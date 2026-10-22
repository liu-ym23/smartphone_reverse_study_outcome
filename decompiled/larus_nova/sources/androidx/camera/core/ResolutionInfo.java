package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;

/* JADX INFO: loaded from: classes2.dex */
public class ResolutionInfo {
    private final ResolutionInfoInternal mResolutionInfoInternal;

    public static abstract class ResolutionInfoInternal {

        public static abstract class Builder {
            public Builder() {
            }

            public abstract ResolutionInfoInternal build();

            public abstract Builder setCropRect(Rect r100);

            public abstract Builder setResolution(Size r100);

            public abstract Builder setRotationDegrees(int r100);
        }

        public ResolutionInfoInternal() {
        }

        public abstract Rect getCropRect();

        public abstract Size getResolution();

        public abstract int getRotationDegrees();
    }

    public Rect getCropRect() {
        return this.mResolutionInfoInternal.getCropRect();
    }

    public Size getResolution() {
        return this.mResolutionInfoInternal.getResolution();
    }

    public int getRotationDegrees() {
        return this.mResolutionInfoInternal.getRotationDegrees();
    }

    public int hashCode() {
        return this.mResolutionInfoInternal.hashCode();
    }

    public String toString() {
        return this.mResolutionInfoInternal.toString();
    }

    public boolean equals(Object r100) {
        return this.mResolutionInfoInternal.equals(r100);
    }

    public ResolutionInfo(Size r100, Rect r101, int r102) {
        this.mResolutionInfoInternal = new AutoValue_ResolutionInfo_ResolutionInfoInternal.Builder().setResolution(r100).setCropRect(r101).setRotationDegrees(r102).build();
    }
}
