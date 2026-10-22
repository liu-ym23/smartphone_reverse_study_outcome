package com.networknt.schema.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

/* loaded from: classes2.dex */
public class JsonMapperFactory {

    public static class Holder {
        private static final ObjectMapper INSTANCE = JsonMapper.builder().build();

        private Holder() {
        }
    }

    public static ObjectMapper getInstance() {
        return Holder.INSTANCE;
    }
}
