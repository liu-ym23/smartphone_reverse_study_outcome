package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;

/* loaded from: classes2.dex */
public class MinPropertiesValidator extends BaseKeywordValidator implements KeywordValidator {
    protected final int min;

    public MinPropertiesValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.MIN_PROPERTIES, jsonNode, schemaLocation, schema, schemaContext);
        if (jsonNode.canConvertToExactIntegral()) {
            this.min = jsonNode.intValue();
        } else {
            this.min = 0;
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (!jsonNode.isObject() || jsonNode.size() >= this.min) {
            return;
        }
        executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(Integer.valueOf(this.min)).build());
    }
}
