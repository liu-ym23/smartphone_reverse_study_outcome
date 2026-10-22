package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class cu extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cu f119979a = null;

    static {
        f119979a = new cu();
    }

    public cu() {
        Boolean r100 = Boolean.TRUE;
        super("live_enter_audio_room_first_frame_event_fallback", "语音场景进房首帧未上报兜底开关", r100, r100);
    }
}
