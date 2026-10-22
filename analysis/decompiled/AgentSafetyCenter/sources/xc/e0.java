package xc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e0 implements tc.a {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f15625a;

    public e0(tc.a aVar) {
        aVar.getClass();
        vc.e descriptor = aVar.getDescriptor();
        descriptor.getClass();
        d0 d0Var = new d0(descriptor);
        d0Var.f15622b = descriptor.a() + "Array";
        VarHandle.storeStoreFence();
        this.f15625a = d0Var;
    }

    @Override // tc.a
    public final vc.e getDescriptor() {
        return this.f15625a;
    }
}
