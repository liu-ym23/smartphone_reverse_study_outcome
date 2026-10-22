package com.android.server.job;

/* JADX INFO: loaded from: classes2.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ADDITIONAL_QUOTA_FOR_SYSTEM_INSTALLER = "com.android.server.job.additional_quota_for_system_installer";
    public static final String FLAG_ADJUST_QUOTA_DEFAULT_CONSTANTS = "com.android.server.job.adjust_quota_default_constants";
    public static final String FLAG_BATCH_ACTIVE_BUCKET_JOBS = "com.android.server.job.batch_active_bucket_jobs";
    public static final String FLAG_BATCH_CONNECTIVITY_JOBS_PER_NETWORK = "com.android.server.job.batch_connectivity_jobs_per_network";
    public static final String FLAG_COUNT_QUOTA_FIX = "com.android.server.job.count_quota_fix";
    public static final String FLAG_CREATE_WORK_CHAIN_BY_DEFAULT = "com.android.server.job.create_work_chain_by_default";
    public static final String FLAG_DO_NOT_FORCE_RUSH_EXECUTION_AT_BOOT = "com.android.server.job.do_not_force_rush_execution_at_boot";
    public static final String FLAG_ENFORCE_QUOTA_POLICY_TO_FGS_JOBS = "com.android.server.job.enforce_quota_policy_to_fgs_jobs";
    public static final String FLAG_ENFORCE_QUOTA_POLICY_TO_TOP_STARTED_JOBS = "com.android.server.job.enforce_quota_policy_to_top_started_jobs";
    public static final String FLAG_ENFORCE_SCHEDULE_LIMIT_TO_PROXY_JOBS = "com.android.server.job.enforce_schedule_limit_to_proxy_jobs";
    public static final String FLAG_INCLUDE_TRACE_TAG_IN_JOB_NAME = "com.android.server.job.include_trace_tag_in_job_name";
    public static final String FLAG_RELAX_PREFETCH_CONNECTIVITY_CONSTRAINT_ONLY_ON_CHARGER = "com.android.server.job.relax_prefetch_connectivity_constraint_only_on_charger";
    public static final String FLAG_REMOVE_USER_DURING_USER_SWITCH = "com.android.server.job.remove_user_during_user_switch";
    public static final String FLAG_THERMAL_RESTRICTIONS_TO_FGS_JOBS = "com.android.server.job.thermal_restrictions_to_fgs_jobs";
    public static final String FLAG_TUNE_QUOTA_WINDOW_DEFAULT_PARAMETERS = "com.android.server.job.tune_quota_window_default_parameters";
    public static final String FLAG_USE_CORRECT_PROCESS_STATE_FOR_LOGGING = "com.android.server.job.use_correct_process_state_for_logging";

    public Flags() {
    }

    public static boolean additionalQuotaForSystemInstaller() {
        return true;
    }

    public static boolean adjustQuotaDefaultConstants() {
        return true;
    }

    public static boolean batchActiveBucketJobs() {
        return false;
    }

    public static boolean batchConnectivityJobsPerNetwork() {
        return false;
    }

    public static boolean countQuotaFix() {
        return true;
    }

    public static boolean createWorkChainByDefault() {
        return true;
    }

    public static boolean doNotForceRushExecutionAtBoot() {
        return false;
    }

    public static boolean enforceQuotaPolicyToFgsJobs() {
        return true;
    }

    public static boolean enforceQuotaPolicyToTopStartedJobs() {
        return true;
    }

    public static boolean enforceScheduleLimitToProxyJobs() {
        return true;
    }

    public static boolean includeTraceTagInJobName() {
        return false;
    }

    public static boolean relaxPrefetchConnectivityConstraintOnlyOnCharger() {
        return true;
    }

    public static boolean removeUserDuringUserSwitch() {
        return true;
    }

    public static boolean thermalRestrictionsToFgsJobs() {
        return true;
    }

    public static boolean tuneQuotaWindowDefaultParameters() {
        return true;
    }

    public static boolean useCorrectProcessStateForLogging() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
