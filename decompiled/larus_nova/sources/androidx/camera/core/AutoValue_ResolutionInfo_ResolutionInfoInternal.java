package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_ResolutionInfo_ResolutionInfoInternal extends ResolutionInfo.ResolutionInfoInternal {
    private final Rect cropRect;
    private final Size resolution;
    private final int rotationDegrees;

    /* JADX INFO: renamed from: androidx.camera.core.AutoValue_ResolutionInfo_ResolutionInfoInternal$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends ResolutionInfo.ResolutionInfoInternal.Builder {
        private Rect cropRect;
        private Size resolution;
        private Integer rotationDegrees;

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal build() {
            if (this.resolution != null) goto L5;
            String r100 = " resolution";
        L7:
            if (this.cropRect != null) goto L10;
            r100 = r100 + " cropRect";
        L10:
            if (this.rotationDegrees != null) goto L13;
            r100 = r100 + " rotationDegrees";
        L13:
            if (r100.isEmpty() == false) goto L17;
            return new AutoValue_ResolutionInfo_ResolutionInfoInternal(this.resolution, this.cropRect, this.rotationDegrees.intValue(), null);
        L17:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal.Builder setCropRect(Rect r100) {
            if (r100 == null) goto L6;
            this.cropRect = r100;
            return this;
        L6:
            throw new NullPointerException("Null cropRect");
        }

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal.Builder setResolution(Size r100) {
            if (r100 == null) goto L6;
            this.resolution = r100;
            return this;
        L6:
            throw new NullPointerException("Null resolution");
        }

        @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal.Builder
        public ResolutionInfo.ResolutionInfoInternal.Builder setRotationDegrees(int r100) {
            this.rotationDegrees = Integer.valueOf(r100);
            return this;
        }
    }

    public int hashCode() {
        return ((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.rotationDegrees;
    }

    public String toString() {
        return "ResolutionInfoInternal{resolution=" + this.resolution + ", cropRect=" + this.cropRect + ", rotationDegrees=" + this.rotationDegrees + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal
    public Size getResolution() {
        return this.resolution;
    }

    @Override // androidx.camera.core.ResolutionInfo.ResolutionInfoInternal
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResolutionInfo.ResolutionInfoInternal) == false) goto L16;
        ResolutionInfo.ResolutionInfoInternal r101 = (ResolutionInfo.ResolutionInfoInternal) r100;
        if (this.resolution.equals(r101.getResolution()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.cropRect.equals(r101.getCropRect()) == false) goto L14;
        if (this.rotationDegrees != r101.getRotationDegrees()) goto L14;
        return true;
    L16:
        return false;
    }

    private AutoValue_ResolutionInfo_ResolutionInfoInternal(Size r100, Rect r101, int r102) {
        this.resolution = r100;
        this.cropRect = r101;
        this.rotationDegrees = r102;
    }

    public /* synthetic */ AutoValue_ResolutionInfo_ResolutionInfoInternal(Size r100, Rect r101, int r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }
}
