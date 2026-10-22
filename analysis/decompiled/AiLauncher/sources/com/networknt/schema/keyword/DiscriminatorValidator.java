package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class DiscriminatorValidator extends BaseKeywordValidator {
    private final String defaultMapping;
    private final Map<String, String> mapping;
    private final String propertyName;

    public DiscriminatorValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.DISCRIMINATOR, jsonNode, schemaLocation, schema, schemaContext);
        ObjectNode objectNode = jsonNode.isObject() ? (ObjectNode) jsonNode : null;
        if (objectNode == null) {
            this.propertyName = "";
            this.mapping = Collections.EMPTY_MAP;
            this.defaultMapping = null;
            return;
        }
        JsonNode jsonNode2 = objectNode.get("propertyName");
        this.propertyName = jsonNode2 != null ? jsonNode2.asText() : "";
        JsonNode jsonNode3 = objectNode.get("mapping");
        ObjectNode objectNode2 = (jsonNode3 == null || !jsonNode3.isObject()) ? null : (ObjectNode) jsonNode3;
        if (objectNode2 != null) {
            this.mapping = new HashMap();
            Iterator<Map.Entry<String, JsonNode>> itFields = objectNode2.fields();
            while (itFields.hasNext()) {
                Map.Entry<String, JsonNode> next = itFields.next();
                this.mapping.put(next.getKey(), next.getValue().asText());
            }
        } else {
            this.mapping = Collections.EMPTY_MAP;
        }
        JsonNode jsonNode4 = objectNode.get("defaultMapping");
        if (jsonNode4 != null) {
            this.defaultMapping = jsonNode4.asText();
        } else {
            this.defaultMapping = null;
        }
    }

    public Map<String, String> getMapping() {
        return this.mapping;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        DiscriminatorState discriminatorState;
        DiscriminatorState discriminatorState2 = executionContext.getDiscriminatorMapping().get(nodePath);
        if (discriminatorState2 == null) {
            discriminatorState = new DiscriminatorState();
            discriminatorState.setPropertyName(this.propertyName);
            executionContext.getDiscriminatorMapping().put(nodePath, discriminatorState);
        } else {
            if (this.schemaContext.getSchemaRegistryConfig().isStrict("discriminator", Boolean.FALSE)) {
                throw new SchemaException("Schema at " + this.schemaLocation + " has a discriminator keyword for which another discriminator keyword has already been set for at " + nodePath);
            }
            if (!"".equals(this.propertyName) && !discriminatorState2.getPropertyName().equals(this.propertyName)) {
                throw new SchemaException("Schema at " + this.schemaLocation + " is redefining the discriminator property that has already been set for at " + nodePath);
            }
            discriminatorState = discriminatorState2;
        }
        JsonNode jsonNode3 = jsonNode.get(discriminatorState.getPropertyName());
        if (jsonNode3 == null || !jsonNode3.isTextual()) {
            String str = this.defaultMapping;
            if (str != null) {
                discriminatorState.setMappedSchema(str);
                discriminatorState.setExplicitMapping(true);
                return;
            } else {
                if (this.schemaContext.getSchemaRegistryConfig().isStrict("discriminator", Boolean.FALSE)) {
                    executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).messageKey("discriminator.missing_discriminating_value").arguments(this.propertyName).build());
                    return;
                }
                return;
            }
        }
        String strAsText = jsonNode3.asText();
        discriminatorState.setDiscriminatingValue(strAsText);
        String str2 = this.mapping.get(strAsText);
        if (discriminatorState2 == null || str2 == null || !discriminatorState2.isExplicitMapping() || discriminatorState2.getMappedSchema().equals(str2)) {
            if (str2 != null) {
                discriminatorState.setMappedSchema(str2);
                discriminatorState.setExplicitMapping(true);
                return;
            } else {
                if (discriminatorState.isExplicitMapping()) {
                    return;
                }
                discriminatorState.setMappedSchema(strAsText);
                discriminatorState.setExplicitMapping(false);
                return;
            }
        }
        throw new SchemaException("Schema at " + this.schemaLocation + " is mapping that has already been set for " + nodePath + " from " + discriminatorState2.getMappedSchema() + " to " + str2);
    }
}
