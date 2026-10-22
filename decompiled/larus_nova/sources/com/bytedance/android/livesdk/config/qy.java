package com.bytedance.android.livesdk.config;

import kotlin.Lazy;

/* JADX INFO: loaded from: classes8.dex */
public final class qy extends SSettingKey<LiveGestureConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qy f121091a = null;

    static {
        f121091a = new qy();
    }

    public qy() {
        Lazy r100 = LiveGestureConfig.f119739a;
        super("live_gesture_config", "直播内流操作手势配置", (LiveGestureConfig) LiveGestureConfig.f119739a.getValue(), (LiveGestureConfig) LiveGestureConfig.f119740b.getValue());
    }
}
