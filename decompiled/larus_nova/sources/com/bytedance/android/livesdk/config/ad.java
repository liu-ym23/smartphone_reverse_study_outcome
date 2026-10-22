package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ad extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ad f119779a = null;

    static {
        f119779a = new ad();
    }

    public ad() {
        Boolean r100 = Boolean.FALSE;
        super("live_anchor_status_center_gesture_type_opt", "新版主播状态中心的手势优化功能开关 默认关闭，打开变成上下滑", r100, r100);
    }
}
