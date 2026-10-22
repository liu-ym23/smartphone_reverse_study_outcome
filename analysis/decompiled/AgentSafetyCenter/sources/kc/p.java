package kc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class p extends nb.a implements nb.e {

    /* renamed from: c, reason: collision with root package name */
    public static final o f7469c;

    static {
        d2.y yVar = new d2.y(17);
        o oVar = new o();
        oVar.f7464c = yVar;
        oVar.f7465f = nb.d.f8810c;
        VarHandle.storeStoreFence();
        f7469c = oVar;
    }

    public p() {
        super(nb.d.f8810c);
    }

    public abstract void M(nb.g gVar, Runnable runnable);

    public void N(nb.g gVar, Runnable runnable) {
        M(gVar, runnable);
    }

    public boolean O(nb.g gVar) {
        return !(this instanceof q1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p P(int i) {
        pc.a.a(i);
        pc.g gVar = new pc.g();
        a0 a0Var = this instanceof a0 ? (a0) this : null;
        if (a0Var == null) {
            a0Var = y.f7501a;
        }
        gVar.f9960f = a0Var;
        gVar.f9961g = this;
        gVar.f9962h = i;
        gVar.i = new pc.k();
        gVar.f9963j = new Object();
        VarHandle.storeStoreFence();
        return gVar;
    }

    @Override // nb.a, nb.g
    public final nb.e get(nb.f fVar) {
        nb.e eVar;
        fVar.getClass();
        if (fVar instanceof o) {
            o oVar = (o) fVar;
            nb.f key = getKey();
            key.getClass();
            if ((key == oVar || oVar.f7465f == key) && (eVar = (nb.e) oVar.f7464c.invoke(this)) != null) {
                return eVar;
            }
        } else if (nb.d.f8810c == fVar) {
            return this;
        }
        return null;
    }

    @Override // nb.a, nb.g
    public final nb.g minusKey(nb.f fVar) {
        fVar.getClass();
        if (fVar instanceof o) {
            o oVar = (o) fVar;
            nb.f key = getKey();
            key.getClass();
            if ((key != oVar && oVar.f7465f != key) || ((nb.e) oVar.f7464c.invoke(this)) == null) {
                return this;
            }
        } else if (nb.d.f8810c != fVar) {
            return this;
        }
        return nb.h.f8811c;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + w.m(this);
    }
}
