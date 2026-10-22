package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fr0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fr0 f120226a = null;

    static {
        f120226a = new fr0();
    }

    public fr0() {
        Boolean r100 = Boolean.FALSE;
        super("live_security_container_force_native", "直播安全容器强制使用原生", r100, r100, false);
    }
}
