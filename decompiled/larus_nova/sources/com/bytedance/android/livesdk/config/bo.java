package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class bo extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bo f119887a = null;

    static {
        f119887a = new bo();
    }

    public bo() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_chatroom_toolbar", "聊天室工具栏是否下线直播老容器", r100, r100);
    }
}
