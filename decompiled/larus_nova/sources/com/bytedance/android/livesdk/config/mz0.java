package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mz0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mz0 f120794a = null;

    static {
        f120794a = new mz0();
    }

    public mz0() {
        super("live_xplay_anchor_pod_merge_stream_enable", "Xplay主播侧启动pod合流开关", Boolean.FALSE, Boolean.TRUE);
    }
}
