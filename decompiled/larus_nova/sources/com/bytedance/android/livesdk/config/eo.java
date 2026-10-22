package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class eo extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final eo f120142a = null;

    static {
        f120142a = new eo();
    }

    public eo() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_live", "直播间是否下线直播老容器", r100, r100);
    }
}
