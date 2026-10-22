package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class q10 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q10 f121023a = null;

    static {
        f121023a = new q10();
    }

    public q10() {
        Boolean r100 = Boolean.FALSE;
        super("live_inner_feed_loadmore_error_report_stack", "内流数据加载失败堆栈上报", r100, r100, true);
    }
}
