package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qj0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qj0 f121061a = null;

    static {
        f121061a = new qj0();
    }

    public qj0() {
        Boolean r100 = Boolean.TRUE;
        super("live_preview_fix_activity_leak_sdk", "sdk内存泄漏问题修复开关", r100, r100);
    }
}
