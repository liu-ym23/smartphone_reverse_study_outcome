package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sk0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sk0 f121235a = null;

    static {
        f121235a = new sk0();
    }

    public sk0() {
        super("live_privacy_room_logger_add_uid_monitor_webcast_pair", "隐私直播间上报是否加上uid缺失webcast前缀的监控", Boolean.FALSE, Boolean.TRUE);
    }
}
