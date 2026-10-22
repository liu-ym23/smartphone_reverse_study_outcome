package com.networknt.schema.serialization.node;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

/* loaded from: classes2.dex */
public interface JsonNodeFactoryFactory {
    JsonNodeFactory getJsonNodeFactory(JsonParser jsonParser);
}
