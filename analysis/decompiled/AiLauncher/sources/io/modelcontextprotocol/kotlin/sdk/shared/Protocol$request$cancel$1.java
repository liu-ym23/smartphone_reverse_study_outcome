package io.modelcontextprotocol.kotlin.sdk.shared;

import Ua.InterfaceC1083u;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.CancelledNotification;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification;
import io.modelcontextprotocol.kotlin.sdk.RequestId;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "reason", "LY8/t;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.Protocol$request$cancel$1", f = "Protocol.kt", l = {433}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class Protocol$request$cancel$1 extends SuspendLambda implements p9.p<Throwable, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ RequestId $messageId;
    final /* synthetic */ InterfaceC1083u<T> $result;
    final /* synthetic */ Transport $transport;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Protocol this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Protocol$request$cancel$1(Protocol protocol, RequestId requestId, Transport transport, InterfaceC1083u<T> interfaceC1083u, InterfaceC4014c<? super Protocol$request$cancel$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = protocol;
        this.$messageId = requestId;
        this.$transport = transport;
        this.$result = interfaceC1083u;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        Protocol$request$cancel$1 protocol$request$cancel$1 = new Protocol$request$cancel$1(this.this$0, this.$messageId, this.$transport, this.$result, interfaceC4014c);
        protocol$request$cancel$1.L$0 = obj;
        return protocol$request$cancel$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2;
        Object obj3;
        Throwable th = (Throwable) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Protocol protocol = this.this$0;
            RequestId requestId = this.$messageId;
            do {
                obj2 = protocol._responseHandlers;
            } while (!Protocol._responseHandlers$FU.compareAndSet(protocol, obj2, ((Pa.d) obj2).remove((Pa.d) requestId)));
            Protocol protocol2 = this.this$0;
            RequestId requestId2 = this.$messageId;
            do {
                obj3 = protocol2._progressHandlers;
            } while (!Protocol._progressHandlers$FU.compareAndSet(protocol2, obj3, ((Pa.d) obj3).remove((Pa.d) requestId2)));
            RequestId requestId3 = this.$messageId;
            String message = th.getMessage();
            if (message == null) {
                message = "Unknown";
            }
            CancelledNotification cancelledNotification = new CancelledNotification(requestId3, message, null, 4, null);
            String value = cancelledNotification.getMethod().getValue();
            AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
            mcpJson.getSerializersModule();
            JSONRPCNotification jSONRPCNotification = new JSONRPCNotification(value, mcpJson.d(CancelledNotification.INSTANCE.serializer(), cancelledNotification), (String) null, 4, (kotlin.jvm.internal.i) null);
            Transport transport = this.$transport;
            this.L$0 = th;
            this.L$1 = g9.h.a(cancelledNotification);
            this.L$2 = g9.h.a(jSONRPCNotification);
            this.label = 1;
            if (transport.send(jSONRPCNotification, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.$result.e(th);
        return Y8.t.f7040a;
    }

    @Override // p9.p
    public final Object invoke(Throwable th, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((Protocol$request$cancel$1) create(th, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }
}
