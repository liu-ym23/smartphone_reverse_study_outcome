package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__ReduceKt$fold$2 implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f21466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f21467b;

    public FlowKt__ReduceKt$fold$2(Ref$ObjectRef r10, Function3 r11) {
        this.f21466a = r10;
        this.f21467b = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r10, Continuation r11) {
        if ((r11 instanceof FlowKt__ReduceKt$fold$2$emit$1) == false) goto L7;
        FlowKt__ReduceKt$fold$2$emit$1 r12 = (FlowKt__ReduceKt$fold$2$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Ref$ObjectRef r17 = (Ref$ObjectRef) r12.L$0;
        kotlin.c.b(r14);
        T r18 = r14;
    L18:
        r17.element = r18;
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        Ref$ObjectRef r19 = this.f21466a;
        Function3 r20 = this.f21467b;
        T r21 = r19.element;
        r12.L$0 = r19;
        r12.label = 1;
        Object r22 = r20.invoke(r21, r10, r12);
        if (r22 != r15) goto L17;
        return r15;
    L17:
        r18 = r22;
        r17 = r19;
    L7:
        r12 = new FlowKt__ReduceKt$fold$2$emit$1(this, r11);
        goto L8
    }
}
