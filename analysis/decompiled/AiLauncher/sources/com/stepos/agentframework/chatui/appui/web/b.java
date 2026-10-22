package com.stepos.agentframework.chatui.appui.web;

import android.webkit.JavascriptInterface;
import com.google.gson.Gson;
import com.stepos.agentframework.chatui.appui.DisplayMode;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0005R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/web/b;", "", "Lcom/stepos/agentframework/chatui/appui/web/WebAppUiView;", "webAppUiView", "<init>", "(Lcom/stepos/agentframework/chatui/appui/web/WebAppUiView;)V", "", "parm", "LY8/t;", "callTool", "(Ljava/lang/String;)V", "json", "requestDisplayMode", "Lcom/stepos/agentframework/chatui/appui/web/WebAppUiView;", "getWebAppUiView", "()Lcom/stepos/agentframework/chatui/appui/web/WebAppUiView;", "setWebAppUiView", "TAG", "Ljava/lang/String;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class b {
    private final String TAG;
    private WebAppUiView webAppUiView;

    public b(WebAppUiView webAppUiView) {
        p.i(webAppUiView, "webAppUiView");
        this.webAppUiView = webAppUiView;
        this.TAG = "AppUIWebInterface";
    }

    @JavascriptInterface
    public final void callTool(String parm) {
        p.i(parm, "parm");
        C4148a.k(this.TAG, "callTool: " + parm, false, 4, null);
    }

    @JavascriptInterface
    public final void requestDisplayMode(String json) {
        c listener;
        p.i(json, "json");
        C4148a.k(this.TAG, "requestDisplayMode parm json: " + json, false, 4, null);
        DisplayMode displayMode = (DisplayMode) new Gson().fromJson(json, DisplayMode.class);
        if (displayMode == null || (listener = this.webAppUiView.getListener()) == null) {
            return;
        }
        listener.a(displayMode);
    }
}
