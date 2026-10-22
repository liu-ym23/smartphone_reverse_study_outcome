package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class i70 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i70 f120429a = null;

    static {
        f120429a = new i70();
    }

    public i70() {
        super("live_log_rankinfo_report_interval", "麦序榜上报间隔时间", 60000, 60000);
    }
}
