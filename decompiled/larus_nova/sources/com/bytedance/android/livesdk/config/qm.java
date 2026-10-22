package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qm extends SSettingKey<com.bytedance.android.livesdk.chatroom.model.m0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qm f121067a = null;

    static {
        f121067a = new qm();
    }

    public qm() {
        com.bytedance.android.livesdk.chatroom.model.m0 r100 = new com.bytedance.android.livesdk.chatroom.model.m0();
        r100.name = "";
        r100.font = null;
        super("live_custom_font_config", r100, "字体下载信息");
    }
}
