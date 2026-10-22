package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class go extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final go f120302a = null;

    static {
        f120302a = new go();
    }

    public go() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_preview", "预览流是否下线直播老容器", r100, r100);
    }
}
