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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
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
        List<ModelLoader.LoadData<?>> r100 = getLoadData();
        int r101 = r100.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L18;
        ModelLoader.LoadData r103 = (ModelLoader.LoadData) ListProtector.get(r100, r102);
        if (this.cacheKeys.contains(r103.sourceKey) == true) goto L9;
        this.cacheKeys.add(r103.sourceKey);
    L9:
        int r104 = 0;
    L11:
        if (r104 >= r103.alternateKeys.size()) goto L16;
        if (this.cacheKeys.contains(ListProtector.get(r103.alternateKeys, r104)) == true) goto L15;
        this.cacheKeys.add((Key) ListProtector.get(r103.alternateKeys, r104));
    L15:
        r104 = r104 + 1;
        goto L11
    L16:
        r102 = r102 + 1;
    L18:
        return this.cacheKeys;
    }

    public DiskCache getDiskCache() {
        return this.diskCacheProvider.getDiskCache();
    }

    public List<ModelLoader.LoadData<?>> getLoadData() {
        if (this.isLoadDataSet == true) goto L11;
        this.isLoadDataSet = true;
        this.loadData.clear();
        List r100 = this.glideContext.getRegistry().getModelLoaders(this.model);
        int r101 = r100.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L11;
        ModelLoader.LoadData<?> r103 = ((ModelLoader) ListProtector.get(r100, r102)).buildLoadData(this.model, this.width, this.height, this.options);
        if (r103 == null) goto L9;
        this.loadData.add(r103);
    L9:
        r102 = r102 + 1;
    L11:
        return this.loadData;
    }

    public Class<?> getModelClass() {
        return this.model.getClass();
    }

    public List<Class<?>> getRegisteredResourceClasses() {
        return this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass);
    }

    public DecodeHelper() {
        this.loadData = new ArrayList();
        this.cacheKeys = new ArrayList();
    }

    public DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public int getHeight() {
        return this.height;
    }

    public Options getOptions() {
        return this.options;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public Key getSignature() {
        return this.signature;
    }

    public Class<?> getTranscodeClass() {
        return this.transcodeClass;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public <Data> LoadPath<Data, ?, Transcode> getLoadPath(Class<Data> r100) {
        return this.glideContext.getRegistry().getLoadPath(r100, this.resourceClass, this.transcodeClass);
    }

    public List<ModelLoader<File, ?>> getModelLoaders(File r100) throws Registry.NoModelLoaderAvailableException {
        return this.glideContext.getRegistry().getModelLoaders(r100);
    }

    public <Z> ResourceEncoder<Z> getResultEncoder(Resource<Z> r100) {
        return this.glideContext.getRegistry().getResultEncoder(r100);
    }

    public <X> Encoder<X> getSourceEncoder(X r100) throws Registry.NoSourceEncoderAvailableException {
        return this.glideContext.getRegistry().getSourceEncoder(r100);
    }

    public <Z> Transformation<Z> getTransformation(Class<Z> r100) {
        Transformation<Z> r101 = (Transformation) this.transformations.get(r100);
        if (r101 != null) goto L10;
        Iterator<Map.Entry<Class<?>, Transformation<?>>> r102 = this.transformations.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<Class<?>, Transformation<?>> r103 = r102.next();
        if (r103.getKey().isAssignableFrom(r100) == false) goto L6;
        r101 = (Transformation) r103.getValue();
    L10:
        if (r101 == null) goto L12;
        return r101;
    L12:
        if (this.transformations.isEmpty() == false) goto L19;
        if (this.isTransformationRequired == false) goto L19;
        throw new IllegalArgumentException("Missing transformation for " + r100 + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    L19:
        return UnitTransformation.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean hasLoadPath(Class<?> r100) {
        if (getLoadPath(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isResourceEncoderAvailable(Resource<?> r100) {
        return this.glideContext.getRegistry().isResourceEncoderAvailable(r100);
    }

    public boolean isSourceKey(Key r100) {
        List<ModelLoader.LoadData<?>> r101 = getLoadData();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (((ModelLoader.LoadData) ListProtector.get(r101, r103)).sourceKey.equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> void init(GlideContext r100, Object r101, Key r102, int r103, int r104, DiskCacheStrategy r105, Class<?> r106, Class<R> r107, Priority r108, Options r110, Map<Class<?>, Transformation<?>> r111, boolean r112, boolean r113, DecodeJob.DiskCacheProvider r114) {
        this.glideContext = r100;
        this.model = r101;
        this.signature = r102;
        this.width = r103;
        this.height = r104;
        this.diskCacheStrategy = r105;
        this.resourceClass = r106;
        this.diskCacheProvider = r114;
        this.transcodeClass = r107;
        this.priority = r108;
        this.options = r110;
        this.transformations = r111;
        this.isTransformationRequired = r112;
        this.isScaleOnlyOrNoTransform = r113;
    }
}
