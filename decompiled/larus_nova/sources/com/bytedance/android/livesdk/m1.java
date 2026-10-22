package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class m1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f153484a = null;

    static {
        f153484a = new m1();
    }

    public m1() {
        Boolean r100 = Boolean.TRUE;
        super("live_multitab_subpage_height_enable", "赛事直播间流获取失败时贴流高度获取", r100, r100);
    }
}
