package wa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import n7.o;

/* loaded from: classes.dex */
public final class k implements ua.d, a {

    /* renamed from: a, reason: collision with root package name */
    public final ua.d f10987a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10988b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f10989c;

    public k(ua.d dVar) {
        Set setF;
        q7.k.e(dVar, "original");
        this.f10987a = dVar;
        this.f10988b = dVar.b() + '?';
        q7.k.e(dVar, "<this>");
        if (dVar instanceof a) {
            setF = ((a) dVar).f();
        } else {
            HashSet hashSet = new HashSet(dVar.c());
            int iC = dVar.c();
            for (int i2 = 0; i2 < iC; i2++) {
                hashSet.add(dVar.d(i2));
            }
            setF = hashSet;
        }
        this.f10989c = setF;
    }

    @Override // ua.d
    public final int a(String str) {
        q7.k.e(str, "name");
        return this.f10987a.a(str);
    }

    @Override // ua.d
    public final String b() {
        return this.f10988b;
    }

    @Override // ua.d
    public final int c() {
        return this.f10987a.c();
    }

    @Override // ua.d
    public final String d(int i2) {
        return this.f10987a.d(i2);
    }

    @Override // ua.d
    public final boolean e() {
        return this.f10987a.e();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            return q7.k.a(this.f10987a, ((k) obj).f10987a);
        }
        return false;
    }

    @Override // wa.a
    public final Set f() {
        return this.f10989c;
    }

    @Override // ua.d
    public final boolean g() {
        return true;
    }

    @Override // ua.d
    public final List getAnnotations() {
        return this.f10987a.getAnnotations();
    }

    @Override // ua.d
    public final o getKind() {
        return this.f10987a.getKind();
    }

    @Override // ua.d
    public final List h(int i2) {
        return this.f10987a.h(i2);
    }

    public final int hashCode() {
        return this.f10987a.hashCode() * 31;
    }

    @Override // ua.d
    public final ua.d i(int i2) {
        return this.f10987a.i(i2);
    }

    @Override // ua.d
    public final boolean j(int i2) {
        return this.f10987a.j(i2);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f10987a);
        sb2.append('?');
        return sb2.toString();
    }
}
