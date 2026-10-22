package com.networknt.schema.serialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.InputFormat;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class BasicNodeReader implements NodeReader {

    public static class Holder {
        private static final BasicNodeReader INSTANCE = new BasicNodeReader();

        private Holder() {
        }
    }

    public static BasicNodeReader getInstance() {
        return Holder.INSTANCE;
    }

    public ObjectMapper getObjectMapper(InputFormat inputFormat) {
        if (InputFormat.JSON.equals(inputFormat)) {
            return JsonMapperFactory.getInstance();
        }
        if (InputFormat.YAML.equals(inputFormat)) {
            return YamlMapperFactory.getInstance();
        }
        throw new IllegalArgumentException("Unsupported input format " + inputFormat);
    }

    @Override // com.networknt.schema.serialization.NodeReader
    public JsonNode readTree(String str, InputFormat inputFormat) throws IOException {
        return getObjectMapper(inputFormat).readTree(str);
    }

    @Override // com.networknt.schema.serialization.NodeReader
    public JsonNode readTree(InputStream inputStream, InputFormat inputFormat) throws IOException {
        return getObjectMapper(inputFormat).readTree(inputStream);
    }
}
