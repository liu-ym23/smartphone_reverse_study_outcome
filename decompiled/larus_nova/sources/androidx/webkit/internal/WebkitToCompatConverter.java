package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import java.lang.reflect.InvocationHandler;
import nvc.a;
import org.chromium.support_lib_boundary.WebResourceRequestBoundaryInterface;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebkitToCompatConverter {
    private final WebkitToCompatConverterBoundaryInterface mImpl;

    public WebkitToCompatConverter(WebkitToCompatConverterBoundaryInterface r100) {
        this.mImpl = r100;
    }

    public SafeBrowsingResponse convertSafeBrowsingResponse(InvocationHandler r100) {
        return (SafeBrowsingResponse) this.mImpl.convertSafeBrowsingResponse(r100);
    }

    public ServiceWorkerWebSettings convertServiceWorkerSettings(InvocationHandler r100) {
        return (ServiceWorkerWebSettings) this.mImpl.convertServiceWorkerSettings(r100);
    }

    public WebSettingsAdapter convertSettings(WebSettings r100) {
        return new WebSettingsAdapter((WebSettingsBoundaryInterface) a.a(WebSettingsBoundaryInterface.class, this.mImpl.convertSettings(r100)));
    }

    public WebMessagePort convertWebMessagePort(InvocationHandler r100) {
        return (WebMessagePort) this.mImpl.convertWebMessagePort(r100);
    }

    public WebResourceError convertWebResourceError(InvocationHandler r100) {
        return (WebResourceError) this.mImpl.convertWebResourceError(r100);
    }

    public WebResourceRequestAdapter convertWebResourceRequest(WebResourceRequest r100) {
        return new WebResourceRequestAdapter((WebResourceRequestBoundaryInterface) a.a(WebResourceRequestBoundaryInterface.class, this.mImpl.convertWebResourceRequest(r100)));
    }

    public InvocationHandler convertSafeBrowsingResponse(SafeBrowsingResponse r100) {
        return this.mImpl.convertSafeBrowsingResponse(r100);
    }

    public InvocationHandler convertServiceWorkerSettings(ServiceWorkerWebSettings r100) {
        return this.mImpl.convertServiceWorkerSettings(r100);
    }

    public InvocationHandler convertWebMessagePort(WebMessagePort r100) {
        return this.mImpl.convertWebMessagePort(r100);
    }

    public InvocationHandler convertWebResourceError(WebResourceError r100) {
        return this.mImpl.convertWebResourceError(r100);
    }
}
