package androidx.camera.core.impl;

import android.util.Size;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SurfaceSizeDefinition {
    public abstract Size getAnalysisSize();

    public abstract Map<Integer, Size> getMaximumSizeMap();

    public abstract Size getPreviewSize();

    public abstract Size getRecordSize();

    public abstract Map<Integer, Size> getS1440pSizeMap();

    public abstract Map<Integer, Size> getS720pSizeMap();

    public abstract Map<Integer, Size> getUltraMaximumSizeMap();

    public SurfaceSizeDefinition() {
    }

    public Size getMaximumSize(int r100) {
        return getMaximumSizeMap().get(Integer.valueOf(r100));
    }

    public Size getS1440pSize(int r100) {
        return getS1440pSizeMap().get(Integer.valueOf(r100));
    }

    public Size getS720pSize(int r100) {
        return getS720pSizeMap().get(Integer.valueOf(r100));
    }

    public Size getUltraMaximumSize(int r100) {
        return getUltraMaximumSizeMap().get(Integer.valueOf(r100));
    }

    public static SurfaceSizeDefinition create(Size r100, Map<Integer, Size> r110, Size r111, Map<Integer, Size> r112, Size r113, Map<Integer, Size> r114, Map<Integer, Size> r115) {
        return new AutoValue_SurfaceSizeDefinition(r100, r110, r111, r112, r113, r114, r115);
    }
}
