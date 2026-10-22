package b8;

import com.stepos.agentsafetycenter.mcp.service.AbilityService;
import com.stepos.mcp.sdk.java.client.AndroidMCPClient;
import com.stepos.mcp.sdk.java.client.IClientDecorator;
import com.stepos.mcp.sdk.java.server.AndroidMCPServer;
import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSession;
import io.modelcontextprotocol.util.KeepAliveScheduler;
import java.util.List;
import java.util.function.Consumer;
import reactor.core.publisher.MonoSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1962c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1963f;

    public /* synthetic */ g0(int i) {
        this.f1962c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f1962c;
        Object obj2 = this.f1963f;
        switch (i) {
            case 0:
                ((w7.f) obj2).a((w7.e) obj);
                break;
            case 1:
                ((AndroidMCPClient) obj2).addDecorator((IClientDecorator) obj);
                break;
            case 2:
                ((IClientDecorator) obj).decorate((McpClient.SyncSpec) obj2);
                break;
            case 3:
                int i3 = AbilityService.f2507g;
                ((d9.b) obj2).invoke(obj);
                break;
            case 4:
                int i10 = AbilityService.f2507g;
                ((d9.b) obj2).invoke(obj);
                break;
            case 5:
                ((McpClientSession) obj2).handle((McpSchema.JSONRPCMessage) obj);
                break;
            case 6:
                ((List) obj2).add((McpSchema.TextContent) obj);
                break;
            case 7:
                ((MonoSink) obj2).error((Throwable) obj);
                break;
            case 8:
                ((KeepAliveScheduler) obj2).lambda$start$2((Long) obj);
                break;
            case 9:
                KeepAliveScheduler.lambda$start$0((McpSession) obj2, (Throwable) obj);
                break;
            default:
                ((AndroidMCPServer) obj2).lambda$initTools$1((McpSchema.Tool) obj);
                break;
        }
    }
}
