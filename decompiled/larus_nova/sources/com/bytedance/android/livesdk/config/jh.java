package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jh extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jh f120525a = null;

    static {
        f120525a = new jh();
    }

    public jh() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_nonitor_report_trace", "主播监控是否上报trace", r100, r100);
    }
}
