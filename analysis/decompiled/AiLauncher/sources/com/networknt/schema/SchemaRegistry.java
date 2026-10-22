package com.networknt.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.dialect.BasicDialectRegistry;
import com.networknt.schema.dialect.DefaultDialectRegistry;
import com.networknt.schema.dialect.Dialect;
import com.networknt.schema.dialect.DialectId;
import com.networknt.schema.dialect.DialectRegistry;
import com.networknt.schema.resource.ResourceLoaders;
import com.networknt.schema.resource.SchemaIdResolvers;
import com.networknt.schema.resource.SchemaLoader;
import com.networknt.schema.serialization.BasicNodeReader;
import com.networknt.schema.serialization.DefaultNodeReader;
import com.networknt.schema.serialization.NodeReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class SchemaRegistry {
    private static final vc.c logger = vc.e.l(SchemaRegistry.class);
    private final String defaultDialectId;
    private final DialectRegistry dialectRegistry;
    private final NodeReader nodeReader;
    private final ConcurrentMap<SchemaLocation, Schema> schemaCache;
    private final boolean schemaCacheEnabled;
    private final SchemaLoader schemaLoader;
    private final SchemaRegistryConfig schemaRegistryConfig;

    public static class Builder {
        private String defaultDialectId;
        private DialectRegistry dialectRegistry = null;
        private NodeReader nodeReader = null;
        private SchemaLoader schemaLoader = null;
        private boolean schemaCacheEnabled = true;
        private SchemaRegistryConfig schemaRegistryConfig = null;

        public SchemaRegistry build() {
            return new SchemaRegistry(this.nodeReader, this.defaultDialectId, this.schemaLoader, this.schemaCacheEnabled, this.dialectRegistry, this.schemaRegistryConfig);
        }

        public Builder defaultDialectId(String str) {
            this.defaultDialectId = str;
            return this;
        }

        public Builder dialectRegistry(DialectRegistry dialectRegistry) {
            this.dialectRegistry = dialectRegistry;
            return this;
        }

        public Builder nodeReader(NodeReader nodeReader) {
            this.nodeReader = nodeReader;
            return this;
        }

        public Builder resourceLoaders(Consumer<ResourceLoaders.Builder> consumer) {
            SchemaLoader schemaLoader = this.schemaLoader;
            SchemaLoader.Builder builder = schemaLoader != null ? SchemaLoader.builder(schemaLoader) : SchemaLoader.builder();
            consumer.accept(builder.getResourceLoadersBuilder());
            this.schemaLoader = builder.build();
            return this;
        }

        public Builder schemaCacheEnabled(boolean z10) {
            this.schemaCacheEnabled = z10;
            return this;
        }

        public Builder schemaIdResolvers(Consumer<SchemaIdResolvers.Builder> consumer) {
            SchemaLoader schemaLoader = this.schemaLoader;
            SchemaLoader.Builder builder = schemaLoader != null ? SchemaLoader.builder(schemaLoader) : SchemaLoader.builder();
            consumer.accept(builder.getSchemaIdResolversBuilder());
            this.schemaLoader = builder.build();
            return this;
        }

        public Builder schemaLoader(SchemaLoader schemaLoader) {
            this.schemaLoader = schemaLoader;
            return this;
        }

        public Builder schemaRegistryConfig(SchemaRegistryConfig schemaRegistryConfig) {
            this.schemaRegistryConfig = schemaRegistryConfig;
            return this;
        }

        public Builder schemas(final Map<String, String> map) {
            return resourceLoaders(new Consumer() { // from class: com.networknt.schema.v
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((ResourceLoaders.Builder) obj).resources((Map<String, String>) map);
                }
            });
        }

        public Builder nodeReader(Consumer<DefaultNodeReader.Builder> consumer) {
            DefaultNodeReader.Builder builder = NodeReader.builder();
            consumer.accept(builder);
            this.nodeReader = builder.build();
            return this;
        }

        public Builder schemaLoader(Consumer<SchemaLoader.Builder> consumer) {
            SchemaLoader schemaLoader = this.schemaLoader;
            SchemaLoader.Builder builder = schemaLoader != null ? SchemaLoader.builder(schemaLoader) : SchemaLoader.builder();
            consumer.accept(builder);
            this.schemaLoader = builder.build();
            return this;
        }

        public Builder schemas(final Function<String, String> function) {
            return resourceLoaders(new Consumer() { // from class: com.networknt.schema.t
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((ResourceLoaders.Builder) obj).resources((Function<String, String>) function);
                }
            });
        }

        public <T> Builder schemas(final Function<String, T> function, final Function<T, String> function2) {
            return resourceLoaders(new Consumer() { // from class: com.networknt.schema.u
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((ResourceLoaders.Builder) obj).resources(function, function2);
                }
            });
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private Schema doCreate(SchemaContext schemaContext, SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, boolean z10) {
        return Schema.from(withDialect(schemaContext, jsonNode), schemaLocation, jsonNode, schema, z10);
    }

    private Dialect getDialect(JsonNode jsonNode, SchemaRegistryConfig schemaRegistryConfig) {
        JsonNode jsonNode2 = jsonNode.get("$schema");
        if (jsonNode2 == null || !jsonNode2.isTextual()) {
            return null;
        }
        return getDialect(jsonNode2.textValue());
    }

    private Dialect getDialectOrDefault(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode.get("$schema");
        if (jsonNode2 == null || jsonNode2.isNull() || jsonNode2.isTextual()) {
            return getDialect((jsonNode2 == null || jsonNode2.isNull()) ? this.defaultDialectId : jsonNode2.textValue());
        }
        throw new SchemaException("Unknown dialect: " + jsonNode2);
    }

    private boolean isYaml(SchemaLocation schemaLocation) {
        String string = schemaLocation.getAbsoluteIri().toString();
        int iLastIndexOf = string.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            return false;
        }
        String strSubstring = string.substring(iLastIndexOf);
        return ".yml".equals(strSubstring) || ".yaml".equals(strSubstring);
    }

    public static String normalizeDialectId(String str) {
        for (SpecificationVersion specificationVersion : SpecificationVersion.values()) {
            if (specificationVersion.getDialectId().equals(str)) {
                return str;
            }
        }
        return str.contains("://json-schema.org/draft") ? str.contains("/draft-07/") ? DialectId.DRAFT_7 : str.contains("/draft/2019-09/") ? DialectId.DRAFT_2019_09 : str.contains("/draft/2020-12/") ? DialectId.DRAFT_2020_12 : str.contains("/draft-04/") ? DialectId.DRAFT_4 : str.contains("/draft-06/") ? DialectId.DRAFT_6 : str : str;
    }

    private void preload(Schema schema) {
        if (getSchemaRegistryConfig().isPreloadSchema()) {
            try {
                schema.initializeValidators();
            } catch (Exception unused) {
            }
        }
    }

    public static SchemaRegistry withDefaultDialect(SpecificationVersion specificationVersion) {
        return withDefaultDialect(specificationVersion, (Consumer<Builder>) null);
    }

    public static SchemaRegistry withDefaultDialectId(String str, Consumer<Builder> consumer) {
        Builder builderDefaultDialectId = builder().defaultDialectId(str);
        if (consumer != null) {
            consumer.accept(builderDefaultDialectId);
        }
        return builderDefaultDialectId.build();
    }

    public static SchemaRegistry withDialect(Dialect dialect) {
        return withDialect(dialect, (Consumer<Builder>) null);
    }

    public static SchemaRegistry withDialects(List<Dialect> list) {
        return withDialects(list, null);
    }

    public Schema create(SchemaContext schemaContext, SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema) {
        return doCreate(schemaContext, schemaLocation, jsonNode, schema, false);
    }

    public SchemaContext createSchemaContext(JsonNode jsonNode) {
        return new SchemaContext(getDialectOrDefault(jsonNode), this);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[Catch: IOException -> 0x0076, SYNTHETIC, TRY_LEAVE, TryCatch #1 {IOException -> 0x0076, blocks: (B:26:0x0072, B:43:0x00a2, B:42:0x009f, B:38:0x0099), top: B:52:0x0010, inners: #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.networknt.schema.Schema getMappedSchema(com.networknt.schema.SchemaLocation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.networknt.schema.SchemaRegistry.getMappedSchema(com.networknt.schema.SchemaLocation):com.networknt.schema.Schema");
    }

    public Schema getSchema(String str) {
        return getSchema(str, InputFormat.JSON);
    }

    public SchemaLoader getSchemaLoader() {
        return this.schemaLoader;
    }

    public SchemaLocation getSchemaLocation(SchemaLocation schemaLocation) {
        return schemaLocation != null ? schemaLocation : SchemaLocation.DOCUMENT;
    }

    public SchemaRegistryConfig getSchemaRegistryConfig() {
        return this.schemaRegistryConfig;
    }

    public Schema loadSchema(SchemaLocation schemaLocation) {
        Schema mappedSchema;
        if (!this.schemaCacheEnabled) {
            return getMappedSchema(schemaLocation);
        }
        Schema schema = this.schemaCache.get(schemaLocation);
        if (schema != null) {
            return schema;
        }
        synchronized (this) {
            try {
                mappedSchema = this.schemaCache.get(schemaLocation);
                if (mappedSchema == null && (mappedSchema = getMappedSchema(schemaLocation)) != null) {
                    this.schemaCache.put(schemaLocation, mappedSchema);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mappedSchema;
    }

    public Schema newSchema(SchemaLocation schemaLocation, JsonNode jsonNode) {
        Schema schemaDoCreate = doCreate(createSchemaContext(jsonNode), getSchemaLocation(schemaLocation), jsonNode, null, false);
        preload(schemaDoCreate);
        return schemaDoCreate;
    }

    public JsonNode readTree(String str, InputFormat inputFormat) throws IOException {
        return this.nodeReader.readTree(str, inputFormat);
    }

    private SchemaRegistry(NodeReader nodeReader, String str, SchemaLoader schemaLoader, boolean z10, DialectRegistry dialectRegistry, SchemaRegistryConfig schemaRegistryConfig) {
        this.schemaCache = new ConcurrentHashMap();
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("defaultDialectId must not be null or empty");
        }
        this.nodeReader = nodeReader == null ? BasicNodeReader.getInstance() : nodeReader;
        this.defaultDialectId = str;
        this.schemaLoader = schemaLoader == null ? SchemaLoader.getDefault() : schemaLoader;
        this.schemaCacheEnabled = z10;
        this.dialectRegistry = dialectRegistry == null ? new DefaultDialectRegistry() : dialectRegistry;
        this.schemaRegistryConfig = schemaRegistryConfig == null ? SchemaRegistryConfig.getInstance() : schemaRegistryConfig;
    }

    public static Builder builder(SchemaRegistry schemaRegistry) {
        return builder().schemaLoader(schemaRegistry.schemaLoader).defaultDialectId(schemaRegistry.defaultDialectId).nodeReader(schemaRegistry.nodeReader).dialectRegistry(schemaRegistry.dialectRegistry).schemaRegistryConfig(schemaRegistry.schemaRegistryConfig);
    }

    public static SchemaRegistry withDefaultDialect(SpecificationVersion specificationVersion, Consumer<Builder> consumer) {
        return withDefaultDialectId(Specification.getDialect(specificationVersion).getId(), consumer);
    }

    public static SchemaRegistry withDialect(Dialect dialect, Consumer<Builder> consumer) {
        Builder builderDialectRegistry = builder().defaultDialectId(dialect.getId()).dialectRegistry(new BasicDialectRegistry(dialect));
        if (consumer != null) {
            consumer.accept(builderDialectRegistry);
        }
        return builderDialectRegistry.build();
    }

    public static SchemaRegistry withDialects(List<Dialect> list, Consumer<Builder> consumer) {
        Builder builderDialectRegistry = builder().defaultDialectId(list.get(0).getId()).dialectRegistry(new BasicDialectRegistry(list));
        if (consumer != null) {
            consumer.accept(builderDialectRegistry);
        }
        return builderDialectRegistry.build();
    }

    public Schema getSchema(String str, InputFormat inputFormat) {
        try {
            return newSchema(null, readTree(str, inputFormat));
        } catch (IOException e10) {
            logger.error("Failed to load json schema!", e10);
            throw new SchemaException(e10);
        }
    }

    public JsonNode readTree(InputStream inputStream, InputFormat inputFormat) throws IOException {
        return this.nodeReader.readTree(inputStream, inputFormat);
    }

    public static SchemaRegistry withDefaultDialect(Dialect dialect) {
        return withDefaultDialect(dialect, (Consumer<Builder>) null);
    }

    public Dialect getDialect(String str) {
        return this.dialectRegistry.getDialect(normalizeDialectId(str), this);
    }

    public static SchemaRegistry withDefaultDialect(Dialect dialect, Consumer<Builder> consumer) {
        Builder builderDialectRegistry = builder().defaultDialectId(dialect.getId()).dialectRegistry(new DefaultDialectRegistry(dialect));
        if (consumer != null) {
            consumer.accept(builderDialectRegistry);
        }
        return builderDialectRegistry.build();
    }

    private SchemaContext withDialect(SchemaContext schemaContext, JsonNode jsonNode) {
        Dialect dialect = getDialect(jsonNode, schemaContext.getSchemaRegistryConfig());
        return (dialect == null || dialect.getId().equals(schemaContext.getDialect().getId())) ? schemaContext : new SchemaContext(dialect, schemaContext.getSchemaRegistry(), schemaContext.getSchemaReferences(), schemaContext.getSchemaResources(), schemaContext.getDynamicAnchors());
    }

    public Schema getSchema(InputStream inputStream) {
        return getSchema(inputStream, InputFormat.JSON);
    }

    public Schema getSchema(InputStream inputStream, InputFormat inputFormat) {
        try {
            return newSchema(null, readTree(inputStream, inputFormat));
        } catch (IOException e10) {
            logger.error("Failed to load json schema!", e10);
            throw new SchemaException(e10);
        }
    }

    public Schema getSchema(SchemaLocation schemaLocation) {
        Schema schemaLoadSchema = loadSchema(schemaLocation);
        preload(schemaLoadSchema);
        return schemaLoadSchema;
    }

    public Schema getSchema(SchemaLocation schemaLocation, JsonNode jsonNode) {
        return newSchema(schemaLocation, jsonNode);
    }

    public Schema getSchema(SchemaLocation schemaLocation, String str, InputFormat inputFormat) {
        try {
            return newSchema(schemaLocation, readTree(str, inputFormat));
        } catch (IOException e10) {
            logger.error("Failed to load json schema!", e10);
            throw new SchemaException(e10);
        }
    }

    public Schema getSchema(SchemaLocation schemaLocation, InputStream inputStream, InputFormat inputFormat) {
        try {
            return newSchema(schemaLocation, readTree(inputStream, inputFormat));
        } catch (IOException e10) {
            logger.error("Failed to load json schema!", e10);
            throw new SchemaException(e10);
        }
    }

    public Schema getSchema(JsonNode jsonNode) {
        return newSchema(null, jsonNode);
    }
}
