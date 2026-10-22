package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ko extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ko f120617a = null;

    static {
        f120617a = new ko();
    }

    public ko() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_welfare", "公益组件是否下线直播老容器", r100, r100);
    }
}
