package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class my0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final my0 f120792a = null;

    static {
        f120792a = new my0();
    }

    public my0() {
        Boolean r100 = Boolean.TRUE;
        super(LiveInitSettingKeys.LIVE_WEBVIEW_USE_MONITOR, "webview使用monitr", r100, r100);
    }
}
