package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wf extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wf f121520a = null;

    static {
        f121520a = new wf();
    }

    public wf() {
        Boolean r100 = Boolean.TRUE;
        super("live_backend_fail_fix", "backend数据异常处理", r100, r100);
    }
}
