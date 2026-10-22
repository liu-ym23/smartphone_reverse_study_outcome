package a8;

import com.stepos.agentsafetycenter.mcp.service.AbilityService;
import d2.y;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerTransport;
import io.modelcontextprotocol.spec.McpStreamableServerTransport;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.function.Function;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f233a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f234b;

    public /* synthetic */ c(int i) {
        this.f233a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f233a;
        Object obj2 = this.f234b;
        switch (i) {
            case 0:
                return new MessageFormat((String) obj, (Locale) obj2);
            case 1:
                int i3 = AbilityService.f2507g;
                return (McpSchema.CallToolResult) ((y) obj2).invoke(obj);
            case 2:
                return ((McpClientTransport) obj2).sendMessage((McpSchema.JSONRPCResponse) obj);
            case 3:
                return ((McpClientSession) obj2).lambda$new$0((Mono) obj);
            case 4:
                return ((McpServerTransport) obj2).sendMessage((McpSchema.JSONRPCResponse) obj);
            case 5:
                return ((McpStreamableServerTransport) obj2).sendMessage((McpSchema.JSONRPCResponse) obj);
            case 6:
                return ((Mono) obj2).thenReturn(obj);
            default:
                y7.a aVar = (y7.a) obj2;
                if (aVar.f15929a.equals((String) obj)) {
                    return aVar;
                }
                return null;
        }
    }
}
