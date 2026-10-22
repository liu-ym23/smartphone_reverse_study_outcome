package com.stepos.core.ability.pipeline;

import com.stepos.core.ability.pipeline.PipelineOutput;
import com.stepos.core.ability.speech.AsrSseEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import qb.b;
import rb.c;
import zb.p;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class GuardedPipeline {
    private final String TAG;
    private final Pipeline pipeline;
    private final AtomicBoolean running;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ability.pipeline.GuardedPipeline$execute$1", f = "GuardedPipeline.kt", l = {26, 32}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.pipeline.GuardedPipeline$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<FlowCollector<? super PipelineOutput>, b<? super n>, Object> {
        final /* synthetic */ v6.c $input;
        final /* synthetic */ String $pipelineId;
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @c(c = "com.stepos.core.ability.pipeline.GuardedPipeline$execute$1$1", f = "GuardedPipeline.kt", l = {31}, m = "invokeSuspend")
        /* renamed from: com.stepos.core.ability.pipeline.GuardedPipeline$execute$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00491 extends SuspendLambda implements q<FlowCollector<? super PipelineOutput>, Throwable, b<? super n>, Object> {
            final /* synthetic */ String $pipelineId;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00491(String str, b<? super C00491> bVar) {
                super(3, bVar);
                this.$pipelineId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                int i10 = this.label;
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                    Throwable th = (Throwable) this.L$1;
                    String str = this.$pipelineId;
                    String message = th.getMessage();
                    if (message == null) {
                        message = AsrSseEvent.TYPE_ERROR;
                    }
                    PipelineOutput.Error error = new PipelineOutput.Error(-1, str, message);
                    this.L$0 = null;
                    this.label = 1;
                    if (flowCollector.emit(error, this) == coroutineSingletons) {
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

            @Override // zb.q
            public final Object invoke(FlowCollector<? super PipelineOutput> flowCollector, Throwable th, b<? super n> bVar) {
                C00491 c00491 = new C00491(this.$pipelineId, bVar);
                c00491.L$0 = flowCollector;
                c00491.L$1 = th;
                return c00491.invokeSuspend(n.f10413a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, v6.c cVar, b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$pipelineId = str;
            this.$input = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass1 anonymousClass1 = GuardedPipeline.this.new AnonymousClass1(this.$pipelineId, this.$input, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
        
            if (r8.emit(r1, r7) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x008b, code lost:
        
            if (r1.collect(r4, r7) == r0) goto L22;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Object, lb.n] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r7.label
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L21
                if (r1 == r4) goto L1d
                if (r1 != r2) goto L15
                kotlin.c.b(r8)     // Catch: java.lang.Throwable -> L12
                goto L8e
            L12:
                r8 = move-exception
                goto L9a
            L15:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1d:
                kotlin.c.b(r8)
                goto L65
            L21:
                kotlin.c.b(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                com.stepos.core.ability.pipeline.GuardedPipeline r1 = com.stepos.core.ability.pipeline.GuardedPipeline.this
                java.util.concurrent.atomic.AtomicBoolean r1 = com.stepos.core.ability.pipeline.GuardedPipeline.access$getRunning$p(r1)
                boolean r1 = r1.compareAndSet(r3, r4)
                if (r1 != 0) goto L68
                com.stepos.core.ability.pipeline.GuardedPipeline r1 = com.stepos.core.ability.pipeline.GuardedPipeline.this
                java.lang.String r1 = com.stepos.core.ability.pipeline.GuardedPipeline.access$getTAG$p(r1)
                java.lang.String r2 = r7.$pipelineId
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r5 = "["
                r3.<init>(r5)
                r3.append(r2)
                java.lang.String r2 = "] already running, rejected"
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                android.util.Log.w(r1, r2)
                com.stepos.core.ability.pipeline.PipelineOutput$Error r1 = new com.stepos.core.ability.pipeline.PipelineOutput$Error
                java.lang.String r2 = r7.$pipelineId
                java.lang.String r3 = "Pipeline is already running"
                r5 = -1
                r1.<init>(r5, r2, r3)
                r7.label = r4
                java.lang.Object r7 = r8.emit(r1, r7)
                if (r7 != r0) goto L65
                goto L8d
            L65:
                lb.n r7 = lb.n.f10413a
                return r7
            L68:
                com.stepos.core.ability.pipeline.GuardedPipeline r1 = com.stepos.core.ability.pipeline.GuardedPipeline.this     // Catch: java.lang.Throwable -> L12
                com.stepos.core.ability.pipeline.Pipeline r1 = com.stepos.core.ability.pipeline.GuardedPipeline.access$getPipeline$p(r1)     // Catch: java.lang.Throwable -> L12
                v6.c r4 = r7.$input     // Catch: java.lang.Throwable -> L12
                kotlinx.coroutines.flow.Flow r1 = r1.execute(r4)     // Catch: java.lang.Throwable -> L12
                com.stepos.core.ability.pipeline.GuardedPipeline$execute$1$1 r4 = new com.stepos.core.ability.pipeline.GuardedPipeline$execute$1$1     // Catch: java.lang.Throwable -> L12
                java.lang.String r5 = r7.$pipelineId     // Catch: java.lang.Throwable -> L12
                r6 = 0
                r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L12
                kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.m168catch(r1, r4)     // Catch: java.lang.Throwable -> L12
                com.stepos.core.ability.pipeline.GuardedPipeline$execute$1$2 r4 = new com.stepos.core.ability.pipeline.GuardedPipeline$execute$1$2     // Catch: java.lang.Throwable -> L12
                r4.<init>()     // Catch: java.lang.Throwable -> L12
                r7.label = r2     // Catch: java.lang.Throwable -> L12
                java.lang.Object r8 = r1.collect(r4, r7)     // Catch: java.lang.Throwable -> L12
                if (r8 != r0) goto L8e
            L8d:
                return r0
            L8e:
                com.stepos.core.ability.pipeline.GuardedPipeline r7 = com.stepos.core.ability.pipeline.GuardedPipeline.this
                java.util.concurrent.atomic.AtomicBoolean r7 = com.stepos.core.ability.pipeline.GuardedPipeline.access$getRunning$p(r7)
                r7.set(r3)
                lb.n r7 = lb.n.f10413a
                return r7
            L9a:
                com.stepos.core.ability.pipeline.GuardedPipeline r7 = com.stepos.core.ability.pipeline.GuardedPipeline.this
                java.util.concurrent.atomic.AtomicBoolean r7 = com.stepos.core.ability.pipeline.GuardedPipeline.access$getRunning$p(r7)
                r7.set(r3)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.pipeline.GuardedPipeline.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super PipelineOutput> flowCollector, b<? super n> bVar) {
            return ((AnonymousClass1) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    public GuardedPipeline(Pipeline pipeline) {
        g.f(pipeline, "pipeline");
        this.pipeline = pipeline;
        this.TAG = "GuardedPipeline";
        this.running = new AtomicBoolean(false);
    }

    public static /* synthetic */ Flow execute$default(GuardedPipeline guardedPipeline, v6.c cVar, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "pipeline";
        }
        return guardedPipeline.execute(cVar, str);
    }

    public final Flow<PipelineOutput> execute(v6.c input, String pipelineId) {
        g.f(input, "input");
        g.f(pipelineId, "pipelineId");
        return FlowKt.flow(new AnonymousClass1(pipelineId, input, null));
    }

    public final boolean isRunning() {
        return this.running.get();
    }
}
