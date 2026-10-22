package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes2.dex */
public final class Cam16 {
    static final double[][] CAM16RGB_TO_XYZ = null;
    static final double[][] XYZ_TO_CAM16RGB = null;
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;
    private final double j;
    private final double jstar;
    private final double m;
    private final double q;
    private final double s;
    private final double[] tempArray;

    static {
        XYZ_TO_CAM16RGB = new double[][]{new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
        CAM16RGB_TO_XYZ = new double[][]{new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};
    }

    double distance(Cam16 r7) {
        double r0 = getJstar() - r7.getJstar();
        double r2 = getAstar() - r7.getAstar();
        double r4 = getBstar() - r7.getBstar();
        return Math.pow(Math.sqrt(((r0 * r0) + (r2 * r2)) + (r4 * r4)), 0.63d) * 1.41d;
    }

    public double getHue() {
        return this.hue;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getJ() {
        return this.j;
    }

    public double getQ() {
        return this.q;
    }

    public double getM() {
        return this.m;
    }

    public double getS() {
        return this.s;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    private Cam16(double r4, double r6, double r8, double r10, double r12, double r14, double r16, double r18, double r20) {
        this.tempArray = new double[]{0.0d, 0.0d, 0.0d};
        this.hue = r4;
        this.chroma = r6;
        this.j = r8;
        this.q = r10;
        this.m = r12;
        this.s = r14;
        this.jstar = r16;
        this.astar = r18;
        this.bstar = r20;
    }

    public static Cam16 fromInt(int r1) {
        return fromIntInViewingConditions(r1, ViewingConditions.DEFAULT);
    }

    static Cam16 fromIntInViewingConditions(int r18, ViewingConditions r19) {
        double r3 = ColorUtils.linearized((16711680 & r18) >> 16);
        double r1 = ColorUtils.linearized((65280 & r18) >> 8);
        double r5 = ColorUtils.linearized(r18 & 255);
        return fromXyzInViewingConditions(((0.41233895d * r3) + (0.35762064d * r1)) + (0.18051042d * r5), ((0.2126d * r3) + (0.7152d * r1)) + (0.0722d * r5), ((r3 * 0.01932141d) + (r1 * 0.11916382d)) + (r5 * 0.95034478d), r19);
    }

    static Cam16 fromXyzInViewingConditions(double r37, double r39, double r41, ViewingConditions r43) {
        double[][] r0 = XYZ_TO_CAM16RGB;
        double[] r2 = r0[0];
        double r3 = ((r2[0] * r37) + (r2[1] * r39)) + (r2[2] * r41);
        double[] r4 = r0[1];
        double r7 = ((r4[0] * r37) + (r4[1] * r39)) + (r4[2] * r41);
        double[] r1 = r0[2];
        double r9 = ((r1[0] * r37) + (r1[1] * r39)) + (r1[2] * r41);
        double r5 = r43.getRgbD()[0] * r3;
        double r6 = r43.getRgbD()[1] * r7;
        double r8 = r43.getRgbD()[2] * r9;
        double r10 = Math.pow((r43.getFl() * Math.abs(r5)) / 100.0d, 0.42d);
        double r12 = Math.pow((r43.getFl() * Math.abs(r6)) / 100.0d, 0.42d);
        double r11 = Math.pow((r43.getFl() * Math.abs(r8)) / 100.0d, 0.42d);
        double r13 = ((Math.signum(r5) * 400.0d) * r10) / (r10 + 27.13d);
        double r14 = ((Math.signum(r6) * 400.0d) * r12) / (r12 + 27.13d);
        double r15 = ((Math.signum(r8) * 400.0d) * r11) / (r11 + 27.13d);
        double r16 = (((r13 * 11.0d) + ((-12.0d) * r14)) + r15) / 11.0d;
        double r17 = ((r13 + r14) - (r15 * 2.0d)) / 9.0d;
        double r18 = r14 * 20.0d;
        double r19 = (((r13 * 20.0d) + r18) + (21.0d * r15)) / 20.0d;
        double r20 = (((r13 * 40.0d) + r18) + r15) / 20.0d;
        double r21 = Math.toDegrees(Math.atan2(r17, r16));
        if (r21 >= 0.0d) goto L7;
        r21 = r21 + 360.0d;
    L5:
        double r110 = r21;
        double r22 = Math.toRadians(r110);
        double r23 = Math.pow((r20 * r43.getNbb()) / r43.getAw(), r43.getC() * r43.getZ()) * 100.0d;
        double r24 = r23 / 100.0d;
        double r25 = (((4.0d / r43.getC()) * Math.sqrt(r24)) * (r43.getAw() + 4.0d)) * r43.getFlRoot();
        if (r110 >= 20.14d) goto L12;
        double r111 = r110 + 360.0d;
    L13:
        double r26 = ((((((Math.cos(Math.toRadians(r111) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * r43.getNc()) * r43.getNcb()) * Math.hypot(r16, r17)) / (r19 + 0.305d);
        double r27 = Math.pow(1.64d - Math.pow(0.29d, r43.getN()), 0.73d) * Math.pow(r26, 0.9d);
        double r28 = Math.sqrt(r24) * r27;
        double r29 = r28 * r43.getFlRoot();
        double r30 = Math.log1p(r29 * 0.0228d) * 43.859649122807014d;
        return new Cam16(r110, r28, r23, r25, r29, Math.sqrt((r27 * r43.getC()) / (r43.getAw() + 4.0d)) * 50.0d, (1.7000000000000002d * r23) / ((0.007d * r23) + 1.0d), r30 * Math.cos(r22), r30 * Math.sin(r22));
    L12:
        r111 = r110;
        goto L13
    L7:
        if (r21 < 360.0d) goto L5;
        r21 = r21 - 360.0d;
        goto L5
    }

    static Cam16 fromJch(double r7, double r9, double r11) {
        return fromJchInViewingConditions(r7, r9, r11, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double r23, double r25, double r27, ViewingConditions r29) {
        double r13 = r23 / 100.0d;
        double r7 = (((4.0d / r29.getC()) * Math.sqrt(r13)) * (r29.getAw() + 4.0d)) * r29.getFlRoot();
        double r15 = r25 * r29.getFlRoot();
        double r11 = Math.sqrt(((r25 / Math.sqrt(r13)) * r29.getC()) / (r29.getAw() + 4.0d)) * 50.0d;
        double r17 = Math.toRadians(r27);
        double r14 = (1.7000000000000002d * r23) / ((0.007d * r23) + 1.0d);
        double r19 = 43.859649122807014d * Math.log1p(r15 * 0.0228d);
        return new Cam16(r27, r25, r23, r7, r15, r11, r14, Math.cos(r17) * r19, Math.sin(r17) * r19);
    }

    public static Cam16 fromUcs(double r7, double r9, double r11) {
        return fromUcsInViewingConditions(r7, r9, r11, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double r11, double r13, double r15, ViewingConditions r17) {
        double r6 = (Math.expm1(Math.hypot(r13, r15) * 0.0228d) / 0.0228d) / r17.getFlRoot();
        double r0 = Math.atan2(r15, r13) * 57.29577951308232d;
        if (r0 >= 0.0d) goto L5;
        r0 = r0 + 360.0d;
    L5:
        double r8 = r0;
        return fromJchInViewingConditions(r11 / (1.0d - ((r11 - 100.0d) * 0.007d)), r6, r8, r17);
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    int viewed(ViewingConditions r7) {
        double[] r6 = xyzInViewingConditions(r7, this.tempArray);
        return ColorUtils.argbFromXyz(r6[0], r6[1], r6[2]);
    }

    double[] xyzInViewingConditions(ViewingConditions r21, double[] r22) {
        if (getChroma() != 0.0d) goto L5;
    L8:
        double r0 = 0.0d;
    L9:
        double r1 = Math.pow(r0 / Math.pow(1.64d - Math.pow(0.29d, r21.getN()), 0.73d), 1.1111111111111112d);
        double r6 = Math.toRadians(getHue());
        double r8 = (Math.cos(2.0d + r6) + 3.8d) * 0.25d;
        double r10 = r21.getAw() * Math.pow(getJ() / 100.0d, (1.0d / r21.getC()) / r21.getZ());
        double r9 = ((r8 * 3846.153846153846d) * r21.getNc()) * r21.getNcb();
        double r11 = r10 / r21.getNbb();
        double r12 = Math.sin(r6);
        double r7 = Math.cos(r6);
        double r14 = (((0.305d + r11) * 23.0d) * r1) / (((r9 * 23.0d) + ((11.0d * r1) * r7)) + ((r1 * 108.0d) * r12));
        double r13 = r7 * r14;
        double r15 = r14 * r12;
        double r16 = r11 * 460.0d;
        double r2 = (((451.0d * r13) + r16) + (288.0d * r15)) / 1403.0d;
        double r17 = ((r16 - (891.0d * r13)) - (261.0d * r15)) / 1403.0d;
        double r18 = ((r16 - (r13 * 220.0d)) - (r15 * 6300.0d)) / 1403.0d;
        double r3 = (Math.signum(r2) * (100.0d / r21.getFl())) * Math.pow(Math.max(0.0d, (Math.abs(r2) * 27.13d) / (400.0d - Math.abs(r2))), 2.380952380952381d);
        double r19 = (Math.signum(r17) * (100.0d / r21.getFl())) * Math.pow(Math.max(0.0d, (Math.abs(r17) * 27.13d) / (400.0d - Math.abs(r17))), 2.380952380952381d);
        double r20 = (Math.signum(r18) * (100.0d / r21.getFl())) * Math.pow(Math.max(0.0d, (Math.abs(r18) * 27.13d) / (400.0d - Math.abs(r18))), 2.380952380952381d);
        double r4 = r3 / r21.getRgbD()[0];
        double r110 = r19 / r21.getRgbD()[1];
        double r23 = r20 / r21.getRgbD()[2];
        double[][] r5 = CAM16RGB_TO_XYZ;
        double[] r24 = r5[0];
        double r25 = ((r24[0] * r4) + (r24[1] * r110)) + (r24[2] * r23);
        double[] r26 = r5[1];
        double r111 = ((r26[0] * r4) + (r26[1] * r110)) + (r26[2] * r23);
        double[] r27 = r5[2];
        double r28 = ((r4 * r27[0]) + (r110 * r27[1])) + (r23 * r27[2]);
        if (r22 == null) goto L14;
        r22[0] = r25;
        r22[1] = r111;
        r22[2] = r28;
        return r22;
    L14:
        return new double[]{r25, r111, r28};
    L5:
        if (getJ() == 0.0d) goto L8;
        r0 = getChroma() / Math.sqrt(getJ() / 100.0d);
        goto L9
    }
}
