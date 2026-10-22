package com.android.server.backup.restore;

import android.app.IBackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.IBackupManagerMonitor;
import android.app.backup.IRestoreObserver;
import android.app.backup.RestoreDescription;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.Slog;
import com.android.server.AppWidgetBackupBridge;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.backup.BackupAgentConnectionManager;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.backup.BackupAndRestoreFeatureFlags;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.BackupRestoreTask;
import com.android.server.backup.BackupUtils;
import com.android.server.backup.OperationStorage;
import com.android.server.backup.PackageManagerBackupAgent;
import com.android.server.backup.TransportManager;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.internal.OnTaskFinishedListener;
import com.android.server.backup.keyvalue.KeyValueBackupTask;
import com.android.server.backup.transport.BackupTransportClient;
import com.android.server.backup.transport.TransportConnection;
import com.android.server.backup.utils.BackupEligibilityRules;
import com.android.server.backup.utils.BackupManagerMonitorEventSender;
import com.android.server.pm.PackageManagerService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes.dex */
public class PerformUnifiedRestoreTask implements BackupRestoreTask {
    private UserBackupManagerService backupManagerService;
    private List<PackageInfo> mAcceptSet;
    private IBackupAgent mAgent;
    private final BackupAgentTimeoutParameters mAgentTimeoutParameters;
    private Boolean mAreVToUListsSet;
    private ParcelFileDescriptor mBackupData;
    private File mBackupDataName;
    private final BackupEligibilityRules mBackupEligibilityRules;
    private BackupManagerMonitorEventSender mBackupManagerMonitorEventSender;
    private PackageInfo mCurrentPackage;
    private boolean mDidLaunch;
    private final int mEphemeralOpToken;
    private boolean mFinished;
    private boolean mIsSystemRestore;
    private final OnTaskFinishedListener mListener;
    private ParcelFileDescriptor mNewState;
    private File mNewStateName;
    private IRestoreObserver mObserver;
    private final OperationStorage mOperationStorage;
    private PackageManagerBackupAgent mPmAgent;
    private int mPmToken;
    private int mRestoreAttemptedAppsCount;
    private RestoreDescription mRestoreDescription;
    private File mStageName;
    private long mStartRealtime;
    private UnifiedRestoreState mState;
    private File mStateDir;
    private int mStatus;
    private PackageInfo mTargetPackage;
    private long mToken;
    private final TransportConnection mTransportConnection;
    private final TransportManager mTransportManager;
    private final int mUserId;
    private List<String> mVToUAllowlist;
    private List<String> mVToUDenylist;
    private byte[] mWidgetData;

    /* JADX INFO: renamed from: com.android.server.backup.restore.PerformUnifiedRestoreTask$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$server$backup$restore$UnifiedRestoreState = null;

        static {
            $SwitchMap$com$android$server$backup$restore$UnifiedRestoreState = new int[UnifiedRestoreState.values().length];
            $SwitchMap$com$android$server$backup$restore$UnifiedRestoreState[UnifiedRestoreState.INITIAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L32:
            $SwitchMap$com$android$server$backup$restore$UnifiedRestoreState[UnifiedRestoreState.RUNNING_QUEUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L24:
            $SwitchMap$com$android$server$backup$restore$UnifiedRestoreState[UnifiedRestoreState.RESTORE_KEYVALUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$android$server$backup$restore$UnifiedRestoreState[UnifiedRestoreState.RESTORE_FULL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L26:
            $SwitchMap$com$android$server$backup$restore$UnifiedRestoreState[UnifiedRestoreState.RESTORE_FINISHED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$com$android$server$backup$restore$UnifiedRestoreState[UnifiedRestoreState.FINAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    class StreamFeederThread extends RestoreEngine implements Runnable, BackupRestoreTask {
        final String TAG;
        FullRestoreEngine mEngine;
        ParcelFileDescriptor[] mEnginePipes;
        FullRestoreEngineThread mEngineThread;
        private final int mEphemeralOpToken;
        ParcelFileDescriptor[] mTransportPipes;
        final /* synthetic */ PerformUnifiedRestoreTask this$0;

        public StreamFeederThread(PerformUnifiedRestoreTask this$0) throws IOException {
            this.this$0 = this$0;
            this.TAG = "StreamFeederThread";
            this.mEphemeralOpToken = PerformUnifiedRestoreTask.m2535$$Nest$fgetbackupManagerService(this$0).generateRandomIntegerToken();
            this.mTransportPipes = ParcelFileDescriptor.createPipe();
            this.mEnginePipes = ParcelFileDescriptor.createPipe();
            setRunning(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            UnifiedRestoreState r13 = UnifiedRestoreState.RUNNING_QUEUE;
            int status = 0;
            EventLog.writeEvent(EventLogTags.FULL_RESTORE_PACKAGE, PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0).packageName);
            this.mEngine = new FullRestoreEngine(PerformUnifiedRestoreTask.m2535$$Nest$fgetbackupManagerService(this.this$0), PerformUnifiedRestoreTask.m2539$$Nest$fgetmOperationStorage(this.this$0), this, null, PerformUnifiedRestoreTask.m2537$$Nest$fgetmBackupManagerMonitorEventSender(this.this$0).getMonitor(), PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0), false, this.mEphemeralOpToken, false, PerformUnifiedRestoreTask.m2536$$Nest$fgetmBackupEligibilityRules(this.this$0));
            this.mEngineThread = new FullRestoreEngineThread(this.mEngine, this.mEnginePipes[0]);
            ParcelFileDescriptor eWriteEnd = this.mEnginePipes[1];
            ParcelFileDescriptor tReadEnd = this.mTransportPipes[0];
            ParcelFileDescriptor tWriteEnd = this.mTransportPipes[1];
            int bufferSize = 65536;
            byte[] buffer = new byte[65536];
            FileOutputStream engineOut = new FileOutputStream(eWriteEnd.getFileDescriptor());
            FileInputStream transportIn = new FileInputStream(tReadEnd.getFileDescriptor());
            new Thread(this.mEngineThread, "unified-restore-engine").start();
            BackupTransportClient transport = PerformUnifiedRestoreTask.m2540$$Nest$fgetmTransportConnection(this.this$0).connectOrThrow("PerformUnifiedRestoreTask$StreamFeederThread.run()");     // Catch: Throwable -> L51 Exception -> L53 IOException -> L55
        L4:
            if (status != 0) goto L58;
            int result = transport.getNextFullRestoreDataChunk(tWriteEnd);     // Catch: Throwable -> L51 Exception -> L53 IOException -> L55
            goto L93
        L7:
            if (result > 0) goto L9;
            BackupTransportClient transport2 = transport;
            ParcelFileDescriptor eWriteEnd2 = eWriteEnd;
            if (result == (-1)) goto L33;
            Slog.e("StreamFeederThread", "Error " + result + " streaming restore for " + PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0).packageName);     // Catch: Throwable -> L45 Exception -> L47 IOException -> L49
            Bundle monitoringExtras = PerformUnifiedRestoreTask.m2544$$Nest$maddRestoreOperationTypeToEvent(this.this$0, null);     // Catch: Throwable -> L45 Exception -> L47 IOException -> L49
            goto L93
        L140:
            PerformUnifiedRestoreTask.m2537$$Nest$fgetmBackupManagerMonitorEventSender(this.this$0).monitorEvent(66, PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0), 1, monitoringExtras);     // Catch: Throwable -> L39 Exception -> L41 IOException -> L43
            EventLog.writeEvent(EventLogTags.RESTORE_TRANSPORT_FAILURE, new Object[0]);     // Catch: Throwable -> L39 Exception -> L41 IOException -> L43
            status = result;
        L38:
            eWriteEnd = eWriteEnd2;
            tReadEnd = tReadEnd;
            transport = transport2;
            tWriteEnd = tWriteEnd;
            goto L4
        L41:
            e = e;
        L75:
            Slog.e("StreamFeederThread", "Transport failed during restore: " + e.getMessage());     // Catch: Throwable -> L39
            Bundle monitoringExtras2 = PerformUnifiedRestoreTask.m2544$$Nest$maddRestoreOperationTypeToEvent(this.this$0, null);     // Catch: Throwable -> L39
            PerformUnifiedRestoreTask.m2537$$Nest$fgetmBackupManagerMonitorEventSender(this.this$0).monitorEvent(66, PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0), 1, monitoringExtras2);     // Catch: Throwable -> L39
            EventLog.writeEvent(EventLogTags.RESTORE_TRANSPORT_FAILURE, new Object[0]);     // Catch: Throwable -> L39
            int status2 = -1000;
            IoUtils.closeQuietly(this.mEnginePipes[1]);
            IoUtils.closeQuietly(this.mTransportPipes[0]);
            IoUtils.closeQuietly(this.mTransportPipes[1]);
            this.mEngineThread.waitForResult();
            IoUtils.closeQuietly(this.mEnginePipes[0]);
            PerformUnifiedRestoreTask r0 = this.this$0;
            if (this.mEngine.getAgent() == null) goto L79;
            boolean r4 = true;
        L80:
            PerformUnifiedRestoreTask.m2542$$Nest$fputmDidLaunch(r0, r4);
            if ((-1000(0xfffffffffffffc18, float:NaN)) != 0) goto L129;
            UnifiedRestoreState nextState = UnifiedRestoreState.RESTORE_FINISHED;
            PerformUnifiedRestoreTask.m2541$$Nest$fputmAgent(this.this$0, this.mEngine.getAgent());
            PerformUnifiedRestoreTask.m2543$$Nest$fputmWidgetData(this.this$0, this.mEngine.getWidgetData());
        L73:
            this.this$0.executeNextState(nextState);
            setRunning(false);
            return;
        L129:
            BackupTransportClient transport3 = PerformUnifiedRestoreTask.m2540$$Nest$fgetmTransportConnection(this.this$0).connectOrThrow("PerformUnifiedRestoreTask$StreamFeederThread.run()");     // Catch: Exception -> L86
            transport3.abortFullRestore();     // Catch: Exception -> L86
        L88:
            PerformUnifiedRestoreTask.m2535$$Nest$fgetbackupManagerService(this.this$0).clearApplicationDataAfterRestoreFailure(PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0).packageName);
            if (status2 != (-1000)) goto L91;
        L90:
            nextState = UnifiedRestoreState.FINAL;
        L91:
            nextState = UnifiedRestoreState.RUNNING_QUEUE;
        L86:
            e = move-exception;
            Slog.e("StreamFeederThread", "Transport threw from abortFullRestore: " + e.getMessage());
            status2 = -1000;
            goto L88
        L79:
            r4 = false;
        L47:
            e = e;
        L45:
            th = move-exception;
            Throwable r2 = th;
        L109:
            IoUtils.closeQuietly(this.mEnginePipes[1]);
            IoUtils.closeQuietly(this.mTransportPipes[0]);
            IoUtils.closeQuietly(this.mTransportPipes[1]);
            this.mEngineThread.waitForResult();
            IoUtils.closeQuietly(this.mEnginePipes[0]);
            PerformUnifiedRestoreTask r1 = this.this$0;
            if (this.mEngine.getAgent() == null) goto L112;
            boolean r5 = true;
        L113:
            PerformUnifiedRestoreTask.m2542$$Nest$fputmDidLaunch(r1, r5);
            if (status != 0) goto L133;
            UnifiedRestoreState nextState2 = UnifiedRestoreState.RESTORE_FINISHED;
            PerformUnifiedRestoreTask.m2541$$Nest$fputmAgent(this.this$0, this.mEngine.getAgent());
            PerformUnifiedRestoreTask.m2543$$Nest$fputmWidgetData(this.this$0, this.mEngine.getWidgetData());
        L124:
            this.this$0.executeNextState(nextState2);
            setRunning(false);
            throw r2;
        L133:
            BackupTransportClient transport4 = PerformUnifiedRestoreTask.m2540$$Nest$fgetmTransportConnection(this.this$0).connectOrThrow("PerformUnifiedRestoreTask$StreamFeederThread.run()");     // Catch: Exception -> L117
            transport4.abortFullRestore();     // Catch: Exception -> L117
        L119:
            PerformUnifiedRestoreTask.m2535$$Nest$fgetbackupManagerService(this.this$0).clearApplicationDataAfterRestoreFailure(PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0).packageName);
            if (status != (-1000)) goto L122;
            nextState2 = UnifiedRestoreState.FINAL;
            goto L124
        L122:
            nextState2 = UnifiedRestoreState.RUNNING_QUEUE;
        L117:
            e = move-exception;
            Slog.e("StreamFeederThread", "Transport threw from abortFullRestore: " + e.getMessage());
            status = -1000;
            goto L119
        L112:
            r5 = false;
            goto L113
        L33:
            status = 0;
            goto L58
        L9:
            if (result <= bufferSize) goto L19;
            bufferSize = result;
            buffer = new byte[bufferSize];     // Catch: Throwable -> L13 Exception -> L15 IOException -> L17
            goto L19
        L15:
            e = e;
        L13:
            th = move-exception;
            r2 = th;
        L19:
            int toCopy = result;
        L20:
            if (toCopy <= 0) goto L30;
            ParcelFileDescriptor eWriteEnd3 = eWriteEnd;
            int n = transportIn.read(buffer, 0, toCopy);     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28
            BackupTransportClient transport5 = transport;
            engineOut.write(buffer, 0, n);     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28
            toCopy = toCopy - n;
            eWriteEnd = eWriteEnd3;
            transport = transport5;
            goto L20
        L26:
            e = e;
        L24:
            th = move-exception;
            r2 = th;
            goto L109
        L30:
            transport2 = transport;
            eWriteEnd2 = eWriteEnd;
        L58:
            IoUtils.closeQuietly(this.mEnginePipes[1]);
            IoUtils.closeQuietly(this.mTransportPipes[0]);
            IoUtils.closeQuietly(this.mTransportPipes[1]);
            this.mEngineThread.waitForResult();
            IoUtils.closeQuietly(this.mEnginePipes[0]);
            PerformUnifiedRestoreTask r3 = this.this$0;
            if (this.mEngine.getAgent() == null) goto L61;
            boolean r6 = true;
        L62:
            PerformUnifiedRestoreTask.m2542$$Nest$fputmDidLaunch(r3, r6);
            if (status != 0) goto L131;
            nextState = UnifiedRestoreState.RESTORE_FINISHED;
            PerformUnifiedRestoreTask.m2541$$Nest$fputmAgent(this.this$0, this.mEngine.getAgent());
            PerformUnifiedRestoreTask.m2543$$Nest$fputmWidgetData(this.this$0, this.mEngine.getWidgetData());
            goto L73
        L131:
            BackupTransportClient transport6 = PerformUnifiedRestoreTask.m2540$$Nest$fgetmTransportConnection(this.this$0).connectOrThrow("PerformUnifiedRestoreTask$StreamFeederThread.run()");     // Catch: Exception -> L67
            transport6.abortFullRestore();     // Catch: Exception -> L67
        L69:
            PerformUnifiedRestoreTask.m2535$$Nest$fgetbackupManagerService(this.this$0).clearApplicationDataAfterRestoreFailure(PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0).packageName);
            if (status != (-1000)) goto L72;
            nextState = UnifiedRestoreState.FINAL;
            goto L73
        L72:
            nextState = UnifiedRestoreState.RUNNING_QUEUE;
        L67:
            e = move-exception;
            Slog.e("StreamFeederThread", "Transport threw from abortFullRestore: " + e.getMessage());
            status = -1000;
            goto L69
        L61:
            r6 = false;
        L39:
            th = move-exception;
            r2 = th;
        L53:
            e = e;
        L51:
            th = move-exception;
            r2 = th;
        L93:
            Slog.e("StreamFeederThread", "Unable to route data for restore");     // Catch: Throwable -> L39
            Bundle monitoringExtras3 = PerformUnifiedRestoreTask.m2544$$Nest$maddRestoreOperationTypeToEvent(this.this$0, null);     // Catch: Throwable -> L39
            PerformUnifiedRestoreTask.m2537$$Nest$fgetmBackupManagerMonitorEventSender(this.this$0).monitorEvent(65, PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0), 2, monitoringExtras3);     // Catch: Throwable -> L39
            EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0).packageName, "I/O error on pipes"});     // Catch: Throwable -> L39
            status2 = -1003;
            IoUtils.closeQuietly(this.mEnginePipes[1]);
            IoUtils.closeQuietly(this.mTransportPipes[0]);
            IoUtils.closeQuietly(this.mTransportPipes[1]);
            this.mEngineThread.waitForResult();
            IoUtils.closeQuietly(this.mEnginePipes[0]);
            PerformUnifiedRestoreTask r7 = this.this$0;
            if (this.mEngine.getAgent() == null) goto L97;
            boolean r8 = true;
        L98:
            PerformUnifiedRestoreTask.m2542$$Nest$fputmDidLaunch(r7, r8);
            if ((-1003(0xfffffffffffffc15, float:NaN)) != 0) goto L127;
            nextState = UnifiedRestoreState.RESTORE_FINISHED;
            PerformUnifiedRestoreTask.m2541$$Nest$fputmAgent(this.this$0, this.mEngine.getAgent());
            PerformUnifiedRestoreTask.m2543$$Nest$fputmWidgetData(this.this$0, this.mEngine.getWidgetData());
            goto L73
        L127:
            BackupTransportClient transport7 = PerformUnifiedRestoreTask.m2540$$Nest$fgetmTransportConnection(this.this$0).connectOrThrow("PerformUnifiedRestoreTask$StreamFeederThread.run()");     // Catch: Exception -> L103
            transport7.abortFullRestore();     // Catch: Exception -> L103
        L105:
            PerformUnifiedRestoreTask.m2535$$Nest$fgetbackupManagerService(this.this$0).clearApplicationDataAfterRestoreFailure(PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0).packageName);
            if (status2 != (-1000)) goto L91;
        L103:
            e = move-exception;
            Slog.e("StreamFeederThread", "Transport threw from abortFullRestore: " + e.getMessage());
            status2 = -1000;
            goto L105
        L97:
            r8 = false;
            goto L98
        }

        @Override // com.android.server.backup.BackupRestoreTask
        public void execute() {
        }

        @Override // com.android.server.backup.BackupRestoreTask
        public void operationComplete(long result) {
        }

        @Override // com.android.server.backup.BackupRestoreTask
        public void handleCancel(int cancellationReason) {
            PerformUnifiedRestoreTask.m2539$$Nest$fgetmOperationStorage(this.this$0).removeOperation(this.mEphemeralOpToken);
            Slog.w("StreamFeederThread", "Full-data restore target timed out; shutting down");
            Bundle monitoringExtras = PerformUnifiedRestoreTask.m2544$$Nest$maddRestoreOperationTypeToEvent(this.this$0, null);
            PerformUnifiedRestoreTask.m2537$$Nest$fgetmBackupManagerMonitorEventSender(this.this$0).monitorEvent(45, PerformUnifiedRestoreTask.m2538$$Nest$fgetmCurrentPackage(this.this$0), 2, monitoringExtras);
            this.mEngineThread.handleTimeout();
            IoUtils.closeQuietly(this.mEnginePipes[1]);
            this.mEnginePipes[1] = null;
            IoUtils.closeQuietly(this.mEnginePipes[0]);
            this.mEnginePipes[0] = null;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetbackupManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserBackupManagerService m2535$$Nest$fgetbackupManagerService(PerformUnifiedRestoreTask r0) {
        return r0.backupManagerService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupEligibilityRules, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackupEligibilityRules m2536$$Nest$fgetmBackupEligibilityRules(PerformUnifiedRestoreTask r0) {
        return r0.mBackupEligibilityRules;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupManagerMonitorEventSender, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackupManagerMonitorEventSender m2537$$Nest$fgetmBackupManagerMonitorEventSender(PerformUnifiedRestoreTask r0) {
        return r0.mBackupManagerMonitorEventSender;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageInfo m2538$$Nest$fgetmCurrentPackage(PerformUnifiedRestoreTask r0) {
        return r0.mCurrentPackage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOperationStorage, reason: not valid java name */
    static /* bridge */ /* synthetic */ OperationStorage m2539$$Nest$fgetmOperationStorage(PerformUnifiedRestoreTask r0) {
        return r0.mOperationStorage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTransportConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ TransportConnection m2540$$Nest$fgetmTransportConnection(PerformUnifiedRestoreTask r0) {
        return r0.mTransportConnection;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAgent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2541$$Nest$fputmAgent(PerformUnifiedRestoreTask r0, IBackupAgent r1) {
        r0.mAgent = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDidLaunch, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2542$$Nest$fputmDidLaunch(PerformUnifiedRestoreTask r0, boolean r1) {
        r0.mDidLaunch = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWidgetData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2543$$Nest$fputmWidgetData(PerformUnifiedRestoreTask r0, byte[] r1) {
        r0.mWidgetData = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddRestoreOperationTypeToEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m2544$$Nest$maddRestoreOperationTypeToEvent(PerformUnifiedRestoreTask r0, Bundle r1) {
        return r0.addRestoreOperationTypeToEvent(r1);
    }

    PerformUnifiedRestoreTask(UserBackupManagerService backupManagerService, TransportConnection transportConnection, String vToUAllowlist, String vToUDenyList) {
        this.mAreVToUListsSet = false;
        this.mListener = null;
        this.mAgentTimeoutParameters = null;
        this.mOperationStorage = null;
        this.mTransportConnection = transportConnection;
        this.mTransportManager = null;
        this.mEphemeralOpToken = 0;
        this.mUserId = 0;
        this.mBackupEligibilityRules = null;
        this.backupManagerService = backupManagerService;
        this.mBackupManagerMonitorEventSender = new BackupManagerMonitorEventSender(null);
        this.mVToUAllowlist = createVToUList(vToUAllowlist);
        this.mVToUDenylist = createVToUList(vToUDenyList);
    }

    public PerformUnifiedRestoreTask(UserBackupManagerService backupManagerService, OperationStorage operationStorage, TransportConnection transportConnection, IRestoreObserver observer, IBackupManagerMonitor monitor, long restoreSetToken, PackageInfo targetPackage, int pmToken, boolean isFullSystemRestore, String[] filterSet, OnTaskFinishedListener listener, BackupEligibilityRules backupEligibilityRules) {
        this.mAreVToUListsSet = false;
        this.backupManagerService = backupManagerService;
        this.mOperationStorage = operationStorage;
        this.mUserId = backupManagerService.getUserId();
        this.mTransportManager = backupManagerService.getTransportManager();
        this.mEphemeralOpToken = backupManagerService.generateRandomIntegerToken();
        this.mState = UnifiedRestoreState.INITIAL;
        this.mStartRealtime = SystemClock.elapsedRealtime();
        this.mTransportConnection = transportConnection;
        this.mObserver = observer;
        this.mBackupManagerMonitorEventSender = new BackupManagerMonitorEventSender(monitor);
        this.mToken = restoreSetToken;
        this.mPmToken = pmToken;
        this.mTargetPackage = targetPackage;
        this.mIsSystemRestore = isFullSystemRestore;
        this.mFinished = false;
        this.mDidLaunch = false;
        this.mListener = listener;
        BackupAgentTimeoutParameters r0 = backupManagerService.getAgentTimeoutParameters();
        r0.getClass();
        this.mAgentTimeoutParameters = r0;
        this.mBackupEligibilityRules = backupEligibilityRules;
        if (targetPackage == null) goto L5;
        this.mAcceptSet = new ArrayList();
        this.mAcceptSet.add(targetPackage);
        return;
    L5:
        if (filterSet != null) goto L7;
        List<PackageInfo> apps = PackageManagerBackupAgent.getStorableApplications(backupManagerService.getPackageManager(), this.mUserId, backupEligibilityRules);
        String[] filterSet2 = packagesToNames(apps);
        Slog.i(BackupManagerService.TAG, "Full restore; asking about " + filterSet2.length + " apps");
    L8:
        this.mAcceptSet = new ArrayList(filterSet2.length);
        int i = 0;
        boolean hasSettings = false;
        boolean hasSystem = false;
    L9:
        boolean hasSystem2 = hasSystem;
        if (i >= filterSet2.length) goto L31;
        PackageManager pm = backupManagerService.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L26
        int i2 = i;
        PackageInfo info = pm.getPackageInfoAsUser(filterSet2[i2], 0, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L23
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(info.packageName) == false) goto L17;
        hasSystem = true;
    L29:
        i = i2 + 1;
        goto L9
    L17:
        if (UserBackupManagerService.SETTINGS_PACKAGE.equals(info.packageName) == false) goto L19;
        hasSettings = true;
        hasSystem = hasSystem2;
        goto L29
    L19:
        ApplicationInfo applicationInfo = info.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L23
        if (backupEligibilityRules.appIsEligibleForBackup(applicationInfo) == false) goto L28;
        this.mAcceptSet.add(info);     // Catch: PackageManager.NameNotFoundException -> L23
    L28:
        hasSystem = hasSystem2;
    L27:
        i2 = i;
        goto L28
    L31:
        if (hasSystem2 == true) goto L42;
    L35:
        if (hasSettings == false) goto L53;
        this.mAcceptSet.add(backupManagerService.getPackageManager().getPackageInfoAsUser(UserBackupManagerService.SETTINGS_PACKAGE, 0, this.mUserId));     // Catch: PackageManager.NameNotFoundException -> L38
        return;
    L39:
        return;
    L53:
        return;
    L42:
        this.mAcceptSet.add(0, backupManagerService.getPackageManager().getPackageInfoAsUser(PackageManagerService.PLATFORM_PACKAGE_NAME, 0, this.mUserId));     // Catch: PackageManager.NameNotFoundException -> L34
        goto L35
    L7:
        filterSet2 = filterSet;
        goto L8
    }

    private String[] packagesToNames(List<PackageInfo> apps) {
        int N = apps.size();
        String[] names = new String[N];
        int i = 0;
    L3:
        if (i >= N) goto L6;
        names[i] = apps.get(i).packageName;
        i = i + 1;
        goto L3
    L6:
        return names;
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void execute() {
        switch(AnonymousClass1.$SwitchMap$com$android$server$backup$restore$UnifiedRestoreState[this.mState.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L6;
            default: goto L21;
        };
    L10:
        restoreFinished();
        return;
    L11:
        restoreFull();
        return;
    L12:
        restoreKeyValue();
        return;
    L13:
        dispatchNextRestore();
        return;
    L14:
        startRestore();
        return;
    L21:
        return;
    L6:
        if (this.mFinished == true) goto L8;
        finalizeRestore();
    L9:
        this.mFinished = true;
        return;
    L8:
        Slog.e(BackupManagerService.TAG, "Duplicate finish");
        goto L9
    }

    private void startRestore() {
        sendStartRestore(this.mAcceptSet.size());
        String transportDirName = this.mTransportManager.getTransportDirName(this.mTransportConnection.getTransportComponent());     // Catch: Exception -> L6
        this.mStateDir = new File(this.backupManagerService.getBaseStateDir(), transportDirName);     // Catch: Exception -> L6
        PackageInfo pmPackage = new PackageInfo();     // Catch: Exception -> L6
        pmPackage.packageName = UserBackupManagerService.PACKAGE_MANAGER_SENTINEL;     // Catch: Exception -> L6
        this.mAcceptSet.add(0, pmPackage);     // Catch: Exception -> L6
        PackageInfo[] packages = (PackageInfo[]) this.mAcceptSet.toArray(new PackageInfo[0]);     // Catch: Exception -> L6
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("PerformUnifiedRestoreTask.startRestore()");     // Catch: Exception -> L6
        if (this.mBackupManagerMonitorEventSender.getMonitor() != null) goto L9;
        this.mBackupManagerMonitorEventSender.setMonitor(transport.getBackupManagerMonitor());     // Catch: Exception -> L6
    L9:
        if (this.mIsSystemRestore == false) goto L11;
        AppWidgetBackupBridge.systemRestoreStarting(this.mUserId);     // Catch: Exception -> L6
        Bundle monitoringExtras = addRestoreOperationTypeToEvent(null);     // Catch: Exception -> L6
        this.mBackupManagerMonitorEventSender.monitorEvent(53, null, 3, monitoringExtras);     // Catch: Exception -> L6
    L12:
        this.mStatus = transport.startRestore(this.mToken, packages);     // Catch: Exception -> L6
        if (this.mStatus == 0) goto L16;
        Slog.e(BackupManagerService.TAG, "Transport error " + this.mStatus + "; no restore possible");     // Catch: Exception -> L6
        Bundle monitoringExtras2 = addRestoreOperationTypeToEvent(null);     // Catch: Exception -> L6
        this.mBackupManagerMonitorEventSender.monitorEvent(55, this.mCurrentPackage, 1, monitoringExtras2);     // Catch: Exception -> L6
        this.mStatus = -1000;     // Catch: Exception -> L6
        executeNextState(UnifiedRestoreState.FINAL);     // Catch: Exception -> L6
        return;
    L16:
        setNoRestrictedModePackages(transport, packages);     // Catch: Exception -> L6
        RestoreDescription desc = transport.nextRestorePackage();     // Catch: Exception -> L6
        if (desc != null) goto L21;
        Slog.e(BackupManagerService.TAG, "No restore metadata available; halting");     // Catch: Exception -> L6
        Bundle monitoringExtras3 = addRestoreOperationTypeToEvent(null);     // Catch: Exception -> L6
        this.mBackupManagerMonitorEventSender.monitorEvent(22, this.mCurrentPackage, 3, monitoringExtras3);     // Catch: Exception -> L6
        this.mStatus = -1000;     // Catch: Exception -> L6
        executeNextState(UnifiedRestoreState.FINAL);     // Catch: Exception -> L6
        return;
    L21:
        if (UserBackupManagerService.PACKAGE_MANAGER_SENTINEL.equals(desc.getPackageName()) == true) goto L24;
        Slog.e(BackupManagerService.TAG, "Required package metadata but got " + desc.getPackageName());     // Catch: Exception -> L6
        Bundle monitoringExtras4 = addRestoreOperationTypeToEvent(null);     // Catch: Exception -> L6
        this.mBackupManagerMonitorEventSender.monitorEvent(23, this.mCurrentPackage, 3, monitoringExtras4);     // Catch: Exception -> L6
        this.mStatus = -1000;     // Catch: Exception -> L6
        executeNextState(UnifiedRestoreState.FINAL);     // Catch: Exception -> L6
        return;
    L24:
        this.mCurrentPackage = new PackageInfo();     // Catch: Exception -> L6
        this.mCurrentPackage.packageName = UserBackupManagerService.PACKAGE_MANAGER_SENTINEL;     // Catch: Exception -> L6
        this.mCurrentPackage.applicationInfo = new ApplicationInfo();     // Catch: Exception -> L6
        this.mCurrentPackage.applicationInfo.uid = 1000;     // Catch: Exception -> L6
        this.mPmAgent = this.backupManagerService.makeMetadataAgent(null);     // Catch: Exception -> L6
        this.mAgent = IBackupAgent.Stub.asInterface(this.mPmAgent.onBind());     // Catch: Exception -> L6
        initiateOneRestore(this.mCurrentPackage, 0);     // Catch: Exception -> L6
        this.backupManagerService.getBackupHandler().removeMessages(18);     // Catch: Exception -> L6
        if (this.mPmAgent.hasMetadata() == true) goto L29;
        Slog.e(BackupManagerService.TAG, "PM agent has no metadata, so not restoring");     // Catch: Exception -> L6
        Bundle monitoringExtras5 = addRestoreOperationTypeToEvent(null);     // Catch: Exception -> L6
        this.mBackupManagerMonitorEventSender.monitorEvent(24, this.mCurrentPackage, 3, monitoringExtras5);     // Catch: Exception -> L6
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{UserBackupManagerService.PACKAGE_MANAGER_SENTINEL, "Package manager restore metadata missing"});     // Catch: Exception -> L6
        this.mStatus = -1000;     // Catch: Exception -> L6
        this.backupManagerService.getBackupHandler().removeMessages(20, this);     // Catch: Exception -> L6
        executeNextState(UnifiedRestoreState.FINAL);     // Catch: Exception -> L6
        return;
    L29:
        return;
    L11:
        Bundle monitoringExtras6 = addRestoreOperationTypeToEvent(null);     // Catch: Exception -> L6
        this.mBackupManagerMonitorEventSender.monitorEvent(54, null, 3, monitoringExtras6);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Unable to contact transport for restore: " + e.getMessage());
        Bundle monitoringExtras7 = addRestoreOperationTypeToEvent(null);
        this.mBackupManagerMonitorEventSender.monitorEvent(25, null, 1, monitoringExtras7);
        this.mStatus = -1000;
        this.backupManagerService.getBackupHandler().removeMessages(20, this);
        executeNextState(UnifiedRestoreState.FINAL);
    }

    private void dispatchNextRestore() {
        UnifiedRestoreState nextState = UnifiedRestoreState.FINAL;
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("PerformUnifiedRestoreTask.dispatchNextRestore()");     // Catch: Throwable -> L6 Exception -> L8
        this.mRestoreDescription = transport.nextRestorePackage();     // Catch: Throwable -> L6 Exception -> L8
        if (this.mRestoreDescription == null) goto L10;
        String r0 = this.mRestoreDescription.getPackageName();     // Catch: Throwable -> L6 Exception -> L8
    L11:
        String pkgName = r0;
        if (pkgName != null) goto L17;
        Bundle monitoringExtras = addRestoreOperationTypeToEvent(null);     // Catch: Throwable -> L6 Exception -> L8
        this.mBackupManagerMonitorEventSender.monitorEvent(56, null, 1, monitoringExtras);     // Catch: Throwable -> L6 Exception -> L8
        Slog.e(BackupManagerService.TAG, "Failure getting next package name");     // Catch: Throwable -> L6 Exception -> L8
        EventLog.writeEvent(EventLogTags.RESTORE_TRANSPORT_FAILURE, new Object[0]);     // Catch: Throwable -> L6 Exception -> L8
        this.mStatus = -1000;     // Catch: Throwable -> L6 Exception -> L8
        UnifiedRestoreState nextState2 = UnifiedRestoreState.FINAL;     // Catch: Throwable -> L6 Exception -> L8
        executeNextState(nextState2);
        return;
    L17:
        if (this.mRestoreDescription != RestoreDescription.NO_MORE_PACKAGES) goto L21;
        Slog.d(BackupManagerService.TAG, "No more packages; finishing restore");     // Catch: Throwable -> L6 Exception -> L8
        int millis = (int) (SystemClock.elapsedRealtime() - this.mStartRealtime);     // Catch: Throwable -> L6 Exception -> L8
        EventLog.writeEvent(EventLogTags.RESTORE_SUCCESS, new Object[]{Integer.valueOf(this.mRestoreAttemptedAppsCount), Integer.valueOf(millis)});     // Catch: Throwable -> L6 Exception -> L8
        UnifiedRestoreState nextState3 = UnifiedRestoreState.FINAL;     // Catch: Throwable -> L6 Exception -> L8
        executeNextState(nextState3);
        return;
    L21:
        Slog.i(BackupManagerService.TAG, "Next restore package: " + this.mRestoreDescription);     // Catch: Throwable -> L6 Exception -> L8
        this.mRestoreAttemptedAppsCount = this.mRestoreAttemptedAppsCount + 1;     // Catch: Throwable -> L6 Exception -> L8
        sendOnRestorePackage(this.mRestoreAttemptedAppsCount, pkgName);     // Catch: Throwable -> L6 Exception -> L8
        PackageManagerBackupAgent.Metadata metaInfo = this.mPmAgent.getRestoredMetadata(pkgName);     // Catch: Throwable -> L6 Exception -> L8
        if (metaInfo != null) goto L69;
        PackageInfo pkgInfo = new PackageInfo();     // Catch: Throwable -> L6 Exception -> L8
        pkgInfo.packageName = pkgName;     // Catch: Throwable -> L6 Exception -> L8
        Bundle monitoringExtras2 = addRestoreOperationTypeToEvent(null);     // Catch: Throwable -> L6 Exception -> L8
        this.mBackupManagerMonitorEventSender.monitorEvent(24, pkgInfo, 3, monitoringExtras2);     // Catch: Throwable -> L6 Exception -> L8
        Slog.e(BackupManagerService.TAG, "No metadata for " + pkgName);     // Catch: Throwable -> L6 Exception -> L8
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{pkgName, "Package metadata missing"});     // Catch: Throwable -> L6 Exception -> L8
        UnifiedRestoreState nextState4 = UnifiedRestoreState.RUNNING_QUEUE;     // Catch: Throwable -> L6 Exception -> L8
        executeNextState(nextState4);
        return;
    L69:
        this.mCurrentPackage = this.backupManagerService.getPackageManager().getPackageInfoAsUser(pkgName, 134217728, this.mUserId);     // Catch: Throwable -> L6 Exception -> L8 PackageManager.NameNotFoundException -> L57
        Bundle monitoringExtras3 = addRestoreOperationTypeToEvent(null);     // Catch: Throwable -> L6 Exception -> L8 PackageManager.NameNotFoundException -> L57
        this.mBackupManagerMonitorEventSender.monitorEvent(67, this.mCurrentPackage, 3, monitoringExtras3);     // Catch: Throwable -> L6 Exception -> L8 PackageManager.NameNotFoundException -> L57
        if (metaInfo.versionCode > this.mCurrentPackage.getLongVersionCode()) goto L30;
    L48:
        this.mWidgetData = null;     // Catch: Throwable -> L6 Exception -> L8
        int type = this.mRestoreDescription.getDataType();     // Catch: Throwable -> L6 Exception -> L8
        if (type != 1) goto L52;
        UnifiedRestoreState nextState5 = UnifiedRestoreState.RESTORE_KEYVALUE;     // Catch: Throwable -> L6 Exception -> L8
    L56:
        executeNextState(nextState5);
        return;
    L52:
        if (type != 2) goto L54;
        nextState5 = UnifiedRestoreState.RESTORE_FULL;     // Catch: Throwable -> L6 Exception -> L8
        goto L56
    L54:
        Slog.e(BackupManagerService.TAG, "Unrecognized restore type " + type);     // Catch: Throwable -> L6 Exception -> L8
        Bundle monitoringExtras4 = addRestoreOperationTypeToEvent(null);     // Catch: Throwable -> L6 Exception -> L8
        this.mBackupManagerMonitorEventSender.monitorEvent(57, this.mCurrentPackage, 3, monitoringExtras4);     // Catch: Throwable -> L6 Exception -> L8
        nextState5 = UnifiedRestoreState.RUNNING_QUEUE;     // Catch: Throwable -> L6 Exception -> L8
        goto L56
    L30:
        if (this.mIsSystemRestore == false) goto L43;
        if (isVToUDowngrade(this.mPmAgent.getSourceSdk(), Build.VERSION.SDK_INT) == false) goto L43;
        if (this.mAreVToUListsSet.booleanValue() == true) goto L37;
        this.mVToUAllowlist = createVToUList(Settings.Secure.getStringForUser(this.backupManagerService.getContext().getContentResolver(), "v_to_u_restore_allowlist", this.mUserId));     // Catch: Throwable -> L6 Exception -> L8
        this.mVToUDenylist = createVToUList(Settings.Secure.getStringForUser(this.backupManagerService.getContext().getContentResolver(), "v_to_u_restore_denylist", this.mUserId));     // Catch: Throwable -> L6 Exception -> L8
        logVToUListsToBMM();     // Catch: Throwable -> L6 Exception -> L8
        this.mAreVToUListsSet = true;     // Catch: Throwable -> L6 Exception -> L8
    L37:
        if (isPackageEligibleForVToURestore(this.mCurrentPackage) == false) goto L39;
        this.mBackupManagerMonitorEventSender.monitorEvent(70, this.mCurrentPackage, 3, addRestoreOperationTypeToEvent(null));     // Catch: Throwable -> L6 Exception -> L8
        Slog.i(BackupManagerService.TAG, "Package " + pkgName + " is eligible for V to U downgrade scenario");     // Catch: Throwable -> L6 Exception -> L8
        goto L48
    L39:
        this.mBackupManagerMonitorEventSender.monitorEvent(71, this.mCurrentPackage, 3, addRestoreOperationTypeToEvent(null));     // Catch: Throwable -> L6 Exception -> L8
        Slog.i(BackupManagerService.TAG, pkgName + " : Package not eligible for V to U downgrade scenario");     // Catch: Throwable -> L6 Exception -> L8
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{pkgName, "Package not eligible for V to U downgrade scenario"});     // Catch: Throwable -> L6 Exception -> L8
        UnifiedRestoreState nextState6 = UnifiedRestoreState.RUNNING_QUEUE;     // Catch: Throwable -> L6 Exception -> L8
        executeNextState(nextState6);
        return;
    L43:
        if ((this.mCurrentPackage.applicationInfo.flags & 131072) != 0) goto L47;
        logDowngradeScenario(false, metaInfo);     // Catch: Throwable -> L6 Exception -> L8
        UnifiedRestoreState nextState7 = UnifiedRestoreState.RUNNING_QUEUE;     // Catch: Throwable -> L6 Exception -> L8
        executeNextState(nextState7);
        return;
    L47:
        logDowngradeScenario(true, metaInfo);     // Catch: Throwable -> L6 Exception -> L8
    L58:
        Slog.e(BackupManagerService.TAG, "Package not present: " + pkgName);     // Catch: Throwable -> L6 Exception -> L8
        Bundle monitoringExtras5 = addRestoreOperationTypeToEvent(null);     // Catch: Throwable -> L6 Exception -> L8
        this.mBackupManagerMonitorEventSender.monitorEvent(26, createPackageInfoForBMMLogging(pkgName), 3, monitoringExtras5);     // Catch: Throwable -> L6 Exception -> L8
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{pkgName, "Package missing on device"});     // Catch: Throwable -> L6 Exception -> L8
        UnifiedRestoreState nextState8 = UnifiedRestoreState.RUNNING_QUEUE;     // Catch: Throwable -> L6 Exception -> L8
        executeNextState(nextState8);
        return;
    L10:
        r0 = null;
    L8:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Can't get next restore target from transport; halting: " + e.getMessage());     // Catch: Throwable -> L6
        Bundle monitoringExtras6 = addRestoreOperationTypeToEvent(null);     // Catch: Throwable -> L6
        this.mBackupManagerMonitorEventSender.monitorEvent(60, null, 3, monitoringExtras6);     // Catch: Throwable -> L6
        EventLog.writeEvent(EventLogTags.RESTORE_TRANSPORT_FAILURE, new Object[0]);     // Catch: Throwable -> L6
        this.mStatus = -1000;     // Catch: Throwable -> L6
        nextState5 = UnifiedRestoreState.FINAL;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        executeNextState(nextState);
        throw th;
    }

    private void restoreKeyValue() {
        String packageName = this.mCurrentPackage.packageName;
        this.mBackupManagerMonitorEventSender.monitorEvent(58, this.mCurrentPackage, 3, addRestoreOperationTypeToEvent(null));
        if (this.mCurrentPackage.applicationInfo.backupAgentName != null) goto L5;
    L21:
        Bundle monitoringExtras = addRestoreOperationTypeToEvent(null);
        this.mBackupManagerMonitorEventSender.monitorEvent(28, this.mCurrentPackage, 2, monitoringExtras);
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{packageName, "Package has no agent"});
        executeNextState(UnifiedRestoreState.RUNNING_QUEUE);
        return;
    L5:
        if ("".equals(this.mCurrentPackage.applicationInfo.backupAgentName) == true) goto L21;
        PackageManagerBackupAgent.Metadata metaInfo = this.mPmAgent.getRestoredMetadata(packageName);
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (BackupUtils.signaturesMatch(metaInfo.sigHashes, this.mCurrentPackage, pmi) == true) goto L11;
        Slog.w(BackupManagerService.TAG, "Signature mismatch restoring " + packageName);
        Bundle monitoringExtras2 = addRestoreOperationTypeToEvent(null);
        this.mBackupManagerMonitorEventSender.monitorEvent(29, this.mCurrentPackage, 3, monitoringExtras2);
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{packageName, "Signature mismatch"});
        executeNextState(UnifiedRestoreState.RUNNING_QUEUE);
        return;
    L11:
        this.mAgent = this.backupManagerService.getBackupAgentConnectionManager().bindToAgentSynchronous(this.mCurrentPackage.applicationInfo, 2, this.mBackupEligibilityRules.getBackupDestination());
        if (this.mAgent != null) goto L15;
        Slog.w(BackupManagerService.TAG, "Can't find backup agent for " + packageName);
        Bundle monitoringExtras3 = addRestoreOperationTypeToEvent(null);
        this.mBackupManagerMonitorEventSender.monitorEvent(30, this.mCurrentPackage, 3, monitoringExtras3);
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{packageName, "Restore agent missing"});
        executeNextState(UnifiedRestoreState.RUNNING_QUEUE);
        return;
    L15:
        this.mDidLaunch = true;
        initiateOneRestore(this.mCurrentPackage, metaInfo.versionCode);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Error when attempting restore: " + e.toString());
        Bundle monitoringExtras4 = addRestoreOperationTypeToEvent(null);
        this.mBackupManagerMonitorEventSender.monitorEvent(61, this.mCurrentPackage, 2, monitoringExtras4);
        keyValueAgentErrorCleanup(false);
        executeNextState(UnifiedRestoreState.RUNNING_QUEUE);
    }

    private void initiateOneRestore(PackageInfo app, long appVersionCode) {
        String packageName = app.packageName;
        Slog.d(BackupManagerService.TAG, "initiateOneRestore packageName=" + packageName);
        this.mBackupDataName = new File(this.backupManagerService.getDataDir(), packageName + ".restore");
        this.mStageName = new File(this.backupManagerService.getDataDir(), packageName + ".stage");
        this.mNewStateName = new File(this.mStateDir, packageName + KeyValueBackupTask.NEW_STATE_FILE_SUFFIX);
        boolean staging = shouldStageBackupData(packageName);
        if (staging == false) goto L5;
        File r0 = this.mStageName;
    L6:
        File downloadFile = r0;
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("PerformUnifiedRestoreTask.initiateOneRestore()");     // Catch: Exception -> L12
        ParcelFileDescriptor stage = ParcelFileDescriptor.open(downloadFile, 1006632960);     // Catch: Exception -> L12
        if (transport.getRestoreData(stage) == 0) goto L18;
        Slog.e(BackupManagerService.TAG, "Error getting restore data for " + packageName);     // Catch: Exception -> L12
        Bundle monitoringExtras = addRestoreOperationTypeToEvent(null);     // Catch: Exception -> L12
        this.mBackupManagerMonitorEventSender.monitorEvent(63, this.mCurrentPackage, 1, monitoringExtras);     // Catch: Exception -> L12
        EventLog.writeEvent(EventLogTags.RESTORE_TRANSPORT_FAILURE, new Object[0]);     // Catch: Exception -> L12
        stage.close();     // Catch: Exception -> L12
        downloadFile.delete();     // Catch: Exception -> L12
        if (BackupAndRestoreFeatureFlags.getUnifiedRestoreContinueAfterTransportFailureInKvRestore() == false) goto L14;
        UnifiedRestoreState nextState = UnifiedRestoreState.RUNNING_QUEUE;     // Catch: Exception -> L12
    L15:
        executeNextState(nextState);     // Catch: Exception -> L12
        return;
    L14:
        nextState = UnifiedRestoreState.FINAL;     // Catch: Exception -> L12
        goto L15
    L18:
        if (staging == false) goto L20;
        stage.close();     // Catch: Exception -> L12
        ParcelFileDescriptor stage2 = ParcelFileDescriptor.open(downloadFile, 268435456);     // Catch: Exception -> L12
        this.mBackupData = ParcelFileDescriptor.open(this.mBackupDataName, 1006632960);     // Catch: Exception -> L12
        BackupDataInput in = new BackupDataInput(stage2.getFileDescriptor());     // Catch: Exception -> L12
        BackupDataOutput out = new BackupDataOutput(this.mBackupData.getFileDescriptor());     // Catch: Exception -> L12
        filterExcludedKeys(packageName, in, out);     // Catch: Exception -> L12
        this.mBackupData.close();     // Catch: Exception -> L12
        ParcelFileDescriptor stage3 = stage2;
    L21:
        stage3.close();     // Catch: Exception -> L12
        this.mBackupData = ParcelFileDescriptor.open(this.mBackupDataName, 268435456);     // Catch: Exception -> L12
        this.mNewState = ParcelFileDescriptor.open(this.mNewStateName, 1006632960);     // Catch: Exception -> L12
        long restoreAgentTimeoutMillis = this.mAgentTimeoutParameters.getRestoreAgentTimeoutMillis(app.applicationInfo.uid);     // Catch: Exception -> L12
        this.backupManagerService.prepareOperationTimeout(this.mEphemeralOpToken, restoreAgentTimeoutMillis, this, 1);     // Catch: Exception -> L12
        this.mAgent.doRestoreWithExcludedKeys(this.mBackupData, appVersionCode, this.mNewState, this.mEphemeralOpToken, this.backupManagerService.getBackupManagerBinder(), new ArrayList(getExcludedKeysForPackage(packageName)));     // Catch: Exception -> L12
        return;
    L20:
        stage3 = stage;
    L12:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Unable to call app for restore: " + packageName, e);
        Bundle monitoringExtras2 = addRestoreOperationTypeToEvent(null);
        this.mBackupManagerMonitorEventSender.monitorEvent(61, this.mCurrentPackage, 2, monitoringExtras2);
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{packageName, e.toString()});
        keyValueAgentErrorCleanup(false);
        executeNextState(UnifiedRestoreState.RUNNING_QUEUE);
        return;
    L5:
        r0 = this.mBackupDataName;
        goto L6
    }

    boolean shouldStageBackupData(String packageName) {
        if (packageName.equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == true) goto L5;
    L8:
        return true;
    L5:
        if (getExcludedKeysForPackage(PackageManagerService.PLATFORM_PACKAGE_NAME).isEmpty() == false) goto L8;
        return false;
    }

    Set<String> getExcludedKeysForPackage(String packageName) {
        return this.backupManagerService.getExcludedRestoreKeys(packageName);
    }

    void filterExcludedKeys(String packageName, BackupDataInput in, BackupDataOutput out) throws Exception {
        Set<String> excludedKeysForPackage = getExcludedKeysForPackage(packageName);
        byte[] buffer = new byte[65536];
    L4:
        if (in.readNextHeader() == false) goto L18;
        String key = in.getKey();
        int size = in.getDataSize();
        if (excludedKeysForPackage == null) goto L11;
        if (excludedKeysForPackage.contains(key) == false) goto L11;
        Slog.i(BackupManagerService.TAG, "Skipping blocked key " + key);
        in.skipEntityData();
    L11:
        if (key.equals(UserBackupManagerService.KEY_WIDGET_STATE) == true) goto L12;
        if (size <= buffer.length) goto L16;
        buffer = new byte[size];
    L16:
        in.readEntityData(buffer, 0, size);
        out.writeEntityHeader(key, size);
        out.writeEntityData(buffer, size);
        goto L4
    L12:
        Slog.i(BackupManagerService.TAG, "Restoring widget state for " + packageName);
        this.mWidgetData = new byte[size];
        in.readEntityData(this.mWidgetData, 0, size);
        goto L4
    }

    private void restoreFull() {
        this.mBackupManagerMonitorEventSender.monitorEvent(59, this.mCurrentPackage, 3, addRestoreOperationTypeToEvent(null));
        StreamFeederThread feeder = new StreamFeederThread(this);     // Catch: IOException -> L5
        new Thread(feeder, "unified-stream-feeder").start();     // Catch: IOException -> L5
        return;
    L6:
        Slog.e(BackupManagerService.TAG, "Unable to construct pipes for stream restore!");
        Bundle monitoringExtras = addRestoreOperationTypeToEvent(null);
        this.mBackupManagerMonitorEventSender.monitorEvent(64, this.mCurrentPackage, 3, monitoringExtras);
        executeNextState(UnifiedRestoreState.RUNNING_QUEUE);
    }

    private void restoreFinished() {
        Slog.d(BackupManagerService.TAG, "restoreFinished packageName=" + this.mCurrentPackage.packageName);
        long restoreAgentFinishedTimeoutMillis = this.mAgentTimeoutParameters.getRestoreAgentFinishedTimeoutMillis();     // Catch: Exception -> L9
        PerformUnifiedRestoreTask r8 = this;
        this.backupManagerService.prepareOperationTimeout(this.mEphemeralOpToken, restoreAgentFinishedTimeoutMillis, r8, 1);     // Catch: Exception -> L7
        r8.mAgent.doRestoreFinished(r8.mEphemeralOpToken, r8.backupManagerService.getBackupManagerBinder());     // Catch: Exception -> L7
        return;
    L7:
        e = e;
    L11:
        String packageName = r8.mCurrentPackage.packageName;
        Slog.e(BackupManagerService.TAG, "Unable to finalize restore of " + packageName);
        Bundle monitoringExtras = addRestoreOperationTypeToEvent(null);
        r8.mBackupManagerMonitorEventSender.monitorEvent(69, r8.mCurrentPackage, 2, monitoringExtras);
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{packageName, e.toString()});
        keyValueAgentErrorCleanup(true);
        executeNextState(UnifiedRestoreState.RUNNING_QUEUE);
        return;
    L9:
        e = e;
        r8 = this;
        goto L11
    }

    private void finalizeRestore() {
        BackupTransportClient transport = this.mTransportConnection.connectOrThrow("PerformUnifiedRestoreTask.finalizeRestore()");     // Catch: Exception -> L5
        transport.finishRestore();     // Catch: Exception -> L5
    L7:
        sendEndRestore();
        this.backupManagerService.getBackupHandler().removeMessages(8);
        this.backupManagerService.getBackupAgentConnectionManager().clearNoRestrictedModePackages();
        if (this.mPmToken > 0) goto L35;
        long restoreAgentTimeoutMillis = this.mAgentTimeoutParameters.getRestoreSessionTimeoutMillis();
        this.backupManagerService.getBackupHandler().sendEmptyMessageDelayed(8, restoreAgentTimeoutMillis);
    L15:
        if (this.mIsSystemRestore == false) goto L18;
        AppWidgetBackupBridge.systemRestoreFinished(this.mUserId);
    L18:
        if (this.mIsSystemRestore == true) goto L20;
    L22:
        Queue<PerformUnifiedRestoreTask> r1 = this.backupManagerService.getPendingRestores();
        monitor-enter(r1);
    L27:
        th = move-exception;
        throw th;
    L25:
        if (this.backupManagerService.getPendingRestores().size() <= 0) goto L29;
        Slog.d(BackupManagerService.TAG, "Starting next pending restore.");     // Catch: Throwable -> L27
        PerformUnifiedRestoreTask task = this.backupManagerService.getPendingRestores().remove();     // Catch: Throwable -> L27
        this.backupManagerService.getBackupHandler().sendMessage(this.backupManagerService.getBackupHandler().obtainMessage(20, task));     // Catch: Throwable -> L27
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L27
        Slog.i(BackupManagerService.TAG, "Restore complete.");
        Bundle monitoringExtras = addRestoreOperationTypeToEvent(null);
        this.mBackupManagerMonitorEventSender.monitorEvent(68, null, 3, monitoringExtras);
        this.mListener.onFinished("PerformUnifiedRestoreTask.finalizeRestore()");
        return;
    L29:
        this.backupManagerService.setRestoreInProgress(false);     // Catch: Throwable -> L27
        goto L30
    L20:
        if (this.mPmAgent == null) goto L22;
        this.backupManagerService.setAncestralPackages(this.mPmAgent.getRestoredPackages());
        this.backupManagerService.setAncestralToken(this.mToken);
        this.backupManagerService.setAncestralBackupDestination(this.mBackupEligibilityRules.getBackupDestination());
        this.backupManagerService.writeRestoreTokens();
        goto L22
    L35:
        this.backupManagerService.getPackageManagerBinder().finishPackageInstall(this.mPmToken, this.mDidLaunch);     // Catch: RemoteException -> L11
    L5:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Error finishing restore", e);
        goto L7
    }

    void keyValueAgentErrorCleanup(boolean clearAppData) {
        if (clearAppData == false) goto L4;
        this.backupManagerService.clearApplicationDataAfterRestoreFailure(this.mCurrentPackage.packageName);
    L4:
        keyValueAgentCleanup();
    }

    void keyValueAgentCleanup() {
        this.mBackupDataName.delete();
        this.mStageName.delete();
        if (this.mBackupData == null) goto L28;
        this.mBackupData.close();     // Catch: IOException -> L7
    L28:
        if (this.mNewState == null) goto L17;
        this.mNewState.close();     // Catch: IOException -> L14
    L17:
        this.mNewState = null;
        this.mBackupData = null;
        this.mNewStateName.delete();
        if (this.mCurrentPackage.applicationInfo == null) goto L24;
        BackupAgentConnectionManager r0 = this.backupManagerService.getBackupAgentConnectionManager();
        ApplicationInfo r1 = this.mCurrentPackage.applicationInfo;
        if (this.mTargetPackage != null) goto L22;
        boolean r2 = true;
    L23:
        r0.unbindAgent(r1, r2);
        goto L24
    L22:
        r2 = false;
    L24:
        this.backupManagerService.getBackupHandler().removeMessages(18, this);
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void operationComplete(long unusedResult) {
        this.mOperationStorage.removeOperation(this.mEphemeralOpToken);
        switch(AnonymousClass1.$SwitchMap$com$android$server$backup$restore$UnifiedRestoreState[this.mState.ordinal()]) {
            case 1: goto L10;
            case 2: goto L4;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L5;
            default: goto L4;
        };
    L4:
        Slog.e(BackupManagerService.TAG, "Unexpected restore callback into state " + this.mState);
        keyValueAgentErrorCleanup(true);
        UnifiedRestoreState nextState = UnifiedRestoreState.FINAL;
    L11:
        executeNextState(nextState);
        return;
    L5:
        int size = (int) this.mBackupDataName.length();
        Bundle monitoringExtras = addRestoreOperationTypeToEvent(null);
        this.mBackupManagerMonitorEventSender.monitorEvent(62, this.mCurrentPackage, 3, monitoringExtras);
        EventLog.writeEvent(EventLogTags.RESTORE_PACKAGE, new Object[]{this.mCurrentPackage.packageName, Integer.valueOf(size)});
        this.mBackupManagerMonitorEventSender.monitorAgentLoggingResults(this.mCurrentPackage, this.mAgent);
        keyValueAgentCleanup();
        if (this.mWidgetData == null) goto L8;
        this.backupManagerService.restoreWidgetData(this.mCurrentPackage.packageName, this.mWidgetData);
    L8:
        UnifiedRestoreState nextState2 = UnifiedRestoreState.RUNNING_QUEUE;
        nextState = nextState2;
        goto L11
    L9:
        nextState = UnifiedRestoreState.RESTORE_FINISHED;
        goto L11
    L10:
        nextState = UnifiedRestoreState.RUNNING_QUEUE;
        goto L11
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void handleCancel(int cancellationReason) {
        this.mOperationStorage.removeOperation(this.mEphemeralOpToken);
        Slog.e(BackupManagerService.TAG, "Timeout restoring application " + this.mCurrentPackage.packageName);
        Bundle monitoringExtras = addRestoreOperationTypeToEvent(null);
        this.mBackupManagerMonitorEventSender.monitorEvent(31, this.mCurrentPackage, 2, monitoringExtras);
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{this.mCurrentPackage.packageName, "restore timeout"});
        keyValueAgentErrorCleanup(true);
        executeNextState(UnifiedRestoreState.RUNNING_QUEUE);
    }

    void executeNextState(UnifiedRestoreState nextState) {
        this.mState = nextState;
        Message msg = this.backupManagerService.getBackupHandler().obtainMessage(20, this);
        this.backupManagerService.getBackupHandler().sendMessage(msg);
    }

    UnifiedRestoreState getCurrentUnifiedRestoreStateForTesting() {
        return this.mState;
    }

    void setCurrentUnifiedRestoreStateForTesting(UnifiedRestoreState state) {
        this.mState = state;
    }

    void setStateDirForTesting(File stateDir) {
        this.mStateDir = stateDir;
    }

    void initiateOneRestoreForTesting(PackageInfo app, long appVersionCode) {
        initiateOneRestore(app, appVersionCode);
    }

    void sendStartRestore(int numPackages) {
        if (this.mObserver == null) goto L11;
        this.mObserver.restoreStarting(numPackages);     // Catch: RemoteException -> L6
        return;
    L7:
        Slog.w(BackupManagerService.TAG, "Restore observer went away: startRestore");
        this.mObserver = null;
        return;
    }

    void sendOnRestorePackage(int index, String name) {
        if (this.mObserver == null) goto L11;
        this.mObserver.onUpdate(index, name);     // Catch: RemoteException -> L6
        return;
    L7:
        Slog.d(BackupManagerService.TAG, "Restore observer died in onUpdate");
        this.mObserver = null;
        return;
    }

    void sendEndRestore() {
        if (this.mObserver == null) goto L11;
        this.mObserver.restoreFinished(this.mStatus);     // Catch: RemoteException -> L6
        return;
    L7:
        Slog.w(BackupManagerService.TAG, "Restore observer went away: endRestore");
        this.mObserver = null;
        return;
    }

    private Bundle addRestoreOperationTypeToEvent(Bundle extras) {
        return BackupManagerMonitorEventSender.putMonitoringExtra(extras, "android.app.backup.extra.OPERATION_TYPE", 1);
    }

    protected boolean isVToUDowngrade(int sourceSdk, int targetSdk) {
        return false;
    }

    protected List<String> createVToUList(String listString) {
        List<String> list = new ArrayList();
        if (listString == null) goto L6;
        List<String> list2 = Arrays.asList(listString.split(","));
        return list2;
    L6:
        return list;
    }

    protected boolean isPackageEligibleForVToURestore(PackageInfo mCurrentPackage) {
        if (this.mVToUDenylist.contains(mCurrentPackage.packageName) == false) goto L7;
        Slog.i(BackupManagerService.TAG, mCurrentPackage.packageName + " : Package is in V to U denylist");
        return false;
    L7:
        if ((mCurrentPackage.applicationInfo.flags & 131072) != 0) goto L10;
        Slog.i(BackupManagerService.TAG, mCurrentPackage.packageName + " : Package has restoreAnyVersion=false and is in V to U allowlist");
        return this.mVToUAllowlist.contains(mCurrentPackage.packageName);
    L10:
        Slog.i(BackupManagerService.TAG, mCurrentPackage.packageName + " : Package has restoreAnyVersion=true and is not in V to U denylist");
        return true;
    }

    private void logDowngradeScenario(boolean isRestoreAnyVersion, PackageManagerBackupAgent.Metadata metaInfo) {
        Bundle monitoringExtras = BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_RESTORE_VERSION", metaInfo.versionCode);
        if (isRestoreAnyVersion == false) goto L5;
        Bundle monitoringExtras2 = BackupManagerMonitorEventSender.putMonitoringExtra(monitoringExtras, "android.app.backup.extra.LOG_RESTORE_ANYWAY", true);
        String message = "Source version " + metaInfo.versionCode + " > installed version " + this.mCurrentPackage.getLongVersionCode() + " but restoreAnyVersion";
    L6:
        Slog.i(BackupManagerService.TAG, "Package " + this.mCurrentPackage.packageName + ": " + message);
        this.mBackupManagerMonitorEventSender.monitorEvent(27, this.mCurrentPackage, 3, addRestoreOperationTypeToEvent(monitoringExtras2));
        return;
    L5:
        monitoringExtras2 = BackupManagerMonitorEventSender.putMonitoringExtra(monitoringExtras, "android.app.backup.extra.LOG_RESTORE_ANYWAY", false);
        message = "Source version " + metaInfo.versionCode + " > installed version " + this.mCurrentPackage.getLongVersionCode();
        EventLog.writeEvent(EventLogTags.RESTORE_AGENT_FAILURE, new Object[]{this.mCurrentPackage.packageName, message});
        goto L6
    }

    private void logVToUListsToBMM() {
        Bundle monitoringExtrasAllowlist = BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.V_TO_U_ALLOWLIST", this.mVToUAllowlist.toString());
        Bundle monitoringExtrasAllowlist2 = addRestoreOperationTypeToEvent(monitoringExtrasAllowlist);
        this.mBackupManagerMonitorEventSender.monitorEvent(72, null, 3, monitoringExtrasAllowlist2);
        Bundle monitoringExtrasDenylist = BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.V_TO_U_DENYLIST", this.mVToUDenylist.toString());
        Bundle monitoringExtrasDenylist2 = addRestoreOperationTypeToEvent(monitoringExtrasDenylist);
        this.mBackupManagerMonitorEventSender.monitorEvent(72, null, 3, monitoringExtrasDenylist2);
    }

    private PackageInfo createPackageInfoForBMMLogging(String packageName) {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = packageName;
        return packageInfo;
    }

    void setNoRestrictedModePackages(BackupTransportClient transport, PackageInfo[] packages) {
        Set<String> packageNames = new ArraySet();     // Catch: RemoteException -> L6
        int i = 0;
    L4:
        if (i >= packages.length) goto L8;
        packageNames.add(packages[i].packageName);     // Catch: RemoteException -> L6
        i = i + 1;     // Catch: RemoteException -> L6
        goto L4
    L8:
        Set<String> packageNames2 = transport.getPackagesThatShouldNotUseRestrictedMode(packageNames, 1);     // Catch: RemoteException -> L6
        this.backupManagerService.getBackupAgentConnectionManager().setNoRestrictedModePackages(packageNames2, 1);     // Catch: RemoteException -> L6
        return;
    L10:
        Slog.i(BackupManagerService.TAG, "Failed to retrieve restricted mode packages from transport");
    }
}
