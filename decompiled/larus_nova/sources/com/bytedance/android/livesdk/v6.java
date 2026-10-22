package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class v6 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f159244a = null;

    static {
        f159244a = new v6();
    }

    public v6() {
        Boolean r100 = Boolean.TRUE;
        super("live_play_param_add_btm", "livesdk_live_play埋点使用BTM统一参数", r100, r100);
    }
}
