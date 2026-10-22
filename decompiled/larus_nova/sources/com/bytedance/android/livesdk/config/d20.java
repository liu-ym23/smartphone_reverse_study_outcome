package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class d20 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d20 f119996a = null;

    static {
        f119996a = new d20();
    }

    public d20() {
        Boolean r100 = Boolean.FALSE;
        super("live_inner_wrds_preload_enable", "直播内流wrds预加载开关", r100, r100);
    }
}
