package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gk extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gk f120294a = null;

    static {
        f120294a = new gk();
    }

    public gk() {
        Boolean r100 = Boolean.TRUE;
        super("live_chat_channel_invite_bugfix_enable", "聊天频道自定义频道邀请bugfix", r100, r100);
    }
}
