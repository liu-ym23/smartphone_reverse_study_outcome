package com.networknt.schema.serialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.InputFormat;
import com.networknt.schema.serialization.node.JsonNodeFactoryFactory;
import com.networknt.schema.serialization.node.LocationJsonNodeFactoryFactory;
import com.networknt.schema.utils.JsonNodes;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class DefaultNodeReader implements NodeReader {
    protected final ObjectMapper jsonMapper;
    protected final JsonNodeFactoryFactory jsonNodeFactoryFactory;
    protected final ObjectMapper yamlMapper;

    public static class Builder extends BuilderSupport<Builder> {
        public NodeReader build() {
            return new DefaultNodeReader(this.jsonMapper, this.yamlMapper, this.jsonNodeFactoryFactory);
        }

        public Builder locationAware() {
            return jsonNodeFactoryFactory(LocationJsonNodeFactoryFactory.getInstance());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.networknt.schema.serialization.DefaultNodeReader.BuilderSupport
        public Builder self() {
            return this;
        }
    }

    public static abstract class BuilderSupport<T> {
        protected ObjectMapper jsonMapper = null;
        protected ObjectMapper yamlMapper = null;
        protected JsonNodeFactoryFactory jsonNodeFactoryFactory = null;

        public T jsonMapper(ObjectMapper objectMapper) {
            this.jsonMapper = objectMapper;
            return self();
        }

        public T jsonNodeFactoryFactory(JsonNodeFactoryFactory jsonNodeFactoryFactory) {
            this.jsonNodeFactoryFactory = jsonNodeFactoryFactory;
            return self();
        }

        public abstract T self();

        public T yamlMapper(ObjectMapper objectMapper) {
            this.yamlMapper = objectMapper;
            return self();
        }
    }

    public DefaultNodeReader(ObjectMapper objectMapper, ObjectMapper objectMapper2, JsonNodeFactoryFactory jsonNodeFactoryFactory) {
        this.jsonMapper = objectMapper;
        this.yamlMapper = objectMapper2;
        this.jsonNodeFactoryFactory = jsonNodeFactoryFactory;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ObjectMapper getJsonMapper() {
        ObjectMapper objectMapper = this.jsonMapper;
        return objectMapper != null ? objectMapper : JsonMapperFactory.getInstance();
    }

    public ObjectMapper getObjectMapper(InputFormat inputFormat) {
        if (InputFormat.JSON.equals(inputFormat)) {
            return getJsonMapper();
        }
        if (InputFormat.YAML.equals(inputFormat)) {
            return getYamlMapper();
        }
        throw new IllegalArgumentException("Unsupported input format " + inputFormat);
    }

    public ObjectMapper getYamlMapper() {
        ObjectMapper objectMapper = this.yamlMapper;
        return objectMapper != null ? objectMapper : YamlMapperFactory.getInstance();
    }

    @Override // com.networknt.schema.serialization.NodeReader
    public JsonNode readTree(String str, InputFormat inputFormat) throws IOException {
        return this.jsonNodeFactoryFactory == null ? getObjectMapper(inputFormat).readTree(str) : JsonNodes.readTree(getObjectMapper(inputFormat), str, this.jsonNodeFactoryFactory);
    }

    @Override // com.networknt.schema.serialization.NodeReader
    public JsonNode readTree(InputStream inputStream, InputFormat inputFormat) throws IOException {
        if (this.jsonNodeFactoryFactory == null) {
            return getObjectMapper(inputFormat).readTree(inputStream);
        }
        return JsonNodes.readTree(getObjectMapper(inputFormat), inputStream, this.jsonNodeFactoryFactory);
    }
}
