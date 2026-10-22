package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_SessionConfig_OutputConfig extends SessionConfig.OutputConfig {
    private final DynamicRange dynamicRange;
    private final int mirrorMode;
    private final String physicalCameraId;
    private final List<DeferrableSurface> sharedSurfaces;
    private final DeferrableSurface surface;
    private final int surfaceGroupId;

    /* JADX INFO: renamed from: androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends SessionConfig.OutputConfig.Builder {
        private DynamicRange dynamicRange;
        private Integer mirrorMode;
        private String physicalCameraId;
        private List<DeferrableSurface> sharedSurfaces;
        private DeferrableSurface surface;
        private Integer surfaceGroupId;

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig build() {
            if (this.surface != null) goto L5;
            String r100 = " surface";
        L7:
            if (this.sharedSurfaces != null) goto L10;
            r100 = r100 + " sharedSurfaces";
        L10:
            if (this.mirrorMode != null) goto L13;
            r100 = r100 + " mirrorMode";
        L13:
            if (this.surfaceGroupId != null) goto L16;
            r100 = r100 + " surfaceGroupId";
        L16:
            if (this.dynamicRange != null) goto L19;
            r100 = r100 + " dynamicRange";
        L19:
            if (r100.isEmpty() == false) goto L23;
            return new AutoValue_SessionConfig_OutputConfig(this.surface, this.sharedSurfaces, this.physicalCameraId, this.mirrorMode.intValue(), this.surfaceGroupId.intValue(), this.dynamicRange, null);
        L23:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setDynamicRange(DynamicRange r100) {
            if (r100 == null) goto L6;
            this.dynamicRange = r100;
            return this;
        L6:
            throw new NullPointerException("Null dynamicRange");
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setMirrorMode(int r100) {
            this.mirrorMode = Integer.valueOf(r100);
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setPhysicalCameraId(String r100) {
            this.physicalCameraId = r100;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setSharedSurfaces(List<DeferrableSurface> r100) {
            if (r100 == null) goto L6;
            this.sharedSurfaces = r100;
            return this;
        L6:
            throw new NullPointerException("Null sharedSurfaces");
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setSurface(DeferrableSurface r100) {
            if (r100 == null) goto L6;
            this.surface = r100;
            return this;
        L6:
            throw new NullPointerException("Null surface");
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder setSurfaceGroupId(int r100) {
            this.surfaceGroupId = Integer.valueOf(r100);
            return this;
        }
    }

    public int hashCode() {
        int r100 = (((this.surface.hashCode() ^ 1000003) * 1000003) ^ this.sharedSurfaces.hashCode()) * 1000003;
        String r101 = this.physicalCameraId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((r100 ^ r102) * 1000003) ^ this.mirrorMode) * 1000003) ^ this.surfaceGroupId) * 1000003) ^ this.dynamicRange.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "OutputConfig{surface=" + this.surface + ", sharedSurfaces=" + this.sharedSurfaces + ", physicalCameraId=" + this.physicalCameraId + ", mirrorMode=" + this.mirrorMode + ", surfaceGroupId=" + this.surfaceGroupId + ", dynamicRange=" + this.dynamicRange + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public int getMirrorMode() {
        return this.mirrorMode;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public String getPhysicalCameraId() {
        return this.physicalCameraId;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public List<DeferrableSurface> getSharedSurfaces() {
        return this.sharedSurfaces;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public DeferrableSurface getSurface() {
        return this.surface;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public int getSurfaceGroupId() {
        return this.surfaceGroupId;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SessionConfig.OutputConfig) == false) goto L27;
        SessionConfig.OutputConfig r101 = (SessionConfig.OutputConfig) r100;
        if (this.surface.equals(r101.getSurface()) == true) goto L10;
    L25:
        return false;
    L10:
        if (this.sharedSurfaces.equals(r101.getSharedSurfaces()) == false) goto L25;
        String r102 = this.physicalCameraId;
        if (r102 != null) goto L17;
        if (r101.getPhysicalCameraId() != null) goto L25;
    L19:
        if (this.mirrorMode != r101.getMirrorMode()) goto L25;
        if (this.surfaceGroupId != r101.getSurfaceGroupId()) goto L25;
        if (this.dynamicRange.equals(r101.getDynamicRange()) == false) goto L25;
        return true;
    L17:
        if (r102.equals(r101.getPhysicalCameraId()) == false) goto L25;
    L27:
        return false;
    }

    private AutoValue_SessionConfig_OutputConfig(DeferrableSurface r100, List<DeferrableSurface> r101, String r102, int r103, int r104, DynamicRange r105) {
        this.surface = r100;
        this.sharedSurfaces = r101;
        this.physicalCameraId = r102;
        this.mirrorMode = r103;
        this.surfaceGroupId = r104;
        this.dynamicRange = r105;
    }

    public /* synthetic */ AutoValue_SessionConfig_OutputConfig(DeferrableSurface r100, List r101, String r102, int r103, int r104, DynamicRange r105, AnonymousClass1 r106) {
        this(r100, r101, r102, r103, r104, r105);
    }
}
