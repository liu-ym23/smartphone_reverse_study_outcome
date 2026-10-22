package com.networknt.schema.annotation;

import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public class AnnotationPredicate implements Predicate<Annotation> {
    final Predicate<NodePath> evaluationPathPredicate;
    final Predicate<NodePath> instanceLocationPredicate;
    final Predicate<String> keywordPredicate;
    final Predicate<SchemaLocation> schemaLocationPredicate;
    final Predicate<Object> valuePredicate;

    public static class Builder {
        Predicate<NodePath> evaluationPathPredicate;
        Predicate<NodePath> instanceLocationPredicate;
        Predicate<String> keywordPredicate;
        Predicate<SchemaLocation> schemaLocationPredicate;
        Predicate<Object> valuePredicate;

        public AnnotationPredicate build() {
            return new AnnotationPredicate(this.instanceLocationPredicate, this.evaluationPathPredicate, this.schemaLocationPredicate, this.keywordPredicate, this.valuePredicate);
        }

        public Builder evaluationPath(Predicate<NodePath> predicate) {
            this.evaluationPathPredicate = predicate;
            return this;
        }

        public Builder instanceLocation(Predicate<NodePath> predicate) {
            this.instanceLocationPredicate = predicate;
            return this;
        }

        public Builder keyword(Predicate<String> predicate) {
            this.keywordPredicate = predicate;
            return this;
        }

        public Builder schema(Predicate<SchemaLocation> predicate) {
            this.schemaLocationPredicate = predicate;
            return this;
        }

        public Builder value(Predicate<Object> predicate) {
            this.valuePredicate = predicate;
            return this;
        }
    }

    public AnnotationPredicate(Predicate<NodePath> predicate, Predicate<NodePath> predicate2, Predicate<SchemaLocation> predicate3, Predicate<String> predicate4, Predicate<Object> predicate5) {
        this.instanceLocationPredicate = predicate;
        this.evaluationPathPredicate = predicate2;
        this.schemaLocationPredicate = predicate3;
        this.keywordPredicate = predicate4;
        this.valuePredicate = predicate5;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Predicate<NodePath> getEvaluationPathPredicate() {
        return this.evaluationPathPredicate;
    }

    public Predicate<NodePath> getInstanceLocationPredicate() {
        return this.instanceLocationPredicate;
    }

    public Predicate<String> getKeywordPredicate() {
        return this.keywordPredicate;
    }

    public Predicate<SchemaLocation> getSchemaLocationPredicate() {
        return this.schemaLocationPredicate;
    }

    public Predicate<Object> getValuePredicate() {
        return this.valuePredicate;
    }

    @Override // java.util.function.Predicate
    public boolean test(Annotation annotation) {
        Predicate<Object> predicate = this.valuePredicate;
        if (predicate != null && !predicate.test(annotation.getValue())) {
            return false;
        }
        Predicate<String> predicate2 = this.keywordPredicate;
        if (predicate2 != null && !predicate2.test(annotation.getKeyword())) {
            return false;
        }
        Predicate<NodePath> predicate3 = this.instanceLocationPredicate;
        if (predicate3 != null && !predicate3.test(annotation.getInstanceLocation())) {
            return false;
        }
        Predicate<NodePath> predicate4 = this.evaluationPathPredicate;
        if (predicate4 != null && !predicate4.test(annotation.getEvaluationPath())) {
            return false;
        }
        Predicate<SchemaLocation> predicate5 = this.schemaLocationPredicate;
        return predicate5 == null || predicate5.test(annotation.getSchemaLocation());
    }
}
