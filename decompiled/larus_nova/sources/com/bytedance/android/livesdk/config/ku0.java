package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ku0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ku0 f120630a = null;

    static {
        f120630a = new ku0();
    }

    public ku0() {
        Boolean r100 = Boolean.TRUE;
        super("live_talk_roomt_enable_restrat_audio_capture_when_resume", "是否在退后台返回前台的时候重启audiocatpure", r100, r100);
    }
}
