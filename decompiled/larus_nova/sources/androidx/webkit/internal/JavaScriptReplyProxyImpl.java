package androidx.webkit.internal;

import androidx.webkit.JavaScriptReplyProxy;
import java.lang.reflect.InvocationHandler;
import nvc.a;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class JavaScriptReplyProxyImpl extends JavaScriptReplyProxy {
    private JsReplyProxyBoundaryInterface mBoundaryInterface;

    public JavaScriptReplyProxyImpl(JsReplyProxyBoundaryInterface r100) {
        this.mBoundaryInterface = r100;
    }

    public static JavaScriptReplyProxyImpl forInvocationHandler(InvocationHandler r100) {
        final JsReplyProxyBoundaryInterface r101 = (JsReplyProxyBoundaryInterface) a.a(JsReplyProxyBoundaryInterface.class, r100);
        return (JavaScriptReplyProxyImpl) r101.getOrCreatePeer(new AnonymousClass1(r101));
    }

    @Override // androidx.webkit.JavaScriptReplyProxy
    public void postMessage(String r100) {
        if (WebViewFeatureInternal.WEB_MESSAGE_LISTENER.isSupportedByWebView() == false) goto L7;
        this.mBoundaryInterface.postMessage(r100);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
