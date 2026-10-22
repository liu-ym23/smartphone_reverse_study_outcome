package androidx.webkit.internal;

import android.webkit.WebResourceError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;

/* JADX INFO: compiled from: WebResourceErrorImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends androidx.webkit.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebResourceError f2997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebResourceErrorBoundaryInterface f2998b;

    public n(InvocationHandler r3) {
        this.f2998b = (WebResourceErrorBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(WebResourceErrorBoundaryInterface.class, (InvocationHandler) ZeusTransformUtils.wrapperContextForParams(r3, InvocationHandler.class, "com.obric.aiagent.plugin")), WebResourceErrorBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    public n(WebResourceError r1) {
        this.f2997a = r1;
    }

    private WebResourceError c() {
        if (this.f2997a != null) goto L6;
        this.f2997a = q.b().a(Proxy.getInvocationHandler(this.f2998b));
    L6:
        return this.f2997a;
    }

    private WebResourceErrorBoundaryInterface d() {
        if (this.f2998b != null) goto L6;
        this.f2998b = (WebResourceErrorBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(WebResourceErrorBoundaryInterface.class, q.b().a(this.f2997a)), WebResourceErrorBoundaryInterface.class, "com.obric.aiagent.plugin");
    L6:
        return this.f2998b;
    }

    @Override // androidx.webkit.h
    public int a() {
        a.b r0 = p.w;
        if (r0.c() == false) goto L7;
        return c.a(c());
    L7:
        if (r0.d() == false) goto L11;
        return d().getErrorCode();
    L11:
        throw p.a();
    }

    @Override // androidx.webkit.h
    public CharSequence b() {
        a.b r0 = p.v;
        if (r0.c() == false) goto L7;
        return c.b(c());
    L7:
        if (r0.d() == false) goto L11;
        return d().getDescription();
    L11:
        throw p.a();
    }
}
