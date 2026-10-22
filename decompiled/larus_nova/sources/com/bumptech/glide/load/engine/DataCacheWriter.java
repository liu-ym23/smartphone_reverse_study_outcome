package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.CacheSink;
import com.bumptech.glide.load.engine.cache.DiskCache;

/* JADX INFO: loaded from: classes39.dex */
class DataCacheWriter<DataType> implements DiskCache.Writer {
    private final DataType data;
    private final Encoder<DataType> encoder;
    private final Options options;

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public boolean write(CacheSink r100) {
        return this.encoder.encode(this.data, r100, this.options);
    }

    public DataCacheWriter(Encoder<DataType> r100, DataType r101, Options r102) {
        this.encoder = r100;
        this.data = r101;
        this.options = r102;
    }
}
