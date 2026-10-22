package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class pd extends SettingKey<j11> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pd f120969a = null;

    static {
        pd r100 = new pd();
        f120969a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public pd() {
        super("live_animation_center_controller", "直播动画中心管理器", new j11(), new j11());
    }
}
