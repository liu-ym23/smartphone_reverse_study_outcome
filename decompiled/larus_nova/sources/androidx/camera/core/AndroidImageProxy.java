package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.impl.TagBundle;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class AndroidImageProxy implements ImageProxy {
    private final Image mImage;
    private final ImageInfo mImageInfo;
    private final PlaneProxy[] mPlanes;

    public static final class PlaneProxy implements ImageProxy.PlaneProxy {
        private final Image.Plane mPlane;

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public ByteBuffer getBuffer() {
            return this.mPlane.getBuffer();
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public int getPixelStride() {
            return this.mPlane.getPixelStride();
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public int getRowStride() {
            return this.mPlane.getRowStride();
        }

        public PlaneProxy(Image.Plane r100) {
            this.mPlane = r100;
        }
    }

    @Override // androidx.camera.core.ImageProxy
    public final /* synthetic */ Bitmap toBitmap() {
        return ImageProxy.CC.$default$toBitmap(this);
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        this.mImage.close();
    }

    @Override // androidx.camera.core.ImageProxy
    public Rect getCropRect() {
        return this.mImage.getCropRect();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        return this.mImage.getFormat();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.mImage.getHeight();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.mImage.getWidth();
    }

    @Override // androidx.camera.core.ImageProxy
    public Image getImage() {
        return this.mImage;
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageProxy.PlaneProxy[] getPlanes() {
        return this.mPlanes;
    }

    public AndroidImageProxy(Image r100) {
        this.mImage = r100;
        Image.Plane[] r101 = r100.getPlanes();
        if (r101 == null) goto L8;
        this.mPlanes = new PlaneProxy[r101.length];
        int r102 = 0;
    L6:
        if (r102 >= r101.length) goto L9;
        this.mPlanes[r102] = new PlaneProxy(r101[r102]);
        r102 = r102 + 1;
    L9:
        this.mImageInfo = ImmutableImageInfo.create(TagBundle.emptyBundle(), r100.getTimestamp(), 0, new Matrix());
        return;
    L8:
        this.mPlanes = new PlaneProxy[0];
        goto L9
    }

    @Override // androidx.camera.core.ImageProxy
    public void setCropRect(Rect r100) {
        this.mImage.setCropRect(r100);
    }
}
