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
import java.util.function.Function;

/* loaded from: classes2.dex */
public class DependentRequired extends BaseKeywordValidator implements KeywordValidator {
    private final Map<String, List<String>> propertyDependencies;

    public DependentRequired(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.DEPENDENT_REQUIRED, jsonNode, schemaLocation, schema, schemaContext);
        this.propertyDependencies = new HashMap();
        Iterator<String> itFieldNames = jsonNode.fieldNames();
        while (itFieldNames.hasNext()) {
            String next = itFieldNames.next();
            JsonNode jsonNode2 = jsonNode.get(next);
            if (jsonNode2.isArray()) {
                List<String> listComputeIfAbsent = this.propertyDependencies.computeIfAbsent(next, new Function() { // from class: com.networknt.schema.keyword.f
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return DependentRequired.a((String) obj);
                    }
                });
                for (int i10 = 0; i10 < jsonNode2.size(); i10++) {
                    listComputeIfAbsent.add(jsonNode2.get(i10).asText());
                }
            }
        }
    }

    public static /* synthetic */ List a(String str) {
        return new ArrayList();
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        Iterator<String> itFieldNames = jsonNode.fieldNames();
        while (itFieldNames.hasNext()) {
            String next = itFieldNames.next();
            List<String> list = this.propertyDependencies.get(next);
            if (list != null && !list.isEmpty()) {
                for (String str : list) {
                    if (jsonNode.get(str) == null) {
                        executionContext.addError(error().instanceNode(jsonNode).property(next).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(str, next).build());
                    }
                }
            }
        }
    }
}
