package com.networknt.schema.keyword;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.annotation.Annotations;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.regex.RegularExpression;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class AdditionalPropertiesValidator extends BaseKeywordValidator {
    private final Schema additionalPropertiesSchema;
    private final boolean allowAdditionalProperties;
    private final Set<String> allowedProperties;
    private final List<RegularExpression> patternProperties;

    public AdditionalPropertiesValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.ADDITIONAL_PROPERTIES, jsonNode, schemaLocation, schema, schemaContext);
        if (jsonNode.isBoolean()) {
            this.allowAdditionalProperties = jsonNode.booleanValue();
            this.additionalPropertiesSchema = null;
        } else if (jsonNode.isObject()) {
            this.allowAdditionalProperties = true;
            this.additionalPropertiesSchema = schemaContext.newSchema(schemaLocation, jsonNode, schema);
        } else {
            this.allowAdditionalProperties = false;
            this.additionalPropertiesSchema = null;
        }
        JsonNode jsonNode2 = schema.getSchemaNode().get(PropertiesValidator.PROPERTY);
        if (jsonNode2 != null) {
            this.allowedProperties = new HashSet();
            Iterator<String> itFieldNames = jsonNode2.fieldNames();
            while (itFieldNames.hasNext()) {
                this.allowedProperties.add(itFieldNames.next());
            }
        } else {
            this.allowedProperties = Collections.EMPTY_SET;
        }
        JsonNode jsonNode3 = schema.getSchemaNode().get(PatternPropertiesValidator.PROPERTY);
        if (jsonNode3 == null) {
            this.patternProperties = Collections.EMPTY_LIST;
            return;
        }
        this.patternProperties = new ArrayList(jsonNode3.size());
        Iterator<String> itFieldNames2 = jsonNode3.fieldNames();
        while (itFieldNames2.hasNext()) {
            this.patternProperties.add(RegularExpression.compile(itFieldNames2.next(), schemaContext));
        }
    }

    private boolean handledByPatternProperties(String str) {
        Iterator<RegularExpression> it = this.patternProperties.iterator();
        while (it.hasNext()) {
            if (it.next().matches(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        Schema schema = this.additionalPropertiesSchema;
        if (schema != null) {
            schema.initializeValidators();
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        validate(executionContext, jsonNode, jsonNode2, nodePath, false);
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        boolean z11;
        Schema schema;
        if (z10 && jsonNode != null) {
            validate(executionContext, jsonNode, jsonNode2, nodePath, true);
            return;
        }
        if (jsonNode == null || !jsonNode.isObject()) {
            return;
        }
        Iterator<String> itFieldNames = jsonNode.fieldNames();
        while (itFieldNames.hasNext()) {
            String next = itFieldNames.next();
            if (!next.startsWith(Const.STR_MART_WELL)) {
                if (this.allowedProperties.contains(next) || handledByPatternProperties(next) || !this.allowAdditionalProperties || (schema = this.additionalPropertiesSchema) == null) {
                    z11 = z10;
                } else {
                    z11 = z10;
                    schema.walk(executionContext, jsonNode.get(next), jsonNode2, nodePath.append(next), z11);
                }
                z10 = z11;
            }
        }
    }

    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        ExecutionContext executionContext2;
        JsonNode jsonNode3;
        if (jsonNode.isObject()) {
            boolean z11 = hasUnevaluatedPropertiesInEvaluationPath(executionContext) || collectAnnotations(executionContext);
            Set linkedHashSet = null;
            if (this.allowAdditionalProperties && z11) {
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                    }
                    linkedHashSet.add(itFieldNames.next());
                }
            }
            Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
            while (itFields.hasNext()) {
                Map.Entry<String, JsonNode> next = itFields.next();
                String key = next.getKey();
                if (!key.startsWith(Const.STR_MART_WELL)) {
                    if (this.allowedProperties.contains(key) || handledByPatternProperties(key)) {
                        executionContext2 = executionContext;
                        jsonNode3 = jsonNode2;
                        executionContext = executionContext2;
                        jsonNode2 = jsonNode3;
                    } else {
                        if (this.allowAdditionalProperties) {
                            Schema schema = this.additionalPropertiesSchema;
                            if (schema != null) {
                                if (z10) {
                                    executionContext2 = executionContext;
                                    jsonNode3 = jsonNode2;
                                    schema.walk(executionContext2, next.getValue(), jsonNode3, nodePath.append(key), true);
                                    executionContext = executionContext2;
                                    jsonNode2 = jsonNode3;
                                } else {
                                    schema.validate(executionContext, next.getValue(), jsonNode2, nodePath.append(key));
                                }
                            }
                        } else {
                            executionContext.addError(error().instanceNode(jsonNode).property(key).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(key).build());
                        }
                        executionContext2 = executionContext;
                        jsonNode3 = jsonNode2;
                        executionContext = executionContext2;
                        jsonNode2 = jsonNode3;
                    }
                }
            }
            ExecutionContext executionContext3 = executionContext;
            if (z11) {
                Annotations annotations = executionContext3.getAnnotations();
                Annotation.Builder builderKeyword = Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext3.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword(getKeyword());
                if (linkedHashSet == null) {
                    linkedHashSet = Collections.EMPTY_SET;
                }
                annotations.put(builderKeyword.value(linkedHashSet).build());
            }
        }
    }
}
