package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SpecificationVersionRange;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.path.NodePath;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes2.dex */
public class UnevaluatedItemsValidator extends BaseKeywordValidator {
    private final boolean isMinV202012;
    private final Schema schema;

    public UnevaluatedItemsValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.UNEVALUATED_ITEMS, jsonNode, schemaLocation, schema, schemaContext);
        this.isMinV202012 = SpecificationVersionRange.MIN_DRAFT_2020_12.getVersions().contains(schemaContext.getDialect().getSpecificationVersion());
        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
            throw new IllegalArgumentException("The value of 'unevaluatedItems' MUST be a valid JSON Schema.");
        }
        this.schema = schemaContext.newSchema(schemaLocation, jsonNode, schema);
    }

    @Override // com.networknt.schema.Validator
    public void validate(final ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        boolean z10;
        int i10;
        boolean z11;
        if (jsonNode.isArray()) {
            boolean z12 = this.isMinV202012;
            final String str = DidiCardProvider.KEY_ITEMS;
            final String str2 = z12 ? "prefixItems" : DidiCardProvider.KEY_ITEMS;
            if (!z12) {
                str = "additionalItems";
            }
            Predicate<? super Annotation> predicate = new Predicate() { // from class: com.networknt.schema.keyword.r0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((Annotation) obj).isValid();
                }
            };
            Predicate<? super Annotation> predicate2 = new Predicate() { // from class: com.networknt.schema.keyword.s0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((Annotation) obj).getEvaluationPath().startsWith(executionContext.getEvaluationPath().getParent());
                }
            };
            List<Annotation> orDefault = executionContext.getAnnotations().asMap().getOrDefault(nodePath, Collections.EMPTY_LIST);
            boolean z13 = false;
            if (!getSchemaNode().isBoolean() || !getSchemaNode().booleanValue()) {
                List<Annotation> list = (List) orDefault.stream().filter(new Predicate() { // from class: com.networknt.schema.keyword.t0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return str2.equals(((Annotation) obj).getKeyword());
                    }
                }).filter(predicate2).filter(predicate).collect(Collectors.toList());
                if (list.isEmpty()) {
                    z10 = false;
                    i10 = 0;
                } else {
                    z10 = false;
                    i10 = 0;
                    for (Annotation annotation : list) {
                        if (annotation.getValue() instanceof Number) {
                            int iIntValue = ((Number) annotation.getValue()).intValue();
                            if (iIntValue > i10) {
                                i10 = iIntValue;
                            }
                        } else if (annotation.getValue() instanceof Boolean) {
                            z10 = true;
                        }
                    }
                }
                if (!z10) {
                    for (Annotation annotation2 : (List) orDefault.stream().filter(new Predicate() { // from class: com.networknt.schema.keyword.u0
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return str.equals(((Annotation) obj).getKeyword());
                        }
                    }).filter(predicate2).filter(predicate).collect(Collectors.toList())) {
                        if ((annotation2.getValue() instanceof Boolean) && Boolean.TRUE.equals(annotation2.getValue())) {
                            z10 = true;
                        }
                    }
                }
                if (!z10) {
                    for (Annotation annotation3 : (List) orDefault.stream().filter(new Predicate() { // from class: com.networknt.schema.keyword.v0
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return "unevaluatedItems".equals(((Annotation) obj).getKeyword());
                        }
                    }).filter(predicate2).filter(predicate).collect(Collectors.toList())) {
                        if ((annotation3.getValue() instanceof Boolean) && Boolean.TRUE.equals(annotation3.getValue())) {
                            z10 = true;
                        }
                    }
                }
                z11 = false;
            } else if (jsonNode.isEmpty()) {
                z11 = false;
                i10 = 0;
                z10 = true;
            } else {
                i10 = 0;
                z11 = true;
                z10 = true;
            }
            if (!z10) {
                executionContext.getErrors().size();
                List<Annotation> list2 = (List) orDefault.stream().filter(new Predicate() { // from class: com.networknt.schema.keyword.w0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return "contains".equals(((Annotation) obj).getKeyword());
                    }
                }).filter(predicate2).filter(predicate).collect(Collectors.toList());
                HashSet hashSet = new HashSet();
                for (Annotation annotation4 : list2) {
                    if (annotation4.getValue() instanceof List) {
                        hashSet.addAll((List) annotation4.getValue());
                    } else if (annotation4.getValue() instanceof Boolean) {
                        z13 = true;
                    }
                }
                if (!z13) {
                    while (i10 < jsonNode.size()) {
                        if (!hashSet.contains(Integer.valueOf(i10))) {
                            if (!this.schemaNode.isBoolean() || this.schemaNode.booleanValue()) {
                                this.schema.validate(executionContext, jsonNode.get(i10), jsonNode, nodePath.append(i10));
                            } else {
                                executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).arguments(Integer.valueOf(i10)).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).build());
                            }
                            z11 = true;
                        }
                        i10++;
                    }
                }
                executionContext.getErrors().size();
            }
            if (z11) {
                executionContext.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword("unevaluatedItems").value(Boolean.TRUE).build());
            }
        }
    }
}
