package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class oc extends SSettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final oc f120892a = null;

    static {
        f120892a = new oc();
    }

    public oc() {
        boolean r100 = tb1.c.f545229a;
        String r101 = "";
        if (r100 == false) goto L5;
        Object r102 = "https://webcast.amemv.com/falcon/webcast_douyin/page/report_live/main/index.html";
    L6:
        if (r100 == false) goto L8;
        r101 = "https://webcast.amemv.com/falcon/webcast_douyin/page/report_live/main/index.html";
    L8:
        super("live_anchor_report_url", "中台主播举报页的url", r102, r101, false);
        return;
    L5:
        r102 = "";
        goto L6
    }
}
