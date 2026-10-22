package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
interface CaptureSessionInterface {
    void cancelIssuedCaptureRequests();

    void close();

    List<CaptureConfig> getCaptureConfigs();

    SessionConfig getSessionConfig();

    boolean isInOpenState();

    void issueCaptureRequests(List<CaptureConfig> r100);

    ListenableFuture<Void> open(SessionConfig r100, CameraDevice r101, SynchronizedCaptureSession.Opener r102);

    ListenableFuture<Void> release(boolean r100);

    void setSessionConfig(SessionConfig r100);

    void setStreamUseCaseMap(Map<DeferrableSurface, Long> r100);
}
