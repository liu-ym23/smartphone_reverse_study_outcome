package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zk0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zk0 f121773a = null;

    static {
        f121773a = new zk0();
    }

    public zk0() {
        Boolean r100 = Boolean.TRUE;
        super("live_proto_decoders_inject_with_service_init", "ProtoDecoderInjectTask 在 TTLiveSDK#initialize 时机执行", r100, r100);
    }
}
