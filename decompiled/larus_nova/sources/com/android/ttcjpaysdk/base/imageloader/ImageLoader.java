package com.android.ttcjpaysdk.base.imageloader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.widget.ImageView;
import com.android.ttcjpaysdk.base.BuildConfig;
import com.android.ttcjpaysdk.base.CJPayPerformance;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0004\u001a\u001b\u001c\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017J$\u0010\r\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/base/imageloader/ImageLoader;", "", "()V", "diskCache", "Lcom/android/ttcjpaysdk/base/imageloader/DiskCache;", "imageLoaderHandler", "Landroid/os/Handler;", "imageLoaderHandlerThread", "Landroid/os/HandlerThread;", "memoryCache", "Lcom/android/ttcjpaysdk/base/imageloader/MemoryCache;", "netCache", "Lcom/android/ttcjpaysdk/base/imageloader/NetCache;", "loadImage", "", "activity", "Landroid/app/Activity;", "url", "", "imageView", "Landroid/widget/ImageView;", "listener", "Lcom/android/ttcjpaysdk/base/imageloader/ImageLoader$OnImageLoaderListener;", "Lcom/android/ttcjpaysdk/base/imageloader/ImageLoader$OnImageLoaderStatusListener;", "tag", "Lcom/android/ttcjpaysdk/base/imageloader/ImageLoader$OnImageLoaderStatusWithTagListener;", "Companion", "OnImageLoaderListener", "OnImageLoaderStatusListener", "OnImageLoaderStatusWithTagListener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageLoader {
    public static final Companion Companion = null;
    private static final Lazy<ImageLoader> instance$delegate = null;
    private DiskCache diskCache;
    private Handler imageLoaderHandler;
    private HandlerThread imageLoaderHandlerThread;
    private MemoryCache memoryCache;
    private NetCache netCache;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/imageloader/ImageLoader$Companion;", "", "()V", "instance", "Lcom/android/ttcjpaysdk/base/imageloader/ImageLoader;", "getInstance", "()Lcom/android/ttcjpaysdk/base/imageloader/ImageLoader;", "instance$delegate", "Lkotlin/Lazy;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ImageLoader getInstance() {
            return (ImageLoader) ImageLoader.access$getInstance$delegate$cp().getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/imageloader/ImageLoader$OnImageLoaderListener;", "", "loadFinished", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnImageLoaderListener {
        void loadFinished(Bitmap r100);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/imageloader/ImageLoader$OnImageLoaderStatusListener;", "", "loadError", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "loadSuccess", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnImageLoaderStatusListener {
        void loadError(Bitmap r100);

        void loadSuccess(Bitmap r100);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/imageloader/ImageLoader$OnImageLoaderStatusWithTagListener;", "", "loadError", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "tag", "", "loadSuccess", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnImageLoaderStatusWithTagListener {
        void loadError(Bitmap r100, String r101);

        void loadSuccess(Bitmap r100, String r101);
    }

    public /* synthetic */ ImageLoader(DefaultConstructorMarker r100) {
        this();
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ImageLoader$Companion$instance$2.INSTANCE);
    }

    private ImageLoader() {
        this.imageLoaderHandlerThread = new PthreadHandlerThreadV2("CJPay ImageLoader Thread");
        CJPayPerformance.getInstance().initByModule(BuildConfig.LIBRARY_PACKAGE_NAME);
        ThreadMethodProxy.start(this.imageLoaderHandlerThread);
        this.imageLoaderHandler = new Handler(this.imageLoaderHandlerThread.getLooper());
        this.memoryCache = new MemoryCache();
        this.diskCache = new DiskCache();
        this.netCache = new NetCache();
        this.imageLoaderHandler.post(new AnonymousClass1(this));
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    public static final /* synthetic */ DiskCache access$getDiskCache$p(ImageLoader r100) {
        return r100.diskCache;
    }

    public static final /* synthetic */ Handler access$getImageLoaderHandler$p(ImageLoader r100) {
        return r100.imageLoaderHandler;
    }

    public static final /* synthetic */ MemoryCache access$getMemoryCache$p(ImageLoader r100) {
        return r100.memoryCache;
    }

    public static final /* synthetic */ NetCache access$getNetCache$p(ImageLoader r100) {
        return r100.netCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.graphics.Bitmap] */
    public final void loadImage(final String r100, final OnImageLoaderListener r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = this.memoryCache.getBitmap(r100);
        r102.element = r103;
        Bitmap r104 = (Bitmap) r103;
        boolean r105 = false;
        if (r103 != 0) goto L8;
    L10:
        if (r105 == false) goto L14;
        if (r101 == null) goto L16;
        r101.loadFinished((Bitmap) r102.element);
        return;
    L16:
        return;
    L14:
        this.imageLoaderHandler.post(new AnonymousClass2(r102, this, r100, r101));
        return;
    L8:
        if (r103.isRecycled() == true) goto L10;
        r105 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.graphics.Bitmap] */
    public final void loadImage(final String r100, final OnImageLoaderStatusListener r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = this.memoryCache.getBitmap(r100);
        r102.element = r103;
        Bitmap r104 = (Bitmap) r103;
        boolean r105 = false;
        if (r103 != 0) goto L8;
    L10:
        if (r105 == false) goto L14;
        if (r101 == null) goto L16;
        r101.loadSuccess((Bitmap) r102.element);
        return;
    L16:
        return;
    L14:
        this.imageLoaderHandler.post(new AnonymousClass3(r102, this, r100, r101));
        return;
    L8:
        if (r103.isRecycled() == true) goto L10;
        r105 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, android.graphics.Bitmap] */
    public final void loadImage(final String r100, final String r110, final OnImageLoaderStatusWithTagListener r111) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        ?? r102 = this.memoryCache.getBitmap(r100);
        r101.element = r102;
        Bitmap r103 = (Bitmap) r102;
        boolean r104 = false;
        if (r102 != 0) goto L8;
    L10:
        if (r104 == false) goto L14;
        if (r111 == null) goto L16;
        r111.loadSuccess((Bitmap) r101.element, r110);
        return;
    L16:
        return;
    L14:
        this.imageLoaderHandler.post(new AnonymousClass4(r101, this, r100, r111, r110));
        return;
    L8:
        if (r102.isRecycled() == true) goto L10;
        r104 = true;
        goto L10
    }

    public final void loadImage(final Activity r100, String r101, final ImageView r102) {
        if (TextUtils.isEmpty(r101) == true) goto L9;
        if (r100 == null) goto L10;
        if (r102 == null) goto L11;
        loadImage(r101, new C88671(r100, r102));
        return;
    L11:
        return;
    L10:
        return;
    }
}
