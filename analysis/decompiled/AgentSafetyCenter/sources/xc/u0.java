package xc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u0 implements tc.a {

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f15670b;

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ z f15671a;

    static {
        u0 u0Var = new u0();
        z zVar = new z();
        jb.e eVar = jb.e.f6756c;
        androidx.room.c cVar = new androidx.room.c(25);
        VarHandle.storeStoreFence();
        zVar.f15681a = h5.t.G(eVar, cVar);
        VarHandle.storeStoreFence();
        u0Var.f15671a = zVar;
        VarHandle.storeStoreFence();
        f15670b = u0Var;
    }

    @Override // tc.a
    public final vc.e getDescriptor() {
        return this.f15671a.getDescriptor();
    }
}
