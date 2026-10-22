package com.networknt.schema.keyword;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.serialization.JsonMapperFactory;
import com.networknt.schema.utils.JsonType;
import com.networknt.schema.utils.TypeFactory;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class ContentMediaTypeValidator extends BaseKeywordValidator {
    private final String contentMediaType;
    private static final String PATTERN_STRING = "(application|audio|font|example|image|message|model|multipart|text|video|x-(?:[0-9A-Za-z!#$%&'*+.^_`|~-]+))/([0-9A-Za-z!#$%&'*+.^_`|~-]+)((?:[ \t]*;[ \t]*[0-9A-Za-z!#$%&'*+.^_`|~-]+=(?:[0-9A-Za-z!#$%&'*+.^_`|~-]+|\"(?:[^\"\\\\]|\\.)*\"))*)";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_STRING);

    public ContentMediaTypeValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.CONTENT_MEDIA_TYPE, jsonNode, schemaLocation, schema, schemaContext);
        this.contentMediaType = jsonNode.textValue();
    }

    public static /* synthetic */ void a(ContentMediaTypeValidator contentMediaTypeValidator, NodePath nodePath, Annotation.Builder builder) {
        contentMediaTypeValidator.getClass();
        builder.instanceLocation(nodePath).value(contentMediaTypeValidator.contentMediaType);
    }

    private boolean matches(String str) {
        if (!"application/json".equals(this.contentMediaType)) {
            return PATTERN.matcher(this.contentMediaType).matches();
        }
        JsonNode jsonNode = this.parentSchema.getSchemaNode().get("contentEncoding");
        if ("base64".equals((jsonNode == null || !jsonNode.isTextual()) ? null : jsonNode.asText())) {
            try {
                str = new String(Base64.getDecoder().decode(str), StandardCharsets.UTF_8);
            } catch (IllegalArgumentException unused) {
                return true;
            }
        }
        try {
            JsonMapperFactory.getInstance().readTree(str);
            return true;
        } catch (JsonProcessingException unused2) {
            return false;
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, final NodePath nodePath) {
        if (TypeFactory.getValueNodeType(jsonNode, this.schemaContext.getSchemaRegistryConfig()) != JsonType.STRING) {
            return;
        }
        if (collectAnnotations(executionContext)) {
            putAnnotation(executionContext, new Consumer() { // from class: com.networknt.schema.keyword.e
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ContentMediaTypeValidator.a(this.f21975a, nodePath, (Annotation.Builder) obj);
                }
            });
        }
        if (matches(jsonNode.asText())) {
            return;
        }
        executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(this.contentMediaType).build());
    }
}
