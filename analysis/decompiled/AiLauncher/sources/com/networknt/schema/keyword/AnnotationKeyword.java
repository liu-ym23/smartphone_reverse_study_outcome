package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.path.NodePath;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class AnnotationKeyword extends AbstractKeyword {

    public static final class Validator extends AbstractKeywordValidator {
        public Validator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext, Keyword keyword) {
            super(keyword, jsonNode, schemaLocation);
        }

        private Object getAnnotationValue(JsonNode jsonNode) {
            if (jsonNode.isTextual()) {
                return jsonNode.textValue();
            }
            if (jsonNode.isNumber()) {
                return jsonNode.numberValue();
            }
            if (jsonNode.isObject()) {
                return jsonNode;
            }
            return null;
        }

        @Override // com.networknt.schema.Validator
        public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, final NodePath nodePath) {
            final Object annotationValue;
            if (!collectAnnotations(executionContext) || (annotationValue = getAnnotationValue(getSchemaNode())) == null) {
                return;
            }
            putAnnotation(executionContext, new Consumer() { // from class: com.networknt.schema.keyword.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((Annotation.Builder) obj).instanceLocation(nodePath).value(annotationValue);
                }
            });
        }
    }

    public AnnotationKeyword(String str) {
        super(str);
    }

    @Override // com.networknt.schema.keyword.Keyword
    public KeywordValidator newValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        return new Validator(schemaLocation, jsonNode, schema, schemaContext, this);
    }
}
