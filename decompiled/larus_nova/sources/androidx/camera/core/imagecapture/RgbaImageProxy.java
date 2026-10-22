package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class RgbaImageProxy implements ImageProxy {
    private final Rect mCropRect;
    private final int mHeight;
    private final ImageInfo mImageInfo;
    private final Object mLock;
    ImageProxy.PlaneProxy[] mPlaneProxy;
    private final int mWidth;

    @Override // androidx.camera.core.ImageProxy
    public final /* synthetic */ Bitmap toBitmap() {
        return ImageProxy.CC.$default$toBitmap(this);
    }

    private void checkNotClosed() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mPlaneProxy == null) goto L7;
        boolean r101 = true;
    L8:
        Preconditions.checkState(r101, "The image is closed.");     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkNotClosed();     // Catch: Throwable -> L7
        this.mPlaneProxy = null;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Bitmap createBitmap() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkNotClosed();     // Catch: Throwable -> L7
        Bitmap r101 = ImageUtil.createBitmapFromPlane(getPlanes(), getWidth(), getHeight());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public Rect getCropRect() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkNotClosed();     // Catch: Throwable -> L7
        Rect r101 = this.mCropRect;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkNotClosed();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return 1;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkNotClosed();     // Catch: Throwable -> L7
        int r101 = this.mHeight;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public Image getImage() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkNotClosed();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageInfo getImageInfo() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkNotClosed();     // Catch: Throwable -> L7
        ImageInfo r101 = this.mImageInfo;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageProxy.PlaneProxy[] getPlanes() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkNotClosed();     // Catch: Throwable -> L7
        ImageProxy.PlaneProxy[] r101 = this.mPlaneProxy;     // Catch: Throwable -> L7
        Objects.requireNonNull(r101);     // Catch: Throwable -> L7
        ImageProxy.PlaneProxy[] r102 = r101;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkNotClosed();     // Catch: Throwable -> L7
        int r101 = this.mWidth;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public RgbaImageProxy(Packet<Bitmap> r100) {
        this(r100.getData(), r100.getCropRect(), r100.getRotationDegrees(), r100.getSensorToBufferTransform(), r100.getCameraCaptureResult().getTimestamp());
    }

    @Override // androidx.camera.core.ImageProxy
    public void setCropRect(Rect r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        checkNotClosed();     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        this.mCropRect.set(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static ImageInfo createImageInfo(final long r100, final int r101, final Matrix r102) {
        return new AnonymousClass2(r100, r101, r102);
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(final ByteBuffer r100, final int r101, final int r102) {
        return new AnonymousClass1(r101, r102, r100);
    }

    public RgbaImageProxy(Bitmap r110, Rect r111, int r112, Matrix r113, long r114) {
        this(ImageUtil.createDirectByteBuffer(r110), 4, r110.getWidth(), r110.getHeight(), r111, r112, r113, r114);
    }

    public RgbaImageProxy(ByteBuffer r100, int r101, int r102, int r103, Rect r104, int r105, Matrix r106, long r107) {
        this.mLock = new Object();
        this.mWidth = r102;
        this.mHeight = r103;
        this.mCropRect = r104;
        this.mImageInfo = createImageInfo(r107, r105, r106);
        r100.rewind();
        this.mPlaneProxy = new ImageProxy.PlaneProxy[]{createPlaneProxy(r100, r102 * r101, r101)};
    }
}
