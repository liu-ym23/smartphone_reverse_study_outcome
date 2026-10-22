package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class a5 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a5 f119765a = null;

    static {
        f119765a = new a5();
    }

    public a5() {
        Boolean r100 = Boolean.TRUE;
        super("fix_live_fix_user_profile_scheme", "上面兜底导致了一个合规问题，这个setting用于取消上面的兜底", r100, r100);
    }
}
