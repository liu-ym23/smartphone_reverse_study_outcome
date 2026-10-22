package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rk0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rk0 f121139a = null;

    static {
        f121139a = new rk0();
    }

    public rk0() {
        super("live_privacy_room_logger_add_uid_monitor", "隐私直播间上报是否加上uid监控", Boolean.FALSE, Boolean.TRUE);
    }
}
