package p2;

import o2.h;
import p.q0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f9692a = {8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f};

    /* renamed from: b, reason: collision with root package name */
    public static volatile q0 f9693b = new q0(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object[] f9694c;

    static {
        Object[] objArr = new Object[0];
        f9694c = objArr;
        synchronized (objArr) {
            f9693b.c((int) 115.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, 100.0f}));
            f9693b.c((int) 130.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, 100.0f}));
            f9693b.c((int) 150.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 100.0f}));
            f9693b.c((int) 180.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, 100.0f}));
            f9693b.c((int) 200.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, 100.0f}));
        }
        if ((f9693b.f9614c[0] / 100.0f) - 0.01f > 1.03f) {
            return;
        }
        h.b("You should only apply non-linear scaling to font scales > 1");
    }

    public static a a(float f5) {
        float f10;
        a cVar;
        float[] fArr = f9692a;
        if (f5 < 1.03f) {
            return null;
        }
        int i = (int) (f5 * 100.0f);
        a aVar = (a) f9693b.b(i);
        if (aVar != null) {
            return aVar;
        }
        q0 q0Var = f9693b;
        int iA = q.a.a(q0Var.f9616g, i, q0Var.f9614c);
        if (iA >= 0) {
            return (a) f9693b.d(iA);
        }
        int i3 = -(iA + 1);
        int i10 = i3 - 1;
        if (i3 >= f9693b.f9616g) {
            c cVar2 = new c(new float[]{1.0f}, new float[]{f5});
            b(f5, cVar2);
            return cVar2;
        }
        if (i10 < 0) {
            cVar = new c(fArr, fArr);
            f10 = 1.0f;
        } else {
            f10 = f9693b.f9614c[i10] / 100.0f;
            cVar = (a) f9693b.d(i10);
        }
        float f11 = f9693b.f9614c[i3] / 100.0f;
        float fMax = (Math.max(0.0f, Math.min(1.0f, f10 == f11 ? 0.0f : (f5 - f10) / (f11 - f10))) * 1.0f) + 0.0f;
        a aVar2 = (a) f9693b.d(i3);
        float[] fArr2 = new float[9];
        for (int i11 = 0; i11 < 9; i11++) {
            float f12 = fArr[i11];
            float fB = cVar.b(f12);
            fArr2[i11] = ((aVar2.b(f12) - fB) * fMax) + fB;
        }
        c cVar3 = new c(fArr, fArr2);
        b(f5, cVar3);
        return cVar3;
    }

    public static void b(float f5, c cVar) {
        synchronized (f9694c) {
            q0 q0VarA = f9693b.clone();
            q0VarA.c((int) (f5 * 100.0f), cVar);
            f9693b = q0VarA;
        }
    }
}
