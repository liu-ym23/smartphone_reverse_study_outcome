package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ka1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ka1 f120586a = null;

    static {
        f120586a = new ka1();
    }

    public ka1() {
        super("live_revenue_interact_forward_stream_opt_enable", "跨房推流优化开关", Boolean.TRUE, Boolean.FALSE);
    }
}
