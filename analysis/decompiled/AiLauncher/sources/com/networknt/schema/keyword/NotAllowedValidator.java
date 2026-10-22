package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class NotAllowedValidator extends BaseKeywordValidator implements KeywordValidator {
    private final List<String> fieldNames;

    public NotAllowedValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.NOT_ALLOWED, jsonNode, schemaLocation, schema, schemaContext);
        if (!jsonNode.isArray()) {
            this.fieldNames = Collections.EMPTY_LIST;
            return;
        }
        int size = jsonNode.size();
        this.fieldNames = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            this.fieldNames.add(jsonNode.get(i10).asText());
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        for (String str : this.fieldNames) {
            if (jsonNode.get(str) != null) {
                executionContext.addError(error().property(str).instanceNode(jsonNode).evaluationPath(executionContext.getEvaluationPath()).instanceLocation(nodePath.append(str)).locale(executionContext.getExecutionConfig().getLocale()).arguments(str).build());
            }
        }
    }
}
