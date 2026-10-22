package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ADD_MODIFY_RAW_OOM_ADJ_SERVICE_LEVEL = "com.android.server.am.add_modify_raw_oom_adj_service_level";
    public static final String FLAG_APP_START_INFO_ISOLATED_PROCESS = "com.android.server.am.app_start_info_isolated_process";
    public static final String FLAG_AVOID_NOTE_OP_AT_ENQUEUE = "com.android.server.am.avoid_note_op_at_enqueue";
    public static final String FLAG_AVOID_REPEATED_BCAST_RE_ENQUEUES = "com.android.server.am.avoid_repeated_bcast_re_enqueues";
    public static final String FLAG_AVOID_RESOLVING_TYPE = "com.android.server.am.avoid_resolving_type";
    public static final String FLAG_BATCHING_OOM_ADJ = "com.android.server.am.batching_oom_adj";
    public static final String FLAG_BFGS_MANAGED_NETWORK_ACCESS = "com.android.server.am.bfgs_managed_network_access";
    public static final String FLAG_COLLECT_LOGCAT_ON_RUN_SYNCHRONOUSLY = "com.android.server.am.collect_logcat_on_run_synchronously";
    public static final String FLAG_DEFER_BINDERS_WHEN_PAUSED = "com.android.server.am.defer_binders_when_paused";
    public static final String FLAG_DEFER_DISPLAY_EVENTS_WHEN_FROZEN = "com.android.server.am.defer_display_events_when_frozen";
    public static final String FLAG_DEFER_OUTGOING_BROADCASTS = "com.android.server.am.defer_outgoing_broadcasts";
    public static final String FLAG_ENABLE_DROPBOX_WATCHDOG_HEADERS = "com.android.server.am.enable_dropbox_watchdog_headers";
    public static final String FLAG_EXPEDITE_ACTIVITY_LAUNCH_ON_COLD_START = "com.android.server.am.expedite_activity_launch_on_cold_start";
    public static final String FLAG_FGS_ABUSE_DETECTION = "com.android.server.am.fgs_abuse_detection";
    public static final String FLAG_FGS_BOOT_COMPLETED = "com.android.server.am.fgs_boot_completed";
    public static final String FLAG_FGS_DISABLE_SAW = "com.android.server.am.fgs_disable_saw";
    public static final String FLAG_FIX_APPLY_OOMADJ_ORDER = "com.android.server.am.fix_apply_oomadj_order";
    public static final String FLAG_FOLLOW_UP_OOMADJ_UPDATES = "com.android.server.am.follow_up_oomadj_updates";
    public static final String FLAG_LIMIT_PRIORITY_SCOPE = "com.android.server.am.limit_priority_scope";
    public static final String FLAG_LOGCAT_LONGER_TIMEOUT = "com.android.server.am.logcat_longer_timeout";
    public static final String FLAG_LOG_BROADCAST_PROCESSED_EVENT = "com.android.server.am.log_broadcast_processed_event";
    public static final String FLAG_LOG_BROADCAST_SENT_EVENT = "com.android.server.am.log_broadcast_sent_event";
    public static final String FLAG_LOG_EXCESSIVE_BINDER_PROXIES = "com.android.server.am.log_excessive_binder_proxies";
    public static final String FLAG_LOWER_SMS_OOM_IMPORTANCE = "com.android.server.am.lower_sms_oom_importance";
    public static final String FLAG_MIGRATE_FULL_OOMADJ_UPDATES = "com.android.server.am.migrate_full_oomadj_updates";
    public static final String FLAG_NEW_FGS_RESTRICTION_LOGIC = "com.android.server.am.new_fgs_restriction_logic";
    public static final String FLAG_OOMADJUSTER_CACHED_APP_TIERS = "com.android.server.am.oomadjuster_cached_app_tiers";
    public static final String FLAG_OOMADJUSTER_CORRECTNESS_REWRITE = "com.android.server.am.oomadjuster_correctness_rewrite";
    public static final String FLAG_OOMADJUSTER_PREV_LADDERING = "com.android.server.am.oomadjuster_prev_laddering";
    public static final String FLAG_PERCEPTIBLE_TASKS = "com.android.server.am.perceptible_tasks";
    public static final String FLAG_PHANTOM_PROCESSES_FIX = "com.android.server.am.phantom_processes_fix";
    public static final String FLAG_PROTOTYPE_AGGRESSIVE_FREEZING = "com.android.server.am.prototype_aggressive_freezing";
    public static final String FLAG_PUSH_GLOBAL_STATE_TO_OOMADJUSTER = "com.android.server.am.push_global_state_to_oomadjuster";
    public static final String FLAG_RAISE_BOUND_UI_SERVICE_THRESHOLD = "com.android.server.am.raise_bound_ui_service_threshold";
    public static final String FLAG_RESTRICT_PRIORITY_VALUES = "com.android.server.am.restrict_priority_values";
    public static final String FLAG_SERVICE_BINDING_OOM_ADJ_POLICY = "com.android.server.am.service_binding_oom_adj_policy";
    public static final String FLAG_SIMPLIFY_PROCESS_TRAVERSAL = "com.android.server.am.simplify_process_traversal";
    public static final String FLAG_SKIP_UNIMPORTANT_CONNECTIONS = "com.android.server.am.skip_unimportant_connections";
    public static final String FLAG_TRACE_RECEIVER_REGISTRATION = "com.android.server.am.trace_receiver_registration";
    public static final String FLAG_TRACE_UPDATE_APP_FREEZE_STATE_LSP = "com.android.server.am.trace_update_app_freeze_state_lsp";
    public static final String FLAG_UNFREEZE_BIND_POLICY_FIX = "com.android.server.am.unfreeze_bind_policy_fix";
    public static final String FLAG_USE_CPU_TIME_CAPABILITY = "com.android.server.am.use_cpu_time_capability";

    public Flags() {
    }

    public static boolean addModifyRawOomAdjServiceLevel() {
        return true;
    }

    public static boolean appStartInfoIsolatedProcess() {
        return true;
    }

    public static boolean avoidNoteOpAtEnqueue() {
        return true;
    }

    public static boolean avoidRepeatedBcastReEnqueues() {
        return true;
    }

    public static boolean avoidResolvingType() {
        return true;
    }

    public static boolean batchingOomAdj() {
        return true;
    }

    public static boolean bfgsManagedNetworkAccess() {
        return false;
    }

    public static boolean collectLogcatOnRunSynchronously() {
        return true;
    }

    public static boolean deferBindersWhenPaused() {
        return true;
    }

    public static boolean deferDisplayEventsWhenFrozen() {
        return true;
    }

    public static boolean deferOutgoingBroadcasts() {
        return false;
    }

    public static boolean enableDropboxWatchdogHeaders() {
        return true;
    }

    public static boolean expediteActivityLaunchOnColdStart() {
        return false;
    }

    public static boolean fgsAbuseDetection() {
        return false;
    }

    public static boolean fgsBootCompleted() {
        return true;
    }

    public static boolean fgsDisableSaw() {
        return true;
    }

    public static boolean fixApplyOomadjOrder() {
        return false;
    }

    public static boolean followUpOomadjUpdates() {
        return true;
    }

    public static boolean limitPriorityScope() {
        return true;
    }

    public static boolean logBroadcastProcessedEvent() {
        return true;
    }

    public static boolean logBroadcastSentEvent() {
        return true;
    }

    public static boolean logExcessiveBinderProxies() {
        return true;
    }

    public static boolean logcatLongerTimeout() {
        return true;
    }

    public static boolean lowerSmsOomImportance() {
        return false;
    }

    public static boolean migrateFullOomadjUpdates() {
        return true;
    }

    public static boolean newFgsRestrictionLogic() {
        return true;
    }

    public static boolean oomadjusterCachedAppTiers() {
        return false;
    }

    public static boolean oomadjusterCorrectnessRewrite() {
        return true;
    }

    public static boolean oomadjusterPrevLaddering() {
        return false;
    }

    public static boolean perceptibleTasks() {
        return false;
    }

    public static boolean phantomProcessesFix() {
        return true;
    }

    public static boolean prototypeAggressiveFreezing() {
        return false;
    }

    public static boolean pushGlobalStateToOomadjuster() {
        return false;
    }

    public static boolean raiseBoundUiServiceThreshold() {
        return true;
    }

    public static boolean restrictPriorityValues() {
        return true;
    }

    public static boolean serviceBindingOomAdjPolicy() {
        return true;
    }

    public static boolean simplifyProcessTraversal() {
        return true;
    }

    public static boolean skipUnimportantConnections() {
        return false;
    }

    public static boolean traceReceiverRegistration() {
        return true;
    }

    public static boolean traceUpdateAppFreezeStateLsp() {
        return true;
    }

    public static boolean unfreezeBindPolicyFix() {
        return true;
    }

    public static boolean useCpuTimeCapability() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
