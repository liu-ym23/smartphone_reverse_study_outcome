package com.bytedance.android.monitorV2.webview;

import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements InvocationHandler {
    public d() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r110, Object[] r111) throws Throwable {
        String r101 = (String) r111[0];     // Catch: Throwable -> L17
        Integer r102 = (Integer) r111[1];     // Catch: Throwable -> L17
        HashMap r112 = (HashMap) r111[2];     // Catch: Throwable -> L17
        Object[] r103 = (Object[]) r112.get("args");     // Catch: Throwable -> L17
        m r104 = m.f163358f;     // Catch: Throwable -> L17
        if (r104.D() == true) goto L7;
        return null;
    L7:
        if ("ttwebviewdelegate".equals(r101) == true) goto L12;
        if (1 == r102.intValue()) goto L12;
        return null;
    L12:
        if ("onProgressChanged".equals(r112.get("name")) == true) goto L14;
    L19:
        return null;
    L14:
        if (r103.length != 2) goto L19;
        nz2.b.f("TTWebChromeClientDelegateHandler", "onProgressChanged: " + nz2.b.e((WebView) r103[0]) + ", newProgress: " + r103[1]);     // Catch: Throwable -> L17
        r104.L((WebView) r103[0], ((Integer) r103[1]).intValue());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L19
    }
}
