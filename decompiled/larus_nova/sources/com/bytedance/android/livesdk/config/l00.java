package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class l00 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l00 f120643a = null;

    static {
        f120643a = new l00();
    }

    public l00() {
        super("live_inner_feed_hot_refresh_stay_time", "单个直播间停留时长触发热更新", 180, 180);
    }
}
