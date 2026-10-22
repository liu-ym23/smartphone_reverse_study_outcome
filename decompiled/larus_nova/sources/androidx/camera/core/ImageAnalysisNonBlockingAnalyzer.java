package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class ImageAnalysisNonBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    final Executor mBackgroundExecutor;
    ImageProxy mCachedImage;
    private final Object mLock;
    private CacheAnalyzingImageProxy mPostedImage;

    public static class CacheAnalyzingImageProxy extends ForwardingImageProxy {
        final WeakReference<ImageAnalysisNonBlockingAnalyzer> mNonBlockingAnalyzerWeakReference;

        public static /* synthetic */ void a(CacheAnalyzingImageProxy r100, ImageProxy r101) {
            r100.lambda$new$1(r101);
        }

        public static /* synthetic */ void b(ImageAnalysisNonBlockingAnalyzer r100) {
            lambda$new$0(r100);
        }

        private static /* synthetic */ void lambda$new$0(ImageAnalysisNonBlockingAnalyzer r100) {
            r100.analyzeCachedImage();
        }

        private /* synthetic */ void lambda$new$1(ImageProxy r100) {
            final ImageAnalysisNonBlockingAnalyzer r101 = this.mNonBlockingAnalyzerWeakReference.get();
            if (r101 == null) goto L6;
            r101.mBackgroundExecutor.execute(new o(r101));
            return;
        }

        public CacheAnalyzingImageProxy(ImageProxy r100, ImageAnalysisNonBlockingAnalyzer r101) {
            super(r100);
            this.mNonBlockingAnalyzerWeakReference = new WeakReference(r101);
            addOnImageCloseListener(new p(this));
        }
    }

    public void analyzeCachedImage() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mPostedImage = null;     // Catch: Throwable -> L10
        if (this.mCachedImage == null) goto L8;
        ImageProxy r101 = this.mCachedImage;     // Catch: Throwable -> L10
        this.mCachedImage = null;     // Catch: Throwable -> L10
        onValidImageAvailable(r101);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public void clearCache() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ImageProxy r101 = this.mCachedImage;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.close();     // Catch: Throwable -> L9
        this.mCachedImage = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public ImageAnalysisNonBlockingAnalyzer(Executor r100) {
        this.mLock = new Object();
        this.mBackgroundExecutor = r100;
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public ImageProxy acquireImage(ImageReaderProxy r100) {
        return r100.acquireLatestImage();
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public void onValidImageAvailable(ImageProxy r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsAttached == true) goto L10;
        r100.close();     // Catch: Throwable -> L23
        monitor-exit(r101);     // Catch: Throwable -> L23
        return;
    L10:
        if (this.mPostedImage != null) goto L12;
        final CacheAnalyzingImageProxy r102 = new CacheAnalyzingImageProxy(r100, this);     // Catch: Throwable -> L23
        this.mPostedImage = r102;     // Catch: Throwable -> L23
        Futures.addCallback(analyzeImage(r102), new AnonymousClass1(this, r102), CameraXExecutors.directExecutor());     // Catch: Throwable -> L23
        monitor-exit(r101);     // Catch: Throwable -> L23
        return;
    L12:
        if (r100.getImageInfo().getTimestamp() > this.mPostedImage.getImageInfo().getTimestamp()) goto L14;
        r100.close();     // Catch: Throwable -> L23
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L23
        return;
    L14:
        ImageProxy r103 = this.mCachedImage;     // Catch: Throwable -> L23
        if (r103 == null) goto L17;
        r103.close();     // Catch: Throwable -> L23
    L17:
        this.mCachedImage = r100;     // Catch: Throwable -> L23
        goto L18
    }
}
