package androidx.camera.core;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraProvider {

    /* JADX INFO: renamed from: androidx.camera.core.CameraProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static CameraInfo $default$getCameraInfo(CameraProvider r100, CameraSelector r101) {
            throw new UnsupportedOperationException("The camera provider is not implemented properly.");
        }
    }

    List<CameraInfo> getAvailableCameraInfos();

    CameraInfo getCameraInfo(CameraSelector r100);

    boolean hasCamera(CameraSelector r100) throws CameraInfoUnavailableException;
}
