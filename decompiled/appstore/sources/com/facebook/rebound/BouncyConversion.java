package com.facebook.rebound;

/* JADX INFO: loaded from: classes2.dex */
public class BouncyConversion {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final double mBounciness;
    private final double mBouncyFriction;
    private final double mBouncyTension;
    private final double mSpeed;

    static {
    }

    public BouncyConversion(double r15, double r17) {
        this.mSpeed = r15;
        this.mBounciness = r17;
        double r12 = project_normal(normalize(r17 / 1.7d, 0.0d, 20.0d), 0.0d, 0.8d);
        double r10 = project_normal(normalize(r15 / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.mBouncyTension = r10;
        this.mBouncyFriction = quadratic_out_interpolation(r12, b3_nobounce(r10), 0.01d);
    }

    private double b3_friction1(double r10) {
        return (((Math.pow(r10, 3.0d) * 7.0E-4d) - (Math.pow(r10, 2.0d) * 0.031d)) + (r10 * 0.64d)) + 1.28d;
    }

    private double b3_friction2(double r10) {
        return (((Math.pow(r10, 3.0d) * 4.4E-5d) - (Math.pow(r10, 2.0d) * 0.006d)) + (r10 * 0.36d)) + 2.0d;
    }

    private double b3_friction3(double r10) {
        return (((Math.pow(r10, 3.0d) * 4.5E-7d) - (Math.pow(r10, 2.0d) * 3.32E-4d)) + (r10 * 0.1078d)) + 5.84d;
    }

    private double b3_nobounce(double r10) {
        if (r10 > 18.0d) goto L6;
        return b3_friction1(r10);
    L6:
        if (r10 <= 18.0d) goto L11;
        if (r10 > 44.0d) goto L11;
        return b3_friction2(r10);
    L11:
        if (r10 > 44.0d) goto L17;
        return 0.0d;
    L17:
        return b3_friction3(r10);
    }

    private double linear_interpolation(double r10, double r11, double r12) {
        return (r12 * r10) + ((1.0d - r10) * r11);
    }

    private double normalize(double r10, double r11, double r12) {
        return (r10 - r11) / (r12 - r11);
    }

    private double project_normal(double r10, double r11, double r12) {
        return r11 + (r10 * (r12 - r11));
    }

    private double quadratic_out_interpolation(double r10, double r12, double r14) {
        return linear_interpolation((2.0d * r10) - (r10 * r10), r12, r14);
    }

    public double getBounciness() {
        return this.mBounciness;
    }

    public double getBouncyFriction() {
        return this.mBouncyFriction;
    }

    public double getBouncyTension() {
        return this.mBouncyTension;
    }

    public double getSpeed() {
        return this.mSpeed;
    }
}
