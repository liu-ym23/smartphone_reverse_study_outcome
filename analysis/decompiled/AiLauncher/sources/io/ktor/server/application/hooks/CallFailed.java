package io.ktor.server.application.hooks;

import Ua.M;
import W4.b;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.ApplicationCallPipeline;
import io.ktor.server.application.Hook;
import io.ktor.server.application.PipelineCall;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002*\u0012&\u0012$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJA\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/server/application/hooks/CallFailed;", "Lio/ktor/server/application/Hook;", "Lkotlin/Function3;", "Lio/ktor/server/application/ApplicationCall;", "", "Le9/c;", "LY8/t;", "", "<init>", "()V", "Lio/ktor/server/application/ApplicationCallPipeline;", "pipeline", "handler", b.STEP_INSTALL, "(Lio/ktor/server/application/ApplicationCallPipeline;Lp9/q;)V", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "Lio/ktor/util/pipeline/PipelinePhase;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CallFailed implements Hook<q<? super ApplicationCall, ? super Throwable, ? super InterfaceC4014c<? super t>, ? extends Object>> {
    public static final CallFailed INSTANCE = new CallFailed();
    private static final Phase phase = new Phase("BeforeSetup");

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "it", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;V)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.hooks.CallFailed$install$1", f = "CommonHooks.kt", l = {48, 52}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.hooks.CallFailed$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<PipelineContext<t, PipelineCall>, t, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ q<ApplicationCall, Throwable, InterfaceC4014c<? super t>, Object> $handler;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
        @InterfaceC4112d(c = "io.ktor.server.application.hooks.CallFailed$install$1$1", f = "CommonHooks.kt", l = {49}, m = "invokeSuspend")
        /* renamed from: io.ktor.server.application.hooks.CallFailed$install$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04111 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
            final /* synthetic */ PipelineContext<t, PipelineCall> $$this$intercept;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C04111(PipelineContext<t, PipelineCall> pipelineContext, InterfaceC4014c<? super C04111> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.$$this$intercept = pipelineContext;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new C04111(this.$$this$intercept, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((C04111) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    PipelineContext<t, PipelineCall> pipelineContext = this.$$this$intercept;
                    this.label = 1;
                    if (pipelineContext.proceed(this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                return t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(q<? super ApplicationCall, ? super Throwable, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = qVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<t, PipelineCall> pipelineContext, t tVar, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        
            if (kotlinx.coroutines.d.f(r1, r6) == r0) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r0 = r6.L$1
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                java.lang.Object r6 = r6.L$0
                io.ktor.util.pipeline.PipelineContext r6 = (io.ktor.util.pipeline.PipelineContext) r6
                kotlin.C4849c.b(r7)
                goto L5f
            L1a:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L22:
                java.lang.Object r1 = r6.L$0
                io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
                kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L2a
                goto L6f
            L2a:
                r7 = move-exception
                r5 = r1
                r1 = r7
                r7 = r5
                goto L48
            L2f:
                kotlin.C4849c.b(r7)
                java.lang.Object r7 = r6.L$0
                io.ktor.util.pipeline.PipelineContext r7 = (io.ktor.util.pipeline.PipelineContext) r7
                io.ktor.server.application.hooks.CallFailed$install$1$1 r1 = new io.ktor.server.application.hooks.CallFailed$install$1$1     // Catch: java.lang.Throwable -> L47
                r4 = 0
                r1.<init>(r7, r4)     // Catch: java.lang.Throwable -> L47
                r6.L$0 = r7     // Catch: java.lang.Throwable -> L47
                r6.label = r3     // Catch: java.lang.Throwable -> L47
                java.lang.Object r6 = kotlinx.coroutines.d.f(r1, r6)     // Catch: java.lang.Throwable -> L47
                if (r6 != r0) goto L6f
                goto L5c
            L47:
                r1 = move-exception
            L48:
                p9.q<io.ktor.server.application.ApplicationCall, java.lang.Throwable, e9.c<? super Y8.t>, java.lang.Object> r3 = r6.$handler
                java.lang.Object r4 = r7.getContext()
                io.ktor.server.application.PipelineCall r4 = (io.ktor.server.application.PipelineCall) r4
                r6.L$0 = r7
                r6.L$1 = r1
                r6.label = r2
                java.lang.Object r6 = r3.invoke(r4, r1, r6)
                if (r6 != r0) goto L5d
            L5c:
                return r0
            L5d:
                r6 = r7
                r0 = r1
            L5f:
                java.lang.Object r6 = r6.getContext()
                io.ktor.server.application.PipelineCall r6 = (io.ktor.server.application.PipelineCall) r6
                io.ktor.server.response.PipelineResponse r6 = r6.getResponse()
                boolean r6 = r6.getIsSent()
                if (r6 == 0) goto L72
            L6f:
                Y8.t r6 = Y8.t.f7040a
                return r6
            L72:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.application.hooks.CallFailed.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private CallFailed() {
    }

    @Override // io.ktor.server.application.Hook
    public void install(ApplicationCallPipeline pipeline, q<? super ApplicationCall, ? super Throwable, ? super InterfaceC4014c<? super t>, ? extends Object> handler) throws InvalidPhaseException {
        kotlin.jvm.internal.p.i(pipeline, "pipeline");
        kotlin.jvm.internal.p.i(handler, "handler");
        Phase setup = ApplicationCallPipeline.INSTANCE.getSetup();
        Phase phase2 = phase;
        pipeline.insertPhaseBefore(setup, phase2);
        pipeline.intercept(phase2, new AnonymousClass1(handler, null));
    }
}
