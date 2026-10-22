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
public class ItemWalkHandler extends AbstractWalkHandler {
    private final List<WalkListener> itemWalkListeners;

    public static class Builder {
        private List<WalkListener> itemWalkListeners = new ArrayList();

        public ItemWalkHandler build() {
            return new ItemWalkHandler(this.itemWalkListeners);
        }

        public Builder itemWalkListener(WalkListener walkListener) {
            this.itemWalkListeners.add(walkListener);
            return this;
        }

        public Builder itemWalkListeners(Consumer<List<WalkListener>> consumer) {
            consumer.accept(this.itemWalkListeners);
            return this;
        }
    }

    public ItemWalkHandler(List<WalkListener> list) {
        this.itemWalkListeners = list;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.networknt.schema.walk.WalkHandler
    public void postWalk(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator, List<Error> list) {
        runPostWalkListeners(this.itemWalkListeners, constructWalkEvent(executionContext, str, jsonNode, jsonNode2, nodePath, schema, keywordValidator), list);
    }

    @Override // com.networknt.schema.walk.WalkHandler
    public boolean preWalk(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator) {
        return runPreWalkListeners(this.itemWalkListeners, constructWalkEvent(executionContext, str, jsonNode, jsonNode2, nodePath, schema, keywordValidator));
    }
}
