package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.annotation.Annotation;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.Iterator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public abstract class AbstractKeywordValidator implements KeywordValidator {
    private final String keyword;
    protected final SchemaLocation schemaLocation;
    protected final JsonNode schemaNode;

    public AbstractKeywordValidator(String str, JsonNode jsonNode, SchemaLocation schemaLocation) {
        this.keyword = str;
        this.schemaNode = jsonNode;
        this.schemaLocation = schemaLocation;
    }

    public boolean collectAnnotations(ExecutionContext executionContext) {
        return collectAnnotations(executionContext, getKeyword());
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public String getKeyword() {
        return this.keyword;
    }

    @Override // com.networknt.schema.Validator
    public SchemaLocation getSchemaLocation() {
        return this.schemaLocation;
    }

    public JsonNode getSchemaNode() {
        return this.schemaNode;
    }

    public boolean hasAdjacentKeywordInEvaluationPath(ExecutionContext executionContext, String str) {
        Iterator<Object> itDescendingIterator = executionContext.getEvaluationSchemaPath().descendingIterator();
        Iterator<Schema> itDescendingIterator2 = executionContext.getEvaluationSchema().descendingIterator();
        if (itDescendingIterator.hasNext()) {
            itDescendingIterator.next();
        }
        boolean z10 = false;
        while (itDescendingIterator2.hasNext()) {
            if (itDescendingIterator2.next().getSchemaNode().has(str)) {
                return true;
            }
            if (z10) {
                return false;
            }
            if (itDescendingIterator.hasNext()) {
                Object next = itDescendingIterator.next();
                if (PropertiesValidator.PROPERTY.equals(next) || DidiCardProvider.KEY_ITEMS.equals(next)) {
                    z10 = true;
                }
            }
        }
        return false;
    }

    public boolean hasUnevaluatedItemsInEvaluationPath(ExecutionContext executionContext) {
        return executionContext.isUnevaluatedItemsPresent() && hasAdjacentKeywordInEvaluationPath(executionContext, "unevaluatedItems");
    }

    public boolean hasUnevaluatedPropertiesInEvaluationPath(ExecutionContext executionContext) {
        return executionContext.isUnevaluatedPropertiesPresent() && hasAdjacentKeywordInEvaluationPath(executionContext, "unevaluatedProperties");
    }

    public void putAnnotation(ExecutionContext executionContext, Consumer<Annotation.Builder> consumer) {
        Annotation.Builder builderKeyword = Annotation.builder().evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword(getKeyword());
        consumer.accept(builderKeyword);
        executionContext.getAnnotations().put(builderKeyword.build());
    }

    public String toString() {
        return getKeyword();
    }

    public boolean collectAnnotations(ExecutionContext executionContext, String str) {
        return executionContext.getExecutionConfig().isAnnotationCollectionEnabled() && executionContext.getExecutionConfig().getAnnotationCollectionFilter().test(str);
    }

    public AbstractKeywordValidator(Keyword keyword, JsonNode jsonNode, SchemaLocation schemaLocation) {
        this(keyword.getValue(), jsonNode, schemaLocation);
    }
}
