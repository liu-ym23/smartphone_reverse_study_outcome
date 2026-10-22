package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import nvc.a;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebViewProviderAdapter {
    WebViewProviderBoundaryInterface mImpl;

    public WebMessagePortCompat[] createWebMessageChannel() {
        InvocationHandler[] r100 = this.mImpl.createWebMessageChannel();
        WebMessagePortCompat[] r101 = new WebMessagePortCompat[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = new WebMessagePortImpl(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public WebChromeClient getWebChromeClient() {
        return this.mImpl.getWebChromeClient();
    }

    public WebViewClient getWebViewClient() {
        return this.mImpl.getWebViewClient();
    }

    public WebViewRenderProcess getWebViewRenderProcess() {
        return WebViewRenderProcessImpl.forInvocationHandler(this.mImpl.getWebViewRenderer());
    }

    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        InvocationHandler r100 = this.mImpl.getWebViewRendererClient();
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = a.f520929a;
        return ((WebViewRenderProcessClientAdapter) ((a.C6981a) r100).f520930a).getWebViewRenderProcessClient();
    }

    public WebViewProviderAdapter(WebViewProviderBoundaryInterface r100) {
        this.mImpl = r100;
    }

    public void removeWebMessageListener(String r100) {
        this.mImpl.removeWebMessageListener(r100);
    }

    public ScriptHandlerImpl addDocumentStartJavaScript(String r100, String[] r101) {
        return ScriptHandlerImpl.toScriptHandler(this.mImpl.addDocumentStartJavaScript(r100, r101));
    }

    public void insertVisualStateCallback(long r100, WebViewCompat.VisualStateCallback r101) {
        WebViewProviderBoundaryInterface r102 = this.mImpl;
        VisualStateCallbackAdapter r103 = new VisualStateCallbackAdapter(r101);
        int r104 = a.f520929a;
        r102.insertVisualStateCallback(r100, new a.C6981a(r103));
    }

    public void postWebMessage(WebMessageCompat r100, Uri r101) {
        WebViewProviderBoundaryInterface r102 = this.mImpl;
        WebMessageAdapter r103 = new WebMessageAdapter(r100);
        int r104 = a.f520929a;
        r102.postMessageToMainFrame(new a.C6981a(r103), r101);
    }

    public void setWebViewRenderProcessClient(Executor r100, WebViewRenderProcessClient r101) {
        if (r101 == null) goto L4;
        WebViewRenderProcessClientAdapter r102 = new WebViewRenderProcessClientAdapter(r100, r101);
        int r103 = a.f520929a;
        a.C6981a r104 = new a.C6981a(r102);
    L5:
        this.mImpl.setWebViewRendererClient(r104);
        return;
    L4:
        r104 = null;
        goto L5
    }

    public void addWebMessageListener(String r100, String[] r101, WebViewCompat.WebMessageListener r102) {
        WebViewProviderBoundaryInterface r103 = this.mImpl;
        WebMessageListenerAdapter r104 = new WebMessageListenerAdapter(r102);
        int r105 = a.f520929a;
        r103.addWebMessageListener(r100, r101, new a.C6981a(r104));
    }
}
