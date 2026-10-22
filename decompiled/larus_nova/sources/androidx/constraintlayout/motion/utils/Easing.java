package androidx.constraintlayout.motion.utils;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Arrays;

/* JADX INFO: loaded from: classes17.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = null;
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    static Easing sDefault;
    String str;

    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        double f15323x1;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        double f15324x2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        double f15325y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        double f15326y2;

        public CubicEasing(String r100) {
            this.str = r100;
            int r101 = r100.indexOf(40);
            int r102 = r100.indexOf(44, r101);
            this.f15323x1 = CastDoubleProtector.parseDouble(r100.substring(r101 + 1, r102).trim());
            int r103 = r102 + 1;
            int r104 = r100.indexOf(44, r103);
            this.f15325y1 = CastDoubleProtector.parseDouble(r100.substring(r103, r104).trim());
            int r105 = r104 + 1;
            int r106 = r100.indexOf(44, r105);
            this.f15324x2 = CastDoubleProtector.parseDouble(r100.substring(r105, r106).trim());
            int r107 = r106 + 1;
            this.f15326y2 = CastDoubleProtector.parseDouble(r100.substring(r107, r100.indexOf(41, r107)).trim());
        }

        private double getDiffX(double r110) {
            double r100 = 1.0d - r110;
            double r101 = this.f15323x1;
            double r111 = this.f15324x2;
            return ((((r100 * 3.0d) * r100) * r101) + (((r100 * 6.0d) * r110) * (r111 - r101))) + (((3.0d * r110) * r110) * (1.0d - r111));
        }

        private double getDiffY(double r110) {
            double r100 = 1.0d - r110;
            double r101 = this.f15325y1;
            double r111 = this.f15326y2;
            return ((((r100 * 3.0d) * r100) * r101) + (((r100 * 6.0d) * r110) * (r111 - r101))) + (((3.0d * r110) * r110) * (1.0d - r111));
        }

        private double getX(double r100) {
            double r101 = 1.0d - r100;
            double r102 = 3.0d * r101;
            double r103 = (r101 * r102) * r100;
            double r104 = (r102 * r100) * r100;
            double r105 = (r100 * r100) * r100;
            return ((this.f15323x1 * r103) + (this.f15324x2 * r104)) + r105;
        }

        private double getY(double r100) {
            double r101 = 1.0d - r100;
            double r102 = 3.0d * r101;
            double r103 = (r101 * r102) * r100;
            double r104 = (r102 * r100) * r100;
            double r105 = (r100 * r100) * r100;
            return ((this.f15325y1 * r103) + (this.f15326y2 * r104)) + r105;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double r110) {
            if (r110 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L6:
            if (r110 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double r100 = 0.5d;
            double r101 = 0.5d;
        L10:
            if (r100 <= error) goto L15;
            r100 = r100 * 0.5d;
            if (getX(r101) < r110) goto L13;
            r101 = r101 - r100;
            goto L10
        L13:
            r101 = r101 + r100;
            goto L10
        L15:
            double r102 = r101 - r100;
            double r103 = getX(r102);
            double r104 = r101 + r100;
            double r105 = getX(r104);
            double r106 = getY(r102);
            return (((getY(r104) - r106) * (r110 - r103)) / (r105 - r103)) + r106;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double r110) {
            double r100 = 0.5d;
            double r101 = 0.5d;
        L4:
            if (r100 <= d_error) goto L9;
            r100 = r100 * 0.5d;
            if (getX(r101) < r110) goto L7;
            r101 = r101 - r100;
            goto L4
        L7:
            r101 = r101 + r100;
            goto L4
        L9:
            double r111 = r101 - r100;
            double r102 = getX(r111);
            double r103 = r101 + r100;
            double r104 = getX(r103);
            return (getY(r103) - getY(r111)) / (r104 - r102);
        }

        public CubicEasing(double r100, double r101, double r102, double r103) {
            setup(r100, r101, r102, r103);
        }

        public void setup(double r100, double r101, double r102, double r103) {
            this.f15323x1 = r100;
            this.f15325y1 = r101;
            this.f15324x2 = r102;
            this.f15326y2 = r103;
        }
    }

    public double get(double r100) {
        return r100;
    }

    public double getDiff(double r100) {
        return 1.0d;
    }

    static {
        sDefault = new Easing();
        NAMED_EASING = new String[]{"standard", ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};
    }

    public Easing() {
        this.str = DownloadHelper.IDENTITY;
    }

    public String toString() {
        return this.str;
    }

    public static Easing getInterpolator(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.startsWith("cubic") == true) goto L8;
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1354466595: goto L25;
            case -1263948740: goto L21;
            case -1102672091: goto L17;
            case 1312628413: goto L13;
            default: goto L28;
        };
    L28:
        switch(r101) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L34;
            case 3: goto L32;
            default: goto L29;
        };
    L29:
        Arrays.toString(NAMED_EASING);
        return sDefault;
    L32:
        return new CubicEasing(STANDARD);
    L34:
        return new CubicEasing(LINEAR);
    L36:
        return new CubicEasing(DECELERATE);
    L38:
        return new CubicEasing(ACCELERATE);
    L13:
        if (r100.equals("standard") == false) goto L28;
        r101 = 3;
        goto L28
    L17:
        if (r100.equals(LINEAR_NAME) == false) goto L28;
        r101 = 2;
        goto L28
    L21:
        if (r100.equals(DECELERATE_NAME) == false) goto L28;
        r101 = 1;
        goto L28
    L25:
        if (r100.equals(ACCELERATE_NAME) == false) goto L28;
        r101 = 0;
        goto L28
    L8:
        return new CubicEasing(r100);
    }
}
