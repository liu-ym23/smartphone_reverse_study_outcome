package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;

/* loaded from: classes2.dex */
public class WriteOnlyValidator extends BaseKeywordValidator {
    private static final vc.c logger = vc.e.l(WriteOnlyValidator.class);

    public WriteOnlyValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.WRITE_ONLY, jsonNode, schemaLocation, schema, schemaContext);
        logger.a("Loaded WriteOnlyValidator for property {} as {}", schema, "write mode");
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (Boolean.TRUE.equals(executionContext.getExecutionConfig().getWriteOnly())) {
            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).build());
        }
    }
}
