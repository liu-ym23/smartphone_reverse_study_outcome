package androidx.camera.core;

import androidx.camera.core.impl.CameraConfig;

/* JADX INFO: loaded from: classes2.dex */
public interface Camera {

    /* JADX INFO: renamed from: androidx.camera.core.Camera$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isUseCasesCombinationSupported(Camera r100, boolean r101, UseCase... r102) {
            return true;
        }

        public static boolean $default$isUseCasesCombinationSupported(Camera r100, UseCase... r101) {
            return r100.isUseCasesCombinationSupported(true, r101);
        }

        public static boolean $default$isUseCasesCombinationSupportedByFramework(Camera r100, UseCase... r101) {
            return r100.isUseCasesCombinationSupported(false, r101);
        }
    }

    CameraControl getCameraControl();

    CameraInfo getCameraInfo();

    CameraConfig getExtendedConfig();

    boolean isUseCasesCombinationSupported(boolean r100, UseCase... r101);

    boolean isUseCasesCombinationSupported(UseCase... r100);

    boolean isUseCasesCombinationSupportedByFramework(UseCase... r100);
}
