package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gn0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gn0 f120301a = null;

    static {
        f120301a = new gn0();
    }

    public gn0() {
        Boolean r100 = Boolean.TRUE;
        super("live_revenue_link_skip_crop_opt", "直播间跳过crop逻辑", r100, r100);
    }
}
