package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class q3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q3 f65391a = null;

    static {
        f65391a = new q3();
    }

    public q3() {
        Boolean r100 = Boolean.FALSE;
        super("live_performance_enter_room_player_optimize", "进房场景播放器优化开关", r100, r100);
    }
}
