package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class DecodeHelper<Transcode> {
    private final List<Key> cacheKeys;
    private DecodeJob.DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private boolean isCacheKeysSet;
    private boolean isLoadDataSet;
    private boolean isScaleOnlyOrNoTransform;
    private boolean isTransformationRequired;
    private final List<ModelLoader.LoadData<?>> loadData;
    private Object model;
    private Options options;
    private Priority priority;
    private Class<?> resourceClass;
    private Key signature;
    private Class<Transcode> transcodeClass;
    private Map<Class<?>, Transformation<?>> transformations;
    private int width;

    public DecodeHelper() {
        this.loadData = new ArrayList();
        this.cacheKeys = new ArrayList();
    }

    public void clear() {
        this.glideContext = null;
        this.model = null;
        this.signature = null;
        this.resourceClass = null;
        this.transcodeClass = null;
        this.options = null;
        this.priority = null;
        this.transformations = null;
        this.diskCacheStrategy = null;
        this.loadData.clear();
        this.isLoadDataSet = false;
        this.cacheKeys.clear();
        this.isCacheKeysSet = false;
    }

    public ArrayPool getArrayPool() {
        return this.glideContext.getArrayPool();
    }

    public List<Key> getCacheKeys() {
        if (this.isCacheKeysSet == true) goto L18;
        this.isCacheKeysSet = true;
        this.cacheKeys.clear();
        List<ModelLoader.LoadData<?>> r10 = getLoadData();
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L18;
        ModelLoader.LoadData<?> r13 = r10.get(r12);
        if (this.cacheKeys.contains(r13.sourceKey) == true) goto L9;
        this.cacheKeys.add(r13.sourceKey);
    L9:
        int r14 = 0;
    L11:
        if (r14 >= r13.alternateKeys.size()) goto L16;
        if (this.cacheKeys.contains(r13.alternateKeys.get(r14)) == true) goto L15;
        this.cacheKeys.add(r13.alternateKeys.get(r14));
    L15:
        r14 = r14 + 1;
        goto L11
    L16:
        r12 = r12 + 1;
    L18:
        return this.cacheKeys;
    }

    public DiskCache getDiskCache() {
        return this.diskCacheProvider.getDiskCache();
    }

    public DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public int getHeight() {
        return this.height;
    }

    public List<ModelLoader.LoadData<?>> getLoadData() {
        if (this.isLoadDataSet == true) goto L11;
        this.isLoadDataSet = true;
        this.loadData.clear();
        List r10 = this.glideContext.getRegistry().getModelLoaders(this.model);
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        ModelLoader.LoadData<?> r13 = ((ModelLoader) r10.get(r12)).buildLoadData(this.model, this.width, this.height, this.options);
        if (r13 == null) goto L9;
        this.loadData.add(r13);
    L9:
        r12 = r12 + 1;
    L11:
        return this.loadData;
    }

    public <Data> LoadPath<Data, ?, Transcode> getLoadPath(Class<Data> r10) {
        return this.glideContext.getRegistry().getLoadPath(r10, this.resourceClass, this.transcodeClass);
    }

    public Class<?> getModelClass() {
        return this.model.getClass();
    }

    public List<ModelLoader<File, ?>> getModelLoaders(File r10) throws Registry.NoModelLoaderAvailableException {
        return this.glideContext.getRegistry().getModelLoaders(r10);
    }

    public Options getOptions() {
        return this.options;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public List<Class<?>> getRegisteredResourceClasses() {
        return this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass);
    }

    public <Z> ResourceEncoder<Z> getResultEncoder(Resource<Z> r10) {
        return this.glideContext.getRegistry().getResultEncoder(r10);
    }

    public Key getSignature() {
        return this.signature;
    }

    public <X> Encoder<X> getSourceEncoder(X r10) throws Registry.NoSourceEncoderAvailableException {
        return this.glideContext.getRegistry().getSourceEncoder(r10);
    }

    public Class<?> getTranscodeClass() {
        return this.transcodeClass;
    }

    public <Z> Transformation<Z> getTransformation(Class<Z> r10) {
        Transformation<Z> r11 = (Transformation) this.transformations.get(r10);
        if (r11 != null) goto L10;
        Iterator<Map.Entry<Class<?>, Transformation<?>>> r12 = this.transformations.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        Map.Entry<Class<?>, Transformation<?>> r13 = r12.next();
        if (r13.getKey().isAssignableFrom(r10) == false) goto L6;
        r11 = (Transformation) r13.getValue();
    L10:
        if (r11 == null) goto L12;
        return r11;
    L12:
        if (this.transformations.isEmpty() == false) goto L19;
        if (this.isTransformationRequired == false) goto L19;
        throw new IllegalArgumentException("Missing transformation for " + r10 + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    L19:
        return UnitTransformation.get();
    }

    public int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean hasLoadPath(Class<?> r10) {
        if (getLoadPath(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> void init(GlideContext r10, Object r11, Key r12, int r13, int r14, DiskCacheStrategy r15, Class<?> r16, Class<R> r17, Priority r18, Options r19, Map<Class<?>, Transformation<?>> r110, boolean r111, boolean r112, DecodeJob.DiskCacheProvider r113) {
        this.glideContext = r10;
        this.model = r11;
        this.signature = r12;
        this.width = r13;
        this.height = r14;
        this.diskCacheStrategy = r15;
        this.resourceClass = r16;
        this.diskCacheProvider = r113;
        this.transcodeClass = r17;
        this.priority = r18;
        this.options = r19;
        this.transformations = r110;
        this.isTransformationRequired = r111;
        this.isScaleOnlyOrNoTransform = r112;
    }

    public boolean isResourceEncoderAvailable(Resource<?> r10) {
        return this.glideContext.getRegistry().isResourceEncoderAvailable(r10);
    }

    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public boolean isSourceKey(Key r10) {
        List<ModelLoader.LoadData<?>> r11 = getLoadData();
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.get(r13).sourceKey.equals(r10) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
