package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zn extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zn f121778a = null;

    static {
        f121778a = new zn();
    }

    public zn() {
        Boolean r100 = Boolean.TRUE;
        super("live_disable_old_container_chatroom", "聊天室是否下线直播老容器", r100, r100);
    }
}
