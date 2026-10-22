package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class p extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f120944a = null;

    static {
        f120944a = new p();
    }

    public p() {
        Boolean r100 = Boolean.TRUE;
        super("audience_cast_state_opt", "观众投屏状态处理优化 默认开启", r100, r100);
    }
}
