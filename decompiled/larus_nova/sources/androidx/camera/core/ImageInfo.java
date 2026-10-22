package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageInfo {

    /* JADX INFO: renamed from: androidx.camera.core.ImageInfo$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Matrix $default$getSensorToBufferTransformMatrix(ImageInfo r100) {
            return new Matrix();
        }
    }

    int getRotationDegrees();

    Matrix getSensorToBufferTransformMatrix();

    TagBundle getTagBundle();

    long getTimestamp();

    void populateExifData(ExifData.Builder r100);
}
