package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class GlideBuilder {
    private GlideExecutor animationExecutor;
    private ArrayPool arrayPool;
    private BitmapPool bitmapPool;
    private ConnectivityMonitorFactory connectivityMonitorFactory;

    @Nullable
    private List<RequestListener<Object>> defaultRequestListeners;
    private RequestOptions defaultRequestOptions;
    private final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    private GlideExecutor diskCacheExecutor;
    private DiskCache.Factory diskCacheFactory;
    private Engine engine;
    private boolean isActiveResourceRetentionAllowed;
    private boolean isLoggingRequestOriginsEnabled;
    private int logLevel;
    private MemoryCache memoryCache;
    private MemorySizeCalculator memorySizeCalculator;

    @Nullable
    private RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
    private GlideExecutor sourceExecutor;

    public GlideBuilder() {
        this.defaultTransitionOptions = new ArrayMap();
        this.logLevel = 4;
        this.defaultRequestOptions = new RequestOptions();
    }

    @NonNull
    public GlideBuilder addGlobalRequestListener(@NonNull RequestListener<Object> r10) {
        if (this.defaultRequestListeners != null) goto L5;
        this.defaultRequestListeners = new ArrayList();
    L5:
        this.defaultRequestListeners.add(r10);
        return this;
    }

    @NonNull
    public Glide build(@NonNull Context r15) {
        if (this.sourceExecutor != null) goto L6;
        this.sourceExecutor = GlideExecutor.newSourceExecutor();
    L6:
        if (this.diskCacheExecutor != null) goto L9;
        this.diskCacheExecutor = GlideExecutor.newDiskCacheExecutor();
    L9:
        if (this.animationExecutor != null) goto L12;
        this.animationExecutor = GlideExecutor.newAnimationExecutor();
    L12:
        if (this.memorySizeCalculator != null) goto L15;
        this.memorySizeCalculator = new MemorySizeCalculator.Builder(r15).build();
    L15:
        if (this.connectivityMonitorFactory != null) goto L18;
        this.connectivityMonitorFactory = new DefaultConnectivityMonitorFactory();
    L18:
        if (this.bitmapPool != null) goto L24;
        int r10 = this.memorySizeCalculator.getBitmapPoolSize();
        if (r10 <= 0) goto L22;
        this.bitmapPool = new LruBitmapPool(r10);
        goto L24
    L22:
        this.bitmapPool = new BitmapPoolAdapter();
    L24:
        if (this.arrayPool != null) goto L27;
        this.arrayPool = new LruArrayPool(this.memorySizeCalculator.getArrayPoolSizeInBytes());
    L27:
        if (this.memoryCache != null) goto L30;
        this.memoryCache = new LruResourceCache(this.memorySizeCalculator.getMemoryCacheSize());
    L30:
        if (this.diskCacheFactory != null) goto L33;
        this.diskCacheFactory = new InternalCacheDiskCacheFactory(r15);
    L33:
        if (this.engine != null) goto L35;
        this.engine = new Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheExecutor, this.sourceExecutor, GlideExecutor.newUnlimitedSourceExecutor(), GlideExecutor.newAnimationExecutor(), this.isActiveResourceRetentionAllowed);
    L35:
        List<RequestListener<Object>> r11 = this.defaultRequestListeners;
        if (r11 != null) goto L38;
        this.defaultRequestListeners = Collections.emptyList();
    L40:
        return new Glide(r15, this.engine, this.memoryCache, this.bitmapPool, this.arrayPool, new RequestManagerRetriever(this.requestManagerFactory), this.connectivityMonitorFactory, this.logLevel, this.defaultRequestOptions.lock(), this.defaultTransitionOptions, this.defaultRequestListeners, this.isLoggingRequestOriginsEnabled);
    L38:
        this.defaultRequestListeners = Collections.unmodifiableList(r11);
        goto L40
    }

    @NonNull
    public GlideBuilder setAnimationExecutor(@Nullable GlideExecutor r10) {
        this.animationExecutor = r10;
        return this;
    }

    @NonNull
    public GlideBuilder setArrayPool(@Nullable ArrayPool r10) {
        this.arrayPool = r10;
        return this;
    }

    @NonNull
    public GlideBuilder setBitmapPool(@Nullable BitmapPool r10) {
        this.bitmapPool = r10;
        return this;
    }

    @NonNull
    public GlideBuilder setConnectivityMonitorFactory(@Nullable ConnectivityMonitorFactory r10) {
        this.connectivityMonitorFactory = r10;
        return this;
    }

    @NonNull
    public GlideBuilder setDefaultRequestOptions(@Nullable RequestOptions r10) {
        this.defaultRequestOptions = r10;
        return this;
    }

    @NonNull
    public <T> GlideBuilder setDefaultTransitionOptions(@NonNull Class<T> r10, @Nullable TransitionOptions<?, T> r11) {
        this.defaultTransitionOptions.put(r10, r11);
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCache(@Nullable DiskCache.Factory r10) {
        this.diskCacheFactory = r10;
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCacheExecutor(@Nullable GlideExecutor r10) {
        this.diskCacheExecutor = r10;
        return this;
    }

    public GlideBuilder setEngine(Engine r10) {
        this.engine = r10;
        return this;
    }

    @NonNull
    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean r10) {
        this.isActiveResourceRetentionAllowed = r10;
        return this;
    }

    @NonNull
    public GlideBuilder setLogLevel(int r10) {
        if (r10 < 2) goto L9;
        if (r10 > 6) goto L9;
        this.logLevel = r10;
        return this;
    L9:
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    public GlideBuilder setLogRequestOrigins(boolean r10) {
        this.isLoggingRequestOriginsEnabled = r10;
        return this;
    }

    @NonNull
    public GlideBuilder setMemoryCache(@Nullable MemoryCache r10) {
        this.memoryCache = r10;
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@NonNull MemorySizeCalculator.Builder r10) {
        return setMemorySizeCalculator(r10.build());
    }

    public void setRequestManagerFactory(@Nullable RequestManagerRetriever.RequestManagerFactory r10) {
        this.requestManagerFactory = r10;
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(@Nullable GlideExecutor r10) {
        return setSourceExecutor(r10);
    }

    @NonNull
    public GlideBuilder setSourceExecutor(@Nullable GlideExecutor r10) {
        this.sourceExecutor = r10;
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@Nullable MemorySizeCalculator r10) {
        this.memorySizeCalculator = r10;
        return this;
    }
}
