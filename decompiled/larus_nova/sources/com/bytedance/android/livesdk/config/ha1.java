package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ha1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ha1 f120357a = null;

    static {
        f120357a = new ha1();
    }

    public ha1() {
        Boolean r100 = Boolean.TRUE;
        super("multi_anchor_cache_list_opt_enable", "PK&主播连线cacheList在leave消息时不清理", r100, r100);
    }
}
