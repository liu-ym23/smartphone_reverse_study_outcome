package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gd0 extends SSettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gd0 f120271a = null;

    static {
        f120271a = new gd0();
    }

    public gd0() {
        Object r100 = bi1.a(Boolean.valueOf(tb1.c.f545229a), "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/roomnoticeguidance_1.png");
        Object r101 = bi1.a(Boolean.FALSE, "https://lf3-webcastcdn-tos.huoshanstatic.com/obj/live-android/roomnoticeguidance_1.png");
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        if (r100 == null) goto L8;
        r101 = r100;
    L8:
        super("live_notice_tip_bg_url", "直播间公告简介图片", r101, "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/roomnoticeguidance_1.png", false);
    }
}
