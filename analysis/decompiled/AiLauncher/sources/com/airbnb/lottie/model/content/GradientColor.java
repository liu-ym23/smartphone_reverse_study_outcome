package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GradientColor {
    private final int[] colors;
    private final float[] positions;

    public GradientColor(float[] fArr, int[] iArr) {
        this.positions = fArr;
        this.colors = iArr;
    }

    private void copyFrom(GradientColor gradientColor) {
        int i10 = 0;
        while (true) {
            int[] iArr = gradientColor.colors;
            if (i10 >= iArr.length) {
                return;
            }
            this.positions[i10] = gradientColor.positions[i10];
            this.colors[i10] = iArr[i10];
            i10++;
        }
    }

    private int getColorForPosition(float f10) {
        int iBinarySearch = Arrays.binarySearch(this.positions, f10);
        if (iBinarySearch >= 0) {
            return this.colors[iBinarySearch];
        }
        int i10 = -(iBinarySearch + 1);
        if (i10 == 0) {
            return this.colors[0];
        }
        int[] iArr = this.colors;
        if (i10 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.positions;
        int i11 = i10 - 1;
        float f11 = fArr[i11];
        return GammaEvaluator.evaluate((f10 - f11) / (fArr[i10] - f11), iArr[i11], iArr[i10]);
    }

    public GradientColor copyWithPositions(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            iArr[i10] = getColorForPosition(fArr[i10]);
        }
        return new GradientColor(fArr, iArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GradientColor gradientColor = (GradientColor) obj;
            if (Arrays.equals(this.positions, gradientColor.positions) && Arrays.equals(this.colors, gradientColor.colors)) {
                return true;
            }
        }
        return false;
    }

    public int[] getColors() {
        return this.colors;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int getSize() {
        return this.colors.length;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.positions) * 31) + Arrays.hashCode(this.colors);
    }

    public void lerp(GradientColor gradientColor, GradientColor gradientColor2, float f10) {
        int[] iArr;
        if (gradientColor.equals(gradientColor2)) {
            copyFrom(gradientColor);
            return;
        }
        if (f10 <= 0.0f) {
            copyFrom(gradientColor);
            return;
        }
        if (f10 >= 1.0f) {
            copyFrom(gradientColor2);
            return;
        }
        if (gradientColor.colors.length != gradientColor2.colors.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.colors.length + " vs " + gradientColor2.colors.length + ")");
        }
        int i10 = 0;
        while (true) {
            iArr = gradientColor.colors;
            if (i10 >= iArr.length) {
                break;
            }
            this.positions[i10] = MiscUtils.lerp(gradientColor.positions[i10], gradientColor2.positions[i10], f10);
            this.colors[i10] = GammaEvaluator.evaluate(f10, gradientColor.colors[i10], gradientColor2.colors[i10]);
            i10++;
        }
        int length = iArr.length;
        while (true) {
            float[] fArr = this.positions;
            if (length >= fArr.length) {
                return;
            }
            int[] iArr2 = gradientColor.colors;
            fArr[length] = fArr[iArr2.length - 1];
            int[] iArr3 = this.colors;
            iArr3[length] = iArr3[iArr2.length - 1];
            length++;
        }
    }
}
