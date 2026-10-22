package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class r extends f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f21662e;

    public r(n r10) {
        this.f21662e = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        o((Throwable) r10);
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.y
    public void o(Throwable r10) {
        n r11 = this.f21662e;
        r11.z(r11.o(p()));
    }
}
