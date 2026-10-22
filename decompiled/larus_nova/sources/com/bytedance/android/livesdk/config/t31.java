package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class t31 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t31 f121270a = null;

    static {
        f121270a = new t31();
    }

    public t31() {
        Boolean r100 = Boolean.TRUE;
        super("live_gesture_touch_dispatch_opt", "直播间触摸事件down线分发给业务优化", r100, r100);
    }
}
