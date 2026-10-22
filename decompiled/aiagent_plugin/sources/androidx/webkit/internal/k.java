package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;

/* JADX INFO: compiled from: SafeBrowsingResponseImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends androidx.webkit.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SafeBrowsingResponse f2989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SafeBrowsingResponseBoundaryInterface f2990b;

    public k(InvocationHandler r3) {
        this.f2990b = (SafeBrowsingResponseBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(SafeBrowsingResponseBoundaryInterface.class, (InvocationHandler) ZeusTransformUtils.wrapperContextForParams(r3, InvocationHandler.class, "com.obric.aiagent.plugin")), SafeBrowsingResponseBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    public k(SafeBrowsingResponse r1) {
        this.f2989a = r1;
    }

    private SafeBrowsingResponse a() {
        if (this.f2989a != null) goto L6;
        this.f2989a = q.b().b(Proxy.getInvocationHandler(this.f2990b));
    L6:
        return this.f2989a;
    }

    private SafeBrowsingResponseBoundaryInterface b() {
        if (this.f2990b != null) goto L6;
        this.f2990b = (SafeBrowsingResponseBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(SafeBrowsingResponseBoundaryInterface.class, q.b().a(this.f2989a)), SafeBrowsingResponseBoundaryInterface.class, "com.obric.aiagent.plugin");
    L6:
        return this.f2990b;
    }

    @Override // androidx.webkit.c
    public void a(boolean r3) {
        a.f r0 = p.z;
        if (r0.c() == false) goto L6;
        e.a(a(), r3);
        return;
    L6:
        if (r0.d() == false) goto L10;
        b().showInterstitial(r3);
        return;
    L10:
        throw p.a();
    }
}
