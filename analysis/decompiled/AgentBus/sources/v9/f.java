package v9;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f implements m0 {

    /* renamed from: a, reason: collision with root package name */
    public int f10547a;

    /* renamed from: b, reason: collision with root package name */
    public final u9.d f10548b;

    public f(u9.n nVar) {
        q7.k.e(nVar, "storageManager");
        this.f10548b = new u9.d((u9.k) nVar, new t9.h(5, this), new r8.c(9, this));
    }

    public abstract Collection e();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof m0) && obj.hashCode() == hashCode()) {
            m0 m0Var = (m0) obj;
            if (m0Var.getParameters().size() == getParameters().size()) {
                f8.g gVarC = c();
                f8.g gVarC2 = m0Var.c();
                if (gVarC2 == null || x9.i.f(gVarC) || h9.f.o(gVarC) || x9.i.f(gVarC2) || h9.f.o(gVarC2)) {
                    return false;
                }
                return i(gVarC2);
            }
        }
        return false;
    }

    public abstract v f();

    public abstract f8.o0 g();

    @Override // v9.m0
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final List d() {
        return ((e) this.f10548b.c()).f10544b;
    }

    public final int hashCode() {
        int i2 = this.f10547a;
        if (i2 != 0) {
            return i2;
        }
        f8.g gVarC = c();
        int iIdentityHashCode = (x9.i.f(gVarC) || h9.f.o(gVarC)) ? System.identityHashCode(this) : h9.f.g(gVarC).f3193a.hashCode();
        this.f10547a = iIdentityHashCode;
        return iIdentityHashCode;
    }

    public abstract boolean i(f8.g gVar);

    public List j(List list) {
        return list;
    }
}
