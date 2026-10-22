package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadLevelAggregator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final float FULL_SCALE = 32768.0f;
    private int frameCount;
    private final int intervalMs;
    private float peakMax;
    private float probMax;
    private double rmsSum;
    private long windowStartMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Level {
        private final float peak;
        private final float probability;
        private final float rms;

        public Level(float f8, float f9, float f10) {
            this.rms = f8;
            this.peak = f9;
            this.probability = f10;
        }

        public static /* synthetic */ Level copy$default(Level level, float f8, float f9, float f10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f8 = level.rms;
            }
            if ((i10 & 2) != 0) {
                f9 = level.peak;
            }
            if ((i10 & 4) != 0) {
                f10 = level.probability;
            }
            return level.copy(f8, f9, f10);
        }

        public final float component1() {
            return this.rms;
        }

        public final float component2() {
            return this.peak;
        }

        public final float component3() {
            return this.probability;
        }

        public final Level copy(float f8, float f9, float f10) {
            return new Level(f8, f9, f10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Level)) {
                return false;
            }
            Level level = (Level) obj;
            return Float.compare(this.rms, level.rms) == 0 && Float.compare(this.peak, level.peak) == 0 && Float.compare(this.probability, level.probability) == 0;
        }

        public final float getPeak() {
            return this.peak;
        }

        public final float getProbability() {
            return this.probability;
        }

        public final float getRms() {
            return this.rms;
        }

        public int hashCode() {
            return Float.hashCode(this.probability) + a0.a.a(this.peak, Float.hashCode(this.rms) * 31, 31);
        }

        public String toString() {
            return "Level(rms=" + this.rms + ", peak=" + this.peak + ", probability=" + this.probability + ")";
        }
    }

    public VadLevelAggregator(int i10) {
        this.intervalMs = i10;
    }

    private final void reset() {
        this.rmsSum = 0.0d;
        this.frameCount = 0;
        this.peakMax = 0.0f;
        this.probMax = 0.0f;
    }

    public final Level onFrame(short[] frame, float f8, long j10) {
        kotlin.jvm.internal.g.f(frame, "frame");
        if (this.frameCount == 0) {
            this.windowStartMs = j10;
        }
        double d8 = 0.0d;
        int i10 = 0;
        for (short s8 : frame) {
            double d10 = s8;
            d8 += d10 * d10;
            int i11 = s8;
            if (s8 < 0) {
                i11 = -s8;
            }
            if (i11 > i10) {
                i10 = i11;
            }
        }
        double dSqrt = this.rmsSum + (frame.length == 0 ? 0.0d : Math.sqrt(d8 / frame.length));
        this.rmsSum = dSqrt;
        int i12 = this.frameCount + 1;
        this.frameCount = i12;
        float f9 = i10 / 32768.0f;
        if (f9 > this.peakMax) {
            this.peakMax = f9;
        }
        if (f8 > this.probMax) {
            this.probMax = f8;
        }
        if (j10 - this.windowStartMs < this.intervalMs) {
            return null;
        }
        Level level = new Level(dc.h.Z((float) ((dSqrt / i12) / 32768.0f), 0.0f, 1.0f), dc.h.Z(this.peakMax, 0.0f, 1.0f), dc.h.Z(this.probMax, 0.0f, 1.0f));
        reset();
        return level;
    }
}
