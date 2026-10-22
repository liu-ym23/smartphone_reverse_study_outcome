package androidx.webkit.internal;

import androidx.webkit.WebViewRenderProcess;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.util.WeakHashMap;
import nvc.a;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebViewRenderProcessImpl extends WebViewRenderProcess {
    private static final WeakHashMap<android.webkit.WebViewRenderProcess, WebViewRenderProcessImpl> sFrameworkMap = null;
    private WebViewRendererBoundaryInterface mBoundaryInterface;
    private WeakReference<android.webkit.WebViewRenderProcess> mFrameworkObject;

    static {
        sFrameworkMap = new WeakHashMap();
    }

    @Override // androidx.webkit.WebViewRenderProcess
    public boolean terminate() {
        ApiFeature.Q r100 = WebViewFeatureInternal.WEB_VIEW_RENDERER_TERMINATE;
        if (r100.isSupportedByFramework() == false) goto L12;
        android.webkit.WebViewRenderProcess r101 = this.mFrameworkObject.get();
        if (r101 != null) goto L7;
    L9:
        return false;
    L7:
        if (ApiHelperForQ.terminate(r101) == false) goto L9;
        return true;
    L12:
        if (r100.isSupportedByWebView() == false) goto L16;
        return this.mBoundaryInterface.terminate();
    L16:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public WebViewRenderProcessImpl(android.webkit.WebViewRenderProcess r100) {
        this.mFrameworkObject = new WeakReference(r100);
    }

    public static WebViewRenderProcessImpl forFrameworkObject(android.webkit.WebViewRenderProcess r100) {
        WeakHashMap<android.webkit.WebViewRenderProcess, WebViewRenderProcessImpl> r101 = sFrameworkMap;
        WebViewRenderProcessImpl r102 = r101.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        WebViewRenderProcessImpl r103 = new WebViewRenderProcessImpl(r100);
        r101.put(r100, r103);
        return r103;
    }

    public static WebViewRenderProcessImpl forInvocationHandler(InvocationHandler r100) {
        final WebViewRendererBoundaryInterface r101 = (WebViewRendererBoundaryInterface) a.a(WebViewRendererBoundaryInterface.class, r100);
        return (WebViewRenderProcessImpl) r101.getOrCreatePeer(new AnonymousClass1(r101));
    }

    public WebViewRenderProcessImpl(WebViewRendererBoundaryInterface r100) {
        this.mBoundaryInterface = r100;
    }
}
