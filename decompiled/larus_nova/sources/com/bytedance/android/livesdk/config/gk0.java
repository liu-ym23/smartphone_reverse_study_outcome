package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gk0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gk0 f120295a = null;

    static {
        f120295a = new gk0();
    }

    public gk0() {
        Boolean r100 = Boolean.TRUE;
        super("live_pre_danmaku_stop_clear_only_running", "直播预览流stop时只在引擎running和非空时清理", r100, r100);
    }
}
