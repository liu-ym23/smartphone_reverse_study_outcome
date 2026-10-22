package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jc1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jc1 f120515a = null;

    static {
        f120515a = new jc1();
    }

    public jc1() {
        Boolean r100 = Boolean.TRUE;
        super("opt_live_boradcast_context_slardar_log", "屏蔽LiveBroadcastContext上报无用日志", r100, r100);
    }
}
