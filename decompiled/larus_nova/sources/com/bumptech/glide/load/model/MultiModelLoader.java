package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    private final Pools.Pool<List<Throwable>> exceptionListPool;
    private final List<ModelLoader<Model, Data>> modelLoaders;

    public static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
        private DataFetcher.DataCallback<? super Data> callback;
        private int currentIndex;
        private List<Throwable> exceptions;
        private final List<DataFetcher<Data>> fetchers;
        private boolean isCancelled;
        private Priority priority;
        private final Pools.Pool<List<Throwable>> throwableListPool;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            Iterator<DataFetcher<Data>> r100 = this.fetchers.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().cancel();
            goto L4
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
            GlideException r100 = new GlideException("Fetch failed", new ArrayList(this.exceptions));
            r100.setErrorCode(GlideException.ERROR_CODE_FETCH_RESOURCE_FAILED);
            this.callback.onLoadFailed(r100);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            List<Throwable> r100 = this.exceptions;
            if (r100 == null) goto L5;
            this.throwableListPool.release(r100);
        L5:
            this.exceptions = null;
            Iterator<DataFetcher<Data>> r101 = this.fetchers.iterator();
        L7:
            if (r101.hasNext() == false) goto L9;
            r101.next().cleanup();
            goto L7
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Data> getDataClass() {
            return ((DataFetcher) ListProtector.get(this.fetchers, 0)).getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return ((DataFetcher) ListProtector.get(this.fetchers, 0)).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(Data r100) {
            if (r100 == null) goto L4;
            this.callback.onDataReady(r100);
            return;
        L4:
            startNextOrFail();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(Exception r100) {
            ((List) Preconditions.checkNotNull(this.exceptions)).add(r100);
            startNextOrFail();
        }

        public MultiFetcher(List<DataFetcher<Data>> r100, Pools.Pool<List<Throwable>> r101) {
            this.throwableListPool = r101;
            Preconditions.checkNotEmpty(r100);
            this.fetchers = r100;
            this.currentIndex = 0;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r100, DataFetcher.DataCallback<? super Data> r101) {
            this.priority = r100;
            this.callback = r101;
            this.exceptions = this.throwableListPool.acquire();
            ((DataFetcher) ListProtector.get(this.fetchers, this.currentIndex)).loadData(r100, this);
            if (this.isCancelled == false) goto L6;
            cancel();
            return;
        }
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.modelLoaders.toArray()) + '}';
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Model r100) {
        Iterator<ModelLoader<Model, Data>> r101 = this.modelLoaders.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().handles(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public MultiModelLoader(List<ModelLoader<Model, Data>> r100, Pools.Pool<List<Throwable>> r101) {
        this.modelLoaders = r100;
        this.exceptionListPool = r101;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(Model r100, int r101, int r110, Options r111) {
        int r102 = this.modelLoaders.size();
        ArrayList r103 = new ArrayList(r102);
        int r104 = 0;
        Key r105 = null;
    L3:
        if (r104 >= r102) goto L11;
        ModelLoader r106 = (ModelLoader) ListProtector.get(this.modelLoaders, r104);
        if (r106.handles(r100) == false) goto L9;
        ModelLoader.LoadData<Data> r107 = r106.buildLoadData(r100, r101, r110, r111);
        if (r107 == null) goto L9;
        r105 = r107.sourceKey;
        r103.add(r107.fetcher);
    L9:
        r104 = r104 + 1;
        goto L3
    L11:
        if (r103.isEmpty() == true) goto L19;
        if (r105 != null) goto L14;
        return null;
    L14:
        return new ModelLoader.LoadData(r105, new MultiFetcher(r103, this.exceptionListPool));
    L19:
        return null;
    }
}
