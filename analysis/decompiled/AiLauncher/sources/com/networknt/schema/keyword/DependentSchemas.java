package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class DependentSchemas extends BaseKeywordValidator {
    private final Map<String, Schema> schemaDependencies;

    public DependentSchemas(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.DEPENDENT_SCHEMAS, jsonNode, schemaLocation, schema, schemaContext);
        this.schemaDependencies = new HashMap();
        Iterator<String> itFieldNames = jsonNode.fieldNames();
        while (itFieldNames.hasNext()) {
            String next = itFieldNames.next();
            JsonNode jsonNode2 = jsonNode.get(next);
            if (jsonNode2.isObject() || jsonNode2.isBoolean()) {
                this.schemaDependencies.put(next, schemaContext.newSchema(schemaLocation.append(next), jsonNode2, schema));
            }
        }
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        preloadSchemas(this.schemaDependencies.values());
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
        Iterator<Schema> it = this.schemaDependencies.values().iterator();
        while (it.hasNext()) {
            it.next().walk(executionContext, jsonNode, jsonNode2, nodePath, false);
        }
    }

    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) throws Throwable {
        ExecutionContext executionContext2;
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        NodePath nodePath2;
        Iterator<String> itFieldNames = jsonNode.fieldNames();
        while (itFieldNames.hasNext()) {
            String next = itFieldNames.next();
            Schema schema = this.schemaDependencies.get(next);
            if (schema != null) {
                executionContext.evaluationPathAddLast(next);
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
                        executionContext2.evaluationPathRemoveLast();
                    } catch (Throwable th3) {
                        th = th3;
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
            executionContext = executionContext2;
            jsonNode = jsonNode3;
            jsonNode2 = jsonNode4;
            nodePath = nodePath2;
        }
    }
}
