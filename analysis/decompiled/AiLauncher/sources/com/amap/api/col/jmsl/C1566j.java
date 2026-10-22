package com.amap.api.col.jmsl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.amap.api.maps.IAMapJsCallback;
import com.amap.api.maps.IAMapWebView;

/* renamed from: com.amap.api.col.jmsl.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1566j extends WebView implements IAMapWebView {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1552f1 f16668a;

    public C1566j(Context context, AttributeSet attributeSet) {
        super(context, null);
        a();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void a() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setCacheMode(-1);
        settings.setDefaultTextEncodingName("utf-8");
        WebView.setWebContentsDebuggingEnabled(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        setWebChromeClient(new WebChromeClient());
    }

    @Override // com.amap.api.maps.IAMapWebView
    @SuppressLint({"JavascriptInterface"})
    public void addAMapJavascriptInterface(IAMapJsCallback iAMapJsCallback, String str) {
        addJavascriptInterface(iAMapJsCallback, str);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterfaceC1552f1 interfaceC1552f1;
        try {
            interfaceC1552f1 = this.f16668a;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (interfaceC1552f1 == null) {
            return false;
        }
        if (interfaceC1552f1.p(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
