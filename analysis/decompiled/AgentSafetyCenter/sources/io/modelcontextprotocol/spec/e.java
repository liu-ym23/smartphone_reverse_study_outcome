package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import reactor.core.publisher.SynchronousSink;
import reactor.util.context.ReactorContextAccessor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6357c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6358f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6359g;

    public /* synthetic */ e(int i) {
        this.f6357c = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f6357c) {
            case 0:
                ((McpClientSession) this.f6359g).lambda$sendRequest$12((TypeRef) this.f6358f, (McpSchema.JSONRPCResponse) obj, (SynchronousSink) obj2);
                break;
            case 1:
                ((McpServerSession) this.f6359g).lambda$sendRequest$3((TypeRef) this.f6358f, (McpSchema.JSONRPCResponse) obj, (SynchronousSink) obj2);
                break;
            case 2:
                ((McpStreamableServerSession.McpStreamableServerSessionStream) this.f6359g).lambda$sendRequest$4((TypeRef) this.f6358f, (McpSchema.JSONRPCResponse) obj, (SynchronousSink) obj2);
                break;
            default:
                ReactorContextAccessor.lambda$readValues$0((Predicate) this.f6359g, (Map) this.f6358f, obj, obj2);
                break;
        }
    }
}
