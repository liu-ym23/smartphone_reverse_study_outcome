package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class cw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cw f119983a = null;

    static {
        f119983a = new cw();
    }

    public cw() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_activity_memory_config", "修复activity内存泄漏开关", r100, r100);
    }
}
