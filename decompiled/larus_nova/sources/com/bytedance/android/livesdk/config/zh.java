package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zh extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zh f121765a = null;

    static {
        f121765a = new zh();
    }

    public zh() {
        Boolean r100 = Boolean.FALSE;
        super("live_broadcast_single_activity_enable", "主播activity单实例", r100, r100, true);
    }
}
