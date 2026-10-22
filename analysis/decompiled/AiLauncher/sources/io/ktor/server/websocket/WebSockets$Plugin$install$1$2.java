package io.ktor.server.websocket;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.PipelineCall;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.q;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.websocket.WebSockets$Plugin$install$1$2", f = "WebSockets.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class WebSockets$Plugin$install$1$2 extends SuspendLambda implements q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super t>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public WebSockets$Plugin$install$1$2(InterfaceC4014c<? super WebSockets$Plugin$install$1$2> interfaceC4014c) {
        super(3, interfaceC4014c);
    }

    @Override // p9.q
    public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        WebSockets$Plugin$install$1$2 webSockets$Plugin$install$1$2 = new WebSockets$Plugin$install$1$2(interfaceC4014c);
        webSockets$Plugin$install$1$2.L$0 = obj;
        return webSockets$Plugin$install$1$2.invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return !(this.L$0 instanceof WebSocketUpgrade) ? t.f7040a : t.f7040a;
    }
}
