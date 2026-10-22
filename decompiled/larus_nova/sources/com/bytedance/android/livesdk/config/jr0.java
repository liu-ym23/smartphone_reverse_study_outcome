package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jr0 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jr0 f120547a = null;

    static {
        f120547a = new jr0();
    }

    public jr0() {
        super("live_sei_update_interval", "sei更新时长", 500L, 500L);
    }
}
