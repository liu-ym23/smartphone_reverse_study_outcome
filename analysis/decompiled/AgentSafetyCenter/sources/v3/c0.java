package v3;

import h0.n1;
import java.io.File;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f14612c = new c0(1);

    @Override // xb.l
    public final Object invoke(Object obj) {
        File file = (File) obj;
        file.getClass();
        file.getCanonicalFile().getAbsolutePath().getClass();
        p0 p0Var = new p0();
        p0Var.f14701a = new sc.c();
        p0Var.f14702b = new sa.c(9);
        p0Var.f14703c = nc.k0.k(new n1(2, null, 7));
        VarHandle.storeStoreFence();
        return p0Var;
    }
}
