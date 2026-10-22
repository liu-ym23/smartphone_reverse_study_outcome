package j9;

import d7.z;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import v9.i0;
import v9.m0;

/* loaded from: classes.dex */
public final class n implements m0 {

    /* renamed from: a, reason: collision with root package name */
    public final Set f5413a;

    /* renamed from: b, reason: collision with root package name */
    public final c7.o f5414b;

    public n(Set set) {
        i0.f10557g.getClass();
        i0 i0Var = i0.f10558h;
        q7.k.e(i0Var, "attributes");
        v9.d.s(z.f2978f, x9.i.a(2, true, "unknown integer literal type"), i0Var, this, false);
        this.f5414b = s7.a.H(new l(0));
        this.f5413a = set;
    }

    @Override // v9.m0
    public final boolean a() {
        return false;
    }

    @Override // v9.m0
    public final f8.g c() {
        return null;
    }

    @Override // v9.m0
    public final Collection d() {
        return (List) this.f5414b.getValue();
    }

    @Override // v9.m0
    public final List getParameters() {
        return z.f2978f;
    }

    @Override // v9.m0
    public final c8.h n() {
        throw null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("IntegerLiteralType");
        sb2.append("[" + d7.r.U0(this.f5413a, ",", null, null, m.f5412g, 30) + ']');
        return sb2.toString();
    }
}
