package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class k01 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k01 f120567a = null;

    static {
        f120567a = new k01();
    }

    public k01() {
        Boolean r100 = Boolean.TRUE;
        super("login_user_service_check_enable", "登录时判断宿主UserService是否为null", r100, r100);
    }
}
