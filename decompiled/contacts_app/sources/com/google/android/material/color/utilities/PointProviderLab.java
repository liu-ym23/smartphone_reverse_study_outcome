package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes2.dex */
public final class PointProviderLab implements PointProvider {
    public PointProviderLab() {
    }

    @Override // com.google.android.material.color.utilities.PointProvider
    public double[] fromInt(int r4) {
        double[] r3 = ColorUtils.labFromArgb(r4);
        return new double[]{r3[0], r3[1], r3[2]};
    }

    @Override // com.google.android.material.color.utilities.PointProvider
    public int toInt(double[] r7) {
        return ColorUtils.argbFromLab(r7[0], r7[1], r7[2]);
    }

    @Override // com.google.android.material.color.utilities.PointProvider
    public double distance(double[] r7, double[] r8) {
        double r0 = r7[0] - r8[0];
        double r2 = r7[1] - r8[1];
        double r4 = r7[2] - r8[2];
        return ((r0 * r0) + (r2 * r2)) + (r4 * r4);
    }
}
