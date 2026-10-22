package Z2;

import kotlin.coroutines.Continuation;

/* loaded from: classes2.dex */
public final class t0 extends C0128h {

    /* renamed from: i, reason: collision with root package name */
    public final x0 f2243i;

    public t0(Continuation continuation, C0141o c0141o) {
        super(1, continuation);
        this.f2243i = c0141o;
    }

    @Override // Z2.C0128h
    public final Throwable s(x0 x0Var) {
        Throwable thD;
        Object objG = this.f2243i.G();
        return (!(objG instanceof v0) || (thD = ((v0) objG).d()) == null) ? objG instanceof r ? ((r) objG).f2238a : x0Var.C() : thD;
    }

    @Override // Z2.C0128h
    public final String z() {
        return "AwaitContinuation";
    }
}
