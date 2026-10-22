package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GradientColor {
    private final int[] colors;
    private final float[] positions;

    public GradientColor(float[] r1, int[] r2) {
        this.positions = r1;
        this.colors = r2;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int[] getColors() {
        return this.colors;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void lerp(GradientColor r5, GradientColor r6, float r7) {
        if (r5.colors.length != r6.colors.length) goto L10;
        int r0 = 0;
    L6:
        if (r0 >= r5.colors.length) goto L8;
        this.positions[r0] = MiscUtils.lerp(r5.positions[r0], r6.positions[r0], r7);
        this.colors[r0] = GammaEvaluator.evaluate(r7, r5.colors[r0], r6.colors[r0]);
        r0 = r0 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + r5.colors.length + " vs " + r6.colors.length + ")");
    }

    public GradientColor copyWithPositions(float[] r4) {
        int[] r0 = new int[r4.length];
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L7;
        r0[r1] = getColorForPosition(r4[r1]);
        r1 = r1 + 1;
        goto L4
    L7:
        return new GradientColor(r4, r0);
    }

    private int getColorForPosition(float r5) {
        int r0 = Arrays.binarySearch(this.positions, r5);
        if (r0 >= 0) goto L5;
        int r1 = -(r0 + 1);
        if (r1 == 0) goto L9;
        int[] r2 = this.colors;
        if (r1 == (r2.length - 1)) goto L13;
        float[] r4 = this.positions;
        int r3 = r1 - 1;
        float r6 = r4[r3];
        return GammaEvaluator.evaluate((r5 - r6) / (r4[r1] - r6), r2[r3], r2[r1]);
    L13:
        return r2[r2.length - 1];
    L9:
        return this.colors[0];
    L5:
        return this.colors[r0];
    }
}
