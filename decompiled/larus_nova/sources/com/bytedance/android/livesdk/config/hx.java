package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hx extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hx f120410a = null;

    static {
        f120410a = new hx();
    }

    public hx() {
        Boolean r100 = Boolean.TRUE;
        super("live_fold_screen_anchor_adapt_enable", "主播侧是否开启折叠屏适配", r100, r100);
    }
}
