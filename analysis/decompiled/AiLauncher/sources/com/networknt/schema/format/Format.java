package com.networknt.schema.format;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.MessageSourceError;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.keyword.FormatValidator;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.JsonType;
import com.networknt.schema.utils.TypeFactory;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public interface Format {
    default String getMessageKey() {
        return "format";
    }

    String getName();

    default boolean matches(ExecutionContext executionContext, String str) {
        return true;
    }

    default void validate(ExecutionContext executionContext, SchemaContext schemaContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10, Supplier<MessageSourceError.Builder> supplier, FormatValidator formatValidator) {
        if (!z10 || matches(executionContext, schemaContext, jsonNode, jsonNode2, nodePath, z10, formatValidator)) {
            return;
        }
        executionContext.addError(supplier.get().arguments(getName(), jsonNode.asText()).build());
    }

    default boolean matches(ExecutionContext executionContext, SchemaContext schemaContext, String str) {
        return matches(executionContext, str);
    }

    default boolean matches(ExecutionContext executionContext, SchemaContext schemaContext, JsonNode jsonNode) {
        if (TypeFactory.getValueNodeType(jsonNode, schemaContext.getSchemaRegistryConfig()) != JsonType.STRING) {
            return true;
        }
        return matches(executionContext, schemaContext, jsonNode.textValue());
    }

    default boolean matches(ExecutionContext executionContext, SchemaContext schemaContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10, FormatValidator formatValidator) {
        return matches(executionContext, schemaContext, jsonNode);
    }
}
