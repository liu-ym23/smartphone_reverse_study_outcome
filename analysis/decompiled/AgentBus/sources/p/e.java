package p;

import android.content.Context;
import b0.c3;
import b0.t1;

/* loaded from: classes.dex */
public final class e extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final e f8078h;

    /* renamed from: i, reason: collision with root package name */
    public static final e f8079i;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f8080g;

    static {
        int i2 = 1;
        f8078h = new e(i2, 0);
        f8079i = new e(i2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i2, int i10) {
        super(i2);
        this.f8080g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f8080g) {
            case 0:
                t1 t1Var = (t1) obj;
                c3 c3Var = j1.q0.f5300b;
                t1Var.getClass();
                if (((Context) b0.b.o(t1Var, c3Var)).getPackageManager().hasSystemFeature("android.software.leanback")) {
                    return g.f8100b;
                }
                d.f8072a.getClass();
                return c.f8064c;
            default:
                return Boolean.valueOf(!(((c1.l) obj).f1812i == 2));
        }
    }
}
