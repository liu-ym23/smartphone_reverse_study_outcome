package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class y4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y4 f65463a = null;

    static {
        f65463a = new y4();
    }

    public y4() {
        Boolean r100 = Boolean.TRUE;
        super("live_sei_pc_compatible_enable", "SEI处理兼容伴侣KTV逻辑", r100, r100);
    }
}
