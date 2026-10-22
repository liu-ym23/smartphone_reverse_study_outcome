package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class l7 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l7 f120656a = null;

    static {
        f120656a = new l7();
    }

    public l7() {
        Boolean r100 = Boolean.TRUE;
        super("hybrid_prefetch_enabled", "Prefetch 开关", r100, r100);
    }
}
