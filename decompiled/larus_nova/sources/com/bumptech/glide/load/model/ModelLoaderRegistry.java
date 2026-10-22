package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class ModelLoaderRegistry {
    private final ModelLoaderCache cache;
    private final MultiModelLoaderFactory multiModelLoaderFactory;

    public static class ModelLoaderCache {
        private final Map<Class<?>, Entry<?>> cachedModelLoaders;

        public static class Entry<Model> {
            final List<ModelLoader<Model, ?>> loaders;

            public Entry(List<ModelLoader<Model, ?>> r100) {
                this.loaders = r100;
            }
        }

        public void clear() {
            this.cachedModelLoaders.clear();
        }

        public ModelLoaderCache() {
            this.cachedModelLoaders = new HashMap();
        }

        public <Model> List<ModelLoader<Model, ?>> get(Class<Model> r100) {
            Entry<?> r101 = this.cachedModelLoaders.get(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            return (List<ModelLoader<Model, ?>>) r101.loaders;
        }

        public <Model> void put(Class<Model> r100, List<ModelLoader<Model, ?>> r101) {
            if (this.cachedModelLoaders.put(r100, new Entry(r101)) != null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already cached loaders for model: " + r100);
        }
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory r100) {
        this.cache = new ModelLoaderCache();
        this.multiModelLoaderFactory = r100;
    }

    private static <A> Class<A> getClass(A r100) {
        return (Class<A>) r100.getClass();
    }

    private synchronized <A> List<ModelLoader<A, ?>> getModelLoadersForClass(Class<A> r100) {
        monitor-enter(this);
        List<ModelLoader<A, ?>> r101 = this.cache.get(r100);     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        r101 = Collections.unmodifiableList(this.multiModelLoaderFactory.build(r100));     // Catch: Throwable -> L8
        this.cache.put(r100, r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    private <Model, Data> void tearDown(List<ModelLoaderFactory<? extends Model, ? extends Data>> r100) {
        Iterator<ModelLoaderFactory<? extends Model, ? extends Data>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().teardown();
        goto L4
    }

    public synchronized List<Class<?>> getDataClasses(Class<?> r100) {
        monitor-enter(this);
        List<Class<?>> r101 = this.multiModelLoaderFactory.getDataClasses(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public <A> List<ModelLoader<A, ?>> getModelLoaders(A r100) {
        List<ModelLoader<A, ?>> r101 = getModelLoadersForClass(getClass(r100));
        if (r101.isEmpty() == true) goto L18;
        int r102 = r101.size();
        List<ModelLoader<A, ?>> r103 = Collections.emptyList();
        boolean r104 = true;
        int r105 = 0;
    L5:
        if (r105 >= r102) goto L13;
        ModelLoader<A, ?> r106 = (ModelLoader) ListProtector.get(r101, r105);
        if (r106.handles(r100) == false) goto L11;
        if (r104 == false) goto L10;
        r103 = new ArrayList(r102 - r105);
        r104 = false;
    L10:
        r103.add(r106);
    L11:
        r105 = r105 + 1;
        goto L5
    L13:
        if (r103.isEmpty() == true) goto L16;
        return r103;
    L16:
        throw new Registry.NoModelLoaderAvailableException(r100, r101);
    L18:
        throw new Registry.NoModelLoaderAvailableException(r100);
    }

    public ModelLoaderRegistry(Pools.Pool<List<Throwable>> r100) {
        this(new MultiModelLoaderFactory(r100));
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(Class<Model> r100, Class<Data> r101) {
        monitor-enter(this);
        ModelLoader<Model, Data> r102 = this.multiModelLoaderFactory.build(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void remove(Class<Model> r100, Class<Data> r101) {
        monitor-enter(this);
        tearDown(this.multiModelLoaderFactory.remove(r100, r101));     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void append(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<? extends Model, ? extends Data> r102) {
        monitor-enter(this);
        this.multiModelLoaderFactory.append(r100, r101, r102);     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void prepend(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<? extends Model, ? extends Data> r102) {
        monitor-enter(this);
        this.multiModelLoaderFactory.prepend(r100, r101, r102);     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void replace(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<? extends Model, ? extends Data> r102) {
        monitor-enter(this);
        tearDown(this.multiModelLoaderFactory.replace(r100, r101, r102));     // Catch: Throwable -> L6
        this.cache.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
