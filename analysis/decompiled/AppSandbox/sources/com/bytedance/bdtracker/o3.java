package com.bytedance.bdtracker;

import android.webkit.WebView;
import com.bytedance.applog.util.WebViewJsUtil;

/* loaded from: classes.dex */
public class o3 implements Runnable {
    public final /* synthetic */ WebView a;
    public final /* synthetic */ p3 b;

    public o3(p3 p3Var, WebView webView) {
        this.b = p3Var;
        this.a = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebViewJsUtil.getWebInfo(this.a, this.b.c);
    }
}
