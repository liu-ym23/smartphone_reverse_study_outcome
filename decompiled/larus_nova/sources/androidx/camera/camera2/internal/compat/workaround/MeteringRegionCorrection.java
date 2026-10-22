package androidx.camera.camera2.internal.compat.workaround;

import android.graphics.PointF;
import androidx.camera.camera2.internal.compat.quirk.AfRegionFlipHorizontallyQuirk;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: classes2.dex */
public class MeteringRegionCorrection {
    private final Quirks mCameraQuirks;

    public MeteringRegionCorrection(Quirks r100) {
        this.mCameraQuirks = r100;
    }

    public PointF getCorrectedPoint(MeteringPoint r100, int r101) {
        if (r101 != 1) goto L9;
        if (this.mCameraQuirks.contains(AfRegionFlipHorizontallyQuirk.class) == false) goto L9;
        return new PointF(1.0f - r100.getX(), r100.getY());
    L9:
        return new PointF(r100.getX(), r100.getY());
    }
}
