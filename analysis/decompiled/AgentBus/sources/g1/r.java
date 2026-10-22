package g1;

import i1.x0;

/* loaded from: classes.dex */
public abstract class r implements d2.c {

    /* renamed from: f, reason: collision with root package name */
    public boolean f3755f;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(r rVar, s sVar) {
        rVar.getClass();
        if (sVar instanceof x0) {
            ((x0) sVar).i(rVar.f3755f);
        }
    }

    public static void g(r rVar, s sVar, int i2, int i10) {
        rVar.getClass();
        a(rVar, sVar);
        sVar.M(d2.i.c((i10 & 4294967295L) | (i2 << 32), sVar.f3760j), 0.0f, null);
    }

    public static void h(r rVar, s sVar, long j2) {
        rVar.getClass();
        a(rVar, sVar);
        sVar.M(d2.i.c(j2, sVar.f3760j), 0.0f, null);
    }

    public static void i(r rVar, s sVar, int i2, int i10) {
        long j2 = (i2 << 32) | (i10 & 4294967295L);
        if (rVar.e() == d2.l.f2793f || rVar.f() == 0) {
            a(rVar, sVar);
            sVar.M(d2.i.c(j2, sVar.f3760j), 0.0f, null);
        } else {
            int iF = (rVar.f() - sVar.f3756f) - ((int) (j2 >> 32));
            a(rVar, sVar);
            sVar.M(d2.i.c((iF << 32) | (((int) (j2 & 4294967295L)) & 4294967295L), sVar.f3760j), 0.0f, null);
        }
    }

    public static void k(r rVar, s sVar, int i2, int i10) {
        int i11 = u.f3765b;
        t tVar = t.f3761h;
        long j2 = (i2 << 32) | (i10 & 4294967295L);
        if (rVar.e() == d2.l.f2793f || rVar.f() == 0) {
            a(rVar, sVar);
            sVar.M(d2.i.c(j2, sVar.f3760j), 0.0f, tVar);
        } else {
            int iF = (rVar.f() - sVar.f3756f) - ((int) (j2 >> 32));
            a(rVar, sVar);
            sVar.M(d2.i.c((iF << 32) | (((int) (j2 & 4294967295L)) & 4294967295L), sVar.f3760j), 0.0f, tVar);
        }
    }

    public static void l(r rVar, s sVar, p7.k kVar) {
        rVar.getClass();
        long j2 = 0;
        a(rVar, sVar);
        sVar.M(d2.i.c((j2 & 4294967295L) | (j2 << 32), sVar.f3760j), 0.0f, kVar);
    }

    public float b(h hVar) {
        return Float.NaN;
    }

    public abstract d2.l e();

    public abstract int f();
}
