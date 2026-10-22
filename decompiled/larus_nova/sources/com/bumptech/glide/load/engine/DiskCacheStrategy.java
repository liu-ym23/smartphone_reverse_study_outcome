package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* JADX INFO: loaded from: classes39.dex */
public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy ALL = null;
    public static final DiskCacheStrategy AUTOMATIC = null;
    public static final DiskCacheStrategy DATA = null;
    public static final DiskCacheStrategy NONE = null;
    public static final DiskCacheStrategy RESOURCE = null;

    public DiskCacheStrategy() {
    }

    public abstract boolean decodeCachedData();

    public abstract boolean decodeCachedResource();

    public abstract String getName();

    public abstract boolean isDataCacheable(DataSource r100);

    public abstract boolean isResourceCacheable(boolean r100, DataSource r101, EncodeStrategy r102);

    static {
        ALL = new AnonymousClass1();
        NONE = new AnonymousClass2();
        DATA = new AnonymousClass3();
        RESOURCE = new AnonymousClass4();
        AUTOMATIC = new AnonymousClass5();
    }
}
