package com.android.server.job.controllers;

import android.app.AppGlobals;
import android.app.job.JobInfo;
import android.app.job.JobWorkItem;
import android.app.job.PendingJobReasonsInfo;
import android.app.job.UserVisibleJobSummary;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import android.util.Patterns;
import android.util.Range;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.jobs.ArrayUtils;
import com.android.modules.expresslog.Counter;
import com.android.server.LocalServices;
import com.android.server.job.GrantedUriPermissions;
import com.android.server.job.JobSchedulerInternal;
import com.android.server.job.JobSchedulerService;
import com.android.server.job.restrictions.JobRestriction;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.wm.ActivityTaskManagerService;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class JobStatus {
    private static final ArrayMap<Pattern, String> BASIC_PII_FILTERS = null;
    static final int CONSTRAINTS_OF_INTEREST = -1801453041;
    static final int CONSTRAINT_BACKGROUND_NOT_RESTRICTED = 4194304;
    public static final int CONSTRAINT_BATTERY_NOT_LOW = 2;
    public static final int CONSTRAINT_CHARGING = 1;
    public static final int CONSTRAINT_CONNECTIVITY = 268435456;
    public static final int CONSTRAINT_CONTENT_TRIGGER = 67108864;
    public static final int CONSTRAINT_DEADLINE = 1073741824;
    static final int CONSTRAINT_DEVICE_NOT_DOZING = 33554432;
    public static final int CONSTRAINT_FLEXIBLE = 2097152;
    public static final int CONSTRAINT_IDLE = 4;
    static final int CONSTRAINT_PREFETCH = 8388608;
    public static final int CONSTRAINT_STORAGE_NOT_LOW = 8;
    public static final int CONSTRAINT_TIMING_DELAY = Integer.MIN_VALUE;
    static final int CONSTRAINT_WITHIN_QUOTA = 16777216;
    static final boolean DEBUG = false;
    static final boolean DEBUG_PREPARE = true;
    public static final long DEFAULT_TRIGGER_MAX_DELAY = 120000;
    public static final long DEFAULT_TRIGGER_UPDATE_DELAY = 10000;
    private static final int DYNAMIC_EXPEDITED_DEFERRAL_CONSTRAINTS = 37748736;
    private static final int DYNAMIC_RESTRICTED_CONSTRAINTS = 268435463;
    private static final int IMPLICIT_CONSTRAINTS = 56623104;
    public static final int INTERNAL_FLAG_DEMOTED_BY_SYSTEM_UIJ = 4;
    public static final int INTERNAL_FLAG_DEMOTED_BY_USER = 2;
    public static final int INTERNAL_FLAG_HAS_FOREGROUND_EXEMPTION = 1;
    private static final int MAX_NAMESPACE_CACHE_SIZE = 128;
    private static final Uri[] MEDIA_URIS_FOR_STANDBY_EXEMPTION = null;
    public static final long MIN_TRIGGER_MAX_DELAY = 1000;
    public static final long MIN_TRIGGER_UPDATE_DELAY = 500;
    public static final long NO_EARLIEST_RUNTIME = 0;
    public static final long NO_LATEST_RUNTIME = Long.MAX_VALUE;
    private static final int NUM_CONSTRAINT_CHANGE_HISTORY = 10;
    public static final int OBRIC_CONSTRAINT_BUSINESS = 512;
    public static final int OVERRIDE_FULL = 3;
    public static final int OVERRIDE_NONE = 0;
    public static final int OVERRIDE_SOFT = 2;
    public static final int OVERRIDE_SORTING = 1;
    private static final int PENDING_JOB_HISTORY_RETURN_LIMIT = 10;
    private static final int PENDING_JOB_HISTORY_TRIM_THRESHOLD = 25;
    static final int SOFT_OVERRIDE_CONSTRAINTS = -2136997361;
    private static final int STATSD_CONSTRAINTS_TO_LOG = -981467136;
    private static final boolean STATS_LOG_ENABLED = false;
    private static final String TAG = "JobScheduler.JobStatus";
    public static final int TRACKING_BATTERY = 1;
    public static final int TRACKING_CONNECTIVITY = 2;
    public static final int TRACKING_CONTENT = 4;
    public static final int TRACKING_FLEXIBILITY = 128;
    public static final int TRACKING_IDLE = 8;
    public static final int TRACKING_QUOTA = 64;
    public static final int TRACKING_STORAGE = 16;
    public static final int TRACKING_TIME = 32;
    private static MessageDigest sMessageDigest;
    private static final ArrayMap<String, String> sNamespaceHashCache = null;
    boolean appHasDozeExemption;
    final String batteryName;
    final int callingUid;
    public ArraySet<String> changedAuthorities;
    public ArraySet<Uri> changedUris;
    ContentObserverController.JobInstance contentObserverJobInstance;
    private final long earliestRunTimeElapsedMillis;
    public long enqueueTime;
    public ArrayList<JobWorkItem> executingWork;
    final JobInfo job;
    public int lastEvaluatedBias;
    private final long latestRunTimeElapsedMillis;
    private final boolean mCanApplyTransportAffinities;
    private int mConstraintChangeHistoryIndex;
    private final int[] mConstraintStatusHistory;
    private final long[] mConstraintUpdatedTimesElapsed;
    private long mCumulativeExecutionTimeMs;
    private int mDynamicConstraints;
    private boolean mExpeditedQuotaApproved;
    private String[] mFilteredDebugTags;
    private String mFilteredTraceTag;
    private long mFirstForceBatchedTimeElapsed;
    private final boolean mHasExemptedMediaUrisOnly;
    private boolean mHasMediaBackupExemption;
    private int mInternalFlags;
    private boolean mIsAbandoned;
    private boolean mIsDowngradedDueToBuggyApp;
    final boolean mIsProxyJob;
    private boolean mIsUserBgRestricted;
    private JobSchedulerInternal mJobSchedulerInternal;
    private long mLastFailedRunTime;
    private long mLastSuccessfulRunTime;
    private boolean mLoggedBucketMismatch;
    private final long mLoggingJobId;
    private long mMinimumNetworkChunkBytes;
    private final String mNamespace;
    private final String mNamespaceHash;
    private final int mNumAbandonedFailures;
    private int mNumAppliedFlexibleConstraints;
    private int mNumDroppedFlexibleConstraints;
    private final int mNumSystemStops;
    private long mOriginalLatestRunTimeElapsedMillis;
    private final List<PendingJobReasonsInfo> mPendingJobReasonsHistory;
    private Pair<Long, Long> mPersistedUtcTimes;
    private boolean mReadyDeadlineSatisfied;
    private boolean mReadyDynamicSatisfied;
    private boolean mReadyNotDozing;
    private boolean mReadyNotRestrictedInBg;
    private boolean mReadyWithinQuota;
    private int mReasonReadyToUnready;
    private final int mRequiredConstraintsOfInterest;
    private int mSatisfiedConstraintsOfInterest;
    public boolean mSourcePkgIsSystem;
    private String mSystemTraceTag;
    private long mTotalNetworkDownloadBytes;
    private long mTotalNetworkUploadBytes;
    private boolean mTransportAffinitiesSatisfied;
    private UserVisibleJobSummary mUserVisibleJobSummary;
    private String mWakelockTag;
    public long madeActive;
    public long madePending;
    public Network network;
    public int nextPendingWorkId;
    private final int numFailures;
    public ObricJobCondition obricJobCondition;
    public int overrideState;
    public ArrayList<JobWorkItem> pendingWork;
    private boolean prepared;
    final int requiredConstraints;
    int satisfiedConstraints;
    public String serviceProcessName;
    final String sourcePackageName;
    final String sourceTag;
    final int sourceUid;
    final int sourceUserId;
    private int standbyBucket;
    public boolean startedAsExpeditedJob;
    public boolean startedAsUserInitiatedJob;
    public boolean startedWithForegroundFlag;
    public boolean startedWithImmediacyPrivilege;
    private int trackingControllers;
    public boolean uidActive;
    private Throwable unpreparedPoint;
    private GrantedUriPermissions uriPerms;
    private long whenStandbyDeferred;

    static {
        DEBUG = JobSchedulerService.DEBUG;
        sNamespaceHashCache = new ArrayMap();
        MEDIA_URIS_FOR_STANDBY_EXEMPTION = new Uri[]{MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.Video.Media.EXTERNAL_CONTENT_URI};
        BASIC_PII_FILTERS = new ArrayMap();
        BASIC_PII_FILTERS.put(Patterns.EMAIL_ADDRESS, "[EMAIL]");
        BASIC_PII_FILTERS.put(Patterns.PHONE, "[PHONE]");
    }

    private JobStatus(JobInfo job, int callingUid, String sourcePackageName, int sourceUserId, int standbyBucket, String namespace, String tag, int numFailures, int mNumAbandonedFailures, int numSystemStops, long earliestRunTimeElapsedMillis, long latestRunTimeElapsedMillis, long lastSuccessfulRunTime, long lastFailedRunTime, long cumulativeExecutionTimeMs, int internalFlags, int dynamicConstraints) {
        this.unpreparedPoint = null;
        this.satisfiedConstraints = 0;
        this.mSatisfiedConstraintsOfInterest = 0;
        this.mDynamicConstraints = 0;
        this.startedAsExpeditedJob = false;
        this.startedAsUserInitiatedJob = false;
        this.startedWithForegroundFlag = false;
        this.startedWithImmediacyPrivilege = false;
        this.nextPendingWorkId = 1;
        this.overrideState = 0;
        this.mConstraintChangeHistoryIndex = 0;
        this.mConstraintUpdatedTimesElapsed = new long[10];
        this.mConstraintStatusHistory = new int[10];
        this.mPendingJobReasonsHistory = new ArrayList();
        this.mTotalNetworkDownloadBytes = -1;
        this.mTotalNetworkUploadBytes = -1;
        this.mMinimumNetworkChunkBytes = -1;
        this.mReasonReadyToUnready = 0;
        this.mSourcePkgIsSystem = false;
        this.callingUid = callingUid;
        this.standbyBucket = standbyBucket;
        this.mNamespace = namespace;
        this.mNamespaceHash = generateNamespaceHash(namespace);
        this.mLoggingJobId = generateLoggingId(namespace, job.getId());
        if (sourceUserId == (-1)) goto L8;
        if (sourcePackageName == null) goto L8;
        int tempSourceUid = AppGlobals.getPackageManager().getPackageUid(sourcePackageName, 0, sourceUserId);     // Catch: RemoteException -> L7
        int tempSourceUid2 = tempSourceUid;
    L9:
        if (tempSourceUid2 != (-1)) goto L11;
        this.sourceUid = callingUid;
        this.sourceUserId = UserHandle.getUserId(callingUid);
        this.sourcePackageName = job.getService().getPackageName();
        this.sourceTag = null;
    L13:
        if (job.getRequiredNetwork() == null) goto L15;
        JobInfo.Builder builder = new JobInfo.Builder(job);
        NetworkRequest.Builder r2 = new NetworkRequest.Builder(job.getRequiredNetwork());
        Integer r4 = Integer.valueOf(this.sourceUid);
        int tempSourceUid3 = this.sourceUid;
        builder.setRequiredNetwork(r2.setUids(Collections.singleton(new Range(r4, Integer.valueOf(tempSourceUid3)))).build());
        JobInfo job2 = builder.build(false, false, false, false);
    L16:
        this.job = job2;
        StringBuilder batteryName = new StringBuilder();
        if (namespace == null) goto L20;
        batteryName.append("@");
        batteryName.append(namespace);
        batteryName.append("@");
    L20:
        if (this.sourceTag == null) goto L22;
        batteryName.append(this.sourceTag);
        batteryName.append(":");
        batteryName.append(job2.getService().getPackageName());
    L23:
        this.batteryName = batteryName.toString();
        String componentPackage = job2.getService().getPackageName();
        this.mIsProxyJob = !this.sourcePackageName.equals(componentPackage);
        this.earliestRunTimeElapsedMillis = earliestRunTimeElapsedMillis;
        this.latestRunTimeElapsedMillis = latestRunTimeElapsedMillis;
        this.mOriginalLatestRunTimeElapsedMillis = latestRunTimeElapsedMillis;
        this.numFailures = numFailures;
        this.mNumAbandonedFailures = mNumAbandonedFailures;
        this.mNumSystemStops = numSystemStops;
        int requiredConstraints = job2.getConstraintFlags();
        if (job2.getRequiredNetwork() == null) goto L27;
        requiredConstraints = requiredConstraints | 268435456;
    L27:
        if (earliestRunTimeElapsedMillis == r13) goto L30;
        requiredConstraints = requiredConstraints | Integer.MIN_VALUE;
    L30:
        if (latestRunTimeElapsedMillis == Long.MAX_VALUE) goto L33;
        requiredConstraints = requiredConstraints | 1073741824;
    L33:
        if (job2.isPrefetch() == false) goto L35;
        requiredConstraints = requiredConstraints | 8388608;
    L35:
        boolean exemptedMediaUrisOnly = false;
        if (job2.getTriggerContentUris() == null) goto L46;
        int requiredConstraints2 = requiredConstraints | 67108864;
        exemptedMediaUrisOnly = true;
        JobInfo.TriggerContentUri[] r0 = job2.getTriggerContentUris();
        int r3 = r0.length;
        int r1 = 0;
    L39:
        if (r1 >= r3) goto L44;
        JobInfo.TriggerContentUri uri = r0[r1];
        int r23 = r1;
        int r24 = r3;
        if (ArrayUtils.contains(MEDIA_URIS_FOR_STANDBY_EXEMPTION, uri.getUri()) == false) goto L42;
        r1 = r23 + 1;
        r3 = r24;
        goto L39
    L42:
        exemptedMediaUrisOnly = false;
        requiredConstraints = requiredConstraints2;
        goto L46
    L44:
        requiredConstraints = requiredConstraints2;
    L46:
        this.mHasExemptedMediaUrisOnly = exemptedMediaUrisOnly;
        if (job2.getRequiredNetwork() != null) goto L49;
    L51:
        boolean r5 = false;
    L52:
        this.mCanApplyTransportAffinities = r5;
        if (((~requiredConstraints) & 7) == 0) goto L55;
    L58:
        boolean lacksSomeFlexibleConstraints = true;
    L60:
        if (isRequestedExpeditedJob() == false) goto L62;
    L67:
        int requiredConstraints3 = requiredConstraints;
    L68:
        int requiredConstraints4 = requiredConstraints3;
    L69:
        int requiredConstraints5 = requiredConstraints4 | ObricJobCondition.initObricConstraints(job2);
        this.requiredConstraints = requiredConstraints5;
        int requiredConstraints6 = requiredConstraints5;
        ApplicationInfo ai = AppGlobals.getPackageManager().getApplicationInfo(this.sourcePackageName, 0, this.sourceUserId);     // Catch: RemoteException -> L79
        if (ai != null) goto L77;
    L81:
        boolean r6 = false;
    L82:
        this.mSourcePkgIsSystem = r6;     // Catch: RemoteException -> L79
        goto L88
    L77:
        if (ai.isSystemApp() == false) goto L81;
        r6 = true;
    L88:
        this.mRequiredConstraintsOfInterest = requiredConstraints6 & CONSTRAINTS_OF_INTEREST;
        addDynamicConstraints(dynamicConstraints);
        this.mReadyNotDozing = canRunInDoze();
        if (standbyBucket != 5) goto L91;
        addDynamicConstraints(DYNAMIC_RESTRICTED_CONSTRAINTS);
    L92:
        this.mCumulativeExecutionTimeMs = cumulativeExecutionTimeMs;
        this.mLastSuccessfulRunTime = lastSuccessfulRunTime;
        this.mLastFailedRunTime = lastFailedRunTime;
        this.mInternalFlags = internalFlags;
        updateNetworkBytesLocked();
        updateMediaBackupExemptionStatus();
        this.mIsAbandoned = false;
        return;
    L91:
        this.mReadyDynamicSatisfied = false;
    L87:
        requiredConstraints6 = requiredConstraints5;
        goto L88
    L62:
        if (job2.isUserInitiated() == true) goto L67;
        requiredConstraints3 = requiredConstraints;
        boolean lacksSomeFlexibleConstraints2 = lacksSomeFlexibleConstraints;
        if ((numFailures + numSystemStops) == 1) goto L68;
        if (lacksSomeFlexibleConstraints2 == false) goto L68;
        requiredConstraints4 = requiredConstraints3 | 2097152;
        goto L69
    L55:
        if (this.mCanApplyTransportAffinities == true) goto L58;
        lacksSomeFlexibleConstraints = false;
        goto L60
    L49:
        if (job2.getRequiredNetwork().getTransportTypes().length != 0) goto L51;
        r5 = true;
        goto L52
    L22:
        batteryName.append(job2.getService().flattenToShortString());
        goto L23
    L15:
        job2 = job;
        goto L16
    L11:
        this.sourceUid = tempSourceUid2;
        this.sourceUserId = sourceUserId;
        this.sourcePackageName = sourcePackageName;
        this.sourceTag = tag;
    L8:
        tempSourceUid2 = -1;
        goto L9
    }

    public JobStatus(JobStatus jobStatus) {
        this(jobStatus.getJob(), jobStatus.getUid(), jobStatus.getSourcePackageName(), jobStatus.getSourceUserId(), jobStatus.getStandbyBucket(), jobStatus.getNamespace(), jobStatus.getSourceTag(), jobStatus.getNumFailures(), jobStatus.getNumAbandonedFailures(), jobStatus.getNumSystemStops(), jobStatus.getEarliestRunTime(), jobStatus.getLatestRunTimeElapsed(), jobStatus.getLastSuccessfulRunTime(), jobStatus.getLastFailedRunTime(), jobStatus.getCumulativeExecutionTimeMs(), jobStatus.getInternalFlags(), jobStatus.mDynamicConstraints);
        this.mPersistedUtcTimes = jobStatus.mPersistedUtcTimes;
        if (jobStatus.mPersistedUtcTimes == null) goto L8;
        if (DEBUG == false) goto L8;
        Slog.i(TAG, "Cloning job with persisted run times", new RuntimeException("here"));
    L8:
        if (jobStatus.executingWork == null) goto L13;
        if (jobStatus.executingWork.size() <= 0) goto L13;
        this.executingWork = new ArrayList(jobStatus.executingWork);
    L13:
        if (jobStatus.pendingWork != null) goto L15;
        return;
    L15:
        if (jobStatus.pendingWork.size() <= 0) goto L19;
        this.pendingWork = new ArrayList(jobStatus.pendingWork);
        return;
    }

    public JobStatus(JobInfo job, int callingUid, String sourcePkgName, int sourceUserId, int standbyBucket, String namespace, String sourceTag, long earliestRunTimeElapsedMillis, long latestRunTimeElapsedMillis, long lastSuccessfulRunTime, long lastFailedRunTime, long cumulativeExecutionTimeMs, Pair<Long, Long> persistedExecutionTimesUTC, int innerFlags, int dynamicConstraints) {
        this(job, callingUid, sourcePkgName, sourceUserId, standbyBucket, namespace, sourceTag, 0, 0, 0, earliestRunTimeElapsedMillis, latestRunTimeElapsedMillis, lastSuccessfulRunTime, lastFailedRunTime, cumulativeExecutionTimeMs, innerFlags, dynamicConstraints);
        this.mPersistedUtcTimes = persistedExecutionTimesUTC;
        if (persistedExecutionTimesUTC != null) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L9;
        Slog.i(TAG, "+ restored job with RTC times because of bad boot clock");
        return;
    }

    public JobStatus(JobStatus rescheduling, long newEarliestRuntimeElapsedMillis, long newLatestRuntimeElapsedMillis, int numFailures, int mNumAbandonedFailures, int numSystemStops, long lastSuccessfulRunTime, long lastFailedRunTime, long cumulativeExecutionTimeMs) {
        this(rescheduling.job, rescheduling.getUid(), rescheduling.getSourcePackageName(), rescheduling.getSourceUserId(), rescheduling.getStandbyBucket(), rescheduling.getNamespace(), rescheduling.getSourceTag(), numFailures, mNumAbandonedFailures, numSystemStops, newEarliestRuntimeElapsedMillis, newLatestRuntimeElapsedMillis, lastSuccessfulRunTime, lastFailedRunTime, cumulativeExecutionTimeMs, rescheduling.getInternalFlags(), rescheduling.mDynamicConstraints);
    }

    public static JobStatus createFromJobInfo(JobInfo job, int callingUid, String sourcePkg, int sourceUserId, String namespace, String tag) {
        long elapsedNow = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (job.isPeriodic() == false) goto L6;
        long period = Math.max(JobInfo.getMinPeriodMillis(), Math.min(31536000000L, job.getIntervalMillis()));
        long latestRunTimeElapsedMillis = elapsedNow + period;
        long earliestRunTimeElapsedMillis = latestRunTimeElapsedMillis - Math.max(JobInfo.getMinFlexMillis(), Math.min(period, job.getFlexMillis()));
        long latestRunTimeElapsedMillis2 = latestRunTimeElapsedMillis;
    L14:
        if (sourcePkg == null) goto L16;
        String jobPackage = sourcePkg;
    L17:
        int standbyBucket = JobSchedulerService.standbyBucketForPackage(jobPackage, sourceUserId, elapsedNow);
        return new JobStatus(job, callingUid, sourcePkg, sourceUserId, standbyBucket, namespace, tag, 0, 0, 0, earliestRunTimeElapsedMillis, latestRunTimeElapsedMillis2, 0, 0, 0, 0, 0);
    L16:
        jobPackage = job.getService().getPackageName();
        goto L17
    L6:
        if (job.hasEarlyConstraint() == false) goto L8;
        long earliestRunTimeElapsedMillis2 = job.getMinLatencyMillis() + elapsedNow;
    L10:
        if (job.hasLateConstraint() == false) goto L12;
        long r4 = job.getMaxExecutionDelayMillis() + elapsedNow;
    L13:
        earliestRunTimeElapsedMillis = earliestRunTimeElapsedMillis2;
        latestRunTimeElapsedMillis2 = r4;
        goto L14
    L12:
        r4 = Long.MAX_VALUE;
        goto L13
    L8:
        earliestRunTimeElapsedMillis2 = 0;
        goto L10
    }

    private long generateLoggingId(String namespace, int jobId) {
        if (namespace != null) goto L6;
        return jobId;
    L6:
        return (((long) namespace.hashCode()) << 31) | ((long) jobId);
    }

    private static String generateNamespaceHash(String namespace) {
        if (namespace != null) goto L6;
        return null;
    L6:
        if (namespace.trim().isEmpty() == false) goto L8;
        return namespace;
    L8:
        ArrayMap<String, String> r0 = sNamespaceHashCache;
        monitor-enter(r0);
        int idx = sNamespaceHashCache.indexOfKey(namespace);     // Catch: Throwable -> L15
        if (idx < 0) goto L18;
        String r2 = sNamespaceHashCache.valueAt(idx);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r2;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
        String hash = null;
    L23:
        e = move-exception;
        Slog.wtf(TAG, "Couldn't hash input", e);
    L31:
        if (hash != null) goto L34;
        return "failed_namespace_hash";
    L34:
        String hash2 = hash.intern();
        ArrayMap<String, String> r3 = sNamespaceHashCache;
        monitor-enter(r3);
    L39:
        th = move-exception;
        throw th;
    L37:
        if (sNamespaceHashCache.size() < 128) goto L41;
        sNamespaceHashCache.removeAt(new Random().nextInt(128));     // Catch: Throwable -> L39
    L41:
        sNamespaceHashCache.put(namespace, hash2);     // Catch: Throwable -> L39
        monitor-exit(r3);     // Catch: Throwable -> L39
        return hash2;
    L21:
        if (sMessageDigest != null) goto L25;
        sMessageDigest = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L23
    L25:
        byte[] digest = sMessageDigest.digest(namespace.getBytes());     // Catch: Exception -> L23
        StringBuilder hexBuilder = new StringBuilder(digest.length);     // Catch: Exception -> L23
        int r4 = digest.length;     // Catch: Exception -> L23
        int r5 = 0;
    L26:
        if (r5 >= r4) goto L28;
        byte byteChar = digest[r5];     // Catch: Exception -> L23
        hexBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(byteChar)}));     // Catch: Exception -> L23
        r5 = r5 + 1;     // Catch: Exception -> L23
        goto L26
    L28:
        hash = hexBuilder.toString();     // Catch: Exception -> L23
    L15:
        th = move-exception;
        throw th;
    }

    public void enqueueWorkLocked(JobWorkItem work) {
        if (this.pendingWork != null) goto L5;
        this.pendingWork = new ArrayList();
    L5:
        work.setWorkId(this.nextPendingWorkId);
        this.nextPendingWorkId++;
        if (work.getIntent() != null) goto L8;
    L10:
        this.pendingWork.add(work);
        updateNetworkBytesLocked();
        return;
    L8:
        if (GrantedUriPermissions.checkGrantFlags(work.getIntent().getFlags()) == false) goto L10;
        work.setGrants(GrantedUriPermissions.createFromIntent(work.getIntent(), this.sourceUid, this.sourcePackageName, this.sourceUserId, toShortString()));
        goto L10
    }

    public JobWorkItem dequeueWorkLocked() {
        if (this.pendingWork != null) goto L5;
        return null;
    L5:
        if (this.pendingWork.size() <= 0) goto L15;
        JobWorkItem work = this.pendingWork.remove(0);
        if (work != null) goto L9;
    L12:
        return work;
    L9:
        if (this.executingWork != null) goto L11;
        this.executingWork = new ArrayList();
    L11:
        this.executingWork.add(work);
        work.bumpDeliveryCount();
        goto L12
    L15:
        return null;
    }

    public int getWorkCount() {
        int executingCount = 0;
        if (this.pendingWork != null) goto L5;
        int pendingCount = 0;
    L7:
        if (this.executingWork == null) goto L11;
        executingCount = this.executingWork.size();
    L11:
        return pendingCount + executingCount;
    L5:
        pendingCount = this.pendingWork.size();
        goto L7
    }

    public boolean hasWorkLocked() {
        if (this.pendingWork == null) goto L7;
        if (this.pendingWork.size() <= 0) goto L7;
    L8:
        return true;
    L7:
        if (hasExecutingWorkLocked() == true) goto L8;
        return false;
    }

    public boolean hasExecutingWorkLocked() {
        if (this.executingWork != null) goto L5;
    L7:
        return false;
    L5:
        if (this.executingWork.size() <= 0) goto L7;
        return true;
    }

    private static void ungrantWorkItem(JobWorkItem work) {
        if (work.getGrants() == null) goto L6;
        ((GrantedUriPermissions) work.getGrants()).revoke();
        return;
    }

    public boolean completeWorkLocked(int workId) {
        if (this.executingWork == null) goto L11;
        int N = this.executingWork.size();
        int i = 0;
    L5:
        if (i >= N) goto L15;
        JobWorkItem work = this.executingWork.get(i);
        if (work.getWorkId() == workId) goto L8;
        i = i + 1;
        goto L5
    L8:
        this.executingWork.remove(i);
        ungrantWorkItem(work);
        updateNetworkBytesLocked();
        return true;
    L15:
        return false;
    L11:
        return false;
    }

    private static void ungrantWorkList(ArrayList<JobWorkItem> list) {
        if (list == null) goto L6;
        int N = list.size();
        int i = 0;
    L4:
        if (i >= N) goto L8;
        ungrantWorkItem(list.get(i));
        i = i + 1;
        goto L4
    L8:
        return;
    }

    public void stopTrackingJobLocked(JobStatus incomingJob) {
        if (incomingJob != null) goto L5;
        ungrantWorkList(this.pendingWork);
        this.pendingWork = null;
        ungrantWorkList(this.executingWork);
        this.executingWork = null;
    L19:
        updateNetworkBytesLocked();
        return;
    L5:
        if (this.executingWork == null) goto L10;
        if (this.executingWork.size() <= 0) goto L10;
        incomingJob.pendingWork = this.executingWork;
    L10:
        if (incomingJob.pendingWork != null) goto L13;
        incomingJob.pendingWork = this.pendingWork;
    L17:
        this.pendingWork = null;
        this.executingWork = null;
        incomingJob.nextPendingWorkId = this.nextPendingWorkId;
        incomingJob.updateNetworkBytesLocked();
        goto L19
    L13:
        if (this.pendingWork == null) goto L17;
        if (this.pendingWork.size() <= 0) goto L17;
        incomingJob.pendingWork.addAll(this.pendingWork);
        goto L17
    }

    public void prepareLocked() {
        if (this.prepared == false) goto L6;
        Slog.wtf(TAG, "Already prepared: " + this);
        return;
    L6:
        this.prepared = true;
        this.unpreparedPoint = null;
        ClipData clip = this.job.getClipData();
        if (clip == null) goto L10;
        this.uriPerms = GrantedUriPermissions.createFromClip(clip, this.sourceUid, this.sourcePackageName, this.sourceUserId, this.job.getClipGrantFlags(), toShortString());
        return;
    }

    public void unprepareLocked() {
        if (this.prepared == true) goto L8;
        Slog.wtf(TAG, "Hasn't been prepared: " + this);
        if (this.unpreparedPoint == null) goto L12;
        Slog.e(TAG, "Was already unprepared at ", this.unpreparedPoint);
        return;
    L12:
        return;
    L8:
        this.prepared = false;
        this.unpreparedPoint = new Throwable().fillInStackTrace();
        if (this.uriPerms == null) goto L13;
        this.uriPerms.revoke();
        this.uriPerms = null;
        return;
    }

    public boolean isPreparedLocked() {
        return this.prepared;
    }

    public JobInfo getJob() {
        return this.job;
    }

    public int getJobId() {
        return this.job.getId();
    }

    public long getLoggingJobId() {
        return this.mLoggingJobId;
    }

    public String getAppTraceTag() {
        return this.job.getTraceTag();
    }

    public boolean isAbandoned() {
        return this.mIsAbandoned;
    }

    public void setAbandoned(boolean abandoned) {
        this.mIsAbandoned = abandoned;
    }

    public String computeSystemTraceTag() {
        if (this.mSystemTraceTag != null) goto L5;
        this.mSystemTraceTag = computeSystemTraceTagInner();
        return this.mSystemTraceTag;
    L5:
        return this.mSystemTraceTag;
    }

    private String computeSystemTraceTagInner() {
        String componentPackage = getServiceComponent().getPackageName();
        StringBuilder traceTag = new StringBuilder(128);
        traceTag.append("*job*<");
        traceTag.append(this.sourceUid);
        traceTag.append(">");
        traceTag.append(this.sourcePackageName);
        if (this.sourcePackageName.equals(componentPackage) == true) goto L5;
        traceTag.append(":");
        traceTag.append(componentPackage);
    L5:
        traceTag.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        traceTag.append(getServiceComponent().getShortClassName());
        if (componentPackage.equals(this.serviceProcessName) == true) goto L9;
        traceTag.append("$");
        traceTag.append(this.serviceProcessName);
    L9:
        if (this.mNamespace != null) goto L11;
    L13:
        traceTag.append("#");
        traceTag.append(getJobId());
        return traceTag.toString();
    L11:
        if (this.mNamespace.trim().isEmpty() == true) goto L13;
        traceTag.append("@");
        traceTag.append(this.mNamespace);
        goto L13
    }

    public boolean isProxyJob() {
        return this.mIsProxyJob;
    }

    public void printUniqueId(PrintWriter pw) {
        if (this.mNamespace == null) goto L5;
        pw.print(this.mNamespace);
        pw.print(":");
    L6:
        UserHandle.formatUid(pw, this.callingUid);
        pw.print(SliceClientPermissions.SliceAuthority.DELIMITER);
        pw.print(this.job.getId());
        return;
    L5:
        pw.print("#");
        goto L6
    }

    public int getNumFailures() {
        return this.numFailures;
    }

    public int getNumAbandonedFailures() {
        return this.mNumAbandonedFailures;
    }

    public int getNumSystemStops() {
        return this.mNumSystemStops;
    }

    public int getNumPreviousAttempts() {
        return this.numFailures + this.mNumSystemStops;
    }

    public ComponentName getServiceComponent() {
        return this.job.getService();
    }

    public String getCallingPackageName() {
        return this.job.getService().getPackageName();
    }

    public String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public int getSourceUid() {
        return this.sourceUid;
    }

    public int getSourceUserId() {
        return this.sourceUserId;
    }

    public int getUserId() {
        return UserHandle.getUserId(this.callingUid);
    }

    private boolean shouldBlameSourceForTimeout() {
        return UserHandle.isCore(this.callingUid);
    }

    public String getTimeoutBlamePackageName() {
        if (shouldBlameSourceForTimeout() == false) goto L7;
        return this.sourcePackageName;
    L7:
        return getServiceComponent().getPackageName();
    }

    public int getTimeoutBlameUid() {
        if (shouldBlameSourceForTimeout() == false) goto L7;
        return this.sourceUid;
    L7:
        return this.callingUid;
    }

    public int getTimeoutBlameUserId() {
        if (shouldBlameSourceForTimeout() == false) goto L7;
        return this.sourceUserId;
    L7:
        return UserHandle.getUserId(this.callingUid);
    }

    public int getEffectiveStandbyBucket() {
        if (this.mJobSchedulerInternal != null) goto L5;
        this.mJobSchedulerInternal = (JobSchedulerInternal) LocalServices.getService(JobSchedulerInternal.class);
    L5:
        boolean isBuggy = this.mJobSchedulerInternal.isAppConsideredBuggy(getUserId(), getServiceComponent().getPackageName(), getTimeoutBlameUserId(), getTimeoutBlamePackageName());
        int actualBucket = getStandbyBucket();
        if (actualBucket != 6) goto L15;
        if (isBuggy == true) goto L9;
    L13:
        return actualBucket;
    L9:
        if (getServiceComponent().getPackageName().equals(this.sourcePackageName) == false) goto L11;
        String pkg = this.sourcePackageName;
    L12:
        Slog.w(TAG, "Exempted app " + pkg + " considered buggy");
        goto L13
    L11:
        pkg = getServiceComponent().getPackageName() + SliceClientPermissions.SliceAuthority.DELIMITER + this.sourcePackageName;
        goto L12
    L15:
        if (this.uidActive == false) goto L17;
        return 0;
    L17:
        if (getJob().isExemptedFromAppStandby() == false) goto L20;
        return 0;
    L20:
        if (actualBucket != 5) goto L22;
    L26:
        int bucketWithBackupExemption = actualBucket;
    L27:
        if (isBuggy == false) goto L33;
        if (bucketWithBackupExemption >= 1) goto L33;
        if (this.mIsDowngradedDueToBuggyApp == true) goto L32;
        Counter.logIncrementWithUid("job_scheduler.value_job_quota_reduced_due_to_buggy_uid", getTimeoutBlameUid());
        this.mIsDowngradedDueToBuggyApp = true;
    L32:
        return 1;
    L33:
        return bucketWithBackupExemption;
    L22:
        if (actualBucket == 4) goto L26;
        if (this.mHasMediaBackupExemption == false) goto L26;
        bucketWithBackupExemption = Math.min(1, actualBucket);
        goto L27
    }

    public int getStandbyBucket() {
        return this.standbyBucket;
    }

    public void setStandbyBucket(int newBucket) {
        if (newBucket != 5) goto L6;
        addDynamicConstraints(DYNAMIC_RESTRICTED_CONSTRAINTS);
    L8:
        this.standbyBucket = newBucket;
        this.mLoggedBucketMismatch = false;
        return;
    L6:
        if (this.standbyBucket != 5) goto L8;
        removeDynamicConstraints(DYNAMIC_RESTRICTED_CONSTRAINTS);
        goto L8
    }

    public void maybeLogBucketMismatch() {
        if (this.mLoggedBucketMismatch == true) goto L6;
        Slog.wtf(TAG, "App " + getSourcePackageName() + " became active but still in NEVER bucket");
        this.mLoggedBucketMismatch = true;
        return;
    }

    public long getWhenStandbyDeferred() {
        return this.whenStandbyDeferred;
    }

    public void setWhenStandbyDeferred(long now) {
        this.whenStandbyDeferred = now;
    }

    public long getFirstForceBatchedTimeElapsed() {
        return this.mFirstForceBatchedTimeElapsed;
    }

    public void setFirstForceBatchedTimeElapsed(long now) {
        this.mFirstForceBatchedTimeElapsed = now;
    }

    public boolean updateMediaBackupExemptionStatus() {
        if (this.mJobSchedulerInternal != null) goto L6;
        this.mJobSchedulerInternal = (JobSchedulerInternal) LocalServices.getService(JobSchedulerInternal.class);
    L6:
        if (this.mHasExemptedMediaUrisOnly == true) goto L8;
    L16:
        boolean hasMediaExemption = false;
    L18:
        if (this.mHasMediaBackupExemption != hasMediaExemption) goto L20;
        return false;
    L20:
        this.mHasMediaBackupExemption = hasMediaExemption;
        return true;
    L8:
        if (this.job.hasLateConstraint() == true) goto L16;
        if (this.job.getRequiredNetwork() == null) goto L16;
        if (getEffectivePriority() < 300) goto L16;
        if (this.sourcePackageName.equals(this.mJobSchedulerInternal.getCloudMediaProviderPackage(this.sourceUserId)) == false) goto L16;
        hasMediaExemption = true;
        goto L18
    }

    public String getNamespace() {
        return this.mNamespace;
    }

    public String getNamespaceHash() {
        return this.mNamespaceHash;
    }

    public String getSourceTag() {
        return this.sourceTag;
    }

    public int getUid() {
        return this.callingUid;
    }

    public String getBatteryName() {
        return this.batteryName;
    }

    static String applyBasicPiiFilters(String val) {
        int i = BASIC_PII_FILTERS.size() - 1;
    L3:
        if (i < 0) goto L6;
        val = BASIC_PII_FILTERS.keyAt(i).matcher(val).replaceAll(BASIC_PII_FILTERS.valueAt(i));
        i = i - 1;
        goto L3
    L6:
        return val;
    }

    public String[] getFilteredDebugTags() {
        if (this.mFilteredDebugTags != null) goto L5;
        ArraySet<String> debugTags = this.job.getDebugTagsArraySet();
        this.mFilteredDebugTags = new String[debugTags.size()];
        int i = 0;
    L8:
        if (i >= this.mFilteredDebugTags.length) goto L11;
        this.mFilteredDebugTags[i] = applyBasicPiiFilters(debugTags.valueAt(i));
        i = i + 1;
        goto L8
    L11:
        return this.mFilteredDebugTags;
    L5:
        return this.mFilteredDebugTags;
    }

    public String getFilteredTraceTag() {
        if (this.mFilteredTraceTag != null) goto L5;
        String rawTag = this.job.getTraceTag();
        if (rawTag != null) goto L10;
        return null;
    L10:
        this.mFilteredTraceTag = applyBasicPiiFilters(rawTag);
        return this.mFilteredTraceTag;
    L5:
        return this.mFilteredTraceTag;
    }

    public String getWakelockTag() {
        if (this.mWakelockTag != null) goto L13;
        this.mWakelockTag = "*job*";
        StringBuilder r0 = new StringBuilder();
        r0.append(this.mWakelockTag);
        if (isRequestedExpeditedJob() == false) goto L8;
        String r1 = "e";
    L11:
        r0.append(r1);
        this.mWakelockTag = r0.toString();
        this.mWakelockTag += SliceClientPermissions.SliceAuthority.DELIMITER + this.batteryName;
        goto L13
    L8:
        if (getJob().isUserInitiated() == false) goto L10;
        r1 = "u";
        goto L11
    L10:
        r1 = ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD;
    L13:
        return this.mWakelockTag;
    }

    public int getBias() {
        return this.job.getBias();
    }

    public int getEffectivePriority() {
        if ((getInternalFlags() & 2) == 0) goto L5;
    L10:
        boolean isDemoted = true;
    L12:
        if (isDemoted == false) goto L14;
        int maxPriority = 400;
    L15:
        int rawPriority = Math.min(maxPriority, this.job.getPriority());
        if (this.numFailures >= 2) goto L19;
        return rawPriority;
    L19:
        if (shouldTreatAsUserInitiatedJob() == false) goto L22;
        return rawPriority;
    L22:
        if (isRequestedExpeditedJob() == false) goto L25;
        return 400;
    L25:
        int dropPower = this.numFailures / 2;
        switch(dropPower) {
            case 1: goto L32;
            case 2: goto L30;
            default: goto L27;
        };
    L27:
        return 100;
    L30:
        return Math.min(200, rawPriority);
    L32:
        return Math.min(300, rawPriority);
    L14:
        maxPriority = 500;
        goto L15
    L5:
        if (this.job.isUserInitiated() == true) goto L7;
    L9:
        isDemoted = false;
        goto L12
    L7:
        if ((getInternalFlags() & 4) == 0) goto L9;
        goto L9
    }

    public int getFlags() {
        return this.job.getFlags();
    }

    public int getInternalFlags() {
        return this.mInternalFlags;
    }

    public void addInternalFlags(int flags) {
        this.mInternalFlags |= flags;
    }

    public void removeInternalFlags(int flags) {
        this.mInternalFlags &= ~flags;
    }

    public int getSatisfiedConstraintFlags() {
        return this.satisfiedConstraints;
    }

    public void maybeAddForegroundExemption(Predicate<Integer> uidForegroundChecker) {
        if (this.job.hasEarlyConstraint() == false) goto L5;
        return;
    L5:
        if (this.job.hasLateConstraint() == false) goto L8;
        return;
    L8:
        if ((this.mInternalFlags & 1) == 0) goto L11;
        return;
    L11:
        if (uidForegroundChecker.test(Integer.valueOf(getSourceUid())) == false) goto L15;
        addInternalFlags(1);
        return;
    }

    private void updateNetworkBytesLocked() {
        this.mTotalNetworkDownloadBytes = this.job.getEstimatedNetworkDownloadBytes();
        if (this.mTotalNetworkDownloadBytes >= 0) goto L5;
        this.mTotalNetworkDownloadBytes = -1;
    L5:
        this.mTotalNetworkUploadBytes = this.job.getEstimatedNetworkUploadBytes();
        if (this.mTotalNetworkUploadBytes >= 0) goto L8;
        this.mTotalNetworkUploadBytes = -1;
    L8:
        this.mMinimumNetworkChunkBytes = this.job.getMinimumNetworkChunkBytes();
        if (this.pendingWork == null) goto L36;
        int i = 0;
    L12:
        if (i >= this.pendingWork.size()) goto L41;
        long downloadBytes = this.pendingWork.get(i).getEstimatedNetworkDownloadBytes();
        if (downloadBytes != (-1)) goto L16;
    L21:
        long uploadBytes = this.pendingWork.get(i).getEstimatedNetworkUploadBytes();
        if (uploadBytes != (-1)) goto L24;
    L29:
        long chunkBytes = this.pendingWork.get(i).getMinimumNetworkChunkBytes();
        if (this.mMinimumNetworkChunkBytes != (-1)) goto L33;
        this.mMinimumNetworkChunkBytes = chunkBytes;
    L35:
        i = i + 1;
        goto L12
    L33:
        if (chunkBytes == (-1)) goto L35;
        this.mMinimumNetworkChunkBytes = Math.min(this.mMinimumNetworkChunkBytes, chunkBytes);
        goto L35
    L24:
        if (uploadBytes <= 0) goto L29;
        if (this.mTotalNetworkUploadBytes == (-1)) goto L28;
        this.mTotalNetworkUploadBytes += uploadBytes;
        goto L29
    L28:
        this.mTotalNetworkUploadBytes = uploadBytes;
        goto L29
    L16:
        if (downloadBytes <= 0) goto L21;
        if (this.mTotalNetworkDownloadBytes == (-1)) goto L20;
        this.mTotalNetworkDownloadBytes += downloadBytes;
        goto L21
    L20:
        this.mTotalNetworkDownloadBytes = downloadBytes;
        goto L21
    L41:
        return;
    }

    public long getEstimatedNetworkDownloadBytes() {
        return this.mTotalNetworkDownloadBytes;
    }

    public long getEstimatedNetworkUploadBytes() {
        return this.mTotalNetworkUploadBytes;
    }

    public long getMinimumNetworkChunkBytes() {
        return this.mMinimumNetworkChunkBytes;
    }

    public boolean hasConnectivityConstraint() {
        if ((this.requiredConstraints & 268435456) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasChargingConstraint() {
        return hasConstraint(1);
    }

    public boolean hasBatteryNotLowConstraint() {
        return hasConstraint(2);
    }

    boolean hasPowerConstraint() {
        return hasConstraint(3);
    }

    public boolean hasStorageNotLowConstraint() {
        return hasConstraint(8);
    }

    public boolean hasObricBusinessConstraint() {
        return hasConstraint(512);
    }

    public boolean hasTimingDelayConstraint() {
        return hasConstraint(Integer.MIN_VALUE);
    }

    public boolean hasDeadlineConstraint() {
        return hasConstraint(1073741824);
    }

    public boolean hasIdleConstraint() {
        return hasConstraint(4);
    }

    public boolean hasContentTriggerConstraint() {
        if ((this.requiredConstraints & 67108864) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlexibilityConstraint() {
        if ((this.requiredConstraints & 2097152) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getNumAppliedFlexibleConstraints() {
        return this.mNumAppliedFlexibleConstraints;
    }

    public int getNumRequiredFlexibleConstraints() {
        return this.mNumAppliedFlexibleConstraints - this.mNumDroppedFlexibleConstraints;
    }

    public int getNumDroppedFlexibleConstraints() {
        return this.mNumDroppedFlexibleConstraints;
    }

    private boolean hasConstraint(int constraint) {
        if ((this.requiredConstraints & constraint) == 0) goto L5;
    L8:
        return true;
    L5:
        if ((this.mDynamicConstraints & constraint) != 0) goto L8;
        return false;
    }

    public long getTriggerContentUpdateDelay() {
        long time = this.job.getTriggerContentUpdateDelay();
        if (time >= 0) goto L7;
        return DEFAULT_TRIGGER_UPDATE_DELAY;
    L7:
        return Math.max(time, 500);
    }

    public long getTriggerContentMaxDelay() {
        long time = this.job.getTriggerContentMaxDelay();
        if (time >= 0) goto L7;
        return 120000;
    L7:
        return Math.max(time, 1000);
    }

    public boolean isPersisted() {
        return this.job.isPersisted();
    }

    public long getCumulativeExecutionTimeMs() {
        return this.mCumulativeExecutionTimeMs;
    }

    public void incrementCumulativeExecutionTime(long incrementMs) {
        this.mCumulativeExecutionTimeMs += incrementMs;
    }

    public long getEarliestRunTime() {
        return this.earliestRunTimeElapsedMillis;
    }

    public long getLatestRunTimeElapsed() {
        return this.latestRunTimeElapsedMillis;
    }

    public long getOriginalLatestRunTimeElapsed() {
        return this.mOriginalLatestRunTimeElapsedMillis;
    }

    public void setOriginalLatestRunTimeElapsed(long latestRunTimeElapsed) {
        this.mOriginalLatestRunTimeElapsedMillis = latestRunTimeElapsed;
    }

    boolean areTransportAffinitiesSatisfied() {
        return this.mTransportAffinitiesSatisfied;
    }

    void setTransportAffinitiesSatisfied(boolean isSatisfied) {
        this.mTransportAffinitiesSatisfied = isSatisfied;
    }

    public boolean canApplyTransportAffinities() {
        return this.mCanApplyTransportAffinities;
    }

    public int getStopReason() {
        return this.mReasonReadyToUnready;
    }

    public float getFractionRunTime() {
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (this.earliestRunTimeElapsedMillis != 0) goto L8;
        if (this.latestRunTimeElapsedMillis != Long.MAX_VALUE) goto L8;
        return 1.0f;
    L8:
        if (this.earliestRunTimeElapsedMillis != 0) goto L15;
        if (now < this.latestRunTimeElapsedMillis) goto L13;
        return 1.0f;
    L13:
        return 0.0f;
    L15:
        if (this.latestRunTimeElapsedMillis != Long.MAX_VALUE) goto L22;
        if (now < this.earliestRunTimeElapsedMillis) goto L20;
        return 1.0f;
    L20:
        return 0.0f;
    L22:
        if (now > this.earliestRunTimeElapsedMillis) goto L25;
        return 0.0f;
    L25:
        if (now < this.latestRunTimeElapsedMillis) goto L28;
        return 1.0f;
    L28:
        return (now - this.earliestRunTimeElapsedMillis) / (this.latestRunTimeElapsedMillis - this.earliestRunTimeElapsedMillis);
    }

    public Pair<Long, Long> getPersistedUtcTimes() {
        return this.mPersistedUtcTimes;
    }

    public void clearPersistedUtcTimes() {
        this.mPersistedUtcTimes = null;
    }

    public boolean isRequestedExpeditedJob() {
        if ((getFlags() & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean shouldTreatAsExpeditedJob() {
        if (this.mExpeditedQuotaApproved == true) goto L5;
    L7:
        return false;
    L5:
        if (isRequestedExpeditedJob() == false) goto L7;
        return true;
    }

    public boolean shouldTreatAsUserInitiatedJob() {
        if (getJob().isUserInitiated() == true) goto L5;
    L9:
        return false;
    L5:
        if ((getInternalFlags() & 2) != 0) goto L9;
        if ((getInternalFlags() & 4) != 0) goto L9;
        return true;
    }

    public UserVisibleJobSummary getUserVisibleJobSummary() {
        if (this.mUserVisibleJobSummary != null) goto L6;
        this.mUserVisibleJobSummary = new UserVisibleJobSummary(this.callingUid, getServiceComponent().getPackageName(), getSourceUserId(), getSourcePackageName(), getNamespace(), getJobId());
    L6:
        return this.mUserVisibleJobSummary;
    }

    public boolean isUserVisibleJob() {
        if (shouldTreatAsUserInitiatedJob() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.startedAsUserInitiatedJob == true) goto L8;
        return false;
    }

    public boolean canRunInDoze() {
        if (this.appHasDozeExemption == false) goto L5;
        return true;
    L5:
        if ((getFlags() & 1) == 0) goto L7;
        return true;
    L7:
        if (shouldTreatAsUserInitiatedJob() == false) goto L9;
        return true;
    L9:
        if (shouldTreatAsExpeditedJob() == true) goto L13;
        if (this.startedAsExpeditedJob == true) goto L13;
    L15:
        return false;
    L13:
        if ((this.mDynamicConstraints & 33554432) != 0) goto L15;
        return true;
    }

    boolean canRunInBatterySaver() {
        if ((getInternalFlags() & 1) == 0) goto L5;
        return true;
    L5:
        if (shouldTreatAsUserInitiatedJob() == false) goto L7;
        return true;
    L7:
        if (shouldTreatAsExpeditedJob() == true) goto L11;
        if (this.startedAsExpeditedJob == true) goto L11;
    L13:
        return false;
    L11:
        if ((this.mDynamicConstraints & 4194304) != 0) goto L13;
        return true;
    }

    public boolean isUserBgRestricted() {
        return this.mIsUserBgRestricted;
    }

    boolean setChargingConstraintSatisfied(long nowElapsed, boolean state) {
        return setConstraintSatisfied(1, nowElapsed, state);
    }

    boolean setBatteryNotLowConstraintSatisfied(long nowElapsed, boolean state) {
        return setConstraintSatisfied(2, nowElapsed, state);
    }

    boolean setStorageNotLowConstraintSatisfied(long nowElapsed, boolean state) {
        return setConstraintSatisfied(8, nowElapsed, state);
    }

    boolean setPrefetchConstraintSatisfied(long nowElapsed, boolean state) {
        return setConstraintSatisfied(8388608, nowElapsed, state);
    }

    boolean setTimingDelayConstraintSatisfied(long nowElapsed, boolean state) {
        return setConstraintSatisfied(Integer.MIN_VALUE, nowElapsed, state);
    }

    boolean setDeadlineConstraintSatisfied(long nowElapsed, boolean state) {
        boolean r1 = false;
        if (setConstraintSatisfied(1073741824, nowElapsed, state) == true) goto L5;
        return false;
    L5:
        if (this.job.isPeriodic() == false) goto L7;
    L10:
        this.mReadyDeadlineSatisfied = r1;
        return true;
    L7:
        if (hasDeadlineConstraint() == false) goto L10;
        if (state == false) goto L10;
        r1 = true;
        goto L10
    }

    boolean setIdleConstraintSatisfied(long nowElapsed, boolean state) {
        return setConstraintSatisfied(4, nowElapsed, state);
    }

    boolean setConnectivityConstraintSatisfied(long nowElapsed, boolean state) {
        return setConstraintSatisfied(268435456, nowElapsed, state);
    }

    boolean setContentTriggerConstraintSatisfied(long nowElapsed, boolean state) {
        return setConstraintSatisfied(67108864, nowElapsed, state);
    }

    boolean setDeviceNotDozingConstraintSatisfied(long nowElapsed, boolean state, boolean whitelisted) {
        this.appHasDozeExemption = whitelisted;
        boolean r1 = false;
        if (setConstraintSatisfied(33554432, nowElapsed, state) == true) goto L5;
        return false;
    L5:
        if (state == false) goto L7;
    L8:
        r1 = true;
    L9:
        this.mReadyNotDozing = r1;
        return true;
    L7:
        if (canRunInDoze() == false) goto L9;
        goto L8
    }

    boolean setBackgroundNotRestrictedConstraintSatisfied(long nowElapsed, boolean state, boolean isUserBgRestricted) {
        this.mIsUserBgRestricted = isUserBgRestricted;
        if (setConstraintSatisfied(4194304, nowElapsed, state) == false) goto L6;
        this.mReadyNotRestrictedInBg = state;
        return true;
    L6:
        return false;
    }

    boolean setQuotaConstraintSatisfied(long nowElapsed, boolean state) {
        if (setConstraintSatisfied(16777216, nowElapsed, state) == false) goto L6;
        this.mReadyWithinQuota = state;
        return true;
    L6:
        return false;
    }

    boolean setFlexibilityConstraintSatisfied(long nowElapsed, boolean state) {
        return setConstraintSatisfied(2097152, nowElapsed, state);
    }

    boolean setObricBusinessConstraintSatisfied(long nowElapsed, boolean state) {
        return setConstraintSatisfied(512, nowElapsed, state);
    }

    boolean setExpeditedJobQuotaApproved(long nowElapsed, boolean state) {
        if (this.mExpeditedQuotaApproved != state) goto L6;
        return false;
    L6:
        if (state == false) goto L8;
    L10:
        boolean wasReady = false;
    L11:
        this.mExpeditedQuotaApproved = state;
        updateExpeditedDependencies();
        boolean isReady = isReady();
        if (wasReady == false) goto L15;
        if (isReady == true) goto L15;
        this.mReasonReadyToUnready = 10;
    L18:
        return true;
    L15:
        if (wasReady == true) goto L18;
        if (isReady == false) goto L18;
        this.mReasonReadyToUnready = 0;
        goto L18
    L8:
        if (isReady() == false) goto L10;
        wasReady = true;
        goto L11
    }

    private void updateExpeditedDependencies() {
        if (isConstraintSatisfied(33554432) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.mReadyNotDozing = r0;
        return;
    L5:
        if (canRunInDoze() == true) goto L8;
        r0 = false;
        goto L9
    }

    boolean setUidActive(boolean newActiveState) {
        if (newActiveState == this.uidActive) goto L6;
        this.uidActive = newActiveState;
        return true;
    L6:
        return false;
    }

    boolean setConstraintSatisfied(int constraint, long nowElapsed, boolean state) {
        if ((this.satisfiedConstraints & constraint) == 0) goto L5;
        boolean old = true;
    L6:
        if (old != state) goto L9;
        return false;
    L9:
        if (DEBUG == false) goto L15;
        StringBuilder r3 = new StringBuilder();
        r3.append("Constraint ");
        r3.append(constraint);
        r3.append(" is ");
        if (state == true) goto L13;
        String r4 = "NOT ";
    L14:
        r3.append(r4);
        r3.append("satisfied for ");
        r3.append(toShortString());
        Slog.v(TAG, r3.toString());
        goto L15
    L13:
        r4 = "";
    L15:
        if (state == false) goto L17;
    L19:
        boolean wasReady = false;
    L20:
        int r5 = this.satisfiedConstraints & (~constraint);
        if (state == false) goto L23;
        int r6 = constraint;
    L24:
        this.satisfiedConstraints = r5 | r6;
        this.mSatisfiedConstraintsOfInterest = this.satisfiedConstraints & CONSTRAINTS_OF_INTEREST;
        if (this.mDynamicConstraints != 0) goto L27;
    L29:
        boolean r7 = false;
    L30:
        this.mReadyDynamicSatisfied = r7;
        this.mConstraintUpdatedTimesElapsed[this.mConstraintChangeHistoryIndex] = nowElapsed;
        this.mConstraintStatusHistory[this.mConstraintChangeHistoryIndex] = this.satisfiedConstraints;
        this.mConstraintChangeHistoryIndex = (this.mConstraintChangeHistoryIndex + 1) % 10;
        boolean isReady = readinessStatusWithConstraint(constraint, state);
        if (wasReady == false) goto L34;
        if (isReady == true) goto L34;
        this.mReasonReadyToUnready = constraintToStopReason(constraint);
    L37:
        int unsatisfiedConstraints = (~this.satisfiedConstraints) & ((this.requiredConstraints | this.mDynamicConstraints) | IMPLICIT_CONSTRAINTS);
        populatePendingJobReasonsHistoryMap(isReady, nowElapsed, unsatisfiedConstraints);
        int historySize = this.mPendingJobReasonsHistory.size();
        if (historySize < 25) goto L40;
        this.mPendingJobReasonsHistory.subList(0, historySize - 10).clear();
    L40:
        return true;
    L34:
        if (wasReady == true) goto L37;
        if (isReady == false) goto L37;
        this.mReasonReadyToUnready = 0;
        goto L37
    L27:
        if (this.mDynamicConstraints != (this.satisfiedConstraints & this.mDynamicConstraints)) goto L29;
        r7 = true;
        goto L30
    L23:
        r6 = 0;
        goto L24
    L17:
        if (isReady() == false) goto L19;
        wasReady = true;
        goto L20
    L5:
        old = false;
        goto L6
    }

    private int constraintToStopReason(int constraint) {
        switch(constraint) {
            case 1: goto L32;
            case 2: goto L27;
            case 4: goto L22;
            case 8: goto L19;
            case 2097152: goto L18;
            case 4194304: goto L14;
            case 8388608: goto L11;
            case 16777216: goto L9;
            case 33554432: goto L8;
            case 268435456: goto L6;
            default: goto L4;
        };
    L4:
        Slog.wtf(TAG, "Unsupported constraint (" + constraint + ") --stop reason mapping");
        return 0;
    L6:
        return 7;
    L8:
        return 4;
    L9:
        return 10;
    L11:
        return 15;
    L18:
        return 0;
    L19:
        return 9;
    L14:
        if (this.mIsUserBgRestricted == false) goto L17;
        return 11;
    L17:
        return 4;
    L22:
        if ((this.requiredConstraints & constraint) == 0) goto L25;
        return 8;
    L25:
        return 12;
    L27:
        if ((this.requiredConstraints & constraint) == 0) goto L30;
        return 5;
    L30:
        return 12;
    L32:
        if ((this.requiredConstraints & constraint) == 0) goto L35;
        return 6;
    L35:
        return 12;
    }

    public ArrayList<Integer> constraintsToPendingJobReasons(int unsatisfiedConstraints) {
        ArrayList<Integer> reasons = new ArrayList();
        if ((4194304 & unsatisfiedConstraints) == 0) goto L9;
        if (this.mIsUserBgRestricted == false) goto L7;
        reasons.addLast(3);
        goto L9
    L7:
        reasons.addLast(12);
    L9:
        if ((33554432 & unsatisfiedConstraints) == 0) goto L14;
        if (reasons.contains(12) == true) goto L14;
        reasons.addLast(12);
    L14:
        if ((unsatisfiedConstraints & 2) == 0) goto L20;
        if ((this.requiredConstraints & 2) == 0) goto L18;
        reasons.addLast(4);
        goto L20
    L18:
        reasons.addLast(2);
    L20:
        if ((unsatisfiedConstraints & 1) == 0) goto L28;
        if ((this.requiredConstraints & 1) == 0) goto L25;
        reasons.addLast(5);
        goto L28
    L25:
        if (reasons.contains(2) == true) goto L28;
        reasons.addLast(2);
    L28:
        if ((unsatisfiedConstraints & 4) == 0) goto L36;
        if ((this.requiredConstraints & 4) == 0) goto L33;
        reasons.addLast(8);
        goto L36
    L33:
        if (reasons.contains(2) == true) goto L36;
        reasons.addLast(2);
    L36:
        if ((268435456 & unsatisfiedConstraints) == 0) goto L39;
        reasons.addLast(6);
    L39:
        if ((67108864 & unsatisfiedConstraints) == 0) goto L42;
        reasons.addLast(7);
    L42:
        if ((2097152 & unsatisfiedConstraints) == 0) goto L45;
        reasons.addLast(13);
    L45:
        if ((8388608 & unsatisfiedConstraints) == 0) goto L48;
        reasons.addLast(10);
    L48:
        if ((unsatisfiedConstraints & 8) == 0) goto L51;
        reasons.addLast(11);
    L51:
        if ((Integer.MIN_VALUE & unsatisfiedConstraints) == 0) goto L54;
        reasons.addLast(9);
    L54:
        if ((16777216 & unsatisfiedConstraints) == 0) goto L57;
        reasons.addLast(14);
    L57:
        if ((1073741824 & unsatisfiedConstraints) == 0) goto L59;
        reasons.addLast(16);
    L59:
        return reasons;
    }

    public int[] getPendingJobReasons(JobRestriction restriction) {
        int unsatisfiedConstraints = (~this.satisfiedConstraints) & ((this.requiredConstraints | this.mDynamicConstraints) | IMPLICIT_CONSTRAINTS);
        ArrayList<Integer> reasons = constraintsToPendingJobReasons(unsatisfiedConstraints);
        if (restriction == null) goto L8;
        int reason = restriction.getPendingReason();
        if (reasons.contains(Integer.valueOf(reason)) == true) goto L8;
        reasons.addLast(Integer.valueOf(reason));
    L8:
        if (reasons.isEmpty() == true) goto L10;
    L16:
        int[] reasonsArr = new int[reasons.size()];
        int i = 0;
    L18:
        if (i >= reasonsArr.length) goto L21;
        reasonsArr[i] = reasons.get(i).intValue();
        i = i + 1;
        goto L18
    L21:
        return reasonsArr;
    L10:
        if (getEffectiveStandbyBucket() != 4) goto L13;
        Slog.wtf(TAG, "App in NEVER bucket querying pending job reason");
        reasons.add(15);
        goto L16
    L13:
        if (this.serviceProcessName == null) goto L15;
        reasons.add(1);
        goto L16
    L15:
        reasons.add(0);
        goto L16
    }

    private void populatePendingJobReasonsHistoryMap(boolean isReady, long constraintTimestamp, int unsatisfiedConstraints) {
        long constraintTimestampEpoch = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + constraintTimestamp;
        int r2 = 0;
        if (isReady == false) goto L10;
        List<PendingJobReasonsInfo> r3 = this.mPendingJobReasonsHistory;
        if (this.serviceProcessName == null) goto L8;
        r2 = 1;
    L8:
        r3.addLast(new PendingJobReasonsInfo(constraintTimestampEpoch, new int[]{r2}));
        return;
    L10:
        ArrayList<Integer> reasons = constraintsToPendingJobReasons(unsatisfiedConstraints);
        if (reasons.isEmpty() == false) goto L13;
        reasons.add(0);
    L13:
        int[] reasonsArr = new int[reasons.size()];
        int i = 0;
    L15:
        if (i >= reasonsArr.length) goto L17;
        reasonsArr[i] = reasons.get(i).intValue();
        i = i + 1;
        goto L15
    L17:
        this.mPendingJobReasonsHistory.addLast(new PendingJobReasonsInfo(constraintTimestampEpoch, reasonsArr));
    }

    public List<PendingJobReasonsInfo> getPendingJobReasonsHistory() {
        List<PendingJobReasonsInfo> returnList = new ArrayList(10);
        int historySize = this.mPendingJobReasonsHistory.size();
        if (historySize == 0) goto L5;
        returnList.addAll(this.mPendingJobReasonsHistory.subList(Math.max(0, historySize - 10), historySize));
    L5:
        return returnList;
    }

    public boolean isConstraintSatisfied(int constraint) {
        if ((this.satisfiedConstraints & constraint) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isExpeditedQuotaApproved() {
        return this.mExpeditedQuotaApproved;
    }

    boolean clearTrackingController(int which) {
        if ((this.trackingControllers & which) == 0) goto L6;
        this.trackingControllers &= ~which;
        return true;
    L6:
        return false;
    }

    void setTrackingController(int which) {
        this.trackingControllers |= which;
    }

    public void setNumAppliedFlexibleConstraints(int count) {
        this.mNumAppliedFlexibleConstraints = count;
    }

    public void setNumDroppedFlexibleConstraints(int count) {
        this.mNumDroppedFlexibleConstraints = Math.max(0, Math.min(this.mNumAppliedFlexibleConstraints, count));
    }

    public void disallowRunInBatterySaverAndDoze() {
        addDynamicConstraints(DYNAMIC_EXPEDITED_DEFERRAL_CONSTRAINTS);
    }

    public void addDynamicConstraints(int constraints) {
        if ((16777216 & constraints) == 0) goto L6;
        Slog.wtf(TAG, "Tried to set quota as a dynamic constraint");
        constraints = constraints & (-16777217);
    L6:
        if (hasConnectivityConstraint() == true) goto L9;
        constraints = constraints & (-268435457);
    L9:
        if (hasContentTriggerConstraint() == true) goto L11;
        constraints = constraints & (-67108865);
    L11:
        this.mDynamicConstraints |= constraints;
        if (this.mDynamicConstraints != 0) goto L14;
    L16:
        boolean r0 = false;
    L17:
        this.mReadyDynamicSatisfied = r0;
        return;
    L14:
        if (this.mDynamicConstraints != (this.satisfiedConstraints & this.mDynamicConstraints)) goto L16;
        r0 = true;
        goto L17
    }

    private void removeDynamicConstraints(int constraints) {
        this.mDynamicConstraints &= ~constraints;
        if (this.mDynamicConstraints != 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.mReadyDynamicSatisfied = r0;
        return;
    L5:
        if (this.mDynamicConstraints != (this.satisfiedConstraints & this.mDynamicConstraints)) goto L7;
        r0 = true;
        goto L8
    }

    public long getLastSuccessfulRunTime() {
        return this.mLastSuccessfulRunTime;
    }

    public long getLastFailedRunTime() {
        return this.mLastFailedRunTime;
    }

    public boolean isReady() {
        return isReady(this.mSatisfiedConstraintsOfInterest);
    }

    public boolean wouldBeReadyWithConstraint(int constraint) {
        return readinessStatusWithConstraint(constraint, true);
    }

    boolean readinessStatusWithConstraint(int constraint, boolean value) {
        boolean oldValue = false;
        int satisfied = this.mSatisfiedConstraintsOfInterest;
        boolean r2 = false;
        switch(constraint) {
            case 4194304: goto L17;
            case 16777216: goto L16;
            case 33554432: goto L15;
            case 1073741824: goto L14;
            default: goto L4;
        };
    L4:
        if (value == false) goto L6;
        satisfied = satisfied | constraint;
    L8:
        if (this.mDynamicConstraints != 0) goto L10;
    L12:
        boolean r4 = false;
    L13:
        this.mReadyDynamicSatisfied = r4;
    L19:
        if (constraint == 2097152) goto L21;
        satisfied = satisfied | 2097152;
    L21:
        boolean toReturn = isReady(satisfied);
        switch(constraint) {
            case 4194304: goto L32;
            case 16777216: goto L31;
            case 33554432: goto L30;
            case 1073741824: goto L29;
            default: goto L24;
        };
    L29:
        this.mReadyDeadlineSatisfied = oldValue;
    L33:
        return toReturn;
    L30:
        this.mReadyNotDozing = oldValue;
        goto L33
    L31:
        this.mReadyWithinQuota = oldValue;
        goto L33
    L32:
        this.mReadyNotRestrictedInBg = oldValue;
        goto L33
    L24:
        if (this.mDynamicConstraints != 0) goto L26;
    L28:
        this.mReadyDynamicSatisfied = r2;
        goto L33
    L26:
        if (this.mDynamicConstraints != (this.satisfiedConstraints & this.mDynamicConstraints)) goto L28;
        r2 = true;
        goto L28
    L10:
        if (this.mDynamicConstraints != (this.mDynamicConstraints & satisfied)) goto L12;
        r4 = true;
        goto L13
    L6:
        satisfied = satisfied & (~constraint);
        goto L8
    L14:
        oldValue = this.mReadyDeadlineSatisfied;
        this.mReadyDeadlineSatisfied = value;
        goto L19
    L15:
        oldValue = this.mReadyNotDozing;
        this.mReadyNotDozing = value;
        goto L19
    L16:
        oldValue = this.mReadyWithinQuota;
        this.mReadyWithinQuota = value;
        goto L19
    L17:
        oldValue = this.mReadyNotRestrictedInBg;
        this.mReadyNotRestrictedInBg = value;
        goto L19
    }

    private boolean isReady(int satisfiedConstraints) {
        if (this.mReadyWithinQuota == true) goto L9;
        if (this.mReadyDynamicSatisfied == true) goto L9;
        if (shouldTreatAsExpeditedJob() == true) goto L9;
    L10:
        return false;
    L9:
        if (getEffectiveStandbyBucket() == 4) goto L10;
        if (this.mReadyNotDozing == true) goto L14;
        return false;
    L14:
        if (this.mReadyNotRestrictedInBg == true) goto L16;
        return false;
    L16:
        if (this.serviceProcessName != null) goto L18;
        return false;
    L18:
        if (this.mReadyDeadlineSatisfied == false) goto L20;
    L21:
        return true;
    L20:
        if (isConstraintsSatisfied(satisfiedConstraints) == true) goto L21;
        return false;
    }

    public boolean areDynamicConstraintsSatisfied() {
        return this.mReadyDynamicSatisfied;
    }

    public boolean isConstraintsSatisfied() {
        return isConstraintsSatisfied(this.mSatisfiedConstraintsOfInterest);
    }

    private boolean isConstraintsSatisfied(int satisfiedConstraints) {
        if (this.overrideState != 3) goto L5;
        return true;
    L5:
        int sat = satisfiedConstraints;
        if (this.overrideState != 2) goto L9;
        sat = sat | (this.requiredConstraints & SOFT_OVERRIDE_CONSTRAINTS);
    L9:
        if ((this.mRequiredConstraintsOfInterest & sat) == this.mRequiredConstraintsOfInterest) goto L13;
        return false;
    L13:
        return true;
    }

    public boolean matches(int uid, String namespace, int jobId) {
        if (this.job.getId() == jobId) goto L5;
    L9:
        return false;
    L5:
        if (this.callingUid != uid) goto L9;
        if (Objects.equals(this.mNamespace, namespace) == false) goto L9;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("JobStatus{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mNamespace == null) goto L5;
        sb.append(" ");
        sb.append(this.mNamespace);
        sb.append(":");
    L6:
        UserHandle.formatUid(sb, this.callingUid);
        sb.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        sb.append(this.job.getId());
        sb.append(' ');
        sb.append(this.batteryName);
        sb.append(" u=");
        sb.append(getUserId());
        sb.append(" s=");
        sb.append(getSourceUid());
        if (this.earliestRunTimeElapsedMillis == 0) goto L9;
    L12:
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();
        sb.append(" TIME=");
        JobStatus r2 = this;
        r2.formatRunTime(sb, this.earliestRunTimeElapsedMillis, 0, now);
        sb.append(":");
        r2.formatRunTime(sb, r2.latestRunTimeElapsedMillis, Long.MAX_VALUE, now);
    L14:
        if (r2.job.getRequiredNetwork() == null) goto L17;
        sb.append(" NET");
    L17:
        if (r2.job.isRequireCharging() == false) goto L20;
        sb.append(" CHARGING");
    L20:
        if (r2.job.isRequireBatteryNotLow() == false) goto L23;
        sb.append(" BATNOTLOW");
    L23:
        if (r2.job.isRequireStorageNotLow() == false) goto L26;
        sb.append(" STORENOTLOW");
    L26:
        if (r2.job.isRequireDeviceIdle() == false) goto L29;
        sb.append(" IDLE");
    L29:
        if (r2.job.isPeriodic() == false) goto L32;
        sb.append(" PERIODIC");
    L32:
        if (r2.job.isPersisted() == false) goto L35;
        sb.append(" PERSISTED");
    L35:
        if ((r2.satisfiedConstraints & 33554432) != 0) goto L38;
        sb.append(" WAIT:DEV_NOT_DOZING");
    L38:
        if (r2.job.getTriggerContentUris() == null) goto L41;
        sb.append(" URIS=");
        sb.append(Arrays.toString(r2.job.getTriggerContentUris()));
    L41:
        if (r2.numFailures == 0) goto L44;
        sb.append(" failures=");
        sb.append(r2.numFailures);
    L44:
        if (r2.mNumSystemStops == 0) goto L47;
        sb.append(" system stops=");
        sb.append(r2.mNumSystemStops);
    L47:
        if (isReady() == false) goto L49;
        sb.append(" READY");
    L50:
        sb.append("}");
        return sb.toString();
    L49:
        sb.append(" satisfied:0x");
        sb.append(Integer.toHexString(r2.satisfiedConstraints));
        int requiredConstraints = r2.mRequiredConstraintsOfInterest | IMPLICIT_CONSTRAINTS;
        sb.append(" unsatisfied:0x");
        sb.append(Integer.toHexString((r2.satisfiedConstraints & requiredConstraints) ^ requiredConstraints));
        goto L50
    L9:
        if (this.latestRunTimeElapsedMillis != Long.MAX_VALUE) goto L12;
        r2 = this;
        goto L14
    L5:
        sb.append(" #");
        goto L6
    }

    private void formatRunTime(PrintWriter pw, long runtime, long defaultValue, long now) {
        if (runtime != defaultValue) goto L5;
        pw.print("none");
        return;
    L5:
        TimeUtils.formatDuration(runtime - now, pw);
    }

    private void formatRunTime(StringBuilder sb, long runtime, long defaultValue, long now) {
        if (runtime != defaultValue) goto L5;
        sb.append("none");
        return;
    L5:
        TimeUtils.formatDuration(runtime - now, sb);
    }

    public String toShortString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mNamespace == null) goto L5;
        sb.append(" {");
        sb.append(this.mNamespace);
        sb.append("}");
    L5:
        sb.append(" #");
        UserHandle.formatUid(sb, this.callingUid);
        sb.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        sb.append(this.job.getId());
        sb.append(' ');
        sb.append(this.batteryName);
        return sb.toString();
    }

    public String toShortStringExceptUniqueId() {
        return Integer.toHexString(System.identityHashCode(this)) + ' ' + this.batteryName;
    }

    public void writeToShortProto(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, this.callingUid);
        proto.write(1120986464258L, this.job.getId());
        proto.write(1138166333443L, this.batteryName);
        proto.end(token);
    }

    static void dumpConstraints(PrintWriter pw, int constraints) {
        if ((constraints & 1) == 0) goto L6;
        pw.print(" CHARGING");
    L6:
        if ((constraints & 2) == 0) goto L9;
        pw.print(" BATTERY_NOT_LOW");
    L9:
        if ((constraints & 8) == 0) goto L12;
        pw.print(" STORAGE_NOT_LOW");
    L12:
        if ((Integer.MIN_VALUE & constraints) == 0) goto L15;
        pw.print(" TIMING_DELAY");
    L15:
        if ((1073741824 & constraints) == 0) goto L18;
        pw.print(" DEADLINE");
    L18:
        if ((constraints & 4) == 0) goto L21;
        pw.print(" IDLE");
    L21:
        if ((268435456 & constraints) == 0) goto L24;
        pw.print(" CONNECTIVITY");
    L24:
        if ((2097152 & constraints) == 0) goto L27;
        pw.print(" FLEXIBILITY");
    L27:
        if ((67108864 & constraints) == 0) goto L30;
        pw.print(" CONTENT_TRIGGER");
    L30:
        if ((33554432 & constraints) == 0) goto L33;
        pw.print(" DEVICE_NOT_DOZING");
    L33:
        if ((4194304 & constraints) == 0) goto L36;
        pw.print(" BACKGROUND_NOT_RESTRICTED");
    L36:
        if ((8388608 & constraints) == 0) goto L39;
        pw.print(" PREFETCH");
    L39:
        if ((16777216 & constraints) == 0) goto L42;
        pw.print(" WITHIN_QUOTA");
    L42:
        if ((constraints & 512) == 0) goto L44;
        pw.print(" OBRIC_BUSINESS");
    L44:
        if (constraints == 0) goto L47;
        pw.print(" [0x");
        pw.print(Integer.toHexString(constraints));
        pw.print("]");
        return;
    }

    static int getProtoConstraint(int constraint) {
        switch(constraint) {
            case -2147483648: goto L29;
            case 1: goto L27;
            case 2: goto L25;
            case 4: goto L23;
            case 8: goto L21;
            case 2097152: goto L19;
            case 4194304: goto L17;
            case 8388608: goto L15;
            case 16777216: goto L13;
            case 33554432: goto L11;
            case 67108864: goto L9;
            case 268435456: goto L7;
            case 1073741824: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 5;
    L7:
        return 7;
    L9:
        return 8;
    L11:
        return 9;
    L13:
        return 10;
    L15:
        return 14;
    L17:
        return 11;
    L19:
        return 15;
    L21:
        return 3;
    L23:
        return 6;
    L25:
        return 2;
    L27:
        return 1;
    L29:
        return 4;
    }

    void dumpConstraints(ProtoOutputStream proto, long fieldId, int constraints) {
        if ((constraints & 1) == 0) goto L6;
        proto.write(fieldId, 1);
    L6:
        if ((constraints & 2) == 0) goto L9;
        proto.write(fieldId, 2);
    L9:
        if ((constraints & 8) == 0) goto L12;
        proto.write(fieldId, 3);
    L12:
        if ((Integer.MIN_VALUE & constraints) == 0) goto L15;
        proto.write(fieldId, 4);
    L15:
        if ((1073741824 & constraints) == 0) goto L18;
        proto.write(fieldId, 5);
    L18:
        if ((constraints & 4) == 0) goto L21;
        proto.write(fieldId, 6);
    L21:
        if ((268435456 & constraints) == 0) goto L24;
        proto.write(fieldId, 7);
    L24:
        if ((67108864 & constraints) == 0) goto L27;
        proto.write(fieldId, 8);
    L27:
        if ((33554432 & constraints) == 0) goto L30;
        proto.write(fieldId, 9);
    L30:
        if ((16777216 & constraints) == 0) goto L33;
        proto.write(fieldId, 10);
    L33:
        if ((4194304 & constraints) == 0) goto L36;
        proto.write(fieldId, 11);
        return;
    }

    private void dumpJobWorkItem(IndentingPrintWriter pw, JobWorkItem work, int index) {
        pw.increaseIndent();
        pw.print("#");
        pw.print(index);
        pw.print(": #");
        pw.print(work.getWorkId());
        pw.print(" ");
        pw.print(work.getDeliveryCount());
        pw.print("x ");
        pw.println(work.getIntent());
        if (work.getGrants() == null) goto L5;
        pw.println("URI grants:");
        pw.increaseIndent();
        ((GrantedUriPermissions) work.getGrants()).dump(pw);
        pw.decreaseIndent();
    L5:
        pw.decreaseIndent();
    }

    private void dumpJobWorkItem(ProtoOutputStream proto, long fieldId, JobWorkItem work) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, work.getWorkId());
        proto.write(1120986464258L, work.getDeliveryCount());
        if (work.getIntent() == null) goto L5;
        work.getIntent().dumpDebug(proto, 1146756268035L);
    L5:
        Object grants = work.getGrants();
        if (grants == null) goto L8;
        ((GrantedUriPermissions) grants).dump(proto, 1146756268036L);
    L8:
        proto.end(token);
    }

    String getBucketName() {
        return bucketName(this.standbyBucket);
    }

    static String bucketName(int standbyBucket) {
        switch(standbyBucket) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L5:
        return "EXEMPTED";
    L7:
        return "RESTRICTED";
    L9:
        return "NEVER";
    L11:
        return "RARE";
    L13:
        return "FREQUENT";
    L15:
        return "WORKING_SET";
    L17:
        return "ACTIVE";
    L4:
        return "Unknown: " + standbyBucket;
    }

    @NeverCompile
    public void dump(IndentingPrintWriter pw, boolean full, long nowElapsed) {
        UserHandle.formatUid(pw, this.callingUid);
        pw.print(" tag=");
        pw.println(getWakelockTag());
        pw.print("Source: uid=");
        UserHandle.formatUid(pw, getSourceUid());
        pw.print(" user=");
        pw.print(getSourceUserId());
        pw.print(" pkg=");
        pw.println(getSourcePackageName());
        boolean r1 = true;
        if (full == false) goto L85;
        pw.println("JobInfo:");
        pw.increaseIndent();
        pw.print("Service: ");
        pw.println(this.job.getService().flattenToShortString());
        if (this.job.isPeriodic() == false) goto L8;
        pw.print("PERIODIC: interval=");
        TimeUtils.formatDuration(this.job.getIntervalMillis(), pw);
        pw.print(" flex=");
        TimeUtils.formatDuration(this.job.getFlexMillis(), pw);
        pw.println();
    L8:
        if (this.job.isPersisted() == false) goto L11;
        pw.println("PERSISTED");
    L11:
        if (this.job.getBias() == 0) goto L13;
        pw.print("Bias: ");
        pw.println(JobInfo.getBiasString(this.job.getBias()));
    L13:
        pw.print("Priority: ");
        pw.print(JobInfo.getPriorityString(this.job.getPriority()));
        int effectivePriority = getEffectivePriority();
        if (effectivePriority == this.job.getPriority()) goto L16;
        pw.print(" effective=");
        pw.print(JobInfo.getPriorityString(effectivePriority));
    L16:
        pw.println();
        if (this.job.getFlags() == 0) goto L20;
        pw.print("Flags: ");
        pw.println(Integer.toHexString(this.job.getFlags()));
    L20:
        if (getInternalFlags() == 0) goto L25;
        pw.print("Internal flags: ");
        pw.print(Integer.toHexString(getInternalFlags()));
        if ((getInternalFlags() & 1) == 0) goto L24;
        pw.print(" HAS_FOREGROUND_EXEMPTION");
    L24:
        pw.println();
    L25:
        pw.print("Requires: charging=");
        pw.print(this.job.isRequireCharging());
        pw.print(" batteryNotLow=");
        pw.print(this.job.isRequireBatteryNotLow());
        pw.print(" deviceIdle=");
        pw.println(this.job.isRequireDeviceIdle());
        if (this.job.getTriggerContentUris() == null) goto L39;
        pw.println("Trigger content URIs:");
        pw.increaseIndent();
        int i = 0;
    L29:
        if (i >= this.job.getTriggerContentUris().length) goto L31;
        JobInfo.TriggerContentUri trig = this.job.getTriggerContentUris()[i];
        pw.print(Integer.toHexString(trig.getFlags()));
        pw.print(' ');
        pw.println(trig.getUri());
        i = i + 1;
        goto L29
    L31:
        pw.decreaseIndent();
        if (this.job.getTriggerContentUpdateDelay() < 0) goto L35;
        pw.print("Trigger update delay: ");
        TimeUtils.formatDuration(this.job.getTriggerContentUpdateDelay(), pw);
        pw.println();
    L35:
        if (this.job.getTriggerContentMaxDelay() < 0) goto L37;
        pw.print("Trigger max delay: ");
        TimeUtils.formatDuration(this.job.getTriggerContentMaxDelay(), pw);
        pw.println();
    L37:
        pw.print("Has media backup exemption", Boolean.valueOf(this.mHasMediaBackupExemption)).println();
    L39:
        if (this.job.getExtras() == null) goto L44;
        if (this.job.getExtras().isDefinitelyEmpty() == true) goto L44;
        pw.print("Extras: ");
        pw.println(this.job.getExtras().toShortString());
    L44:
        if (this.job.getTransientExtras() == null) goto L49;
        if (this.job.getTransientExtras().isDefinitelyEmpty() == true) goto L49;
        pw.print("Transient extras: ");
        pw.println(this.job.getTransientExtras().toShortString());
    L49:
        if (this.job.getClipData() == null) goto L52;
        pw.print("Clip data: ");
        StringBuilder b = new StringBuilder(128);
        b.append(this.job.getClipData());
        pw.println(b);
    L52:
        if (this.uriPerms == null) goto L55;
        pw.println("Granted URI permissions:");
        this.uriPerms.dump(pw);
    L55:
        if (this.job.getRequiredNetwork() == null) goto L58;
        pw.print("Network type: ");
        pw.println(this.job.getRequiredNetwork());
    L58:
        if (this.mTotalNetworkDownloadBytes == (-1)) goto L61;
        pw.print("Network download bytes: ");
        pw.println(this.mTotalNetworkDownloadBytes);
    L61:
        if (this.mTotalNetworkUploadBytes == (-1)) goto L64;
        pw.print("Network upload bytes: ");
        pw.println(this.mTotalNetworkUploadBytes);
    L64:
        if (this.mMinimumNetworkChunkBytes == (-1)) goto L67;
        pw.print("Minimum network chunk bytes: ");
        pw.println(this.mMinimumNetworkChunkBytes);
    L67:
        if (this.job.getMinLatencyMillis() == 0) goto L70;
        pw.print("Minimum latency: ");
        TimeUtils.formatDuration(this.job.getMinLatencyMillis(), pw);
        pw.println();
    L70:
        if (this.job.getMaxExecutionDelayMillis() == 0) goto L72;
        pw.print("Max execution delay: ");
        TimeUtils.formatDuration(this.job.getMaxExecutionDelayMillis(), pw);
        pw.println();
    L72:
        pw.print("Backoff: policy=");
        pw.print(this.job.getBackoffPolicy());
        pw.print(" initial=");
        TimeUtils.formatDuration(this.job.getInitialBackoffMillis(), pw);
        pw.println();
        if (this.job.hasEarlyConstraint() == false) goto L76;
        pw.println("Has early constraint");
    L76:
        if (this.job.hasLateConstraint() == false) goto L79;
        pw.println("Has late constraint");
    L79:
        if (this.job.getTraceTag() == null) goto L82;
        pw.print("Trace tag: ");
        pw.println(this.job.getTraceTag());
    L82:
        if (this.job.getDebugTags().size() <= 0) goto L84;
        pw.print("Debug tags: ");
        pw.println(this.job.getDebugTags());
    L84:
        pw.decreaseIndent();
    L85:
        pw.print("Required constraints:");
        dumpConstraints(pw, this.requiredConstraints);
        pw.println();
        pw.print("Dynamic constraints:");
        dumpConstraints(pw, this.mDynamicConstraints);
        pw.println();
        if (full == false) goto L108;
        pw.print("Satisfied constraints:");
        dumpConstraints(pw, this.satisfiedConstraints);
        pw.println();
        pw.print("Unsatisfied constraints:");
        dumpConstraints(pw, (this.requiredConstraints | 16777216) & (~this.satisfiedConstraints));
        pw.println();
        if (hasFlexibilityConstraint() == false) goto L90;
        pw.print("Num Required Flexible constraints: ");
        pw.print(getNumRequiredFlexibleConstraints());
        pw.println();
        pw.print("Num Dropped Flexible constraints: ");
        pw.print(getNumDroppedFlexibleConstraints());
        pw.println();
    L90:
        pw.println("Constraint history:");
        pw.increaseIndent();
        int h = 0;
    L92:
        if (h >= 10) goto L98;
        int idx = (this.mConstraintChangeHistoryIndex + h) % 10;
        if (this.mConstraintUpdatedTimesElapsed[idx] == 0) goto L97;
        TimeUtils.formatDuration(this.mConstraintUpdatedTimesElapsed[idx], nowElapsed, pw);
        pw.print(" =");
        dumpConstraints(pw, this.mConstraintStatusHistory[idx]);
        pw.println();
    L97:
        h = h + 1;
        goto L92
    L98:
        pw.decreaseIndent();
        if (this.appHasDozeExemption == false) goto L102;
        pw.println("Doze whitelisted: true");
    L102:
        if (this.uidActive == false) goto L105;
        pw.println("Uid: active");
    L105:
        if (this.job.isExemptedFromAppStandby() == false) goto L108;
        pw.println("Is exempted from app standby");
    L108:
        if (this.trackingControllers == 0) goto L131;
        pw.print("Tracking:");
        if ((this.trackingControllers & 1) == 0) goto L113;
        pw.print(" BATTERY");
    L113:
        if ((this.trackingControllers & 2) == 0) goto L116;
        pw.print(" CONNECTIVITY");
    L116:
        if ((this.trackingControllers & 4) == 0) goto L119;
        pw.print(" CONTENT");
    L119:
        if ((this.trackingControllers & 8) == 0) goto L122;
        pw.print(" IDLE");
    L122:
        if ((this.trackingControllers & 16) == 0) goto L125;
        pw.print(" STORAGE");
    L125:
        if ((this.trackingControllers & 32) == 0) goto L128;
        pw.print(" TIME");
    L128:
        if ((this.trackingControllers & 64) == 0) goto L130;
        pw.print(" QUOTA");
    L130:
        pw.println();
    L131:
        pw.println("Implicit constraints:");
        pw.increaseIndent();
        pw.print("readyNotDozing: ");
        pw.println(this.mReadyNotDozing);
        pw.print("readyNotRestrictedInBg: ");
        pw.println(this.mReadyNotRestrictedInBg);
        if (this.job.isPeriodic() == true) goto L137;
        if (hasDeadlineConstraint() == false) goto L137;
        pw.print("readyDeadlineSatisfied: ");
        pw.println(this.mReadyDeadlineSatisfied);
    L137:
        if (this.mDynamicConstraints == 0) goto L139;
        pw.print("readyDynamicSatisfied: ");
        pw.println(this.mReadyDynamicSatisfied);
    L139:
        pw.print("readyComponentEnabled: ");
        if (this.serviceProcessName != null) goto L143;
        r1 = false;
    L143:
        pw.println(r1);
        if ((getFlags() & 16) == 0) goto L147;
        pw.print("expeditedQuotaApproved: ");
        pw.print(this.mExpeditedQuotaApproved);
        pw.print(" (started as EJ: ");
        pw.print(this.startedAsExpeditedJob);
        pw.println(")");
    L147:
        if ((32 & getFlags()) == 0) goto L149;
        pw.print("userInitiatedApproved: ");
        pw.print(shouldTreatAsUserInitiatedJob());
        pw.print(" (started as UIJ: ");
        pw.print(this.startedAsUserInitiatedJob);
        pw.println(")");
    L149:
        pw.decreaseIndent();
        pw.print("Started with foreground flag: ");
        pw.println(this.startedWithForegroundFlag);
        if (this.mIsUserBgRestricted == false) goto L153;
        pw.println("User BG restricted");
    L153:
        if (this.changedAuthorities == null) goto L160;
        pw.println("Changed authorities:");
        pw.increaseIndent();
        int i2 = 0;
    L156:
        if (i2 >= this.changedAuthorities.size()) goto L158;
        pw.println(this.changedAuthorities.valueAt(i2));
        i2 = i2 + 1;
        goto L156
    L158:
        pw.decreaseIndent();
    L160:
        if (this.changedUris == null) goto L167;
        pw.println("Changed URIs:");
        pw.increaseIndent();
        int i3 = 0;
    L163:
        if (i3 >= this.changedUris.size()) goto L165;
        pw.println(this.changedUris.valueAt(i3));
        i3 = i3 + 1;
        goto L163
    L165:
        pw.decreaseIndent();
    L167:
        if (this.network == null) goto L170;
        pw.print("Network: ");
        pw.println(this.network);
    L170:
        if (this.pendingWork == null) goto L178;
        if (this.pendingWork.size() <= 0) goto L178;
        pw.println("Pending work:");
        int i4 = 0;
    L175:
        if (i4 >= this.pendingWork.size()) goto L178;
        dumpJobWorkItem(pw, this.pendingWork.get(i4), i4);
        i4 = i4 + 1;
    L178:
        if (this.executingWork != null) goto L180;
    L185:
        pw.print("Standby bucket: ");
        pw.println(getBucketName());
        pw.increaseIndent();
        if (this.whenStandbyDeferred == 0) goto L189;
        pw.print("Deferred since: ");
        TimeUtils.formatDuration(this.whenStandbyDeferred, nowElapsed, pw);
        pw.println();
    L189:
        if (this.mFirstForceBatchedTimeElapsed == 0) goto L191;
        pw.print("Time since first force batch attempt: ");
        TimeUtils.formatDuration(this.mFirstForceBatchedTimeElapsed, nowElapsed, pw);
        pw.println();
    L191:
        pw.decreaseIndent();
        pw.print("Enqueue time: ");
        TimeUtils.formatDuration(this.enqueueTime, nowElapsed, pw);
        pw.println();
        pw.print("Run time: earliest=");
        formatRunTime(pw, this.earliestRunTimeElapsedMillis, 0, nowElapsed);
        pw.print(", latest=");
        formatRunTime(pw, this.latestRunTimeElapsedMillis, Long.MAX_VALUE, nowElapsed);
        pw.print(", original latest=");
        formatRunTime(pw, this.mOriginalLatestRunTimeElapsedMillis, Long.MAX_VALUE, nowElapsed);
        pw.println();
        if (this.mCumulativeExecutionTimeMs == 0) goto L195;
        pw.print("Cumulative execution time=");
        TimeUtils.formatDuration(this.mCumulativeExecutionTimeMs, pw);
        pw.println();
    L195:
        if (this.numFailures == 0) goto L198;
        pw.print("Num failures: ");
        pw.println(this.numFailures);
    L198:
        if (this.mNumSystemStops == 0) goto L201;
        pw.print("Num system stops: ");
        pw.println(this.mNumSystemStops);
    L201:
        if (this.mLastSuccessfulRunTime == 0) goto L204;
        pw.print("Last successful run: ");
        pw.println(formatTime(this.mLastSuccessfulRunTime));
    L204:
        if (this.mLastFailedRunTime == 0) goto L215;
        pw.print("Last failed run: ");
        pw.println(formatTime(this.mLastFailedRunTime));
        return;
    L215:
        return;
    L180:
        if (this.executingWork.size() <= 0) goto L185;
        pw.println("Executing work:");
        int i5 = 0;
    L183:
        if (i5 >= this.executingWork.size()) goto L185;
        dumpJobWorkItem(pw, this.executingWork.get(i5), i5);
        i5 = i5 + 1;
        goto L183
    }

    private static CharSequence formatTime(long time) {
        return DateFormat.format("yyyy-MM-dd HH:mm:ss", time);
    }

    public void dump(ProtoOutputStream proto, long fieldId, boolean full, long elapsedRealtimeMillis) {
        long token = proto.start(fieldId);
        long r5 = 1120986464257L;
        proto.write(1120986464257L, this.callingUid);
        proto.write(1138166333442L, getWakelockTag());
        proto.write(1120986464259L, getSourceUid());
        proto.write(1120986464260L, getSourceUserId());
        proto.write(1138166333445L, getSourcePackageName());
        if (full == false) goto L43;
        long r15 = 0;
        long jiToken = proto.start(1146756268038L);
        this.job.getService().dumpDebug(proto, 1146756268033L);
        proto.write(1133871366146L, this.job.isPeriodic());
        proto.write(1112396529667L, this.job.getIntervalMillis());
        proto.write(1112396529668L, this.job.getFlexMillis());
        proto.write(1133871366149L, this.job.isPersisted());
        proto.write(1172526071814L, this.job.getBias());
        proto.write(1120986464263L, this.job.getFlags());
        proto.write(1112396529688L, getInternalFlags());
        proto.write(1133871366152L, this.job.isRequireCharging());
        proto.write(1133871366153L, this.job.isRequireBatteryNotLow());
        proto.write(1133871366154L, this.job.isRequireDeviceIdle());
        if (this.job.getTriggerContentUris() == null) goto L21;
        int i = 0;
    L8:
        if (i >= this.job.getTriggerContentUris().length) goto L15;
        long tcuToken = proto.start(2246267895819L);
        JobInfo.TriggerContentUri trig = this.job.getTriggerContentUris()[i];
        proto.write(r5, trig.getFlags());
        Uri u = trig.getUri();
        if (u == null) goto L13;
        proto.write(1138166333442L, u.toString());
    L13:
        proto.end(tcuToken);
        i = i + 1;
        r5 = 1120986464257L;
        goto L8
    L15:
        if (this.job.getTriggerContentUpdateDelay() < 0) goto L18;
        proto.write(1112396529676L, this.job.getTriggerContentUpdateDelay());
    L18:
        if (this.job.getTriggerContentMaxDelay() < 0) goto L21;
        proto.write(1112396529677L, this.job.getTriggerContentMaxDelay());
    L21:
        if (this.job.getExtras() == null) goto L26;
        if (this.job.getExtras().isDefinitelyEmpty() == true) goto L26;
        this.job.getExtras().dumpDebug(proto, 1146756268046L);
    L26:
        if (this.job.getTransientExtras() == null) goto L31;
        if (this.job.getTransientExtras().isDefinitelyEmpty() == true) goto L31;
        this.job.getTransientExtras().dumpDebug(proto, 1146756268047L);
    L31:
        if (this.job.getClipData() == null) goto L34;
        this.job.getClipData().dumpDebug(proto, 1146756268048L);
    L34:
        if (this.uriPerms == null) goto L37;
        this.uriPerms.dump(proto, 1146756268049L);
    L37:
        if (this.mTotalNetworkDownloadBytes == (-1)) goto L40;
        proto.write(1112396529689L, this.mTotalNetworkDownloadBytes);
    L40:
        if (this.mTotalNetworkUploadBytes == (-1)) goto L42;
        proto.write(1112396529690L, this.mTotalNetworkUploadBytes);
    L42:
        proto.write(1112396529684L, this.job.getMinLatencyMillis());
        proto.write(1112396529685L, this.job.getMaxExecutionDelayMillis());
        long bpToken = proto.start(1146756268054L);
        proto.write(1159641169921L, this.job.getBackoffPolicy());
        proto.write(1112396529666L, this.job.getInitialBackoffMillis());
        proto.end(bpToken);
        proto.write(1133871366167L, this.job.hasEarlyConstraint());
        proto.write(1133871366168L, this.job.hasLateConstraint());
        proto.end(jiToken);
    L44:
        dumpConstraints(proto, 2259152797703L, this.requiredConstraints);
        dumpConstraints(proto, 2259152797727L, this.mDynamicConstraints);
        if (full == false) goto L48;
        dumpConstraints(proto, 2259152797704L, this.satisfiedConstraints);
        dumpConstraints(proto, 2259152797705L, (this.requiredConstraints | 16777216) & (~this.satisfiedConstraints));
        proto.write(1133871366154L, this.appHasDozeExemption);
        proto.write(1133871366170L, this.uidActive);
        proto.write(1133871366171L, this.job.isExemptedFromAppStandby());
    L48:
        if ((this.trackingControllers & 1) == 0) goto L51;
        proto.write(2259152797707L, 0);
    L51:
        if ((this.trackingControllers & 2) == 0) goto L54;
        proto.write(2259152797707L, 1);
    L54:
        if ((this.trackingControllers & 4) == 0) goto L57;
        proto.write(2259152797707L, 2);
    L57:
        if ((this.trackingControllers & 8) == 0) goto L60;
        proto.write(2259152797707L, 3);
    L60:
        if ((this.trackingControllers & 16) == 0) goto L63;
        proto.write(2259152797707L, 4);
    L63:
        if ((this.trackingControllers & 32) == 0) goto L66;
        proto.write(2259152797707L, 5);
    L66:
        if ((this.trackingControllers & 64) == 0) goto L68;
        proto.write(2259152797707L, 6);
    L68:
        long icToken = proto.start(1146756268057L);
        proto.write(1133871366145L, this.mReadyNotDozing);
        proto.write(1133871366146L, this.mReadyNotRestrictedInBg);
        proto.write(1133871366147L, this.mReadyDynamicSatisfied);
        proto.end(icToken);
        if (this.changedAuthorities == null) goto L75;
        int k = 0;
    L72:
        if (k >= this.changedAuthorities.size()) goto L75;
        proto.write(2237677961228L, this.changedAuthorities.valueAt(k));
        k = k + 1;
    L75:
        if (this.changedUris == null) goto L81;
        int i2 = 0;
    L78:
        if (i2 >= this.changedUris.size()) goto L81;
        proto.write(2237677961229L, this.changedUris.valueAt(i2).toString());
        i2 = i2 + 1;
    L81:
        if (this.pendingWork == null) goto L87;
        int i3 = 0;
    L84:
        if (i3 >= this.pendingWork.size()) goto L87;
        dumpJobWorkItem(proto, 2246267895823L, this.pendingWork.get(i3));
        i3 = i3 + 1;
    L87:
        if (this.executingWork == null) goto L92;
        int i4 = 0;
    L90:
        if (i4 >= this.executingWork.size()) goto L92;
        dumpJobWorkItem(proto, 2246267895824L, this.executingWork.get(i4));
        i4 = i4 + 1;
    L92:
        proto.write(1159641169937L, this.standbyBucket);
        proto.write(1112396529682L, elapsedRealtimeMillis - this.enqueueTime);
        if (this.whenStandbyDeferred != r15) goto L95;
        long r7 = r15;
    L96:
        proto.write(1112396529692L, r7);
        if (this.mFirstForceBatchedTimeElapsed != r15) goto L99;
        long r8 = r15;
    L100:
        proto.write(1112396529693L, r8);
        if (this.earliestRunTimeElapsedMillis != r15) goto L103;
        proto.write(1176821039123L, 0);
    L105:
        if (this.latestRunTimeElapsedMillis != Long.MAX_VALUE) goto L107;
        proto.write(1176821039124L, 0);
    L108:
        proto.write(1116691496990L, this.mOriginalLatestRunTimeElapsedMillis);
        proto.write(1120986464277L, this.numFailures + this.mNumSystemStops);
        proto.write(1112396529686L, this.mLastSuccessfulRunTime);
        proto.write(1112396529687L, this.mLastFailedRunTime);
        proto.end(token);
        return;
    L107:
        proto.write(1176821039124L, this.latestRunTimeElapsedMillis - elapsedRealtimeMillis);
        goto L108
    L103:
        proto.write(1176821039123L, this.earliestRunTimeElapsedMillis - elapsedRealtimeMillis);
        goto L105
    L99:
        r8 = elapsedRealtimeMillis - this.mFirstForceBatchedTimeElapsed;
        goto L100
    L95:
        r7 = elapsedRealtimeMillis - this.whenStandbyDeferred;
        goto L96
    L43:
        r15 = 0;
        goto L44
    }
}
