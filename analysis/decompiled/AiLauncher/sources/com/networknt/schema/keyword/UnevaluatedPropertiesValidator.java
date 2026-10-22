package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.annotation.Annotation;
import com.networknt.schema.path.NodePath;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes2.dex */
public class UnevaluatedPropertiesValidator extends BaseKeywordValidator {
    private final Schema schema;

    public UnevaluatedPropertiesValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.UNEVALUATED_PROPERTIES, jsonNode, schemaLocation, schema, schemaContext);
        if (!jsonNode.isObject() && !jsonNode.isBoolean()) {
            throw new IllegalArgumentException("The value of 'unevaluatedProperties' MUST be a valid JSON Schema.");
        }
        this.schema = schemaContext.newSchema(schemaLocation, jsonNode, schema);
    }

    @Override // com.networknt.schema.Validator
    public void validate(final ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (jsonNode.isObject()) {
            Predicate<? super Annotation> predicate = new Predicate() { // from class: com.networknt.schema.keyword.x0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((Annotation) obj).isValid();
                }
            };
            Predicate<? super Annotation> predicate2 = new Predicate() { // from class: com.networknt.schema.keyword.y0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((Annotation) obj).getEvaluationPath().startsWith(executionContext.getEvaluationPath().getParent());
                }
            };
            List<Annotation> orDefault = executionContext.getAnnotations().asMap().getOrDefault(nodePath, Collections.EMPTY_LIST);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            for (Annotation annotation : (List) orDefault.stream().filter(new Predicate() { // from class: com.networknt.schema.keyword.z0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return PropertiesValidator.PROPERTY.equals(((Annotation) obj).getKeyword());
                }
            }).filter(predicate2).filter(predicate).collect(Collectors.toList())) {
                if (annotation.getValue() instanceof Set) {
                    linkedHashSet2.addAll((Set) annotation.getValue());
                }
            }
            for (Annotation annotation2 : (List) orDefault.stream().filter(new Predicate() { // from class: com.networknt.schema.keyword.A0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return PatternPropertiesValidator.PROPERTY.equals(((Annotation) obj).getKeyword());
                }
            }).filter(predicate2).filter(predicate).collect(Collectors.toList())) {
                if (annotation2.getValue() instanceof Set) {
                    linkedHashSet2.addAll((Set) annotation2.getValue());
                }
            }
            for (Annotation annotation3 : (List) orDefault.stream().filter(new Predicate() { // from class: com.networknt.schema.keyword.B0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return "additionalProperties".equals(((Annotation) obj).getKeyword());
                }
            }).filter(predicate2).filter(predicate).collect(Collectors.toList())) {
                if (annotation3.getValue() instanceof Set) {
                    linkedHashSet2.addAll((Set) annotation3.getValue());
                }
            }
            for (Annotation annotation4 : (List) orDefault.stream().filter(new Predicate() { // from class: com.networknt.schema.keyword.C0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return "unevaluatedProperties".equals(((Annotation) obj).getKeyword());
                }
            }).filter(predicate2).filter(predicate).collect(Collectors.toList())) {
                if (annotation4.getValue() instanceof Set) {
                    linkedHashSet2.addAll((Set) annotation4.getValue());
                }
            }
            boolean zIsFailFast = executionContext.isFailFast();
            try {
                executionContext.setFailFast(false);
                Iterator<String> itFieldNames = jsonNode.fieldNames();
                while (itFieldNames.hasNext()) {
                    String next = itFieldNames.next();
                    if (!linkedHashSet2.contains(next)) {
                        linkedHashSet.add(next);
                        if (!this.schemaNode.isBoolean() || this.schemaNode.booleanValue()) {
                            this.schema.validate(executionContext, jsonNode.get(next), jsonNode, nodePath.append(next));
                        } else {
                            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).property(next).evaluationPath(executionContext.getEvaluationPath()).arguments(next).locale(executionContext.getExecutionConfig().getLocale()).build());
                        }
                    }
                }
                executionContext.setFailFast(zIsFailFast);
                executionContext.getAnnotations().put(Annotation.builder().instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).schemaLocation(this.schemaLocation).keyword(getKeyword()).value(linkedHashSet).build());
            } catch (Throwable th) {
                executionContext.setFailFast(zIsFailFast);
                throw th;
            }
        }
    }
}
