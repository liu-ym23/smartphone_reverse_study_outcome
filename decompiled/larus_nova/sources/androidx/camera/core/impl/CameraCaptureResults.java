package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraCaptureResults {
    private CameraCaptureResults() {
    }

    public static CameraCaptureResult retrieveCameraCaptureResult(ImageInfo r100) {
        if ((r100 instanceof CameraCaptureResultImageInfo) == true) goto L5;
        return null;
    L5:
        return ((CameraCaptureResultImageInfo) r100).getCameraCaptureResult();
    }
}
