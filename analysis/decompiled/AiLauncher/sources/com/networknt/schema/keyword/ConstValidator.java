package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;

/* loaded from: classes2.dex */
public class ConstValidator extends BaseKeywordValidator implements KeywordValidator {
    public ConstValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.CONST, jsonNode, schemaLocation, schema, schemaContext);
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (this.schemaNode.isNumber() && jsonNode.isNumber()) {
            if (this.schemaNode.decimalValue().compareTo(jsonNode.decimalValue()) != 0) {
                executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(this.schemaNode.asText(), jsonNode.asText()).build());
            }
        } else {
            if (this.schemaNode.equals(jsonNode)) {
                return;
            }
            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(this.schemaNode.asText(), jsonNode.asText()).build());
        }
    }
}
