package com.bytedance.android.live.browser.service;

import android.webkit.WebView;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d0 implements aa.b {
    public d0() {
    }

    @Override // aa.b
    public final boolean isTTWebView() {
        return ((IMiddlewareHostBusiness) jc1.k.n(IMiddlewareHostBusiness.class)).isTTWebView();
    }

    @Override // aa.b
    public final JSONObject g0(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        return ((IMiddlewareHostBusiness) jc1.k.n(IMiddlewareHostBusiness.class)).getTTWebViewPerfTiming(r100);
    }

    @Override // aa.b
    public final void y1(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        if (((IMiddlewareHostBusiness) jc1.k.n(IMiddlewareHostBusiness.class)).isTTWebView() == false) goto L6;
        r100.evaluateJavascript("ttwebview:/*enableTTLogEvent*/;", null);
        return;
    }
}
