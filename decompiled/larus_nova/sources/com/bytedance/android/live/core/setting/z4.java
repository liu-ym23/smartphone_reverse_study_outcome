package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class z4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z4 f65471a = null;

    static {
        z4 r100 = new z4();
        f65471a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public z4() {
        Boolean r100 = Boolean.FALSE;
        super("live_setting_applog_key", "拉流端播放器日志是否使用applog上报", r100, r100);
    }
}
