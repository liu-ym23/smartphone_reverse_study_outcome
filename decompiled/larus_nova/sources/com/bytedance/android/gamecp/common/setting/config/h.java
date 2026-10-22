package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/h;", "", "", "enableFloatView", "Z", "getEnableFloatView", "()Z", "enableQueueContainer", "getEnableQueueContainer", "enableJSBRegisterForRuntime", "getEnableJSBRegisterForRuntime", "enableDynamicLoadManager", "getEnableDynamicLoadManager", "enableFixTransparentRegion", "getEnableFixTransparentRegion", "", "dynamicLoadManagerSchema", "Ljava/lang/String;", "getDynamicLoadManagerSchema", "()Ljava/lang/String;", "restartClearInitCacheEvent", "getRestartClearInitCacheEvent", "sendCopyJson", "getSendCopyJson", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("dynamic_load_manager_schema")
    private final String dynamicLoadManagerSchema;

    @SerializedName("enable_dynamic_load_manager")
    private final boolean enableDynamicLoadManager;

    @SerializedName("enable_fix_transparent_region")
    private final boolean enableFixTransparentRegion;

    @SerializedName("enable_float_view")
    private final boolean enableFloatView;

    @SerializedName("enable_jsb_register_for_runtime")
    private final boolean enableJSBRegisterForRuntime;

    @SerializedName("enable_queue_container")
    private final boolean enableQueueContainer;

    @SerializedName("restart_clear_init_cache_event")
    private final boolean restartClearInitCacheEvent;

    @SerializedName("send_copy_json")
    private final boolean sendCopyJson;

    public h() {
        this.enableFloatView = true;
        this.enableQueueContainer = true;
        this.enableJSBRegisterForRuntime = true;
        this.enableDynamicLoadManager = true;
        this.enableFixTransparentRegion = true;
        this.dynamicLoadManagerSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Fxplay_dynamic_load_manager%2Ftemplate.js%3Fbusiness_type%3Dgamecp_group&bdhm_bid=instant_play&enable_latch=1&mix_container_type=annie&settings_keys=live_gmcp_xplay_map_music_roulette_enter_method";
        this.restartClearInitCacheEvent = true;
        this.sendCopyJson = true;
    }
}
