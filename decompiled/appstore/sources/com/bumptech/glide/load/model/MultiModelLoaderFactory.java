package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiModelLoaderFactory {
    private static final Factory DEFAULT_FACTORY = null;
    private static final ModelLoader<Object, Object> EMPTY_MODEL_LOADER = null;
    private final Set<Entry<?, ?>> alreadyUsedEntries;
    private final List<Entry<?, ?>> entries;
    private final Factory factory;
    private final Pools$Pool<List<Throwable>> throwableListPool;

    public static class EmptyModelLoader implements ModelLoader<Object, Object> {
        public EmptyModelLoader() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        @Nullable
        public ModelLoader.LoadData<Object> buildLoadData(@NonNull Object r10, int r11, int r12, @NonNull Options r13) {
            return null;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(@NonNull Object r10) {
            return false;
        }
    }

    public static class Entry<Model, Data> {
        final Class<Data> dataClass;
        final ModelLoaderFactory<? extends Model, ? extends Data> factory;
        private final Class<Model> modelClass;

        public Entry(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> r12) {
            this.modelClass = r10;
            this.dataClass = r11;
            this.factory = r12;
        }

        public boolean handles(@NonNull Class<?> r10, @NonNull Class<?> r11) {
            if (handles(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.dataClass.isAssignableFrom(r11) == false) goto L7;
            return true;
        }

        public boolean handles(@NonNull Class<?> r10) {
            return this.modelClass.isAssignableFrom(r10);
        }
    }

    public static class Factory {
        public Factory() {
        }

        @NonNull
        public <Model, Data> MultiModelLoader<Model, Data> build(@NonNull List<ModelLoader<Model, Data>> r10, @NonNull Pools$Pool<List<Throwable>> r11) {
            return new MultiModelLoader(r10, r11);
        }
    }

    static {
        DEFAULT_FACTORY = new Factory();
        EMPTY_MODEL_LOADER = new EmptyModelLoader();
    }

    public MultiModelLoaderFactory(@NonNull Pools$Pool<List<Throwable>> r10) {
        this(r10, DEFAULT_FACTORY);
    }

    private <Model, Data> void add(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> r12, boolean r13) {
        Entry<?, ?> r14 = new Entry(r10, r11, r12);
        List<Entry<?, ?>> r15 = this.entries;
        if (r13 == false) goto L5;
        int r16 = r15.size();
    L6:
        r15.add(r16, r14);
        return;
    L5:
        r16 = 0;
        goto L6
    }

    @NonNull
    private static <Model, Data> ModelLoader<Model, Data> emptyModelLoader() {
        return (ModelLoader<Model, Data>) EMPTY_MODEL_LOADER;
    }

    @NonNull
    private <Model, Data> ModelLoaderFactory<Model, Data> getFactory(@NonNull Entry<?, ?> r10) {
        return (ModelLoaderFactory<Model, Data>) r10.factory;
    }

    public synchronized <Model, Data> void append(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> r12) {
        monitor-enter(this);
        add(r10, r11, r12, true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @NonNull
    public synchronized <Model> List<ModelLoader<Model, ?>> build(@NonNull Class<Model> r10) {
        monitor-enter(this);
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L13
        Iterator<Entry<?, ?>> r12 = this.entries.iterator();     // Catch: Throwable -> L13
    L5:
        if (r12.hasNext() == false) goto L15;
        Entry<?, ?> r13 = r12.next();     // Catch: Throwable -> L13
        if (this.alreadyUsedEntries.contains(r13) == true) goto L5;
        if (r13.handles(r10) == false) goto L5;
        this.alreadyUsedEntries.add(r13);     // Catch: Throwable -> L13
        r11.add(build(r13));     // Catch: Throwable -> L13
        this.alreadyUsedEntries.remove(r13);     // Catch: Throwable -> L13
        goto L5
    L15:
        monitor-exit(this);
        return r11;
    L13:
        th = move-exception;
        this.alreadyUsedEntries.clear();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    @NonNull
    public synchronized List<Class<?>> getDataClasses(@NonNull Class<?> r10) {
        monitor-enter(this);
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L12
        Iterator<Entry<?, ?>> r12 = this.entries.iterator();     // Catch: Throwable -> L12
    L5:
        if (r12.hasNext() == false) goto L14;
        Entry<?, ?> r13 = r12.next();     // Catch: Throwable -> L12
        if (r11.contains(r13.dataClass) == true) goto L5;
        if (r13.handles(r10) == false) goto L5;
        r11.add(r13.dataClass);     // Catch: Throwable -> L12
        goto L5
    L14:
        monitor-exit(this);
        return r11;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> void prepend(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> r12) {
        monitor-enter(this);
        add(r10, r11, r12, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> remove(@NonNull Class<Model> r10, @NonNull Class<Data> r11) {
        monitor-enter(this);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L10
        Iterator<Entry<?, ?>> r13 = this.entries.iterator();     // Catch: Throwable -> L10
    L5:
        if (r13.hasNext() == false) goto L12;
        Entry<?, ?> r14 = r13.next();     // Catch: Throwable -> L10
        if (r14.handles(r10, r11) == false) goto L5;
        r13.remove();     // Catch: Throwable -> L10
        r12.add(getFactory(r14));     // Catch: Throwable -> L10
        goto L5
    L12:
        monitor-exit(this);
        return r12;
    L10:
        th = move-exception;
        throw th;
    }

    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> replace(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> r12) {
        monitor-enter(this);
        List<ModelLoaderFactory<? extends Model, ? extends Data>> r13 = remove(r10, r11);     // Catch: Throwable -> L6
        append(r10, r11, r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public MultiModelLoaderFactory(@NonNull Pools$Pool<List<Throwable>> r10, @NonNull Factory r11) {
        this.entries = new ArrayList();
        this.alreadyUsedEntries = new HashSet();
        this.throwableListPool = r10;
        this.factory = r11;
    }

    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> r10, @NonNull Class<Data> r11) {
        monitor-enter(this);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L12
        Iterator<Entry<?, ?>> r13 = this.entries.iterator();     // Catch: Throwable -> L12
        boolean r14 = false;
    L5:
        if (r13.hasNext() == false) goto L15;
        Entry<?, ?> r15 = r13.next();     // Catch: Throwable -> L12
        if (this.alreadyUsedEntries.contains(r15) == true) goto L8;
        if (r15.handles(r10, r11) == false) goto L5;
        this.alreadyUsedEntries.add(r15);     // Catch: Throwable -> L12
        r12.add(build(r15));     // Catch: Throwable -> L12
        this.alreadyUsedEntries.remove(r15);     // Catch: Throwable -> L12
        goto L5
    L8:
        r14 = true;
        goto L5
    L15:
        if (r12.size() <= 1) goto L20;
        MultiModelLoader<Model, Data> r16 = this.factory.build(r12, this.throwableListPool);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r16;
    L20:
        if (r12.size() != 1) goto L24;
        ModelLoader<Model, Data> r17 = (ModelLoader) r12.get(0);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r17;
    L24:
        if (r14 == false) goto L29;
        ModelLoader<Model, Data> r18 = emptyModelLoader();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r18;
    L29:
        throw new Registry.NoModelLoaderAvailableException(r10, r11);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.alreadyUsedEntries.clear();     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    @NonNull
    private <Model, Data> ModelLoader<Model, Data> build(@NonNull Entry<?, ?> r10) {
        return (ModelLoader) Preconditions.checkNotNull(r10.factory.build(this));
    }
}
