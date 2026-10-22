package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class du0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final du0 f120065a = null;

    static {
        f120065a = new du0();
    }

    public du0() {
        Boolean r100 = Boolean.TRUE;
        super("live_system_ui_transparent_fix_video_position", "直播沉浸式systemui下，视频下移", r100, r100);
    }
}
