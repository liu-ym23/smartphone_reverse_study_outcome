package com.bytedance.android.monitorV2.webview;

import android.webkit.WebView;
import com.bytedance.map.api.monitor.MapMonitorConst;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements InvocationHandler {
    public f() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r110, Method r111, Object[] r112) throws Throwable {
        String r100 = (String) r112[0];     // Catch: Throwable -> L48
        Integer r101 = (Integer) r112[1];     // Catch: Throwable -> L48
        HashMap r113 = (HashMap) r112[2];     // Catch: Throwable -> L48
        Object[] r102 = (Object[]) r113.get("args");     // Catch: Throwable -> L48
        m r114 = m.f163358f;     // Catch: Throwable -> L48
        if (r114.D() == true) goto L7;
        return null;
    L7:
        if ("ttwebviewdelegate".equals(r100) == true) goto L13;
        if (1 == r101.intValue()) goto L13;
        return null;
    L13:
        if ("init".equals(r113.get("name")) == false) goto L26;
        nz2.b.f("TTWebViewDelegateHandler", "handleViewCreate: " + nz2.b.e((WebView) r102[0]));     // Catch: Throwable -> L48
        WebView r115 = (WebView) r102[0];     // Catch: Throwable -> L48
        r114.getClass();     // Catch: Throwable -> L48
    L22:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);     // Catch: Throwable -> L48
    L24:
        return null;
    L16:
        if (r114.B() == false) goto L24;
        if (r115 == null) goto L24;
        r114.f163362d.o(r115);     // Catch: Throwable -> L22
    L26:
        if ("loadUrl".equals(r113.get("name")) == false) goto L30;
        nz2.b.f("TTWebViewDelegateHandler", "onLoadUrl: " + r102[1]);     // Catch: Throwable -> L48
        r114.G((WebView) r102[0], (String) r102[1]);     // Catch: Throwable -> L48
        return null;
    L30:
        if ("goBack".equals(r113.get("name")) == false) goto L34;
        nz2.b.f("TTWebViewDelegateHandler", "goBack: " + nz2.b.e((WebView) r102[0]));     // Catch: Throwable -> L48
        r114.m((WebView) r102[0]);     // Catch: Throwable -> L48
        return null;
    L34:
        if ("reload".equals(r113.get("name")) == false) goto L38;
        nz2.b.f("TTWebViewDelegateHandler", "reload: " + nz2.b.e((WebView) r102[0]));     // Catch: Throwable -> L48
        WebView r116 = (WebView) r102[0];     // Catch: Throwable -> L48
        r114.getClass();     // Catch: Throwable -> L48
        return null;
    L38:
        if (MapMonitorConst.EVENT_DESTROY.equals(r113.get("name")) == false) goto L50;
        nz2.b.f("TTWebViewDelegateHandler", "destroy: " + nz2.b.e((WebView) r102[0]));     // Catch: Throwable -> L48
        WebView r117 = (WebView) r102[0];     // Catch: Throwable -> L48
        r114.getClass();     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);     // Catch: Throwable -> L48
    L47:
        return null;
    L41:
        if (r114.B() == false) goto L47;
        r114.f163362d.p(r117);     // Catch: Throwable -> L45
    L50:
        return null;
    L48:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L50
    }
}
