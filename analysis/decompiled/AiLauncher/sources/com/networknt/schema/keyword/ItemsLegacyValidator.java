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
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ItemsLegacyValidator extends BaseKeywordValidator {
    private static final String PROPERTY_ADDITIONAL_ITEMS = "additionalItems";
    private final Boolean additionalItems;
    private final SchemaLocation additionalItemsSchemaLocation;
    private final JsonNode additionalItemsSchemaNode;
    private final Schema additionalSchema;
    private final Schema schema;
    private final List<Schema> tupleSchema;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemsLegacyValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        Schema schemaNewSchema;
        JsonNode jsonNode2;
        JsonNode jsonNode3;
        Schema schema2;
        super(KeywordType.ITEMS_LEGACY, jsonNode, schemaLocation, schema, schemaContext);
        boolean zIsObject = jsonNode.isObject();
        Boolean bool = null;
        if (zIsObject || jsonNode.isBoolean()) {
            schemaNewSchema = schemaContext.newSchema(schemaLocation, jsonNode, schema);
            this.tupleSchema = Collections.EMPTY_LIST;
            jsonNode2 = null;
        } else {
            this.tupleSchema = new ArrayList(jsonNode.size());
            Iterator<JsonNode> it = jsonNode.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                this.tupleSchema.add(schemaContext.newSchema(schemaLocation.append(i10), it.next(), schema));
                i10++;
            }
            JsonNode jsonNode4 = getParentSchema().getSchemaNode().get(PROPERTY_ADDITIONAL_ITEMS);
            if (jsonNode4 != null) {
                if (jsonNode4.isBoolean()) {
                    Boolean boolValueOf = Boolean.valueOf(jsonNode4.asBoolean());
                    jsonNode3 = jsonNode4;
                    schemaNewSchema = null;
                    bool = boolValueOf;
                } else {
                    if (jsonNode4.isObject()) {
                        Schema schemaNewSchema2 = schemaContext.newSchema(schema.getSchemaLocation().append(PROPERTY_ADDITIONAL_ITEMS), jsonNode4, schema);
                        jsonNode3 = jsonNode4;
                        schemaNewSchema = null;
                        schema2 = schemaNewSchema2;
                        this.additionalItems = bool;
                        this.schema = schemaNewSchema;
                        this.additionalSchema = schema2;
                        this.additionalItemsSchemaLocation = schema.getSchemaLocation().append(PROPERTY_ADDITIONAL_ITEMS);
                        this.additionalItemsSchemaNode = jsonNode3;
                    }
                    jsonNode3 = jsonNode4;
                    schemaNewSchema = null;
                }
                schema2 = schemaNewSchema;
                this.additionalItems = bool;
                this.schema = schemaNewSchema;
                this.additionalSchema = schema2;
                this.additionalItemsSchemaLocation = schema.getSchemaLocation().append(PROPERTY_ADDITIONAL_ITEMS);
                this.additionalItemsSchemaNode = jsonNode3;
            }
            schemaNewSchema = null;
            jsonNode2 = null;
        }
        jsonNode3 = jsonNode2;
        schema2 = jsonNode2;
        this.additionalItems = bool;
        this.schema = schemaNewSchema;
        this.additionalSchema = schema2;
        this.additionalItemsSchemaLocation = schema.getSchemaLocation().append(PROPERTY_ADDITIONAL_ITEMS);
        this.additionalItemsSchemaNode = jsonNode3;
    }

    private boolean doValidate(ExecutionContext executionContext, int i10, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        NodePath nodePathAppend = nodePath.append(i10);
        Schema schema = this.schema;
        if (schema != null) {
            schema.validate(executionContext, jsonNode, jsonNode2, nodePathAppend);
            return false;
        }
        List<Schema> list = this.tupleSchema;
        if (list != null) {
            if (i10 < list.size()) {
                executionContext.evaluationPathAddLast(i10);
                try {
                    this.tupleSchema.get(i10).validate(executionContext, jsonNode, jsonNode2, nodePathAppend);
                    return false;
                } finally {
                    executionContext.evaluationPathRemoveLast();
                }
            }
            Boolean bool = this.additionalItems;
            z = (bool != null && bool.booleanValue()) || this.additionalSchema != null;
            if (this.additionalSchema != null) {
                executionContext.evaluationPathRemoveLast();
                executionContext.evaluationPathAddLast(PROPERTY_ADDITIONAL_ITEMS);
                try {
                    this.additionalSchema.validate(executionContext, jsonNode, jsonNode2, nodePathAppend);
                    return z;
                } finally {
                }
            }
            Boolean bool2 = this.additionalItems;
            if (bool2 != null && !bool2.booleanValue()) {
                executionContext.evaluationPathRemoveLast();
                executionContext.evaluationPathAddLast(PROPERTY_ADDITIONAL_ITEMS);
                try {
                    executionContext.addError(error().instanceNode(jsonNode2).instanceLocation(nodePath).keyword(PROPERTY_ADDITIONAL_ITEMS).messageKey(PROPERTY_ADDITIONAL_ITEMS).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.additionalItemsSchemaLocation).schemaNode(this.additionalItemsSchemaNode).locale(executionContext.getExecutionConfig().getLocale()).index(Integer.valueOf(i10)).arguments(Integer.valueOf(i10)).build());
                    return z;
                } finally {
                }
            }
        }
        return z;
    }

    private static JsonNode getDefaultNode(Schema schema, ExecutionContext executionContext) {
        SchemaRef schemaRefFrom;
        JsonNode jsonNode = schema.getSchemaNode().get("default");
        return (jsonNode != null || (schemaRefFrom = SchemaRefs.from(schema, executionContext)) == null) ? jsonNode : getDefaultNode(schemaRefFrom.getSchema(), executionContext);
    }

    private void walkSchema(ExecutionContext executionContext, Schema schema, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10, String str) {
        boolean zEquals = PROPERTY_ADDITIONAL_ITEMS.equals(str);
        if (zEquals) {
            executionContext.evaluationPathRemoveLast();
            executionContext.evaluationPathAddLast(str);
        }
        try {
            boolean zPreWalk = executionContext.getWalkConfig().getItemWalkHandler().preWalk(executionContext, str, jsonNode, jsonNode2, nodePath, schema, this);
            int size = executionContext.getErrors().size();
            if (zPreWalk) {
                schema.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
            }
            executionContext.getWalkConfig().getItemWalkHandler().postWalk(executionContext, str, jsonNode, jsonNode2, nodePath, schema, this, executionContext.getErrors().subList(size, executionContext.getErrors().size()));
            if (zEquals) {
                executionContext.evaluationPathRemoveLast();
                executionContext.evaluationPathAddLast(DidiCardProvider.KEY_ITEMS);
            }
        } finally {
        }
    }

    public Schema getSchema() {
        return this.schema;
    }

    public List<Schema> getTupleSchema() {
        return this.tupleSchema;
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        Schema schema = this.schema;
        if (schema != null) {
            schema.initializeValidators();
        }
        preloadSchemas(this.tupleSchema);
        Schema schema2 = this.additionalSchema;
        if (schema2 != null) {
            schema2.initializeValidators();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // com.networknt.schema.Validator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void validate(com.networknt.schema.ExecutionContext r11, com.fasterxml.jackson.databind.JsonNode r12, com.fasterxml.jackson.databind.JsonNode r13, com.networknt.schema.path.NodePath r14) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.networknt.schema.keyword.ItemsLegacyValidator.validate(com.networknt.schema.ExecutionContext, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.databind.JsonNode, com.networknt.schema.path.NodePath):void");
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        ItemsLegacyValidator itemsLegacyValidator = this;
        ExecutionContext executionContext2 = executionContext;
        boolean zHasUnevaluatedItemsInEvaluationPath = hasUnevaluatedItemsInEvaluationPath(executionContext);
        if (zHasUnevaluatedItemsInEvaluationPath || collectAnnotations(executionContext)) {
            if (itemsLegacyValidator.schema != null) {
                executionContext2.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext2.getEvaluationPath()).schemaLocation(itemsLegacyValidator.schemaLocation).keyword(itemsLegacyValidator.getKeyword()).value(Boolean.TRUE).build());
            } else if (itemsLegacyValidator.tupleSchema != null) {
                int size = jsonNode.isArray() ? jsonNode.size() : 1;
                int size2 = itemsLegacyValidator.tupleSchema.size();
                if (size > size2) {
                    executionContext2.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext2.getEvaluationPath()).schemaLocation(itemsLegacyValidator.schemaLocation).keyword(itemsLegacyValidator.getKeyword()).value(Integer.valueOf(size2)).build());
                } else {
                    executionContext2.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext2.getEvaluationPath()).schemaLocation(itemsLegacyValidator.schemaLocation).keyword(itemsLegacyValidator.getKeyword()).value(Boolean.TRUE).build());
                }
            }
        }
        Schema schema = itemsLegacyValidator.schema;
        int i10 = 0;
        if (schema != null) {
            if (!(jsonNode instanceof ArrayNode)) {
                walkSchema(executionContext, schema, null, jsonNode2, nodePath.append(0), z10, KeywordType.ITEMS_LEGACY.getValue());
                return;
            }
            int iMax = Math.max(1, jsonNode.size());
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            JsonNode defaultNode = executionContext2.getWalkConfig().getApplyDefaultsStrategy().shouldApplyArrayDefaults() ? getDefaultNode(itemsLegacyValidator.schema, executionContext2) : null;
            while (i10 < iMax) {
                JsonNode jsonNode5 = arrayNode.get(i10);
                if (jsonNode5 == null || !jsonNode5.isNull() || defaultNode == null) {
                    jsonNode4 = jsonNode5;
                } else {
                    arrayNode.set(i10, defaultNode);
                    jsonNode4 = defaultNode;
                }
                itemsLegacyValidator.walkSchema(executionContext2, itemsLegacyValidator.schema, jsonNode4, jsonNode2, nodePath.append(i10), z10, KeywordType.ITEMS_LEGACY.getValue());
                i10++;
                itemsLegacyValidator = this;
                executionContext2 = executionContext;
            }
            return;
        }
        List<Schema> list = itemsLegacyValidator.tupleSchema;
        if (list != null) {
            int size3 = list.size();
            for (int i11 = 0; i11 < size3; i11++) {
                if (jsonNode instanceof ArrayNode) {
                    ArrayNode arrayNode2 = (ArrayNode) jsonNode;
                    JsonNode jsonNode6 = arrayNode2.get(i11);
                    JsonNode defaultNode2 = executionContext2.getWalkConfig().getApplyDefaultsStrategy().shouldApplyArrayDefaults() ? getDefaultNode(itemsLegacyValidator.tupleSchema.get(i11), executionContext2) : null;
                    if (jsonNode6 != null && jsonNode6.isNull() && defaultNode2 != null) {
                        arrayNode2.set(i11, defaultNode2);
                        jsonNode6 = defaultNode2;
                    }
                    executionContext2.evaluationPathAddLast(i11);
                    try {
                        itemsLegacyValidator.walkSchema(executionContext2, itemsLegacyValidator.tupleSchema.get(i11), jsonNode6, jsonNode2, nodePath.append(i11), z10, KeywordType.ITEMS_LEGACY.getValue());
                    } finally {
                    }
                } else {
                    executionContext2.evaluationPathAddLast(i11);
                    try {
                        itemsLegacyValidator.walkSchema(executionContext2, itemsLegacyValidator.tupleSchema.get(i11), null, jsonNode2, nodePath.append(i11), z10, KeywordType.ITEMS_LEGACY.getValue());
                    } finally {
                    }
                }
            }
            if (itemsLegacyValidator.additionalSchema != null) {
                int iMax2 = Math.max(1, (jsonNode != null ? jsonNode.size() : 0) - size3);
                boolean z11 = false;
                while (i10 < iMax2) {
                    int i12 = i10 + size3;
                    if (jsonNode instanceof ArrayNode) {
                        ArrayNode arrayNode3 = (ArrayNode) jsonNode;
                        JsonNode jsonNode7 = arrayNode3.get(i12);
                        JsonNode defaultNode3 = executionContext2.getWalkConfig().getApplyDefaultsStrategy().shouldApplyArrayDefaults() ? getDefaultNode(itemsLegacyValidator.additionalSchema, executionContext2) : null;
                        if (jsonNode7 == null || !jsonNode7.isNull() || defaultNode3 == null) {
                            jsonNode3 = jsonNode7;
                        } else {
                            arrayNode3.set(i12, defaultNode3);
                            jsonNode3 = defaultNode3;
                        }
                        itemsLegacyValidator.walkSchema(executionContext2, itemsLegacyValidator.additionalSchema, jsonNode3, jsonNode2, nodePath.append(i12), z10, PROPERTY_ADDITIONAL_ITEMS);
                        if (jsonNode3 != null) {
                            z11 = true;
                        }
                        executionContext2 = executionContext;
                    } else {
                        executionContext2 = executionContext;
                        itemsLegacyValidator.walkSchema(executionContext2, itemsLegacyValidator.additionalSchema, null, jsonNode2, nodePath.append(i12), z10, PROPERTY_ADDITIONAL_ITEMS);
                    }
                    i10++;
                }
                if (z11) {
                    if (zHasUnevaluatedItemsInEvaluationPath || itemsLegacyValidator.collectAnnotations(executionContext2, PROPERTY_ADDITIONAL_ITEMS)) {
                        executionContext2.evaluationPathAddLast(PROPERTY_ADDITIONAL_ITEMS);
                        executionContext2.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext2.getEvaluationPath()).schemaLocation(itemsLegacyValidator.additionalItemsSchemaLocation).keyword(PROPERTY_ADDITIONAL_ITEMS).value(Boolean.TRUE).build());
                    }
                }
            }
        }
    }
}
