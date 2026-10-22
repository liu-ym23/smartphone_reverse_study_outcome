package androidx.camera.core;

import android.media.ImageReader;
import androidx.camera.core.impl.ImageReaderProxy;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageReaderProxys {
    private ImageReaderProxys() {
    }

    public static ImageReaderProxy createIsolatedReader(int r100, int r101, int r102, int r103) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(r100, r101, r102, r103));
    }
}
