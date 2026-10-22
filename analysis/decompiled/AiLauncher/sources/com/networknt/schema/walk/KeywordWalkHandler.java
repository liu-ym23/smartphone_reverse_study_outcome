package com.networknt.schema.walk;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.keyword.Keyword;
import com.networknt.schema.keyword.KeywordValidator;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.walk.KeywordWalkHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class KeywordWalkHandler extends AbstractWalkHandler {
    private final List<WalkListener> allKeywordWalkListeners;
    private final Map<String, List<WalkListener>> keywordWalkListenersMap;

    public static class Builder {
        private Map<String, List<WalkListener>> keywordWalkListeners = new HashMap();
        private List<WalkListener> allKeywordWalkListeners = new ArrayList();

        public static /* synthetic */ List a(String str) {
            return new ArrayList();
        }

        public KeywordWalkHandler build() {
            return new KeywordWalkHandler(this.allKeywordWalkListeners, this.keywordWalkListeners);
        }

        public Builder keywordWalkListener(String str, WalkListener walkListener) {
            this.keywordWalkListeners.computeIfAbsent(str, new Function() { // from class: com.networknt.schema.walk.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return KeywordWalkHandler.Builder.a((String) obj);
                }
            }).add(walkListener);
            return this;
        }

        public Builder keywordWalkListeners(Consumer<Map<String, List<WalkListener>>> consumer) {
            consumer.accept(this.keywordWalkListeners);
            return this;
        }

        public Builder keywordWalkListener(Keyword keyword, WalkListener walkListener) {
            return keywordWalkListener(keyword.getValue(), walkListener);
        }

        public Builder keywordWalkListener(WalkListener walkListener) {
            this.allKeywordWalkListeners.add(walkListener);
            return this;
        }
    }

    public KeywordWalkHandler(List<WalkListener> list, Map<String, List<WalkListener>> map) {
        this.allKeywordWalkListeners = list;
        this.keywordWalkListenersMap = map;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.networknt.schema.walk.WalkHandler
    public void postWalk(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator, List<Error> list) {
        WalkEvent walkEventConstructWalkEvent = constructWalkEvent(executionContext, str, jsonNode, jsonNode2, nodePath, schema, keywordValidator);
        runPostWalkListeners(this.keywordWalkListenersMap.get(str), walkEventConstructWalkEvent, list);
        runPostWalkListeners(this.allKeywordWalkListeners, walkEventConstructWalkEvent, list);
    }

    @Override // com.networknt.schema.walk.WalkHandler
    public boolean preWalk(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator) {
        WalkEvent walkEventConstructWalkEvent = constructWalkEvent(executionContext, str, jsonNode, jsonNode2, nodePath, schema, keywordValidator);
        boolean zRunPreWalkListeners = runPreWalkListeners(this.keywordWalkListenersMap.get(str), walkEventConstructWalkEvent);
        if (zRunPreWalkListeners) {
            runPreWalkListeners(this.allKeywordWalkListeners, walkEventConstructWalkEvent);
        }
        return zRunPreWalkListeners;
    }
}
