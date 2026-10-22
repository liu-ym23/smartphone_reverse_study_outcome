package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public final class t1 extends k1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Continuation f21757e;

    public t1(Continuation r10) {
        this.f21757e = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        o((Throwable) r10);
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.y
    public void o(Throwable r10) {
        Continuation r11 = this.f21757e;
        Result.a r12 = Result.Companion;
        r11.resumeWith(Result.m35constructorimpl(Unit.f21064a));
    }
}
