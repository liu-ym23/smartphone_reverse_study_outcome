package kotlinx.coroutines.flow;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import lb.n;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class DistinctFlowImpl<T> implements Flow<T> {
    public final p<Object, Object, Boolean> areEquivalent;
    public final l<T, Object> keySelector;
    private final Flow<T> upstream;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<T> $collector;
        final /* synthetic */ Ref$ObjectRef<Object> $previousKey;
        final /* synthetic */ DistinctFlowImpl<T> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(DistinctFlowImpl<T> distinctFlowImpl, Ref$ObjectRef<Object> ref$ObjectRef, FlowCollector<? super T> flowCollector) {
            this.this$0 = distinctFlowImpl;
            this.$previousKey = ref$ObjectRef;
            this.$collector = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r6, qb.b<? super lb.n> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
                if (r0 == 0) goto L13
                r0 = r7
                kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                kotlin.c.b(r7)
                goto L65
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                kotlin.c.b(r7)
                kotlinx.coroutines.flow.DistinctFlowImpl<T> r7 = r5.this$0
                zb.l<T, java.lang.Object> r7 = r7.keySelector
                java.lang.Object r7 = r7.invoke(r6)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.$previousKey
                T r2 = r2.f10076a
                kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
                if (r2 == r4) goto L56
                kotlinx.coroutines.flow.DistinctFlowImpl<T> r4 = r5.this$0
                zb.p<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.areEquivalent
                java.lang.Object r2 = r4.invoke(r2, r7)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L53
                goto L56
            L53:
                lb.n r5 = lb.n.f10413a
                return r5
            L56:
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.$previousKey
                r2.f10076a = r7
                kotlinx.coroutines.flow.FlowCollector<T> r5 = r5.$collector
                r0.label = r3
                java.lang.Object r5 = r5.emit(r6, r0)
                if (r5 != r1) goto L65
                return r1
            L65:
                lb.n r5 = lb.n.f10413a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl.AnonymousClass2.emit(java.lang.Object, qb.b):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(Flow<? extends T> flow, l<? super T, ? extends Object> lVar, p<Object, Object, Boolean> pVar) {
        this.upstream = flow;
        this.keySelector = lVar;
        this.areEquivalent = pVar;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, qb.b<? super n> bVar) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f10076a = (T) NullSurrogateKt.NULL;
        Object objCollect = this.upstream.collect(new AnonymousClass2(this, ref$ObjectRef, flowCollector), bVar);
        return objCollect == CoroutineSingletons.f10059a ? objCollect : n.f10413a;
    }
}
