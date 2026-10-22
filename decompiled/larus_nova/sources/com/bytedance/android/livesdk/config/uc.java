package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class uc extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uc f121360a = null;

    static {
        f121360a = new uc();
    }

    public uc() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_screenshot_enable", "是否展示录屏开播入口", r100, r100);
    }
}
