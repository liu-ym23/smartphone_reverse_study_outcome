package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public interface DiskCache {

    public interface Factory {
        public static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
        public static final int DEFAULT_DISK_CACHE_SIZE = 262144000;

        DiskCache build();
    }

    public interface Writer {
        boolean write(CacheSink r100);
    }

    void clear();

    void delete(Key r100);

    File get(Key r100);

    void put(Key r100, Writer r101);
}
