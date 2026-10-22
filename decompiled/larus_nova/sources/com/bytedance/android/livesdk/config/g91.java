package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b(\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001a\u0010 \u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001a\u0010\"\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001a\u0010$\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001a\u0010&\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/config/g91;", "", "", "enableWebViewMonitor", "Z", "h", "()Z", "setEnableWebViewMonitor", "(Z)V", "enableWebViewJsb", "getEnableWebViewJsb", "setEnableWebViewJsb", "enableWebViewJsbPref", "getEnableWebViewJsbPref", "setEnableWebViewJsbPref", "enableWebViewBlack", "f", "setEnableWebViewBlack", "enableWebViewFetch", "getEnableWebViewFetch", "setEnableWebViewFetch", "enableWebViewInjectBrowser", com.amap.api.col.s.ce.f26391f, "setEnableWebViewInjectBrowser", "enableLynxMonitor", "e", "setEnableLynxMonitor", "enableLynxBlack", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnableLynxBlack", "enableLynxFetch", "b", "enableLynxJsb", "c", "enableLynxJsbPerf", "d", "enableCustomError", "getEnableCustomError", "enableFalcon", "getEnableFalcon", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g91 {

    @SerializedName("custom_error")
    private final boolean enableCustomError;

    @SerializedName("falcon")
    private final boolean enableFalcon;

    @SerializedName("lynx_blank")
    private boolean enableLynxBlack;

    @SerializedName("lynx_fetch")
    private final boolean enableLynxFetch;

    @SerializedName("lynx_jsb")
    private final boolean enableLynxJsb;

    @SerializedName("lynx_jsb_perf")
    private final boolean enableLynxJsbPerf;

    @SerializedName("lynx_monitor_enable")
    private boolean enableLynxMonitor;

    @SerializedName("webview_blank")
    private boolean enableWebViewBlack;

    @SerializedName("webview_fetch")
    private boolean enableWebViewFetch;

    @SerializedName("webview_inject_browser")
    private boolean enableWebViewInjectBrowser;

    @SerializedName("webview_jsb")
    private boolean enableWebViewJsb;

    @SerializedName("webview_jsb_pref")
    private boolean enableWebViewJsbPref;

    @SerializedName("webview_monitor_enable")
    private boolean enableWebViewMonitor;

    public g91() {
        this.enableWebViewMonitor = true;
        this.enableWebViewJsb = true;
        this.enableWebViewJsbPref = true;
        this.enableWebViewBlack = true;
        this.enableWebViewFetch = true;
        this.enableWebViewInjectBrowser = true;
        this.enableLynxMonitor = true;
        this.enableLynxBlack = true;
        this.enableLynxFetch = true;
        this.enableLynxJsb = true;
        this.enableLynxJsbPerf = true;
        this.enableCustomError = true;
        this.enableFalcon = true;
    }

    public final boolean a() {
        return this.enableLynxBlack;
    }

    public final boolean b() {
        return this.enableLynxFetch;
    }

    public final boolean c() {
        return this.enableLynxJsb;
    }

    public final boolean d() {
        return this.enableLynxJsbPerf;
    }

    public final boolean e() {
        return this.enableLynxMonitor;
    }

    public final boolean f() {
        return this.enableWebViewBlack;
    }

    public final boolean g() {
        return this.enableWebViewInjectBrowser;
    }

    public final boolean h() {
        return this.enableWebViewMonitor;
    }
}
