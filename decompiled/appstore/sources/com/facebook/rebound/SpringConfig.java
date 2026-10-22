package com.facebook.rebound;

/* JADX INFO: loaded from: classes2.dex */
public class SpringConfig {
    public static SpringConfig defaultConfig;
    public double friction;
    public double tension;

    static {
        defaultConfig = fromOrigamiTensionAndFriction(40.0d, 7.0d);
    }

    public SpringConfig(double r10, double r11) {
        this.tension = r10;
        this.friction = r11;
    }

    public static SpringConfig fromBouncinessAndSpeed(double r10, double r11) {
        BouncyConversion r12 = new BouncyConversion(r11, r10);
        return fromOrigamiTensionAndFriction(r12.getBouncyTension(), r12.getBouncyFriction());
    }

    public static SpringConfig fromOrigamiTensionAndFriction(double r10, double r11) {
        return new SpringConfig(OrigamiValueConverter.tensionFromOrigamiValue(r10), OrigamiValueConverter.frictionFromOrigamiValue(r11));
    }
}
