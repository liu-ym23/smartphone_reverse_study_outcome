package com.android.server.job;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ADDITIONAL_QUOTA_FOR_SYSTEM_INSTALLER, Flags.FLAG_ADJUST_QUOTA_DEFAULT_CONSTANTS, Flags.FLAG_BATCH_ACTIVE_BUCKET_JOBS, Flags.FLAG_BATCH_CONNECTIVITY_JOBS_PER_NETWORK, Flags.FLAG_COUNT_QUOTA_FIX, Flags.FLAG_CREATE_WORK_CHAIN_BY_DEFAULT, Flags.FLAG_DO_NOT_FORCE_RUSH_EXECUTION_AT_BOOT, Flags.FLAG_ENFORCE_QUOTA_POLICY_TO_FGS_JOBS, Flags.FLAG_ENFORCE_QUOTA_POLICY_TO_TOP_STARTED_JOBS, Flags.FLAG_ENFORCE_SCHEDULE_LIMIT_TO_PROXY_JOBS, Flags.FLAG_INCLUDE_TRACE_TAG_IN_JOB_NAME, Flags.FLAG_RELAX_PREFETCH_CONNECTIVITY_CONSTRAINT_ONLY_ON_CHARGER, Flags.FLAG_REMOVE_USER_DURING_USER_SWITCH, Flags.FLAG_THERMAL_RESTRICTIONS_TO_FGS_JOBS, Flags.FLAG_TUNE_QUOTA_WINDOW_DEFAULT_PARAMETERS, Flags.FLAG_USE_CORRECT_PROCESS_STATE_FOR_LOGGING, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean additionalQuotaForSystemInstaller() {
        return getValue(Flags.FLAG_ADDITIONAL_QUOTA_FOR_SYSTEM_INSTALLER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean adjustQuotaDefaultConstants() {
        return getValue(Flags.FLAG_ADJUST_QUOTA_DEFAULT_CONSTANTS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean batchActiveBucketJobs() {
        return getValue(Flags.FLAG_BATCH_ACTIVE_BUCKET_JOBS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean batchConnectivityJobsPerNetwork() {
        return getValue(Flags.FLAG_BATCH_CONNECTIVITY_JOBS_PER_NETWORK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean countQuotaFix() {
        return getValue(Flags.FLAG_COUNT_QUOTA_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean createWorkChainByDefault() {
        return getValue(Flags.FLAG_CREATE_WORK_CHAIN_BY_DEFAULT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean doNotForceRushExecutionAtBoot() {
        return getValue(Flags.FLAG_DO_NOT_FORCE_RUSH_EXECUTION_AT_BOOT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean enforceQuotaPolicyToFgsJobs() {
        return getValue(Flags.FLAG_ENFORCE_QUOTA_POLICY_TO_FGS_JOBS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean enforceQuotaPolicyToTopStartedJobs() {
        return getValue(Flags.FLAG_ENFORCE_QUOTA_POLICY_TO_TOP_STARTED_JOBS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean enforceScheduleLimitToProxyJobs() {
        return getValue(Flags.FLAG_ENFORCE_SCHEDULE_LIMIT_TO_PROXY_JOBS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean includeTraceTagInJobName() {
        return getValue(Flags.FLAG_INCLUDE_TRACE_TAG_IN_JOB_NAME, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean relaxPrefetchConnectivityConstraintOnlyOnCharger() {
        return getValue(Flags.FLAG_RELAX_PREFETCH_CONNECTIVITY_CONSTRAINT_ONLY_ON_CHARGER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean removeUserDuringUserSwitch() {
        return getValue(Flags.FLAG_REMOVE_USER_DURING_USER_SWITCH, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean thermalRestrictionsToFgsJobs() {
        return getValue(Flags.FLAG_THERMAL_RESTRICTIONS_TO_FGS_JOBS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean tuneQuotaWindowDefaultParameters() {
        return getValue(Flags.FLAG_TUNE_QUOTA_WINDOW_DEFAULT_PARAMETERS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean useCorrectProcessStateForLogging() {
        return getValue(Flags.FLAG_USE_CORRECT_PROCESS_STATE_FOR_LOGGING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    public boolean isFlagReadOnlyOptimized(String flagName) {
        if (this.mReadOnlyFlagsSet.contains(flagName) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isOptimizationEnabled() {
        return false;
    }

    protected boolean getValue(String flagName, Predicate<FeatureFlags> getter) {
        return this.mGetValueImpl.test(flagName, getter);
    }

    public List<String> getFlagNames() {
        return Arrays.asList(new String[]{Flags.FLAG_ADDITIONAL_QUOTA_FOR_SYSTEM_INSTALLER, Flags.FLAG_ADJUST_QUOTA_DEFAULT_CONSTANTS, Flags.FLAG_BATCH_ACTIVE_BUCKET_JOBS, Flags.FLAG_BATCH_CONNECTIVITY_JOBS_PER_NETWORK, Flags.FLAG_COUNT_QUOTA_FIX, Flags.FLAG_CREATE_WORK_CHAIN_BY_DEFAULT, Flags.FLAG_DO_NOT_FORCE_RUSH_EXECUTION_AT_BOOT, Flags.FLAG_ENFORCE_QUOTA_POLICY_TO_FGS_JOBS, Flags.FLAG_ENFORCE_QUOTA_POLICY_TO_TOP_STARTED_JOBS, Flags.FLAG_ENFORCE_SCHEDULE_LIMIT_TO_PROXY_JOBS, Flags.FLAG_INCLUDE_TRACE_TAG_IN_JOB_NAME, Flags.FLAG_RELAX_PREFETCH_CONNECTIVITY_CONSTRAINT_ONLY_ON_CHARGER, Flags.FLAG_REMOVE_USER_DURING_USER_SWITCH, Flags.FLAG_THERMAL_RESTRICTIONS_TO_FGS_JOBS, Flags.FLAG_TUNE_QUOTA_WINDOW_DEFAULT_PARAMETERS, Flags.FLAG_USE_CORRECT_PROCESS_STATE_FOR_LOGGING});
    }
}
