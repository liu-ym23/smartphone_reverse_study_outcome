package com.networknt.schema.walk;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.keyword.KeywordValidator;
import com.networknt.schema.path.NodePath;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class PropertyWalkHandler extends AbstractWalkHandler {
    private final List<WalkListener> propertyWalkListeners;

    public static class Builder {
        private List<WalkListener> propertyWalkListeners = new ArrayList();

        public PropertyWalkHandler build() {
            return new PropertyWalkHandler(this.propertyWalkListeners);
        }

        public Builder propertyWalkListener(WalkListener walkListener) {
            this.propertyWalkListeners.add(walkListener);
            return this;
        }

        public Builder propertyWalkListeners(Consumer<List<WalkListener>> consumer) {
            consumer.accept(this.propertyWalkListeners);
            return this;
        }
    }

    public PropertyWalkHandler(List<WalkListener> list) {
        this.propertyWalkListeners = list;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.networknt.schema.walk.WalkHandler
    public void postWalk(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator, List<Error> list) {
        runPostWalkListeners(this.propertyWalkListeners, constructWalkEvent(executionContext, str, jsonNode, jsonNode2, nodePath, schema, keywordValidator), list);
    }

    @Override // com.networknt.schema.walk.WalkHandler
    public boolean preWalk(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator) {
        return runPreWalkListeners(this.propertyWalkListeners, constructWalkEvent(executionContext, str, jsonNode, jsonNode2, nodePath, schema, keywordValidator));
    }
}
