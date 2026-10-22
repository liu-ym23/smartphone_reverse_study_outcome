package androidx.camera.camera2.internal;

import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: loaded from: classes2.dex */
class Camera2CaptureOptionUnpacker implements CaptureConfig.OptionUnpacker {
    static final Camera2CaptureOptionUnpacker INSTANCE = null;

    public Camera2CaptureOptionUnpacker() {
    }

    static {
        INSTANCE = new Camera2CaptureOptionUnpacker();
    }

    @Override // androidx.camera.core.impl.CaptureConfig.OptionUnpacker
    public void unpack(UseCaseConfig<?> r100, CaptureConfig.Builder r101) {
        CaptureConfig r102 = r100.getDefaultCaptureConfig(null);
        Config r103 = OptionsBundle.emptyBundle();
        int r104 = CaptureConfig.defaultEmptyCaptureConfig().getTemplateType();
        if (r102 == null) goto L5;
        r104 = r102.getTemplateType();
        r101.addAllCameraCaptureCallbacks(r102.getCameraCaptureCallbacks());
        r103 = r102.getImplementationOptions();
    L5:
        r101.setImplementationOptions(r103);
        Camera2ImplConfig r105 = new Camera2ImplConfig(r100);
        r101.setTemplateType(r105.getCaptureRequestTemplate(r104));
        r101.addCameraCaptureCallback(CaptureCallbackContainer.create(r105.getSessionCaptureCallback(Camera2CaptureCallbacks.createNoOpCallback())));
        r101.addImplementationOptions(r105.getCaptureRequestOptions());
    }
}
