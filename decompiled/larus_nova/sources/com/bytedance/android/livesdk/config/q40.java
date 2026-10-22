package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class q40 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q40 f121029a = null;

    static {
        f121029a = new q40();
    }

    public q40() {
        super("live_ktv_midi_lyric_load_time_out_duration", "KTV歌词和midi加载超时时长 (单位 ms)", 5000L, 5000L);
    }
}
