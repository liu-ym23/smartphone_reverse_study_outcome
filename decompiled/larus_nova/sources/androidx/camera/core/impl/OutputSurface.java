package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OutputSurface {
    public OutputSurface() {
    }

    public abstract int getImageFormat();

    public abstract Size getSize();

    public abstract Surface getSurface();

    public static OutputSurface create(Surface r100, Size r101, int r102) {
        return new AutoValue_OutputSurface(r100, r101, r102);
    }
}
