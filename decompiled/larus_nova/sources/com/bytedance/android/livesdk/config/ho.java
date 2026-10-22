package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ho extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ho f120392a = null;

    static {
        f120392a = new ho();
    }

    public ho() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_report", "report是否下线直播老容器", r100, r100);
    }
}
