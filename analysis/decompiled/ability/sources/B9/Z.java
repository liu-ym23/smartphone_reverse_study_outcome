package B9;

import java.util.List;

/* loaded from: classes4.dex */
public final class Z implements z9.g {

    /* renamed from: a, reason: collision with root package name */
    public final String f234a;
    public final z9.f b;

    public Z(String str, z9.f kind) {
        kotlin.jvm.internal.k.f(kind, "kind");
        this.f234a = str;
        this.b = kind;
    }

    public final void a() {
        throw new IllegalStateException(B7.a.q(new StringBuilder("Primitive descriptor "), this.f234a, " does not have elements"));
    }

    @Override // z9.g
    public final int c(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        a();
        throw null;
    }

    @Override // z9.g
    public final int d() {
        return 0;
    }

    @Override // z9.g
    public final String e(int i) {
        a();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Z)) {
            return false;
        }
        Z z10 = (Z) obj;
        return kotlin.jvm.internal.k.b(this.f234a, z10.f234a) && kotlin.jvm.internal.k.b(this.b, z10.b);
    }

    @Override // z9.g
    public final List f(int i) {
        a();
        throw null;
    }

    @Override // z9.g
    public final z9.g g(int i) {
        a();
        throw null;
    }

    @Override // z9.g
    public final H4.o getKind() {
        return this.b;
    }

    @Override // z9.g
    public final String h() {
        return this.f234a;
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.f234a.hashCode();
    }

    @Override // z9.g
    public final boolean i(int i) {
        a();
        throw null;
    }

    public final String toString() {
        return B7.a.g(')', this.f234a, new StringBuilder("PrimitiveDescriptor("));
    }
}
