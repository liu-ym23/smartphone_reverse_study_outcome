package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xm0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xm0 f121617a = null;

    static {
        f121617a = new xm0();
    }

    public xm0() {
        Boolean r100 = Boolean.FALSE;
        super("live_report_crash_when_crash", "crash时上报退房信息", r100, r100, true);
    }
}
