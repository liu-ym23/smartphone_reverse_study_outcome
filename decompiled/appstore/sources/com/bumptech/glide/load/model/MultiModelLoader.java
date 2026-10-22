package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    private final Pools$Pool<List<Throwable>> exceptionListPool;
    private final List<ModelLoader<Model, Data>> modelLoaders;

    public static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
        private DataFetcher.DataCallback<? super Data> callback;
        private int currentIndex;

        @Nullable
        private List<Throwable> exceptions;
        private final List<DataFetcher<Data>> fetchers;
        private boolean isCancelled;
        private Priority priority;
        private final Pools$Pool<List<Throwable>> throwableListPool;

        public MultiFetcher(@NonNull List<DataFetcher<Data>> r10, @NonNull Pools$Pool<List<Throwable>> r11) {
            this.throwableListPool = r11;
            Preconditions.checkNotEmpty(r10);
            this.fetchers = r10;
            this.currentIndex = 0;
        }

        private void startNextOrFail() {
            if (this.isCancelled == false) goto L6;
            return;
        L6:
            if (this.currentIndex >= (this.fetchers.size() - 1)) goto L8;
            this.currentIndex++;
            loadData(this.priority, this.callback);
            return;
        L8:
            Preconditions.checkNotNull(this.exceptions);
            this.callback.onLoadFailed(new GlideException("Fetch failed", new ArrayList(this.exceptions)));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            Iterator<DataFetcher<Data>> r10 = this.fetchers.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r10.next().cancel();
            goto L4
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            List<Throwable> r10 = this.exceptions;
            if (r10 == null) goto L5;
            this.throwableListPool.release(r10);
        L5:
            this.exceptions = null;
            Iterator<DataFetcher<Data>> r11 = this.fetchers.iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            r11.next().cleanup();
            goto L7
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Data> getDataClass() {
            return this.fetchers.get(0).getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return this.fetchers.get(0).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority r10, @NonNull DataFetcher.DataCallback<? super Data> r11) {
            this.priority = r10;
            this.callback = r11;
            this.exceptions = this.throwableListPool.acquire();
            this.fetchers.get(this.currentIndex).loadData(r10, this);
            if (this.isCancelled == false) goto L6;
            cancel();
            return;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(@Nullable Data r10) {
            if (r10 == null) goto L4;
            this.callback.onDataReady(r10);
            return;
        L4:
            startNextOrFail();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(@NonNull Exception r10) {
            ((List) Preconditions.checkNotNull(this.exceptions)).add(r10);
            startNextOrFail();
        }
    }

    public MultiModelLoader(@NonNull List<ModelLoader<Model, Data>> r10, @NonNull Pools$Pool<List<Throwable>> r11) {
        this.modelLoaders = r10;
        this.exceptionListPool = r11;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Model r10, int r11, int r12, @NonNull Options r13) {
        int r14 = this.modelLoaders.size();
        ArrayList r15 = new ArrayList(r14);
        int r16 = 0;
        Key r17 = null;
    L3:
        if (r16 >= r14) goto L11;
        ModelLoader<Model, Data> r18 = this.modelLoaders.get(r16);
        if (r18.handles(r10) == false) goto L9;
        ModelLoader.LoadData<Data> r19 = r18.buildLoadData(r10, r11, r12, r13);
        if (r19 == null) goto L9;
        r17 = r19.sourceKey;
        r15.add(r19.fetcher);
    L9:
        r16 = r16 + 1;
        goto L3
    L11:
        if (r15.isEmpty() == true) goto L19;
        if (r17 != null) goto L14;
        return null;
    L14:
        return new ModelLoader.LoadData(r17, new MultiFetcher(r15, this.exceptionListPool));
    L19:
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Model r10) {
        Iterator<ModelLoader<Model, Data>> r11 = this.modelLoaders.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r11.next().handles(r10) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.modelLoaders.toArray()) + '}';
    }
}
