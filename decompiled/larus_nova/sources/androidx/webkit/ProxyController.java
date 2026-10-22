package androidx.webkit;

import androidx.webkit.internal.ProxyControllerImpl;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public abstract class ProxyController {

    public static class LAZY_HOLDER {
        static final ProxyController INSTANCE = null;

        private LAZY_HOLDER() {
        }

        static {
            INSTANCE = new ProxyControllerImpl();
        }
    }

    public ProxyController() {
    }

    public abstract void clearProxyOverride(Executor r100, Runnable r101);

    public abstract void setProxyOverride(ProxyConfig r100, Executor r101, Runnable r102);

    public static ProxyController getInstance() {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE) == false) goto L7;
        return LAZY_HOLDER.INSTANCE;
    L7:
        throw new UnsupportedOperationException("Proxy override not supported");
    }
}
