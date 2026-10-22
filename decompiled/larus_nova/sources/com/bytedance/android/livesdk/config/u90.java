package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class u90 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u90 f121354a = null;

    static {
        f121354a = new u90();
    }

    public u90() {
        Boolean r100 = Boolean.TRUE;
        super("live_miracast_load_opt", "系统扩展投屏时，提高投屏组件加载优先级", r100, r100, true);
    }
}
