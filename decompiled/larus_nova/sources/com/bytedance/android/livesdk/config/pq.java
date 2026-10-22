package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class pq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pq f120999a = null;

    static {
        f120999a = new pq();
    }

    public pq() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_anchor_long_press_record", "主播侧录屏长按开关", r100, r100);
    }
}
