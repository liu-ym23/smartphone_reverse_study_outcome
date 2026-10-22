package B9;

import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public abstract class I implements z9.g {

    /* renamed from: a, reason: collision with root package name */
    public final z9.g f221a;

    public I(z9.g gVar) {
        this.f221a = gVar;
    }

    @Override // z9.g
    public final int c(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        Integer numF0 = j9.t.f0(name);
        if (numF0 != null) {
            return numF0.intValue();
        }
        throw new IllegalArgumentException(name.concat(" is not a valid list index"));
    }

    @Override // z9.g
    public final int d() {
        return 1;
    }

    @Override // z9.g
    public final String e(int i) {
        return String.valueOf(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I)) {
            return false;
        }
        I i = (I) obj;
        return kotlin.jvm.internal.k.b(this.f221a, i.f221a) && kotlin.jvm.internal.k.b(h(), i.h());
    }

    @Override // z9.g
    public final List f(int i) {
        if (i >= 0) {
            return EmptyList.f4893a;
        }
        StringBuilder sbU = B7.a.u(i, "Illegal index ", ", ");
        sbU.append(h());
        sbU.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbU.toString().toString());
    }

    @Override // z9.g
    public final z9.g g(int i) {
        if (i >= 0) {
            return this.f221a;
        }
        StringBuilder sbU = B7.a.u(i, "Illegal index ", ", ");
        sbU.append(h());
        sbU.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbU.toString().toString());
    }

    @Override // z9.g
    public final H4.o getKind() {
        return z9.k.d;
    }

    public final int hashCode() {
        return h().hashCode() + (this.f221a.hashCode() * 31);
    }

    @Override // z9.g
    public final boolean i(int i) {
        if (i >= 0) {
            return false;
        }
        StringBuilder sbU = B7.a.u(i, "Illegal index ", ", ");
        sbU.append(h());
        sbU.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbU.toString().toString());
    }

    public final String toString() {
        return h() + '(' + this.f221a + ')';
    }
}
