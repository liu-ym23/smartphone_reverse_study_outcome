package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class e1 extends k1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1 f21418e;

    public e1(Function1 r10) {
        this.f21418e = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        o((Throwable) r10);
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.y
    public void o(Throwable r10) {
        this.f21418e.invoke(r10);
    }
}
