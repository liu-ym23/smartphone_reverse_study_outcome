package com.stepos.agentframework.chatui.appui.web;

import La.w;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.chatcore.utils.m;
import com.stepos.agentframework.chatui.appui.AppUIGlobal;
import com.stepos.agentframework.chatui.appui.web.WebAppUiView;
import com.stepos.agentframework.util.C2153b;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0001*B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/web/WebAppUiView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", "f", "()V", "e", "", "TAG", "Ljava/lang/String;", "Lcom/stepos/agentframework/chatui/appui/web/AgentWebView;", "webView", "Lcom/stepos/agentframework/chatui/appui/web/AgentWebView;", "getWebView", "()Lcom/stepos/agentframework/chatui/appui/web/AgentWebView;", "setWebView", "(Lcom/stepos/agentframework/chatui/appui/web/AgentWebView;)V", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "Lcom/stepos/agentframework/chatui/appui/e;", "global", "Lcom/stepos/agentframework/chatui/appui/e;", "getGlobal", "()Lcom/stepos/agentframework/chatui/appui/e;", "setGlobal", "(Lcom/stepos/agentframework/chatui/appui/e;)V", "Lcom/stepos/agentframework/chatui/appui/web/c;", "listener", "Lcom/stepos/agentframework/chatui/appui/web/c;", "getListener", "()Lcom/stepos/agentframework/chatui/appui/web/c;", "setListener", "(Lcom/stepos/agentframework/chatui/appui/web/c;)V", "Companion", Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WebAppUiView extends FrameLayout {
    public static final String LOCAL_HTML = "file:///android_asset/appui/index.html";
    private final String TAG;
    private AppUIData appUIData;
    private AppUIGlobal global;
    private c listener;
    private AgentWebView webView;

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/agentframework/chatui/appui/web/WebAppUiView$a", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "view", "Landroid/webkit/WebResourceRequest;", "request", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "Landroid/webkit/WebResourceError;", "error", "LY8/t;", "onReceivedError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", "", "url", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends WebViewClient {
        public a() {
        }

        public static final void b(WebAppUiView webAppUiView) {
            webAppUiView.e();
            webAppUiView.f();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            final WebAppUiView webAppUiView = WebAppUiView.this;
            webAppUiView.postDelayed(new Runnable() { // from class: com.stepos.agentframework.chatui.appui.web.d
                @Override // java.lang.Runnable
                public final void run() {
                    WebAppUiView.a.b(webAppUiView);
                }
            }, 200L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            String str = WebAppUiView.this.TAG;
            CharSequence description = error != null ? error.getDescription() : null;
            C4148a.k(str, "onReceivedError: " + ((Object) description) + " type:" + (error != null ? Integer.valueOf(error.getErrorCode()) : null), false, 4, null);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            p.i(view, "view");
            p.i(request, "request");
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebAppUiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.i(context, "context");
        this.TAG = "WebAppUiView";
        View viewFindViewById = LayoutInflater.from(context).inflate(R$layout.layout_web_app_ui, (ViewGroup) this, true).findViewById(R$id.agent_webview);
        p.h(viewFindViewById, "findViewById(...)");
        AgentWebView agentWebView = (AgentWebView) viewFindViewById;
        this.webView = agentWebView;
        agentWebView.addJavascriptInterface(new b(this), "androidJsBridge");
        this.webView.setWebViewClient(new a());
    }

    public final void d(AppUIData appUIData) {
        p.i(appUIData, "appUIData");
        this.appUIData = appUIData;
        this.webView.loadUrl(LOCAL_HTML);
    }

    public final void e() {
        AppUIGlobal appUIGlobal = this.global;
        if (appUIGlobal != null) {
            AppUIData appUIData = this.appUIData;
            appUIGlobal.a(appUIData != null ? appUIData.getStructuredContent() : null);
        }
        String json = ExtKt.l().toJson(this.global);
        p.h(json, "toJson(...)");
        m.INSTANCE.a(this.TAG, "setGlobal: " + json);
        this.webView.evaluateJavascript(w.n("\n           window.setGlobal(`" + C2153b.b(C2153b.INSTANCE, json, false, 2, null) + "`)\n    "), null);
    }

    public final void f() {
        String str = this.TAG;
        AppUIData appUIData = this.appUIData;
        p.f(appUIData);
        C4148a.d(str, "setHtml: " + appUIData.getHtml(), false, 4, null);
        C2153b c2153b = C2153b.INSTANCE;
        AppUIData appUIData2 = this.appUIData;
        p.f(appUIData2);
        this.webView.evaluateJavascript(w.n("\n           window.setHtml(`" + C2153b.b(c2153b, appUIData2.getHtml(), false, 2, null) + "`)\n    "), null);
    }

    public final AppUIGlobal getGlobal() {
        return this.global;
    }

    public final c getListener() {
        return this.listener;
    }

    public final AgentWebView getWebView() {
        return this.webView;
    }

    public final void setGlobal(AppUIGlobal appUIGlobal) {
        this.global = appUIGlobal;
    }

    public final void setListener(c cVar) {
        this.listener = cVar;
    }

    public final void setWebView(AgentWebView agentWebView) {
        p.i(agentWebView, "<set-?>");
        this.webView = agentWebView;
    }
}
