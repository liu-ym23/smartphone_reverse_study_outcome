package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pm extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pm f120991a = null;

    static {
        f120991a = new pm();
    }

    public pm() {
        Boolean r100 = Boolean.TRUE;
        super("live_current_streamer_room", "使用streamer room", r100, r100);
    }
}
