package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.JsonNodeTypes;
import com.networknt.schema.utils.JsonType;
import com.networknt.schema.utils.TypeFactory;

/* loaded from: classes2.dex */
public class TypeValidator extends BaseKeywordValidator {
    private final JsonType schemaType;
    private final UnionTypeValidator unionTypeValidator;

    public TypeValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.TYPE, jsonNode, schemaLocation, schema, schemaContext);
        JsonType schemaNodeType = TypeFactory.getSchemaNodeType(jsonNode);
        this.schemaType = schemaNodeType;
        if (schemaNodeType == JsonType.UNION) {
            this.unionTypeValidator = new UnionTypeValidator(schemaLocation, jsonNode, schema, schemaContext);
        } else {
            this.unionTypeValidator = null;
        }
    }

    public boolean equalsToSchemaType(JsonNode jsonNode, ExecutionContext executionContext) {
        return JsonNodeTypes.equalsToSchemaType(jsonNode, this.schemaType, this.parentSchema, this.schemaContext, executionContext);
    }

    public JsonType getSchemaType() {
        return this.schemaType;
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (this.schemaType == JsonType.UNION) {
            this.unionTypeValidator.validate(executionContext, jsonNode, jsonNode2, nodePath);
        } else {
            if (equalsToSchemaType(jsonNode, executionContext)) {
                return;
            }
            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(TypeFactory.getValueNodeType(jsonNode, this.schemaContext.getSchemaRegistryConfig()).toString(), this.schemaType.toString()).build());
        }
    }
}
