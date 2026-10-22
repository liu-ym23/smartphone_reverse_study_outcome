package androidx.camera.core.processing.util;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OutConfig {
    public OutConfig() {
    }

    public abstract Rect getCropRect();

    public abstract int getFormat();

    public abstract int getRotationDegrees();

    public abstract Size getSize();

    public abstract int getTargets();

    public abstract UUID getUuid();

    public abstract boolean isMirroring();

    public abstract boolean shouldRespectInputCropRect();

    public static OutConfig of(SurfaceEdge r100) {
        return of(r100.getTargets(), r100.getFormat(), r100.getCropRect(), TransformUtils.getRotatedSize(r100.getCropRect(), r100.getRotationDegrees()), r100.getRotationDegrees(), r100.isMirroring());
    }

    public static OutConfig of(int r100, int r101, Rect r102, Size r110, int r111, boolean r112) {
        return of(r100, r101, r102, r110, r111, r112, false);
    }

    public static OutConfig of(int r110, int r111, Rect r112, Size r113, int r114, boolean r115, boolean r116) {
        return new AutoValue_OutConfig(UUID.randomUUID(), r110, r111, r112, r113, r114, r115, r116);
    }
}
