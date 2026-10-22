package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class yj extends SSettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yj f121693a = null;

    static {
        f121693a = new yj();
    }

    public yj() {
        boolean r100 = tb1.c.f545229a;
        String r101 = "";
        if (r100 == false) goto L5;
        Object r102 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/h5/security_live_report_h5_douyin/template/pages/AudioCommentReport.html";
    L6:
        if (r100 == false) goto L8;
        r101 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/h5/security_live_report_h5_douyin/template/pages/AudioCommentReport.html";
    L8:
        super("live_channel_link_report_url", "频道房语音用户举报页的url", r102, r101, false);
        return;
    L5:
        r102 = "";
        goto L6
    }
}
