package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zc extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zc f121751a = null;

    static {
        f121751a = new zc();
    }

    public zc() {
        super("live_anchor_status_center_gesture_trigger_threshold", "手势触发阈值，默认50", 50, 50);
    }
}
