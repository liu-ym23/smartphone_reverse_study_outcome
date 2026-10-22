package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.annotation.Annotations;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.regex.RegularExpression;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class PatternPropertiesValidator extends BaseKeywordValidator {
    public static final String PROPERTY = "patternProperties";
    private final Map<RegularExpression, Schema> schemas;

    public PatternPropertiesValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.PATTERN_PROPERTIES, jsonNode, schemaLocation, schema, schemaContext);
        this.schemas = new IdentityHashMap();
        if (!jsonNode.isObject()) {
            throw new SchemaException("patternProperties must be an object node");
        }
        Iterator<String> itFieldNames = jsonNode.fieldNames();
        while (itFieldNames.hasNext()) {
            String next = itFieldNames.next();
            this.schemas.put(RegularExpression.compile(next, schemaContext), schemaContext.newSchema(schemaLocation.append(next), jsonNode.get(next), schema));
        }
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        preloadSchemas(this.schemas.values());
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (jsonNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
            boolean z10 = hasUnevaluatedPropertiesInEvaluationPath(executionContext) || collectAnnotations(executionContext);
            Set linkedHashSet = null;
            while (itFields.hasNext()) {
                Map.Entry<String, JsonNode> next = itFields.next();
                String key = next.getKey();
                JsonNode value = next.getValue();
                for (Map.Entry<RegularExpression, Schema> entry : this.schemas.entrySet()) {
                    if (entry.getKey().matches(key)) {
                        NodePath nodePathAppend = nodePath.append(key);
                        int size = executionContext.getErrors().size();
                        Schema value2 = entry.getValue();
                        executionContext.evaluationPathAddLast(value2.getSchemaLocation().getFragment().getElement(-1).toString());
                        try {
                            value2.validate(executionContext, value, jsonNode2, nodePathAppend);
                            executionContext.evaluationPathRemoveLast();
                            if (size == executionContext.getErrors().size() && z10) {
                                if (linkedHashSet == null) {
                                    linkedHashSet = new LinkedHashSet();
                                }
                                linkedHashSet.add(key);
                            }
                        } catch (Throwable th) {
                            executionContext.evaluationPathRemoveLast();
                            throw th;
                        }
                    }
                }
            }
            if (z10) {
                Annotations annotations = executionContext.getAnnotations();
                Annotation.Builder builderKeyword = Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword(getKeyword());
                if (linkedHashSet == null) {
                    linkedHashSet = Collections.EMPTY_SET;
                }
                annotations.put(builderKeyword.value(linkedHashSet).build());
            }
        }
    }
}
