package androidx.camera.core.internal.compat;

import android.hardware.Camera;

/* JADX INFO: loaded from: classes2.dex */
class MediaActionSoundCompatBaseImpl {
    private static final int SAMPLE_CAMERA_ID = 0;

    public static boolean mustPlayShutterSound() {
        if (Camera.getNumberOfCameras() >= 1) goto L9;
        return false;
    L9:
        Camera.CameraInfo r100 = new Camera.CameraInfo();     // Catch: RuntimeException -> L8
        Camera.getCameraInfo(0, r100);     // Catch: RuntimeException -> L8
        return !r100.canDisableShutterSound;
    L8:
        return false;
    }

    private MediaActionSoundCompatBaseImpl() {
    }
}
