package com.bytedance.bdturing.b;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.bdturing.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsBridgeModule.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "JsBridgeModule";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f6508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f6509b;

    /* JADX INFO: compiled from: JsBridgeModule.java */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f6515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bytedance.bdturing.b.a f6516b;

        static /* synthetic */ com.bytedance.bdturing.b.a a(a r0) {
            return r0.f6516b;
        }

        public a(b r3, com.bytedance.bdturing.b.a r4) {
            com.bytedance.bdturing.b.a r5 = (com.bytedance.bdturing.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.bdturing.b.a.class, "com.obric.aiagent.plugin");
            this.f6515a = r3;
            this.f6516b = r5;
        }

        @JavascriptInterface
        public void callMethodParams(final String r3) {
            g.g(b.TAG, "JS called method ======= callMethodParams(" + r3 + ")");
            if (b.a(this.f6515a) != null) goto L6;
            g.a(b.TAG, "uihandler is null");
            return;
        L6:
            b.a(this.f6515a).post(new AnonymousClass1(this, r3));
        }

        @JavascriptInterface
        public void onMethodParams(String r2) {
            g.g(b.TAG, "JS called method ======= onMethodParams(" + r2 + ")");
            new JSONObject(r2).getString("__callback_id");     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @JavascriptInterface
        public void offMethodParams(String r2) {
            g.g(b.TAG, "JS called method ======= offMethodParams(" + r2 + ")");
        }
    }

    static /* synthetic */ Handler a(b r0) {
        return r0.f6509b;
    }

    static /* synthetic */ WebView b(b r0) {
        return r0.f6508a;
    }

    public b(com.bytedance.bdturing.b.a r3, WebView r4) {
        com.bytedance.bdturing.b.a r5 = (com.bytedance.bdturing.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.bdturing.b.a.class, "com.obric.aiagent.plugin");
        this.f6509b = null;
        this.f6508a = r4;
        if (r4 != null) goto L5;
        return;
    L5:
        r4.getSettings().setJavaScriptEnabled(true);
        this.f6508a.addJavascriptInterface(new a(this, r5), "androidJsBridge");
        this.f6509b = new Handler(Looper.getMainLooper());
    }

    public void a(final String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.f6508a == null) goto L11;
        Handler r0 = this.f6509b;
        if (r0 == null) goto L12;
        r0.post(new AnonymousClass1(this, r3));
        g.g(TAG, "callJsCode ====== " + r3);
        return;
    L12:
        return;
    }

    public void a() {
        if (this.f6508a != null) goto L5;
        return;
    L5:
        this.f6509b.post(new AnonymousClass2(this));
        this.f6509b = null;
        this.f6508a = null;
    }
}
