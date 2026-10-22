package v0;

import k.t;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final t f10304a;

    static {
        q qVar = d.f10276e;
        int i2 = qVar.f10271c;
        e eVar = new e(qVar, qVar, 1);
        int i10 = qVar.f10271c;
        l lVar = d.f10295x;
        int i11 = (lVar.f10271c << 6) | i10;
        g gVar = new g(qVar, lVar, 0);
        int i12 = (i10 << 6) | lVar.f10271c;
        g gVar2 = new g(lVar, qVar, 0);
        t tVar = k.k.f5504a;
        t tVar2 = new t();
        tVar2.g(i2 | (i2 << 6), eVar);
        tVar2.g(i11, gVar);
        tVar2.g(i12, gVar2);
        f10304a = tVar2;
    }
}
