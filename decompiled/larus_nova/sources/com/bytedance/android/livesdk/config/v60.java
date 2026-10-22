package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class v60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v60 f121423a = null;

    static {
        f121423a = new v60();
    }

    public v60() {
        Boolean r100 = Boolean.TRUE;
        super("live_link_supported_force_server_mix", "多人场景是否支持强制服务端合流", r100, r100);
    }
}
