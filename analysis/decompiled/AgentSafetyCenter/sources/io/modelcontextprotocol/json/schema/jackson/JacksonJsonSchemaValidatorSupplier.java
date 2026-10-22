package io.modelcontextprotocol.json.schema.jackson;

import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.json.schema.JsonSchemaValidatorSupplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class JacksonJsonSchemaValidatorSupplier implements JsonSchemaValidatorSupplier {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Supplier
    public JsonSchemaValidator get() {
        return new DefaultJsonSchemaValidator();
    }
}
