package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class l70 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l70 f120657a = null;

    static {
        f120657a = new l70();
    }

    public l70() {
        Boolean r100 = Boolean.TRUE;
        super("live_long_press_guide_opt", "LongPressGuideHelper.show()开关", r100, r100);
    }
}
