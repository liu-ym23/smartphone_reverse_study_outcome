package com.bytedance.android.monitorV2.webview;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements InvocationHandler {
    public e() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r110, Method r111, Object[] r112) throws Throwable {
        String r100 = (String) r112[0];     // Catch: Throwable -> L52
        Integer r113 = (Integer) r112[1];     // Catch: Throwable -> L52
        HashMap r114 = (HashMap) r112[2];     // Catch: Throwable -> L52
        Object[] r115 = (Object[]) r114.get("args");     // Catch: Throwable -> L52
        m r116 = m.f163358f;     // Catch: Throwable -> L52
        if (r116.D() == true) goto L7;
        return null;
    L7:
        if ("ttwebviewdelegate".equals(r100) == true) goto L13;
        if (1 == r113.intValue()) goto L13;
        return null;
    L13:
        if ("onPageStarted".equals(r114.get("name")) == false) goto L17;
        nz2.b.f("TTWebViewClientDelegateHandler", "onPageStarted:" + r115[1]);     // Catch: Throwable -> L52
        r116.J((WebView) r115[0], (String) r115[1]);     // Catch: Throwable -> L52
        return null;
    L17:
        if ("onPageFinished".equals(r114.get("name")) == false) goto L29;
        nz2.b.f("TTWebViewClientDelegateHandler", "onPageFinished: " + r115[1]);     // Catch: Throwable -> L52
        WebView r101 = (WebView) r115[0];     // Catch: Throwable -> L52
        String r102 = (String) r115[1];     // Catch: Throwable -> L52
        r116.getClass();     // Catch: Throwable -> L52
    L24:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);     // Catch: Throwable -> L52
    L26:
        return null;
    L20:
        if (r116.f163362d.h(r101) == false) goto L26;
        r116.f163362d.l(r101, r102);     // Catch: Throwable -> L24
    L29:
        if ("onReceivedError".equals(r114.get("name")) == false) goto L35;
        if (r115.length != 3) goto L35;
        nz2.b.f("TTWebViewClientDelegateHandler", "handleRequestError: " + nz2.b.e((WebView) r115[0]) + ", error: " + r115[2]);     // Catch: Throwable -> L52
        r116.w((WebView) r115[0], (WebResourceRequest) r115[1], (WebResourceError) r115[2]);     // Catch: Throwable -> L52
        return null;
    L35:
        if ("onReceivedError".equals(r114.get("name")) == false) goto L41;
        if (r115.length != 4) goto L41;
        nz2.b.f("TTWebViewClientDelegateHandler", "handleRequestError: " + nz2.b.e((WebView) r115[0]) + ", errorCode: " + r115[1]);     // Catch: Throwable -> L52
        r116.v((WebView) r115[0], ((Integer) r115[1]).intValue(), (String) r115[2], (String) r115[3]);     // Catch: Throwable -> L52
        return null;
    L41:
        if ("onReceivedHttpError".equals(r114.get("name")) == false) goto L47;
        if (r115.length != 3) goto L47;
        nz2.b.f("TTWebViewClientDelegateHandler", "handleRequestHttpError: " + nz2.b.e((WebView) r115[0]) + ", request: " + r115[1]);     // Catch: Throwable -> L52
        r116.y((WebView) r115[0], (WebResourceRequest) r115[1], (WebResourceResponse) r115[2]);     // Catch: Throwable -> L52
        return null;
    L47:
        if ("onRenderProcessGone".equals(r114.get("name")) == true) goto L49;
    L54:
        return null;
    L49:
        if (r115.length != 2) goto L54;
        nz2.b.f("TTWebViewClientDelegateHandler", "handleRenderProcessGone: " + nz2.b.e((WebView) r115[0]) + ", detail: " + r115[1]);     // Catch: Throwable -> L52
        r116.s((WebView) r115[0], (RenderProcessGoneDetail) r115[1]);     // Catch: Throwable -> L52
        return null;
    L52:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L54
    }
}
