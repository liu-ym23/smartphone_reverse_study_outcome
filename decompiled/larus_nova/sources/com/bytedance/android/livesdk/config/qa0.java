package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qa0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qa0 f121039a = null;

    static {
        f121039a = new qa0();
    }

    public qa0() {
        Boolean r100 = Boolean.TRUE;
        super("live_multilink_fresco_cache_clear", "多人fresco私有缓存清理", r100, r100);
    }
}
