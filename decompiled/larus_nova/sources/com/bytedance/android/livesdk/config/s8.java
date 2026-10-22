package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class s8 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s8 f121188a = null;

    static {
        f121188a = new s8();
    }

    public s8() {
        Boolean r100 = Boolean.FALSE;
        super("jsb_enable_host_method_import", "启用 JSB 宿主方法注入", r100, r100);
    }
}
