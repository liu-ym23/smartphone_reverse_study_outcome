package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class t30 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t30 f121269a = null;

    static {
        f121269a = new t30();
    }

    public t30() {
        Boolean r100 = Boolean.TRUE;
        super("live_jsb_enable_init_xbridge", "启用 JSB 宿主方法注入", r100, r100);
    }
}
