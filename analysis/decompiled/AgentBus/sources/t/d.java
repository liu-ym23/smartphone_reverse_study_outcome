package t;

import d2.l;
import n7.m;
import nb.i;
import q7.k;
import u0.c0;
import u0.u;
import u0.v;
import u0.w;

/* loaded from: classes.dex */
public final class d implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f9645a;

    /* renamed from: b, reason: collision with root package name */
    public final a f9646b;

    /* renamed from: c, reason: collision with root package name */
    public final a f9647c;

    /* renamed from: d, reason: collision with root package name */
    public final a f9648d;

    public d(a aVar, a aVar2, a aVar3, a aVar4) {
        this.f9645a = aVar;
        this.f9646b = aVar2;
        this.f9647c = aVar3;
        this.f9648d = aVar4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [t.a] */
    /* JADX WARN: Type inference failed for: r3v2, types: [t.a] */
    public static d b(d dVar, b bVar, b bVar2, b bVar3, int i2) {
        b bVar4 = bVar;
        if ((i2 & 1) != 0) {
            bVar4 = dVar.f9645a;
        }
        a aVar = dVar.f9646b;
        b bVar5 = bVar2;
        if ((i2 & 4) != 0) {
            bVar5 = dVar.f9647c;
        }
        dVar.getClass();
        return new d(bVar4, aVar, bVar5, bVar3);
    }

    @Override // u0.c0
    public final w a(long j2, l lVar, d2.c cVar) {
        float fA = this.f9645a.a(j2, cVar);
        float fA2 = this.f9646b.a(j2, cVar);
        float fA3 = this.f9647c.a(j2, cVar);
        float fA4 = this.f9648d.a(j2, cVar);
        float fC = t0.e.c(j2);
        float f10 = fA + fA4;
        if (f10 > fC) {
            float f11 = fC / f10;
            fA *= f11;
            fA4 *= f11;
        }
        float f12 = fA2 + fA3;
        if (f12 > fC) {
            float f13 = fC / f12;
            fA2 *= f13;
            fA3 *= f13;
        }
        if (fA < 0.0f || fA2 < 0.0f || fA3 < 0.0f || fA4 < 0.0f) {
            throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + fA + ", topEnd = " + fA2 + ", bottomEnd = " + fA3 + ", bottomStart = " + fA4 + ")!").toString());
        }
        if (fA + fA2 + fA3 + fA4 == 0.0f) {
            return new u(m.a(0L, j2));
        }
        t0.c cVarA = m.a(0L, j2);
        l lVar2 = l.f2793f;
        long jB = i.b(lVar == lVar2 ? fA : fA2);
        if (lVar == lVar2) {
            fA = fA2;
        }
        long jB2 = i.b(fA);
        long jB3 = i.b(lVar == lVar2 ? fA3 : fA4);
        if (lVar != lVar2) {
            fA4 = fA3;
        }
        return new v(new t0.d(cVarA.f9656a, cVarA.f9657b, cVarA.f9658c, cVarA.f9659d, jB, jB2, jB3, i.b(fA4)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.a(this.f9645a, dVar.f9645a) && k.a(this.f9646b, dVar.f9646b) && k.a(this.f9647c, dVar.f9647c) && k.a(this.f9648d, dVar.f9648d);
    }

    public final int hashCode() {
        return this.f9648d.hashCode() + ((this.f9647c.hashCode() + ((this.f9646b.hashCode() + (this.f9645a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "RoundedCornerShape(topStart = " + this.f9645a + ", topEnd = " + this.f9646b + ", bottomEnd = " + this.f9647c + ", bottomStart = " + this.f9648d + ')';
    }
}
