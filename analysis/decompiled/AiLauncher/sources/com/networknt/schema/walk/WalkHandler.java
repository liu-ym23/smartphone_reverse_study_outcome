package com.networknt.schema.walk;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.keyword.KeywordValidator;
import com.networknt.schema.path.NodePath;
import java.util.List;

/* loaded from: classes2.dex */
public interface WalkHandler {
    void postWalk(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator, List<Error> list);

    boolean preWalk(ExecutionContext executionContext, String str, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, Schema schema, KeywordValidator keywordValidator);
}
