package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ue1 extends SSettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ue1 f121367a = null;

    static {
        f121367a = new ue1();
    }

    public ue1() {
        if (tb1.c.f545229a == false) goto L5;
        String r100 = "https://p3.douyinpic.com/aweme-client-static-resource/ranklist_fans_club_di.webp~tplv-obj.image";
    L6:
        super("rank_list_award_webp_di", "抖火粉丝团人气榜单王奖励动画di_url", r100, "https://p3.douyinpic.com/aweme-client-static-resource/ranklist_fans_club_di.webp~tplv-obj.image", false);
        return;
    L5:
        r100 = "";
        goto L6
    }
}
