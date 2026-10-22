package androidx.camera.core.resolutionselector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class ResolutionSelector {
    public static final int PREFER_CAPTURE_RATE_OVER_HIGHER_RESOLUTION = 0;
    public static final int PREFER_HIGHER_RESOLUTION_OVER_CAPTURE_RATE = 1;
    private final int mAllowedResolutionMode;
    private final AspectRatioStrategy mAspectRatioStrategy;
    private final ResolutionFilter mResolutionFilter;
    private final ResolutionStrategy mResolutionStrategy;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AllowedResolutionMode {
    }

    public static final class Builder {
        private int mAllowedResolutionMode;
        private AspectRatioStrategy mAspectRatioStrategy;
        private ResolutionFilter mResolutionFilter;
        private ResolutionStrategy mResolutionStrategy;

        public ResolutionSelector build() {
            return new ResolutionSelector(this.mAspectRatioStrategy, this.mResolutionStrategy, this.mResolutionFilter, this.mAllowedResolutionMode);
        }

        public Builder() {
            this.mAspectRatioStrategy = AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY;
            this.mResolutionStrategy = null;
            this.mResolutionFilter = null;
            this.mAllowedResolutionMode = 0;
        }

        private Builder(ResolutionSelector r100) {
            this.mAspectRatioStrategy = AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY;
            this.mResolutionStrategy = null;
            this.mResolutionFilter = null;
            this.mAllowedResolutionMode = 0;
            this.mAspectRatioStrategy = r100.getAspectRatioStrategy();
            this.mResolutionStrategy = r100.getResolutionStrategy();
            this.mResolutionFilter = r100.getResolutionFilter();
            this.mAllowedResolutionMode = r100.getAllowedResolutionMode();
        }

        public static Builder fromResolutionSelector(ResolutionSelector r100) {
            return new Builder(r100);
        }

        public Builder setAllowedResolutionMode(int r100) {
            this.mAllowedResolutionMode = r100;
            return this;
        }

        public Builder setAspectRatioStrategy(AspectRatioStrategy r100) {
            this.mAspectRatioStrategy = r100;
            return this;
        }

        public Builder setResolutionFilter(ResolutionFilter r100) {
            this.mResolutionFilter = r100;
            return this;
        }

        public Builder setResolutionStrategy(ResolutionStrategy r100) {
            this.mResolutionStrategy = r100;
            return this;
        }
    }

    public int getAllowedResolutionMode() {
        return this.mAllowedResolutionMode;
    }

    public AspectRatioStrategy getAspectRatioStrategy() {
        return this.mAspectRatioStrategy;
    }

    public ResolutionFilter getResolutionFilter() {
        return this.mResolutionFilter;
    }

    public ResolutionStrategy getResolutionStrategy() {
        return this.mResolutionStrategy;
    }

    public ResolutionSelector(AspectRatioStrategy r100, ResolutionStrategy r101, ResolutionFilter r102, int r103) {
        this.mAspectRatioStrategy = r100;
        this.mResolutionStrategy = r101;
        this.mResolutionFilter = r102;
        this.mAllowedResolutionMode = r103;
    }
}
