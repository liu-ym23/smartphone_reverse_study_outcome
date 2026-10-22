package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class Registry {
    private static final String BUCKET_APPEND_ALL = "legacy_append";
    public static final String BUCKET_BITMAP = "Bitmap";
    public static final String BUCKET_BITMAP_DRAWABLE = "BitmapDrawable";
    public static final String BUCKET_GIF = "Gif";
    private static final String BUCKET_PREPEND_ALL = "legacy_prepend_all";
    private final DataRewinderRegistry dataRewinderRegistry;
    private final ResourceDecoderRegistry decoderRegistry;
    private final EncoderRegistry encoderRegistry;
    private final ImageHeaderParserRegistry imageHeaderParserRegistry;
    private final LoadPathCache loadPathCache;
    private final ModelLoaderRegistry modelLoaderRegistry;
    private final ModelToResourceClassCache modelToResourceClassCache;
    private final ResourceEncoderRegistry resourceEncoderRegistry;
    private final Pools.Pool<List<Throwable>> throwableListPool;
    private final TranscoderRegistry transcoderRegistry;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String r100) {
            super(r100);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object r100) {
            super("Failed to find any ModelLoaders registered for model class: " + r100.getClass());
        }

        public NoModelLoaderAvailableException(Class<?> r100, Class<?> r101) {
            super("Failed to find any ModelLoaders for model: " + r100 + " and data: " + r101);
        }

        public <M> NoModelLoaderAvailableException(M r100, List<ModelLoader<M, ?>> r101) {
            super("Found ModelLoaders for model class: " + r101 + ", but none that handle this specific model instance: " + r100);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> r100) {
            super("Failed to find result encoder for resource class: " + r100 + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> r100) {
            super("Failed to find source encoder for data class: " + r100);
        }
    }

    public List<ImageHeaderParser> getImageHeaderParsers() {
        List<ImageHeaderParser> r100 = this.imageHeaderParserRegistry.getParsers();
        if (r100.isEmpty() == true) goto L6;
        return r100;
    L6:
        throw new NoImageHeaderParserException();
    }

    public Registry() {
        this.modelToResourceClassCache = new ModelToResourceClassCache();
        this.loadPathCache = new LoadPathCache();
        Pools.Pool<List<Throwable>> r100 = FactoryPools.threadSafeList();
        this.throwableListPool = r100;
        this.modelLoaderRegistry = new ModelLoaderRegistry(r100);
        this.encoderRegistry = new EncoderRegistry();
        this.decoderRegistry = new ResourceDecoderRegistry();
        this.resourceEncoderRegistry = new ResourceEncoderRegistry();
        this.dataRewinderRegistry = new DataRewinderRegistry();
        this.transcoderRegistry = new TranscoderRegistry();
        this.imageHeaderParserRegistry = new ImageHeaderParserRegistry();
        setResourceDecoderBucketPriorityList(Arrays.asList(new String[]{BUCKET_GIF, BUCKET_BITMAP, BUCKET_BITMAP_DRAWABLE}));
    }

    public <Model> List<ModelLoader<Model, ?>> getModelLoaders(Model r100) {
        return this.modelLoaderRegistry.getModelLoaders(r100);
    }

    public <X> ResourceEncoder<X> getResultEncoder(Resource<X> r100) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> r101 = this.resourceEncoderRegistry.get(r100.getResourceClass());
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new NoResultEncoderAvailableException(r100.getResourceClass());
    }

    public <X> DataRewinder<X> getRewinder(X r100) {
        return this.dataRewinderRegistry.build(r100);
    }

    public <X> Encoder<X> getSourceEncoder(X r100) throws NoSourceEncoderAvailableException {
        Encoder<X> r101 = this.encoderRegistry.getEncoder(r100.getClass());
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new NoSourceEncoderAvailableException(r100.getClass());
    }

    public boolean isResourceEncoderAvailable(Resource<?> r100) {
        if (this.resourceEncoderRegistry.get(r100.getResourceClass()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Registry register(ImageHeaderParser r100) {
        this.imageHeaderParserRegistry.add(r100);
        return this;
    }

    public final Registry setResourceDecoderBucketPriorityList(List<String> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        r101.addAll(r100);
        ListProtector.add(r101, 0, BUCKET_PREPEND_ALL);
        r101.add(BUCKET_APPEND_ALL);
        this.decoderRegistry.setBucketPriorityList(r101);
        return this;
    }

    public Registry register(DataRewinder.Factory<?> r100) {
        this.dataRewinderRegistry.register(r100);
        return this;
    }

    public <Data> Registry append(Class<Data> r100, Encoder<Data> r101) {
        this.encoderRegistry.append(r100, r101);
        return this;
    }

    public <Data> Registry prepend(Class<Data> r100, Encoder<Data> r101) {
        this.encoderRegistry.prepend(r100, r101);
        return this;
    }

    public <Data> Registry register(Class<Data> r100, Encoder<Data> r101) {
        return append(r100, r101);
    }

    public <TResource> Registry append(Class<TResource> r100, ResourceEncoder<TResource> r101) {
        this.resourceEncoderRegistry.append(r100, r101);
        return this;
    }

    public <TResource> Registry prepend(Class<TResource> r100, ResourceEncoder<TResource> r101) {
        this.resourceEncoderRegistry.prepend(r100, r101);
        return this;
    }

    public <TResource> Registry register(Class<TResource> r100, ResourceEncoder<TResource> r101) {
        return append(r100, r101);
    }

    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> getDecodePaths(Class<Data> r110, Class<TResource> r111, Class<Transcode> r112) {
        ArrayList r100 = new ArrayList();
        Iterator r113 = this.decoderRegistry.getResourceClasses(r110, r111).iterator();
    L4:
        if (r113.hasNext() == false) goto L9;
        Class r101 = (Class) r113.next();
        Iterator r102 = this.transcoderRegistry.getTranscodeClasses(r101, r112).iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        Class r103 = (Class) r102.next();
        r100.add(new DecodePath(r110, r101, r103, this.decoderRegistry.getDecoders(r110, r101), this.transcoderRegistry.get(r101, r103), this.throwableListPool));
        goto L7
    L9:
        return r100;
    }

    public <Data, TResource> Registry append(Class<Data> r100, Class<TResource> r101, ResourceDecoder<Data, TResource> r102) {
        append(BUCKET_APPEND_ALL, r100, r101, r102);
        return this;
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> getLoadPath(Class<Data> r110, Class<TResource> r111, Class<Transcode> r112) {
        LoadPath<Data, TResource, Transcode> r100 = this.loadPathCache.get(r110, r111, r112);
        if (this.loadPathCache.isEmptyLoadPath(r100) == false) goto L5;
        return null;
    L5:
        if (r100 != null) goto L11;
        List<DecodePath<Data, TResource, Transcode>> r101 = getDecodePaths(r110, r111, r112);
        if (r101.isEmpty() == false) goto L9;
        r100 = null;
    L10:
        this.loadPathCache.put(r110, r111, r112, r100);
        goto L11
    L9:
        r100 = new LoadPath(r110, r111, r112, r101, this.throwableListPool);
    L11:
        return r100;
    }

    public <Model, TResource, Transcode> List<Class<?>> getRegisteredResourceClasses(Class<Model> r100, Class<TResource> r101, Class<Transcode> r102) {
        List<Class<?>> r103 = this.modelToResourceClassCache.get(r100, r101, r102);
        List<Class<?>> r104 = r103;
        if (r103 != null) goto L16;
        ArrayList r105 = new ArrayList();
        Iterator<Class<?>> r106 = this.modelLoaderRegistry.getDataClasses(r100).iterator();
    L6:
        if (r106.hasNext() == false) goto L15;
        Class<?> r107 = r106.next();
        Iterator r108 = this.decoderRegistry.getResourceClasses(r107, r101).iterator();
    L9:
        if (r108.hasNext() == false) goto L6;
        Class r109 = (Class) r108.next();
        if (this.transcoderRegistry.getTranscodeClasses(r109, r102).isEmpty() == true) goto L9;
        if (r105.contains(r109) == true) goto L9;
        r105.add(r109);
        goto L9
    L15:
        this.modelToResourceClassCache.put(r100, r101, r102, Collections.unmodifiableList(r105));
        r104 = r105;
    L16:
        return r104;
    }

    public <Data, TResource> Registry prepend(Class<Data> r100, Class<TResource> r101, ResourceDecoder<Data, TResource> r102) {
        prepend(BUCKET_PREPEND_ALL, r100, r101, r102);
        return this;
    }

    public <TResource, Transcode> Registry register(Class<TResource> r100, Class<Transcode> r101, ResourceTranscoder<TResource, Transcode> r102) {
        this.transcoderRegistry.register(r100, r101, r102);
        return this;
    }

    public <TResource, Transcode> Registry registerAtHead(Class<TResource> r100, Class<Transcode> r101, ResourceTranscoder<TResource, Transcode> r102) {
        this.transcoderRegistry.registerAtHead(r100, r101, r102);
        return this;
    }

    public <Model, Data> Registry replace(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<? extends Model, ? extends Data> r102) {
        this.modelLoaderRegistry.replace(r100, r101, r102);
        return this;
    }

    public <Model, Data> Registry append(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<Model, Data> r102) {
        this.modelLoaderRegistry.append(r100, r101, r102);
        return this;
    }

    public <Model, Data> Registry prepend(Class<Model> r100, Class<Data> r101, ModelLoaderFactory<Model, Data> r102) {
        this.modelLoaderRegistry.prepend(r100, r101, r102);
        return this;
    }

    public <Data, TResource> Registry append(String r100, Class<Data> r101, Class<TResource> r102, ResourceDecoder<Data, TResource> r103) {
        this.decoderRegistry.append(r100, r103, r101, r102);
        return this;
    }

    public <Data, TResource> Registry prepend(String r100, Class<Data> r101, Class<TResource> r102, ResourceDecoder<Data, TResource> r103) {
        this.decoderRegistry.prepend(r100, r103, r101, r102);
        return this;
    }
}
