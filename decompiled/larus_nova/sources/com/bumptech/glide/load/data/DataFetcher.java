package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes39.dex */
public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void onDataReady(T r100);

        void onLoadFailed(Exception r100);
    }

    void cancel();

    void cleanup();

    Class<T> getDataClass();

    DataSource getDataSource();

    void loadData(Priority r100, DataCallback<? super T> r101);
}
