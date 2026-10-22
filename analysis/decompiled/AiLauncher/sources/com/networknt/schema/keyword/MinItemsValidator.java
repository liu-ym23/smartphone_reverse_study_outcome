package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;

/* loaded from: classes2.dex */
public class MinItemsValidator extends BaseKeywordValidator implements KeywordValidator {
    private int min;

    public MinItemsValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.MIN_ITEMS, jsonNode, schemaLocation, schema, schemaContext);
        this.min = 0;
        if (jsonNode.canConvertToExactIntegral()) {
            this.min = jsonNode.intValue();
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (jsonNode.isArray()) {
            if (jsonNode.size() < this.min) {
                executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(Integer.valueOf(this.min), Integer.valueOf(jsonNode.size())).build());
            }
        } else {
            if (!this.schemaContext.getSchemaRegistryConfig().isTypeLoose() || 1 >= this.min) {
                return;
            }
            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(Integer.valueOf(this.min), 1).build());
        }
    }
}
