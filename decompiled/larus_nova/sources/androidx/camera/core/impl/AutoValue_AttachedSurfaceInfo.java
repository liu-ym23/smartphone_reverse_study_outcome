package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_AttachedSurfaceInfo extends AttachedSurfaceInfo {
    private final List<UseCaseConfigFactory.CaptureType> captureTypes;
    private final DynamicRange dynamicRange;
    private final int imageFormat;
    private final Config implementationOptions;
    private final Size size;
    private final SurfaceConfig surfaceConfig;
    private final Range<Integer> targetFrameRate;

    public int hashCode() {
        int r100 = (((((((((this.surfaceConfig.hashCode() ^ 1000003) * 1000003) ^ this.imageFormat) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.captureTypes.hashCode()) * 1000003;
        Config r101 = this.implementationOptions;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 ^ r103) * 1000003;
        Range<Integer> r105 = this.targetFrameRate;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 ^ r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.surfaceConfig + ", imageFormat=" + this.imageFormat + ", size=" + this.size + ", dynamicRange=" + this.dynamicRange + ", captureTypes=" + this.captureTypes + ", implementationOptions=" + this.implementationOptions + ", targetFrameRate=" + this.targetFrameRate + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
        return this.captureTypes;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public int getImageFormat() {
        return this.imageFormat;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public Config getImplementationOptions() {
        return this.implementationOptions;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public SurfaceConfig getSurfaceConfig() {
        return this.surfaceConfig;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public Range<Integer> getTargetFrameRate() {
        return this.targetFrameRate;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AttachedSurfaceInfo) == false) goto L34;
        AttachedSurfaceInfo r101 = (AttachedSurfaceInfo) r100;
        if (this.surfaceConfig.equals(r101.getSurfaceConfig()) == true) goto L10;
    L32:
        return false;
    L10:
        if (this.imageFormat != r101.getImageFormat()) goto L32;
        if (this.size.equals(r101.getSize()) == false) goto L32;
        if (this.dynamicRange.equals(r101.getDynamicRange()) == false) goto L32;
        if (this.captureTypes.equals(r101.getCaptureTypes()) == false) goto L32;
        Config r102 = this.implementationOptions;
        if (r102 != null) goto L23;
        if (r101.getImplementationOptions() != null) goto L32;
    L24:
        Range<Integer> r103 = this.targetFrameRate;
        if (r103 != null) goto L30;
        if (r101.getTargetFrameRate() != null) goto L32;
        return true;
    L30:
        if (r103.equals(r101.getTargetFrameRate()) == false) goto L32;
        return true;
    L23:
        if (r102.equals(r101.getImplementationOptions()) == false) goto L32;
    L34:
        return false;
    }

    public AutoValue_AttachedSurfaceInfo(SurfaceConfig r100, int r101, Size r102, DynamicRange r103, List<UseCaseConfigFactory.CaptureType> r104, Config r105, Range<Integer> r106) {
        if (r100 == null) goto L19;
        this.surfaceConfig = r100;
        this.imageFormat = r101;
        if (r102 == null) goto L17;
        this.size = r102;
        if (r103 == null) goto L15;
        this.dynamicRange = r103;
        if (r104 == null) goto L13;
        this.captureTypes = r104;
        this.implementationOptions = r105;
        this.targetFrameRate = r106;
        return;
    L13:
        throw new NullPointerException("Null captureTypes");
    L15:
        throw new NullPointerException("Null dynamicRange");
    L17:
        throw new NullPointerException("Null size");
    L19:
        throw new NullPointerException("Null surfaceConfig");
    }
}
