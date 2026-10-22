package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {
        public final List<Key> alternateKeys;
        public final DataFetcher<Data> fetcher;
        public final Key sourceKey;

        public LoadData(@NonNull Key r10, @NonNull DataFetcher<Data> r11) {
            this(r10, Collections.emptyList(), r11);
        }

        public LoadData(@NonNull Key r10, @NonNull List<Key> r11, @NonNull DataFetcher<Data> r12) {
            this.sourceKey = (Key) Preconditions.checkNotNull(r10);
            this.alternateKeys = (List) Preconditions.checkNotNull(r11);
            this.fetcher = (DataFetcher) Preconditions.checkNotNull(r12);
        }
    }

    @Nullable
    LoadData<Data> buildLoadData(@NonNull Model r10, int r11, int r12, @NonNull Options r13);

    boolean handles(@NonNull Model r10);
}
