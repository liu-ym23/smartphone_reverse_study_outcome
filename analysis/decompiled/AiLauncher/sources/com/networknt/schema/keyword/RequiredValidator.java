package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class RequiredValidator extends BaseKeywordValidator implements KeywordValidator {
    private final List<String> fieldNames;

    public RequiredValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.REQUIRED, jsonNode, schemaLocation, schema, schemaContext);
        if (!jsonNode.isArray()) {
            this.fieldNames = Collections.EMPTY_LIST;
            return;
        }
        this.fieldNames = new ArrayList(jsonNode.size());
        Iterator<JsonNode> it = jsonNode.iterator();
        while (it.hasNext()) {
            this.fieldNames.add(it.next().asText());
        }
    }

    public JsonNode getFieldKeyword(String str, String str2) {
        JsonNode jsonNode;
        JsonNode jsonNode2 = this.parentSchema.getSchemaNode().get(PropertiesValidator.PROPERTY);
        if (jsonNode2 == null || (jsonNode = jsonNode2.get(str)) == null) {
            return null;
        }
        return jsonNode.get(str2);
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        JsonNode fieldKeyword;
        if (jsonNode.isObject()) {
            for (String str : this.fieldNames) {
                if (jsonNode.get(str) == null) {
                    Boolean readOnly = executionContext.getExecutionConfig().getReadOnly();
                    Boolean writeOnly = executionContext.getExecutionConfig().getWriteOnly();
                    Boolean bool = Boolean.TRUE;
                    if (bool.equals(readOnly)) {
                        JsonNode fieldKeyword2 = getFieldKeyword(str, "readOnly");
                        if (fieldKeyword2 == null || !fieldKeyword2.booleanValue()) {
                            executionContext.addError(error().instanceNode(jsonNode).property(str).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(str).build());
                        }
                    } else if (!bool.equals(writeOnly) || (fieldKeyword = getFieldKeyword(str, "writeOnly")) == null || !fieldKeyword.booleanValue()) {
                        executionContext.addError(error().instanceNode(jsonNode).property(str).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(str).build());
                    }
                }
            }
        }
    }
}
