package com.bytedance.android.livesdk.config;

/* JADX INFO: renamed from: com.bytedance.android.livesdk.config.do, reason: invalid class name */
/* JADX INFO: loaded from: classes8.dex */
public final class Cdo extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Cdo f120052a = null;

    static {
        f120052a = new Cdo();
    }

    public Cdo() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_fans_group", "粉丝团是否下线直播老容器", r100, r100);
    }
}
