package com.networknt.schema.walk;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.keyword.KeywordValidator;
import com.networknt.schema.path.NodePath;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class AbstractWalkHandler implements WalkHandler {
    public WalkEvent constructWalkEvent(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator) {
        return WalkEvent.builder().executionContext(executionContext).instanceLocation(nodePath).keyword(str).instanceNode(jsonNode).rootNode(jsonNode2).schema(schema).validator(keywordValidator).build();
    }

    public void runPostWalkListeners(List<WalkListener> list, WalkEvent walkEvent, List<Error> list2) {
        if (list != null) {
            Iterator<WalkListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onWalkEnd(walkEvent, list2);
            }
        }
    }

    public boolean runPreWalkListeners(List<WalkListener> list, WalkEvent walkEvent) {
        boolean z10 = true;
        if (list != null) {
            Iterator<WalkListener> it = list.iterator();
            while (it.hasNext()) {
                WalkFlow walkFlowOnWalkStart = it.next().onWalkStart(walkEvent);
                if (WalkFlow.SKIP.equals(walkFlowOnWalkStart) || WalkFlow.ABORT.equals(walkFlowOnWalkStart)) {
                    if (WalkFlow.ABORT.equals(walkFlowOnWalkStart)) {
                        return false;
                    }
                    z10 = false;
                }
            }
        }
        return z10;
    }
}
