package c6;

import ab.e0;
import ab.z;
import java.io.IOException;

/* loaded from: classes.dex */
public final class j extends s7.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f1950b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ia.m f1951c;

    public j(n nVar, ia.m mVar) {
        this.f1950b = nVar;
        this.f1951c = mVar;
    }

    @Override // s7.a
    public final void K(e0 e0Var, int i2, String str) {
        q7.k.e(e0Var, "webSocket");
        this.f1950b.f(new a(i2, str, null));
    }

    @Override // s7.a
    public final void L(e0 e0Var, int i2, String str) {
        q7.k.e(e0Var, "webSocket");
        ((nb.g) e0Var).b(i2, str);
    }

    @Override // s7.a
    public final void M(nb.g gVar, Exception exc, z zVar) {
        String message = exc.getMessage();
        if (message == null) {
            message = "ws failure";
        }
        this.f1950b.f(ib.c.x(message, exc));
        ia.m mVar = this.f1951c;
        if (mVar.w()) {
            mVar.resumeWith(w7.e0.n(new IOException(exc.getMessage(), exc)));
        }
    }

    @Override // s7.a
    public final void N(e0 e0Var, String str) {
        q7.k.e(e0Var, "webSocket");
        n nVar = this.f1950b;
        if (nVar.f1959g.get()) {
            return;
        }
        nVar.f1956d.M(str);
    }

    @Override // s7.a
    public final void O(e0 e0Var, ob.k kVar) {
        q7.k.e(e0Var, "webSocket");
        String strR = kVar.r();
        n nVar = this.f1950b;
        if (nVar.f1959g.get()) {
            return;
        }
        nVar.f1956d.M(strR);
    }

    @Override // s7.a
    public final void P(e0 e0Var, z zVar) {
        this.f1950b.f1960h = e0Var;
        if (this.f1951c.w()) {
            this.f1951c.resumeWith(this.f1950b);
        }
    }
}
