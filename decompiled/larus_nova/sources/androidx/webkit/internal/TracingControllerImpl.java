package androidx.webkit.internal;

import androidx.webkit.TracingConfig;
import androidx.webkit.TracingController;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class TracingControllerImpl extends TracingController {
    private TracingControllerBoundaryInterface mBoundaryInterface;
    private android.webkit.TracingController mFrameworksImpl;

    private TracingControllerBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface != null) goto L6;
        this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getTracingController();
    L6:
        return this.mBoundaryInterface;
    }

    private android.webkit.TracingController getFrameworksImpl() {
        if (this.mFrameworksImpl != null) goto L6;
        this.mFrameworksImpl = ApiHelperForP.getTracingControllerInstance();
    L6:
        return this.mFrameworksImpl;
    }

    @Override // androidx.webkit.TracingController
    public boolean isTracing() {
        ApiFeature.P r100 = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (r100.isSupportedByFramework() == false) goto L7;
        return ApiHelperForP.isTracing(getFrameworksImpl());
    L7:
        if (r100.isSupportedByWebView() == false) goto L11;
        return getBoundaryInterface().isTracing();
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public TracingControllerImpl() {
        ApiFeature.P r100 = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (r100.isSupportedByFramework() == false) goto L6;
        this.mFrameworksImpl = ApiHelperForP.getTracingControllerInstance();
        this.mBoundaryInterface = null;
        return;
    L6:
        if (r100.isSupportedByWebView() == false) goto L10;
        this.mFrameworksImpl = null;
        this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getTracingController();
        return;
    L10:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.TracingController
    public void start(TracingConfig r100) {
        if (r100 == null) goto L13;
        ApiFeature.P r101 = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (r101.isSupportedByFramework() == false) goto L7;
        ApiHelperForP.start(getFrameworksImpl(), r100);
        return;
    L7:
        if (r101.isSupportedByWebView() == false) goto L11;
        getBoundaryInterface().start(r100.getPredefinedCategories(), r100.getCustomIncludedCategories(), r100.getTracingMode());
        return;
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    L13:
        throw new IllegalArgumentException("Tracing config must be non null");
    }

    @Override // androidx.webkit.TracingController
    public boolean stop(OutputStream r100, Executor r101) {
        ApiFeature.P r102 = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (r102.isSupportedByFramework() == false) goto L7;
        return ApiHelperForP.stop(getFrameworksImpl(), r100, r101);
    L7:
        if (r102.isSupportedByWebView() == false) goto L11;
        return getBoundaryInterface().stop(r100, r101);
    L11:
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
