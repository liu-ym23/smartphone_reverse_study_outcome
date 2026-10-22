package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dm extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dm f120048a = null;

    static {
        f120048a = new dm();
    }

    public dm() {
        Boolean r100 = Boolean.FALSE;
        super("live_client_mix_stream", "端上配置是否客户端合流", r100, r100);
    }
}
