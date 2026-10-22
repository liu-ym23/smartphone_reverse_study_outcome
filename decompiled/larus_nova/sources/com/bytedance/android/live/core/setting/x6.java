package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class x6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x6 f65457a = null;

    static {
        f65457a = new x6();
    }

    public x6() {
        Boolean r100 = Boolean.TRUE;
        super("player_first_sei_fix_accurate_close", "播放器首帧SEI精准开关", r100, r100);
    }
}
