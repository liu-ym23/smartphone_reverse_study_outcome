package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class h2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h2 f65313a = null;

    static {
        f65313a = new h2();
    }

    public h2() {
        Boolean r100 = Boolean.TRUE;
        super("live_load_short_touch_bigcard_anim_enable", "短触大卡动画单独打开", r100, r100);
    }
}
