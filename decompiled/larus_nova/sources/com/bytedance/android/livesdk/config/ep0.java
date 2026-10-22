package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ep0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ep0 f120145a = null;

    static {
        f120145a = new ep0();
    }

    public ep0() {
        Boolean r100 = Boolean.TRUE;
        super("live_room_swipe_guide_configs_with_guide_tetris_fix", "直播上下滑引导和清屏组件引导冲突优化", r100, r100, true);
    }
}
