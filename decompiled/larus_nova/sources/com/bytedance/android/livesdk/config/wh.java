package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wh extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wh f121524a = null;

    static {
        f121524a = new wh();
    }

    public wh() {
        Boolean r100 = Boolean.FALSE;
        super("live_broadcast_restart_observer_memory", "开播重启监控低内存", r100, r100);
    }
}
