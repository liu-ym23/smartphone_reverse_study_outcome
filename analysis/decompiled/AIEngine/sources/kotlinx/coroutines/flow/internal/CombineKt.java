package kotlinx.coroutines.flow.internal;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import lb.n;
import mb.s;
import qb.b;
import rb.c;
import zb.a;
import zb.p;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CombineKt {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {ErrorCodes.SERVICE_RECYCLE_ERROR, 73, 76}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ a<T[]> $arrayFactory;
        final /* synthetic */ Flow<T>[] $flows;
        final /* synthetic */ FlowCollector<R> $this_combineInternal;
        final /* synthetic */ q<FlowCollector<? super R>, T[], b<? super n>, Object> $transform;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @c(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {ErrorCodes.GET_CONTENT_URI_ERROR}, m = "invokeSuspend")
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
            final /* synthetic */ Flow<T>[] $flows;
            final /* synthetic */ int $i;
            final /* synthetic */ AtomicInteger $nonClosed;
            final /* synthetic */ Channel<s<Object>> $resultChannel;
            int label;

            /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01041<T> implements FlowCollector {
                final /* synthetic */ int $i;
                final /* synthetic */ Channel<s<Object>> $resultChannel;

                public C01041(Channel<s<Object>> channel, int i10) {
                    this.$resultChannel = channel;
                    this.$i = i10;
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
                
                    if (kotlinx.coroutines.YieldKt.yield(r0) == r1) goto L21;
                 */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(T r6, qb.b<? super lb.n> r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                        if (r0 == 0) goto L13
                        r0 = r7
                        kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                        r0.<init>(r5, r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L36
                        if (r2 == r4) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.c.b(r7)
                        goto L54
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.c.b(r7)
                        goto L4b
                    L36:
                        kotlin.c.b(r7)
                        kotlinx.coroutines.channels.Channel<mb.s<java.lang.Object>> r7 = r5.$resultChannel
                        mb.s r2 = new mb.s
                        int r5 = r5.$i
                        r2.<init>(r5, r6)
                        r0.label = r4
                        java.lang.Object r5 = r7.send(r2, r0)
                        if (r5 != r1) goto L4b
                        goto L53
                    L4b:
                        r0.label = r3
                        java.lang.Object r5 = kotlinx.coroutines.YieldKt.yield(r0)
                        if (r5 != r1) goto L54
                    L53:
                        return r1
                    L54:
                        lb.n r5 = lb.n.f10413a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt.AnonymousClass2.AnonymousClass1.C01041.emit(java.lang.Object, qb.b):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Flow<? extends T>[] flowArr, int i10, AtomicInteger atomicInteger, Channel<s<Object>> channel, b<? super AnonymousClass1> bVar) {
                super(2, bVar);
                this.$flows = flowArr;
                this.$i = i10;
                this.$nonClosed = atomicInteger;
                this.$resultChannel = channel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final b<n> create(Object obj, b<?> bVar) {
                return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, bVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AtomicInteger atomicInteger;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                int i10 = this.label;
                try {
                    if (i10 == 0) {
                        kotlin.c.b(obj);
                        Flow[] flowArr = this.$flows;
                        int i11 = this.$i;
                        Flow flow = flowArr[i11];
                        C01041 c01041 = new C01041(this.$resultChannel, i11);
                        this.label = 1;
                        if (flow.collect(c01041, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.c.b(obj);
                    }
                    if (atomicInteger.decrementAndGet() == 0) {
                        SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                    }
                    return n.f10413a;
                } finally {
                    if (this.$nonClosed.decrementAndGet() == 0) {
                        SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                    }
                }
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
                return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Flow<? extends T>[] flowArr, a<T[]> aVar, q<? super FlowCollector<? super R>, ? super T[], ? super b<? super n>, ? extends Object> qVar, FlowCollector<? super R> flowCollector, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$flows = flowArr;
            this.$arrayFactory = aVar;
            this.$transform = qVar;
            this.$this_combineInternal = flowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00ff, code lost:
        
            if (r10.invoke(r11, r13, r21) == r1) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x011b, code lost:
        
            if (r11.invoke(r12, r10, r21) == r1) goto L43;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00be A[LOOP:0: B:28:0x00be->B:47:?, LOOP_START, PHI: r7 r10
          0x00be: PHI (r7v4 int) = (r7v3 int), (r7v5 int) binds: [B:25:0x00b9, B:47:?] A[DONT_GENERATE, DONT_INLINE]
          0x00be: PHI (r10v3 mb.s) = (r10v2 mb.s), (r10v16 mb.s) binds: [B:25:0x00b9, B:47:?] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x011e -> B:20:0x0096). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 295
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    public static final <R, T> Object combineInternal(FlowCollector<? super R> flowCollector, Flow<? extends T>[] flowArr, a<T[]> aVar, q<? super FlowCollector<? super R>, ? super T[], ? super b<? super n>, ? extends Object> qVar, b<? super n> bVar) {
        Object objFlowScope = FlowCoroutineKt.flowScope(new AnonymousClass2(flowArr, aVar, qVar, flowCollector, null), bVar);
        return objFlowScope == CoroutineSingletons.f10059a ? objFlowScope : n.f10413a;
    }
}
