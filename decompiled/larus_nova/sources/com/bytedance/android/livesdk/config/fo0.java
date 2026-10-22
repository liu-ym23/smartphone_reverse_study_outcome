package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class fo0 extends SettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fo0 f120220a = null;

    static {
        f120220a = new fo0();
    }

    public fo0() {
        super("live_room_end_vip_count_down_seconds", "直播间结束后会员跳转新直播间倒计时", 5L, 5L, false);
    }
}
