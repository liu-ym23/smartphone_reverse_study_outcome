package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class DependenciesValidator extends BaseKeywordValidator implements KeywordValidator {
    private final Map<String, List<String>> propertyDeps;
    private final Map<String, Schema> schemaDeps;

    public DependenciesValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.DEPENDENCIES, jsonNode, schemaLocation, schema, schemaContext);
        this.propertyDeps = new HashMap();
        this.schemaDeps = new HashMap();
        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
        while (itFields.hasNext()) {
            Map.Entry<String, JsonNode> next = itFields.next();
            String key = next.getKey();
            JsonNode value = next.getValue();
            if (value.isArray()) {
                List<String> arrayList = this.propertyDeps.get(key);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.propertyDeps.put(key, arrayList);
                }
                for (int i10 = 0; i10 < value.size(); i10++) {
                    arrayList.add(value.get(i10).asText());
                }
            } else if (value.isObject() || value.isBoolean()) {
                this.schemaDeps.put(key, schemaContext.newSchema(schemaLocation.append(key), value, schema));
            }
        }
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        preloadSchemas(this.schemaDeps.values());
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        Iterator<String> itFieldNames = jsonNode.fieldNames();
        while (itFieldNames.hasNext()) {
            String next = itFieldNames.next();
            List<String> list = this.propertyDeps.get(next);
            if (list != null && !list.isEmpty()) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (jsonNode.get(it.next()) == null) {
                        executionContext.addError(error().instanceNode(jsonNode).property(next).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(this.propertyDeps.toString()).build());
                    }
                }
            }
            Schema schema = this.schemaDeps.get(next);
            if (schema != null) {
                executionContext.evaluationPathAddLast(next);
                try {
                    schema.validate(executionContext, jsonNode, jsonNode2, nodePath);
                } finally {
                    executionContext.evaluationPathRemoveLast();
                }
            }
        }
    }
}
