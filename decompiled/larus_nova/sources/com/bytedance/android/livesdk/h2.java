package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class h2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h2 f132624a = null;

    static {
        f132624a = new h2();
    }

    public h2() {
        Boolean r100 = Boolean.TRUE;
        super("live_player_stall_counter_enable", "stall 计数开关", r100, r100);
    }
}
