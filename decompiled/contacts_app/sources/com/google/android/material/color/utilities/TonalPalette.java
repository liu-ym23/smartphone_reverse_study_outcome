package com.google.android.material.color.utilities;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class TonalPalette {
    Map<Integer, Integer> cache;
    double chroma;
    double hue;

    public static final TonalPalette fromInt(int r0) {
        return fromHct(Hct.fromInt(r0));
    }

    public static final TonalPalette fromHct(Hct r4) {
        return fromHueAndChroma(r4.getHue(), r4.getChroma());
    }

    public static final TonalPalette fromHueAndChroma(double r1, double r3) {
        return new TonalPalette(r1, r3);
    }

    private TonalPalette(double r2, double r4) {
        this.cache = new HashMap();
        this.hue = r2;
        this.chroma = r4;
    }

    public int tone(int r8) {
        Integer r0 = this.cache.get(Integer.valueOf(r8));
        if (r0 != null) goto L6;
        r0 = Integer.valueOf(Hct.from(this.hue, this.chroma, r8).toInt());
        this.cache.put(Integer.valueOf(r8), r0);
    L6:
        return r0.intValue();
    }

    public Hct getHct(double r7) {
        return Hct.from(this.hue, this.chroma, r7);
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }
}
