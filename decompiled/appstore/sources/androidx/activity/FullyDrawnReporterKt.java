package androidx.activity;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class FullyDrawnReporterKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    public static final Object a(FullyDrawnReporter r10, Function1 r11, Continuation r12) {
        if ((r12 instanceof FullyDrawnReporterKt$reportWhenComplete$1) == false) goto L7;
        FullyDrawnReporterKt$reportWhenComplete$1 r13 = (FullyDrawnReporterKt$reportWhenComplete$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        FullyDrawnReporter r18 = (FullyDrawnReporter) r13.L$0;
        kotlin.c.b(r15);     // Catch: Throwable -> L14
        FullyDrawnReporter r19 = r18;
    L25:
        kotlin.jvm.internal.p.b(1);
        r19.f();
        kotlin.jvm.internal.p.a(1);
        r10 = Unit.f21064a;
        return r10;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        r10.b();
        if (r10.d() == true) goto L21;
        r13.L$0 = r10;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        r19 = r10;
        if (r11.invoke(r13) != r16) goto L25;
        return r16;
    L21:
        return Unit.f21064a;
    L14:
        th = move-exception;
        kotlin.jvm.internal.p.b(1);
        r10.f();
        kotlin.jvm.internal.p.a(1);
        throw th;
    L7:
        r13 = new FullyDrawnReporterKt$reportWhenComplete$1(r12);
        goto L8
    }
}
