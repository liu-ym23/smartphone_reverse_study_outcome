package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;

/* JADX INFO: loaded from: classes2.dex */
public class MaxPreviewSize {
    private final ExtraCroppingQuirk mExtraCroppingQuirk;

    public MaxPreviewSize() {
        this((ExtraCroppingQuirk) DeviceQuirks.get(ExtraCroppingQuirk.class));
    }

    public MaxPreviewSize(ExtraCroppingQuirk r100) {
        this.mExtraCroppingQuirk = r100;
    }

    public Size getMaxPreviewResolution(Size r100) {
        ExtraCroppingQuirk r101 = this.mExtraCroppingQuirk;
        if (r101 != null) goto L5;
        return r100;
    L5:
        Size r102 = r101.getVerifiedResolution(SurfaceConfig.ConfigType.PRIV);
        if (r102 != null) goto L9;
        return r100;
    L9:
        if ((r102.getWidth() * r102.getHeight()) <= (r100.getWidth() * r100.getHeight())) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        return r100;
    L14:
        return r102;
    L11:
        r103 = false;
        goto L12
    }
}
