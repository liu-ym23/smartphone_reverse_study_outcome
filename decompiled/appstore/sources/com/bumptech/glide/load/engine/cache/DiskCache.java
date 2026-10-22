package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface DiskCache {

    public interface Factory {
        public static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
        public static final int DEFAULT_DISK_CACHE_SIZE = 262144000;

        @Nullable
        DiskCache build();
    }

    public interface Writer {
        boolean write(@NonNull File r10);
    }

    void clear();

    void delete(Key r10);

    @Nullable
    File get(Key r10);

    void put(Key r10, Writer r11);
}
