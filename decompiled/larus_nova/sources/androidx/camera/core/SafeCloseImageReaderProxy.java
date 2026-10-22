package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class SafeCloseImageReaderProxy implements ImageReaderProxy {
    private ForwardingImageProxy.OnImageCloseListener mForwardingImageCloseListener;
    private final ForwardingImageProxy.OnImageCloseListener mImageCloseListener;
    private final ImageReaderProxy mImageReaderProxy;
    private boolean mIsClosed;
    private final Object mLock;
    private int mOutstandingImages;
    private final Surface mSurface;

    public static /* synthetic */ void a(SafeCloseImageReaderProxy r100, ImageReaderProxy.OnImageAvailableListener r101, ImageReaderProxy r102) {
        r100.lambda$setOnImageAvailableListener$1(r101, r102);
    }

    public static /* synthetic */ void b(SafeCloseImageReaderProxy r100, ImageProxy r101) {
        r100.lambda$new$0(r101);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireLatestImage() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ImageProxy r101 = wrapImageProxy(this.mImageReaderProxy.acquireLatestImage());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireNextImage() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ImageProxy r101 = wrapImageProxy(this.mImageReaderProxy.acquireNextImage());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mImageReaderProxy.clearOnImageAvailableListener();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Surface r101 = this.mSurface;     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        r101.release();     // Catch: Throwable -> L10
    L7:
        this.mImageReaderProxy.close();     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public int getCapacity() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mImageReaderProxy.getMaxImages() - this.mOutstandingImages;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mImageReaderProxy.getHeight();     // Catch: Throwable -> L7
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
        int r101 = this.mImageReaderProxy.getImageFormat();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public ImageReaderProxy getImageReaderProxy() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ImageReaderProxy r101 = this.mImageReaderProxy;     // Catch: Throwable -> L7
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
        int r101 = this.mImageReaderProxy.getMaxImages();     // Catch: Throwable -> L7
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
        Surface r101 = this.mImageReaderProxy.getSurface();     // Catch: Throwable -> L7
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
        int r101 = this.mImageReaderProxy.getWidth();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isClosed() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        boolean r101 = this.mIsClosed;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public void safeClose() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mIsClosed = true;     // Catch: Throwable -> L10
        this.mImageReaderProxy.clearOnImageAvailableListener();     // Catch: Throwable -> L10
        if (this.mOutstandingImages != 0) goto L8;
        close();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public SafeCloseImageReaderProxy(ImageReaderProxy r100) {
        this.mLock = new Object();
        this.mOutstandingImages = 0;
        this.mIsClosed = false;
        this.mImageCloseListener = new e0(this);
        this.mImageReaderProxy = r100;
        this.mSurface = r100.getSurface();
    }

    private /* synthetic */ void lambda$new$0(ImageProxy r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        int r102 = this.mOutstandingImages - 1;     // Catch: Throwable -> L13
        this.mOutstandingImages = r102;     // Catch: Throwable -> L13
        if (this.mIsClosed == false) goto L8;
        if (r102 != 0) goto L8;
        close();     // Catch: Throwable -> L13
    L8:
        ForwardingImageProxy.OnImageCloseListener r103 = this.mForwardingImageCloseListener;     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        if (r103 == null) goto L18;
        r103.onImageClose(r100);
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private ImageProxy wrapImageProxy(ImageProxy r100) {
        if (r100 == null) goto L5;
        this.mOutstandingImages++;
        SingleCloseImageProxy r101 = new SingleCloseImageProxy(r100);
        r101.addOnImageCloseListener(this.mImageCloseListener);
        return r101;
    L5:
        return null;
    }

    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mForwardingImageCloseListener = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setOnImageAvailableListener$1(ImageReaderProxy.OnImageAvailableListener r100, ImageReaderProxy r101) {
        r100.onImageAvailable(this);
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(final ImageReaderProxy.OnImageAvailableListener r100, Executor r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        this.mImageReaderProxy.setOnImageAvailableListener(new f0(this, r100), r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
