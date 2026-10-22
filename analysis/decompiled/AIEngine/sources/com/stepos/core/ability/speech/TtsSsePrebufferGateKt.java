package com.stepos.core.ability.speech;

import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsSsePrebufferGateKt {
    private static final String TAG = "TtsCloudClient";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.TtsSsePrebufferGateKt$prebufferOnStart$2", f = "TtsSsePrebufferGate.kt", l = {61, 88}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.TtsSsePrebufferGateKt$prebufferOnStart$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<ProducerScope<? super byte[]>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ zb.a<Long> $nowMs;
        final /* synthetic */ long $targetMs;
        final /* synthetic */ Flow<byte[]> $this_prebufferOnStart;
        final /* synthetic */ long $ttftBudgetMs;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: com.stepos.core.ability.speech.TtsSsePrebufferGateKt$prebufferOnStart$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ ProducerScope<byte[]> $$this$channelFlow;
            final /* synthetic */ ArrayList<byte[]> $buffer;
            final /* synthetic */ Ref$BooleanRef $firstSeen;
            final /* synthetic */ Ref$BooleanRef $flushed;
            final /* synthetic */ Mutex $mutex;
            final /* synthetic */ zb.a<Long> $nowMs;
            final /* synthetic */ long $subscribeAtMs;
            final /* synthetic */ long $targetMs;
            final /* synthetic */ Ref$ObjectRef<Job> $timerJob;
            final /* synthetic */ long $ttftBudgetMs;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Mutex mutex, Ref$BooleanRef ref$BooleanRef, ProducerScope<? super byte[]> producerScope, ArrayList<byte[]> arrayList, Ref$BooleanRef ref$BooleanRef2, zb.a<Long> aVar, long j10, long j11, long j12, Ref$ObjectRef<Job> ref$ObjectRef) {
                this.$mutex = mutex;
                this.$flushed = ref$BooleanRef;
                this.$$this$channelFlow = producerScope;
                this.$buffer = arrayList;
                this.$firstSeen = ref$BooleanRef2;
                this.$nowMs = aVar;
                this.$subscribeAtMs = j10;
                this.$targetMs = j11;
                this.$ttftBudgetMs = j12;
                this.$timerJob = ref$ObjectRef;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, qb.b bVar) {
                return emit((byte[]) obj, (qb.b<? super lb.n>) bVar);
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x0107, code lost:
            
                if (r13.send(r0, r2) == r3) goto L50;
             */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0150 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:14:0x0041, B:46:0x014a, B:48:0x0150, B:51:0x017c, B:55:0x01c4, B:21:0x0057), top: B:62:0x0025 }] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(byte[] r25, qb.b<? super lb.n> r26) throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 468
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsSsePrebufferGateKt.AnonymousClass2.AnonymousClass1.emit(byte[], qb.b):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(zb.a<Long> aVar, Flow<byte[]> flow, long j10, long j11, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$nowMs = aVar;
            this.$this_prebufferOnStart = flow;
            this.$targetMs = j10;
            this.$ttftBudgetMs = j11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c7 A[Catch: all -> 0x004a, TryCatch #1 {all -> 0x004a, blocks: (B:13:0x0045, B:34:0x00c1, B:36:0x00c7, B:39:0x00eb), top: B:45:0x0045 }] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.Object invokeSuspend$flush(kotlinx.coroutines.sync.Mutex r17, kotlin.jvm.internal.Ref$BooleanRef r18, java.util.ArrayList<byte[]> r19, kotlinx.coroutines.channels.ProducerScope<? super byte[]> r20, java.lang.String r21, long r22, long r24, qb.b<? super lb.n> r26) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 298
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsSsePrebufferGateKt.AnonymousClass2.invokeSuspend$flush(kotlinx.coroutines.sync.Mutex, kotlin.jvm.internal.Ref$BooleanRef, java.util.ArrayList, kotlinx.coroutines.channels.ProducerScope, java.lang.String, long, long, qb.b):java.lang.Object");
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$nowMs, this.$this_prebufferOnStart, this.$targetMs, this.$ttftBudgetMs, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x00c4, code lost:
        
            if (invokeSuspend$flush(r8, r6, r7, r11, "upstream-complete", r12, 0, r25) == r10) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                r25 = this;
                r9 = r25
                kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r0 = r9.label
                r1 = 2
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L36
                if (r0 == r2) goto L1c
                if (r0 != r1) goto L14
                kotlin.c.b(r26)
                goto Lc7
            L14:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1c:
                long r4 = r9.J$0
                java.lang.Object r0 = r9.L$4
                kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
                java.lang.Object r6 = r9.L$3
                kotlin.jvm.internal.Ref$BooleanRef r6 = (kotlin.jvm.internal.Ref$BooleanRef) r6
                java.lang.Object r7 = r9.L$2
                java.util.ArrayList r7 = (java.util.ArrayList) r7
                java.lang.Object r8 = r9.L$1
                kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
                java.lang.Object r11 = r9.L$0
                kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
                kotlin.c.b(r26)
                goto L95
            L36:
                kotlin.c.b(r26)
                java.lang.Object r0 = r9.L$0
                r14 = r0
                kotlinx.coroutines.channels.ProducerScope r14 = (kotlinx.coroutines.channels.ProducerScope) r14
                r0 = 0
                kotlinx.coroutines.sync.Mutex r12 = kotlinx.coroutines.sync.MutexKt.Mutex$default(r0, r2, r3)
                java.util.ArrayList r15 = new java.util.ArrayList
                r15.<init>()
                kotlin.jvm.internal.Ref$BooleanRef r13 = new kotlin.jvm.internal.Ref$BooleanRef
                r13.<init>()
                kotlin.jvm.internal.Ref$BooleanRef r16 = new kotlin.jvm.internal.Ref$BooleanRef
                r16.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r24 = new kotlin.jvm.internal.Ref$ObjectRef
                r24.<init>()
                zb.a<java.lang.Long> r0 = r9.$nowMs
                java.lang.Object r0 = r0.invoke()
                java.lang.Number r0 = (java.lang.Number) r0
                long r18 = r0.longValue()
                kotlinx.coroutines.flow.Flow<byte[]> r0 = r9.$this_prebufferOnStart
                com.stepos.core.ability.speech.TtsSsePrebufferGateKt$prebufferOnStart$2$1 r11 = new com.stepos.core.ability.speech.TtsSsePrebufferGateKt$prebufferOnStart$2$1
                zb.a<java.lang.Long> r4 = r9.$nowMs
                long r5 = r9.$targetMs
                long r7 = r9.$ttftBudgetMs
                r17 = r4
                r20 = r5
                r22 = r7
                r11.<init>(r12, r13, r14, r15, r16, r17, r18, r20, r22, r24)
                r5 = r18
                r4 = r24
                r9.L$0 = r14
                r9.L$1 = r12
                r9.L$2 = r15
                r9.L$3 = r13
                r9.L$4 = r4
                r9.J$0 = r5
                r9.label = r2
                java.lang.Object r0 = r0.collect(r11, r9)
                if (r0 != r10) goto L8f
                goto Lc6
            L8f:
                r0 = r4
                r4 = r5
                r8 = r12
                r6 = r13
                r11 = r14
                r7 = r15
            L95:
                T r0 = r0.f10076a
                kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                if (r0 == 0) goto L9e
                kotlinx.coroutines.Job.DefaultImpls.cancel$default(r0, r3, r2, r3)
            L9e:
                zb.a<java.lang.Long> r0 = r9.$nowMs
                java.lang.Object r0 = r0.invoke()
                java.lang.Number r0 = (java.lang.Number) r0
                long r12 = r0.longValue()
                long r12 = r12 - r4
                r9.L$0 = r3
                r9.L$1 = r3
                r9.L$2 = r3
                r9.L$3 = r3
                r9.L$4 = r3
                r9.label = r1
                java.lang.String r4 = "upstream-complete"
                r2 = r7
                r0 = r8
                r7 = 0
                r1 = r6
                r3 = r11
                r5 = r12
                java.lang.Object r0 = invokeSuspend$flush(r0, r1, r2, r3, r4, r5, r7, r9)
                if (r0 != r10) goto Lc7
            Lc6:
                return r10
            Lc7:
                lb.n r0 = lb.n.f10413a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.TtsSsePrebufferGateKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(ProducerScope<? super byte[]> producerScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(producerScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    public static final Flow<byte[]> prebufferOnStart(Flow<byte[]> flow, long j10, long j11, zb.a<Long> nowMs) {
        kotlin.jvm.internal.g.f(flow, "<this>");
        kotlin.jvm.internal.g.f(nowMs, "nowMs");
        return j10 <= 0 ? flow : FlowKt.channelFlow(new AnonymousClass2(nowMs, flow, j10, j11, null));
    }

    public static /* synthetic */ Flow prebufferOnStart$default(Flow flow, long j10, long j11, zb.a aVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar = new a(7);
        }
        return prebufferOnStart(flow, j10, j11, aVar);
    }
}
