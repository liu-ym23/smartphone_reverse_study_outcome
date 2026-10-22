package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Glide implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String TAG = "Glide";
    private static volatile Glide glide;
    private static volatile boolean isInitializing;
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;
    private final BitmapPreFiller bitmapPreFiller;
    private final ConnectivityMonitorFactory connectivityMonitorFactory;
    private final Engine engine;
    private final GlideContext glideContext;
    private final List<RequestManager> managers;
    private final MemoryCache memoryCache;
    private MemoryCategory memoryCategory;
    private final Registry registry;
    private final RequestManagerRetriever requestManagerRetriever;

    public Glide(@NonNull Context r24, @NonNull Engine r25, @NonNull MemoryCache r26, @NonNull BitmapPool r27, @NonNull ArrayPool r28, @NonNull RequestManagerRetriever r29, @NonNull ConnectivityMonitorFactory r30, int r31, @NonNull RequestOptions r32, @NonNull Map<Class<?>, TransitionOptions<?, ?>> r33, @NonNull List<RequestListener<Object>> r34, boolean r35) {
        this.managers = new ArrayList();
        this.memoryCategory = MemoryCategory.NORMAL;
        this.engine = r25;
        this.bitmapPool = r27;
        this.arrayPool = r28;
        this.memoryCache = r26;
        this.requestManagerRetriever = r29;
        this.connectivityMonitorFactory = r30;
        this.bitmapPreFiller = new BitmapPreFiller(r26, r27, (DecodeFormat) r32.getOptions().get(Downsampler.DECODE_FORMAT));
        Resources r10 = r24.getResources();
        Registry r11 = new Registry();
        this.registry = r11;
        r11.register(new DefaultImageHeaderParser());
        r11.register(new ExifInterfaceImageHeaderParser());
        List<ImageHeaderParser> r12 = r11.getImageHeaderParsers();
        Downsampler r13 = new Downsampler(r12, r10.getDisplayMetrics(), r27, r28);
        ByteBufferGifDecoder r14 = new ByteBufferGifDecoder(r24, r12, r27, r28);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> r15 = VideoDecoder.parcel(r27);
        ByteBufferBitmapDecoder r16 = new ByteBufferBitmapDecoder(r13);
        StreamBitmapDecoder r17 = new StreamBitmapDecoder(r13, r28);
        ResourceDrawableDecoder r18 = new ResourceDrawableDecoder(r24);
        ResourceLoader.StreamFactory r19 = new ResourceLoader.StreamFactory(r10);
        ResourceLoader.UriFactory r110 = new ResourceLoader.UriFactory(r10);
        ResourceLoader.FileDescriptorFactory r111 = new ResourceLoader.FileDescriptorFactory(r10);
        ResourceLoader.AssetFileDescriptorFactory r20 = new ResourceLoader.AssetFileDescriptorFactory(r10);
        BitmapEncoder r21 = new BitmapEncoder(r28);
        BitmapBytesTranscoder r22 = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder r23 = new GifDrawableBytesTranscoder();
        ContentResolver r36 = r24.getContentResolver();
        Registry r37 = r11.append(ByteBuffer.class, new ByteBufferEncoder()).append(InputStream.class, new StreamEncoder(r28)).append(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, r16).append(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, r17).append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, r15).append(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(r27)).append(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).append(Bitmap.class, r21).append(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(r10, r16)).append(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(r10, r17)).append(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(r10, r15)).append(BitmapDrawable.class, new BitmapDrawableEncoder(r27, r21)).append(Registry.BUCKET_GIF, InputStream.class, GifDrawable.class, new StreamGifDecoder(r12, r14, r28)).append(Registry.BUCKET_GIF, ByteBuffer.class, GifDrawable.class, r14).append(GifDrawable.class, new GifDrawableEncoder()).append(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(r27)).append(Uri.class, Drawable.class, r18).append(Uri.class, Bitmap.class, new ResourceBitmapDecoder(r18, r27)).register(new ByteBufferRewinder.Factory()).append(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).append(File.class, InputStream.class, new FileLoader.StreamFactory()).append(File.class, File.class, new FileDecoder()).append(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).append(File.class, File.class, UnitModelLoader.Factory.getInstance()).register(new InputStreamRewinder.Factory(r28));
        Class r38 = Integer.TYPE;
        r37.append(r38, InputStream.class, r19).append(r38, ParcelFileDescriptor.class, r111).append(Integer.class, InputStream.class, r19).append(Integer.class, ParcelFileDescriptor.class, r111).append(Integer.class, Uri.class, r110).append(r38, AssetFileDescriptor.class, r20).append(Integer.class, AssetFileDescriptor.class, r20).append(r38, Uri.class, r110).append(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(String.class, InputStream.class, new StringLoader.StreamFactory()).append(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).append(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).append(Uri.class, InputStream.class, new HttpUriLoader.Factory()).append(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(r24.getAssets())).append(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(r24.getAssets())).append(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(r24)).append(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(r24)).append(Uri.class, InputStream.class, new UriLoader.StreamFactory(r36)).append(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(r36)).append(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(r36)).append(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).append(URL.class, InputStream.class, new UrlLoader.StreamFactory()).append(Uri.class, File.class, new MediaStoreFileLoader.Factory(r24)).append(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).append(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).append(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).append(Uri.class, Uri.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, new UnitDrawableDecoder()).register(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(r10)).register(Bitmap.class, byte[].class, r22).register(Drawable.class, byte[].class, new DrawableBytesTranscoder(r27, r22, r23)).register(GifDrawable.class, byte[].class, r23);
        this.glideContext = new GlideContext(r24, r28, r11, new ImageViewTargetFactory(), r32, r33, r34, r25, r35, r31);
    }

    private static void checkAndInitializeGlide(@NonNull Context r10) {
        if (isInitializing == true) goto L7;
        isInitializing = true;
        initializeGlide(r10);
        isInitializing = false;
        return;
    L7:
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @NonNull
    public static Glide get(@NonNull Context r10) {
        if (glide != null) goto L16;
        monitor-enter(Glide.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (glide != null) goto L11;
        checkAndInitializeGlide(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(Glide.class);     // Catch: Throwable -> L9
    L16:
        return glide;
    }

    @Nullable
    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules() {
        goto L18
    L23:
        return (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(null).newInstance(null);
    L9:
        e = move-exception;
        throwIncorrectGlideModule(e);
        return null;
    L11:
        e = move-exception;
        throwIncorrectGlideModule(e);
        return null;
    L7:
        e = move-exception;
        throwIncorrectGlideModule(e);
        return null;
    L5:
        e = move-exception;
        throwIncorrectGlideModule(e);
        return null;
    L18:
        if (Log.isLoggable(TAG, 5) == false) goto L28;
        Log.w(TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
        return null;
    L28:
        return null;
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context r10) {
        return getPhotoCacheDir(r10, "image_manager_disk_cache");
    }

    @NonNull
    private static RequestManagerRetriever getRetriever(@Nullable Context r10) {
        Preconditions.checkNotNull(r10, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(r10).getRequestManagerRetriever();
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void init(Glide r10) {
        monitor-enter(Glide.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L9;
        tearDown();     // Catch: Throwable -> L7
    L9:
        glide = r10;     // Catch: Throwable -> L7
        monitor-exit(Glide.class);
    }

    private static void initializeGlide(@NonNull Context r10) {
        initializeGlide(r10, new GlideBuilder());
    }

    @VisibleForTesting
    public static synchronized void tearDown() {
        monitor-enter(Glide.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L9;
        glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);     // Catch: Throwable -> L7
        glide.engine.shutdown();     // Catch: Throwable -> L7
    L9:
        glide = null;     // Catch: Throwable -> L7
        monitor-exit(Glide.class);
    }

    private static void throwIncorrectGlideModule(Exception r10) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", r10);
    }

    @NonNull
    public static RequestManager with(@NonNull Context r10) {
        return getRetriever(r10).get(r10);
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.engine.clearDiskCache();
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    @NonNull
    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    @NonNull
    public Context getContext() {
        return this.glideContext.getBaseContext();
    }

    @NonNull
    public GlideContext getGlideContext() {
        return this.glideContext;
    }

    @NonNull
    public Registry getRegistry() {
        return this.registry;
    }

    @NonNull
    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r10) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        clearMemory();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r10) {
        trimMemory(r10);
    }

    public void preFillBitmapPool(@NonNull PreFillType.Builder... r10) {
        this.bitmapPreFiller.preFill(r10);
    }

    public void registerRequestManager(RequestManager r10) {
        List<RequestManager> r11 = this.managers;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.managers.contains(r10) == true) goto L12;
        this.managers.add(r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("Cannot register already registered manager");     // Catch: Throwable -> L9
    }

    public boolean removeFromManagers(@NonNull Target<?> r10) {
        List<RequestManager> r11 = this.managers;
        monitor-enter(r11);
        Iterator<RequestManager> r12 = this.managers.iterator();     // Catch: Throwable -> L12
    L6:
        if (r12.hasNext() == false) goto L14;
        if (r12.next().untrack(r10) == false) goto L6;
        monitor-exit(r11);     // Catch: Throwable -> L12
        return true;
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    @NonNull
    public MemoryCategory setMemoryCategory(@NonNull MemoryCategory r10) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(r10.getMultiplier());
        this.bitmapPool.setSizeMultiplier(r10.getMultiplier());
        MemoryCategory r11 = this.memoryCategory;
        this.memoryCategory = r10;
        return r11;
    }

    public void trimMemory(int r10) {
        Util.assertMainThread();
        this.memoryCache.trimMemory(r10);
        this.bitmapPool.trimMemory(r10);
        this.arrayPool.trimMemory(r10);
    }

    public void unregisterRequestManager(RequestManager r10) {
        List<RequestManager> r11 = this.managers;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.managers.contains(r10) == false) goto L12;
        this.managers.remove(r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("Cannot unregister not yet registered manager");     // Catch: Throwable -> L9
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context r10, @NonNull String r11) {
        File r12 = r10.getCacheDir();
        if (r12 == null) goto L13;
        File r13 = new File(r12, r11);
        if (r13.mkdirs() == false) goto L7;
    L11:
        return r13;
    L7:
        if (r13.exists() == true) goto L9;
    L10:
        return null;
    L9:
        if (r13.isDirectory() == true) goto L11;
    L13:
        if (Log.isLoggable(TAG, 6) == false) goto L15;
        Log.e(TAG, "default disk cache dir is null");
    L15:
        return null;
    }

    private static void initializeGlide(@NonNull Context r10, @NonNull GlideBuilder r11) {
        Context r12 = r10.getApplicationContext();
        GeneratedAppGlideModule r13 = getAnnotationGeneratedGlideModules();
        List<GlideModule> r14 = Collections.emptyList();
        if (r13 != null) goto L5;
    L6:
        r14 = new ManifestParser(r12).parse();
    L8:
        if (r13 == null) goto L22;
        if (r13.getExcludedModuleClasses().isEmpty() == true) goto L22;
        Set<Class<?>> r15 = r13.getExcludedModuleClasses();
        Iterator<GlideModule> r16 = r14.iterator();
    L13:
        if (r16.hasNext() == false) goto L22;
        GlideModule r17 = r16.next();
        if (r15.contains(r17.getClass()) == false) goto L13;
        if (Log.isLoggable(TAG, 3) == false) goto L20;
        Log.d(TAG, "AppGlideModule excludes manifest GlideModule: " + r17);
    L20:
        r16.remove();
    L22:
        if (Log.isLoggable(TAG, 3) == false) goto L27;
        Iterator<GlideModule> r18 = r14.iterator();
    L25:
        if (r18.hasNext() == false) goto L27;
        Log.d(TAG, "Discovered GlideModule from manifest: " + r18.next().getClass());
    L27:
        if (r13 == null) goto L29;
        RequestManagerRetriever.RequestManagerFactory r19 = r13.getRequestManagerFactory();
    L30:
        r11.setRequestManagerFactory(r19);
        Iterator<GlideModule> r20 = r14.iterator();
    L32:
        if (r20.hasNext() == false) goto L34;
        r20.next().applyOptions(r12, r11);
        goto L32
    L34:
        if (r13 == null) goto L36;
        r13.applyOptions(r12, r11);
    L36:
        Glide r110 = r11.build(r12);
        Iterator<GlideModule> r21 = r14.iterator();
    L38:
        if (r21.hasNext() == false) goto L40;
        r21.next().registerComponents(r12, r110, r110.registry);
        goto L38
    L40:
        if (r13 == null) goto L42;
        r13.registerComponents(r12, r110, r110.registry);
    L42:
        r12.registerComponentCallbacks(r110);
        glide = r110;
        return;
    L29:
        r19 = null;
        goto L30
    L5:
        if (r13.isManifestParsingEnabled() == false) goto L8;
        goto L6
    }

    @NonNull
    public static RequestManager with(@NonNull Activity r10) {
        return getRetriever(r10).get(r10);
    }

    @NonNull
    public static RequestManager with(@NonNull FragmentActivity r10) {
        return getRetriever(r10).get(r10);
    }

    @NonNull
    public static RequestManager with(@NonNull Fragment r10) {
        return getRetriever(r10.getActivity()).get(r10);
    }

    @VisibleForTesting
    public static synchronized void init(@NonNull Context r10, @NonNull GlideBuilder r11) {
        monitor-enter(Glide.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L9;
        tearDown();     // Catch: Throwable -> L7
    L9:
        initializeGlide(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(Glide.class);
    }

    @NonNull
    @Deprecated
    public static RequestManager with(@NonNull android.app.Fragment r10) {
        return getRetriever(r10.getActivity()).get(r10);
    }

    @NonNull
    public static RequestManager with(@NonNull View r10) {
        return getRetriever(r10.getContext()).get(r10);
    }
}
