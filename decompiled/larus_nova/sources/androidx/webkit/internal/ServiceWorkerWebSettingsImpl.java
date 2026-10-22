package androidx.webkit.internal;

import android.webkit.ServiceWorkerWebSettings;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import nvc.a;
import org.chromium.support_lib_boundary.ServiceWorkerWebSettingsBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class ServiceWorkerWebSettingsImpl extends ServiceWorkerWebSettingsCompat {
    private ServiceWorkerWebSettingsBoundaryInterface mBoundaryInterface;
    private ServiceWorkerWebSettings mFrameworksImpl;

    private ServiceWorkerWebSettingsBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface != null) goto L6;
        this.mBoundaryInterface = (ServiceWorkerWebSettingsBoundaryInterface) a.a(ServiceWorkerWebSettingsBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertServiceWorkerSettings(this.mFrameworksImpl));
    L6:
        return this.mBoundaryInterface;
    }

    private ServiceWorkerWebSettings getFrameworksImpl() {
        if (this.mFrameworksImpl != null) goto L6;
        this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertServiceWorkerSettings(Proxy.getInvocationHandler(this.mBoundaryInterface));
    L6:
        return this.mFrameworksImpl;
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    public boolean getAllowContentAccess() {
        ApiFeature.N r100 = WebViewFeatureInternal.SERVICE_WORKER_CONTENT_ACCESS;
        if (r100.isSupportedByFramework() == false) goto L7;
        return ApiHelperForN.getAllowContentAccess(getFrameworksImpl());
    L7:
        if (r100.isSupportedByWebView() == false) goto L11;
        return getBoundaryInterface().getAllowContentAccess();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    public boolean getAllowFileAccess() {
        ApiFeature.N r100 = WebViewFeatureInternal.SERVICE_WORKER_FILE_ACCESS;
        if (r100.isSupportedByFramework() == false) goto L7;
        return ApiHelperForN.getAllowFileAccess(getFrameworksImpl());
    L7:
        if (r100.isSupportedByWebView() == false) goto L11;
        return getBoundaryInterface().getAllowFileAccess();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    public boolean getBlockNetworkLoads() {
        ApiFeature.N r100 = WebViewFeatureInternal.SERVICE_WORKER_BLOCK_NETWORK_LOADS;
        if (r100.isSupportedByFramework() == false) goto L7;
        return ApiHelperForN.getBlockNetworkLoads(getFrameworksImpl());
    L7:
        if (r100.isSupportedByWebView() == false) goto L11;
        return getBoundaryInterface().getBlockNetworkLoads();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    public int getCacheMode() {
        ApiFeature.N r100 = WebViewFeatureInternal.SERVICE_WORKER_CACHE_MODE;
        if (r100.isSupportedByFramework() == false) goto L7;
        return ApiHelperForN.getCacheMode(getFrameworksImpl());
    L7:
        if (r100.isSupportedByWebView() == false) goto L11;
        return getBoundaryInterface().getCacheMode();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    public int getRequestedWithHeaderMode() {
        if (WebViewFeatureInternal.REQUESTED_WITH_HEADER_CONTROL.isSupportedByWebView() == false) goto L7;
        return getBoundaryInterface().getRequestedWithHeaderMode();
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public ServiceWorkerWebSettingsImpl(InvocationHandler r100) {
        this.mBoundaryInterface = (ServiceWorkerWebSettingsBoundaryInterface) a.a(ServiceWorkerWebSettingsBoundaryInterface.class, r100);
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    public void setAllowContentAccess(boolean r100) {
        ApiFeature.N r101 = WebViewFeatureInternal.SERVICE_WORKER_CONTENT_ACCESS;
        if (r101.isSupportedByFramework() == false) goto L6;
        ApiHelperForN.setAllowContentAccess(getFrameworksImpl(), r100);
        return;
    L6:
        if (r101.isSupportedByWebView() == false) goto L10;
        getBoundaryInterface().setAllowContentAccess(r100);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    public void setAllowFileAccess(boolean r100) {
        ApiFeature.N r101 = WebViewFeatureInternal.SERVICE_WORKER_FILE_ACCESS;
        if (r101.isSupportedByFramework() == false) goto L6;
        ApiHelperForN.setAllowFileAccess(getFrameworksImpl(), r100);
        return;
    L6:
        if (r101.isSupportedByWebView() == false) goto L10;
        getBoundaryInterface().setAllowFileAccess(r100);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    public void setBlockNetworkLoads(boolean r100) {
        ApiFeature.N r101 = WebViewFeatureInternal.SERVICE_WORKER_BLOCK_NETWORK_LOADS;
        if (r101.isSupportedByFramework() == false) goto L6;
        ApiHelperForN.setBlockNetworkLoads(getFrameworksImpl(), r100);
        return;
    L6:
        if (r101.isSupportedByWebView() == false) goto L10;
        getBoundaryInterface().setBlockNetworkLoads(r100);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    public void setCacheMode(int r100) {
        ApiFeature.N r101 = WebViewFeatureInternal.SERVICE_WORKER_CACHE_MODE;
        if (r101.isSupportedByFramework() == false) goto L6;
        ApiHelperForN.setCacheMode(getFrameworksImpl(), r100);
        return;
    L6:
        if (r101.isSupportedByWebView() == false) goto L10;
        getBoundaryInterface().setCacheMode(r100);
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.ServiceWorkerWebSettingsCompat
    public void setRequestedWithHeaderMode(int r100) {
        if (WebViewFeatureInternal.REQUESTED_WITH_HEADER_CONTROL.isSupportedByWebView() == false) goto L7;
        getBoundaryInterface().setRequestedWithHeaderMode(r100);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public ServiceWorkerWebSettingsImpl(ServiceWorkerWebSettings r100) {
        this.mFrameworksImpl = r100;
    }
}
