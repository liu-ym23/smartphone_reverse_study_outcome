package com.google.android.material.color;

import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class HarmonizedColorsOptions {
    private final int colorAttributeToHarmonizeWith;
    private final HarmonizedColorAttributes colorAttributes;
    private final int[] colorResourceIds;

    /* JADX INFO: renamed from: com.google.android.material.color.HarmonizedColorsOptions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int colorAttributeToHarmonizeWith;
        private HarmonizedColorAttributes colorAttributes;
        private int[] colorResourceIds;

        public Builder() {
            this.colorResourceIds = new int[0];
            this.colorAttributeToHarmonizeWith = R.attr.colorPrimary;
        }

        static /* synthetic */ int[] access$000(Builder r0) {
            return r0.colorResourceIds;
        }

        static /* synthetic */ HarmonizedColorAttributes access$100(Builder r0) {
            return r0.colorAttributes;
        }

        static /* synthetic */ int access$200(Builder r0) {
            return r0.colorAttributeToHarmonizeWith;
        }

        public Builder setColorResourceIds(int[] r1) {
            this.colorResourceIds = r1;
            return this;
        }

        public Builder setColorAttributes(HarmonizedColorAttributes r1) {
            this.colorAttributes = r1;
            return this;
        }

        public Builder setColorAttributeToHarmonizeWith(int r1) {
            this.colorAttributeToHarmonizeWith = r1;
            return this;
        }

        public HarmonizedColorsOptions build() {
            return new HarmonizedColorsOptions(this, null);
        }
    }

    /* synthetic */ HarmonizedColorsOptions(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static HarmonizedColorsOptions createMaterialDefaults() {
        return new Builder().setColorAttributes(HarmonizedColorAttributes.createMaterialDefaults()).build();
    }

    private HarmonizedColorsOptions(Builder r2) {
        this.colorResourceIds = Builder.access$000(r2);
        this.colorAttributes = Builder.access$100(r2);
        this.colorAttributeToHarmonizeWith = Builder.access$200(r2);
    }

    public int[] getColorResourceIds() {
        return this.colorResourceIds;
    }

    public HarmonizedColorAttributes getColorAttributes() {
        return this.colorAttributes;
    }

    public int getColorAttributeToHarmonizeWith() {
        return this.colorAttributeToHarmonizeWith;
    }

    int getThemeOverlayResourceId(int r2) {
        HarmonizedColorAttributes r0 = this.colorAttributes;
        if (r0 != null) goto L5;
        return r2;
    L5:
        if (r0.getThemeOverlay() != 0) goto L7;
        return r2;
    L7:
        return this.colorAttributes.getThemeOverlay();
    }
}
