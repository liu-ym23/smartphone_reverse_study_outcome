package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class s00 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s00 f121171a = null;

    static {
        f121171a = new s00();
    }

    public s00() {
        Boolean r100 = Boolean.TRUE;
        super("live_hybrid_jsb_multi_link_support", "jsb是否支持PK判断(多人开关)", r100, r100);
    }
}
