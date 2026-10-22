package androidx.datastore.core;

import androidx.datastore.core.c;
import d1.g;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class SingleProcessDataStore$data$1 extends SuspendLambda implements p<FlowCollector<Object>, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f1614a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1615b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c<Object> f1616c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g<Object>, qb.b<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f1617a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g<Object> f1618b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(g<Object> gVar, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.f1618b = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f1618b, bVar);
            anonymousClass1.f1617a = obj;
            return anonymousClass1;
        }

        @Override // zb.p
        public final Object invoke(g<Object> gVar, qb.b<? super Boolean> bVar) {
            return ((AnonymousClass1) create(gVar, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            g<Object> gVar = (g) this.f1617a;
            g<Object> gVar2 = this.f1618b;
            boolean z = false;
            if (!(gVar2 instanceof d1.a) && !(gVar2 instanceof d1.d) && gVar == gVar2) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$data$1(c<Object> cVar, qb.b<? super SingleProcessDataStore$data$1> bVar) {
        super(2, bVar);
        this.f1616c = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.f1616c, bVar);
        singleProcessDataStore$data$1.f1615b = obj;
        return singleProcessDataStore$data$1;
    }

    @Override // zb.p
    public final Object invoke(FlowCollector<Object> flowCollector, qb.b<? super n> bVar) {
        return ((SingleProcessDataStore$data$1) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        c<Object> cVar = this.f1616c;
        MutableStateFlow<g<Object>> mutableStateFlow = cVar.f1680g;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f1614a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f1615b;
            g<Object> value = mutableStateFlow.getValue();
            if (!(value instanceof d1.a)) {
                cVar.f1681i.a(new c.a.C0011a(value));
            }
            final Flow flowDropWhile = FlowKt.dropWhile(mutableStateFlow, new AnonymousClass1(value, null));
            Flow<Object> flow = new Flow<Object>() { // from class: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1

                /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
                /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2 implements FlowCollector<g<Object>> {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ FlowCollector f1605a;

                    @rb.c(c = "androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2", f = "SingleProcessDataStore.kt", l = {137}, m = "emit")
                    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: a, reason: collision with root package name */
                        public /* synthetic */ Object f1606a;

                        /* renamed from: b, reason: collision with root package name */
                        public int f1607b;

                        public AnonymousClass1(qb.b bVar) {
                            super(bVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f1606a = obj;
                            this.f1607b |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.f1605a = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(d1.g<java.lang.Object> r5, qb.b r6) throws java.lang.Throwable {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = (androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f1607b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f1607b = r1
                            goto L18
                        L13:
                            androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = new androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.f1606a
                            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                            int r2 = r0.f1607b
                            r3 = 1
                            if (r2 == 0) goto L2f
                            if (r2 != r3) goto L27
                            kotlin.c.b(r6)
                            goto L4f
                        L27:
                            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                            r4.<init>(r5)
                            throw r4
                        L2f:
                            kotlin.c.b(r6)
                            d1.g r5 = (d1.g) r5
                            boolean r6 = r5 instanceof d1.f
                            if (r6 != 0) goto L69
                            boolean r6 = r5 instanceof d1.d
                            if (r6 != 0) goto L64
                            boolean r6 = r5 instanceof d1.a
                            if (r6 == 0) goto L52
                            d1.a r5 = (d1.a) r5
                            T r5 = r5.f8258a
                            r0.f1607b = r3
                            kotlinx.coroutines.flow.FlowCollector r4 = r4.f1605a
                            java.lang.Object r4 = r4.emit(r5, r0)
                            if (r4 != r1) goto L4f
                            return r1
                        L4f:
                            lb.n r4 = lb.n.f10413a
                            return r4
                        L52:
                            boolean r4 = r5 instanceof d1.h
                            if (r4 == 0) goto L5e
                            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                            java.lang.String r5 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                            r4.<init>(r5)
                            throw r4
                        L5e:
                            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
                            r4.<init>()
                            throw r4
                        L64:
                            d1.d r5 = (d1.d) r5
                            java.lang.Throwable r4 = r5.f8260a
                            throw r4
                        L69:
                            d1.f r5 = (d1.f) r5
                            java.lang.Throwable r4 = r5.f8261a
                            throw r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, qb.b):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public final Object collect(FlowCollector<? super Object> flowCollector2, qb.b bVar) {
                    Object objCollect = flowDropWhile.collect(new AnonymousClass2(flowCollector2), bVar);
                    return objCollect == CoroutineSingletons.f10059a ? objCollect : n.f10413a;
                }
            };
            this.f1614a = 1;
            if (FlowKt.emitAll(flowCollector, flow, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return n.f10413a;
    }
}
