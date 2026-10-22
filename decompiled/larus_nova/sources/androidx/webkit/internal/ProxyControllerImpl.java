package androidx.webkit.internal;

import androidx.webkit.ProxyConfig;
import androidx.webkit.ProxyController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class ProxyControllerImpl extends ProxyController {
    private ProxyControllerBoundaryInterface mBoundaryInterface;

    private ProxyControllerBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface != null) goto L6;
        this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getProxyController();
    L6:
        return this.mBoundaryInterface;
    }

    public ProxyControllerImpl() {
    }

    public static String[][] proxyRulesToStringArray(List<ProxyConfig.ProxyRule> r100) {
        String[][] r101 = (String[][]) Array.newInstance(String.class, new int[]{r100.size(), 2});
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L6;
        r101[r102][0] = ((ProxyConfig.ProxyRule) ListProtector.get(r100, r102)).getSchemeFilter();
        r101[r102][1] = ((ProxyConfig.ProxyRule) ListProtector.get(r100, r102)).getUrl();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    @Override // androidx.webkit.ProxyController
    public void clearProxyOverride(Executor r100, Runnable r101) {
        if (WebViewFeatureInternal.PROXY_OVERRIDE.isSupportedByWebView() == false) goto L7;
        getBoundaryInterface().clearProxyOverride(r101, r100);
        return;
    L7:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.ProxyController
    public void setProxyOverride(ProxyConfig r110, Executor r111, Runnable r112) {
        ApiFeature.NoFramework r100 = WebViewFeatureInternal.PROXY_OVERRIDE;
        ApiFeature.NoFramework r101 = WebViewFeatureInternal.PROXY_OVERRIDE_REVERSE_BYPASS;
        String[][] r102 = proxyRulesToStringArray(r110.getProxyRules());
        String[] r103 = (String[]) r110.getBypassRules().toArray(new String[0]);
        if (r100.isSupportedByWebView() == false) goto L8;
        if (r110.isReverseBypassEnabled() == true) goto L8;
        getBoundaryInterface().setProxyOverride(r102, r103, r112, r111);
        return;
    L8:
        if (r100.isSupportedByWebView() == false) goto L14;
        if (r101.isSupportedByWebView() == false) goto L14;
        getBoundaryInterface().setProxyOverride(r102, r103, r112, r111, r110.isReverseBypassEnabled());
        return;
    L14:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
