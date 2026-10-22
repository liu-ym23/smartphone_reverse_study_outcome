package com.networknt.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.dialect.Dialect;
import com.networknt.schema.keyword.KeywordValidator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public class SchemaContext {
    private final Dialect dialect;
    private final boolean discriminatorKeywordEnabled;
    private final ConcurrentMap<String, Schema> dynamicAnchors;
    private final boolean nullableKeywordEnabled;
    private final ConcurrentMap<String, Schema> schemaReferences;
    private final SchemaRegistry schemaRegistry;
    private final ConcurrentMap<String, Schema> schemaResources;

    public SchemaContext(Dialect dialect, SchemaRegistry schemaRegistry) {
        this(dialect, schemaRegistry, new ConcurrentHashMap(), new ConcurrentHashMap(), new ConcurrentHashMap());
    }

    public Dialect getDialect() {
        return this.dialect;
    }

    public ConcurrentMap<String, Schema> getDynamicAnchors() {
        return this.dynamicAnchors;
    }

    public ConcurrentMap<String, Schema> getSchemaReferences() {
        return this.schemaReferences;
    }

    public SchemaRegistry getSchemaRegistry() {
        return this.schemaRegistry;
    }

    public SchemaRegistryConfig getSchemaRegistryConfig() {
        return this.schemaRegistry.getSchemaRegistryConfig();
    }

    public ConcurrentMap<String, Schema> getSchemaResources() {
        return this.schemaResources;
    }

    public boolean isDiscriminatorKeywordEnabled() {
        return this.discriminatorKeywordEnabled;
    }

    public boolean isNullableKeywordEnabled() {
        return this.nullableKeywordEnabled;
    }

    public Schema newSchema(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema) {
        return getSchemaRegistry().create(this, schemaLocation, jsonNode, schema);
    }

    public KeywordValidator newValidator(SchemaLocation schemaLocation, String str, JsonNode jsonNode, Schema schema) {
        return this.dialect.newValidator(this, schemaLocation, str, jsonNode, schema);
    }

    public String resolveSchemaId(JsonNode jsonNode) {
        return this.dialect.readId(jsonNode);
    }

    public SchemaContext(Dialect dialect, SchemaRegistry schemaRegistry, ConcurrentMap<String, Schema> concurrentMap, ConcurrentMap<String, Schema> concurrentMap2, ConcurrentMap<String, Schema> concurrentMap3) {
        if (dialect == null) {
            throw new IllegalArgumentException("Dialect must not be null");
        }
        if (schemaRegistry == null) {
            throw new IllegalArgumentException("SchemaRegistry must not be null");
        }
        this.dialect = dialect;
        this.schemaRegistry = schemaRegistry;
        this.schemaReferences = concurrentMap;
        this.schemaResources = concurrentMap2;
        this.dynamicAnchors = concurrentMap3;
        if (dialect.getKeywords().containsKey("discriminator")) {
            this.discriminatorKeywordEnabled = true;
        } else {
            this.discriminatorKeywordEnabled = false;
        }
        if (dialect.getKeywords().containsKey("nullable")) {
            this.nullableKeywordEnabled = true;
        } else {
            this.nullableKeywordEnabled = false;
        }
    }
}
