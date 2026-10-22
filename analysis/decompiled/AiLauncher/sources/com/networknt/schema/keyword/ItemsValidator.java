package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SchemaRef;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.SchemaRefs;
import com.networknt.schema.walk.WalkHandler;

/* loaded from: classes2.dex */
public class ItemsValidator extends BaseKeywordValidator {
    private final boolean additionalItems;
    private final int prefixCount;
    private final Schema schema;

    public ItemsValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.ITEMS, jsonNode, schemaLocation, schema, schemaContext);
        JsonNode jsonNode2 = schema.getSchemaNode().get("prefixItems");
        if (jsonNode2 instanceof ArrayNode) {
            this.prefixCount = jsonNode2.size();
        } else {
            if (jsonNode2 != null) {
                throw new IllegalArgumentException("The value of 'prefixItems' must be an array of JSON Schema.");
            }
            this.prefixCount = 0;
        }
        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
            throw new IllegalArgumentException("The value of 'items' MUST be a valid JSON Schema.");
        }
        this.schema = schemaContext.newSchema(schemaLocation, jsonNode, schema);
        this.additionalItems = jsonNode.isBoolean() ? jsonNode.booleanValue() : true;
    }

    private static JsonNode getDefaultNode(Schema schema, ExecutionContext executionContext) {
        SchemaRef schemaRefFrom;
        JsonNode jsonNode = schema.getSchemaNode().get("default");
        return (jsonNode != null || (schemaRefFrom = SchemaRefs.from(schema, executionContext)) == null) ? jsonNode : getDefaultNode(schemaRefFrom.getSchema(), executionContext);
    }

    private void walkSchema(ExecutionContext executionContext, Schema schema, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        WalkHandler itemWalkHandler = executionContext.getWalkConfig().getItemWalkHandler();
        KeywordType keywordType = KeywordType.ITEMS;
        boolean zPreWalk = itemWalkHandler.preWalk(executionContext, keywordType.getValue(), jsonNode, jsonNode2, nodePath, schema, this);
        int size = executionContext.getErrors().size();
        if (zPreWalk) {
            schema.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
        }
        executionContext.getWalkConfig().getItemWalkHandler().postWalk(executionContext, keywordType.getValue(), jsonNode, jsonNode2, nodePath, schema, this, executionContext.getErrors().subList(size, executionContext.getErrors().size()));
    }

    public Schema getSchema() {
        return this.schema;
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        this.schema.initializeValidators();
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (jsonNode.isArray()) {
            int i10 = this.prefixCount;
            boolean z10 = false;
            while (i10 < jsonNode.size()) {
                NodePath nodePathAppend = nodePath.append(i10);
                if (this.additionalItems) {
                    this.schema.validate(executionContext, jsonNode.get(i10), jsonNode2, nodePathAppend);
                } else {
                    executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).index(Integer.valueOf(i10)).arguments(Integer.valueOf(i10)).build());
                }
                i10++;
                z10 = true;
            }
            if (z10) {
                if (hasUnevaluatedItemsInEvaluationPath(executionContext) || collectAnnotations(executionContext)) {
                    executionContext.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword(getKeyword()).value(Boolean.TRUE).build());
                }
            }
        }
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        JsonNode jsonNode3;
        Schema schema;
        if (!(jsonNode instanceof ArrayNode)) {
            walkSchema(executionContext, this.schema, null, jsonNode2, nodePath.append(this.prefixCount), z10);
            return;
        }
        ArrayNode arrayNode = (ArrayNode) jsonNode;
        JsonNode defaultNode = (!executionContext.getWalkConfig().getApplyDefaultsStrategy().shouldApplyArrayDefaults() || (schema = this.schema) == null) ? null : getDefaultNode(schema, executionContext);
        boolean z11 = false;
        int i10 = this.prefixCount;
        while (i10 < jsonNode.size()) {
            JsonNode jsonNode4 = jsonNode.get(i10);
            if (!jsonNode4.isNull() || defaultNode == null) {
                jsonNode3 = jsonNode4;
            } else {
                arrayNode.set(i10, defaultNode);
                jsonNode3 = defaultNode;
            }
            walkSchema(executionContext, this.schema, jsonNode3, jsonNode2, nodePath.append(i10), z10);
            i10++;
            z11 = true;
        }
        if (z11) {
            if (hasUnevaluatedItemsInEvaluationPath(executionContext) || collectAnnotations(executionContext)) {
                executionContext.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword(getKeyword()).value(Boolean.TRUE).build());
            }
        }
    }
}
