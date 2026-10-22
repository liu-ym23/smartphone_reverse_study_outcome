package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mi1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mi1 f120759a = null;

    static {
        f120759a = new mi1();
    }

    public mi1() {
        Boolean r100 = Boolean.TRUE;
        super("user_info_secret_callback_assign_redress_enable", "UserInfoSecretCallback绑定时机纠正开关", r100, r100);
    }
}
