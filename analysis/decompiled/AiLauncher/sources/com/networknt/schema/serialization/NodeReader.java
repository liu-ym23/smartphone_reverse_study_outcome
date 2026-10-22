package com.networknt.schema.serialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.InputFormat;
import com.networknt.schema.serialization.DefaultNodeReader;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public interface NodeReader {
    static DefaultNodeReader.Builder builder() {
        return DefaultNodeReader.builder();
    }

    JsonNode readTree(InputStream inputStream, InputFormat inputFormat) throws IOException;

    JsonNode readTree(String str, InputFormat inputFormat) throws IOException;
}
