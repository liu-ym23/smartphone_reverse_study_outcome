package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class f70 extends SSettingKey<am2.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f70 f120180a = null;

    static {
        f120180a = new f70();
    }

    public f70() {
        Object r100 = bi1.a(Boolean.valueOf(com.bytedance.android.live.core.utils.v.a()), am2.v.f());
        Object r101 = new am2.v();
        if (r100 == null) goto L6;
        r101 = r100;
    L6:
        super("live_logsdk_config", am2.v.class, "日志sdk开关配置", r101, am2.v.e());
    }
}
