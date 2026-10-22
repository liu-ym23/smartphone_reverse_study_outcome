package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class io extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final io f120468a = null;

    static {
        f120468a = new io();
    }

    public io() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_task_packet", "任务红包是否下线直播老容器", r100, r100);
    }
}
