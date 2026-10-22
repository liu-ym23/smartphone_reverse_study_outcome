package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class yg0 extends SSettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yg0 f121687a = null;

    static {
        f121687a = new yg0();
    }

    public yg0() {
        Object r100 = bi1.a(Boolean.valueOf(tb1.c.f545229a), "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png");
        Boolean r101 = Boolean.FALSE;
        Object r102 = bi1.a(r101, "https://lf1-webcastcdn-tos.huoshanstatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png");
        Object r103 = bi1.a(r101, "https://lf1-webcastcdn-tos.bdxiguastatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png");
        if (r103 != null) goto L5;
        r103 = "https://lf1-webcastcdn-tos.toutiaostatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png";
    L5:
        if (r102 != null) goto L7;
        r102 = r103;
    L7:
        if (r100 != null) goto L9;
        Object r104 = r102;
    L10:
        super("live_pk_denoise_bottom_bg_url", "降噪后的pk观众端底部背景图", r104, "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png", false);
        return;
    L9:
        r104 = r100;
        goto L10
    }
}
