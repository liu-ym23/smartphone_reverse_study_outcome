package s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class n0 implements o2.c {

    /* renamed from: c, reason: collision with root package name */
    public boolean f11270c;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(n0 n0Var, o0 o0Var) {
        n0Var.getClass();
        if (o0Var instanceof u1.z0) {
            ((u1.z0) o0Var).y(n0Var.f11270c);
        }
    }

    public static void k(n0 n0Var, o0 o0Var, long j10) {
        n0Var.getClass();
        b(n0Var, o0Var);
        o0Var.R(o2.i.d(j10, o0Var.i), 0.0f, null);
    }

    public static void l(n0 n0Var, o0 o0Var, int i, int i3) {
        long j10 = (i << 32) | (i3 & 4294967295L);
        if (n0Var.d() == o2.l.f9123c || n0Var.f() == 0) {
            b(n0Var, o0Var);
            o0Var.R(o2.i.d(j10, o0Var.i), 0.0f, null);
        } else {
            int iF = (n0Var.f() - o0Var.f11277c) - ((int) (j10 >> 32));
            b(n0Var, o0Var);
            o0Var.R(o2.i.d((iF << 32) | (((int) (j10 & 4294967295L)) & 4294967295L), o0Var.i), 0.0f, null);
        }
    }

    public static void m(n0 n0Var, o0 o0Var, int i, int i3) {
        int i10 = q0.f11291b;
        p0 p0Var = p0.f11287f;
        long j10 = (i << 32) | (i3 & 4294967295L);
        if (n0Var.d() == o2.l.f9123c || n0Var.f() == 0) {
            b(n0Var, o0Var);
            o0Var.R(o2.i.d(j10, o0Var.i), 0.0f, p0Var);
        } else {
            int iF = (n0Var.f() - o0Var.f11277c) - ((int) (j10 >> 32));
            b(n0Var, o0Var);
            o0Var.R(o2.i.d((iF << 32) | (((int) (j10 & 4294967295L)) & 4294967295L), o0Var.i), 0.0f, p0Var);
        }
    }

    public static void o(n0 n0Var, o0 o0Var, int i, int i3, xb.l lVar, int i10) {
        if ((i10 & 8) != 0) {
            int i11 = q0.f11291b;
            lVar = p0.f11287f;
        }
        n0Var.getClass();
        b(n0Var, o0Var);
        o0Var.R(o2.i.d((i3 & 4294967295L) | (i << 32), o0Var.i), 0.0f, lVar);
    }

    public float c(n nVar) {
        return Float.NaN;
    }

    public abstract o2.l d();

    public abstract int f();

    public final void g(o0 o0Var, int i, int i3, float f5) {
        b(this, o0Var);
        o0Var.R(o2.i.d((i3 & 4294967295L) | (i << 32), o0Var.i), f5, null);
    }
}
