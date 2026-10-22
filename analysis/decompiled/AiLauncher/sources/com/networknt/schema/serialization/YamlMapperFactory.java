package com.networknt.schema.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

/* loaded from: classes2.dex */
public class YamlMapperFactory {

    public static class Holder {
        private static final ObjectMapper INSTANCE = YAMLMapper.builder().build();

        private Holder() {
        }
    }

    public static ObjectMapper getInstance() {
        return Holder.INSTANCE;
    }
}
