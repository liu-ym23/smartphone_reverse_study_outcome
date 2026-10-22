package androidx.webkit.internal;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;

/* JADX INFO: compiled from: WebMessagePortImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends androidx.webkit.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebMessagePort f2995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebMessagePortBoundaryInterface f2996b;

    public m(WebMessagePort r1) {
        this.f2995a = r1;
    }

    private WebMessagePort b() {
        if (this.f2995a != null) goto L6;
        this.f2995a = q.b().c(Proxy.getInvocationHandler(this.f2996b));
    L6:
        return this.f2995a;
    }

    @Override // androidx.webkit.g
    public WebMessagePort a() {
        return b();
    }

    public static androidx.webkit.g[] a(WebMessagePort[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        androidx.webkit.g[] r0 = new androidx.webkit.g[r4.length];
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L9;
        r0[r1] = new m(r4[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static WebMessagePort[] a(androidx.webkit.g[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = r4.length;
        WebMessagePort[] r1 = new WebMessagePort[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2] = r4[r2].a();
        r2 = r2 + 1;
        goto L6
    L8:
        return r1;
    }

    public static androidx.webkit.f a(WebMessage r0) {
        return c.a(r0);
    }
}
