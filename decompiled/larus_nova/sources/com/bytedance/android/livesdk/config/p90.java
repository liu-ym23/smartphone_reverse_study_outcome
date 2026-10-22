package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class p90 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p90 f120961a = null;

    static {
        f120961a = new p90();
    }

    public p90() {
        Boolean r100 = Boolean.FALSE;
        super("live_mini_app_user_message", "小程序和电商互斥依赖消息", r100, r100);
    }
}
