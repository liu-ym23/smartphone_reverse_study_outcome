package io.ktor.server.routing;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.OnCallContext;
import io.ktor.server.application.PipelineCall;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/server/application/OnCallContext;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "call", "<anonymous>", "(Lio/ktor/server/application/OnCallContext;Lio/ktor/server/application/PipelineCall;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.routing.IgnoreTrailingSlashKt$IgnoreTrailingSlash$1$1", f = "IgnoreTrailingSlash.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class IgnoreTrailingSlashKt$IgnoreTrailingSlash$1$1 extends SuspendLambda implements p9.q<OnCallContext<Y8.t>, PipelineCall, InterfaceC4014c<? super Y8.t>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public IgnoreTrailingSlashKt$IgnoreTrailingSlash$1$1(InterfaceC4014c<? super IgnoreTrailingSlashKt$IgnoreTrailingSlash$1$1> interfaceC4014c) {
        super(3, interfaceC4014c);
    }

    @Override // p9.q
    public final Object invoke(OnCallContext<Y8.t> onCallContext, PipelineCall pipelineCall, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        IgnoreTrailingSlashKt$IgnoreTrailingSlash$1$1 ignoreTrailingSlashKt$IgnoreTrailingSlash$1$1 = new IgnoreTrailingSlashKt$IgnoreTrailingSlash$1$1(interfaceC4014c);
        ignoreTrailingSlashKt$IgnoreTrailingSlash$1$1.L$0 = pipelineCall;
        return ignoreTrailingSlashKt$IgnoreTrailingSlash$1$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        IgnoreTrailingSlashKt.setIgnoreTrailingSlash((PipelineCall) this.L$0, true);
        return Y8.t.f7040a;
    }
}
