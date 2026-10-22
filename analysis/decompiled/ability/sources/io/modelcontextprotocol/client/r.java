package io.modelcontextprotocol.client;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpNotificationHandler;
import io.modelcontextprotocol.server.McpRequestHandler;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.function.Function;
import reactor.util.context.ContextView;
import z3.C2163h;

/* loaded from: classes2.dex */
public final /* synthetic */ class r implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4646a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ r(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f4646a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4646a) {
            case 0:
                return McpAsyncClient.lambda$new$19((Duration) this.b, (McpClientTransport) this.c, (HashMap) this.d, (HashMap) this.e, (ContextView) obj);
            case 1:
                return ((McpClientSession) this.b).lambda$sendRequest$11((String) this.c, (String) this.d, this.e, (ContextView) obj);
            case 2:
                return ((McpServerSession) this.b).lambda$handleIncomingNotification$11((McpNotificationHandler) this.c, (McpTransportContext) this.d, (McpSchema.JSONRPCNotification) this.e, (McpAsyncServerExchange) obj);
            case 3:
                return ((McpServerSession) this.b).lambda$handleIncomingRequest$7((McpRequestHandler) this.c, (McpTransportContext) this.d, (McpSchema.JSONRPCRequest) this.e, (McpAsyncServerExchange) obj);
            default:
                C2163h c2163h = (C2163h) this.b;
                A3.a aVar = (A3.a) this.d;
                u3.f fVar = (u3.f) this.e;
                u3.g gVarJ = c2163h.j();
                gVarJ.getClass();
                gVarJ.d = aVar;
                gVarJ.b = fVar.f;
                String str = ((z3.y) obj).f6954a;
                gVarJ.i = str;
                gVarJ.k = (Locale) fVar.f6698a.f177a;
                gVarJ.f6696a = str;
                gVarJ.e = new Object[]{c2163h.e.g.toString()};
                return gVarJ.a();
        }
    }
}
