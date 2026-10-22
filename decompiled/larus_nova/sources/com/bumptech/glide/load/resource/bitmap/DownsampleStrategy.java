package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public abstract class DownsampleStrategy {
    public static final DownsampleStrategy AT_LEAST = null;
    public static final DownsampleStrategy AT_MOST = null;
    public static final DownsampleStrategy CENTER_INSIDE = null;
    public static final DownsampleStrategy CENTER_OUTSIDE = null;
    public static final DownsampleStrategy DEFAULT = null;
    public static final DownsampleStrategy FIT_CENTER = null;
    static final boolean IS_BITMAP_FACTORY_SCALING_SUPPORTED = false;
    public static final DownsampleStrategy NONE = null;
    public static final Option<DownsampleStrategy> OPTION = null;

    public static class AtLeast extends DownsampleStrategy {
        public AtLeast() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r100, int r101, int r102, int r103) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r100, int r101, int r102, int r103) {
            int r104 = Math.min(r101 / r103, r100 / r102);
            if (r104 != 0) goto L6;
            return 1.0f;
        L6:
            return 1.0f / Integer.highestOneBit(r104);
        }
    }

    public static class AtMost extends DownsampleStrategy {
        public AtMost() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r100, int r101, int r102, int r103) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r100, int r101, int r102, int r103) {
            int r104 = (int) Math.ceil(Math.max(r101 / r103, r100 / r102));
            int r105 = 1;
            int r106 = Math.max(1, Integer.highestOneBit(r104));
            if (r106 < r104) goto L7;
            r105 = 0;
        L7:
            return 1.0f / (r106 << r105);
        }
    }

    public static class CenterInside extends DownsampleStrategy {
        public CenterInside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r100, int r101, int r102, int r103) {
            if (getScaleFactor(r100, r101, r102, r103) != 1.0f) goto L6;
            return SampleSizeRounding.QUALITY;
        L6:
            return DownsampleStrategy.FIT_CENTER.getSampleSizeRounding(r100, r101, r102, r103);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r100, int r101, int r102, int r103) {
            return Math.min(1.0f, DownsampleStrategy.FIT_CENTER.getScaleFactor(r100, r101, r102, r103));
        }
    }

    public static class CenterOutside extends DownsampleStrategy {
        public CenterOutside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r100, int r101, int r102, int r103) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r100, int r101, int r102, int r103) {
            return Math.max(r102 / r100, r103 / r101);
        }
    }

    public static class FitCenter extends DownsampleStrategy {
        public FitCenter() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r100, int r101, int r102, int r103) {
            if (DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED == false) goto L7;
            return SampleSizeRounding.QUALITY;
        L7:
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r100, int r101, int r102, int r103) {
            if (DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED == true) goto L5;
            int r104 = Math.max(r101 / r103, r100 / r102);
            if (r104 != 0) goto L10;
            return 1.0f;
        L10:
            return 1.0f / Integer.highestOneBit(r104);
        L5:
            return Math.min(r102 / r100, r103 / r101);
        }
    }

    public static class None extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r100, int r101, int r102, int r103) {
            return 1.0f;
        }

        public None() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r100, int r101, int r102, int r103) {
            return SampleSizeRounding.QUALITY;
        }
    }

    public static final enum SampleSizeRounding extends Enum<SampleSizeRounding> {
        private static final /* synthetic */ SampleSizeRounding[] $VALUES = null;
        public static final SampleSizeRounding MEMORY = null;
        public static final SampleSizeRounding QUALITY = null;

        static {
            SampleSizeRounding r100 = new SampleSizeRounding("MEMORY", 0);
            MEMORY = r100;
            SampleSizeRounding r101 = new SampleSizeRounding("QUALITY", 1);
            QUALITY = r101;
            $VALUES = new SampleSizeRounding[]{r100, r101};
        }

        public static SampleSizeRounding[] values() {
            return (SampleSizeRounding[]) $VALUES.clone();
        }

        public static SampleSizeRounding valueOf(String r100) {
            return (SampleSizeRounding) a.a(SampleSizeRounding.class, r100);
        }

        private SampleSizeRounding(String r100, int r101) {
            super(r100, r101);
        }
    }

    public DownsampleStrategy() {
    }

    public abstract SampleSizeRounding getSampleSizeRounding(int r100, int r101, int r102, int r103);

    public abstract float getScaleFactor(int r100, int r101, int r102, int r103);

    static {
        AT_LEAST = new AtLeast();
        AT_MOST = new AtMost();
        FIT_CENTER = new FitCenter();
        CENTER_INSIDE = new CenterInside();
        CenterOutside r100 = new CenterOutside();
        CENTER_OUTSIDE = r100;
        NONE = new None();
        DEFAULT = r100;
        OPTION = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", r100);
        IS_BITMAP_FACTORY_SCALING_SUPPORTED = true;
    }
}
