package io.modelcontextprotocol.server;

import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6278a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ JsonSchemaValidator f6279b;

    public /* synthetic */ k(int i) {
        this.f6278a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6278a;
        JsonSchemaValidator jsonSchemaValidator = this.f6279b;
        switch (i) {
            case 0:
                return McpAsyncServer.withStructuredOutputHandling(jsonSchemaValidator, (McpServerFeatures.AsyncToolSpecification) obj);
            default:
                return McpStatelessAsyncServer.withStructuredOutputHandling(jsonSchemaValidator, (McpStatelessServerFeatures.AsyncToolSpecification) obj);
        }
    }
}
