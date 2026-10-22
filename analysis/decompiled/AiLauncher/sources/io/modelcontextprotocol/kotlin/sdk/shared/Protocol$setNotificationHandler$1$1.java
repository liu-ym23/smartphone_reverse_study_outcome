package io.modelcontextprotocol.kotlin.sdk.shared;

import Ua.Q;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification;
import io.modelcontextprotocol.kotlin.sdk.Notification;
import io.modelcontextprotocol.kotlin.sdk.TypesKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;", "it", "LY8/t;", "<anonymous>", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.Protocol$setNotificationHandler$1$1", f = "Protocol.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class Protocol$setNotificationHandler$1$1 extends SuspendLambda implements p9.p<JSONRPCNotification, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC5074l<T, Q<Y8.t>> $handler;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Protocol$setNotificationHandler$1$1(InterfaceC5074l<? super T, ? extends Q<Y8.t>> interfaceC5074l, InterfaceC4014c<? super Protocol$setNotificationHandler$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$handler = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        Protocol$setNotificationHandler$1$1 protocol$setNotificationHandler$1$1 = new Protocol$setNotificationHandler$1$1(this.$handler, interfaceC4014c);
        protocol$setNotificationHandler$1$1.L$0 = obj;
        return protocol$setNotificationHandler$1$1;
    }

    @Override // p9.p
    public final Object invoke(JSONRPCNotification jSONRPCNotification, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((Protocol$setNotificationHandler$1$1) create(jSONRPCNotification, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        JSONRPCNotification jSONRPCNotification = (JSONRPCNotification) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        InterfaceC5074l<T, Q<Y8.t>> interfaceC5074l = this.$handler;
        Notification notificationFromJSON = TypesKt.fromJSON(jSONRPCNotification);
        kotlin.jvm.internal.p.g(notificationFromJSON, "null cannot be cast to non-null type T of io.modelcontextprotocol.kotlin.sdk.shared.Protocol.setNotificationHandler");
        interfaceC5074l.invoke(notificationFromJSON);
        return Y8.t.f7040a;
    }
}
