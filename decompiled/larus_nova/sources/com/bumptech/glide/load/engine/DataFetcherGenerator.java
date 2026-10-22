package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

/* JADX INFO: loaded from: classes39.dex */
interface DataFetcherGenerator {

    public interface FetcherReadyCallback {
        void onDataFetcherFailed(Key r100, Exception r101, DataFetcher<?> r102, DataSource r103);

        void onDataFetcherReady(Key r100, Object r101, DataFetcher<?> r102, DataSource r103, Key r104);

        void reschedule();
    }

    void cancel();

    boolean startNext();
}
