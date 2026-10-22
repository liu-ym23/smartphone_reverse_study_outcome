package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vf extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vf f121445a = null;

    static {
        f121445a = new vf();
    }

    public vf() {
        Boolean r100 = Boolean.FALSE;
        super("live_backend_compatible_optimize", "backend所有业务兼容接入+分段优化", r100, r100, true);
    }
}
