package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hw f120408a = null;

    static {
        f120408a = new hw();
    }

    public hw() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_detail_enter_method_anable", "修复抖音混滑埋点问题开关", r100, r100);
    }
}
