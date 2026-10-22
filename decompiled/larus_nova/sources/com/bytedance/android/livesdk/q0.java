package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class q0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f156873a = null;

    static {
        f156873a = new q0();
    }

    public q0() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_landscape_player_top_margin", "横屏播放器顶部区域未充满修复", r100, r100);
    }
}
