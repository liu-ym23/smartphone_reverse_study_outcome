package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewFeature;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebViewRenderProcessClientAdapter implements WebViewRendererClientBoundaryInterface {
    private static final String[] sSupportedFeatures = null;
    private final Executor mExecutor;
    private final WebViewRenderProcessClient mWebViewRenderProcessClient;

    static {
        sSupportedFeatures = new String[]{WebViewFeature.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE};
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return this.mWebViewRenderProcessClient;
    }

    public WebViewRenderProcessClientAdapter(Executor r100, WebViewRenderProcessClient r101) {
        this.mExecutor = r100;
        this.mWebViewRenderProcessClient = r101;
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public final void onRendererResponsive(final WebView r100, InvocationHandler r101) {
        final WebViewRenderProcessImpl r102 = WebViewRenderProcessImpl.forInvocationHandler(r101);
        final WebViewRenderProcessClient r103 = this.mWebViewRenderProcessClient;
        Executor r104 = this.mExecutor;
        if (r104 != null) goto L5;
        r103.onRenderProcessResponsive(r100, r102);
        return;
    L5:
        r104.execute(new AnonymousClass2(this, r103, r100, r102));
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public final void onRendererUnresponsive(final WebView r100, InvocationHandler r101) {
        final WebViewRenderProcessImpl r102 = WebViewRenderProcessImpl.forInvocationHandler(r101);
        final WebViewRenderProcessClient r103 = this.mWebViewRenderProcessClient;
        Executor r104 = this.mExecutor;
        if (r104 != null) goto L5;
        r103.onRenderProcessUnresponsive(r100, r102);
        return;
    L5:
        r104.execute(new AnonymousClass1(this, r103, r100, r102));
    }
}
