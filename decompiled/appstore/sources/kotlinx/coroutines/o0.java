package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class o0 extends k1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DisposableHandle f21655e;

    public o0(DisposableHandle r10) {
        this.f21655e = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        o((Throwable) r10);
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.y
    public void o(Throwable r10) {
        this.f21655e.dispose();
    }
}
