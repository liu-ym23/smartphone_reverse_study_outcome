package wa;

import java.util.List;
import n7.o;

/* loaded from: classes.dex */
public final class j implements ua.d {

    /* renamed from: a, reason: collision with root package name */
    public final String f10985a;

    /* renamed from: b, reason: collision with root package name */
    public final ua.c f10986b;

    public j(String str, ua.c cVar) {
        q7.k.e(cVar, "kind");
        this.f10985a = str;
        this.f10986b = cVar;
    }

    @Override // ua.d
    public final int a(String str) {
        q7.k.e(str, "name");
        f();
        throw null;
    }

    @Override // ua.d
    public final String b() {
        return this.f10985a;
    }

    @Override // ua.d
    public final int c() {
        return 0;
    }

    @Override // ua.d
    public final String d(int i2) {
        f();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return q7.k.a(this.f10985a, jVar.f10985a) && q7.k.a(this.f10986b, jVar.f10986b);
    }

    public final void f() {
        throw new IllegalStateException(a1.a.m(new StringBuilder("Primitive descriptor "), this.f10985a, " does not have elements"));
    }

    @Override // ua.d
    public final o getKind() {
        return this.f10986b;
    }

    @Override // ua.d
    public final List h(int i2) {
        f();
        throw null;
    }

    public final int hashCode() {
        return (this.f10986b.hashCode() * 31) + this.f10985a.hashCode();
    }

    @Override // ua.d
    public final ua.d i(int i2) {
        f();
        throw null;
    }

    @Override // ua.d
    public final boolean j(int i2) {
        f();
        throw null;
    }

    public final String toString() {
        return a1.a.l(new StringBuilder("PrimitiveDescriptor("), this.f10985a, ')');
    }
}
