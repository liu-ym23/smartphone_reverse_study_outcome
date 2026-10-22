package io.ktor.util.pipeline;

import Y8.t;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import p9.q;

@Metadata(d1 = {"\u00002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u009d\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00012J\u0010\n\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\t0\u00042\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "TSubject", "TContext", "context", "", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Le9/c;", "LY8/t;", "Lio/ktor/util/pipeline/PipelineInterceptor;", "interceptors", "subject", "Lkotlin/coroutines/d;", "coroutineContext", "", "debugMode", "pipelineContextFor", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Lkotlin/coroutines/d;Z)Lio/ktor/util/pipeline/PipelineContext;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PipelineContextKt {
    public static final <TSubject, TContext> PipelineContext<TSubject, TContext> pipelineContextFor(TContext context, List<? extends q<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super InterfaceC4014c<? super t>, ? extends Object>> interceptors, TSubject subject, d coroutineContext, boolean z10) {
        p.i(context, "context");
        p.i(interceptors, "interceptors");
        p.i(subject, "subject");
        p.i(coroutineContext, "coroutineContext");
        return (PipelineContext_jvmKt.getDISABLE_SFG() || z10) ? new DebugPipelineContext(context, interceptors, subject, coroutineContext) : new SuspendFunctionGun(subject, context, interceptors);
    }

    public static /* synthetic */ PipelineContext pipelineContextFor$default(Object obj, List list, Object obj2, d dVar, boolean z10, int i10, Object obj3) {
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        return pipelineContextFor(obj, list, obj2, dVar, z10);
    }
}
