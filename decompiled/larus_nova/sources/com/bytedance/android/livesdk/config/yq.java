package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class yq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yq f121708a = null;

    static {
        f121708a = new yq();
    }

    public yq() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_audience_invite_friends", "实验：是否开启聊天室好友邀请", r100, r100);
    }
}
