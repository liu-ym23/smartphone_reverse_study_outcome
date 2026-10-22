package io.ktor.server.http.content;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.routing.RoutingCall;
import io.ktor.server.routing.RoutingContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt$staticContentRoute$2$1$1$2$1", f = "StaticContent.kt", l = {625}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class StaticContentKt$staticContentRoute$2$1$1$2$1 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ p9.p<ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StaticContentKt$staticContentRoute$2$1$1$2$1(p9.p<? super ApplicationCall, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super StaticContentKt$staticContentRoute$2$1$1$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$handler = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        StaticContentKt$staticContentRoute$2$1$1$2$1 staticContentKt$staticContentRoute$2$1$1$2$1 = new StaticContentKt$staticContentRoute$2$1$1$2$1(this.$handler, interfaceC4014c);
        staticContentKt$staticContentRoute$2$1$1$2$1.L$0 = obj;
        return staticContentKt$staticContentRoute$2$1$1$2$1;
    }

    @Override // p9.p
    public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((StaticContentKt$staticContentRoute$2$1$1$2$1) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            RoutingContext routingContext = (RoutingContext) this.L$0;
            p9.p<ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> pVar = this.$handler;
            RoutingCall call = routingContext.getCall();
            this.label = 1;
            if (pVar.invoke(call, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
