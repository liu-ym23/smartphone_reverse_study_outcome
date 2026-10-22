package b8;

import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessAsyncServer;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.Iterator;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1990c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1991f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1992g;

    public /* synthetic */ n0(int i) {
        this.f1990c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f1990c) {
            case 0:
                g gVar = (g) this.f1991f;
                w7.f fVar = (w7.f) this.f1992g;
                w7.l lVarD = gVar.f1955e.d();
                w7.a aVar = lVarD.i.f15339a;
                String str = aVar != null ? aVar.f15287a : "";
                if (lVarD.f15330f) {
                    Iterator itDescendingIterator = fVar.f15312g.descendingIterator();
                    while (itDescendingIterator.hasNext()) {
                        w7.l lVar = (w7.l) itDescendingIterator.next();
                        w7.a aVar2 = lVar.i.f15339a;
                        String str2 = aVar2 != null ? aVar2.f15287a : "";
                        if (!str.equals(str2)) {
                            w7.l lVarD2 = lVar.d();
                            if (lVarD2.f15330f) {
                                lVarD = lVarD2;
                            }
                            str = str2;
                        }
                    }
                }
                return lVarD;
            case 1:
                return ((McpAsyncServer) this.f1991f).lambda$addResource$19((McpServerFeatures.AsyncResourceSpecification) this.f1992g);
            case 2:
                return ((McpAsyncServer) this.f1991f).lambda$addResourceTemplate$21((McpServerFeatures.AsyncResourceTemplateSpecification) this.f1992g);
            case 3:
                return ((McpAsyncServer) this.f1991f).lambda$addTool$12((McpServerFeatures.AsyncToolSpecification) this.f1992g);
            case 4:
                return ((McpAsyncServer) this.f1991f).lambda$addPrompt$32((McpServerFeatures.AsyncPromptSpecification) this.f1992g);
            case 5:
                return ((McpAsyncServer) this.f1991f).lambda$asyncInitializeRequestHandler$5((McpSchema.InitializeRequest) this.f1992g);
            case 6:
                return ((McpAsyncServerExchange) this.f1991f).lambda$loggingNotification$3((McpSchema.LoggingMessageNotification) this.f1992g);
            case 7:
                return ((McpStatelessAsyncServer) this.f1991f).lambda$asyncInitializeRequestHandler$1(this.f1992g);
            case 8:
                return ((McpStatelessAsyncServer) this.f1991f).lambda$addPrompt$24((McpStatelessServerFeatures.AsyncPromptSpecification) this.f1992g);
            case 9:
                return ((McpStatelessAsyncServer) this.f1991f).lambda$addResource$11((McpStatelessServerFeatures.AsyncResourceSpecification) this.f1992g);
            case 10:
                return ((McpStatelessAsyncServer) this.f1991f).lambda$addResourceTemplate$13((McpStatelessServerFeatures.AsyncResourceTemplateSpecification) this.f1992g);
            case 11:
                return ((McpStatelessAsyncServer) this.f1991f).lambda$addTool$5((McpStatelessServerFeatures.AsyncToolSpecification) this.f1992g);
            case 12:
                return ((McpClientSession) this.f1991f).lambda$handleIncomingNotification$7((McpSchema.JSONRPCNotification) this.f1992g);
            case 13:
                return ((McpClientSession) this.f1991f).lambda$handleIncomingRequest$6((McpSchema.JSONRPCRequest) this.f1992g);
            default:
                return ((McpStreamableServerSession) this.f1991f).lambda$accept$7((McpSchema.JSONRPCResponse) this.f1992g);
        }
    }
}
