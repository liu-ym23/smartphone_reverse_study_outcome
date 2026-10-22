package io.ktor.client.plugins.sse;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.sse.ServerSentEvent;
import io.ktor.util.logging.LoggerJvmKt;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"LXa/c;", "Lio/ktor/sse/ServerSentEvent;", "", "cause", "LY8/t;", "<anonymous>", "(LXa/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$2", f = "DefaultClientSSESession.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class DefaultClientSSESession$_incoming$2 extends SuspendLambda implements p9.q<Xa.c<? super ServerSentEvent>, Throwable, InterfaceC4014c<? super Y8.t>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultClientSSESession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultClientSSESession$_incoming$2(DefaultClientSSESession defaultClientSSESession, InterfaceC4014c<? super DefaultClientSSESession$_incoming$2> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.this$0 = defaultClientSSESession;
    }

    @Override // p9.q
    public final Object invoke(Xa.c<? super ServerSentEvent> cVar, Throwable th, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        DefaultClientSSESession$_incoming$2 defaultClientSSESession$_incoming$2 = new DefaultClientSSESession$_incoming$2(this.this$0, interfaceC4014c);
        defaultClientSSESession$_incoming$2.L$0 = th;
        return defaultClientSSESession$_incoming$2.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th = (Throwable) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (th instanceof CancellationException) {
            return Y8.t.f7040a;
        }
        vc.c logger = SSEKt.getLOGGER();
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            logger.trace("Error during SSE session processing: " + th);
        }
        this.this$0.close();
        throw th;
    }
}
