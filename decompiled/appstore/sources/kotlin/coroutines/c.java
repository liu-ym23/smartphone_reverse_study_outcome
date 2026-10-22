package kotlin.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final void a(Function1 r10, Continuation r11) {
        q.g(r10, "<this>");
        q.g(r11, "completion");
        Continuation r12 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(r10, r11));
        Result.a r13 = Result.Companion;
        r12.resumeWith(Result.m35constructorimpl(Unit.f21064a));
    }

    public static final void b(Function2 r10, Object r11, Continuation r12) {
        q.g(r10, "<this>");
        q.g(r12, "completion");
        Continuation r13 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(r10, r11, r12));
        Result.a r14 = Result.Companion;
        r13.resumeWith(Result.m35constructorimpl(Unit.f21064a));
    }
}
