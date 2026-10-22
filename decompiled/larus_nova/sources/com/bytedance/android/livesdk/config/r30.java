package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class r30 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r30 f121102a = null;

    static {
        f121102a = new r30();
    }

    public r30() {
        Boolean r100 = Boolean.FALSE;
        super("live_is_load_gift_after_feed_end", "是否在直播Feed首刷后再加载资源", r100, r100);
    }
}
