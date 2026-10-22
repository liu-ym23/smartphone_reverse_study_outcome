package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qq f121075a = null;

    static {
        f121075a = new qq();
    }

    public qq() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_anchor_overheat_digg_degrade", "主播发热点赞降级开关", r100, r100);
    }
}
