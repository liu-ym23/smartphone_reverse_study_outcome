package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools$Pool;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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
    private final Pools$Pool<List<Throwable>> throwableListPool;
    private final TranscoderRegistry transcoderRegistry;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String r10) {
            super(r10);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object r10) {
            super("Failed to find any ModelLoaders for model: " + r10);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> r10, @NonNull Class<?> r11) {
            super("Failed to find any ModelLoaders for model: " + r10 + " and data: " + r11);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> r10) {
            super("Failed to find result encoder for resource class: " + r10 + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> r10) {
            super("Failed to find source encoder for data class: " + r10);
        }
    }

    public Registry() {
        this.modelToResourceClassCache = new ModelToResourceClassCache();
        this.loadPathCache = new LoadPathCache();
        Pools$Pool<List<Throwable>> r10 = FactoryPools.threadSafeList();
        this.throwableListPool = r10;
        this.modelLoaderRegistry = new ModelLoaderRegistry(r10);
        this.encoderRegistry = new EncoderRegistry();
        this.decoderRegistry = new ResourceDecoderRegistry();
        this.resourceEncoderRegistry = new ResourceEncoderRegistry();
        this.dataRewinderRegistry = new DataRewinderRegistry();
        this.transcoderRegistry = new TranscoderRegistry();
        this.imageHeaderParserRegistry = new ImageHeaderParserRegistry();
        setResourceDecoderBucketPriorityList(Arrays.asList(new String[]{BUCKET_GIF, BUCKET_BITMAP, BUCKET_BITMAP_DRAWABLE}));
    }

    @NonNull
    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> getDecodePaths(@NonNull Class<Data> r12, @NonNull Class<TResource> r13, @NonNull Class<Transcode> r14) {
        ArrayList r10 = new ArrayList();
        Iterator r15 = this.decoderRegistry.getResourceClasses(r12, r13).iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        Class r11 = (Class) r15.next();
        Iterator r16 = this.transcoderRegistry.getTranscodeClasses(r11, r14).iterator();
    L7:
        if (r16.hasNext() == false) goto L4;
        Class r17 = (Class) r16.next();
        r10.add(new DecodePath(r12, r11, r17, this.decoderRegistry.getDecoders(r12, r11), this.transcoderRegistry.get(r11, r17), this.throwableListPool));
        goto L7
    L9:
        return r10;
    }

    @NonNull
    public <Data> Registry append(@NonNull Class<Data> r10, @NonNull Encoder<Data> r11) {
        this.encoderRegistry.append(r10, r11);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> getImageHeaderParsers() {
        List<ImageHeaderParser> r10 = this.imageHeaderParserRegistry.getParsers();
        if (r10.isEmpty() == true) goto L6;
        return r10;
    L6:
        throw new NoImageHeaderParserException();
    }

    @Nullable
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> getLoadPath(@NonNull Class<Data> r10, @NonNull Class<TResource> r11, @NonNull Class<Transcode> r12) {
        LoadPath<Data, TResource, Transcode> r13 = this.loadPathCache.get(r10, r11, r12);
        if (this.loadPathCache.isEmptyLoadPath(r13) == false) goto L5;
        return null;
    L5:
        if (r13 != null) goto L11;
        List<DecodePath<Data, TResource, Transcode>> r14 = getDecodePaths(r10, r11, r12);
        if (r14.isEmpty() == false) goto L9;
        r13 = null;
    L10:
        this.loadPathCache.put(r10, r11, r12, r13);
        goto L11
    L9:
        r13 = new LoadPath(r10, r11, r12, r14, this.throwableListPool);
    L11:
        return r13;
    }

    @NonNull
    public <Model> List<ModelLoader<Model, ?>> getModelLoaders(@NonNull Model r10) {
        List<ModelLoader<Model, ?>> r11 = this.modelLoaderRegistry.getModelLoaders(r10);
        if (r11.isEmpty() == true) goto L6;
        return r11;
    L6:
        throw new NoModelLoaderAvailableException(r10);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> getRegisteredResourceClasses(@NonNull Class<Model> r10, @NonNull Class<TResource> r11, @NonNull Class<Transcode> r12) {
        List<Class<?>> r13 = this.modelToResourceClassCache.get(r10, r11, r12);
        if (r13 != null) goto L16;
        r13 = new ArrayList();
        Iterator<Class<?>> r14 = this.modelLoaderRegistry.getDataClasses(r10).iterator();
    L6:
        if (r14.hasNext() == false) goto L15;
        Class<?> r15 = r14.next();
        Iterator r16 = this.decoderRegistry.getResourceClasses(r15, r11).iterator();
    L9:
        if (r16.hasNext() == false) goto L6;
        Class<?> r17 = (Class) r16.next();
        if (this.transcoderRegistry.getTranscodeClasses(r17, r12).isEmpty() == true) goto L9;
        if (r13.contains(r17) == true) goto L9;
        r13.add(r17);
        goto L9
    L15:
        this.modelToResourceClassCache.put(r10, r11, r12, Collections.unmodifiableList(r13));
    L16:
        return r13;
    }

    @NonNull
    public <X> ResourceEncoder<X> getResultEncoder(@NonNull Resource<X> r10) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> r11 = this.resourceEncoderRegistry.get(r10.getResourceClass());
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new NoResultEncoderAvailableException(r10.getResourceClass());
    }

    @NonNull
    public <X> DataRewinder<X> getRewinder(@NonNull X r10) {
        return this.dataRewinderRegistry.build(r10);
    }

    @NonNull
    public <X> Encoder<X> getSourceEncoder(@NonNull X r10) throws NoSourceEncoderAvailableException {
        Encoder<X> r11 = this.encoderRegistry.getEncoder(r10.getClass());
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new NoSourceEncoderAvailableException(r10.getClass());
    }

    public boolean isResourceEncoderAvailable(@NonNull Resource<?> r10) {
        if (this.resourceEncoderRegistry.get(r10.getResourceClass()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    public <Data> Registry prepend(@NonNull Class<Data> r10, @NonNull Encoder<Data> r11) {
        this.encoderRegistry.prepend(r10, r11);
        return this;
    }

    @NonNull
    @Deprecated
    public <Data> Registry register(@NonNull Class<Data> r10, @NonNull Encoder<Data> r11) {
        return append(r10, r11);
    }

    @NonNull
    public <Model, Data> Registry replace(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> r12) {
        this.modelLoaderRegistry.replace(r10, r11, r12);
        return this;
    }

    @NonNull
    public final Registry setResourceDecoderBucketPriorityList(@NonNull List<String> r10) {
        ArrayList r11 = new ArrayList(r10.size());
        r11.addAll(r10);
        r11.add(0, BUCKET_PREPEND_ALL);
        r11.add(BUCKET_APPEND_ALL);
        this.decoderRegistry.setBucketPriorityList(r11);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry append(@NonNull Class<Data> r10, @NonNull Class<TResource> r11, @NonNull ResourceDecoder<Data, TResource> r12) {
        append(BUCKET_APPEND_ALL, r10, r11, r12);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry prepend(@NonNull Class<Data> r10, @NonNull Class<TResource> r11, @NonNull ResourceDecoder<Data, TResource> r12) {
        prepend(BUCKET_PREPEND_ALL, r10, r11, r12);
        return this;
    }

    @NonNull
    @Deprecated
    public <TResource> Registry register(@NonNull Class<TResource> r10, @NonNull ResourceEncoder<TResource> r11) {
        return append(r10, r11);
    }

    @NonNull
    public <Data, TResource> Registry append(@NonNull String r10, @NonNull Class<Data> r11, @NonNull Class<TResource> r12, @NonNull ResourceDecoder<Data, TResource> r13) {
        this.decoderRegistry.append(r10, r13, r11, r12);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry prepend(@NonNull String r10, @NonNull Class<Data> r11, @NonNull Class<TResource> r12, @NonNull ResourceDecoder<Data, TResource> r13) {
        this.decoderRegistry.prepend(r10, r13, r11, r12);
        return this;
    }

    @NonNull
    public Registry register(@NonNull DataRewinder.Factory<?> r10) {
        this.dataRewinderRegistry.register(r10);
        return this;
    }

    @NonNull
    public <TResource> Registry append(@NonNull Class<TResource> r10, @NonNull ResourceEncoder<TResource> r11) {
        this.resourceEncoderRegistry.append(r10, r11);
        return this;
    }

    @NonNull
    public <TResource> Registry prepend(@NonNull Class<TResource> r10, @NonNull ResourceEncoder<TResource> r11) {
        this.resourceEncoderRegistry.prepend(r10, r11);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry register(@NonNull Class<TResource> r10, @NonNull Class<Transcode> r11, @NonNull ResourceTranscoder<TResource, Transcode> r12) {
        this.transcoderRegistry.register(r10, r11, r12);
        return this;
    }

    @NonNull
    public <Model, Data> Registry append(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<Model, Data> r12) {
        this.modelLoaderRegistry.append(r10, r11, r12);
        return this;
    }

    @NonNull
    public <Model, Data> Registry prepend(@NonNull Class<Model> r10, @NonNull Class<Data> r11, @NonNull ModelLoaderFactory<Model, Data> r12) {
        this.modelLoaderRegistry.prepend(r10, r11, r12);
        return this;
    }

    @NonNull
    public Registry register(@NonNull ImageHeaderParser r10) {
        this.imageHeaderParserRegistry.add(r10);
        return this;
    }
}
