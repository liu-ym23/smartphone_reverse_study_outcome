package androidx.constraintlayout.core.motion.utils;

import com.ss.android.http.legacy.protocol.HTTP;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = null;
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    static Easing sDefault;
    String str;

    static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;
        double x1;
        double x2;
        double y1;
        double y2;

        static {
        }

        CubicEasing(String r6) {
            this.str = r6;
            int r0 = r6.indexOf(40);
            int r2 = r6.indexOf(44, r0);
            this.x1 = Double.parseDouble(r6.substring(r0 + 1, r2).trim());
            int r3 = r2 + 1;
            int r1 = r6.indexOf(44, r3);
            this.y1 = Double.parseDouble(r6.substring(r3, r1).trim());
            int r4 = r1 + 1;
            int r5 = r6.indexOf(44, r4);
            this.x2 = Double.parseDouble(r6.substring(r4, r5).trim());
            int r7 = r5 + 1;
            this.y2 = Double.parseDouble(r6.substring(r7, r6.indexOf(41, r7)).trim());
        }

        public CubicEasing(double r1, double r3, double r5, double r7) {
            setup(r1, r3, r5, r7);
        }

        void setup(double r1, double r3, double r5, double r7) {
            this.x1 = r1;
            this.y1 = r3;
            this.x2 = r5;
            this.y2 = r7;
        }

        private double getX(double r7) {
            double r0 = 1.0d - r7;
            double r2 = 3.0d * r0;
            double r1 = (r0 * r2) * r7;
            double r3 = (r2 * r7) * r7;
            double r4 = (r7 * r7) * r7;
            return ((this.x1 * r1) + (this.x2 * r3)) + r4;
        }

        private double getY(double r7) {
            double r0 = 1.0d - r7;
            double r2 = 3.0d * r0;
            double r1 = (r0 * r2) * r7;
            double r3 = (r2 * r7) * r7;
            double r4 = (r7 * r7) * r7;
            return ((this.y1 * r1) + (this.y2 * r3)) + r4;
        }

        private double getDiffX(double r13) {
            double r2 = 1.0d - r13;
            double r8 = this.x1;
            double r10 = this.x2;
            return ((((r2 * 3.0d) * r2) * r8) + (((r2 * 6.0d) * r13) * (r10 - r8))) + (((3.0d * r13) * r13) * (1.0d - r10));
        }

        private double getDiffY(double r13) {
            double r2 = 1.0d - r13;
            double r8 = this.y1;
            double r10 = this.y2;
            return ((((r2 * 3.0d) * r2) * r8) + (((r2 * 6.0d) * r13) * (r10 - r8))) + (((3.0d * r13) * r13) * (1.0d - r10));
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double r9) {
            double r2 = 0.5d;
            double r4 = 0.5d;
        L4:
            if (r2 <= d_error) goto L9;
            r2 = r2 * 0.5d;
            if (getX(r4) < r9) goto L7;
            r4 = r4 - r2;
            goto L4
        L7:
            r4 = r4 + r2;
            goto L4
        L9:
            double r10 = r4 - r2;
            double r0 = getX(r10);
            double r5 = r4 + r2;
            double r3 = getX(r5);
            return (getY(r5) - getY(r10)) / (r3 - r0);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double r9) {
            if (r9 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r9 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double r2 = 0.5d;
            double r4 = 0.5d;
        L10:
            if (r2 <= error) goto L15;
            r2 = r2 * 0.5d;
            if (getX(r4) < r9) goto L13;
            r4 = r4 - r2;
            goto L10
        L13:
            r4 = r4 + r2;
            goto L10
        L15:
            double r0 = r4 - r2;
            double r6 = getX(r0);
            double r5 = r4 + r2;
            double r3 = getX(r5);
            double r1 = getY(r0);
            return (((getY(r5) - r1) * (r9 - r6)) / (r3 - r6)) + r1;
        }
    }

    public double get(double r1) {
        return r1;
    }

    public double getDiff(double r1) {
        return 1.0d;
    }

    public Easing() {
        this.str = HTTP.IDENTITY_CODING;
    }

    static {
        sDefault = new Easing();
        NAMED_EASING = new String[]{"standard", ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};
    }

    public static Easing getInterpolator(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.startsWith("cubic") == false) goto L10;
        return new CubicEasing(r2);
    L10:
        if (r2.startsWith("spline") == false) goto L14;
        return new StepCurve(r2);
    L14:
        if (r2.startsWith("Schlick") == true) goto L16;
        r2.hashCode();
        byte r1 = -1;
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
        switch(r1) {
            case 0: goto L58;
            case 1: goto L56;
            case 2: goto L54;
            case 3: goto L52;
            case 4: goto L50;
            case 5: goto L48;
            default: goto L45;
        };
    L45:
        System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
        return sDefault;
    L48:
        return new CubicEasing(STANDARD);
    L50:
        return new CubicEasing(OVERSHOOT);
    L52:
        return new CubicEasing(LINEAR);
    L54:
        return new CubicEasing(ANTICIPATE);
    L56:
        return new CubicEasing(DECELERATE);
    L58:
        return new CubicEasing(ACCELERATE);
    L21:
        if (r2.equals("standard") == false) goto L44;
        r1 = 5;
        goto L44
    L25:
        if (r2.equals(OVERSHOOT_NAME) == false) goto L44;
        r1 = 4;
        goto L44
    L29:
        if (r2.equals(LINEAR_NAME) == false) goto L44;
        r1 = 3;
        goto L44
    L33:
        if (r2.equals(ANTICIPATE_NAME) == false) goto L44;
        r1 = 2;
        goto L44
    L37:
        if (r2.equals(DECELERATE_NAME) == false) goto L44;
        r1 = 1;
        goto L44
    L41:
        if (r2.equals(ACCELERATE_NAME) == false) goto L44;
        r1 = 0;
        goto L44
    L16:
        return new Schlick(r2);
    }

    public String toString() {
        return this.str;
    }
}
