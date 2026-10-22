package com.networknt.schema.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class ResourceLoaders extends ArrayList<ResourceLoader> {
    private static final long serialVersionUID = 1;

    public static class Builder {
        private final ResourceLoaders values;

        public Builder() {
            this.values = new ResourceLoaders();
        }

        public Builder add(ResourceLoader resourceLoader) {
            this.values.add(resourceLoader);
            return this;
        }

        public ResourceLoaders build() {
            return this.values;
        }

        public Builder resources(Map<String, String> map) {
            this.values.add(new MapResourceLoader(map));
            return this;
        }

        public Builder values(Consumer<List<ResourceLoader>> consumer) {
            consumer.accept(this.values);
            return this;
        }

        public Builder with(Builder builder) {
            if (!builder.values.isEmpty()) {
                this.values.addAll(builder.values);
            }
            return this;
        }

        public Builder resources(Function<String, String> function) {
            this.values.add(new MapResourceLoader(function));
            return this;
        }

        public Builder(Builder builder) {
            ResourceLoaders resourceLoaders = new ResourceLoaders();
            this.values = resourceLoaders;
            resourceLoaders.addAll(builder.values);
        }

        public <T> Builder resources(Function<String, T> function, Function<T, String> function2) {
            this.values.add(new MapResourceLoader(function, function2));
            return this;
        }
    }

    public ResourceLoaders() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public ResourceLoaders(Collection<? extends ResourceLoader> collection) {
        super(collection);
    }

    public ResourceLoaders(int i10) {
        super(i10);
    }
}
