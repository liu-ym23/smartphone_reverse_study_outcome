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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class PrefixItemsValidator extends BaseKeywordValidator {
    private final List<Schema> tupleSchema;

    public PrefixItemsValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.PREFIX_ITEMS, jsonNode, schemaLocation, schema, schemaContext);
        if (!(jsonNode instanceof ArrayNode) || jsonNode.isEmpty()) {
            throw new IllegalArgumentException("The value of 'prefixItems' MUST be a non-empty array of valid JSON Schemas.");
        }
        this.tupleSchema = new ArrayList(jsonNode.size());
        Iterator<JsonNode> it = jsonNode.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            this.tupleSchema.add(schemaContext.newSchema(schemaLocation.append(i10), it.next(), schema));
            i10++;
        }
    }

    private void doWalk(ExecutionContext executionContext, int i10, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        walkSchema(executionContext, i10, this.tupleSchema.get(i10), jsonNode, jsonNode2, nodePath.append(i10), z10);
    }

    private static JsonNode getDefaultNode(Schema schema, ExecutionContext executionContext) {
        SchemaRef schemaRefFrom;
        JsonNode jsonNode = schema.getSchemaNode().get("default");
        return (jsonNode != null || (schemaRefFrom = SchemaRefs.from(schema, executionContext)) == null) ? jsonNode : getDefaultNode(schemaRefFrom.getSchema(), executionContext);
    }

    private void walkSchema(ExecutionContext executionContext, int i10, Schema schema, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        WalkHandler itemWalkHandler = executionContext.getWalkConfig().getItemWalkHandler();
        KeywordType keywordType = KeywordType.PREFIX_ITEMS;
        boolean zPreWalk = itemWalkHandler.preWalk(executionContext, keywordType.getValue(), jsonNode, jsonNode2, nodePath, schema, this);
        int size = executionContext.getErrors().size();
        if (zPreWalk) {
            executionContext.evaluationPathAddLast(i10);
            try {
                schema.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
            } finally {
                executionContext.evaluationPathRemoveLast();
            }
        }
        executionContext.getWalkConfig().getItemWalkHandler().postWalk(executionContext, keywordType.getValue(), jsonNode, jsonNode2, nodePath, schema, this, executionContext.getErrors().subList(size, executionContext.getErrors().size()));
    }

    public List<Schema> getTupleSchema() {
        return this.tupleSchema;
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        preloadSchemas(this.tupleSchema);
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (jsonNode.isArray()) {
            int iMin = Math.min(jsonNode.size(), this.tupleSchema.size());
            for (int i10 = 0; i10 < iMin; i10++) {
                NodePath nodePathAppend = nodePath.append(i10);
                executionContext.evaluationPathAddLast(i10);
                try {
                    this.tupleSchema.get(i10).validate(executionContext, jsonNode.get(i10), jsonNode2, nodePathAppend);
                    executionContext.evaluationPathRemoveLast();
                } catch (Throwable th) {
                    executionContext.evaluationPathRemoveLast();
                    throw th;
                }
            }
            if (hasUnevaluatedItemsInEvaluationPath(executionContext) || collectAnnotations(executionContext)) {
                int size = jsonNode.isArray() ? jsonNode.size() : 1;
                int size2 = this.tupleSchema.size();
                if (size > size2) {
                    executionContext.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword(getKeyword()).value(Integer.valueOf(size2)).build());
                } else {
                    executionContext.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword(getKeyword()).value(Boolean.TRUE).build());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void walk(com.networknt.schema.ExecutionContext r11, com.fasterxml.jackson.databind.JsonNode r12, com.fasterxml.jackson.databind.JsonNode r13, com.networknt.schema.path.NodePath r14, boolean r15) {
        /*
            r10 = this;
            boolean r1 = r12 instanceof com.fasterxml.jackson.databind.node.ArrayNode
            r2 = 0
            if (r1 == 0) goto Lcf
            r8 = r12
            com.fasterxml.jackson.databind.node.ArrayNode r8 = (com.fasterxml.jackson.databind.node.ArrayNode) r8
            java.util.List<com.networknt.schema.Schema> r1 = r10.tupleSchema
            int r9 = r1.size()
        Le:
            if (r2 >= r9) goto L4d
            com.fasterxml.jackson.databind.JsonNode r1 = r12.get(r2)
            com.networknt.schema.walk.WalkConfig r3 = r11.getWalkConfig()
            com.networknt.schema.walk.ApplyDefaultsStrategy r3 = r3.getApplyDefaultsStrategy()
            boolean r3 = r3.shouldApplyArrayDefaults()
            if (r3 == 0) goto L41
            java.util.List<com.networknt.schema.Schema> r3 = r10.tupleSchema
            java.lang.Object r3 = r3.get(r2)
            com.networknt.schema.Schema r3 = (com.networknt.schema.Schema) r3
            com.fasterxml.jackson.databind.JsonNode r3 = getDefaultNode(r3, r11)
            if (r1 == 0) goto L41
            boolean r5 = r1.isNull()
            if (r5 == 0) goto L41
            if (r3 == 0) goto L41
            r8.set(r2, r3)
            r0 = r10
            r1 = r11
            r4 = r13
            r5 = r14
            r6 = r15
            goto L47
        L41:
            r3 = r1
            r0 = r10
            r4 = r13
            r5 = r14
            r6 = r15
            r1 = r11
        L47:
            r0.doWalk(r1, r2, r3, r4, r5, r6)
            int r2 = r2 + 1
            goto Le
        L4d:
            boolean r1 = r10.hasUnevaluatedItemsInEvaluationPath(r11)
            if (r1 != 0) goto L59
            boolean r1 = r10.collectAnnotations(r11)
            if (r1 == 0) goto Le3
        L59:
            boolean r1 = r12.isArray()
            if (r1 == 0) goto L64
            int r1 = r12.size()
            goto L65
        L64:
            r1 = 1
        L65:
            java.util.List<com.networknt.schema.Schema> r2 = r10.tupleSchema
            int r2 = r2.size()
            if (r1 <= r2) goto L9f
            com.networknt.schema.annotation.Annotations r1 = r11.getAnnotations()
            com.networknt.schema.annotation.Annotation$Builder r3 = com.networknt.schema.annotation.Annotation.builder()
            com.networknt.schema.annotation.Annotation$Builder r3 = r3.instanceLocation(r14)
            com.networknt.schema.path.NodePath r4 = r11.getEvaluationPath()
            com.networknt.schema.annotation.Annotation$Builder r3 = r3.evaluationPath(r4)
            com.networknt.schema.SchemaLocation r4 = r10.schemaLocation
            com.networknt.schema.annotation.Annotation$Builder r3 = r3.schemaLocation(r4)
            java.lang.String r0 = r10.getKeyword()
            com.networknt.schema.annotation.Annotation$Builder r0 = r3.keyword(r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.networknt.schema.annotation.Annotation$Builder r0 = r0.value(r2)
            com.networknt.schema.annotation.Annotation r0 = r0.build()
            r1.put(r0)
            return
        L9f:
            com.networknt.schema.annotation.Annotations r1 = r11.getAnnotations()
            com.networknt.schema.annotation.Annotation$Builder r2 = com.networknt.schema.annotation.Annotation.builder()
            com.networknt.schema.annotation.Annotation$Builder r2 = r2.instanceLocation(r14)
            com.networknt.schema.path.NodePath r3 = r11.getEvaluationPath()
            com.networknt.schema.annotation.Annotation$Builder r2 = r2.evaluationPath(r3)
            com.networknt.schema.SchemaLocation r3 = r10.schemaLocation
            com.networknt.schema.annotation.Annotation$Builder r2 = r2.schemaLocation(r3)
            java.lang.String r0 = r10.getKeyword()
            com.networknt.schema.annotation.Annotation$Builder r0 = r2.keyword(r0)
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            com.networknt.schema.annotation.Annotation$Builder r0 = r0.value(r2)
            com.networknt.schema.annotation.Annotation r0 = r0.build()
            r1.put(r0)
            return
        Lcf:
            java.util.List<com.networknt.schema.Schema> r1 = r10.tupleSchema
            int r7 = r1.size()
        Ld5:
            if (r2 >= r7) goto Le3
            r3 = 0
            r0 = r10
            r1 = r11
            r4 = r13
            r5 = r14
            r6 = r15
            r0.doWalk(r1, r2, r3, r4, r5, r6)
            int r2 = r2 + 1
            goto Ld5
        Le3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.networknt.schema.keyword.PrefixItemsValidator.walk(com.networknt.schema.ExecutionContext, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.databind.JsonNode, com.networknt.schema.path.NodePath, boolean):void");
    }
}
