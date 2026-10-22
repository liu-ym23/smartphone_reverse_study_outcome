package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class yo0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yo0 f121705a = null;

    static {
        f121705a = new yo0();
    }

    public yo0() {
        Boolean r100 = Boolean.FALSE;
        super("live_room_offline_yellow_dot_bubble", "直播间黄点气泡治理", r100, r100);
    }
}
