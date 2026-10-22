package com.networknt.schema.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public class SchemaIdResolvers extends ArrayList<SchemaIdResolver> {
    private static final long serialVersionUID = 1;

    public static class Builder {
        private final SchemaIdResolvers values;

        public Builder() {
            this.values = new SchemaIdResolvers();
        }

        public Builder add(SchemaIdResolver schemaIdResolver) {
            this.values.add(schemaIdResolver);
            return this;
        }

        public SchemaIdResolvers build() {
            return this.values;
        }

        public Builder mapPrefix(String str, String str2) {
            this.values.add(new PrefixSchemaIdResolver(str, str2));
            return this;
        }

        public Builder mappings(Map<String, String> map) {
            this.values.add(new MapSchemaIdResolver(map));
            return this;
        }

        public Builder values(Consumer<List<SchemaIdResolver>> consumer) {
            consumer.accept(this.values);
            return this;
        }

        public Builder with(Builder builder) {
            if (!builder.values.isEmpty()) {
                this.values.addAll(builder.values);
            }
            return this;
        }

        public Builder mappings(Function<String, String> function) {
            this.values.add(new MapSchemaIdResolver(function));
            return this;
        }

        public Builder(Builder builder) {
            SchemaIdResolvers schemaIdResolvers = new SchemaIdResolvers();
            this.values = schemaIdResolvers;
            schemaIdResolvers.addAll(builder.values);
        }

        public Builder mappings(Predicate<String> predicate, Function<String, String> function) {
            this.values.add(new MapSchemaIdResolver(predicate, function));
            return this;
        }
    }

    public SchemaIdResolvers() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public SchemaIdResolvers(Collection<? extends SchemaIdResolver> collection) {
        super(collection);
    }

    public SchemaIdResolvers(int i10) {
        super(i10);
    }
}
