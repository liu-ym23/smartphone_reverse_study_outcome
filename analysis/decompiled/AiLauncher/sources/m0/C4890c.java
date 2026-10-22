package m0;

import java.util.Arrays;

/* renamed from: m0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4890c {

    /* renamed from: b, reason: collision with root package name */
    public static C4890c f37051b = new C4890c();

    /* renamed from: c, reason: collision with root package name */
    public static String[] f37052c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a, reason: collision with root package name */
    public String f37053a = com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s;

    /* renamed from: m0.c$a */
    public static class a extends C4890c {

        /* renamed from: h, reason: collision with root package name */
        public static double f37054h = 0.01d;

        /* renamed from: i, reason: collision with root package name */
        public static double f37055i = 1.0E-4d;

        /* renamed from: d, reason: collision with root package name */
        public double f37056d;

        /* renamed from: e, reason: collision with root package name */
        public double f37057e;

        /* renamed from: f, reason: collision with root package name */
        public double f37058f;

        /* renamed from: g, reason: collision with root package name */
        public double f37059g;

        public a(String str) {
            this.f37053a = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f37056d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i10 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i10);
            this.f37057e = Double.parseDouble(str.substring(i10, iIndexOf3).trim());
            int i11 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i11);
            this.f37058f = Double.parseDouble(str.substring(i11, iIndexOf4).trim());
            int i12 = iIndexOf4 + 1;
            this.f37059g = Double.parseDouble(str.substring(i12, str.indexOf(41, i12)).trim());
        }

        @Override // m0.C4890c
        public double a(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > f37054h) {
                d11 *= 0.5d;
                d12 = d(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double d14 = d(d13);
            double d15 = d12 + d11;
            double d16 = d(d15);
            double dE = e(d13);
            return (((e(d15) - dE) * (d10 - d14)) / (d16 - d14)) + dE;
        }

        @Override // m0.C4890c
        public double b(double d10) {
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > f37055i) {
                d11 *= 0.5d;
                d12 = d(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double d14 = d12 + d11;
            return (e(d14) - e(d13)) / (d(d14) - d(d13));
        }

        public final double d(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f37056d * d11 * d12 * d10) + (this.f37058f * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        public final double e(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f37057e * d11 * d12 * d10) + (this.f37059g * d12 * d10 * d10) + (d10 * d10 * d10);
        }
    }

    public static C4890c c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        if (str.startsWith("spline")) {
            return new l(str);
        }
        if (str.startsWith("Schlick")) {
            return new i(str);
        }
        switch (str) {
            case "accelerate":
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case "decelerate":
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case "anticipate":
                return new a("cubic(0.36, 0, 0.66, -0.56)");
            case "linear":
                return new a("cubic(1, 1, 0, 0)");
            case "overshoot":
                return new a("cubic(0.34, 1.56, 0.64, 1)");
            case "standard":
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f37052c));
                return f37051b;
        }
    }

    public double a(double d10) {
        return d10;
    }

    public double b(double d10) {
        return 1.0d;
    }

    public String toString() {
        return this.f37053a;
    }
}
