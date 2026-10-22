package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class el extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final el f120136a = null;

    static {
        f120136a = new el();
    }

    public el() {
        Boolean r100 = Boolean.TRUE;
        super("live_clear_use_new_reset", "调整清屏reset的位置", r100, r100);
    }
}
