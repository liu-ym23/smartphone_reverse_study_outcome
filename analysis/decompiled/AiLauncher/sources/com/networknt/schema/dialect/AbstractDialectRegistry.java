package com.networknt.schema.dialect;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.InvalidSchemaException;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SchemaRegistry;
import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.dialect.Dialect;
import java.util.Map;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public abstract class AbstractDialectRegistry implements DialectRegistry {
    public Dialect loadDialect(String str, SchemaRegistry schemaRegistry) {
        try {
            return loadDialectBuilder(str, schemaRegistry).build();
        } catch (InvalidSchemaException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new InvalidSchemaException(Error.builder().message("Failed to load dialect ''{0}''").arguments(str).build(), e11);
        }
    }

    public Dialect.Builder loadDialectBuilder(String str, SchemaRegistry schemaRegistry) {
        JsonNode jsonNode;
        Schema schema = schemaRegistry.getSchema(SchemaLocation.of(str));
        Dialect.Builder builder = Dialect.builder(str, schema.getSchemaContext().getDialect());
        SpecificationVersion specificationVersion = schema.getSchemaContext().getDialect().getSpecificationVersion();
        if (specificationVersion != null && specificationVersion.getOrder() >= SpecificationVersion.DRAFT_2019_09.getOrder() && (jsonNode = schema.getSchemaNode().get("$vocabulary")) != null) {
            builder.vocabularies(new Consumer() { // from class: com.networknt.schema.dialect.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((Map) obj).clear();
                }
            });
            for (Map.Entry<String, JsonNode> entry : jsonNode.properties()) {
                builder.vocabulary(entry.getKey(), entry.getValue().booleanValue());
            }
        }
        return builder;
    }
}
