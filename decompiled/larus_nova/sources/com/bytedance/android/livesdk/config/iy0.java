package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class iy0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final iy0 f120488a = null;

    static {
        f120488a = new iy0();
    }

    public iy0() {
        Boolean r100 = Boolean.FALSE;
        super("live_webview_console_js_inject", "是否向WebView注入console脚本", r100, r100);
    }
}
