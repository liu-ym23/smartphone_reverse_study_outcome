package com.amap.api.maps;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;

/* loaded from: classes.dex */
public interface IAMapWebView {
    void addAMapJavascriptInterface(IAMapJsCallback iAMapJsCallback, String str);

    void addView(View view, ViewGroup.LayoutParams layoutParams);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    int getHeight();

    int getWidth();

    void loadUrl(String str);

    void setWebViewClient(WebViewClient webViewClient);
}
