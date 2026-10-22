package com.networknt.schema.walk;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.keyword.KeywordValidator;
import com.networknt.schema.path.NodePath;

/* loaded from: classes2.dex */
public class WalkEvent {
    private NodePath evaluationPath;
    private ExecutionContext executionContext;
    private NodePath instanceLocation;
    private JsonNode instanceNode;
    private String keyword;
    private JsonNode rootNode;
    private Schema schema;
    private KeywordValidator validator;

    public static class WalkEventBuilder {
        private final WalkEvent walkEvent = new WalkEvent();

        public WalkEvent build() {
            if (this.walkEvent.executionContext != null) {
                WalkEvent walkEvent = this.walkEvent;
                walkEvent.evaluationPath = walkEvent.executionContext.getEvaluationPath();
            }
            return this.walkEvent;
        }

        public WalkEventBuilder executionContext(ExecutionContext executionContext) {
            this.walkEvent.executionContext = executionContext;
            return this;
        }

        public WalkEventBuilder instanceLocation(NodePath nodePath) {
            this.walkEvent.instanceLocation = nodePath;
            return this;
        }

        public WalkEventBuilder instanceNode(JsonNode jsonNode) {
            this.walkEvent.instanceNode = jsonNode;
            return this;
        }

        public WalkEventBuilder keyword(String str) {
            this.walkEvent.keyword = str;
            return this;
        }

        public WalkEventBuilder rootNode(JsonNode jsonNode) {
            this.walkEvent.rootNode = jsonNode;
            return this;
        }

        public WalkEventBuilder schema(Schema schema) {
            this.walkEvent.schema = schema;
            return this;
        }

        public WalkEventBuilder validator(KeywordValidator keywordValidator) {
            this.walkEvent.validator = keywordValidator;
            return this;
        }
    }

    public static WalkEventBuilder builder() {
        return new WalkEventBuilder();
    }

    public NodePath getEvaluationPath() {
        return this.evaluationPath;
    }

    public ExecutionContext getExecutionContext() {
        return this.executionContext;
    }

    public NodePath getInstanceLocation() {
        return this.instanceLocation;
    }

    public JsonNode getInstanceNode() {
        return this.instanceNode;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public JsonNode getRootNode() {
        return this.rootNode;
    }

    public Schema getSchema() {
        return this.schema;
    }

    public <T extends KeywordValidator> T getValidator() {
        return (T) this.validator;
    }

    public String toString() {
        return "WalkEvent [schemaLocation=" + getSchema().getSchemaLocation() + ", instanceLocation=" + this.instanceLocation + ", evaluationPath=" + this.evaluationPath + "]";
    }
}
