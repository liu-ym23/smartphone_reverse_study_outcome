package androidx.camera.core.impl;

import android.util.Size;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_SurfaceSizeDefinition extends SurfaceSizeDefinition {
    private final Size analysisSize;
    private final Map<Integer, Size> maximumSizeMap;
    private final Size previewSize;
    private final Size recordSize;
    private final Map<Integer, Size> s1440pSizeMap;
    private final Map<Integer, Size> s720pSizeMap;
    private final Map<Integer, Size> ultraMaximumSizeMap;

    public int hashCode() {
        return ((((((((((((this.analysisSize.hashCode() ^ 1000003) * 1000003) ^ this.s720pSizeMap.hashCode()) * 1000003) ^ this.previewSize.hashCode()) * 1000003) ^ this.s1440pSizeMap.hashCode()) * 1000003) ^ this.recordSize.hashCode()) * 1000003) ^ this.maximumSizeMap.hashCode()) * 1000003) ^ this.ultraMaximumSizeMap.hashCode();
    }

    public String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.analysisSize + ", s720pSizeMap=" + this.s720pSizeMap + ", previewSize=" + this.previewSize + ", s1440pSizeMap=" + this.s1440pSizeMap + ", recordSize=" + this.recordSize + ", maximumSizeMap=" + this.maximumSizeMap + ", ultraMaximumSizeMap=" + this.ultraMaximumSizeMap + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getAnalysisSize() {
        return this.analysisSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map<Integer, Size> getMaximumSizeMap() {
        return this.maximumSizeMap;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getPreviewSize() {
        return this.previewSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getRecordSize() {
        return this.recordSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map<Integer, Size> getS1440pSizeMap() {
        return this.s1440pSizeMap;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map<Integer, Size> getS720pSizeMap() {
        return this.s720pSizeMap;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map<Integer, Size> getUltraMaximumSizeMap() {
        return this.ultraMaximumSizeMap;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SurfaceSizeDefinition) == false) goto L24;
        SurfaceSizeDefinition r101 = (SurfaceSizeDefinition) r100;
        if (this.analysisSize.equals(r101.getAnalysisSize()) == true) goto L10;
    L22:
        return false;
    L10:
        if (this.s720pSizeMap.equals(r101.getS720pSizeMap()) == false) goto L22;
        if (this.previewSize.equals(r101.getPreviewSize()) == false) goto L22;
        if (this.s1440pSizeMap.equals(r101.getS1440pSizeMap()) == false) goto L22;
        if (this.recordSize.equals(r101.getRecordSize()) == false) goto L22;
        if (this.maximumSizeMap.equals(r101.getMaximumSizeMap()) == false) goto L22;
        if (this.ultraMaximumSizeMap.equals(r101.getUltraMaximumSizeMap()) == false) goto L22;
        return true;
    L24:
        return false;
    }

    public AutoValue_SurfaceSizeDefinition(Size r100, Map<Integer, Size> r101, Size r102, Map<Integer, Size> r103, Size r104, Map<Integer, Size> r105, Map<Integer, Size> r106) {
        if (r100 == null) goto L31;
        this.analysisSize = r100;
        if (r101 == null) goto L29;
        this.s720pSizeMap = r101;
        if (r102 == null) goto L27;
        this.previewSize = r102;
        if (r103 == null) goto L25;
        this.s1440pSizeMap = r103;
        if (r104 == null) goto L23;
        this.recordSize = r104;
        if (r105 == null) goto L21;
        this.maximumSizeMap = r105;
        if (r106 == null) goto L19;
        this.ultraMaximumSizeMap = r106;
        return;
    L19:
        throw new NullPointerException("Null ultraMaximumSizeMap");
    L21:
        throw new NullPointerException("Null maximumSizeMap");
    L23:
        throw new NullPointerException("Null recordSize");
    L25:
        throw new NullPointerException("Null s1440pSizeMap");
    L27:
        throw new NullPointerException("Null previewSize");
    L29:
        throw new NullPointerException("Null s720pSizeMap");
    L31:
        throw new NullPointerException("Null analysisSize");
    }
}
