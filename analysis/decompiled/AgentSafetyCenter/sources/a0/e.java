package a0;

import g5.f;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final d f7a;

    static {
        float f5 = 50;
        c cVar = new c();
        cVar.f2a = f5;
        if (f5 < 0.0f || f5 > 100.0f) {
            f.s("The percent should be in the range of [0, 100]");
        } else {
            VarHandle.storeStoreFence();
            f7a = new d(cVar, cVar, cVar, cVar);
        }
    }

    public static final d a(float f5) {
        b bVarC = a.a.c(f5);
        return new d(bVarC, bVarC, bVarC, bVarC);
    }

    public static final d b(float f5, float f10, float f11, float f12) {
        return new d(a.a.c(f5), a.a.c(f10), a.a.c(f11), a.a.c(f12));
    }

    public static d c(float f5, float f10, float f11, int i) {
        if ((i & 1) != 0) {
            f5 = 0;
        }
        if ((i & 4) != 0) {
            f11 = 0;
        }
        return b(f5, f10, f11, 0);
    }
}
