package com.bytedance.android.livesdkapi.init;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 #2\u00020\u0001:\u0001#J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0005H&J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u001c\u001a\u00020\u001dH&J \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/ILiveInitAssistant;", "", "isInitFinish", "", "markDuration", "", "name", "", "duration", "", "markEnablePreInit", "markError", "markGetServiceNpe", "serviceName", "markInfo", "key", "value", "markInitFinished", "markInitStart", "markIsNewUser", "markScene", "scene", "pageType", "position", "", "markThread", "markTimeEnd", "markTimeStart", "optimizeConfig", "Lcom/bytedance/android/livesdkapi/init/LiveInitializeSettingConfig;", "setInitConfig", "loggerConfig", "Lcom/bytedance/android/livesdkapi/init/LiveInitLoggerConfig;", "initConfig", "Lcom/bytedance/android/livesdkapi/init/LiveInitConfigInner;", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveInitAssistant {
    public static final String ACTION_HANDLER_INIT_DURATION = "action_handler_init_duration";
    public static final String AI_SERVICE_INIT_DURATION = "ai_service_init_duration";
    public static final Companion Companion = null;
    public static final String ENABLE_MULTI_THREAD_SCHEDULE = "enable_multi_thread_schedule";
    public static final String FEATURE_SERVICE_INIT_DURATION = "feature_service_init_duration";
    public static final String GET_SERVICE_NPE_ERROR = "get_service_npe_error";
    public static final String HAS_PRE_INIT = "has_pre_init";
    public static final String HOST_SERVICE_INIT_DURATION = "host_service_init_duration";
    public static final String INIT_DURATION = "init_duration";
    public static final String INIT_EXECUTE_PHASE = "init_execute_phase";
    public static final String INIT_THREAD = "init_thread";
    public static final String INIT_THREAD_ERROR = "init_thread_expect";
    public static final String INIT_TOTAL_DURATION = "init_total_duration";
    public static final String INIT_TRIGGER_ERROR = "init_trigger_error";
    public static final String INIT_TRIGGER_FROM = "init_trigger_from";
    public static final String KEY_IS_FROM_DEEPLINK = "is_from_deeplink";
    public static final String LIVE_KMP_GLOBAL_SCOPE_ENTER_DURATION = "live_kmp_global_scope_enter_duration";
    public static final String LIVE_SDK_COMPONENT_INIT_DURATION = "livesdk_component_init_duration";
    public static final String LIVE_SDK_INITIALIZE_DURATION = "livesdk_initialize_duration";
    public static final String LIVE_SDK_SERVICE_INIT_DURATION = "livesdk_service_init_duration";
    public static final String NPE_SERVICE_NPE_LIST = "get_service_npe_error_list";
    public static final String PRE_INIT_DURATION = "pre_init_duration";
    public static final String PRE_INIT_THREAD = "pre_init_thread";
    public static final String PRE_INIT_THREAD_ERROR = "pre_init_thread_error";
    public static final String PRE_INIT_TRIGGER_SCENE = "pre_init_trigger_scene";
    public static final String REVENUE_GLOBAL_SCOPE_ENTER_DURATION = "revenue_global_scope_enter_duration";
    public static final String REVENUE_SERVICE_INIT_DURATION = "revenue_service_init_duration";
    public static final String REVENUE_SERVICE_REGISTER_DURATION = "revenue_service_register_duration";
    public static final String STREAM_STRATEGY_INIT_DURATION = "stream_strategy_init_duration";
    public static final String UPDATE_SETTING_IN_INIT = "update_setting_in_init";
    public static final String WAIT_INIT_LOCK = "main_thread_wait_lock_error";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/init/ILiveInitAssistant$Companion;", "", "()V", "ACTION_HANDLER_INIT_DURATION", "", "AI_SERVICE_INIT_DURATION", "ENABLE_MULTI_THREAD_SCHEDULE", "FEATURE_SERVICE_INIT_DURATION", "GET_SERVICE_NPE_ERROR", "HAS_PRE_INIT", "HOST_SERVICE_INIT_DURATION", "INIT_DURATION", "INIT_EXECUTE_PHASE", "INIT_THREAD", "INIT_THREAD_ERROR", "INIT_TOTAL_DURATION", "INIT_TRIGGER_ERROR", "INIT_TRIGGER_FROM", "KEY_IS_FROM_DEEPLINK", "LIVE_KMP_GLOBAL_SCOPE_ENTER_DURATION", "LIVE_SDK_COMPONENT_INIT_DURATION", "LIVE_SDK_INITIALIZE_DURATION", "LIVE_SDK_SERVICE_INIT_DURATION", "NPE_SERVICE_NPE_LIST", "PRE_INIT_DURATION", "PRE_INIT_THREAD", "PRE_INIT_THREAD_ERROR", "PRE_INIT_TRIGGER_SCENE", "REVENUE_GLOBAL_SCOPE_ENTER_DURATION", "REVENUE_SERVICE_INIT_DURATION", "REVENUE_SERVICE_REGISTER_DURATION", "STREAM_STRATEGY_INIT_DURATION", "UPDATE_SETTING_IN_INIT", "WAIT_INIT_LOCK", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String ACTION_HANDLER_INIT_DURATION = "action_handler_init_duration";
        public static final String AI_SERVICE_INIT_DURATION = "ai_service_init_duration";
        public static final String ENABLE_MULTI_THREAD_SCHEDULE = "enable_multi_thread_schedule";
        public static final String FEATURE_SERVICE_INIT_DURATION = "feature_service_init_duration";
        public static final String GET_SERVICE_NPE_ERROR = "get_service_npe_error";
        public static final String HAS_PRE_INIT = "has_pre_init";
        public static final String HOST_SERVICE_INIT_DURATION = "host_service_init_duration";
        public static final String INIT_DURATION = "init_duration";
        public static final String INIT_EXECUTE_PHASE = "init_execute_phase";
        public static final String INIT_THREAD = "init_thread";
        public static final String INIT_THREAD_ERROR = "init_thread_expect";
        public static final String INIT_TOTAL_DURATION = "init_total_duration";
        public static final String INIT_TRIGGER_ERROR = "init_trigger_error";
        public static final String INIT_TRIGGER_FROM = "init_trigger_from";
        public static final String KEY_IS_FROM_DEEPLINK = "is_from_deeplink";
        public static final String LIVE_KMP_GLOBAL_SCOPE_ENTER_DURATION = "live_kmp_global_scope_enter_duration";
        public static final String LIVE_SDK_COMPONENT_INIT_DURATION = "livesdk_component_init_duration";
        public static final String LIVE_SDK_INITIALIZE_DURATION = "livesdk_initialize_duration";
        public static final String LIVE_SDK_SERVICE_INIT_DURATION = "livesdk_service_init_duration";
        public static final String NPE_SERVICE_NPE_LIST = "get_service_npe_error_list";
        public static final String PRE_INIT_DURATION = "pre_init_duration";
        public static final String PRE_INIT_THREAD = "pre_init_thread";
        public static final String PRE_INIT_THREAD_ERROR = "pre_init_thread_error";
        public static final String PRE_INIT_TRIGGER_SCENE = "pre_init_trigger_scene";
        public static final String REVENUE_GLOBAL_SCOPE_ENTER_DURATION = "revenue_global_scope_enter_duration";
        public static final String REVENUE_SERVICE_INIT_DURATION = "revenue_service_init_duration";
        public static final String REVENUE_SERVICE_REGISTER_DURATION = "revenue_service_register_duration";
        public static final String STREAM_STRATEGY_INIT_DURATION = "stream_strategy_init_duration";
        public static final String UPDATE_SETTING_IN_INIT = "update_setting_in_init";
        public static final String WAIT_INIT_LOCK = "main_thread_wait_lock_error";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean isInitFinish();

    void markDuration(String r100, long r101);

    void markEnablePreInit();

    void markError(String r100);

    void markGetServiceNpe(String r100);

    void markInfo(String r100, String r101);

    void markInitFinished();

    void markInitStart();

    void markIsNewUser();

    void markScene(String r100, long r101, int r102);

    void markThread(String r100);

    void markTimeEnd(String r100);

    void markTimeStart(String r100);

    LiveInitializeSettingConfig optimizeConfig();

    void setInitConfig(LiveInitializeSettingConfig r100, LiveInitLoggerConfig r101, LiveInitConfigInner r102);
}
