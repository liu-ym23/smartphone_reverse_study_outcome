package io.modelcontextprotocol.json.schema.jackson;

import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.json.schema.JsonSchemaValidatorSupplier;

/* loaded from: classes4.dex */
public class JacksonJsonSchemaValidatorSupplier implements JsonSchemaValidatorSupplier {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Supplier
    public JsonSchemaValidator get() {
        return new DefaultJsonSchemaValidator();
    }
}
