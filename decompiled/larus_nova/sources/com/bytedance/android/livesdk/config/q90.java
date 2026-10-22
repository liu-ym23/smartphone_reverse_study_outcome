package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class q90 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q90 f121037a = null;

    static {
        f121037a = new q90();
    }

    public q90() {
        Boolean r100 = Boolean.FALSE;
        super("live_open_native_app_continue_watch_enable", "小程序看播时长埋点逻辑更改", r100, r100);
    }
}
