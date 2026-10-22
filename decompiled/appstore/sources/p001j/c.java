package p001j;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f20780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String[] f20781c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20782a;

    public static class a extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static double f20783h = 0.01d;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static double f20784i = 1.0E-4d;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f20785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f20786e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f20787f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f20788g;

        static {
        }

        public a(String r10) {
            this.f20782a = r10;
            int r11 = r10.indexOf(40);
            int r12 = r10.indexOf(44, r11);
            this.f20785d = Double.parseDouble(r10.substring(r11 + 1, r12).trim());
            int r13 = r12 + 1;
            int r14 = r10.indexOf(44, r13);
            this.f20786e = Double.parseDouble(r10.substring(r13, r14).trim());
            int r15 = r14 + 1;
            int r16 = r10.indexOf(44, r15);
            this.f20787f = Double.parseDouble(r10.substring(r15, r16).trim());
            int r17 = r16 + 1;
            this.f20788g = Double.parseDouble(r10.substring(r17, r10.indexOf(41, r17)).trim());
        }

        @Override // p001j.c
        public double a(double r10) {
            if (r10 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r10 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double r11 = 0.5d;
            double r12 = 0.5d;
        L10:
            if (r11 <= f20783h) goto L15;
            r11 = r11 * 0.5d;
            if (d(r12) < r10) goto L13;
            r12 = r12 - r11;
            goto L10
        L13:
            r12 = r12 + r11;
            goto L10
        L15:
            double r13 = r12 - r11;
            double r14 = d(r13);
            double r15 = r12 + r11;
            double r16 = d(r15);
            double r17 = e(r13);
            return (((e(r15) - r17) * (r10 - r14)) / (r16 - r14)) + r17;
        }

        @Override // p001j.c
        public double b(double r10) {
            double r11 = 0.5d;
            double r12 = 0.5d;
        L4:
            if (r11 <= f20784i) goto L9;
            r11 = r11 * 0.5d;
            if (d(r12) < r10) goto L7;
            r12 = r12 - r11;
            goto L4
        L7:
            r12 = r12 + r11;
            goto L4
        L9:
            double r13 = r12 - r11;
            double r14 = d(r13);
            double r15 = r12 + r11;
            double r16 = d(r15);
            return (e(r15) - e(r13)) / (r16 - r14);
        }

        public final double d(double r10) {
            double r11 = 1.0d - r10;
            double r12 = 3.0d * r11;
            double r13 = (r11 * r12) * r10;
            double r14 = (r12 * r10) * r10;
            double r15 = (r10 * r10) * r10;
            return ((this.f20785d * r13) + (this.f20787f * r14)) + r15;
        }

        public final double e(double r10) {
            double r11 = 1.0d - r10;
            double r12 = 3.0d * r11;
            double r13 = (r11 * r12) * r10;
            double r14 = (r12 * r10) * r10;
            double r15 = (r10 * r10) * r10;
            return ((this.f20786e * r13) + (this.f20788g * r14)) + r15;
        }
    }

    static {
        f20780b = new c();
        f20781c = new String[]{"standard", "accelerate", "decelerate", "linear"};
    }

    public c() {
        this.f20782a = "identity";
    }

    public static c c(String r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.startsWith("cubic") == false) goto L10;
        return new a(r10);
    L10:
        if (r10.startsWith("spline") == false) goto L14;
        return new j(r10);
    L14:
        if (r10.startsWith("Schlick") == true) goto L16;
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -1354466595: goto L41;
            case -1263948740: goto L37;
            case -1197605014: goto L33;
            case -1102672091: goto L29;
            case -749065269: goto L25;
            case 1312628413: goto L21;
            default: goto L44;
        };
    L44:
        switch(r11) {
            case 0: goto L58;
            case 1: goto L56;
            case 2: goto L54;
            case 3: goto L52;
            case 4: goto L50;
            case 5: goto L48;
            default: goto L45;
        };
    L45:
        System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f20781c));
        return f20780b;
    L48:
        return new a("cubic(0.4, 0.0, 0.2, 1)");
    L50:
        return new a("cubic(0.34, 1.56, 0.64, 1)");
    L52:
        return new a("cubic(1, 1, 0, 0)");
    L54:
        return new a("cubic(0.36, 0, 0.66, -0.56)");
    L56:
        return new a("cubic(0.0, 0.0, 0.2, 0.95)");
    L58:
        return new a("cubic(0.4, 0.05, 0.8, 0.7)");
    L21:
        if (r10.equals("standard") == false) goto L44;
        r11 = 5;
        goto L44
    L25:
        if (r10.equals("overshoot") == false) goto L44;
        r11 = 4;
        goto L44
    L29:
        if (r10.equals("linear") == false) goto L44;
        r11 = 3;
        goto L44
    L33:
        if (r10.equals("anticipate") == false) goto L44;
        r11 = 2;
        goto L44
    L37:
        if (r10.equals("decelerate") == false) goto L44;
        r11 = 1;
        goto L44
    L41:
        if (r10.equals("accelerate") == false) goto L44;
        r11 = 0;
        goto L44
    L16:
        return new h(r10);
    }

    public double a(double r10) {
        return r10;
    }

    public double b(double r10) {
        return 1.0d;
    }

    public String toString() {
        return this.f20782a;
    }
}
