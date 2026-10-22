package Z2;

import kotlin.Unit;

/* renamed from: Z2.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0136l extends q0 implements InterfaceC0134k {

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0138m f2227e;

    public C0136l(x0 x0Var) {
        this.f2227e = x0Var;
    }

    @Override // Z2.InterfaceC0134k
    public final boolean b(Throwable th) {
        return i().y(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        j((Throwable) obj);
        return Unit.INSTANCE;
    }

    @Override // Z2.s0
    public final void j(Throwable th) {
        ((x0) this.f2227e).u(i());
    }
}
