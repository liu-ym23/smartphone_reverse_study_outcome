package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class kh extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kh f120602a = null;

    static {
        f120602a = new kh();
    }

    public kh() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_nonitor_report_trace_sync", "主播监控是否异步上报trace", r100, r100);
    }
}
