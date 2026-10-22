package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class oq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final oq f120924a = null;

    static {
        f120924a = new oq();
    }

    public oq() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_anchor_invite_friends", "实验：是否开启聊天室好友邀请", r100, r100);
    }
}
