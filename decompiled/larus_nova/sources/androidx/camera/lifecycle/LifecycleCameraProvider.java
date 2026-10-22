package androidx.camera.lifecycle;

import androidx.camera.core.CameraProvider;
import androidx.camera.core.UseCase;

/* JADX INFO: loaded from: classes2.dex */
interface LifecycleCameraProvider extends CameraProvider {
    boolean isBound(UseCase r100);

    void unbind(UseCase... r100);

    void unbindAll();
}
