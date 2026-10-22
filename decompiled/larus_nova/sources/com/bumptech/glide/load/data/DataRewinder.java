package com.bumptech.glide.load.data;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public interface DataRewinder<T> {

    public interface Factory<T> {
        DataRewinder<T> build(T r100);

        Class<T> getDataClass();
    }

    void cleanup();

    T rewindAndGet() throws IOException;
}
