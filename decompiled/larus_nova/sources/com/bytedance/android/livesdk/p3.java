package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class p3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p3 f154191a = null;

    static {
        f154191a = new p3();
    }

    public p3() {
        Boolean r100 = Boolean.FALSE;
        super("live_webview_console_js_inject", "直播开启WebView调试", r100, r100);
    }
}
