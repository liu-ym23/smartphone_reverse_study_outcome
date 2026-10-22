package com.android.server.job;

/* JADX INFO: loaded from: classes2.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean additionalQuotaForSystemInstaller() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean adjustQuotaDefaultConstants() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean batchActiveBucketJobs() {
        return false;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean batchConnectivityJobsPerNetwork() {
        return false;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean countQuotaFix() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean createWorkChainByDefault() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean doNotForceRushExecutionAtBoot() {
        return false;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean enforceQuotaPolicyToFgsJobs() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean enforceQuotaPolicyToTopStartedJobs() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean enforceScheduleLimitToProxyJobs() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean includeTraceTagInJobName() {
        return false;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean relaxPrefetchConnectivityConstraintOnlyOnCharger() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean removeUserDuringUserSwitch() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean thermalRestrictionsToFgsJobs() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean tuneQuotaWindowDefaultParameters() {
        return true;
    }

    @Override // com.android.server.job.FeatureFlags
    public boolean useCorrectProcessStateForLogging() {
        return true;
    }
}
