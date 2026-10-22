package bv5;

import androidx.camera.video.AudioStats;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import faceverify.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f20841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f20842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f20843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f20844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f20845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super bv5.a, Unit> f20846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f20847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f20848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double[][] f20849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public double f20850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f20851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayDeque<a> f20852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Double> f20853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Map<String, Object>> f20854n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<Map<String, Object>> f20855o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f20856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double[] f20857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double[] f20858c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Double.compare(this.f20856a, r101.f20856a) == 0) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f20857b, r101.f20857b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f20858c, r101.f20858c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = Double.doubleToLongBits(this.f20856a);
            return (((((int) (r100 ^ (r100 >>> 32))) * 31) + Arrays.hashCode(this.f20857b)) * 31) + Arrays.hashCode(this.f20858c);
        }

        public final String toString() {
            return "ImuSample(tS=" + this.f20856a + ", acc=" + Arrays.toString(this.f20857b) + ", gyro=" + Arrays.toString(this.f20858c) + ")";
        }

        public a(double r100, double[] r101, double[] r102) {
            Intrinsics.checkNotNullParameter(r101, "acc");
            Intrinsics.checkNotNullParameter(r102, w.BLOB_ELEM_SUBTYPE_GYRO);
            this.f20856a = r100;
            this.f20857b = r101;
            this.f20858c = r102;
        }
    }

    /* JADX INFO: renamed from: bv5.b$b, reason: collision with other inner class name */
    public static final class C0365b<A, B, C, D, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final A f20859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final B f20860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C f20861c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final D f20862d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final E f20863e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0365b) == true) goto L8;
            return false;
        L8:
            C0365b r101 = (C0365b) r100;
            if (Intrinsics.areEqual(this.f20859a, r101.f20859a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f20860b, r101.f20860b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f20861c, r101.f20861c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f20862d, r101.f20862d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f20863e, r101.f20863e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            A r100 = this.f20859a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            B r104 = this.f20860b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            C r107 = this.f20861c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            D r110 = this.f20862d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            E r113 = this.f20863e;
            if (r113 == null) goto L23;
            r101 = r113.hashCode();
        L23:
            return r112 + r101;
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Quintuple(first=" + this.f20859a + ", second=" + this.f20860b + ", third=" + this.f20861c + ", fourth=" + this.f20862d + ", fifth=" + this.f20863e + ")";
        }

        public C0365b(A r100, B r101, C r102, D r103, E r104) {
            this.f20859a = r100;
            this.f20860b = r101;
            this.f20861c = r102;
            this.f20862d = r103;
            this.f20863e = r104;
        }
    }

    public final boolean c(double r110, double r111, double r112, String r210) {
        Intrinsics.checkNotNullParameter(r210, "source");
        if (Double.isInfinite(r110) == false) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L10;
    L26:
        return false;
    L10:
        if (Double.isInfinite(r111) == false) goto L12;
    L14:
        boolean r101 = false;
    L15:
        if (r101 == false) goto L26;
        double r102 = e.c(this.f20848h.f20927c);
        int r103 = e.f20864a;
        double r104 = e.u(r110 - r102);
        double[] r105 = {r104};
        if (Math.abs(r104) <= r112) goto L20;
        return false;
    L20:
        double[][] r106 = e.i(1, 18);
        int r107 = 0;
    L22:
        if (r107 >= 3) goto L24;
        double[] r108 = {AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
        r108[r107] = 1.0E-6d;
        int r109 = e.f20864a;
        double[] r113 = e.m(e.l(this.f20848h.f20927c, e.o(r108)));
        double[] r114 = e.m(e.l(this.f20848h.f20927c, e.o(new double[]{-r108[0], -r108[1], -r108[2]})));
        r106[0][r107 + 6] = e.u(e.c(r113) - e.c(r114)) / 2.0E-6d;
        r107 = r107 + 1;
        goto L22
    L24:
        a(r105, r106, new double[][]{new double[]{r111 * r111}}, r210, c.a(r111));
        return true;
    L12:
        if (Double.isNaN(r111) == true) goto L14;
        r101 = true;
        goto L15
    L5:
        if (Double.isNaN(r110) == true) goto L7;
        r100 = true;
        goto L8
    }

    public static /* synthetic */ void b(b r100, double[] r101, double[][] r102, double[][] r110, String r111) {
        r100.a(r101, r102, r110, r111, Double.NaN);
    }

    public final void a(double[] r210, double[][] r211, double[][] r212, String r213, double r310) {
        if (r213 == null) goto L5;
        int r100 = e.f20864a;
        double[] r101 = e.b(this.f20848h.f20927c);
    L6:
        int r102 = e.f20864a;
        double[][] r103 = e.d(e.g(e.g(r211, this.f20849i), e.h(r211)), r212);
        Intrinsics.checkNotNullParameter(r103, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        int r104 = r103.length;
        if (r104 > 0) goto L9;
    L11:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L108;
        double[][] r106 = new double[r104][];
        int r110 = 0;
    L16:
        if (r110 >= r104) goto L27;
        int r111 = r104 * 2;
        double[] r112 = new double[r111];
        int r113 = 0;
    L18:
        if (r113 >= r111) goto L26;
        if (r113 >= r104) goto L22;
        double r114 = r103[r110][r113];
    L25:
        r112[r113] = r114;
        r113 = r113 + 1;
        goto L18
    L22:
        if ((r113 - r104) != r110) goto L24;
        r114 = 1.0d;
        goto L25
    L24:
        r114 = 0.0d;
        goto L25
    L26:
        r106[r110] = r112;
        r110 = r110 + 1;
        goto L16
    L27:
        int r107 = 0;
    L28:
        if (r107 >= r104) goto L60;
        double r115 = Math.abs(r106[r107][r107]);
        int r116 = r107 + 1;
        int r117 = r107;
        int r118 = r116;
    L30:
        if (r118 >= r104) goto L36;
        double r119 = Math.abs(r106[r118][r107]);
        if (r119 <= r115) goto L34;
        r117 = r118;
        r115 = r119;
    L34:
        r118 = r118 + 1;
        goto L30
    L36:
        if (r115 < 1.0E-18d) goto L38;
        boolean r120 = true;
    L39:
        if (r120 == false) goto L59;
        if (r117 == r107) goto L42;
        double[] r121 = r106[r107];
        r106[r107] = r106[r117];
        r106[r117] = r121;
    L42:
        double r122 = r106[r107][r107];
        int r123 = r104 * 2;
        int r124 = 0;
    L43:
        if (r124 >= r123) goto L45;
        double[] r125 = r106[r107];
        r125[r124] = r125[r124] / r122;
        r124 = r124 + 1;
        goto L43
    L45:
        int r126 = 0;
    L46:
        if (r126 >= r104) goto L57;
        if (r126 == r107) goto L56;
        double r127 = r106[r126][r107];
        if (r127 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L51;
        boolean r128 = true;
    L52:
        if (r128 == true) goto L56;
        int r129 = 0;
    L54:
        if (r129 >= r123) goto L56;
        double[] r130 = r106[r126];
        r130[r129] = r130[r129] - (r106[r107][r129] * r127);
        r129 = r129 + 1;
        goto L54
    L51:
        r128 = false;
    L56:
        r126 = r126 + 1;
        goto L46
    L57:
        r107 = r116;
        goto L28
    L59:
        throw new IllegalArgumentException("Matrix is singular or ill-conditioned.".toString());
    L38:
        r120 = false;
        goto L39
    L60:
        double[][] r108 = new double[r104][];
        int r131 = 0;
    L61:
        if (r131 >= r104) goto L63;
        r108[r131] = new double[r104];
        r131 = r131 + 1;
        goto L61
    L63:
        int r132 = 0;
    L64:
        if (r132 >= r104) goto L69;
        int r133 = 0;
    L66:
        if (r133 >= r104) goto L68;
        r108[r132][r133] = r106[r132][r133 + r104];
        r133 = r133 + 1;
        goto L66
    L68:
        r132 = r132 + 1;
        goto L64
    L69:
        int r109 = e.f20864a;
        double[][] r134 = e.g(e.g(this.f20849i, e.h(r211)), r108);
        double[] r135 = e.f(r134, r210);
        double[][] r136 = e.e();
        double[][] r137 = e.g(r134, r211);
        Intrinsics.checkNotNullParameter(r136, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r137, "b");
        int r138 = r136[0].length;
        if (r137.length == 18) goto L72;
    L74:
        boolean r139 = false;
    L75:
        if (r139 == false) goto L106;
        double[][] r140 = new double[18][];
        int r141 = 0;
    L77:
        if (r141 >= 18) goto L79;
        r140[r141] = new double[r138];
        r141 = r141 + 1;
        goto L77
    L79:
        int r142 = 0;
    L80:
        if (r142 >= 18) goto L85;
        int r143 = 0;
    L82:
        if (r143 >= r138) goto L84;
        r140[r142][r143] = r136[r142][r143] - r137[r142][r143];
        r143 = r143 + 1;
        goto L82
    L84:
        r142 = r142 + 1;
        goto L80
    L85:
        int r144 = e.f20864a;
        this.f20849i = e.q(e.d(e.g(e.g(r140, this.f20849i), e.h(r140)), e.g(e.g(r134, r212), e.h(r134))));
        double[] r145 = ArraysKt.copyOfRange(r135, 0, 3);
        double[] r146 = ArraysKt.copyOfRange(r135, 3, 6);
        double[] r147 = ArraysKt.copyOfRange(r135, 6, 9);
        double[] r148 = ArraysKt.copyOfRange(r135, 9, 12);
        double[] r149 = ArraysKt.copyOfRange(r135, 12, 15);
        double[] r150 = ArraysKt.copyOfRange(r135, 15, 18);
        k r151 = this.f20848h;
        double[] r152 = e.r(r151.f20925a, r145);
        Intrinsics.checkNotNullParameter(r152, "<set-?>");
        r151.f20925a = r152;
        k r153 = this.f20848h;
        double[] r154 = e.r(r153.f20926b, r146);
        Intrinsics.checkNotNullParameter(r154, "<set-?>");
        r153.f20926b = r154;
        k r155 = this.f20848h;
        double[] r156 = e.m(e.l(r155.f20927c, e.o(r147)));
        Intrinsics.checkNotNullParameter(r156, "<set-?>");
        r155.f20927c = r156;
        k r157 = this.f20848h;
        double[] r158 = e.r(r157.f20928d, r148);
        Intrinsics.checkNotNullParameter(r158, "<set-?>");
        r157.f20928d = r158;
        k r159 = this.f20848h;
        double[] r160 = e.r(r159.f20929e, r149);
        Intrinsics.checkNotNullParameter(r160, "<set-?>");
        r159.f20929e = r160;
        k r161 = this.f20848h;
        double[] r162 = e.r(r161.f20930f, r150);
        Intrinsics.checkNotNullParameter(r162, "<set-?>");
        r161.f20930f = r162;
        double[][] r163 = e.e();
        double[][] r164 = e.p(r147);
        int r165 = 0;
    L86:
        if (r165 >= 3) goto L95;
        int r166 = 0;
    L88:
        if (r166 >= 3) goto L94;
        double[] r167 = r163[r165 + 6];
        int r168 = r166 + 6;
        if (r165 != r166) goto L92;
        double r169 = 1.0d - (r164[r165][r166] * 0.5d);
    L93:
        r167[r168] = r169;
        r166 = r166 + 1;
        goto L88
    L92:
        r169 = r164[r165][r166] * (-0.5d);
        goto L93
    L94:
        r165 = r165 + 1;
        goto L86
    L95:
        int r170 = e.f20864a;
        this.f20849i = e.q(e.g(e.g(r163, this.f20849i), e.h(r163)));
        if (r213 == null) goto L134;
        if (r101 == null) goto L135;
        double r171 = c.a(e.u(e.b(this.f20848h.f20927c)[0] - r101[0]));
        Function1<? super bv5.a, Unit> r172 = this.f20846f;
        if (r172 == null) goto L101;
        r172.invoke(new bv5.a(r213, this.f20850j, r171, r310));
    L101:
        d r173 = this.f20847g;
        if (r173 == null) goto L136;
        r173.onEvent("attitude_correction", MapsKt.mapOf(new Pair[]{TuplesKt.to("source", r213), TuplesKt.to("t_s", Double.valueOf(this.f20850j)), TuplesKt.to("yaw_delta_deg", Double.valueOf(r171)), TuplesKt.to("yaw_meas_std_deg", Double.valueOf(r310))}));
        return;
    L136:
        return;
    L135:
        return;
    L134:
        return;
    L106:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L72:
        if (r137[0].length != r138) goto L74;
        r139 = true;
        goto L75
    L108:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L9:
        if (r103[0].length != r104) goto L11;
        r105 = true;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public b(k r100, double[][] r101, double r102, double r103, double r104, double r110, l r111) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "p0");
        this.f20841a = r102;
        this.f20842b = r103;
        this.f20843c = r104;
        this.f20844d = r110;
        this.f20845e = r111;
        this.f20848h = r100;
        int r105 = e.f20864a;
        Intrinsics.checkNotNullParameter(r101, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        int r106 = r101.length;
        double[][] r107 = new double[r106][];
        int r108 = 0;
    L3:
        if (r108 >= r106) goto L5;
        double[] r109 = r101[r108];
        r107[r108] = Arrays.copyOf(r109, r109.length);
        r108 = r108 + 1;
        goto L3
    L5:
        this.f20849i = r107;
        this.f20851k = -1.0E18d;
        this.f20852l = new ArrayDeque();
        this.f20853m = new ArrayList();
        this.f20854n = new ArrayList();
        this.f20855o = new ArrayList();
    }
}
