package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class m00 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m00 f120722a = null;

    static {
        f120722a = new m00();
    }

    public m00() {
        super("live_hot_reset_time_interval", "高热直播间失效时间间隔", 60, 60);
    }
}
