package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.common.McpTransportContext;
import java.util.function.Function;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6298a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpTransportContext f6299b;

    public /* synthetic */ d(int i) {
        this.f6298a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6298a;
        McpTransportContext mcpTransportContext = this.f6299b;
        Context context = (Context) obj;
        switch (i) {
            case 0:
                return HttpServletSseServerTransportProvider.lambda$doPost$3(mcpTransportContext, context);
            case 1:
                return HttpServletStatelessServerTransport.lambda$doPost$1(mcpTransportContext, context);
            case 2:
                return HttpServletStatelessServerTransport.lambda$doPost$2(mcpTransportContext, context);
            case 3:
                return HttpServletStreamableServerTransportProvider.lambda$doDelete$12(mcpTransportContext, context);
            case 4:
                return HttpServletStreamableServerTransportProvider.lambda$doGet$6(mcpTransportContext, context);
            case 5:
                return HttpServletStreamableServerTransportProvider.lambda$doGet$7(mcpTransportContext, context);
            case 6:
                return HttpServletStreamableServerTransportProvider.lambda$doPost$9(mcpTransportContext, context);
            case 7:
                return HttpServletStreamableServerTransportProvider.lambda$doPost$10(mcpTransportContext, context);
            default:
                return HttpServletStreamableServerTransportProvider.lambda$doPost$11(mcpTransportContext, context);
        }
    }
}
