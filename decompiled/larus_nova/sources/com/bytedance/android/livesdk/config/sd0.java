package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sd0 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sd0 f121200a = null;

    static {
        f121200a = new sd0();
    }

    public sd0() {
        super("live_open_feature_list_cache_timeout", "本地缓存数据超时时间(默认 3 d)", 172800000, 172800000);
    }
}
