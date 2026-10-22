package io.ktor.server.engine;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.OnCallContext;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.engine.ShutDownUrl;
import io.ktor.server.request.ApplicationRequestPropertiesKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/server/application/OnCallContext;", "Lio/ktor/server/engine/ShutDownUrl$Config;", "Lio/ktor/server/application/PipelineCall;", "call", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/OnCallContext;Lio/ktor/server/application/PipelineCall;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.engine.ShutDownUrl$Companion$ApplicationCallPlugin$2$1", f = "ShutDownUrl.kt", l = {116}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ShutDownUrl$Companion$ApplicationCallPlugin$2$1 extends SuspendLambda implements p9.q<OnCallContext<ShutDownUrl.Config>, PipelineCall, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ShutDownUrl $plugin;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShutDownUrl$Companion$ApplicationCallPlugin$2$1(ShutDownUrl shutDownUrl, InterfaceC4014c<? super ShutDownUrl$Companion$ApplicationCallPlugin$2$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$plugin = shutDownUrl;
    }

    @Override // p9.q
    public final Object invoke(OnCallContext<ShutDownUrl.Config> onCallContext, PipelineCall pipelineCall, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        ShutDownUrl$Companion$ApplicationCallPlugin$2$1 shutDownUrl$Companion$ApplicationCallPlugin$2$1 = new ShutDownUrl$Companion$ApplicationCallPlugin$2$1(this.$plugin, interfaceC4014c);
        shutDownUrl$Companion$ApplicationCallPlugin$2$1.L$0 = pipelineCall;
        return shutDownUrl$Companion$ApplicationCallPlugin$2$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            PipelineCall pipelineCall = (PipelineCall) this.L$0;
            if (kotlin.jvm.internal.p.d(ApplicationRequestPropertiesKt.getUri(pipelineCall.getRequest()), this.$plugin.getUrl())) {
                ShutDownUrl shutDownUrl = this.$plugin;
                this.label = 1;
                if (shutDownUrl.doShutdown(pipelineCall, this) == objG) {
                    return objG;
                }
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
