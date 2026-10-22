package reactor.util.retry;

import com.stepos.mcp.sdk.base.BaseMCPService;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import xb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10921c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10922f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f10923g;

    public /* synthetic */ a(int i) {
        this.f10921c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f10921c) {
            case 0:
                return ((RetryBackoffSpec) this.f10922f).lambda$doAfterRetryAsync$2((Function) this.f10923g, (Retry.RetrySignal) obj, (Mono) obj2);
            case 1:
                return ((RetryBackoffSpec) this.f10922f).lambda$doBeforeRetryAsync$1((Function) this.f10923g, (Retry.RetrySignal) obj, (Mono) obj2);
            default:
                return BaseMCPService.addTool$lambda$0((BaseMCPService) this.f10922f, (q) this.f10923g, (McpAsyncServerExchange) obj, (McpSchema.CallToolRequest) obj2);
        }
    }
}
