package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean addModifyRawOomAdjServiceLevel() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean appStartInfoIsolatedProcess() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean avoidNoteOpAtEnqueue() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean avoidRepeatedBcastReEnqueues() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean avoidResolvingType() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean batchingOomAdj() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean bfgsManagedNetworkAccess() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean collectLogcatOnRunSynchronously() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean deferBindersWhenPaused() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean deferDisplayEventsWhenFrozen() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean deferOutgoingBroadcasts() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean enableDropboxWatchdogHeaders() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean expediteActivityLaunchOnColdStart() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean fgsAbuseDetection() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean fgsBootCompleted() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean fgsDisableSaw() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean fixApplyOomadjOrder() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean followUpOomadjUpdates() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean limitPriorityScope() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean logBroadcastProcessedEvent() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean logBroadcastSentEvent() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean logExcessiveBinderProxies() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean logcatLongerTimeout() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean lowerSmsOomImportance() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean migrateFullOomadjUpdates() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean newFgsRestrictionLogic() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean oomadjusterCachedAppTiers() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean oomadjusterCorrectnessRewrite() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean oomadjusterPrevLaddering() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean perceptibleTasks() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean phantomProcessesFix() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean prototypeAggressiveFreezing() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean pushGlobalStateToOomadjuster() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean raiseBoundUiServiceThreshold() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean restrictPriorityValues() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean serviceBindingOomAdjPolicy() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean simplifyProcessTraversal() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean skipUnimportantConnections() {
        return false;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean traceReceiverRegistration() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean traceUpdateAppFreezeStateLsp() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean unfreezeBindPolicyFix() {
        return true;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean useCpuTimeCapability() {
        return false;
    }
}
