package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebMessageAdapter implements WebMessageBoundaryInterface {
    private WebMessageCompat mWebMessageCompat;

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[0];
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public String getData() {
        return this.mWebMessageCompat.getData();
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public InvocationHandler getMessagePayload() {
        throw new UnsupportedOperationException("This method is not yet supported");
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public InvocationHandler[] getPorts() {
        WebMessagePortCompat[] r100 = this.mWebMessageCompat.getPorts();
        if (r100 != null) goto L6;
        return null;
    L6:
        InvocationHandler[] r101 = new InvocationHandler[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = r100[r102].getInvocationHandler();
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    }

    public WebMessageAdapter(WebMessageCompat r100) {
        this.mWebMessageCompat = r100;
    }

    private static WebMessagePortCompat[] toWebMessagePortCompats(InvocationHandler[] r100) {
        WebMessagePortCompat[] r101 = new WebMessagePortCompat[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = new WebMessagePortImpl(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static WebMessageCompat webMessageCompatFromBoundaryInterface(WebMessageBoundaryInterface r100) {
        return new WebMessageCompat(r100.getData(), toWebMessagePortCompats(r100.getPorts()));
    }
}
