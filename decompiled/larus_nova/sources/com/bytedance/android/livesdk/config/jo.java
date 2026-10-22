package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jo extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jo f120540a = null;

    static {
        f120540a = new jo();
    }

    public jo() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_test", "测试页面是否下线直播老容器", r100, r100);
    }
}
