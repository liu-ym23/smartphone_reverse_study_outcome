package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ve1 extends SSettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ve1 f121444a = null;

    static {
        f121444a = new ve1();
    }

    public ve1() {
        if (tb1.c.f545229a == false) goto L5;
        String r100 = "https://p3.douyinpic.com/aweme-client-static-resource/ranklist_fans_club_guang.webp~tplv-obj.image";
    L6:
        super("rank_list_award_webp_light", "抖火粉丝团人气榜单王奖励动画guang_url", r100, "https://p3.douyinpic.com/aweme-client-static-resource/ranklist_fans_club_guang.webp~tplv-obj.image", false);
        return;
    L5:
        r100 = "";
        goto L6
    }
}
