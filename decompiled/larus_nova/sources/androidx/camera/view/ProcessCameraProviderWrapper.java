package androidx.camera.view;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes2.dex */
interface ProcessCameraProviderWrapper {
    Camera bindToLifecycle(LifecycleOwner r100, CameraSelector r101, UseCaseGroup r102);

    CameraInfo getCameraInfo(CameraSelector r100);

    boolean hasCamera(CameraSelector r100) throws CameraInfoUnavailableException;

    ListenableFuture<Void> shutdownAsync();

    void unbind(UseCase... r100);

    void unbindAll();
}
