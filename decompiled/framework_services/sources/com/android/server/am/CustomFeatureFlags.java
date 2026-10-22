package com.android.server.am;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ADD_MODIFY_RAW_OOM_ADJ_SERVICE_LEVEL, Flags.FLAG_APP_START_INFO_ISOLATED_PROCESS, Flags.FLAG_AVOID_NOTE_OP_AT_ENQUEUE, Flags.FLAG_AVOID_REPEATED_BCAST_RE_ENQUEUES, Flags.FLAG_AVOID_RESOLVING_TYPE, Flags.FLAG_BATCHING_OOM_ADJ, Flags.FLAG_BFGS_MANAGED_NETWORK_ACCESS, Flags.FLAG_COLLECT_LOGCAT_ON_RUN_SYNCHRONOUSLY, Flags.FLAG_DEFER_BINDERS_WHEN_PAUSED, Flags.FLAG_DEFER_DISPLAY_EVENTS_WHEN_FROZEN, Flags.FLAG_DEFER_OUTGOING_BROADCASTS, Flags.FLAG_ENABLE_DROPBOX_WATCHDOG_HEADERS, Flags.FLAG_EXPEDITE_ACTIVITY_LAUNCH_ON_COLD_START, Flags.FLAG_FGS_ABUSE_DETECTION, Flags.FLAG_FGS_BOOT_COMPLETED, Flags.FLAG_FGS_DISABLE_SAW, Flags.FLAG_FIX_APPLY_OOMADJ_ORDER, Flags.FLAG_FOLLOW_UP_OOMADJ_UPDATES, Flags.FLAG_LIMIT_PRIORITY_SCOPE, Flags.FLAG_LOG_BROADCAST_PROCESSED_EVENT, Flags.FLAG_LOG_BROADCAST_SENT_EVENT, Flags.FLAG_LOG_EXCESSIVE_BINDER_PROXIES, Flags.FLAG_LOGCAT_LONGER_TIMEOUT, Flags.FLAG_LOWER_SMS_OOM_IMPORTANCE, Flags.FLAG_MIGRATE_FULL_OOMADJ_UPDATES, Flags.FLAG_NEW_FGS_RESTRICTION_LOGIC, Flags.FLAG_OOMADJUSTER_CACHED_APP_TIERS, Flags.FLAG_OOMADJUSTER_CORRECTNESS_REWRITE, Flags.FLAG_OOMADJUSTER_PREV_LADDERING, Flags.FLAG_PERCEPTIBLE_TASKS, Flags.FLAG_PHANTOM_PROCESSES_FIX, Flags.FLAG_PROTOTYPE_AGGRESSIVE_FREEZING, Flags.FLAG_PUSH_GLOBAL_STATE_TO_OOMADJUSTER, Flags.FLAG_RAISE_BOUND_UI_SERVICE_THRESHOLD, Flags.FLAG_RESTRICT_PRIORITY_VALUES, Flags.FLAG_SERVICE_BINDING_OOM_ADJ_POLICY, Flags.FLAG_SIMPLIFY_PROCESS_TRAVERSAL, Flags.FLAG_SKIP_UNIMPORTANT_CONNECTIONS, Flags.FLAG_TRACE_RECEIVER_REGISTRATION, Flags.FLAG_TRACE_UPDATE_APP_FREEZE_STATE_LSP, Flags.FLAG_UNFREEZE_BIND_POLICY_FIX, Flags.FLAG_USE_CPU_TIME_CAPABILITY, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean addModifyRawOomAdjServiceLevel() {
        return getValue(Flags.FLAG_ADD_MODIFY_RAW_OOM_ADJ_SERVICE_LEVEL, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean appStartInfoIsolatedProcess() {
        return getValue(Flags.FLAG_APP_START_INFO_ISOLATED_PROCESS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean avoidNoteOpAtEnqueue() {
        return getValue(Flags.FLAG_AVOID_NOTE_OP_AT_ENQUEUE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean avoidRepeatedBcastReEnqueues() {
        return getValue(Flags.FLAG_AVOID_REPEATED_BCAST_RE_ENQUEUES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean avoidResolvingType() {
        return getValue(Flags.FLAG_AVOID_RESOLVING_TYPE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean batchingOomAdj() {
        return getValue(Flags.FLAG_BATCHING_OOM_ADJ, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean bfgsManagedNetworkAccess() {
        return getValue(Flags.FLAG_BFGS_MANAGED_NETWORK_ACCESS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean collectLogcatOnRunSynchronously() {
        return getValue(Flags.FLAG_COLLECT_LOGCAT_ON_RUN_SYNCHRONOUSLY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean deferBindersWhenPaused() {
        return getValue(Flags.FLAG_DEFER_BINDERS_WHEN_PAUSED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean deferDisplayEventsWhenFrozen() {
        return getValue(Flags.FLAG_DEFER_DISPLAY_EVENTS_WHEN_FROZEN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean deferOutgoingBroadcasts() {
        return getValue(Flags.FLAG_DEFER_OUTGOING_BROADCASTS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean enableDropboxWatchdogHeaders() {
        return getValue(Flags.FLAG_ENABLE_DROPBOX_WATCHDOG_HEADERS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean expediteActivityLaunchOnColdStart() {
        return getValue(Flags.FLAG_EXPEDITE_ACTIVITY_LAUNCH_ON_COLD_START, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean fgsAbuseDetection() {
        return getValue(Flags.FLAG_FGS_ABUSE_DETECTION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean fgsBootCompleted() {
        return getValue(Flags.FLAG_FGS_BOOT_COMPLETED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean fgsDisableSaw() {
        return getValue(Flags.FLAG_FGS_DISABLE_SAW, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean fixApplyOomadjOrder() {
        return getValue(Flags.FLAG_FIX_APPLY_OOMADJ_ORDER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean followUpOomadjUpdates() {
        return getValue(Flags.FLAG_FOLLOW_UP_OOMADJ_UPDATES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean limitPriorityScope() {
        return getValue(Flags.FLAG_LIMIT_PRIORITY_SCOPE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean logBroadcastProcessedEvent() {
        return getValue(Flags.FLAG_LOG_BROADCAST_PROCESSED_EVENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean logBroadcastSentEvent() {
        return getValue(Flags.FLAG_LOG_BROADCAST_SENT_EVENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean logExcessiveBinderProxies() {
        return getValue(Flags.FLAG_LOG_EXCESSIVE_BINDER_PROXIES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean logcatLongerTimeout() {
        return getValue(Flags.FLAG_LOGCAT_LONGER_TIMEOUT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean lowerSmsOomImportance() {
        return getValue(Flags.FLAG_LOWER_SMS_OOM_IMPORTANCE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean migrateFullOomadjUpdates() {
        return getValue(Flags.FLAG_MIGRATE_FULL_OOMADJ_UPDATES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean newFgsRestrictionLogic() {
        return getValue(Flags.FLAG_NEW_FGS_RESTRICTION_LOGIC, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean oomadjusterCachedAppTiers() {
        return getValue(Flags.FLAG_OOMADJUSTER_CACHED_APP_TIERS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean oomadjusterCorrectnessRewrite() {
        return getValue(Flags.FLAG_OOMADJUSTER_CORRECTNESS_REWRITE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean oomadjusterPrevLaddering() {
        return getValue(Flags.FLAG_OOMADJUSTER_PREV_LADDERING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean perceptibleTasks() {
        return getValue(Flags.FLAG_PERCEPTIBLE_TASKS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean phantomProcessesFix() {
        return getValue(Flags.FLAG_PHANTOM_PROCESSES_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean prototypeAggressiveFreezing() {
        return getValue(Flags.FLAG_PROTOTYPE_AGGRESSIVE_FREEZING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean pushGlobalStateToOomadjuster() {
        return getValue(Flags.FLAG_PUSH_GLOBAL_STATE_TO_OOMADJUSTER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean raiseBoundUiServiceThreshold() {
        return getValue(Flags.FLAG_RAISE_BOUND_UI_SERVICE_THRESHOLD, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean restrictPriorityValues() {
        return getValue(Flags.FLAG_RESTRICT_PRIORITY_VALUES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean serviceBindingOomAdjPolicy() {
        return getValue(Flags.FLAG_SERVICE_BINDING_OOM_ADJ_POLICY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean simplifyProcessTraversal() {
        return getValue(Flags.FLAG_SIMPLIFY_PROCESS_TRAVERSAL, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean skipUnimportantConnections() {
        return getValue(Flags.FLAG_SKIP_UNIMPORTANT_CONNECTIONS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean traceReceiverRegistration() {
        return getValue(Flags.FLAG_TRACE_RECEIVER_REGISTRATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean traceUpdateAppFreezeStateLsp() {
        return getValue(Flags.FLAG_TRACE_UPDATE_APP_FREEZE_STATE_LSP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean unfreezeBindPolicyFix() {
        return getValue(Flags.FLAG_UNFREEZE_BIND_POLICY_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.am.FeatureFlags
    public boolean useCpuTimeCapability() {
        return getValue(Flags.FLAG_USE_CPU_TIME_CAPABILITY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
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
        return Arrays.asList(new String[]{Flags.FLAG_ADD_MODIFY_RAW_OOM_ADJ_SERVICE_LEVEL, Flags.FLAG_APP_START_INFO_ISOLATED_PROCESS, Flags.FLAG_AVOID_NOTE_OP_AT_ENQUEUE, Flags.FLAG_AVOID_REPEATED_BCAST_RE_ENQUEUES, Flags.FLAG_AVOID_RESOLVING_TYPE, Flags.FLAG_BATCHING_OOM_ADJ, Flags.FLAG_BFGS_MANAGED_NETWORK_ACCESS, Flags.FLAG_COLLECT_LOGCAT_ON_RUN_SYNCHRONOUSLY, Flags.FLAG_DEFER_BINDERS_WHEN_PAUSED, Flags.FLAG_DEFER_DISPLAY_EVENTS_WHEN_FROZEN, Flags.FLAG_DEFER_OUTGOING_BROADCASTS, Flags.FLAG_ENABLE_DROPBOX_WATCHDOG_HEADERS, Flags.FLAG_EXPEDITE_ACTIVITY_LAUNCH_ON_COLD_START, Flags.FLAG_FGS_ABUSE_DETECTION, Flags.FLAG_FGS_BOOT_COMPLETED, Flags.FLAG_FGS_DISABLE_SAW, Flags.FLAG_FIX_APPLY_OOMADJ_ORDER, Flags.FLAG_FOLLOW_UP_OOMADJ_UPDATES, Flags.FLAG_LIMIT_PRIORITY_SCOPE, Flags.FLAG_LOG_BROADCAST_PROCESSED_EVENT, Flags.FLAG_LOG_BROADCAST_SENT_EVENT, Flags.FLAG_LOG_EXCESSIVE_BINDER_PROXIES, Flags.FLAG_LOGCAT_LONGER_TIMEOUT, Flags.FLAG_LOWER_SMS_OOM_IMPORTANCE, Flags.FLAG_MIGRATE_FULL_OOMADJ_UPDATES, Flags.FLAG_NEW_FGS_RESTRICTION_LOGIC, Flags.FLAG_OOMADJUSTER_CACHED_APP_TIERS, Flags.FLAG_OOMADJUSTER_CORRECTNESS_REWRITE, Flags.FLAG_OOMADJUSTER_PREV_LADDERING, Flags.FLAG_PERCEPTIBLE_TASKS, Flags.FLAG_PHANTOM_PROCESSES_FIX, Flags.FLAG_PROTOTYPE_AGGRESSIVE_FREEZING, Flags.FLAG_PUSH_GLOBAL_STATE_TO_OOMADJUSTER, Flags.FLAG_RAISE_BOUND_UI_SERVICE_THRESHOLD, Flags.FLAG_RESTRICT_PRIORITY_VALUES, Flags.FLAG_SERVICE_BINDING_OOM_ADJ_POLICY, Flags.FLAG_SIMPLIFY_PROCESS_TRAVERSAL, Flags.FLAG_SKIP_UNIMPORTANT_CONNECTIONS, Flags.FLAG_TRACE_RECEIVER_REGISTRATION, Flags.FLAG_TRACE_UPDATE_APP_FREEZE_STATE_LSP, Flags.FLAG_UNFREEZE_BIND_POLICY_FIX, Flags.FLAG_USE_CPU_TIME_CAPABILITY});
    }
}
