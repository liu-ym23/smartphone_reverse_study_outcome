package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mu extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mu f120783a = null;

    static {
        f120783a = new mu();
    }

    public mu() {
        Boolean r100 = Boolean.FALSE;
        super("live_enter_room_pre_pull_stream_switch", "直播间进房是否开启预拉流的开关", r100, r100);
    }
}
