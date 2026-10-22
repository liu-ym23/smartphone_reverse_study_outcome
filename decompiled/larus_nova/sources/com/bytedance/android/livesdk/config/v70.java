package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LiveMainThreadScheduleConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class v70 extends SSettingKey<LiveMainThreadScheduleConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v70 f121425a = null;

    static {
        f121425a = new v70();
    }

    public v70() {
        super("live_main_thread_jato_schedule_opt", "直播主线程优化", new LiveMainThreadScheduleConfig(), new LiveMainThreadScheduleConfig());
    }
}
