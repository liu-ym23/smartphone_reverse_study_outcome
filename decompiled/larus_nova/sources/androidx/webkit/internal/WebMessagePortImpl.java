package androidx.webkit.internal;

import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import nvc.a;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebMessagePortImpl extends WebMessagePortCompat {
    private WebMessagePortBoundaryInterface mBoundaryInterface;
    private WebMessagePort mFrameworksImpl;

    private WebMessagePortBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface != null) goto L6;
        this.mBoundaryInterface = (WebMessagePortBoundaryInterface) a.a(WebMessagePortBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(this.mFrameworksImpl));
    L6:
        return this.mBoundaryInterface;
    }

    private WebMessagePort getFrameworksImpl() {
        if (this.mFrameworksImpl != null) goto L6;
        this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(Proxy.getInvocationHandler(this.mBoundaryInterface));
    L6:
        return this.mFrameworksImpl;
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public void close() {
        ApiFeature.M r100 = WebViewFeatureInternal.WEB_MESSAGE_PORT_CLOSE;
        if (r100.isSupportedByFramework() == false) goto L6;
        ApiHelperForM.close(getFrameworksImpl());
        return;
    L6:
        if (r100.isSupportedByWebView() == false) goto L10;
        getBoundaryInterface().close();
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public WebMessagePort getFrameworkPort() {
        return getFrameworksImpl();
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public InvocationHandler getInvocationHandler() {
        return Proxy.getInvocationHandler(getBoundaryInterface());
    }

    public WebMessagePortImpl(InvocationHandler r100) {
        this.mBoundaryInterface = (WebMessagePortBoundaryInterface) a.a(WebMessagePortBoundaryInterface.class, r100);
    }

    public static WebMessage compatToFrameworkMessage(WebMessageCompat r100) {
        return ApiHelperForM.createWebMessage(r100);
    }

    public static WebMessagePort[] compatToPorts(WebMessagePortCompat[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length;
        WebMessagePort[] r102 = new WebMessagePort[r101];
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L8;
        r102[r103] = r100[r103].getFrameworkPort();
        r103 = r103 + 1;
        goto L6
    L8:
        return r102;
    }

    public static WebMessageCompat frameworkMessageToCompat(WebMessage r100) {
        return ApiHelperForM.createWebMessageCompat(r100);
    }

    public static WebMessagePortCompat[] portsToCompat(WebMessagePort[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        WebMessagePortCompat[] r101 = new WebMessagePortCompat[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = new WebMessagePortImpl(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public void postMessage(WebMessageCompat r100) {
        ApiFeature.M r101 = WebViewFeatureInternal.WEB_MESSAGE_PORT_POST_MESSAGE;
        if (r101.isSupportedByFramework() == false) goto L6;
        ApiHelperForM.postMessage(getFrameworksImpl(), compatToFrameworkMessage(r100));
        return;
    L6:
        if (r101.isSupportedByWebView() == false) goto L10;
        WebMessagePortBoundaryInterface r102 = getBoundaryInterface();
        WebMessageAdapter r103 = new WebMessageAdapter(r100);
        int r104 = a.f520929a;
        r102.postMessage(new a.C6981a(r103));
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public void setWebMessageCallback(WebMessagePortCompat.WebMessageCallbackCompat r100) {
        ApiFeature.M r101 = WebViewFeatureInternal.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK;
        if (r101.isSupportedByFramework() == false) goto L6;
        ApiHelperForM.setWebMessageCallback(getFrameworksImpl(), r100);
        return;
    L6:
        if (r101.isSupportedByWebView() == false) goto L10;
        WebMessagePortBoundaryInterface r102 = getBoundaryInterface();
        WebMessageCallbackAdapter r103 = new WebMessageCallbackAdapter(r100);
        int r104 = a.f520929a;
        r102.setWebMessageCallback(new a.C6981a(r103));
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public WebMessagePortImpl(WebMessagePort r100) {
        this.mFrameworksImpl = r100;
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public void setWebMessageCallback(Handler r100, WebMessagePortCompat.WebMessageCallbackCompat r101) {
        ApiFeature.M r102 = WebViewFeatureInternal.CREATE_WEB_MESSAGE_CHANNEL;
        if (r102.isSupportedByFramework() == false) goto L6;
        ApiHelperForM.setWebMessageCallback(getFrameworksImpl(), r101, r100);
        return;
    L6:
        if (r102.isSupportedByWebView() == false) goto L10;
        WebMessagePortBoundaryInterface r103 = getBoundaryInterface();
        WebMessageCallbackAdapter r104 = new WebMessageCallbackAdapter(r101);
        int r105 = a.f520929a;
        r103.setWebMessageCallback(new a.C6981a(r104), r100);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
