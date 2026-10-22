package androidx.webkit.internal;

import android.webkit.ServiceWorkerController;
import androidx.webkit.ServiceWorkerClientCompat;
import androidx.webkit.ServiceWorkerControllerCompat;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import nvc.a;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class ServiceWorkerControllerImpl extends ServiceWorkerControllerCompat {
    private ServiceWorkerControllerBoundaryInterface mBoundaryInterface;
    private ServiceWorkerController mFrameworksImpl;
    private final ServiceWorkerWebSettingsCompat mWebSettings;

    private ServiceWorkerControllerBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface != null) goto L6;
        this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getServiceWorkerController();
    L6:
        return this.mBoundaryInterface;
    }

    private ServiceWorkerController getFrameworksImpl() {
        if (this.mFrameworksImpl != null) goto L6;
        this.mFrameworksImpl = ApiHelperForN.getServiceWorkerControllerInstance();
    L6:
        return this.mFrameworksImpl;
    }

    public ServiceWorkerControllerImpl() {
        ApiFeature.N r100 = WebViewFeatureInternal.SERVICE_WORKER_BASIC_USAGE;
        if (r100.isSupportedByFramework() == false) goto L6;
        this.mFrameworksImpl = ApiHelperForN.getServiceWorkerControllerInstance();
        this.mBoundaryInterface = null;
        this.mWebSettings = ApiHelperForN.getServiceWorkerWebSettingsImpl(getFrameworksImpl());
        return;
    L6:
        if (r100.isSupportedByWebView() == false) goto L10;
        this.mFrameworksImpl = null;
        ServiceWorkerControllerBoundaryInterface r101 = WebViewGlueCommunicator.getFactory().getServiceWorkerController();
        this.mBoundaryInterface = r101;
        this.mWebSettings = new ServiceWorkerWebSettingsImpl(r101.getServiceWorkerWebSettings());
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.ServiceWorkerControllerCompat
    public ServiceWorkerWebSettingsCompat getServiceWorkerWebSettings() {
        return this.mWebSettings;
    }

    @Override // androidx.webkit.ServiceWorkerControllerCompat
    public void setServiceWorkerClient(ServiceWorkerClientCompat r100) {
        ApiFeature.N r101 = WebViewFeatureInternal.SERVICE_WORKER_BASIC_USAGE;
        if (r101.isSupportedByFramework() == false) goto L8;
        if (r100 != null) goto L6;
        ApiHelperForN.setServiceWorkerClient(getFrameworksImpl(), null);
        return;
    L6:
        ApiHelperForN.setServiceWorkerClientCompat(getFrameworksImpl(), r100);
        return;
    L8:
        if (r101.isSupportedByWebView() == false) goto L14;
        if (r100 != null) goto L11;
        getBoundaryInterface().setServiceWorkerClient(null);
        return;
    L11:
        ServiceWorkerControllerBoundaryInterface r102 = getBoundaryInterface();
        ServiceWorkerClientAdapter r103 = new ServiceWorkerClientAdapter(r100);
        int r104 = a.f520929a;
        r102.setServiceWorkerClient(new a.C6981a(r103));
        return;
    L14:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
