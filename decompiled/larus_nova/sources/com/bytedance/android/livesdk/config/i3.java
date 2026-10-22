package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class i3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i3 f120422a = null;

    static {
        f120422a = new i3();
    }

    public i3() {
        Boolean r100 = Boolean.TRUE;
        super("enable_guest_link_auto_silence_setting", "聊天室设置面板是否展示观众连线默认静音设置项", r100, r100);
    }
}
