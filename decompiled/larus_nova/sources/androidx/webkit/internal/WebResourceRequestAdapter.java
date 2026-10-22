package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebResourceRequestBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebResourceRequestAdapter {
    private final WebResourceRequestBoundaryInterface mBoundaryInterface;

    public boolean isRedirect() {
        return this.mBoundaryInterface.isRedirect();
    }

    public WebResourceRequestAdapter(WebResourceRequestBoundaryInterface r100) {
        this.mBoundaryInterface = r100;
    }
}
