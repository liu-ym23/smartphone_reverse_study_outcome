package com.bytedance.android.monitor.webview;

import android.webkit.WebView;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements cz2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f162931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f162932b;

    public final String a() {
        n r100 = this.f162932b.v(this.f162931a);
        if (r100 != null) goto L5;
        p r101 = this.f162932b.f162913a;
        WebView r102 = this.f162931a;
        return (String) ((WeakHashMap) r101.f162968a).get(r102);
    L5:
        return r100.f162961a.f531012a;
    }

    public e(d r100, WebView r101) {
        this.f162932b = r100;
        this.f162931a = r101;
    }
}
