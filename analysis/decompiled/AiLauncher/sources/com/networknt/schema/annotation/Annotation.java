package com.networknt.schema.annotation;

import com.networknt.schema.SchemaLocation;
import com.networknt.schema.keyword.Keyword;
import com.networknt.schema.path.NodePath;
import java.util.Objects;

/* loaded from: classes2.dex */
public class Annotation {
    private final NodePath evaluationPath;
    private final NodePath instanceLocation;
    private final String keyword;
    private final SchemaLocation schemaLocation;
    private boolean valid = true;
    private final Object value;

    public static class Builder {
        private NodePath evaluationPath;
        private NodePath instanceLocation;
        private String keyword;
        private SchemaLocation schemaLocation;
        private Object value;

        public Annotation build() {
            return new Annotation(this.keyword, this.instanceLocation, this.schemaLocation, this.evaluationPath, this.value);
        }

        public Builder evaluationPath(NodePath nodePath) {
            this.evaluationPath = nodePath;
            return this;
        }

        public Builder instanceLocation(NodePath nodePath) {
            this.instanceLocation = nodePath;
            return this;
        }

        public Builder keyword(Keyword keyword) {
            this.keyword = keyword.getValue();
            return this;
        }

        public Builder schemaLocation(SchemaLocation schemaLocation) {
            this.schemaLocation = schemaLocation;
            return this;
        }

        public Builder value(Object obj) {
            this.value = obj;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }
    }

    public Annotation(String str, NodePath nodePath, SchemaLocation schemaLocation, NodePath nodePath2, Object obj) {
        this.keyword = str;
        this.instanceLocation = nodePath;
        this.schemaLocation = schemaLocation;
        this.evaluationPath = nodePath2;
        this.value = obj;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Annotation annotation = (Annotation) obj;
        return Objects.equals(this.evaluationPath, annotation.evaluationPath) && Objects.equals(this.instanceLocation, annotation.instanceLocation) && Objects.equals(this.keyword, annotation.keyword) && Objects.equals(this.schemaLocation, annotation.schemaLocation) && Objects.equals(this.value, annotation.value);
    }

    public NodePath getEvaluationPath() {
        return this.evaluationPath;
    }

    public NodePath getInstanceLocation() {
        return this.instanceLocation;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public SchemaLocation getSchemaLocation() {
        return this.schemaLocation;
    }

    public <T> T getValue() {
        return (T) this.value;
    }

    public int hashCode() {
        return Objects.hash(this.evaluationPath, this.instanceLocation, this.keyword, this.schemaLocation, this.value);
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean z10) {
        this.valid = z10;
    }

    public String toString() {
        return "Annotation [evaluationPath=" + this.evaluationPath + ", schemaLocation=" + this.schemaLocation + ", instanceLocation=" + this.instanceLocation + ", keyword=" + this.keyword + ", value=" + this.value + "]";
    }
}
