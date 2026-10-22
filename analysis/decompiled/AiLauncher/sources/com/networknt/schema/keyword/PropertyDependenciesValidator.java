package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class PropertyDependenciesValidator extends BaseKeywordValidator implements KeywordValidator {
    private final Map<String, Map<String, Schema>> propertyDependencies;

    public PropertyDependenciesValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.PROPERTY_DEPENDENCIES, jsonNode, schemaLocation, schema, schemaContext);
        Set<Map.Entry<String, JsonNode>> setProperties = jsonNode.properties();
        this.propertyDependencies = new LinkedHashMap(setProperties.size());
        for (Map.Entry<String, JsonNode> entry : setProperties) {
            String key = entry.getKey();
            SchemaLocation schemaLocationAppend = schemaLocation.append(key);
            for (Map.Entry<String, JsonNode> entry2 : entry.getValue().properties()) {
                this.propertyDependencies.computeIfAbsent(key, new Function() { // from class: com.networknt.schema.keyword.l0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return PropertyDependenciesValidator.a((String) obj);
                    }
                }).put(entry2.getKey(), schemaContext.newSchema(schemaLocationAppend.append(entry2.getKey()), entry2.getValue(), schema));
            }
        }
    }

    public static /* synthetic */ Map a(String str) {
        return new LinkedHashMap();
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        Iterator<Map<String, Schema>> it = this.propertyDependencies.values().iterator();
        while (it.hasNext()) {
            Iterator<Schema> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().initializeValidators();
            }
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) throws Throwable {
        validate(executionContext, jsonNode, jsonNode2, nodePath, false);
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) throws Throwable {
        if (z10) {
            validate(executionContext, jsonNode, jsonNode2, nodePath, true);
            return;
        }
        for (Map.Entry<String, Map<String, Schema>> entry : this.propertyDependencies.entrySet()) {
            executionContext.evaluationPathAddLast(entry.getKey());
            try {
                for (Map.Entry<String, Schema> entry2 : entry.getValue().entrySet()) {
                    executionContext.evaluationPathAddLast(entry2.getKey());
                    try {
                        entry2.getValue().walk(executionContext, jsonNode, jsonNode2, nodePath, false);
                        executionContext.evaluationPathRemoveLast();
                    } finally {
                        executionContext.evaluationPathRemoveLast();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) throws Throwable {
        ExecutionContext executionContext2;
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        NodePath nodePath2;
        Map<String, Schema> map;
        for (Map.Entry<String, JsonNode> entry : jsonNode.properties()) {
            String key = entry.getKey();
            String strAsText = entry.getValue().asText();
            if (strAsText == null || (map = this.propertyDependencies.get(key)) == null) {
                executionContext2 = executionContext;
                jsonNode3 = jsonNode;
                jsonNode4 = jsonNode2;
                nodePath2 = nodePath;
            } else {
                executionContext.evaluationPathAddLast(key);
                try {
                    Schema schema = map.get(strAsText);
                    if (schema != null) {
                        executionContext.evaluationPathAddLast(strAsText);
                        if (z10) {
                            executionContext2 = executionContext;
                            jsonNode3 = jsonNode;
                            jsonNode4 = jsonNode2;
                            nodePath2 = nodePath;
                            try {
                                schema.walk(executionContext2, jsonNode3, jsonNode4, nodePath2, true);
                                executionContext2.evaluationPathRemoveLast();
                            } catch (Throwable th) {
                                th = th;
                                Throwable th2 = th;
                                executionContext2.evaluationPathRemoveLast();
                                throw th2;
                            }
                        } else {
                            try {
                                schema.validate(executionContext, jsonNode, jsonNode2, nodePath);
                                executionContext2 = executionContext;
                                jsonNode3 = jsonNode;
                                jsonNode4 = jsonNode2;
                                nodePath2 = nodePath;
                                try {
                                    executionContext2.evaluationPathRemoveLast();
                                } catch (Throwable th3) {
                                    th = th3;
                                    Throwable th4 = th;
                                    executionContext2.evaluationPathRemoveLast();
                                    throw th4;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                executionContext2 = executionContext;
                                Throwable th22 = th;
                                executionContext2.evaluationPathRemoveLast();
                                throw th22;
                            }
                        }
                    } else {
                        executionContext2 = executionContext;
                        jsonNode3 = jsonNode;
                        jsonNode4 = jsonNode2;
                        nodePath2 = nodePath;
                    }
                    executionContext2.evaluationPathRemoveLast();
                } catch (Throwable th6) {
                    th = th6;
                    executionContext2 = executionContext;
                }
            }
            executionContext = executionContext2;
            jsonNode = jsonNode3;
            jsonNode2 = jsonNode4;
            nodePath = nodePath2;
        }
    }
}
