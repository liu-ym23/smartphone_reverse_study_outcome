package androidx.camera.core;

import android.util.Rational;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewPort {
    public static final int FILL_CENTER = 1;
    public static final int FILL_END = 2;
    public static final int FILL_START = 0;
    public static final int FIT = 3;
    private Rational mAspectRatio;
    private int mLayoutDirection;
    private int mRotation;
    private int mScaleType;

    public static final class Builder {
        private static final int DEFAULT_LAYOUT_DIRECTION = 0;
        private static final int DEFAULT_SCALE_TYPE = 1;
        private final Rational mAspectRatio;
        private int mLayoutDirection;
        private final int mRotation;
        private int mScaleType;

        public ViewPort build() {
            Preconditions.checkNotNull(this.mAspectRatio, "The crop aspect ratio must be set.");
            return new ViewPort(this.mScaleType, this.mAspectRatio, this.mRotation, this.mLayoutDirection);
        }

        public Builder setLayoutDirection(int r100) {
            this.mLayoutDirection = r100;
            return this;
        }

        public Builder setScaleType(int r100) {
            this.mScaleType = r100;
            return this;
        }

        public Builder(Rational r100, int r101) {
            this.mScaleType = 1;
            this.mLayoutDirection = 0;
            this.mAspectRatio = r100;
            this.mRotation = r101;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScaleType {
    }

    public Rational getAspectRatio() {
        return this.mAspectRatio;
    }

    public int getLayoutDirection() {
        return this.mLayoutDirection;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getScaleType() {
        return this.mScaleType;
    }

    public ViewPort(int r100, Rational r101, int r102, int r103) {
        this.mScaleType = r100;
        this.mAspectRatio = r101;
        this.mRotation = r102;
        this.mLayoutDirection = r103;
    }
}
