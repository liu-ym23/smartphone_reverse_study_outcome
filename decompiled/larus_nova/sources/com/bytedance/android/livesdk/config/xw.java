package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xw f121636a = null;

    static {
        f121636a = new xw();
    }

    public xw() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_user_profile_scheme", "个人卡scheme，half且在直播间内时才打开半屏", r100, r100, new String[]{"true开启修正个人卡scheme", "false关闭修正个人卡scheme"});
    }
}
