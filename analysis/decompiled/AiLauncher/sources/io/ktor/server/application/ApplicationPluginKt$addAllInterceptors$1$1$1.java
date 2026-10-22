package io.ktor.server.application;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.routing.RoutingApplicationCall;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.q;

/* JADX INFO: Add missing generic type declarations: [TContext, TSubject] */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\n"}, d2 = {"TSubject", "TContext", "Lio/ktor/util/pipeline/PipelineContext;", "subject", "LY8/t;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.application.ApplicationPluginKt$addAllInterceptors$1$1$1", f = "ApplicationPlugin.kt", l = {193}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ApplicationPluginKt$addAllInterceptors$1$1$1<TContext, TSubject> extends SuspendLambda implements q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object> $interceptor;
    final /* synthetic */ BaseRouteScopedPlugin<B, F> $plugin;
    final /* synthetic */ F $pluginInstance;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ApplicationPluginKt$addAllInterceptors$1$1$1(BaseRouteScopedPlugin<B, F> baseRouteScopedPlugin, F f10, q<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super ApplicationPluginKt$addAllInterceptors$1$1$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$plugin = baseRouteScopedPlugin;
        this.$pluginInstance = f10;
        this.$interceptor = qVar;
    }

    public final Object invoke(PipelineContext<TSubject, TContext> pipelineContext, TSubject tsubject, InterfaceC4014c<? super t> interfaceC4014c) {
        ApplicationPluginKt$addAllInterceptors$1$1$1 applicationPluginKt$addAllInterceptors$1$1$1 = new ApplicationPluginKt$addAllInterceptors$1$1$1(this.$plugin, this.$pluginInstance, this.$interceptor, interfaceC4014c);
        applicationPluginKt$addAllInterceptors$1$1$1.L$0 = pipelineContext;
        applicationPluginKt$addAllInterceptors$1$1$1.L$1 = tsubject;
        return applicationPluginKt$addAllInterceptors$1$1$1.invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            Object obj2 = this.L$1;
            Object context = pipelineContext.getContext();
            if ((context instanceof RoutingApplicationCall) && p.d(RouteScopedPluginKt.findPluginInRoute(((RoutingApplicationCall) context).getRoute(), this.$plugin), this.$pluginInstance)) {
                q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object> qVar = this.$interceptor;
                this.L$0 = null;
                this.label = 1;
                if (qVar.invoke(pipelineContext, obj2, this) == objG) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p9.q
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, InterfaceC4014c<? super t> interfaceC4014c) {
        return invoke((PipelineContext<PipelineContext<TSubject, TContext>, TContext>) obj, (PipelineContext<TSubject, TContext>) obj2, interfaceC4014c);
    }
}
