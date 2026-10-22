package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fz extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fz f120241a = null;

    static {
        f120241a = new fz();
    }

    public fz() {
        super("live_gift_user_request_interval", "礼物消费频控User接口请求周期(s)", 86400L, 86400L);
    }
}
