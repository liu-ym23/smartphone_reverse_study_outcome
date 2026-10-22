package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class w5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w5 f65448a = null;

    static {
        f65448a = new w5();
    }

    public w5() {
        Boolean r100 = Boolean.TRUE;
        super("live_vr_top_margin_fix", "VR沉浸模式下顶部间距修复", r100, r100);
    }
}
