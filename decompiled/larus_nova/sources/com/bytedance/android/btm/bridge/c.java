package com.bytedance.android.btm.bridge;

import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements b {
    public c() {
    }

    @Override // com.bytedance.android.btm.bridge.b
    public final String getHybridContainerType(g66.c r100) {
        if (obtainView(r100) == null) goto L5;
        return "ttwebview";
    L5:
        return "unkown";
    }

    @Override // com.bytedance.android.btm.bridge.b
    public final String getPageUrl(g66.c r100) {
        WebView r101 = (WebView) r100.c(WebView.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getUrl();
    }

    @Override // com.bytedance.android.btm.bridge.b
    public final View obtainView(g66.c r100) {
        return (View) r100.c(WebView.class);
    }
}
