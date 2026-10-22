package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class g5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g5 f65307a = null;

    static {
        f65307a = new g5();
    }

    public g5() {
        Boolean r100 = Boolean.FALSE;
        super("live_short_touch_queue_expand_animation", "短触区排队放大动画", r100, r100);
    }
}
