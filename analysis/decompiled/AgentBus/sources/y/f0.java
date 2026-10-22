package y;

import b0.c3;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final c3 f11391a = new c3(j.f11463o);

    public static final u0.c0 a(int i2, b0.p pVar) {
        e0 e0Var = (e0) pVar.j(f11391a);
        switch (n.f.d(i2)) {
            case 0:
                return e0Var.f11386e;
            case 1:
                return b(e0Var.f11386e);
            case 2:
                return e0Var.f11382a;
            case 3:
                return b(e0Var.f11382a);
            case 4:
                return t.e.f9649a;
            case 5:
                return e0Var.f11385d;
            case 6:
                t.d dVar = e0Var.f11385d;
                float f10 = (float) 0.0d;
                return t.d.b(dVar, new t.b(f10), null, new t.b(f10), 6);
            case 7:
                return b(e0Var.f11385d);
            case 8:
                return e0Var.f11384c;
            case 9:
                return u0.z.f9929a;
            case 10:
                return e0Var.f11383b;
            default:
                throw new a4.u();
        }
    }

    public static final t.d b(t.d dVar) {
        float f10 = (float) 0.0d;
        return t.d.b(dVar, null, new t.b(f10), new t.b(f10), 3);
    }
}
