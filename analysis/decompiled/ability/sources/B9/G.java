package B9;

import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class G implements z9.g {

    /* renamed from: a, reason: collision with root package name */
    public final String f219a;
    public final z9.g b;
    public final z9.g c;

    public G(String str, z9.g gVar, z9.g gVar2) {
        this.f219a = str;
        this.b = gVar;
        this.c = gVar2;
    }

    @Override // z9.g
    public final int c(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        Integer numF0 = j9.t.f0(name);
        if (numF0 != null) {
            return numF0.intValue();
        }
        throw new IllegalArgumentException(name.concat(" is not a valid map index"));
    }

    @Override // z9.g
    public final int d() {
        return 2;
    }

    @Override // z9.g
    public final String e(int i) {
        return String.valueOf(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G)) {
            return false;
        }
        G g = (G) obj;
        return kotlin.jvm.internal.k.b(this.f219a, g.f219a) && kotlin.jvm.internal.k.b(this.b, g.b) && kotlin.jvm.internal.k.b(this.c, g.c);
    }

    @Override // z9.g
    public final List f(int i) {
        if (i >= 0) {
            return EmptyList.f4893a;
        }
        throw new IllegalArgumentException(B7.a.q(B7.a.u(i, "Illegal index ", ", "), this.f219a, " expects only non-negative indices").toString());
    }

    @Override // z9.g
    public final z9.g g(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.q(B7.a.u(i, "Illegal index ", ", "), this.f219a, " expects only non-negative indices").toString());
        }
        int i6 = i % 2;
        if (i6 == 0) {
            return this.b;
        }
        if (i6 == 1) {
            return this.c;
        }
        throw new IllegalStateException("Unreached");
    }

    @Override // z9.g
    public final H4.o getKind() {
        return z9.k.e;
    }

    @Override // z9.g
    public final String h() {
        return this.f219a;
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f219a.hashCode() * 31)) * 31);
    }

    @Override // z9.g
    public final boolean i(int i) {
        if (i >= 0) {
            return false;
        }
        throw new IllegalArgumentException(B7.a.q(B7.a.u(i, "Illegal index ", ", "), this.f219a, " expects only non-negative indices").toString());
    }

    public final String toString() {
        return this.f219a + '(' + this.b + ", " + this.c + ')';
    }
}
