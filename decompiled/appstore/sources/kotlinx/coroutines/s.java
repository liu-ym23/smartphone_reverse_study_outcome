package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class s extends f1 implements ChildHandle {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ChildJob f21673e;

    public s(ChildJob r10) {
        this.f21673e = r10;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean childCancelled(Throwable r10) {
        return p().q(r10);
    }

    @Override // kotlinx.coroutines.ChildHandle
    public Job getParent() {
        return p();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        o((Throwable) r10);
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.y
    public void o(Throwable r10) {
        this.f21673e.parentCancelled(p());
    }
}
