package cd7;

import android.app.Activity;
import android.content.Context;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<WebView> f23410a;

    @Override // cd7.a
    public Activity getActivity() {
        WebView r100 = this.f23410a.get();
        Context r101 = null;
        if (r100 == null) goto L5;
        Context r102 = r100.getContext();
    L7:
        if ((r102 instanceof Activity) == false) goto L11;
        r101 = r102;
    L11:
        return (Activity) r101;
    L5:
        r102 = null;
        goto L7
    }

    @Override // cd7.a
    public final String getUrl() {
        WebView r100 = this.f23410a.get();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUrl();
    }

    public c(WebView r100) {
        this.f23410a = new WeakReference(r100);
    }

    @Override // cd7.a
    public final void loadUrl(String r100) {
        WebView r101 = this.f23410a.get();
        if (r101 == null) goto L6;
        r101.loadUrl(r100);
        return;
    }

    @Override // cd7.a
    public final void addJavascriptInterface(Object r100, String r101) {
        WebView r102 = this.f23410a.get();
        if (r102 == null) goto L6;
        r102.addJavascriptInterface(r100, "JS2NativeBridge");
        return;
    }

    @Override // cd7.a
    public final void b(String r100, yc7.b.a r101) {
        if ((r101 instanceof ValueCallback) == false) goto L7;
        WebView r102 = this.f23410a.get();
        if (r102 == null) goto L11;
        r102.evaluateJavascript(r100, r101);
        return;
    L11:
        return;
    L7:
        WebView r103 = this.f23410a.get();
        if (r103 == null) goto L13;
        r103.evaluateJavascript(r100, null);
        return;
    }
}
