package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class v10 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v10 f121414a = null;

    static {
        f121414a = new v10();
    }

    public v10() {
        Boolean r100 = Boolean.TRUE;
        super("live_inner_feed_rerank_common_opt_enable", "直播内流重排逻辑开关", r100, r100, true);
    }
}
