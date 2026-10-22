package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class TemperatureCache {
    private final Hct input;
    private Hct precomputedComplement;
    private List<Hct> precomputedHctsByHue;
    private List<Hct> precomputedHctsByTemp;
    private Map<Hct, Double> precomputedTempsByHct;

    public static /* synthetic */ int $r8$lambda$e6YdIPEGdkrEJi1glUUT_iAtqcE(Double r0, Double r1) {
        return r0.compareTo(r1);
    }

    private static boolean isBetween(double r3, double r5, double r7) {
        if (r5 >= r7) goto L11;
        if (r5 <= r3) goto L7;
        return false;
    L7:
        if (r3 <= r7) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (r5 <= r3) goto L15;
        if (r3 <= r7) goto L15;
        return false;
    L15:
        return true;
    }

    private TemperatureCache() {
        throw new UnsupportedOperationException();
    }

    public TemperatureCache(Hct r1) {
        this.input = r1;
    }

    public Hct getComplement() {
        Hct r1 = this.precomputedComplement;
        if (r1 == null) goto L5;
        return r1;
    L5:
        double r8 = getColdest().getHue();
        double r10 = getTempsByHct().get(getColdest()).doubleValue();
        double r12 = getWarmest().getHue();
        double r14 = getTempsByHct().get(getWarmest()).doubleValue() - r10;
        boolean r2 = isBetween(this.input.getHue(), r8, r12);
        if (r2 == false) goto L8;
        double r16 = r12;
    L9:
        if (r2 == true) goto L12;
        r8 = r12;
    L12:
        Hct r3 = getHctsByHue().get((int) Math.round(this.input.getHue()));
        double r18 = 1.0d - getRelativeTemperature(this.input);
        double r20 = 1000.0d;
        double r22 = 0.0d;
    L14:
        if (r22 > 360.0d) goto L22;
        double r24 = MathUtils.sanitizeDegreesDouble(r16 + (1.0d * r22));
        if (isBetween(r24, r16, r8) == false) goto L21;
        Hct r4 = getHctsByHue().get((int) Math.round(r24));
        double r5 = Math.abs(r18 - ((getTempsByHct().get(r4).doubleValue() - r10) / r14));
        if (r5 >= r20) goto L21;
        r3 = r4;
        r20 = r5;
    L21:
        r22 = r22 + 1.0d;
        goto L14
    L22:
        this.precomputedComplement = r3;
        return r3;
    L8:
        r16 = r8;
        goto L9
    }

    public List<Hct> getAnalogousColors() {
        return getAnalogousColors(5, 12);
    }

    public List<Hct> getAnalogousColors(int r19, int r20) {
        int r3 = (int) Math.round(this.input.getHue());
        Hct r4 = getHctsByHue().get(r3);
        double r5 = getRelativeTemperature(r4);
        ArrayList r7 = new ArrayList();
        r7.add(r4);
        double r8 = 0.0d;
        double r12 = 0.0d;
        int r11 = 0;
    L4:
        if (r11 >= 360) goto L6;
        double r14 = getRelativeTemperature(getHctsByHue().get(MathUtils.sanitizeDegreesInt(r3 + r11)));
        r12 = r12 + Math.abs(r14 - r5);
        r11 = r11 + 1;
        r5 = r14;
        goto L4
    L6:
        double r13 = r12 / ((double) r20);
        double r6 = getRelativeTemperature(r4);
        int r15 = 1;
    L8:
        if (r7.size() >= r20) goto L28;
        Hct r9 = getHctsByHue().get(MathUtils.sanitizeDegreesInt(r3 + r15));
        double r16 = getRelativeTemperature(r9);
        r8 = r8 + Math.abs(r16 - r6);
        if (r8 < (((double) r7.size()) * r13)) goto L12;
        boolean r10 = true;
    L13:
        int r17 = 1;
    L14:
        if (r10 == false) goto L22;
        if (r7.size() >= r20) goto L22;
        r7.add(r9);
        if (r8 < (((double) (r7.size() + r17)) * r13)) goto L20;
        r10 = true;
    L21:
        r17 = r17 + 1;
        goto L14
    L20:
        r10 = false;
    L22:
        r15 = r15 + 1;
        if (r15 > 360) goto L25;
        r6 = r16;
    L25:
        if (r7.size() >= r20) goto L28;
        r7.add(r9);
        goto L25
    L12:
        r10 = false;
    L28:
        ArrayList r2 = new ArrayList();
        r2.add(this.input);
        int r0 = (int) Math.floor((((double) r19) - 1.0d) / 2.0d);
        int r18 = 1;
    L30:
        if (r18 >= (r0 + 1)) goto L38;
        int r21 = 0 - r18;
    L32:
        if (r21 >= 0) goto L35;
        r21 = r21 + r7.size();
        goto L32
    L35:
        if (r21 < r7.size()) goto L37;
        r21 = r21 % r7.size();
    L37:
        r2.add(0, (Hct) r7.get(r21));
        r18 = r18 + 1;
        goto L30
    L38:
        int r1 = (r19 - r0) - 1;
        int r22 = 1;
    L40:
        if (r22 >= (r1 + 1)) goto L48;
        int r23 = r22;
    L42:
        if (r23 >= 0) goto L45;
        r23 = r23 + r7.size();
        goto L42
    L45:
        if (r23 < r7.size()) goto L47;
        r23 = r23 % r7.size();
    L47:
        r2.add((Hct) r7.get(r23));
        r22 = r22 + 1;
        goto L40
    L48:
        return r2;
    }

    public double getRelativeTemperature(Hct r5) {
        double r0 = getTempsByHct().get(getWarmest()).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        double r2 = getTempsByHct().get(r5).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        if (r0 != 0.0d) goto L7;
        return 0.5d;
    L7:
        return r2 / r0;
    }

    public static double rawTemperature(Hct r7) {
        double[] r8 = ColorUtils.labFromArgb(r7.toInt());
        return ((Math.pow(Math.hypot(r8[1], r8[2]), 1.07d) * 0.02d) * Math.cos(Math.toRadians(MathUtils.sanitizeDegreesDouble(MathUtils.sanitizeDegreesDouble(Math.toDegrees(Math.atan2(r8[2], r8[1]))) - 50.0d)))) - 0.5d;
    }

    private Hct getColdest() {
        return getHctsByTemp().get(0);
    }

    private List<Hct> getHctsByHue() {
        List<Hct> r0 = this.precomputedHctsByHue;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ArrayList r1 = new ArrayList();
        double r2 = 0.0d;
    L7:
        if (r2 > 360.0d) goto L9;
        double r5 = this.input.getChroma();
        double r7 = this.input.getTone();
        r1.add(Hct.from(r2, r5, r7));
        r2 = r2 + 1.0d;
        goto L7
    L9:
        List<Hct> r3 = Collections.unmodifiableList(r1);
        this.precomputedHctsByHue = r3;
        return r3;
    }

    private List<Hct> getHctsByTemp() {
        List<Hct> r0 = this.precomputedHctsByTemp;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ArrayList r1 = new ArrayList(getHctsByHue());
        r1.add(this.input);
        Collections.sort(r1, Comparator.comparing(new TemperatureCache$$ExternalSyntheticLambda0(this), new TemperatureCache$$ExternalSyntheticLambda1()));
        this.precomputedHctsByTemp = r1;
        return r1;
    }

    /* JADX INFO: renamed from: lambda$getHctsByTemp$0$com-google-android-material-color-utilities-TemperatureCache, reason: not valid java name */
    /* synthetic */ Double m247xb7a75f35(Hct r1) {
        return getTempsByHct().get(r1);
    }

    private Map<Hct, Double> getTempsByHct() {
        Map<Hct, Double> r0 = this.precomputedTempsByHct;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ArrayList r1 = new ArrayList(getHctsByHue());
        r1.add(this.input);
        HashMap r2 = new HashMap();
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        Hct r4 = (Hct) r3.next();
        r2.put(r4, Double.valueOf(rawTemperature(r4)));
        goto L7
    L9:
        this.precomputedTempsByHct = r2;
        return r2;
    }

    private Hct getWarmest() {
        return getHctsByTemp().get(getHctsByTemp().size() - 1);
    }
}
