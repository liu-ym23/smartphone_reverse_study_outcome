package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__CountKt$count$4 implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f21435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f21436b;

    public FlowKt__CountKt$count$4(Function2 r10, Ref$IntRef r11) {
        this.f21435a = r10;
        this.f21436b = r11;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r10, Continuation r11) {
        if ((r11 instanceof FlowKt__CountKt$count$4$emit$1) == false) goto L7;
        FlowKt__CountKt$count$4$emit$1 r12 = (FlowKt__CountKt$count$4$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        FlowKt__CountKt$count$4 this = (FlowKt__CountKt$count$4) r12.L$0;
        kotlin.c.b(r14);
    L18:
        if (((Boolean) r14).booleanValue() == false) goto L21;
        this.f21436b.element++;
    L21:
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        Function2 r17 = this.f21435a;
        r12.L$0 = this;
        r12.label = 1;
        r14 = r17.mo0invoke(r10, r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new FlowKt__CountKt$count$4$emit$1(this, r11);
        goto L8
    }
}
