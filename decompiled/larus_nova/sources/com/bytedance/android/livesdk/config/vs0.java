package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.SmoothAnimSetting;

/* JADX INFO: loaded from: classes8.dex */
public final class vs0 extends SSettingKey<SmoothAnimSetting> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vs0 f121475a = null;

    static {
        f121475a = new vs0();
    }

    public vs0() {
        super("live_smooth_anim_config", "直播带动画的平滑进房", new SmoothAnimSetting(), new SmoothAnimSetting(), true);
    }
}
