package com.bytedance.ai.model;

import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.ai.monitor.bridge.BridgeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class h0 {
    public h0() {
    }

    public abstract String a();

    public abstract WebView b();

    public abstract void c(String r100);

    @JavascriptInterface
    public final void appletPostMessage(String r100) {
        l5.w r101 = l5.w.f507419b;
        String r102 = a();
        BridgeType r103 = BridgeType.V1;
        Intrinsics.checkNotNullParameter("appletPostMessageWebView", "name");
        Intrinsics.checkNotNullParameter(r103, "type");
        com.bytedance.ai.monitor.b.b("applet_old_bridge", new l5.y("appletPostMessageWebView", r103, r102, null));
        c(r100);
    }

    public final void d(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Runnable r101 = new f0(this, r100);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r101.run();
        return;
    L5:
        p2.c.d(r101);
    }
}
