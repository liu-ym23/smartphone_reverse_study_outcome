package com.bumptech.glide;

import android.app.Activity;
import android.app.Fragment;
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
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
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
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
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
import com.bumptech.glide.memorypolicy.GlideDownGradeSettings;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import el9.a;
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
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class Glide implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String TAG = "Glide";
    private static volatile Glide glide;
    private static volatile boolean isInitializing;
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;
    private BitmapPreFiller bitmapPreFiller;
    private final ConnectivityMonitorFactory connectivityMonitorFactory;
    private final RequestOptionsFactory defaultRequestOptionsFactory;
    private final Engine engine;
    private final GlideContext glideContext;
    private Boolean isDowngradeFGEnabled;
    private final List<RequestManager> managers;
    private final MemoryCache memoryCache;
    private MemoryCategory memoryCategory;
    private final Registry registry;
    private final RequestManagerRetriever requestManagerRetriever;

    public interface RequestOptionsFactory {
        RequestOptions build();
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
    }

    public static synchronized void tearDown() {
        monitor-enter(Glide.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L7;
        glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);     // Catch: Throwable -> L10
        glide.engine.shutdown();     // Catch: Throwable -> L10
    L7:
        glide = null;     // Catch: Throwable -> L10
        monitor-exit(Glide.class);
    }

    public Context getContext() {
        return this.glideContext.getBaseContext();
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

    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    public GlideContext getGlideContext() {
        return this.glideContext;
    }

    public Registry getRegistry() {
        return this.registry;
    }

    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        clearMemory();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bumptech_glide_Glide_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bumptech_glide_Glide_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private boolean applyGlideDowngrade(int r110) {
        GlideDownGradeSettings.ParseResult r100 = GlideDownGradeSettings.INSTANCE.getTrimConfigParseResult();
        if (r100.getFailed() == false) goto L6;
        Log.i(GlideDownGradeSettings.TAG, "ignore trim, trim level=" + r110 + ", reason=config_invalid:" + r100.getError());
        return false;
    L6:
        GlideDownGradeSettings.ResolveResul r101 = GlideDownGradeSettings.resolveLevel(r110, r100.getConfig());
        float r102 = r101.getTargetRetentionRatio();
        float r103 = r101.getSizeMultiplier();
        this.memoryCache.trimToRetainRatio(r102);     // Catch: Throwable -> L10
        this.memoryCache.setSizeMultiplier(r103);     // Catch: Throwable -> L10
        this.bitmapPool.trimToRetainRatio(r102);     // Catch: Throwable -> L10
        this.bitmapPool.setSizeMultiplier(r103);     // Catch: Throwable -> L10
        this.arrayPool.trimToRetainRatio(r102);     // Catch: Throwable -> L10
        Log.i(GlideDownGradeSettings.TAG, "applyTrimMemoryCategory, trim level: " + r110 + "; hit range:" + r101.getRangeText() + "; retainRatio=" + r102 + "; sizeMultiplier=" + r103);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        Log.e(GlideDownGradeSettings.TAG, "applyTrimMemoryCategory failed, trim level: " + r110 + "; hit range:" + r101.getRangeText() + "; retainRatio=" + r102 + "; sizeMultiplier=" + r103, th);
        return false;
    }

    public static Glide get(Context r100) {
        if (glide != null) goto L15;
        GeneratedAppGlideModule r101 = getAnnotationGeneratedGlideModules(r100.getApplicationContext());
        monitor-enter(Glide.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (glide != null) goto L9;
        checkAndInitializeGlide(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(Glide.class);     // Catch: Throwable -> L11
    L15:
        return glide;
    }

    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules(Context r100) {
    L17:
        return (GeneratedAppGlideModule) INVOKESTATIC_com_bumptech_glide_Glide_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{r100.getApplicationContext()});
    L12:
        GlideLogUtil.e(TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
    L13:
        return null;
    L8:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L10:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L6:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L4:
        e = move-exception;
        throwIncorrectGlideModule(e);
        goto L13
    }

    public static File getPhotoCacheDir(Context r100) {
        return getPhotoCacheDir(r100, "image_manager_disk_cache");
    }

    private static RequestManagerRetriever getRetriever(Context r100) {
        Preconditions.checkNotNull(r100, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(r100).getRequestManagerRetriever();
    }

    public static synchronized void init(Glide r100) {
        monitor-enter(Glide.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L7;
        tearDown();     // Catch: Throwable -> L10
    L7:
        glide = r100;     // Catch: Throwable -> L10
        monitor-exit(Glide.class);
    }

    private static void throwIncorrectGlideModule(Exception r100) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", r100);
    }

    public static RequestManager with(Fragment r100) {
        return getRetriever(r100.getActivity()).get(r100);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r100) {
        trimMemory(r100);
    }

    public synchronized void preFillBitmapPool(PreFillType.Builder... r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.bitmapPreFiller != null) goto L6;
        DecodeFormat r101 = (DecodeFormat) this.defaultRequestOptionsFactory.build().getOptions().get(Downsampler.DECODE_FORMAT);     // Catch: Throwable -> L9
        this.bitmapPreFiller = new BitmapPreFiller(this.memoryCache, this.bitmapPool, r101);     // Catch: Throwable -> L9
    L6:
        this.bitmapPreFiller.preFill(r100);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    public void registerRequestManager(RequestManager r100) {
        List<RequestManager> r101 = this.managers;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.managers.contains(r100) == true) goto L10;
        this.managers.add(r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Cannot register already registered manager");     // Catch: Throwable -> L11
    }

    public boolean removeFromManagers(Target<?> r100) {
        List<RequestManager> r101 = this.managers;
        monitor-enter(r101);
        Iterator<RequestManager> r102 = this.managers.iterator();     // Catch: Throwable -> L15
    L6:
        if (r102.hasNext() == false) goto L12;
        if (r102.next().untrack(r100) == false) goto L6;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    public void setIsDowngradeFGEnabled(Boolean r100) {
        this.isDowngradeFGEnabled = r100;
    }

    public MemoryCategory setMemoryCategory(MemoryCategory r100) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(r100.getMultiplier());
        this.bitmapPool.setSizeMultiplier(r100.getMultiplier());
        MemoryCategory r101 = this.memoryCategory;
        this.memoryCategory = r100;
        return r101;
    }

    public void trimMemory(int r100) {
        Util.assertMainThread();
        Iterator<RequestManager> r101 = this.managers.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r101.next().onTrimMemory(r100);
        goto L4
    L7:
        if (this.isDowngradeFGEnabled.booleanValue() == false) goto L9;
        boolean r102 = applyGlideDowngrade(r100);
    L10:
        if (r102 == true) goto L14;
        this.memoryCache.trimMemory(r100);
        this.bitmapPool.trimMemory(r100);
        this.arrayPool.trimMemory(r100);
        return;
    L14:
        return;
    L9:
        Log.i(GlideDownGradeSettings.TAG, "skip downgrade: fg disabled");
        r102 = false;
        goto L10
    }

    public void unregisterRequestManager(RequestManager r100) {
        List<RequestManager> r101 = this.managers;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.managers.contains(r100) == false) goto L10;
        this.managers.remove(r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Cannot unregister not yet registered manager");     // Catch: Throwable -> L11
    }

    public static RequestManager with(View r100) {
        return getRetriever(r100.getContext()).get(r100);
    }

    public static RequestManager with(androidx.fragment.app.Fragment r100) {
        return getRetriever(r100.getContext()).get(r100);
    }

    public static RequestManager with(Activity r100) {
        return getRetriever(r100).get(r100);
    }

    public static RequestManager with(Context r100) {
        return getRetriever(r100).get(r100);
    }

    public static RequestManager with(FragmentActivity r100) {
        return getRetriever(r100).get(r100);
    }

    private static void checkAndInitializeGlide(Context r100, GeneratedAppGlideModule r101) {
        if (isInitializing == true) goto L12;
        isInitializing = true;
        initializeGlide(r100, r101);     // Catch: Exception -> L7
    L9:
        isInitializing = false;
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "initializeGlide failed:" + e.getMessage(), e);
        goto L9
    L12:
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static File getPhotoCacheDir(Context r100, String r101) {
        File r102 = r100.getCacheDir();
        if (r102 == null) goto L12;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, r101);
        if (r103.mkdirs() == false) goto L7;
    L11:
        return r103;
    L7:
        if (r103.exists() == true) goto L9;
    L10:
        return null;
    L9:
        if (r103.isDirectory() == true) goto L11;
    L12:
        GlideLogUtil.e(TAG, "default disk cache dir is null");
        return null;
    }

    public static void init(Context r100, GlideBuilder r101) {
        GeneratedAppGlideModule r102 = getAnnotationGeneratedGlideModules(r100);
        monitor-enter(Glide.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L7;
        tearDown();     // Catch: Throwable -> L10
    L7:
        initializeGlide(r100, r101, r102);     // Catch: Throwable -> L10
        monitor-exit(Glide.class);     // Catch: Throwable -> L10
    }

    private static void initializeGlide(Context r100, GeneratedAppGlideModule r101) {
        initializeGlide(r100, new GlideBuilder(), r101);
    }

    private static void initializeGlide(Context r100, GlideBuilder r101, GeneratedAppGlideModule r102) {
        Context r103 = r100.getApplicationContext();
        List<GlideModule> r104 = Collections.emptyList();
        if (r102 != null) goto L5;
    L6:
        r104 = new ManifestParser(r103).parse();
    L8:
        if (r102 != null) goto L10;
    L18:
        Iterator<GlideModule> r105 = r104.iterator();
    L20:
        if (r105.hasNext() == false) goto L22;
        GlideLogUtil.i(TAG, "Discovered GlideModule from manifest: " + r105.next().getClass());
        goto L20
    L22:
        if (r102 == null) goto L24;
        RequestManagerRetriever.RequestManagerFactory r106 = r102.getRequestManagerFactory();
    L25:
        r101.setRequestManagerFactory(r106);
        Iterator<GlideModule> r107 = r104.iterator();
    L27:
        if (r107.hasNext() == false) goto L29;
        r107.next().applyOptions(r103, r101);
        goto L27
    L29:
        if (r102 == null) goto L31;
        r102.applyOptions(r103, r101);
    L31:
        Glide r108 = r101.build(r103);
        Iterator<GlideModule> r109 = r104.iterator();
    L33:
        if (r109.hasNext() == false) goto L40;
        GlideModule r110 = r109.next();
        r110.registerComponents(r103, r108, r108.registry);     // Catch: AbstractMethodError -> L37
    L37:
        e = move-exception;
        throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ".concat(r110.getClass().getName()), e);
    L40:
        if (r102 == null) goto L42;
        r102.registerComponents(r103, r108, r108.registry);
    L42:
        r103.registerComponentCallbacks(r108);
        glide = r108;
        return;
    L24:
        r106 = null;
        goto L25
    L10:
        if (r102.getExcludedModuleClasses().isEmpty() == true) goto L18;
        Set<Class<?>> r111 = r102.getExcludedModuleClasses();
        Iterator<GlideModule> r112 = r104.iterator();
    L13:
        if (r112.hasNext() == false) goto L18;
        GlideModule r113 = r112.next();
        if (r111.contains(r113.getClass()) == false) goto L13;
        GlideLogUtil.i(TAG, "AppGlideModule excludes manifest GlideModule: " + r113);
        r112.remove();
        goto L13
    L5:
        if (r102.isManifestParsingEnabled() == false) goto L8;
        goto L6
    }

    public Glide(Context r210, Engine r211, MemoryCache r212, BitmapPool r213, ArrayPool r214, RequestManagerRetriever r215, ConnectivityMonitorFactory r216, int r217, RequestOptionsFactory r218, Map<Class<?>, TransitionOptions<?, ?>> r310, List<RequestListener<Object>> r311, boolean r312, boolean r313) {
        this.managers = new ArrayList();
        this.memoryCategory = MemoryCategory.NORMAL;
        this.isDowngradeFGEnabled = Boolean.FALSE;
        this.engine = r211;
        this.bitmapPool = r213;
        this.arrayPool = r214;
        this.memoryCache = r212;
        this.requestManagerRetriever = r215;
        this.connectivityMonitorFactory = r216;
        this.defaultRequestOptionsFactory = r218;
        Resources r100 = r210.getResources();
        Registry r101 = new Registry();
        this.registry = r101;
        r101.register(new DefaultImageHeaderParser());
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 27) goto L5;
        r101.register(new ExifInterfaceImageHeaderParser());
    L5:
        List<ImageHeaderParser> r103 = r101.getImageHeaderParsers();
        ByteBufferGifDecoder r110 = new ByteBufferGifDecoder(r210, r103, r213, r214);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> r111 = VideoDecoder.parcel(r213);
        Downsampler r112 = new Downsampler(r101.getImageHeaderParsers(), INVOKEVIRTUAL_com_bumptech_glide_Glide_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100), r213, r214);
        if (r313 == true) goto L8;
    L10:
        ResourceDecoder r113 = new ByteBufferBitmapDecoder(r112);
        ResourceDecoder r114 = new StreamBitmapDecoder(r112, r214);
    L11:
        ResourceDrawableDecoder r115 = new ResourceDrawableDecoder(r210);
        ResourceLoader.StreamFactory r104 = new ResourceLoader.StreamFactory(r100);
        ResourceLoader.UriFactory r105 = new ResourceLoader.UriFactory(r100);
        ResourceLoader.FileDescriptorFactory r106 = new ResourceLoader.FileDescriptorFactory(r100);
        ResourceLoader.AssetFileDescriptorFactory r107 = new ResourceLoader.AssetFileDescriptorFactory(r100);
        BitmapEncoder r108 = new BitmapEncoder(r214);
        BitmapBytesTranscoder r109 = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder r116 = new GifDrawableBytesTranscoder();
        ContentResolver r117 = r210.getContentResolver();
        r101.append(ByteBuffer.class, new ByteBufferEncoder()).append(InputStream.class, new StreamEncoder(r214)).append(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, r113).append(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, r114);
        if (ParcelFileDescriptorRewinder.isSupported() == false) goto L14;
        r101.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(r112));
    L14:
        r101.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, r111).append(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(r213)).append(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).append(Bitmap.class, r108).append(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(r100, r113)).append(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(r100, r114)).append(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(r100, r111)).append(BitmapDrawable.class, new BitmapDrawableEncoder(r213, r108)).append(Registry.BUCKET_GIF, InputStream.class, GifDrawable.class, new StreamGifDecoder(r103, r110, r214)).append(Registry.BUCKET_GIF, ByteBuffer.class, GifDrawable.class, r110).append(GifDrawable.class, new GifDrawableEncoder()).append(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(r213)).append(Uri.class, Drawable.class, r115).append(Uri.class, Bitmap.class, new ResourceBitmapDecoder(r115, r213)).register(new ByteBufferRewinder.Factory()).append(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).append(File.class, InputStream.class, new FileLoader.StreamFactory()).append(File.class, File.class, new FileDecoder()).append(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).append(File.class, File.class, UnitModelLoader.Factory.getInstance()).register(new InputStreamRewinder.Factory(r214));
        if (ParcelFileDescriptorRewinder.isSupported() == false) goto L17;
        r101.register(new ParcelFileDescriptorRewinder.Factory());
    L17:
        Class r118 = Integer.TYPE;
        r101.append(r118, InputStream.class, r104).append(r118, ParcelFileDescriptor.class, r106).append(Integer.class, InputStream.class, r104).append(Integer.class, ParcelFileDescriptor.class, r106).append(Integer.class, Uri.class, r105).append(r118, AssetFileDescriptor.class, r107).append(Integer.class, AssetFileDescriptor.class, r107).append(r118, Uri.class, r105).append(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(String.class, InputStream.class, new StringLoader.StreamFactory()).append(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).append(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).append(Uri.class, InputStream.class, new HttpUriLoader.Factory()).append(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(r210.getAssets())).append(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(r210.getAssets())).append(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(r210)).append(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(r210));
        if (r102 < 29) goto L20;
        r101.append(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(r210));
        r101.append(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(r210));
    L20:
        r101.append(Uri.class, InputStream.class, new UriLoader.StreamFactory(r117)).append(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(r117)).append(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(r117)).append(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).append(URL.class, InputStream.class, new UrlLoader.StreamFactory()).append(Uri.class, File.class, new MediaStoreFileLoader.Factory(r210)).append(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).append(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).append(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).append(Uri.class, Uri.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, new UnitDrawableDecoder()).register(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(r100)).register(Bitmap.class, byte[].class, r109).register(Drawable.class, byte[].class, new DrawableBytesTranscoder(r213, r109, r116)).register(GifDrawable.class, byte[].class, r116);
        if (r102 < 23) goto L23;
        ResourceDecoder<ByteBuffer, Bitmap> r119 = VideoDecoder.byteBuffer(r213);
        r101.append(ByteBuffer.class, Bitmap.class, r119);
        r101.append(ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(r100, r119));
    L23:
        this.glideContext = new GlideContext(r210, r214, r101, new ImageViewTargetFactory(), r218, r310, r311, r211, r312, r217);
        return;
    L8:
        if (r102 < 28) goto L10;
        r114 = new InputStreamBitmapImageDecoderResourceDecoder();
        r113 = new ByteBufferBitmapImageDecoderResourceDecoder();
        goto L11
    }
}
