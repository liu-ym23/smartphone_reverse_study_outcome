package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;

/* loaded from: classes2.dex */
public class MaxItemsValidator extends BaseKeywordValidator implements KeywordValidator {
    private final int max;

    public MaxItemsValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.MAX_ITEMS, jsonNode, schemaLocation, schema, schemaContext);
        if (jsonNode.canConvertToExactIntegral()) {
            this.max = jsonNode.intValue();
        } else {
            this.max = 0;
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (jsonNode.isArray()) {
            if (jsonNode.size() > this.max) {
                executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(Integer.valueOf(this.max), Integer.valueOf(jsonNode.size())).build());
            }
        } else {
            if (!this.schemaContext.getSchemaRegistryConfig().isTypeLoose() || 1 <= this.max) {
                return;
            }
            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(Integer.valueOf(this.max), 1).build());
        }
    }
}
