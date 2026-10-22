package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SchemaRef;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.annotation.Annotations;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.SchemaRefs;
import com.networknt.schema.walk.WalkHandler;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class PropertiesValidator extends BaseKeywordValidator {
    public static final String PROPERTY = "properties";
    private final Map<String, Schema> schemas;

    public PropertiesValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.PROPERTIES, jsonNode, schemaLocation, schema, schemaContext);
        this.schemas = new LinkedHashMap();
        Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
        while (itFields.hasNext()) {
            Map.Entry<String, JsonNode> next = itFields.next();
            String key = next.getKey();
            this.schemas.put(key, schemaContext.newSchema(schemaLocation.append(key), next.getValue(), schema));
        }
    }

    private void applyPropertyDefaults(ObjectNode objectNode, ExecutionContext executionContext) {
        for (Map.Entry<String, Schema> entry : this.schemas.entrySet()) {
            JsonNode jsonNode = objectNode.get(entry.getKey());
            JsonNode defaultNode = getDefaultNode(entry.getValue(), executionContext);
            if (defaultNode != null && (jsonNode == null || (jsonNode.isNull() && executionContext.getWalkConfig().getApplyDefaultsStrategy().shouldApplyPropertyDefaultsIfNull()))) {
                objectNode.set(entry.getKey(), defaultNode);
            }
        }
    }

    private static JsonNode getDefaultNode(Schema schema, ExecutionContext executionContext) {
        SchemaRef schemaRefFrom;
        JsonNode jsonNode = schema.getSchemaNode().get("default");
        return (jsonNode != null || (schemaRefFrom = SchemaRefs.from(schema, executionContext)) == null) ? jsonNode : getDefaultNode(schemaRefFrom.getSchema(), executionContext);
    }

    private void walkSchema(ExecutionContext executionContext, Map.Entry<String, Schema> entry, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10, WalkHandler walkHandler) {
        JsonNode jsonNode3;
        Schema value = entry.getValue();
        JsonNode jsonNode4 = jsonNode == null ? null : jsonNode.get(entry.getKey());
        NodePath nodePathAppend = nodePath.append(entry.getKey());
        KeywordType keywordType = KeywordType.PROPERTIES;
        boolean zPreWalk = walkHandler.preWalk(executionContext, keywordType.getValue(), jsonNode4, jsonNode2, nodePathAppend, value, this);
        if (jsonNode4 == null && jsonNode != null) {
            jsonNode4 = jsonNode.get(entry.getKey());
        }
        int size = executionContext.getErrors().size();
        if (zPreWalk) {
            jsonNode3 = jsonNode4;
            value.walk(executionContext, jsonNode3, jsonNode2, nodePathAppend, z10);
            nodePathAppend = nodePathAppend;
        } else {
            jsonNode3 = jsonNode4;
        }
        walkHandler.postWalk(executionContext, keywordType.getValue(), jsonNode3, jsonNode2, nodePathAppend, value, this, executionContext.getErrors().subList(size, executionContext.getErrors().size()));
    }

    public Map<String, Schema> getSchemas() {
        return this.schemas;
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        preloadSchemas(this.schemas.values());
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        validate(executionContext, jsonNode, jsonNode2, nodePath, false);
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        if (executionContext.getWalkConfig().getApplyDefaultsStrategy().shouldApplyPropertyDefaults() && jsonNode != null && jsonNode.getNodeType() == JsonNodeType.OBJECT) {
            applyPropertyDefaults((ObjectNode) jsonNode, executionContext);
        }
        if (z10) {
            validate(executionContext, jsonNode == null ? MissingNode.getInstance() : jsonNode, jsonNode2, nodePath, true);
            return;
        }
        WalkHandler propertyWalkHandler = executionContext.getWalkConfig().getPropertyWalkHandler();
        for (Map.Entry<String, Schema> entry : this.schemas.entrySet()) {
            executionContext.evaluationPathAddLast(entry.getKey());
            try {
                walkSchema(executionContext, entry, jsonNode, jsonNode2, nodePath, z10, propertyWalkHandler);
            } finally {
                executionContext.evaluationPathRemoveLast();
            }
        }
    }

    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        NodePath nodePath2 = nodePath;
        boolean z11 = hasUnevaluatedPropertiesInEvaluationPath(executionContext) || collectAnnotations(executionContext);
        Set linkedHashSet = null;
        for (Map.Entry<String, Schema> entry : this.schemas.entrySet()) {
            JsonNode jsonNode3 = jsonNode.get(entry.getKey());
            if (jsonNode3 != null) {
                NodePath nodePathAppend = nodePath.append(entry.getKey());
                if (z11) {
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                    }
                    linkedHashSet.add(entry.getKey());
                }
                executionContext.evaluationPathAddLast(entry.getKey());
                if (z10) {
                    walkSchema(executionContext, entry, jsonNode, jsonNode2, nodePath2, true, executionContext.getWalkConfig().getPropertyWalkHandler());
                } else {
                    try {
                        entry.getValue().validate(executionContext, jsonNode3, jsonNode2, nodePathAppend);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else if (z10) {
                executionContext.evaluationPathAddLast(entry.getKey());
                try {
                    nodePath2 = nodePath;
                    walkSchema(executionContext, entry, jsonNode, jsonNode2, nodePath2, true, executionContext.getWalkConfig().getPropertyWalkHandler());
                } finally {
                    executionContext.evaluationPathRemoveLast();
                }
            }
            nodePath2 = nodePath;
        }
        if (z11) {
            Annotations annotations = executionContext.getAnnotations();
            Annotation.Builder builderKeyword = Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword(getKeyword());
            if (linkedHashSet == null) {
                linkedHashSet = Collections.EMPTY_SET;
            }
            annotations.put(builderKeyword.value(linkedHashSet).build());
        }
    }
}
