package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hr0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hr0 f120399a = null;

    static {
        f120399a = new hr0();
    }

    public hr0() {
        Boolean r100 = Boolean.TRUE;
        super("live_seek_gesture_for_play_back_only", "只有实时回放直播打开手势seek", r100, r100);
    }
}
