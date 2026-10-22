package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class b8 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b8 f119847a = null;

    static {
        f119847a = new b8();
    }

    public b8() {
        Boolean r100 = Boolean.FALSE;
        super("is_oversea_new_user", "是否为海外新用户，通过用户户口位置判断", r100, r100);
    }
}
