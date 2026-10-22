package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.workaround.PreviewPixelHDRnet;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: loaded from: classes2.dex */
final class Camera2SessionOptionUnpacker implements SessionConfig.OptionUnpacker {
    static final Camera2SessionOptionUnpacker INSTANCE = null;

    public Camera2SessionOptionUnpacker() {
    }

    static {
        INSTANCE = new Camera2SessionOptionUnpacker();
    }

    @Override // androidx.camera.core.impl.SessionConfig.OptionUnpacker
    public void unpack(Size r100, UseCaseConfig<?> r101, SessionConfig.Builder r102) {
        SessionConfig r103 = r101.getDefaultSessionConfig(null);
        Config r104 = OptionsBundle.emptyBundle();
        int r105 = SessionConfig.defaultEmptySessionConfig().getTemplateType();
        if (r103 == null) goto L5;
        r105 = r103.getTemplateType();
        r102.addAllDeviceStateCallbacks(r103.getDeviceStateCallbacks());
        r102.addAllSessionStateCallbacks(r103.getSessionStateCallbacks());
        r102.addAllRepeatingCameraCaptureCallbacks(r103.getRepeatingCameraCaptureCallbacks());
        r104 = r103.getImplementationOptions();
    L5:
        r102.setImplementationOptions(r104);
        if ((r101 instanceof PreviewConfig) == false) goto L8;
        PreviewPixelHDRnet.setHDRnet(r100, r102);
    L8:
        Camera2ImplConfig r106 = new Camera2ImplConfig(r101);
        r102.setTemplateType(r106.getCaptureRequestTemplate(r105));
        r102.addDeviceStateCallback(r106.getDeviceStateCallback(CameraDeviceStateCallbacks.createNoOpCallback()));
        r102.addSessionStateCallback(r106.getSessionStateCallback(CameraCaptureSessionStateCallbacks.createNoOpCallback()));
        r102.addCameraCaptureCallback(CaptureCallbackContainer.create(r106.getSessionCaptureCallback(Camera2CaptureCallbacks.createNoOpCallback())));
        r102.setVideoStabilization(r101.getVideoStabilizationMode());
        r102.setPreviewStabilization(r101.getPreviewStabilizationMode());
        MutableOptionsBundle r107 = MutableOptionsBundle.create();
        r107.insertOption(Camera2ImplConfig.SESSION_PHYSICAL_CAMERA_ID_OPTION, r106.getPhysicalCameraId(null));
        r107.insertOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION, Long.valueOf(r106.getStreamUseCase(-1)));
        r102.addImplementationOptions(r107);
        r102.addImplementationOptions(r106.getCaptureRequestOptions());
    }
}
