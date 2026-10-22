package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__LimitKt {

    public static final class a implements Flow {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f21447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f21448b;

        public a(Flow r10, Function2 r11) {
            this.f21447a = r10;
            this.f21448b = r11;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector r10, Continuation r11) {
            Ref$BooleanRef r12 = new Ref$BooleanRef();
            Object r13 = this.f21447a.collect(new FlowKt__LimitKt$dropWhile$1$1(r12, r10, this.f21448b), r11);
            if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
            return r13;
        L6:
            return Unit.f21064a;
        }
    }

    public static final /* synthetic */ Object a(FlowCollector r10, Object r11, Continuation r12) {
        return d(r10, r11, r12);
    }

    public static final Object b(Flow r10, Function2 r11, Continuation r12) {
        if ((r12 instanceof FlowKt__LimitKt$collectWhile$1) == false) goto L7;
        FlowKt__LimitKt$collectWhile$1 r13 = (FlowKt__LimitKt$collectWhile$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        FlowKt__LimitKt$collectWhile$collector$1 r18 = (FlowKt__LimitKt$collectWhile$collector$1) r13.L$0;
        kotlin.c.b(r15);     // Catch: AbortFlowException -> L14
    L26:
        return Unit.f21064a;
    L14:
        e = e;
    L24:
        kotlinx.coroutines.flow.internal.j.a(e, r18);
        goto L26
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        FlowKt__LimitKt$collectWhile$collector$1 r19 = new FlowKt__LimitKt$collectWhile$collector$1(r11);
        r13.L$0 = r19;     // Catch: AbortFlowException -> L22
        r13.label = 1;     // Catch: AbortFlowException -> L22
        if (r10.collect(r19, r13) != r16) goto L26;
        return r16;
    L22:
        e = e;
        r18 = r19;
    L7:
        r13 = new FlowKt__LimitKt$collectWhile$1(r12);
        goto L8
    }

    public static final Flow c(Flow r10, Function2 r11) {
        return new a(r10, r11);
    }

    public static final Object d(FlowCollector r10, Object r11, Continuation r12) {
        if ((r12 instanceof FlowKt__LimitKt$emitAbort$1) == false) goto L7;
        FlowKt__LimitKt$emitAbort$1 r13 = (FlowKt__LimitKt$emitAbort$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L12;
        r10 = (FlowCollector) r13.L$0;
        kotlin.c.b(r15);
    L18:
        throw new AbortFlowException(r10);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r15);
        r13.L$0 = r10;
        r13.label = 1;
        if (r10.emit(r11, r13) != r16) goto L18;
        return r16;
    L7:
        r13 = new FlowKt__LimitKt$emitAbort$1(r12);
        goto L8
    }
}
