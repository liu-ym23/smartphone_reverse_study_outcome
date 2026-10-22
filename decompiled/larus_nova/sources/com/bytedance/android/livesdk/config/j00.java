package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class j00 extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j00 f120492a = null;

    static {
        f120492a = new j00();
    }

    public j00() {
        Float r100 = Float.valueOf(1.0f);
        super("live_inner_feed_hot_refresh_random_request_rate", "内流热更新概率", r100, r100);
    }
}
