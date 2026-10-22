package b0;

/* loaded from: classes.dex */
public final class f implements c1 {

    /* renamed from: f, reason: collision with root package name */
    public final a2 f1139f;

    /* renamed from: h, reason: collision with root package name */
    public Throwable f1141h;

    /* renamed from: g, reason: collision with root package name */
    public final Object f1140g = new Object();

    /* renamed from: i, reason: collision with root package name */
    public final j0.a f1142i = new j0.a(0);

    /* renamed from: j, reason: collision with root package name */
    public k.z f1143j = new k.z();

    /* renamed from: k, reason: collision with root package name */
    public k.z f1144k = new k.z();

    public f(a2 a2Var) {
        this.f1139f = a2Var;
    }

    @Override // b0.c1
    public final Object K(p7.k kVar, i7.c cVar) {
        int i2;
        int i10;
        int i11;
        ia.m mVar = new ia.m(1, ib.k.C(cVar));
        mVar.s();
        d dVar = new d();
        dVar.f1120a = kVar;
        dVar.f1121b = mVar;
        q7.t tVar = new q7.t();
        tVar.f8818f = -1;
        synchronized (this.f1140g) {
            Throwable th = this.f1141h;
            if (th != null) {
                mVar.resumeWith(w7.e0.n(th));
            } else {
                j0.a aVar = this.f1142i;
                do {
                    i2 = aVar.get();
                    i10 = i2 + 1;
                } while (!aVar.compareAndSet(i2, i10));
                boolean z4 = (134217727 & i10) == 1;
                tVar.f8818f = (i10 >>> 27) & 15;
                this.f1143j.a(dVar);
                mVar.u(new e(dVar, this, tVar, 0));
                if (z4) {
                    try {
                        this.f1139f.c();
                    } catch (Throwable th2) {
                        synchronized (this.f1140g) {
                            try {
                                if (this.f1141h == null) {
                                    this.f1141h = th2;
                                    k.z zVar = this.f1143j;
                                    Object[] objArr = zVar.f5556a;
                                    int i12 = zVar.f5557b;
                                    for (int i13 = 0; i13 < i12; i13++) {
                                        ia.m mVar2 = ((d) objArr[i13]).f1121b;
                                        if (mVar2 != null) {
                                            mVar2.resumeWith(w7.e0.n(th2));
                                        }
                                    }
                                    this.f1143j.c();
                                    j0.a aVar2 = this.f1142i;
                                    do {
                                        i11 = aVar2.get();
                                    } while (!aVar2.compareAndSet(i11, ((((i11 >>> 27) & 15) + 1) & 15) << 27));
                                }
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                }
            }
        }
        Object objR = mVar.r();
        h7.a aVar3 = h7.a.f4212f;
        return objR;
    }

    @Override // g7.l
    public final g7.l Q(g7.l lVar) {
        return a1.plus(this, lVar);
    }

    public final void c(long j2) {
        int i2;
        ia.m mVar;
        Object objN;
        synchronized (this.f1140g) {
            try {
                k.z zVar = this.f1143j;
                this.f1143j = this.f1144k;
                this.f1144k = zVar;
                j0.a aVar = this.f1142i;
                do {
                    i2 = aVar.get();
                } while (!aVar.compareAndSet(i2, ((((i2 >>> 27) & 15) + 1) & 15) << 27));
                int i10 = zVar.f5557b;
                for (int i11 = 0; i11 < i10; i11++) {
                    d dVar = (d) zVar.e(i11);
                    p7.k kVar = dVar.f1120a;
                    if (kVar != null && (mVar = dVar.f1121b) != null) {
                        try {
                            objN = kVar.invoke(Long.valueOf(j2));
                        } catch (Throwable th) {
                            objN = w7.e0.n(th);
                        }
                        mVar.resumeWith(objN);
                    }
                }
                zVar.c();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // g7.l
    public final g7.j o(g7.k kVar) {
        return a1.get(this, kVar);
    }

    @Override // g7.l
    public final Object r(Object obj, p7.n nVar) {
        return a1.fold(this, obj, nVar);
    }

    @Override // g7.l
    public final g7.l z(g7.k kVar) {
        return a1.minusKey(this, kVar);
    }
}
