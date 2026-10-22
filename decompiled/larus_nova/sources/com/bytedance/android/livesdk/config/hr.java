package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hr extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hr f120398a = null;

    static {
        f120398a = new hr();
    }

    public hr() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_control_client_mix_stream", "是否支持配置端上选择合流方式", r100, r100);
    }
}
