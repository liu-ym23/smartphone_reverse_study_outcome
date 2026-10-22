package androidx.webkit.internal;

import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewFeature;
import java.lang.reflect.InvocationHandler;
import nvc.a;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebMessageCallbackAdapter implements WebMessageCallbackBoundaryInterface {
    private final WebMessagePortCompat.WebMessageCallbackCompat mImpl;

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[]{WebViewFeature.WEB_MESSAGE_CALLBACK_ON_MESSAGE};
    }

    public WebMessageCallbackAdapter(WebMessagePortCompat.WebMessageCallbackCompat r100) {
        this.mImpl = r100;
    }

    @Override // org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface
    public void onMessage(InvocationHandler r100, InvocationHandler r101) {
        this.mImpl.onMessage(new WebMessagePortImpl(r100), WebMessageAdapter.webMessageCompatFromBoundaryInterface((WebMessageBoundaryInterface) a.a(WebMessageBoundaryInterface.class, r101)));
    }
}
