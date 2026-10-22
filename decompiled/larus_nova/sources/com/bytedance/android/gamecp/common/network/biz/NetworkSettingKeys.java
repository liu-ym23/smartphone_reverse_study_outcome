package com.bytedance.android.gamecp.common.network.biz;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public interface NetworkSettingKeys {
    public static final SettingKey<Boolean> ENABLE_PB_REQUESTS = null;
    public static final SettingKey<String> PB_REQUEST_SWITCHES = null;
    public static final SettingKey<Integer> USE_PB_OBJECT_JSON_PASS_THROUGH = null;

    static {
        Boolean r100 = Boolean.TRUE;
        ENABLE_PB_REQUESTS = new SettingKey("enable_pb_requests", "PB 请求开关", r100, r100);
        USE_PB_OBJECT_JSON_PASS_THROUGH = new SettingKey("use_pb_object_json_pass_through", "PB 请求使用内网服务透传（0：关；1：只读；2：查看&抓包）", 0, 0);
        PB_REQUEST_SWITCHES = new SettingKey("pb_request_switches", "PB 请求的开关合集", "{\"room\": true, \"rank_list\": true, \"comment\": true, \"feed\": true, \"report\": true, \"lucky_box\": true, \"gift\": true}", "{\"room\": true, \"rank_list\": true, \"comment\": true, \"feed\": true, \"report\": true, \"lucky_box\": true, \"gift\": true}");
    }
}
