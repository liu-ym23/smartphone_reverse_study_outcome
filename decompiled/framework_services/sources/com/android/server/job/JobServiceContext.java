package com.android.server.job;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.Notification;
import android.app.compat.CompatChanges;
import android.app.job.IJobCallback;
import android.app.job.IJobService;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.PermissionChecker;
import android.content.ServiceConnection;
import android.net.Network;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.util.EventLog;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import android.util.Slog;
import android.util.TimeUtils;
import com.android.internal.app.IBatteryStats;
import com.android.internal.os.TimeoutRecord;
import com.android.internal.util.FrameworkStatsLog;
import com.android.modules.expresslog.Counter;
import com.android.modules.expresslog.Histogram;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.job.controllers.JobStatus;
import com.android.server.slice.SliceClientPermissions;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class JobServiceContext implements ServiceConnection {
    private static final long ANR_PRE_UDC_APIS_ON_SLOW_RESPONSES = 258236856;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_STANDBY = false;
    private static final long EXECUTION_DURATION_STAMP_PERIOD_MILLIS = 300000;
    private static final int MSG_TIMEOUT = 0;
    private static final long NOTIFICATION_TIMEOUT_MILLIS = 0;
    public static final int NO_PREFERRED_UID = -1;
    private static final long OP_BIND_TIMEOUT_MILLIS = 0;
    private static final long OP_TIMEOUT_MILLIS = 0;
    private static final String TAG = "JobServiceContext";
    private static final String TRACE_ABANDONED_JOB = "abandonedJob:";
    private static final String TRACE_ABANDONED_JOB_DELIMITER = "#";
    static final int VERB_BINDING = 0;
    static final int VERB_EXECUTING = 2;
    static final int VERB_FINISHED = 4;
    static final int VERB_STARTING = 1;
    static final int VERB_STOPPING = 3;
    private static final String[] VERB_STRINGS = null;
    private static final Histogram sEnqueuedJwiAtJobStart = null;
    private static final Histogram sTransferredNetworkDownloadKBHighWaterMarkLogger = null;
    private static final Histogram sTransferredNetworkUploadKBHighWaterMarkLogger = null;
    private static final Histogram sUpdatedEstimatedNetworkDownloadKBLogger = null;
    private static final Histogram sUpdatedEstimatedNetworkUploadKBLogger = null;
    private final ActivityManagerInternal mActivityManagerInternal;
    private boolean mAvailable;
    private boolean mAwaitingNotification;
    private final IBatteryStats mBatteryStats;
    private final Handler mCallbackHandler;
    private boolean mCancelled;
    private final JobCompletedListener mCompletedListener;
    private final Context mContext;
    private String mDeathMarkDebugReason;
    private int mDeathMarkInternalStopReason;
    private int mDeathMarkStopReason;
    private long mEstimatedDownloadBytes;
    private long mEstimatedUploadBytes;
    private long mExecutionStartTimeElapsed;
    private long mInitialDownloadedBytesFromCalling;
    private long mInitialDownloadedBytesFromSource;
    private long mInitialUploadedBytesFromCalling;
    private long mInitialUploadedBytesFromSource;
    private final JobConcurrencyManager mJobConcurrencyManager;
    private final JobPackageTracker mJobPackageTracker;
    private long mLastExecutionDurationStampTimeElapsed;
    private long mLastUnsuccessfulFinishElapsed;
    private final Object mLock;
    private long mMaxExecutionTimeMillis;
    private long mMinExecutionGuaranteeMillis;
    private final JobNotificationCoordinator mNotificationCoordinator;
    private JobParameters mParams;
    private String mPendingDebugStopReason;
    private int mPendingInternalStopReason;
    private Network mPendingNetworkChange;
    private int mPendingStopReason;
    private final PowerManager mPowerManager;
    private int mPreferredUid;
    private boolean mPreviousJobHadSuccessfulFinish;
    private JobCallback mRunningCallback;
    private JobStatus mRunningJob;
    private JobStatus mRunningJobSaved;
    private int mRunningJobWorkType;
    private final JobSchedulerService mService;
    public String mStoppedReason;
    public long mStoppedTime;
    private long mTimeoutElapsed;
    private long mTransferredDownloadBytes;
    private long mTransferredUploadBytes;
    private final UsageStatsManagerInternal mUsageStatsManagerInternal;
    int mVerb;
    private PowerManager.WakeLock mWakeLock;
    IJobService service;

    final class JobCallback extends IJobCallback.Stub {
        public String mStoppedReason;
        public long mStoppedTime;
        final /* synthetic */ JobServiceContext this$0;

        JobCallback(JobServiceContext this$0) {
            this.this$0 = this$0;
        }

        public void acknowledgeGetTransferredDownloadBytesMessage(int jobId, int workId, long transferredBytes) {
            JobServiceContext.m4865$$Nest$mdoAcknowledgeGetTransferredDownloadBytesMessage(this.this$0, this, jobId, workId, transferredBytes);
        }

        public void acknowledgeGetTransferredUploadBytesMessage(int jobId, int workId, long transferredBytes) {
            JobServiceContext.m4866$$Nest$mdoAcknowledgeGetTransferredUploadBytesMessage(this.this$0, this, jobId, workId, transferredBytes);
        }

        public void acknowledgeStartMessage(int jobId, boolean ongoing) {
            this.this$0.doAcknowledgeStartMessage(this, jobId, ongoing);
        }

        public void acknowledgeStopMessage(int jobId, boolean reschedule) {
            this.this$0.doAcknowledgeStopMessage(this, jobId, reschedule);
        }

        public JobWorkItem dequeueWork(int jobId) {
            return this.this$0.doDequeueWork(this, jobId);
        }

        public boolean completeWork(int jobId, int workId) {
            return this.this$0.doCompleteWork(this, jobId, workId);
        }

        public void jobFinished(int jobId, boolean reschedule) {
            this.this$0.doJobFinished(this, jobId, reschedule);
        }

        public void handleAbandonedJob(int jobId) {
            this.this$0.doHandleAbandonedJob(this, jobId);
        }

        public void updateEstimatedNetworkBytes(int jobId, JobWorkItem item, long downloadBytes, long uploadBytes) {
            JobServiceContext.m4868$$Nest$mdoUpdateEstimatedNetworkBytes(this.this$0, this, jobId, item, downloadBytes, uploadBytes);
        }

        public void updateTransferredNetworkBytes(int jobId, JobWorkItem item, long downloadBytes, long uploadBytes) {
            JobServiceContext.m4869$$Nest$mdoUpdateTransferredNetworkBytes(this.this$0, this, jobId, item, downloadBytes, uploadBytes);
        }

        public void setNotification(int jobId, int notificationId, Notification notification, int jobEndNotificationPolicy) {
            JobServiceContext.m4867$$Nest$mdoSetNotification(this.this$0, this, jobId, notificationId, notification, jobEndNotificationPolicy);
        }
    }

    private class JobServiceHandler extends Handler {
        final /* synthetic */ JobServiceContext this$0;

        JobServiceHandler(JobServiceContext r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch(message.what) {
                case 0: goto L5;
                default: goto L4;
            };
        L4:
            Slog.e(JobServiceContext.TAG, "Unrecognised message: " + message);
            return;
        L5:
            Object r0 = JobServiceContext.m4863$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L8:
            if (message.obj != JobServiceContext.m4864$$Nest$fgetmRunningCallback(this.this$0)) goto L12;
            this.this$0.handleOpTimeoutLocked();     // Catch: Throwable -> L10
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L12:
            JobCallback jc = (JobCallback) message.obj;     // Catch: Throwable -> L10
            StringBuilder sb = new StringBuilder(128);     // Catch: Throwable -> L10
            sb.append("Ignoring timeout of no longer active job");     // Catch: Throwable -> L10
            if (jc.mStoppedReason == null) goto L15;
            sb.append(", stopped ");     // Catch: Throwable -> L10
            TimeUtils.formatDuration(JobSchedulerService.sElapsedRealtimeClock.millis() - jc.mStoppedTime, sb);     // Catch: Throwable -> L10
            sb.append(" because: ");     // Catch: Throwable -> L10
            sb.append(jc.mStoppedReason);     // Catch: Throwable -> L10
        L15:
            Slog.w(JobServiceContext.TAG, sb.toString());     // Catch: Throwable -> L10
            goto L16
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m4863$$Nest$fgetmLock(JobServiceContext r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRunningCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ JobCallback m4864$$Nest$fgetmRunningCallback(JobServiceContext r0) {
        return r0.mRunningCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$mdoAcknowledgeGetTransferredDownloadBytesMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4865$$Nest$mdoAcknowledgeGetTransferredDownloadBytesMessage(JobServiceContext r0, JobCallback r1, int r2, int r3, long r4) {
        r0.doAcknowledgeGetTransferredDownloadBytesMessage(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mdoAcknowledgeGetTransferredUploadBytesMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4866$$Nest$mdoAcknowledgeGetTransferredUploadBytesMessage(JobServiceContext r0, JobCallback r1, int r2, int r3, long r4) {
        r0.doAcknowledgeGetTransferredUploadBytesMessage(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mdoSetNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4867$$Nest$mdoSetNotification(JobServiceContext r0, JobCallback r1, int r2, int r3, Notification r4, int r5) {
        r0.doSetNotification(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mdoUpdateEstimatedNetworkBytes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4868$$Nest$mdoUpdateEstimatedNetworkBytes(JobServiceContext r0, JobCallback r1, int r2, JobWorkItem r3, long r4, long r6) {
        r0.doUpdateEstimatedNetworkBytes(r1, r2, r3, r4, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mdoUpdateTransferredNetworkBytes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4869$$Nest$mdoUpdateTransferredNetworkBytes(JobServiceContext r0, JobCallback r1, int r2, JobWorkItem r3, long r4, long r6) {
        r0.doUpdateTransferredNetworkBytes(r1, r2, r3, r4, r6);
    }

    static {
        DEBUG = JobSchedulerService.DEBUG;
        DEBUG_STANDBY = JobSchedulerService.DEBUG_STANDBY;
        OP_BIND_TIMEOUT_MILLIS = Build.HW_TIMEOUT_MULTIPLIER * 18000;
        OP_TIMEOUT_MILLIS = Build.HW_TIMEOUT_MULTIPLIER * EventLogTags.JOB_DEFERRED_EXECUTION;
        NOTIFICATION_TIMEOUT_MILLIS = ((long) Build.HW_TIMEOUT_MULTIPLIER) * JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        sEnqueuedJwiAtJobStart = new Histogram("job_scheduler.value_hist_w_uid_enqueued_work_items_at_job_start", new Histogram.ScaledRangeOptions(20, 1, 3.0f, 1.4f));
        sTransferredNetworkDownloadKBHighWaterMarkLogger = new Histogram("job_scheduler.value_hist_transferred_network_download_kilobytes_high_water_mark", new Histogram.ScaledRangeOptions(50, 0, 32.0f, 1.31f));
        sTransferredNetworkUploadKBHighWaterMarkLogger = new Histogram("job_scheduler.value_hist_transferred_network_upload_kilobytes_high_water_mark", new Histogram.ScaledRangeOptions(50, 0, 32.0f, 1.31f));
        sUpdatedEstimatedNetworkDownloadKBLogger = new Histogram("job_scheduler.value_hist_updated_estimated_network_download_kilobytes", new Histogram.ScaledRangeOptions(50, 0, 32.0f, 1.31f));
        sUpdatedEstimatedNetworkUploadKBLogger = new Histogram("job_scheduler.value_hist_updated_estimated_network_upload_kilobytes", new Histogram.ScaledRangeOptions(50, 0, 32.0f, 1.31f));
        VERB_STRINGS = new String[]{"VERB_BINDING", "VERB_STARTING", "VERB_EXECUTING", "VERB_STOPPING", "VERB_FINISHED"};
    }

    JobServiceContext(JobSchedulerService service, JobConcurrencyManager concurrencyManager, JobNotificationCoordinator notificationCoordinator, IBatteryStats batteryStats, JobPackageTracker tracker, Looper looper) {
        this.mPendingStopReason = 0;
        this.mDeathMarkStopReason = 0;
        this.mContext = service.getContext();
        this.mLock = service.getLock();
        this.mService = service;
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mBatteryStats = batteryStats;
        this.mJobPackageTracker = tracker;
        this.mCallbackHandler = new JobServiceHandler(this, looper);
        this.mJobConcurrencyManager = concurrencyManager;
        this.mNotificationCoordinator = notificationCoordinator;
        this.mCompletedListener = service;
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        this.mUsageStatsManagerInternal = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        this.mAvailable = true;
        this.mVerb = 4;
        this.mPreferredUid = -1;
    }

    boolean executeRunnableJob(JobStatus job, int workType) {
        Object r3 = this.mLock;
        monitor-enter(r3);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAvailable == true) goto L11;
        Slog.e(TAG, "Starting new runnable but context is unavailable > Error.");     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return false;
    L11:
        this.mPreferredUid = -1;     // Catch: Throwable -> L9
        this.mRunningJob = job;     // Catch: Throwable -> L9
        this.mRunningJobSaved = job;     // Catch: Throwable -> L9
        this.mRunningJobWorkType = workType;     // Catch: Throwable -> L9
        this.mRunningCallback = new JobCallback(this);     // Catch: Throwable -> L9
        this.mPendingNetworkChange = null;     // Catch: Throwable -> L9
        if (job.hasDeadlineConstraint() == true) goto L14;
    L16:
        boolean r0 = false;
    L17:
        boolean isDeadlineExpired = r0;
        if (job.changedUris == null) goto L20;
        Uri[] triggeredUris = new Uri[job.changedUris.size()];     // Catch: Throwable -> L9
        job.changedUris.toArray(triggeredUris);     // Catch: Throwable -> L9
        Uri[] triggeredUris2 = triggeredUris;
    L22:
        if (job.changedAuthorities == null) goto L24;
        String[] triggeredAuthorities = new String[job.changedAuthorities.size()];     // Catch: Throwable -> L9
        job.changedAuthorities.toArray(triggeredAuthorities);     // Catch: Throwable -> L9
        String[] triggeredAuthorities2 = triggeredAuthorities;
    L25:
        JobInfo ji = job.getJob();     // Catch: Throwable -> L9
        if (canGetNetworkInformation(job) == false) goto L28;
        Network passedNetwork = job.network;     // Catch: Throwable -> L9
    L29:
        this.mParams = new JobParameters(this.mRunningCallback, job.getNamespace(), job.getJobId(), ji.getExtras(), ji.getTransientExtras(), ji.getClipData(), ji.getClipGrantFlags(), isDeadlineExpired, job.shouldTreatAsExpeditedJob(), job.shouldTreatAsUserInitiatedJob(), triggeredUris2, triggeredAuthorities2, passedNetwork);     // Catch: Throwable -> L9
        this.mExecutionStartTimeElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L9
        this.mLastExecutionDurationStampTimeElapsed = this.mExecutionStartTimeElapsed;     // Catch: Throwable -> L9
        this.mMinExecutionGuaranteeMillis = this.mService.getMinJobExecutionGuaranteeMs(job);     // Catch: Throwable -> L9
        this.mMaxExecutionTimeMillis = Math.max(this.mService.getMaxJobExecutionTimeMs(job), this.mMinExecutionGuaranteeMillis);     // Catch: Throwable -> L9
        this.mEstimatedDownloadBytes = job.getEstimatedNetworkDownloadBytes();     // Catch: Throwable -> L9
        this.mEstimatedUploadBytes = job.getEstimatedNetworkUploadBytes();     // Catch: Throwable -> L9
        this.mTransferredUploadBytes = 0;     // Catch: Throwable -> L9
        this.mTransferredDownloadBytes = 0;     // Catch: Throwable -> L9
        this.mAwaitingNotification = job.isUserVisibleJob();     // Catch: Throwable -> L9
        long whenDeferred = job.getWhenStandbyDeferred();     // Catch: Throwable -> L9
        if (whenDeferred <= 0) goto L34;
        long deferral = this.mExecutionStartTimeElapsed - whenDeferred;     // Catch: Throwable -> L9
        EventLog.writeEvent(EventLogTags.JOB_DEFERRED_EXECUTION, deferral);     // Catch: Throwable -> L9
        if (DEBUG_STANDBY == false) goto L34;
        StringBuilder sb = new StringBuilder(128);     // Catch: Throwable -> L9
        sb.append("Starting job deferred for standby by ");     // Catch: Throwable -> L9
        TimeUtils.formatDuration(deferral, sb);     // Catch: Throwable -> L9
        sb.append(" ms : ");     // Catch: Throwable -> L9
        sb.append(job.toShortString());     // Catch: Throwable -> L9
        Slog.v(TAG, sb.toString());     // Catch: Throwable -> L9
    L34:
        job.clearPersistedUtcTimes();     // Catch: Throwable -> L9
        this.mWakeLock = this.mPowerManager.newWakeLock(1, job.getWakelockTag());     // Catch: Throwable -> L9
        this.mWakeLock.setWorkSource(this.mService.deriveWorkSource(job.getSourceUid(), job.getSourcePackageName()));     // Catch: Throwable -> L9
        this.mWakeLock.setReferenceCounted(false);     // Catch: Throwable -> L9
        this.mWakeLock.acquire();     // Catch: Throwable -> L9
        this.mVerb = 0;     // Catch: Throwable -> L9
        scheduleOpTimeOutLocked();     // Catch: Throwable -> L9
        Intent intent = new Intent().setComponent(job.getServiceComponent()).setFlags(4);     // Catch: Throwable -> L9
        intent.setAction("android.intent.action.JOB_SERVICE");     // Catch: Throwable -> L9
        boolean startedWithForegroundFlag = false;
    L44:
        e = move-exception;
        Slog.w(TAG, "Job service " + job.getServiceComponent().getShortClassName() + " cannot be executed: " + e.getMessage());     // Catch: Throwable -> L9
        boolean binding = false;
    L59:
        if (binding == false) goto L61;
        this.mJobPackageTracker.noteActive(job);     // Catch: Throwable -> L9
        int sourceUid = job.getSourceUid();     // Catch: Throwable -> L9
        this.mInitialDownloadedBytesFromSource = TrafficStats.getUidRxBytes(sourceUid);     // Catch: Throwable -> L9
        this.mInitialUploadedBytesFromSource = TrafficStats.getUidTxBytes(sourceUid);     // Catch: Throwable -> L9
        this.mInitialDownloadedBytesFromCalling = TrafficStats.getUidRxBytes(job.getUid());     // Catch: Throwable -> L9
        this.mInitialUploadedBytesFromCalling = TrafficStats.getUidTxBytes(job.getUid());     // Catch: Throwable -> L9
        int procState = this.mService.getUidProcState(job.getUid());     // Catch: Throwable -> L9
        if (procState <= 8) goto L69;
        int procState2 = this.mActivityManagerInternal.getUidProcessState(job.getUid());     // Catch: Throwable -> L9
    L71:
        if (job.isProxyJob() == false) goto L73;
        int[] r1 = {sourceUid, job.getUid()};     // Catch: Throwable -> L9
    L75:
        if (job.isProxyJob() == false) goto L77;
        String[] r14 = {null, job.getSourceTag()};     // Catch: Throwable -> L9
    L78:
        boolean startedWithForegroundFlag2 = startedWithForegroundFlag;
        int[] r9 = r1;
        FrameworkStatsLog.write(8, r9, r14, job.getBatteryName(), 1, -1, job.getStandbyBucket(), job.getLoggingJobId(), job.hasChargingConstraint(), job.hasBatteryNotLowConstraint(), job.hasStorageNotLowConstraint(), job.hasTimingDelayConstraint(), job.hasDeadlineConstraint(), job.hasIdleConstraint(), job.hasConnectivityConstraint(), job.hasContentTriggerConstraint(), job.isRequestedExpeditedJob(), job.shouldTreatAsExpeditedJob(), 0, job.getJob().isPrefetch(), job.getJob().getPriority(), job.getEffectivePriority(), job.getNumPreviousAttempts(), job.getJob().getMaxExecutionDelayMillis(), isDeadlineExpired, job.isConstraintSatisfied(1), job.isConstraintSatisfied(2), job.isConstraintSatisfied(8), job.isConstraintSatisfied(Integer.MIN_VALUE), job.isConstraintSatisfied(4), job.isConstraintSatisfied(268435456), job.isConstraintSatisfied(67108864), this.mExecutionStartTimeElapsed - job.enqueueTime, job.getJob().isUserInitiated(), job.shouldTreatAsUserInitiatedJob(), job.getJob().isPeriodic(), job.getJob().getMinLatencyMillis(), job.getEstimatedNetworkDownloadBytes(), job.getEstimatedNetworkUploadBytes(), job.getWorkCount(), ActivityManager.processStateAmToProto(procState2), job.getNamespaceHash(), 0, 0, 0, 0, job.getJob().getIntervalMillis(), job.getJob().getFlexMillis(), job.hasFlexibilityConstraint(), job.isConstraintSatisfied(2097152), job.canApplyTransportAffinities(), job.getNumAppliedFlexibleConstraints(), job.getNumDroppedFlexibleConstraints(), job.getFilteredTraceTag(), job.getFilteredDebugTags(), job.getNumAbandonedFailures(), job.getJob().getBackoffPolicy() + 1, this.mService.shouldUseAggressiveBackoff(job.getNumAbandonedFailures(), job.getSourceUid()));     // Catch: Throwable -> L9
        sEnqueuedJwiAtJobStart.logSampleWithUid(job.getUid(), job.getWorkCount());     // Catch: Throwable -> L9
        String sourcePackage = job.getSourcePackageName();     // Catch: Throwable -> L9
        if (Trace.isTagEnabled(524288) == false) goto L82;
        Trace.asyncTraceForTrackBegin(524288, "JobScheduler", job.computeSystemTraceTag(), getId());     // Catch: Throwable -> L9
    L82:
        if (job.getAppTraceTag() == null) goto L94;
        Trace.asyncTraceForTrackBegin(4096, "JobScheduler", job.getAppTraceTag(), job.getJobId());     // Catch: Throwable -> L9
    L94:
        this.mBatteryStats.noteJobStart(job.getBatteryName(), job.getSourceUid());     // Catch: Throwable -> L9 RemoteException -> L86
    L87:
        int jobUserId = job.getSourceUserId();     // Catch: Throwable -> L9
        this.mUsageStatsManagerInternal.setLastJobRunTime(sourcePackage, jobUserId, this.mExecutionStartTimeElapsed);     // Catch: Throwable -> L9
        this.mAvailable = false;     // Catch: Throwable -> L9
        this.mStoppedReason = null;     // Catch: Throwable -> L9
        this.mStoppedTime = 0;     // Catch: Throwable -> L9
        job.startedAsExpeditedJob = job.shouldTreatAsExpeditedJob();     // Catch: Throwable -> L9
        job.startedAsUserInitiatedJob = job.shouldTreatAsUserInitiatedJob();     // Catch: Throwable -> L9
        job.startedWithForegroundFlag = startedWithForegroundFlag2;     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return true;
    L77:
        r14 = new String[]{job.getSourceTag()};     // Catch: Throwable -> L9
        goto L78
    L73:
        r1 = new int[]{sourceUid};     // Catch: Throwable -> L9
        goto L75
    L69:
        procState2 = procState;
        goto L71
    L61:
        if (DEBUG == false) goto L63;
        Slog.d(TAG, job.getServiceComponent().getShortClassName() + " unavailable.");     // Catch: Throwable -> L9
    L63:
        this.mContext.unbindService(this);     // Catch: Throwable -> L9
        this.mRunningJob = null;     // Catch: Throwable -> L9
        this.mRunningJobWorkType = 0;     // Catch: Throwable -> L9
        this.mRunningCallback = null;     // Catch: Throwable -> L9
        this.mParams = null;     // Catch: Throwable -> L9
        this.mExecutionStartTimeElapsed = 0;     // Catch: Throwable -> L9
        this.mWakeLock.release();     // Catch: Throwable -> L9
        this.mVerb = 4;     // Catch: Throwable -> L9
        removeOpTimeOutLocked();     // Catch: Throwable -> L9
        this.mRunningJobSaved = null;     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return false;
    L37:
        if (job.shouldTreatAsUserInitiatedJob() == false) goto L47;
        if (job.isUserBgRestricted() == true) goto L47;
        long bindFlags = 32769 | 65536;     // Catch: Throwable -> L9 SecurityException -> L44
        if (job.hasConnectivityConstraint() == false) goto L43;
        bindFlags = bindFlags | 4295098368L;     // Catch: Throwable -> L9 SecurityException -> L44
    L43:
        startedWithForegroundFlag = true;
    L55:
        intent.getSmtEx().putSmtExtra("from_job", true);     // Catch: Throwable -> L9 SecurityException -> L44
        boolean binding2 = this.mContext.bindServiceAsUser(intent, this, Context.BindServiceFlags.of(bindFlags), UserHandle.of(job.getUserId()));     // Catch: Throwable -> L9 SecurityException -> L44
        binding = binding2;
        goto L59
    L47:
        if (job.shouldTreatAsExpeditedJob() == true) goto L52;
        if (job.shouldTreatAsUserInitiatedJob() == true) goto L52;
        bindFlags = 32769 | 260;     // Catch: Throwable -> L9 SecurityException -> L44
    L52:
        bindFlags = 32769 | 65540;     // Catch: Throwable -> L9 SecurityException -> L44
        if (job.hasConnectivityConstraint() == false) goto L55;
        bindFlags = bindFlags | 131072;     // Catch: Throwable -> L9 SecurityException -> L44
        goto L55
    L28:
        passedNetwork = null;
        goto L29
    L24:
        triggeredAuthorities2 = null;
        goto L25
    L20:
        triggeredUris2 = null;
        goto L22
    L14:
        if (job.getLatestRunTimeElapsed() >= JobSchedulerService.sElapsedRealtimeClock.millis()) goto L16;
        r0 = true;
        goto L17
    }

    private boolean canGetNetworkInformation(JobStatus job) {
        if (job.getJob().getRequiredNetwork() != null) goto L5;
        return false;
    L5:
        int uid = job.getUid();
        if (CompatChanges.isChangeEnabled(271850009, uid) == false) goto L10;
        String pkgName = job.getServiceComponent().getPackageName();
        if (hasPermissionForDelivery(uid, pkgName, "android.permission.ACCESS_NETWORK_STATE") == true) goto L12;
        return false;
    L12:
        return true;
    L10:
        return true;
    }

    private boolean hasPermissionForDelivery(int uid, String pkgName, String permission) {
        int result = PermissionChecker.checkPermissionForDataDelivery(this.mContext, permission, -1, uid, pkgName, null, "network info via JS");
        if (result != 0) goto L5;
        return true;
    L5:
        return false;
    }

    JobStatus getRunningJobLocked() {
        return this.mRunningJob;
    }

    void setRunningJobLockedForTest(JobStatus job) {
        this.mRunningJob = job;
    }

    void setJobParamsLockedForTest(JobParameters params) {
        this.mParams = params;
    }

    void setRunningCallbackLockedForTest(JobCallback callback) {
        this.mRunningCallback = callback;
    }

    void setPendingStopReasonLockedForTest(int stopReason) {
        this.mPendingStopReason = stopReason;
    }

    int getRunningJobWorkType() {
        return this.mRunningJobWorkType;
    }

    private String getRunningJobNameLocked() {
        if (this.mRunningJob != null) goto L7;
        return "<null>";
    L7:
        return this.mRunningJob.toShortString();
    }

    void cancelExecutingJobLocked(int reason, int internalStopReason, String debugReason) {
        doCancelLocked(reason, internalStopReason, debugReason);
    }

    void markForProcessDeathLocked(int reason, int internalStopReason, String debugReason) {
        if (this.mVerb != 4) goto L9;
        if (DEBUG == false) goto L15;
        Slog.d(TAG, "Too late to mark for death (verb=" + this.mVerb + "), ignoring.");
        return;
    L15:
        return;
    L9:
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Marking " + this.mRunningJob.toShortString() + " for death because " + reason + ":" + debugReason);
    L11:
        this.mDeathMarkStopReason = reason;
        this.mDeathMarkInternalStopReason = internalStopReason;
        this.mDeathMarkDebugReason = debugReason;
        if (this.mParams.getStopReason() != 0) goto L16;
        this.mParams.setStopReason(reason, internalStopReason, debugReason);
        return;
    }

    int getPreferredUid() {
        return this.mPreferredUid;
    }

    void clearPreferredUid() {
        this.mPreferredUid = -1;
    }

    int getId() {
        return hashCode();
    }

    long getExecutionStartTimeElapsed() {
        return this.mExecutionStartTimeElapsed;
    }

    long getTimeoutElapsed() {
        return this.mTimeoutElapsed;
    }

    long getRemainingGuaranteedTimeMs(long nowElapsed) {
        return Math.max(0, (this.mExecutionStartTimeElapsed + this.mMinExecutionGuaranteeMillis) - nowElapsed);
    }

    void informOfNetworkChangeLocked(Network newNetwork) {
        if (newNetwork == null) goto L13;
        if (this.mRunningJob == null) goto L13;
        if (canGetNetworkInformation(this.mRunningJob) == true) goto L13;
        if (DEBUG == false) goto L27;
        Slog.d(TAG, "Skipping network change call because of missing permissions");
        return;
    L27:
        return;
    L13:
        if (this.mVerb == 2) goto L25;
        Slog.w(TAG, "Sending onNetworkChanged for a job that isn't started. " + this.mRunningJob);
        if (this.mVerb != 0) goto L17;
    L18:
        this.mPendingNetworkChange = newNetwork;
        return;
    L17:
        if (this.mVerb == 1) goto L18;
        return;
    L25:
        this.mParams.setNetwork(newNetwork);     // Catch: RemoteException -> L22
        this.mPendingNetworkChange = null;     // Catch: RemoteException -> L22
        this.service.onNetworkChanged(this.mParams);     // Catch: RemoteException -> L22
        return;
    L22:
        e = move-exception;
        Slog.e(TAG, "Error sending onNetworkChanged to client.", e);
        closeAndCleanupJobLocked(true, "host crashed when trying to inform of network change");
    }

    boolean isWithinExecutionGuaranteeTime() {
        if (JobSchedulerService.sElapsedRealtimeClock.millis() >= (this.mExecutionStartTimeElapsed + this.mMinExecutionGuaranteeMillis)) goto L5;
        return true;
    L5:
        return false;
    }

    boolean stopIfExecutingLocked(String pkgName, int userId, String namespace, boolean matchJobId, int jobId, int stopReason, int internalStopReason) {
        JobStatus executing = getRunningJobLocked();
        if (executing != null) goto L5;
        return false;
    L5:
        if (userId != (-1)) goto L7;
    L8:
        if (pkgName == null) goto L12;
        if (pkgName.equals(executing.getSourcePackageName()) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(namespace, executing.getNamespace()) == false) goto L24;
        if (matchJobId == false) goto L17;
        if (jobId == executing.getJobId()) goto L17;
        return false;
    L17:
        if (this.mVerb != 2) goto L26;
        this.mParams.setStopReason(stopReason, internalStopReason, "stop from shell");
        sendStopMessageLocked("stop from shell");
        return true;
    L26:
        return false;
    L24:
        return false;
    L7:
        if (userId == executing.getUserId()) goto L8;
        return false;
    }

    Pair<Long, Long> getEstimatedNetworkBytes() {
        return Pair.create(Long.valueOf(this.mEstimatedDownloadBytes), Long.valueOf(this.mEstimatedUploadBytes));
    }

    Pair<Long, Long> getTransferredNetworkBytes() {
        return Pair.create(Long.valueOf(this.mTransferredDownloadBytes), Long.valueOf(this.mTransferredUploadBytes));
    }

    void doJobFinished(JobCallback cb, int jobId, boolean reschedule) {
        long ident = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L18
        monitor-enter(r2);     // Catch: Throwable -> L18
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L6:
        if (verifyCallerLocked(cb) == true) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        this.mParams.setStopReason(0, 10, "app called jobFinished");     // Catch: Throwable -> L10
        doCallbackLocked(reschedule, "app called jobFinished");     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    void doHandleAbandonedJob(JobCallback cb, int jobId) {
        long ident = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L24
        monitor-enter(r2);     // Catch: Throwable -> L24
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L6:
        if (verifyCallerLocked(cb) == true) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L13:
        if (this.mVerb == 2) goto L17;
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L17:
        JobStatus executing = getRunningJobLocked();     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        if (executing != null) goto L21;
    L26:
        Binder.restoreCallingIdentity(ident);
        return;
    L21:
        if (jobId != executing.getJobId()) goto L26;
        executing.setAbandoned(true);     // Catch: Throwable -> L24
        Trace.instant(131072, TRACE_ABANDONED_JOB + executing.getBatteryName() + TRACE_ABANDONED_JOB_DELIMITER + executing.getJobId());     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void doAcknowledgeGetTransferredDownloadBytesMessage(JobCallback cb, int jobId, int workId, long transferredBytes) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (verifyCallerLocked(cb) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mTransferredDownloadBytes = transferredBytes;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void doAcknowledgeGetTransferredUploadBytesMessage(JobCallback cb, int jobId, int workId, long transferredBytes) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (verifyCallerLocked(cb) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mTransferredUploadBytes = transferredBytes;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    void doAcknowledgeStopMessage(JobCallback cb, int jobId, boolean reschedule) {
        doCallback(cb, reschedule, null);
    }

    void doAcknowledgeStartMessage(JobCallback cb, int jobId, boolean ongoing) {
        doCallback(cb, ongoing, "finished start");
    }

    JobWorkItem doDequeueWork(JobCallback cb, int jobId) {
        long ident = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L32
        monitor-enter(r2);     // Catch: Throwable -> L32
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L6:
        if (assertCallerLocked(cb) == true) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return null;
    L13:
        if (this.mVerb == 3) goto L27;
        if (this.mVerb == 4) goto L27;
        JobWorkItem work = this.mRunningJob.dequeueWorkLocked();     // Catch: Throwable -> L10
        if (work == null) goto L20;
    L22:
        if (work == null) goto L24;
        this.mService.mJobs.touchJob(this.mRunningJob);     // Catch: Throwable -> L10
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return work;
    L20:
        if (this.mRunningJob.hasExecutingWorkLocked() == true) goto L22;
        this.mParams.setStopReason(0, 10, "last work dequeued");     // Catch: Throwable -> L10
        doCallbackLocked(false, "last work dequeued");     // Catch: Throwable -> L10
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return null;
    L32:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    boolean doCompleteWork(JobCallback cb, int jobId, int workId) {
        long ident = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L6:
        if (assertCallerLocked(cb) == true) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return true;
    L13:
        if (this.mRunningJob.completeWorkLocked(workId) == false) goto L18;
        this.mService.mJobs.touchJob(this.mRunningJob);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return true;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return false;
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void doUpdateEstimatedNetworkBytes(JobCallback cb, int jobId, JobWorkItem item, long downloadBytes, long uploadBytes) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (verifyCallerLocked(cb) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_estimated_network_bytes_updated", this.mRunningJob.getUid());     // Catch: Throwable -> L8
        sUpdatedEstimatedNetworkDownloadKBLogger.logSample(JobSchedulerService.safelyScaleBytesToKBForHistogram(downloadBytes));     // Catch: Throwable -> L8
        sUpdatedEstimatedNetworkUploadKBLogger.logSample(JobSchedulerService.safelyScaleBytesToKBForHistogram(uploadBytes));     // Catch: Throwable -> L8
        if (this.mEstimatedDownloadBytes == (-1)) goto L21;
        if (downloadBytes == (-1)) goto L21;
        if (this.mEstimatedDownloadBytes >= downloadBytes) goto L18;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_estimated_network_download_bytes_increased", this.mRunningJob.getUid());     // Catch: Throwable -> L8
        goto L21
    L18:
        if (this.mEstimatedDownloadBytes <= downloadBytes) goto L21;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_estimated_network_download_bytes_decreased", this.mRunningJob.getUid());     // Catch: Throwable -> L8
    L21:
        if (this.mEstimatedUploadBytes != (-1)) goto L23;
    L30:
        this.mEstimatedDownloadBytes = downloadBytes;     // Catch: Throwable -> L8
        this.mEstimatedUploadBytes = uploadBytes;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L23:
        if (uploadBytes == (-1)) goto L30;
        if (this.mEstimatedUploadBytes >= uploadBytes) goto L28;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_estimated_network_upload_bytes_increased", this.mRunningJob.getUid());     // Catch: Throwable -> L8
        goto L30
    L28:
        if (this.mEstimatedUploadBytes <= uploadBytes) goto L30;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_estimated_network_upload_bytes_decreased", this.mRunningJob.getUid());     // Catch: Throwable -> L8
        goto L30
    }

    private void doUpdateTransferredNetworkBytes(JobCallback cb, int jobId, JobWorkItem item, long downloadBytes, long uploadBytes) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (verifyCallerLocked(cb) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_transferred_network_bytes_updated", this.mRunningJob.getUid());     // Catch: Throwable -> L8
        sTransferredNetworkDownloadKBHighWaterMarkLogger.logSample(JobSchedulerService.safelyScaleBytesToKBForHistogram(downloadBytes));     // Catch: Throwable -> L8
        sTransferredNetworkUploadKBHighWaterMarkLogger.logSample(JobSchedulerService.safelyScaleBytesToKBForHistogram(uploadBytes));     // Catch: Throwable -> L8
        if (this.mTransferredDownloadBytes == (-1)) goto L21;
        if (downloadBytes == (-1)) goto L21;
        if (this.mTransferredDownloadBytes >= downloadBytes) goto L18;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_transferred_network_download_bytes_increased", this.mRunningJob.getUid());     // Catch: Throwable -> L8
        goto L21
    L18:
        if (this.mTransferredDownloadBytes <= downloadBytes) goto L21;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_transferred_network_download_bytes_decreased", this.mRunningJob.getUid());     // Catch: Throwable -> L8
    L21:
        if (this.mTransferredUploadBytes != (-1)) goto L23;
    L30:
        this.mTransferredDownloadBytes = downloadBytes;     // Catch: Throwable -> L8
        this.mTransferredUploadBytes = uploadBytes;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L23:
        if (uploadBytes == (-1)) goto L30;
        if (this.mTransferredUploadBytes >= uploadBytes) goto L28;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_transferred_network_upload_bytes_increased", this.mRunningJob.getUid());     // Catch: Throwable -> L8
        goto L30
    L28:
        if (this.mTransferredUploadBytes <= uploadBytes) goto L30;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_transferred_network_upload_bytes_decreased", this.mRunningJob.getUid());     // Catch: Throwable -> L8
        goto L30
    }

    private void doSetNotification(JobCallback cb, int jodId, int notificationId, Notification notification, int jobEndNotificationPolicy) {
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        Object r10 = this.mLock;     // Catch: Throwable -> L26
        monitor-enter(r10);     // Catch: Throwable -> L26
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L6:
        if (verifyCallerLocked(cb) == true) goto L13;
        monitor-exit(r10);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L13:
        if (callingUid != this.mRunningJob.getUid()) goto L22;
        String callingPkgName = this.mRunningJob.getServiceComponent().getPackageName();     // Catch: Throwable -> L10
        this.mNotificationCoordinator.enqueueNotification(this, callingPkgName, callingPid, callingUid, notificationId, notification, jobEndNotificationPolicy);     // Catch: Throwable -> L10
        if (this.mAwaitingNotification == false) goto L19;
        this.mAwaitingNotification = false;     // Catch: Throwable -> L10
        if (this.mVerb != 2) goto L19;
        scheduleOpTimeOutLocked();     // Catch: Throwable -> L10
    L19:
        monitor-exit(r10);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L22:
        Slog.wtfStack(TAG, "Calling UID isn't the same as running job's UID...");     // Catch: Throwable -> L10
        throw new SecurityException("Can't post notification on behalf of another app");     // Catch: Throwable -> L10
    L26:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        JobStatus runningJob = this.mRunningJob;     // Catch: Throwable -> L12
        if (runningJob == null) goto L14;
        if (name.equals(runningJob.getServiceComponent()) == false) goto L14;
        this.service = IJobService.Stub.asInterface(service);     // Catch: Throwable -> L12
        doServiceBoundLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        closeAndCleanupJobLocked(true, "connected for different component");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mDeathMarkStopReason == 0) goto L10;
        this.mParams.setStopReason(this.mDeathMarkStopReason, this.mDeathMarkInternalStopReason, this.mDeathMarkDebugReason);     // Catch: Throwable -> L7
    L12:
        closeAndCleanupJobLocked(true, "unexpectedly disconnected");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        if (this.mRunningJob == null) goto L12;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_unexpected_service_disconnects", this.mRunningJob.getUid());     // Catch: Throwable -> L7
        goto L12
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName name) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mRunningJob != null) goto L10;
        Slog.e(TAG, "Binding died for " + name.getPackageName() + " but no running job on this context");     // Catch: Throwable -> L7
    L13:
        closeAndCleanupJobLocked(true, "binding died");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        if (this.mRunningJob.getServiceComponent().equals(name) == false) goto L12;
        Slog.e(TAG, "Binding died for " + this.mRunningJob.getSourceUserId() + ":" + name.getPackageName());     // Catch: Throwable -> L7
        goto L13
    L12:
        Slog.e(TAG, "Binding died for " + name.getPackageName() + " but context is running a different job");     // Catch: Throwable -> L7
        goto L13
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName name) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mRunningJob != null) goto L10;
        Slog.wtf(TAG, "Got null binding for " + name.getPackageName() + " but no running job on this context");     // Catch: Throwable -> L7
    L13:
        closeAndCleanupJobLocked(false, "null binding");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        if (this.mRunningJob.getServiceComponent().equals(name) == false) goto L12;
        Slog.wtf(TAG, "Got null binding for " + this.mRunningJob.getSourceUserId() + ":" + name.getPackageName());     // Catch: Throwable -> L7
        goto L13
    L12:
        Slog.wtf(TAG, "Got null binding for " + name.getPackageName() + " but context is running a different job");     // Catch: Throwable -> L7
        goto L13
    }

    private boolean verifyCallerLocked(JobCallback cb) {
        if (this.mRunningCallback != cb) goto L5;
        return true;
    L5:
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Stale callback received, ignoring.");
        return false;
    L11:
        return false;
    }

    private boolean assertCallerLocked(JobCallback cb) {
        if (verifyCallerLocked(cb) == true) goto L15;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (this.mPreviousJobHadSuccessfulFinish == false) goto L7;
    L10:
        StringBuilder sb = new StringBuilder(128);
        sb.append("Caller no longer running");
        if (cb.mStoppedReason == null) goto L14;
        sb.append(", last stopped ");
        TimeUtils.formatDuration(nowElapsed - cb.mStoppedTime, sb);
        sb.append(" because: ");
        sb.append(cb.mStoppedReason);
    L14:
        throw new SecurityException(sb.toString());
    L7:
        if ((nowElapsed - this.mLastUnsuccessfulFinishElapsed) >= 15000) goto L10;
        return false;
    L15:
        return true;
    }

    void doServiceBoundLocked() {
        removeOpTimeOutLocked();
        handleServiceBoundLocked();
    }

    void doCallback(JobCallback cb, boolean reschedule, String reason) {
        long ident = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L18
        monitor-enter(r2);     // Catch: Throwable -> L18
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L6:
        if (verifyCallerLocked(cb) == true) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        doCallbackLocked(reschedule, reason);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    void doCallbackLocked(boolean reschedule, String reason) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "doCallback of : " + this.mRunningJob + " v:" + VERB_STRINGS[this.mVerb]);
    L5:
        removeOpTimeOutLocked();
        if (this.mVerb != 1) goto L9;
        handleStartedLocked(reschedule);
        return;
    L9:
        if (this.mVerb != 2) goto L11;
    L16:
        handleFinishedLocked(reschedule, reason);
        return;
    L11:
        if (this.mVerb == 3) goto L16;
        if (DEBUG == false) goto L19;
        Slog.d(TAG, "Unrecognised callback: " + this.mRunningJob);
        return;
    }

    private void doCancelLocked(int stopReasonCode, int internalStopReasonCode, String debugReason) {
        if (this.mVerb == 4) goto L25;
        if (this.mVerb == 3) goto L25;
        if (this.mRunningJob.startedAsExpeditedJob == true) goto L10;
    L15:
        this.mParams.setStopReason(stopReasonCode, internalStopReasonCode, debugReason);
        if (stopReasonCode == 2) goto L18;
    L22:
        handleCancelLocked(debugReason);
        return;
    L18:
        if (this.mRunningJob == null) goto L20;
        int r0 = this.mRunningJob.getUid();
    L21:
        this.mPreferredUid = r0;
        goto L22
    L20:
        r0 = -1;
        goto L21
    L10:
        if (stopReasonCode != 10) goto L15;
        long earliestStopTimeElapsed = this.mExecutionStartTimeElapsed + this.mMinExecutionGuaranteeMillis;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (nowElapsed >= earliestStopTimeElapsed) goto L15;
        this.mPendingStopReason = stopReasonCode;
        this.mPendingInternalStopReason = internalStopReasonCode;
        this.mPendingDebugStopReason = debugReason;
        return;
    L25:
        if (DEBUG == false) goto L28;
        Slog.d(TAG, "Too late to process cancel for context (verb=" + this.mVerb + "), ignoring.");
        return;
    }

    private void handleServiceBoundLocked() {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "handleServiceBound for " + getRunningJobNameLocked());
    L6:
        if (this.mVerb == 0) goto L10;
        Slog.e(TAG, "Sending onStartJob for a job that isn't pending. " + VERB_STRINGS[this.mVerb]);
        closeAndCleanupJobLocked(false, "started job not pending");
        return;
    L10:
        if (this.mCancelled == true) goto L12;
        this.mVerb = 1;     // Catch: Exception -> L18
        scheduleOpTimeOutLocked();     // Catch: Exception -> L18
        this.service.startJob(this.mParams);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Slog.e(TAG, "Error sending onStart message to '" + this.mRunningJob.getServiceComponent().getShortClassName() + "' ", e);
        return;
    L12:
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "Job cancelled while waiting for bind to complete. " + this.mRunningJob);
    L14:
        closeAndCleanupJobLocked(true, "cancelled while waiting for bind");
    }

    private void handleStartedLocked(boolean workOngoing) {
        switch(this.mVerb) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "Handling started job but job wasn't starting! Was " + VERB_STRINGS[this.mVerb] + ".");
        return;
    L6:
        this.mVerb = 2;
        if (workOngoing == true) goto L11;
        handleFinishedLocked(false, "onStartJob returned false");
        return;
    L11:
        if (this.mCancelled == true) goto L13;
        scheduleOpTimeOutLocked();
        if (this.mPendingNetworkChange == null) goto L23;
        if (Objects.equals(this.mParams.getNetwork(), this.mPendingNetworkChange) == true) goto L23;
        informOfNetworkChangeLocked(this.mPendingNetworkChange);
    L23:
        if (this.mRunningJob.isUserVisibleJob() == false) goto L26;
        this.mService.informObserversOfUserVisibleJobChange(this, this.mRunningJob, true);
        return;
    L26:
        return;
    L13:
        if (DEBUG == false) goto L15;
        Slog.d(TAG, "Job cancelled while waiting for onStartJob to complete.");
    L15:
        handleCancelLocked(null);
    }

    private void handleFinishedLocked(boolean reschedule, String reason) {
        switch(this.mVerb) {
            case 2: goto L5;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "Got an execution complete message for a job that wasn't beingexecuted. Was " + VERB_STRINGS[this.mVerb] + ".");
        return;
    L5:
        closeAndCleanupJobLocked(reschedule, reason);
    }

    private void handleCancelLocked(String reason) {
        if (JobSchedulerService.DEBUG == false) goto L6;
        Slog.d(TAG, "Handling cancel for: " + this.mRunningJob.getJobId() + " " + VERB_STRINGS[this.mVerb]);
    L6:
        switch(this.mVerb) {
            case 0: goto L10;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L14;
            default: goto L7;
        };
    L7:
        Slog.e(TAG, "Cancelling a job without a valid verb: " + this.mVerb);
        return;
    L9:
        sendStopMessageLocked(reason);
        return;
    L10:
        this.mCancelled = true;
        applyStoppedReasonLocked(reason);
        return;
    }

    void handleOpTimeoutLocked() {
        switch(this.mVerb) {
            case 0: goto L37;
            case 1: goto L36;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "Handling timeout for an invalid job state: " + getRunningJobNameLocked() + ", dropping.");
        closeAndCleanupJobLocked(false, "invalid timeout");
        return;
    L5:
        onSlowAppResponseLocked(true, false, "job_scheduler.value_cntr_w_uid_slow_app_response_on_stop_job", "timed out while stopping", "No response to onStopJob", CompatChanges.isChangeEnabled(ANR_PRE_UDC_APIS_ON_SLOW_RESPONSES, this.mRunningJob.getUid()));
        return;
    L36:
        onSlowAppResponseLocked(false, true, "job_scheduler.value_cntr_w_uid_slow_app_response_on_start_job", "timed out while starting", "No response to onStartJob", CompatChanges.isChangeEnabled(ANR_PRE_UDC_APIS_ON_SLOW_RESPONSES, this.mRunningJob.getUid()));
        return;
    L37:
        onSlowAppResponseLocked(true, true, "job_scheduler.value_cntr_w_uid_slow_app_response_binding", "timed out while binding", "Timed out while trying to bind", false);
        return;
    L7:
        if (this.mPendingStopReason != 0) goto L9;
    L12:
        long latestStopTimeElapsed = this.mExecutionStartTimeElapsed + this.mMaxExecutionTimeMillis;
        long earliestStopTimeElapsed = this.mExecutionStartTimeElapsed + this.mMinExecutionGuaranteeMillis;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (nowElapsed < latestStopTimeElapsed) goto L23;
        Slog.i(TAG, "Client timed out while executing (no jobFinished received). Sending onStop: " + getRunningJobNameLocked());
        JobStatus executing = getRunningJobLocked();
        int stopReason = 3;
        int internalStopReason = 3;
        StringBuilder stopMessage = new StringBuilder("timeout while executing");
        StringBuilder debugStopReason = new StringBuilder("client timed out");
        if (executing != null) goto L17;
    L21:
        this.mParams.setStopReason(stopReason, internalStopReason, debugStopReason.toString());
        sendStopMessageLocked(stopMessage.toString());
        return;
    L17:
        if (CompatChanges.isChangeEnabled(372529068, executing.getSourceUid()) == true) goto L21;
        if (executing.isAbandoned() == false) goto L21;
        stopReason = 16;
        internalStopReason = 13;
        stopMessage.append(" and maybe abandoned");
        debugStopReason.append(" and maybe abandoned");
        goto L21
    L23:
        if (nowElapsed < earliestStopTimeElapsed) goto L30;
        String reason = this.mJobConcurrencyManager.shouldStopRunningJobLocked(this);
        if (reason == null) goto L27;
        Slog.i(TAG, "Stopping client after min execution time: " + getRunningJobNameLocked() + " because " + reason);
        this.mParams.setStopReason(4, 3, reason);
        sendStopMessageLocked(reason);
        return;
    L27:
        Slog.i(TAG, "Letting " + getRunningJobNameLocked() + " continue to run past min execution time");
        scheduleOpTimeOutLocked();
        return;
    L30:
        if (this.mAwaitingNotification == false) goto L32;
        onSlowAppResponseLocked(true, true, "job_scheduler.value_cntr_w_uid_slow_app_response_set_notification", "timed out while stopping", "required notification not provided", true);
        return;
    L32:
        long timeSinceDurationStampTimeMs = nowElapsed - this.mLastExecutionDurationStampTimeElapsed;
        if (timeSinceDurationStampTimeMs >= 300000) goto L35;
        Slog.e(TAG, "Unexpected op timeout while EXECUTING");
    L35:
        this.mRunningJob.incrementCumulativeExecutionTime(timeSinceDurationStampTimeMs);
        this.mService.mJobs.touchJob(this.mRunningJob);
        this.mLastExecutionDurationStampTimeElapsed = nowElapsed;
        scheduleOpTimeOutLocked();
        return;
    L9:
        if (this.mService.isReadyToBeExecutedLocked(this.mRunningJob, false) == false) goto L11;
        this.mPendingStopReason = 0;
        this.mPendingInternalStopReason = 0;
        this.mPendingDebugStopReason = null;
        goto L12
    L11:
        Slog.i(TAG, "JS was waiting to stop this job. Sending onStop: " + getRunningJobNameLocked());
        this.mParams.setStopReason(this.mPendingStopReason, this.mPendingInternalStopReason, this.mPendingDebugStopReason);
        sendStopMessageLocked(this.mPendingDebugStopReason);
    }

    void sendStopMessageLocked(String reason) {
        removeOpTimeOutLocked();
        if (this.mVerb == 2) goto L11;
        Slog.e(TAG, "Sending onStopJob for a job that isn't started. " + this.mRunningJob);
        closeAndCleanupJobLocked(false, reason);
        return;
    L11:
        applyStoppedReasonLocked(reason);     // Catch: RemoteException -> L8
        this.mVerb = 3;     // Catch: RemoteException -> L8
        scheduleOpTimeOutLocked();     // Catch: RemoteException -> L8
        this.service.stopJob(this.mParams);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Error sending onStopJob to client.", e);
        closeAndCleanupJobLocked(true, "host crashed when trying to stop");
    }

    private void onSlowAppResponseLocked(boolean reschedule, boolean updateStopReasons, String texCounterMetricId, String debugReason, String anrMessage, boolean triggerAnr) {
        Slog.w(TAG, anrMessage + " for " + getRunningJobNameLocked());
        Counter.logIncrementWithUid(texCounterMetricId, this.mRunningJob.getUid());
        if (updateStopReasons == false) goto L5;
        this.mParams.setStopReason(0, 12, debugReason);
    L5:
        if (triggerAnr == false) goto L7;
        this.mActivityManagerInternal.appNotResponding(this.mRunningJob.serviceProcessName, this.mRunningJob.getUid(), TimeoutRecord.forJobService(anrMessage));
    L7:
        closeAndCleanupJobLocked(reschedule, debugReason);
    }

    private void closeAndCleanupJobLocked(boolean reschedule, String loggingDebugReason) {
        if (this.mVerb != 4) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "Cleaning up " + this.mRunningJob.toShortString() + " reschedule=" + reschedule + " reason=" + loggingDebugReason);
    L8:
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        applyStoppedReasonLocked(loggingDebugReason);
        JobStatus completedJob = this.mRunningJob;
        completedJob.incrementCumulativeExecutionTime(nowElapsed - this.mLastExecutionDurationStampTimeElapsed);
        int loggingStopReason = this.mParams.getStopReason();
        int loggingInternalStopReason = this.mParams.getInternalStopReasonCode();
        if (this.mDeathMarkStopReason != 0) goto L11;
        int reschedulingInternalStopReason = loggingInternalStopReason;
        int reschedulingStopReason = loggingStopReason;
    L16:
        if (loggingInternalStopReason != 10) goto L18;
        boolean r0 = true;
    L19:
        this.mPreviousJobHadSuccessfulFinish = r0;
        if (this.mPreviousJobHadSuccessfulFinish == true) goto L22;
        this.mLastUnsuccessfulFinishElapsed = nowElapsed;
    L22:
        this.mJobPackageTracker.noteInactive(completedJob, loggingInternalStopReason, loggingDebugReason);
        int sourceUid = completedJob.getSourceUid();
        int procState = this.mService.getUidProcState(completedJob.getUid());
        if (procState <= 8) goto L25;
        int procState2 = this.mActivityManagerInternal.getUidProcessState(completedJob.getUid());
    L27:
        if (completedJob.isProxyJob() == false) goto L29;
        int[] r1 = {sourceUid, completedJob.getUid()};
    L30:
        int reschedulingInternalStopReason2 = reschedulingInternalStopReason;
        if (completedJob.isProxyJob() == false) goto L33;
        String[] r15 = {null, completedJob.getSourceTag()};
    L34:
        FrameworkStatsLog.write(8, r1, r15, completedJob.getBatteryName(), 0, loggingInternalStopReason, completedJob.getStandbyBucket(), completedJob.getLoggingJobId(), completedJob.hasChargingConstraint(), completedJob.hasBatteryNotLowConstraint(), completedJob.hasStorageNotLowConstraint(), completedJob.hasTimingDelayConstraint(), completedJob.hasDeadlineConstraint(), completedJob.hasIdleConstraint(), completedJob.hasConnectivityConstraint(), completedJob.hasContentTriggerConstraint(), completedJob.isRequestedExpeditedJob(), completedJob.startedAsExpeditedJob, loggingStopReason, completedJob.getJob().isPrefetch(), completedJob.getJob().getPriority(), completedJob.getEffectivePriority(), completedJob.getNumPreviousAttempts(), completedJob.getJob().getMaxExecutionDelayMillis(), this.mParams.isOverrideDeadlineExpired(), completedJob.isConstraintSatisfied(1), completedJob.isConstraintSatisfied(2), completedJob.isConstraintSatisfied(8), completedJob.isConstraintSatisfied(Integer.MIN_VALUE), completedJob.isConstraintSatisfied(4), completedJob.isConstraintSatisfied(268435456), completedJob.isConstraintSatisfied(67108864), this.mExecutionStartTimeElapsed - completedJob.enqueueTime, completedJob.getJob().isUserInitiated(), completedJob.startedAsUserInitiatedJob, completedJob.getJob().isPeriodic(), completedJob.getJob().getMinLatencyMillis(), completedJob.getEstimatedNetworkDownloadBytes(), completedJob.getEstimatedNetworkUploadBytes(), completedJob.getWorkCount(), ActivityManager.processStateAmToProto(procState2), completedJob.getNamespaceHash(), TrafficStats.getUidRxBytes(completedJob.getSourceUid()) - this.mInitialDownloadedBytesFromSource, TrafficStats.getUidTxBytes(completedJob.getSourceUid()) - this.mInitialUploadedBytesFromSource, TrafficStats.getUidRxBytes(completedJob.getUid()) - this.mInitialDownloadedBytesFromCalling, TrafficStats.getUidTxBytes(completedJob.getUid()) - this.mInitialUploadedBytesFromCalling, completedJob.getJob().getIntervalMillis(), completedJob.getJob().getFlexMillis(), completedJob.hasFlexibilityConstraint(), completedJob.isConstraintSatisfied(2097152), completedJob.canApplyTransportAffinities(), completedJob.getNumAppliedFlexibleConstraints(), completedJob.getNumDroppedFlexibleConstraints(), completedJob.getFilteredTraceTag(), completedJob.getFilteredDebugTags(), completedJob.getNumAbandonedFailures(), completedJob.getJob().getBackoffPolicy() + 1, this.mService.shouldUseAggressiveBackoff(completedJob.getNumAbandonedFailures(), completedJob.getSourceUid()));
        if (Trace.isTagEnabled(524288) == false) goto L38;
        Trace.asyncTraceForTrackEnd(524288, "JobScheduler", getId());
    L38:
        if (completedJob.getAppTraceTag() == null) goto L51;
        Trace.asyncTraceForTrackEnd(4096, "JobScheduler", completedJob.getJobId());
    L51:
        this.mBatteryStats.noteJobFinish(this.mRunningJob.getBatteryName(), this.mRunningJob.getSourceUid(), loggingInternalStopReason);     // Catch: RemoteException -> L42
    L43:
        this.mNotificationCoordinator.removeNotificationAssociation(this, reschedulingStopReason, completedJob);
        if (this.mWakeLock == null) goto L46;
        this.mWakeLock.release();
    L46:
        int workType = this.mRunningJobWorkType;
        this.mContext.unbindService(this);
        this.mWakeLock = null;
        this.mRunningJob = null;
        this.mRunningJobWorkType = 0;
        this.mRunningCallback = null;
        this.mParams = null;
        this.mVerb = 4;
        this.mCancelled = false;
        this.service = null;
        this.mAvailable = true;
        this.mDeathMarkStopReason = 0;
        this.mDeathMarkInternalStopReason = 0;
        this.mDeathMarkDebugReason = null;
        this.mLastExecutionDurationStampTimeElapsed = 0;
        this.mPendingStopReason = 0;
        this.mPendingInternalStopReason = 0;
        this.mPendingDebugStopReason = null;
        this.mPendingNetworkChange = null;
        removeOpTimeOutLocked();
        this.mRunningJobSaved = null;
        if (completedJob.isUserVisibleJob() == false) goto L49;
        this.mService.informObserversOfUserVisibleJobChange(this, completedJob, false);
    L49:
        this.mCompletedListener.onJobCompletedLocked(completedJob, reschedulingStopReason, reschedulingInternalStopReason2, reschedule);
        this.mJobConcurrencyManager.onJobCompletedLocked(this, completedJob, workType);
        return;
    L33:
        r15 = new String[]{completedJob.getSourceTag()};
        goto L34
    L29:
        r1 = new int[]{sourceUid};
        goto L30
    L25:
        procState2 = procState;
        goto L27
    L18:
        r0 = false;
        goto L19
    L11:
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "Job marked for death because of " + JobParameters.getInternalReasonCodeDescription(this.mDeathMarkInternalStopReason) + ": " + this.mDeathMarkDebugReason);
    L13:
        int reschedulingStopReason2 = this.mDeathMarkStopReason;
        reschedulingInternalStopReason = this.mDeathMarkInternalStopReason;
        reschedulingStopReason = reschedulingStopReason2;
        goto L16
    }

    private void applyStoppedReasonLocked(String reason) {
        if (reason != null) goto L4;
        return;
    L4:
        if (this.mStoppedReason != null) goto L10;
        this.mStoppedReason = reason;
        this.mStoppedTime = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (this.mRunningCallback == null) goto L11;
        JobCallback r0 = this.mRunningCallback;
        r0.mStoppedReason = this.mStoppedReason;
        JobCallback r1 = this.mRunningCallback;
        r1.mStoppedTime = this.mStoppedTime;
        return;
    L11:
        return;
    }

    private void scheduleOpTimeOutLocked() {
        removeOpTimeOutLocked();
        switch(this.mVerb) {
            case 0: goto L13;
            case 1: goto L4;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        long timeoutMillis = OP_TIMEOUT_MILLIS;
    L15:
        if (DEBUG == false) goto L17;
        Slog.d(TAG, "Scheduling time out for '" + this.mRunningJob.getServiceComponent().getShortClassName() + "' jId: " + this.mParams.getJobId() + ", in " + (timeoutMillis / 1000) + " s");
    L17:
        Message m = this.mCallbackHandler.obtainMessage(0, this.mRunningCallback);
        this.mCallbackHandler.sendMessageDelayed(m, timeoutMillis);
        if (this.mRunningJobSaved == null) goto L20;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().monitorJobSchedule(this.mRunningJobSaved.getUid(), this.mRunningJobSaved.serviceProcessName, timeoutMillis, this.mRunningJobSaved.hashCode());
    L20:
        this.mTimeoutElapsed = JobSchedulerService.sElapsedRealtimeClock.millis() + timeoutMillis;
        return;
    L5:
        long timeoutMillis2 = this.mExecutionStartTimeElapsed;
        long earliestStopTimeElapsed = timeoutMillis2 + this.mMinExecutionGuaranteeMillis;
        long latestStopTimeElapsed = this.mExecutionStartTimeElapsed + this.mMaxExecutionTimeMillis;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (nowElapsed >= earliestStopTimeElapsed) goto L8;
        long minTimeout = earliestStopTimeElapsed - nowElapsed;
    L10:
        if (this.mAwaitingNotification == false) goto L12;
        minTimeout = Math.min(minTimeout, NOTIFICATION_TIMEOUT_MILLIS);
    L12:
        timeoutMillis = Math.min(minTimeout, 300000);
        goto L15
    L8:
        minTimeout = latestStopTimeElapsed - nowElapsed;
        goto L10
    L13:
        timeoutMillis = OP_BIND_TIMEOUT_MILLIS;
        goto L15
    }

    private void removeOpTimeOutLocked() {
        this.mCallbackHandler.removeMessages(0);
        if (this.mRunningJobSaved == null) goto L6;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().cancelJobSchedule(this.mRunningJobSaved.getUid(), this.mRunningJobSaved.serviceProcessName, this.mRunningJobSaved.hashCode());
        return;
    }

    void dumpLocked(IndentingPrintWriter pw, long nowElapsed) {
        if (this.mRunningJob == null) goto L5;
        pw.println(this.mRunningJob.toShortString());
        pw.increaseIndent();
        pw.print("Running for: ");
        TimeUtils.formatDuration(nowElapsed - this.mExecutionStartTimeElapsed, pw);
        pw.print(", timeout at: ");
        TimeUtils.formatDuration(this.mTimeoutElapsed - nowElapsed, pw);
        pw.println();
        pw.print("Remaining execution limits: [");
        TimeUtils.formatDuration((this.mExecutionStartTimeElapsed + this.mMinExecutionGuaranteeMillis) - nowElapsed, pw);
        pw.print(", ");
        TimeUtils.formatDuration((this.mExecutionStartTimeElapsed + this.mMaxExecutionTimeMillis) - nowElapsed, pw);
        pw.print("]");
        if (this.mPendingStopReason == 0) goto L11;
        pw.print(" Pending stop because ");
        pw.print(this.mPendingStopReason);
        pw.print(SliceClientPermissions.SliceAuthority.DELIMITER);
        pw.print(this.mPendingInternalStopReason);
        pw.print(SliceClientPermissions.SliceAuthority.DELIMITER);
        pw.print(this.mPendingDebugStopReason);
    L11:
        pw.println();
        pw.decreaseIndent();
        return;
    L5:
        if (this.mStoppedReason == null) goto L7;
        pw.print("inactive since ");
        TimeUtils.formatDuration(this.mStoppedTime, nowElapsed, pw);
        pw.print(", stopped because: ");
        pw.println(this.mStoppedReason);
        return;
    L7:
        pw.println("inactive");
    }
}
