package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nq f120852a = null;

    static {
        f120852a = new nq();
    }

    public nq() {
        super("live_enable_adjust_full_display", Boolean.FALSE, "开播预览页是否适配全面屏");
    }
}
