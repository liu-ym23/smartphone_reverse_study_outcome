package androidx.camera.camera2.internal;

import android.content.Context;
import android.util.Size;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class Camera2UseCaseConfigFactory implements UseCaseConfigFactory {
    final DisplayInfoManager mDisplayInfoManager;

    public Camera2UseCaseConfigFactory(Context r100) {
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(r100);
    }

    @Override // androidx.camera.core.impl.UseCaseConfigFactory
    public Config getConfig(UseCaseConfigFactory.CaptureType r100, int r101) {
        MutableOptionsBundle r102 = MutableOptionsBundle.create();
        SessionConfig.Builder r103 = new SessionConfig.Builder();
        r103.setTemplateType(TemplateTypeUtil.getSessionConfigTemplateType(r100, r101));
        r102.insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, r103.build());
        r102.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, Camera2SessionOptionUnpacker.INSTANCE);
        CaptureConfig.Builder r104 = new CaptureConfig.Builder();
        r104.setTemplateType(TemplateTypeUtil.getCaptureConfigTemplateType(r100, r101));
        r102.insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, r104.build());
        Config.Option<CaptureConfig.OptionUnpacker> r105 = UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER;
        if (r100 != UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE) goto L5;
        CaptureConfig.OptionUnpacker r106 = ImageCaptureOptionUnpacker.INSTANCE;
    L6:
        r102.insertOption(r105, r106);
        if (r100 != UseCaseConfigFactory.CaptureType.PREVIEW) goto L9;
        Size r107 = this.mDisplayInfoManager.getPreviewSize();
        r102.insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, r107);
    L9:
        int r108 = this.mDisplayInfoManager.getMaxSizeDisplay(true).getRotation();
        r102.insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(r108));
        if (r100 != UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) goto L12;
    L13:
        r102.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.TRUE);
    L15:
        return OptionsBundle.from(r102);
    L12:
        if (r100 != UseCaseConfigFactory.CaptureType.STREAM_SHARING) goto L15;
    L5:
        r106 = Camera2CaptureOptionUnpacker.INSTANCE;
        goto L6
    }
}
