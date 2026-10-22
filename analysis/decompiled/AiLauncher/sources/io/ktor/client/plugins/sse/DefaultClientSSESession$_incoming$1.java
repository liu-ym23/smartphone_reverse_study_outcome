package io.ktor.client.plugins.sse;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.sse.ServerSentEvent;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LXa/c;", "Lio/ktor/sse/ServerSentEvent;", "LY8/t;", "<anonymous>", "(LXa/c;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$1", f = "DefaultClientSSESession.kt", l = {53, 59, 63}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class DefaultClientSSESession$_incoming$1 extends SuspendLambda implements p9.p<Xa.c<? super ServerSentEvent>, InterfaceC4014c<? super Y8.t>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DefaultClientSSESession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultClientSSESession$_incoming$1(DefaultClientSSESession defaultClientSSESession, InterfaceC4014c<? super DefaultClientSSESession$_incoming$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = defaultClientSSESession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        DefaultClientSSESession$_incoming$1 defaultClientSSESession$_incoming$1 = new DefaultClientSSESession$_incoming$1(this.this$0, interfaceC4014c);
        defaultClientSSESession$_incoming$1.L$0 = obj;
        return defaultClientSSESession$_incoming$1;
    }

    @Override // p9.p
    public final Object invoke(Xa.c<? super ServerSentEvent> cVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((DefaultClientSSESession$_incoming$1) create(cVar, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ac, code lost:
    
        if (r8.doReconnection(r7) == r1) goto L38;
     */
    /* JADX WARN: Path cross not found for [B:31:0x007e, B:15:0x003a], limit reached: 38 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006c -> B:15:0x003a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007c -> B:15:0x003a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0095 -> B:15:0x003a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ac -> B:13:0x002e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00af -> B:13:0x002e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            Xa.c r0 = (Xa.c) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r7.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L2b
            if (r2 == r6) goto L27
            if (r2 == r5) goto L1f
            if (r2 != r4) goto L17
            goto L2b
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1f:
            java.lang.Object r2 = r7.L$1
            io.ktor.sse.ServerSentEvent r2 = (io.ktor.sse.ServerSentEvent) r2
            kotlin.C4849c.b(r8)
            goto L3a
        L27:
            kotlin.C4849c.b(r8)
            goto L59
        L2b:
            kotlin.C4849c.b(r8)
        L2e:
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            kotlin.coroutines.d r8 = r8.getCoroutineContext()
            boolean r8 = Ua.C1086v0.r(r8)
            if (r8 == 0) goto Lb6
        L3a:
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            kotlin.coroutines.d r8 = r8.getCoroutineContext()
            boolean r8 = Ua.C1086v0.r(r8)
            if (r8 == 0) goto L98
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            io.ktor.utils.io.ByteReadChannel r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getInput$p(r8)
            r7.L$0 = r0
            r7.L$1 = r3
            r7.label = r6
            java.lang.Object r8 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$tryParseEvent(r8, r2, r7)
            if (r8 != r1) goto L59
            goto Lae
        L59:
            io.ktor.sse.ServerSentEvent r8 = (io.ktor.sse.ServerSentEvent) r8
            if (r8 != 0) goto L5e
            goto L98
        L5e:
            io.ktor.client.plugins.sse.DefaultClientSSESession r2 = r7.this$0
            boolean r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$isCommentsEvent(r2, r8)
            if (r2 == 0) goto L6e
            io.ktor.client.plugins.sse.DefaultClientSSESession r2 = r7.this$0
            boolean r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getShowCommentEvents$p(r2)
            if (r2 == 0) goto L3a
        L6e:
            io.ktor.client.plugins.sse.DefaultClientSSESession r2 = r7.this$0
            boolean r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$isRetryEvent(r2, r8)
            if (r2 == 0) goto L7e
            io.ktor.client.plugins.sse.DefaultClientSSESession r2 = r7.this$0
            boolean r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getShowRetryEvents$p(r2)
            if (r2 == 0) goto L3a
        L7e:
            io.ktor.client.plugins.sse.DefaultClientSSESession r2 = r7.this$0
            io.ktor.client.plugins.sse.BodyBuffer r2 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getBodyBuffer$p(r2)
            r2.appendEvent(r8)
            r7.L$0 = r0
            java.lang.Object r2 = g9.h.a(r8)
            r7.L$1 = r2
            r7.label = r5
            java.lang.Object r8 = r0.emit(r8, r7)
            if (r8 != r1) goto L3a
            goto Lae
        L98:
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            boolean r8 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getNeedToReconnect$p(r8)
            if (r8 == 0) goto Laf
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            r7.L$0 = r0
            r7.L$1 = r3
            r7.label = r4
            java.lang.Object r8 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$doReconnection(r8, r7)
            if (r8 != r1) goto L2e
        Lae:
            return r1
        Laf:
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            io.ktor.client.plugins.sse.DefaultClientSSESession.access$close(r8)
            goto L2e
        Lb6:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
