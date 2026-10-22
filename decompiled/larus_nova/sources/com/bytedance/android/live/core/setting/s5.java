package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class s5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s5 f65409a = null;

    static {
        f65409a = new s5();
    }

    public s5() {
        Boolean r100 = Boolean.FALSE;
        super("live_use_short_touch_dismiss_animation", "使用短触区退出动画", r100, r100);
    }
}
