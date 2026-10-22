package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class a5 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a5 f65207a = null;

    static {
        a5 r100 = new a5();
        f65207a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public a5() {
        super("live_setting_applog_key_event_mask", "拉流端播放器日志使用applog上报事件名", 0L, 0L);
    }
}
