package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

/* JADX INFO: loaded from: classes.dex */
public abstract class DownsampleStrategy {
    public static final DownsampleStrategy AT_LEAST = null;
    public static final DownsampleStrategy AT_MOST = null;
    public static final DownsampleStrategy CENTER_INSIDE = null;
    public static final DownsampleStrategy CENTER_OUTSIDE = null;
    public static final DownsampleStrategy DEFAULT = null;
    public static final DownsampleStrategy FIT_CENTER = null;
    public static final DownsampleStrategy NONE = null;
    public static final Option<DownsampleStrategy> OPTION = null;

    public static class AtLeast extends DownsampleStrategy {
        public AtLeast() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r10, int r11, int r12, int r13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r10, int r11, int r12, int r13) {
            int r14 = Math.min(r11 / r13, r10 / r12);
            if (r14 != 0) goto L6;
            return 1.0f;
        L6:
            return 1.0f / Integer.highestOneBit(r14);
        }
    }

    public static class AtMost extends DownsampleStrategy {
        public AtMost() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r10, int r11, int r12, int r13) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r10, int r11, int r12, int r13) {
            int r14 = (int) Math.ceil(Math.max(r11 / r13, r10 / r12));
            int r15 = 1;
            int r16 = Math.max(1, Integer.highestOneBit(r14));
            if (r16 < r14) goto L7;
            r15 = 0;
        L7:
            return 1.0f / (r16 << r15);
        }
    }

    public static class CenterInside extends DownsampleStrategy {
        public CenterInside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r10, int r11, int r12, int r13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r10, int r11, int r12, int r13) {
            return Math.min(1.0f, DownsampleStrategy.FIT_CENTER.getScaleFactor(r10, r11, r12, r13));
        }
    }

    public static class CenterOutside extends DownsampleStrategy {
        public CenterOutside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r10, int r11, int r12, int r13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r10, int r11, int r12, int r13) {
            return Math.max(r12 / r10, r13 / r11);
        }
    }

    public static class FitCenter extends DownsampleStrategy {
        public FitCenter() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r10, int r11, int r12, int r13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r10, int r11, int r12, int r13) {
            return Math.min(r12 / r10, r13 / r11);
        }
    }

    public static class None extends DownsampleStrategy {
        public None() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r10, int r11, int r12, int r13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r10, int r11, int r12, int r13) {
            return 1.0f;
        }
    }

    public static final enum SampleSizeRounding extends Enum<SampleSizeRounding> {
        private static final /* synthetic */ SampleSizeRounding[] $VALUES = null;
        public static final SampleSizeRounding MEMORY = null;
        public static final SampleSizeRounding QUALITY = null;

        static {
            SampleSizeRounding r10 = new SampleSizeRounding("MEMORY", 0);
            MEMORY = r10;
            SampleSizeRounding r11 = new SampleSizeRounding("QUALITY", 1);
            QUALITY = r11;
            $VALUES = new SampleSizeRounding[]{r10, r11};
        }

        private SampleSizeRounding(String r10, int r11) {
            super(r10, r11);
        }

        public static SampleSizeRounding valueOf(String r10) {
            return (SampleSizeRounding) Enum.valueOf(SampleSizeRounding.class, r10);
        }

        public static SampleSizeRounding[] values() {
            return (SampleSizeRounding[]) $VALUES.clone();
        }
    }

    static {
        FIT_CENTER = new FitCenter();
        CenterOutside r10 = new CenterOutside();
        CENTER_OUTSIDE = r10;
        AT_LEAST = new AtLeast();
        AT_MOST = new AtMost();
        CENTER_INSIDE = new CenterInside();
        NONE = new None();
        DEFAULT = r10;
        OPTION = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", r10);
    }

    public DownsampleStrategy() {
    }

    public abstract SampleSizeRounding getSampleSizeRounding(int r10, int r11, int r12, int r13);

    public abstract float getScaleFactor(int r10, int r11, int r12, int r13);
}
