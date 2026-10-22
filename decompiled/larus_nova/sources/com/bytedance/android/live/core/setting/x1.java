package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.HalfScreenBackgroundConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class x1 extends SSettingKey<HalfScreenBackgroundConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f65452a = null;

    static {
        x1 r100 = new x1();
        f65452a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public x1() {
        super("live_half_screen_background_opt", "半屏流背景图优化", new HalfScreenBackgroundConfig(), new HalfScreenBackgroundConfig());
    }
}
