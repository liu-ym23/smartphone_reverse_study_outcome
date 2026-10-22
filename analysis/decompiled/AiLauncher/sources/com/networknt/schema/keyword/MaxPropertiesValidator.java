package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;

/* loaded from: classes2.dex */
public class MaxPropertiesValidator extends BaseKeywordValidator implements KeywordValidator {
    private final int max;

    public MaxPropertiesValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.MAX_PROPERTIES, jsonNode, schemaLocation, schema, schemaContext);
        if (jsonNode.canConvertToExactIntegral()) {
            this.max = jsonNode.intValue();
        } else {
            this.max = Integer.MAX_VALUE;
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (!jsonNode.isObject() || jsonNode.size() <= this.max) {
            return;
        }
        executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(Integer.valueOf(this.max)).build());
    }
}
