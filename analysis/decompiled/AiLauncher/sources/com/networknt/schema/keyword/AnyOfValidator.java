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
public class AnyOfValidator extends BaseKeywordValidator {
    private final List<Schema> schemas;

    public AnyOfValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.ANY_OF, jsonNode, schemaLocation, schema, schemaContext);
        if (!jsonNode.isArray()) {
            throw new SchemaException(error().instanceNode(jsonNode).instanceLocation(schemaLocation.getFragment()).messageKey("type").arguments(TypeFactory.getValueNodeType(jsonNode, this.schemaContext.getSchemaRegistryConfig()).toString(), "array").build());
        }
        int size = jsonNode.size();
        this.schemas = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            this.schemas.add(schemaContext.newSchema(schemaLocation.append(i10), jsonNode.get(i10), schema));
        }
    }

    public boolean canShortCircuit(ExecutionContext executionContext) {
        if (hasUnevaluatedItemsInEvaluationPath(executionContext) || hasUnevaluatedPropertiesInEvaluationPath(executionContext)) {
            return false;
        }
        return !executionContext.getExecutionConfig().isAnnotationCollectionEnabled();
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        preloadSchemas(this.schemas);
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        validate(executionContext, jsonNode, jsonNode2, nodePath, false);
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void validate(com.networknt.schema.ExecutionContext r17, com.fasterxml.jackson.databind.JsonNode r18, com.fasterxml.jackson.databind.JsonNode r19, com.networknt.schema.path.NodePath r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.networknt.schema.keyword.AnyOfValidator.validate(com.networknt.schema.ExecutionContext, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.databind.JsonNode, com.networknt.schema.path.NodePath, boolean):void");
    }
}
