package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__EmittersKt {
    public static final /* synthetic */ Object a(FlowCollector r10, Function3 r11, Throwable r12, Continuation r13) {
        return c(r10, r11, r12, r13);
    }

    public static final void b(FlowCollector r10) {
    }

    public static final Object c(FlowCollector r10, Function3 r11, Throwable r12, Continuation r13) {
        if ((r13 instanceof FlowKt__EmittersKt$invokeSafely$1) == false) goto L7;
        FlowKt__EmittersKt$invokeSafely$1 r14 = (FlowKt__EmittersKt$invokeSafely$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r14.label;
        if (r18 == 0) goto L18;
        if (r18 != 1) goto L17;
        r12 = (Throwable) r14.L$0;
        kotlin.c.b(r16);     // Catch: Throwable -> L14
    L22:
        return Unit.f21064a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r16);
        r14.L$0 = r12;     // Catch: Throwable -> L14
        r14.label = 1;     // Catch: Throwable -> L14
        if (r11.invoke(r10, r12, r14) != r17) goto L22;
        return r17;
    L14:
        th = move-exception;
        if (r12 == null) goto L27;
        if (r12 == th) goto L27;
        kotlin.a.a(th, r12);
    L27:
        throw th;
    L7:
        r14 = new FlowKt__EmittersKt$invokeSafely$1(r13);
        goto L8
    }

    public static final Flow d(Flow r10, Function2 r11) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(r11, r10);
    }
}
