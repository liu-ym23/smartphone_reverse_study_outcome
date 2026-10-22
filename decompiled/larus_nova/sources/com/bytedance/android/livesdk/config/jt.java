package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jt extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jt f120550a = null;

    static {
        f120550a = new jt();
    }

    public jt() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_test_info_upload", "是否允许上报直播间测试信息", r100, r100);
    }
}
