package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes4.dex */
public final class DistinctFlowImpl implements Flow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Flow f21427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f21428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2 f21429c;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2, reason: invalid class name */
    public static final class AnonymousClass2 implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DistinctFlowImpl f21430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f21431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f21432c;

        public AnonymousClass2(DistinctFlowImpl r10, Ref$ObjectRef r11, FlowCollector r12) {
            this.f21430a = r10;
            this.f21431b = r11;
            this.f21432c = r12;
        }

        /* JADX WARN: Type inference failed for: r7v4, types: [T, java.lang.Object] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r10, Continuation r11) {
            if ((r11 instanceof DistinctFlowImpl$collect$2$emit$1) == false) goto L7;
            DistinctFlowImpl$collect$2$emit$1 r12 = (DistinctFlowImpl$collect$2$emit$1) r11;
            int r13 = r12.label;
            if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
            r12.label = r13 - Integer.MIN_VALUE;
        L8:
            Object r14 = r12.result;
            Object r15 = kotlin.coroutines.intrinsics.a.d();
            int r16 = r12.label;
            if (r16 == 0) goto L14;
            if (r16 != 1) goto L13;
            kotlin.c.b(r14);
        L25:
            return Unit.f21064a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            kotlin.c.b(r14);
            ?? r17 = this.f21430a.f21428b.invoke(r10);
            T r18 = this.f21431b.element;
            if (r18 != kotlinx.coroutines.flow.internal.m.f21551a) goto L17;
        L21:
            this.f21431b.element = r17;
            FlowCollector r19 = this.f21432c;
            r12.label = 1;
            if (r19.emit(r10, r12) != r15) goto L25;
            return r15;
        L17:
            if (((Boolean) this.f21430a.f21429c.mo0invoke(r18, r17)).booleanValue() == false) goto L21;
            return Unit.f21064a;
        L7:
            r12 = new DistinctFlowImpl$collect$2$emit$1(this, r11);
            goto L8
        }
    }

    public DistinctFlowImpl(Flow r10, Function1 r11, Function2 r12) {
        this.f21427a = r10;
        this.f21428b = r11;
        this.f21429c = r12;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, kotlinx.coroutines.internal.b0] */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector r10, Continuation r11) {
        Ref$ObjectRef r12 = new Ref$ObjectRef();
        r12.element = kotlinx.coroutines.flow.internal.m.f21551a;
        Object r13 = this.f21427a.collect(new AnonymousClass2(this, r12, r10), r11);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r13;
    L6:
        return Unit.f21064a;
    }
}
