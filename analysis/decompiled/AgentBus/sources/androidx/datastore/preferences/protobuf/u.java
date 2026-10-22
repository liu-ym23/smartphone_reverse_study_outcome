package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class u implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public final w f959f;

    /* renamed from: g, reason: collision with root package name */
    public w f960g;

    public u(w wVar) {
        this.f959f = wVar;
        if (wVar.g()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f960g = wVar.i();
    }

    public final w a() {
        w wVarB = b();
        wVarB.getClass();
        if (w.f(wVarB, true)) {
            return wVarB;
        }
        throw new i1();
    }

    public final w b() {
        if (!this.f960g.g()) {
            return this.f960g;
        }
        w wVar = this.f960g;
        wVar.getClass();
        w0 w0Var = w0.f962c;
        w0Var.getClass();
        w0Var.a(wVar.getClass()).b(wVar);
        wVar.h();
        return this.f960g;
    }

    public final void c() {
        if (this.f960g.g()) {
            return;
        }
        w wVarI = this.f959f.i();
        w wVar = this.f960g;
        w0 w0Var = w0.f962c;
        w0Var.getClass();
        w0Var.a(wVarI.getClass()).a(wVarI, wVar);
        this.f960g = wVarI;
    }

    public final Object clone() {
        u uVar = (u) this.f959f.c(5);
        uVar.f960g = b();
        return uVar;
    }
}
