package com.android.server.job;

/* JADX INFO: loaded from: classes2.dex */
public interface FeatureFlags {
    boolean additionalQuotaForSystemInstaller();

    boolean adjustQuotaDefaultConstants();

    boolean batchActiveBucketJobs();

    boolean batchConnectivityJobsPerNetwork();

    boolean countQuotaFix();

    boolean createWorkChainByDefault();

    boolean doNotForceRushExecutionAtBoot();

    boolean enforceQuotaPolicyToFgsJobs();

    boolean enforceQuotaPolicyToTopStartedJobs();

    boolean enforceScheduleLimitToProxyJobs();

    boolean includeTraceTagInJobName();

    boolean relaxPrefetchConnectivityConstraintOnlyOnCharger();

    boolean removeUserDuringUserSwitch();

    boolean thermalRestrictionsToFgsJobs();

    boolean tuneQuotaWindowDefaultParameters();

    boolean useCorrectProcessStateForLogging();
}
