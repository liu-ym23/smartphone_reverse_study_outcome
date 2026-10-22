package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class z00 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z00 f121729a = null;

    static {
        f121729a = new z00();
    }

    public z00() {
        Boolean r100 = Boolean.FALSE;
        super("live_im_allow_reconnect_command", "直播消息支持reconnect命令", r100, r100);
    }
}
