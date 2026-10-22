package io.modelcontextprotocol.kotlin.sdk.shared;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "<unused var>", "LY8/t;", "<anonymous>", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport$onMessage$old$1", f = "Transport.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class AbstractTransport$onMessage$old$1 extends SuspendLambda implements p9.p<JSONRPCMessage, InterfaceC4014c<? super Y8.t>, Object> {
    int label;

    public AbstractTransport$onMessage$old$1(InterfaceC4014c<? super AbstractTransport$onMessage$old$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AbstractTransport$onMessage$old$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AbstractTransport$onMessage$old$1) create(jSONRPCMessage, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return Y8.t.f7040a;
    }
}
