package io.modelcontextprotocol.kotlin.sdk.shared;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.EmptyRequestResult;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCRequest;
import io.modelcontextprotocol.kotlin.sdk.Request;
import io.modelcontextprotocol.kotlin.sdk.RequestResult;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.serialization.KSerializer;
import qb.D;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "request", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest;", "extraHandler", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.Protocol$setRequestHandler$1$1", f = "Protocol.kt", l = {499}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class Protocol$setRequestHandler$1$1 extends SuspendLambda implements p9.q<JSONRPCRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
    final /* synthetic */ p9.q<T, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> $block;
    final /* synthetic */ KSerializer<Object> $serializer;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Protocol$setRequestHandler$1$1(KSerializer<Object> kSerializer, p9.q<? super T, ? super RequestHandlerExtra, ? super InterfaceC4014c<? super RequestResult>, ? extends Object> qVar, InterfaceC4014c<? super Protocol$setRequestHandler$1$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$serializer = kSerializer;
        this.$block = qVar;
    }

    @Override // p9.q
    public final Object invoke(JSONRPCRequest jSONRPCRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
        Protocol$setRequestHandler$1$1 protocol$setRequestHandler$1$1 = new Protocol$setRequestHandler$1$1(this.$serializer, this.$block, interfaceC4014c);
        protocol$setRequestHandler$1$1.L$0 = jSONRPCRequest;
        protocol$setRequestHandler$1$1.L$1 = requestHandlerExtra;
        return protocol$setRequestHandler$1$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        JSONRPCRequest jSONRPCRequest = (JSONRPCRequest) this.L$0;
        RequestHandlerExtra requestHandlerExtra = (RequestHandlerExtra) this.L$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Object objB = ProtocolKt.getMcpJson().b(this.$serializer, jSONRPCRequest.getParams());
            if (objB == null) {
                return new EmptyRequestResult((D) null, 1, (kotlin.jvm.internal.i) null);
            }
            this.L$0 = g9.h.a(jSONRPCRequest);
            this.L$1 = g9.h.a(requestHandlerExtra);
            this.L$2 = g9.h.a(objB);
            this.label = 1;
            obj = this.$block.invoke((Request) objB, requestHandlerExtra, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return (RequestResult) obj;
    }
}
