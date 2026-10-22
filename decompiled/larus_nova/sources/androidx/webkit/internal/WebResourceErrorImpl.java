package androidx.webkit.internal;

import android.webkit.WebResourceError;
import androidx.webkit.WebResourceErrorCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import nvc.a;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebResourceErrorImpl extends WebResourceErrorCompat {
    private WebResourceErrorBoundaryInterface mBoundaryInterface;
    private WebResourceError mFrameworksImpl;

    private WebResourceErrorBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface != null) goto L6;
        this.mBoundaryInterface = (WebResourceErrorBoundaryInterface) a.a(WebResourceErrorBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertWebResourceError(this.mFrameworksImpl));
    L6:
        return this.mBoundaryInterface;
    }

    private WebResourceError getFrameworksImpl() {
        if (this.mFrameworksImpl != null) goto L6;
        this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertWebResourceError(Proxy.getInvocationHandler(this.mBoundaryInterface));
    L6:
        return this.mFrameworksImpl;
    }

    @Override // androidx.webkit.WebResourceErrorCompat
    public CharSequence getDescription() {
        ApiFeature.M r100 = WebViewFeatureInternal.WEB_RESOURCE_ERROR_GET_DESCRIPTION;
        if (r100.isSupportedByFramework() == false) goto L7;
        return ApiHelperForM.getDescription(getFrameworksImpl());
    L7:
        if (r100.isSupportedByWebView() == false) goto L11;
        return getBoundaryInterface().getDescription();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.WebResourceErrorCompat
    public int getErrorCode() {
        ApiFeature.M r100 = WebViewFeatureInternal.WEB_RESOURCE_ERROR_GET_CODE;
        if (r100.isSupportedByFramework() == false) goto L7;
        return ApiHelperForM.getErrorCode(getFrameworksImpl());
    L7:
        if (r100.isSupportedByWebView() == false) goto L11;
        return getBoundaryInterface().getErrorCode();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public WebResourceErrorImpl(InvocationHandler r100) {
        this.mBoundaryInterface = (WebResourceErrorBoundaryInterface) a.a(WebResourceErrorBoundaryInterface.class, r100);
    }

    public WebResourceErrorImpl(WebResourceError r100) {
        this.mFrameworksImpl = r100;
    }
}
