package com.bumptech.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import androidx.core.os.BuildCompat;
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
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public final class GlideBuilder {
    private GlideExecutor animationExecutor;
    private ArrayPool arrayPool;
    private BitmapPool bitmapPool;
    private ConnectivityMonitorFactory connectivityMonitorFactory;
    private List<RequestListener<Object>> defaultRequestListeners;
    private Glide.RequestOptionsFactory defaultRequestOptionsFactory;
    private final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    private GlideExecutor diskCacheExecutor;
    private DiskCache.Factory diskCacheFactory;
    private Engine engine;
    private boolean isActiveResourceRetentionAllowed;
    private boolean isImageDecoderEnabledForBitmaps;
    private boolean isLoggingRequestOriginsEnabled;
    private int logLevel;
    private MemoryCache memoryCache;
    private MemorySizeCalculator memorySizeCalculator;
    private RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
    private GlideExecutor sourceExecutor;

    public GlideBuilder() {
        this.defaultTransitionOptions = new ArrayMap();
        this.logLevel = 4;
        this.defaultRequestOptionsFactory = new AnonymousClass1(this);
    }

    public GlideBuilder addGlobalRequestListener(RequestListener<Object> r100) {
        if (this.defaultRequestListeners != null) goto L5;
        this.defaultRequestListeners = new ArrayList();
    L5:
        this.defaultRequestListeners.add(r100);
        return this;
    }

    public Glide build(Context r110) {
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
        this.memorySizeCalculator = new MemorySizeCalculator.Builder(r110).build();
    L15:
        if (this.connectivityMonitorFactory != null) goto L18;
        this.connectivityMonitorFactory = new DefaultConnectivityMonitorFactory();
    L18:
        if (this.bitmapPool != null) goto L24;
        int r100 = this.memorySizeCalculator.getBitmapPoolSize();
        if (r100 <= 0) goto L22;
        this.bitmapPool = new LruBitmapPool(r100);
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
        this.diskCacheFactory = new InternalCacheDiskCacheFactory(r110);
    L33:
        if (this.engine != null) goto L35;
        this.engine = new Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheExecutor, this.sourceExecutor, GlideExecutor.newUnlimitedSourceExecutor(), this.animationExecutor, this.isActiveResourceRetentionAllowed);
    L35:
        List<RequestListener<Object>> r101 = this.defaultRequestListeners;
        if (r101 != null) goto L38;
        this.defaultRequestListeners = Collections.emptyList();
    L40:
        return new Glide(r110, this.engine, this.memoryCache, this.bitmapPool, this.arrayPool, new RequestManagerRetriever(this.requestManagerFactory), this.connectivityMonitorFactory, this.logLevel, this.defaultRequestOptionsFactory, this.defaultTransitionOptions, this.defaultRequestListeners, this.isLoggingRequestOriginsEnabled, this.isImageDecoderEnabledForBitmaps);
    L38:
        this.defaultRequestListeners = Collections.unmodifiableList(r101);
        goto L40
    }

    public GlideBuilder setAnimationExecutor(GlideExecutor r100) {
        this.animationExecutor = r100;
        return this;
    }

    public GlideBuilder setArrayPool(ArrayPool r100) {
        this.arrayPool = r100;
        return this;
    }

    public GlideBuilder setBitmapPool(BitmapPool r100) {
        this.bitmapPool = r100;
        return this;
    }

    public GlideBuilder setConnectivityMonitorFactory(ConnectivityMonitorFactory r100) {
        this.connectivityMonitorFactory = r100;
        return this;
    }

    public GlideBuilder setDefaultRequestOptions(final RequestOptions r100) {
        return setDefaultRequestOptions(new AnonymousClass2(this, r100));
    }

    public GlideBuilder setDiskCache(DiskCache.Factory r100) {
        this.diskCacheFactory = r100;
        return this;
    }

    public GlideBuilder setDiskCacheExecutor(GlideExecutor r100) {
        this.diskCacheExecutor = r100;
        return this;
    }

    public GlideBuilder setEngine(Engine r100) {
        this.engine = r100;
        return this;
    }

    public GlideBuilder setImageDecoderEnabledForBitmaps(boolean r100) {
        if (BuildCompat.isAtLeastQ() == true) goto L5;
        return this;
    L5:
        this.isImageDecoderEnabledForBitmaps = r100;
        return this;
    }

    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean r100) {
        this.isActiveResourceRetentionAllowed = r100;
        return this;
    }

    public GlideBuilder setLogLevel(int r100) {
        if (r100 < 2) goto L9;
        if (r100 > 6) goto L9;
        this.logLevel = r100;
        return this;
    L9:
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    public GlideBuilder setLogRequestOrigins(boolean r100) {
        this.isLoggingRequestOriginsEnabled = r100;
        return this;
    }

    public GlideBuilder setMemoryCache(MemoryCache r100) {
        this.memoryCache = r100;
        return this;
    }

    public GlideBuilder setMemorySizeCalculator(MemorySizeCalculator.Builder r100) {
        return setMemorySizeCalculator(r100.build());
    }

    public void setRequestManagerFactory(RequestManagerRetriever.RequestManagerFactory r100) {
        this.requestManagerFactory = r100;
    }

    public GlideBuilder setResizeExecutor(GlideExecutor r100) {
        return setSourceExecutor(r100);
    }

    public GlideBuilder setSourceExecutor(GlideExecutor r100) {
        this.sourceExecutor = r100;
        return this;
    }

    public GlideBuilder setDefaultRequestOptions(Glide.RequestOptionsFactory r100) {
        this.defaultRequestOptionsFactory = (Glide.RequestOptionsFactory) Preconditions.checkNotNull(r100);
        return this;
    }

    public GlideBuilder setMemorySizeCalculator(MemorySizeCalculator r100) {
        this.memorySizeCalculator = r100;
        return this;
    }

    public <T> GlideBuilder setDefaultTransitionOptions(Class<T> r100, TransitionOptions<?, T> r101) {
        this.defaultTransitionOptions.put(r100, r101);
        return this;
    }
}
