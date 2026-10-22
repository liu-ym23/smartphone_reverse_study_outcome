package com.android.server.backup.fullbackup;

import android.app.IBackupAgent;
import android.app.backup.IBackupCallback;
import android.app.backup.IBackupManagerMonitor;
import android.app.backup.IBackupObserver;
import android.app.backup.IFullBackupRestoreObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.backup.BackupRestoreTask;
import com.android.server.backup.FullBackupJob;
import com.android.server.backup.OperationStorage;
import com.android.server.backup.TransportManager;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.internal.OnTaskFinishedListener;
import com.android.server.backup.remote.RemoteCall;
import com.android.server.backup.transport.BackupTransportClient;
import com.android.server.backup.transport.TransportConnection;
import com.android.server.backup.utils.BackupEligibilityRules;
import com.android.server.backup.utils.BackupManagerMonitorEventSender;
import com.android.server.backup.utils.BackupObserverUtils;
import com.google.android.collect.Sets;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class PerformFullTransportBackupTask extends FullBackupTask implements BackupRestoreTask {
    private static final String TAG = "PFTBT";
    private final BackupAgentTimeoutParameters mAgentTimeoutParameters;
    private final BackupEligibilityRules mBackupEligibilityRules;
    private BackupManagerMonitorEventSender mBackupManagerMonitorEventSender;
    IBackupObserver mBackupObserver;
    SinglePackageBackupRunner mBackupRunner;
    private final int mBackupRunnerOpToken;
    private final Object mCancelLock;
    private volatile boolean mCancelled;
    private final int mCurrentOpToken;
    private volatile boolean mIsDoingBackup;
    FullBackupJob mJob;
    CountDownLatch mLatch;
    private final OnTaskFinishedListener mListener;
    OperationStorage mOperationStorage;
    List<PackageInfo> mPackages;
    private final TransportConnection mTransportConnection;
    boolean mUpdateSchedule;
    private UserBackupManagerService mUserBackupManagerService;
    private final int mUserId;
    boolean mUserInitiated;

    class SinglePackageBackupPreflight implements BackupRestoreTask, FullBackupPreflight {
        private final int mCurrentOpToken;
        final CountDownLatch mLatch;
        final long mQuota;
        final AtomicLong mResult;
        final TransportConnection mTransportConnection;
        private final int mTransportFlags;
        final /* synthetic */ PerformFullTransportBackupTask this$0;

        public static /* synthetic */ void $r8$lambda$bUP1Rg5xlkG0v3vCKmb3tJCMZ04(SinglePackageBackupPreflight r0, IBackupAgent r1, long r2, IBackupCallback r4) {
            r0.lambda$preflightFullBackup$0(r1, r2, r4);
        }

        SinglePackageBackupPreflight(PerformFullTransportBackupTask this$0, TransportConnection transportConnection, long quota, int currentOpToken, int transportFlags) {
            this.this$0 = this$0;
            this.mResult = new AtomicLong(-1003);
            this.mLatch = new CountDownLatch(1);
            this.mTransportConnection = transportConnection;
            this.mQuota = quota;
            this.mCurrentOpToken = currentOpToken;
            this.mTransportFlags = transportFlags;
        }

        @Override // com.android.server.backup.fullbackup.FullBackupPreflight
        public int preflightFullBackup(PackageInfo pkg, final IBackupAgent agent) {
            long fullBackupAgentTimeoutMillis = PerformFullTransportBackupTask.m2526$$Nest$fgetmAgentTimeoutParameters(this.this$0).getFullBackupAgentTimeoutMillis();
            PerformFullTransportBackupTask.m2529$$Nest$fgetmUserBackupManagerService(this.this$0).prepareOperationTimeout(this.mCurrentOpToken, fullBackupAgentTimeoutMillis, this, 0);     // Catch: Exception -> L18
            agent.doMeasureFullBackup(this.mQuota, this.mCurrentOpToken, PerformFullTransportBackupTask.m2529$$Nest$fgetmUserBackupManagerService(this.this$0).getBackupManagerBinder(), this.mTransportFlags);     // Catch: Exception -> L15
            this.mLatch.await(fullBackupAgentTimeoutMillis, TimeUnit.MILLISECONDS);     // Catch: Exception -> L15
            final long totalSize = this.mResult.get();     // Catch: Exception -> L15
            if (totalSize < 0) goto L10;
            BackupTransportClient transport = this.mTransportConnection.connectOrThrow("PFTBT$SPBP.preflightFullBackup()");     // Catch: Exception -> L15
            int result = transport.checkFullBackupSize(totalSize);     // Catch: Exception -> L15
            if (result != (-1005)) goto L29;
            RemoteCall.execute(new PerformFullTransportBackupTask$SinglePackageBackupPreflight$$ExternalSyntheticLambda0(this, agent, totalSize), PerformFullTransportBackupTask.m2526$$Nest$fgetmAgentTimeoutParameters(this.this$0).getQuotaExceededTimeoutMillis());     // Catch: Exception -> L15
            return result;
        L29:
            return result;
        L10:
            return (int) totalSize;
        L15:
            e = move-exception;
            Exception e = e;
        L22:
            Slog.w(PerformFullTransportBackupTask.TAG, "Exception preflighting " + pkg.packageName + ": " + e.getMessage());
            return -1003;
        L18:
            e = e;
        L19:
            e = e;
        L20:
            e = e;
            goto L19
        }

        private /* synthetic */ void lambda$preflightFullBackup$0(IBackupAgent agent, long totalSize, IBackupCallback callback) throws RemoteException {
            agent.doQuotaExceeded(totalSize, this.mQuota, callback);
        }

        @Override // com.android.server.backup.BackupRestoreTask
        public void execute() {
        }

        @Override // com.android.server.backup.BackupRestoreTask
        public void operationComplete(long result) {
            this.mResult.set(result);
            this.mLatch.countDown();
            this.this$0.mOperationStorage.removeOperation(this.mCurrentOpToken);
        }

        @Override // com.android.server.backup.BackupRestoreTask
        public void handleCancel(int cancellationReason) {
            this.mResult.set(-1003);
            this.mLatch.countDown();
            this.this$0.mOperationStorage.removeOperation(this.mCurrentOpToken);
        }

        @Override // com.android.server.backup.fullbackup.FullBackupPreflight
        public long getExpectedSizeOrErrorCode() {
            long fullBackupAgentTimeoutMillis = PerformFullTransportBackupTask.m2526$$Nest$fgetmAgentTimeoutParameters(this.this$0).getFullBackupAgentTimeoutMillis();
            this.mLatch.await(fullBackupAgentTimeoutMillis, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L5
            return this.mResult.get();
        L6:
            return -1;
        }
    }

    class SinglePackageBackupRunner implements Runnable, BackupRestoreTask {
        final CountDownLatch mBackupLatch;
        private volatile int mBackupResult;
        private final int mCurrentOpToken;
        private FullBackupEngine mEngine;
        private final int mEphemeralToken;
        private volatile boolean mIsCancelled;
        final ParcelFileDescriptor mOutput;
        final SinglePackageBackupPreflight mPreflight;
        final CountDownLatch mPreflightLatch;
        private volatile int mPreflightResult;
        private final long mQuota;
        final PackageInfo mTarget;
        private final int mTransportFlags;
        final /* synthetic */ PerformFullTransportBackupTask this$0;

        SinglePackageBackupRunner(PerformFullTransportBackupTask this$0, ParcelFileDescriptor output, PackageInfo target, TransportConnection transportConnection, long quota, int currentOpToken, int transportFlags) throws IOException {
            this.this$0 = this$0;
            this.mOutput = ParcelFileDescriptor.dup(output.getFileDescriptor());
            this.mTarget = target;
            this.mCurrentOpToken = currentOpToken;
            this.mEphemeralToken = PerformFullTransportBackupTask.m2529$$Nest$fgetmUserBackupManagerService(this$0).generateRandomIntegerToken();
            this.mPreflight = new SinglePackageBackupPreflight(this$0, transportConnection, quota, this.mEphemeralToken, transportFlags);
            this.mPreflightLatch = new CountDownLatch(1);
            this.mBackupLatch = new CountDownLatch(1);
            this.mPreflightResult = -1003;
            this.mBackupResult = -1003;
            this.mQuota = quota;
            this.mTransportFlags = transportFlags;
            registerTask(target.packageName);
        }

        void registerTask(String packageName) {
            Set<String> packages = Sets.newHashSet(new String[]{packageName});
            this.this$0.mOperationStorage.registerOperationForPackages(this.mCurrentOpToken, 0, packages, this, 0);
        }

        void unregisterTask() {
            this.this$0.mOperationStorage.removeOperation(this.mCurrentOpToken);
        }

        @Override // java.lang.Runnable
        public void run() {
            FileOutputStream out = new FileOutputStream(this.mOutput.getFileDescriptor());
            this.mEngine = new FullBackupEngine(PerformFullTransportBackupTask.m2529$$Nest$fgetmUserBackupManagerService(this.this$0), out, this.mPreflight, this.mTarget, false, this, this.mQuota, this.mCurrentOpToken, this.mTransportFlags, PerformFullTransportBackupTask.m2527$$Nest$fgetmBackupEligibilityRules(this.this$0), PerformFullTransportBackupTask.m2528$$Nest$fgetmBackupManagerMonitorEventSender(this.this$0));
        L7:
            th = move-exception;
            this.mPreflightLatch.countDown();     // Catch: Throwable -> L15 Exception -> L17
            throw th;     // Catch: Throwable -> L15 Exception -> L17
        L4:
            if (this.mIsCancelled == true) goto L44;
            this.mPreflightResult = this.mEngine.preflightCheck();     // Catch: Throwable -> L7
        L44:
            this.mPreflightLatch.countDown();     // Catch: Throwable -> L15 Exception -> L17
            if (this.mPreflightResult == 0) goto L12;
        L19:
            unregisterTask();
            this.mBackupLatch.countDown();
            this.mOutput.close();     // Catch: IOException -> L22
        L43:
            return;
        L12:
            if (this.mIsCancelled == true) goto L19;
            this.mBackupResult = this.mEngine.backupOnePackage();     // Catch: Throwable -> L15 Exception -> L17
        L23:
            Slog.w(PerformFullTransportBackupTask.TAG, "Error closing transport pipe in runner");
            return;
        L17:
            e = move-exception;
            Slog.w(PerformFullTransportBackupTask.TAG, "Exception during full package backup of " + this.mTarget.packageName, e);     // Catch: Throwable -> L15
            unregisterTask();
            this.mBackupLatch.countDown();
            this.mOutput.close();     // Catch: IOException -> L22
        L15:
            e = move-exception;
            unregisterTask();
            this.mBackupLatch.countDown();
            this.mOutput.close();     // Catch: IOException -> L35
            throw e;
        L36:
            Slog.w(PerformFullTransportBackupTask.TAG, "Error closing transport pipe in runner");
            throw e;
        }

        public void sendQuotaExceeded(long backupDataBytes, long quotaBytes) {
            this.mEngine.sendQuotaExceeded(backupDataBytes, quotaBytes);
        }

        long getPreflightResultBlocking() {
            long fullBackupAgentTimeoutMillis = PerformFullTransportBackupTask.m2526$$Nest$fgetmAgentTimeoutParameters(this.this$0).getFullBackupAgentTimeoutMillis();
            this.mPreflightLatch.await(fullBackupAgentTimeoutMillis, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L11
            if (this.mIsCancelled == false) goto L8;
            return -2003;
        L8:
            if (this.mPreflightResult != 0) goto L15;
            return this.mPreflight.getExpectedSizeOrErrorCode();
        L15:
            return this.mPreflightResult;
        L16:
            return -1003;
        }

        int getBackupResultBlocking() {
            long fullBackupAgentTimeoutMillis = PerformFullTransportBackupTask.m2526$$Nest$fgetmAgentTimeoutParameters(this.this$0).getFullBackupAgentTimeoutMillis();
            this.mBackupLatch.await(fullBackupAgentTimeoutMillis, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L9
            if (this.mIsCancelled == false) goto L7;
            return -2003;
        L7:
            return this.mBackupResult;
        L10:
            return -1003;
        }

        @Override // com.android.server.backup.BackupRestoreTask
        public void execute() {
        }

        @Override // com.android.server.backup.BackupRestoreTask
        public void operationComplete(long result) {
        }

        @Override // com.android.server.backup.BackupRestoreTask
        public void handleCancel(int cancellationReason) {
            Slog.w(PerformFullTransportBackupTask.TAG, "Cancelled backup: " + this.mTarget.packageName + " reason:" + cancellationReason);
            PerformFullTransportBackupTask.m2528$$Nest$fgetmBackupManagerMonitorEventSender(this.this$0).monitorEvent(4, this.mTarget, 2, BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.CANCELLATION_REASON", cancellationReason));
            this.mIsCancelled = true;
            PerformFullTransportBackupTask.m2529$$Nest$fgetmUserBackupManagerService(this.this$0).handleCancel(this.mEphemeralToken, cancellationReason);
            PerformFullTransportBackupTask.m2529$$Nest$fgetmUserBackupManagerService(this.this$0).getBackupAgentConnectionManager().unbindAgent(this.mTarget.applicationInfo, true);
            this.mPreflightLatch.countDown();
            this.mBackupLatch.countDown();
            this.this$0.mOperationStorage.removeOperation(this.mCurrentOpToken);
        }
    }

    public static /* synthetic */ void $r8$lambda$LHAoxPfqTRXwU2t3rQ_gq5cVgNw(TransportManager r0, TransportConnection r1, String r2) {
        lambda$newWithCurrentTransport$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAgentTimeoutParameters, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackupAgentTimeoutParameters m2526$$Nest$fgetmAgentTimeoutParameters(PerformFullTransportBackupTask r0) {
        return r0.mAgentTimeoutParameters;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupEligibilityRules, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackupEligibilityRules m2527$$Nest$fgetmBackupEligibilityRules(PerformFullTransportBackupTask r0) {
        return r0.mBackupEligibilityRules;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupManagerMonitorEventSender, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackupManagerMonitorEventSender m2528$$Nest$fgetmBackupManagerMonitorEventSender(PerformFullTransportBackupTask r0) {
        return r0.mBackupManagerMonitorEventSender;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserBackupManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserBackupManagerService m2529$$Nest$fgetmUserBackupManagerService(PerformFullTransportBackupTask r0) {
        return r0.mUserBackupManagerService;
    }

    public static PerformFullTransportBackupTask newWithCurrentTransport(UserBackupManagerService backupManagerService, OperationStorage operationStorage, IFullBackupRestoreObserver observer, String[] whichPackages, boolean updateSchedule, FullBackupJob runningJob, CountDownLatch latch, IBackupObserver backupObserver, IBackupManagerMonitor monitor, boolean userInitiated, String caller, BackupEligibilityRules backupEligibilityRules) {
        final TransportManager transportManager = backupManagerService.getTransportManager();
        final TransportConnection transportConnection = transportManager.getCurrentTransportClient(caller);
        if (transportConnection == null) goto L7;
        OnTaskFinishedListener listener = new PerformFullTransportBackupTask$$ExternalSyntheticLambda0(transportManager, transportConnection);
        return new PerformFullTransportBackupTask(backupManagerService, operationStorage, transportConnection, observer, whichPackages, updateSchedule, runningJob, latch, backupObserver, monitor, listener, userInitiated, backupEligibilityRules);
    L7:
        throw new IllegalStateException("No TransportConnection available");
    }

    private static /* synthetic */ void lambda$newWithCurrentTransport$0(TransportManager transportManager, TransportConnection transportConnection, String listenerCaller) {
        transportManager.disposeOfTransportClient(transportConnection, listenerCaller);
    }

    public PerformFullTransportBackupTask(UserBackupManagerService backupManagerService, OperationStorage operationStorage, TransportConnection transportConnection, IFullBackupRestoreObserver observer, String[] whichPackages, boolean updateSchedule, FullBackupJob runningJob, CountDownLatch latch, IBackupObserver backupObserver, IBackupManagerMonitor monitor, OnTaskFinishedListener listener, boolean userInitiated, BackupEligibilityRules backupEligibilityRules) {
        String[] r6 = whichPackages;
        super(observer);
        this.mCancelLock = new Object();
        this.mUserBackupManagerService = backupManagerService;
        this.mOperationStorage = operationStorage;
        this.mTransportConnection = transportConnection;
        this.mUpdateSchedule = updateSchedule;
        this.mLatch = latch;
        this.mJob = runningJob;
        this.mPackages = new ArrayList(r6.length);
        this.mBackupObserver = backupObserver;
        if (listener == null) goto L5;
        OnTaskFinishedListener r0 = listener;
    L6:
        this.mListener = r0;
        this.mUserInitiated = userInitiated;
        this.mCurrentOpToken = backupManagerService.generateRandomIntegerToken();
        this.mBackupRunnerOpToken = backupManagerService.generateRandomIntegerToken();
        this.mBackupManagerMonitorEventSender = new BackupManagerMonitorEventSender(monitor);
        BackupAgentTimeoutParameters r1 = backupManagerService.getAgentTimeoutParameters();
        r1.getClass();
        this.mAgentTimeoutParameters = r1;
        this.mUserId = backupManagerService.getUserId();
        this.mBackupEligibilityRules = backupEligibilityRules;
        if (backupManagerService.isBackupOperationInProgress() == false) goto L10;
        Slog.d(TAG, "Skipping full backup. A backup is already in progress.");
        this.mCancelled = true;
        return;
    L10:
        int r5 = r6.length;
        int r2 = 0;
    L11:
        if (r2 >= r5) goto L32;
        int r16 = r2;
        String pkg = r6[r16];
        PackageManager pm = backupManagerService.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L28
        int r17 = r5;
        PackageInfo packageInfo = pm.getPackageInfoAsUser(pkg, 134217728, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L18
        if (this.mBackupEligibilityRules.appIsEligibleForBackup(packageInfo.applicationInfo) == true) goto L21;
        this.mBackupManagerMonitorEventSender.monitorEvent(9, packageInfo, 3, null);     // Catch: PackageManager.NameNotFoundException -> L18
        BackupObserverUtils.sendBackupOnPackageResult(this.mBackupObserver, pkg, -2001);     // Catch: PackageManager.NameNotFoundException -> L18
    L31:
        r2 = r16 + 1;
        r6 = whichPackages;
        r5 = r17;
        goto L11
    L21:
        if (this.mBackupEligibilityRules.appGetsFullBackup(packageInfo) == true) goto L24;
        this.mBackupManagerMonitorEventSender.monitorEvent(10, packageInfo, 3, null);     // Catch: PackageManager.NameNotFoundException -> L18
        BackupObserverUtils.sendBackupOnPackageResult(this.mBackupObserver, pkg, -2001);     // Catch: PackageManager.NameNotFoundException -> L18
        goto L31
    L24:
        if (this.mBackupEligibilityRules.appIsStopped(packageInfo.applicationInfo) == false) goto L26;
        this.mBackupManagerMonitorEventSender.monitorEvent(11, packageInfo, 3, null);     // Catch: PackageManager.NameNotFoundException -> L18
        BackupObserverUtils.sendBackupOnPackageResult(this.mBackupObserver, pkg, -2001);     // Catch: PackageManager.NameNotFoundException -> L18
        goto L31
    L26:
        this.mPackages.add(packageInfo);     // Catch: PackageManager.NameNotFoundException -> L18
    L30:
        Slog.i(TAG, "Requested package " + pkg + " not found; ignoring");
        this.mBackupManagerMonitorEventSender.monitorEvent(12, null, 3, null);
    L29:
        r17 = r5;
        goto L30
    L32:
        Set<String> packageNames = Sets.newHashSet();
        Iterator<PackageInfo> r3 = this.mPackages.iterator();
    L34:
        if (r3.hasNext() == false) goto L36;
        PackageInfo pkgInfo = r3.next();
        packageNames.add(pkgInfo.packageName);
        goto L34
    L36:
        Slog.d(TAG, "backupmanager pftbt token=" + Integer.toHexString(this.mCurrentOpToken));
        this.mOperationStorage.registerOperationForPackages(this.mCurrentOpToken, 0, packageNames, this, 2);
        return;
    L5:
        r0 = OnTaskFinishedListener.NOP;
        goto L6
    }

    public void unregisterTask() {
        this.mOperationStorage.removeOperation(this.mCurrentOpToken);
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void execute() {
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void handleCancel(int cancellationReason) {
        Object r0 = this.mCancelLock;
        monitor-enter(r0);
        if (cancellationReason != 0) goto L11;
        Slog.wtf(TAG, "This task cannot time out");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (cancellationReason != 1) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        if (this.mCancelled == false) goto L19;
        Slog.d(TAG, "Ignoring duplicate cancel call.");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mCancelled = true;     // Catch: Throwable -> L8
        if (this.mIsDoingBackup == false) goto L26;
        this.mUserBackupManagerService.handleCancel(this.mBackupRunnerOpToken, cancellationReason);     // Catch: Throwable -> L8
        BackupTransportClient transport = this.mTransportConnection.getConnectedTransport("PFTBT.handleCancel()");     // Catch: Throwable -> L8 Throwable -> L24
        transport.cancelFullBackup();     // Catch: Throwable -> L8 Throwable -> L24
    L24:
        e = move-exception;
        Slog.w(TAG, "Error calling cancelFullBackup() on transport: " + e);     // Catch: Throwable -> L8
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void operationComplete(long result) {
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 23141. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    @Override // java.lang.Runnable
    public void run() {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: CONST (r2v0 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (0 ??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) A[DECLARE_VAR] in method: com.android.server.backup.fullbackup.PerformFullTransportBackupTask.run():void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.backup.fullbackup.PerformFullTransportBackupTask.run():void");
    }

    void cleanUpPipes(ParcelFileDescriptor[] pipes) {
        if (pipes != null) goto L4;
        return;
    L4:
        if (pipes[0] == null) goto L11;
        ParcelFileDescriptor fd = pipes[0];
        pipes[0] = null;
        fd.close();     // Catch: IOException -> L8
    L9:
        Slog.w(TAG, "Unable to close pipe!");
    L11:
        if (pipes[1] == null) goto L23;
        ParcelFileDescriptor fd2 = pipes[1];
        pipes[1] = null;
        fd2.close();     // Catch: IOException -> L15
        return;
    L16:
        Slog.w(TAG, "Unable to close pipe!");
        return;
    }

    private void setNoRestrictedModePackages(BackupTransportClient transport, List<PackageInfo> packages) {
        Set<String> packageNames = new ArraySet();     // Catch: RemoteException -> L6
        int i = 0;
    L4:
        if (i >= packages.size()) goto L8;
        packageNames.add(packages.get(i).packageName);     // Catch: RemoteException -> L6
        i = i + 1;     // Catch: RemoteException -> L6
        goto L4
    L8:
        Set<String> packageNames2 = transport.getPackagesThatShouldNotUseRestrictedMode(packageNames, 0);     // Catch: RemoteException -> L6
        this.mUserBackupManagerService.getBackupAgentConnectionManager().setNoRestrictedModePackages(packageNames2, 0);     // Catch: RemoteException -> L6
        return;
    L10:
        Slog.i(TAG, "Failed to retrieve no restricted mode packages from transport");
    }
}
