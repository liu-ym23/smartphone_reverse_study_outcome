package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__ReduceKt {

    public static final class a implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f21456a;

        public a(Ref$ObjectRef r10) {
            this.f21456a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(Object r10, Continuation r11) {
            this.f21456a.element = r10;
            throw new AbortFlowException(this);
        }
    }

    public static final class b implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f21457a;

        public b(Ref$ObjectRef r10) {
            this.f21457a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(Object r10, Continuation r11) {
            this.f21457a.element = r10;
            throw new AbortFlowException(this);
        }
    }

    public static final class c implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f21458a;

        public c(Ref$ObjectRef r10) {
            this.f21458a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r10, Continuation r11) {
            this.f21458a.element = r10;
            return Unit.f21064a;
        }
    }

    public static final class d implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f21459a;

        public d(Ref$ObjectRef r10) {
            this.f21459a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r10, Continuation r11) {
            this.f21459a.element = r10;
            return Unit.f21064a;
        }
    }

    public static final class e implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f21460a;

        public e(Ref$ObjectRef r10) {
            this.f21460a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r10, Continuation r11) {
            Ref$ObjectRef r12 = this.f21460a;
            if (r12.element != kotlinx.coroutines.flow.internal.m.f21551a) goto L7;
            r12.element = r10;
            return Unit.f21064a;
        L7:
            throw new IllegalArgumentException("Flow has more than one element");
        }
    }

    public static final class f implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f21461a;

        public f(Ref$ObjectRef r10) {
            this.f21461a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, kotlinx.coroutines.internal.b0] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(Object r10, Continuation r11) {
            Ref$ObjectRef r12 = this.f21461a;
            T r13 = r12.element;
            ?? r14 = kotlinx.coroutines.flow.internal.m.f21551a;
            if (r13 != r14) goto L6;
            r12.element = r10;
            return Unit.f21064a;
        L6:
            r12.element = r14;
            throw new AbortFlowException(this);
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.b0] */
    public static final Object a(Flow r10, Continuation r11) {
        if ((r11 instanceof FlowKt__ReduceKt$first$1) == false) goto L7;
        FlowKt__ReduceKt$first$1 r12 = (FlowKt__ReduceKt$first$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        a r17 = (a) r12.L$1;
        Ref$ObjectRef r18 = (Ref$ObjectRef) r12.L$0;
        kotlin.c.b(r14);     // Catch: AbortFlowException -> L14
    L26:
        T r19 = r18.element;
        if (r19 == kotlinx.coroutines.flow.internal.m.f21551a) goto L30;
        return r19;
    L30:
        throw new NoSuchElementException("Expected at least one element");
    L14:
        AbortFlowException e10 = e;
    L25:
        kotlinx.coroutines.flow.internal.j.a(e10, r17);
        goto L26
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        Ref$ObjectRef r20 = new Ref$ObjectRef();
        r20.element = kotlinx.coroutines.flow.internal.m.f21551a;
        a r21 = new a(r20);
        r12.L$0 = r20;     // Catch: AbortFlowException -> L23
        r12.L$1 = r21;     // Catch: AbortFlowException -> L23
        r12.label = 1;     // Catch: AbortFlowException -> L23
        if (r10.collect(r21, r12) != r15) goto L22;
        return r15;
    L22:
        r18 = r20;
    L23:
        e = move-exception;
        r18 = r20;
        e10 = e;
        r17 = r21;
    L7:
        r12 = new FlowKt__ReduceKt$first$1(r11);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.b0] */
    public static final Object b(Flow r10, Function2 r11, Continuation r12) {
        if ((r12 instanceof FlowKt__ReduceKt$first$3) == false) goto L7;
        FlowKt__ReduceKt$first$3 r13 = (FlowKt__ReduceKt$first$3) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 r18 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) r13.L$2;
        Ref$ObjectRef r19 = (Ref$ObjectRef) r13.L$1;
        Function2 r20 = (Function2) r13.L$0;
        kotlin.c.b(r15);     // Catch: AbortFlowException -> L14
    L26:
        T r21 = r19.element;
        if (r21 == kotlinx.coroutines.flow.internal.m.f21551a) goto L30;
        return r21;
    L30:
        throw new NoSuchElementException("Expected at least one element matching the predicate " + r20);
    L14:
        AbortFlowException e10 = e;
    L25:
        kotlinx.coroutines.flow.internal.j.a(e10, r18);
        goto L26
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        Ref$ObjectRef r22 = new Ref$ObjectRef();
        r22.element = kotlinx.coroutines.flow.internal.m.f21551a;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 r23 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(r11, r22);
        r13.L$0 = r11;     // Catch: AbortFlowException -> L23
        r13.L$1 = r22;     // Catch: AbortFlowException -> L23
        r13.L$2 = r23;     // Catch: AbortFlowException -> L23
        r13.label = 1;     // Catch: AbortFlowException -> L23
        if (r10.collect(r23, r13) != r16) goto L22;
        return r16;
    L22:
        r20 = r11;
        r19 = r22;
    L23:
        e = move-exception;
        r20 = r11;
        r19 = r22;
        e10 = e;
        r18 = r23;
    L7:
        r13 = new FlowKt__ReduceKt$first$3(r12);
        goto L8
    }

    public static final Object c(Flow r10, Continuation r11) {
        if ((r11 instanceof FlowKt__ReduceKt$firstOrNull$1) == false) goto L7;
        FlowKt__ReduceKt$firstOrNull$1 r12 = (FlowKt__ReduceKt$firstOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        b r17 = (b) r12.L$1;
        Ref$ObjectRef r18 = (Ref$ObjectRef) r12.L$0;
        kotlin.c.b(r14);     // Catch: AbortFlowException -> L14
    L27:
        return r18.element;
    L14:
        AbortFlowException e10 = e;
    L25:
        kotlinx.coroutines.flow.internal.j.a(e10, r17);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        Ref$ObjectRef r19 = new Ref$ObjectRef();
        b r20 = new b(r19);
        r12.L$0 = r19;     // Catch: AbortFlowException -> L23
        r12.L$1 = r20;     // Catch: AbortFlowException -> L23
        r12.label = 1;     // Catch: AbortFlowException -> L23
        if (r10.collect(r20, r12) != r15) goto L22;
        return r15;
    L22:
        r18 = r19;
    L23:
        e = move-exception;
        r18 = r19;
        e10 = e;
        r17 = r20;
    L7:
        r12 = new FlowKt__ReduceKt$firstOrNull$1(r11);
        goto L8
    }

    public static final Object d(Flow r10, Function2 r11, Continuation r12) {
        if ((r12 instanceof FlowKt__ReduceKt$firstOrNull$3) == false) goto L7;
        FlowKt__ReduceKt$firstOrNull$3 r13 = (FlowKt__ReduceKt$firstOrNull$3) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r18 = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) r13.L$1;
        Ref$ObjectRef r19 = (Ref$ObjectRef) r13.L$0;
        kotlin.c.b(r15);     // Catch: AbortFlowException -> L14
    L27:
        return r19.element;
    L14:
        AbortFlowException e10 = e;
    L25:
        kotlinx.coroutines.flow.internal.j.a(e10, r18);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r15);
        Ref$ObjectRef r20 = new Ref$ObjectRef();
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r21 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(r11, r20);
        r13.L$0 = r20;     // Catch: AbortFlowException -> L23
        r13.L$1 = r21;     // Catch: AbortFlowException -> L23
        r13.label = 1;     // Catch: AbortFlowException -> L23
        if (r10.collect(r21, r13) != r16) goto L22;
        return r16;
    L22:
        r19 = r20;
    L23:
        e = move-exception;
        r19 = r20;
        e10 = e;
        r18 = r21;
    L7:
        r13 = new FlowKt__ReduceKt$firstOrNull$3(r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object e(Flow r10, Object r11, Function3 r12, Continuation r13) {
        if ((r13 instanceof FlowKt__ReduceKt$fold$1) == false) goto L7;
        FlowKt__ReduceKt$fold$1 r14 = (FlowKt__ReduceKt$fold$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        Ref$ObjectRef r19 = (Ref$ObjectRef) r14.L$0;
        kotlin.c.b(r16);
    L19:
        return r19.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r16);
        Ref$ObjectRef r20 = new Ref$ObjectRef();
        r20.element = r11;
        FlowKt__ReduceKt$fold$2 r21 = new FlowKt__ReduceKt$fold$2(r20, r12);
        r14.L$0 = r20;
        r14.label = 1;
        if (r10.collect(r21, r14) != r17) goto L17;
        return r17;
    L17:
        r19 = r20;
    L7:
        r14 = new FlowKt__ReduceKt$fold$1(r13);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.b0] */
    public static final Object f(Flow r10, Continuation r11) {
        if ((r11 instanceof FlowKt__ReduceKt$last$1) == false) goto L7;
        FlowKt__ReduceKt$last$1 r12 = (FlowKt__ReduceKt$last$1) r11;
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
    L18:
        T r18 = r17.element;
        if (r18 == kotlinx.coroutines.flow.internal.m.f21551a) goto L22;
        return r18;
    L22:
        throw new NoSuchElementException("Expected at least one element");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        Ref$ObjectRef r19 = new Ref$ObjectRef();
        r19.element = kotlinx.coroutines.flow.internal.m.f21551a;
        c r20 = new c(r19);
        r12.L$0 = r19;
        r12.label = 1;
        if (r10.collect(r20, r12) != r15) goto L17;
        return r15;
    L17:
        r17 = r19;
    L7:
        r12 = new FlowKt__ReduceKt$last$1(r11);
        goto L8
    }

    public static final Object g(Flow r10, Continuation r11) {
        if ((r11 instanceof FlowKt__ReduceKt$lastOrNull$1) == false) goto L7;
        FlowKt__ReduceKt$lastOrNull$1 r12 = (FlowKt__ReduceKt$lastOrNull$1) r11;
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
    L19:
        return r17.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        Ref$ObjectRef r18 = new Ref$ObjectRef();
        d r19 = new d(r18);
        r12.L$0 = r18;
        r12.label = 1;
        if (r10.collect(r19, r12) != r15) goto L17;
        return r15;
    L17:
        r17 = r18;
    L7:
        r12 = new FlowKt__ReduceKt$lastOrNull$1(r11);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.b0] */
    public static final Object h(Flow r10, Function3 r11, Continuation r12) {
        if ((r12 instanceof FlowKt__ReduceKt$reduce$1) == false) goto L7;
        FlowKt__ReduceKt$reduce$1 r13 = (FlowKt__ReduceKt$reduce$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        Ref$ObjectRef r18 = (Ref$ObjectRef) r13.L$0;
        kotlin.c.b(r15);
    L18:
        T r19 = r18.element;
        if (r19 == kotlinx.coroutines.flow.internal.m.f21551a) goto L22;
        return r19;
    L22:
        throw new NoSuchElementException("Empty flow can't be reduced");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r15);
        Ref$ObjectRef r20 = new Ref$ObjectRef();
        r20.element = kotlinx.coroutines.flow.internal.m.f21551a;
        FlowKt__ReduceKt$reduce$2 r21 = new FlowKt__ReduceKt$reduce$2(r20, r11);
        r13.L$0 = r20;
        r13.label = 1;
        if (r10.collect(r21, r13) != r16) goto L17;
        return r16;
    L17:
        r18 = r20;
    L7:
        r13 = new FlowKt__ReduceKt$reduce$1(r12);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.b0] */
    public static final Object i(Flow r10, Continuation r11) {
        if ((r11 instanceof FlowKt__ReduceKt$single$1) == false) goto L7;
        FlowKt__ReduceKt$single$1 r12 = (FlowKt__ReduceKt$single$1) r11;
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
    L18:
        T r18 = r17.element;
        if (r18 == kotlinx.coroutines.flow.internal.m.f21551a) goto L22;
        return r18;
    L22:
        throw new NoSuchElementException("Flow is empty");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        Ref$ObjectRef r19 = new Ref$ObjectRef();
        r19.element = kotlinx.coroutines.flow.internal.m.f21551a;
        e r20 = new e(r19);
        r12.L$0 = r19;
        r12.label = 1;
        if (r10.collect(r20, r12) != r15) goto L17;
        return r15;
    L17:
        r17 = r19;
    L7:
        r12 = new FlowKt__ReduceKt$single$1(r11);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.b0] */
    public static final Object j(Flow r10, Continuation r11) {
        if ((r11 instanceof FlowKt__ReduceKt$singleOrNull$1) == false) goto L7;
        FlowKt__ReduceKt$singleOrNull$1 r12 = (FlowKt__ReduceKt$singleOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        f r17 = (f) r12.L$1;
        Ref$ObjectRef r18 = (Ref$ObjectRef) r12.L$0;
        kotlin.c.b(r14);     // Catch: AbortFlowException -> L14
    L26:
        T r19 = r18.element;
        if (r19 != kotlinx.coroutines.flow.internal.m.f21551a) goto L34;
        return null;
    L34:
        return r19;
    L14:
        AbortFlowException e10 = e;
    L25:
        kotlinx.coroutines.flow.internal.j.a(e10, r17);
        goto L26
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlin.c.b(r14);
        Ref$ObjectRef r20 = new Ref$ObjectRef();
        r20.element = kotlinx.coroutines.flow.internal.m.f21551a;
        f r21 = new f(r20);
        r12.L$0 = r20;     // Catch: AbortFlowException -> L23
        r12.L$1 = r21;     // Catch: AbortFlowException -> L23
        r12.label = 1;     // Catch: AbortFlowException -> L23
        if (r10.collect(r21, r12) != r15) goto L22;
        return r15;
    L22:
        r18 = r20;
    L23:
        e = move-exception;
        r18 = r20;
        e10 = e;
        r17 = r21;
    L7:
        r12 = new FlowKt__ReduceKt$singleOrNull$1(r11);
        goto L8
    }
}
