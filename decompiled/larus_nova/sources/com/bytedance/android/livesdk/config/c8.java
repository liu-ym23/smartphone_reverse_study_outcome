package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class c8 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c8 f119927a = null;

    static {
        f119927a = new c8();
    }

    public c8() {
        Boolean r100 = Boolean.FALSE;
        super("is_oversea_old_user", "是否为海外老用户，通过用户户口位置判断", r100, r100);
    }
}
