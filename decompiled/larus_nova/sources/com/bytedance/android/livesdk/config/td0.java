package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class td0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final td0 f121289a = null;

    static {
        f121289a = new td0();
    }

    public td0() {
        Boolean r100 = Boolean.TRUE;
        super("live_open_feature_list_local_cache", "主播功能列表本地缓存开关", r100, r100);
    }
}
