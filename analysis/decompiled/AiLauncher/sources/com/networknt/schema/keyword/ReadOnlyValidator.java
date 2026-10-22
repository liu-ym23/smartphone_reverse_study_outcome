package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;

/* loaded from: classes2.dex */
public class ReadOnlyValidator extends BaseKeywordValidator {
    private static final vc.c logger = vc.e.l(ReadOnlyValidator.class);

    public ReadOnlyValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.READ_ONLY, jsonNode, schemaLocation, schema, schemaContext);
        logger.a("Loaded ReadOnlyValidator for property {} as {}", schema, "read mode");
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (Boolean.TRUE.equals(executionContext.getExecutionConfig().getReadOnly())) {
            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).build());
        }
    }
}
