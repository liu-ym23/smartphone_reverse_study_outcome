package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class p30 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p30 f120953a = null;

    static {
        f120953a = new p30();
    }

    public p30() {
        Boolean r100 = Boolean.TRUE;
        super("live_io_async_init", "Live IO启用异步初始化", r100, r100);
    }
}
