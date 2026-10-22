package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class t8 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t8 f121277a = null;

    static {
        f121277a = new t8();
    }

    public t8() {
        Boolean r100 = Boolean.TRUE;
        super("jsb_enable_permission_check", "启用 JSB 鉴权", r100, r100);
    }
}
