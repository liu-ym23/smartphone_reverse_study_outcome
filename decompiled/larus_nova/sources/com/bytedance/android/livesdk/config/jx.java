package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jx extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jx f120558a = null;

    static {
        jx r100 = new jx();
        f120558a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public jx() {
        Boolean r100 = Boolean.FALSE;
        super("live_follow_cover_pre_pullstream", "关注天窗首次滑动预拉流优化", r100, r100, new String[]{"true:使用预拉流", "false:不使用预拉流"});
    }
}
