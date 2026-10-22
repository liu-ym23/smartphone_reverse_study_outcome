package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class yf extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yf f121681a = null;

    static {
        f121681a = new yf();
    }

    public yf() {
        Boolean r100 = Boolean.FALSE;
        super("live_backend_memory_leak_fix", "backend框架内存泄漏修复及框架优化", r100, r100);
    }
}
