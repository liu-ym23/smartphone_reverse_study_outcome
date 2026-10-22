package j8;

import e7.g;
import f8.a1;
import f8.d1;
import f8.e1;
import f8.y0;
import f8.z0;
import q7.k;

/* loaded from: classes.dex */
public final class a extends e1 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f5401c = new a("package", false);

    @Override // f8.e1
    public final Integer a(e1 e1Var) {
        k.e(e1Var, "visibility");
        if (this == e1Var) {
            return 0;
        }
        g gVar = d1.f3474a;
        return (e1Var == y0.f3522c || e1Var == z0.f3523c) ? 1 : -1;
    }

    @Override // f8.e1
    public final String b() {
        return "public/*package*/";
    }

    @Override // f8.e1
    public final e1 c() {
        return a1.f3461c;
    }
}
