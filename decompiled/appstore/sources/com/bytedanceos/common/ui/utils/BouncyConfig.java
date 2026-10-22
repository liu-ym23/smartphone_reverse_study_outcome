package com.bytedanceos.common.ui.utils;

/* JADX INFO: loaded from: classes2.dex */
public class BouncyConfig {
    public static final BouncyConfig DEFAULT = null;
    private static final int DEF_FRICTION = 200;
    private static final int DEF_GAP_LIMIT = 220;
    private static final int DEF_MAX_ADAPTER_SIZE_TO_ESTIMATE = 20;
    private static final double DEF_SPEED_FACTOR = 5.0d;
    private static final int DEF_TENSION = 1000;
    private static final int DEF_VIEW_COUNT_ESTIMATE_SIZE = 5;
    protected final int friction;
    protected final int gapLimit;
    protected final int maxAdapterSizeToEstimate;
    protected final double speedFactor;
    protected final int tension;
    protected final int viewCountEstimateSize;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.utils.BouncyConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int nestedFriction;
        private int nestedGapLimit;
        private int nestedMaxAdapterSizeToEstimate;
        private double nestedSpeedFactor;
        private int nestedTension;
        private int nestedViewCountEstimateSize;

        public Builder() {
            this.nestedGapLimit = BouncyConfig.DEF_GAP_LIMIT;
            this.nestedSpeedFactor = BouncyConfig.DEF_SPEED_FACTOR;
            this.nestedTension = 1000;
            this.nestedFriction = 200;
            this.nestedViewCountEstimateSize = 5;
            this.nestedMaxAdapterSizeToEstimate = 20;
        }

        public BouncyConfig build() {
            return new BouncyConfig(this.nestedGapLimit, this.nestedSpeedFactor, this.nestedViewCountEstimateSize, this.nestedMaxAdapterSizeToEstimate, this.nestedFriction, this.nestedTension, null);
        }

        public Builder setFriction(int r10) {
            this.nestedFriction = r10;
            return this;
        }

        public Builder setGapLimit(int r10) {
            this.nestedGapLimit = r10;
            return this;
        }

        public Builder setMaxAdapterSizeToEstimate(int r10) {
            this.nestedMaxAdapterSizeToEstimate = r10;
            return this;
        }

        public Builder setSpeedFactor(double r10) {
            if (r10 >= 1.0d) goto L5;
            r10 = 1.0d;
        L5:
            this.nestedSpeedFactor = r10;
            return this;
        }

        public Builder setTension(int r10) {
            this.nestedTension = r10;
            return this;
        }

        public Builder setViewCountEstimateSize(int r10) {
            this.nestedViewCountEstimateSize = r10;
            return this;
        }
    }

    static {
        DEFAULT = new Builder().build();
    }

    public /* synthetic */ BouncyConfig(int r10, double r11, int r12, int r13, int r14, int r15, AnonymousClass1 r16) {
        this(r10, r11, r12, r13, r14, r15);
    }

    public int getFriction() {
        return this.friction;
    }

    public int getGapLimit() {
        return this.gapLimit;
    }

    public int getMaxAdapterSizeToEstimate() {
        return this.maxAdapterSizeToEstimate;
    }

    public double getSpeedFactor() {
        return this.speedFactor;
    }

    public int getTension() {
        return this.tension;
    }

    public int getViewCountEstimateSize() {
        return this.viewCountEstimateSize;
    }

    public String toString() {
        return "BouncyConfig{gapLimit=" + this.gapLimit + ", speedFactor=" + this.speedFactor + ", tension=" + this.tension + ", friction=" + this.friction + ", viewCountEstimateSize=" + this.viewCountEstimateSize + ", maxAdapterSizeToEstimate=" + this.maxAdapterSizeToEstimate + '}';
    }

    private BouncyConfig(int r10, double r11, int r12, int r13, int r14, int r15) {
        this.gapLimit = r10;
        this.speedFactor = r11;
        this.viewCountEstimateSize = r12;
        this.maxAdapterSizeToEstimate = r13;
        this.friction = r14;
        this.tension = r15;
    }
}
