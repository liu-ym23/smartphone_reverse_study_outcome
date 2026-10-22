package io.ktor.util.pipeline;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import io.ktor.util.debug.ContextUtilsKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a2\u0010\u0005\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0005\u0010\u0006\u001aw\u0010\u000e\u001a\u00020\u0003\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00020\u0000*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\t\u001a\u00020\b26\b\b\u0010\r\u001a0\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f*p\b\u0000\u0010\u0010\u001a\u0004\b\u0000\u0010\u0007\u001a\u0004\b\u0001\u0010\u0001\".\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n2.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n*r\u0010\u0011\u001a\u0004\b\u0000\u0010\u0007\u001a\u0004\b\u0001\u0010\u0001\"0\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n20\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"", "TContext", "Lio/ktor/util/pipeline/Pipeline;", "LY8/t;", "context", "execute", "(Lio/ktor/util/pipeline/Pipeline;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "TSubject", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Le9/c;", "block", "intercept", "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/util/pipeline/PipelinePhase;Lp9/q;)V", "PipelineInterceptorCoroutine", "PipelineInterceptor", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PipelineKt {

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.pipeline.PipelineKt$execute$2", f = "Pipeline.kt", l = {510}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.pipeline.PipelineKt$execute$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ TContext $context;
        final /* synthetic */ Pipeline<t, TContext> $this_execute;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Pipeline<t, TContext> pipeline, TContext tcontext, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(1, interfaceC4014c);
            this.$this_execute = pipeline;
            this.$context = tcontext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$this_execute, this.$context, interfaceC4014c);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Pipeline<t, TContext> pipeline = this.$this_execute;
                TContext tcontext = this.$context;
                t tVar = t.f7040a;
                this.label = 1;
                if (pipeline.execute(tcontext, tVar, this) == objG) {
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

    /* JADX INFO: Add missing generic type declarations: [TContext] */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "subject", "LY8/t;", "<anonymous>", "(Ljava/lang/Void;Ljava/lang/Void;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.util.pipeline.PipelineKt$intercept$1", f = "Pipeline.kt", l = {528}, m = "invokeSuspend")
    /* renamed from: io.ktor.util.pipeline.PipelineKt$intercept$1, reason: invalid class name */
    public static final class AnonymousClass1<TContext> extends SuspendLambda implements q<PipelineContext<? extends Object, TContext>, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object> $block;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(q<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$block = qVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<? extends Object, TContext> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            Object obj2 = this.L$1;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                p.o(3, "TSubject");
                if (obj2 == null) {
                    return t.f7040a;
                }
                PipelineContext pipelineContext2 = pipelineContext != null ? pipelineContext : null;
                if (pipelineContext2 != null) {
                    q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object> qVar = this.$block;
                    this.L$0 = h.a(pipelineContext);
                    this.L$1 = h.a(obj2);
                    this.L$2 = h.a(pipelineContext2);
                    this.label = 1;
                    if (qVar.invoke(pipelineContext2, obj2, this) == objG) {
                        return objG;
                    }
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

    public static final <TContext> Object execute(Pipeline<t, TContext> pipeline, TContext tcontext, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objInitContextInDebugMode = ContextUtilsKt.initContextInDebugMode(new AnonymousClass2(pipeline, tcontext, null), interfaceC4014c);
        return objInitContextInDebugMode == C4063a.g() ? objInitContextInDebugMode : t.f7040a;
    }

    private static final <TContext> Object execute$$forInline(Pipeline<t, TContext> pipeline, TContext tcontext, InterfaceC4014c<? super t> interfaceC4014c) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(pipeline, tcontext, null);
        n.c(0);
        ContextUtilsKt.initContextInDebugMode(anonymousClass2, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    public static final /* synthetic */ <TSubject, TContext> void intercept(Pipeline<?, TContext> pipeline, Phase phase, q<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        p.i(pipeline, "<this>");
        p.i(phase, "phase");
        p.i(block, "block");
        p.n();
        pipeline.intercept(phase, new AnonymousClass1(block, null));
    }
}
