package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class i00 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i00 f120417a = null;

    static {
        f120417a = new i00();
    }

    public i00() {
        Boolean r100 = Boolean.FALSE;
        super("live_inner_feed_hot_refresh_ignore_data", "热更新丢弃返回结果", r100, r100);
    }
}
