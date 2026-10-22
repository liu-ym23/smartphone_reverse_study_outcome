package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__LimitKt$dropWhile$1$1 implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f21450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f21451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f21452c;

    public FlowKt__LimitKt$dropWhile$1$1(Ref$BooleanRef r10, FlowCollector r11, Function2 r12) {
        this.f21450a = r10;
        this.f21451b = r11;
        this.f21452c = r12;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r10, Continuation r11) {
        if ((r11 instanceof FlowKt__LimitKt$dropWhile$1$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$dropWhile$1$1$emit$1 r12 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 == 1) goto L17;
        if (r16 == 2) goto L16;
        if (r16 != 3) goto L15;
        kotlin.c.b(r14);
    L34:
        return Unit.f21064a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r10 = r12.L$1;
        FlowKt__LimitKt$dropWhile$1$1 this = (FlowKt__LimitKt$dropWhile$1$1) r12.L$0;
        kotlin.c.b(r14);
    L29:
        if (((Boolean) r14).booleanValue() == true) goto L36;
        this.f21450a.element = true;
        FlowCollector r17 = this.f21451b;
        r12.L$0 = null;
        r12.L$1 = null;
        r12.label = 3;
        if (r17.emit(r10, r12) != r15) goto L34;
        return r15;
    L36:
        return Unit.f21064a;
    L17:
        kotlin.c.b(r14);
    L24:
        return Unit.f21064a;
    L18:
        kotlin.c.b(r14);
        if (this.f21450a.element == false) goto L25;
        FlowCollector r18 = this.f21451b;
        r12.label = 1;
        if (r18.emit(r10, r12) != r15) goto L24;
        return r15;
    L25:
        Function2 r19 = this.f21452c;
        r12.L$0 = this;
        r12.L$1 = r10;
        r12.label = 2;
        r14 = r19.mo0invoke(r10, r12);
        if (r14 != r15) goto L29;
        return r15;
    L7:
        r12 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, r11);
        goto L8
    }
}
