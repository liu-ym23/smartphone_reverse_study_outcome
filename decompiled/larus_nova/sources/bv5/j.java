package bv5;

import androidx.camera.video.AudioStats;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class j {
    public final ArrayDeque<Boolean> A;
    public final ArrayDeque<Long> B;
    public final ArrayDeque<Long> C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f20899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f20900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<bv5.a, Unit> f20901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Double, Unit> f20902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f20903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f20904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f20905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f20906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f20907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public double f20908j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20909k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double[] f20910l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double[] f20911m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double[] f20912n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double[] f20913o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public double[] f20914p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public double f20915q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double f20916r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double[] f20917s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Long f20918t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Double f20919u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Double f20920v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public double[] f20921w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Long f20922x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public double f20923y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public double f20924z;

    public static final class a {
    }

    static {
    }

    public static double d(double r100) {
        double r101 = (r100 + 180.0d) % 360.0d;
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r101 = r101 + 360.0d;
    L6:
        return r101 - 180.0d;
    }

    public final void a(b r100) {
        int r101 = e.f20864a;
        double r102 = c.a(e.c(r100.f20848h.f20927c));
        boolean r103 = false;
        if (Double.isInfinite(r102) == false) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
        return;
    L10:
        h r105 = this.f20903e;
        double r106 = d(r102);
        int r107 = w27.g.f558041a;
        double r108 = r105.update(r106, System.currentTimeMillis());
        if (Double.isInfinite(r108) == false) goto L13;
    L15:
        boolean r109 = false;
    L16:
        if (r109 == true) goto L18;
        double r110 = Double.NaN;
    L22:
        if (Double.isInfinite(r110) == false) goto L24;
    L26:
        if (r103 == false) goto L29;
        this.f20902d.invoke(Double.valueOf(r110));
        return;
    L29:
        return;
    L24:
        if (Double.isNaN(r110) == true) goto L26;
        r103 = true;
        goto L26
    L18:
        r110 = (-r108) % 360.0d;
        if (r110 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L22;
        r110 = r110 + 360.0d;
        goto L22
    L13:
        if (Double.isNaN(r108) == true) goto L15;
        r109 = true;
        goto L16
    L5:
        if (Double.isNaN(r102) == true) goto L7;
        r104 = true;
        goto L8
    }

    public final void b(b r110) {
        double r100 = this.f20915q;
        boolean r101 = false;
        if (Double.isInfinite(r100) == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L11;
        return;
    L11:
        if (this.f20909k == false) goto L16;
        if ((this.f20905g - this.f20908j) >= this.f20899a.A) goto L16;
        return;
    L16:
        if ((this.f20905g - this.f20907i) >= this.f20899a.B) goto L18;
        return;
    L18:
        int r103 = e.f20864a;
        double[] r104 = e.b(r110.f20848h.f20927c);
        double r105 = c.a(r104[1]);
        double r106 = c.a(r104[2]);
        if (Double.isInfinite(r105) == false) goto L21;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == true) goto L26;
        return;
    L26:
        if (Double.isInfinite(r106) == false) goto L28;
    L30:
        boolean r108 = false;
    L31:
        if (r108 == true) goto L34;
        return;
    L34:
        if (Math.abs(r105) <= this.f20899a.D) goto L36;
        return;
    L36:
        if (Math.abs(r106) > this.f20899a.D) goto L59;
        double r109 = 180.0d;
        double r111 = (((360.0d - r100) + 180.0d) % 360.0d) - 180.0d;
        double r112 = this.f20916r;
        if (Double.isInfinite(r112) == false) goto L41;
    L43:
        if (r101 == true) goto L45;
    L47:
        double r113 = this.f20899a.f20891z;
    L49:
        if (this.f20909k == false) goto L52;
        r109 = this.f20899a.C;
    L52:
        if (r110.c(c.b(r111), c.b(r113), c.b(r109), "罗盘航向") == false) goto L54;
        this.f20909k = true;
    L54:
        this.f20908j = this.f20905g;
        return;
    L45:
        if (r112 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L47;
        r113 = RangesKt.coerceIn(r112, 5.0d, 45.0d);
        goto L49
    L41:
        if (Double.isNaN(r112) == true) goto L43;
        r101 = true;
        goto L43
    L59:
        return;
    L28:
        if (Double.isNaN(r106) == true) goto L30;
        r108 = true;
        goto L31
    L21:
        if (Double.isNaN(r105) == true) goto L23;
        r107 = true;
        goto L24
    L5:
        if (Double.isNaN(r100) == true) goto L7;
        r102 = true;
        goto L8
    }

    public j(f r100, com.bytedance.navigation.kmp.capability.sensor.eskf.h r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r102, "onHeadingDeg");
        this.f20899a = r100;
        this.f20900b = r101;
        this.f20901c = null;
        this.f20902d = r102;
        this.f20903e = new h(r100.O);
        this.f20906h = Double.NEGATIVE_INFINITY;
        this.f20907i = Double.NEGATIVE_INFINITY;
        this.f20908j = Double.NEGATIVE_INFINITY;
        this.f20915q = Double.NaN;
        this.f20916r = Double.NaN;
        this.f20923y = Double.NaN;
        this.f20924z = Double.NaN;
        this.A = new ArrayDeque();
        this.B = new ArrayDeque();
        this.C = new ArrayDeque();
    }

    public final void c(double r410, double r411, double r412, double r413, double r510, double r511, long r512) {
        if (this.f20904f == null) goto L6;
    L63:
        b r100 = this.f20904f;
        if (r100 != null) goto L66;
        return;
    L66:
        Long r101 = this.f20922x;
        if (r512 < 0) goto L73;
        if (r101 == null) goto L73;
        if ((r512 - r101.longValue()) >= 500000000) goto L73;
        a(r100);
        return;
    L73:
        Double r102 = this.f20919u;
        if (r102 == null) goto L82;
        double r103 = r102.doubleValue();
        Double r104 = this.f20920v;
        if (r104 == null) goto L81;
        double r105 = r104.doubleValue();
        double[] r106 = this.f20921w;
        if (r106 != null) goto L80;
        double[] r107 = {AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
        int r108 = 3;
    L83:
        double r109 = Math.max(r413, this.f20899a.f20871f);
        f r110 = this.f20899a;
        double r111 = Math.max(r110.f20872g * r413, r110.f20871f);
        double[][] r112 = new double[r108][];
        double[] r113 = new double[r108];
        double r114 = r109 * r109;
        r113[0] = r114;
        r113[1] = 0.0d;
        r113[2] = 0.0d;
        r112[0] = r113;
        double[] r115 = new double[r108];
        r115[0] = 0.0d;
        r115[1] = r114;
        r115[2] = 0.0d;
        r112[1] = r115;
        double[] r116 = new double[r108];
        r116[0] = 0.0d;
        r116[1] = 0.0d;
        r116[2] = r111 * r111;
        r112[2] = r116;
        Intrinsics.checkNotNullParameter(r107, "posMeas");
        Intrinsics.checkNotNullParameter(r112, "rMeas");
        Intrinsics.checkNotNullParameter("GPS位置", "source");
        double r117 = r107[0];
        double[] r118 = r100.f20848h.f20925a;
        double[] r119 = {r117 - r118[0], r107[1] - r118[1], r107[2] - r118[2]};
        int r120 = e.f20864a;
        int r121 = 3;
        double[][] r122 = e.i(3, 18);
        int r123 = 0;
    L84:
        if (r123 >= r121) goto L86;
        r122[r123][r123] = 1.0d;
        r123 = r123 + 1;
        r121 = 3;
        goto L84
    L86:
        b.b(r100, r119, r122, r112, "GPS位置");
        ArrayDeque<Boolean> r124 = this.A;
        if (Double.isInfinite(r510) == false) goto L89;
    L91:
        boolean r125 = false;
    L92:
        if (r125 == true) goto L94;
    L96:
        boolean r126 = false;
    L97:
        r124.addLast(Boolean.valueOf(r126));
        int r127 = Math.max(1, this.f20899a.f20878m);
    L99:
        if (this.A.size() <= r127) goto L102;
        this.A.removeFirst();
        goto L99
    L102:
        if (this.f20899a.f20873h == true) goto L104;
    L218:
        b r128 = r100;
    L220:
        if (this.f20899a.f20886u == true) goto L222;
    L243:
        if (r512 < 0) goto L245;
        this.f20922x = Long.valueOf(r512);
    L245:
        a(r128);
        return;
    L222:
        if (Double.isInfinite(r510) == false) goto L224;
    L226:
        boolean r129 = false;
    L227:
        if (r129 == false) goto L243;
        if (Double.isInfinite(r511) == false) goto L231;
    L233:
        boolean r130 = false;
    L234:
        if (r130 == false) goto L243;
        if (r510 < this.f20899a.f20887v) goto L243;
        double r131 = c.b(r511);
        double r132 = Math.sin(r131) * r510;
        double r133 = Math.cos(r131) * r510;
        f r134 = this.f20899a;
        double r135 = Math.max(r134.f20888w * r413, r134.f20889x);
        double r136 = r135 * r135;
        double[][] r137 = {new double[]{r136, AudioStats.AUDIO_AMPLITUDE_NONE}, new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, r136}};
        double[] r138 = {r132, r133};
        Intrinsics.checkNotNullParameter(r138, "velEnMeas");
        Intrinsics.checkNotNullParameter(r137, "rMeas");
        Intrinsics.checkNotNullParameter("GPS速度", "source");
        if (r137[0].length != 2) goto L243;
        if (r137[1].length != 2) goto L243;
        double r139 = r138[0];
        double[] r140 = r128.f20848h.f20926b;
        double[] r141 = {r139 - r140[0], r138[1] - r140[1]};
        int r142 = e.f20864a;
        double[][] r143 = e.i(2, 18);
        r143[0][3] = 1.0d;
        r143[1][4] = 1.0d;
        b.b(r128, r141, r143, r137, "GPS速度");
        goto L243
    L231:
        if (Double.isNaN(r511) == true) goto L233;
        r130 = true;
        goto L234
    L224:
        if (Double.isNaN(r510) == true) goto L226;
        r129 = true;
        goto L227
    L104:
        if (Double.isInfinite(r511) == false) goto L106;
    L108:
        boolean r144 = false;
    L109:
        if (r144 == false) goto L218;
        double r145 = (((360.0d - r511) + 180.0d) % 360.0d) - 180.0d;
        int r146 = e.f20864a;
        double[] r147 = e.b(r100.f20848h.f20927c);
        double r148 = c.a(r147[1]);
        double r149 = c.a(r147[2]);
        f r150 = this.f20899a;
        double r151 = r150.f20876k;
        int r152 = r150.f20877l;
        if (Double.isInfinite(r145) == false) goto L113;
    L115:
        boolean r210 = false;
    L116:
        if (r210 == true) goto L118;
    L164:
        r128 = r100;
    L165:
        boolean r153 = false;
    L167:
        if (Double.isInfinite(r148) == false) goto L169;
    L171:
        boolean r154 = false;
    L172:
        if (r154 == true) goto L174;
    L216:
        r145 = r145;
        r128 = r128;
    L217:
        this.f20924z = this.f20923y;
        this.f20923y = r145;
        goto L220
    L174:
        if (Double.isInfinite(r149) == false) goto L176;
    L178:
        boolean r155 = false;
    L179:
        if (r155 == false) goto L216;
        double r156 = Math.abs(r149);
        f r157 = this.f20899a;
        if (r156 >= r157.f20879n) goto L216;
        if (r148 <= r157.f20880o) goto L216;
        if (r148 >= r157.f20881p) goto L216;
        if (Double.isInfinite(r510) == false) goto L189;
    L191:
        boolean r158 = false;
    L192:
        if (r158 == false) goto L216;
        f r159 = this.f20899a;
        if (r510 < r159.f20874i) goto L216;
        if (r153 == false) goto L216;
        double r160 = r159.f20882q;
        double r161 = r159.f20883r;
        double r162 = r159.f20884s;
        double r163 = r159.f20885t;
        if (Double.isInfinite(r413) == false) goto L199;
    L201:
        boolean r164 = false;
    L202:
        if (r164 == true) goto L205;
        r161 = r163;
    L208:
        double r165 = c.b(r145);
        double r166 = c.b(r161);
        Double r167 = Double.valueOf(r510);
        f r168 = this.f20899a;
        double r169 = r168.f20874i;
        double r170 = c.b(r168.f20875j);
        Intrinsics.checkNotNullParameter("GPS航向", "source");
        if (r167 != null) goto L211;
    L213:
        boolean r171 = r128.c(r165, r166, r170, "GPS航向");
    L214:
        if (r171 == false) goto L217;
        this.f20907i = this.f20905g;
        goto L217
    L211:
        if (r167.doubleValue() >= r169) goto L213;
        r171 = false;
        goto L214
    L205:
        if (r413 <= r160) goto L208;
        r161 = r161 + (((r413 - r160) / (r162 - r160)) * (r163 - r161));
        goto L208
    L199:
        if (Double.isNaN(r413) == true) goto L201;
        r164 = true;
        goto L202
    L189:
        if (Double.isNaN(r510) == true) goto L191;
        r158 = true;
        goto L192
    L176:
        if (Double.isNaN(r149) == true) goto L178;
        r155 = true;
        goto L179
    L169:
        if (Double.isNaN(r148) == true) goto L171;
        r154 = true;
        goto L172
    L118:
        if (Double.isInfinite(r151) == false) goto L120;
    L122:
        boolean r211 = false;
    L123:
        if (r211 == false) goto L164;
        if (r152 > 1) goto L128;
        r128 = r100;
    L163:
        r153 = true;
        goto L167
    L128:
        r128 = r100;
        double r172 = this.f20923y;
        if (Double.isInfinite(r172) == false) goto L131;
    L133:
        boolean r173 = false;
    L134:
        if (r173 == false) goto L165;
        double r212 = Math.abs(d(r145 - r172));
        if (r212 <= 0.001d) goto L165;
        if (r212 >= r151) goto L165;
        if (r152 < 3) goto L163;
        double r174 = this.f20924z;
        if (Double.isInfinite(r174) == false) goto L146;
    L148:
        boolean r175 = false;
    L149:
        if (r175 == false) goto L165;
        if (Math.abs(r145) < 0.001d) goto L165;
        if (Math.abs(r172) < 0.001d) goto L165;
        if (Math.abs(r174) < 0.001d) goto L165;
        double r176 = Math.abs(d(r172 - r174));
        if (r176 <= 0.001d) goto L165;
        if (r176 < r151) goto L163;
    L146:
        if (Double.isNaN(r174) == true) goto L148;
        r175 = true;
        goto L149
    L131:
        if (Double.isNaN(r172) == true) goto L133;
        r173 = true;
        goto L134
    L120:
        if (Double.isNaN(r151) == true) goto L122;
        r211 = true;
        goto L123
    L113:
        if (Double.isNaN(r145) == true) goto L115;
        r210 = true;
        goto L116
    L106:
        if (Double.isNaN(r511) == true) goto L108;
        r144 = true;
        goto L109
    L94:
        if (r510 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L96;
        r126 = true;
        goto L97
    L89:
        if (Double.isNaN(r510) == true) goto L91;
        r125 = true;
        goto L92
    L80:
        int r177 = g.f20892a;
        double[] r178 = g.a(c.b(r410), c.b(r411), r412);
        Intrinsics.checkNotNullParameter(r178, "ecef");
        Intrinsics.checkNotNullParameter(r106, "refEcef");
        double r179 = r178[0] - r106[0];
        double r180 = r178[1] - r106[1];
        double r181 = r178[2] - r106[2];
        double r182 = Math.sin(r103);
        double r183 = Math.cos(r103);
        double r184 = Math.sin(r105);
        double r185 = Math.cos(r105);
        double r186 = -r182;
        double[] r187 = {r186 * r185, r186 * r184, r183};
        r108 = 3;
        int r188 = e.f20864a;
        r107 = e.f(new double[][]{new double[]{-r184, r185, AudioStats.AUDIO_AMPLITUDE_NONE}, r187, new double[]{r185 * r183, r183 * r184, r182}}, new double[]{r179, r180, r181});
        goto L83
    L81:
        r108 = 3;
        r107 = new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
        goto L83
    L82:
        r108 = 3;
        r107 = new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
        goto L83
    L6:
        if (Double.isInfinite(r413) == false) goto L8;
    L10:
        boolean r189 = false;
    L11:
        if (r189 == false) goto L63;
        if (r413 >= this.f20899a.f20870e) goto L63;
        double[] r190 = this.f20917s;
        if (r190 == null) goto L63;
        double r191 = c.b(r410);
        double r213 = c.b(r411);
        this.f20919u = Double.valueOf(r191);
        this.f20920v = Double.valueOf(r213);
        this.f20921w = g.a(r191, r213, r412);
        f r192 = this.f20899a;
        double r193 = r192.E;
        double r194 = r192.F;
        double r195 = r192.G;
        double r196 = r192.H;
        double r197 = r192.f20867b;
        double r198 = r192.I;
        double r199 = r192.f20865J;
        double r200 = 1.0d / Math.sqrt(r197);
        double r310 = (((r193 * 3.141592653589793d) / 180.0d) / 60.0d) * r200;
        double r201 = r200 * (r194 / 60.0d);
        double r1100 = ((r195 * 3.141592653589793d) / 180.0d) / 3600.0d;
        double r202 = r196 * 1.0E-5d;
        double[] r203 = {AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
        if (Double.isInfinite(r510) == false) goto L21;
    L23:
        boolean r204 = false;
    L24:
        if (r204 == true) goto L26;
    L35:
        double[] r1101 = {AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
        int r1102 = e.f20864a;
        double[] r311 = e.m(r190);
        double[] r205 = this.f20911m;
        if (r205 != null) goto L38;
        r205 = new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
    L38:
        double[] r312 = Arrays.copyOf(r205, r205.length);
        double[] r206 = this.f20913o;
        if (r206 != null) goto L41;
        r206 = new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
    L41:
        k r207 = new k(r1101, r203, r311, r312, Arrays.copyOf(r206, r206.length), new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, -this.f20899a.M});
        double[][] r313 = e.i(18, 18);
        double r1103 = Math.max(r413, this.f20899a.f20871f);
        int r208 = 0;
        int r1104 = 3;
    L42:
        if (r208 >= 3) goto L44;
        r313[r208][r208] = r1103 * r1103;
        r208 = r208 + 1;
        goto L42
    L44:
        int r209 = 0;
    L45:
        if (r209 >= r1104) goto L47;
        int r1105 = r209 + 3;
        double[] r1106 = r313[r1105];
        double r214 = this.f20899a.L;
        r1106[r1105] = r214 * r214;
        r209 = r209 + 1;
        r1104 = 3;
        goto L45
    L47:
        int r215 = 0;
    L48:
        int r216 = 3;
        if (r215 >= 3) goto L51;
        double r217 = c.b(this.f20899a.K[r215]);
        int r1107 = r215 + 6;
        r313[r1107][r1107] = r217 * r217;
        r215 = r215 + 1;
        goto L48
    L51:
        int r218 = 0;
    L52:
        if (r218 >= 3) goto L54;
        int r219 = r218 + 9;
        r313[r219][r219] = r202 * r202;
        r218 = r218 + 1;
        goto L52
    L54:
        int r220 = 0;
    L55:
        if (r220 >= 3) goto L57;
        int r221 = r220 + 12;
        r313[r221][r221] = r1100 * r1100;
        r220 = r220 + 1;
        goto L55
    L57:
        int r222 = 0;
    L58:
        if (r222 >= r216) goto L60;
        int r223 = r222 + 15;
        r313[r223][r223] = 0.001d;
        r222 = r222 + 1;
        r216 = 3;
        goto L58
    L60:
        b r224 = new b(r207, r313, r201, r310, r199, r198, this.f20899a.N);
        d r225 = this.f20900b;
        r224.f20847g = r225;
        r224.f20846f = this.f20901c;
        this.f20904f = r224;
        if (r225 == null) goto L63;
        r225.onEvent("eskf_init", MapsKt.mapOf(new Pair[]{TuplesKt.to("accuracy_m", Double.valueOf(r413)), TuplesKt.to("ba0", ArraysKt.toList(r207.f20928d)), TuplesKt.to("bg0", ArraysKt.toList(r207.f20929e))}));
        goto L63
    L26:
        if (Double.isInfinite(r511) == false) goto L28;
    L30:
        boolean r226 = false;
    L31:
        if (r226 == false) goto L35;
        if (r510 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L35;
        double r227 = c.b(r511);
        r203[0] = Math.sin(r227) * r510;
        r203[1] = Math.cos(r227) * r510;
        goto L35
    L28:
        if (Double.isNaN(r511) == true) goto L30;
        r226 = true;
        goto L31
    L21:
        if (Double.isNaN(r510) == true) goto L23;
        r204 = true;
        goto L24
    L8:
        if (Double.isNaN(r413) == true) goto L10;
        r189 = true;
        goto L11
    }
}
