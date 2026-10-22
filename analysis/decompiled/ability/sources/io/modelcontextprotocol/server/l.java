package io.modelcontextprotocol.server;

import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4712a;
    public final /* synthetic */ JsonSchemaValidator b;

    public /* synthetic */ l(JsonSchemaValidator jsonSchemaValidator, int i) {
        this.f4712a = i;
        this.b = jsonSchemaValidator;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4712a;
        JsonSchemaValidator jsonSchemaValidator = this.b;
        switch (i) {
            case 0:
                return McpAsyncServer.withStructuredOutputHandling(jsonSchemaValidator, (McpServerFeatures.AsyncToolSpecification) obj);
            default:
                return McpStatelessAsyncServer.withStructuredOutputHandling(jsonSchemaValidator, (McpStatelessServerFeatures.AsyncToolSpecification) obj);
        }
    }
}
