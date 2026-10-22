package androidx.camera.camera2.internal;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.SessionConfig;

/* JADX INFO: loaded from: classes2.dex */
interface ZslControl {
    void addZslConfig(SessionConfig.Builder r100);

    ImageProxy dequeueImageFromBuffer();

    boolean enqueueImageToImageWriter(ImageProxy r100);

    boolean isZslDisabledByFlashMode();

    boolean isZslDisabledByUserCaseConfig();

    void setZslDisabledByFlashMode(boolean r100);

    void setZslDisabledByUserCaseConfig(boolean r100);
}
