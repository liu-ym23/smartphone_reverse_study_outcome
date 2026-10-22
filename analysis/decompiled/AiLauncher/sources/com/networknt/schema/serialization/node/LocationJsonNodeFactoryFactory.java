package com.networknt.schema.serialization.node;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

/* loaded from: classes2.dex */
public class LocationJsonNodeFactoryFactory implements JsonNodeFactoryFactory {
    private static final LocationJsonNodeFactoryFactory INSTANCE = new LocationJsonNodeFactoryFactory();

    public static LocationJsonNodeFactoryFactory getInstance() {
        return INSTANCE;
    }

    @Override // com.networknt.schema.serialization.node.JsonNodeFactoryFactory
    public JsonNodeFactory getJsonNodeFactory(JsonParser jsonParser) {
        return new LocationJsonNodeFactory(jsonParser);
    }
}
