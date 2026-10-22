package com.bytedance.android.live.network;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.setting.w;

/* JADX INFO: loaded from: classes46.dex */
public interface NetworkSettingKeys {
    public static final SettingKey<Boolean> ENABLE_PB_REQUESTS = null;
    public static final SettingKey<Integer> LIVE_NETWORK_AB_CUT_GROUP = null;
    public static final SettingKey<Boolean> MINOR_INTERCEPT_USE_SERVER_PROMPTS = null;
    public static final SettingKey<Boolean> OPT_FLEX_MODEL_REFLECTIVE_DATA_NODE_TO_JSON_OBJECT = null;
    public static final SettingKey<Boolean> PB_REQUEST_STRATEGY = null;
    public static final SettingKey<String> PB_REQUEST_SWITCHES = null;
    public static final SettingKey<Integer> USE_PB_OBJECT_JSON_PASS_THROUGH = null;

    static {
        LIVE_NETWORK_AB_CUT_GROUP = new SettingKey("live_network_ab_cut_group", "直播网络接口AB剪裁", 1, 1);
        Boolean r100 = Boolean.TRUE;
        ENABLE_PB_REQUESTS = new SettingKey("enable_pb_requests", "PB 请求开关", r100, r100).setPreloadCache(w.a());
        USE_PB_OBJECT_JSON_PASS_THROUGH = new SettingKey("use_pb_object_json_pass_through", "PB 请求使用内网服务透传（0：关；1：只读；2：查看&抓包）", 0, 0);
        PB_REQUEST_STRATEGY = new SettingKey("pb_request_strategy", "策略请求使用PB", r100, r100);
        PB_REQUEST_SWITCHES = new SettingKey("pb_request_switches", "PB 请求的开关合集", "{\"room\": true, \"rank_list\": true, \"feed\": true, \"report\": true, \"popular\": true, \"lucky_box\": true, \"gift\": true, \"pk\": true, \"multi_link\": true, \"pk_or_multi\": true}", "{\"room\": true, \"rank_list\": true, \"feed\": true, \"report\": true, \"popular\": true, \"lucky_box\": true, \"gift\": true, \"pk\": true, \"multi_link\": true, \"pk_or_multi\": true}");
        MINOR_INTERCEPT_USE_SERVER_PROMPTS = new SettingKey("minor_intercept_use_server_prompts", "42200错误码，未成年拦截，toast提示，是否采用Server下发的文案，true-是，false-不采用server下发", r100, r100);
        OPT_FLEX_MODEL_REFLECTIVE_DATA_NODE_TO_JSON_OBJECT = new SettingKey("opt_flex_model_reflective_data_node_to_json_object", "开启对 ReflectiveDataNode#toJsonObject 的优化，减少重复序列化带来的性能消耗", r100, r100);
    }
}
