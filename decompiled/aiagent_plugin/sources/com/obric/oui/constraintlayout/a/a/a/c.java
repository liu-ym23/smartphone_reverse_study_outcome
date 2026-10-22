package com.obric.oui.constraintlayout.a.a.a;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Arrays;

/* JADX INFO: compiled from: Easing.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static c f34591a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String[] f34592c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f34593b;

    /* JADX INFO: compiled from: Easing.java */
    static class a extends c {
        private static double h = 0.01d;
        private static double i = 1.0E-4d;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double f34594d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        double f34595e;
        double f;
        double g;

        static {
        }

        a(String r6) {
            this.f34593b = r6;
            int r0 = r6.indexOf(40);
            int r2 = r6.indexOf(44, r0);
            this.f34594d = Double.parseDouble(r6.substring(r0 + 1, r2).trim());
            int r3 = r2 + 1;
            int r1 = r6.indexOf(44, r3);
            this.f34595e = Double.parseDouble(r6.substring(r3, r1).trim());
            int r4 = r1 + 1;
            int r5 = r6.indexOf(44, r4);
            this.f = Double.parseDouble(r6.substring(r4, r5).trim());
            int r7 = r5 + 1;
            this.g = Double.parseDouble(r6.substring(r7, r6.indexOf(41, r7)).trim());
        }

        private double c(double r7) {
            double r0 = 1.0d - r7;
            double r2 = 3.0d * r0;
            double r1 = (r0 * r2) * r7;
            double r3 = (r2 * r7) * r7;
            double r4 = (r7 * r7) * r7;
            return ((this.f34594d * r1) + (this.f * r3)) + r4;
        }

        private double d(double r7) {
            double r0 = 1.0d - r7;
            double r2 = 3.0d * r0;
            double r1 = (r0 * r2) * r7;
            double r3 = (r2 * r7) * r7;
            double r4 = (r7 * r7) * r7;
            return ((this.f34595e * r1) + (this.g * r3)) + r4;
        }

        @Override // com.obric.oui.constraintlayout.a.a.a.c
        public double b(double r9) {
            double r2 = 0.5d;
            double r4 = 0.5d;
        L4:
            if (r2 <= i) goto L9;
            r2 = r2 * 0.5d;
            if (c(r4) < r9) goto L7;
            r4 = r4 - r2;
            goto L4
        L7:
            r4 = r4 + r2;
            goto L4
        L9:
            double r10 = r4 - r2;
            double r0 = c(r10);
            double r5 = r4 + r2;
            double r3 = c(r5);
            return (d(r5) - d(r10)) / (r3 - r0);
        }

        @Override // com.obric.oui.constraintlayout.a.a.a.c
        public double a(double r9) {
            if (r9 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r9 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double r2 = 0.5d;
            double r4 = 0.5d;
        L10:
            if (r2 <= h) goto L15;
            r2 = r2 * 0.5d;
            if (c(r4) < r9) goto L13;
            r4 = r4 - r2;
            goto L10
        L13:
            r4 = r4 + r2;
            goto L10
        L15:
            double r0 = r4 - r2;
            double r6 = c(r0);
            double r5 = r4 + r2;
            double r3 = c(r5);
            double r1 = d(r0);
            return (((d(r5) - r1) * (r9 - r6)) / (r3 - r6)) + r1;
        }
    }

    public double a(double r1) {
        return r1;
    }

    public double b(double r1) {
        return 1.0d;
    }

    public c() {
        this.f34593b = DownloadHelper.IDENTITY;
    }

    static {
        f34591a = new c();
        f34592c = new String[]{"standard", "accelerate", "decelerate", "linear"};
    }

    public static c a(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.startsWith("cubic") == false) goto L10;
        return new a(r2);
    L10:
        if (r2.startsWith("spline") == false) goto L14;
        return new l(r2);
    L14:
        if (r2.startsWith("Schlick") == true) goto L16;
        r2.hashCode();
        byte r0 = -1;
        switch(r2.hashCode()) {
            case -1354466595: goto L41;
            case -1263948740: goto L37;
            case -1197605014: goto L33;
            case -1102672091: goto L29;
            case -749065269: goto L25;
            case 1312628413: goto L21;
            default: goto L44;
        };
    L44:
        switch(r0) {
            case 0: goto L58;
            case 1: goto L56;
            case 2: goto L54;
            case 3: goto L52;
            case 4: goto L50;
            case 5: goto L48;
            default: goto L45;
        };
    L45:
        System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f34592c));
        return f34591a;
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
        if (r2.equals("standard") == false) goto L44;
        r0 = 5;
        goto L44
    L25:
        if (r2.equals("overshoot") == false) goto L44;
        r0 = 4;
        goto L44
    L29:
        if (r2.equals("linear") == false) goto L44;
        r0 = 3;
        goto L44
    L33:
        if (r2.equals("anticipate") == false) goto L44;
        r0 = 2;
        goto L44
    L37:
        if (r2.equals("decelerate") == false) goto L44;
        r0 = 1;
        goto L44
    L41:
        if (r2.equals("accelerate") == false) goto L44;
        r0 = 0;
        goto L44
    L16:
        return new i(r2);
    }

    public String toString() {
        return this.f34593b;
    }
}
