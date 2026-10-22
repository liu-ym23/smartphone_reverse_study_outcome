package com.networknt.schema.resource;

import com.networknt.schema.AbsoluteIri;
import com.networknt.schema.Error;
import com.networknt.schema.InvalidSchemaException;
import com.networknt.schema.resource.ResourceLoaders;
import com.networknt.schema.resource.SchemaIdResolvers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public class SchemaLoader {
    protected final Predicate<AbsoluteIri> allow;
    protected final Predicate<AbsoluteIri> block;
    protected final List<ResourceLoader> resourceLoaders;
    protected final List<SchemaIdResolver> schemaIdResolvers;
    private static final MetaSchemaIdResolver META_SCHEMA_ID_RESOLVER = MetaSchemaIdResolver.getInstance();
    private static final ClasspathResourceLoader CLASSPATH_RESOURCE_LOADER = ClasspathResourceLoader.getInstance();

    public static class Builder {
        private SchemaIdResolvers.Builder schemaIdResolversBuilder = new SchemaIdResolvers.Builder();
        private ResourceLoaders.Builder resourceLoadersBuilder = new ResourceLoaders.Builder();
        private Predicate<AbsoluteIri> allow = null;
        private Predicate<AbsoluteIri> block = null;
        private boolean fetchRemoteResources = false;

        public Builder allow(Predicate<AbsoluteIri> predicate) {
            this.allow = predicate;
            return this;
        }

        public Builder block(Predicate<AbsoluteIri> predicate) {
            this.block = predicate;
            return this;
        }

        public SchemaLoader build() {
            if (this.fetchRemoteResources) {
                this.resourceLoadersBuilder.add(IriResourceLoader.getInstance());
            }
            return new SchemaLoader(this.schemaIdResolversBuilder.build(), this.resourceLoadersBuilder.build(), this.allow, this.block);
        }

        public Builder fetchRemoteResources(boolean z10) {
            this.fetchRemoteResources = z10;
            return this;
        }

        public ResourceLoaders.Builder getResourceLoadersBuilder() {
            return this.resourceLoadersBuilder;
        }

        public SchemaIdResolvers.Builder getSchemaIdResolversBuilder() {
            return this.schemaIdResolversBuilder;
        }

        public Builder resourceLoaders(Consumer<ResourceLoaders.Builder> consumer) {
            consumer.accept(this.resourceLoadersBuilder);
            return this;
        }

        public Builder schemaIdResolvers(Consumer<SchemaIdResolvers.Builder> consumer) {
            consumer.accept(this.schemaIdResolversBuilder);
            return this;
        }

        public Builder fetchRemoteResources() {
            return fetchRemoteResources(true);
        }
    }

    public static class DefaultHolder {
        private static final SchemaLoader DEFAULT;

        static {
            List list = Collections.EMPTY_LIST;
            DEFAULT = new SchemaLoader((List<SchemaIdResolver>) list, (List<ResourceLoader>) list);
        }

        private DefaultHolder() {
        }
    }

    public static class RemoteFetcher {
        private static final SchemaLoader REMOTE_FETCHER = SchemaLoader.builder().fetchRemoteResources().build();

        private RemoteFetcher() {
        }
    }

    public SchemaLoader(ResourceLoader resourceLoader) {
        this((List<SchemaIdResolver>) Collections.EMPTY_LIST, (List<ResourceLoader>) Collections.singletonList(resourceLoader));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SchemaLoader getDefault() {
        return DefaultHolder.DEFAULT;
    }

    public static SchemaLoader getRemoteFetcher() {
        return RemoteFetcher.REMOTE_FETCHER;
    }

    public InputStreamSource getClasspathResource(AbsoluteIri absoluteIri) {
        return CLASSPATH_RESOURCE_LOADER.getResource(absoluteIri);
    }

    public List<ResourceLoader> getResourceLoaders() {
        return this.resourceLoaders;
    }

    public List<SchemaIdResolver> getSchemaIdResolvers() {
        return this.schemaIdResolvers;
    }

    public InputStreamSource getSchemaResource(AbsoluteIri absoluteIri) {
        Predicate<AbsoluteIri> predicate = this.allow;
        if (predicate != null && !predicate.test(absoluteIri)) {
            throw new InvalidSchemaException(Error.builder().message("Schema from ''{0}'' is not allowed to be loaded.").arguments(absoluteIri).build());
        }
        Predicate<AbsoluteIri> predicate2 = this.block;
        if (predicate2 != null && predicate2.test(absoluteIri)) {
            throw new InvalidSchemaException(Error.builder().message("Schema from ''{0}'' is not allowed to be loaded.").arguments(absoluteIri).build());
        }
        Iterator<SchemaIdResolver> it = this.schemaIdResolvers.iterator();
        AbsoluteIri absoluteIri2 = absoluteIri;
        while (it.hasNext()) {
            AbsoluteIri absoluteIriResolve = it.next().resolve(absoluteIri2);
            if (absoluteIriResolve != null) {
                absoluteIri2 = absoluteIriResolve;
            }
        }
        AbsoluteIri absoluteIriResolveMetaSchemaId = resolveMetaSchemaId(absoluteIri);
        if (absoluteIriResolveMetaSchemaId != null) {
            absoluteIri2 = absoluteIriResolveMetaSchemaId;
        }
        InputStreamSource classpathResource = getClasspathResource(absoluteIri2);
        if (classpathResource != null) {
            return classpathResource;
        }
        Iterator<ResourceLoader> it2 = this.resourceLoaders.iterator();
        while (it2.hasNext()) {
            InputStreamSource resource = it2.next().getResource(absoluteIri2);
            if (resource != null) {
                return resource;
            }
        }
        return null;
    }

    public AbsoluteIri resolveMetaSchemaId(AbsoluteIri absoluteIri) {
        return META_SCHEMA_ID_RESOLVER.resolve(absoluteIri);
    }

    public SchemaLoader(SchemaIdResolver schemaIdResolver, ResourceLoader resourceLoader) {
        this((List<SchemaIdResolver>) Collections.singletonList(schemaIdResolver), (List<ResourceLoader>) Collections.singletonList(resourceLoader));
    }

    public static Builder builder(final SchemaLoader schemaLoader) {
        Builder builder = new Builder();
        if (!schemaLoader.getResourceLoaders().isEmpty()) {
            builder.resourceLoaders(new Consumer() { // from class: com.networknt.schema.resource.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((ResourceLoaders.Builder) obj).values(new Consumer() { // from class: com.networknt.schema.resource.j
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj2) {
                            ((List) obj2).addAll(schemaLoader.resourceLoaders);
                        }
                    });
                }
            });
        }
        if (!schemaLoader.getSchemaIdResolvers().isEmpty()) {
            builder.schemaIdResolvers(new Consumer() { // from class: com.networknt.schema.resource.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((SchemaIdResolvers.Builder) obj).values(new Consumer() { // from class: com.networknt.schema.resource.k
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj2) {
                            ((List) obj2).addAll(schemaLoader.schemaIdResolvers);
                        }
                    });
                }
            });
        }
        builder.allow(schemaLoader.allow);
        builder.block(schemaLoader.block);
        return builder;
    }

    public SchemaLoader(List<SchemaIdResolver> list, List<ResourceLoader> list2) {
        this(list, list2, null, null);
    }

    public SchemaLoader(List<SchemaIdResolver> list, List<ResourceLoader> list2, Predicate<AbsoluteIri> predicate, Predicate<AbsoluteIri> predicate2) {
        this.schemaIdResolvers = list;
        this.resourceLoaders = list2;
        this.allow = predicate;
        this.block = predicate2;
    }

    public SchemaLoader(SchemaLoader schemaLoader) {
        this(new ArrayList(schemaLoader.schemaIdResolvers), new ArrayList(schemaLoader.resourceLoaders));
    }
}
