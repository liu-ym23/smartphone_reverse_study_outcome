package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class na extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final na f120815a = null;

    static {
        f120815a = new na();
    }

    public na() {
        Boolean r100 = Boolean.FALSE;
        super("live_allow_old_lynx_monitor_report", "允许上报老监控", r100, r100);
    }
}
