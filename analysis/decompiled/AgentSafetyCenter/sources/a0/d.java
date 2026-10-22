package a0;

import d1.a0;
import d1.b0;
import d1.c0;
import d1.j0;
import h5.t;
import o2.l;
import p5.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements j0 {

    /* renamed from: a, reason: collision with root package name */
    public a f3a;

    /* renamed from: b, reason: collision with root package name */
    public a f4b;

    /* renamed from: c, reason: collision with root package name */
    public a f5c;

    /* renamed from: d, reason: collision with root package name */
    public a f6d;

    public d(a aVar, a aVar2, a aVar3, a aVar4) {
        this.f3a = aVar;
        this.f4b = aVar2;
        this.f5c = aVar3;
        this.f6d = aVar4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [a0.a] */
    /* JADX WARN: Type inference failed for: r3v2, types: [a0.a] */
    public static d b(d dVar, b bVar, b bVar2, b bVar3, int i) {
        b bVar4 = bVar;
        if ((i & 1) != 0) {
            bVar4 = dVar.f3a;
        }
        a aVar = dVar.f4b;
        b bVar5 = bVar2;
        if ((i & 4) != 0) {
            bVar5 = dVar.f5c;
        }
        dVar.getClass();
        return new d(bVar4, aVar, bVar5, bVar3);
    }

    @Override // d1.j0
    public final c0 a(long j10, l lVar, o2.c cVar) {
        float fA = this.f3a.a(j10, cVar);
        float fA2 = this.f4b.a(j10, cVar);
        float fA3 = this.f5c.a(j10, cVar);
        float fA4 = this.f6d.a(j10, cVar);
        float fD = c1.e.d(j10);
        float f5 = fA + fA4;
        if (f5 > fD) {
            float f10 = fD / f5;
            fA *= f10;
            fA4 *= f10;
        }
        float f11 = fA2 + fA3;
        if (f11 > fD) {
            float f12 = fD / f11;
            fA2 *= f12;
            fA3 *= f12;
        }
        if (fA < 0.0f || fA2 < 0.0f || fA3 < 0.0f || fA4 < 0.0f) {
            throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + fA + ", topEnd = " + fA2 + ", bottomEnd = " + fA3 + ", bottomStart = " + fA4 + ")!").toString());
        }
        if (fA + fA2 + fA3 + fA4 == 0.0f) {
            return new a0(f.d(0L, j10));
        }
        c1.c cVarD = f.d(0L, j10);
        l lVar2 = l.f9123c;
        long jD = t.d(lVar == lVar2 ? fA : fA2);
        if (lVar == lVar2) {
            fA = fA2;
        }
        long jD2 = t.d(fA);
        long jD3 = t.d(lVar == lVar2 ? fA3 : fA4);
        if (lVar != lVar2) {
            fA4 = fA3;
        }
        return new b0(new c1.d(cVarD.f2167a, cVarD.f2168b, cVarD.f2169c, cVarD.f2170d, jD, jD2, jD3, t.d(fA4)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.a(this.f3a, dVar.f3a) && k.a(this.f4b, dVar.f4b) && k.a(this.f5c, dVar.f5c) && k.a(this.f6d, dVar.f6d);
    }

    public final int hashCode() {
        return this.f6d.hashCode() + ((this.f5c.hashCode() + ((this.f4b.hashCode() + (this.f3a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "RoundedCornerShape(topStart = " + this.f3a + ", topEnd = " + this.f4b + ", bottomEnd = " + this.f5c + ", bottomStart = " + this.f6d + ')';
    }
}
