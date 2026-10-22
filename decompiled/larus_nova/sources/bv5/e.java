package bv5;

import androidx.camera.video.AudioStats;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f20864a = 0;

    static {
    }

    public e() {
    }

    public static double u(double r100) {
        double r101 = (r100 + 3.141592653589793d) % 6.283185307179586d;
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r101 = r101 + 6.283185307179586d;
    L6:
        return r101 - 3.141592653589793d;
    }

    public static double[][] e() {
        double[][] r100 = new double[18][];
        int r101 = 0;
    L3:
        if (r101 >= 18) goto L11;
        double[] r102 = new double[18];
        int r103 = 0;
    L5:
        if (r103 >= 18) goto L10;
        if (r101 != r103) goto L8;
        double r104 = 1.0d;
    L9:
        r102[r103] = r104;
        r103 = r103 + 1;
        goto L5
    L8:
        r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L9
    L10:
        r100[r101] = r102;
        r101 = r101 + 1;
        goto L3
    L11:
        return r100;
    }

    public static double[] b(double[] r110) {
        Intrinsics.checkNotNullParameter(r110, "qWxyz");
        double[][] r100 = n(r110);
        double r101 = r100[0][1];
        double r102 = r100[1][1];
        double[] r103 = r100[2];
        double r104 = r103[0];
        double r111 = r103[1];
        double r112 = r103[2];
        double r105 = Math.asin(Math.max(-1.0d, Math.min(1.0d, r111)));
        if (Math.abs(Math.cos(r105)) >= 1.0E-12d) goto L5;
        char r113 = 0;
        double r106 = Math.atan2(-r100[1][0], r100[0][0]);
        double r107 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        double[] r108 = new double[3];
        r108[r113] = r106;
        r108[1] = r105;
        r108[2] = r107;
        return r108;
    L5:
        r113 = 0;
        r106 = Math.atan2(-r101, r102);
        r107 = Math.atan2(-r104, r112);
        goto L6
    }

    public static double c(double[] r100) {
        double r101 = c.b(70.0d);
        Intrinsics.checkNotNullParameter(r100, "qWxyz");
        double[] r102 = b(r100);
        if (Math.abs(r102[1]) < r101) goto L7;
        double[][] r103 = n(r100);
        double r104 = -r103[0][2];
        double r105 = -r104;
        return Math.atan2(r105, -r103[1][2]);
    L7:
        return r102[0];
    }

    public static double[][] h(double[][] r110) {
        Intrinsics.checkNotNullParameter(r110, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        int r100 = r110.length;
        int r101 = r110[0].length;
        double[][] r102 = new double[r101][];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = new double[r100];
        r103 = r103 + 1;
        goto L3
    L5:
        int r104 = 0;
    L6:
        if (r104 >= r100) goto L11;
        int r105 = 0;
    L8:
        if (r105 >= r101) goto L10;
        r102[r105][r104] = r110[r104][r105];
        r105 = r105 + 1;
        goto L8
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        return r102;
    }

    public static double j(double[] r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        double r101 = r100[0];
        double r102 = r100[1];
        double r103 = (r101 * r101) + (r102 * r102);
        double r104 = r100[2];
        return Math.sqrt(r103 + (r104 * r104));
    }

    public static double[] m(double[] r110) {
        Intrinsics.checkNotNullParameter(r110, "qWxyz");
        double r100 = r110[0];
        double r101 = r110[1];
        double r102 = r110[2];
        double r111 = r110[3];
        double r112 = Math.sqrt((((r100 * r100) + (r101 * r101)) + (r102 * r102)) + (r111 * r111));
        if (r112 < 1.0E-12d) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        return new double[]{r100 / r112, r101 / r112, r102 / r112, r111 / r112};
    L10:
        throw new IllegalArgumentException("Quaternion norm is too small.".toString());
    L5:
        r103 = false;
        goto L6
    }

    public static double[][] n(double[] r310) {
        Intrinsics.checkNotNullParameter(r310, "qWxyz");
        double[] r100 = m(r310);
        double r101 = r100[0];
        double r102 = r100[1];
        double r103 = r100[2];
        double r110 = r100[3];
        double r111 = r102 * r102;
        double r112 = r103 * r103;
        double r113 = r110 * r110;
        double r114 = r102 * r103;
        double r210 = r102 * r110;
        double r211 = r103 * r110;
        double r104 = r102 * r101;
        double r105 = r103 * r101;
        double r106 = r101 * r110;
        return new double[][]{new double[]{1.0d - ((r112 + r113) * 2.0d), (r114 - r106) * 2.0d, (r210 + r105) * 2.0d}, new double[]{(r114 + r106) * 2.0d, 1.0d - ((r111 + r113) * 2.0d), (r211 - r104) * 2.0d}, new double[]{(r210 - r105) * 2.0d, (r211 + r104) * 2.0d, 1.0d - ((r111 + r112) * 2.0d)}};
    }

    public static double[] o(double[] r110) {
        Intrinsics.checkNotNullParameter(r110, "phi");
        double r100 = j(r110);
        if (r100 >= 1.0E-12d) goto L6;
        double[] r101 = {r110[0] * 0.5d, r110[1] * 0.5d, r110[2] * 0.5d};
        return m(new double[]{1.0d, r101[0], r101[1], r101[2]});
    L6:
        double[] r102 = {r110[0] / r100, r110[1] / r100, r110[2] / r100};
        double r103 = r100 * 0.5d;
        double r104 = Math.sin(r103);
        return new double[]{Math.cos(r103), r102[0] * r104, r102[1] * r104, r102[2] * r104};
    }

    public static double[][] p(double[] r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        double r100 = r110[0];
        double r101 = r110[1];
        double r102 = r110[2];
        return new double[][]{new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, -r102, r101}, new double[]{r102, AudioStats.AUDIO_AMPLITUDE_NONE, -r100}, new double[]{-r101, r100, AudioStats.AUDIO_AMPLITUDE_NONE}};
    }

    public static double[][] q(double[][] r110) {
        Intrinsics.checkNotNullParameter(r110, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        int r100 = r110.length;
        Intrinsics.checkNotNullParameter(r110, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        int r101 = r110.length;
        double[][] r102 = new double[r101][];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        double[] r105 = r110[r104];
        r102[r104] = Arrays.copyOf(r105, r105.length);
        r104 = r104 + 1;
    L5:
        if (r103 >= r100) goto L10;
        int r111 = r103 + 1;
        int r106 = r111;
    L7:
        if (r106 >= r100) goto L9;
        double[] r107 = r102[r103];
        double r108 = r107[r106];
        double[] r109 = r102[r106];
        double r112 = (r108 + r109[r103]) * 0.5d;
        r107[r106] = r112;
        r109[r103] = r112;
        r106 = r106 + 1;
        goto L7
    L9:
        r103 = r111;
        goto L5
    L10:
        return r102;
    }

    public static double[] a(double[] r110, double[] r111) {
        Intrinsics.checkNotNullParameter(r110, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r111, "b");
        double r100 = r110[1];
        double r101 = r111[2];
        double r102 = r110[2];
        double r103 = r111[0];
        double r104 = r110[0];
        return new double[]{(r100 * r101) - (r111[1] * r102), (r102 * r103) - (r101 * r104), (r104 * r111[1]) - (r110[1] * r103)};
    }

    public static double[][] d(double[][] r110, double[][] r111) {
        Intrinsics.checkNotNullParameter(r110, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r111, "b");
        int r100 = r110.length;
        int r101 = r110[0].length;
        if (r111.length == r100) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L20;
        double[][] r103 = new double[r100][];
        int r104 = 0;
    L10:
        if (r104 >= r100) goto L12;
        r103[r104] = new double[r101];
        r104 = r104 + 1;
        goto L10
    L12:
        int r105 = 0;
    L13:
        if (r105 >= r100) goto L18;
        int r106 = 0;
    L15:
        if (r106 >= r101) goto L17;
        r103[r105][r106] = r110[r105][r106] + r111[r105][r106];
        r106 = r106 + 1;
        goto L15
    L17:
        r105 = r105 + 1;
        goto L13
    L18:
        return r103;
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r111[0].length != r101) goto L7;
        r102 = true;
        goto L8
    }

    public static double[] f(double[][] r110, double[] r111) {
        Intrinsics.checkNotNullParameter(r110, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r111, "x");
        int r100 = r110.length;
        int r101 = r110[0].length;
        if (r111.length != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L15;
        double[] r103 = new double[r100];
        int r104 = 0;
    L8:
        if (r104 >= r100) goto L13;
        double[] r105 = r110[r104];
        double r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r107 = 0;
    L10:
        if (r107 >= r101) goto L12;
        r106 = r106 + (r105[r107] * r111[r107]);
        r107 = r107 + 1;
        goto L10
    L12:
        r103[r104] = r106;
        r104 = r104 + 1;
        goto L8
    L13:
        return r103;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r102 = false;
        goto L6
    }

    public static double[][] g(double[][] r210, double[][] r211) {
        Intrinsics.checkNotNullParameter(r210, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r211, "b");
        int r100 = r210.length;
        int r101 = r210[0].length;
        if (r211.length != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L26;
        int r103 = r211[0].length;
        double[][] r104 = new double[r100][];
        int r105 = 0;
    L8:
        if (r105 >= r100) goto L10;
        r104[r105] = new double[r103];
        r105 = r105 + 1;
        goto L8
    L10:
        int r106 = 0;
    L11:
        if (r106 >= r100) goto L24;
        double[] r107 = r210[r106];
        int r110 = 0;
    L13:
        if (r110 >= r101) goto L23;
        double r111 = r107[r110];
        if (r111 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == true) goto L22;
        double[] r113 = r211[r110];
        int r114 = 0;
    L20:
        if (r114 >= r103) goto L22;
        double[] r115 = r104[r106];
        r115[r114] = r115[r114] + (r113[r114] * r111);
        r114 = r114 + 1;
    L22:
        r110 = r110 + 1;
        goto L13
    L17:
        r112 = false;
        goto L18
    L23:
        r106 = r106 + 1;
        goto L11
    L24:
        return r104;
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r102 = false;
        goto L6
    }

    public static double[][] i(int r100, int r101) {
        double[][] r102 = new double[r100][];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r102[r103] = new double[r101];
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static double[] l(double[] r210, double[] r211) {
        Intrinsics.checkNotNullParameter(r210, "q1Wxyz");
        Intrinsics.checkNotNullParameter(r211, "q2Wxyz");
        double r100 = r210[0];
        double r101 = r210[1];
        double r102 = r210[2];
        double r110 = r210[3];
        double r111 = r211[0];
        double r112 = r211[1];
        double r113 = r211[2];
        double r103 = r211[3];
        return new double[]{(((r100 * r111) - (r101 * r112)) - (r102 * r113)) - (r110 * r103), (((r100 * r112) + (r101 * r111)) + (r102 * r103)) - (r110 * r113), (((r100 * r113) - (r101 * r103)) + (r102 * r111)) + (r110 * r112), (((r100 * r103) + (r101 * r113)) - (r102 * r112)) + (r110 * r111)};
    }

    public static double[] r(double[] r100, double[] r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        return new double[]{r100[0] + r101[0], r100[1] + r101[1], r100[2] + r101[2]};
    }

    public static double[] s(double[] r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        return new double[]{r100[0] * r101, r100[1] * r101, r100[2] * r101};
    }

    public static double[] t(double[] r100, double[] r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        return new double[]{r100[0] - r101[0], r100[1] - r101[1], r100[2] - r101[2]};
    }

    public static double[] k(double r110, double r111, double r112) {
        double r113 = r110 * 0.5d;
        double r114 = r111 * 0.5d;
        double r115 = r112 * 0.5d;
        double[] r100 = {Math.cos(r113), AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, Math.sin(r113)};
        double[] r116 = {Math.cos(r114), Math.sin(r114), AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
        return m(l(l(r100, r116), new double[]{Math.cos(r115), AudioStats.AUDIO_AMPLITUDE_NONE, Math.sin(r115), AudioStats.AUDIO_AMPLITUDE_NONE}));
    }
}
