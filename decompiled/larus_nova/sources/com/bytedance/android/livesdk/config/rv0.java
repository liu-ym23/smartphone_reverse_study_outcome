package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rv0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rv0 f121161a = null;

    static {
        f121161a = new rv0();
    }

    public rv0() {
        Boolean r100 = Boolean.TRUE;
        super("live_unify_message_with_platform", "是否支持平台化统一通道", r100, r100);
    }
}
