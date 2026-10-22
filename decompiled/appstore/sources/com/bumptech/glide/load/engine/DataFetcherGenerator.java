package com.bumptech.glide.load.engine;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

/* JADX INFO: loaded from: classes.dex */
interface DataFetcherGenerator {

    public interface FetcherReadyCallback {
        void onDataFetcherFailed(Key r10, Exception r11, DataFetcher<?> r12, DataSource r13);

        void onDataFetcherReady(Key r10, @Nullable Object r11, DataFetcher<?> r12, DataSource r13, Key r14);

        void reschedule();
    }

    void cancel();

    boolean startNext();
}
