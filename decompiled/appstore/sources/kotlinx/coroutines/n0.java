package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisposableHandle f21652a;

    public n0(DisposableHandle r10) {
        this.f21652a = r10;
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable r10) {
        this.f21652a.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        a((Throwable) r10);
        return Unit.f21064a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f21652a + ']';
    }
}
