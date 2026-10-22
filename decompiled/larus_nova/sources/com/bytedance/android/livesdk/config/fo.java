package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fo extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fo f120219a = null;

    static {
        f120219a = new fo();
    }

    public fo() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_open_live_method", "OpenLiveMethod是否下线直播老容器", r100, r100);
    }
}
