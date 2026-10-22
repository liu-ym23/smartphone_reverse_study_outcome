package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.TypeFactory;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AllOfValidator extends BaseKeywordValidator {
    private final List<Schema> schemas;

    public AllOfValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.ALL_OF, jsonNode, schemaLocation, schema, schemaContext);
        if (!jsonNode.isArray()) {
            throw new SchemaException(error().instanceNode(jsonNode).instanceLocation(schemaLocation.getFragment()).messageKey("type").arguments(TypeFactory.getValueNodeType(jsonNode, this.schemaContext.getSchemaRegistryConfig()).toString(), "array").build());
        }
        int size = jsonNode.size();
        this.schemas = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            this.schemas.add(schemaContext.newSchema(schemaLocation.append(i10), jsonNode.get(i10), schema));
        }
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        preloadSchemas(this.schemas);
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) throws Throwable {
        validate(executionContext, jsonNode, jsonNode2, nodePath, false);
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) throws Throwable {
        if (z10 && jsonNode != null) {
            validate(executionContext, jsonNode, jsonNode2, nodePath, true);
            return;
        }
        int i10 = 0;
        for (Schema schema : this.schemas) {
            executionContext.evaluationPathAddLast(i10);
            try {
                schema.walk(executionContext, jsonNode, jsonNode2, nodePath, false);
                executionContext.evaluationPathRemoveLast();
                i10++;
            } catch (Throwable th) {
                executionContext.evaluationPathRemoveLast();
                throw th;
            }
        }
    }

    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) throws Throwable {
        ExecutionContext executionContext2;
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        NodePath nodePath2;
        int i10 = 0;
        for (Schema schema : this.schemas) {
            executionContext.evaluationPathAddLast(i10);
            if (z10) {
                executionContext2 = executionContext;
                jsonNode3 = jsonNode;
                jsonNode4 = jsonNode2;
                nodePath2 = nodePath;
                try {
                    schema.walk(executionContext2, jsonNode3, jsonNode4, nodePath2, true);
                    executionContext2.evaluationPathRemoveLast();
                    i10++;
                    executionContext = executionContext2;
                    jsonNode = jsonNode3;
                    jsonNode2 = jsonNode4;
                    nodePath = nodePath2;
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
                    i10++;
                    executionContext = executionContext2;
                    jsonNode = jsonNode3;
                    jsonNode2 = jsonNode4;
                    nodePath = nodePath2;
                } catch (Throwable th3) {
                    th = th3;
                    executionContext2 = executionContext;
                    Throwable th22 = th;
                    executionContext2.evaluationPathRemoveLast();
                    throw th22;
                }
            }
        }
    }
}
