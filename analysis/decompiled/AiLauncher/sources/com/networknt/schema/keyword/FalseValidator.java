package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;

/* loaded from: classes2.dex */
public class FalseValidator extends BaseKeywordValidator implements KeywordValidator {
    public FalseValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.FALSE, jsonNode, schemaLocation, schema, schemaContext);
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(executionContext.getEvaluationPath().getParent().getName(-1)).build());
    }
}
