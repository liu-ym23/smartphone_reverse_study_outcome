package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class bt extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bt f119897a = null;

    static {
        f119897a = new bt();
    }

    public bt() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_setup_audio_push_stream", "音频链路合流优化开关", r100, r100);
    }
}
