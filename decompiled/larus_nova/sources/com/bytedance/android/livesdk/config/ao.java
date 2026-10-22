package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ao extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ao f119807a = null;

    static {
        f119807a = new ao();
    }

    public ao() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_chatroom_admin", "聊天室管理员是否下线直播老容器", r100, r100);
    }
}
