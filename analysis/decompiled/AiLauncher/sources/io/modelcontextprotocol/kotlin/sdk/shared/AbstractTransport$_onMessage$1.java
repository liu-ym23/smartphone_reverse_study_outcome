package io.modelcontextprotocol.kotlin.sdk.shared;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "it", "LY8/t;", "<anonymous>", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport$_onMessage$1", f = "Transport.kt", l = {65, 66}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class AbstractTransport$_onMessage$1 extends SuspendLambda implements p9.p<JSONRPCMessage, InterfaceC4014c<? super Y8.t>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AbstractTransport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTransport$_onMessage$1(AbstractTransport abstractTransport, InterfaceC4014c<? super AbstractTransport$_onMessage$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = abstractTransport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AbstractTransport$_onMessage$1 abstractTransport$_onMessage$1 = new AbstractTransport$_onMessage$1(this.this$0, interfaceC4014c);
        abstractTransport$_onMessage$1.L$0 = obj;
        return abstractTransport$_onMessage$1;
    }

    @Override // p9.p
    public final Object invoke(JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AbstractTransport$_onMessage$1) create(jSONRPCMessage, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
    
        if (r6.invoke(r0, r5) == r1) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = r5.L$0
            io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r0 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r5.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L22
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.C4849c.b(r6)
            goto L4b
        L16:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1e:
            kotlin.C4849c.b(r6)
            goto L36
        L22:
            kotlin.C4849c.b(r6)
            io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport r6 = r5.this$0
            Ua.u r6 = io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport.access$get_onMessageInitialized$p(r6)
            r5.L$0 = r0
            r5.label = r4
            java.lang.Object r6 = r6.a1(r5)
            if (r6 != r1) goto L36
            goto L4a
        L36:
            io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport r6 = r5.this$0
            p9.p r6 = r6.get_onMessage()
            java.lang.Object r2 = g9.h.a(r0)
            r5.L$0 = r2
            r5.label = r3
            java.lang.Object r5 = r6.invoke(r0, r5)
            if (r5 != r1) goto L4b
        L4a:
            return r1
        L4b:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport$_onMessage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
