package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jv0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jv0 f120555a = null;

    static {
        f120555a = new jv0();
    }

    public jv0() {
        Boolean r100 = Boolean.FALSE;
        super("live_translucent_renderthread_opt", "透明引起RT冗余渲染优化", r100, r100);
    }
}
