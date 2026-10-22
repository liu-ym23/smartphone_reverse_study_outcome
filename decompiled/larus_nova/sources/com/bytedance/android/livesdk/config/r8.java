package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class r8 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r8 f121110a = null;

    static {
        f121110a = new r8();
    }

    public r8() {
        Boolean r100 = Boolean.FALSE;
        super("jsb_disable_all_permission_check", "屏蔽JSB 鉴权", r100, r100);
    }
}
