package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class b5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b5 f119843a = null;

    static {
        f119843a = new b5();
    }

    public b5() {
        Boolean r100 = Boolean.TRUE;
        super("fix_live_inner_leak_gray_config", "修复rx内存泄漏问题", r100, r100, true);
    }
}
