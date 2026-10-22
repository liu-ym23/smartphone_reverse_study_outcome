package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.JsonType;
import com.networknt.schema.utils.TypeFactory;

/* loaded from: classes2.dex */
public class MaxLengthValidator extends BaseKeywordValidator implements KeywordValidator {
    private final int maxLength;

    public MaxLengthValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.MAX_LENGTH, jsonNode, schemaLocation, schema, schemaContext);
        if (jsonNode == null || !jsonNode.canConvertToExactIntegral()) {
            this.maxLength = Integer.MAX_VALUE;
        } else {
            this.maxLength = jsonNode.intValue();
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (TypeFactory.getValueNodeType(jsonNode, this.schemaContext.getSchemaRegistryConfig()) == JsonType.STRING && jsonNode.textValue().codePointCount(0, jsonNode.textValue().length()) > this.maxLength) {
            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(Integer.valueOf(this.maxLength)).build());
        }
    }
}
