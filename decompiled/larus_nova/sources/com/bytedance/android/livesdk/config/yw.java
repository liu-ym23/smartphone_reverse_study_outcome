package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class yw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yw f121720a = null;

    static {
        f121720a = new yw();
    }

    public yw() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_widget_auto_dispose_npe", "修复autoDispose的NPE", r100, r100);
    }
}
