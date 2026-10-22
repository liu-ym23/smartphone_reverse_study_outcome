package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class h00 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h00 f120327a = null;

    static {
        f120327a = new h00();
    }

    public h00() {
        Boolean r100 = Boolean.FALSE;
        super("live_inner_feed_hot_refresh", "是否开启热更新", r100, r100);
    }
}
