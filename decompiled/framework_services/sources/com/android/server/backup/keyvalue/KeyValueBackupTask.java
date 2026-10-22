package com.android.server.backup.keyvalue;

import android.app.IBackupAgent;
import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.IBackupCallback;
import android.app.backup.IBackupManagerMonitor;
import android.app.backup.IBackupObserver;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.ConditionVariable;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SELinux;
import android.os.WorkSource;
import android.util.Log;
import com.android.internal.util.Preconditions;
import com.android.server.AppWidgetBackupBridge;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.backup.BackupRestoreTask;
import com.android.server.backup.DataChangedJournal;
import com.android.server.backup.KeyValueBackupJob;
import com.android.server.backup.OperationStorage;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.fullbackup.PerformFullTransportBackupTask;
import com.android.server.backup.internal.OnTaskFinishedListener;
import com.android.server.backup.remote.RemoteCall;
import com.android.server.backup.remote.RemoteCallable;
import com.android.server.backup.remote.RemoteResult;
import com.android.server.backup.transport.BackupTransportClient;
import com.android.server.backup.transport.TransportConnection;
import com.android.server.backup.utils.BackupEligibilityRules;
import com.android.server.backup.utils.BackupManagerMonitorEventSender;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import libcore.io.IoUtils;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: loaded from: classes.dex */
public class KeyValueBackupTask implements BackupRestoreTask, Runnable {
    private static final String BLANK_STATE_FILE_NAME = "blank_state";
    public static final String NEW_STATE_FILE_SUFFIX = ".new";
    static final String NO_DATA_END_SENTINEL = "@end@";
    private static final String PM_PACKAGE = "@pm@";
    public static final String STAGING_FILE_SUFFIX = ".data";
    private static final String SUCCESS_STATE_SUBDIR = "backing-up";
    private static final String TAG = "KVBT";
    private static final AtomicInteger THREAD_COUNT = null;
    private static final int THREAD_PRIORITY = 10;
    private IBackupAgent mAgent;
    private final BackupAgentTimeoutParameters mAgentTimeoutParameters;
    private ParcelFileDescriptor mBackupData;
    private File mBackupDataFile;
    private final BackupEligibilityRules mBackupEligibilityRules;
    private final UserBackupManagerService mBackupManagerService;
    private final File mBlankStateFile;
    private final ConditionVariable mCancelAcknowledged;
    private volatile boolean mCancelled;
    private final int mCurrentOpToken;
    private PackageInfo mCurrentPackage;
    private final File mDataDirectory;
    private PerformFullTransportBackupTask mFullBackupTask;
    private boolean mHasDataToBackup;
    private final DataChangedJournal mJournal;
    private ParcelFileDescriptor mNewState;
    private File mNewStateFile;
    private boolean mNonIncremental;
    private final OperationStorage mOperationStorage;
    private final List<String> mOriginalQueue;
    private final PackageManager mPackageManager;
    private volatile RemoteCall mPendingCall;
    private final List<String> mPendingFullBackups;
    private final List<String> mQueue;
    private final Object mQueueLock;
    private final KeyValueBackupReporter mReporter;
    private ParcelFileDescriptor mSavedState;
    private File mSavedStateFile;
    private final File mStateDirectory;
    private final OnTaskFinishedListener mTaskFinishedListener;
    private final TransportConnection mTransportConnection;
    private final int mUserId;
    private final boolean mUserInitiated;

    @Retention(RetentionPolicy.SOURCE)
    private @interface StateTransaction {
        public static final int COMMIT_NEW = 0;
        public static final int DISCARD_ALL = 2;
        public static final int DISCARD_NEW = 1;
    }

    /* JADX INFO: renamed from: $r8$lambda$HlOnrtndPiz-6Ppg2cGxgaeHfJ0, reason: not valid java name */
    public static /* synthetic */ void m2531$r8$lambda$HlOnrtndPiz6Ppg2cGxgaeHfJ0(IBackupAgent r0, long r1, long r3, IBackupCallback r5) {
        lambda$agentDoQuotaExceeded$1(r0, r1, r3, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$oFR3nE7py0s4M-mHvfz7rZmKkGI, reason: not valid java name */
    public static /* synthetic */ void m2532$r8$lambda$oFR3nE7py0s4MmHvfz7rZmKkGI(KeyValueBackupTask r0, IBackupAgent r1, long r2, int r4, IBackupCallback r5) {
        r0.lambda$extractAgentData$0(r1, r2, r4, r5);
    }

    static {
        THREAD_COUNT = new AtomicInteger();
    }

    public static KeyValueBackupTask start(UserBackupManagerService backupManagerService, OperationStorage operationStorage, TransportConnection transportConnection, String transportDirName, List<String> queue, DataChangedJournal dataChangedJournal, IBackupObserver observer, IBackupManagerMonitor monitor, OnTaskFinishedListener listener, List<String> pendingFullBackups, boolean userInitiated, boolean nonIncremental, BackupEligibilityRules backupEligibilityRules) {
        KeyValueBackupReporter reporter = new KeyValueBackupReporter(backupManagerService, observer, new BackupManagerMonitorEventSender(monitor));
        KeyValueBackupTask task = new KeyValueBackupTask(backupManagerService, operationStorage, transportConnection, transportDirName, queue, dataChangedJournal, reporter, listener, pendingFullBackups, userInitiated, nonIncremental, backupEligibilityRules);
        Thread thread = new Thread(task, "key-value-backup-" + THREAD_COUNT.incrementAndGet());
        thread.start();
        KeyValueBackupReporter.onNewThread(thread.getName());
        return task;
    }

    public KeyValueBackupTask(UserBackupManagerService backupManagerService, OperationStorage operationStorage, TransportConnection transportConnection, String transportDirName, List<String> queue, DataChangedJournal journal, KeyValueBackupReporter reporter, OnTaskFinishedListener taskFinishedListener, List<String> pendingFullBackups, boolean userInitiated, boolean nonIncremental, BackupEligibilityRules backupEligibilityRules) {
        this.mCancelAcknowledged = new ConditionVariable(false);
        this.mCancelled = false;
        this.mBackupManagerService = backupManagerService;
        this.mOperationStorage = operationStorage;
        this.mPackageManager = backupManagerService.getPackageManager();
        this.mTransportConnection = transportConnection;
        this.mOriginalQueue = queue;
        this.mQueue = new ArrayList(queue);
        this.mJournal = journal;
        this.mReporter = reporter;
        this.mTaskFinishedListener = taskFinishedListener;
        this.mPendingFullBackups = pendingFullBackups;
        this.mUserInitiated = userInitiated;
        this.mNonIncremental = nonIncremental;
        BackupAgentTimeoutParameters r0 = backupManagerService.getAgentTimeoutParameters();
        r0.getClass();
        this.mAgentTimeoutParameters = r0;
        this.mStateDirectory = new File(backupManagerService.getBaseStateDir(), transportDirName);
        this.mDataDirectory = this.mBackupManagerService.getDataDir();
        this.mCurrentOpToken = backupManagerService.generateRandomIntegerToken();
        this.mQueueLock = this.mBackupManagerService.getQueueLock();
        this.mBlankStateFile = new File(this.mStateDirectory, BLANK_STATE_FILE_NAME);
        this.mUserId = backupManagerService.getUserId();
        this.mBackupEligibilityRules = backupEligibilityRules;
    }

    private void registerTask() {
        this.mOperationStorage.registerOperation(this.mCurrentOpToken, 0, this, 2);
    }

    private void unregisterTask() {
        this.mOperationStorage.removeOperation(this.mCurrentOpToken);
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.mHasDataToBackup = false;
        Set<String> backedUpApps = new HashSet();
        int status = 0;
        startTask();     // Catch: TaskException -> L12
    L5:
        if (this.mQueue.isEmpty() == true) goto L24;
        if (this.mCancelled == true) goto L24;
        String packageName = this.mQueue.remove(0);     // Catch: TaskException -> L12
        if ("@pm@".equals(packageName) == false) goto L16;
        backupPm();     // Catch: TaskException -> L12 AgentException -> L14
    L17:
        setSuccessState(packageName, true);     // Catch: TaskException -> L12 AgentException -> L14
        backedUpApps.add(packageName);     // Catch: TaskException -> L12 AgentException -> L14
        goto L5
    L16:
        backupPackage(packageName);     // Catch: TaskException -> L12 AgentException -> L14
        goto L17
    L14:
        e = move-exception;
        setSuccessState(packageName, false);     // Catch: TaskException -> L12
        if (e.isTransitory() == false) goto L5;
        this.mBackupManagerService.dataChangedImpl(packageName);     // Catch: TaskException -> L12
    L24:
        informTransportOfUnchangedApps(backedUpApps);     // Catch: TaskException -> L12
    L30:
        finishTask(status);
        return;
    L12:
        e = move-exception;
        if (e.isStateCompromised() == false) goto L29;
        this.mBackupManagerService.resetBackupState(this.mStateDirectory);
    L29:
        revertTask();
        status = e.getStatus();
        goto L30
    }

    private void informTransportOfUnchangedApps(Set<String> appsBackedUp) {
        String[] succeedingPackages = getSucceedingPackages();
        if (succeedingPackages != null) goto L5;
        return;
    L5:
        int flags = 8;
        if (this.mUserInitiated == false) goto L8;
        flags = 8 | 1;
    L8:
        boolean noDataPackageEncountered = false;
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("KVBT.informTransportOfEmptyBackups()");     // Catch: Throwable -> L15
        int r5 = succeedingPackages.length;     // Catch: Throwable -> L15
        int r7 = 0;
    L10:
        if (r7 >= r5) goto L27;
        String packageName = succeedingPackages[r7];     // Catch: Throwable -> L15
        if (appsBackedUp.contains(packageName) == false) goto L34;
        Log.v(TAG, "Skipping package which was backed up this time: " + packageName);     // Catch: Throwable -> L15
    L26:
        r7 = r7 + 1;     // Catch: Throwable -> L15 Throwable -> L15
        goto L10
    L34:
        PackageInfo packageInfo = this.mPackageManager.getPackageInfo(packageName, 0);     // Catch: Throwable -> L15 Throwable -> L15 PackageManager.NameNotFoundException -> L21
        if (isEligibleForNoDataCall(packageInfo) == true) goto L24;
        clearStatus(packageName);     // Catch: Throwable -> L15 Throwable -> L15 PackageManager.NameNotFoundException -> L21
    L24:
        sendNoDataChangedTo(transport, packageInfo, flags);     // Catch: Throwable -> L15 Throwable -> L15
        noDataPackageEncountered = true;
    L25:
        clearStatus(packageName);     // Catch: Throwable -> L15 Throwable -> L15
        goto L26
    L27:
        if (noDataPackageEncountered == false) goto L42;
        PackageInfo endSentinal = new PackageInfo();     // Catch: Throwable -> L15 Throwable -> L15
        endSentinal.packageName = NO_DATA_END_SENTINEL;     // Catch: Throwable -> L15 Throwable -> L15
        sendNoDataChangedTo(transport, endSentinal, flags);     // Catch: Throwable -> L15 Throwable -> L15
        return;
    L42:
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "Could not inform transport of all unchanged apps", e);
    }

    private boolean isEligibleForNoDataCall(PackageInfo packageInfo) {
        if (this.mBackupEligibilityRules.appIsKeyValueOnly(packageInfo) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mBackupEligibilityRules.appIsRunningAndEligibleForBackupWithTransport(this.mTransportConnection, packageInfo.packageName) == false) goto L7;
        return true;
    }

    private void sendNoDataChangedTo(BackupTransportClient transport, PackageInfo packageInfo, int flags) throws RemoteException {
        ParcelFileDescriptor pfd = ParcelFileDescriptor.open(this.mBlankStateFile, AudioFormat.MP2);     // Catch: FileNotFoundException -> L19
        int result = transport.performBackup(packageInfo, pfd, flags);     // Catch: Throwable -> L12
        if (result == (-1000)) goto L14;
        if (result == (-1001)) goto L14;
        transport.finishBackup();     // Catch: Throwable -> L12
        IoUtils.closeQuietly(pfd);
        return;
    L14:
        Log.w(TAG, "Aborting informing transport of unchanged apps, transport errored");     // Catch: Throwable -> L12
        IoUtils.closeQuietly(pfd);
        return;
    L12:
        th = move-exception;
        IoUtils.closeQuietly(pfd);
        throw th;
    L20:
        Log.e(TAG, "Unable to find blank state file, aborting unchanged apps signal.");
    }

    private String[] getSucceedingPackages() {
        File stateDirectory = getTopLevelSuccessStateDirectory(false);
        if (stateDirectory != null) goto L7;
        return null;
    L7:
        return stateDirectory.list();
    }

    private void setSuccessState(String packageName, boolean success) {
        File successStateFile = getSuccessStateFileFor(packageName);
        if (successStateFile != null) goto L6;
        return;
    L6:
        if (successStateFile.exists() == success) goto L21;
        if (success == true) goto L19;
        clearStatus(packageName, successStateFile);
        return;
    L19:
    L14:
        e = move-exception;
        Log.w(TAG, "Unable to permanently record success for " + packageName, e);
        return;
    L11:
        if (successStateFile.createNewFile() == true) goto L22;
        Log.w(TAG, "Unable to permanently record success for " + packageName);     // Catch: IOException -> L14
        return;
    L22:
        return;
    }

    private void clearStatus(String packageName) {
        File successStateFile = getSuccessStateFileFor(packageName);
        if (successStateFile != null) goto L5;
        return;
    L5:
        clearStatus(packageName, successStateFile);
    }

    private void clearStatus(String packageName, File successStateFile) {
        if (successStateFile.exists() == true) goto L5;
        return;
    L5:
        if (successStateFile.delete() == true) goto L9;
        Log.w(TAG, "Unable to remove status file for " + packageName);
        return;
    }

    private File getSuccessStateFileFor(String packageName) {
        File stateDirectory = getTopLevelSuccessStateDirectory(true);
        if (stateDirectory != null) goto L6;
        return null;
    L6:
        return new File(stateDirectory, packageName);
    }

    private File getTopLevelSuccessStateDirectory(boolean createIfMissing) {
        File directory = new File(this.mStateDirectory, SUCCESS_STATE_SUBDIR);
        if (directory.exists() == true) goto L9;
        if (createIfMissing == false) goto L9;
        if (directory.mkdirs() == true) goto L9;
        Log.e(TAG, "Unable to create backing-up state directory");
        return null;
    L9:
        return directory;
    }

    private int sendDataToTransport(PackageInfo packageInfo) throws AgentException, TaskException {
        return sendDataToTransport();
    L4:
        e = move-exception;
        this.mReporter.onAgentDataError(packageInfo.packageName, e);
        throw TaskException.causedBy(e);
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void execute() {
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void operationComplete(long unusedResult) {
    }

    private void startTask() throws TaskException {
        if (this.mBackupManagerService.isBackupOperationInProgress() == true) goto L41;
        this.mFullBackupTask = createFullBackupTask(this.mPendingFullBackups);
        registerTask();
        if (this.mQueue.isEmpty() == false) goto L11;
        if (this.mPendingFullBackups.isEmpty() == false) goto L11;
        this.mReporter.onEmptyQueueAtStart();
        return;
    L11:
        if (this.mQueue.remove("@pm@") == false) goto L13;
    L16:
        boolean backupPm = true;
    L17:
        if (backupPm == false) goto L19;
        this.mQueue.add(0, "@pm@");
    L20:
        this.mReporter.onQueueReady(this.mQueue);
        File pmState = new File(this.mStateDirectory, "@pm@");
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("KVBT.startTask()");     // Catch: Exception -> L24 TaskException -> L26
        String transportName = transport.name();     // Catch: Exception -> L24 TaskException -> L26
        if (transportName.contains("EncryptedLocalTransport") == false) goto L28;
        this.mNonIncremental = true;     // Catch: Exception -> L24 TaskException -> L26
    L28:
        this.mReporter.onTransportReady(transportName);     // Catch: Exception -> L24 TaskException -> L26
        if (pmState.length() > 0) goto L36;
        this.mReporter.onInitializeTransport(transportName);     // Catch: Exception -> L24 TaskException -> L26
        this.mBackupManagerService.resetBackupState(this.mStateDirectory);     // Catch: Exception -> L24 TaskException -> L26
        int status = transport.initializeDevice();     // Catch: Exception -> L24 TaskException -> L26
        this.mReporter.onTransportInitialized(status);     // Catch: Exception -> L24 TaskException -> L26
        if (status != 0) goto L34;
        return;
    L34:
        throw TaskException.stateCompromised();     // Catch: Exception -> L24 TaskException -> L26
    L36:
        return;
    L26:
        e = move-exception;
        throw e;
    L24:
        e = move-exception;
        this.mReporter.onInitializeTransportError(e);
        throw TaskException.stateCompromised();
    L19:
        this.mReporter.onSkipPm();
        goto L20
    L13:
        if (this.mNonIncremental == false) goto L16;
        backupPm = false;
        goto L17
    L41:
        this.mReporter.onSkipBackup();
        throw TaskException.create();
    }

    private PerformFullTransportBackupTask createFullBackupTask(List<String> packages) {
        return new PerformFullTransportBackupTask(this.mBackupManagerService, this.mOperationStorage, this.mTransportConnection, null, (String[]) packages.toArray(new String[packages.size()]), false, null, new CountDownLatch(1), this.mReporter.getObserver(), this.mReporter.getMonitor(), this.mTaskFinishedListener, this.mUserInitiated, this.mBackupEligibilityRules);
    }

    private void backupPm() throws TaskException {
        this.mReporter.onStartPackageBackup("@pm@");
        this.mCurrentPackage = new PackageInfo();
        this.mCurrentPackage.packageName = "@pm@";
        extractPmAgentData(this.mCurrentPackage);     // Catch: Throwable -> L6 TaskException -> L8
        int status = sendDataToTransport(this.mCurrentPackage);     // Catch: Throwable -> L6
        cleanUpAgentForTransportStatus(status);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        throw TaskException.stateCompromised(e);     // Catch: Throwable -> L6
    L6:
        e = move-exception;
        this.mReporter.onExtractPmAgentDataError(e);
        cleanUpAgentForError(e);
        if ((e instanceof TaskException) == false) goto L16;
        throw ((TaskException) e);
    L16:
        throw TaskException.stateCompromised(e);
    }

    private void backupPackage(String packageName) throws AgentException, TaskException {
        this.mReporter.onStartPackageBackup(packageName);
        this.mCurrentPackage = getPackageForBackup(packageName);
        extractAgentData(this.mCurrentPackage);     // Catch: Throwable -> L5
        BackupManagerMonitorEventSender mBackupManagerMonitorEventSender = new BackupManagerMonitorEventSender(this.mReporter.getMonitor());     // Catch: Throwable -> L5
        mBackupManagerMonitorEventSender.monitorAgentLoggingResults(this.mCurrentPackage, this.mAgent);     // Catch: Throwable -> L5
        int status = sendDataToTransport(this.mCurrentPackage);     // Catch: Throwable -> L5
        cleanUpAgentForTransportStatus(status);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        cleanUpAgentForError(e);
        throw e;
    }

    private PackageInfo getPackageForBackup(String packageName) throws AgentException {
        PackageInfo packageInfo = this.mPackageManager.getPackageInfoAsUser(packageName, 134217728, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L16
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (this.mBackupEligibilityRules.appIsEligibleForBackup(applicationInfo) == true) goto L6;
        this.mReporter.onPackageNotEligibleForBackup(packageName);
        throw AgentException.permanent();
    L6:
        if (this.mBackupEligibilityRules.appGetsFullBackup(packageInfo) == false) goto L8;
        this.mReporter.onPackageEligibleForFullBackup(packageName);
        throw AgentException.permanent();
    L8:
        if (this.mBackupEligibilityRules.appIsStopped(applicationInfo) == true) goto L10;
        return packageInfo;
    L10:
        this.mReporter.onPackageStopped(packageName);
        throw AgentException.permanent();
    L16:
        e = move-exception;
        this.mReporter.onAgentUnknown(packageName);
        throw AgentException.permanent(e);
    }

    private IBackupAgent bindAgent(PackageInfo packageInfo) throws AgentException {
        String packageName = packageInfo.packageName;
        IBackupAgent agent = this.mBackupManagerService.getBackupAgentConnectionManager().bindToAgentSynchronous(packageInfo.applicationInfo, 0, this.mBackupEligibilityRules.getBackupDestination());     // Catch: SecurityException -> L8
        if (agent == null) goto L6;
        return agent;
    L6:
        this.mReporter.onAgentError(packageName);     // Catch: SecurityException -> L8
        throw AgentException.transitory();     // Catch: SecurityException -> L8
    L8:
        e = move-exception;
        this.mReporter.onBindAgentError(packageName, e);
        throw AgentException.transitory(e);
    }

    private void finishTask(int status) {
        Iterator<String> r0 = this.mQueue.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        String packageName = r0.next();
        this.mBackupManagerService.dataChangedImpl(packageName);
        goto L4
    L7:
        if (this.mJournal != null) goto L9;
    L11:
        String transportName = null;
        long currentToken = this.mBackupManagerService.getCurrentToken();
        if (this.mHasDataToBackup == false) goto L20;
        if (status != 0) goto L20;
        if (currentToken != 0) goto L20;
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("KVBT.finishTask()");     // Catch: Exception -> L18
        transportName = transport.name();     // Catch: Exception -> L18
        this.mBackupManagerService.setCurrentToken(transport.getCurrentRestoreSet());     // Catch: Exception -> L18
        this.mBackupManagerService.writeRestoreTokens();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        this.mReporter.onSetCurrentTokenError(e);
    L20:
        Object r4 = this.mQueueLock;
        monitor-enter(r4);
        this.mBackupManagerService.setBackupRunning(false);     // Catch: Throwable -> L27
        if (status != (-1001)) goto L31;
        this.mReporter.onTransportNotInitialized(transportName);     // Catch: Throwable -> L27
        triggerTransportInitializationLocked();     // Catch: Throwable -> L27 Exception -> L29
    L29:
        e = move-exception;
        this.mReporter.onPendingInitializeTransportError(e);     // Catch: Throwable -> L27
        status = -1000;
    L31:
        monitor-exit(r4);     // Catch: Throwable -> L27
        unregisterTask();
        this.mReporter.onTaskFinished();
        if (this.mCancelled == false) goto L36;
        this.mCancelAcknowledged.open();
    L36:
        if (this.mCancelled == true) goto L45;
        if (status != 0) goto L45;
        if (this.mFullBackupTask == null) goto L45;
        if (this.mPendingFullBackups.isEmpty() == true) goto L45;
        this.mReporter.onStartFullBackup(this.mPendingFullBackups);
        new Thread(this.mFullBackupTask, "full-transport-requested").start();
        return;
    L45:
        if (this.mFullBackupTask == null) goto L47;
        this.mFullBackupTask.unregisterTask();
    L47:
        this.mTaskFinishedListener.onFinished("KVBT.finishTask()");
        this.mReporter.onBackupFinished(getBackupFinishedStatus(this.mCancelled, status));
        this.mBackupManagerService.getWakeLock().release();
        return;
    L27:
        th = move-exception;
        throw th;
    L9:
        if (this.mJournal.delete() == true) goto L11;
        this.mReporter.onJournalDeleteFailed(this.mJournal);
        goto L11
    }

    private int getBackupFinishedStatus(boolean cancelled, int transportStatus) {
        if (cancelled == false) goto L5;
        return -2003;
    L5:
        switch(transportStatus) {
            case -1005: goto L8;
            case -1002: goto L8;
            case 0: goto L8;
            default: goto L6;
        };
    L6:
        return -1000;
    L8:
        return 0;
    }

    private void triggerTransportInitializationLocked() throws Exception {
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("KVBT.triggerTransportInitializationLocked");
        this.mBackupManagerService.getPendingInits().add(transport.name());
        deletePmStateFile();
        this.mBackupManagerService.backupNow();
    }

    private void deletePmStateFile() {
        new File(this.mStateDirectory, "@pm@").delete();
    }

    private void extractPmAgentData(PackageInfo packageInfo) throws AgentException, TaskException {
        Preconditions.checkArgument(packageInfo.packageName.equals("@pm@"));
        BackupAgent pmAgent = this.mBackupManagerService.makeMetadataAgentWithEligibilityRules(this.mBackupEligibilityRules);
        this.mAgent = IBackupAgent.Stub.asInterface(pmAgent.onBind());
        extractAgentData(packageInfo, this.mAgent);
    }

    private void extractAgentData(PackageInfo packageInfo) throws AgentException, TaskException {
        this.mBackupManagerService.getWakeLock().setWorkSource(new WorkSource(packageInfo.applicationInfo.uid));
        this.mAgent = bindAgent(packageInfo);     // Catch: Throwable -> L6
        extractAgentData(packageInfo, this.mAgent);     // Catch: Throwable -> L6
        this.mBackupManagerService.getWakeLock().setWorkSource(null);
        return;
    L6:
        th = move-exception;
        this.mBackupManagerService.getWakeLock().setWorkSource(null);
        throw th;
    }

    private void extractAgentData(PackageInfo packageInfo, final IBackupAgent agent) throws AgentException, TaskException {
        String packageName = packageInfo.packageName;
        this.mReporter.onExtractAgentData(packageName);
        this.mSavedStateFile = new File(this.mStateDirectory, packageName);
        this.mBackupDataFile = new File(this.mDataDirectory, packageName + STAGING_FILE_SUFFIX);
        this.mNewStateFile = new File(this.mStateDirectory, packageName + NEW_STATE_FILE_SUFFIX);
        this.mReporter.onAgentFilesReady(this.mBackupDataFile);
        boolean callingAgent = false;
    L22:
        e = e;
        final KeyValueBackupTask r7 = this;
    L24:
        r7.mReporter.onCallAgentDoBackupError(packageName, callingAgent, e);
        if (callingAgent == false) goto L29;
        throw AgentException.transitory(e);
    L29:
        throw TaskException.create();
    L4:
        if (this.mNonIncremental == true) goto L34;
        File savedStateFileForAgent = this.mSavedStateFile;     // Catch: Exception -> L22
    L10:
        this.mSavedState = ParcelFileDescriptor.open(savedStateFileForAgent, AudioFormat.MP2);     // Catch: Exception -> L22
        this.mBackupData = ParcelFileDescriptor.open(this.mBackupDataFile, 1006632960);     // Catch: Exception -> L22
        this.mNewState = ParcelFileDescriptor.open(this.mNewStateFile, 1006632960);     // Catch: Exception -> L22
        if (this.mUserId == 0) goto L13;
    L15:
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("KVBT.extractAgentData()");     // Catch: Exception -> L22
        final long quota = transport.getBackupQuota(packageName, false);     // Catch: Exception -> L22
        final int transportFlags = transport.getTransportFlags();     // Catch: Exception -> L22
        callingAgent = true;
        r7 = this;
        RemoteResult agentResult = remoteCall(new KeyValueBackupTask$$ExternalSyntheticLambda1(r7, agent, quota, transportFlags), r7.mAgentTimeoutParameters.getKvBackupAgentTimeoutMillis(), "doBackup()");     // Catch: Exception -> L20
        checkAgentResult(packageInfo, agentResult);
        return;
    L20:
        e = e;
        goto L24
    L13:
        if (SELinux.restorecon(this.mBackupDataFile) == true) goto L15;
        this.mReporter.onRestoreconFailed(this.mBackupDataFile);     // Catch: Exception -> L7
    L7:
        e = e;
        r7 = this;
        goto L24
    L34:
        savedStateFileForAgent = this.mBlankStateFile;     // Catch: Exception -> L7
        goto L10
    }

    private /* synthetic */ void lambda$extractAgentData$0(IBackupAgent agent, long quota, int transportFlags, IBackupCallback callback) throws RemoteException {
        agent.doBackup(this.mSavedState, this.mBackupData, this.mNewState, quota, callback, transportFlags);
    }

    private void checkAgentResult(PackageInfo packageInfo, RemoteResult result) throws AgentException, TaskException {
        boolean r1 = true;
        if (result != RemoteResult.FAILED_THREAD_INTERRUPTED) goto L5;
        this.mCancelled = true;
        this.mReporter.onAgentCancelled(packageInfo);
        throw TaskException.create();
    L5:
        if (result != RemoteResult.FAILED_CANCELLED) goto L7;
        this.mReporter.onAgentCancelled(packageInfo);
        throw TaskException.create();
    L7:
        if (result == RemoteResult.FAILED_TIMED_OUT) goto L18;
        Preconditions.checkState(result.isPresent());
        long resultCode = result.get();
        if (resultCode != (-1)) goto L11;
        this.mReporter.onAgentResultError(packageInfo);
        throw AgentException.transitory();
    L11:
        if (resultCode == 0) goto L14;
        r1 = false;
    L14:
        Preconditions.checkState(r1);
        return;
    L18:
        this.mReporter.onAgentTimedOut(packageInfo);
        throw AgentException.transitory();
    }

    private void agentFail(IBackupAgent agent, String message) {
        agent.fail(message);     // Catch: Exception -> L4
        return;
    L5:
        this.mReporter.onFailAgentError(this.mCurrentPackage.packageName);
    }

    private String SHA1Checksum(byte[] input) {
        MessageDigest md = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L8
        byte[] checksum = md.digest(input);     // Catch: NoSuchAlgorithmException -> L8
        StringBuilder string = new StringBuilder(checksum.length * 2);
        int r2 = checksum.length;
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L7;
        byte item = checksum[r3];
        string.append(Integer.toHexString(item));
        r3 = r3 + 1;
        goto L4
    L7:
        return string.toString();
    L8:
        e = move-exception;
        this.mReporter.onDigestError(e);
        return TarConstants.VERSION_POSIX;
    }

    private void writeWidgetPayloadIfAppropriate(FileDescriptor fd, String pkgName) throws IOException {
        byte[] widgetState = AppWidgetBackupBridge.getWidgetState(pkgName, this.mUserId);
        File widgetFile = new File(this.mStateDirectory, pkgName + "_widget");
        boolean priorStateExists = widgetFile.exists();
        if (priorStateExists == true) goto L6;
        if (widgetState != null) goto L6;
        return;
    L6:
        this.mReporter.onWriteWidgetData(priorStateExists, widgetState);
        String newChecksum = null;
        if (widgetState == null) goto L30;
        newChecksum = SHA1Checksum(widgetState);
        if (priorStateExists == false) goto L30;
        FileInputStream fin = new FileInputStream(widgetFile);
        DataInputStream in = new DataInputStream(fin);     // Catch: Throwable -> L17
        String priorChecksum = in.readUTF();     // Catch: Throwable -> L19
        in.close();     // Catch: Throwable -> L17
        fin.close();
        if (Objects.equals(newChecksum, priorChecksum) == false) goto L30;
        return;
    L19:
        th = move-exception;
        in.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L17
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        fin.close();     // Catch: Throwable -> L27
    L29:
        throw th;
    L27:
        th = move-exception;
        th.addSuppressed(th);
    L30:
        BackupDataOutput out = new BackupDataOutput(fd);
        if (widgetState == null) goto L50;
        FileOutputStream fout = new FileOutputStream(widgetFile);
        DataOutputStream stateOut = new DataOutputStream(fout);     // Catch: Throwable -> L37
        stateOut.writeUTF(newChecksum);     // Catch: Throwable -> L39
        stateOut.close();     // Catch: Throwable -> L37
        fout.close();
        out.writeEntityHeader(UserBackupManagerService.KEY_WIDGET_STATE, widgetState.length);
        out.writeEntityData(widgetState, widgetState.length);
        return;
    L39:
        th = move-exception;
        stateOut.close();     // Catch: Throwable -> L42
    L44:
        throw th;     // Catch: Throwable -> L37
    L42:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        fout.close();     // Catch: Throwable -> L47
    L49:
        throw th;
    L47:
        th = move-exception;
        th.addSuppressed(th);
        goto L49
    L50:
        out.writeEntityHeader(UserBackupManagerService.KEY_WIDGET_STATE, -1);
        widgetFile.delete();
    }

    private int sendDataToTransport() throws AgentException, TaskException, IOException {
        boolean nonIncremental = false;
        if (this.mBackupData == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        checkBackupData(this.mCurrentPackage.applicationInfo, this.mBackupDataFile);
        String packageName = this.mCurrentPackage.packageName;
        writeWidgetPayloadIfAppropriate(this.mBackupData.getFileDescriptor(), packageName);
        if (this.mSavedStateFile.length() != 0) goto L9;
        nonIncremental = true;
    L9:
        int status = transportPerformBackup(this.mCurrentPackage, this.mBackupDataFile, nonIncremental);
        handleTransportStatus(status, packageName, this.mBackupDataFile.length());
        return status;
    L5:
        r0 = false;
        goto L6
    }

    private int transportPerformBackup(PackageInfo packageInfo, File backupDataFile, boolean nonIncremental) throws TaskException {
        String packageName = packageInfo.packageName;
        long size = backupDataFile.length();
        if (size > 0) goto L6;
        this.mReporter.onEmptyData(packageInfo);
        return 0;
    L6:
        this.mHasDataToBackup = true;
        ParcelFileDescriptor backupData = ParcelFileDescriptor.open(backupDataFile, 268435456);     // Catch: Exception -> L19
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("KVBT.transportPerformBackup()");     // Catch: Throwable -> L11
        this.mReporter.onTransportPerformBackup(packageName);     // Catch: Throwable -> L11
        int flags = getPerformBackupFlags(this.mUserInitiated, nonIncremental);     // Catch: Throwable -> L11
        int status = transport.performBackup(packageInfo, backupData, flags);     // Catch: Throwable -> L11
        if (status != 0) goto L14;
        status = transport.finishBackup();     // Catch: Throwable -> L11
    L16:
        if (backupData == null) goto L22;
        backupData.close();     // Catch: Exception -> L19
    L22:
        if (nonIncremental == true) goto L24;
    L28:
        return status;
    L24:
        if (status != (-1006)) goto L28;
        this.mReporter.onPackageBackupNonIncrementalAndNonIncrementalRequired(packageName);
        throw TaskException.create();
    L14:
        if (status != (-1001)) goto L16;
        this.mReporter.onTransportNotInitialized(transport.name());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (backupData != null) goto L38;
    L35:
        throw th;     // Catch: Exception -> L19
    L38:
        backupData.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        this.mReporter.onPackageBackupTransportError(packageName, e);
        throw TaskException.causedBy(e);
    }

    private void handleTransportStatus(int status, String packageName, long size) throws TaskException, AgentException {
        if (status != 0) goto L6;
        this.mReporter.onPackageBackupComplete(packageName, size);
        return;
    L6:
        if (status != (-1006)) goto L10;
        this.mReporter.onPackageBackupNonIncrementalRequired(this.mCurrentPackage);
        this.mQueue.add(0, packageName);
        return;
    L10:
        if (status != (-1002)) goto L12;
        this.mReporter.onPackageBackupRejected(packageName);
        throw AgentException.permanent();
    L12:
        if (status != (-1005)) goto L15;
        this.mReporter.onPackageBackupQuotaExceeded(packageName);
        agentDoQuotaExceeded(this.mAgent, packageName, size);
        throw AgentException.permanent();
    L15:
        this.mReporter.onPackageBackupTransportFailure(packageName);
        throw TaskException.forStatus(status);
    }

    private void agentDoQuotaExceeded(final IBackupAgent agent, String packageName, final long size) {
        if (agent == null) goto L13;
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("KVBT.agentDoQuotaExceeded()");     // Catch: Exception -> L9
        final long quota = transport.getBackupQuota(packageName, false);     // Catch: Exception -> L9
        remoteCall(new KeyValueBackupTask$$ExternalSyntheticLambda0(agent, size, quota), this.mAgentTimeoutParameters.getQuotaExceededTimeoutMillis(), "doQuotaExceeded()");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Exception e = e;
    L11:
        this.mReporter.onAgentDoQuotaExceededError(e);
        return;
    L9:
        e = move-exception;
        e = e;
        goto L11
    }

    private static /* synthetic */ void lambda$agentDoQuotaExceeded$1(IBackupAgent agent, long size, long quota, IBackupCallback callback) throws RemoteException {
        agent.doQuotaExceeded(size, quota, callback);
    }

    private void checkBackupData(ApplicationInfo applicationInfo, File backupDataFile) throws IOException, AgentException {
        if (applicationInfo != null) goto L4;
        return;
    L4:
        if ((applicationInfo.flags & 1) != 0) goto L36;
        ParcelFileDescriptor backupData = ParcelFileDescriptor.open(backupDataFile, 268435456);
        BackupDataInput backupDataInput = new BackupDataInput(backupData.getFileDescriptor());     // Catch: Throwable -> L17
    L9:
        if (backupDataInput.readNextHeader() == false) goto L21;
        String key = backupDataInput.getKey();     // Catch: Throwable -> L17
        if (key == null) goto L19;
        if (key.charAt(0) < 65280) goto L19;
        this.mReporter.onAgentIllegalKey(this.mCurrentPackage, key);     // Catch: Throwable -> L17
        agentFail(this.mAgent, "Illegal backup key: " + key);     // Catch: Throwable -> L17
        throw AgentException.permanent();     // Catch: Throwable -> L17
    L19:
        backupDataInput.skipEntityData();     // Catch: Throwable -> L17
        goto L9
    L21:
        backupData.close();
        return;
    L17:
        th = move-exception;
        if (backupData != null) goto L32;
    L28:
        throw th;
    L32:
        backupData.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);
        goto L28
    }

    private int getPerformBackupFlags(boolean r4, boolean r5) {
        if (r5 == false) goto L5;
        int r1 = 4;
    L7:
        return (r4 ? 1 : 0) | r1;
    L5:
        r1 = 2;
        goto L7
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void handleCancel(int cancellationReason) {
        if (cancellationReason == 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "Key-value backup task cannot time out");
        markCancel();
        waitCancel();
        return;
    L4:
        r0 = false;
        goto L5
    }

    public void markCancel() {
        this.mReporter.onCancel();
        this.mCancelled = true;
        RemoteCall pendingCall = this.mPendingCall;
        if (pendingCall == null) goto L6;
        pendingCall.cancel();
        return;
    }

    public void waitCancel() {
        this.mCancelAcknowledged.block();
    }

    private void revertTask() {
        this.mReporter.onRevertTask();
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("KVBT.revertTask()");     // Catch: Exception -> L5
        long delay = transport.requestBackupTime();     // Catch: Exception -> L5
    L7:
        KeyValueBackupJob.schedule(this.mBackupManagerService.getUserId(), this.mBackupManagerService.getContext(), delay, this.mBackupManagerService);
        Iterator<String> r0 = this.mOriginalQueue.iterator();
    L9:
        if (r0.hasNext() == false) goto L11;
        String packageName = r0.next();
        this.mBackupManagerService.dataChangedImpl(packageName);
        goto L9
    L11:
        return;
    L5:
        e = move-exception;
        this.mReporter.onTransportRequestBackupTimeError(e);
        delay = 0;
        goto L7
    }

    private void cleanUpAgentForError(BackupException exception) {
        cleanUpAgent(1);
    }

    private void cleanUpAgentForTransportStatus(int status) {
        switch(status) {
            case -1006: goto L6;
            case 0: goto L5;
            default: goto L4;
        };
    L5:
        cleanUpAgent(0);
        return;
    L6:
        cleanUpAgent(2);
        return;
    L4:
        throw new AssertionError();
    }

    private void cleanUpAgent(int stateTransaction) {
        applyStateTransaction(stateTransaction);
        if (this.mBackupDataFile == null) goto L5;
        this.mBackupDataFile.delete();
    L5:
        this.mBlankStateFile.delete();
        this.mSavedStateFile = null;
        this.mBackupDataFile = null;
        this.mNewStateFile = null;
        tryCloseFileDescriptor(this.mSavedState, "old state");
        tryCloseFileDescriptor(this.mBackupData, "backup data");
        tryCloseFileDescriptor(this.mNewState, "new state");
        this.mSavedState = null;
        this.mBackupData = null;
        this.mNewState = null;
        if (this.mCurrentPackage.applicationInfo == null) goto L8;
        this.mBackupManagerService.getBackupAgentConnectionManager().unbindAgent(this.mCurrentPackage.applicationInfo, false);
    L8:
        this.mAgent = null;
    }

    private void applyStateTransaction(int stateTransaction) {
        switch(stateTransaction) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        this.mSavedStateFile.delete();
        this.mNewStateFile.delete();
        return;
    L9:
        this.mNewStateFile.renameTo(this.mSavedStateFile);
        return;
    L4:
        throw new IllegalArgumentException("Unknown state transaction " + stateTransaction);
    L7:
        if (this.mNewStateFile == null) goto L12;
        this.mNewStateFile.delete();
        return;
    }

    private void tryCloseFileDescriptor(Closeable closeable, String logName) {
        if (closeable == null) goto L10;
        closeable.close();     // Catch: IOException -> L5
        return;
    L6:
        this.mReporter.onCloseFileDescriptorError(logName);
        return;
    }

    private RemoteResult remoteCall(RemoteCallable<IBackupCallback> remoteCallable, long timeoutMs, String logIdentifier) throws RemoteException {
        this.mPendingCall = new RemoteCall(this.mCancelled, remoteCallable, timeoutMs);
        RemoteResult result = this.mPendingCall.call();
        this.mReporter.onRemoteCallReturned(result, logIdentifier);
        this.mPendingCall = null;
        return result;
    }
}
