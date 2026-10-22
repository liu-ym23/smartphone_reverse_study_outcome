package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

/* JADX INFO: loaded from: classes.dex */
public class Mask {
    private final boolean inverted;
    private final MaskMode maskMode;
    private final AnimatableShapeValue maskPath;
    private final AnimatableIntegerValue opacity;

    public static final enum MaskMode extends Enum<MaskMode> {
        private static final /* synthetic */ MaskMode[] $VALUES = null;
        public static final MaskMode MASK_MODE_ADD = null;
        public static final MaskMode MASK_MODE_INTERSECT = null;
        public static final MaskMode MASK_MODE_NONE = null;
        public static final MaskMode MASK_MODE_SUBTRACT = null;

        private static /* synthetic */ MaskMode[] $values() {
            return new MaskMode[]{MASK_MODE_ADD, MASK_MODE_SUBTRACT, MASK_MODE_INTERSECT, MASK_MODE_NONE};
        }

        private MaskMode(String r1, int r2) {
            super(r1, r2);
        }

        public static MaskMode valueOf(String r1) {
            return (MaskMode) Enum.valueOf(MaskMode.class, r1);
        }

        public static MaskMode[] values() {
            return (MaskMode[]) $VALUES.clone();
        }

        static {
            MASK_MODE_ADD = new MaskMode("MASK_MODE_ADD", 0);
            MASK_MODE_SUBTRACT = new MaskMode("MASK_MODE_SUBTRACT", 1);
            MASK_MODE_INTERSECT = new MaskMode("MASK_MODE_INTERSECT", 2);
            MASK_MODE_NONE = new MaskMode("MASK_MODE_NONE", 3);
            $VALUES = $values();
        }
    }

    public Mask(MaskMode r1, AnimatableShapeValue r2, AnimatableIntegerValue r3, boolean r4) {
        this.maskMode = r1;
        this.maskPath = r2;
        this.opacity = r3;
        this.inverted = r4;
    }

    public MaskMode getMaskMode() {
        return this.maskMode;
    }

    public AnimatableShapeValue getMaskPath() {
        return this.maskPath;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public boolean isInverted() {
        return this.inverted;
    }
}
