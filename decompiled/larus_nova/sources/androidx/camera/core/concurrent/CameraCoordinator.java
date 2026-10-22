package androidx.camera.core.concurrent;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraCoordinator {
    public static final int CAMERA_OPERATING_MODE_CONCURRENT = 2;
    public static final int CAMERA_OPERATING_MODE_SINGLE = 1;
    public static final int CAMERA_OPERATING_MODE_UNSPECIFIED = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraOperatingMode {
    }

    public interface ConcurrentCameraModeListener {
        void onCameraOperatingModeUpdated(int r100, int r101);
    }

    void addListener(ConcurrentCameraModeListener r100);

    List<CameraInfo> getActiveConcurrentCameraInfos();

    int getCameraOperatingMode();

    List<List<CameraSelector>> getConcurrentCameraSelectors();

    String getPairedConcurrentCameraId(String r100);

    void removeListener(ConcurrentCameraModeListener r100);

    void setActiveConcurrentCameraInfos(List<CameraInfo> r100);

    void setCameraOperatingMode(int r100);

    void shutdown();
}
