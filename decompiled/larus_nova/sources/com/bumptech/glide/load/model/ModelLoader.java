package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {
        public final List<Key> alternateKeys;
        public final DataFetcher<Data> fetcher;
        public final Key sourceKey;

        public LoadData(Key r100, DataFetcher<Data> r101) {
            this(r100, Collections.emptyList(), r101);
        }

        public LoadData(Key r100, List<Key> r101, DataFetcher<Data> r102) {
            this.sourceKey = (Key) Preconditions.checkNotNull(r100);
            this.alternateKeys = (List) Preconditions.checkNotNull(r101);
            this.fetcher = (DataFetcher) Preconditions.checkNotNull(r102);
        }
    }

    LoadData<Data> buildLoadData(Model r100, int r101, int r102, Options r103);

    boolean handles(Model r100);
}
