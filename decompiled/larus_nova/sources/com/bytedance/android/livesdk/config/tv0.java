package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tv0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tv0 f121329a = null;

    static {
        f121329a = new tv0();
    }

    public tv0() {
        Boolean r100 = Boolean.TRUE;
        super("live_upload_alogger_check_issue", "是否允许集中上报日志查问题", r100, r100);
    }
}
