package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nw f120864a = null;

    static {
        f120864a = new nw();
    }

    public nw() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_host_initialize_npe", "修复live初始化npe", r100, r100);
    }
}
