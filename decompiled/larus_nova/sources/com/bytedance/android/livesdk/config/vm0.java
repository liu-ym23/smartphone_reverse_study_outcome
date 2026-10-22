package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LiveRenderThreadScheduleConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class vm0 extends SSettingKey<LiveRenderThreadScheduleConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vm0 f121463a = null;

    static {
        f121463a = new vm0();
    }

    public vm0() {
        super("live_render_thread_jato_schedule_opt", "直播渲染线程优化", new LiveRenderThreadScheduleConfig(), new LiveRenderThreadScheduleConfig());
    }
}
