package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes39.dex */
public class MultiModelLoaderFactory {
    private static final Factory DEFAULT_FACTORY = null;
    private static final ModelLoader<Object, Object> EMPTY_MODEL_LOADER = null;
    private final Set<Entry<?, ?>> alreadyUsedEntries;
    private final List<Entry<?, ?>> entries;
    private final Factory factory;
    private final Pools.Pool<List<Throwable>> throwableListPool;

    public static class EmptyModelLoader implements ModelLoader<Object, Object> {
        public EmptyModelLoader() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public ModelLoader.LoadData<Object> buildLoadData(Object r100, int r101, int r102, Options r103) {
            return null;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(Object r100) {
            return false;
        }
    }

    public static class Entry<Model, Data> {
        final Class<Data> dataClass;
        final ModelLoaderFactory<? extends Model, ? extends Data> factory;
        private final Class<Model> modelClass;

        public boolean handles(Class<?> r100) {
            return this.modelClass.isAssignableFrom(r100);
        }

        public boolean handles(Class<?> r100, Class<?> r101) {
            if (handles(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.dataClass.isAssignableFrom(r101) == false) goto L7;
            return true;
        }

        public Entry(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<? extends Model, ? extends Data> r102) {
            this.modelClass = r100;
            this.dataClass = r101;
            this.factory = r102;
        }
    }

    public static class Factory {
        public Factory() {
        }

        public <Model, Data> MultiModelLoader<Model, Data> build(List<ModelLoader<Model, Data>> r100, Pools.Pool<List<Throwable>> r101) {
            return new MultiModelLoader(r100, r101);
        }
    }

    static {
        DEFAULT_FACTORY = new Factory();
        EMPTY_MODEL_LOADER = new EmptyModelLoader();
    }

    private static <Model, Data> ModelLoader<Model, Data> emptyModelLoader() {
        return (ModelLoader<Model, Data>) EMPTY_MODEL_LOADER;
    }

    public MultiModelLoaderFactory(Pools.Pool<List<Throwable>> r100) {
        this(r100, DEFAULT_FACTORY);
    }

    private <Model, Data> ModelLoaderFactory<Model, Data> getFactory(Entry<?, ?> r100) {
        return (ModelLoaderFactory<Model, Data>) r100.factory;
    }

    public synchronized <Model> List<ModelLoader<Model, ?>> build(Class<Model> r100) {
        monitor-enter(this);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<Entry<?, ?>> r102 = this.entries.iterator();     // Catch: Throwable -> L15
    L5:
        if (r102.hasNext() == false) goto L13;
        Entry<?, ?> r103 = r102.next();     // Catch: Throwable -> L15
        if (this.alreadyUsedEntries.contains(r103) == true) goto L5;
        if (r103.handles(r100) == false) goto L5;
        this.alreadyUsedEntries.add(r103);     // Catch: Throwable -> L15
        r101.add(build(r103));     // Catch: Throwable -> L15
        this.alreadyUsedEntries.remove(r103);     // Catch: Throwable -> L15
        goto L5
    L13:
        monitor-exit(this);
        return r101;
    L15:
        th = move-exception;
        this.alreadyUsedEntries.clear();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized List<Class<?>> getDataClasses(Class<?> r100) {
        monitor-enter(this);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L14
        Iterator<Entry<?, ?>> r102 = this.entries.iterator();     // Catch: Throwable -> L14
    L5:
        if (r102.hasNext() == false) goto L12;
        Entry<?, ?> r103 = r102.next();     // Catch: Throwable -> L14
        if (r101.contains(r103.dataClass) == true) goto L5;
        if (r103.handles(r100) == false) goto L5;
        r101.add(r103.dataClass);     // Catch: Throwable -> L14
        goto L5
    L12:
        monitor-exit(this);
        return r101;
    L14:
        th = move-exception;
        throw th;
    }

    private <Model, Data> ModelLoader<Model, Data> build(Entry<?, ?> r100) {
        return (ModelLoader) Preconditions.checkNotNull(r100.factory.build(this));
    }

    public MultiModelLoaderFactory(Pools.Pool<List<Throwable>> r100, Factory r101) {
        this.entries = new ArrayList();
        this.alreadyUsedEntries = new HashSet();
        this.throwableListPool = r100;
        this.factory = r101;
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(Class<Model> r100, Class<Data> r101) {
        monitor-enter(this);
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L28
        Iterator<Entry<?, ?>> r103 = this.entries.iterator();     // Catch: Throwable -> L28
        boolean r104 = false;
    L5:
        if (r103.hasNext() == false) goto L13;
        Entry<?, ?> r105 = r103.next();     // Catch: Throwable -> L28
        if (this.alreadyUsedEntries.contains(r105) == true) goto L8;
        if (r105.handles(r100, r101) == false) goto L5;
        this.alreadyUsedEntries.add(r105);     // Catch: Throwable -> L28
        r102.add(build(r105));     // Catch: Throwable -> L28
        this.alreadyUsedEntries.remove(r105);     // Catch: Throwable -> L28
        goto L5
    L8:
        r104 = true;
        goto L5
    L13:
        if (r102.size() <= 1) goto L18;
        MultiModelLoader<Model, Data> r106 = this.factory.build(r102, this.throwableListPool);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r106;
    L18:
        if (r102.size() != 1) goto L22;
        ModelLoader<Model, Data> r107 = (ModelLoader) ListProtector.get(r102, 0);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r107;
    L22:
        if (r104 == false) goto L27;
        ModelLoader<Model, Data> r108 = emptyModelLoader();     // Catch: Throwable -> L28
        monitor-exit(this);
        return r108;
    L27:
        throw new Registry.NoModelLoaderAvailableException(r100, r101);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        this.alreadyUsedEntries.clear();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> remove(Class<Model> r100, Class<Data> r101) {
        monitor-enter(this);
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L12
        Iterator<Entry<?, ?>> r103 = this.entries.iterator();     // Catch: Throwable -> L12
    L5:
        if (r103.hasNext() == false) goto L10;
        Entry<?, ?> r104 = r103.next();     // Catch: Throwable -> L12
        if (r104.handles(r100, r101) == false) goto L5;
        r103.remove();     // Catch: Throwable -> L12
        r102.add(getFactory(r104));     // Catch: Throwable -> L12
        goto L5
    L10:
        monitor-exit(this);
        return r102;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void append(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<? extends Model, ? extends Data> r102) {
        monitor-enter(this);
        add(r100, r101, r102, true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void prepend(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<? extends Model, ? extends Data> r102) {
        monitor-enter(this);
        add(r100, r101, r102, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> replace(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<? extends Model, ? extends Data> r102) {
        monitor-enter(this);
        List<ModelLoaderFactory<? extends Model, ? extends Data>> r103 = remove(r100, r101);     // Catch: Throwable -> L6
        append(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }

    private <Model, Data> void add(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<? extends Model, ? extends Data> r102, boolean r103) {
        Entry r104 = new Entry(r100, r101, r102);
        List<Entry<?, ?>> r105 = this.entries;
        if (r103 == false) goto L5;
        int r106 = r105.size();
    L6:
        ListProtector.add(r105, r106, r104);
        return;
    L5:
        r106 = 0;
        goto L6
    }
}
