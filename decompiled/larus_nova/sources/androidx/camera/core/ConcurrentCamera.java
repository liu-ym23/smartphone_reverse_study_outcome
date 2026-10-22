package androidx.camera.core;

import androidx.lifecycle.LifecycleOwner;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ConcurrentCamera {
    private List<Camera> mCameras;

    public static final class SingleCameraConfig {
        private CameraSelector mCameraSelector;
        private LayoutSettings mLayoutSettings;
        private LifecycleOwner mLifecycleOwner;
        private UseCaseGroup mUseCaseGroup;

        public CameraSelector getCameraSelector() {
            return this.mCameraSelector;
        }

        public LayoutSettings getLayoutSettings() {
            return this.mLayoutSettings;
        }

        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        public UseCaseGroup getUseCaseGroup() {
            return this.mUseCaseGroup;
        }

        public SingleCameraConfig(CameraSelector r100, UseCaseGroup r101, LifecycleOwner r102) {
            this(r100, r101, LayoutSettings.DEFAULT, r102);
        }

        public SingleCameraConfig(CameraSelector r100, UseCaseGroup r101, LayoutSettings r102, LifecycleOwner r103) {
            this.mCameraSelector = r100;
            this.mUseCaseGroup = r101;
            this.mLayoutSettings = r102;
            this.mLifecycleOwner = r103;
        }
    }

    public List<Camera> getCameras() {
        return this.mCameras;
    }

    public ConcurrentCamera(List<Camera> r100) {
        this.mCameras = r100;
    }
}
