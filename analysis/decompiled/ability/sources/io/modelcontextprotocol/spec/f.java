package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import reactor.core.publisher.SynchronousSink;
import reactor.util.context.ReactorContextAccessor;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4744a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ f(int i, Object obj, Object obj2) {
        this.f4744a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f4744a) {
            case 0:
                ((McpClientSession) this.c).lambda$sendRequest$12((TypeRef) this.b, (McpSchema.JSONRPCResponse) obj, (SynchronousSink) obj2);
                break;
            case 1:
                ((McpServerSession) this.c).lambda$sendRequest$3((TypeRef) this.b, (McpSchema.JSONRPCResponse) obj, (SynchronousSink) obj2);
                break;
            case 2:
                ((McpStreamableServerSession.McpStreamableServerSessionStream) this.c).lambda$sendRequest$4((TypeRef) this.b, (McpSchema.JSONRPCResponse) obj, (SynchronousSink) obj2);
                break;
            default:
                ReactorContextAccessor.lambda$readValues$0((Predicate) this.c, (Map) this.b, obj, obj2);
                break;
        }
    }
}
