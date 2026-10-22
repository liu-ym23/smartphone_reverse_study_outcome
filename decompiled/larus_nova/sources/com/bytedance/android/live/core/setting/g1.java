package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class g1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f65303a = null;

    static {
        f65303a = new g1();
    }

    public g1() {
        Boolean r100 = Boolean.TRUE;
        super("live_enhanced_short_touch_animation_close", "强化短触区消失时关闭右移动画", r100, r100);
    }
}
