package androidx.camera.camera2.internal;

import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.workaround.ImageCapturePixelHDRPlus;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: loaded from: classes2.dex */
final class ImageCaptureOptionUnpacker extends Camera2CaptureOptionUnpacker {
    static final ImageCaptureOptionUnpacker INSTANCE = null;
    private final ImageCapturePixelHDRPlus mImageCapturePixelHDRPlus;

    static {
        INSTANCE = new ImageCaptureOptionUnpacker(new ImageCapturePixelHDRPlus());
    }

    private ImageCaptureOptionUnpacker(ImageCapturePixelHDRPlus r100) {
        this.mImageCapturePixelHDRPlus = r100;
    }

    @Override // androidx.camera.camera2.internal.Camera2CaptureOptionUnpacker, androidx.camera.core.impl.CaptureConfig.OptionUnpacker
    public void unpack(UseCaseConfig<?> r100, CaptureConfig.Builder r101) {
        super.unpack(r100, r101);
        if ((r100 instanceof ImageCaptureConfig) == false) goto L10;
        ImageCaptureConfig r102 = (ImageCaptureConfig) r100;
        Camera2ImplConfig.Builder r103 = new Camera2ImplConfig.Builder();
        if (r102.hasCaptureMode() == false) goto L7;
        this.mImageCapturePixelHDRPlus.toggleHDRPlus(r102.getCaptureMode(), r103);
    L7:
        r101.addImplementationOptions(r103.build());
        return;
    L10:
        throw new IllegalArgumentException("config is not ImageCaptureConfig");
    }
}
