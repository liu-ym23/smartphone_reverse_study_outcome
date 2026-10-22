package com.android.server.am;

import android.R;
import android.app.ActivityThread;
import android.app.ForegroundServiceTypePolicy;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.KeyValueListParser;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.server.accessibility.AccessibilityManagerService$$ExternalSyntheticLambda57;
import com.android.server.job.controllers.JobStatus;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
final class ActivityManagerConstants extends ContentObserver {
    private static final Uri ACTIVITY_MANAGER_CONSTANTS_URI = null;
    private static final Uri ACTIVITY_STARTS_LOGGING_ENABLED_URI = null;
    public static int BINDER_HEAVY_HITTER_AUTO_SAMPLER_BATCHSIZE = 0;
    public static boolean BINDER_HEAVY_HITTER_AUTO_SAMPLER_ENABLED = false;
    public static float BINDER_HEAVY_HITTER_AUTO_SAMPLER_THRESHOLD = 0.0f;
    public static int BINDER_HEAVY_HITTER_WATCHER_BATCHSIZE = 0;
    public static boolean BINDER_HEAVY_HITTER_WATCHER_ENABLED = false;
    public static float BINDER_HEAVY_HITTER_WATCHER_THRESHOLD = 0.0f;
    static int COMPACTION_DELAY_MS = 0;
    static final long DEFAULT_BACKGROUND_SETTLE_TIME = 30000;
    private static final long DEFAULT_BG_START_TIMEOUT = 15000;
    private static final int DEFAULT_BOOT_TIME_TEMP_ALLOWLIST_DURATION = 20000;
    private static final int DEFAULT_BOUND_SERVICE_CRASH_MAX_RETRY = 16;
    private static final long DEFAULT_BOUND_SERVICE_CRASH_RESTART_DURATION = 1800000;
    private static final String DEFAULT_COMPONENT_ALIAS_OVERRIDES = "";
    private static final long DEFAULT_CONTENT_PROVIDER_RETAIN_TIME = 20000;
    static final long DEFAULT_DATA_SYNC_FGS_TIMEOUT_DURATION = 21600000;
    private static final int DEFAULT_DEFER_BOOT_COMPLETED_BROADCAST = 6;
    private static final boolean DEFAULT_ENABLE_BATCHING_OOM_ADJ = false;
    private static final boolean DEFAULT_ENABLE_COMPONENT_ALIAS = false;
    private static final boolean DEFAULT_ENABLE_EXTRA_SERVICE_RESTART_DELAY_ON_MEM_PRESSURE = true;
    private static final boolean DEFAULT_ENABLE_NEW_OOM_ADJ = false;
    private static final boolean DEFAULT_ENABLE_WAIT_FOR_FINISH_ATTACH_APPLICATION = true;
    private static final long DEFAULT_EXTRA_SERVICE_RESTART_DELAY_ON_CRITICAL_MEM = 30000;
    private static final long DEFAULT_EXTRA_SERVICE_RESTART_DELAY_ON_LOW_MEM = 20000;
    private static final long[] DEFAULT_EXTRA_SERVICE_RESTART_DELAY_ON_MEM_PRESSURE = null;
    private static final long DEFAULT_EXTRA_SERVICE_RESTART_DELAY_ON_MODERATE_MEM = 10000;
    private static final long DEFAULT_EXTRA_SERVICE_RESTART_DELAY_ON_NORMAL_MEM = 0;
    private static final long DEFAULT_FGSERVICE_MIN_REPORT_TIME = 3000;
    private static final long DEFAULT_FGSERVICE_MIN_SHOWN_TIME = 2000;
    private static final long DEFAULT_FGSERVICE_SCREEN_ON_AFTER_TIME = 5000;
    private static final long DEFAULT_FGSERVICE_SCREEN_ON_BEFORE_TIME = 1000;
    private static final boolean DEFAULT_FGS_ALLOW_OPT_OUT = false;
    private static final float DEFAULT_FGS_ATOM_SAMPLE_RATE = 1.0f;
    private static final int DEFAULT_FGS_BOOT_COMPLETED_ALLOWLIST = 1073743640;
    static final long DEFAULT_FGS_CRASH_EXTRA_WAIT_DURATION = 10000;
    private static final float DEFAULT_FGS_START_ALLOWED_LOG_SAMPLE_RATE = 0.25f;
    private static final float DEFAULT_FGS_START_DENIED_LOG_SAMPLE_RATE = 1.0f;
    private static final int DEFAULT_FGS_START_FOREGROUND_TIMEOUT_MS = 10000;
    private static final long DEFAULT_FG_TO_BG_FGS_GRACE_DURATION = 5000;
    private static final long DEFAULT_FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION = 1000;
    private static final boolean DEFAULT_FORCE_BACKGROUND_CHECK_ON_RESTRICTED_APPS = true;
    private static final int DEFAULT_FREEZER_CUTOFF_ADJ = 0;
    private static final long DEFAULT_FULL_PSS_LOWERED_INTERVAL = 300000;
    private static final long DEFAULT_FULL_PSS_MIN_INTERVAL = 1200000;
    private static final long DEFAULT_GC_MIN_INTERVAL = 60000;
    private static final long DEFAULT_GC_TIMEOUT = 5000;
    static final boolean DEFAULT_KILL_BG_RESTRICTED_CACHED_IDLE = false;
    static final long DEFAULT_KILL_BG_RESTRICTED_CACHED_IDLE_SETTLE_TIME_MS = 60000;
    private static final float DEFAULT_LOW_SWAP_THRESHOLD_PERCENT = 0.1f;
    private static final int DEFAULT_MAX_CACHED_PROCESSES = 1024;
    private static final long DEFAULT_MAX_EMPTY_TIME_MILLIS = 3600000000L;
    private static final int DEFAULT_MAX_PHANTOM_PROCESSES = 32;
    private static final long DEFAULT_MAX_PREVIOUS_TIME = 60000;
    static final int DEFAULT_MAX_SERVICE_CONNECTIONS_PER_PROCESS = 3000;
    private static final long DEFAULT_MAX_SERVICE_INACTIVITY = 1800000;
    static final long DEFAULT_MEDIA_PROCESSING_FGS_TIMEOUT_DURATION = 21600000;
    private static final long DEFAULT_MEMORY_INFO_THROTTLE_TIME = 300000;
    private static final long DEFAULT_MIN_ASSOC_LOG_DURATION = 300000;
    private static final int DEFAULT_MIN_CRASH_INTERVAL = 120000;
    private static final long DEFAULT_NETWORK_ACCESS_TIMEOUT_MS = 200;
    private static final long DEFAULT_NO_KILL_CACHED_PROCESSES_POST_BOOT_COMPLETED_DURATION_MILLIS = 600000;
    private static final boolean DEFAULT_NO_KILL_CACHED_PROCESSES_UNTIL_BOOT_COMPLETED = true;
    private static final int DEFAULT_OOMADJ_UPDATE_POLICY = 1;
    private static final int DEFAULT_PENDINGINTENT_WARNING_THRESHOLD = 2000;
    private static final long DEFAULT_POWER_CHECK_INTERVAL = 0;
    private static final int DEFAULT_POWER_CHECK_MAX_CPU_1 = 25;
    private static final int DEFAULT_POWER_CHECK_MAX_CPU_2 = 25;
    private static final int DEFAULT_POWER_CHECK_MAX_CPU_3 = 10;
    private static final int DEFAULT_POWER_CHECK_MAX_CPU_4 = 2;
    private static final boolean DEFAULT_PRIORITIZE_ALARM_BROADCASTS = true;
    private static final boolean DEFAULT_PROACTIVE_KILLS_ENABLED = false;
    private static final int DEFAULT_PROCESS_CRASH_COUNT_LIMIT = 12;
    private static final int DEFAULT_PROCESS_CRASH_COUNT_RESET_INTERVAL = 43200000;
    private static final long DEFAULT_PROCESS_KILL_TIMEOUT_MS = 10000;
    private static final boolean DEFAULT_PROCESS_START_ASYNC = true;
    private static final int DEFAULT_PUSH_MESSAGING_OVER_QUOTA_BEHAVIOR = 1;
    protected static final long DEFAULT_SERVICE_BACKGROUND_TIMEOUT = 0;
    private static final long DEFAULT_SERVICE_BG_ACTIVITY_START_TIMEOUT = 10000;
    private static final long DEFAULT_SERVICE_BIND_ALMOST_PERCEPTIBLE_TIMEOUT_MS = 15000;
    private static final long DEFAULT_SERVICE_MIN_RESTART_TIME_BETWEEN = 10000;
    private static final long DEFAULT_SERVICE_RESET_RUN_DURATION = 60000;
    private static final long DEFAULT_SERVICE_RESTART_DURATION = 1000;
    private static final int DEFAULT_SERVICE_RESTART_DURATION_FACTOR = 4;
    private static final int DEFAULT_SERVICE_START_FOREGROUND_ANR_DELAY_MS = 10000;
    private static final int DEFAULT_SERVICE_START_FOREGROUND_TIMEOUT_MS = 30000;
    protected static final long DEFAULT_SERVICE_TIMEOUT = 0;
    private static final long DEFAULT_SERVICE_USAGE_INTERACTION_TIME_POST_S = 60000;
    private static final long DEFAULT_SERVICE_USAGE_INTERACTION_TIME_PRE_S = 1800000;
    static final long DEFAULT_SHORT_FGS_ANR_EXTRA_WAIT_DURATION = 10000;
    static final long DEFAULT_SHORT_FGS_PROC_STATE_EXTRA_WAIT_DURATION = 5000;
    static final long DEFAULT_SHORT_FGS_TIMEOUT_DURATION = 180000;
    private static final boolean DEFAULT_SYSTEM_EXEMPT_POWER_RESTRICTIONS_ENABLED = true;
    private static final long DEFAULT_TIERED_CACHED_ADJ_DECAY_TIME = 60000;
    private static final long DEFAULT_TOP_TO_ALMOST_PERCEPTIBLE_GRACE_DURATION = 15000;
    private static final long DEFAULT_TOP_TO_FGS_GRACE_DURATION = 15000;
    private static final long DEFAULT_USAGE_STATS_INTERACTION_INTERVAL_POST_S = 600000;
    private static final long DEFAULT_USAGE_STATS_INTERACTION_INTERVAL_PRE_S = 7200000;
    private static final boolean DEFAULT_USE_TIERED_CACHED_ADJ = false;
    private static final long DEFAULT_VISIBLE_TO_INVISIBLE_UIJ_SCHEDULE_GRACE_DURATION = 5000;
    static int EMPTY_APP_PERCENT = 0;
    private static final Uri ENABLE_AUTOMATIC_SYSTEM_SERVER_HEAP_DUMPS_URI = null;
    private static final Uri FORCE_ENABLE_PSS_PROFILING_URI = null;
    private static final Uri FOREGROUND_SERVICE_STARTS_LOGGING_ENABLED_URI = null;
    static final String KEY_BACKGROUND_SETTLE_TIME = "background_settle_time";
    static final String KEY_BG_START_TIMEOUT = "service_bg_start_timeout";
    private static final String KEY_BINDER_HEAVY_HITTER_AUTO_SAMPLER_BATCHSIZE = "binder_heavy_hitter_auto_sampler_batchsize";
    private static final String KEY_BINDER_HEAVY_HITTER_AUTO_SAMPLER_ENABLED = "binder_heavy_hitter_auto_sampler_enabled";
    private static final String KEY_BINDER_HEAVY_HITTER_AUTO_SAMPLER_THRESHOLD = "binder_heavy_hitter_auto_sampler_threshold";
    private static final String KEY_BINDER_HEAVY_HITTER_WATCHER_BATCHSIZE = "binder_heavy_hitter_watcher_batchsize";
    private static final String KEY_BINDER_HEAVY_HITTER_WATCHER_ENABLED = "binder_heavy_hitter_watcher_enabled";
    private static final String KEY_BINDER_HEAVY_HITTER_WATCHER_THRESHOLD = "binder_heavy_hitter_watcher_threshold";
    static final String KEY_BOOT_TIME_TEMP_ALLOWLIST_DURATION = "boot_time_temp_allowlist_duration";
    static final String KEY_BOUND_SERVICE_CRASH_MAX_RETRY = "service_crash_max_retry";
    static final String KEY_BOUND_SERVICE_CRASH_RESTART_DURATION = "service_crash_restart_duration";
    static final String KEY_COMPONENT_ALIAS_OVERRIDES = "component_alias_overrides";
    private static final String KEY_CONTENT_PROVIDER_RETAIN_TIME = "content_provider_retain_time";
    private static final String KEY_DATA_SYNC_FGS_TIMEOUT_DURATION = "data_sync_fgs_timeout_duration";
    private static final String KEY_DEFAULT_BACKGROUND_ACTIVITY_STARTS_ENABLED = "default_background_activity_starts_enabled";
    private static final String KEY_DEFAULT_BACKGROUND_FGS_STARTS_RESTRICTION_ENABLED = "default_background_fgs_starts_restriction_enabled";
    private static final String KEY_DEFAULT_FGS_STARTS_RESTRICTION_CHECK_CALLER_TARGET_SDK = "default_fgs_starts_restriction_check_caller_target_sdk";
    private static final String KEY_DEFAULT_FGS_STARTS_RESTRICTION_ENABLED = "default_fgs_starts_restriction_enabled";
    private static final String KEY_DEFAULT_FGS_STARTS_RESTRICTION_NOTIFICATION_ENABLED = "default_fgs_starts_restriction_notification_enabled";
    private static final String KEY_DEFERRED_FGS_NOTIFICATIONS_API_GATED = "deferred_fgs_notifications_api_gated";
    private static final String KEY_DEFERRED_FGS_NOTIFICATIONS_ENABLED = "deferred_fgs_notifications_enabled";
    private static final String KEY_DEFERRED_FGS_NOTIFICATION_EXCLUSION_TIME = "deferred_fgs_notification_exclusion_time";
    private static final String KEY_DEFERRED_FGS_NOTIFICATION_EXCLUSION_TIME_FOR_SHORT = "deferred_fgs_notification_exclusion_time_for_short";
    private static final String KEY_DEFERRED_FGS_NOTIFICATION_INTERVAL = "deferred_fgs_notification_interval";
    private static final String KEY_DEFERRED_FGS_NOTIFICATION_INTERVAL_FOR_SHORT = "deferred_fgs_notification_interval_for_short";
    private static final String KEY_DEFER_BOOT_COMPLETED_BROADCAST = "defer_boot_completed_broadcast";
    static final String KEY_DISABLE_APP_PROFILER_PSS_PROFILING = "disable_app_profiler_pss_profiling";
    static final String KEY_ENABLE_BATCHING_OOM_ADJ = "enable_batching_oom_adj";
    static final String KEY_ENABLE_COMPONENT_ALIAS = "enable_experimental_component_alias";
    static final String KEY_ENABLE_EXTRA_SERVICE_RESTART_DELAY_ON_MEM_PRESSURE = "enable_extra_delay_svc_restart_mem_pressure";
    static final String KEY_ENABLE_NEW_OOMADJ = "enable_new_oom_adj";
    private static final String KEY_ENABLE_WAIT_FOR_FINISH_ATTACH_APPLICATION = "enable_wait_for_finish_attach_application";
    static final String KEY_EXTRA_SERVICE_RESTART_DELAY_ON_MEM_PRESSURE = "extra_delay_svc_restart_mem_pressure";
    private static final String KEY_FGSERVICE_MIN_REPORT_TIME = "fgservice_min_report_time";
    private static final String KEY_FGSERVICE_MIN_SHOWN_TIME = "fgservice_min_shown_time";
    private static final String KEY_FGSERVICE_SCREEN_ON_AFTER_TIME = "fgservice_screen_on_after_time";
    private static final String KEY_FGSERVICE_SCREEN_ON_BEFORE_TIME = "fgservice_screen_on_before_time";
    static final String KEY_FGS_ALLOW_OPT_OUT = "fgs_allow_opt_out";
    static final String KEY_FGS_ATOM_SAMPLE_RATE = "fgs_atom_sample_rate";
    private static final String KEY_FGS_BOOT_COMPLETED_ALLOWLIST = "fgs_boot_completed_allowlist";
    private static final String KEY_FGS_CRASH_EXTRA_WAIT_DURATION = "fgs_crash_extra_wait_duration";
    static final String KEY_FGS_START_ALLOWED_LOG_SAMPLE_RATE = "fgs_start_allowed_log_sample_rate";
    static final String KEY_FGS_START_DENIED_LOG_SAMPLE_RATE = "fgs_start_denied_log_sample_rate";
    static final String KEY_FGS_START_FOREGROUND_TIMEOUT = "fgs_start_foreground_timeout";
    static final String KEY_FG_TO_BG_FGS_GRACE_DURATION = "fg_to_bg_fgs_grace_duration";
    static final String KEY_FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION = "follow_up_oomadj_update_wait_duration";
    private static final String KEY_FORCE_BACKGROUND_CHECK_ON_RESTRICTED_APPS = "force_bg_check_on_restricted";
    static final String KEY_FREEZER_CUTOFF_ADJ = "freezer_cutoff_adj";
    private static final String KEY_FULL_PSS_LOWERED_INTERVAL = "full_pss_lowered_interval";
    private static final String KEY_FULL_PSS_MIN_INTERVAL = "full_pss_min_interval";
    private static final String KEY_GC_MIN_INTERVAL = "gc_min_interval";
    private static final String KEY_GC_TIMEOUT = "gc_timeout";
    private static final String KEY_IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES = "imperceptible_kill_exempt_packages";
    private static final String KEY_IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES = "imperceptible_kill_exempt_proc_states";
    static final String KEY_KILL_BG_RESTRICTED_CACHED_IDLE = "kill_bg_restricted_cached_idle";
    static final String KEY_KILL_BG_RESTRICTED_CACHED_IDLE_SETTLE_TIME = "kill_bg_restricted_cached_idle_settle_time";
    private static final String KEY_LOW_SWAP_THRESHOLD_PERCENT = "low_swap_threshold_percent";
    private static final String KEY_MAX_CACHED_PROCESSES = "max_cached_processes";
    private static final String KEY_MAX_EMPTY_TIME_MILLIS = "max_empty_time_millis";
    private static final String KEY_MAX_PHANTOM_PROCESSES = "max_phantom_processes";
    static final String KEY_MAX_PREVIOUS_TIME = "max_previous_time";
    private static final String KEY_MAX_SERVICE_CONNECTIONS_PER_PROCESS = "max_service_connections_per_process";
    static final String KEY_MAX_SERVICE_INACTIVITY = "service_max_inactivity";
    private static final String KEY_MEDIA_PROCESSING_FGS_TIMEOUT_DURATION = "media_processing_fgs_timeout_duration";
    static final String KEY_MEMORY_INFO_THROTTLE_TIME = "memory_info_throttle_time";
    private static final String KEY_MIN_ASSOC_LOG_DURATION = "min_assoc_log_duration";
    static final String KEY_MIN_CRASH_INTERVAL = "min_crash_interval";
    static final String KEY_NETWORK_ACCESS_TIMEOUT_MS = "network_access_timeout_ms";
    private static final String KEY_NO_KILL_CACHED_PROCESSES_POST_BOOT_COMPLETED_DURATION_MILLIS = "no_kill_cached_processes_post_boot_completed_duration_millis";
    private static final String KEY_NO_KILL_CACHED_PROCESSES_UNTIL_BOOT_COMPLETED = "no_kill_cached_processes_until_boot_completed";
    private static final String KEY_OOMADJ_UPDATE_POLICY = "oomadj_update_policy";
    static final String KEY_PENDINGINTENT_WARNING_THRESHOLD = "pendingintent_warning_threshold";
    private static final String KEY_POWER_CHECK_INTERVAL = "power_check_interval";
    private static final String KEY_POWER_CHECK_MAX_CPU_1 = "power_check_max_cpu_1";
    private static final String KEY_POWER_CHECK_MAX_CPU_2 = "power_check_max_cpu_2";
    private static final String KEY_POWER_CHECK_MAX_CPU_3 = "power_check_max_cpu_3";
    private static final String KEY_POWER_CHECK_MAX_CPU_4 = "power_check_max_cpu_4";
    private static final String KEY_PRIORITIZE_ALARM_BROADCASTS = "prioritize_alarm_broadcasts";
    private static final String KEY_PROACTIVE_KILLS_ENABLED = "proactive_kills_enabled";
    static final String KEY_PROCESS_CRASH_COUNT_LIMIT = "process_crash_count_limit";
    static final String KEY_PROCESS_CRASH_COUNT_RESET_INTERVAL = "process_crash_count_reset_interval";
    private static final String KEY_PROCESS_KILL_TIMEOUT = "process_kill_timeout";
    static final String KEY_PROCESS_START_ASYNC = "process_start_async";
    private static final String KEY_PROC_STATE_DEBUG_UIDS = "proc_state_debug_uids";
    static final String KEY_PSS_TO_RSS_THRESHOLD_MODIFIER = "pss_to_rss_threshold_modifier";
    private static final String KEY_PUSH_MESSAGING_OVER_QUOTA_BEHAVIOR = "push_messaging_over_quota_behavior";
    static final String KEY_SERVICE_BG_ACTIVITY_START_TIMEOUT = "service_bg_activity_start_timeout";
    private static final String KEY_SERVICE_BIND_ALMOST_PERCEPTIBLE_TIMEOUT_MS = "service_bind_almost_perceptible_timeout_ms";
    static final String KEY_SERVICE_MIN_RESTART_TIME_BETWEEN = "service_min_restart_time_between";
    static final String KEY_SERVICE_RESET_RUN_DURATION = "service_reset_run_duration";
    static final String KEY_SERVICE_RESTART_DURATION = "service_restart_duration";
    static final String KEY_SERVICE_RESTART_DURATION_FACTOR = "service_restart_duration_factor";
    private static final String KEY_SERVICE_START_FOREGROUND_ANR_DELAY_MS = "service_start_foreground_anr_delay_ms";
    private static final String KEY_SERVICE_START_FOREGROUND_TIMEOUT_MS = "service_start_foreground_timeout_ms";
    private static final String KEY_SERVICE_USAGE_INTERACTION_TIME_POST_S = "service_usage_interaction_time_post_s";
    private static final String KEY_SERVICE_USAGE_INTERACTION_TIME_PRE_S = "service_usage_interaction_time";
    private static final String KEY_SHORT_FGS_ANR_EXTRA_WAIT_DURATION = "short_fgs_anr_extra_wait_duration";
    private static final String KEY_SHORT_FGS_PROC_STATE_EXTRA_WAIT_DURATION = "short_fgs_proc_state_extra_wait_duration";
    private static final String KEY_SHORT_FGS_TIMEOUT_DURATION = "short_fgs_timeout_duration";
    private static final String KEY_SYSTEM_EXEMPT_POWER_RESTRICTIONS_ENABLED = "system_exempt_power_restrictions_enabled";
    static final String KEY_TIERED_CACHED_ADJ_DECAY_TIME = "tiered_cached_adj_decay_time";
    static final String KEY_TIERED_CACHED_ADJ_UI_TIER_SIZE = "tiered_cached_adj_ui_tier_size";
    static final String KEY_TOP_TO_ALMOST_PERCEPTIBLE_GRACE_DURATION = "top_to_almost_perceptible_grace_duration";
    static final String KEY_TOP_TO_FGS_GRACE_DURATION = "top_to_fgs_grace_duration";
    private static final String KEY_USAGE_STATS_INTERACTION_INTERVAL_POST_S = "usage_stats_interaction_interval_post_s";
    private static final String KEY_USAGE_STATS_INTERACTION_INTERVAL_PRE_S = "usage_stats_interaction_interval";
    static final String KEY_USE_TIERED_CACHED_ADJ = "use_tiered_cached_adj";
    static final String KEY_VISIBLE_TO_INVISIBLE_UIJ_SCHEDULE_GRACE_DURATION = "vis_to_invis_uij_schedule_grace_duration";
    public static float LOW_SWAP_THRESHOLD_PERCENT = 0.0f;
    public static long MAX_PREVIOUS_TIME = 0;
    public static long MIN_ASSOC_LOG_DURATION = 0;
    private static final long MIN_AUTOMATIC_HEAP_DUMP_PSS_THRESHOLD_BYTES = 102400;
    public static int MIN_CRASH_INTERVAL = 0;
    private static final int OOMADJ_UPDATE_POLICY_QUICK = 1;
    private static final int OOMADJ_UPDATE_POLICY_SLOW = 0;
    public static boolean PROACTIVE_KILLS_ENABLED = false;
    static int PROCESS_CRASH_COUNT_LIMIT = 0;
    static long PROCESS_CRASH_COUNT_RESET_INTERVAL = 0;
    private static final String TAG = "ActivityManagerConstants";
    private static final int TIERED_CACHED_ADJ_MAX_UI_TIER_SIZE = 50;
    static int TRIM_CACHE_PERCENT;
    static int TRIM_EMPTY_PERCENT;
    static long TRIM_ENABLE_MEMORY;
    static boolean USE_TRIM_SETTINGS;
    public static BoostFramework mPerf;
    public boolean APP_PROFILER_PSS_PROFILING_DISABLED;
    public long BACKGROUND_SETTLE_TIME;
    public long BG_START_TIMEOUT;
    public long BOUND_SERVICE_CRASH_RESTART_DURATION;
    public long BOUND_SERVICE_MAX_CRASH_RETRY;
    long CONTENT_PROVIDER_RETAIN_TIME;
    public int CUR_MAX_CACHED_PROCESSES;
    public int CUR_MAX_EMPTY_PROCESSES;
    public int CUR_TRIM_CACHED_PROCESSES;
    public int CUR_TRIM_EMPTY_PROCESSES;
    public boolean ENABLE_BATCHING_OOM_ADJ;
    public boolean ENABLE_NEW_OOMADJ;
    public long FGSERVICE_MIN_REPORT_TIME;
    public long FGSERVICE_MIN_SHOWN_TIME;
    public long FGSERVICE_SCREEN_ON_AFTER_TIME;
    public long FGSERVICE_SCREEN_ON_BEFORE_TIME;
    public int FGS_BOOT_COMPLETED_ALLOWLIST;
    public boolean FLAG_PROCESS_START_ASYNC;
    public long FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION;
    boolean FORCE_BACKGROUND_CHECK_ON_RESTRICTED_APPS;
    public int FREEZER_CUTOFF_ADJ;
    long FULL_PSS_LOWERED_INTERVAL;
    long FULL_PSS_MIN_INTERVAL;
    long GC_MIN_INTERVAL;
    long GC_TIMEOUT;
    public ArraySet<String> IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES;
    public ArraySet<Integer> IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES;
    public final ArraySet<ComponentName> KEEP_WARMING_SERVICES;
    public int MAX_CACHED_PROCESSES;
    public int MAX_PHANTOM_PROCESSES;
    public long MAX_SERVICE_INACTIVITY;
    public long MEMORY_INFO_THROTTLE_TIME;
    public boolean OOMADJ_UPDATE_QUICK;
    public int PENDINGINTENT_WARNING_THRESHOLD;
    long POWER_CHECK_INTERVAL;
    int POWER_CHECK_MAX_CPU_1;
    int POWER_CHECK_MAX_CPU_2;
    int POWER_CHECK_MAX_CPU_3;
    int POWER_CHECK_MAX_CPU_4;
    public float PSS_TO_RSS_THRESHOLD_MODIFIER;
    long SERVICE_BACKGROUND_TIMEOUT;
    public long SERVICE_BG_ACTIVITY_START_TIMEOUT;
    public long SERVICE_MIN_RESTART_TIME_BETWEEN;
    public long SERVICE_RESET_RUN_DURATION;
    public long SERVICE_RESTART_DURATION;
    public int SERVICE_RESTART_DURATION_FACTOR;
    long SERVICE_TIMEOUT;
    long SERVICE_USAGE_INTERACTION_TIME_POST_S;
    long SERVICE_USAGE_INTERACTION_TIME_PRE_S;
    public long TIERED_CACHED_ADJ_DECAY_TIME;
    public int TIERED_CACHED_ADJ_UI_TIER_SIZE;
    public long TOP_TO_ALMOST_PERCEPTIBLE_GRACE_DURATION;
    public volatile long TOP_TO_FGS_GRACE_DURATION;
    long USAGE_STATS_INTERACTION_INTERVAL_POST_S;
    long USAGE_STATS_INTERACTION_INTERVAL_PRE_S;
    public boolean USE_TIERED_CACHED_ADJ;
    volatile long mBootTimeTempAllowlistDuration;
    volatile String mComponentAliasOverrides;
    private final int mCustomizedMaxCachedProcesses;
    public volatile long mDataSyncFgsTimeoutDuration;
    private final int mDefaultBinderHeavyHitterAutoSamplerBatchSize;
    private final boolean mDefaultBinderHeavyHitterAutoSamplerEnabled;
    private final float mDefaultBinderHeavyHitterAutoSamplerThreshold;
    private final int mDefaultBinderHeavyHitterWatcherBatchSize;
    private final boolean mDefaultBinderHeavyHitterWatcherEnabled;
    private final float mDefaultBinderHeavyHitterWatcherThreshold;
    private final boolean mDefaultDisableAppProfilerPssProfiling;
    private List<String> mDefaultImperceptibleKillExemptPackages;
    private List<Integer> mDefaultImperceptibleKillExemptProcStates;
    private final float mDefaultPssToRssThresholdModifier;
    private final int mDefaultTieredCachedAdjUiTierSize;
    volatile int mDeferBootCompletedBroadcast;
    volatile boolean mEnableComponentAlias;
    boolean mEnableExtraServiceRestartDelayOnMemPressure;
    volatile boolean mEnableProcStateStacktrace;
    public volatile boolean mEnableWaitForFinishAttachApplication;
    long[] mExtraServiceRestartDelayOnMemPressure;
    volatile long mFgToBgFgsGraceDuration;
    volatile boolean mFgsAllowOptOut;
    volatile float mFgsAtomSampleRate;
    public volatile long mFgsCrashExtraWaitDuration;
    volatile long mFgsNotificationDeferralExclusionTime;
    volatile long mFgsNotificationDeferralExclusionTimeForShort;
    volatile long mFgsNotificationDeferralInterval;
    volatile long mFgsNotificationDeferralIntervalForShort;
    volatile float mFgsStartAllowedLogSampleRate;
    volatile float mFgsStartDeniedLogSampleRate;
    volatile long mFgsStartForegroundTimeoutMs;
    volatile boolean mFgsStartRestrictionCheckCallerTargetSdk;
    volatile boolean mFgsStartRestrictionNotificationEnabled;
    volatile boolean mFlagActivityStartsLoggingEnabled;
    volatile boolean mFlagBackgroundActivityStartsEnabled;
    volatile boolean mFlagBackgroundFgsStartRestrictionEnabled;
    volatile boolean mFlagFgsNotificationDeferralApiGated;
    volatile boolean mFlagFgsNotificationDeferralEnabled;
    volatile boolean mFlagFgsStartRestrictionEnabled;
    volatile boolean mFlagForegroundServiceStartsLoggingEnabled;
    volatile boolean mFlagSystemExemptPowerRestrictionsEnabled;
    volatile boolean mForceEnablePssProfiling;
    volatile boolean mKillBgRestrictedAndCachedIdle;
    volatile long mKillBgRestrictedAndCachedIdleSettleTimeMs;
    volatile long mMaxEmptyTimeMillis;
    volatile int mMaxServiceConnectionsPerProcess;
    public volatile long mMediaProcessingFgsTimeoutDuration;
    volatile long mNetworkAccessTimeoutMs;
    volatile long mNoKillCachedProcessesPostBootCompletedDurationMillis;
    volatile boolean mNoKillCachedProcessesUntilBootCompleted;
    private final DeviceConfig.OnPropertiesChangedListener mOnDeviceConfigChangedForComponentAliasListener;
    private final DeviceConfig.OnPropertiesChangedListener mOnDeviceConfigChangedListener;
    private int mOverrideMaxCachedProcesses;
    private final KeyValueListParser mParser;
    volatile boolean mPrioritizeAlarmBroadcasts;
    volatile int mProcStateDebugSetProcStateDelay;
    volatile int mProcStateDebugSetUidStateDelay;
    volatile SparseBooleanArray mProcStateDebugUids;
    volatile long mProcessKillTimeoutMs;
    volatile int mPushMessagingOverQuotaBehavior;
    private ContentResolver mResolver;
    private final ActivityManagerService mService;
    volatile long mServiceBindAlmostPerceptibleTimeoutMs;
    volatile int mServiceStartForegroundAnrDelayMs;
    volatile int mServiceStartForegroundTimeoutMs;
    public volatile long mShortFgsAnrExtraWaitDuration;
    public volatile long mShortFgsProcStateExtraWaitDuration;
    public volatile long mShortFgsTimeoutDuration;
    private final boolean mSystemServerAutomaticHeapDumpEnabled;
    private final String mSystemServerAutomaticHeapDumpPackageName;
    private long mSystemServerAutomaticHeapDumpPssThresholdBytes;
    volatile long mVisibleToInvisibleUijScheduleGraceDurationMs;

    /* JADX INFO: renamed from: $r8$lambda$mD6niBFtKBeU-NJaPeAdcFXEbJs, reason: not valid java name */
    public static /* synthetic */ void m1099$r8$lambda$mD6niBFtKBeUNJaPeAdcFXEbJs(ActivityManagerConstants r0, String r1) {
        r0.lambda$updateImperceptibleKillExemptions$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBackgroundActivityStarts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1100$$Nest$mupdateBackgroundActivityStarts(ActivityManagerConstants r0) {
        r0.updateBackgroundActivityStarts();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBackgroundFgsStartsRestriction, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1101$$Nest$mupdateBackgroundFgsStartsRestriction(ActivityManagerConstants r0) {
        r0.updateBackgroundFgsStartsRestriction();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBinderHeavyHitterWatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1102$$Nest$mupdateBinderHeavyHitterWatcher(ActivityManagerConstants r0) {
        r0.updateBinderHeavyHitterWatcher();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBootTimeTempAllowListDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1103$$Nest$mupdateBootTimeTempAllowListDuration(ActivityManagerConstants r0) {
        r0.updateBootTimeTempAllowListDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateComponentAliases, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1104$$Nest$mupdateComponentAliases(ActivityManagerConstants r0) {
        r0.updateComponentAliases();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDataSyncFgsTimeoutDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1105$$Nest$mupdateDataSyncFgsTimeoutDuration(ActivityManagerConstants r0) {
        r0.updateDataSyncFgsTimeoutDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDeferBootCompletedBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1106$$Nest$mupdateDeferBootCompletedBroadcast(ActivityManagerConstants r0) {
        r0.updateDeferBootCompletedBroadcast();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDisableAppProfilerPssProfiling, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1107$$Nest$mupdateDisableAppProfilerPssProfiling(ActivityManagerConstants r0) {
        r0.updateDisableAppProfilerPssProfiling();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateEnableExtraServiceRestartDelayOnMemPressure, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1108$$Nest$mupdateEnableExtraServiceRestartDelayOnMemPressure(ActivityManagerConstants r0) {
        r0.updateEnableExtraServiceRestartDelayOnMemPressure();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateEnableWaitForFinishAttachApplication, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1109$$Nest$mupdateEnableWaitForFinishAttachApplication(ActivityManagerConstants r0) {
        r0.updateEnableWaitForFinishAttachApplication();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateExtraServiceRestartDelayOnMemPressure, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1110$$Nest$mupdateExtraServiceRestartDelayOnMemPressure(ActivityManagerConstants r0) {
        r0.updateExtraServiceRestartDelayOnMemPressure();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFGSPermissionEnforcementFlagsIfNecessary, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1111$$Nest$mupdateFGSPermissionEnforcementFlagsIfNecessary(ActivityManagerConstants r0, String r1) {
        r0.updateFGSPermissionEnforcementFlagsIfNecessary(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgToBgFgsGraceDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1112$$Nest$mupdateFgToBgFgsGraceDuration(ActivityManagerConstants r0) {
        r0.updateFgToBgFgsGraceDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsAllowOptOut, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1113$$Nest$mupdateFgsAllowOptOut(ActivityManagerConstants r0) {
        r0.updateFgsAllowOptOut();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsAtomSamplePercent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1114$$Nest$mupdateFgsAtomSamplePercent(ActivityManagerConstants r0) {
        r0.updateFgsAtomSamplePercent();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsCrashExtraWaitDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1115$$Nest$mupdateFgsCrashExtraWaitDuration(ActivityManagerConstants r0) {
        r0.updateFgsCrashExtraWaitDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsNotificationDeferralApiGated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1116$$Nest$mupdateFgsNotificationDeferralApiGated(ActivityManagerConstants r0) {
        r0.updateFgsNotificationDeferralApiGated();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsNotificationDeferralEnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1117$$Nest$mupdateFgsNotificationDeferralEnable(ActivityManagerConstants r0) {
        r0.updateFgsNotificationDeferralEnable();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsNotificationDeferralExclusionTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1118$$Nest$mupdateFgsNotificationDeferralExclusionTime(ActivityManagerConstants r0) {
        r0.updateFgsNotificationDeferralExclusionTime();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsNotificationDeferralExclusionTimeForShort, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1119$$Nest$mupdateFgsNotificationDeferralExclusionTimeForShort(ActivityManagerConstants r0) {
        r0.updateFgsNotificationDeferralExclusionTimeForShort();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsNotificationDeferralInterval, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1120$$Nest$mupdateFgsNotificationDeferralInterval(ActivityManagerConstants r0) {
        r0.updateFgsNotificationDeferralInterval();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsNotificationDeferralIntervalForShort, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1121$$Nest$mupdateFgsNotificationDeferralIntervalForShort(ActivityManagerConstants r0) {
        r0.updateFgsNotificationDeferralIntervalForShort();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsStartAllowedLogSamplePercent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1122$$Nest$mupdateFgsStartAllowedLogSamplePercent(ActivityManagerConstants r0) {
        r0.updateFgsStartAllowedLogSamplePercent();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsStartDeniedLogSamplePercent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1123$$Nest$mupdateFgsStartDeniedLogSamplePercent(ActivityManagerConstants r0) {
        r0.updateFgsStartDeniedLogSamplePercent();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsStartForegroundTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1124$$Nest$mupdateFgsStartForegroundTimeout(ActivityManagerConstants r0) {
        r0.updateFgsStartForegroundTimeout();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsStartsRestriction, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1125$$Nest$mupdateFgsStartsRestriction(ActivityManagerConstants r0) {
        r0.updateFgsStartsRestriction();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsStartsRestrictionCheckCallerTargetSdk, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1126$$Nest$mupdateFgsStartsRestrictionCheckCallerTargetSdk(ActivityManagerConstants r0) {
        r0.updateFgsStartsRestrictionCheckCallerTargetSdk();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFgsStartsRestrictionNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1127$$Nest$mupdateFgsStartsRestrictionNotification(ActivityManagerConstants r0) {
        r0.updateFgsStartsRestrictionNotification();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFollowUpOomAdjUpdateWaitDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1128$$Nest$mupdateFollowUpOomAdjUpdateWaitDuration(ActivityManagerConstants r0) {
        r0.updateFollowUpOomAdjUpdateWaitDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateForceRestrictedBackgroundCheck, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1129$$Nest$mupdateForceRestrictedBackgroundCheck(ActivityManagerConstants r0) {
        r0.updateForceRestrictedBackgroundCheck();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateImperceptibleKillExemptions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1130$$Nest$mupdateImperceptibleKillExemptions(ActivityManagerConstants r0) {
        r0.updateImperceptibleKillExemptions();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateKillBgRestrictedCachedIdle, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1131$$Nest$mupdateKillBgRestrictedCachedIdle(ActivityManagerConstants r0) {
        r0.updateKillBgRestrictedCachedIdle();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateKillBgRestrictedCachedIdleSettleTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1132$$Nest$mupdateKillBgRestrictedCachedIdleSettleTime(ActivityManagerConstants r0) {
        r0.updateKillBgRestrictedCachedIdleSettleTime();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateLowSwapThresholdPercent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1133$$Nest$mupdateLowSwapThresholdPercent(ActivityManagerConstants r0) {
        r0.updateLowSwapThresholdPercent();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMaxCachedProcesses, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1134$$Nest$mupdateMaxCachedProcesses(ActivityManagerConstants r0) {
        r0.updateMaxCachedProcesses();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMaxEmptyTimeMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1135$$Nest$mupdateMaxEmptyTimeMillis(ActivityManagerConstants r0) {
        r0.updateMaxEmptyTimeMillis();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMaxPhantomProcesses, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1136$$Nest$mupdateMaxPhantomProcesses(ActivityManagerConstants r0) {
        r0.updateMaxPhantomProcesses();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMaxPreviousTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1137$$Nest$mupdateMaxPreviousTime(ActivityManagerConstants r0) {
        r0.updateMaxPreviousTime();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMaxServiceConnectionsPerProcess, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1138$$Nest$mupdateMaxServiceConnectionsPerProcess(ActivityManagerConstants r0) {
        r0.updateMaxServiceConnectionsPerProcess();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMediaProcessingFgsTimeoutDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1139$$Nest$mupdateMediaProcessingFgsTimeoutDuration(ActivityManagerConstants r0) {
        r0.updateMediaProcessingFgsTimeoutDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMinAssocLogDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1140$$Nest$mupdateMinAssocLogDuration(ActivityManagerConstants r0) {
        r0.updateMinAssocLogDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNetworkAccessTimeoutMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1141$$Nest$mupdateNetworkAccessTimeoutMs(ActivityManagerConstants r0) {
        r0.updateNetworkAccessTimeoutMs();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNoKillCachedProcessesPostBootCompletedDurationMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1142x837448ae(ActivityManagerConstants r0) {
        r0.updateNoKillCachedProcessesPostBootCompletedDurationMillis();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNoKillCachedProcessesUntilBootCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1143$$Nest$mupdateNoKillCachedProcessesUntilBootCompleted(ActivityManagerConstants r0) {
        r0.updateNoKillCachedProcessesUntilBootCompleted();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateOomAdjUpdatePolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1144$$Nest$mupdateOomAdjUpdatePolicy(ActivityManagerConstants r0) {
        r0.updateOomAdjUpdatePolicy();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePrioritizeAlarmBroadcasts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1145$$Nest$mupdatePrioritizeAlarmBroadcasts(ActivityManagerConstants r0) {
        r0.updatePrioritizeAlarmBroadcasts();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateProactiveKillsEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1146$$Nest$mupdateProactiveKillsEnabled(ActivityManagerConstants r0) {
        r0.updateProactiveKillsEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateProcStateDebugUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1147$$Nest$mupdateProcStateDebugUids(ActivityManagerConstants r0) {
        r0.updateProcStateDebugUids();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateProcessKillTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1148$$Nest$mupdateProcessKillTimeout(ActivityManagerConstants r0) {
        r0.updateProcessKillTimeout();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePssToRssThresholdModifier, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1149$$Nest$mupdatePssToRssThresholdModifier(ActivityManagerConstants r0) {
        r0.updatePssToRssThresholdModifier();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePushMessagingOverQuotaBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1150$$Nest$mupdatePushMessagingOverQuotaBehavior(ActivityManagerConstants r0) {
        r0.updatePushMessagingOverQuotaBehavior();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateServiceBindAlmostPerceptibleTimeoutMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1151$$Nest$mupdateServiceBindAlmostPerceptibleTimeoutMs(ActivityManagerConstants r0) {
        r0.updateServiceBindAlmostPerceptibleTimeoutMs();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateServiceStartForegroundAnrDealyMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1152$$Nest$mupdateServiceStartForegroundAnrDealyMs(ActivityManagerConstants r0) {
        r0.updateServiceStartForegroundAnrDealyMs();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateServiceStartForegroundTimeoutMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1153$$Nest$mupdateServiceStartForegroundTimeoutMs(ActivityManagerConstants r0) {
        r0.updateServiceStartForegroundTimeoutMs();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateShortFgsAnrExtraWaitDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1154$$Nest$mupdateShortFgsAnrExtraWaitDuration(ActivityManagerConstants r0) {
        r0.updateShortFgsAnrExtraWaitDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateShortFgsProcStateExtraWaitDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1155$$Nest$mupdateShortFgsProcStateExtraWaitDuration(ActivityManagerConstants r0) {
        r0.updateShortFgsProcStateExtraWaitDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateShortFgsTimeoutDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1156$$Nest$mupdateShortFgsTimeoutDuration(ActivityManagerConstants r0) {
        r0.updateShortFgsTimeoutDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSystemExemptPowerRestrictionsEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1157$$Nest$mupdateSystemExemptPowerRestrictionsEnabled(ActivityManagerConstants r0) {
        r0.updateSystemExemptPowerRestrictionsEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateTopToFgsGraceDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1158$$Nest$mupdateTopToFgsGraceDuration(ActivityManagerConstants r0) {
        r0.updateTopToFgsGraceDuration();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateUseTieredCachedAdj, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1159$$Nest$mupdateUseTieredCachedAdj(ActivityManagerConstants r0) {
        r0.updateUseTieredCachedAdj();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEFAULT_FREEZER_CUTOFF_ADJ, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1160$$Nest$sfgetDEFAULT_FREEZER_CUTOFF_ADJ() {
        return DEFAULT_FREEZER_CUTOFF_ADJ;
    }

    static {
        if (ActivityManagerDebugConfig.DEBUG_POWER_QUICK == false) goto L5;
        int r0 = 1;
    L6:
        DEFAULT_POWER_CHECK_INTERVAL = (r0 * 60) * 1000;
        DEFAULT_USE_TIERED_CACHED_ADJ = false;
        DEFAULT_ENABLE_NEW_OOM_ADJ = true;
        DEFAULT_ENABLE_BATCHING_OOM_ADJ = true;
        DEFAULT_FREEZER_CUTOFF_ADJ = 900;
        DEFAULT_EXTRA_SERVICE_RESTART_DELAY_ON_MEM_PRESSURE = new long[]{0, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY, 20000, 30000};
        DEFAULT_SERVICE_TIMEOUT = Build.HW_TIMEOUT_MULTIPLIER * DEFAULT_BOOT_TIME_TEMP_ALLOWLIST_DURATION;
        DEFAULT_SERVICE_BACKGROUND_TIMEOUT = DEFAULT_SERVICE_TIMEOUT * 10;
        MAX_PREVIOUS_TIME = 60000;
        MIN_CRASH_INTERVAL = DEFAULT_MIN_CRASH_INTERVAL;
        PROCESS_CRASH_COUNT_RESET_INTERVAL = 43200000;
        PROCESS_CRASH_COUNT_LIMIT = 12;
        mPerf = new BoostFramework();
        USE_TRIM_SETTINGS = true;
        COMPACTION_DELAY_MS = 300000;
        EMPTY_APP_PERCENT = 50;
        TRIM_EMPTY_PERCENT = 100;
        TRIM_CACHE_PERCENT = 100;
        TRIM_ENABLE_MEMORY = 1073741824;
        ACTIVITY_MANAGER_CONSTANTS_URI = Settings.Global.getUriFor("activity_manager_constants");
        ACTIVITY_STARTS_LOGGING_ENABLED_URI = Settings.Global.getUriFor("activity_starts_logging_enabled");
        FOREGROUND_SERVICE_STARTS_LOGGING_ENABLED_URI = Settings.Global.getUriFor("foreground_service_starts_logging_enabled");
        ENABLE_AUTOMATIC_SYSTEM_SERVER_HEAP_DUMPS_URI = Settings.Global.getUriFor("enable_automatic_system_server_heap_dumps");
        FORCE_ENABLE_PSS_PROFILING_URI = Settings.Global.getUriFor("force_enable_pss_profiling");
        MIN_ASSOC_LOG_DURATION = 300000;
        PROACTIVE_KILLS_ENABLED = false;
        LOW_SWAP_THRESHOLD_PERCENT = DEFAULT_LOW_SWAP_THRESHOLD_PERCENT;
        return;
    L5:
        r0 = 5;
        goto L6
    }

    public static boolean allowTrim() {
        if (Process.getTotalMemory() >= TRIM_ENABLE_MEMORY) goto L5;
        return true;
    L5:
        return false;
    }

    ActivityManagerConstants(Context context, ActivityManagerService service, Handler handler) {
        super(handler);
        boolean r3 = false;
        this.mProcStateDebugUids = new SparseBooleanArray(0);
        this.mEnableProcStateStacktrace = false;
        this.mProcStateDebugSetProcStateDelay = 0;
        this.mProcStateDebugSetUidStateDelay = 0;
        this.MAX_CACHED_PROCESSES = 1024;
        this.BACKGROUND_SETTLE_TIME = 30000;
        this.FGSERVICE_MIN_SHOWN_TIME = 2000;
        this.FGSERVICE_MIN_REPORT_TIME = 3000;
        this.FGSERVICE_SCREEN_ON_BEFORE_TIME = 1000;
        this.FGSERVICE_SCREEN_ON_AFTER_TIME = 5000;
        this.FGS_BOOT_COMPLETED_ALLOWLIST = DEFAULT_FGS_BOOT_COMPLETED_ALLOWLIST;
        this.CONTENT_PROVIDER_RETAIN_TIME = 20000;
        this.GC_TIMEOUT = 5000;
        this.GC_MIN_INTERVAL = 60000;
        this.FORCE_BACKGROUND_CHECK_ON_RESTRICTED_APPS = true;
        this.FULL_PSS_MIN_INTERVAL = DEFAULT_FULL_PSS_MIN_INTERVAL;
        this.FULL_PSS_LOWERED_INTERVAL = 300000;
        this.POWER_CHECK_INTERVAL = DEFAULT_POWER_CHECK_INTERVAL;
        this.POWER_CHECK_MAX_CPU_1 = 25;
        this.POWER_CHECK_MAX_CPU_2 = 25;
        this.POWER_CHECK_MAX_CPU_3 = 10;
        this.POWER_CHECK_MAX_CPU_4 = 2;
        this.SERVICE_USAGE_INTERACTION_TIME_PRE_S = 1800000;
        this.SERVICE_USAGE_INTERACTION_TIME_POST_S = 60000;
        this.USAGE_STATS_INTERACTION_INTERVAL_PRE_S = 7200000;
        this.USAGE_STATS_INTERACTION_INTERVAL_POST_S = 600000;
        this.SERVICE_RESTART_DURATION = 1000;
        this.SERVICE_RESET_RUN_DURATION = 60000;
        this.SERVICE_RESTART_DURATION_FACTOR = 4;
        this.SERVICE_MIN_RESTART_TIME_BETWEEN = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.SERVICE_TIMEOUT = DEFAULT_SERVICE_TIMEOUT;
        this.SERVICE_BACKGROUND_TIMEOUT = DEFAULT_SERVICE_BACKGROUND_TIMEOUT;
        this.MAX_SERVICE_INACTIVITY = 1800000;
        this.BG_START_TIMEOUT = 15000;
        this.SERVICE_BG_ACTIVITY_START_TIMEOUT = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.BOUND_SERVICE_CRASH_RESTART_DURATION = 1800000;
        this.BOUND_SERVICE_MAX_CRASH_RETRY = 16;
        this.FLAG_PROCESS_START_ASYNC = true;
        this.MEMORY_INFO_THROTTLE_TIME = 300000;
        this.TOP_TO_FGS_GRACE_DURATION = 15000;
        this.TOP_TO_ALMOST_PERCEPTIBLE_GRACE_DURATION = 15000;
        this.mFlagBackgroundFgsStartRestrictionEnabled = true;
        this.mFlagFgsStartRestrictionEnabled = true;
        this.mFgsStartRestrictionNotificationEnabled = false;
        this.mForceEnablePssProfiling = false;
        this.mFgsStartRestrictionCheckCallerTargetSdk = true;
        this.mFlagFgsNotificationDeferralEnabled = true;
        this.mFlagFgsNotificationDeferralApiGated = false;
        this.mFgsNotificationDeferralInterval = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.mFgsNotificationDeferralIntervalForShort = this.mFgsNotificationDeferralInterval;
        this.mFgsNotificationDeferralExclusionTime = 120000;
        this.mFgsNotificationDeferralExclusionTimeForShort = this.mFgsNotificationDeferralExclusionTime;
        this.mFlagSystemExemptPowerRestrictionsEnabled = true;
        this.mPushMessagingOverQuotaBehavior = 1;
        this.mBootTimeTempAllowlistDuration = 20000;
        this.mFgToBgFgsGraceDuration = 5000;
        this.mVisibleToInvisibleUijScheduleGraceDurationMs = 5000;
        this.mFgsStartForegroundTimeoutMs = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.mFgsAtomSampleRate = 1.0f;
        this.mFgsStartAllowedLogSampleRate = DEFAULT_FGS_START_ALLOWED_LOG_SAMPLE_RATE;
        this.mFgsStartDeniedLogSampleRate = 1.0f;
        this.mKillBgRestrictedAndCachedIdle = false;
        this.mKillBgRestrictedAndCachedIdleSettleTimeMs = 60000;
        this.mProcessKillTimeoutMs = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.mFgsAllowOptOut = false;
        this.mExtraServiceRestartDelayOnMemPressure = DEFAULT_EXTRA_SERVICE_RESTART_DELAY_ON_MEM_PRESSURE;
        this.mEnableExtraServiceRestartDelayOnMemPressure = true;
        this.mEnableComponentAlias = false;
        this.mDeferBootCompletedBroadcast = 6;
        this.mPrioritizeAlarmBroadcasts = true;
        this.mServiceStartForegroundTimeoutMs = 30000;
        this.mServiceStartForegroundAnrDelayMs = 10000;
        this.mServiceBindAlmostPerceptibleTimeoutMs = 15000;
        this.mComponentAliasOverrides = "";
        this.mMaxServiceConnectionsPerProcess = 3000;
        this.mParser = new KeyValueListParser(',');
        this.mOverrideMaxCachedProcesses = -1;
        this.mNoKillCachedProcessesUntilBootCompleted = true;
        this.mNoKillCachedProcessesPostBootCompletedDurationMillis = 600000;
        this.CUR_TRIM_EMPTY_PROCESSES = computeEmptyProcessLimit(this.MAX_CACHED_PROCESSES) / 2;
        this.CUR_TRIM_CACHED_PROCESSES = (this.MAX_CACHED_PROCESSES - computeEmptyProcessLimit(this.MAX_CACHED_PROCESSES)) / 3;
        this.mMaxEmptyTimeMillis = DEFAULT_MAX_EMPTY_TIME_MILLIS;
        this.IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES = new ArraySet();
        this.IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES = new ArraySet();
        this.PENDINGINTENT_WARNING_THRESHOLD = 2000;
        this.KEEP_WARMING_SERVICES = new ArraySet();
        this.MAX_PHANTOM_PROCESSES = 32;
        this.mNetworkAccessTimeoutMs = DEFAULT_NETWORK_ACCESS_TIMEOUT_MS;
        this.OOMADJ_UPDATE_QUICK = true;
        this.mShortFgsTimeoutDuration = 180000;
        this.mShortFgsProcStateExtraWaitDuration = 5000;
        this.mMediaProcessingFgsTimeoutDuration = 21600000;
        this.mDataSyncFgsTimeoutDuration = 21600000;
        this.mEnableWaitForFinishAttachApplication = true;
        this.mShortFgsAnrExtraWaitDuration = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.mFgsCrashExtraWaitDuration = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.USE_TIERED_CACHED_ADJ = DEFAULT_USE_TIERED_CACHED_ADJ;
        this.TIERED_CACHED_ADJ_DECAY_TIME = 60000;
        this.ENABLE_NEW_OOMADJ = DEFAULT_ENABLE_NEW_OOM_ADJ;
        this.ENABLE_BATCHING_OOM_ADJ = DEFAULT_ENABLE_BATCHING_OOM_ADJ;
        this.FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION = 1000;
        this.FREEZER_CUTOFF_ADJ = DEFAULT_FREEZER_CUTOFF_ADJ;
        this.mOnDeviceConfigChangedListener = new AnonymousClass1(this);
        this.mOnDeviceConfigChangedForComponentAliasListener = new AnonymousClass2(this);
        this.mService = service;
        if (Build.IS_DEBUGGABLE == true) goto L5;
    L8:
        this.mSystemServerAutomaticHeapDumpEnabled = r3;
        this.mSystemServerAutomaticHeapDumpPackageName = context.getPackageName();
        this.mSystemServerAutomaticHeapDumpPssThresholdBytes = Math.max(MIN_AUTOMATIC_HEAP_DUMP_PSS_THRESHOLD_BYTES, context.getResources().getInteger(R.integer.config_defaultMinEmergencyGestureTapDurationMillis));
        this.mDefaultImperceptibleKillExemptPackages = Arrays.asList(context.getResources().getStringArray(R.array.config_displayCutoutPathArray));
        this.mDefaultImperceptibleKillExemptProcStates = (List) Arrays.stream(context.getResources().getIntArray(R.array.config_displayCutoutSideOverrideArray)).boxed().collect(Collectors.toList());
        this.IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES.addAll(this.mDefaultImperceptibleKillExemptPackages);
        this.IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES.addAll(this.mDefaultImperceptibleKillExemptProcStates);
        this.mDefaultBinderHeavyHitterWatcherEnabled = context.getResources().getBoolean(R.bool.config_defaultInTouchMode);
        this.mDefaultBinderHeavyHitterWatcherBatchSize = context.getResources().getInteger(R.integer.config_defaultNotificationLedOff);
        this.mDefaultBinderHeavyHitterWatcherThreshold = context.getResources().getFloat(R.dimen.day_picker_padding_horizontal);
        this.mDefaultBinderHeavyHitterAutoSamplerEnabled = context.getResources().getBoolean(R.bool.config_defaultEmergencyGestureSoundEnabled);
        this.mDefaultBinderHeavyHitterAutoSamplerBatchSize = context.getResources().getInteger(R.integer.config_defaultNightMode);
        this.mDefaultBinderHeavyHitterAutoSamplerThreshold = context.getResources().getFloat(R.dimen.day_picker_button_margin_top);
        BINDER_HEAVY_HITTER_WATCHER_ENABLED = this.mDefaultBinderHeavyHitterWatcherEnabled;
        BINDER_HEAVY_HITTER_WATCHER_BATCHSIZE = this.mDefaultBinderHeavyHitterWatcherBatchSize;
        BINDER_HEAVY_HITTER_WATCHER_THRESHOLD = this.mDefaultBinderHeavyHitterWatcherThreshold;
        BINDER_HEAVY_HITTER_AUTO_SAMPLER_ENABLED = this.mDefaultBinderHeavyHitterAutoSamplerEnabled;
        BINDER_HEAVY_HITTER_AUTO_SAMPLER_BATCHSIZE = this.mDefaultBinderHeavyHitterAutoSamplerBatchSize;
        BINDER_HEAVY_HITTER_AUTO_SAMPLER_THRESHOLD = this.mDefaultBinderHeavyHitterAutoSamplerThreshold;
        service.scheduleUpdateBinderHeavyHitterWatcherConfig();
        this.KEEP_WARMING_SERVICES.addAll((Collection) Arrays.stream(context.getResources().getStringArray(R.array.config_nightDisplayColorTemperatureCoefficients)).map(new AccessibilityManagerService$$ExternalSyntheticLambda57()).collect(Collectors.toSet()));
        this.mCustomizedMaxCachedProcesses = context.getResources().getInteger(R.integer.config_defaultBinderHeavyHitterAutoSamplerBatchSize);
        this.CUR_MAX_CACHED_PROCESSES = this.mCustomizedMaxCachedProcesses;
        this.CUR_MAX_EMPTY_PROCESSES = computeEmptyProcessLimit(this.CUR_MAX_CACHED_PROCESSES);
        int rawMaxEmptyProcesses = computeEmptyProcessLimit(Integer.min(this.CUR_MAX_CACHED_PROCESSES, this.MAX_CACHED_PROCESSES));
        this.CUR_TRIM_EMPTY_PROCESSES = rawMaxEmptyProcesses / 2;
        this.CUR_TRIM_CACHED_PROCESSES = (Integer.min(this.CUR_MAX_CACHED_PROCESSES, this.MAX_CACHED_PROCESSES) - rawMaxEmptyProcesses) / 3;
        loadNativeBootDeviceConfigConstants();
        this.mDefaultDisableAppProfilerPssProfiling = context.getResources().getBoolean(R.bool.config_am_disablePssProfiling);
        this.APP_PROFILER_PSS_PROFILING_DISABLED = this.mDefaultDisableAppProfilerPssProfiling;
        this.mDefaultPssToRssThresholdModifier = context.getResources().getFloat(R.dimen.datepicker_header_height);
        this.PSS_TO_RSS_THRESHOLD_MODIFIER = this.mDefaultPssToRssThresholdModifier;
        this.mDefaultTieredCachedAdjUiTierSize = context.getResources().getInteger(R.integer.config_app_exit_info_history_list_size);
        this.TIERED_CACHED_ADJ_UI_TIER_SIZE = Math.min(this.mDefaultTieredCachedAdjUiTierSize, 50);
        return;
    L5:
        if (context.getResources().getBoolean(R.bool.config_defaultBatteryPercentageSetting) == false) goto L8;
        r3 = true;
        goto L8
    }

    private void updatePerfConfigConstants() {
        if (mPerf == null) goto L6;
        int r0 = Integer.valueOf(mPerf.perfGetProp("ro.vendor.qti.sys.fw.bg_apps_limit", String.valueOf(1024))).intValue();
        this.CUR_MAX_CACHED_PROCESSES = r0;
        this.MAX_CACHED_PROCESSES = r0;
        this.CUR_MAX_EMPTY_PROCESSES = computeEmptyProcessLimit(this.CUR_MAX_CACHED_PROCESSES);
        COMPACTION_DELAY_MS = Integer.valueOf(mPerf.perfGetProp("ro.vendor.qti.sys.fw.compaction_delay_sec", "300")).intValue() * 1000;
        USE_TRIM_SETTINGS = Boolean.parseBoolean(mPerf.perfGetProp("ro.vendor.qti.sys.fw.use_trim_settings", "true"));
        EMPTY_APP_PERCENT = Integer.valueOf(mPerf.perfGetProp("ro.vendor.qti.sys.fw.empty_app_percent", "50")).intValue();
        TRIM_EMPTY_PERCENT = Integer.valueOf(mPerf.perfGetProp("ro.vendor.qti.sys.fw.trim_empty_percent", "100")).intValue();
        TRIM_CACHE_PERCENT = Integer.valueOf(mPerf.perfGetProp("ro.vendor.qti.sys.fw.trim_cache_percent", "100")).intValue();
        TRIM_ENABLE_MEMORY = Long.valueOf(mPerf.perfGetProp("ro.vendor.qti.sys.fw.trim_enable_memory", "1073741824")).longValue();
        int rawEmptyProcesses = computeEmptyProcessLimit(this.MAX_CACHED_PROCESSES);
        this.CUR_TRIM_EMPTY_PROCESSES = computeTrimEmptyApps(rawEmptyProcesses);
        this.CUR_TRIM_CACHED_PROCESSES = computeTrimCachedApps(rawEmptyProcesses, this.MAX_CACHED_PROCESSES);
        return;
    }

    public void start(ContentResolver resolver) {
        this.mResolver = resolver;
        this.mResolver.registerContentObserver(ACTIVITY_MANAGER_CONSTANTS_URI, false, this);
        this.mResolver.registerContentObserver(ACTIVITY_STARTS_LOGGING_ENABLED_URI, false, this);
        this.mResolver.registerContentObserver(FOREGROUND_SERVICE_STARTS_LOGGING_ENABLED_URI, false, this);
        if (this.mSystemServerAutomaticHeapDumpEnabled == false) goto L5;
        this.mResolver.registerContentObserver(ENABLE_AUTOMATIC_SYSTEM_SERVER_HEAP_DUMPS_URI, false, this);
    L5:
        this.mResolver.registerContentObserver(FORCE_ENABLE_PSS_PROFILING_URI, false, this);
        updateConstants();
        updatePerfConfigConstants();
        if (this.mSystemServerAutomaticHeapDumpEnabled == false) goto L8;
        updateEnableAutomaticSystemServerHeapDumps();
    L8:
        DeviceConfig.addOnPropertiesChangedListener("activity_manager", ActivityThread.currentApplication().getMainExecutor(), this.mOnDeviceConfigChangedListener);
        DeviceConfig.addOnPropertiesChangedListener("activity_manager_ca", ActivityThread.currentApplication().getMainExecutor(), this.mOnDeviceConfigChangedForComponentAliasListener);
        loadDeviceConfigConstants();
        updateActivityStartsLoggingEnabled();
        updateForegroundServiceStartsLoggingEnabled();
        updateForceEnablePssProfiling();
        this.mService.initDropboxRateLimiter();
    }

    void loadDeviceConfigConstants() {
        this.mOnDeviceConfigChangedListener.onPropertiesChanged(DeviceConfig.getProperties("activity_manager", new String[0]));
        this.mOnDeviceConfigChangedForComponentAliasListener.onPropertiesChanged(DeviceConfig.getProperties("activity_manager_ca", new String[0]));
    }

    private void loadNativeBootDeviceConfigConstants() {
        this.ENABLE_NEW_OOMADJ = BroadcastConstants.getDeviceConfigBoolean(KEY_ENABLE_NEW_OOMADJ, DEFAULT_ENABLE_NEW_OOM_ADJ);
        this.ENABLE_BATCHING_OOM_ADJ = BroadcastConstants.getDeviceConfigBoolean(KEY_ENABLE_BATCHING_OOM_ADJ, DEFAULT_ENABLE_BATCHING_OOM_ADJ);
    }

    public static int computeTrimEmptyApps(int rawMaxEmptyProcesses) {
        if (USE_TRIM_SETTINGS == false) goto L9;
        if (allowTrim() == false) goto L9;
        return (TRIM_EMPTY_PERCENT * rawMaxEmptyProcesses) / 100;
    L9:
        return rawMaxEmptyProcesses / 2;
    }

    public static int computeTrimCachedApps(int rawMaxEmptyProcesses, int totalProcessLimit) {
        if (USE_TRIM_SETTINGS == false) goto L9;
        if (allowTrim() == false) goto L9;
        return (TRIM_CACHE_PERCENT * totalProcessLimit) / 100;
    L9:
        return (totalProcessLimit - rawMaxEmptyProcesses) / 3;
    }

    public void setOverrideMaxCachedProcesses(int value) {
        this.mOverrideMaxCachedProcesses = value;
        updateMaxCachedProcesses();
    }

    public int getOverrideMaxCachedProcesses() {
        return this.mOverrideMaxCachedProcesses;
    }

    public static int computeEmptyProcessLimit(int totalProcessLimit) {
        if (USE_TRIM_SETTINGS == false) goto L9;
        if (allowTrim() == false) goto L9;
        return (EMPTY_APP_PERCENT * totalProcessLimit) / 100;
    L9:
        return totalProcessLimit / 2;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri) {
        if (uri != null) goto L5;
        return;
    L5:
        if (ACTIVITY_MANAGER_CONSTANTS_URI.equals(uri) == false) goto L8;
        updateConstants();
        return;
    L8:
        if (ACTIVITY_STARTS_LOGGING_ENABLED_URI.equals(uri) == false) goto L11;
        updateActivityStartsLoggingEnabled();
        return;
    L11:
        if (FOREGROUND_SERVICE_STARTS_LOGGING_ENABLED_URI.equals(uri) == false) goto L14;
        updateForegroundServiceStartsLoggingEnabled();
        return;
    L14:
        if (ENABLE_AUTOMATIC_SYSTEM_SERVER_HEAP_DUMPS_URI.equals(uri) == false) goto L17;
        updateEnableAutomaticSystemServerHeapDumps();
        return;
    L17:
        if (FORCE_ENABLE_PSS_PROFILING_URI.equals(uri) == false) goto L24;
        updateForceEnablePssProfiling();
        return;
    }

    private void updateConstants() {
        String setting = Settings.Global.getString(this.mResolver, "activity_manager_constants");
        ActivityManagerService r3 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mParser.setString(setting);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
    L10:
        long currentPowerCheckInterval = this.POWER_CHECK_INTERVAL;     // Catch: Throwable -> L6
        KeyValueListParser r0 = this.mParser;     // Catch: Throwable -> L6
        if (this.mService.xMode == false) goto L13;
        long r10 = 60000;
    L14:
        this.BACKGROUND_SETTLE_TIME = r0.getLong(KEY_BACKGROUND_SETTLE_TIME, r10);     // Catch: Throwable -> L6
        this.FGSERVICE_MIN_SHOWN_TIME = this.mParser.getLong(KEY_FGSERVICE_MIN_SHOWN_TIME, 2000);     // Catch: Throwable -> L6
        this.FGSERVICE_MIN_REPORT_TIME = this.mParser.getLong(KEY_FGSERVICE_MIN_REPORT_TIME, 3000);     // Catch: Throwable -> L6
        this.FGSERVICE_SCREEN_ON_BEFORE_TIME = this.mParser.getLong(KEY_FGSERVICE_SCREEN_ON_BEFORE_TIME, 1000);     // Catch: Throwable -> L6
        this.FGSERVICE_SCREEN_ON_AFTER_TIME = this.mParser.getLong(KEY_FGSERVICE_SCREEN_ON_AFTER_TIME, 5000);     // Catch: Throwable -> L6
        this.FGS_BOOT_COMPLETED_ALLOWLIST = this.mParser.getInt(KEY_FGS_BOOT_COMPLETED_ALLOWLIST, DEFAULT_FGS_BOOT_COMPLETED_ALLOWLIST);     // Catch: Throwable -> L6
        this.CONTENT_PROVIDER_RETAIN_TIME = this.mParser.getLong(KEY_CONTENT_PROVIDER_RETAIN_TIME, 20000);     // Catch: Throwable -> L6
        this.GC_TIMEOUT = this.mParser.getLong(KEY_GC_TIMEOUT, 5000);     // Catch: Throwable -> L6
        this.GC_MIN_INTERVAL = this.mParser.getLong(KEY_GC_MIN_INTERVAL, 60000);     // Catch: Throwable -> L6
        this.FULL_PSS_MIN_INTERVAL = this.mParser.getLong(KEY_FULL_PSS_MIN_INTERVAL, DEFAULT_FULL_PSS_MIN_INTERVAL);     // Catch: Throwable -> L6
        this.FULL_PSS_LOWERED_INTERVAL = this.mParser.getLong(KEY_FULL_PSS_LOWERED_INTERVAL, 300000);     // Catch: Throwable -> L6
        this.POWER_CHECK_INTERVAL = this.mParser.getLong(KEY_POWER_CHECK_INTERVAL, DEFAULT_POWER_CHECK_INTERVAL);     // Catch: Throwable -> L6
        this.POWER_CHECK_MAX_CPU_1 = this.mParser.getInt(KEY_POWER_CHECK_MAX_CPU_1, 25);     // Catch: Throwable -> L6
        this.POWER_CHECK_MAX_CPU_2 = this.mParser.getInt(KEY_POWER_CHECK_MAX_CPU_2, 25);     // Catch: Throwable -> L6
        this.POWER_CHECK_MAX_CPU_3 = this.mParser.getInt(KEY_POWER_CHECK_MAX_CPU_3, 10);     // Catch: Throwable -> L6
        this.POWER_CHECK_MAX_CPU_4 = this.mParser.getInt(KEY_POWER_CHECK_MAX_CPU_4, 2);     // Catch: Throwable -> L6
        this.SERVICE_USAGE_INTERACTION_TIME_PRE_S = this.mParser.getLong(KEY_SERVICE_USAGE_INTERACTION_TIME_PRE_S, 1800000);     // Catch: Throwable -> L6
        this.SERVICE_USAGE_INTERACTION_TIME_POST_S = this.mParser.getLong(KEY_SERVICE_USAGE_INTERACTION_TIME_POST_S, 60000);     // Catch: Throwable -> L6
        this.USAGE_STATS_INTERACTION_INTERVAL_PRE_S = this.mParser.getLong(KEY_USAGE_STATS_INTERACTION_INTERVAL_PRE_S, 7200000);     // Catch: Throwable -> L6
        this.USAGE_STATS_INTERACTION_INTERVAL_POST_S = this.mParser.getLong(KEY_USAGE_STATS_INTERACTION_INTERVAL_POST_S, 600000);     // Catch: Throwable -> L6
        this.SERVICE_RESTART_DURATION = this.mParser.getLong(KEY_SERVICE_RESTART_DURATION, 1000);     // Catch: Throwable -> L6
        this.SERVICE_RESET_RUN_DURATION = this.mParser.getLong(KEY_SERVICE_RESET_RUN_DURATION, 60000);     // Catch: Throwable -> L6
        this.SERVICE_RESTART_DURATION_FACTOR = this.mParser.getInt(KEY_SERVICE_RESTART_DURATION_FACTOR, 4);     // Catch: Throwable -> L6
        this.SERVICE_MIN_RESTART_TIME_BETWEEN = this.mParser.getLong(KEY_SERVICE_MIN_RESTART_TIME_BETWEEN, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);     // Catch: Throwable -> L6
        this.MAX_SERVICE_INACTIVITY = this.mParser.getLong(KEY_MAX_SERVICE_INACTIVITY, 1800000);     // Catch: Throwable -> L6
        this.BG_START_TIMEOUT = this.mParser.getLong(KEY_BG_START_TIMEOUT, 15000);     // Catch: Throwable -> L6
        this.SERVICE_BG_ACTIVITY_START_TIMEOUT = this.mParser.getLong(KEY_SERVICE_BG_ACTIVITY_START_TIMEOUT, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);     // Catch: Throwable -> L6
        this.BOUND_SERVICE_CRASH_RESTART_DURATION = this.mParser.getLong(KEY_BOUND_SERVICE_CRASH_RESTART_DURATION, 1800000);     // Catch: Throwable -> L6
        this.BOUND_SERVICE_MAX_CRASH_RETRY = this.mParser.getInt(KEY_BOUND_SERVICE_CRASH_MAX_RETRY, 16);     // Catch: Throwable -> L6
        this.FLAG_PROCESS_START_ASYNC = this.mParser.getBoolean(KEY_PROCESS_START_ASYNC, true);     // Catch: Throwable -> L6
        this.MEMORY_INFO_THROTTLE_TIME = this.mParser.getLong(KEY_MEMORY_INFO_THROTTLE_TIME, 300000);     // Catch: Throwable -> L6
        this.TOP_TO_ALMOST_PERCEPTIBLE_GRACE_DURATION = this.mParser.getDurationMillis(KEY_TOP_TO_ALMOST_PERCEPTIBLE_GRACE_DURATION, 15000);     // Catch: Throwable -> L6
        MIN_CRASH_INTERVAL = this.mParser.getInt(KEY_MIN_CRASH_INTERVAL, DEFAULT_MIN_CRASH_INTERVAL);     // Catch: Throwable -> L6
        this.PENDINGINTENT_WARNING_THRESHOLD = this.mParser.getInt(KEY_PENDINGINTENT_WARNING_THRESHOLD, 2000);     // Catch: Throwable -> L6
        PROCESS_CRASH_COUNT_RESET_INTERVAL = this.mParser.getInt(KEY_PROCESS_CRASH_COUNT_RESET_INTERVAL, DEFAULT_PROCESS_CRASH_COUNT_RESET_INTERVAL);     // Catch: Throwable -> L6
        PROCESS_CRASH_COUNT_LIMIT = this.mParser.getInt(KEY_PROCESS_CRASH_COUNT_LIMIT, 12);     // Catch: Throwable -> L6
        if (this.POWER_CHECK_INTERVAL == currentPowerCheckInterval) goto L17;
        this.mService.mHandler.removeMessages(27);     // Catch: Throwable -> L6
        Message msg = this.mService.mHandler.obtainMessage(27);     // Catch: Throwable -> L6
        this.mService.mHandler.sendMessageDelayed(msg, this.POWER_CHECK_INTERVAL);     // Catch: Throwable -> L6
    L17:
        monitor-exit(r3);     // Catch: Throwable -> L6
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        r10 = 30000;
        goto L14
    L6:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L8:
        e = move-exception;
        Slog.e(TAG, "Bad activity manager config settings", e);     // Catch: Throwable -> L6
        goto L10
    }

    private void updateActivityStartsLoggingEnabled() {
        boolean r2 = true;
        if (Settings.Global.getInt(this.mResolver, "activity_starts_logging_enabled", 1) == 1) goto L6;
        r2 = false;
    L6:
        this.mFlagActivityStartsLoggingEnabled = r2;
    }

    private void updateForceEnablePssProfiling() {
        boolean r2 = false;
        if (Settings.Global.getInt(this.mResolver, "force_enable_pss_profiling", 0) != 1) goto L5;
        r2 = true;
    L5:
        this.mForceEnablePssProfiling = r2;
    }

    private void updateBackgroundActivityStarts() {
        this.mFlagBackgroundActivityStartsEnabled = DeviceConfig.getBoolean("activity_manager", KEY_DEFAULT_BACKGROUND_ACTIVITY_STARTS_ENABLED, false);
    }

    private void updateForegroundServiceStartsLoggingEnabled() {
        boolean r2 = true;
        if (Settings.Global.getInt(this.mResolver, "foreground_service_starts_logging_enabled", 1) == 1) goto L6;
        r2 = false;
    L6:
        this.mFlagForegroundServiceStartsLoggingEnabled = r2;
    }

    private void updateBackgroundFgsStartsRestriction() {
        this.mFlagBackgroundFgsStartRestrictionEnabled = DeviceConfig.getBoolean("activity_manager", KEY_DEFAULT_BACKGROUND_FGS_STARTS_RESTRICTION_ENABLED, true);
    }

    private void updateFgsStartsRestriction() {
        this.mFlagFgsStartRestrictionEnabled = DeviceConfig.getBoolean("activity_manager", KEY_DEFAULT_FGS_STARTS_RESTRICTION_ENABLED, true);
    }

    private void updateFgsStartsRestrictionNotification() {
        this.mFgsStartRestrictionNotificationEnabled = DeviceConfig.getBoolean("activity_manager", KEY_DEFAULT_FGS_STARTS_RESTRICTION_NOTIFICATION_ENABLED, false);
    }

    private void updateFgsStartsRestrictionCheckCallerTargetSdk() {
        this.mFgsStartRestrictionCheckCallerTargetSdk = DeviceConfig.getBoolean("activity_manager", KEY_DEFAULT_FGS_STARTS_RESTRICTION_CHECK_CALLER_TARGET_SDK, true);
    }

    private void updateFgsNotificationDeferralEnable() {
        this.mFlagFgsNotificationDeferralEnabled = DeviceConfig.getBoolean("activity_manager", KEY_DEFERRED_FGS_NOTIFICATIONS_ENABLED, true);
    }

    private void updateFgsNotificationDeferralApiGated() {
        this.mFlagFgsNotificationDeferralApiGated = DeviceConfig.getBoolean("activity_manager", KEY_DEFERRED_FGS_NOTIFICATIONS_API_GATED, false);
    }

    private void updateFgsNotificationDeferralInterval() {
        this.mFgsNotificationDeferralInterval = DeviceConfig.getLong("activity_manager", KEY_DEFERRED_FGS_NOTIFICATION_INTERVAL, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    private void updateFgsNotificationDeferralIntervalForShort() {
        this.mFgsNotificationDeferralIntervalForShort = DeviceConfig.getLong("activity_manager", KEY_DEFERRED_FGS_NOTIFICATION_INTERVAL_FOR_SHORT, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    private void updateFgsNotificationDeferralExclusionTime() {
        this.mFgsNotificationDeferralExclusionTime = DeviceConfig.getLong("activity_manager", KEY_DEFERRED_FGS_NOTIFICATION_EXCLUSION_TIME, 120000);
    }

    private void updateFgsNotificationDeferralExclusionTimeForShort() {
        this.mFgsNotificationDeferralExclusionTimeForShort = DeviceConfig.getLong("activity_manager", KEY_DEFERRED_FGS_NOTIFICATION_EXCLUSION_TIME_FOR_SHORT, 120000);
    }

    private void updateSystemExemptPowerRestrictionsEnabled() {
        this.mFlagSystemExemptPowerRestrictionsEnabled = DeviceConfig.getBoolean("activity_manager", KEY_SYSTEM_EXEMPT_POWER_RESTRICTIONS_ENABLED, true);
    }

    private void updatePushMessagingOverQuotaBehavior() {
        this.mPushMessagingOverQuotaBehavior = DeviceConfig.getInt("activity_manager", KEY_PUSH_MESSAGING_OVER_QUOTA_BEHAVIOR, 1);
        if (this.mPushMessagingOverQuotaBehavior >= (-1)) goto L5;
    L6:
        this.mPushMessagingOverQuotaBehavior = 1;
        return;
    L5:
        if (this.mPushMessagingOverQuotaBehavior > 1) goto L6;
    }

    private void updateOomAdjUpdatePolicy() {
        boolean r2 = true;
        if (DeviceConfig.getInt("activity_manager", KEY_OOMADJ_UPDATE_POLICY, 1) == 1) goto L6;
        r2 = false;
    L6:
        this.OOMADJ_UPDATE_QUICK = r2;
    }

    private void updateForceRestrictedBackgroundCheck() {
        this.FORCE_BACKGROUND_CHECK_ON_RESTRICTED_APPS = DeviceConfig.getBoolean("activity_manager", KEY_FORCE_BACKGROUND_CHECK_ON_RESTRICTED_APPS, true);
    }

    private void updateBootTimeTempAllowListDuration() {
        this.mBootTimeTempAllowlistDuration = DeviceConfig.getLong("activity_manager", KEY_BOOT_TIME_TEMP_ALLOWLIST_DURATION, 20000);
    }

    private void updateFgToBgFgsGraceDuration() {
        this.mFgToBgFgsGraceDuration = DeviceConfig.getLong("activity_manager", KEY_FG_TO_BG_FGS_GRACE_DURATION, 5000);
    }

    private void updateVisibleToInvisibleUijScheduleGraceDuration() {
        this.mVisibleToInvisibleUijScheduleGraceDurationMs = DeviceConfig.getLong("activity_manager", KEY_VISIBLE_TO_INVISIBLE_UIJ_SCHEDULE_GRACE_DURATION, 5000);
    }

    private void updateFgsStartForegroundTimeout() {
        this.mFgsStartForegroundTimeoutMs = DeviceConfig.getLong("activity_manager", KEY_FGS_START_FOREGROUND_TIMEOUT, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    private void updateFgsAtomSamplePercent() {
        this.mFgsAtomSampleRate = DeviceConfig.getFloat("activity_manager", KEY_FGS_ATOM_SAMPLE_RATE, 1.0f);
    }

    private void updateFgsStartAllowedLogSamplePercent() {
        this.mFgsStartAllowedLogSampleRate = DeviceConfig.getFloat("activity_manager", KEY_FGS_START_ALLOWED_LOG_SAMPLE_RATE, DEFAULT_FGS_START_ALLOWED_LOG_SAMPLE_RATE);
    }

    private void updateFgsStartDeniedLogSamplePercent() {
        this.mFgsStartDeniedLogSampleRate = DeviceConfig.getFloat("activity_manager", KEY_FGS_START_DENIED_LOG_SAMPLE_RATE, 1.0f);
    }

    private void updateKillBgRestrictedCachedIdle() {
        this.mKillBgRestrictedAndCachedIdle = DeviceConfig.getBoolean("activity_manager", KEY_KILL_BG_RESTRICTED_CACHED_IDLE, false);
    }

    private void updateKillBgRestrictedCachedIdleSettleTime() {
        long currentSettleTime = this.mKillBgRestrictedAndCachedIdleSettleTimeMs;
        this.mKillBgRestrictedAndCachedIdleSettleTimeMs = DeviceConfig.getLong("activity_manager", KEY_KILL_BG_RESTRICTED_CACHED_IDLE_SETTLE_TIME, 60000);
        if (this.mKillBgRestrictedAndCachedIdleSettleTimeMs >= currentSettleTime) goto L6;
        this.mService.mHandler.sendEmptyMessageDelayed(58, this.mKillBgRestrictedAndCachedIdleSettleTimeMs);
        return;
    }

    private void updateFgsAllowOptOut() {
        this.mFgsAllowOptOut = DeviceConfig.getBoolean("activity_manager", KEY_FGS_ALLOW_OPT_OUT, false);
    }

    private void updateExtraServiceRestartDelayOnMemPressure() {
        ActivityManagerService r1 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        int memFactor = this.mService.mAppProfiler.getLastMemoryLevelLocked();     // Catch: Throwable -> L8
        long[] prevDelays = this.mExtraServiceRestartDelayOnMemPressure;     // Catch: Throwable -> L8
        this.mExtraServiceRestartDelayOnMemPressure = parseLongArray(KEY_EXTRA_SERVICE_RESTART_DELAY_ON_MEM_PRESSURE, DEFAULT_EXTRA_SERVICE_RESTART_DELAY_ON_MEM_PRESSURE);     // Catch: Throwable -> L8
        this.mService.mServices.performRescheduleServiceRestartOnMemoryPressureLocked(this.mExtraServiceRestartDelayOnMemPressure[memFactor], prevDelays[memFactor], "config", SystemClock.uptimeMillis());     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void updateEnableExtraServiceRestartDelayOnMemPressure() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        boolean prevEnabled = this.mEnableExtraServiceRestartDelayOnMemPressure;     // Catch: Throwable -> L8
        this.mEnableExtraServiceRestartDelayOnMemPressure = DeviceConfig.getBoolean("activity_manager", KEY_ENABLE_EXTRA_SERVICE_RESTART_DELAY_ON_MEM_PRESSURE, true);     // Catch: Throwable -> L8
        this.mService.mServices.rescheduleServiceRestartOnMemoryPressureIfNeededLocked(prevEnabled, this.mEnableExtraServiceRestartDelayOnMemPressure, SystemClock.uptimeMillis());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void updatePrioritizeAlarmBroadcasts() {
        String flag = DeviceConfig.getString("activity_manager", KEY_PRIORITIZE_ALARM_BROADCASTS, "");
        if (TextUtils.isEmpty(flag) == false) goto L5;
        boolean r1 = true;
    L6:
        this.mPrioritizeAlarmBroadcasts = r1;
        return;
    L5:
        r1 = Boolean.parseBoolean(flag);
        goto L6
    }

    private void updateDeferBootCompletedBroadcast() {
        this.mDeferBootCompletedBroadcast = DeviceConfig.getInt("activity_manager", KEY_DEFER_BOOT_COMPLETED_BROADCAST, 6);
    }

    private void updateNoKillCachedProcessesUntilBootCompleted() {
        this.mNoKillCachedProcessesUntilBootCompleted = DeviceConfig.getBoolean("activity_manager", KEY_NO_KILL_CACHED_PROCESSES_UNTIL_BOOT_COMPLETED, true);
    }

    private void updateNoKillCachedProcessesPostBootCompletedDurationMillis() {
        this.mNoKillCachedProcessesPostBootCompletedDurationMillis = DeviceConfig.getLong("activity_manager", KEY_NO_KILL_CACHED_PROCESSES_POST_BOOT_COMPLETED_DURATION_MILLIS, 600000);
    }

    private void updateMaxEmptyTimeMillis() {
        this.mMaxEmptyTimeMillis = DeviceConfig.getLong("activity_manager", KEY_MAX_EMPTY_TIME_MILLIS, DEFAULT_MAX_EMPTY_TIME_MILLIS);
    }

    private void updateNetworkAccessTimeoutMs() {
        this.mNetworkAccessTimeoutMs = DeviceConfig.getLong("activity_manager", KEY_NETWORK_ACCESS_TIMEOUT_MS, DEFAULT_NETWORK_ACCESS_TIMEOUT_MS);
    }

    private void updateServiceStartForegroundTimeoutMs() {
        this.mServiceStartForegroundTimeoutMs = DeviceConfig.getInt("activity_manager", KEY_SERVICE_START_FOREGROUND_TIMEOUT_MS, 30000);
    }

    private void updateServiceStartForegroundAnrDealyMs() {
        this.mServiceStartForegroundAnrDelayMs = DeviceConfig.getInt("activity_manager", KEY_SERVICE_START_FOREGROUND_ANR_DELAY_MS, 10000);
    }

    private void updateServiceBindAlmostPerceptibleTimeoutMs() {
        this.mServiceBindAlmostPerceptibleTimeoutMs = DeviceConfig.getLong("activity_manager", KEY_SERVICE_BIND_ALMOST_PERCEPTIBLE_TIMEOUT_MS, 15000);
    }

    private long[] parseLongArray(String key, long[] def) {
        String val = DeviceConfig.getString("activity_manager", key, null);
        if (TextUtils.isEmpty(val) == true) goto L15;
        String[] ss = val.split(",");
        if (ss.length != def.length) goto L15;
        long[] tmp = new long[ss.length];
        int i = 0;
    L16:
        if (i >= ss.length) goto L14;
        tmp[i] = Long.parseLong(ss[i]);     // Catch: NumberFormatException -> L11
        i = i + 1;
        goto L16
    L14:
        return tmp;
    L15:
        return def;
    }

    private void updateComponentAliases() {
        this.mEnableComponentAlias = DeviceConfig.getBoolean("activity_manager_ca", KEY_ENABLE_COMPONENT_ALIAS, false);
        this.mComponentAliasOverrides = DeviceConfig.getString("activity_manager_ca", KEY_COMPONENT_ALIAS_OVERRIDES, "");
        this.mService.mComponentAliasResolver.update(this.mEnableComponentAlias, this.mComponentAliasOverrides);
    }

    private void updateProcessKillTimeout() {
        this.mProcessKillTimeoutMs = DeviceConfig.getLong("activity_manager", KEY_PROCESS_KILL_TIMEOUT, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    private void updateImperceptibleKillExemptions() {
        this.IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES.clear();
        this.IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES.addAll(this.mDefaultImperceptibleKillExemptPackages);
        String val = DeviceConfig.getString("activity_manager", KEY_IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES, null);
        if (TextUtils.isEmpty(val) == true) goto L5;
        this.IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES.addAll(Arrays.asList(val.split(",")));
    L5:
        this.IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES.clear();
        this.IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES.addAll(this.mDefaultImperceptibleKillExemptProcStates);
        String val2 = DeviceConfig.getString("activity_manager", KEY_IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES, null);
        if (TextUtils.isEmpty(val2) == true) goto L9;
        Arrays.asList(val2.split(",")).stream().forEach(new ActivityManagerConstants$$ExternalSyntheticLambda1(this));
        return;
    }

    private /* synthetic */ void lambda$updateImperceptibleKillExemptions$0(String v) {
        this.IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES.add(Integer.valueOf(Integer.parseInt(v)));     // Catch: NumberFormatException -> L4
        return;
    }

    private void updateEnableAutomaticSystemServerHeapDumps() {
        if (this.mSystemServerAutomaticHeapDumpEnabled == true) goto L6;
        Slog.wtf(TAG, "updateEnableAutomaticSystemServerHeapDumps called when leak detection disabled");
        return;
    L6:
        boolean enabled = true;
        if (Settings.Global.getInt(this.mResolver, "enable_automatic_system_server_heap_dumps", 1) == 1) goto L10;
        enabled = false;
    L10:
        if (enabled == false) goto L12;
        long r0 = this.mSystemServerAutomaticHeapDumpPssThresholdBytes;
    L13:
        long threshold = r0;
        this.mService.setDumpHeapDebugLimit(null, 0, threshold, this.mSystemServerAutomaticHeapDumpPackageName);
        return;
    L12:
        r0 = 0;
        goto L13
    }

    private void updateMaxCachedProcesses() {
        String maxCachedProcessesFlag = DeviceConfig.getProperty("activity_manager", KEY_MAX_CACHED_PROCESSES);
    L8:
        e = move-exception;
        Slog.e(TAG, "Unable to parse flag for max_cached_processes: " + maxCachedProcessesFlag, e);
        this.CUR_MAX_CACHED_PROCESSES = this.mCustomizedMaxCachedProcesses;
    L15:
        this.CUR_MAX_EMPTY_PROCESSES = computeEmptyProcessLimit(this.CUR_MAX_CACHED_PROCESSES);
        int rawMaxEmptyProcesses = computeEmptyProcessLimit(Integer.min(this.CUR_MAX_CACHED_PROCESSES, this.MAX_CACHED_PROCESSES));
        this.CUR_TRIM_EMPTY_PROCESSES = computeTrimEmptyApps(rawMaxEmptyProcesses);
        this.CUR_TRIM_CACHED_PROCESSES = (Integer.min(this.CUR_MAX_CACHED_PROCESSES, this.MAX_CACHED_PROCESSES) - rawMaxEmptyProcesses) / 3;
        return;
    L4:
        if (this.mOverrideMaxCachedProcesses < 0) goto L6;
        int r1 = this.mOverrideMaxCachedProcesses;     // Catch: NumberFormatException -> L8
    L12:
        this.CUR_MAX_CACHED_PROCESSES = r1;     // Catch: NumberFormatException -> L8
        goto L15
    L6:
        if (TextUtils.isEmpty(maxCachedProcessesFlag) == false) goto L10;
        r1 = this.mCustomizedMaxCachedProcesses;     // Catch: NumberFormatException -> L8
        goto L12
    L10:
        r1 = Integer.parseInt(maxCachedProcessesFlag);     // Catch: NumberFormatException -> L8
        goto L12
    }

    private void updateProactiveKillsEnabled() {
        PROACTIVE_KILLS_ENABLED = DeviceConfig.getBoolean("activity_manager", KEY_PROACTIVE_KILLS_ENABLED, false);
    }

    private void updateLowSwapThresholdPercent() {
        LOW_SWAP_THRESHOLD_PERCENT = DeviceConfig.getFloat("activity_manager", KEY_LOW_SWAP_THRESHOLD_PERCENT, DEFAULT_LOW_SWAP_THRESHOLD_PERCENT);
    }

    private void updateTopToFgsGraceDuration() {
        this.TOP_TO_FGS_GRACE_DURATION = DeviceConfig.getLong("activity_manager", KEY_TOP_TO_FGS_GRACE_DURATION, 15000);
    }

    private void updateMaxPreviousTime() {
        MAX_PREVIOUS_TIME = DeviceConfig.getLong("activity_manager", KEY_MAX_PREVIOUS_TIME, 60000);
    }

    private void updateProcStateDebugUids() {
        String val = DeviceConfig.getString("activity_manager", KEY_PROC_STATE_DEBUG_UIDS, "").trim();
        this.mEnableProcStateStacktrace = false;
        this.mProcStateDebugSetProcStateDelay = 0;
        this.mProcStateDebugSetUidStateDelay = 0;
        if (val.length() != 0) goto L6;
        this.mProcStateDebugUids = new SparseBooleanArray(0);
        return;
    L6:
        String[] uids = val.split(",");
        SparseBooleanArray newArray = new SparseBooleanArray(0);
        int r6 = uids.length;
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L33;
        String token = uids[r7];
        if (token.length() == 0) goto L32;
        if ("stack".equals(token) == false) goto L14;
        this.mEnableProcStateStacktrace = true;
        goto L32
    L14:
        boolean isUid = true;
        char prefix = token.charAt(0);
        if ('a' > prefix) goto L35;
        if (prefix > 'z') goto L35;
        isUid = false;
        token = token.substring(1);
    L35:
        int value = Integer.parseInt(token.trim());     // Catch: NumberFormatException -> L30
        if (isUid == false) goto L24;
        newArray.put(value, true);
        goto L32
    L24:
        if (prefix != 'p') goto L27;
        this.mProcStateDebugSetProcStateDelay = value;
        goto L32
    L27:
        if (prefix != 'u') goto L29;
        this.mProcStateDebugSetUidStateDelay = value;
        goto L32
    L29:
        Slog.w(TAG, "Invalid prefix " + prefix + " in " + val);
    L31:
        Slog.w(TAG, "Invalid number " + token + " in " + val);
    L32:
        r7 = r7 + 1;
        goto L7
    L33:
        this.mProcStateDebugUids = newArray;
    }

    private void updateMinAssocLogDuration() {
        MIN_ASSOC_LOG_DURATION = DeviceConfig.getLong("activity_manager", KEY_MIN_ASSOC_LOG_DURATION, 300000);
    }

    private void updateBinderHeavyHitterWatcher() {
        BINDER_HEAVY_HITTER_WATCHER_ENABLED = DeviceConfig.getBoolean("activity_manager", KEY_BINDER_HEAVY_HITTER_WATCHER_ENABLED, this.mDefaultBinderHeavyHitterWatcherEnabled);
        BINDER_HEAVY_HITTER_WATCHER_BATCHSIZE = DeviceConfig.getInt("activity_manager", KEY_BINDER_HEAVY_HITTER_WATCHER_BATCHSIZE, this.mDefaultBinderHeavyHitterWatcherBatchSize);
        BINDER_HEAVY_HITTER_WATCHER_THRESHOLD = DeviceConfig.getFloat("activity_manager", KEY_BINDER_HEAVY_HITTER_WATCHER_THRESHOLD, this.mDefaultBinderHeavyHitterWatcherThreshold);
        BINDER_HEAVY_HITTER_AUTO_SAMPLER_ENABLED = DeviceConfig.getBoolean("activity_manager", KEY_BINDER_HEAVY_HITTER_AUTO_SAMPLER_ENABLED, this.mDefaultBinderHeavyHitterAutoSamplerEnabled);
        BINDER_HEAVY_HITTER_AUTO_SAMPLER_BATCHSIZE = DeviceConfig.getInt("activity_manager", KEY_BINDER_HEAVY_HITTER_AUTO_SAMPLER_BATCHSIZE, this.mDefaultBinderHeavyHitterAutoSamplerBatchSize);
        BINDER_HEAVY_HITTER_WATCHER_THRESHOLD = DeviceConfig.getFloat("activity_manager", KEY_BINDER_HEAVY_HITTER_AUTO_SAMPLER_THRESHOLD, this.mDefaultBinderHeavyHitterAutoSamplerThreshold);
        this.mService.scheduleUpdateBinderHeavyHitterWatcherConfig();
    }

    private void updateMaxPhantomProcesses() {
        int oldVal = this.MAX_PHANTOM_PROCESSES;
        this.MAX_PHANTOM_PROCESSES = DeviceConfig.getInt("activity_manager", KEY_MAX_PHANTOM_PROCESSES, 32);
        if (oldVal <= this.MAX_PHANTOM_PROCESSES) goto L6;
        ActivityManagerService.MainHandler r1 = this.mService.mHandler;
        PhantomProcessList r2 = this.mService.mPhantomProcessList;
        r2.getClass();
        r1.post(new ActivityManagerConstants$$ExternalSyntheticLambda0(r2));
        return;
    }

    private void updateMaxServiceConnectionsPerProcess() {
        this.mMaxServiceConnectionsPerProcess = DeviceConfig.getInt("activity_manager", KEY_MAX_SERVICE_CONNECTIONS_PER_PROCESS, 3000);
    }

    private void updateShortFgsTimeoutDuration() {
        this.mShortFgsTimeoutDuration = DeviceConfig.getLong("activity_manager", KEY_SHORT_FGS_TIMEOUT_DURATION, 180000);
    }

    private void updateShortFgsProcStateExtraWaitDuration() {
        this.mShortFgsProcStateExtraWaitDuration = DeviceConfig.getLong("activity_manager", KEY_SHORT_FGS_PROC_STATE_EXTRA_WAIT_DURATION, 5000);
    }

    private void updateShortFgsAnrExtraWaitDuration() {
        this.mShortFgsAnrExtraWaitDuration = DeviceConfig.getLong("activity_manager", KEY_SHORT_FGS_ANR_EXTRA_WAIT_DURATION, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    private void updateMediaProcessingFgsTimeoutDuration() {
        this.mMediaProcessingFgsTimeoutDuration = DeviceConfig.getLong("activity_manager", KEY_MEDIA_PROCESSING_FGS_TIMEOUT_DURATION, 21600000);
    }

    private void updateDataSyncFgsTimeoutDuration() {
        this.mDataSyncFgsTimeoutDuration = DeviceConfig.getLong("activity_manager", KEY_DATA_SYNC_FGS_TIMEOUT_DURATION, 21600000);
    }

    private void updateFgsCrashExtraWaitDuration() {
        this.mFgsCrashExtraWaitDuration = DeviceConfig.getLong("activity_manager", KEY_FGS_CRASH_EXTRA_WAIT_DURATION, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    private void updateEnableWaitForFinishAttachApplication() {
        this.mEnableWaitForFinishAttachApplication = DeviceConfig.getBoolean("activity_manager", KEY_ENABLE_WAIT_FOR_FINISH_ATTACH_APPLICATION, true);
    }

    private void updateUseTieredCachedAdj() {
        this.USE_TIERED_CACHED_ADJ = DeviceConfig.getBoolean("activity_manager", KEY_USE_TIERED_CACHED_ADJ, DEFAULT_USE_TIERED_CACHED_ADJ);
        this.TIERED_CACHED_ADJ_DECAY_TIME = DeviceConfig.getLong("activity_manager", KEY_TIERED_CACHED_ADJ_DECAY_TIME, 60000);
        this.TIERED_CACHED_ADJ_UI_TIER_SIZE = Math.min(DeviceConfig.getInt("activity_manager", KEY_TIERED_CACHED_ADJ_UI_TIER_SIZE, this.mDefaultTieredCachedAdjUiTierSize), 50);
    }

    private void updateEnableNewOomAdj() {
        this.ENABLE_NEW_OOMADJ = DeviceConfig.getBoolean("activity_manager_native_boot", KEY_ENABLE_NEW_OOMADJ, DEFAULT_ENABLE_NEW_OOM_ADJ);
    }

    private void updateFollowUpOomAdjUpdateWaitDuration() {
        this.FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION = DeviceConfig.getLong("activity_manager", KEY_FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION, 1000);
    }

    private void updateFGSPermissionEnforcementFlagsIfNecessary(String name) {
        ForegroundServiceTypePolicy.getDefaultPolicy().updatePermissionEnforcementFlagIfNecessary(name);
    }

    private void updateDisableAppProfilerPssProfiling() {
        this.APP_PROFILER_PSS_PROFILING_DISABLED = DeviceConfig.getBoolean("activity_manager", KEY_DISABLE_APP_PROFILER_PSS_PROFILING, this.mDefaultDisableAppProfilerPssProfiling);
    }

    private void updatePssToRssThresholdModifier() {
        this.PSS_TO_RSS_THRESHOLD_MODIFIER = DeviceConfig.getFloat("activity_manager", KEY_PSS_TO_RSS_THRESHOLD_MODIFIER, this.mDefaultPssToRssThresholdModifier);
    }

    private void updateEnableBatchingOomAdj() {
        this.ENABLE_BATCHING_OOM_ADJ = DeviceConfig.getBoolean("activity_manager_native_boot", KEY_ENABLE_BATCHING_OOM_ADJ, DEFAULT_ENABLE_BATCHING_OOM_ADJ);
    }

    boolean shouldDebugUidForProcState(int uid) {
        SparseBooleanArray ar = this.mProcStateDebugUids;
        int size = ar.size();
        if (size != 0) goto L6;
        return false;
    L6:
        if (size > 8) goto L17;
        int i = 0;
    L8:
        if (i >= size) goto L15;
        if (ar.keyAt(i) == uid) goto L12;
        i = i + 1;
        goto L8
    L12:
        return ar.valueAt(i);
    L15:
        return false;
    L17:
        return ar.get(uid, false);
    }

    boolean shouldEnableProcStateDebug() {
        if (this.mProcStateDebugUids.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NeverCompile
    void dump(PrintWriter pw) {
        pw.println("ACTIVITY MANAGER SETTINGS (dumpsys activity settings) activity_manager_constants:");
        pw.print("  ");
        pw.print(KEY_MAX_CACHED_PROCESSES);
        pw.print("=");
        pw.println(this.MAX_CACHED_PROCESSES);
        pw.print("  ");
        pw.print(KEY_BACKGROUND_SETTLE_TIME);
        pw.print("=");
        pw.println(this.BACKGROUND_SETTLE_TIME);
        pw.print("  ");
        pw.print(KEY_FGSERVICE_MIN_SHOWN_TIME);
        pw.print("=");
        pw.println(this.FGSERVICE_MIN_SHOWN_TIME);
        pw.print("  ");
        pw.print(KEY_FGSERVICE_MIN_REPORT_TIME);
        pw.print("=");
        pw.println(this.FGSERVICE_MIN_REPORT_TIME);
        pw.print("  ");
        pw.print(KEY_FGSERVICE_SCREEN_ON_BEFORE_TIME);
        pw.print("=");
        pw.println(this.FGSERVICE_SCREEN_ON_BEFORE_TIME);
        pw.print("  ");
        pw.print(KEY_FGSERVICE_SCREEN_ON_AFTER_TIME);
        pw.print("=");
        pw.println(this.FGSERVICE_SCREEN_ON_AFTER_TIME);
        pw.print("  ");
        pw.print(KEY_FGS_BOOT_COMPLETED_ALLOWLIST);
        pw.print("=");
        pw.println(this.FGS_BOOT_COMPLETED_ALLOWLIST);
        pw.print("  ");
        pw.print(KEY_CONTENT_PROVIDER_RETAIN_TIME);
        pw.print("=");
        pw.println(this.CONTENT_PROVIDER_RETAIN_TIME);
        pw.print("  ");
        pw.print(KEY_GC_TIMEOUT);
        pw.print("=");
        pw.println(this.GC_TIMEOUT);
        pw.print("  ");
        pw.print(KEY_GC_MIN_INTERVAL);
        pw.print("=");
        pw.println(this.GC_MIN_INTERVAL);
        pw.print("  ");
        pw.print(KEY_FORCE_BACKGROUND_CHECK_ON_RESTRICTED_APPS);
        pw.print("=");
        pw.println(this.FORCE_BACKGROUND_CHECK_ON_RESTRICTED_APPS);
        pw.print("  ");
        pw.print(KEY_FULL_PSS_MIN_INTERVAL);
        pw.print("=");
        pw.println(this.FULL_PSS_MIN_INTERVAL);
        pw.print("  ");
        pw.print(KEY_FULL_PSS_LOWERED_INTERVAL);
        pw.print("=");
        pw.println(this.FULL_PSS_LOWERED_INTERVAL);
        pw.print("  ");
        pw.print(KEY_POWER_CHECK_INTERVAL);
        pw.print("=");
        pw.println(this.POWER_CHECK_INTERVAL);
        pw.print("  ");
        pw.print(KEY_POWER_CHECK_MAX_CPU_1);
        pw.print("=");
        pw.println(this.POWER_CHECK_MAX_CPU_1);
        pw.print("  ");
        pw.print(KEY_POWER_CHECK_MAX_CPU_2);
        pw.print("=");
        pw.println(this.POWER_CHECK_MAX_CPU_2);
        pw.print("  ");
        pw.print(KEY_POWER_CHECK_MAX_CPU_3);
        pw.print("=");
        pw.println(this.POWER_CHECK_MAX_CPU_3);
        pw.print("  ");
        pw.print(KEY_POWER_CHECK_MAX_CPU_4);
        pw.print("=");
        pw.println(this.POWER_CHECK_MAX_CPU_4);
        pw.print("  ");
        pw.print(KEY_SERVICE_USAGE_INTERACTION_TIME_PRE_S);
        pw.print("=");
        pw.println(this.SERVICE_USAGE_INTERACTION_TIME_PRE_S);
        pw.print("  ");
        pw.print(KEY_SERVICE_USAGE_INTERACTION_TIME_POST_S);
        pw.print("=");
        pw.println(this.SERVICE_USAGE_INTERACTION_TIME_POST_S);
        pw.print("  ");
        pw.print(KEY_USAGE_STATS_INTERACTION_INTERVAL_PRE_S);
        pw.print("=");
        pw.println(this.USAGE_STATS_INTERACTION_INTERVAL_PRE_S);
        pw.print("  ");
        pw.print(KEY_USAGE_STATS_INTERACTION_INTERVAL_POST_S);
        pw.print("=");
        pw.println(this.USAGE_STATS_INTERACTION_INTERVAL_POST_S);
        pw.print("  ");
        pw.print(KEY_SERVICE_RESTART_DURATION);
        pw.print("=");
        pw.println(this.SERVICE_RESTART_DURATION);
        pw.print("  ");
        pw.print(KEY_SERVICE_RESET_RUN_DURATION);
        pw.print("=");
        pw.println(this.SERVICE_RESET_RUN_DURATION);
        pw.print("  ");
        pw.print(KEY_SERVICE_RESTART_DURATION_FACTOR);
        pw.print("=");
        pw.println(this.SERVICE_RESTART_DURATION_FACTOR);
        pw.print("  ");
        pw.print(KEY_SERVICE_MIN_RESTART_TIME_BETWEEN);
        pw.print("=");
        pw.println(this.SERVICE_MIN_RESTART_TIME_BETWEEN);
        pw.print("  ");
        pw.print(KEY_MAX_SERVICE_INACTIVITY);
        pw.print("=");
        pw.println(this.MAX_SERVICE_INACTIVITY);
        pw.print("  ");
        pw.print(KEY_BG_START_TIMEOUT);
        pw.print("=");
        pw.println(this.BG_START_TIMEOUT);
        pw.print("  ");
        pw.print(KEY_SERVICE_BG_ACTIVITY_START_TIMEOUT);
        pw.print("=");
        pw.println(this.SERVICE_BG_ACTIVITY_START_TIMEOUT);
        pw.print("  ");
        pw.print(KEY_BOUND_SERVICE_CRASH_RESTART_DURATION);
        pw.print("=");
        pw.println(this.BOUND_SERVICE_CRASH_RESTART_DURATION);
        pw.print("  ");
        pw.print(KEY_BOUND_SERVICE_CRASH_MAX_RETRY);
        pw.print("=");
        pw.println(this.BOUND_SERVICE_MAX_CRASH_RETRY);
        pw.print("  ");
        pw.print(KEY_PROCESS_START_ASYNC);
        pw.print("=");
        pw.println(this.FLAG_PROCESS_START_ASYNC);
        pw.print("  ");
        pw.print(KEY_MEMORY_INFO_THROTTLE_TIME);
        pw.print("=");
        pw.println(this.MEMORY_INFO_THROTTLE_TIME);
        pw.print("  ");
        pw.print(KEY_TOP_TO_FGS_GRACE_DURATION);
        pw.print("=");
        pw.println(this.TOP_TO_FGS_GRACE_DURATION);
        pw.print("  ");
        pw.print(KEY_TOP_TO_ALMOST_PERCEPTIBLE_GRACE_DURATION);
        pw.print("=");
        pw.println(this.TOP_TO_ALMOST_PERCEPTIBLE_GRACE_DURATION);
        pw.print("  ");
        pw.print(KEY_MIN_CRASH_INTERVAL);
        pw.print("=");
        pw.println(MIN_CRASH_INTERVAL);
        pw.print("  ");
        pw.print(KEY_PROCESS_CRASH_COUNT_RESET_INTERVAL);
        pw.print("=");
        pw.println(PROCESS_CRASH_COUNT_RESET_INTERVAL);
        pw.print("  ");
        pw.print(KEY_PROCESS_CRASH_COUNT_LIMIT);
        pw.print("=");
        pw.println(PROCESS_CRASH_COUNT_LIMIT);
        pw.print("  ");
        pw.print(KEY_IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES);
        pw.print("=");
        pw.println(Arrays.toString(this.IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES.toArray()));
        pw.print("  ");
        pw.print(KEY_IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES);
        pw.print("=");
        pw.println(Arrays.toString(this.IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES.toArray()));
        pw.print("  ");
        pw.print(KEY_MIN_ASSOC_LOG_DURATION);
        pw.print("=");
        pw.println(MIN_ASSOC_LOG_DURATION);
        pw.print("  ");
        pw.print(KEY_BINDER_HEAVY_HITTER_WATCHER_ENABLED);
        pw.print("=");
        pw.println(BINDER_HEAVY_HITTER_WATCHER_ENABLED);
        pw.print("  ");
        pw.print(KEY_BINDER_HEAVY_HITTER_WATCHER_BATCHSIZE);
        pw.print("=");
        pw.println(BINDER_HEAVY_HITTER_WATCHER_BATCHSIZE);
        pw.print("  ");
        pw.print(KEY_BINDER_HEAVY_HITTER_WATCHER_THRESHOLD);
        pw.print("=");
        pw.println(BINDER_HEAVY_HITTER_WATCHER_THRESHOLD);
        pw.print("  ");
        pw.print(KEY_BINDER_HEAVY_HITTER_AUTO_SAMPLER_ENABLED);
        pw.print("=");
        pw.println(BINDER_HEAVY_HITTER_AUTO_SAMPLER_ENABLED);
        pw.print("  ");
        pw.print(KEY_BINDER_HEAVY_HITTER_AUTO_SAMPLER_BATCHSIZE);
        pw.print("=");
        pw.println(BINDER_HEAVY_HITTER_AUTO_SAMPLER_BATCHSIZE);
        pw.print("  ");
        pw.print(KEY_BINDER_HEAVY_HITTER_AUTO_SAMPLER_THRESHOLD);
        pw.print("=");
        pw.println(BINDER_HEAVY_HITTER_AUTO_SAMPLER_THRESHOLD);
        pw.print("  ");
        pw.print(KEY_MAX_PHANTOM_PROCESSES);
        pw.print("=");
        pw.println(this.MAX_PHANTOM_PROCESSES);
        pw.print("  ");
        pw.print(KEY_BOOT_TIME_TEMP_ALLOWLIST_DURATION);
        pw.print("=");
        pw.println(this.mBootTimeTempAllowlistDuration);
        pw.print("  ");
        pw.print(KEY_FG_TO_BG_FGS_GRACE_DURATION);
        pw.print("=");
        pw.println(this.mFgToBgFgsGraceDuration);
        pw.print("  ");
        pw.print(KEY_FGS_START_FOREGROUND_TIMEOUT);
        pw.print("=");
        pw.println(this.mFgsStartForegroundTimeoutMs);
        pw.print("  ");
        pw.print(KEY_DEFAULT_BACKGROUND_ACTIVITY_STARTS_ENABLED);
        pw.print("=");
        pw.println(this.mFlagBackgroundActivityStartsEnabled);
        pw.print("  ");
        pw.print(KEY_DEFAULT_BACKGROUND_FGS_STARTS_RESTRICTION_ENABLED);
        pw.print("=");
        pw.println(this.mFlagBackgroundFgsStartRestrictionEnabled);
        pw.print("  ");
        pw.print(KEY_DEFAULT_FGS_STARTS_RESTRICTION_ENABLED);
        pw.print("=");
        pw.println(this.mFlagFgsStartRestrictionEnabled);
        pw.print("  ");
        pw.print(KEY_DEFAULT_FGS_STARTS_RESTRICTION_NOTIFICATION_ENABLED);
        pw.print("=");
        pw.println(this.mFgsStartRestrictionNotificationEnabled);
        pw.print("  ");
        pw.print(KEY_DEFAULT_FGS_STARTS_RESTRICTION_CHECK_CALLER_TARGET_SDK);
        pw.print("=");
        pw.println(this.mFgsStartRestrictionCheckCallerTargetSdk);
        pw.print("  ");
        pw.print(KEY_FGS_ATOM_SAMPLE_RATE);
        pw.print("=");
        pw.println(this.mFgsAtomSampleRate);
        pw.print("  ");
        pw.print(KEY_FGS_START_ALLOWED_LOG_SAMPLE_RATE);
        pw.print("=");
        pw.println(this.mFgsStartAllowedLogSampleRate);
        pw.print("  ");
        pw.print(KEY_FGS_START_DENIED_LOG_SAMPLE_RATE);
        pw.print("=");
        pw.println(this.mFgsStartDeniedLogSampleRate);
        pw.print("  ");
        pw.print(KEY_PUSH_MESSAGING_OVER_QUOTA_BEHAVIOR);
        pw.print("=");
        pw.println(this.mPushMessagingOverQuotaBehavior);
        pw.print("  ");
        pw.print(KEY_FGS_ALLOW_OPT_OUT);
        pw.print("=");
        pw.println(this.mFgsAllowOptOut);
        pw.print("  ");
        pw.print(KEY_ENABLE_COMPONENT_ALIAS);
        pw.print("=");
        pw.println(this.mEnableComponentAlias);
        pw.print("  ");
        pw.print(KEY_COMPONENT_ALIAS_OVERRIDES);
        pw.print("=");
        pw.println(this.mComponentAliasOverrides);
        pw.print("  ");
        pw.print(KEY_DEFER_BOOT_COMPLETED_BROADCAST);
        pw.print("=");
        pw.println(this.mDeferBootCompletedBroadcast);
        pw.print("  ");
        pw.print(KEY_PRIORITIZE_ALARM_BROADCASTS);
        pw.print("=");
        pw.println(this.mPrioritizeAlarmBroadcasts);
        pw.print("  ");
        pw.print(KEY_NO_KILL_CACHED_PROCESSES_UNTIL_BOOT_COMPLETED);
        pw.print("=");
        pw.println(this.mNoKillCachedProcessesUntilBootCompleted);
        pw.print("  ");
        pw.print(KEY_NO_KILL_CACHED_PROCESSES_POST_BOOT_COMPLETED_DURATION_MILLIS);
        pw.print("=");
        pw.println(this.mNoKillCachedProcessesPostBootCompletedDurationMillis);
        pw.print("  ");
        pw.print(KEY_MAX_EMPTY_TIME_MILLIS);
        pw.print("=");
        pw.println(this.mMaxEmptyTimeMillis);
        pw.print("  ");
        pw.print(KEY_SERVICE_START_FOREGROUND_TIMEOUT_MS);
        pw.print("=");
        pw.println(this.mServiceStartForegroundTimeoutMs);
        pw.print("  ");
        pw.print(KEY_SERVICE_START_FOREGROUND_ANR_DELAY_MS);
        pw.print("=");
        pw.println(this.mServiceStartForegroundAnrDelayMs);
        pw.print("  ");
        pw.print(KEY_SERVICE_BIND_ALMOST_PERCEPTIBLE_TIMEOUT_MS);
        pw.print("=");
        pw.println(this.mServiceBindAlmostPerceptibleTimeoutMs);
        pw.print("  ");
        pw.print(KEY_NETWORK_ACCESS_TIMEOUT_MS);
        pw.print("=");
        pw.println(this.mNetworkAccessTimeoutMs);
        pw.print("  ");
        pw.print(KEY_MAX_SERVICE_CONNECTIONS_PER_PROCESS);
        pw.print("=");
        pw.println(this.mMaxServiceConnectionsPerProcess);
        pw.print("  ");
        pw.print(KEY_PROACTIVE_KILLS_ENABLED);
        pw.print("=");
        pw.println(PROACTIVE_KILLS_ENABLED);
        pw.print("  ");
        pw.print(KEY_LOW_SWAP_THRESHOLD_PERCENT);
        pw.print("=");
        pw.println(LOW_SWAP_THRESHOLD_PERCENT);
        pw.print("  ");
        pw.print(KEY_DEFERRED_FGS_NOTIFICATIONS_ENABLED);
        pw.print("=");
        pw.println(this.mFlagFgsNotificationDeferralEnabled);
        pw.print("  ");
        pw.print(KEY_DEFERRED_FGS_NOTIFICATIONS_API_GATED);
        pw.print("=");
        pw.println(this.mFlagFgsNotificationDeferralApiGated);
        pw.print("  ");
        pw.print(KEY_DEFERRED_FGS_NOTIFICATION_INTERVAL);
        pw.print("=");
        pw.println(this.mFgsNotificationDeferralInterval);
        pw.print("  ");
        pw.print(KEY_DEFERRED_FGS_NOTIFICATION_INTERVAL_FOR_SHORT);
        pw.print("=");
        pw.println(this.mFgsNotificationDeferralIntervalForShort);
        pw.print("  ");
        pw.print(KEY_DEFERRED_FGS_NOTIFICATION_EXCLUSION_TIME);
        pw.print("=");
        pw.println(this.mFgsNotificationDeferralExclusionTime);
        pw.print("  ");
        pw.print(KEY_DEFERRED_FGS_NOTIFICATION_EXCLUSION_TIME_FOR_SHORT);
        pw.print("=");
        pw.println(this.mFgsNotificationDeferralExclusionTimeForShort);
        pw.print("  ");
        pw.print(KEY_SYSTEM_EXEMPT_POWER_RESTRICTIONS_ENABLED);
        pw.print("=");
        pw.println(this.mFlagSystemExemptPowerRestrictionsEnabled);
        pw.print("  ");
        pw.print(KEY_SHORT_FGS_TIMEOUT_DURATION);
        pw.print("=");
        pw.println(this.mShortFgsTimeoutDuration);
        pw.print("  ");
        pw.print(KEY_SHORT_FGS_PROC_STATE_EXTRA_WAIT_DURATION);
        pw.print("=");
        pw.println(this.mShortFgsProcStateExtraWaitDuration);
        pw.print("  ");
        pw.print(KEY_SHORT_FGS_ANR_EXTRA_WAIT_DURATION);
        pw.print("=");
        pw.println(this.mShortFgsAnrExtraWaitDuration);
        pw.print("  ");
        pw.print(KEY_MEDIA_PROCESSING_FGS_TIMEOUT_DURATION);
        pw.print("=");
        pw.println(this.mMediaProcessingFgsTimeoutDuration);
        pw.print("  ");
        pw.print(KEY_DATA_SYNC_FGS_TIMEOUT_DURATION);
        pw.print("=");
        pw.println(this.mDataSyncFgsTimeoutDuration);
        pw.print("  ");
        pw.print(KEY_FGS_CRASH_EXTRA_WAIT_DURATION);
        pw.print("=");
        pw.println(this.mFgsCrashExtraWaitDuration);
        pw.print("  ");
        pw.print(KEY_USE_TIERED_CACHED_ADJ);
        pw.print("=");
        pw.println(this.USE_TIERED_CACHED_ADJ);
        pw.print("  ");
        pw.print(KEY_TIERED_CACHED_ADJ_DECAY_TIME);
        pw.print("=");
        pw.println(this.TIERED_CACHED_ADJ_DECAY_TIME);
        pw.print("  ");
        pw.print(KEY_TIERED_CACHED_ADJ_UI_TIER_SIZE);
        pw.print("=");
        pw.println(this.TIERED_CACHED_ADJ_UI_TIER_SIZE);
        pw.print("  ");
        pw.print(KEY_ENABLE_NEW_OOMADJ);
        pw.print("=");
        pw.println(this.ENABLE_NEW_OOMADJ);
        pw.print("  ");
        pw.print(KEY_FREEZER_CUTOFF_ADJ);
        pw.print("=");
        pw.println(this.FREEZER_CUTOFF_ADJ);
        pw.print("  ");
        pw.print(KEY_DISABLE_APP_PROFILER_PSS_PROFILING);
        pw.print("=");
        pw.println(this.APP_PROFILER_PSS_PROFILING_DISABLED);
        pw.print("  ");
        pw.print(KEY_PSS_TO_RSS_THRESHOLD_MODIFIER);
        pw.print("=");
        pw.println(this.PSS_TO_RSS_THRESHOLD_MODIFIER);
        pw.print("  ");
        pw.print(KEY_MAX_PREVIOUS_TIME);
        pw.print("=");
        pw.println(MAX_PREVIOUS_TIME);
        pw.print("  ");
        pw.print(KEY_ENABLE_BATCHING_OOM_ADJ);
        pw.print("=");
        pw.println(this.ENABLE_BATCHING_OOM_ADJ);
        pw.println();
        if (this.mOverrideMaxCachedProcesses < 0) goto L5;
        pw.print("  mOverrideMaxCachedProcesses=");
        pw.println(this.mOverrideMaxCachedProcesses);
    L5:
        pw.print("  mCustomizedMaxCachedProcesses=");
        pw.println(this.mCustomizedMaxCachedProcesses);
        pw.print("  CUR_MAX_CACHED_PROCESSES=");
        pw.println(this.CUR_MAX_CACHED_PROCESSES);
        pw.print("  CUR_MAX_EMPTY_PROCESSES=");
        pw.println(this.CUR_MAX_EMPTY_PROCESSES);
        pw.print("  CUR_TRIM_EMPTY_PROCESSES=");
        pw.println(this.CUR_TRIM_EMPTY_PROCESSES);
        pw.print("  CUR_TRIM_CACHED_PROCESSES=");
        pw.println(this.CUR_TRIM_CACHED_PROCESSES);
        pw.print("  OOMADJ_UPDATE_QUICK=");
        pw.println(this.OOMADJ_UPDATE_QUICK);
        pw.print("  ENABLE_WAIT_FOR_FINISH_ATTACH_APPLICATION=");
        pw.println(this.mEnableWaitForFinishAttachApplication);
        pw.print("  ");
        pw.print(KEY_FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION);
        pw.print("=");
        pw.println(this.FOLLOW_UP_OOMADJ_UPDATE_WAIT_DURATION);
        SparseBooleanArray r0 = this.mProcStateDebugUids;
        monitor-enter(r0);
        pw.print("  ");     // Catch: Throwable -> L10
        pw.print(KEY_PROC_STATE_DEBUG_UIDS);     // Catch: Throwable -> L10
        pw.print("=");     // Catch: Throwable -> L10
        pw.println(this.mProcStateDebugUids);     // Catch: Throwable -> L10
        pw.print("    uid-state-delay=");     // Catch: Throwable -> L10
        pw.println(this.mProcStateDebugSetUidStateDelay);     // Catch: Throwable -> L10
        pw.print("    proc-state-delay=");     // Catch: Throwable -> L10
        pw.println(this.mProcStateDebugSetProcStateDelay);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
