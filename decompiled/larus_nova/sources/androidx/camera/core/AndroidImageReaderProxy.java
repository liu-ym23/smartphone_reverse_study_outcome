package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class AndroidImageReaderProxy implements ImageReaderProxy {
    private final ImageReader mImageReader;
    private boolean mIsImageAvailableListenerCleared;
    private final Object mLock;

    public static /* synthetic */ void a(AndroidImageReaderProxy r100, Executor r101, ImageReaderProxy.OnImageAvailableListener r102, ImageReader r103) {
        r100.lambda$setOnImageAvailableListener$1(r101, r102, r103);
    }

    public static /* synthetic */ void b(AndroidImageReaderProxy r100, ImageReaderProxy.OnImageAvailableListener r101) {
        r100.lambda$setOnImageAvailableListener$0(r101);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireLatestImage() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Image r101 = this.mImageReader.acquireLatestImage();     // Catch: Throwable -> L7 RuntimeException -> L9
    L13:
        if (r101 != null) goto L16;
        monitor-exit(r100);     // Catch: Throwable -> L7
        return null;
    L16:
        AndroidImageProxy r102 = new AndroidImageProxy(r101);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r102;
    L9:
        e = move-exception;
        if (isImageReaderContextNotInitializedException(e) == false) goto L19;
        r101 = null;
        goto L13
    L19:
        throw e;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireNextImage() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Image r101 = this.mImageReader.acquireNextImage();     // Catch: Throwable -> L7 RuntimeException -> L9
    L13:
        if (r101 != null) goto L16;
        monitor-exit(r100);     // Catch: Throwable -> L7
        return null;
    L16:
        AndroidImageProxy r102 = new AndroidImageProxy(r101);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r102;
    L9:
        e = move-exception;
        if (isImageReaderContextNotInitializedException(e) == false) goto L19;
        r101 = null;
        goto L13
    L19:
        throw e;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mIsImageAvailableListenerCleared = true;     // Catch: Throwable -> L8
        this.mImageReader.setOnImageAvailableListener(null, null);     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mImageReader.close();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mImageReader.getHeight();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mImageReader.getImageFormat();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mImageReader.getMaxImages();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Surface r101 = this.mImageReader.getSurface();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mImageReader.getWidth();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public AndroidImageReaderProxy(ImageReader r100) {
        this.mLock = new Object();
        this.mIsImageAvailableListenerCleared = true;
        this.mImageReader = r100;
    }

    private boolean isImageReaderContextNotInitializedException(RuntimeException r100) {
        return "ImageReaderContext is not initialized".equals(r100.getMessage());
    }

    private /* synthetic */ void lambda$setOnImageAvailableListener$0(ImageReaderProxy.OnImageAvailableListener r100) {
        r100.onImageAvailable(this);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(final ImageReaderProxy.OnImageAvailableListener r100, final Executor r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        this.mIsImageAvailableListenerCleared = false;     // Catch: Throwable -> L8
        ImageReader.OnImageAvailableListener r103 = new b(this, r101, r100);     // Catch: Throwable -> L8
        this.mImageReader.setOnImageAvailableListener(r103, MainThreadAsyncHandler.getInstance());     // Catch: Throwable -> L8
        monitor-exit(r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setOnImageAvailableListener$1(Executor r100, final ImageReaderProxy.OnImageAvailableListener r101, ImageReader r102) {
        Object r103 = this.mLock;
        monitor-enter(r103);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsImageAvailableListenerCleared == true) goto L7;
        r100.execute(new a(this, r101));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L9
    }
}
