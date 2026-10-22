package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.JsonType;
import com.networknt.schema.utils.TypeFactory;
import java.util.Base64;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class ContentEncodingValidator extends BaseKeywordValidator {
    private final String contentEncoding;

    public ContentEncodingValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.CONTENT_ENCODING, jsonNode, schemaLocation, schema, schemaContext);
        this.contentEncoding = jsonNode.textValue();
    }

    public static /* synthetic */ void a(ContentEncodingValidator contentEncodingValidator, NodePath nodePath, Annotation.Builder builder) {
        contentEncodingValidator.getClass();
        builder.instanceLocation(nodePath).value(contentEncodingValidator.contentEncoding);
    }

    private boolean matches(String str) {
        if (!"base64".equals(this.contentEncoding)) {
            return true;
        }
        try {
            Base64.getDecoder().decode(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, final NodePath nodePath) {
        if (TypeFactory.getValueNodeType(jsonNode, this.schemaContext.getSchemaRegistryConfig()) != JsonType.STRING) {
            return;
        }
        if (collectAnnotations(executionContext)) {
            putAnnotation(executionContext, new Consumer() { // from class: com.networknt.schema.keyword.d
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ContentEncodingValidator.a(this.f21973a, nodePath, (Annotation.Builder) obj);
                }
            });
        }
        if (matches(jsonNode.asText())) {
            return;
        }
        executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(this.contentEncoding).build());
    }
}
