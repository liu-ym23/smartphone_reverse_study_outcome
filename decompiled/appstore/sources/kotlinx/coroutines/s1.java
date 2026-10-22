package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class s1 extends k1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f21674e;

    public s1(n r10) {
        this.f21674e = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        o((Throwable) r10);
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.y
    public void o(Throwable r10) {
        Object r11 = p().E();
        if ((r11 instanceof w) == false) goto L5;
        n r12 = this.f21674e;
        Result.a r13 = Result.Companion;
        r12.resumeWith(Result.m35constructorimpl(kotlin.c.a(((w) r11).f21768a)));
        return;
    L5:
        n r14 = this.f21674e;
        Result.a r15 = Result.Companion;
        r14.resumeWith(Result.m35constructorimpl(l1.h(r11)));
    }
}
