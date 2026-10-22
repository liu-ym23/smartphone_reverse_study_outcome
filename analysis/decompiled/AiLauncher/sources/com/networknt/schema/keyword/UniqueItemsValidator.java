package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class UniqueItemsValidator extends BaseKeywordValidator implements KeywordValidator {
    private final boolean unique;

    public UniqueItemsValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.UNIQUE_ITEMS, jsonNode, schemaLocation, schema, schemaContext);
        if (jsonNode.isBoolean()) {
            this.unique = jsonNode.booleanValue();
        } else {
            this.unique = false;
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (this.unique) {
            HashSet hashSet = new HashSet();
            Iterator<JsonNode> it = jsonNode.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next())) {
                    executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).build());
                }
            }
        }
    }
}
