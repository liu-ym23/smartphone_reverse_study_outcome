package com.bytedance.android.gamecp.common.setting;

import android.content.Context;
import com.bytedance.android.gamecp.common.setting.config.s2;
import com.bytedance.android.gamecp.common.utils.LiveSdkInitHelper;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import wu.q0;

/* JADX INFO: loaded from: classes44.dex */
public class LiveInitSettingKeys {
    public static final String LIVE_LOGSDK_CONFIG_STR = "live_logsdk_config";

    public LiveInitSettingKeys() {
    }

    public static s2 get_LIVE_LOGSDK_CONFIG() {
        if (isSettingOpt() == false) goto L7;
        return (s2) getJsonConfig("live_logsdk_config", s2.class, new s2());
    L7:
        return q0.f561372a.getValue();
    }

    private static boolean isSettingOpt() {
        return LiveSdkInitHelper.isEnableSettingOpt();
    }

    private static <T> T getJsonConfig(String r100, Class<T> r101, T r102) {
        Context r103 = LiveSdkInitHelper.getContext();     // Catch: Exception -> L8
        if (r103 == null) goto L10;
        String r104 = r103.getSharedPreferences("ttlive_sdk_shared_pref_cache", 0).getString(r100, "");     // Catch: Exception -> L8
        T r105 = (T) GsonHelper.get().fromJson(r104, r101);
        if (r105 != null) goto L7;
        return r102;
    L7:
        return r105;
    L10:
        return r102;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
