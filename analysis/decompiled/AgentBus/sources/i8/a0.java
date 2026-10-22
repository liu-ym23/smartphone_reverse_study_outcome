package i8;

import com.stepos.account.oauth.OAuthConstants;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a0 extends m implements f8.z {

    /* renamed from: h, reason: collision with root package name */
    public final u9.k f4738h;

    /* renamed from: i, reason: collision with root package name */
    public final c8.h f4739i;

    /* renamed from: j, reason: collision with root package name */
    public final Map f4740j;

    /* renamed from: k, reason: collision with root package name */
    public final f0 f4741k;

    /* renamed from: l, reason: collision with root package name */
    public b9.g f4742l;

    /* renamed from: m, reason: collision with root package name */
    public f8.h0 f4743m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f4744n;

    /* renamed from: o, reason: collision with root package name */
    public final u9.e f4745o;

    /* renamed from: p, reason: collision with root package name */
    public final c7.o f4746p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(e9.f fVar, u9.k kVar, c8.h hVar, int i2) {
        super(g8.h.f3888a, fVar);
        q7.k.e(fVar, "moduleName");
        this.f4738h = kVar;
        this.f4739i = hVar;
        if (!fVar.f3198g) {
            throw new IllegalArgumentException("Module name must be special: " + fVar);
        }
        this.f4740j = d7.a0.f2944f;
        f0.f4767a.getClass();
        f0 f0Var = (f0) s0(d0.f4761b);
        this.f4741k = f0Var == null ? e0.f4763b : f0Var;
        this.f4744n = true;
        this.f4745o = kVar.b(new c1.w(6, this));
        this.f4746p = s7.a.H(new c8.k(this, 2));
    }

    public final void F0() {
        if (this.f4744n) {
            return;
        }
        if (s0(f8.v.f3516a) != null) {
            throw new ClassCastException();
        }
        String str = "Accessing invalid module descriptor " + this;
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        throw new d5.f(str);
    }

    @Override // f8.j
    public final Object P(f8.l lVar, Object obj) {
        return f8.y.accept(this, lVar, obj);
    }

    @Override // f8.z
    public final List W() {
        if (this.f4742l != null) {
            return d7.z.f2978f;
        }
        StringBuilder sb2 = new StringBuilder("Dependencies of module ");
        String str = getName().f3197f;
        q7.k.d(str, "name.toString()");
        sb2.append(str);
        sb2.append(" were not set");
        throw new AssertionError(sb2.toString());
    }

    @Override // f8.z
    public final boolean g0(f8.z zVar) {
        q7.k.e(zVar, "targetModule");
        if (equals(zVar)) {
            return true;
        }
        q7.k.b(this.f4742l);
        if (d7.r.I0(d7.b0.f2947f, zVar)) {
            return true;
        }
        W();
        return zVar.W().contains(this);
    }

    @Override // f8.z
    public final Collection j(e9.c cVar, p7.k kVar) {
        q7.k.e(cVar, "fqName");
        q7.k.e(kVar, "nameFilter");
        F0();
        F0();
        return ((l) this.f4746p.getValue()).j(cVar, kVar);
    }

    @Override // f8.z
    public final c8.h n() {
        return this.f4739i;
    }

    @Override // f8.j
    public final f8.j p() {
        return f8.y.getContainingDeclaration(this);
    }

    @Override // f8.z
    public final Object s0(f8.x xVar) {
        q7.k.e(xVar, "capability");
        Object obj = this.f4740j.get(xVar);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    @Override // i8.m
    public final String toString() {
        String strE0 = m.E0(this);
        return this.f4744n ? strE0 : strE0.concat(" !isValid");
    }

    @Override // f8.z
    public final f8.i0 z(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        F0();
        return (f8.i0) this.f4745o.invoke(cVar);
    }
}
