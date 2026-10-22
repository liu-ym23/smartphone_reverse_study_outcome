package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AttachedSurfaceInfo {
    public abstract List<UseCaseConfigFactory.CaptureType> getCaptureTypes();

    public abstract DynamicRange getDynamicRange();

    public abstract int getImageFormat();

    public abstract Config getImplementationOptions();

    public abstract Size getSize();

    public abstract SurfaceConfig getSurfaceConfig();

    public abstract Range<Integer> getTargetFrameRate();

    public AttachedSurfaceInfo() {
    }

    public StreamSpec toStreamSpec(Config r100) {
        StreamSpec.Builder r101 = StreamSpec.builder(getSize()).setDynamicRange(getDynamicRange()).setImplementationOptions(r100);
        if (getTargetFrameRate() == null) goto L6;
        r101.setExpectedFrameRateRange(getTargetFrameRate());
    L6:
        return r101.build();
    }

    public static AttachedSurfaceInfo create(SurfaceConfig r100, int r110, Size r111, DynamicRange r112, List<UseCaseConfigFactory.CaptureType> r113, Config r114, Range<Integer> r115) {
        return new AutoValue_AttachedSurfaceInfo(r100, r110, r111, r112, r113, r114, r115);
    }
}
