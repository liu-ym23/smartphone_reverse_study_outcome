package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.TransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageProxyTransformFactory {
    private boolean mUsingCropRect;
    private boolean mUsingRotationDegrees;

    public ImageProxyTransformFactory() {
    }

    public boolean isUsingCropRect() {
        return this.mUsingCropRect;
    }

    public boolean isUsingRotationDegrees() {
        return this.mUsingRotationDegrees;
    }

    private RectF getCropRect(ImageProxy r100) {
        if (this.mUsingCropRect == false) goto L7;
        return new RectF(r100.getCropRect());
    L7:
        return new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
    }

    private int getRotationDegrees(ImageProxy r100) {
        if (this.mUsingRotationDegrees == true) goto L5;
        return 0;
    L5:
        return r100.getImageInfo().getRotationDegrees();
    }

    public OutputTransform getOutputTransform(ImageProxy r100) {
        int r101 = getRotationDegrees(r100);
        RectF r102 = getCropRect(r100);
        Matrix r103 = TransformUtils.getRectToRect(r102, getRotatedCropRect(r102, r101), r101);
        r103.preConcat(TransformUtils.getNormalizedToBuffer(r100.getCropRect()));
        return new OutputTransform(r103, TransformUtils.rectToSize(r100.getCropRect()));
    }

    public void setUsingCropRect(boolean r100) {
        this.mUsingCropRect = r100;
    }

    public void setUsingRotationDegrees(boolean r100) {
        this.mUsingRotationDegrees = r100;
    }

    public static RectF getRotatedCropRect(RectF r100, int r101) {
        if (TransformUtils.is90or270(r101) == false) goto L7;
        return new RectF(0.0f, 0.0f, r100.height(), r100.width());
    L7:
        return new RectF(0.0f, 0.0f, r100.width(), r100.height());
    }
}
