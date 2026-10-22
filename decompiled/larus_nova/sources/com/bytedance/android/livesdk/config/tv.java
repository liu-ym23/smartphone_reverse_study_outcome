package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tv extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tv f121328a = null;

    public tv() {
        super("live_feed_filter_duplicate_num", "去重范围在连续多少个直播间", 4, 4);
    }

    static {
        f121328a = new tv();
    }
}
