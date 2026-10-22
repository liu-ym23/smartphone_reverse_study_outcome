package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;

/* JADX INFO: loaded from: classes2.dex */
public final class SettableImageProxy extends ForwardingImageProxy {
    private Rect mCropRect;
    private final int mHeight;
    private final ImageInfo mImageInfo;
    private final Object mLock;
    private final int mWidth;

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public Rect getCropRect() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mCropRect != null) goto L9;
        Rect r101 = new Rect(0, 0, getWidth(), getHeight());     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    L9:
        Rect r102 = new Rect(this.mCropRect);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r102;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.mHeight;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.mWidth;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public void setCropRect(Rect r100) {
        if (r100 == null) goto L7;
        Rect r101 = new Rect(r100);
        if (r101.intersect(0, 0, getWidth(), getHeight()) == true) goto L6;
        r101.setEmpty();
    L6:
        r100 = r101;
    L7:
        Object r102 = this.mLock;
        monitor-enter(r102);
        this.mCropRect = r100;     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public SettableImageProxy(ImageProxy r100, ImageInfo r101) {
        this(r100, null, r101);
    }

    public SettableImageProxy(ImageProxy r100, Size r101, ImageInfo r102) {
        super(r100);
        this.mLock = new Object();
        if (r101 != null) goto L5;
        this.mWidth = super.getWidth();
        this.mHeight = super.getHeight();
    L6:
        this.mImageInfo = r102;
        return;
    L5:
        this.mWidth = r101.getWidth();
        this.mHeight = r101.getHeight();
        goto L6
    }
}
