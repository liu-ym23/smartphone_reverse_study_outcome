package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public interface FeatureFlags {
    boolean addModifyRawOomAdjServiceLevel();

    boolean appStartInfoIsolatedProcess();

    boolean avoidNoteOpAtEnqueue();

    boolean avoidRepeatedBcastReEnqueues();

    boolean avoidResolvingType();

    boolean batchingOomAdj();

    boolean bfgsManagedNetworkAccess();

    boolean collectLogcatOnRunSynchronously();

    boolean deferBindersWhenPaused();

    boolean deferDisplayEventsWhenFrozen();

    boolean deferOutgoingBroadcasts();

    boolean enableDropboxWatchdogHeaders();

    boolean expediteActivityLaunchOnColdStart();

    boolean fgsAbuseDetection();

    boolean fgsBootCompleted();

    boolean fgsDisableSaw();

    boolean fixApplyOomadjOrder();

    boolean followUpOomadjUpdates();

    boolean limitPriorityScope();

    boolean logBroadcastProcessedEvent();

    boolean logBroadcastSentEvent();

    boolean logExcessiveBinderProxies();

    boolean logcatLongerTimeout();

    boolean lowerSmsOomImportance();

    boolean migrateFullOomadjUpdates();

    boolean newFgsRestrictionLogic();

    boolean oomadjusterCachedAppTiers();

    boolean oomadjusterCorrectnessRewrite();

    boolean oomadjusterPrevLaddering();

    boolean perceptibleTasks();

    boolean phantomProcessesFix();

    boolean prototypeAggressiveFreezing();

    boolean pushGlobalStateToOomadjuster();

    boolean raiseBoundUiServiceThreshold();

    boolean restrictPriorityValues();

    boolean serviceBindingOomAdjPolicy();

    boolean simplifyProcessTraversal();

    boolean skipUnimportantConnections();

    boolean traceReceiverRegistration();

    boolean traceUpdateAppFreezeStateLsp();

    boolean unfreezeBindPolicyFix();

    boolean useCpuTimeCapability();
}
