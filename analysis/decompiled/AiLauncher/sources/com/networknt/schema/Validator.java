package com.networknt.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.walk.Walker;

/* loaded from: classes2.dex */
public interface Validator extends Walker {
    SchemaLocation getSchemaLocation();

    void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath);

    @Override // com.networknt.schema.walk.Walker
    default void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        if (jsonNode != null && z10) {
            validate(executionContext, jsonNode, jsonNode2, nodePath);
        }
    }
}
