package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dh extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dh f120032a = null;

    static {
        f120032a = new dh();
    }

    public dh() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_fix_anchor_perf_monitor", "主播性能监控bugfix", r100, r100);
    }
}
