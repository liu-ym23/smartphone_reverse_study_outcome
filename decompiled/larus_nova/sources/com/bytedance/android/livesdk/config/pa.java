package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pa extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pa f120962a = null;

    static {
        f120962a = new pa();
    }

    public pa() {
        Boolean r100 = Boolean.FALSE;
        super("live_ambient_light_listener_enable", "直播启用环境光传感器", r100, r100);
    }
}
