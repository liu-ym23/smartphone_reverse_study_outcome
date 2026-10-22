package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xf extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xf f121599a = null;

    static {
        f121599a = new xf();
    }

    public xf() {
        Boolean r100 = Boolean.TRUE;
        super("live_backend_fix", "backend数据错位修复", r100, r100);
    }
}
