package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qe0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qe0 f121049a = null;

    static {
        f121049a = new qe0();
    }

    public qe0() {
        Boolean r100 = Boolean.TRUE;
        super("live_opt_load_livecore_so", "是否开启livecore加载so加载流程优化", r100, r100);
    }
}
