package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import androidx.webkit.SafeBrowsingResponseCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import nvc.a;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class SafeBrowsingResponseImpl extends SafeBrowsingResponseCompat {
    private SafeBrowsingResponseBoundaryInterface mBoundaryInterface;
    private SafeBrowsingResponse mFrameworksImpl;

    private SafeBrowsingResponseBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface != null) goto L6;
        this.mBoundaryInterface = (SafeBrowsingResponseBoundaryInterface) a.a(SafeBrowsingResponseBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertSafeBrowsingResponse(this.mFrameworksImpl));
    L6:
        return this.mBoundaryInterface;
    }

    private SafeBrowsingResponse getFrameworksImpl() {
        if (this.mFrameworksImpl != null) goto L6;
        this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertSafeBrowsingResponse(Proxy.getInvocationHandler(this.mBoundaryInterface));
    L6:
        return this.mFrameworksImpl;
    }

    public SafeBrowsingResponseImpl(InvocationHandler r100) {
        this.mBoundaryInterface = (SafeBrowsingResponseBoundaryInterface) a.a(SafeBrowsingResponseBoundaryInterface.class, r100);
    }

    @Override // androidx.webkit.SafeBrowsingResponseCompat
    public void backToSafety(boolean r100) {
        ApiFeature.O_MR1 r101 = WebViewFeatureInternal.SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY;
        if (r101.isSupportedByFramework() == false) goto L6;
        ApiHelperForOMR1.backToSafety(getFrameworksImpl(), r100);
        return;
    L6:
        if (r101.isSupportedByWebView() == false) goto L10;
        getBoundaryInterface().backToSafety(r100);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.SafeBrowsingResponseCompat
    public void proceed(boolean r100) {
        ApiFeature.O_MR1 r101 = WebViewFeatureInternal.SAFE_BROWSING_RESPONSE_PROCEED;
        if (r101.isSupportedByFramework() == false) goto L6;
        ApiHelperForOMR1.proceed(getFrameworksImpl(), r100);
        return;
    L6:
        if (r101.isSupportedByWebView() == false) goto L10;
        getBoundaryInterface().proceed(r100);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.SafeBrowsingResponseCompat
    public void showInterstitial(boolean r100) {
        ApiFeature.O_MR1 r101 = WebViewFeatureInternal.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL;
        if (r101.isSupportedByFramework() == false) goto L6;
        ApiHelperForOMR1.showInterstitial(getFrameworksImpl(), r100);
        return;
    L6:
        if (r101.isSupportedByWebView() == false) goto L10;
        getBoundaryInterface().showInterstitial(r100);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public SafeBrowsingResponseImpl(SafeBrowsingResponse r100) {
        this.mFrameworksImpl = r100;
    }
}
