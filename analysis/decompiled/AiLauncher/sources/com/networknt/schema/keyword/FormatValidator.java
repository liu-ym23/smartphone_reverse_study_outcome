package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.format.BaseFormatValidator;
import com.networknt.schema.format.Format;
import com.networknt.schema.path.NodePath;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes2.dex */
public class FormatValidator extends BaseFormatValidator implements KeywordValidator {
    private static final vc.c logger = vc.e.l(FormatValidator.class);
    private final Format format;

    public FormatValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext, Format format, Keyword keyword) {
        super(schemaLocation, jsonNode, schema, keyword, schemaContext);
        this.format = format;
    }

    public boolean createUnknownFormatAssertions(ExecutionContext executionContext) {
        return (isAssertionsEnabled(executionContext) && isStrict(executionContext)) || isFormatAssertionVocabularyEnabled();
    }

    public Object getAnnotationValue() {
        Format format = this.format;
        if (format != null) {
            return format.getName();
        }
        if (this.schemaNode.isTextual()) {
            return this.schemaNode.textValue();
        }
        return null;
    }

    public boolean isStrict(ExecutionContext executionContext) {
        return this.schemaContext.getSchemaRegistryConfig().isStrict(getKeyword(), Boolean.FALSE);
    }

    @Override // com.networknt.schema.Validator
    public void validate(final ExecutionContext executionContext, final JsonNode jsonNode, JsonNode jsonNode2, final NodePath nodePath) {
        FormatValidator formatValidator;
        NodePath nodePath2;
        final Object annotationValue;
        if (collectAnnotations(executionContext) && (annotationValue = getAnnotationValue()) != null) {
            putAnnotation(executionContext, new Consumer() { // from class: com.networknt.schema.keyword.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((Annotation.Builder) obj).instanceLocation(nodePath).value(annotationValue);
                }
            });
        }
        boolean zIsAssertionsEnabled = isAssertionsEnabled(executionContext);
        Format format = this.format;
        if (format == null) {
            validateUnknownFormat(executionContext, jsonNode, jsonNode2, nodePath);
            return;
        }
        try {
            formatValidator = this;
            nodePath2 = nodePath;
        } catch (PatternSyntaxException e10) {
            e = e10;
            formatValidator = this;
            nodePath2 = nodePath;
        }
        try {
            format.validate(executionContext, this.schemaContext, jsonNode, jsonNode2, nodePath2, zIsAssertionsEnabled, new Supplier() { // from class: com.networknt.schema.keyword.i
                @Override // java.util.function.Supplier
                public final Object get() {
                    FormatValidator formatValidator2 = this.f21987a;
                    JsonNode jsonNode3 = jsonNode;
                    NodePath nodePath3 = nodePath;
                    ExecutionContext executionContext2 = executionContext;
                    return formatValidator2.error().instanceNode(jsonNode3).instanceLocation(nodePath3).evaluationPath(executionContext2.getEvaluationPath()).messageKey(formatValidator2.format.getMessageKey()).locale(executionContext2.getExecutionConfig().getLocale());
                }
            }, formatValidator);
        } catch (PatternSyntaxException e11) {
            e = e11;
            logger.error("Failed to apply pattern on {}: Invalid RE syntax [{}]", nodePath2, formatValidator.format.getName(), e);
        }
    }

    public void validateUnknownFormat(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (createUnknownFormatAssertions(executionContext) && this.schemaNode.isTextual()) {
            executionContext.addError(error().instanceLocation(nodePath).instanceNode(jsonNode).evaluationPath(executionContext.getEvaluationPath()).messageKey("format.unknown").arguments(this.schemaNode.textValue()).build());
        }
    }
}
