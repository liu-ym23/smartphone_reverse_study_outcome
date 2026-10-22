package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class x3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x3 f65454a = null;

    static {
        f65454a = new x3();
    }

    public x3() {
        Boolean r100 = Boolean.TRUE;
        super("live_play_together_toolbar_opt", "适用于一起玩场景下的toolbar优化的端上兜底总开关", r100, r100);
    }
}
