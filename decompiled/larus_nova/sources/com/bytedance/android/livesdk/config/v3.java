package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class v3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v3 f121416a = null;

    static {
        f121416a = new v3();
    }

    public v3() {
        Boolean r100 = Boolean.TRUE;
        super("enable_lynx_real_share_group", "真正开启Lynx共享Runtime", r100, r100);
    }
}
