package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools$Pool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ModelLoaderRegistry {
    private final ModelLoaderCache cache;
    private final MultiModelLoaderFactory multiModelLoaderFactory;

    public static class ModelLoaderCache {
        private final Map<Class<?>, Entry<?>> cachedModelLoaders;

        public static class Entry<Model> {
            final List<ModelLoader<Model, ?>> loaders;

            public Entry(List<ModelLoader<Model, ?>> r10) {
                this.loaders = r10;
            }
        }

        public ModelLoaderCache() {
            this.cachedModelLoaders = new HashMap();
        }

        public void clear() {
            this.cachedModelLoaders.clear();
        }

        @Nullable
        public <Model> List<ModelLoader<Model, ?>> get(Class<Model> r10) {
            Entry<?> r11 = this.cachedModelLoaders.get(r10);
            if (r11 != null) goto L6;
            return null;
        L6:
            return (List<ModelLoader<Model, ?>>) r11.loaders;
        }

        public <Model> void put(Class<Model> r10, List<ModelLoader<Model, ?>> r11) {
            if (this.cachedModelLoaders.put(r10, new Entry(r11)) != null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already cached loaders for model: " + r10);
        }
    }

    public ModelLoaderRegistry(@NonNull Pools$Pool<List<Throwable>> r10) {
        this(new MultiModelLoaderFactory(r10));
    }

    @NonNull
    private static <A> Class<A> getClass(@NonNull A r10) {
        return (Class<A>) r10.getClass();
    }

    @NonNull
    private synchronized <A> List<ModelLoader<A, ?>> getModelLoadersForClass(@NonNull Class<A> r10) {
        monitor-enter(this);
        List<ModelLoader<A, ?>> r11 = this.cache.get(r10);     // Catch: Throwable -> L7
        if (r11 != null) goto L9;
        r11 = Collections.unmodifiableList(this.multiModelLoaderFactory.build(r10));     // Catch: Throwable -> L7
        this.cache.put(r10, r11);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    private <Model, Data> void tearDown(@NonNull List<ModelLoaderFactory<? extends Model, ? extends Data>> r10) {
        Iterator<ModelLoaderFactory<? extends Model, ? extends Data>> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().teardown();
        goto L4
    }

    public synchronized <Model, Data> void append(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> r12) {
        monitor-enter(this);
        this.multiModelLoaderFactory.append(r10, r11, r12);     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> r10, @NonNull Class<Data> r11) {
        monitor-enter(this);
        ModelLoader<Model, Data> r12 = this.multiModelLoaderFactory.build(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    @NonNull
    public synchronized List<Class<?>> getDataClasses(@NonNull Class<?> r10) {
        monitor-enter(this);
        List<Class<?>> r11 = this.multiModelLoaderFactory.getDataClasses(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @NonNull
    public <A> List<ModelLoader<A, ?>> getModelLoaders(@NonNull A r10) {
        List<ModelLoader<A, ?>> r11 = getModelLoadersForClass(getClass(r10));
        int r12 = r11.size();
        List<ModelLoader<A, ?>> r13 = Collections.emptyList();
        boolean r14 = true;
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L10;
        ModelLoader<A, ?> r16 = r11.get(r15);
        if (r16.handles(r10) == false) goto L9;
        if (r14 == false) goto L8;
        r13 = new ArrayList(r12 - r15);
        r14 = false;
    L8:
        r13.add(r16);
    L9:
        r15 = r15 + 1;
        goto L3
    L10:
        return r13;
    }

    public synchronized <Model, Data> void prepend(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> r12) {
        monitor-enter(this);
        this.multiModelLoaderFactory.prepend(r10, r11, r12);     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void remove(@NonNull Class<Model> r10, @NonNull Class<Data> r11) {
        monitor-enter(this);
        tearDown(this.multiModelLoaderFactory.remove(r10, r11));     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void replace(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> r12) {
        monitor-enter(this);
        tearDown(this.multiModelLoaderFactory.replace(r10, r11, r12));     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private ModelLoaderRegistry(@NonNull MultiModelLoaderFactory r10) {
        this.cache = new ModelLoaderCache();
        this.multiModelLoaderFactory = r10;
    }
}
