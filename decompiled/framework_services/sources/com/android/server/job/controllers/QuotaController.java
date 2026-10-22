package com.android.server.job.controllers;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.UidObserver;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManagerInternal;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.UserPackage;
import android.hardware.tv.mediaquality.ParameterName;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Trace;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseArrayMap;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.util.SparseSetArray;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.jobs.ArrayUtils;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.LocalServices;
import com.android.server.PowerAllowlistInternal;
import com.android.server.alarm.HeartbeatStats;
import com.android.server.compat.PlatformCompat;
import com.android.server.job.JobSchedulerService;
import com.android.server.pm.PackageManagerService;
import com.android.server.usage.AppStandbyInternal;
import com.android.server.usage.UnixCalendar;
import com.android.server.utils.AlarmQueue;
import dalvik.annotation.optimization.NeverCompile;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class QuotaController extends StateController {
    private static final String ALARM_TAG_CLEANUP = "*job.cleanup*";
    private static final String ALARM_TAG_QUOTA_CHECK = "*job.quota_check*";
    private static final boolean DEBUG = false;
    private static final long MAX_PERIOD_MS = 86400000;
    private static final int MSG_CHECK_PACKAGE = 2;
    private static final int MSG_CLEAN_UP_SESSIONS = 1;
    static final int MSG_END_GRACE_PERIOD = 6;
    private static final int MSG_PROCESS_USAGE_EVENT = 5;
    static final int MSG_REACHED_COUNT_QUOTA = 7;
    static final int MSG_REACHED_EJ_TIME_QUOTA = 4;
    static final int MSG_REACHED_TIME_QUOTA = 0;
    private static final int MSG_UID_PROCESS_STATE_CHANGED = 3;
    static final long OVERRIDE_QUOTA_ADJUST_DEFAULT_CONSTANTS = 378129159;
    static final long OVERRIDE_QUOTA_ENFORCEMENT_TO_FGS_JOBS = 341201311;
    static final long OVERRIDE_QUOTA_ENFORCEMENT_TO_TOP_STARTED_JOBS = 374323858;
    private static final int SYSTEM_APP_CHECK_FLAGS = 4993024;
    private static final String TAG = "JobScheduler.Quota";
    private static final String TRACE_QUOTA_STATE_CHANGED_DELIMITER = "#";
    private static final String TRACE_QUOTA_STATE_CHANGED_TAG = "QuotaStateChanged:";
    private final AlarmManager mAlarmManager;
    private final long[] mAllowedTimePerPeriodMs;
    private long mAllowedTimePeriodAdditionaInstallerMs;
    private final BackgroundJobsController mBackgroundJobsController;
    private final long[] mBucketPeriodsMs;
    private final ConnectivityController mConnectivityController;
    private final Consumer<List<TimedEvent>> mDeleteOldEventsFunctor;
    private long mEJGracePeriodTempAllowlistMs;
    private long mEJGracePeriodTopAppMs;
    private long mEJLimitWindowSizeMs;
    private final long[] mEJLimitsMs;
    private final SparseArrayMap<String, Timer> mEJPkgTimers;
    private long mEJRewardInteractionMs;
    private long mEJRewardNotificationSeenMs;
    private long mEJRewardTopAppMs;
    private final SparseArrayMap<String, ShrinkableDebits> mEJStats;
    private final SparseArrayMap<String, List<TimedEvent>> mEJTimingSessions;
    private long mEJTopAppTimeChunkSizeMs;
    private final EarliestEndTimeFunctor mEarliestEndTimeFunctor;
    private long mEjLimitAdditionInstallerMs;
    private long mEjLimitAdditionSpecialMs;
    private final SparseArrayMap<String, ExecutionStats[]> mExecutionStatsCache;
    private final SparseBooleanArray mForegroundUids;
    private final QcHandler mHandler;
    private final InQuotaAlarmQueue mInQuotaAlarmQueue;
    private final int[] mMaxBucketJobCounts;
    private final int[] mMaxBucketSessionCounts;
    private long mMaxExecutionTimeIntoQuotaMs;
    private long mMaxExecutionTimeMs;
    private int mMaxJobCountPerRateLimitingWindow;
    private int mMaxSessionCountPerRateLimitingWindow;
    private long mNextCleanupTimeElapsed;
    private final SparseArrayMap<String, Timer> mPkgTimers;
    private final PlatformCompat mPlatformCompat;
    private final QcConstants mQcConstants;
    private long mQuotaBufferMs;
    private long mRateLimitingWindowMs;
    private final AlarmManager.OnAlarmListener mSessionCleanupAlarmListener;
    private final SparseSetArray<String> mSystemInstallers;
    private final SparseBooleanArray mTempAllowlistCache;
    private final SparseLongArray mTempAllowlistGraceCache;
    private final TimedEventTooOldPredicate mTimedEventTooOld;
    private final TimerChargingUpdateFunctor mTimerChargingUpdateFunctor;
    private final SparseArrayMap<String, List<TimedEvent>> mTimingEvents;
    private long mTimingSessionCoalescingDurationMs;
    private final SparseBooleanArray mTopAppCache;
    private final SparseLongArray mTopAppGraceCache;
    private final SparseArrayMap<String, TopAppTimer> mTopAppTrackers;
    private final ArraySet<JobStatus> mTopStartedJobs;
    private final SparseArrayMap<String, ArraySet<JobStatus>> mTrackedJobs;
    private final UidConstraintUpdater mUpdateUidConstraints;

    private final class EarliestEndTimeFunctor implements Consumer<List<TimedEvent>> {
        public long earliestEndElapsed;

        /* synthetic */ EarliestEndTimeFunctor(QuotaController r1, QuotaControllerIA r2) {
            this(r1);
        }

        private EarliestEndTimeFunctor(QuotaController r3) {
            this.earliestEndElapsed = Long.MAX_VALUE;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(List<TimedEvent> r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(List<TimedEvent> events) {
            if (events != null) goto L4;
            return;
        L4:
            if (events.size() <= 0) goto L8;
            this.earliestEndElapsed = Math.min(this.earliestEndElapsed, events.get(0).getEndTimeElapsed());
            return;
        }

        void reset() {
            this.earliestEndElapsed = Long.MAX_VALUE;
        }
    }

    static class ExecutionStats {
        public long allowedTimePerPeriodMs;
        public int bgJobCountInMaxPeriod;
        public int bgJobCountInWindow;
        public long executionTimeInMaxPeriodMs;
        public long executionTimeInWindowMs;
        public long expirationTimeElapsed;
        public long inQuotaTimeElapsed;
        public int jobCountInRateLimitingWindow;
        public int jobCountLimit;
        public long jobRateLimitExpirationTimeElapsed;
        public int sessionCountInRateLimitingWindow;
        public int sessionCountInWindow;
        public int sessionCountLimit;
        public long sessionRateLimitExpirationTimeElapsed;
        public long windowSizeMs;

        ExecutionStats() {
        }

        public String toString() {
            return "expirationTime=" + this.expirationTimeElapsed + ", allowedTimePerPeriodMs=" + this.allowedTimePerPeriodMs + ", windowSizeMs=" + this.windowSizeMs + ", jobCountLimit=" + this.jobCountLimit + ", sessionCountLimit=" + this.sessionCountLimit + ", executionTimeInWindow=" + this.executionTimeInWindowMs + ", bgJobCountInWindow=" + this.bgJobCountInWindow + ", executionTimeInMaxPeriod=" + this.executionTimeInMaxPeriodMs + ", bgJobCountInMaxPeriod=" + this.bgJobCountInMaxPeriod + ", sessionCountInWindow=" + this.sessionCountInWindow + ", inQuotaTime=" + this.inQuotaTimeElapsed + ", rateLimitJobCountExpirationTime=" + this.jobRateLimitExpirationTimeElapsed + ", rateLimitJobCountWindow=" + this.jobCountInRateLimitingWindow + ", rateLimitSessionCountExpirationTime=" + this.sessionRateLimitExpirationTimeElapsed + ", rateLimitSessionCountWindow=" + this.sessionCountInRateLimitingWindow;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ExecutionStats) == false) goto L36;
            ExecutionStats other = (ExecutionStats) obj;
            if (this.expirationTimeElapsed == other.expirationTimeElapsed) goto L7;
            return false;
        L7:
            if (this.allowedTimePerPeriodMs == other.allowedTimePerPeriodMs) goto L9;
            return false;
        L9:
            if (this.windowSizeMs == other.windowSizeMs) goto L11;
            return false;
        L11:
            if (this.jobCountLimit == other.jobCountLimit) goto L13;
            return false;
        L13:
            if (this.sessionCountLimit == other.sessionCountLimit) goto L15;
            return false;
        L15:
            if (this.executionTimeInWindowMs == other.executionTimeInWindowMs) goto L17;
            return false;
        L17:
            if (this.bgJobCountInWindow == other.bgJobCountInWindow) goto L19;
            return false;
        L19:
            if (this.executionTimeInMaxPeriodMs == other.executionTimeInMaxPeriodMs) goto L21;
            return false;
        L21:
            if (this.sessionCountInWindow == other.sessionCountInWindow) goto L23;
            return false;
        L23:
            if (this.bgJobCountInMaxPeriod == other.bgJobCountInMaxPeriod) goto L25;
            return false;
        L25:
            if (this.inQuotaTimeElapsed == other.inQuotaTimeElapsed) goto L27;
            return false;
        L27:
            if (this.jobRateLimitExpirationTimeElapsed == other.jobRateLimitExpirationTimeElapsed) goto L29;
            return false;
        L29:
            if (this.jobCountInRateLimitingWindow == other.jobCountInRateLimitingWindow) goto L31;
            return false;
        L31:
            if (this.sessionRateLimitExpirationTimeElapsed == other.sessionRateLimitExpirationTimeElapsed) goto L33;
            return false;
        L33:
            if (this.sessionCountInRateLimitingWindow != other.sessionCountInRateLimitingWindow) goto L51;
            return true;
        L51:
            return false;
        L36:
            return false;
        }

        public int hashCode() {
            int result = (0 * 31) + QuotaController.m5078$$Nest$smhashLong(this.expirationTimeElapsed);
            return (((((((((((((((((((((((((((result * 31) + QuotaController.m5078$$Nest$smhashLong(this.allowedTimePerPeriodMs)) * 31) + QuotaController.m5078$$Nest$smhashLong(this.windowSizeMs)) * 31) + QuotaController.m5078$$Nest$smhashLong(this.jobCountLimit)) * 31) + QuotaController.m5078$$Nest$smhashLong(this.sessionCountLimit)) * 31) + QuotaController.m5078$$Nest$smhashLong(this.executionTimeInWindowMs)) * 31) + this.bgJobCountInWindow) * 31) + QuotaController.m5078$$Nest$smhashLong(this.executionTimeInMaxPeriodMs)) * 31) + this.bgJobCountInMaxPeriod) * 31) + this.sessionCountInWindow) * 31) + QuotaController.m5078$$Nest$smhashLong(this.inQuotaTimeElapsed)) * 31) + QuotaController.m5078$$Nest$smhashLong(this.jobRateLimitExpirationTimeElapsed)) * 31) + this.jobCountInRateLimitingWindow) * 31) + QuotaController.m5078$$Nest$smhashLong(this.sessionRateLimitExpirationTimeElapsed)) * 31) + this.sessionCountInRateLimitingWindow;
        }
    }

    private class InQuotaAlarmQueue extends AlarmQueue<UserPackage> {
        final /* synthetic */ QuotaController this$0;

        /* synthetic */ InQuotaAlarmQueue(QuotaController r1, Context r2, Looper r3, QuotaControllerIA r4) {
            this(r1, r2, r3);
        }

        @Override // com.android.server.utils.AlarmQueue
        protected /* bridge */ /* synthetic */ boolean isForUser(UserPackage r1, int r2) {
            return isForUser2(r1, r2);
        }

        private InQuotaAlarmQueue(QuotaController r9, Context context, Looper looper) {
            this.this$0 = r9;
            super(context, looper, QuotaController.ALARM_TAG_QUOTA_CHECK, "In quota", false, 60000);
        }

        /* JADX INFO: renamed from: isForUser, reason: avoid collision after fix types in other method */
        protected boolean isForUser2(UserPackage key, int userId) {
            if (key.userId != userId) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.utils.AlarmQueue
        protected void processExpiredAlarms(ArraySet<UserPackage> expired) {
            int i = 0;
        L4:
            if (i >= expired.size()) goto L7;
            UserPackage p = expired.valueAt(i);
            QuotaController.m5030$$Nest$fgetmHandler(this.this$0).obtainMessage(2, p.userId, 0, p.packageName).sendToTarget();
            i = i + 1;
            goto L4
        }
    }

    class QcConstants {
        private static final long DEFAULT_ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS = 600000;
        private static final long DEFAULT_ALLOWED_TIME_PER_PERIOD_FREQUENT_MS = 600000;
        private static final long DEFAULT_ALLOWED_TIME_PER_PERIOD_RARE_MS = 600000;
        private static final long DEFAULT_ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS = 600000;
        private static final long DEFAULT_ALLOWED_TIME_PER_PERIOD_WORKING_MS = 600000;
        private static final long DEFAULT_CURRENT_ALLOWED_TIME_PER_PERIOD_ACTIVE_MS = 1200000;
        private static final long DEFAULT_CURRENT_ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS = 1200000;
        private static final long DEFAULT_CURRENT_ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS = 1200000;
        private static final long DEFAULT_CURRENT_EJ_LIMIT_WORKING_MS = 900000;
        private static final long DEFAULT_CURRENT_EJ_REWARD_INTERACTION_MS = 5000;
        private static final long DEFAULT_CURRENT_EJ_TOP_APP_TIME_CHUNK_SIZE_MS = 300000;
        private static final long DEFAULT_CURRENT_WINDOW_SIZE_ACTIVE_MS = 1800000;
        private static final long DEFAULT_CURRENT_WINDOW_SIZE_EXEMPTED_MS = 1200000;
        private static final long DEFAULT_CURRENT_WINDOW_SIZE_FREQUENT_MS = 43200000;
        private static final long DEFAULT_CURRENT_WINDOW_SIZE_WORKING_MS = 14400000;
        private static final long DEFAULT_EJ_GRACE_PERIOD_TEMP_ALLOWLIST_MS = 180000;
        private static final long DEFAULT_EJ_GRACE_PERIOD_TOP_APP_MS = 60000;
        private static final long DEFAULT_EJ_LIMIT_ACTIVE_MS = 1800000;
        private static final long DEFAULT_EJ_LIMIT_ADDITION_INSTALLER_MS = 1800000;
        private static final long DEFAULT_EJ_LIMIT_ADDITION_SPECIAL_MS = 900000;
        private static final long DEFAULT_EJ_LIMIT_EXEMPTED_MS = 3600000;
        private static final long DEFAULT_EJ_LIMIT_FREQUENT_MS = 600000;
        private static final long DEFAULT_EJ_LIMIT_RARE_MS = 600000;
        private static final long DEFAULT_EJ_LIMIT_RESTRICTED_MS = 300000;
        private static final long DEFAULT_EJ_REWARD_NOTIFICATION_SEEN_MS = 0;
        private static final long DEFAULT_EJ_REWARD_TOP_APP_MS = 10000;
        private static final long DEFAULT_EJ_WINDOW_SIZE_MS = 86400000;
        private static final long DEFAULT_IN_QUOTA_BUFFER_MS = 30000;
        private static final long DEFAULT_LATEST_WINDOW_SIZE_ACTIVE_MS = 3600000;
        private static final long DEFAULT_LATEST_WINDOW_SIZE_EXEMPTED_MS = 2400000;
        private static final long DEFAULT_LEGACY_ALLOWED_TIME_PER_PERIOD_ACTIVE_MS = 600000;
        private static final long DEFAULT_LEGACY_ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS = 600000;
        private static final long DEFAULT_LEGACY_EJ_LIMIT_WORKING_MS = 1800000;
        private static final long DEFAULT_LEGACY_EJ_REWARD_INTERACTION_MS = 15000;
        private static final long DEFAULT_LEGACY_EJ_TOP_APP_TIME_CHUNK_SIZE_MS = 30000;
        private static final long DEFAULT_LEGACY_WINDOW_SIZE_ACTIVE_MS = 600000;
        private static final long DEFAULT_LEGACY_WINDOW_SIZE_EXEMPTED_MS = 600000;
        private static final long DEFAULT_LEGACY_WINDOW_SIZE_FREQUENT_MS = 28800000;
        private static final long DEFAULT_LEGACY_WINDOW_SIZE_WORKING_MS = 7200000;
        private static final long DEFAULT_MAX_EXECUTION_TIME_MS = 14400000;
        private static final int DEFAULT_MAX_JOB_COUNT_ACTIVE = 75;
        private static final int DEFAULT_MAX_JOB_COUNT_EXEMPTED = 75;
        private static final int DEFAULT_MAX_JOB_COUNT_FREQUENT = 200;
        private static final int DEFAULT_MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW = 20;
        private static final int DEFAULT_MAX_JOB_COUNT_RARE = 48;
        private static final int DEFAULT_MAX_JOB_COUNT_RESTRICTED = 10;
        private static final int DEFAULT_MAX_JOB_COUNT_WORKING = 120;
        private static final int DEFAULT_MAX_SESSION_COUNT_ACTIVE = 75;
        private static final int DEFAULT_MAX_SESSION_COUNT_EXEMPTED = 75;
        private static final int DEFAULT_MAX_SESSION_COUNT_FREQUENT = 8;
        private static final int DEFAULT_MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW = 20;
        private static final int DEFAULT_MAX_SESSION_COUNT_RARE = 3;
        private static final int DEFAULT_MAX_SESSION_COUNT_RESTRICTED = 1;
        private static final int DEFAULT_MAX_SESSION_COUNT_WORKING = 10;
        private static final long DEFAULT_MIN_QUOTA_CHECK_DELAY_MS = 60000;
        private static final long DEFAULT_RATE_LIMITING_WINDOW_MS = 60000;
        private static final long DEFAULT_TIMING_SESSION_COALESCING_DURATION_MS = 5000;
        private static final long DEFAULT_WINDOW_SIZE_RARE_MS = 86400000;
        private static final long DEFAULT_WINDOW_SIZE_RESTRICTED_MS = 86400000;
        static final String KEY_ALLOWED_TIME_PER_PERIOD_ACTIVE_MS = "qc_allowed_time_per_period_active_ms";
        static final String KEY_ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS = "qc_allowed_time_per_period_addition_installer_ms";
        static final String KEY_ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS = "qc_allowed_time_per_period_exempted_ms";
        static final String KEY_ALLOWED_TIME_PER_PERIOD_FREQUENT_MS = "qc_allowed_time_per_period_frequent_ms";
        static final String KEY_ALLOWED_TIME_PER_PERIOD_RARE_MS = "qc_allowed_time_per_period_rare_ms";
        static final String KEY_ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS = "qc_allowed_time_per_period_restricted_ms";
        static final String KEY_ALLOWED_TIME_PER_PERIOD_WORKING_MS = "qc_allowed_time_per_period_working_ms";
        static final String KEY_EJ_GRACE_PERIOD_TEMP_ALLOWLIST_MS = "qc_ej_grace_period_temp_allowlist_ms";
        static final String KEY_EJ_GRACE_PERIOD_TOP_APP_MS = "qc_ej_grace_period_top_app_ms";
        static final String KEY_EJ_LIMIT_ACTIVE_MS = "qc_ej_limit_active_ms";
        static final String KEY_EJ_LIMIT_ADDITION_INSTALLER_MS = "qc_ej_limit_addition_installer_ms";
        static final String KEY_EJ_LIMIT_ADDITION_SPECIAL_MS = "qc_ej_limit_addition_special_ms";
        static final String KEY_EJ_LIMIT_EXEMPTED_MS = "qc_ej_limit_exempted_ms";
        static final String KEY_EJ_LIMIT_FREQUENT_MS = "qc_ej_limit_frequent_ms";
        static final String KEY_EJ_LIMIT_RARE_MS = "qc_ej_limit_rare_ms";
        static final String KEY_EJ_LIMIT_RESTRICTED_MS = "qc_ej_limit_restricted_ms";
        static final String KEY_EJ_LIMIT_WORKING_MS = "qc_ej_limit_working_ms";
        static final String KEY_EJ_REWARD_INTERACTION_MS = "qc_ej_reward_interaction_ms";
        static final String KEY_EJ_REWARD_NOTIFICATION_SEEN_MS = "qc_ej_reward_notification_seen_ms";
        static final String KEY_EJ_REWARD_TOP_APP_MS = "qc_ej_reward_top_app_ms";
        static final String KEY_EJ_TOP_APP_TIME_CHUNK_SIZE_MS = "qc_ej_top_app_time_chunk_size_ms";
        static final String KEY_EJ_WINDOW_SIZE_MS = "qc_ej_window_size_ms";
        static final String KEY_IN_QUOTA_BUFFER_MS = "qc_in_quota_buffer_ms";
        static final String KEY_MAX_EXECUTION_TIME_MS = "qc_max_execution_time_ms";
        static final String KEY_MAX_JOB_COUNT_ACTIVE = "qc_max_job_count_active";
        static final String KEY_MAX_JOB_COUNT_EXEMPTED = "qc_max_job_count_exempted";
        static final String KEY_MAX_JOB_COUNT_FREQUENT = "qc_max_job_count_frequent";
        static final String KEY_MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW = "qc_max_job_count_per_rate_limiting_window";
        static final String KEY_MAX_JOB_COUNT_RARE = "qc_max_job_count_rare";
        static final String KEY_MAX_JOB_COUNT_RESTRICTED = "qc_max_job_count_restricted";
        static final String KEY_MAX_JOB_COUNT_WORKING = "qc_max_job_count_working";
        static final String KEY_MAX_SESSION_COUNT_ACTIVE = "qc_max_session_count_active";
        static final String KEY_MAX_SESSION_COUNT_EXEMPTED = "qc_max_session_count_exempted";
        static final String KEY_MAX_SESSION_COUNT_FREQUENT = "qc_max_session_count_frequent";
        static final String KEY_MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW = "qc_max_session_count_per_rate_limiting_window";
        static final String KEY_MAX_SESSION_COUNT_RARE = "qc_max_session_count_rare";
        static final String KEY_MAX_SESSION_COUNT_RESTRICTED = "qc_max_session_count_restricted";
        static final String KEY_MAX_SESSION_COUNT_WORKING = "qc_max_session_count_working";
        static final String KEY_MIN_QUOTA_CHECK_DELAY_MS = "qc_min_quota_check_delay_ms";
        static final String KEY_RATE_LIMITING_WINDOW_MS = "qc_rate_limiting_window_ms";
        static final String KEY_TIMING_SESSION_COALESCING_DURATION_MS = "qc_timing_session_coalescing_duration_ms";
        static final String KEY_WINDOW_SIZE_ACTIVE_MS = "qc_window_size_active_ms";
        static final String KEY_WINDOW_SIZE_EXEMPTED_MS = "qc_window_size_exempted_ms";
        static final String KEY_WINDOW_SIZE_FREQUENT_MS = "qc_window_size_frequent_ms";
        static final String KEY_WINDOW_SIZE_RARE_MS = "qc_window_size_rare_ms";
        static final String KEY_WINDOW_SIZE_RESTRICTED_MS = "qc_window_size_restricted_ms";
        static final String KEY_WINDOW_SIZE_WORKING_MS = "qc_window_size_working_ms";
        private static final int MIN_BUCKET_JOB_COUNT = 10;
        private static final int MIN_BUCKET_SESSION_COUNT = 1;
        private static final long MIN_MAX_EXECUTION_TIME_MS = 3600000;
        private static final int MIN_MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW = 10;
        private static final int MIN_MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW = 10;
        private static final long MIN_RATE_LIMITING_WINDOW_MS = 30000;
        private static final String QC_CONSTANT_PREFIX = "qc_";
        public long ALLOWED_TIME_PER_PERIOD_ACTIVE_MS;
        public long ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS;
        public long ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS;
        public long ALLOWED_TIME_PER_PERIOD_FREQUENT_MS;
        public long ALLOWED_TIME_PER_PERIOD_RARE_MS;
        public long ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS;
        public long ALLOWED_TIME_PER_PERIOD_WORKING_MS;
        public long EJ_GRACE_PERIOD_TEMP_ALLOWLIST_MS;
        public long EJ_GRACE_PERIOD_TOP_APP_MS;
        public long EJ_LIMIT_ACTIVE_MS;
        public long EJ_LIMIT_ADDITION_INSTALLER_MS;
        public long EJ_LIMIT_ADDITION_SPECIAL_MS;
        public long EJ_LIMIT_EXEMPTED_MS;
        public long EJ_LIMIT_FREQUENT_MS;
        public long EJ_LIMIT_RARE_MS;
        public long EJ_LIMIT_RESTRICTED_MS;
        public long EJ_LIMIT_WORKING_MS;
        public long EJ_REWARD_INTERACTION_MS;
        public long EJ_REWARD_NOTIFICATION_SEEN_MS;
        public long EJ_REWARD_TOP_APP_MS;
        public long EJ_TOP_APP_TIME_CHUNK_SIZE_MS;
        public long EJ_WINDOW_SIZE_MS;
        public long IN_QUOTA_BUFFER_MS;
        public long MAX_EXECUTION_TIME_MS;
        public int MAX_JOB_COUNT_ACTIVE;
        public int MAX_JOB_COUNT_EXEMPTED;
        public int MAX_JOB_COUNT_FREQUENT;
        public int MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW;
        public int MAX_JOB_COUNT_RARE;
        public int MAX_JOB_COUNT_RESTRICTED;
        public int MAX_JOB_COUNT_WORKING;
        public int MAX_SESSION_COUNT_ACTIVE;
        public int MAX_SESSION_COUNT_EXEMPTED;
        public int MAX_SESSION_COUNT_FREQUENT;
        public int MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW;
        public int MAX_SESSION_COUNT_RARE;
        public int MAX_SESSION_COUNT_RESTRICTED;
        public int MAX_SESSION_COUNT_WORKING;
        public long MIN_QUOTA_CHECK_DELAY_MS;
        public long RATE_LIMITING_WINDOW_MS;
        public long TIMING_SESSION_COALESCING_DURATION_MS;
        public long WINDOW_SIZE_ACTIVE_MS;
        public long WINDOW_SIZE_EXEMPTED_MS;
        public long WINDOW_SIZE_FREQUENT_MS;
        public long WINDOW_SIZE_RARE_MS;
        public long WINDOW_SIZE_RESTRICTED_MS;
        public long WINDOW_SIZE_WORKING_MS;
        private boolean mEJLimitConstantsUpdated;
        private boolean mExecutionPeriodConstantsUpdated;
        private boolean mRateLimitingConstantsUpdated;
        private boolean mShouldReevaluateConstraints;
        final /* synthetic */ QuotaController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmShouldReevaluateConstraints, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5079$$Nest$fgetmShouldReevaluateConstraints(QcConstants r0) {
            return r0.mShouldReevaluateConstraints;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmEJLimitConstantsUpdated, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5080$$Nest$fputmEJLimitConstantsUpdated(QcConstants r0, boolean r1) {
            r0.mEJLimitConstantsUpdated = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmExecutionPeriodConstantsUpdated, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5081$$Nest$fputmExecutionPeriodConstantsUpdated(QcConstants r0, boolean r1) {
            r0.mExecutionPeriodConstantsUpdated = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmRateLimitingConstantsUpdated, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5082$$Nest$fputmRateLimitingConstantsUpdated(QcConstants r0, boolean r1) {
            r0.mRateLimitingConstantsUpdated = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmShouldReevaluateConstraints, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5083$$Nest$fputmShouldReevaluateConstraints(QcConstants r0, boolean r1) {
            r0.mShouldReevaluateConstraints = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5084$$Nest$mdump(QcConstants r0, IndentingPrintWriter r1) {
            r0.dump(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5085$$Nest$mdump(QcConstants r0, ProtoOutputStream r1) {
            r0.dump(r1);
        }

        QcConstants(QuotaController this$0) {
            this.this$0 = this$0;
            this.mShouldReevaluateConstraints = false;
            this.mRateLimitingConstantsUpdated = false;
            this.mExecutionPeriodConstantsUpdated = false;
            this.mEJLimitConstantsUpdated = false;
            this.ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS = 600000;
            this.ALLOWED_TIME_PER_PERIOD_ACTIVE_MS = 600000;
            this.ALLOWED_TIME_PER_PERIOD_WORKING_MS = 600000;
            this.ALLOWED_TIME_PER_PERIOD_FREQUENT_MS = 600000;
            this.ALLOWED_TIME_PER_PERIOD_RARE_MS = 600000;
            this.ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS = 600000;
            this.IN_QUOTA_BUFFER_MS = 30000;
            this.WINDOW_SIZE_EXEMPTED_MS = 600000;
            this.WINDOW_SIZE_ACTIVE_MS = 600000;
            this.WINDOW_SIZE_WORKING_MS = 7200000;
            this.WINDOW_SIZE_FREQUENT_MS = DEFAULT_LEGACY_WINDOW_SIZE_FREQUENT_MS;
            this.WINDOW_SIZE_RARE_MS = 86400000;
            this.WINDOW_SIZE_RESTRICTED_MS = 86400000;
            this.MAX_EXECUTION_TIME_MS = 14400000;
            this.MAX_JOB_COUNT_EXEMPTED = 75;
            this.MAX_JOB_COUNT_ACTIVE = 75;
            this.MAX_JOB_COUNT_WORKING = 120;
            this.MAX_JOB_COUNT_FREQUENT = 200;
            this.MAX_JOB_COUNT_RARE = 48;
            this.MAX_JOB_COUNT_RESTRICTED = 10;
            this.RATE_LIMITING_WINDOW_MS = 60000;
            this.MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW = 20;
            this.MAX_SESSION_COUNT_EXEMPTED = 75;
            this.MAX_SESSION_COUNT_ACTIVE = 75;
            this.MAX_SESSION_COUNT_WORKING = 10;
            this.MAX_SESSION_COUNT_FREQUENT = 8;
            this.MAX_SESSION_COUNT_RARE = 3;
            this.MAX_SESSION_COUNT_RESTRICTED = 1;
            this.MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW = 20;
            this.TIMING_SESSION_COALESCING_DURATION_MS = 5000;
            this.MIN_QUOTA_CHECK_DELAY_MS = 60000;
            this.EJ_LIMIT_EXEMPTED_MS = 3600000;
            this.EJ_LIMIT_ACTIVE_MS = 1800000;
            this.EJ_LIMIT_WORKING_MS = 1800000;
            this.EJ_LIMIT_FREQUENT_MS = 600000;
            this.EJ_LIMIT_RARE_MS = 600000;
            this.EJ_LIMIT_RESTRICTED_MS = 300000;
            this.EJ_LIMIT_ADDITION_SPECIAL_MS = HeartbeatStats.MAX_NAT_TIME_MS;
            this.EJ_LIMIT_ADDITION_INSTALLER_MS = 1800000;
            this.ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS = 600000;
            this.EJ_WINDOW_SIZE_MS = 86400000;
            this.EJ_TOP_APP_TIME_CHUNK_SIZE_MS = 30000;
            this.EJ_REWARD_TOP_APP_MS = 10000;
            this.EJ_REWARD_INTERACTION_MS = DEFAULT_LEGACY_EJ_REWARD_INTERACTION_MS;
            this.EJ_REWARD_NOTIFICATION_SEEN_MS = 0;
            this.EJ_GRACE_PERIOD_TEMP_ALLOWLIST_MS = 180000;
            this.EJ_GRACE_PERIOD_TOP_APP_MS = 60000;
        }

        void adjustDefaultBucketWindowSizes(boolean useLegacyQuotaConstants) {
            if (useLegacyQuotaConstants == false) goto L4;
            this.ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS = 600000;
            this.ALLOWED_TIME_PER_PERIOD_ACTIVE_MS = 600000;
            this.ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS = 600000;
            this.WINDOW_SIZE_EXEMPTED_MS = 600000;
            this.WINDOW_SIZE_ACTIVE_MS = 600000;
            this.WINDOW_SIZE_WORKING_MS = 7200000;
            this.WINDOW_SIZE_FREQUENT_MS = DEFAULT_LEGACY_WINDOW_SIZE_FREQUENT_MS;
        L5:
            QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[6] = Math.min(86400000, Math.max(60000, this.ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS));
            QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[0] = Math.min(86400000, Math.max(60000, this.ALLOWED_TIME_PER_PERIOD_ACTIVE_MS));
            QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[6] = Math.max(QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[6], Math.min(86400000, this.WINDOW_SIZE_EXEMPTED_MS));
            QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[0] = Math.max(QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[0], Math.min(86400000, this.WINDOW_SIZE_ACTIVE_MS));
            QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[1] = Math.max(QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[1], Math.min(86400000, this.WINDOW_SIZE_WORKING_MS));
            QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[2] = Math.max(QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[2], Math.min(86400000, this.WINDOW_SIZE_FREQUENT_MS));
            QuotaController.m5046$$Nest$fputmAllowedTimePeriodAdditionaInstallerMs(this.this$0, Math.min(QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[6] - QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[6], this.ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS));
            return;
        L4:
            this.ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS = 1200000;
            this.ALLOWED_TIME_PER_PERIOD_ACTIVE_MS = 1200000;
            this.ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS = 1200000;
            this.WINDOW_SIZE_EXEMPTED_MS = DEFAULT_LATEST_WINDOW_SIZE_EXEMPTED_MS;
            this.WINDOW_SIZE_ACTIVE_MS = 3600000;
            this.WINDOW_SIZE_WORKING_MS = 14400000;
            this.WINDOW_SIZE_FREQUENT_MS = 43200000;
            goto L5
        }

        void adjustDefaultEjLimits(boolean useLegacyQuotaConstants) {
            if (useLegacyQuotaConstants == false) goto L5;
            long r2 = 1800000;
        L6:
            this.EJ_LIMIT_WORKING_MS = r2;
            if (useLegacyQuotaConstants == false) goto L9;
            long r3 = 30000;
        L10:
            this.EJ_TOP_APP_TIME_CHUNK_SIZE_MS = r3;
            if (useLegacyQuotaConstants == false) goto L13;
            long r4 = DEFAULT_LEGACY_EJ_REWARD_INTERACTION_MS;
        L14:
            this.EJ_REWARD_INTERACTION_MS = r4;
            QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[1] = Math.max(HeartbeatStats.MAX_NAT_TIME_MS, Math.min(QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[0], this.EJ_LIMIT_WORKING_MS));
            QuotaController.m5050$$Nest$fputmEJRewardInteractionMs(this.this$0, Math.min(HeartbeatStats.MAX_NAT_TIME_MS, Math.max(5000, this.EJ_REWARD_INTERACTION_MS)));
            long newChunkSizeMs = Math.min(HeartbeatStats.MAX_NAT_TIME_MS, Math.max(1, this.EJ_TOP_APP_TIME_CHUNK_SIZE_MS));
            QuotaController.m5053$$Nest$fputmEJTopAppTimeChunkSizeMs(this.this$0, newChunkSizeMs);
            if (QuotaController.m5026$$Nest$fgetmEJTopAppTimeChunkSizeMs(this.this$0) >= QuotaController.m5025$$Nest$fgetmEJRewardTopAppMs(this.this$0)) goto L18;
            Slog.w(QuotaController.TAG, "EJ top app time chunk less than reward: " + QuotaController.m5026$$Nest$fgetmEJTopAppTimeChunkSizeMs(this.this$0) + " vs " + QuotaController.m5025$$Nest$fgetmEJRewardTopAppMs(this.this$0));
            return;
        L18:
            return;
        L13:
            r4 = 5000;
            goto L14
        L9:
            r3 = 300000;
            goto L10
        L5:
            r2 = 900000;
            goto L6
        }

        public void processConstantLocked(DeviceConfig.Properties properties, String key) {
            boolean isCompatEnabled = QuotaController.m5067$$Nest$misCompatOverridedForQuotaConstantAdjustment(this.this$0);
            switch(key.hashCode()) {
                case -1952749138: goto L138;
                case -1719823663: goto L135;
                case -1683576133: goto L132;
                case -1515776932: goto L129;
                case -1507602138: goto L126;
                case -1495638658: goto L123;
                case -1436524327: goto L120;
                case -1412574464: goto L117;
                case -1409079211: goto L114;
                case -1301522660: goto L111;
                case -1253638898: goto L108;
                case -1004520055: goto L105;
                case -947372170: goto L102;
                case -947005713: goto L99;
                case -911626004: goto L96;
                case -861283784: goto L93;
                case -743649451: goto L90;
                case -473591193: goto L87;
                case -144699320: goto L84;
                case 26669170: goto L81;
                case 202838626: goto L78;
                case 319829733: goto L75;
                case 353645753: goto L72;
                case 353674834: goto L69;
                case 515924943: goto L66;
                case 542719401: goto L63;
                case 659682264: goto L60;
                case 1012217584: goto L57;
                case 1070239943: goto L54;
                case 1185201205: goto L51;
                case 1211719583: goto L48;
                case 1232643386: goto L45;
                case 1415707953: goto L42;
                case 1416512063: goto L39;
                case 1504661904: goto L36;
                case 1510141337: goto L33;
                case 1572083493: goto L30;
                case 1737007281: goto L27;
                case 1846826615: goto L24;
                case 1908515971: goto L21;
                case 1921715463: goto L18;
                case 1988481858: goto L15;
                case 2079805852: goto L12;
                case 2084297379: goto L9;
                case 2133096527: goto L6;
                default: goto L140;
            };
        L140:
            byte r4 = -1;
        L141:
            long r6 = 300000;
            switch(r4) {
                case 0: goto L208;
                case 1: goto L208;
                case 2: goto L208;
                case 3: goto L208;
                case 4: goto L208;
                case 5: goto L208;
                case 6: goto L208;
                case 7: goto L208;
                case 8: goto L208;
                case 9: goto L208;
                case 10: goto L208;
                case 11: goto L208;
                case 12: goto L208;
                case 13: goto L208;
                case 14: goto L207;
                case 15: goto L207;
                case 16: goto L207;
                case 17: goto L206;
                case 18: goto L206;
                case 19: goto L206;
                case 20: goto L206;
                case 21: goto L206;
                case 22: goto L206;
                case 23: goto L206;
                case 24: goto L206;
                case 25: goto L203;
                case 26: goto L200;
                case 27: goto L197;
                case 28: goto L194;
                case 29: goto L191;
                case 30: goto L188;
                case 31: goto L185;
                case 32: goto L182;
                case 33: goto L179;
                case 34: goto L176;
                case 35: goto L173;
                case 36: goto L170;
                case 37: goto L167;
                case 38: goto L166;
                case 39: goto L158;
                case 40: goto L152;
                case 41: goto L148;
                case 42: goto L146;
                case 43: goto L145;
                case 44: goto L144;
                default: goto L249;
            };
        L144:
            this.EJ_GRACE_PERIOD_TOP_APP_MS = properties.getLong(key, 60000);
            QuotaController.m5048$$Nest$fputmEJGracePeriodTopAppMs(this.this$0, Math.min(3600000, Math.max(0, this.EJ_GRACE_PERIOD_TOP_APP_MS)));
            return;
        L145:
            this.EJ_GRACE_PERIOD_TEMP_ALLOWLIST_MS = properties.getLong(key, 180000);
            QuotaController.m5047$$Nest$fputmEJGracePeriodTempAllowlistMs(this.this$0, Math.min(3600000, Math.max(0, this.EJ_GRACE_PERIOD_TEMP_ALLOWLIST_MS)));
            return;
        L146:
            this.EJ_REWARD_NOTIFICATION_SEEN_MS = properties.getLong(key, 0);
            QuotaController.m5051$$Nest$fputmEJRewardNotificationSeenMs(this.this$0, Math.min(300000, Math.max(0, this.EJ_REWARD_NOTIFICATION_SEEN_MS)));
            return;
        L152:
            this.EJ_REWARD_TOP_APP_MS = properties.getLong(key, 10000);
            long newTopReward = Math.min(HeartbeatStats.MAX_NAT_TIME_MS, Math.max(10000, this.EJ_REWARD_TOP_APP_MS));
            if (QuotaController.m5025$$Nest$fgetmEJRewardTopAppMs(this.this$0) == newTopReward) goto L214;
            QuotaController.m5052$$Nest$fputmEJRewardTopAppMs(this.this$0, newTopReward);
            if (QuotaController.m5026$$Nest$fgetmEJTopAppTimeChunkSizeMs(this.this$0) >= QuotaController.m5025$$Nest$fgetmEJRewardTopAppMs(this.this$0)) goto L215;
            Slog.w(QuotaController.TAG, "EJ top app time chunk less than reward: " + QuotaController.m5026$$Nest$fgetmEJTopAppTimeChunkSizeMs(this.this$0) + " vs " + QuotaController.m5025$$Nest$fgetmEJRewardTopAppMs(this.this$0));
            return;
        L215:
            return;
        L214:
            return;
        L166:
            this.MIN_QUOTA_CHECK_DELAY_MS = properties.getLong(key, 60000);
            QuotaController.m5031$$Nest$fgetmInQuotaAlarmQueue(this.this$0).setMinTimeBetweenAlarmsMs(Math.min(HeartbeatStats.MAX_NAT_TIME_MS, Math.max(0, this.MIN_QUOTA_CHECK_DELAY_MS)));
            return;
        L167:
            this.TIMING_SESSION_COALESCING_DURATION_MS = properties.getLong(key, 5000);
            long newSessionCoalescingDurationMs = Math.min(HeartbeatStats.MAX_NAT_TIME_MS, Math.max(0, this.TIMING_SESSION_COALESCING_DURATION_MS));
            if (QuotaController.m5042$$Nest$fgetmTimingSessionCoalescingDurationMs(this.this$0) == newSessionCoalescingDurationMs) goto L221;
            QuotaController.m5062$$Nest$fputmTimingSessionCoalescingDurationMs(this.this$0, newSessionCoalescingDurationMs);
            this.mShouldReevaluateConstraints = true;
            return;
        L221:
            return;
        L170:
            this.MAX_SESSION_COUNT_RESTRICTED = properties.getInt(key, 1);
            int newRestrictedMaxSessionCount = Math.max(0, this.MAX_SESSION_COUNT_RESTRICTED);
            if (QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[5] == newRestrictedMaxSessionCount) goto L223;
            QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[5] = newRestrictedMaxSessionCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L223:
            return;
        L173:
            this.MAX_SESSION_COUNT_RARE = properties.getInt(key, 3);
            int newRareMaxSessionCount = Math.max(1, this.MAX_SESSION_COUNT_RARE);
            if (QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[3] == newRareMaxSessionCount) goto L225;
            QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[3] = newRareMaxSessionCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L225:
            return;
        L176:
            this.MAX_SESSION_COUNT_FREQUENT = properties.getInt(key, 8);
            int newFrequentMaxSessionCount = Math.max(1, this.MAX_SESSION_COUNT_FREQUENT);
            if (QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[2] == newFrequentMaxSessionCount) goto L227;
            QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[2] = newFrequentMaxSessionCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L227:
            return;
        L179:
            this.MAX_SESSION_COUNT_WORKING = properties.getInt(key, 10);
            int newWorkingMaxSessionCount = Math.max(1, this.MAX_SESSION_COUNT_WORKING);
            if (QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[1] == newWorkingMaxSessionCount) goto L229;
            QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[1] = newWorkingMaxSessionCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L229:
            return;
        L182:
            this.MAX_SESSION_COUNT_ACTIVE = properties.getInt(key, 75);
            int newActiveMaxSessionCount = Math.max(1, this.MAX_SESSION_COUNT_ACTIVE);
            if (QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[0] == newActiveMaxSessionCount) goto L231;
            QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[0] = newActiveMaxSessionCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L231:
            return;
        L185:
            this.MAX_SESSION_COUNT_EXEMPTED = properties.getInt(key, 75);
            int newExemptedMaxSessionCount = Math.max(1, this.MAX_SESSION_COUNT_EXEMPTED);
            if (QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[6] == newExemptedMaxSessionCount) goto L233;
            QuotaController.m5033$$Nest$fgetmMaxBucketSessionCounts(this.this$0)[6] = newExemptedMaxSessionCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L233:
            return;
        L188:
            this.MAX_JOB_COUNT_RESTRICTED = properties.getInt(key, 10);
            int newRestrictedMaxJobCount = Math.max(10, this.MAX_JOB_COUNT_RESTRICTED);
            if (QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[5] == newRestrictedMaxJobCount) goto L235;
            QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[5] = newRestrictedMaxJobCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L235:
            return;
        L191:
            this.MAX_JOB_COUNT_RARE = properties.getInt(key, 48);
            int newRareMaxJobCount = Math.max(10, this.MAX_JOB_COUNT_RARE);
            if (QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[3] == newRareMaxJobCount) goto L237;
            QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[3] = newRareMaxJobCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L237:
            return;
        L194:
            this.MAX_JOB_COUNT_FREQUENT = properties.getInt(key, 200);
            int newFrequentMaxJobCount = Math.max(10, this.MAX_JOB_COUNT_FREQUENT);
            if (QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[2] == newFrequentMaxJobCount) goto L239;
            QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[2] = newFrequentMaxJobCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L239:
            return;
        L197:
            this.MAX_JOB_COUNT_WORKING = properties.getInt(key, 120);
            int newWorkingMaxJobCount = Math.max(10, this.MAX_JOB_COUNT_WORKING);
            if (QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[1] == newWorkingMaxJobCount) goto L241;
            QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[1] = newWorkingMaxJobCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L241:
            return;
        L200:
            this.MAX_JOB_COUNT_ACTIVE = properties.getInt(key, 75);
            int newActiveMaxJobCount = Math.max(10, this.MAX_JOB_COUNT_ACTIVE);
            if (QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[0] == newActiveMaxJobCount) goto L243;
            QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[0] = newActiveMaxJobCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L243:
            return;
        L203:
            this.MAX_JOB_COUNT_EXEMPTED = properties.getInt(key, 75);
            int newExemptedMaxJobCount = Math.max(10, this.MAX_JOB_COUNT_EXEMPTED);
            if (QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[6] == newExemptedMaxJobCount) goto L245;
            QuotaController.m5032$$Nest$fgetmMaxBucketJobCounts(this.this$0)[6] = newExemptedMaxJobCount;
            this.mShouldReevaluateConstraints = true;
            return;
        L245:
            return;
        L206:
            updateEJLimitConstantsLocked();
            return;
        L207:
            updateRateLimitingConstantsLocked();
            return;
        L208:
            updateExecutionPeriodConstantsLocked();
            return;
        L148:
            if (isCompatEnabled == true) goto L150;
            long r5 = 5000;
        L151:
            this.EJ_REWARD_INTERACTION_MS = properties.getLong(key, r5);
            QuotaController.m5050$$Nest$fputmEJRewardInteractionMs(this.this$0, Math.min(HeartbeatStats.MAX_NAT_TIME_MS, Math.max(5000, this.EJ_REWARD_INTERACTION_MS)));
            return;
        L150:
            r5 = DEFAULT_LEGACY_EJ_REWARD_INTERACTION_MS;
            goto L151
        L249:
            return;
        L158:
            if (isCompatEnabled == false) goto L161;
            r6 = 30000;
        L161:
            this.EJ_TOP_APP_TIME_CHUNK_SIZE_MS = properties.getLong(key, r6);
            long newChunkSizeMs = Math.min(HeartbeatStats.MAX_NAT_TIME_MS, Math.max(1, this.EJ_TOP_APP_TIME_CHUNK_SIZE_MS));
            if (QuotaController.m5026$$Nest$fgetmEJTopAppTimeChunkSizeMs(this.this$0) == newChunkSizeMs) goto L217;
            QuotaController.m5053$$Nest$fputmEJTopAppTimeChunkSizeMs(this.this$0, newChunkSizeMs);
            if (QuotaController.m5026$$Nest$fgetmEJTopAppTimeChunkSizeMs(this.this$0) >= QuotaController.m5025$$Nest$fgetmEJRewardTopAppMs(this.this$0)) goto L218;
            Slog.w(QuotaController.TAG, "EJ top app time chunk less than reward: " + QuotaController.m5026$$Nest$fgetmEJTopAppTimeChunkSizeMs(this.this$0) + " vs " + QuotaController.m5025$$Nest$fgetmEJRewardTopAppMs(this.this$0));
            return;
        L218:
            return;
        L217:
            return;
        L6:
            if (key.equals(KEY_MAX_SESSION_COUNT_FREQUENT) == false) goto L140;
            r4 = 34;
            goto L141
        L9:
            if (key.equals(KEY_MAX_SESSION_COUNT_RARE) == false) goto L140;
            r4 = 35;
            goto L141
        L12:
            if (key.equals(KEY_MAX_SESSION_COUNT_RESTRICTED) == false) goto L140;
            r4 = 36;
            goto L141
        L15:
            if (key.equals(KEY_EJ_WINDOW_SIZE_MS) == false) goto L140;
            r4 = ParameterName.GLOBE_DIMMING;
            goto L141
        L18:
            if (key.equals(KEY_TIMING_SESSION_COALESCING_DURATION_MS) == false) goto L140;
            r4 = 37;
            goto L141
        L21:
            if (key.equals(KEY_WINDOW_SIZE_ACTIVE_MS) == false) goto L140;
            r4 = 9;
            goto L141
        L24:
            if (key.equals(KEY_MAX_JOB_COUNT_WORKING) == false) goto L140;
            r4 = ParameterName.LEVEL_RANGE;
            goto L141
        L27:
            if (key.equals(KEY_EJ_REWARD_TOP_APP_MS) == false) goto L140;
            r4 = ParameterName.COLOR_TEMPERATURE_RED_OFFSET;
            goto L141
        L30:
            if (key.equals(KEY_EJ_LIMIT_WORKING_MS) == false) goto L140;
            r4 = ParameterName.DYNAMIC_LUMA_CONTROL;
            goto L141
        L33:
            if (key.equals(KEY_ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS) == false) goto L140;
            r4 = 0;
            goto L141
        L36:
            if (key.equals(KEY_MAX_SESSION_COUNT_WORKING) == false) goto L140;
            r4 = 33;
            goto L141
        L39:
            if (key.equals(KEY_MAX_SESSION_COUNT_EXEMPTED) == false) goto L140;
            r4 = ParameterName.VRR;
            goto L141
        L42:
            if (key.equals(KEY_IN_QUOTA_BUFFER_MS) == false) goto L140;
            r4 = 7;
            goto L141
        L45:
            if (key.equals(KEY_MIN_QUOTA_CHECK_DELAY_MS) == false) goto L140;
            r4 = ParameterName.COLOR_TEMPERATURE_GREEN_GAIN;
            goto L141
        L48:
            if (key.equals(KEY_EJ_GRACE_PERIOD_TEMP_ALLOWLIST_MS) == false) goto L140;
            r4 = ParameterName.ELEVEN_POINT_RED;
            goto L141
        L51:
            if (key.equals(KEY_ALLOWED_TIME_PER_PERIOD_RARE_MS) == false) goto L140;
            r4 = 4;
            goto L141
        L54:
            if (key.equals(KEY_MAX_SESSION_COUNT_ACTIVE) == false) goto L140;
            r4 = ParameterName.CVRR;
            goto L141
        L57:
            if (key.equals(KEY_WINDOW_SIZE_WORKING_MS) == false) goto L140;
            r4 = 10;
            goto L141
        L60:
            if (key.equals(KEY_EJ_GRACE_PERIOD_TOP_APP_MS) == false) goto L140;
            r4 = ParameterName.ELEVEN_POINT_GREEN;
            goto L141
        L63:
            if (key.equals(KEY_MAX_EXECUTION_TIME_MS) == false) goto L140;
            r4 = 8;
            goto L141
        L66:
            if (key.equals(KEY_EJ_LIMIT_ADDITION_INSTALLER_MS) == false) goto L140;
            r4 = ParameterName.COLOR_TEMPERATURE;
            goto L141
        L69:
            if (key.equals(KEY_EJ_LIMIT_RARE_MS) == false) goto L140;
            r4 = ParameterName.BLACK_STRETCH;
            goto L141
        L72:
            if (key.equals(KEY_EJ_LIMIT_RESTRICTED_MS) == false) goto L140;
            r4 = ParameterName.BLUE_STRETCH;
            goto L141
        L75:
            if (key.equals(KEY_MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW) == false) goto L140;
            r4 = 15;
            goto L141
        L78:
            if (key.equals(KEY_ALLOWED_TIME_PER_PERIOD_WORKING_MS) == false) goto L140;
            r4 = 2;
            goto L141
        L81:
            if (key.equals(KEY_ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS) == false) goto L140;
            r4 = 6;
            goto L141
        L84:
            if (key.equals(KEY_MAX_JOB_COUNT_FREQUENT) == false) goto L140;
            r4 = ParameterName.GAMUT_MAPPING;
            goto L141
        L87:
            if (key.equals(KEY_WINDOW_SIZE_RARE_MS) == false) goto L140;
            r4 = 12;
            goto L141
        L90:
            if (key.equals(KEY_MAX_JOB_COUNT_RESTRICTED) == false) goto L140;
            r4 = ParameterName.LOW_LATENCY;
            goto L141
        L93:
            if (key.equals(KEY_MAX_JOB_COUNT_EXEMPTED) == false) goto L140;
            r4 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
            goto L141
        L96:
            if (key.equals(KEY_MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW) == false) goto L140;
            r4 = 16;
            goto L141
        L99:
            if (key.equals(KEY_RATE_LIMITING_WINDOW_MS) == false) goto L140;
            r4 = 14;
            goto L141
        L102:
            if (key.equals(KEY_EJ_REWARD_INTERACTION_MS) == false) goto L140;
            r4 = 41;
            goto L141
        L105:
            if (key.equals(KEY_ALLOWED_TIME_PER_PERIOD_FREQUENT_MS) == false) goto L140;
            r4 = 3;
            goto L141
        L108:
            if (key.equals(KEY_WINDOW_SIZE_RESTRICTED_MS) == false) goto L140;
            r4 = 13;
            goto L141
        L111:
            if (key.equals(KEY_MAX_JOB_COUNT_RARE) == false) goto L140;
            r4 = ParameterName.PC_MODE;
            goto L141
        L114:
            if (key.equals(KEY_EJ_TOP_APP_TIME_CHUNK_SIZE_MS) == false) goto L140;
            r4 = ParameterName.COLOR_TEMPERATURE_BLUE_GAIN;
            goto L141
        L117:
            if (key.equals(KEY_MAX_JOB_COUNT_ACTIVE) == false) goto L140;
            r4 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
            goto L141
        L120:
            if (key.equals(KEY_EJ_REWARD_NOTIFICATION_SEEN_MS) == false) goto L140;
            r4 = 42;
            goto L141
        L123:
            if (key.equals(KEY_EJ_LIMIT_ADDITION_SPECIAL_MS) == false) goto L140;
            r4 = ParameterName.COLOR_TUNE;
            goto L141
        L126:
            if (key.equals(KEY_EJ_LIMIT_FREQUENT_MS) == false) goto L140;
            r4 = ParameterName.FILM_MODE;
            goto L141
        L129:
            if (key.equals(KEY_ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS) == false) goto L140;
            r4 = 5;
            goto L141
        L132:
            if (key.equals(KEY_WINDOW_SIZE_FREQUENT_MS) == false) goto L140;
            r4 = 11;
            goto L141
        L135:
            if (key.equals(KEY_ALLOWED_TIME_PER_PERIOD_ACTIVE_MS) == false) goto L140;
            r4 = 1;
            goto L141
        L138:
            if (key.equals(KEY_EJ_LIMIT_ACTIVE_MS) == false) goto L140;
            r4 = ParameterName.DE_CONTOUR;
            goto L141
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void updateExecutionPeriodConstantsLocked() {
            if (this.mExecutionPeriodConstantsUpdated == false) goto L5;
            return;
        L5:
            this.mExecutionPeriodConstantsUpdated = true;
            boolean r2 = QuotaController.m5067$$Nest$misCompatOverridedForQuotaConstantAdjustment(this.this$0);
            DeviceConfig.Properties r3 = DeviceConfig.getProperties("jobscheduler", new String[]{KEY_ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS, KEY_ALLOWED_TIME_PER_PERIOD_ACTIVE_MS, KEY_ALLOWED_TIME_PER_PERIOD_WORKING_MS, KEY_ALLOWED_TIME_PER_PERIOD_FREQUENT_MS, KEY_ALLOWED_TIME_PER_PERIOD_RARE_MS, KEY_ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS, KEY_ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS, KEY_IN_QUOTA_BUFFER_MS, KEY_MAX_EXECUTION_TIME_MS, KEY_WINDOW_SIZE_EXEMPTED_MS, KEY_WINDOW_SIZE_ACTIVE_MS, KEY_WINDOW_SIZE_WORKING_MS, KEY_WINDOW_SIZE_FREQUENT_MS, KEY_WINDOW_SIZE_RARE_MS, KEY_WINDOW_SIZE_RESTRICTED_MS});
            long r5 = 1200000;
            this.ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS = r3.getLong(KEY_ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS, 1200000);
            this.ALLOWED_TIME_PER_PERIOD_ACTIVE_MS = r3.getLong(KEY_ALLOWED_TIME_PER_PERIOD_ACTIVE_MS, 1200000);
            long r7 = 600000;
            this.ALLOWED_TIME_PER_PERIOD_WORKING_MS = r3.getLong(KEY_ALLOWED_TIME_PER_PERIOD_WORKING_MS, 600000);
            this.ALLOWED_TIME_PER_PERIOD_FREQUENT_MS = r3.getLong(KEY_ALLOWED_TIME_PER_PERIOD_FREQUENT_MS, 600000);
            this.ALLOWED_TIME_PER_PERIOD_RARE_MS = r3.getLong(KEY_ALLOWED_TIME_PER_PERIOD_RARE_MS, 600000);
            this.ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS = r3.getLong(KEY_ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS, 600000);
            this.ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS = r3.getLong(KEY_ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS, 1200000);
            this.IN_QUOTA_BUFFER_MS = r3.getLong(KEY_IN_QUOTA_BUFFER_MS, 30000);
            long r9 = 14400000;
            this.MAX_EXECUTION_TIME_MS = r3.getLong(KEY_MAX_EXECUTION_TIME_MS, 14400000);
            if (r2 == true) goto L8;
            r5 = DEFAULT_LATEST_WINDOW_SIZE_EXEMPTED_MS;
        L11:
            this.WINDOW_SIZE_EXEMPTED_MS = r3.getLong(KEY_WINDOW_SIZE_EXEMPTED_MS, r5);
            if (r2 == true) goto L14;
            r7 = 3600000;
        L17:
            this.WINDOW_SIZE_ACTIVE_MS = r3.getLong(KEY_WINDOW_SIZE_ACTIVE_MS, r7);
            if (r2 == false) goto L21;
            r9 = 7200000;
        L21:
            this.WINDOW_SIZE_WORKING_MS = r3.getLong(KEY_WINDOW_SIZE_WORKING_MS, r9);
            if (r2 == true) goto L24;
            long r6 = 43200000;
        L25:
            this.WINDOW_SIZE_FREQUENT_MS = r3.getLong(KEY_WINDOW_SIZE_FREQUENT_MS, r6);
            this.WINDOW_SIZE_RARE_MS = r3.getLong(KEY_WINDOW_SIZE_RARE_MS, 86400000);
            this.WINDOW_SIZE_RESTRICTED_MS = r3.getLong(KEY_WINDOW_SIZE_RESTRICTED_MS, 86400000);
            long r4 = Math.max(3600000, Math.min(86400000, this.MAX_EXECUTION_TIME_MS));
            if (QuotaController.m5034$$Nest$fgetmMaxExecutionTimeMs(this.this$0) == r4) goto L28;
            QuotaController.m5057$$Nest$fputmMaxExecutionTimeMs(this.this$0, r4);
            QuotaController.m5056$$Nest$fputmMaxExecutionTimeIntoQuotaMs(this.this$0, QuotaController.m5034$$Nest$fgetmMaxExecutionTimeMs(this.this$0) - QuotaController.m5038$$Nest$fgetmQuotaBufferMs(this.this$0));
            this.mShouldReevaluateConstraints = true;
        L28:
            long r11 = Math.min(QuotaController.m5034$$Nest$fgetmMaxExecutionTimeMs(this.this$0), Math.max(60000, this.ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS));
            long r10 = Math.min(Long.MAX_VALUE, r11);
            if (QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[6] == r11) goto L31;
            QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[6] = r11;
            this.mShouldReevaluateConstraints = true;
        L31:
            long r1 = Math.min(QuotaController.m5034$$Nest$fgetmMaxExecutionTimeMs(this.this$0), Math.max(60000, this.ALLOWED_TIME_PER_PERIOD_ACTIVE_MS));
            long r12 = Math.min(r10, r1);
            if (QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[0] == r1) goto L34;
            QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[0] = r1;
            this.mShouldReevaluateConstraints = true;
        L34:
            long r8 = Math.min(QuotaController.m5034$$Nest$fgetmMaxExecutionTimeMs(this.this$0), Math.max(60000, this.ALLOWED_TIME_PER_PERIOD_WORKING_MS));
            long r13 = Math.min(r12, r8);
            if (QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[1] == r8) goto L37;
            QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[1] = r8;
            this.mShouldReevaluateConstraints = true;
        L37:
            long r14 = Math.min(QuotaController.m5034$$Nest$fgetmMaxExecutionTimeMs(this.this$0), Math.max(60000, this.ALLOWED_TIME_PER_PERIOD_FREQUENT_MS));
            long r15 = Math.min(r13, r14);
            if (QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[2] == r14) goto L40;
            QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[2] = r14;
            this.mShouldReevaluateConstraints = true;
        L40:
            long r16 = Math.min(QuotaController.m5034$$Nest$fgetmMaxExecutionTimeMs(this.this$0), Math.max(60000, this.ALLOWED_TIME_PER_PERIOD_RARE_MS));
            long r17 = Math.min(r15, r16);
            if (QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[3] == r16) goto L43;
            QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[3] = r16;
            this.mShouldReevaluateConstraints = true;
        L43:
            long r18 = Math.min(QuotaController.m5034$$Nest$fgetmMaxExecutionTimeMs(this.this$0), Math.max(60000, this.ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS));
            long r19 = Math.min(r17, r18);
            if (QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[5] == r18) goto L46;
            QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[5] = r18;
            this.mShouldReevaluateConstraints = true;
        L46:
            long r110 = Math.max(0, Math.min(r19, Math.min(300000, this.IN_QUOTA_BUFFER_MS)));
            if (QuotaController.m5038$$Nest$fgetmQuotaBufferMs(this.this$0) == r110) goto L50;
            QuotaController.m5060$$Nest$fputmQuotaBufferMs(this.this$0, r110);
            QuotaController.m5056$$Nest$fputmMaxExecutionTimeIntoQuotaMs(this.this$0, QuotaController.m5034$$Nest$fgetmMaxExecutionTimeMs(this.this$0) - QuotaController.m5038$$Nest$fgetmQuotaBufferMs(this.this$0));
            this.mShouldReevaluateConstraints = true;
        L50:
            long r20 = Math.max(QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[6], Math.min(86400000, this.WINDOW_SIZE_EXEMPTED_MS));
            if (QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[6] == r20) goto L53;
            QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[6] = r20;
            this.mShouldReevaluateConstraints = true;
        L53:
            long r21 = Math.max(QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[0], Math.min(86400000, this.WINDOW_SIZE_ACTIVE_MS));
            if (QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[0] == r21) goto L56;
            QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[0] = r21;
            char r22 = 1;
            this.mShouldReevaluateConstraints = true;
        L57:
            boolean r23 = r22;
            long r111 = Math.max(QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[r22], Math.min(86400000, this.WINDOW_SIZE_WORKING_MS));
            if (QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[r23 ? 1 : 0] == r111) goto L60;
            QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[r23 ? 1 : 0] = r111;
            this.mShouldReevaluateConstraints = r23;
        L60:
            long r24 = Math.max(QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[2], Math.min(86400000, this.WINDOW_SIZE_FREQUENT_MS));
            if (QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[2] == r24) goto L63;
            QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[2] = r24;
            this.mShouldReevaluateConstraints = true;
        L63:
            long r25 = Math.max(QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[3], Math.min(86400000, this.WINDOW_SIZE_RARE_MS));
            if (QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[3] == r25) goto L66;
            QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[3] = r25;
            this.mShouldReevaluateConstraints = true;
        L66:
            long r26 = Math.max(QuotaController.m5015$$Nest$fgetmAllowedTimePerPeriodMs(this.this$0)[r9], Math.min(UnixCalendar.WEEK_IN_MILLIS, this.WINDOW_SIZE_RESTRICTED_MS));
            if (QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[r9] == r26) goto L69;
            QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[5] = r26;
            this.mShouldReevaluateConstraints = true;
        L69:
            long r27 = Math.max(0, Math.min(QuotaController.m5017$$Nest$fgetmBucketPeriodsMs(this.this$0)[6] - r11, this.ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS));
            if (QuotaController.m5016$$Nest$fgetmAllowedTimePeriodAdditionaInstallerMs(this.this$0) == r27) goto L73;
            QuotaController.m5046$$Nest$fputmAllowedTimePeriodAdditionaInstallerMs(this.this$0, r27);
            this.mShouldReevaluateConstraints = true;
            return;
        L73:
            return;
        L56:
            r22 = 1;
            goto L57
        L24:
            r6 = DEFAULT_LEGACY_WINDOW_SIZE_FREQUENT_MS;
            goto L25
        L14:
            if (r2 == true) goto L17;
            r7 = 1800000;
            goto L17
        L8:
            if (r2 == false) goto L11;
            r5 = 600000;
            goto L11
        }

        private void updateRateLimitingConstantsLocked() {
            if (this.mRateLimitingConstantsUpdated == false) goto L5;
            return;
        L5:
            this.mRateLimitingConstantsUpdated = true;
            DeviceConfig.Properties properties = DeviceConfig.getProperties("jobscheduler", new String[]{KEY_RATE_LIMITING_WINDOW_MS, KEY_MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW, KEY_MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW});
            this.RATE_LIMITING_WINDOW_MS = properties.getLong(KEY_RATE_LIMITING_WINDOW_MS, 60000);
            this.MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW = properties.getInt(KEY_MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW, 20);
            this.MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW = properties.getInt(KEY_MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW, 20);
            long newRateLimitingWindowMs = Math.min(86400000, Math.max(30000, this.RATE_LIMITING_WINDOW_MS));
            if (QuotaController.m5039$$Nest$fgetmRateLimitingWindowMs(this.this$0) == newRateLimitingWindowMs) goto L8;
            QuotaController.m5061$$Nest$fputmRateLimitingWindowMs(this.this$0, newRateLimitingWindowMs);
            this.mShouldReevaluateConstraints = true;
        L8:
            int newMaxJobCountPerRateLimitingWindow = Math.max(10, this.MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW);
            if (QuotaController.m5035$$Nest$fgetmMaxJobCountPerRateLimitingWindow(this.this$0) == newMaxJobCountPerRateLimitingWindow) goto L11;
            QuotaController.m5058$$Nest$fputmMaxJobCountPerRateLimitingWindow(this.this$0, newMaxJobCountPerRateLimitingWindow);
            this.mShouldReevaluateConstraints = true;
        L11:
            int newMaxSessionCountPerRateLimitPeriod = Math.max(10, this.MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW);
            if (QuotaController.m5036$$Nest$fgetmMaxSessionCountPerRateLimitingWindow(this.this$0) == newMaxSessionCountPerRateLimitPeriod) goto L15;
            QuotaController.m5059$$Nest$fputmMaxSessionCountPerRateLimitingWindow(this.this$0, newMaxSessionCountPerRateLimitPeriod);
            this.mShouldReevaluateConstraints = true;
            return;
        }

        private void updateEJLimitConstantsLocked() {
            if (this.mEJLimitConstantsUpdated == false) goto L5;
            return;
        L5:
            this.mEJLimitConstantsUpdated = true;
            boolean isCompatEnabled = QuotaController.m5067$$Nest$misCompatOverridedForQuotaConstantAdjustment(this.this$0);
            DeviceConfig.Properties properties = DeviceConfig.getProperties("jobscheduler", new String[]{KEY_EJ_LIMIT_EXEMPTED_MS, KEY_EJ_LIMIT_ACTIVE_MS, KEY_EJ_LIMIT_WORKING_MS, KEY_EJ_LIMIT_FREQUENT_MS, KEY_EJ_LIMIT_RARE_MS, KEY_EJ_LIMIT_RESTRICTED_MS, KEY_EJ_LIMIT_ADDITION_SPECIAL_MS, KEY_EJ_LIMIT_ADDITION_INSTALLER_MS, KEY_EJ_WINDOW_SIZE_MS});
            this.EJ_LIMIT_EXEMPTED_MS = properties.getLong(KEY_EJ_LIMIT_EXEMPTED_MS, 3600000);
            this.EJ_LIMIT_ACTIVE_MS = properties.getLong(KEY_EJ_LIMIT_ACTIVE_MS, 1800000);
            if (isCompatEnabled == true) goto L8;
            long r11 = 900000;
        L9:
            this.EJ_LIMIT_WORKING_MS = properties.getLong(KEY_EJ_LIMIT_WORKING_MS, r11);
            this.EJ_LIMIT_FREQUENT_MS = properties.getLong(KEY_EJ_LIMIT_FREQUENT_MS, 600000);
            this.EJ_LIMIT_RARE_MS = properties.getLong(KEY_EJ_LIMIT_RARE_MS, 600000);
            this.EJ_LIMIT_RESTRICTED_MS = properties.getLong(KEY_EJ_LIMIT_RESTRICTED_MS, 300000);
            this.EJ_LIMIT_ADDITION_INSTALLER_MS = properties.getLong(KEY_EJ_LIMIT_ADDITION_INSTALLER_MS, 1800000);
            this.EJ_LIMIT_ADDITION_SPECIAL_MS = properties.getLong(KEY_EJ_LIMIT_ADDITION_SPECIAL_MS, HeartbeatStats.MAX_NAT_TIME_MS);
            this.EJ_WINDOW_SIZE_MS = properties.getLong(KEY_EJ_WINDOW_SIZE_MS, 86400000);
            long newWindowSizeMs = Math.max(3600000, Math.min(86400000, this.EJ_WINDOW_SIZE_MS));
            if (QuotaController.m5020$$Nest$fgetmEJLimitWindowSizeMs(this.this$0) == newWindowSizeMs) goto L12;
            QuotaController.m5049$$Nest$fputmEJLimitWindowSizeMs(this.this$0, newWindowSizeMs);
            this.mShouldReevaluateConstraints = true;
        L12:
            long newExemptLimitMs = Math.max(HeartbeatStats.MAX_NAT_TIME_MS, Math.min(newWindowSizeMs, this.EJ_LIMIT_EXEMPTED_MS));
            if (QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[6] == newExemptLimitMs) goto L15;
            QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[6] = newExemptLimitMs;
            this.mShouldReevaluateConstraints = true;
        L15:
            long newActiveLimitMs = Math.max(HeartbeatStats.MAX_NAT_TIME_MS, Math.min(newExemptLimitMs, this.EJ_LIMIT_ACTIVE_MS));
            if (QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[0] == newActiveLimitMs) goto L18;
            QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[0] = newActiveLimitMs;
            this.mShouldReevaluateConstraints = true;
        L18:
            long newWorkingLimitMs = Math.max(HeartbeatStats.MAX_NAT_TIME_MS, Math.min(newActiveLimitMs, this.EJ_LIMIT_WORKING_MS));
            if (QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[1] == newWorkingLimitMs) goto L21;
            QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[1] = newWorkingLimitMs;
            this.mShouldReevaluateConstraints = true;
        L21:
            long newFrequentLimitMs = Math.max(600000, Math.min(newWorkingLimitMs, this.EJ_LIMIT_FREQUENT_MS));
            if (QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[2] == newFrequentLimitMs) goto L24;
            QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[2] = newFrequentLimitMs;
            this.mShouldReevaluateConstraints = true;
        L24:
            long newRareLimitMs = Math.max(600000, Math.min(newFrequentLimitMs, this.EJ_LIMIT_RARE_MS));
            if (QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[3] == newRareLimitMs) goto L27;
            QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[3] = newRareLimitMs;
            this.mShouldReevaluateConstraints = true;
        L27:
            long newRestrictedLimitMs = Math.max(300000, Math.min(newRareLimitMs, this.EJ_LIMIT_RESTRICTED_MS));
            if (QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[5] == newRestrictedLimitMs) goto L30;
            QuotaController.m5021$$Nest$fgetmEJLimitsMs(this.this$0)[5] = newRestrictedLimitMs;
            this.mShouldReevaluateConstraints = true;
        L30:
            long newAdditionInstallerMs = Math.max(0, Math.min(newWindowSizeMs - newActiveLimitMs, this.EJ_LIMIT_ADDITION_INSTALLER_MS));
            if (QuotaController.m5027$$Nest$fgetmEjLimitAdditionInstallerMs(this.this$0) == newAdditionInstallerMs) goto L33;
            QuotaController.m5054$$Nest$fputmEjLimitAdditionInstallerMs(this.this$0, newAdditionInstallerMs);
            this.mShouldReevaluateConstraints = true;
        L33:
            long newAdditionSpecialMs = Math.max(0, Math.min(newWindowSizeMs - newActiveLimitMs, this.EJ_LIMIT_ADDITION_SPECIAL_MS));
            if (QuotaController.m5028$$Nest$fgetmEjLimitAdditionSpecialMs(this.this$0) == newAdditionSpecialMs) goto L37;
            QuotaController.m5055$$Nest$fputmEjLimitAdditionSpecialMs(this.this$0, newAdditionSpecialMs);
            this.mShouldReevaluateConstraints = true;
            return;
        L37:
            return;
        L8:
            r11 = 1800000;
            goto L9
        }

        private void dump(IndentingPrintWriter pw) {
            pw.println();
            pw.println("QuotaController:");
            pw.increaseIndent();
            pw.print(KEY_ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS, Long.valueOf(this.ALLOWED_TIME_PER_PERIOD_EXEMPTED_MS)).println();
            pw.print(KEY_ALLOWED_TIME_PER_PERIOD_ACTIVE_MS, Long.valueOf(this.ALLOWED_TIME_PER_PERIOD_ACTIVE_MS)).println();
            pw.print(KEY_ALLOWED_TIME_PER_PERIOD_WORKING_MS, Long.valueOf(this.ALLOWED_TIME_PER_PERIOD_WORKING_MS)).println();
            pw.print(KEY_ALLOWED_TIME_PER_PERIOD_FREQUENT_MS, Long.valueOf(this.ALLOWED_TIME_PER_PERIOD_FREQUENT_MS)).println();
            pw.print(KEY_ALLOWED_TIME_PER_PERIOD_RARE_MS, Long.valueOf(this.ALLOWED_TIME_PER_PERIOD_RARE_MS)).println();
            pw.print(KEY_ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS, Long.valueOf(this.ALLOWED_TIME_PER_PERIOD_RESTRICTED_MS)).println();
            pw.print(KEY_ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS, Long.valueOf(this.ALLOWED_TIME_PER_PERIOD_ADDITION_INSTALLER_MS)).println();
            pw.print(KEY_IN_QUOTA_BUFFER_MS, Long.valueOf(this.IN_QUOTA_BUFFER_MS)).println();
            pw.print(KEY_WINDOW_SIZE_EXEMPTED_MS, Long.valueOf(this.WINDOW_SIZE_EXEMPTED_MS)).println();
            pw.print(KEY_WINDOW_SIZE_ACTIVE_MS, Long.valueOf(this.WINDOW_SIZE_ACTIVE_MS)).println();
            pw.print(KEY_WINDOW_SIZE_WORKING_MS, Long.valueOf(this.WINDOW_SIZE_WORKING_MS)).println();
            pw.print(KEY_WINDOW_SIZE_FREQUENT_MS, Long.valueOf(this.WINDOW_SIZE_FREQUENT_MS)).println();
            pw.print(KEY_WINDOW_SIZE_RARE_MS, Long.valueOf(this.WINDOW_SIZE_RARE_MS)).println();
            pw.print(KEY_WINDOW_SIZE_RESTRICTED_MS, Long.valueOf(this.WINDOW_SIZE_RESTRICTED_MS)).println();
            pw.print(KEY_MAX_EXECUTION_TIME_MS, Long.valueOf(this.MAX_EXECUTION_TIME_MS)).println();
            pw.print(KEY_MAX_JOB_COUNT_EXEMPTED, Integer.valueOf(this.MAX_JOB_COUNT_EXEMPTED)).println();
            pw.print(KEY_MAX_JOB_COUNT_ACTIVE, Integer.valueOf(this.MAX_JOB_COUNT_ACTIVE)).println();
            pw.print(KEY_MAX_JOB_COUNT_WORKING, Integer.valueOf(this.MAX_JOB_COUNT_WORKING)).println();
            pw.print(KEY_MAX_JOB_COUNT_FREQUENT, Integer.valueOf(this.MAX_JOB_COUNT_FREQUENT)).println();
            pw.print(KEY_MAX_JOB_COUNT_RARE, Integer.valueOf(this.MAX_JOB_COUNT_RARE)).println();
            pw.print(KEY_MAX_JOB_COUNT_RESTRICTED, Integer.valueOf(this.MAX_JOB_COUNT_RESTRICTED)).println();
            pw.print(KEY_RATE_LIMITING_WINDOW_MS, Long.valueOf(this.RATE_LIMITING_WINDOW_MS)).println();
            pw.print(KEY_MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW, Integer.valueOf(this.MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW)).println();
            pw.print(KEY_MAX_SESSION_COUNT_EXEMPTED, Integer.valueOf(this.MAX_SESSION_COUNT_EXEMPTED)).println();
            pw.print(KEY_MAX_SESSION_COUNT_ACTIVE, Integer.valueOf(this.MAX_SESSION_COUNT_ACTIVE)).println();
            pw.print(KEY_MAX_SESSION_COUNT_WORKING, Integer.valueOf(this.MAX_SESSION_COUNT_WORKING)).println();
            pw.print(KEY_MAX_SESSION_COUNT_FREQUENT, Integer.valueOf(this.MAX_SESSION_COUNT_FREQUENT)).println();
            pw.print(KEY_MAX_SESSION_COUNT_RARE, Integer.valueOf(this.MAX_SESSION_COUNT_RARE)).println();
            pw.print(KEY_MAX_SESSION_COUNT_RESTRICTED, Integer.valueOf(this.MAX_SESSION_COUNT_RESTRICTED)).println();
            pw.print(KEY_MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW, Integer.valueOf(this.MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW)).println();
            pw.print(KEY_TIMING_SESSION_COALESCING_DURATION_MS, Long.valueOf(this.TIMING_SESSION_COALESCING_DURATION_MS)).println();
            pw.print(KEY_MIN_QUOTA_CHECK_DELAY_MS, Long.valueOf(this.MIN_QUOTA_CHECK_DELAY_MS)).println();
            pw.print(KEY_EJ_LIMIT_EXEMPTED_MS, Long.valueOf(this.EJ_LIMIT_EXEMPTED_MS)).println();
            pw.print(KEY_EJ_LIMIT_ACTIVE_MS, Long.valueOf(this.EJ_LIMIT_ACTIVE_MS)).println();
            pw.print(KEY_EJ_LIMIT_WORKING_MS, Long.valueOf(this.EJ_LIMIT_WORKING_MS)).println();
            pw.print(KEY_EJ_LIMIT_FREQUENT_MS, Long.valueOf(this.EJ_LIMIT_FREQUENT_MS)).println();
            pw.print(KEY_EJ_LIMIT_RARE_MS, Long.valueOf(this.EJ_LIMIT_RARE_MS)).println();
            pw.print(KEY_EJ_LIMIT_RESTRICTED_MS, Long.valueOf(this.EJ_LIMIT_RESTRICTED_MS)).println();
            pw.print(KEY_EJ_LIMIT_ADDITION_INSTALLER_MS, Long.valueOf(this.EJ_LIMIT_ADDITION_INSTALLER_MS)).println();
            pw.print(KEY_EJ_LIMIT_ADDITION_SPECIAL_MS, Long.valueOf(this.EJ_LIMIT_ADDITION_SPECIAL_MS)).println();
            pw.print(KEY_EJ_WINDOW_SIZE_MS, Long.valueOf(this.EJ_WINDOW_SIZE_MS)).println();
            pw.print(KEY_EJ_TOP_APP_TIME_CHUNK_SIZE_MS, Long.valueOf(this.EJ_TOP_APP_TIME_CHUNK_SIZE_MS)).println();
            pw.print(KEY_EJ_REWARD_TOP_APP_MS, Long.valueOf(this.EJ_REWARD_TOP_APP_MS)).println();
            pw.print(KEY_EJ_REWARD_INTERACTION_MS, Long.valueOf(this.EJ_REWARD_INTERACTION_MS)).println();
            pw.print(KEY_EJ_REWARD_NOTIFICATION_SEEN_MS, Long.valueOf(this.EJ_REWARD_NOTIFICATION_SEEN_MS)).println();
            pw.print(KEY_EJ_GRACE_PERIOD_TEMP_ALLOWLIST_MS, Long.valueOf(this.EJ_GRACE_PERIOD_TEMP_ALLOWLIST_MS)).println();
            pw.print(KEY_EJ_GRACE_PERIOD_TOP_APP_MS, Long.valueOf(this.EJ_GRACE_PERIOD_TOP_APP_MS)).println();
            pw.decreaseIndent();
        }

        private void dump(ProtoOutputStream proto) {
            long qcToken = proto.start(1146756268056L);
            proto.write(1112396529666L, this.IN_QUOTA_BUFFER_MS);
            proto.write(1112396529667L, this.WINDOW_SIZE_ACTIVE_MS);
            proto.write(1112396529668L, this.WINDOW_SIZE_WORKING_MS);
            proto.write(1112396529669L, this.WINDOW_SIZE_FREQUENT_MS);
            proto.write(1112396529670L, this.WINDOW_SIZE_RARE_MS);
            proto.write(1112396529684L, this.WINDOW_SIZE_RESTRICTED_MS);
            proto.write(1112396529671L, this.MAX_EXECUTION_TIME_MS);
            proto.write(1120986464264L, this.MAX_JOB_COUNT_ACTIVE);
            proto.write(1120986464265L, this.MAX_JOB_COUNT_WORKING);
            proto.write(1120986464266L, this.MAX_JOB_COUNT_FREQUENT);
            proto.write(1120986464267L, this.MAX_JOB_COUNT_RARE);
            proto.write(1120986464277L, this.MAX_JOB_COUNT_RESTRICTED);
            proto.write(1120986464275L, this.RATE_LIMITING_WINDOW_MS);
            proto.write(1120986464268L, this.MAX_JOB_COUNT_PER_RATE_LIMITING_WINDOW);
            proto.write(1120986464269L, this.MAX_SESSION_COUNT_ACTIVE);
            proto.write(1120986464270L, this.MAX_SESSION_COUNT_WORKING);
            proto.write(1120986464271L, this.MAX_SESSION_COUNT_FREQUENT);
            proto.write(1120986464272L, this.MAX_SESSION_COUNT_RARE);
            proto.write(1120986464278L, this.MAX_SESSION_COUNT_RESTRICTED);
            proto.write(1120986464273L, this.MAX_SESSION_COUNT_PER_RATE_LIMITING_WINDOW);
            proto.write(1112396529682L, this.TIMING_SESSION_COALESCING_DURATION_MS);
            proto.write(1112396529687L, this.MIN_QUOTA_CHECK_DELAY_MS);
            proto.write(1112396529688L, this.EJ_LIMIT_ACTIVE_MS);
            proto.write(1112396529689L, this.EJ_LIMIT_WORKING_MS);
            proto.write(1112396529690L, this.EJ_LIMIT_FREQUENT_MS);
            proto.write(1112396529691L, this.EJ_LIMIT_RARE_MS);
            proto.write(1112396529692L, this.EJ_LIMIT_RESTRICTED_MS);
            proto.write(1112396529693L, this.EJ_WINDOW_SIZE_MS);
            proto.write(1112396529694L, this.EJ_TOP_APP_TIME_CHUNK_SIZE_MS);
            proto.write(1112396529695L, this.EJ_REWARD_TOP_APP_MS);
            proto.write(1112396529696L, this.EJ_REWARD_INTERACTION_MS);
            proto.write(1112396529697L, this.EJ_REWARD_NOTIFICATION_SEEN_MS);
            proto.end(qcToken);
        }
    }

    private class QcHandler extends Handler {
        final /* synthetic */ QuotaController this$0;

        QcHandler(QuotaController r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
        L10:
            th = move-exception;
            throw th;
        L5:
            switch(msg.what) {
                case 0: goto L147;
                case 1: goto L144;
                case 2: goto L139;
                case 3: goto L91;
                case 4: goto L78;
                case 5: goto L58;
                case 6: goto L13;
                case 7: goto L7;
                default: goto L160;
            };     // Catch: Throwable -> L10
        L7:
            UserPackage pkg = (UserPackage) msg.obj;     // Catch: Throwable -> L10
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L12;
            Slog.d(QuotaController.TAG, pkg + " has reached its count quota.");     // Catch: Throwable -> L10
        L12:
            Trace.instant(131072, QuotaController.TRACE_QUOTA_STATE_CHANGED_TAG + pkg + QuotaController.TRACE_QUOTA_STATE_CHANGED_DELIMITER + 7);     // Catch: Throwable -> L10
            this.this$0.mStateChangedListener.onControllerStateChanged(QuotaController.m5071$$Nest$mmaybeUpdateConstraintForPkgLocked(this.this$0, JobSchedulerService.sElapsedRealtimeClock.millis(), pkg.userId, pkg.packageName));     // Catch: Throwable -> L10
            goto L160
        L13:
            int uid = msg.arg1;     // Catch: Throwable -> L10
            Object r6 = this.this$0.mLock;     // Catch: Throwable -> L10
            monitor-enter(r6);     // Catch: Throwable -> L10
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L16:
            if (QuotaController.m5040$$Nest$fgetmTempAllowlistCache(this.this$0).get(uid) == true) goto L52;
            if (QuotaController.m5043$$Nest$fgetmTopAppCache(this.this$0).get(uid) == true) goto L52;
            long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L28
            if (nowElapsed < QuotaController.m5041$$Nest$fgetmTempAllowlistGraceCache(this.this$0).get(uid)) goto L47;
            if (nowElapsed < QuotaController.m5044$$Nest$fgetmTopAppGraceCache(this.this$0).get(uid)) goto L47;
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L30;
            Slog.d(QuotaController.TAG, uid + " is now out of grace period");     // Catch: Throwable -> L28
        L30:
            QuotaController.m5041$$Nest$fgetmTempAllowlistGraceCache(this.this$0).delete(uid);     // Catch: Throwable -> L28
            QuotaController.m5044$$Nest$fgetmTopAppGraceCache(this.this$0).delete(uid);     // Catch: Throwable -> L28
            if (Trace.isTagEnabled(524288) == false) goto L33;
            Trace.instantForTrack(524288, "JobScheduler", "<" + uid + ">#6");     // Catch: Throwable -> L28
        L33:
            ArraySet<String> packages = this.this$0.mService.getPackagesForUidLocked(uid);     // Catch: Throwable -> L28
            if (packages == null) goto L44;
            int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L28
            int i = packages.size() - 1;     // Catch: Throwable -> L28
        L36:
            if (i < 0) goto L41;
            Timer t = (Timer) QuotaController.m5022$$Nest$fgetmEJPkgTimers(this.this$0).get(userId, packages.valueAt(i));     // Catch: Throwable -> L28
            if (t == null) goto L40;
            t.onStateChangedLocked(nowElapsed, false);     // Catch: Throwable -> L28
        L40:
            i = i - 1;     // Catch: Throwable -> L28
            goto L36
        L41:
            ArraySet<JobStatus> changedJobs = QuotaController.m5072$$Nest$mmaybeUpdateConstraintForUidLocked(this.this$0, uid);     // Catch: Throwable -> L28
            if (changedJobs.size() <= 0) goto L44;
            this.this$0.mStateChangedListener.onControllerStateChanged(changedJobs);     // Catch: Throwable -> L28
        L44:
            monitor-exit(r6);     // Catch: Throwable -> L28
        L47:
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L49;
            Slog.d(QuotaController.TAG, uid + " is still in grace period");     // Catch: Throwable -> L28
        L49:
            monitor-exit(r6);     // Catch: Throwable -> L28
        L52:
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L54;
            Slog.d(QuotaController.TAG, uid + " is still allowed");     // Catch: Throwable -> L28
        L54:
            monitor-exit(r6);     // Catch: Throwable -> L28
            goto L160
        L58:
            int userId2 = msg.arg1;     // Catch: Throwable -> L10
            UsageEvents.Event event = (UsageEvents.Event) msg.obj;     // Catch: Throwable -> L10
            String pkgName = event.getPackageName();     // Catch: Throwable -> L10
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L62;
            Slog.d(QuotaController.TAG, "Processing event " + event.getEventType() + " for " + StateController.packageToString(userId2, pkgName));     // Catch: Throwable -> L10
        L62:
            switch(event.getEventType()) {
                case 1: goto L66;
                case 2: goto L66;
                case 7: goto L65;
                case 9: goto L65;
                case 10: goto L64;
                case 12: goto L65;
                case 23: goto L66;
                case 24: goto L66;
                default: goto L160;
            };     // Catch: Throwable -> L10
        L64:
            QuotaController.m5064$$Nest$mgrantRewardForInstantEvent(this.this$0, userId2, pkgName, QuotaController.m5024$$Nest$fgetmEJRewardNotificationSeenMs(this.this$0));     // Catch: Throwable -> L10
            goto L160
        L65:
            QuotaController.m5064$$Nest$mgrantRewardForInstantEvent(this.this$0, userId2, pkgName, QuotaController.m5023$$Nest$fgetmEJRewardInteractionMs(this.this$0));     // Catch: Throwable -> L10
            goto L160
        L66:
            Object r7 = this.this$0.mLock;     // Catch: Throwable -> L10
            monitor-enter(r7);     // Catch: Throwable -> L10
            TopAppTimer timer = (TopAppTimer) QuotaController.m5045$$Nest$fgetmTopAppTrackers(this.this$0).get(userId2, pkgName);     // Catch: Throwable -> L71
            if (timer != null) goto L73;
            timer = new TopAppTimer(this.this$0, userId2, pkgName);     // Catch: Throwable -> L71
            QuotaController.m5045$$Nest$fgetmTopAppTrackers(this.this$0).add(userId2, pkgName, timer);     // Catch: Throwable -> L71
        L73:
            timer.processEventLocked(event);     // Catch: Throwable -> L71
            monitor-exit(r7);     // Catch: Throwable -> L71
        L71:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L78:
            UserPackage pkg2 = (UserPackage) msg.obj;     // Catch: Throwable -> L10
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L82;
            Slog.d(QuotaController.TAG, "Checking if " + pkg2 + " has reached its EJ quota.");     // Catch: Throwable -> L10
        L82:
            if (this.this$0.getRemainingEJExecutionTimeLocked(pkg2.userId, pkg2.packageName) <= 0) goto L84;
            Message rescheduleMsg = obtainMessage(4, pkg2);     // Catch: Throwable -> L10
            long timeRemainingMs = this.this$0.getTimeUntilEJQuotaConsumedLocked(pkg2.userId, pkg2.packageName);     // Catch: Throwable -> L10
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L90;
            Slog.d(QuotaController.TAG, pkg2 + " has " + timeRemainingMs + "ms left for EJ");     // Catch: Throwable -> L10
        L90:
            sendMessageDelayed(rescheduleMsg, timeRemainingMs);     // Catch: Throwable -> L10
            goto L160
        L84:
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L86;
            Slog.d(QuotaController.TAG, pkg2 + " has reached its EJ quota.");     // Catch: Throwable -> L10
        L86:
            Trace.instant(131072, QuotaController.TRACE_QUOTA_STATE_CHANGED_TAG + pkg2 + QuotaController.TRACE_QUOTA_STATE_CHANGED_DELIMITER + 4);     // Catch: Throwable -> L10
            this.this$0.mStateChangedListener.onControllerStateChanged(QuotaController.m5071$$Nest$mmaybeUpdateConstraintForPkgLocked(this.this$0, JobSchedulerService.sElapsedRealtimeClock.millis(), pkg2.userId, pkg2.packageName));     // Catch: Throwable -> L10
            goto L160
        L91:
            int uid2 = msg.arg1;     // Catch: Throwable -> L10
            int procState = msg.arg2;     // Catch: Throwable -> L10
            int userId3 = UserHandle.getUserId(uid2);     // Catch: Throwable -> L10
            long nowElapsed2 = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L10
            Object r12 = this.this$0.mLock;     // Catch: Throwable -> L10
            monitor-enter(r12);     // Catch: Throwable -> L10
            if (procState > 2) goto L103;
            QuotaController.m5043$$Nest$fgetmTopAppCache(this.this$0).put(uid2, true);     // Catch: Throwable -> L99
            QuotaController.m5044$$Nest$fgetmTopAppGraceCache(this.this$0).delete(uid2);     // Catch: Throwable -> L99
            if (QuotaController.m5029$$Nest$fgetmForegroundUids(this.this$0).get(uid2) == false) goto L101;
            monitor-exit(r12);     // Catch: Throwable -> L99
            goto L160
        L101:
            QuotaController.m5029$$Nest$fgetmForegroundUids(this.this$0).put(uid2, true);     // Catch: Throwable -> L99
            boolean isQuotaFree = true;
        L118:
            if (QuotaController.m5037$$Nest$fgetmPkgTimers(this.this$0).indexOfKey(userId3) < 0) goto L120;
        L121:
            ArraySet<String> packages2 = this.this$0.mService.getPackagesForUidLocked(uid2);     // Catch: Throwable -> L99
            if (packages2 == null) goto L132;
            int i2 = packages2.size() - 1;     // Catch: Throwable -> L99
        L124:
            if (i2 < 0) goto L132;
            Timer t2 = (Timer) QuotaController.m5022$$Nest$fgetmEJPkgTimers(this.this$0).get(userId3, packages2.valueAt(i2));     // Catch: Throwable -> L99
            if (t2 == null) goto L128;
            t2.onStateChangedLocked(nowElapsed2, isQuotaFree);     // Catch: Throwable -> L99
        L128:
            Timer t3 = (Timer) QuotaController.m5037$$Nest$fgetmPkgTimers(this.this$0).get(userId3, packages2.valueAt(i2));     // Catch: Throwable -> L99
            if (t3 == null) goto L131;
            t3.onStateChangedLocked(nowElapsed2, isQuotaFree);     // Catch: Throwable -> L99
        L131:
            i2 = i2 - 1;     // Catch: Throwable -> L99
        L132:
            ArraySet<JobStatus> changedJobs2 = QuotaController.m5072$$Nest$mmaybeUpdateConstraintForUidLocked(this.this$0, uid2);     // Catch: Throwable -> L99
            if (changedJobs2.size() <= 0) goto L135;
            this.this$0.mStateChangedListener.onControllerStateChanged(changedJobs2);     // Catch: Throwable -> L99
        L135:
            monitor-exit(r12);     // Catch: Throwable -> L99
            goto L160
        L120:
            if (QuotaController.m5022$$Nest$fgetmEJPkgTimers(this.this$0).indexOfKey(userId3) < 0) goto L132;
        L103:
            if (procState <= this.this$0.getProcessStateQuotaFreeThreshold(uid2)) goto L105;
            QuotaController.m5029$$Nest$fgetmForegroundUids(this.this$0).delete(uid2);     // Catch: Throwable -> L99
            boolean reprocess = true;
            isQuotaFree = false;
        L111:
            if (QuotaController.m5043$$Nest$fgetmTopAppCache(this.this$0).get(uid2) == false) goto L114;
            long endElapsed = QuotaController.m5019$$Nest$fgetmEJGracePeriodTopAppMs(this.this$0) + nowElapsed2;     // Catch: Throwable -> L99
            QuotaController.m5043$$Nest$fgetmTopAppCache(this.this$0).delete(uid2);     // Catch: Throwable -> L99
            QuotaController.m5044$$Nest$fgetmTopAppGraceCache(this.this$0).put(uid2, endElapsed);     // Catch: Throwable -> L99
            sendMessageDelayed(obtainMessage(6, uid2, 0), QuotaController.m5019$$Nest$fgetmEJGracePeriodTopAppMs(this.this$0));     // Catch: Throwable -> L99
        L114:
            if (reprocess == true) goto L118;
            monitor-exit(r12);     // Catch: Throwable -> L99
            goto L160
        L105:
            if (QuotaController.m5029$$Nest$fgetmForegroundUids(this.this$0).get(uid2) == true) goto L107;
            boolean reprocess2 = true;
        L108:
            QuotaController.m5029$$Nest$fgetmForegroundUids(this.this$0).put(uid2, true);     // Catch: Throwable -> L99
            reprocess = reprocess2;
            isQuotaFree = true;
            goto L111
        L107:
            reprocess2 = false;
        L99:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L139:
            String packageName = (String) msg.obj;     // Catch: Throwable -> L10
            int userId4 = msg.arg1;     // Catch: Throwable -> L10
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L142;
            Slog.d(QuotaController.TAG, "Checking pkg " + StateController.packageToString(userId4, packageName));     // Catch: Throwable -> L10
        L142:
            this.this$0.mStateChangedListener.onControllerStateChanged(QuotaController.m5071$$Nest$mmaybeUpdateConstraintForPkgLocked(this.this$0, JobSchedulerService.sElapsedRealtimeClock.millis(), userId4, packageName));     // Catch: Throwable -> L10
            goto L160
        L147:
            UserPackage pkg3 = (UserPackage) msg.obj;     // Catch: Throwable -> L10
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L151;
            Slog.d(QuotaController.TAG, "Checking if " + pkg3 + " has reached its quota.");     // Catch: Throwable -> L10
        L151:
            if (this.this$0.getRemainingExecutionTimeLocked(pkg3.userId, pkg3.packageName) <= 50) goto L153;
            Message rescheduleMsg2 = obtainMessage(0, pkg3);     // Catch: Throwable -> L10
            long timeRemainingMs2 = this.this$0.getTimeUntilQuotaConsumedLocked(pkg3.userId, pkg3.packageName);     // Catch: Throwable -> L10
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L159;
            Slog.d(QuotaController.TAG, pkg3 + " has " + timeRemainingMs2 + "ms left.");     // Catch: Throwable -> L10
        L159:
            sendMessageDelayed(rescheduleMsg2, timeRemainingMs2);     // Catch: Throwable -> L10
            goto L160
        L153:
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L155;
            Slog.d(QuotaController.TAG, pkg3 + " has reached its quota.");     // Catch: Throwable -> L10
        L155:
            Trace.instant(131072, QuotaController.TRACE_QUOTA_STATE_CHANGED_TAG + pkg3 + QuotaController.TRACE_QUOTA_STATE_CHANGED_DELIMITER + 0);     // Catch: Throwable -> L10
            this.this$0.mStateChangedListener.onControllerStateChanged(QuotaController.m5071$$Nest$mmaybeUpdateConstraintForPkgLocked(this.this$0, JobSchedulerService.sElapsedRealtimeClock.millis(), pkg3.userId, pkg3.packageName));     // Catch: Throwable -> L10
        L160:
            monitor-exit(r3);     // Catch: Throwable -> L10
            return;
        L144:
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L146;
            Slog.d(QuotaController.TAG, "Cleaning up timing sessions.");     // Catch: Throwable -> L10
        L146:
            this.this$0.deleteObsoleteSessionsLocked();     // Catch: Throwable -> L10
            this.this$0.maybeScheduleCleanupAlarmLocked();     // Catch: Throwable -> L10
            goto L160
        }
    }

    private class QcUidObserver extends UidObserver {
        final /* synthetic */ QuotaController this$0;

        /* synthetic */ QcUidObserver(QuotaController r1, QuotaControllerIA r2) {
            this(r1);
        }

        private QcUidObserver(QuotaController r1) {
            this.this$0 = r1;
        }

        public void onUidStateChanged(int uid, int procState, long procStateSeq, int capability) {
            QuotaController.m5030$$Nest$fgetmHandler(this.this$0).obtainMessage(3, uid, procState).sendToTarget();
        }
    }

    static final class ShrinkableDebits {
        private long mDebitTally;
        private int mStandbyBucket;

        ShrinkableDebits(int standbyBucket) {
            this.mDebitTally = 0;
            this.mStandbyBucket = standbyBucket;
        }

        long getTallyLocked() {
            return this.mDebitTally;
        }

        long transactLocked(long amount) {
            if (amount < 0) goto L5;
        L7:
            long leftover = 0;
        L8:
            this.mDebitTally = Math.max(0, this.mDebitTally + amount);
            return leftover;
        L5:
            if (Math.abs(amount) <= this.mDebitTally) goto L7;
            leftover = this.mDebitTally + amount;
            goto L8
        }

        void setStandbyBucketLocked(int standbyBucket) {
            this.mStandbyBucket = standbyBucket;
        }

        int getStandbyBucketLocked() {
            return this.mStandbyBucket;
        }

        public String toString() {
            return "ShrinkableDebits { debit tally: " + this.mDebitTally + ", bucket: " + this.mStandbyBucket + " }";
        }

        void dumpLocked(IndentingPrintWriter pw) {
            pw.println(toString());
        }
    }

    final class StandbyTracker extends AppStandbyInternal.AppIdleStateChangeListener {
        final /* synthetic */ QuotaController this$0;

        public static /* synthetic */ void $r8$lambda$t09qsupi5NrKPja4qQPLgVYLvys(StandbyTracker r0, int r1, int r2, String r3) {
            r0.lambda$onAppIdleStateChanged$0(r1, r2, r3);
        }

        StandbyTracker(QuotaController this$0) {
            this.this$0 = this$0;
        }

        public void onAppIdleStateChanged(final String packageName, final int userId, boolean idle, final int bucket, int reason) {
            AppSchedulingModuleThread.getHandler().post(new QuotaController$StandbyTracker$$ExternalSyntheticLambda0(this, bucket, userId, packageName));
        }

        private /* synthetic */ void lambda$onAppIdleStateChanged$0(int bucket, int userId, String packageName) {
            int bucketIndex = JobSchedulerService.standbyBucketToBucketIndex(bucket);
            this.this$0.updateStandbyBucket(userId, packageName, bucketIndex);
        }
    }

    final class TempAllowlistTracker implements PowerAllowlistInternal.TempAllowlistChangeListener {
        final /* synthetic */ QuotaController this$0;

        TempAllowlistTracker(QuotaController this$0) {
            this.this$0 = this$0;
        }

        public void onAppAdded(int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L11
            QuotaController.m5040$$Nest$fgetmTempAllowlistCache(this.this$0).put(uid, true);     // Catch: Throwable -> L11
            ArraySet<String> packages = this.this$0.mService.getPackagesForUidLocked(uid);     // Catch: Throwable -> L11
            if (packages == null) goto L17;
            int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L11
            int i = packages.size() - 1;     // Catch: Throwable -> L11
        L7:
            if (i < 0) goto L14;
            Timer t = (Timer) QuotaController.m5022$$Nest$fgetmEJPkgTimers(this.this$0).get(userId, packages.valueAt(i));     // Catch: Throwable -> L11
            if (t == null) goto L13;
            t.onStateChangedLocked(nowElapsed, true);     // Catch: Throwable -> L11
        L13:
            i = i - 1;     // Catch: Throwable -> L11
            goto L7
        L14:
            ArraySet<JobStatus> changedJobs = QuotaController.m5072$$Nest$mmaybeUpdateConstraintForUidLocked(this.this$0, uid);     // Catch: Throwable -> L11
            if (changedJobs.size() <= 0) goto L17;
            this.this$0.mStateChangedListener.onControllerStateChanged(changedJobs);     // Catch: Throwable -> L11
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void onAppRemoved(int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L7
            long endElapsed = QuotaController.m5018$$Nest$fgetmEJGracePeriodTempAllowlistMs(this.this$0) + nowElapsed;     // Catch: Throwable -> L7
            QuotaController.m5040$$Nest$fgetmTempAllowlistCache(this.this$0).delete(uid);     // Catch: Throwable -> L7
            QuotaController.m5041$$Nest$fgetmTempAllowlistGraceCache(this.this$0).put(uid, endElapsed);     // Catch: Throwable -> L7
            Message msg = QuotaController.m5030$$Nest$fgetmHandler(this.this$0).obtainMessage(6, uid, 0);     // Catch: Throwable -> L7
            QuotaController.m5030$$Nest$fgetmHandler(this.this$0).sendMessageDelayed(msg, QuotaController.m5018$$Nest$fgetmEJGracePeriodTempAllowlistMs(this.this$0));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    interface TimedEvent {
        void dump(IndentingPrintWriter r1);

        long getEndTimeElapsed();
    }

    private static final class TimedEventTooOldPredicate implements Predicate<TimedEvent> {
        private long mNowElapsed;

        /* JADX INFO: renamed from: -$$Nest$mupdateNow, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5086$$Nest$mupdateNow(TimedEventTooOldPredicate r0) {
            r0.updateNow();
        }

        /* synthetic */ TimedEventTooOldPredicate(QuotaControllerIA r1) {
            this();
        }

        private TimedEventTooOldPredicate() {
        }

        @Override // java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(TimedEvent r1) {
            return test2(r1);
        }

        private void updateNow() {
            this.mNowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        }

        /* JADX INFO: renamed from: test, reason: avoid collision after fix types in other method */
        public boolean test2(TimedEvent ts) {
            if (ts.getEndTimeElapsed() > (this.mNowElapsed - 86400000)) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private final class Timer {
        private int mBgJobCount;
        private long mDebitAdjustment;
        private final UserPackage mPkg;
        private final boolean mRegularJobTimer;
        private final ArraySet<JobStatus> mRunningBgJobs;
        private long mStartTimeElapsed;
        private final int mUid;
        final /* synthetic */ QuotaController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmPkg, reason: not valid java name */
        static /* bridge */ /* synthetic */ UserPackage m5087$$Nest$fgetmPkg(Timer r0) {
            return r0.mPkg;
        }

        Timer(QuotaController r1, int uid, int userId, String packageName, boolean regularJobTimer) {
            this.this$0 = r1;
            this.mRunningBgJobs = new ArraySet();
            this.mPkg = UserPackage.of(userId, packageName);
            this.mUid = uid;
            this.mRegularJobTimer = regularJobTimer;
        }

        void startTrackingJobLocked(JobStatus jobStatus) {
            if (jobStatus.shouldTreatAsUserInitiatedJob() == false) goto L9;
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L36;
            Slog.v(QuotaController.TAG, "Timer ignoring " + jobStatus.toShortString() + " because it's user-initiated");
            return;
        L36:
            return;
        L9:
            if (QuotaController.m5069$$Nest$misTopStartedJobLocked(this.this$0, jobStatus) == false) goto L15;
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L37;
            Slog.v(QuotaController.TAG, "Timer ignoring " + jobStatus.toShortString() + " because isTop");
            return;
        L37:
            return;
        L15:
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L18;
            Slog.v(QuotaController.TAG, "Starting to track " + jobStatus.toShortString());
        L18:
            if (this.mRunningBgJobs.add(jobStatus) == false) goto L33;
            if (shouldTrackLocked() == false) goto L33;
            this.mBgJobCount++;
            if (this.mRegularJobTimer == false) goto L27;
            this.this$0.incrementJobCountLocked(this.mPkg.userId, this.mPkg.packageName, 1);
            ExecutionStats stats = QuotaController.m5063$$Nest$mgetExecutionStatsLocked(this.this$0, this.mPkg.userId, this.mPkg.packageName, jobStatus.getEffectiveStandbyBucket(), false);
            if (QuotaController.m5070$$Nest$misUnderJobCountQuotaLocked(this.this$0, stats) == true) goto L27;
            QuotaController.m5030$$Nest$fgetmHandler(this.this$0).obtainMessage(7, this.mPkg).sendToTarget();
        L27:
            if (this.mRunningBgJobs.size() != 1) goto L38;
            this.mStartTimeElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
            this.mDebitAdjustment = 0;
            if (this.mRegularJobTimer == false) goto L31;
            this.this$0.invalidateAllExecutionStatsLocked(this.mPkg.userId, this.mPkg.packageName);
        L31:
            scheduleCutoff();
            return;
        L38:
            return;
        L33:
            if (Trace.isTagEnabled(524288) == false) goto L40;
            Trace.instantForTrack(524288, "JobScheduler", "QC/- " + this.mPkg);
            return;
        }

        void stopTrackingJob(JobStatus jobStatus) {
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.v(QuotaController.TAG, "Stopping tracking of " + jobStatus.toShortString());
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L8:
            if (this.mRunningBgJobs.size() == 0) goto L10;
            long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L12
            int standbyBucket = JobSchedulerService.standbyBucketForPackage(this.mPkg.packageName, this.mPkg.userId, nowElapsed);     // Catch: Throwable -> L12
            if (this.mRunningBgJobs.remove(jobStatus) == true) goto L19;
        L23:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L19:
            if (this.mRunningBgJobs.size() != 0) goto L23;
            if (QuotaController.m5068$$Nest$misQuotaFreeLocked(this.this$0, standbyBucket) == true) goto L23;
            emitSessionLocked(nowElapsed);     // Catch: Throwable -> L12
            cancelCutoff();     // Catch: Throwable -> L12
            goto L23
        L10:
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L14;
            Slog.d(QuotaController.TAG, "Timer isn't tracking any jobs but still told to stop");     // Catch: Throwable -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L12
        }

        void updateDebitAdjustment(long nowElapsed, long debit) {
            this.mDebitAdjustment = Math.max(this.mDebitAdjustment + debit, this.mStartTimeElapsed - nowElapsed);
        }

        void dropEverythingLocked() {
            this.mRunningBgJobs.clear();
            cancelCutoff();
        }

        private void emitSessionLocked(long nowElapsed) {
            if (this.mBgJobCount > 0) goto L5;
            return;
        L5:
            TimingSession ts = new TimingSession(this.mStartTimeElapsed, nowElapsed, this.mBgJobCount);
            QuotaController.m5073$$Nest$msaveTimingSession(this.this$0, this.mPkg.userId, this.mPkg.packageName, ts, !this.mRegularJobTimer, this.mDebitAdjustment);
            this.mBgJobCount = 0;
            cancelCutoff();
            if (this.mRegularJobTimer == false) goto L9;
            QuotaController.m5066$$Nest$mincrementTimingSessionCountLocked(this.this$0, this.mPkg.userId, this.mPkg.packageName);
            return;
        }

        public boolean isActive() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mBgJobCount <= 0) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        boolean isRunning(JobStatus jobStatus) {
            return this.mRunningBgJobs.contains(jobStatus);
        }

        long getCurrentDuration(long nowElapsed) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (isActive() == true) goto L7;
            long r1 = 0;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = (nowElapsed - this.mStartTimeElapsed) + this.mDebitAdjustment;     // Catch: Throwable -> L10
            goto L8
        }

        int getBgJobCount() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int r1 = this.mBgJobCount;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        private boolean shouldTrackLocked() {
            long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
            int standbyBucket = JobSchedulerService.standbyBucketForPackage(this.mPkg.packageName, this.mPkg.userId, nowElapsed);
            if (this.mRegularJobTimer == false) goto L5;
        L7:
            boolean hasTempAllowlistExemption = false;
        L8:
            long topAppGracePeriodEndElapsed = QuotaController.m5044$$Nest$fgetmTopAppGraceCache(this.this$0).get(this.mUid);
            if (this.mRegularJobTimer == false) goto L11;
        L15:
            boolean hasTopAppExemption = false;
        L17:
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L20;
            Slog.d(QuotaController.TAG, "quotaFree=" + QuotaController.m5068$$Nest$misQuotaFreeLocked(this.this$0, standbyBucket) + " isFG=" + QuotaController.m5029$$Nest$fgetmForegroundUids(this.this$0).get(this.mUid) + " tempEx=" + hasTempAllowlistExemption + " topEx=" + hasTopAppExemption);
        L20:
            if (QuotaController.m5068$$Nest$misQuotaFreeLocked(this.this$0, standbyBucket) == false) goto L22;
            return false;
        L22:
            if (QuotaController.m5029$$Nest$fgetmForegroundUids(this.this$0).get(this.mUid) == true) goto L29;
            if (hasTempAllowlistExemption == true) goto L30;
            if (hasTopAppExemption == false) goto L27;
            return false;
        L27:
            return true;
        L30:
            return false;
        L29:
            return false;
        L11:
            if (QuotaController.m5043$$Nest$fgetmTopAppCache(this.this$0).get(this.mUid) == false) goto L13;
        L14:
            hasTopAppExemption = true;
            goto L17
        L13:
            if (nowElapsed >= topAppGracePeriodEndElapsed) goto L15;
        L5:
            if (QuotaController.m5065$$Nest$mhasTempAllowlistExemptionLocked(this.this$0, this.mUid, standbyBucket, nowElapsed) == false) goto L7;
            hasTempAllowlistExemption = true;
            goto L8
        }

        void onStateChangedLocked(long nowElapsed, boolean isQuotaFree) {
            if (isQuotaFree == false) goto L5;
            emitSessionLocked(nowElapsed);
            return;
        L5:
            if (isActive() == false) goto L7;
            return;
        L7:
            if (shouldTrackLocked() == true) goto L9;
            return;
        L9:
            if (this.mRunningBgJobs.size() <= 0) goto L18;
            this.mStartTimeElapsed = nowElapsed;
            this.mDebitAdjustment = 0;
            this.mBgJobCount = this.mRunningBgJobs.size();
            if (this.mRegularJobTimer == false) goto L13;
            this.this$0.incrementJobCountLocked(this.mPkg.userId, this.mPkg.packageName, this.mBgJobCount);
            this.this$0.invalidateAllExecutionStatsLocked(this.mPkg.userId, this.mPkg.packageName);
        L13:
            scheduleCutoff();
            return;
        }

        void rescheduleCutoff() {
            cancelCutoff();
            scheduleCutoff();
        }

        private void scheduleCutoff() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (isActive() == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            QcHandler r1 = QuotaController.m5030$$Nest$fgetmHandler(this.this$0);     // Catch: Throwable -> L8
            if (this.mRegularJobTimer == false) goto L13;
            int r2 = 0;
        L14:
            Message msg = r1.obtainMessage(r2, this.mPkg);     // Catch: Throwable -> L8
            if (this.mRegularJobTimer == false) goto L17;
            long timeRemainingMs = this.this$0.getTimeUntilQuotaConsumedLocked(this.mPkg.userId, this.mPkg.packageName);     // Catch: Throwable -> L8
        L19:
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L25;
            StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L8
            if (this.mRegularJobTimer == false) goto L23;
            String r6 = "Regular job";
        L24:
            r5.append(r6);     // Catch: Throwable -> L8
            r5.append(" for ");     // Catch: Throwable -> L8
            r5.append(this.mPkg);     // Catch: Throwable -> L8
            r5.append(" has ");     // Catch: Throwable -> L8
            r5.append(timeRemainingMs);     // Catch: Throwable -> L8
            r5.append("ms left.");     // Catch: Throwable -> L8
            Slog.i(QuotaController.TAG, r5.toString());     // Catch: Throwable -> L8
            goto L25
        L23:
            r6 = "EJ";
        L25:
            QuotaController.m5030$$Nest$fgetmHandler(this.this$0).sendMessageDelayed(msg, timeRemainingMs);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L17:
            timeRemainingMs = this.this$0.getTimeUntilEJQuotaConsumedLocked(this.mPkg.userId, this.mPkg.packageName);     // Catch: Throwable -> L8
            goto L19
        L13:
            r2 = 4;
            goto L14
        }

        private void cancelCutoff() {
            QcHandler r0 = QuotaController.m5030$$Nest$fgetmHandler(this.this$0);
            if (this.mRegularJobTimer == false) goto L5;
            int r1 = 0;
        L6:
            r0.removeMessages(r1, this.mPkg);
            return;
        L5:
            r1 = 4;
            goto L6
        }

        public void dump(IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
            pw.print("Timer<");
            if (this.mRegularJobTimer == false) goto L5;
            String r0 = "REG";
        L6:
            pw.print(r0);
            pw.print(">{");
            pw.print(this.mPkg);
            pw.print("} ");
            if (isActive() == false) goto L9;
            pw.print("started at ");
            pw.print(this.mStartTimeElapsed);
            pw.print(" (");
            pw.print(JobSchedulerService.sElapsedRealtimeClock.millis() - this.mStartTimeElapsed);
            pw.print("ms ago)");
        L10:
            pw.print(", ");
            pw.print(this.mBgJobCount);
            pw.print(" running bg jobs");
            if (this.mRegularJobTimer == true) goto L13;
            pw.print(" (debit adj=");
            pw.print(this.mDebitAdjustment);
            pw.print(")");
        L13:
            pw.println();
            pw.increaseIndent();
            int i = 0;
        L15:
            if (i >= this.mRunningBgJobs.size()) goto L20;
            JobStatus js = this.mRunningBgJobs.valueAt(i);
            if (predicate.test(js) == false) goto L19;
            pw.println(js.toShortString());
        L19:
            i = i + 1;
            goto L15
        L20:
            pw.decreaseIndent();
            return;
        L9:
            pw.print("NOT active");
            goto L10
        L5:
            r0 = "EJ";
            goto L6
        }

        public void dump(ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
            long token = proto.start(fieldId);
            proto.write(1133871366146L, isActive());
            proto.write(1112396529667L, this.mStartTimeElapsed);
            proto.write(1120986464260L, this.mBgJobCount);
            int i = 0;
        L4:
            if (i >= this.mRunningBgJobs.size()) goto L9;
            JobStatus js = this.mRunningBgJobs.valueAt(i);
            if (predicate.test(js) == false) goto L8;
            js.writeToShortProto(proto, 2246267895813L);
        L8:
            i = i + 1;
            goto L4
        L9:
            proto.end(token);
        }
    }

    private class TimerChargingUpdateFunctor implements Consumer<Timer> {
        private boolean mIsCharging;
        private long mNowElapsed;

        /* JADX INFO: renamed from: -$$Nest$msetStatus, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5088$$Nest$msetStatus(TimerChargingUpdateFunctor r0, long r1, boolean r3) {
            r0.setStatus(r1, r3);
        }

        /* synthetic */ TimerChargingUpdateFunctor(QuotaController r1, QuotaControllerIA r2) {
            this(r1);
        }

        private TimerChargingUpdateFunctor(QuotaController r1) {
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Timer r1) {
            accept2(r1);
        }

        private void setStatus(long nowElapsed, boolean isCharging) {
            this.mNowElapsed = nowElapsed;
            this.mIsCharging = isCharging;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Timer timer) {
            if (JobSchedulerService.standbyBucketForPackage(Timer.m5087$$Nest$fgetmPkg(timer).packageName, Timer.m5087$$Nest$fgetmPkg(timer).userId, this.mNowElapsed) == 5) goto L6;
            timer.onStateChangedLocked(this.mNowElapsed, this.mIsCharging);
            return;
        }
    }

    static final class TimingSession implements TimedEvent {
        public final int bgJobCount;
        public final long endTimeElapsed;
        private final int mHashCode;
        public final long startTimeElapsed;

        TimingSession(long startElapsed, long endElapsed, int bgJobCount) {
            this.startTimeElapsed = startElapsed;
            this.endTimeElapsed = endElapsed;
            this.bgJobCount = bgJobCount;
            int hashCode = (0 * 31) + QuotaController.m5078$$Nest$smhashLong(this.startTimeElapsed);
            this.mHashCode = (((hashCode * 31) + QuotaController.m5078$$Nest$smhashLong(this.endTimeElapsed)) * 31) + bgJobCount;
        }

        @Override // com.android.server.job.controllers.QuotaController.TimedEvent
        public long getEndTimeElapsed() {
            return this.endTimeElapsed;
        }

        public String toString() {
            return "TimingSession{" + this.startTimeElapsed + "->" + this.endTimeElapsed + ", " + this.bgJobCount + "}";
        }

        public boolean equals(Object obj) {
            if ((obj instanceof TimingSession) == false) goto L12;
            TimingSession other = (TimingSession) obj;
            if (this.startTimeElapsed == other.startTimeElapsed) goto L7;
            return false;
        L7:
            if (this.endTimeElapsed == other.endTimeElapsed) goto L9;
            return false;
        L9:
            if (this.bgJobCount != other.bgJobCount) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public int hashCode() {
            return this.mHashCode;
        }

        @Override // com.android.server.job.controllers.QuotaController.TimedEvent
        public void dump(IndentingPrintWriter pw) {
            pw.print(this.startTimeElapsed);
            pw.print(" -> ");
            pw.print(this.endTimeElapsed);
            pw.print(" (");
            pw.print(this.endTimeElapsed - this.startTimeElapsed);
            pw.print("), ");
            pw.print(this.bgJobCount);
            pw.print(" bg jobs.");
            pw.println();
        }

        public void dump(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1112396529665L, this.startTimeElapsed);
            proto.write(1112396529666L, this.endTimeElapsed);
            proto.write(1120986464259L, this.bgJobCount);
            proto.end(token);
        }
    }

    private final class TopAppTimer {
        private final SparseArray<UsageEvents.Event> mActivities;
        private final UserPackage mPkg;
        private long mStartTimeElapsed;
        final /* synthetic */ QuotaController this$0;

        TopAppTimer(QuotaController r1, int userId, String packageName) {
            this.this$0 = r1;
            this.mActivities = new SparseArray();
            this.mPkg = UserPackage.of(userId, packageName);
        }

        private int calculateTimeChunks(long nowElapsed) {
            long totalTopTimeMs = nowElapsed - this.mStartTimeElapsed;
            int numTimeChunks = (int) (totalTopTimeMs / QuotaController.m5026$$Nest$fgetmEJTopAppTimeChunkSizeMs(this.this$0));
            long remainderMs = totalTopTimeMs % QuotaController.m5026$$Nest$fgetmEJTopAppTimeChunkSizeMs(this.this$0);
            if (remainderMs >= 1000) goto L5;
            return numTimeChunks;
        L5:
            return numTimeChunks + 1;
        }

        long getPendingReward(long nowElapsed) {
            return QuotaController.m5025$$Nest$fgetmEJRewardTopAppMs(this.this$0) * ((long) calculateTimeChunks(nowElapsed));
        }

        void processEventLocked(UsageEvents.Event event) {
            long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
            switch(event.getEventType()) {
                case 1: goto L16;
                case 2: goto L5;
                case 23: goto L5;
                case 24: goto L5;
                default: goto L24;
            };
        L5:
            UsageEvents.Event existingEvent = (UsageEvents.Event) this.mActivities.removeReturnOld(event.mInstanceId);
            if (existingEvent != null) goto L8;
            return;
        L8:
            if (this.mActivities.size() != 0) goto L21;
            long pendingReward = getPendingReward(nowElapsed);
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L12;
            Slog.d(QuotaController.TAG, "Crediting " + this.mPkg + " " + pendingReward + "ms for " + calculateTimeChunks(nowElapsed) + " time chunks");
        L12:
            ShrinkableDebits debits = this.this$0.getEJDebitsLocked(this.mPkg.userId, this.mPkg.packageName);
            if (QuotaController.m5076$$Nest$mtransactQuotaLocked(this.this$0, this.mPkg.userId, this.mPkg.packageName, nowElapsed, debits, pendingReward) == false) goto L22;
            this.this$0.mStateChangedListener.onControllerStateChanged(QuotaController.m5071$$Nest$mmaybeUpdateConstraintForPkgLocked(this.this$0, nowElapsed, this.mPkg.userId, this.mPkg.packageName));
            return;
        L22:
            return;
        L21:
            return;
        L24:
            return;
        L16:
            if (this.mActivities.size() != 0) goto L18;
            this.mStartTimeElapsed = nowElapsed;
        L18:
            this.mActivities.put(event.mInstanceId, event);
        }

        boolean isActive() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mActivities.size() <= 0) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        public void dump(IndentingPrintWriter pw) {
            pw.print("TopAppTimer{");
            pw.print(this.mPkg);
            pw.print("} ");
            if (isActive() == false) goto L5;
            pw.print("started at ");
            pw.print(this.mStartTimeElapsed);
            pw.print(" (");
            pw.print(JobSchedulerService.sElapsedRealtimeClock.millis() - this.mStartTimeElapsed);
            pw.print("ms ago)");
        L6:
            pw.println();
            pw.increaseIndent();
            int i = 0;
        L8:
            if (i >= this.mActivities.size()) goto L10;
            UsageEvents.Event event = this.mActivities.valueAt(i);
            pw.println(event.getClassName());
            i = i + 1;
            goto L8
        L10:
            pw.decreaseIndent();
            return;
        L5:
            pw.print("NOT active");
            goto L6
        }

        public void dump(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1133871366146L, isActive());
            proto.write(1112396529667L, this.mStartTimeElapsed);
            proto.write(1120986464260L, this.mActivities.size());
            proto.end(token);
        }
    }

    private class UidConstraintUpdater implements Consumer<JobStatus> {
        public final ArraySet<JobStatus> changedJobs;
        private final SparseArrayMap<String, Integer> mToScheduleStartAlarms;
        long mUpdateTimeElapsed;
        final /* synthetic */ QuotaController this$0;

        /* synthetic */ UidConstraintUpdater(QuotaController r1, QuotaControllerIA r2) {
            this(r1);
        }

        private UidConstraintUpdater(QuotaController r3) {
            this.this$0 = r3;
            this.mToScheduleStartAlarms = new SparseArrayMap();
            this.changedJobs = new ArraySet();
            this.mUpdateTimeElapsed = 0;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(JobStatus r1) {
            accept2(r1);
        }

        void prepare() {
            this.mUpdateTimeElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
            this.changedJobs.clear();
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(JobStatus jobStatus) {
            if (jobStatus.isRequestedExpeditedJob() == false) goto L5;
            boolean isWithinEJQuota = this.this$0.isWithinEJQuotaLocked(jobStatus);
        L7:
            if (QuotaController.m5074$$Nest$msetConstraintSatisfied(this.this$0, jobStatus, this.mUpdateTimeElapsed, this.this$0.isWithinQuotaLocked(jobStatus), isWithinEJQuota) == false) goto L10;
            this.changedJobs.add(jobStatus);
        L10:
            if (QuotaController.m5075$$Nest$msetExpeditedQuotaApproved(this.this$0, jobStatus, this.mUpdateTimeElapsed, isWithinEJQuota) == false) goto L12;
            this.changedJobs.add(jobStatus);
        L12:
            int userId = jobStatus.getSourceUserId();
            String packageName = jobStatus.getSourcePackageName();
            int realStandbyBucket = jobStatus.getStandbyBucket();
            if (isWithinEJQuota == true) goto L15;
        L17:
            this.mToScheduleStartAlarms.add(userId, packageName, Integer.valueOf(realStandbyBucket));
            return;
        L15:
            if (this.this$0.isWithinQuotaLocked(userId, packageName, realStandbyBucket) == false) goto L17;
            QuotaController.m5031$$Nest$fgetmInQuotaAlarmQueue(this.this$0).removeAlarmForKey(UserPackage.of(userId, packageName));
            return;
        L5:
            isWithinEJQuota = false;
            goto L7
        }

        void postProcess() {
            int u = 0;
        L4:
            if (u >= this.mToScheduleStartAlarms.numMaps()) goto L11;
            int userId = this.mToScheduleStartAlarms.keyAt(u);
            int p = 0;
        L7:
            if (p >= this.mToScheduleStartAlarms.numElementsForKey(userId)) goto L9;
            String packageName = (String) this.mToScheduleStartAlarms.keyAt(u, p);
            int standbyBucket = ((Integer) this.mToScheduleStartAlarms.get(userId, packageName)).intValue();
            this.this$0.maybeScheduleStartAlarmLocked(userId, packageName, standbyBucket);
            p = p + 1;
            goto L7
        L9:
            u = u + 1;
            goto L4
        }

        void reset() {
            this.mToScheduleStartAlarms.clear();
        }
    }

    final class UsageEventTracker implements UsageStatsManagerInternal.UsageEventListener {
        final /* synthetic */ QuotaController this$0;

        UsageEventTracker(QuotaController this$0) {
            this.this$0 = this$0;
        }

        @Override // android.app.usage.UsageStatsManagerInternal.UsageEventListener
        public void onUsageEvent(int userId, UsageEvents.Event event) {
            switch(event.getEventType()) {
                case 1: goto L7;
                case 2: goto L7;
                case 7: goto L7;
                case 9: goto L7;
                case 10: goto L7;
                case 12: goto L7;
                case 23: goto L7;
                case 24: goto L7;
                default: goto L5;
            };
        L7:
            QuotaController.m5030$$Nest$fgetmHandler(this.this$0).obtainMessage(5, userId, 0, event).sendToTarget();
            return;
        L5:
            if (QuotaController.m5077$$Nest$sfgetDEBUG() == false) goto L9;
            Slog.d(QuotaController.TAG, "Dropping usage event " + event.getEventType());
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-3NZ5XpdDVosL9X9AVckEGk6ezM, reason: not valid java name */
    public static /* synthetic */ void m5013$r8$lambda$3NZ5XpdDVosL9X9AVckEGk6ezM(QuotaController r0, Predicate r1, ProtoOutputStream r2, ArraySet r3) {
        r0.lambda$dumpControllerStateLocked$7(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$FRepowK0q4sPXFYwpLTs2tTkn0U(QuotaController r0, List r1) {
        r0.lambda$new$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$Kzxhf6GsnXI89yy8HJA3YgpVfNA(long r0, ExecutionStats[] r2) {
        lambda$invalidateAllExecutionStatsLocked$1(r0, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$MNHbYiRF-Q5zoKUxjG65rroTxUU, reason: not valid java name */
    public static /* synthetic */ void m5014$r8$lambda$MNHbYiRFQ5zoKUxjG65rroTxUU(QuotaController r0) {
        r0.lambda$handleNewChargingStateLocked$2();
    }

    public static /* synthetic */ void $r8$lambda$QOq0iO8RyR3XjoDnLSldinZQnFI(QuotaController r0) {
        r0.lambda$onConstantsUpdatedLocked$4();
    }

    public static /* synthetic */ void $r8$lambda$Vt24VpaW9Ch7P9j_EJzW0yEWwUU(QuotaController r0, Predicate r1, IndentingPrintWriter r2, ArraySet r3) {
        r0.lambda$dumpControllerStateLocked$5(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$YYVorqvDSysTVlHaRinVTkluDzY(QuotaController r0, String r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$nJtt_f8EeFaCHDEellk6e9DTdA0(IndentingPrintWriter r0, TopAppTimer r1) {
        lambda$dumpControllerStateLocked$6(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAllowedTimePerPeriodMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long[] m5015$$Nest$fgetmAllowedTimePerPeriodMs(QuotaController r0) {
        return r0.mAllowedTimePerPeriodMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAllowedTimePeriodAdditionaInstallerMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5016$$Nest$fgetmAllowedTimePeriodAdditionaInstallerMs(QuotaController r2) {
        return r2.mAllowedTimePeriodAdditionaInstallerMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBucketPeriodsMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long[] m5017$$Nest$fgetmBucketPeriodsMs(QuotaController r0) {
        return r0.mBucketPeriodsMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEJGracePeriodTempAllowlistMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5018$$Nest$fgetmEJGracePeriodTempAllowlistMs(QuotaController r2) {
        return r2.mEJGracePeriodTempAllowlistMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEJGracePeriodTopAppMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5019$$Nest$fgetmEJGracePeriodTopAppMs(QuotaController r2) {
        return r2.mEJGracePeriodTopAppMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEJLimitWindowSizeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5020$$Nest$fgetmEJLimitWindowSizeMs(QuotaController r2) {
        return r2.mEJLimitWindowSizeMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEJLimitsMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long[] m5021$$Nest$fgetmEJLimitsMs(QuotaController r0) {
        return r0.mEJLimitsMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEJPkgTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m5022$$Nest$fgetmEJPkgTimers(QuotaController r0) {
        return r0.mEJPkgTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEJRewardInteractionMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5023$$Nest$fgetmEJRewardInteractionMs(QuotaController r2) {
        return r2.mEJRewardInteractionMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEJRewardNotificationSeenMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5024$$Nest$fgetmEJRewardNotificationSeenMs(QuotaController r2) {
        return r2.mEJRewardNotificationSeenMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEJRewardTopAppMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5025$$Nest$fgetmEJRewardTopAppMs(QuotaController r2) {
        return r2.mEJRewardTopAppMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEJTopAppTimeChunkSizeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5026$$Nest$fgetmEJTopAppTimeChunkSizeMs(QuotaController r2) {
        return r2.mEJTopAppTimeChunkSizeMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEjLimitAdditionInstallerMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5027$$Nest$fgetmEjLimitAdditionInstallerMs(QuotaController r2) {
        return r2.mEjLimitAdditionInstallerMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEjLimitAdditionSpecialMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5028$$Nest$fgetmEjLimitAdditionSpecialMs(QuotaController r2) {
        return r2.mEjLimitAdditionSpecialMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmForegroundUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m5029$$Nest$fgetmForegroundUids(QuotaController r0) {
        return r0.mForegroundUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ QcHandler m5030$$Nest$fgetmHandler(QuotaController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInQuotaAlarmQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ InQuotaAlarmQueue m5031$$Nest$fgetmInQuotaAlarmQueue(QuotaController r0) {
        return r0.mInQuotaAlarmQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaxBucketJobCounts, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m5032$$Nest$fgetmMaxBucketJobCounts(QuotaController r0) {
        return r0.mMaxBucketJobCounts;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaxBucketSessionCounts, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m5033$$Nest$fgetmMaxBucketSessionCounts(QuotaController r0) {
        return r0.mMaxBucketSessionCounts;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaxExecutionTimeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5034$$Nest$fgetmMaxExecutionTimeMs(QuotaController r2) {
        return r2.mMaxExecutionTimeMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaxJobCountPerRateLimitingWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5035$$Nest$fgetmMaxJobCountPerRateLimitingWindow(QuotaController r0) {
        return r0.mMaxJobCountPerRateLimitingWindow;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaxSessionCountPerRateLimitingWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5036$$Nest$fgetmMaxSessionCountPerRateLimitingWindow(QuotaController r0) {
        return r0.mMaxSessionCountPerRateLimitingWindow;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPkgTimers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m5037$$Nest$fgetmPkgTimers(QuotaController r0) {
        return r0.mPkgTimers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQuotaBufferMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5038$$Nest$fgetmQuotaBufferMs(QuotaController r2) {
        return r2.mQuotaBufferMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRateLimitingWindowMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5039$$Nest$fgetmRateLimitingWindowMs(QuotaController r2) {
        return r2.mRateLimitingWindowMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTempAllowlistCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m5040$$Nest$fgetmTempAllowlistCache(QuotaController r0) {
        return r0.mTempAllowlistCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTempAllowlistGraceCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseLongArray m5041$$Nest$fgetmTempAllowlistGraceCache(QuotaController r0) {
        return r0.mTempAllowlistGraceCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTimingSessionCoalescingDurationMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5042$$Nest$fgetmTimingSessionCoalescingDurationMs(QuotaController r2) {
        return r2.mTimingSessionCoalescingDurationMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTopAppCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m5043$$Nest$fgetmTopAppCache(QuotaController r0) {
        return r0.mTopAppCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTopAppGraceCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseLongArray m5044$$Nest$fgetmTopAppGraceCache(QuotaController r0) {
        return r0.mTopAppGraceCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTopAppTrackers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m5045$$Nest$fgetmTopAppTrackers(QuotaController r0) {
        return r0.mTopAppTrackers;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAllowedTimePeriodAdditionaInstallerMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5046$$Nest$fputmAllowedTimePeriodAdditionaInstallerMs(QuotaController r0, long r1) {
        r0.mAllowedTimePeriodAdditionaInstallerMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEJGracePeriodTempAllowlistMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5047$$Nest$fputmEJGracePeriodTempAllowlistMs(QuotaController r0, long r1) {
        r0.mEJGracePeriodTempAllowlistMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEJGracePeriodTopAppMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5048$$Nest$fputmEJGracePeriodTopAppMs(QuotaController r0, long r1) {
        r0.mEJGracePeriodTopAppMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEJLimitWindowSizeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5049$$Nest$fputmEJLimitWindowSizeMs(QuotaController r0, long r1) {
        r0.mEJLimitWindowSizeMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEJRewardInteractionMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5050$$Nest$fputmEJRewardInteractionMs(QuotaController r0, long r1) {
        r0.mEJRewardInteractionMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEJRewardNotificationSeenMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5051$$Nest$fputmEJRewardNotificationSeenMs(QuotaController r0, long r1) {
        r0.mEJRewardNotificationSeenMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEJRewardTopAppMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5052$$Nest$fputmEJRewardTopAppMs(QuotaController r0, long r1) {
        r0.mEJRewardTopAppMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEJTopAppTimeChunkSizeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5053$$Nest$fputmEJTopAppTimeChunkSizeMs(QuotaController r0, long r1) {
        r0.mEJTopAppTimeChunkSizeMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEjLimitAdditionInstallerMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5054$$Nest$fputmEjLimitAdditionInstallerMs(QuotaController r0, long r1) {
        r0.mEjLimitAdditionInstallerMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEjLimitAdditionSpecialMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5055$$Nest$fputmEjLimitAdditionSpecialMs(QuotaController r0, long r1) {
        r0.mEjLimitAdditionSpecialMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMaxExecutionTimeIntoQuotaMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5056$$Nest$fputmMaxExecutionTimeIntoQuotaMs(QuotaController r0, long r1) {
        r0.mMaxExecutionTimeIntoQuotaMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMaxExecutionTimeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5057$$Nest$fputmMaxExecutionTimeMs(QuotaController r0, long r1) {
        r0.mMaxExecutionTimeMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMaxJobCountPerRateLimitingWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5058$$Nest$fputmMaxJobCountPerRateLimitingWindow(QuotaController r0, int r1) {
        r0.mMaxJobCountPerRateLimitingWindow = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMaxSessionCountPerRateLimitingWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5059$$Nest$fputmMaxSessionCountPerRateLimitingWindow(QuotaController r0, int r1) {
        r0.mMaxSessionCountPerRateLimitingWindow = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmQuotaBufferMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5060$$Nest$fputmQuotaBufferMs(QuotaController r0, long r1) {
        r0.mQuotaBufferMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRateLimitingWindowMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5061$$Nest$fputmRateLimitingWindowMs(QuotaController r0, long r1) {
        r0.mRateLimitingWindowMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTimingSessionCoalescingDurationMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5062$$Nest$fputmTimingSessionCoalescingDurationMs(QuotaController r0, long r1) {
        r0.mTimingSessionCoalescingDurationMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetExecutionStatsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExecutionStats m5063$$Nest$mgetExecutionStatsLocked(QuotaController r0, int r1, String r2, int r3, boolean r4) {
        return r0.getExecutionStatsLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mgrantRewardForInstantEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5064$$Nest$mgrantRewardForInstantEvent(QuotaController r0, int r1, String r2, long r3) {
        r0.grantRewardForInstantEvent(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasTempAllowlistExemptionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5065$$Nest$mhasTempAllowlistExemptionLocked(QuotaController r0, int r1, int r2, long r3) {
        return r0.hasTempAllowlistExemptionLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mincrementTimingSessionCountLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5066$$Nest$mincrementTimingSessionCountLocked(QuotaController r0, int r1, String r2) {
        r0.incrementTimingSessionCountLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misCompatOverridedForQuotaConstantAdjustment, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5067$$Nest$misCompatOverridedForQuotaConstantAdjustment(QuotaController r0) {
        return r0.isCompatOverridedForQuotaConstantAdjustment();
    }

    /* JADX INFO: renamed from: -$$Nest$misQuotaFreeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5068$$Nest$misQuotaFreeLocked(QuotaController r0, int r1) {
        return r0.isQuotaFreeLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misTopStartedJobLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5069$$Nest$misTopStartedJobLocked(QuotaController r0, JobStatus r1) {
        return r0.isTopStartedJobLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misUnderJobCountQuotaLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5070$$Nest$misUnderJobCountQuotaLocked(QuotaController r0, ExecutionStats r1) {
        return r0.isUnderJobCountQuotaLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeUpdateConstraintForPkgLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m5071$$Nest$mmaybeUpdateConstraintForPkgLocked(QuotaController r0, long r1, int r3, String r4) {
        return r0.maybeUpdateConstraintForPkgLocked(r1, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeUpdateConstraintForUidLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m5072$$Nest$mmaybeUpdateConstraintForUidLocked(QuotaController r0, int r1) {
        return r0.maybeUpdateConstraintForUidLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msaveTimingSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5073$$Nest$msaveTimingSession(QuotaController r0, int r1, String r2, TimingSession r3, boolean r4, long r5) {
        r0.saveTimingSession(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$msetConstraintSatisfied, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5074$$Nest$msetConstraintSatisfied(QuotaController r0, JobStatus r1, long r2, boolean r4, boolean r5) {
        return r0.setConstraintSatisfied(r1, r2, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$msetExpeditedQuotaApproved, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5075$$Nest$msetExpeditedQuotaApproved(QuotaController r0, JobStatus r1, long r2, boolean r4) {
        return r0.setExpeditedQuotaApproved(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mtransactQuotaLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5076$$Nest$mtransactQuotaLocked(QuotaController r0, int r1, String r2, long r3, ShrinkableDebits r5, long r6) {
        return r0.transactQuotaLocked(r1, r2, r3, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5077$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$smhashLong, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5078$$Nest$smhashLong(long r0) {
        return hashLong(r0);
    }

    static {
        if (JobSchedulerService.DEBUG == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        DEBUG = r0;
        return;
    L5:
        if (Log.isLoggable(TAG, 3) == true) goto L8;
        r0 = false;
        goto L9
    }

    private static int hashLong(long val) {
        return (int) ((val >>> 32) ^ val);
    }

    public QuotaController(JobSchedulerService service, BackgroundJobsController backgroundJobsController, ConnectivityController connectivityController) {
        super(service);
        this.mTrackedJobs = new SparseArrayMap();
        this.mPkgTimers = new SparseArrayMap();
        this.mEJPkgTimers = new SparseArrayMap();
        this.mTimingEvents = new SparseArrayMap();
        this.mEJTimingSessions = new SparseArrayMap();
        this.mExecutionStatsCache = new SparseArrayMap();
        this.mEJStats = new SparseArrayMap();
        this.mTopAppTrackers = new SparseArrayMap();
        this.mForegroundUids = new SparseBooleanArray();
        this.mTopStartedJobs = new ArraySet();
        this.mTempAllowlistCache = new SparseBooleanArray();
        this.mTempAllowlistGraceCache = new SparseLongArray();
        this.mTopAppCache = new SparseBooleanArray();
        this.mTopAppGraceCache = new SparseLongArray();
        this.mAllowedTimePerPeriodMs = new long[]{600000, 600000, 600000, 600000, 0, 600000, 600000};
        this.mMaxExecutionTimeMs = 14400000;
        this.mQuotaBufferMs = 30000;
        this.mMaxExecutionTimeIntoQuotaMs = this.mMaxExecutionTimeMs - this.mQuotaBufferMs;
        this.mRateLimitingWindowMs = 60000;
        this.mMaxJobCountPerRateLimitingWindow = 20;
        this.mMaxSessionCountPerRateLimitingWindow = 20;
        this.mNextCleanupTimeElapsed = 0;
        this.mSessionCleanupAlarmListener = new AnonymousClass1(this);
        this.mBucketPeriodsMs = new long[]{600000, 7200000, 28800000, 86400000, 0, 86400000, 600000};
        this.mMaxBucketJobCounts = new int[]{75, 120, 200, 48, 0, 10, 75};
        this.mMaxBucketSessionCounts = new int[]{75, 10, 8, 3, 0, 1, 75};
        this.mTimingSessionCoalescingDurationMs = 5000;
        this.mEJLimitsMs = new long[]{1800000, 1800000, 600000, 600000, 0, 300000, 3600000};
        this.mEjLimitAdditionInstallerMs = 1800000;
        this.mEjLimitAdditionSpecialMs = HeartbeatStats.MAX_NAT_TIME_MS;
        this.mAllowedTimePeriodAdditionaInstallerMs = 600000;
        this.mEJLimitWindowSizeMs = 86400000;
        this.mEJTopAppTimeChunkSizeMs = 30000;
        this.mEJRewardTopAppMs = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.mEJRewardInteractionMs = 15000;
        this.mEJRewardNotificationSeenMs = 0;
        this.mEJGracePeriodTempAllowlistMs = 180000;
        this.mEJGracePeriodTopAppMs = 60000;
        this.mSystemInstallers = new SparseSetArray();
        QuotaControllerIA r2 = null;
        this.mEarliestEndTimeFunctor = new EarliestEndTimeFunctor(this, r2);
        this.mTimerChargingUpdateFunctor = new TimerChargingUpdateFunctor(this, r2);
        this.mUpdateUidConstraints = new UidConstraintUpdater(this, r2);
        this.mTimedEventTooOld = new TimedEventTooOldPredicate(r2);
        this.mDeleteOldEventsFunctor = new QuotaController$$ExternalSyntheticLambda0(this);
        this.mHandler = new QcHandler(this, AppSchedulingModuleThread.get().getLooper());
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        this.mQcConstants = new QcConstants(this);
        this.mBackgroundJobsController = backgroundJobsController;
        this.mConnectivityController = connectivityController;
        this.mInQuotaAlarmQueue = new InQuotaAlarmQueue(this, this.mContext, AppSchedulingModuleThread.get().getLooper(), r2);
        AppStandbyInternal appStandby = (AppStandbyInternal) LocalServices.getService(AppStandbyInternal.class);
        appStandby.addListener(new StandbyTracker(this));
        UsageStatsManagerInternal usmi = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        usmi.registerListener(new UsageEventTracker(this));
        PowerAllowlistInternal pai = (PowerAllowlistInternal) LocalServices.getService(PowerAllowlistInternal.class);
        pai.registerTempAllowlistChangeListener(new TempAllowlistTracker(this));
        this.mPlatformCompat = (PlatformCompat) ServiceManager.getService("platform_compat");
        this.mPlatformCompat.registerListener(OVERRIDE_QUOTA_ADJUST_DEFAULT_CONSTANTS, new QuotaController$$ExternalSyntheticLambda1(this));
        ActivityManager.getService().registerUidObserver(new QcUidObserver(this, r2), 1, 4, null);     // Catch: RemoteException -> L5
        ActivityManager.getService().registerUidObserver(new QcUidObserver(this, r2), 1, 3, null);     // Catch: RemoteException -> L5
        ActivityManager.getService().registerUidObserver(new QcUidObserver(this, r2), 1, 2, null);     // Catch: RemoteException -> L5
    L6:
        processQuotaConstantsAdjustment();
    }

    private /* synthetic */ void lambda$new$0(String packageName) {
        handleQuotaDefaultConstantsCompatChange();
    }

    @Override // com.android.server.job.controllers.StateController
    public void onSystemServicesReady() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        cacheInstallerPackagesLocked(0);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus jobStatus, JobStatus lastJob) {
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        int userId = jobStatus.getSourceUserId();
        String pkgName = jobStatus.getSourcePackageName();
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, pkgName);
        if (jobs != null) goto L5;
        ArraySet<JobStatus> jobs2 = new ArraySet();
        this.mTrackedJobs.add(userId, pkgName, jobs2);
        ArraySet<JobStatus> jobs3 = jobs2;
    L6:
        jobs3.add(jobStatus);
        jobStatus.setTrackingController(64);
        boolean isWithinQuota = isWithinQuotaLocked(jobStatus);
        boolean outOfEJQuota = false;
        if (jobStatus.isRequestedExpeditedJob() == true) goto L9;
    L11:
        boolean isWithinEJQuota = false;
    L12:
        setConstraintSatisfied(jobStatus, nowElapsed, isWithinQuota, isWithinEJQuota);
        if (jobStatus.isRequestedExpeditedJob() == false) goto L18;
        setExpeditedQuotaApproved(jobStatus, nowElapsed, isWithinEJQuota);
        if (isWithinEJQuota == true) goto L19;
        outOfEJQuota = true;
    L19:
        if (isWithinQuota == false) goto L21;
        if (outOfEJQuota == true) goto L21;
        return;
    L21:
        maybeScheduleStartAlarmLocked(userId, pkgName, jobStatus.getEffectiveStandbyBucket());
        return;
    L18:
        outOfEJQuota = false;
        goto L19
    L9:
        if (isWithinEJQuotaLocked(jobStatus) == false) goto L11;
        isWithinEJQuota = true;
        goto L12
    L5:
        jobs3 = jobs;
        goto L6
    }

    @Override // com.android.server.job.controllers.StateController
    public void prepareForExecutionLocked(JobStatus jobStatus) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Prepping for " + jobStatus.toShortString());
    L5:
        int uid = jobStatus.getSourceUid();
        if (this.mPlatformCompat.isChangeEnabledByUid(OVERRIDE_QUOTA_ENFORCEMENT_TO_TOP_STARTED_JOBS, uid) == false) goto L15;
        if (this.mTopAppCache.get(uid) == false) goto L15;
        if (DEBUG == false) goto L12;
        Slog.d(TAG, jobStatus.toShortString() + " is top started job");
    L12:
        this.mTopStartedJobs.add(jobStatus);
        return;
    L15:
        if (jobStatus.shouldTreatAsUserInitiatedJob() == false) goto L17;
        return;
    L17:
        int userId = jobStatus.getSourceUserId();
        String packageName = jobStatus.getSourcePackageName();
        if (jobStatus.shouldTreatAsExpeditedJob() == false) goto L20;
        SparseArrayMap<String, Timer> timerMap = this.mEJPkgTimers;
    L21:
        Timer timer = (Timer) timerMap.get(userId, packageName);
        if (timer != null) goto L24;
        timer = new Timer(this, uid, userId, packageName, !jobStatus.shouldTreatAsExpeditedJob());
        timerMap.add(userId, packageName, timer);
    L24:
        timer.startTrackingJobLocked(jobStatus);
        return;
    L20:
        timerMap = this.mPkgTimers;
        goto L21
    }

    @Override // com.android.server.job.controllers.StateController
    public void unprepareFromExecutionLocked(JobStatus jobStatus) {
        Timer timer = (Timer) this.mPkgTimers.get(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName());
        if (timer == null) goto L6;
        timer.stopTrackingJob(jobStatus);
    L6:
        if (jobStatus.isRequestedExpeditedJob() == false) goto L11;
        Timer timer2 = (Timer) this.mEJPkgTimers.get(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName());
        if (timer2 == null) goto L11;
        timer2.stopTrackingJob(jobStatus);
    L11:
        if (this.mPlatformCompat.isChangeEnabledByUid(OVERRIDE_QUOTA_ENFORCEMENT_TO_TOP_STARTED_JOBS, jobStatus.getSourceUid()) == false) goto L14;
        this.mTopStartedJobs.remove(jobStatus);
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus jobStatus, JobStatus incomingJob) {
        if (jobStatus.clearTrackingController(64) == false) goto L12;
        unprepareFromExecutionLocked(jobStatus);
        int userId = jobStatus.getSourceUserId();
        String pkgName = jobStatus.getSourcePackageName();
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, pkgName);
        if (jobs != null) goto L7;
        return;
    L7:
        if (jobs.remove(jobStatus) == true) goto L9;
        return;
    L9:
        if (jobs.size() != 0) goto L15;
        this.mInQuotaAlarmQueue.removeAlarmForKey(UserPackage.of(userId, pkgName));
        return;
    L15:
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onAppRemovedLocked(String packageName, int uid) {
        if (packageName != null) goto L5;
        Slog.wtf(TAG, "Told app removed but given null package name.");
        return;
    L5:
        clearAppStatsLocked(UserHandle.getUserId(uid), packageName);
        if (this.mService.getPackagesForUidLocked(uid) != null) goto L9;
        this.mForegroundUids.delete(uid);
        this.mTempAllowlistCache.delete(uid);
        this.mTempAllowlistGraceCache.delete(uid);
        this.mTopAppCache.delete(uid);
        this.mTopAppGraceCache.delete(uid);
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUserAddedLocked(int userId) {
        cacheInstallerPackagesLocked(userId);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUserRemovedLocked(int userId) {
        this.mTrackedJobs.delete(userId);
        this.mPkgTimers.delete(userId);
        this.mEJPkgTimers.delete(userId);
        this.mTimingEvents.delete(userId);
        this.mEJTimingSessions.delete(userId);
        this.mInQuotaAlarmQueue.removeAlarmsForUserId(userId);
        this.mExecutionStatsCache.delete(userId);
        this.mEJStats.delete(userId);
        this.mSystemInstallers.remove(userId);
        this.mTopAppTrackers.delete(userId);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onBatteryStateChangedLocked() {
        handleNewChargingStateLocked();
    }

    public void clearAppStatsLocked(int userId, String packageName) {
        this.mTrackedJobs.delete(userId, packageName);
        Timer timer = (Timer) this.mPkgTimers.delete(userId, packageName);
        if (timer != null) goto L5;
    L7:
        Timer timer2 = (Timer) this.mEJPkgTimers.delete(userId, packageName);
        if (timer2 != null) goto L10;
    L12:
        this.mTimingEvents.delete(userId, packageName);
        this.mEJTimingSessions.delete(userId, packageName);
        this.mInQuotaAlarmQueue.removeAlarmForKey(UserPackage.of(userId, packageName));
        this.mExecutionStatsCache.delete(userId, packageName);
        this.mEJStats.delete(userId, packageName);
        this.mTopAppTrackers.delete(userId, packageName);
        return;
    L10:
        if (timer2.isActive() == false) goto L12;
        Slog.e(TAG, "clearAppStats called before EJ Timer turned off.");
        timer2.dropEverythingLocked();
        goto L12
    L5:
        if (timer.isActive() == false) goto L7;
        Slog.e(TAG, "clearAppStats called before Timer turned off.");
        timer.dropEverythingLocked();
        goto L7
    }

    private void cacheInstallerPackagesLocked(int userId) {
        List<PackageInfo> packages = this.mContext.getPackageManager().getInstalledPackagesAsUser(SYSTEM_APP_CHECK_FLAGS, userId);
        int i = packages.size() - 1;
    L3:
        if (i < 0) goto L12;
        PackageInfo pi = packages.get(i);
        ApplicationInfo ai = pi.applicationInfo;
        int idx = ArrayUtils.indexOf(pi.requestedPermissions, "android.permission.INSTALL_PACKAGES");
        if (idx < 0) goto L10;
        if (ai == null) goto L10;
        if (this.mContext.checkPermission("android.permission.INSTALL_PACKAGES", -1, ai.uid) != 0) goto L10;
        this.mSystemInstallers.add(UserHandle.getUserId(ai.uid), pi.packageName);
    L10:
        i = i - 1;
        goto L3
    }

    private boolean isUidInForeground(int uid) {
        if (UserHandle.isCore(uid) == false) goto L6;
        return true;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mForegroundUids.get(uid);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isTopStartedJobLocked(JobStatus jobStatus) {
        if (this.mPlatformCompat.isChangeEnabledByUid(OVERRIDE_QUOTA_ENFORCEMENT_TO_TOP_STARTED_JOBS, jobStatus.getSourceUid()) == true) goto L5;
        return false;
    L5:
        return this.mTopStartedJobs.contains(jobStatus);
    }

    public long getMaxJobExecutionTimeMsLocked(JobStatus jobStatus) {
        boolean isJobImportant = true;
        if (jobStatus.shouldTreatAsExpeditedJob() == true) goto L29;
        if (this.mService.isBatteryCharging() == false) goto L9;
        return this.mConstants.RUNTIME_FREE_QUOTA_MAX_LIMIT_MS;
    L9:
        if (this.mTopAppCache.get(jobStatus.getSourceUid()) == false) goto L11;
    L16:
        boolean isInPrivilegedState = true;
    L18:
        if (jobStatus.getEffectivePriority() >= 400) goto L22;
        isJobImportant = false;
    L22:
        if (isInPrivilegedState == false) goto L27;
        if (isJobImportant == false) goto L27;
        return this.mConstants.RUNTIME_FREE_QUOTA_MAX_LIMIT_MS;
    L27:
        return getTimeUntilQuotaConsumedLocked(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName());
    L11:
        if (isTopStartedJobLocked(jobStatus) == true) goto L16;
        if (isUidInForeground(jobStatus.getSourceUid()) == true) goto L16;
        isInPrivilegedState = false;
        goto L18
    L29:
        if (this.mService.isBatteryCharging() == false) goto L33;
        return this.mConstants.RUNTIME_FREE_QUOTA_MAX_LIMIT_MS;
    L33:
        if (jobStatus.getEffectiveStandbyBucket() != 6) goto L37;
        return Math.max(this.mEJLimitsMs[6] / 2, getTimeUntilEJQuotaConsumedLocked(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName()));
    L37:
        if (this.mTopAppCache.get(jobStatus.getSourceUid()) == true) goto L48;
        if (isTopStartedJobLocked(jobStatus) == true) goto L48;
        if (isUidInForeground(jobStatus.getSourceUid()) == false) goto L46;
        return Math.max(this.mEJLimitsMs[1] / 2, getTimeUntilEJQuotaConsumedLocked(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName()));
    L46:
        return getTimeUntilEJQuotaConsumedLocked(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName());
    L48:
        return Math.max(this.mEJLimitsMs[0] / 2, getTimeUntilEJQuotaConsumedLocked(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName()));
    }

    private boolean hasTempAllowlistExemptionLocked(int sourceUid, int standbyBucket, long nowElapsed) {
        if (standbyBucket != 5) goto L5;
    L13:
        return false;
    L5:
        if (standbyBucket == 4) goto L13;
        long tempAllowlistGracePeriodEndElapsed = this.mTempAllowlistGraceCache.get(sourceUid);
        if (this.mTempAllowlistCache.get(sourceUid) == false) goto L10;
    L11:
        return true;
    L10:
        if (nowElapsed < tempAllowlistGracePeriodEndElapsed) goto L11;
        return false;
    }

    public boolean isWithinEJQuotaLocked(JobStatus jobStatus) {
        if (isQuotaFreeLocked(jobStatus.getEffectiveStandbyBucket()) == false) goto L6;
        return true;
    L6:
        if (isTopStartedJobLocked(jobStatus) == false) goto L8;
    L27:
        return true;
    L8:
        if (isUidInForeground(jobStatus.getSourceUid()) == true) goto L27;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (hasTempAllowlistExemptionLocked(jobStatus.getSourceUid(), jobStatus.getEffectiveStandbyBucket(), nowElapsed) == false) goto L13;
        return true;
    L13:
        long topAppGracePeriodEndElapsed = this.mTopAppGraceCache.get(jobStatus.getSourceUid());
        if (this.mTopAppCache.get(jobStatus.getSourceUid()) == false) goto L16;
    L19:
        boolean hasTopAppExemption = true;
    L20:
        if (hasTopAppExemption == false) goto L23;
        return true;
    L23:
        if (0 >= getRemainingEJExecutionTimeLocked(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName())) goto L26;
        return true;
    L26:
        return false;
    L16:
        if (nowElapsed < topAppGracePeriodEndElapsed) goto L19;
        hasTopAppExemption = false;
        goto L20
    }

    ShrinkableDebits getEJDebitsLocked(int userId, String packageName) {
        ShrinkableDebits debits = (ShrinkableDebits) this.mEJStats.get(userId, packageName);
        if (debits != null) goto L6;
        ShrinkableDebits debits2 = new ShrinkableDebits(JobSchedulerService.standbyBucketForPackage(packageName, userId, JobSchedulerService.sElapsedRealtimeClock.millis()));
        this.mEJStats.add(userId, packageName, debits2);
        return debits2;
    L6:
        return debits;
    }

    boolean isWithinQuotaLocked(JobStatus jobStatus) {
        int standbyBucket = jobStatus.getEffectiveStandbyBucket();
        if (jobStatus.shouldTreatAsUserInitiatedJob() == false) goto L5;
    L30:
        return true;
    L5:
        if (isTopStartedJobLocked(jobStatus) == true) goto L30;
        if (isUidInForeground(jobStatus.getSourceUid()) == true) goto L30;
        if (standbyBucket != 4) goto L13;
        return false;
    L13:
        if (isQuotaFreeLocked(standbyBucket) == false) goto L15;
        return true;
    L15:
        ExecutionStats stats = getExecutionStatsLocked(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName(), standbyBucket);
        if (getRemainingExecutionTimeLocked(stats) > 0) goto L19;
        return false;
    L19:
        if (standbyBucket == 5) goto L24;
        if (this.mService.isCurrentlyRunningLocked(jobStatus) == false) goto L24;
        return true;
    L24:
        if (isUnderJobCountQuotaLocked(stats) == false) goto L29;
        if (isUnderSessionCountQuotaLocked(stats) == false) goto L29;
        return true;
    L29:
        return false;
    }

    private boolean isQuotaFreeLocked(int standbyBucket) {
        if (this.mService.isBatteryCharging() == true) goto L5;
        return false;
    L5:
        if (standbyBucket == 5) goto L9;
        return true;
    L9:
        return false;
    }

    boolean isWithinQuotaLocked(int userId, String packageName, int standbyBucket) {
        if (standbyBucket != 4) goto L6;
        return false;
    L6:
        if (isQuotaFreeLocked(standbyBucket) == false) goto L8;
        return true;
    L8:
        ExecutionStats stats = getExecutionStatsLocked(userId, packageName, standbyBucket);
        if (getRemainingExecutionTimeLocked(stats) > 0) goto L11;
        return false;
    L11:
        if (isUnderJobCountQuotaLocked(stats) == true) goto L13;
        return false;
    L13:
        if (isUnderSessionCountQuotaLocked(stats) == true) goto L16;
        return false;
    L16:
        return true;
    }

    private boolean isUnderJobCountQuotaLocked(ExecutionStats stats) {
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (stats.jobRateLimitExpirationTimeElapsed > now) goto L5;
    L8:
        boolean isUnderAllowedTimeQuota = true;
    L9:
        if (isUnderAllowedTimeQuota == false) goto L14;
        if (stats.bgJobCountInWindow >= stats.jobCountLimit) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (stats.jobCountInRateLimitingWindow < this.mMaxJobCountPerRateLimitingWindow) goto L8;
        isUnderAllowedTimeQuota = false;
        goto L9
    }

    private boolean isUnderSessionCountQuotaLocked(ExecutionStats stats) {
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (stats.sessionRateLimitExpirationTimeElapsed > now) goto L5;
    L8:
        boolean isUnderAllowedTimeQuota = true;
    L9:
        if (isUnderAllowedTimeQuota == false) goto L14;
        if (stats.sessionCountInWindow >= stats.sessionCountLimit) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (stats.sessionCountInRateLimitingWindow < this.mMaxSessionCountPerRateLimitingWindow) goto L8;
        isUnderAllowedTimeQuota = false;
        goto L9
    }

    long getRemainingExecutionTimeLocked(JobStatus jobStatus) {
        return getRemainingExecutionTimeLocked(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName(), jobStatus.getEffectiveStandbyBucket());
    }

    long getRemainingExecutionTimeLocked(int userId, String packageName) {
        int standbyBucket = JobSchedulerService.standbyBucketForPackage(packageName, userId, JobSchedulerService.sElapsedRealtimeClock.millis());
        return getRemainingExecutionTimeLocked(userId, packageName, standbyBucket);
    }

    private long getRemainingExecutionTimeLocked(int userId, String packageName, int standbyBucket) {
        if (standbyBucket != 4) goto L7;
        return 0;
    L7:
        return getRemainingExecutionTimeLocked(getExecutionStatsLocked(userId, packageName, standbyBucket));
    }

    private long getRemainingExecutionTimeLocked(ExecutionStats stats) {
        return Math.min(stats.allowedTimePerPeriodMs - stats.executionTimeInWindowMs, this.mMaxExecutionTimeMs - stats.executionTimeInMaxPeriodMs);
    }

    long getRemainingEJExecutionTimeLocked(int userId, String packageName) {
        ShrinkableDebits quota = getEJDebitsLocked(userId, packageName);
        if (quota.getStandbyBucketLocked() != 4) goto L6;
        return 0;
    L6:
        long limitMs = getEJLimitMsLocked(userId, packageName, quota.getStandbyBucketLocked());
        long remainingMs = limitMs - quota.getTallyLocked();
        List<TimedEvent> timingSessions = (List) this.mEJTimingSessions.get(userId, packageName);
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        long windowStartTimeElapsed = nowElapsed - this.mEJLimitWindowSizeMs;
        if (timingSessions == null) goto L18;
    L9:
        if (timingSessions.size() <= 0) goto L18;
        TimingSession ts = (TimingSession) timingSessions.get(0);
        long limitMs2 = limitMs;
        if (ts.endTimeElapsed >= windowStartTimeElapsed) goto L14;
        long duration = ts.endTimeElapsed - ts.startTimeElapsed;
        remainingMs = remainingMs + duration;
        quota.transactLocked(-duration);
        timingSessions.remove(0);
        limitMs = limitMs2;
        goto L9
    L14:
        if (ts.startTimeElapsed >= windowStartTimeElapsed) goto L18;
        remainingMs = remainingMs + (windowStartTimeElapsed - ts.startTimeElapsed);
    L18:
        TopAppTimer topAppTimer = (TopAppTimer) this.mTopAppTrackers.get(userId, packageName);
        if (topAppTimer != null) goto L21;
    L23:
        Timer timer = (Timer) this.mEJPkgTimers.get(userId, packageName);
        if (timer != null) goto L27;
        return remainingMs;
    L27:
        return remainingMs - timer.getCurrentDuration(JobSchedulerService.sElapsedRealtimeClock.millis());
    L21:
        if (topAppTimer.isActive() == false) goto L23;
        remainingMs = remainingMs + topAppTimer.getPendingReward(nowElapsed);
        goto L23
    }

    private long getEJLimitMsLocked(int userId, String packageName, int standbyBucket) {
        long baseLimitMs = this.mEJLimitsMs[standbyBucket];
        if (this.mSystemInstallers.contains(userId, packageName) == true) goto L5;
        return baseLimitMs;
    L5:
        return this.mEjLimitAdditionInstallerMs + baseLimitMs;
    }

    private long getAllowedTimePerPeriodMsLocked(int userId, String pkgName, int standbyBucket) {
        long baseLimitMs = this.mAllowedTimePerPeriodMs[standbyBucket];
        if (isCompatOverridedForQuotaConstantAdjustment() == false) goto L5;
    L10:
        return baseLimitMs;
    L5:
        if (standbyBucket != 6) goto L10;
        if (this.mSystemInstallers.contains(userId, pkgName) == false) goto L10;
        return this.mAllowedTimePeriodAdditionaInstallerMs + baseLimitMs;
    }

    long getTimeUntilQuotaConsumedLocked(int userId, String packageName) {
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        int standbyBucket = JobSchedulerService.standbyBucketForPackage(packageName, userId, nowElapsed);
        if (standbyBucket != 4) goto L6;
        return 0;
    L6:
        List<TimedEvent> events = (List) this.mTimingEvents.get(userId, packageName);
        ExecutionStats stats = getExecutionStatsLocked(userId, packageName, standbyBucket);
        long allowedTimePerPeriodMs = getAllowedTimePerPeriodMsLocked(userId, packageName, standbyBucket);
        if (events != null) goto L9;
    L17:
        long startWindowElapsed = stats.windowSizeMs;
        if (startWindowElapsed == allowedTimePerPeriodMs) goto L20;
        return allowedTimePerPeriodMs;
    L20:
        return this.mMaxExecutionTimeMs;
    L9:
        if (events.size() == 0) goto L17;
        long startWindowElapsed2 = nowElapsed - stats.windowSizeMs;
        long startMaxElapsed = nowElapsed - 86400000;
        long allowedTimeRemainingMs = allowedTimePerPeriodMs - stats.executionTimeInWindowMs;
        long maxExecutionTimeRemainingMs = this.mMaxExecutionTimeMs - stats.executionTimeInMaxPeriodMs;
        if (stats.windowSizeMs != allowedTimePerPeriodMs) goto L16;
        return calculateTimeUntilQuotaConsumedLocked(events, startMaxElapsed, maxExecutionTimeRemainingMs);
    L16:
        return Math.min(calculateTimeUntilQuotaConsumedLocked(events, startMaxElapsed, maxExecutionTimeRemainingMs), calculateTimeUntilQuotaConsumedLocked(events, startWindowElapsed2, allowedTimeRemainingMs));
    }

    private long calculateTimeUntilQuotaConsumedLocked(List<TimedEvent> sessions, long windowStartElapsed, long deadSpaceMs) {
        int numSessions = sessions.size();
        int i = 0;
        long start = windowStartElapsed;
        long timeUntilQuotaConsumedMs = 0;
        long deadSpaceMs2 = deadSpaceMs;
    L3:
        if (i >= numSessions) goto L16;
        TimingSession session = (TimingSession) sessions.get(i);
        if (session.endTimeElapsed < windowStartElapsed) goto L14;
        if (session.startTimeElapsed > windowStartElapsed) goto L10;
        timeUntilQuotaConsumedMs = timeUntilQuotaConsumedMs + (session.endTimeElapsed - windowStartElapsed);
        start = session.endTimeElapsed;
        goto L14
    L10:
        long diff = session.startTimeElapsed - start;
        if (diff > deadSpaceMs2) goto L16;
        timeUntilQuotaConsumedMs = timeUntilQuotaConsumedMs + ((session.endTimeElapsed - session.startTimeElapsed) + diff);
        deadSpaceMs2 = deadSpaceMs2 - diff;
        start = session.endTimeElapsed;
    L14:
        i = i + 1;
    L16:
        long timeUntilQuotaConsumedMs2 = timeUntilQuotaConsumedMs + deadSpaceMs2;
        if (timeUntilQuotaConsumedMs2 <= this.mMaxExecutionTimeMs) goto L19;
        Slog.wtf(TAG, "Calculated quota consumed time too high: " + timeUntilQuotaConsumedMs2);
    L19:
        return timeUntilQuotaConsumedMs2;
    }

    long getTimeUntilEJQuotaConsumedLocked(int userId, String packageName) {
        long remainingExecutionTimeMs = getRemainingEJExecutionTimeLocked(userId, packageName);
        List<TimedEvent> sessions = (List) this.mEJTimingSessions.get(userId, packageName);
        if (sessions != null) goto L5;
    L30:
        return remainingExecutionTimeMs;
    L5:
        if (sessions.size() == 0) goto L30;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        ShrinkableDebits quota = getEJDebitsLocked(userId, packageName);
        long limitMs = getEJLimitMsLocked(userId, packageName, quota.getStandbyBucketLocked());
        long startWindowElapsed = Math.max(0, nowElapsed - this.mEJLimitWindowSizeMs);
        long deadSpaceMs = 0;
        long phasedOutSessionTimeMs = 0;
        long remainingDeadSpaceMs = remainingExecutionTimeMs;
        int i = 0;
    L9:
        if (i >= sessions.size()) goto L29;
        TimingSession session = (TimingSession) sessions.get(i);
        if (session.endTimeElapsed >= startWindowElapsed) goto L14;
        remainingDeadSpaceMs = remainingDeadSpaceMs + (session.endTimeElapsed - session.startTimeElapsed);
        sessions.remove(i);
        i = i - 1;
    L27:
        i = i + 1;
        goto L9
    L14:
        if (session.startTimeElapsed >= startWindowElapsed) goto L16;
        phasedOutSessionTimeMs = session.endTimeElapsed - startWindowElapsed;
        goto L27
    L16:
        long phasedOutSessionTimeMs2 = session.startTimeElapsed;
        if (i != 0) goto L19;
        long r1 = startWindowElapsed;
    L20:
        long timeBetweenSessions = phasedOutSessionTimeMs2 - r1;
        long usedDeadSpaceMs = Math.min(remainingDeadSpaceMs, timeBetweenSessions);
        deadSpaceMs = deadSpaceMs + usedDeadSpaceMs;
        if (usedDeadSpaceMs != timeBetweenSessions) goto L24;
        phasedOutSessionTimeMs = phasedOutSessionTimeMs + (session.endTimeElapsed - session.startTimeElapsed);
    L24:
        remainingDeadSpaceMs = remainingDeadSpaceMs - usedDeadSpaceMs;
        if (remainingDeadSpaceMs > 0) goto L27;
    L19:
        r1 = sessions.get(i - 1).getEndTimeElapsed();
    L29:
        return Math.min(limitMs, (deadSpaceMs + phasedOutSessionTimeMs) + remainingDeadSpaceMs);
    }

    ExecutionStats getExecutionStatsLocked(int userId, String packageName, int standbyBucket) {
        return getExecutionStatsLocked(userId, packageName, standbyBucket, true);
    }

    private ExecutionStats getExecutionStatsLocked(int userId, String packageName, int standbyBucket, boolean refreshStatsIfOld) {
        if (standbyBucket != 4) goto L6;
        Slog.wtf(TAG, "getExecutionStatsLocked called for a NEVER app.");
        return new ExecutionStats();
    L6:
        ExecutionStats[] appStats = (ExecutionStats[]) this.mExecutionStatsCache.get(userId, packageName);
        if (appStats != null) goto L9;
        appStats = new ExecutionStats[this.mBucketPeriodsMs.length];
        this.mExecutionStatsCache.add(userId, packageName, appStats);
    L9:
        ExecutionStats stats = appStats[standbyBucket];
        if (stats != null) goto L12;
        stats = new ExecutionStats();
        appStats[standbyBucket] = stats;
    L12:
        if (refreshStatsIfOld == false) goto L28;
        long bucketAllowedTimeMs = getAllowedTimePerPeriodMsLocked(userId, packageName, standbyBucket);
        long bucketWindowSizeMs = this.mBucketPeriodsMs[standbyBucket];
        int jobCountLimit = this.mMaxBucketJobCounts[standbyBucket];
        int sessionCountLimit = this.mMaxBucketSessionCounts[standbyBucket];
        Timer timer = (Timer) this.mPkgTimers.get(userId, packageName);
        if (timer == null) goto L18;
        if (timer.isActive() == false) goto L18;
    L27:
        stats.allowedTimePerPeriodMs = bucketAllowedTimeMs;
        stats.windowSizeMs = bucketWindowSizeMs;
        stats.jobCountLimit = jobCountLimit;
        stats.sessionCountLimit = sessionCountLimit;
        updateExecutionStatsLocked(userId, packageName, stats);
    L18:
        if (stats.expirationTimeElapsed <= JobSchedulerService.sElapsedRealtimeClock.millis()) goto L27;
        if (stats.allowedTimePerPeriodMs != bucketAllowedTimeMs) goto L27;
        if (stats.windowSizeMs != bucketWindowSizeMs) goto L27;
        if (stats.jobCountLimit != jobCountLimit) goto L27;
        if (stats.sessionCountLimit != sessionCountLimit) goto L27;
    L28:
        return stats;
    }

    void updateExecutionStatsLocked(int userId, String packageName, ExecutionStats stats) {
        stats.executionTimeInWindowMs = 0;
        stats.bgJobCountInWindow = 0;
        stats.executionTimeInMaxPeriodMs = 0;
        stats.bgJobCountInMaxPeriod = 0;
        stats.sessionCountInWindow = 0;
        if (stats.jobCountLimit != 0) goto L5;
    L8:
        stats.inQuotaTimeElapsed = Long.MAX_VALUE;
    L9:
        long allowedTimeIntoQuotaMs = stats.allowedTimePerPeriodMs - this.mQuotaBufferMs;
        Timer timer = (Timer) this.mPkgTimers.get(userId, packageName);
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        stats.expirationTimeElapsed = nowElapsed + 86400000;
        if (timer == null) goto L24;
        if (timer.isActive() == false) goto L24;
        long r12 = timer.getCurrentDuration(nowElapsed);
        stats.executionTimeInMaxPeriodMs = r12;
        stats.executionTimeInWindowMs = r12;
        int r13 = timer.getBgJobCount();
        stats.bgJobCountInMaxPeriod = r13;
        stats.bgJobCountInWindow = r13;
        stats.expirationTimeElapsed = nowElapsed;
        if (stats.executionTimeInWindowMs < allowedTimeIntoQuotaMs) goto L18;
        stats.inQuotaTimeElapsed = Math.max(stats.inQuotaTimeElapsed, (nowElapsed - allowedTimeIntoQuotaMs) + stats.windowSizeMs);
    L18:
        if (stats.executionTimeInMaxPeriodMs < this.mMaxExecutionTimeIntoQuotaMs) goto L21;
        long inQuotaTime = (nowElapsed - this.mMaxExecutionTimeIntoQuotaMs) + 86400000;
        stats.inQuotaTimeElapsed = Math.max(stats.inQuotaTimeElapsed, inQuotaTime);
    L21:
        if (stats.bgJobCountInWindow < stats.jobCountLimit) goto L24;
        long inQuotaTime2 = stats.windowSizeMs + nowElapsed;
        stats.inQuotaTimeElapsed = Math.max(stats.inQuotaTimeElapsed, inQuotaTime2);
    L24:
        List<TimedEvent> events = (List) this.mTimingEvents.get(userId, packageName);
        if (events == null) goto L77;
        if (events.size() == 0) goto L82;
        long startWindowElapsed = nowElapsed - stats.windowSizeMs;
        long startMaxElapsed = nowElapsed - 86400000;
        int sessionCountInWindow = 0;
        int loopStart = events.size() - 1;
        long emptyTimeMs = Long.MAX_VALUE;
        TimingSession lastSeenTimingSession = null;
        int i = loopStart;
    L30:
        if (i < 0) goto L73;
        int i2 = i;
        TimingSession session = (TimingSession) events.get(i);
        long allowedTimeIntoQuotaMs2 = allowedTimeIntoQuotaMs;
        if (startWindowElapsed < session.endTimeElapsed) goto L34;
        events = events;
        nowElapsed = nowElapsed;
    L58:
        if (startMaxElapsed >= session.startTimeElapsed) goto L65;
        stats.executionTimeInMaxPeriodMs += session.endTimeElapsed - session.startTimeElapsed;
        stats.bgJobCountInMaxPeriod += session.bgJobCount;
        long r4 = Math.min(emptyTimeMs, session.startTimeElapsed - startMaxElapsed);
        if (stats.executionTimeInMaxPeriodMs < this.mMaxExecutionTimeIntoQuotaMs) goto L63;
        long r8 = stats.inQuotaTimeElapsed;
        long r10 = session.startTimeElapsed;
        long emptyTimeMs2 = stats.executionTimeInMaxPeriodMs;
        stats.inQuotaTimeElapsed = Math.max(r8, ((r10 + emptyTimeMs2) - this.mMaxExecutionTimeIntoQuotaMs) + 86400000);
    L63:
        emptyTimeMs = r4;
        session = session;
    L71:
        lastSeenTimingSession = session;
        i = i2 - 1;
        events = events;
        allowedTimeIntoQuotaMs = allowedTimeIntoQuotaMs2;
        nowElapsed = nowElapsed;
        goto L30
    L65:
        if (startMaxElapsed >= session.endTimeElapsed) goto L74;
        stats.executionTimeInMaxPeriodMs += session.endTimeElapsed - startMaxElapsed;
        stats.bgJobCountInMaxPeriod += session.bgJobCount;
        if (stats.executionTimeInMaxPeriodMs < this.mMaxExecutionTimeIntoQuotaMs) goto L70;
        stats.inQuotaTimeElapsed = Math.max(stats.inQuotaTimeElapsed, ((stats.executionTimeInMaxPeriodMs + startMaxElapsed) - this.mMaxExecutionTimeIntoQuotaMs) + 86400000);
    L70:
        emptyTimeMs = 0;
    L74:
        stats.expirationTimeElapsed = nowElapsed + emptyTimeMs;
        stats.sessionCountInWindow = sessionCountInWindow;
        return;
    L34:
        if (startWindowElapsed >= session.startTimeElapsed) goto L36;
        long start = session.startTimeElapsed;
        long start2 = session.startTimeElapsed;
        emptyTimeMs = Math.min(emptyTimeMs, start2 - startWindowElapsed);
        long start3 = start;
    L37:
        long start4 = start3;
        long start5 = stats.executionTimeInWindowMs;
        stats.executionTimeInWindowMs = start5 + (session.endTimeElapsed - start4);
        stats.bgJobCountInWindow += session.bgJobCount;
        if (stats.executionTimeInWindowMs < allowedTimeIntoQuotaMs2) goto L42;
        stats.inQuotaTimeElapsed = Math.max(stats.inQuotaTimeElapsed, ((start4 + stats.executionTimeInWindowMs) - allowedTimeIntoQuotaMs2) + stats.windowSizeMs);
    L42:
        if (stats.bgJobCountInWindow < stats.jobCountLimit) goto L44;
        long inQuotaTime3 = session.endTimeElapsed + stats.windowSizeMs;
        stats.inQuotaTimeElapsed = Math.max(stats.inQuotaTimeElapsed, inQuotaTime3);
    L44:
        if (lastSeenTimingSession != null) goto L46;
    L48:
        boolean shouldCoalesce = false;
    L49:
        if (shouldCoalesce == true) goto L55;
        int sessionCountInWindow2 = sessionCountInWindow + 1;
        if (sessionCountInWindow2 < stats.sessionCountLimit) goto L54;
        long inQuotaTime4 = session.endTimeElapsed + stats.windowSizeMs;
        stats.inQuotaTimeElapsed = Math.max(stats.inQuotaTimeElapsed, inQuotaTime4);
    L54:
        sessionCountInWindow = sessionCountInWindow2;
        goto L58
    L55:
        nowElapsed = nowElapsed;
        sessionCountInWindow = sessionCountInWindow;
        goto L58
    L46:
        if ((lastSeenTimingSession.startTimeElapsed - session.endTimeElapsed) > this.mTimingSessionCoalescingDurationMs) goto L48;
        shouldCoalesce = true;
        goto L49
    L36:
        start3 = startWindowElapsed;
        emptyTimeMs = 0;
        goto L37
    L73:
        nowElapsed = nowElapsed;
        goto L74
    L82:
        return;
    L77:
        return;
    L5:
        if (stats.sessionCountLimit == 0) goto L8;
        stats.inQuotaTimeElapsed = 0;
        goto L9
    }

    void invalidateAllExecutionStatsLocked() {
        final long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        this.mExecutionStatsCache.forEach(new QuotaController$$ExternalSyntheticLambda2(nowElapsed));
    }

    private static /* synthetic */ void lambda$invalidateAllExecutionStatsLocked$1(long nowElapsed, ExecutionStats[] appStats) {
        if (appStats == null) goto L10;
        int i = 0;
    L5:
        if (i >= appStats.length) goto L14;
        ExecutionStats stats = appStats[i];
        if (stats == null) goto L9;
        stats.expirationTimeElapsed = nowElapsed;
    L9:
        i = i + 1;
        goto L5
    L14:
        return;
    }

    void invalidateAllExecutionStatsLocked(int userId, String packageName) {
        ExecutionStats[] appStats = (ExecutionStats[]) this.mExecutionStatsCache.get(userId, packageName);
        if (appStats == null) goto L11;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        int i = 0;
    L6:
        if (i >= appStats.length) goto L15;
        ExecutionStats stats = appStats[i];
        if (stats == null) goto L10;
        stats.expirationTimeElapsed = nowElapsed;
    L10:
        i = i + 1;
        goto L6
    L15:
        return;
    }

    void handleQuotaDefaultConstantsCompatChange() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean isCompatEnabled = isCompatOverridedForQuotaConstantAdjustment();     // Catch: Throwable -> L7
        this.mQcConstants.adjustDefaultBucketWindowSizes(isCompatEnabled);     // Catch: Throwable -> L7
        this.mQcConstants.adjustDefaultEjLimits(isCompatEnabled);     // Catch: Throwable -> L7
        QcConstants.m5083$$Nest$fputmShouldReevaluateConstraints(this.mQcConstants, true);     // Catch: Throwable -> L7
        onConstantsUpdatedLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void processQuotaConstantsAdjustment() {
        if (isCompatOverridedForQuotaConstantAdjustment() == true) goto L6;
        this.mQcConstants.adjustDefaultBucketWindowSizes(false);
        this.mQcConstants.adjustDefaultEjLimits(false);
        return;
    }

    void incrementJobCountLocked(int userId, String packageName, int count) {
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();
        ExecutionStats[] appStats = (ExecutionStats[]) this.mExecutionStatsCache.get(userId, packageName);
        if (appStats != null) goto L5;
        appStats = new ExecutionStats[this.mBucketPeriodsMs.length];
        this.mExecutionStatsCache.add(userId, packageName, appStats);
    L5:
        int i = 0;
    L7:
        if (i >= appStats.length) goto L16;
        ExecutionStats stats = appStats[i];
        if (stats != null) goto L12;
        stats = new ExecutionStats();
        appStats[i] = stats;
    L12:
        if (stats.jobRateLimitExpirationTimeElapsed > now) goto L14;
        stats.jobRateLimitExpirationTimeElapsed = this.mRateLimitingWindowMs + now;
        stats.jobCountInRateLimitingWindow = 0;
    L14:
        stats.jobCountInRateLimitingWindow += count;
        stats.bgJobCountInWindow += count;
        i = i + 1;
        goto L7
    }

    private boolean isCompatOverridedForQuotaConstantAdjustment() {
        return this.mPlatformCompat.isChangeEnabledByPackageName(OVERRIDE_QUOTA_ADJUST_DEFAULT_CONSTANTS, PackageManagerService.PLATFORM_PACKAGE_NAME, 0);
    }

    private void incrementTimingSessionCountLocked(int userId, String packageName) {
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();
        ExecutionStats[] appStats = (ExecutionStats[]) this.mExecutionStatsCache.get(userId, packageName);
        if (appStats != null) goto L5;
        appStats = new ExecutionStats[this.mBucketPeriodsMs.length];
        this.mExecutionStatsCache.add(userId, packageName, appStats);
    L5:
        int i = 0;
    L7:
        if (i >= appStats.length) goto L16;
        ExecutionStats stats = appStats[i];
        if (stats != null) goto L12;
        stats = new ExecutionStats();
        appStats[i] = stats;
    L12:
        if (stats.sessionRateLimitExpirationTimeElapsed > now) goto L14;
        stats.sessionRateLimitExpirationTimeElapsed = this.mRateLimitingWindowMs + now;
        stats.sessionCountInRateLimitingWindow = 0;
    L14:
        stats.sessionCountInRateLimitingWindow++;
        i = i + 1;
        goto L7
    }

    void saveTimingSession(int userId, String packageName, TimingSession session, boolean isExpedited) {
        saveTimingSession(userId, packageName, session, isExpedited, 0);
    }

    private void saveTimingSession(int userId, String packageName, TimingSession session, boolean isExpedited, long debitAdjustment) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (isExpedited == false) goto L8;
        SparseArrayMap<String, List<TimedEvent>> sessionMap = this.mEJTimingSessions;     // Catch: Throwable -> L6
    L9:
        List<TimedEvent> sessions = (List) sessionMap.get(userId, packageName);     // Catch: Throwable -> L6
        if (sessions != null) goto L12;
        sessions = new ArrayList();     // Catch: Throwable -> L6
        sessionMap.add(userId, packageName, sessions);     // Catch: Throwable -> L6
    L12:
        sessions.add(session);     // Catch: Throwable -> L6
        if (isExpedited == false) goto L15;
        ShrinkableDebits quota = getEJDebitsLocked(userId, packageName);     // Catch: Throwable -> L6
        quota.transactLocked((session.endTimeElapsed - session.startTimeElapsed) + debitAdjustment);     // Catch: Throwable -> L6
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L15:
        invalidateAllExecutionStatsLocked(userId, packageName);     // Catch: Throwable -> L6
        maybeScheduleCleanupAlarmLocked();     // Catch: Throwable -> L6
        goto L16
    L8:
        sessionMap = this.mTimingEvents;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private void grantRewardForInstantEvent(int userId, String packageName, long credit) {
        if (credit != 0) goto L5;
        return;
    L5:
        Object r9 = this.mLock;
        monitor-enter(r9);
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L10
        ShrinkableDebits quota = getEJDebitsLocked(userId, packageName);     // Catch: Throwable -> L10
        if (transactQuotaLocked(userId, packageName, nowElapsed, quota, credit) == false) goto L12;
        this.mStateChangedListener.onControllerStateChanged(maybeUpdateConstraintForPkgLocked(nowElapsed, userId, packageName));     // Catch: Throwable -> L10
    L12:
        monitor-exit(r9);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean transactQuotaLocked(int userId, String packageName, long nowElapsed, ShrinkableDebits debits, long credit) {
        long oldTally = debits.getTallyLocked();
        long leftover = debits.transactLocked(-credit);
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "debits overflowed by " + leftover);
    L6:
        if (oldTally == debits.getTallyLocked()) goto L8;
        boolean changed = true;
    L10:
        if (leftover == 0) goto L17;
        Timer ejTimer = (Timer) this.mEJPkgTimers.get(userId, packageName);
        if (ejTimer != null) goto L14;
        return changed;
    L14:
        if (ejTimer.isActive() == false) goto L19;
        ejTimer.updateDebitAdjustment(nowElapsed, leftover);
        return true;
    L19:
        return changed;
    L17:
        return changed;
    L8:
        changed = false;
        goto L10
    }

    void maybeScheduleCleanupAlarmLocked() {
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (this.mNextCleanupTimeElapsed > nowElapsed) goto L5;
        this.mEarliestEndTimeFunctor.reset();
        this.mTimingEvents.forEach(this.mEarliestEndTimeFunctor);
        this.mEJTimingSessions.forEach(this.mEarliestEndTimeFunctor);
        long earliestEndElapsed = this.mEarliestEndTimeFunctor.earliestEndElapsed;
        if (earliestEndElapsed == Long.MAX_VALUE) goto L11;
        long nextCleanupElapsed = 86400000 + earliestEndElapsed;
        if ((nextCleanupElapsed - this.mNextCleanupTimeElapsed) > 600000) goto L17;
        long nextCleanupElapsed2 = this.mNextCleanupTimeElapsed + 600000;
    L18:
        this.mNextCleanupTimeElapsed = nextCleanupElapsed2;
        this.mAlarmManager.set(3, nextCleanupElapsed2, ALARM_TAG_CLEANUP, this.mSessionCleanupAlarmListener, this.mHandler);
        if (DEBUG == false) goto L24;
        Slog.d(TAG, "Scheduled next cleanup for " + this.mNextCleanupTimeElapsed);
        return;
    L24:
        return;
    L17:
        nextCleanupElapsed2 = nextCleanupElapsed;
        goto L18
    L11:
        if (DEBUG == false) goto L23;
        Slog.d(TAG, "Didn't find a time to schedule cleanup");
        return;
    L23:
        return;
    L5:
        if (DEBUG == false) goto L22;
        Slog.v(TAG, "Not scheduling cleanup since there's already one at " + this.mNextCleanupTimeElapsed + " (in " + (this.mNextCleanupTimeElapsed - nowElapsed) + "ms)");
        return;
    }

    private void handleNewChargingStateLocked() {
        TimerChargingUpdateFunctor.m5088$$Nest$msetStatus(this.mTimerChargingUpdateFunctor, JobSchedulerService.sElapsedRealtimeClock.millis(), this.mService.isBatteryCharging());
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "handleNewChargingStateLocked: " + this.mService.isBatteryCharging());
    L5:
        this.mEJPkgTimers.forEach(this.mTimerChargingUpdateFunctor);
        this.mPkgTimers.forEach(this.mTimerChargingUpdateFunctor);
        AppSchedulingModuleThread.getHandler().post(new QuotaController$$ExternalSyntheticLambda4(this));
    }

    private /* synthetic */ void lambda$handleNewChargingStateLocked$2() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        maybeUpdateAllConstraintsLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void maybeUpdateAllConstraintsLocked() {
        ArraySet<JobStatus> changedJobs = new ArraySet();
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        int u = 0;
    L4:
        if (u >= this.mTrackedJobs.numMaps()) goto L10;
        int userId = this.mTrackedJobs.keyAt(u);
        int p = 0;
    L7:
        if (p >= this.mTrackedJobs.numElementsForKey(userId)) goto L9;
        String packageName = (String) this.mTrackedJobs.keyAt(u, p);
        changedJobs.addAll(maybeUpdateConstraintForPkgLocked(nowElapsed, userId, packageName));
        p = p + 1;
        goto L7
    L9:
        u = u + 1;
        goto L4
    L10:
        int u2 = changedJobs.size();
        if (u2 <= 0) goto L16;
        this.mStateChangedListener.onControllerStateChanged(changedJobs);
        return;
    }

    private ArraySet<JobStatus> maybeUpdateConstraintForPkgLocked(long nowElapsed, int userId, String packageName) {
        long r2 = nowElapsed;
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, packageName);
        ArraySet<JobStatus> changedJobs = new ArraySet();
        if (jobs != null) goto L5;
    L55:
        return changedJobs;
    L5:
        if (jobs.size() == 0) goto L55;
        int realStandbyBucket = jobs.valueAt(0).getStandbyBucket();
        boolean realInQuota = isWithinQuotaLocked(userId, packageName, realStandbyBucket);
        boolean outOfEJQuota = false;
        int i = jobs.size() - 1;
    L8:
        if (i < 0) goto L49;
        JobStatus js = jobs.valueAt(i);
        if (js.isRequestedExpeditedJob() == true) goto L12;
    L14:
        boolean isWithinEJQuota = false;
    L16:
        if (isTopStartedJobLocked(js) == false) goto L22;
        if (js.setQuotaConstraintSatisfied(r2, true) == false) goto L20;
        changedJobs.add(js);
        realInQuota = realInQuota;
    L39:
        if (js.isRequestedExpeditedJob() == false) goto L47;
        if (setExpeditedQuotaApproved(js, r2, isWithinEJQuota) == false) goto L43;
        changedJobs.add(js);
    L43:
        if (isWithinEJQuota == true) goto L45;
        boolean r4 = true;
    L46:
        outOfEJQuota = r4 | outOfEJQuota;
        goto L47
    L45:
        r4 = false;
    L47:
        i = i - 1;
        realInQuota = realInQuota;
        goto L8
    L20:
        realInQuota = realInQuota;
        goto L39
    L22:
        if (realStandbyBucket == 6) goto L35;
        if (realStandbyBucket == 0) goto L35;
        if (realStandbyBucket != js.getEffectiveStandbyBucket()) goto L35;
        if (this.mService.isCurrentlyRunningLocked(js) == true) goto L35;
        realInQuota = realInQuota;
        if (setConstraintSatisfied(js, r2, realInQuota, isWithinEJQuota) == false) goto L31;
        changedJobs.add(js);
        r2 = nowElapsed;
        goto L39
    L31:
        r2 = nowElapsed;
    L35:
        r2 = nowElapsed;
        if (setConstraintSatisfied(js, r2, isWithinQuotaLocked(js), isWithinEJQuota) == false) goto L39;
        changedJobs.add(js);
        goto L39
    L12:
        if (isWithinEJQuotaLocked(js) == false) goto L14;
        isWithinEJQuota = true;
        goto L16
    L49:
        if (realInQuota == false) goto L53;
        if (outOfEJQuota == true) goto L53;
        this.mInQuotaAlarmQueue.removeAlarmForKey(UserPackage.of(userId, packageName));
    L54:
        return changedJobs;
    L53:
        maybeScheduleStartAlarmLocked(userId, packageName, realStandbyBucket);
        goto L54
    }

    private ArraySet<JobStatus> maybeUpdateConstraintForUidLocked(int uid) {
        this.mUpdateUidConstraints.prepare();
        this.mService.getJobStore().forEachJobForSourceUid(uid, this.mUpdateUidConstraints);
        this.mUpdateUidConstraints.postProcess();
        this.mUpdateUidConstraints.reset();
        return this.mUpdateUidConstraints.changedJobs;
    }

    void maybeScheduleStartAlarmLocked(int userId, String packageName, int standbyBucket) {
        if (standbyBucket != 4) goto L5;
        return;
    L5:
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, packageName);
        if (jobs == null) goto L79;
        if (jobs.size() == 0) goto L79;
        ExecutionStats stats = getExecutionStatsLocked(userId, packageName, standbyBucket);
        boolean isUnderJobCountQuota = isUnderJobCountQuotaLocked(stats);
        boolean isUnderTimingSessionCountQuota = isUnderSessionCountQuotaLocked(stats);
        long remainingEJQuota = getRemainingEJExecutionTimeLocked(userId, packageName);
        long allowedTimePerPeriosMs = getAllowedTimePerPeriodMsLocked(userId, packageName, standbyBucket);
        if (stats.executionTimeInWindowMs >= allowedTimePerPeriosMs) goto L18;
        if (stats.executionTimeInMaxPeriodMs >= this.mMaxExecutionTimeMs) goto L18;
        if (isUnderJobCountQuota == false) goto L18;
        if (isUnderTimingSessionCountQuota == false) goto L18;
        boolean inRegularQuota = true;
    L20:
        if (inRegularQuota == true) goto L22;
    L29:
        long inRegularQuotaTimeElapsed = Long.MAX_VALUE;
        if (inRegularQuota == true) goto L42;
        long inQuotaTimeElapsed = stats.inQuotaTimeElapsed;
        if (isUnderJobCountQuota == true) goto L36;
        long inEJQuotaTimeElapsed = Long.MAX_VALUE;
        if (stats.bgJobCountInWindow >= stats.jobCountLimit) goto L37;
        inQuotaTimeElapsed = Math.max(inQuotaTimeElapsed, stats.jobRateLimitExpirationTimeElapsed);
    L37:
        if (isUnderTimingSessionCountQuota == false) goto L39;
    L41:
        inRegularQuotaTimeElapsed = inQuotaTimeElapsed;
    L44:
        if (remainingEJQuota > 0) goto L71;
        long limitMs = getEJLimitMsLocked(userId, packageName, standbyBucket) - this.mQuotaBufferMs;
        long sumMs = 0;
        Timer ejTimer = (Timer) this.mEJPkgTimers.get(userId, packageName);
        if (ejTimer != null) goto L48;
    L53:
        long limitMs2 = limitMs;
        long inEJQuotaTimeElapsed2 = inEJQuotaTimeElapsed;
    L54:
        List<TimedEvent> timingSessions = (List) this.mEJTimingSessions.get(userId, packageName);
        if (timingSessions == null) goto L65;
        int i = timingSessions.size() - 1;
    L57:
        if (i < 0) goto L72;
        int i2 = i;
        TimingSession ts = (TimingSession) timingSessions.get(i);
        List<TimedEvent> timingSessions2 = timingSessions;
        long durationMs = ts.endTimeElapsed - ts.startTimeElapsed;
        sumMs = sumMs + durationMs;
        if (sumMs >= limitMs2) goto L60;
        i = i2 - 1;
        timingSessions = timingSessions2;
        goto L57
    L60:
        long durationMs2 = ts.startTimeElapsed;
        long inEJQuotaTimeElapsed3 = (durationMs2 + (sumMs - limitMs2)) + this.mEJLimitWindowSizeMs;
        inEJQuotaTimeElapsed2 = inEJQuotaTimeElapsed3;
    L72:
        long inQuotaTimeElapsed2 = Math.min(inRegularQuotaTimeElapsed, inEJQuotaTimeElapsed2);
        if (inQuotaTimeElapsed2 > JobSchedulerService.sElapsedRealtimeClock.millis()) goto L76;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        Slog.wtf(TAG, "In quota time is " + (nowElapsed - inQuotaTimeElapsed2) + "ms old. Now=" + nowElapsed + ", inQuotaTime=" + inQuotaTimeElapsed2 + ": " + stats);
        inQuotaTimeElapsed2 = nowElapsed + 300000;
    L76:
        this.mInQuotaAlarmQueue.addAlarm(UserPackage.of(userId, packageName), inQuotaTimeElapsed2);
        return;
    L65:
        if (ejTimer != null) goto L67;
    L68:
        if (inRegularQuota == false) goto L72;
        Slog.wtf(TAG, StateController.packageToString(userId, packageName) + " has 0 EJ quota without running anything");
        return;
    L67:
        if (ejTimer.isActive() == true) goto L72;
    L48:
        if (ejTimer.isActive() == false) goto L53;
        limitMs2 = limitMs;
        long nowElapsed2 = JobSchedulerService.sElapsedRealtimeClock.millis();
        sumMs = 0 + ejTimer.getCurrentDuration(nowElapsed2);
        if (sumMs < limitMs2) goto L52;
        inEJQuotaTimeElapsed2 = (nowElapsed2 - limitMs2) + this.mEJLimitWindowSizeMs;
        goto L54
    L52:
        inEJQuotaTimeElapsed2 = inEJQuotaTimeElapsed;
        goto L54
    L71:
        inEJQuotaTimeElapsed2 = inEJQuotaTimeElapsed;
        goto L72
    L39:
        if (stats.sessionCountInWindow >= stats.sessionCountLimit) goto L41;
        inQuotaTimeElapsed = Math.max(inQuotaTimeElapsed, stats.sessionRateLimitExpirationTimeElapsed);
        goto L41
    L36:
        inEJQuotaTimeElapsed = Long.MAX_VALUE;
        goto L37
    L42:
        inEJQuotaTimeElapsed = Long.MAX_VALUE;
        goto L44
    L22:
        if (remainingEJQuota <= 0) goto L29;
        if (DEBUG == false) goto L27;
        Slog.e(TAG, "maybeScheduleStartAlarmLocked called for " + StateController.packageToString(userId, packageName) + " even though it already has " + getRemainingExecutionTimeLocked(userId, packageName, standbyBucket) + "ms in its quota.");
    L27:
        this.mInQuotaAlarmQueue.removeAlarmForKey(UserPackage.of(userId, packageName));
        this.mHandler.obtainMessage(2, userId, 0, packageName).sendToTarget();
        return;
    L18:
        inRegularQuota = false;
    L79:
        Slog.e(TAG, "maybeScheduleStartAlarmLocked called for " + StateController.packageToString(userId, packageName) + " that has no jobs");
        this.mInQuotaAlarmQueue.removeAlarmForKey(UserPackage.of(userId, packageName));
    }

    private boolean setConstraintSatisfied(JobStatus jobStatus, long nowElapsed, boolean isWithinQuota, boolean isWithinEjQuota) {
        if (jobStatus.startedAsExpeditedJob == false) goto L6;
        boolean isSatisfied = isWithinEjQuota;
    L13:
        if (isSatisfied == true) goto L18;
        if (jobStatus.getWhenStandbyDeferred() != 0) goto L18;
        jobStatus.setWhenStandbyDeferred(nowElapsed);
    L18:
        return jobStatus.setQuotaConstraintSatisfied(nowElapsed, isSatisfied);
    L6:
        if (this.mService.isCurrentlyRunningLocked(jobStatus) == false) goto L8;
        isSatisfied = isWithinQuota;
        goto L13
    L8:
        if (isWithinEjQuota == true) goto L12;
        if (isWithinQuota == true) goto L12;
        isSatisfied = false;
    L12:
        isSatisfied = true;
        goto L13
    }

    private boolean setExpeditedQuotaApproved(JobStatus jobStatus, long nowElapsed, boolean isWithinQuota) {
        if (jobStatus.setExpeditedJobQuotaApproved(nowElapsed, isWithinQuota) == false) goto L11;
        this.mBackgroundJobsController.evaluateStateLocked(jobStatus);
        this.mConnectivityController.evaluateStateLocked(jobStatus);
        if (isWithinQuota == true) goto L7;
        return true;
    L7:
        if (jobStatus.isReady() == false) goto L14;
        this.mStateChangedListener.onRunJobNow(jobStatus);
        return true;
    L14:
        return true;
    L11:
        return false;
    }

    void updateStandbyBucket(int userId, String packageName, int bucketIndex) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "Moving pkg " + StateController.packageToString(userId, packageName) + " to bucketIndex " + bucketIndex);
    L5:
        List<JobStatus> restrictedChanges = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        ShrinkableDebits debits = (ShrinkableDebits) this.mEJStats.get(userId, packageName);     // Catch: Throwable -> L10
        if (debits == null) goto L12;
        debits.setStandbyBucketLocked(bucketIndex);     // Catch: Throwable -> L10
    L12:
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, packageName);     // Catch: Throwable -> L10
        if (jobs == null) goto L43;
        if (jobs.size() == 0) goto L43;
        int i = jobs.size() - 1;     // Catch: Throwable -> L10
    L18:
        if (i < 0) goto L27;
        JobStatus js = jobs.valueAt(i);     // Catch: Throwable -> L10
        if (bucketIndex == 5) goto L24;
        if (js.getStandbyBucket() == 5) goto L24;
    L26:
        js.setStandbyBucket(bucketIndex);     // Catch: Throwable -> L10
        i = i - 1;     // Catch: Throwable -> L10
    L24:
        if (bucketIndex == js.getStandbyBucket()) goto L26;
        restrictedChanges.add(js);     // Catch: Throwable -> L10
        goto L26
    L27:
        Timer timer = (Timer) this.mPkgTimers.get(userId, packageName);     // Catch: Throwable -> L10
        if (timer != null) goto L30;
    L32:
        Timer timer2 = (Timer) this.mEJPkgTimers.get(userId, packageName);     // Catch: Throwable -> L10
        if (timer2 != null) goto L35;
    L37:
        this.mStateChangedListener.onControllerStateChanged(maybeUpdateConstraintForPkgLocked(JobSchedulerService.sElapsedRealtimeClock.millis(), userId, packageName));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (restrictedChanges.size() <= 0) goto L52;
        this.mStateChangedListener.onRestrictedBucketChanged(restrictedChanges);
        return;
    L52:
        return;
    L35:
        if (timer2.isActive() == false) goto L37;
        timer2.rescheduleCutoff();     // Catch: Throwable -> L10
        goto L37
    L30:
        if (timer.isActive() == false) goto L32;
        timer.rescheduleCutoff();     // Catch: Throwable -> L10
    L43:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$3(List events) {
        if (events == null) goto L5;
        events.removeIf(this.mTimedEventTooOld);
        return;
    }

    void deleteObsoleteSessionsLocked() {
        TimedEventTooOldPredicate.m5086$$Nest$mupdateNow(this.mTimedEventTooOld);
        this.mTimingEvents.forEach(this.mDeleteOldEventsFunctor);
        int uIdx = 0;
    L4:
        if (uIdx >= this.mEJTimingSessions.numMaps()) goto L19;
        int userId = this.mEJTimingSessions.keyAt(uIdx);
        int pIdx = 0;
    L7:
        if (pIdx >= this.mEJTimingSessions.numElementsForKey(userId)) goto L17;
        String packageName = (String) this.mEJTimingSessions.keyAt(uIdx, pIdx);
        ShrinkableDebits debits = getEJDebitsLocked(userId, packageName);
        List<TimedEvent> sessions = (List) this.mEJTimingSessions.get(userId, packageName);
        if (sessions == null) goto L16;
    L12:
        if (sessions.size() <= 0) goto L16;
        TimingSession ts = (TimingSession) sessions.get(0);
        if (this.mTimedEventTooOld.test2(ts) == false) goto L16;
        long duration = ts.endTimeElapsed - ts.startTimeElapsed;
        debits.transactLocked(-duration);
        sessions.remove(0);
    L16:
        pIdx = pIdx + 1;
        goto L7
    L17:
        uIdx = uIdx + 1;
        goto L4
    }

    int getProcessStateQuotaFreeThreshold(int uid) {
        if (this.mPlatformCompat.isChangeEnabledByUid(OVERRIDE_QUOTA_ENFORCEMENT_TO_FGS_JOBS, uid) == true) goto L6;
        return 3;
    L6:
        return 4;
    }

    @Override // com.android.server.job.controllers.StateController
    public void prepareForUpdatedConstantsLocked() {
        QcConstants.m5083$$Nest$fputmShouldReevaluateConstraints(this.mQcConstants, false);
        QcConstants.m5082$$Nest$fputmRateLimitingConstantsUpdated(this.mQcConstants, false);
        QcConstants.m5081$$Nest$fputmExecutionPeriodConstantsUpdated(this.mQcConstants, false);
        QcConstants.m5080$$Nest$fputmEJLimitConstantsUpdated(this.mQcConstants, false);
    }

    @Override // com.android.server.job.controllers.StateController
    public void processConstantLocked(DeviceConfig.Properties properties, String key) {
        this.mQcConstants.processConstantLocked(properties, key);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onConstantsUpdatedLocked() {
        if (QcConstants.m5079$$Nest$fgetmShouldReevaluateConstraints(this.mQcConstants) == false) goto L6;
        AppSchedulingModuleThread.getHandler().post(new QuotaController$$ExternalSyntheticLambda3(this));
        return;
    }

    private /* synthetic */ void lambda$onConstantsUpdatedLocked$4() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        invalidateAllExecutionStatsLocked();     // Catch: Throwable -> L7
        maybeUpdateAllConstraintsLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    long[] getAllowedTimePerPeriodMs() {
        return this.mAllowedTimePerPeriodMs;
    }

    int[] getBucketMaxJobCounts() {
        return this.mMaxBucketJobCounts;
    }

    int[] getBucketMaxSessionCounts() {
        return this.mMaxBucketSessionCounts;
    }

    long[] getBucketWindowSizes() {
        return this.mBucketPeriodsMs;
    }

    SparseBooleanArray getForegroundUids() {
        return this.mForegroundUids;
    }

    Handler getHandler() {
        return this.mHandler;
    }

    long getEJGracePeriodTempAllowlistMs() {
        return this.mEJGracePeriodTempAllowlistMs;
    }

    long getEJGracePeriodTopAppMs() {
        return this.mEJGracePeriodTopAppMs;
    }

    long[] getEJLimitsMs() {
        return this.mEJLimitsMs;
    }

    long getEjLimitAdditionInstallerMs() {
        return this.mEjLimitAdditionInstallerMs;
    }

    long getAllowedTimePeriodAdditionInstallerMs() {
        return this.mAllowedTimePeriodAdditionaInstallerMs;
    }

    long getEjLimitAdditionSpecialMs() {
        return this.mEjLimitAdditionSpecialMs;
    }

    long getEJLimitWindowSizeMs() {
        return this.mEJLimitWindowSizeMs;
    }

    long getEJRewardInteractionMs() {
        return this.mEJRewardInteractionMs;
    }

    long getEJRewardNotificationSeenMs() {
        return this.mEJRewardNotificationSeenMs;
    }

    long getEJRewardTopAppMs() {
        return this.mEJRewardTopAppMs;
    }

    List<TimedEvent> getEJTimingSessions(int userId, String packageName) {
        return (List) this.mEJTimingSessions.get(userId, packageName);
    }

    long getEJTopAppTimeChunkSizeMs() {
        return this.mEJTopAppTimeChunkSizeMs;
    }

    long getInQuotaBufferMs() {
        return this.mQuotaBufferMs;
    }

    long getMaxExecutionTimeMs() {
        return this.mMaxExecutionTimeMs;
    }

    int getMaxJobCountPerRateLimitingWindow() {
        return this.mMaxJobCountPerRateLimitingWindow;
    }

    int getMaxSessionCountPerRateLimitingWindow() {
        return this.mMaxSessionCountPerRateLimitingWindow;
    }

    long getMinQuotaCheckDelayMs() {
        return this.mInQuotaAlarmQueue.getMinTimeBetweenAlarmsMs();
    }

    long getRateLimitingWindowMs() {
        return this.mRateLimitingWindowMs;
    }

    long getTimingSessionCoalescingDurationMs() {
        return this.mTimingSessionCoalescingDurationMs;
    }

    List<TimedEvent> getTimingSessions(int userId, String packageName) {
        return (List) this.mTimingEvents.get(userId, packageName);
    }

    QcConstants getQcConstants() {
        return this.mQcConstants;
    }

    @Override // com.android.server.job.controllers.StateController
    @NeverCompile
    public void dumpControllerStateLocked(final IndentingPrintWriter pw, final Predicate<JobStatus> predicate) {
        pw.println("Aconfig Flags:");
        pw.println("    com.android.server.job.adjust_quota_default_constants: true");
        pw.println("    com.android.server.job.enforce_quota_policy_to_fgs_jobs: true");
        pw.println("    com.android.server.job.enforce_quota_policy_to_top_started_jobs: true");
        pw.println("    com.android.server.job.additional_quota_for_system_installer: true");
        pw.println();
        pw.println("Current elapsed time: " + JobSchedulerService.sElapsedRealtimeClock.millis());
        pw.println();
        pw.print("Foreground UIDs: ");
        pw.println(this.mForegroundUids.toString());
        pw.println();
        pw.print("Cached top apps: ");
        pw.println(this.mTopAppCache.toString());
        pw.print("Cached top app grace period: ");
        pw.println(this.mTopAppGraceCache.toString());
        pw.print("Cached temp allowlist: ");
        pw.println(this.mTempAllowlistCache.toString());
        pw.print("Cached temp allowlist grace period: ");
        pw.println(this.mTempAllowlistGraceCache.toString());
        pw.println();
        pw.println("Special apps:");
        pw.increaseIndent();
        pw.print("System installers={");
        int si = 0;
    L4:
        if (si >= this.mSystemInstallers.size()) goto L8;
        if (si <= 0) goto L7;
        pw.print(", ");
    L7:
        pw.print(this.mSystemInstallers.keyAt(si));
        pw.print("->");
        pw.print(this.mSystemInstallers.get(si));
        si = si + 1;
        goto L4
    L8:
        pw.println("}");
        pw.decreaseIndent();
        pw.println();
        this.mTrackedJobs.forEach(new QuotaController$$ExternalSyntheticLambda5(this, predicate, pw));
        pw.println();
        int u = 0;
    L10:
        if (u >= this.mPkgTimers.numMaps()) goto L22;
        int userId = this.mPkgTimers.keyAt(u);
        int p = 0;
    L13:
        if (p >= this.mPkgTimers.numElementsForKey(userId)) goto L21;
        String pkgName = (String) this.mPkgTimers.keyAt(u, p);
        ((Timer) this.mPkgTimers.valueAt(u, p)).dump(pw, predicate);
        pw.println();
        List<TimedEvent> events = (List) this.mTimingEvents.get(userId, pkgName);
        if (events == null) goto L20;
        pw.increaseIndent();
        pw.println("Saved events:");
        pw.increaseIndent();
        int j = events.size() - 1;
    L17:
        if (j < 0) goto L19;
        TimedEvent event = events.get(j);
        event.dump(pw);
        j = j - 1;
        goto L17
    L19:
        pw.decreaseIndent();
        pw.decreaseIndent();
        pw.println();
    L20:
        p = p + 1;
        goto L13
    L21:
        u = u + 1;
        goto L10
    L22:
        pw.println();
        int u2 = 0;
    L24:
        if (u2 >= this.mEJPkgTimers.numMaps()) goto L36;
        int userId2 = this.mEJPkgTimers.keyAt(u2);
        int p2 = 0;
    L27:
        if (p2 >= this.mEJPkgTimers.numElementsForKey(userId2)) goto L35;
        String pkgName2 = (String) this.mEJPkgTimers.keyAt(u2, p2);
        ((Timer) this.mEJPkgTimers.valueAt(u2, p2)).dump(pw, predicate);
        pw.println();
        List<TimedEvent> sessions = (List) this.mEJTimingSessions.get(userId2, pkgName2);
        if (sessions == null) goto L34;
        pw.increaseIndent();
        pw.println("Saved sessions:");
        pw.increaseIndent();
        int j2 = sessions.size() - 1;
    L31:
        if (j2 < 0) goto L33;
        TimedEvent session = sessions.get(j2);
        session.dump(pw);
        j2 = j2 - 1;
        goto L31
    L33:
        pw.decreaseIndent();
        pw.decreaseIndent();
        pw.println();
    L34:
        p2 = p2 + 1;
        goto L27
    L35:
        u2 = u2 + 1;
        goto L24
    L36:
        pw.println();
        this.mTopAppTrackers.forEach(new QuotaController$$ExternalSyntheticLambda6(pw));
        pw.println();
        pw.println("Cached execution stats:");
        pw.increaseIndent();
        int u3 = 0;
    L38:
        if (u3 >= this.mExecutionStatsCache.numMaps()) goto L51;
        int userId3 = this.mExecutionStatsCache.keyAt(u3);
        int p3 = 0;
    L41:
        if (p3 >= this.mExecutionStatsCache.numElementsForKey(userId3)) goto L50;
        String pkgName3 = (String) this.mExecutionStatsCache.keyAt(u3, p3);
        ExecutionStats[] stats = (ExecutionStats[]) this.mExecutionStatsCache.valueAt(u3, p3);
        pw.println(StateController.packageToString(userId3, pkgName3));
        pw.increaseIndent();
        int i = 0;
    L44:
        if (i >= stats.length) goto L49;
        ExecutionStats executionStats = stats[i];
        if (executionStats == null) goto L48;
        pw.print(JobStatus.bucketName(i));
        pw.print(": ");
        pw.println(executionStats);
    L48:
        i = i + 1;
        goto L44
    L49:
        pw.decreaseIndent();
        p3 = p3 + 1;
        goto L41
    L50:
        u3 = u3 + 1;
        goto L38
    L51:
        pw.decreaseIndent();
        pw.println();
        pw.println("EJ debits:");
        pw.increaseIndent();
        int u4 = 0;
    L53:
        if (u4 >= this.mEJStats.numMaps()) goto L59;
        int userId4 = this.mEJStats.keyAt(u4);
        int p4 = 0;
    L56:
        if (p4 >= this.mEJStats.numElementsForKey(userId4)) goto L58;
        String pkgName4 = (String) this.mEJStats.keyAt(u4, p4);
        ShrinkableDebits debits = (ShrinkableDebits) this.mEJStats.valueAt(u4, p4);
        pw.print(StateController.packageToString(userId4, pkgName4));
        pw.print(": ");
        debits.dumpLocked(pw);
        p4 = p4 + 1;
        goto L56
    L58:
        u4 = u4 + 1;
        goto L53
    L59:
        pw.decreaseIndent();
        pw.println();
        this.mInQuotaAlarmQueue.dump(pw);
        pw.decreaseIndent();
    }

    private /* synthetic */ void lambda$dumpControllerStateLocked$5(Predicate predicate, IndentingPrintWriter pw, ArraySet jobs) {
        int j = 0;
    L4:
        if (j >= jobs.size()) goto L31;
        JobStatus js = (JobStatus) jobs.valueAt(j);
        if (predicate.test(js) == false) goto L29;
        pw.print(TRACE_QUOTA_STATE_CHANGED_DELIMITER);
        js.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, js.getSourceUid());
        if (this.mTopStartedJobs.contains(js) == false) goto L11;
        pw.print(" (TOP)");
    L11:
        pw.println();
        pw.increaseIndent();
        pw.print(JobStatus.bucketName(js.getEffectiveStandbyBucket()));
        pw.print(", ");
        if (js.shouldTreatAsExpeditedJob() == false) goto L15;
        pw.print("within EJ quota");
    L21:
        pw.print(", ");
        if (js.shouldTreatAsExpeditedJob() == false) goto L25;
        pw.print(getRemainingEJExecutionTimeLocked(js.getSourceUserId(), js.getSourcePackageName()));
        pw.print("ms remaining in EJ quota");
    L28:
        pw.println();
        pw.decreaseIndent();
        goto L29
    L25:
        if (js.startedAsExpeditedJob == false) goto L27;
        pw.print("should be stopped after min execution time");
        goto L28
    L27:
        pw.print(getRemainingExecutionTimeLocked(js));
        pw.print("ms remaining in quota");
        goto L28
    L15:
        if (js.startedAsExpeditedJob == false) goto L18;
        pw.print("out of EJ quota");
        goto L21
    L18:
        if (js.isConstraintSatisfied(16777216) == false) goto L20;
        pw.print("within regular quota");
        goto L21
    L20:
        pw.print("not within quota");
    L29:
        j = j + 1;
        goto L4
    }

    private static /* synthetic */ void lambda$dumpControllerStateLocked$6(IndentingPrintWriter pw, TopAppTimer timer) {
        timer.dump(pw);
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(final ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
        final Predicate<JobStatus> r2 = predicate;
        long token = proto.start(fieldId);
        long mToken = proto.start(1146756268041L);
        proto.write(1133871366145L, this.mService.isBatteryCharging());
        proto.write(1112396529670L, JobSchedulerService.sElapsedRealtimeClock.millis());
        int i = 0;
    L4:
        if (i >= this.mForegroundUids.size()) goto L6;
        proto.write(2220498092035L, this.mForegroundUids.keyAt(i));
        i = i + 1;
        goto L4
    L6:
        this.mTrackedJobs.forEach(new QuotaController$$ExternalSyntheticLambda7(this, r2, proto));
        int u = 0;
    L8:
        if (u >= this.mPkgTimers.numMaps()) goto L41;
        int userId = this.mPkgTimers.keyAt(u);
        int p = 0;
    L11:
        if (p >= this.mPkgTimers.numElementsForKey(userId)) goto L40;
        String pkgName = (String) this.mPkgTimers.keyAt(u, p);
        long psToken = proto.start(2246267895813L);
        ((Timer) this.mPkgTimers.valueAt(u, p)).dump(proto, 1146756268034L, r2);
        Timer ejTimer = (Timer) this.mEJPkgTimers.get(userId, pkgName);
        if (ejTimer == null) goto L16;
        ejTimer.dump(proto, 1146756268038L, r2);
    L16:
        List<TimedEvent> events = (List) this.mTimingEvents.get(userId, pkgName);
        if (events == null) goto L26;
        int j = events.size() - 1;
    L19:
        if (j < 0) goto L25;
        TimedEvent event = events.get(j);
        int u2 = u;
        if ((event instanceof TimingSession) == false) goto L24;
        TimingSession session = (TimingSession) event;
        session.dump(proto, 2246267895811L);
    L24:
        j = j - 1;
        u = u2;
        ejTimer = ejTimer;
        events = events;
        goto L19
    L25:
        int u3 = u;
    L27:
        ExecutionStats[] stats = (ExecutionStats[]) this.mExecutionStatsCache.get(userId, pkgName);
        if (stats == null) goto L38;
        int bucketIndex = 0;
    L31:
        if (bucketIndex >= stats.length) goto L37;
        ExecutionStats es = stats[bucketIndex];
        if (es == null) goto L36;
        long esToken = proto.start(2246267895812L);
        proto.write(1159641169921L, bucketIndex);
        proto.write(1112396529666L, es.expirationTimeElapsed);
        proto.write(1112396529667L, es.windowSizeMs);
        proto.write(1120986464270L, es.jobCountLimit);
        proto.write(1120986464271L, es.sessionCountLimit);
        proto.write(1112396529668L, es.executionTimeInWindowMs);
        proto.write(1120986464261L, es.bgJobCountInWindow);
        proto.write(1112396529670L, es.executionTimeInMaxPeriodMs);
        proto.write(1120986464263L, es.bgJobCountInMaxPeriod);
        proto.write(1120986464267L, es.sessionCountInWindow);
        proto.write(1112396529672L, es.inQuotaTimeElapsed);
        proto.write(1112396529673L, es.jobRateLimitExpirationTimeElapsed);
        proto.write(1120986464266L, es.jobCountInRateLimitingWindow);
        proto.write(1112396529676L, es.sessionRateLimitExpirationTimeElapsed);
        proto.write(1120986464269L, es.sessionCountInRateLimitingWindow);
        proto.end(esToken);
    L36:
        bucketIndex = bucketIndex + 1;
        stats = stats;
        token = token;
        userId = userId;
        goto L31
    L37:
        long token2 = token;
    L39:
        proto.end(psToken);
        p = p + 1;
        r2 = predicate;
        u = u3;
        token = token2;
        userId = userId;
        goto L11
    L38:
        token2 = token;
        goto L39
    L26:
        u3 = u;
        goto L27
    L40:
        u = u + 1;
        r2 = predicate;
        goto L8
    L41:
        proto.end(mToken);
        proto.end(token);
    }

    private /* synthetic */ void lambda$dumpControllerStateLocked$7(Predicate predicate, ProtoOutputStream proto, ArraySet jobs) {
        int j = 0;
    L4:
        if (j >= jobs.size()) goto L11;
        JobStatus js = (JobStatus) jobs.valueAt(j);
        if (predicate.test(js) == false) goto L9;
        long jsToken = proto.start(2246267895812L);
        js.writeToShortProto(proto, 1146756268033L);
        proto.write(1120986464258L, js.getSourceUid());
        proto.write(1159641169923L, js.getEffectiveStandbyBucket());
        proto.write(1133871366148L, this.mTopStartedJobs.contains(js));
        proto.write(1133871366149L, js.isConstraintSatisfied(16777216));
        proto.write(1112396529670L, getRemainingExecutionTimeLocked(js));
        proto.write(1133871366151L, js.isRequestedExpeditedJob());
        proto.write(1133871366152L, js.isExpeditedQuotaApproved());
        proto.end(jsToken);
    L9:
        j = j + 1;
        goto L4
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpConstants(IndentingPrintWriter pw) {
        QcConstants.m5084$$Nest$mdump(this.mQcConstants, pw);
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpConstants(ProtoOutputStream proto) {
        QcConstants.m5085$$Nest$mdump(this.mQcConstants, proto);
    }
}
