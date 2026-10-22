package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ly0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ly0 f120717a = null;

    static {
        f120717a = new ly0();
    }

    public ly0() {
        Boolean r100 = Boolean.TRUE;
        super("live_webview_offline_enable", "直播开启WebView离线化", r100, r100);
    }
}
