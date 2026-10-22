package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableImageInfo implements ImageInfo {
    public ImmutableImageInfo() {
    }

    @Override // androidx.camera.core.ImageInfo
    public abstract int getRotationDegrees();

    @Override // androidx.camera.core.ImageInfo
    public abstract Matrix getSensorToBufferTransformMatrix();

    @Override // androidx.camera.core.ImageInfo
    public abstract TagBundle getTagBundle();

    @Override // androidx.camera.core.ImageInfo
    public abstract long getTimestamp();

    @Override // androidx.camera.core.ImageInfo
    public void populateExifData(ExifData.Builder r100) {
        r100.setOrientationDegrees(getRotationDegrees());
    }

    public static ImageInfo create(TagBundle r100, long r101, int r110, Matrix r111) {
        return new AutoValue_ImmutableImageInfo(r100, r101, r110, r111);
    }
}
