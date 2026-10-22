package com.google.android.material.color;

import android.graphics.Bitmap;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.android.material.color.utilities.Score;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicColorsOptions {
    private static final DynamicColors.Precondition ALWAYS_ALLOW = null;
    private static final DynamicColors.OnAppliedCallback NO_OP_CALLBACK = null;
    private Integer contentBasedSeedColor;
    private final DynamicColors.OnAppliedCallback onAppliedCallback;
    private final DynamicColors.Precondition precondition;
    private final int themeOverlay;

    public static class Builder {
        private Bitmap contentBasedSource;
        private DynamicColors.OnAppliedCallback onAppliedCallback;
        private DynamicColors.Precondition precondition;
        private int themeOverlay;

        public Builder() {
            this.precondition = DynamicColorsOptions.access$400();
            this.onAppliedCallback = DynamicColorsOptions.access$500();
        }

        static /* synthetic */ int access$000(Builder r0) {
            return r0.themeOverlay;
        }

        static /* synthetic */ DynamicColors.Precondition access$100(Builder r0) {
            return r0.precondition;
        }

        static /* synthetic */ DynamicColors.OnAppliedCallback access$200(Builder r0) {
            return r0.onAppliedCallback;
        }

        static /* synthetic */ Bitmap access$300(Builder r0) {
            return r0.contentBasedSource;
        }

        public Builder setThemeOverlay(int r1) {
            this.themeOverlay = r1;
            return this;
        }

        public Builder setPrecondition(DynamicColors.Precondition r1) {
            this.precondition = r1;
            return this;
        }

        public Builder setOnAppliedCallback(DynamicColors.OnAppliedCallback r1) {
            this.onAppliedCallback = r1;
            return this;
        }

        public Builder setContentBasedSource(Bitmap r1) {
            this.contentBasedSource = r1;
            return this;
        }

        public DynamicColorsOptions build() {
            return new DynamicColorsOptions(this, null);
        }
    }

    /* synthetic */ DynamicColorsOptions(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ DynamicColors.Precondition access$400() {
        return ALWAYS_ALLOW;
    }

    static /* synthetic */ DynamicColors.OnAppliedCallback access$500() {
        return NO_OP_CALLBACK;
    }

    static {
        ALWAYS_ALLOW = new AnonymousClass1();
        NO_OP_CALLBACK = new AnonymousClass2();
    }

    private DynamicColorsOptions(Builder r2) {
        this.themeOverlay = Builder.access$000(r2);
        this.precondition = Builder.access$100(r2);
        this.onAppliedCallback = Builder.access$200(r2);
        if (Builder.access$300(r2) == null) goto L6;
        this.contentBasedSeedColor = Integer.valueOf(extractSeedColorFromImage(Builder.access$300(r2)));
        return;
    }

    public int getThemeOverlay() {
        return this.themeOverlay;
    }

    public DynamicColors.Precondition getPrecondition() {
        return this.precondition;
    }

    public DynamicColors.OnAppliedCallback getOnAppliedCallback() {
        return this.onAppliedCallback;
    }

    public Integer getContentBasedSeedColor() {
        return this.contentBasedSeedColor;
    }

    private static int extractSeedColorFromImage(Bitmap r9) {
        int r6 = r9.getWidth();
        int r7 = r9.getHeight();
        int[] r8 = new int[r6 * r7];
        r9.getPixels(r8, 0, r6, 0, 0, r6, r7);
        return Score.score(QuantizerCelebi.quantize(r8, 128)).get(0).intValue();
    }
}
