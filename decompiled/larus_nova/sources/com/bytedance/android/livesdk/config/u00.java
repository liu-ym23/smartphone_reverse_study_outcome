package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class u00 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u00 f121339a = null;

    static {
        f121339a = new u00();
    }

    public u00() {
        Boolean r100 = Boolean.FALSE;
        super("live_hybrid_tryfix_fetch_v3_status_code", "修复fetch方法返回值没有statusCode", r100, r100);
    }
}
