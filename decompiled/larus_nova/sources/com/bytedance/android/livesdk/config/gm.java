package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gm extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gm f120298a = null;

    static {
        f120298a = new gm();
    }

    public gm() {
        Boolean r100 = Boolean.FALSE;
        super("live_core_async_logger_safe_quit", "LiveCore日志上报线程是否安全退出", r100, r100);
    }
}
