package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class t4 extends SSettingKey<y21> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t4 f121271a = null;

    static {
        t4 r100 = new t4();
        f121271a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public t4() {
        super("fast_match_optimize_v2_enable", "快速匹配优化二期是否开启", new y21(), new y21());
    }
}
