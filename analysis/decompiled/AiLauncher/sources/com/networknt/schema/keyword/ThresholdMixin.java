package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;

/* loaded from: classes2.dex */
public interface ThresholdMixin {
    boolean crossesThreshold(JsonNode jsonNode);

    String thresholdValue();
}
