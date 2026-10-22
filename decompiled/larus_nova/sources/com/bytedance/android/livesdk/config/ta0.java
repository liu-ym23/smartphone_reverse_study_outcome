package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ta0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ta0 f121282a = null;

    static {
        f121282a = new ta0();
    }

    public ta0() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_audio_pub_stream_fall_back_protect", "【语音】跨房厅战公共流回退到跨房流后，首帧回调到来不再mute跨房流", r100, r100);
    }
}
