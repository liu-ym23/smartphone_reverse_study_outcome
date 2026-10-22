package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mf extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mf f120750a = null;

    static {
        f120750a = new mf();
    }

    public mf() {
        Boolean r100 = Boolean.TRUE;
        super("live_audio_subtitle_sei_check", "检查字幕sei是否符合json格式", r100, r100);
    }
}
