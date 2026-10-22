package c9;

import f9.o;
import f9.v;

/* loaded from: classes.dex */
public final class b extends f9.j implements v {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2088g;

    /* renamed from: h, reason: collision with root package name */
    public int f2089h;

    /* renamed from: i, reason: collision with root package name */
    public int f2090i;

    /* renamed from: j, reason: collision with root package name */
    public int f2091j;

    public /* synthetic */ b(int i2) {
        this.f2088g = i2;
    }

    @Override // f9.j
    public final f9.a a() {
        switch (this.f2088g) {
            case 0:
                c cVarD = d();
                cVarD.isInitialized();
                return cVarD;
            default:
                d dVarE = e();
                dVarE.isInitialized();
                return dVarE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003f  */
    @Override // f9.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.j b(f9.e r2, f9.h r3) throws java.lang.Throwable {
        /*
            r1 = this;
            int r3 = r1.f2088g
            switch(r3) {
                case 0: goto L24;
                default: goto L5;
            }
        L5:
            r3 = 0
            c9.a r0 = c9.d.f2101m     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            r0.getClass()     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            c9.d r0 = new c9.d     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L14 f9.r -> L16
            r1.g(r0)
            return r1
        L14:
            r2 = move-exception
            goto L1e
        L16:
            r2 = move-exception
            f9.a r0 = r2.f3597f     // Catch: java.lang.Throwable -> L14
            c9.d r0 = (c9.d) r0     // Catch: java.lang.Throwable -> L14
            throw r2     // Catch: java.lang.Throwable -> L1c
        L1c:
            r2 = move-exception
            r3 = r0
        L1e:
            if (r3 == 0) goto L23
            r1.g(r3)
        L23:
            throw r2
        L24:
            r3 = 0
            c9.a r0 = c9.c.f2093m     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            r0.getClass()     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            c9.c r0 = new c9.c     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L33 f9.r -> L35
            r1.f(r0)
            return r1
        L33:
            r2 = move-exception
            goto L3d
        L35:
            r2 = move-exception
            f9.a r0 = r2.f3597f     // Catch: java.lang.Throwable -> L33
            c9.c r0 = (c9.c) r0     // Catch: java.lang.Throwable -> L33
            throw r2     // Catch: java.lang.Throwable -> L3b
        L3b:
            r2 = move-exception
            r3 = r0
        L3d:
            if (r3 == 0) goto L42
            r1.f(r3)
        L42:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c9.b.b(f9.e, f9.h):f9.j");
    }

    @Override // f9.j
    public final /* bridge */ /* synthetic */ f9.j c(o oVar) {
        switch (this.f2088g) {
            case 0:
                f((c) oVar);
                break;
            default:
                g((d) oVar);
                break;
        }
        return this;
    }

    public final Object clone() {
        switch (this.f2088g) {
            case 0:
                b bVar = new b(0);
                bVar.f(d());
                return bVar;
            default:
                b bVar2 = new b(1);
                bVar2.g(e());
                return bVar2;
        }
    }

    public c d() {
        c cVar = new c(this);
        int i2 = this.f2089h;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        cVar.f2096h = this.f2090i;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        cVar.f2097i = this.f2091j;
        cVar.f2095g = i10;
        return cVar;
    }

    public d e() {
        d dVar = new d(this);
        int i2 = this.f2089h;
        int i10 = (i2 & 1) != 1 ? 0 : 1;
        dVar.f2104h = this.f2090i;
        if ((i2 & 2) == 2) {
            i10 |= 2;
        }
        dVar.f2105i = this.f2091j;
        dVar.f2103g = i10;
        return dVar;
    }

    public void f(c cVar) {
        if (cVar == c.f2092l) {
            return;
        }
        int i2 = cVar.f2095g;
        if ((i2 & 1) == 1) {
            int i10 = cVar.f2096h;
            this.f2089h = 1 | this.f2089h;
            this.f2090i = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = cVar.f2097i;
            this.f2089h = 2 | this.f2089h;
            this.f2091j = i11;
        }
        this.f3565f = this.f3565f.f(cVar.f2094f);
    }

    public void g(d dVar) {
        if (dVar == d.f2100l) {
            return;
        }
        int i2 = dVar.f2103g;
        if ((i2 & 1) == 1) {
            int i10 = dVar.f2104h;
            this.f2089h = 1 | this.f2089h;
            this.f2090i = i10;
        }
        if ((i2 & 2) == 2) {
            int i11 = dVar.f2105i;
            this.f2089h = 2 | this.f2089h;
            this.f2091j = i11;
        }
        this.f3565f = this.f3565f.f(dVar.f2102f);
    }
}
