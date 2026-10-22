package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SpecificationVersionRange;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.path.NodePath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public class ContainsValidator extends BaseKeywordValidator {
    private static final String CONTAINS_MAX = "contains.max";
    private static final String CONTAINS_MIN = "contains.min";
    private final boolean isMinV201909;
    private final Integer max;
    private final Integer min;
    private final Schema schema;

    public ContainsValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        Integer numValueOf;
        super(KeywordType.CONTAINS, jsonNode, schemaLocation, schema, schemaContext);
        this.isMinV201909 = SpecificationVersionRange.MIN_DRAFT_2019_09.getVersions().contains(this.schemaContext.getDialect().getSpecificationVersion());
        if (jsonNode.isObject() || jsonNode.isBoolean()) {
            this.schema = schemaContext.newSchema(schemaLocation, jsonNode, schema);
            JsonNode schemaNode = schema.getSchemaNode();
            Optional optionalFilter = Optional.ofNullable(schemaNode.get(KeywordType.MAX_CONTAINS.getValue())).filter(new Predicate() { // from class: com.networknt.schema.keyword.c
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((JsonNode) obj).canConvertToExactIntegral();
                }
            });
            Integer numValueOf2 = optionalFilter.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter.get()).intValue()) : null;
            Optional optionalFilter2 = Optional.ofNullable(schemaNode.get(KeywordType.MIN_CONTAINS.getValue())).filter(new Predicate() { // from class: com.networknt.schema.keyword.c
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((JsonNode) obj).canConvertToExactIntegral();
                }
            });
            numValueOf = optionalFilter2.isPresent() ? Integer.valueOf(((JsonNode) optionalFilter2.get()).intValue()) : null;
            num = numValueOf2;
        } else {
            this.schema = null;
            numValueOf = null;
        }
        this.max = num;
        this.min = numValueOf;
    }

    private void boundsViolated(ExecutionContext executionContext, KeywordType keywordType, Locale locale, JsonNode jsonNode, NodePath nodePath, int i10) {
        executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).messageKey(KeywordType.MIN_CONTAINS.equals(keywordType) ? CONTAINS_MIN : KeywordType.MAX_CONTAINS.equals(keywordType) ? CONTAINS_MAX : "contains").locale(locale).arguments(String.valueOf(i10), this.schema.getSchemaNode().toString()).keyword(keywordType.getValue()).build());
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        Optional.ofNullable(this.schema).ifPresent(new Consumer() { // from class: com.networknt.schema.keyword.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Schema) obj).initializeValidators();
            }
        });
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        int i10;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        if (this.schema == null || !jsonNode.isArray()) {
            i10 = 0;
        } else {
            boolean zIsFailFast = executionContext.isFailFast();
            List<Error> errors = executionContext.getErrors();
            try {
                executionContext.setFailFast(false);
                ArrayList arrayList2 = new ArrayList();
                executionContext.setErrors(arrayList2);
                Iterator<JsonNode> it = jsonNode.iterator();
                int i12 = 0;
                i10 = 0;
                while (it.hasNext()) {
                    this.schema.validate(executionContext, it.next(), jsonNode2, nodePath.append(i10));
                    if (arrayList2.isEmpty()) {
                        i12++;
                        arrayList.add(Integer.valueOf(i10));
                    } else {
                        arrayList2.clear();
                    }
                    i10++;
                }
                executionContext.setFailFast(zIsFailFast);
                executionContext.setErrors(errors);
                Integer num = this.min;
                int iIntValue = num != null ? num.intValue() : 1;
                if (i12 < iIntValue) {
                    boundsViolated(executionContext, this.isMinV201909 ? KeywordType.MIN_CONTAINS : KeywordType.CONTAINS, executionContext.getExecutionConfig().getLocale(), jsonNode, nodePath, iIntValue);
                }
                Integer num2 = this.max;
                if (num2 != null && i12 > num2.intValue()) {
                    boundsViolated(executionContext, this.isMinV201909 ? KeywordType.MAX_CONTAINS : KeywordType.CONTAINS, executionContext.getExecutionConfig().getLocale(), jsonNode, nodePath, this.max.intValue());
                }
                i11 = i12;
            } catch (Throwable th) {
                executionContext.setFailFast(zIsFailFast);
                executionContext.setErrors(errors);
                throw th;
            }
        }
        boolean zHasUnevaluatedItemsInEvaluationPath = hasUnevaluatedItemsInEvaluationPath(executionContext);
        if (this.schema != null) {
            if (zHasUnevaluatedItemsInEvaluationPath || collectAnnotations(executionContext, "contains")) {
                if (i11 == i10) {
                    executionContext.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword("contains").value(Boolean.TRUE).build());
                } else {
                    executionContext.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword("contains").value(arrayList).build());
                }
            }
            if (this.min != null && (zHasUnevaluatedItemsInEvaluationPath || collectAnnotations(executionContext, "minContains"))) {
                executionContext.evaluationPathAddLast("minContains");
                executionContext.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation.append("minContains")).keyword("minContains").value(this.min).build());
                executionContext.evaluationPathRemoveLast();
            }
            if (this.max != null) {
                if (zHasUnevaluatedItemsInEvaluationPath || collectAnnotations(executionContext, "maxContains")) {
                    executionContext.evaluationPathAddLast("maxContains");
                    executionContext.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation.append("maxContains")).keyword("maxContains").value(this.max).build());
                    executionContext.evaluationPathRemoveLast();
                }
            }
        }
    }
}
