package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.CameraOrientationUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class UseCaseConfigUtil {
    private UseCaseConfigUtil() {
    }

    public static void updateTargetRotationAndRelatedConfigs(UseCaseConfig.Builder<?, ?, ?> r100, int r101) {
        ImageOutputConfig r102 = (ImageOutputConfig) r100.getUseCaseConfig();
        int r103 = r102.getTargetRotation(-1);
        if (r103 == (-1)) goto L5;
        if (r103 != r101) goto L5;
    L6:
        if (r103 == (-1)) goto L16;
        if (r101 == (-1)) goto L17;
        if (r103 == r101) goto L20;
        int r104 = CameraOrientationUtil.surfaceRotationToDegrees(r103);
        if ((Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(r101) - r104) % 180) != 90) goto L18;
        Size r105 = r102.getTargetResolution(null);
        if (r105 == null) goto L19;
        ((ImageOutputConfig.Builder) r100).setTargetResolution(new Size(r105.getHeight(), r105.getWidth()));
        return;
    L19:
        return;
    L18:
        return;
    L20:
        return;
    L17:
        return;
    L16:
        return;
    L5:
        ((ImageOutputConfig.Builder) r100).setTargetRotation(r101);
        goto L6
    }
}
