package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.concurrent.CameraCoordinator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraFactory {

    public interface Provider {
        CameraFactory newInstance(Context r100, CameraThreadConfig r101, CameraSelector r102, long r103) throws InitializationException;
    }

    Set<String> getAvailableCameraIds();

    CameraInternal getCamera(String r100) throws CameraUnavailableException;

    CameraCoordinator getCameraCoordinator();

    Object getCameraManager();
}
