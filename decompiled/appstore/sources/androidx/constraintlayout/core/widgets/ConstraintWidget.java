package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.i;
import androidx.constraintlayout.core.widgets.analyzer.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    public static float U0 = 0.5f;
    public int A;
    public int A0;
    public float B;
    public int B0;
    public int C;
    public boolean C0;
    public int D;
    public boolean D0;
    public float E;
    public boolean E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public boolean G0;
    public int H;
    public boolean H0;
    public float I;
    public boolean I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int[] f1431J;
    public int J0;
    public float K;
    public int K0;
    public boolean L;
    public boolean L0;
    public boolean M;
    public boolean M0;
    public boolean N;
    public float[] N0;
    public int O;
    public ConstraintWidget[] O0;
    public int P;
    public ConstraintWidget[] P0;
    public ConstraintAnchor Q;
    public ConstraintWidget Q0;
    public ConstraintAnchor R;
    public ConstraintWidget R0;
    public ConstraintAnchor S;
    public int S0;
    public ConstraintAnchor T;
    public int T0;
    public ConstraintAnchor U;
    public ConstraintAnchor V;
    public ConstraintAnchor W;
    public ConstraintAnchor X;
    public ConstraintAnchor[] Y;
    public ArrayList Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1432a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean[] f1433a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WidgetRun[] f1434b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public DimensionBehaviour[] f1435b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.b f1436c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ConstraintWidget f1437c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.b f1438d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f1439d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f1440e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f1441e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f1442f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f1443f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean[] f1444g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f1445g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1446h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f1447h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1448i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f1449i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1450j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f1451j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1452k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f1453k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1454l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f1455l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1456m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f1457m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public androidx.constraintlayout.core.state.a f1458n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f1459n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f1460o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f1461o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1462p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f1463p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1464q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f1465q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1466r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f1467r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1468s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public Object f1469s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1470t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f1471t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1472u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f1473u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1474v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f1475v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1476w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public String f1477w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1478x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f1479x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f1480y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f1481y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1482z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f1483z0;

    public static final enum DimensionBehaviour extends Enum<DimensionBehaviour> {
        private static final /* synthetic */ DimensionBehaviour[] $VALUES = null;
        public static final DimensionBehaviour FIXED = null;
        public static final DimensionBehaviour MATCH_CONSTRAINT = null;
        public static final DimensionBehaviour MATCH_PARENT = null;
        public static final DimensionBehaviour WRAP_CONTENT = null;

        static {
            DimensionBehaviour r10 = new DimensionBehaviour("FIXED", 0);
            FIXED = r10;
            DimensionBehaviour r11 = new DimensionBehaviour("WRAP_CONTENT", 1);
            WRAP_CONTENT = r11;
            DimensionBehaviour r12 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            MATCH_CONSTRAINT = r12;
            DimensionBehaviour r13 = new DimensionBehaviour("MATCH_PARENT", 3);
            MATCH_PARENT = r13;
            $VALUES = new DimensionBehaviour[]{r10, r11, r12, r13};
        }

        private DimensionBehaviour(String r10, int r11) {
            super(r10, r11);
        }

        public static DimensionBehaviour valueOf(String r10) {
            return (DimensionBehaviour) Enum.valueOf(DimensionBehaviour.class, r10);
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) $VALUES.clone();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1484a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f1485b = null;

        static {
            int[] r10 = new int[DimensionBehaviour.values().length];
            f1485b = r10;
            r10[DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            f1485b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L46:
            f1485b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L58:
            f1485b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            int[] r11 = new int[ConstraintAnchor.Type.values().length];
            f1484a = r11;
            r11[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L38:
            f1484a[ConstraintAnchor.Type.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L44:
            f1484a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L52:
            f1484a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L34:
            f1484a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L42:
            f1484a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L56:
            f1484a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L40:
            f1484a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            f1484a[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    static {
    }

    public ConstraintWidget() {
        this.f1432a = false;
        this.f1434b = new WidgetRun[2];
        this.f1440e = null;
        this.f1442f = null;
        this.f1444g = new boolean[]{true, true};
        this.f1446h = false;
        this.f1448i = true;
        this.f1450j = false;
        this.f1452k = true;
        this.f1454l = -1;
        this.f1456m = -1;
        this.f1458n = new androidx.constraintlayout.core.state.a(this);
        this.f1462p = false;
        this.f1464q = false;
        this.f1466r = false;
        this.f1468s = false;
        this.f1470t = -1;
        this.f1472u = -1;
        this.f1474v = 0;
        this.f1476w = 0;
        this.f1478x = 0;
        this.f1480y = new int[2];
        this.f1482z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.f1431J = new int[]{Channel.UNLIMITED, Channel.UNLIMITED};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r12 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = r12;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, r12};
        this.Z = new ArrayList();
        this.f1433a0 = new boolean[2];
        DimensionBehaviour r10 = DimensionBehaviour.FIXED;
        this.f1435b0 = new DimensionBehaviour[]{r10, r10};
        this.f1437c0 = null;
        this.f1439d0 = 0;
        this.f1441e0 = 0;
        this.f1443f0 = 0.0f;
        this.f1445g0 = -1;
        this.f1447h0 = 0;
        this.f1449i0 = 0;
        this.f1451j0 = 0;
        this.f1453k0 = 0;
        this.f1455l0 = 0;
        this.f1457m0 = 0;
        this.f1459n0 = 0;
        float r11 = U0;
        this.f1465q0 = r11;
        this.f1467r0 = r11;
        this.f1471t0 = 0;
        this.f1473u0 = 0;
        this.f1475v0 = false;
        this.f1477w0 = null;
        this.f1479x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        a();
    }

    public int A() {
        ConstraintAnchor r10 = this.Q;
        if (r10 == null) goto L5;
        int r11 = r10.f1427g;
    L6:
        ConstraintAnchor r12 = this.S;
        if (r12 != null) goto L9;
        return r11;
    L9:
        return r11 + r12.f1427g;
    L5:
        r11 = 0;
        goto L6
    }

    public void A0(boolean r10) {
        this.f1475v0 = r10;
    }

    public int B() {
        return this.O;
    }

    public void B0(int r10) {
        this.f1459n0 = r10;
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        this.L = r11;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public int C() {
        return this.P;
    }

    public void C0(Object r10) {
        this.f1469s0 = r10;
    }

    public int D(int r10) {
        if (r10 != 0) goto L6;
        return V();
    L6:
        if (r10 == 1) goto L8;
        return 0;
    L8:
        return w();
    }

    public void D0(String r10) {
        this.f1477w0 = r10;
    }

    public int E() {
        return this.f1431J[1];
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    public void E0(String r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
    L44:
        this.f1443f0 = 0.0f;
        return;
    L5:
        if (r10.length() == 0) goto L44;
        int r12 = r10.length();
        int r13 = r10.indexOf(44);
        int r14 = 0;
        int r15 = -1;
        if (r13 > 0) goto L10;
    L19:
        int r16 = r10.indexOf(58);
        if (r16 >= 0) goto L22;
    L35:
        String r17 = r10.substring(r14);
        if (r17.length() <= 0) goto L39;
        float r18 = Float.parseFloat(r17);     // Catch: NumberFormatException -> L46
    L40:
        r11 = (r18 > r11 ? 1 : (r18 == r11 ? 0 : -1));
        if (r11 <= 0) goto L49;
        this.f1443f0 = r18;
        this.f1445g0 = r15;
        return;
    L49:
        return;
    L22:
        if (r16 >= (r12 - 1)) goto L35;
        String r19 = r10.substring(r14, r16);
        String r20 = r10.substring(r16 + 1);
        if (r19.length() <= 0) goto L39;
        if (r20.length() <= 0) goto L39;
        float r21 = Float.parseFloat(r19);     // Catch: NumberFormatException -> L46
        float r22 = Float.parseFloat(r20);     // Catch: NumberFormatException -> L46
        if (r21 <= 0.0f) goto L39;
        if (r22 <= 0.0f) goto L39;
        if (r15 != 1) goto L33;
        r18 = Math.abs(r22 / r21);     // Catch: NumberFormatException -> L46
        goto L40
    L33:
        r18 = Math.abs(r21 / r22);     // Catch: NumberFormatException -> L46
    L39:
        r18 = r11;
        goto L40
    L10:
        if (r13 >= (r12 - 1)) goto L19;
        String r23 = r10.substring(0, r13);
        if (r23.equalsIgnoreCase("W") == false) goto L15;
    L18:
        r15 = r14;
        r14 = r13 + 1;
        goto L19
    L15:
        if (r23.equalsIgnoreCase("H") == false) goto L17;
        r14 = 1;
        goto L18
    L17:
        r14 = -1;
        goto L18
    }

    public int F() {
        return this.f1431J[0];
    }

    public void F0(int r10) {
        if (this.L == true) goto L5;
        return;
    L5:
        int r11 = r10 - this.f1459n0;
        int r12 = this.f1441e0 + r11;
        this.f1449i0 = r11;
        this.R.t(r11);
        this.T.t(r12);
        this.U.t(r10);
        this.f1464q = true;
    }

    public int G() {
        return this.f1463p0;
    }

    public void G0(int r10, int r11) {
        if (this.f1462p == false) goto L5;
        return;
    L5:
        this.Q.t(r10);
        this.S.t(r11);
        this.f1447h0 = r10;
        this.f1439d0 = r11 - r10;
        this.f1462p = true;
    }

    public int H() {
        return this.f1461o0;
    }

    public void H0(int r10) {
        this.Q.t(r10);
        this.f1447h0 = r10;
    }

    public ConstraintWidget I(int r10) {
        if (r10 != 0) goto L10;
        ConstraintAnchor r11 = this.S;
        ConstraintAnchor r12 = r11.f1426f;
        if (r12 != null) goto L6;
        return null;
    L6:
        if (r12.f1426f == r11) goto L8;
        return null;
    L8:
        return r12.f1424d;
    L10:
        if (r10 != 1) goto L20;
        ConstraintAnchor r13 = this.T;
        ConstraintAnchor r14 = r13.f1426f;
        if (r14 != null) goto L14;
        return null;
    L14:
        if (r14.f1426f == r13) goto L16;
        return null;
    L16:
        return r14.f1424d;
    L20:
        return null;
    }

    public void I0(int r10) {
        this.R.t(r10);
        this.f1449i0 = r10;
    }

    public ConstraintWidget J() {
        return this.f1437c0;
    }

    public void J0(int r10, int r11) {
        if (this.f1464q == false) goto L5;
        return;
    L5:
        this.R.t(r10);
        this.T.t(r11);
        this.f1449i0 = r10;
        this.f1441e0 = r11 - r10;
        if (this.L == false) goto L8;
        this.U.t(r10 + this.f1459n0);
    L8:
        this.f1464q = true;
    }

    public ConstraintWidget K(int r10) {
        if (r10 != 0) goto L10;
        ConstraintAnchor r11 = this.Q;
        ConstraintAnchor r12 = r11.f1426f;
        if (r12 != null) goto L6;
        return null;
    L6:
        if (r12.f1426f == r11) goto L8;
        return null;
    L8:
        return r12.f1424d;
    L10:
        if (r10 != 1) goto L20;
        ConstraintAnchor r13 = this.R;
        ConstraintAnchor r14 = r13.f1426f;
        if (r14 != null) goto L14;
        return null;
    L14:
        if (r14.f1426f == r13) goto L16;
        return null;
    L16:
        return r14.f1424d;
    L20:
        return null;
    }

    public void K0(int r10, int r11, int r12, int r13) {
        int r14 = r12 - r10;
        int r15 = r13 - r11;
        this.f1447h0 = r10;
        this.f1449i0 = r11;
        if (this.f1473u0 != 8) goto L6;
        this.f1439d0 = 0;
        this.f1441e0 = 0;
        return;
    L6:
        DimensionBehaviour[] r16 = this.f1435b0;
        DimensionBehaviour r17 = r16[0];
        DimensionBehaviour r18 = DimensionBehaviour.FIXED;
        if (r17 != r18) goto L12;
        int r19 = this.f1439d0;
        if (r14 >= r19) goto L12;
        r14 = r19;
    L12:
        if (r16[1] != r18) goto L16;
        int r20 = this.f1441e0;
        if (r15 >= r20) goto L16;
        r15 = r20;
    L16:
        this.f1439d0 = r14;
        this.f1441e0 = r15;
        int r21 = this.f1463p0;
        if (r15 >= r21) goto L19;
        this.f1441e0 = r21;
    L19:
        int r22 = this.f1461o0;
        if (r14 >= r22) goto L22;
        this.f1439d0 = r22;
    L22:
        int r23 = this.A;
        if (r23 > 0) goto L25;
    L27:
        int r24 = this.D;
        if (r24 > 0) goto L30;
    L32:
        int r25 = this.f1439d0;
        if (r14 == r25) goto L35;
        this.f1454l = r25;
    L35:
        int r26 = this.f1441e0;
        if (r15 == r26) goto L39;
        this.f1456m = r26;
        return;
    L39:
        return;
    L30:
        if (this.f1435b0[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        this.f1441e0 = Math.min(this.f1441e0, r24);
        goto L32
    L25:
        if (r17 != DimensionBehaviour.MATCH_CONSTRAINT) goto L27;
        this.f1439d0 = Math.min(this.f1439d0, r23);
        goto L27
    }

    public int L() {
        return W() + this.f1439d0;
    }

    public void L0(boolean r10) {
        this.L = r10;
    }

    public WidgetRun M(int r10) {
        if (r10 != 0) goto L6;
        return this.f1440e;
    L6:
        if (r10 == 1) goto L8;
        return null;
    L8:
        return this.f1442f;
    }

    public void M0(int r10) {
        this.f1441e0 = r10;
        int r11 = this.f1463p0;
        if (r10 >= r11) goto L6;
        this.f1441e0 = r11;
        return;
    }

    public void N(StringBuilder r13) {
        r13.append("  " + this.f1460o + ":{\n");
        StringBuilder r10 = new StringBuilder();
        r10.append("    actualWidth:");
        r10.append(this.f1439d0);
        r13.append(r10.toString());
        r13.append("\n");
        r13.append("    actualHeight:" + this.f1441e0);
        r13.append("\n");
        r13.append("    actualLeft:" + this.f1447h0);
        r13.append("\n");
        r13.append("    actualTop:" + this.f1449i0);
        r13.append("\n");
        P(r13, "left", this.Q);
        P(r13, "top", this.R);
        P(r13, "right", this.S);
        P(r13, "bottom", this.T);
        P(r13, "baseline", this.U);
        P(r13, "centerX", this.V);
        P(r13, "centerY", this.W);
        O(r13, "    width", this.f1439d0, this.f1461o0, this.f1431J[0], this.f1454l, this.f1482z, this.f1476w, this.B, this.N0[0]);
        O(r13, "    height", this.f1441e0, this.f1463p0, this.f1431J[1], this.f1456m, this.C, this.f1478x, this.E, this.N0[1]);
        z0(r13, "    dimensionRatio", this.f1443f0, this.f1445g0);
        x0(r13, "    horizontalBias", this.f1465q0, U0);
        x0(r13, "    verticalBias", this.f1467r0, U0);
        y0(r13, "    horizontalChainStyle", this.J0, 0);
        y0(r13, "    verticalChainStyle", this.K0, 0);
        r13.append("  }");
    }

    public void N0(float r10) {
        this.f1465q0 = r10;
    }

    public final void O(StringBuilder r10, String r11, int r12, int r13, int r14, int r15, int r16, int r17, float r18, float r19) {
        r10.append(r11);
        r10.append(" :  {\n");
        y0(r10, "      size", r12, 0);
        y0(r10, "      min", r13, 0);
        y0(r10, "      max", r14, Channel.UNLIMITED);
        y0(r10, "      matchMin", r16, 0);
        y0(r10, "      matchDef", r17, 0);
        x0(r10, "      matchPercent", r18, 1.0f);
        r10.append("    },\n");
    }

    public void O0(int r10) {
        this.J0 = r10;
    }

    public final void P(StringBuilder r10, String r11, ConstraintAnchor r12) {
        if (r12.f1426f != null) goto L5;
        return;
    L5:
        r10.append("    ");
        r10.append(r11);
        r10.append(" : [ '");
        r10.append(r12.f1426f);
        r10.append("'");
        if (r12.f1428h == Integer.MIN_VALUE) goto L8;
    L9:
        r10.append(",");
        r10.append(r12.f1427g);
        if (r12.f1428h == Integer.MIN_VALUE) goto L12;
        r10.append(",");
        r10.append(r12.f1428h);
        r10.append(",");
    L12:
        r10.append(" ] ,\n");
        return;
    L8:
        if (r12.f1427g == 0) goto L12;
        goto L9
    }

    public void P0(int r10, int r11) {
        this.f1447h0 = r10;
        int r12 = r11 - r10;
        this.f1439d0 = r12;
        int r13 = this.f1461o0;
        if (r12 >= r13) goto L6;
        this.f1439d0 = r13;
        return;
    }

    public float Q() {
        return this.f1467r0;
    }

    public void Q0(DimensionBehaviour r10) {
        this.f1435b0[0] = r10;
    }

    public int R() {
        return this.K0;
    }

    public void R0(int r10, int r11, int r12, float r13) {
        this.f1476w = r10;
        this.f1482z = r11;
        if (r12 != Integer.MAX_VALUE) goto L5;
        r12 = 0;
    L5:
        this.A = r12;
        this.B = r13;
        if (r13 > 0.0f) goto L8;
        return;
    L8:
        if (r13 >= 1.0f) goto L13;
        if (r10 != 0) goto L14;
        this.f1476w = 2;
        return;
    L14:
        return;
    }

    public DimensionBehaviour S() {
        return this.f1435b0[1];
    }

    public void S0(float r10) {
        this.N0[0] = r10;
    }

    public int T() {
        if (this.Q == null) goto L5;
        int r10 = this.R.f1427g;
    L7:
        if (this.S != null) goto L9;
        return r10;
    L9:
        return r10 + this.T.f1427g;
    L5:
        r10 = 0;
        goto L7
    }

    public void T0(int r10, boolean r11) {
        this.f1433a0[r10] = r11;
    }

    public int U() {
        return this.f1473u0;
    }

    public void U0(boolean r10) {
        this.M = r10;
    }

    public int V() {
        if (this.f1473u0 != 8) goto L7;
        return 0;
    L7:
        return this.f1439d0;
    }

    public void V0(boolean r10) {
        this.N = r10;
    }

    public int W() {
        ConstraintWidget r10 = this.f1437c0;
        if (r10 == null) goto L9;
        if ((r10 instanceof ConstraintWidgetContainer) == false) goto L9;
        return ((ConstraintWidgetContainer) r10).f1489d1 + this.f1447h0;
    L9:
        return this.f1447h0;
    }

    public void W0(int r10, int r11) {
        this.O = r10;
        this.P = r11;
        Z0(false);
    }

    public int X() {
        ConstraintWidget r10 = this.f1437c0;
        if (r10 == null) goto L9;
        if ((r10 instanceof ConstraintWidgetContainer) == false) goto L9;
        return ((ConstraintWidgetContainer) r10).f1490e1 + this.f1449i0;
    L9:
        return this.f1449i0;
    }

    public void X0(int r10) {
        this.f1431J[1] = r10;
    }

    public boolean Y() {
        return this.L;
    }

    public void Y0(int r10) {
        this.f1431J[0] = r10;
    }

    public boolean Z(int r10) {
        if (r10 != 0) goto L17;
        if (this.Q.f1426f == null) goto L7;
        int r11 = 1;
    L9:
        if (this.S.f1426f == null) goto L11;
        int r12 = 1;
    L13:
        if ((r11 + r12) < 2) goto L15;
        return false;
    L15:
        return true;
    L11:
        r12 = 0;
        goto L13
    L7:
        r11 = 0;
        goto L9
    L17:
        if (this.R.f1426f == null) goto L19;
        int r13 = 1;
    L21:
        if (this.T.f1426f == null) goto L23;
        int r14 = 1;
    L24:
        int r15 = r13 + r14;
        if (this.U.f1426f == null) goto L27;
        int r16 = 1;
    L29:
        if ((r15 + r16) < 2) goto L31;
        return false;
    L31:
        return true;
    L27:
        r16 = 0;
        goto L29
    L23:
        r14 = 0;
        goto L24
    L19:
        r13 = 0;
        goto L21
    }

    public void Z0(boolean r10) {
        this.f1448i = r10;
    }

    public final void a() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    public boolean a0() {
        int r10 = this.Z.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (((ConstraintAnchor) this.Z.get(r11)).m() == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void a1(int r10) {
        if (r10 >= 0) goto L4;
        this.f1463p0 = 0;
        return;
    L4:
        this.f1463p0 = r10;
    }

    public void b(ConstraintWidgetContainer r10, LinearSystem r11, HashSet r12, int r13, boolean r14) {
        if (r14 == true) goto L4;
    L7:
        if (r13 != 0) goto L20;
        HashSet r15 = this.Q.d();
        if (r15 == null) goto L14;
        Iterator r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        ((ConstraintAnchor) r16.next()).f1424d.b(r10, r11, r12, r13, true);
    L14:
        HashSet r17 = this.S.d();
        if (r17 == null) goto L38;
        Iterator r18 = r17.iterator();
    L18:
        if (r18.hasNext() == false) goto L45;
        ((ConstraintAnchor) r18.next()).f1424d.b(r10, r11, r12, r13, true);
        goto L18
    L45:
        return;
    L38:
        return;
    L20:
        HashSet r19 = this.R.d();
        if (r19 == null) goto L26;
        Iterator r110 = r19.iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        ((ConstraintAnchor) r110.next()).f1424d.b(r10, r11, r12, r13, true);
    L26:
        HashSet r111 = this.T.d();
        if (r111 == null) goto L32;
        Iterator r112 = r111.iterator();
    L30:
        if (r112.hasNext() == false) goto L32;
        ((ConstraintAnchor) r112.next()).f1424d.b(r10, r11, r12, r13, true);
    L32:
        HashSet r20 = this.U.d();
        if (r20 == null) goto L44;
        Iterator r21 = r20.iterator();
    L36:
        if (r21.hasNext() == false) goto L46;
        ((ConstraintAnchor) r21.next()).f1424d.b(r10, r11, r12, r13, true);
        goto L36
    L46:
        return;
    L44:
        return;
    L4:
        if (r12.contains(this) == true) goto L6;
        return;
    L6:
        f.a(r10, r11, this);
        r12.remove(this);
        d(r11, r10.V1(64));
        goto L7
    }

    public boolean b0() {
        if (this.f1454l == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (this.f1456m != (-1)) goto L8;
        return false;
    }

    public void b1(int r10) {
        if (r10 >= 0) goto L4;
        this.f1461o0 = 0;
        return;
    L4:
        this.f1461o0 = r10;
    }

    public boolean c() {
        if ((this instanceof h) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof e) == true) goto L8;
        return false;
    }

    public boolean c0(int r10, int r11) {
        if (r10 != 0) goto L17;
        ConstraintAnchor r12 = this.Q.f1426f;
        if (r12 != null) goto L7;
    L30:
        return false;
    L7:
        if (r12.n() == false) goto L30;
        ConstraintAnchor r13 = this.S.f1426f;
        if (r13 == null) goto L30;
        if (r13.n() == false) goto L30;
        if (((this.S.f1426f.e() - this.S.f()) - (this.Q.f1426f.e() + this.Q.f())) < r11) goto L16;
        return true;
    L16:
        return false;
    L17:
        ConstraintAnchor r14 = this.R.f1426f;
        if (r14 == null) goto L30;
        if (r14.n() == false) goto L30;
        ConstraintAnchor r15 = this.T.f1426f;
        if (r15 == null) goto L30;
        if (r15.n() == false) goto L30;
        if (((this.T.f1426f.e() - this.T.f()) - (this.R.f1426f.e() + this.R.f())) < r11) goto L29;
        return true;
    L29:
        return false;
    }

    public void c1(int r10, int r11) {
        this.f1447h0 = r10;
        this.f1449i0 = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r15v5, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r53v0, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v6 */
    public void d(LinearSystem r54, boolean r55) {
        SolverVariable r13 = r54.q(this.Q);
        SolverVariable r12 = r54.q(this.S);
        SolverVariable r11 = r54.q(this.R);
        SolverVariable r10 = r54.q(this.T);
        SolverVariable r14 = r54.q(this.U);
        ConstraintWidget r15 = this.f1437c0;
        if (r15 == null) goto L19;
        if (r15 != null) goto L6;
    L8:
        boolean r16 = false;
    L9:
        if (r15 != null) goto L11;
    L13:
        boolean r17 = false;
    L14:
        int r18 = this.f1474v;
        if (r18 == 1) goto L21;
        if (r18 == 2) goto L20;
        if (r18 == 3) goto L19;
        boolean r19 = r17;
        boolean r20 = r16;
    L23:
        if (this.f1473u0 == 8) goto L25;
    L33:
        boolean r21 = this.f1462p;
        if (r21 == false) goto L36;
    L37:
        if (r21 == false) goto L47;
        r54.f(r13, this.f1447h0);
        r54.f(r12, this.f1447h0 + this.f1439d0);
        if (r20 == false) goto L47;
        ConstraintWidget r22 = this.f1437c0;
        if (r22 == null) goto L47;
        if (this.f1452k == false) goto L45;
        ConstraintWidgetContainer r23 = (ConstraintWidgetContainer) r22;
        r23.A1(this.Q);
        r23.z1(this.S);
        goto L47
    L45:
        r54.h(r54.q(r22.S), r12, 0, 5);
    L47:
        if (this.f1464q == false) goto L59;
        r54.f(r11, this.f1449i0);
        r54.f(r10, this.f1449i0 + this.f1441e0);
        if (this.U.m() == false) goto L51;
        r54.f(r14, this.f1449i0 + this.f1459n0);
    L51:
        if (r19 == false) goto L59;
        ConstraintWidget r24 = this.f1437c0;
        if (r24 == null) goto L59;
        if (this.f1452k == false) goto L57;
        ConstraintWidgetContainer r25 = (ConstraintWidgetContainer) r24;
        r25.F1(this.R);
        r25.E1(this.T);
        goto L59
    L57:
        r54.h(r54.q(r24.T), r10, 0, 5);
    L59:
        if (this.f1462p == true) goto L61;
    L64:
        Metrics r26 = LinearSystem.f1265x;
        if (r26 == null) goto L67;
        r26.f1310y++;
    L67:
        if (r55 == false) goto L98;
        i r27 = this.f1440e;
        if (r27 == null) goto L98;
        k r28 = this.f1442f;
        if (r28 == null) goto L98;
        DependencyNode r29 = r27.f1548h;
        if (r29.f1538j == false) goto L98;
        if (r27.f1549i.f1538j == false) goto L98;
        if (r28.f1548h.f1538j == false) goto L98;
        if (r28.f1549i.f1538j == false) goto L98;
        if (r26 == null) goto L82;
        r26.f1303r++;
    L82:
        r54.f(r13, r29.f1535g);
        r54.f(r12, this.f1440e.f1549i.f1535g);
        r54.f(r11, this.f1442f.f1548h.f1535g);
        r54.f(r10, this.f1442f.f1549i.f1535g);
        r54.f(r14, this.f1442f.f1577k.f1535g);
        if (this.f1437c0 == null) goto L96;
        if (r20 == true) goto L86;
    L90:
        if (r19 == false) goto L96;
        if (this.f1444g[1] == false) goto L96;
        if (j0() == true) goto L96;
        r54.h(r54.q(this.f1437c0.T), r10, 0, 8);
        goto L96
    L86:
        if (this.f1444g[0] == false) goto L90;
        if (h0() == true) goto L90;
        r54.h(r54.q(this.f1437c0.S), r12, 0, 8);
    L96:
        this.f1462p = false;
        this.f1464q = false;
        return;
    L98:
        if (r26 == null) goto L101;
        r26.f1304s++;
    L101:
        if (this.f1437c0 != null) goto L103;
        boolean r210 = false;
        boolean r211 = false;
    L133:
        int r30 = this.f1439d0;
        int r31 = this.f1461o0;
        if (r30 < r31) goto L137;
        r31 = r30;
    L137:
        int r32 = this.f1441e0;
        int r33 = this.f1463p0;
        if (r32 < r33) goto L141;
        r33 = r32;
    L141:
        DimensionBehaviour[] r34 = this.f1435b0;
        DimensionBehaviour r35 = r34[0];
        DimensionBehaviour r36 = DimensionBehaviour.MATCH_CONSTRAINT;
        int r212 = r31;
        if (r35 == r36) goto L145;
        boolean r37 = true;
    L146:
        DimensionBehaviour r38 = r34[1];
        int r213 = r33;
        SolverVariable r214 = r14;
        if (r38 == r36) goto L149;
        boolean r39 = true;
    L150:
        int r40 = this.f1445g0;
        this.H = r40;
        SolverVariable r310 = r10;
        float r110 = this.f1443f0;
        this.I = r110;
        SolverVariable r311 = r11;
        int r111 = this.f1476w;
        int r112 = this.f1478x;
        if (r110 > 0.0f) goto L153;
    L187:
        r111 = r111;
        r112 = r112;
        int r312 = r213;
    L184:
        boolean r113 = false;
    L188:
        int[] r41 = this.f1480y;
        r41[0] = r111;
        r41[1] = r112;
        this.f1446h = r113;
        if (r113 == false) goto L194;
        int r42 = this.H;
        int r43 = -1;
        if (r42 == 0) goto L193;
        if (r42 == (-1)) goto L193;
    L195:
        boolean r215 = false;
    L196:
        if (r113 == false) goto L201;
        int r44 = this.H;
        if (r44 == 1) goto L200;
        if (r44 != r43) goto L201;
    L200:
        boolean r313 = true;
    L202:
        DimensionBehaviour r45 = this.f1435b0[0];
        DimensionBehaviour r114 = DimensionBehaviour.WRAP_CONTENT;
        if (r45 == r114) goto L205;
    L207:
        boolean r46 = false;
    L208:
        if (r46 == false) goto L210;
        int r216 = 0;
    L211:
        boolean r314 = !this.X.o();
        boolean[] r47 = this.f1433a0;
        boolean r217 = r47[0];
        boolean r315 = r47[1];
        if (this.f1470t != 2) goto L214;
    L234:
        SolverVariable r316 = r12;
        SolverVariable r317 = r13;
    L248:
        if (r55 == false) goto L266;
        ?? r115 = this;
        k r48 = r115.f1442f;
        if (r48 == null) goto L265;
        DependencyNode r49 = r48.f1548h;
        if (r49.f1538j == false) goto L265;
        if (r48.f1549i.f1538j == false) goto L265;
        r54 = r54;
        r311 = r311;
        r54.f(r311, r49.f1535g);
        r310 = r310;
        r54.f(r310, r115.f1442f.f1549i.f1535g);
        r214 = r214;
        r54.f(r214, r115.f1442f.f1577k.f1535g);
        ConstraintWidget r50 = r115.f1437c0;
        if (r50 == null) goto L263;
        if (r210 == true) goto L263;
        if (r19 == false) goto L263;
        int r116 = 1;
        if (r115.f1444g[1] == false) goto L262;
        int r51 = 8;
        int r117 = 0;
        r54.h(r54.q(r50.T), r310, 0, 8);
    L264:
        int r52 = r117;
        ?? r118 = r115;
    L269:
        if (r118.f1472u != 2) goto L271;
        int r53 = r117;
    L272:
        if (r53 == 0) goto L313;
        if (r118.f1464q == true) goto L313;
        if (r118.f1435b0[r116] == r114) goto L278;
    L280:
        ?? r56 = r117;
    L281:
        if (r56 == 0) goto L283;
        r312 = r117;
    L283:
        ConstraintWidget r57 = r118.f1437c0;
        if (r57 == null) goto L286;
        SolverVariable r58 = r54.q(r57.T);
    L287:
        ConstraintWidget r59 = r118.f1437c0;
        if (r59 == null) goto L290;
        SolverVariable r60 = r54.q(r59.R);
    L292:
        if (r118.f1459n0 <= 0) goto L294;
    L295:
        ConstraintAnchor r61 = r118.U;
        if (r61.f1426f == null) goto L302;
        r54.e(r214, r311, o(), r51);
        r54.e(r214, r54.q(r118.U.f1426f), r118.U.f(), r51);
        if (r19 == 0) goto L300;
        r54.h(r58, r54.q(r118.T), r117, 5);
    L300:
        ?? r218 = r117;
    L306:
        boolean r62 = r118.f1444g[r116];
        DimensionBehaviour[] r63 = r118.f1435b0;
        DimensionBehaviour r64 = r63[r116];
        ConstraintAnchor r65 = r118.R;
        ConstraintAnchor r66 = r118.T;
        int r67 = r118.f1449i0;
        int r68 = r118.f1463p0;
        int r119 = r118.f1431J[r116];
        float r120 = r118.f1467r0;
        if (r63[0] != r36) goto L309;
        boolean r121 = true;
    L310:
        f(r54, false, r19, r20, r62, r60, r58, r64, r56, r65, r66, r67, r312, r68, r119, r120, r313, r121, r210, r211, r315, r112, r111, r118.C, r118.D, r118.E, r218);
        goto L313
    L309:
        r121 = false;
        goto L310
    L302:
        if (r118.f1473u0 != r51) goto L304;
        r54.e(r214, r311, r61.f(), r51);
    L305:
        r218 = r314;
        goto L306
    L304:
        r54.e(r214, r311, o(), r51);
        goto L305
    L294:
        if (r118.f1473u0 != r51) goto L305;
    L290:
        r60 = null;
        goto L292
    L286:
        r58 = null;
        goto L287
    L278:
        if ((r118 instanceof ConstraintWidgetContainer) == false) goto L280;
        r56 = r116;
    L313:
        if (r113 == false) goto L319;
        if (this.H != 1) goto L317;
        r54.k(r310, r311, r316, r317, this.I, 8);
        goto L319
    L317:
        r54.k(r316, r317, r310, r311, this.I, 8);
    L319:
        if (this.X.o() == false) goto L321;
        r54.b(this, this.X.j().h(), (float) Math.toRadians(this.K + 90.0f), this.X.f());
    L321:
        this.f1462p = false;
        this.f1464q = false;
        return;
    L271:
        r53 = r52;
        goto L272
    L262:
        r51 = 8;
        r117 = 0;
    L263:
        r51 = 8;
        r117 = 0;
        r116 = 1;
    L265:
        r51 = 8;
        r117 = 0;
        r116 = 1;
        ?? r122 = r115;
    L267:
        r52 = r116;
        r118 = r122;
        goto L269
    L266:
        r51 = 8;
        r117 = 0;
        r116 = 1;
        r122 = this;
        goto L267
    L214:
        if (this.f1462p == true) goto L234;
        if (r55 == false) goto L235;
        i r69 = this.f1440e;
        if (r69 == null) goto L235;
        DependencyNode r70 = r69.f1548h;
        if (r70.f1538j == false) goto L235;
        if (r69.f1549i.f1538j == false) goto L235;
        if (r55 == false) goto L234;
        r54.f(r13, r70.f1535g);
        r54.f(r12, this.f1440e.f1549i.f1535g);
        if (this.f1437c0 == null) goto L232;
        if (r20 == false) goto L232;
        if (this.f1444g[0] == false) goto L232;
        if (h0() == true) goto L232;
        r54.h(r54.q(this.f1437c0.S), r12, 0, 8);
    L232:
        r316 = r12;
        r317 = r13;
    L235:
        ConstraintWidget r71 = this.f1437c0;
        if (r71 == null) goto L238;
        SolverVariable r72 = r54.q(r71.S);
    L239:
        ConstraintWidget r73 = this.f1437c0;
        if (r73 == null) goto L242;
        SolverVariable r123 = r54.q(r73.Q);
    L243:
        boolean r124 = this.f1444g[0];
        DimensionBehaviour[] r74 = this.f1435b0;
        DimensionBehaviour r318 = r74[0];
        ConstraintAnchor r75 = this.Q;
        ConstraintAnchor r76 = this.S;
        int r77 = this.f1447h0;
        int r78 = this.f1461o0;
        int r410 = this.f1431J[0];
        float r79 = this.f1465q0;
        if (r74[1] != r36) goto L246;
        boolean r411 = true;
    L247:
        r316 = r12;
        r317 = r13;
        f(r54, true, r20, r19, r124, r123, r72, r318, r46, r75, r76, r77, r216, r78, r410, r79, r215, r411, r211, r210, r217, r111, r112, this.f1482z, this.A, this.B, r314);
        goto L248
    L246:
        r411 = false;
        goto L247
    L242:
        r123 = null;
        goto L243
    L238:
        r72 = null;
        goto L239
    L210:
        r216 = r212;
        goto L211
    L205:
        if ((this instanceof ConstraintWidgetContainer) == false) goto L207;
        r46 = true;
    L201:
        r313 = false;
    L193:
        r215 = true;
        goto L196
    L194:
        r43 = -1;
        goto L195
    L153:
        if (this.f1473u0 == 8) goto L187;
        if (r35 != r36) goto L157;
        if (r111 != 0) goto L157;
        r111 = 3;
    L157:
        if (r38 != r36) goto L160;
        if (r112 != 0) goto L160;
        r112 = 3;
    L160:
        if (r35 != r36) goto L166;
        if (r38 != r36) goto L166;
        int r125 = 3;
        if (r111 != 3) goto L168;
        if (r112 != 3) goto L168;
        p1(r20, r19, r37, r39);
    L186:
        r212 = r212;
    L174:
        r312 = r213;
    L175:
        r113 = true;
    L168:
        if (r35 != r36) goto L176;
        if (r111 != r125) goto L176;
        this.H = 0;
        int r80 = (int) (r110 * r32);
        if (r38 == r36) goto L173;
        r111 = 4;
        r112 = r112;
        r312 = r213;
        r113 = false;
        r212 = r80;
        goto L188
    L173:
        r212 = r80;
    L176:
        if (r38 != r36) goto L186;
        if (r112 != r125) goto L186;
        this.H = 1;
        if (r40 != (-1)) goto L181;
        this.I = 1.0f / r110;
    L181:
        int r81 = (int) (this.I * r30);
        if (r35 == r36) goto L185;
        r112 = 4;
        r312 = r81;
        r111 = r111;
        goto L184
    L185:
        r312 = r81;
        r111 = r111;
        r112 = r112;
        r212 = r212;
    L166:
        r125 = 3;
        goto L168
    L149:
        r39 = false;
        goto L150
    L145:
        r37 = false;
        goto L146
    L103:
        if (e0(0) == false) goto L106;
        ((ConstraintWidgetContainer) this.f1437c0).w1(this, 0);
        boolean r82 = true;
    L108:
        if (e0(1) == false) goto L110;
        ((ConstraintWidgetContainer) this.f1437c0).w1(this, 1);
        boolean r83 = true;
    L111:
        if (r82 == true) goto L120;
        if (r20 == false) goto L120;
        if (this.f1473u0 == 8) goto L120;
        if (this.Q.f1426f != null) goto L120;
        if (this.S.f1426f != null) goto L120;
        r54.h(r54.q(this.f1437c0.S), r12, 0, 1);
    L120:
        if (r83 == true) goto L131;
        if (r19 == false) goto L131;
        if (this.f1473u0 == 8) goto L131;
        if (this.R.f1426f != null) goto L131;
        if (this.T.f1426f != null) goto L131;
        if (this.U != null) goto L131;
        r54.h(r54.q(this.f1437c0.T), r10, 0, 1);
    L131:
        r211 = r82;
        r210 = r83;
        goto L133
    L110:
        r83 = j0();
        goto L111
    L106:
        r82 = h0();
        goto L108
    L61:
        if (this.f1464q == false) goto L64;
        this.f1462p = false;
        this.f1464q = false;
        return;
    L36:
        if (this.f1464q == false) goto L64;
    L25:
        if (this.f1475v0 == true) goto L33;
        if (a0() == true) goto L33;
        boolean[] r84 = this.f1433a0;
        if (r84[0] == true) goto L33;
        if (r84[1] == true) goto L33;
        return;
    L20:
        r19 = r17;
        r20 = false;
        goto L23
    L21:
        r20 = r16;
        r19 = false;
        goto L23
    L11:
        if (r15.f1435b0[1] != DimensionBehaviour.WRAP_CONTENT) goto L13;
        r17 = true;
        goto L14
    L6:
        if (r15.f1435b0[0] != DimensionBehaviour.WRAP_CONTENT) goto L8;
        r16 = true;
    L19:
        r20 = false;
        r19 = false;
        goto L23
    }

    public void d0(ConstraintAnchor.Type r10, ConstraintWidget r11, ConstraintAnchor.Type r12, int r13, int r14) {
        n(r10).b(r11.n(r12), r13, r14, true);
    }

    public void d1(ConstraintWidget r10) {
        this.f1437c0 = r10;
    }

    public boolean e() {
        if (this.f1473u0 == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e0(int r10) {
        int r11 = r10 * 2;
        ConstraintAnchor[] r12 = this.Y;
        ConstraintAnchor r13 = r12[r11];
        ConstraintAnchor r14 = r13.f1426f;
        if (r14 != null) goto L5;
    L11:
        return false;
    L5:
        if (r14.f1426f == r13) goto L11;
        ConstraintAnchor r15 = r12[r11 + 1];
        ConstraintAnchor r16 = r15.f1426f;
        if (r16 == null) goto L11;
        if (r16.f1426f != r15) goto L11;
        return true;
    }

    public void e1(float r10) {
        this.f1467r0 = r10;
    }

    public final void f(LinearSystem r32, boolean r33, boolean r34, boolean r35, boolean r36, SolverVariable r37, SolverVariable r38, DimensionBehaviour r39, boolean r40, ConstraintAnchor r41, ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        SolverVariable r10 = r32.q(r41);
        SolverVariable r11 = r32.q(r42);
        SolverVariable r12 = r32.q(r41.j());
        SolverVariable r13 = r32.q(r42.j());
        if (LinearSystem.x() == null) goto L5;
        LinearSystem.x().f1308w++;
    L5:
        boolean r14 = r41.o();
        boolean r15 = r42.o();
        boolean r16 = this.X.o();
        if (r15 == false) goto L8;
        int r17 = (r14 ? 1 : 0) + 1;
    L9:
        if (r16 == false) goto L11;
        r17 = r17 + 1;
    L11:
        if (r48 == false) goto L13;
        int r18 = 3;
    L14:
        int r19 = a.f1485b[r39.ordinal()];
        if (r19 != 1) goto L17;
    L22:
        int r20 = r18;
    L23:
        boolean r110 = false;
    L27:
        int r111 = this.f1454l;
        if (r111 == (-1)) goto L31;
        if (r33 == false) goto L31;
        this.f1454l = -1;
        r110 = false;
    L32:
        int r21 = this.f1456m;
        if (r21 == (-1)) goto L37;
        if (r33 == true) goto L37;
        this.f1456m = -1;
        r111 = r21;
        r110 = false;
    L37:
        if (this.f1473u0 != 8) goto L39;
        r111 = 0;
        r110 = false;
    L39:
        if (r58 == false) goto L47;
        if (r14 == true) goto L44;
        if (r15 == true) goto L44;
        if (r16 == true) goto L44;
        r32.f(r10, r43);
    L44:
        if (r14 == false) goto L47;
        if (r15 == true) goto L47;
        r32.e(r10, r12, r41.f(), 8);
    L47:
        if (r110 == true) goto L58;
        if (r40 == false) goto L55;
        r32.e(r11, r10, 0, 3);
        if (r45 <= 0) goto L53;
        r32.h(r11, r10, r45, 8);
    L53:
        if (r46 >= Integer.MAX_VALUE) goto L56;
        r32.j(r11, r10, r46, 8);
    L56:
        int r22 = r56;
        int r410 = r17;
        boolean r23 = r110;
        boolean r112 = r36;
        int r24 = r55;
    L110:
        if (r58 == false) goto L343;
        if (r50 == false) goto L113;
        int r25 = 0;
        char r26 = 2;
    L344:
        if (r410 >= r26) goto L376;
        if (r34 == false) goto L377;
        if (r112 == false) goto L378;
        r32.h(r10, r37, r25, 8);
        if (r33 == false) goto L350;
    L353:
        int r113 = 1;
    L354:
        if (r33 == true) goto L365;
        ConstraintAnchor r27 = this.U.f1426f;
        if (r27 == null) goto L365;
        ConstraintWidget r28 = r27.f1424d;
        if (r28.f1443f0 == 0.0f) goto L364;
        DimensionBehaviour[] r29 = r28.f1435b0;
        DimensionBehaviour r30 = r29[r25];
        DimensionBehaviour r31 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r30 != r31) goto L364;
        if (r29[1] != r31) goto L364;
        int r114 = 1;
    L366:
        if (r114 == 0) goto L379;
        r32.h(r38, r11, r25, 8);
        return;
    L379:
        return;
    L364:
        r114 = r25;
    L365:
        r114 = r113;
        goto L366
    L350:
        if (this.U.f1426f == null) goto L353;
        r113 = r25;
        goto L354
    L378:
        return;
    L377:
        return;
    L376:
        return;
    L113:
        if (r14 == true) goto L117;
        if (r15 == true) goto L117;
        if (r16 == true) goto L117;
        int r59 = 5;
        int r60 = 0;
    L322:
        boolean r210 = r34;
    L321:
        int r61 = r59;
    L323:
        if (r210 == false) goto L373;
        if (r112 == true) goto L326;
        return;
    L326:
        if (r42.f1426f == null) goto L328;
        int r115 = r42.f();
    L329:
        if (r13 != r38) goto L331;
        return;
    L331:
        if (this.f1450j == true) goto L333;
    L341:
        r32.h(r38, r11, r115, r61);
        return;
    L333:
        if (r11.f1319g == false) goto L341;
        ConstraintWidget r62 = this.f1437c0;
        if (r62 == null) goto L341;
        ConstraintWidgetContainer r63 = (ConstraintWidgetContainer) r62;
        if (r33 == false) goto L339;
        r63.z1(r42);
        return;
    L339:
        r63.E1(r42);
        return;
    L328:
        r115 = r60;
        goto L329
    L373:
        return;
    L117:
        if (r14 == false) goto L127;
        if (r15 == true) goto L127;
        ConstraintWidget r64 = r41.f1426f.f1424d;
        if (r34 == true) goto L122;
    L124:
        int r116 = 5;
    L125:
        r210 = r34;
        r60 = 0;
        r61 = r116;
        r11 = r11;
        goto L323
    L122:
        if ((r64 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L124;
        r116 = 8;
    L127:
        if (r14 == true) goto L144;
        if (r15 == false) goto L144;
        r32.e(r11, r13, -r42.f(), 8);
        if (r34 == true) goto L132;
    L141:
        r60 = 0;
        r59 = 5;
        goto L322
    L132:
        if (this.f1450j == true) goto L134;
    L142:
        r59 = 5;
        r32.h(r10, r37, 0, 5);
        r60 = 0;
        goto L322
    L134:
        if (r10.f1319g == false) goto L142;
        ConstraintWidget r65 = this.f1437c0;
        if (r65 == null) goto L142;
        ConstraintWidgetContainer r66 = (ConstraintWidgetContainer) r65;
        if (r33 == false) goto L140;
        r66.A1(r41);
        goto L141
    L140:
        r66.F1(r41);
    L144:
        if (r14 == false) goto L141;
        if (r15 == false) goto L141;
        ConstraintWidget r117 = r41.f1426f.f1424d;
        ConstraintWidget r67 = r42.f1426f.f1424d;
        ConstraintWidget r68 = J();
        int r118 = 6;
        if (r23 == false) goto L218;
        if (r20 != 0) goto L167;
        if (r22 != 0) goto L158;
        if (r24 != 0) goto L158;
        if (r12.f1319g == true) goto L154;
    L157:
        boolean r119 = false;
        boolean r211 = false;
        int r69 = 8;
        int r70 = 8;
        boolean r212 = true;
    L160:
        if ((r117 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L162;
    L166:
        r38 = r38;
        int r71 = r69;
        r118 = 6;
        boolean r213 = r212;
        boolean r214 = r119;
        int r120 = 4;
    L231:
        if (r211 == false) goto L235;
        if (r12 != r13) goto L235;
        if (r117 == r68) goto L235;
        r211 = false;
        boolean r215 = false;
    L236:
        if (r214 == false) goto L245;
        if (r23 == true) goto L243;
        if (r49 == true) goto L243;
        if (r51 == true) goto L243;
        if (r12 != r37) goto L243;
        if (r13 != r38) goto L243;
        r210 = false;
        int r216 = 8;
        int r217 = 8;
        boolean r218 = false;
    L244:
        int r310 = r20;
        ConstraintWidget r219 = r68;
        r32.c(r10, r12, r41.f(), r47, r13, r11, r42.f(), r217);
        r71 = r216;
        r215 = r218;
    L247:
        if (this.f1473u0 == 8) goto L249;
    L251:
        if (r211 == false) goto L261;
        if (r210 == false) goto L260;
        if (r12 == r13) goto L260;
        if (r23 == true) goto L260;
        if ((r117 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L258;
    L259:
        r71 = 6;
        goto L260
    L258:
        if ((r67 instanceof androidx.constraintlayout.core.widgets.a) == true) goto L259;
    L260:
        r32.h(r10, r12, r41.f(), r71);
        r11 = r11;
        r32.j(r11, r13, -r42.f(), r71);
    L262:
        if (r210 == false) goto L271;
        if (r52 == false) goto L271;
        if ((r117 instanceof androidx.constraintlayout.core.widgets.a) == true) goto L271;
        if ((r67 instanceof androidx.constraintlayout.core.widgets.a) == true) goto L271;
        ConstraintWidget r72 = r219;
        if (r67 == r72) goto L272;
        r71 = 6;
        int r73 = 6;
        r215 = true;
    L273:
        if (r215 == false) goto L304;
        if (r213 == false) goto L295;
        if (r51 == false) goto L277;
        if (r35 == false) goto L295;
    L277:
        if (r117 == r72) goto L281;
        if (r67 == r72) goto L281;
        int r74 = r73;
    L283:
        if ((r117 instanceof e) == false) goto L285;
    L286:
        r74 = 5;
    L288:
        if ((r117 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L290;
    L291:
        r74 = 5;
    L292:
        if (r51 == false) goto L294;
        r74 = 5;
    L294:
        r73 = Math.max(r74, r73);
        goto L295
    L290:
        if ((r67 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L292;
    L285:
        if ((r67 instanceof e) == false) goto L288;
    L281:
        r74 = 6;
    L295:
        if (r210 == false) goto L303;
        int r75 = Math.min(r71, r73);
        if (r48 == false) goto L302;
        if (r51 == true) goto L302;
        if (r117 == r72) goto L301;
        if (r67 != r72) goto L302;
    L301:
        r73 = 4;
    L302:
        r73 = r75;
    L303:
        r32.e(r10, r12, r41.f(), r73);
        r32.e(r11, r13, -r42.f(), r73);
    L304:
        if (r210 == true) goto L306;
    L311:
        if (r210 == false) goto L320;
        if (r23 == false) goto L320;
        if (r45 != 0) goto L320;
        if (r24 != 0) goto L320;
        if (r23 == true) goto L317;
    L319:
        r60 = 0;
        r59 = 5;
        r32.h(r11, r10, 0, 5);
        goto L321
    L317:
        if (r310 != 3) goto L319;
        r60 = 0;
        r32.h(r11, r10, 0, 8);
        r59 = 5;
    L320:
        r59 = 5;
        r60 = 0;
        goto L321
    L306:
        if (r37 != r12) goto L308;
        int r76 = r41.f();
    L309:
        if (r12 == r37) goto L311;
        r32.h(r10, r37, r76, 5);
        goto L311
    L308:
        r76 = 0;
    L272:
        r73 = r120;
    L271:
        r72 = r219;
        goto L272
    L261:
        r11 = r11;
        goto L262
    L249:
        if (r42.m() == true) goto L251;
        return;
    L243:
        r210 = r34;
        r217 = r118;
        r218 = r215;
        r216 = r71;
        goto L244
    L245:
        r310 = r20;
        r219 = r68;
        r210 = r34;
    L235:
        r215 = true;
        goto L236
    L162:
        if ((r67 instanceof androidx.constraintlayout.core.widgets.a) == true) goto L166;
        r213 = r212;
        r214 = r119;
        r120 = r70;
    L165:
        r71 = r69;
        r118 = 6;
        goto L231
    L154:
        if (r13.f1319g == false) goto L157;
        r32.e(r10, r12, r41.f(), 8);
        r32.e(r11, r13, -r42.f(), 8);
        return;
    L158:
        r212 = false;
        r69 = 5;
        r70 = 5;
        r119 = true;
        r211 = true;
        goto L160
    L167:
        if (r20 != 2) goto L179;
        if ((r117 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L171;
    L176:
        r71 = 5;
    L177:
        r120 = 4;
    L174:
        r214 = true;
        r211 = true;
    L175:
        r213 = false;
        goto L231
    L171:
        if ((r67 instanceof androidx.constraintlayout.core.widgets.a) == true) goto L176;
        r38 = r38;
        r118 = 6;
        r71 = 5;
        r120 = 5;
        goto L174
    L179:
        if (r20 != 1) goto L182;
        r71 = 8;
        goto L177
    L182:
        if (r20 == 3) goto L184;
        r38 = r38;
        r118 = 6;
        r71 = 5;
        r120 = 4;
        r214 = false;
        r211 = false;
        goto L175
    L184:
        if (this.H != (-1)) goto L194;
        if (r51 == false) goto L193;
        r38 = r38;
        if (r34 == false) goto L192;
        r118 = 5;
    L189:
        r71 = 8;
    L190:
        r120 = 5;
    L191:
        r214 = true;
        r211 = true;
        r213 = true;
        goto L231
    L192:
        r118 = 4;
        goto L189
    L193:
        r38 = r38;
        r118 = 8;
        goto L189
    L194:
        if (r48 == true) goto L196;
        if (r22 <= 0) goto L205;
        r38 = r38;
        r118 = 6;
        r71 = 5;
        goto L190
    L205:
        if (r22 != 0) goto L215;
        if (r24 != 0) goto L215;
        if (r51 == true) goto L209;
        r38 = r38;
        r118 = 6;
        r71 = 5;
        r120 = 8;
        goto L191
    L209:
        if (r117 == r68) goto L212;
        if (r67 == r68) goto L212;
        int r77 = 4;
    L213:
        r71 = r77;
    L214:
        r120 = 4;
    L212:
        r77 = 5;
    L215:
        r71 = 5;
        goto L214
    L196:
        if (r54 != 2) goto L198;
    L201:
        r69 = 5;
        int r78 = 4;
    L202:
        r120 = r78;
        r214 = true;
        r211 = true;
        r213 = true;
        goto L165
    L198:
        if (r54 == 1) goto L201;
        r69 = 8;
        r78 = 5;
        goto L202
    L218:
        if (r12.f1319g == false) goto L176;
        if (r13.f1319g == false) goto L176;
        r32.c(r10, r12, r41.f(), r47, r13, r11, r42.f(), 8);
        if (r34 == false) goto L369;
        if (r112 == true) goto L225;
        return;
    L225:
        if (r42.f1426f == null) goto L227;
        int r121 = r42.f();
    L228:
        if (r13 == r38) goto L371;
        r32.h(r38, r11, r121, 5);
        return;
    L371:
        return;
    L227:
        r121 = 0;
        goto L228
    L369:
        return;
    L343:
        r25 = 0;
        r26 = 2;
        goto L344
    L55:
        r32.e(r11, r10, r111, 8);
        goto L56
    L58:
        if (r17 == 2) goto L68;
        if (r48 == true) goto L68;
        if (r20 == 1) goto L63;
        if (r20 != 0) goto L68;
    L63:
        int r79 = Math.max(r55, r111);
        if (r56 <= 0) goto L66;
        r79 = Math.min(r56, r79);
    L66:
        r32.e(r11, r10, r79, 8);
        r112 = r36;
        r22 = r56;
        r410 = r17;
        r23 = false;
        r24 = r55;
    L68:
        if (r55 != (-2)) goto L70;
        int r80 = r111;
    L71:
        if (r56 != (-2)) goto L73;
        r22 = r111;
    L74:
        if (r111 <= 0) goto L79;
        if (r20 == 1) goto L79;
        r111 = 0;
    L79:
        if (r80 <= 0) goto L82;
        r32.h(r11, r10, r80, 8);
        r111 = Math.max(r111, r80);
    L82:
        if (r22 <= 0) goto L88;
        if (r34 == false) goto L86;
        if (r20 != 1) goto L86;
    L87:
        r111 = Math.min(r111, r22);
    L86:
        r32.j(r11, r10, r22, 8);
    L88:
        if (r20 != 1) goto L96;
        if (r34 == false) goto L91;
        r32.e(r11, r10, r111, 8);
    L94:
        r410 = r17;
        r23 = r110;
        r112 = r36;
        r24 = r80;
        goto L110
    L91:
        if (r50 == false) goto L93;
        r32.e(r11, r10, r111, 5);
        r32.j(r11, r10, r111, 8);
        goto L94
    L93:
        r32.e(r11, r10, r111, 5);
        r32.j(r11, r10, r111, 8);
        goto L94
    L96:
        if (r20 != 2) goto L109;
        ConstraintAnchor.Type r81 = r41.k();
        ConstraintAnchor.Type r82 = ConstraintAnchor.Type.TOP;
        if (r81 != r82) goto L100;
    L104:
        SolverVariable r83 = r32.q(this.f1437c0.n(r82));
        SolverVariable r84 = r32.q(this.f1437c0.n(ConstraintAnchor.Type.BOTTOM));
    L103:
        SolverVariable r220 = r83;
        SolverVariable r122 = r84;
        ArrayRow r85 = r32.r();
        r410 = r17 == true ? 1 : 0;
        r24 = r80;
        r32.d(r85.h(r11, r10, r122, r220, r57));
        if (r34 == false) goto L108;
        r110 = false;
    L108:
        r23 = r110;
        r112 = r36;
        goto L110
    L100:
        if (r41.k() == ConstraintAnchor.Type.BOTTOM) goto L104;
        r83 = r32.q(this.f1437c0.n(ConstraintAnchor.Type.LEFT));
        r84 = r32.q(this.f1437c0.n(ConstraintAnchor.Type.RIGHT));
        goto L103
    L109:
        r410 = r17;
        r24 = r80;
        r23 = r110;
        r112 = true;
        goto L110
    L73:
        r22 = r56;
        goto L74
    L70:
        r80 = r55;
    L31:
        r111 = r44;
        goto L32
    L17:
        if (r19 == 2) goto L22;
        if (r19 == 3) goto L22;
        if (r19 != 4) goto L22;
        r20 = r18;
        if (r20 == 4) goto L23;
        r110 = true;
        goto L27
    L13:
        r18 = r53;
        goto L14
    L8:
        r17 = r14 ? 1 : 0;
        goto L9
    }

    public boolean f0() {
        return this.f1466r;
    }

    public void f1(int r10) {
        this.K0 = r10;
    }

    public void g(ConstraintAnchor.Type r10, ConstraintWidget r11, ConstraintAnchor.Type r12) {
        h(r10, r11, r12, 0);
    }

    public boolean g0(int r10) {
        return this.f1433a0[r10];
    }

    public void g1(int r10, int r11) {
        this.f1449i0 = r10;
        int r12 = r11 - r10;
        this.f1441e0 = r12;
        int r13 = this.f1463p0;
        if (r12 >= r13) goto L6;
        this.f1441e0 = r13;
        return;
    }

    public void h(ConstraintAnchor.Type r10, ConstraintWidget r11, ConstraintAnchor.Type r12, int r13) {
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.CENTER;
        if (r10 != r14) goto L40;
        if (r12 != r14) goto L29;
        ConstraintAnchor.Type r15 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor r16 = n(r15);
        ConstraintAnchor.Type r17 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor r18 = n(r17);
        ConstraintAnchor.Type r19 = ConstraintAnchor.Type.TOP;
        ConstraintAnchor r20 = n(r19);
        ConstraintAnchor.Type r21 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor r22 = n(r21);
        boolean r23 = true;
        if (r16 != null) goto L8;
    L9:
        if (r18 != null) goto L11;
    L13:
        h(r15, r11, r15, 0);
        h(r17, r11, r17, 0);
        boolean r24 = true;
    L14:
        if (r20 != null) goto L16;
    L17:
        if (r22 != null) goto L19;
    L21:
        h(r19, r11, r19, 0);
        h(r21, r11, r21, 0);
    L22:
        if (r24 == false) goto L25;
        if (r23 == false) goto L25;
        n(r14).a(r11.n(r14), 0);
        return;
    L25:
        if (r24 == false) goto L27;
        ConstraintAnchor.Type r25 = ConstraintAnchor.Type.CENTER_X;
        n(r25).a(r11.n(r25), 0);
        return;
    L27:
        if (r23 == false) goto L97;
        ConstraintAnchor.Type r26 = ConstraintAnchor.Type.CENTER_Y;
        n(r26).a(r11.n(r26), 0);
        return;
    L97:
        return;
    L19:
        if (r22.o() == false) goto L21;
    L20:
        r23 = false;
        goto L22
    L16:
        if (r20.o() == true) goto L20;
    L11:
        if (r18.o() == false) goto L13;
    L12:
        r24 = false;
        goto L14
    L8:
        if (r16.o() == true) goto L12;
    L29:
        ConstraintAnchor.Type r27 = ConstraintAnchor.Type.LEFT;
        if (r12 != r27) goto L32;
    L39:
        h(r27, r11, r12, 0);
        h(ConstraintAnchor.Type.RIGHT, r11, r12, 0);
        n(r14).a(r11.n(r12), 0);
        return;
    L32:
        if (r12 == ConstraintAnchor.Type.RIGHT) goto L39;
        ConstraintAnchor.Type r28 = ConstraintAnchor.Type.TOP;
        if (r12 != r28) goto L37;
    L38:
        h(r28, r11, r12, 0);
        h(ConstraintAnchor.Type.BOTTOM, r11, r12, 0);
        n(r14).a(r11.n(r12), 0);
        return;
    L37:
        if (r12 == ConstraintAnchor.Type.BOTTOM) goto L38;
        return;
    L40:
        ConstraintAnchor.Type r29 = ConstraintAnchor.Type.CENTER_X;
        if (r10 != r29) goto L47;
        ConstraintAnchor.Type r30 = ConstraintAnchor.Type.LEFT;
        if (r12 != r30) goto L45;
    L46:
        ConstraintAnchor r31 = n(r30);
        ConstraintAnchor r110 = r11.n(r12);
        ConstraintAnchor r111 = n(ConstraintAnchor.Type.RIGHT);
        r31.a(r110, 0);
        r111.a(r110, 0);
        n(r29).a(r110, 0);
        return;
    L45:
        if (r12 == ConstraintAnchor.Type.RIGHT) goto L46;
    L47:
        ConstraintAnchor.Type r32 = ConstraintAnchor.Type.CENTER_Y;
        if (r10 != r32) goto L54;
        ConstraintAnchor.Type r33 = ConstraintAnchor.Type.TOP;
        if (r12 != r33) goto L52;
    L53:
        ConstraintAnchor r34 = r11.n(r12);
        n(r33).a(r34, 0);
        n(ConstraintAnchor.Type.BOTTOM).a(r34, 0);
        n(r32).a(r34, 0);
        return;
    L52:
        if (r12 == ConstraintAnchor.Type.BOTTOM) goto L53;
    L54:
        if (r10 != r29) goto L57;
        if (r12 != r29) goto L57;
        ConstraintAnchor.Type r35 = ConstraintAnchor.Type.LEFT;
        n(r35).a(r11.n(r35), 0);
        ConstraintAnchor.Type r36 = ConstraintAnchor.Type.RIGHT;
        n(r36).a(r11.n(r36), 0);
        n(r29).a(r11.n(r12), 0);
        return;
    L57:
        if (r10 != r32) goto L60;
        if (r12 != r32) goto L60;
        ConstraintAnchor.Type r37 = ConstraintAnchor.Type.TOP;
        n(r37).a(r11.n(r37), 0);
        ConstraintAnchor.Type r38 = ConstraintAnchor.Type.BOTTOM;
        n(r38).a(r11.n(r38), 0);
        n(r32).a(r11.n(r12), 0);
        return;
    L60:
        ConstraintAnchor r39 = n(r10);
        ConstraintAnchor r112 = r11.n(r12);
        if (r39.p(r112) == false) goto L106;
        ConstraintAnchor.Type r113 = ConstraintAnchor.Type.BASELINE;
        if (r10 != r113) goto L70;
        ConstraintAnchor r40 = n(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r41 = n(ConstraintAnchor.Type.BOTTOM);
        if (r40 == null) goto L67;
        r40.q();
    L67:
        if (r41 == null) goto L93;
        r41.q();
    L93:
        r39.a(r112, r13);
        return;
    L70:
        if (r10 != ConstraintAnchor.Type.TOP) goto L72;
    L84:
        ConstraintAnchor r114 = n(r113);
        if (r114 == null) goto L87;
        r114.q();
    L87:
        ConstraintAnchor r115 = n(r14);
        if (r115.j() == r112) goto L90;
        r115.q();
    L90:
        ConstraintAnchor r42 = n(r10).g();
        ConstraintAnchor r43 = n(r32);
        if (r43.o() == false) goto L93;
        r42.q();
        r43.q();
        goto L93
    L72:
        if (r10 == ConstraintAnchor.Type.BOTTOM) goto L84;
        if (r10 != ConstraintAnchor.Type.LEFT) goto L77;
    L78:
        ConstraintAnchor r116 = n(r14);
        if (r116.j() == r112) goto L81;
        r116.q();
    L81:
        ConstraintAnchor r44 = n(r10).g();
        ConstraintAnchor r45 = n(r29);
        if (r45.o() == false) goto L93;
        r44.q();
        r45.q();
        goto L93
    L77:
        if (r10 != ConstraintAnchor.Type.RIGHT) goto L93;
    }

    public boolean h0() {
        ConstraintAnchor r10 = this.Q;
        ConstraintAnchor r11 = r10.f1426f;
        if (r11 != null) goto L5;
    L6:
        ConstraintAnchor r12 = this.S;
        ConstraintAnchor r13 = r12.f1426f;
        if (r13 != null) goto L9;
        return false;
    L9:
        if (r13.f1426f != r12) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r11.f1426f != r10) goto L6;
        return true;
    }

    public void h1(DimensionBehaviour r10) {
        this.f1435b0[1] = r10;
    }

    public void i(ConstraintAnchor r10, ConstraintAnchor r11, int r12) {
        if (r10.h() != this) goto L6;
        h(r10.k(), r11.h(), r11.k(), r12);
        return;
    }

    public boolean i0() {
        return this.M;
    }

    public void i1(int r10, int r11, int r12, float r13) {
        this.f1478x = r10;
        this.C = r11;
        if (r12 != Integer.MAX_VALUE) goto L5;
        r12 = 0;
    L5:
        this.D = r12;
        this.E = r13;
        if (r13 > 0.0f) goto L8;
        return;
    L8:
        if (r13 >= 1.0f) goto L13;
        if (r10 != 0) goto L14;
        this.f1478x = 2;
        return;
    L14:
        return;
    }

    public void j(ConstraintWidget r10, float r11, int r12) {
        ConstraintAnchor.Type r13 = ConstraintAnchor.Type.CENTER;
        d0(r13, r10, r13, r12, 0);
        this.K = r11;
    }

    public boolean j0() {
        ConstraintAnchor r10 = this.R;
        ConstraintAnchor r11 = r10.f1426f;
        if (r11 != null) goto L5;
    L6:
        ConstraintAnchor r12 = this.T;
        ConstraintAnchor r13 = r12.f1426f;
        if (r13 != null) goto L9;
        return false;
    L9:
        if (r13.f1426f != r12) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r11.f1426f != r10) goto L6;
        return true;
    }

    public void j1(float r10) {
        this.N0[1] = r10;
    }

    public void k(ConstraintWidget r10, HashMap r11) {
        this.f1470t = r10.f1470t;
        this.f1472u = r10.f1472u;
        this.f1476w = r10.f1476w;
        this.f1478x = r10.f1478x;
        int[] r12 = this.f1480y;
        int[] r13 = r10.f1480y;
        r12[0] = r13[0];
        r12[1] = r13[1];
        this.f1482z = r10.f1482z;
        this.A = r10.A;
        this.C = r10.C;
        this.D = r10.D;
        this.E = r10.E;
        this.F = r10.F;
        this.G = r10.G;
        this.H = r10.H;
        this.I = r10.I;
        int[] r14 = r10.f1431J;
        this.f1431J = Arrays.copyOf(r14, r14.length);
        this.K = r10.K;
        this.L = r10.L;
        this.M = r10.M;
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.f1435b0 = (DimensionBehaviour[]) Arrays.copyOf(this.f1435b0, 2);
        ConstraintWidget r15 = null;
        if (this.f1437c0 != null) goto L5;
        ConstraintWidget r16 = null;
    L6:
        this.f1437c0 = r16;
        this.f1439d0 = r10.f1439d0;
        this.f1441e0 = r10.f1441e0;
        this.f1443f0 = r10.f1443f0;
        this.f1445g0 = r10.f1445g0;
        this.f1447h0 = r10.f1447h0;
        this.f1449i0 = r10.f1449i0;
        this.f1451j0 = r10.f1451j0;
        this.f1453k0 = r10.f1453k0;
        this.f1455l0 = r10.f1455l0;
        this.f1457m0 = r10.f1457m0;
        this.f1459n0 = r10.f1459n0;
        this.f1461o0 = r10.f1461o0;
        this.f1463p0 = r10.f1463p0;
        this.f1465q0 = r10.f1465q0;
        this.f1467r0 = r10.f1467r0;
        this.f1469s0 = r10.f1469s0;
        this.f1471t0 = r10.f1471t0;
        this.f1473u0 = r10.f1473u0;
        this.f1475v0 = r10.f1475v0;
        this.f1477w0 = r10.f1477w0;
        this.f1479x0 = r10.f1479x0;
        this.f1481y0 = r10.f1481y0;
        this.f1483z0 = r10.f1483z0;
        this.A0 = r10.A0;
        this.B0 = r10.B0;
        this.C0 = r10.C0;
        this.D0 = r10.D0;
        this.E0 = r10.E0;
        this.F0 = r10.F0;
        this.G0 = r10.G0;
        this.H0 = r10.H0;
        this.J0 = r10.J0;
        this.K0 = r10.K0;
        this.L0 = r10.L0;
        this.M0 = r10.M0;
        float[] r17 = this.N0;
        float[] r18 = r10.N0;
        r17[0] = r18[0];
        r17[1] = r18[1];
        ConstraintWidget[] r19 = this.O0;
        ConstraintWidget[] r20 = r10.O0;
        r19[0] = r20[0];
        r19[1] = r20[1];
        ConstraintWidget[] r21 = this.P0;
        ConstraintWidget[] r22 = r10.P0;
        r21[0] = r22[0];
        r21[1] = r22[1];
        ConstraintWidget r23 = r10.Q0;
        if (r23 != null) goto L9;
        ConstraintWidget r24 = null;
    L10:
        this.Q0 = r24;
        ConstraintWidget r25 = r10.R0;
        if (r25 == null) goto L14;
        r15 = (ConstraintWidget) r11.get(r25);
    L14:
        this.R0 = r15;
        return;
    L9:
        r24 = (ConstraintWidget) r11.get(r23);
        goto L10
    L5:
        r16 = (ConstraintWidget) r11.get(r10.f1437c0);
        goto L6
    }

    public boolean k0() {
        return this.N;
    }

    public void k1(int r10) {
        this.f1473u0 = r10;
    }

    public void l(LinearSystem r10) {
        r10.q(this.Q);
        r10.q(this.R);
        r10.q(this.S);
        r10.q(this.T);
        if (this.f1459n0 <= 0) goto L6;
        r10.q(this.U);
        return;
    }

    public boolean l0() {
        if (this.f1448i == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f1473u0 == 8) goto L7;
        return true;
    }

    public void l1(int r10) {
        this.f1439d0 = r10;
        int r11 = this.f1461o0;
        if (r10 >= r11) goto L6;
        this.f1439d0 = r11;
        return;
    }

    public void m() {
        if (this.f1440e != null) goto L6;
        this.f1440e = new i(this);
    L6:
        if (this.f1442f != null) goto L9;
        this.f1442f = new k(this);
        return;
    }

    public boolean m0() {
        if (this.f1462p == false) goto L5;
    L10:
        return true;
    L5:
        if (this.Q.n() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.S.n() == false) goto L9;
        goto L9
    }

    public void m1(int r10) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 > 3) goto L8;
        this.f1474v = r10;
        return;
    }

    public ConstraintAnchor n(ConstraintAnchor.Type r10) {
        switch(a.f1484a[r10.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new AssertionError(r10.name());
    L9:
        return this.W;
    L11:
        return this.V;
    L13:
        return this.X;
    L15:
        return this.U;
    L17:
        return this.T;
    L19:
        return this.S;
    L21:
        return this.R;
    L23:
        return this.Q;
    }

    public boolean n0() {
        if (this.f1464q == false) goto L5;
    L10:
        return true;
    L5:
        if (this.R.n() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.T.n() == false) goto L9;
        goto L9
    }

    public void n1(int r10) {
        this.f1447h0 = r10;
    }

    public int o() {
        return this.f1459n0;
    }

    public boolean o0() {
        return this.f1468s;
    }

    public void o1(int r10) {
        this.f1449i0 = r10;
    }

    public float p(int r10) {
        if (r10 != 0) goto L6;
        return this.f1465q0;
    L6:
        if (r10 == 1) goto L8;
        return -1.0f;
    L8:
        return this.f1467r0;
    }

    public void p0() {
        this.f1466r = true;
    }

    public void p1(boolean r10, boolean r11, boolean r12, boolean r13) {
        if (this.H != (-1)) goto L13;
        if (r12 == false) goto L7;
        if (r13 == true) goto L7;
        this.H = 0;
    L7:
        if (r12 == true) goto L13;
        if (r13 == false) goto L13;
        this.H = 1;
        if (this.f1445g0 != (-1)) goto L13;
        this.I = 1.0f / this.I;
    L13:
        if (this.H != 0) goto L20;
        if (this.R.o() == true) goto L17;
    L18:
        this.H = 1;
    L27:
        if (this.H != (-1)) goto L47;
        if (this.R.o() == false) goto L37;
        if (this.T.o() == false) goto L37;
        if (this.Q.o() == false) goto L37;
        if (this.S.o() == true) goto L47;
    L37:
        if (this.R.o() == false) goto L42;
        if (this.T.o() == false) goto L42;
        this.H = 0;
    L42:
        if (this.Q.o() == false) goto L47;
        if (this.S.o() == false) goto L47;
        this.I = 1.0f / this.I;
        this.H = 1;
    L47:
        if (this.H != (-1)) goto L58;
        int r14 = this.f1482z;
        if (r14 > 0) goto L51;
    L53:
        if (r14 == 0) goto L55;
        return;
    L55:
        if (this.C <= 0) goto L61;
        this.I = 1.0f / this.I;
        this.H = 1;
        return;
    L61:
        return;
    L51:
        if (this.C != 0) goto L53;
        this.H = 0;
        return;
    L58:
        return;
    L17:
        if (this.T.o() == false) goto L18;
    L20:
        if (this.H != 1) goto L27;
        if (this.Q.o() == true) goto L24;
    L25:
        this.H = 0;
        goto L27
    L24:
        if (this.S.o() == true) goto L27;
        goto L25
    }

    public int q() {
        return X() + this.f1441e0;
    }

    public void q0() {
        this.f1468s = true;
    }

    public void q1(boolean r10, boolean r11) {
        boolean r12 = r10 & this.f1440e.j();
        boolean r13 = r11 & this.f1442f.j();
        i r14 = this.f1440e;
        int r15 = r14.f1548h.f1535g;
        k r16 = this.f1442f;
        int r17 = r16.f1548h.f1535g;
        int r18 = r14.f1549i.f1535g;
        int r19 = r16.f1549i.f1535g;
        int r20 = r19 - r17;
        if ((r18 - r15) < 0) goto L15;
        if (r20 < 0) goto L15;
        if (r15 == Integer.MIN_VALUE) goto L15;
        if (r15 == Integer.MAX_VALUE) goto L15;
        if (r17 == Integer.MIN_VALUE) goto L15;
        if (r17 == Integer.MAX_VALUE) goto L15;
        if (r18 == Integer.MIN_VALUE) goto L15;
        if (r18 == Integer.MAX_VALUE) goto L15;
        if (r19 == Integer.MIN_VALUE) goto L15;
        if (r19 == Integer.MAX_VALUE) goto L15;
    L16:
        int r21 = r18 - r15;
        int r22 = r19 - r17;
        if (r12 == false) goto L19;
        this.f1447h0 = r15;
    L19:
        if (r13 == false) goto L22;
        this.f1449i0 = r17;
    L22:
        if (this.f1473u0 != 8) goto L25;
        this.f1439d0 = 0;
        this.f1441e0 = 0;
        return;
    L25:
        if (r12 == true) goto L27;
    L34:
        if (r13 == true) goto L36;
        return;
    L36:
        if (this.f1435b0[1] != DimensionBehaviour.FIXED) goto L40;
        int r23 = this.f1441e0;
        if (r22 >= r23) goto L40;
        r22 = r23;
    L40:
        this.f1441e0 = r22;
        int r24 = this.f1463p0;
        if (r22 >= r24) goto L45;
        this.f1441e0 = r24;
        return;
    L45:
        return;
    L27:
        if (this.f1435b0[0] != DimensionBehaviour.FIXED) goto L31;
        int r25 = this.f1439d0;
        if (r21 >= r25) goto L31;
        r21 = r25;
    L31:
        this.f1439d0 = r21;
        int r26 = this.f1461o0;
        if (r21 >= r26) goto L34;
        this.f1439d0 = r26;
    L15:
        r18 = 0;
        r15 = 0;
        r19 = 0;
        r17 = 0;
        goto L16
    }

    public Object r() {
        return this.f1469s0;
    }

    public boolean r0() {
        DimensionBehaviour[] r10 = this.f1435b0;
        DimensionBehaviour r11 = r10[0];
        DimensionBehaviour r12 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r11 == r12) goto L5;
        return false;
    L5:
        if (r10[1] == r12) goto L7;
        return false;
    L7:
        return true;
    }

    public void r1(LinearSystem r10, boolean r11) {
        int r12 = r10.y(this.Q);
        int r13 = r10.y(this.R);
        int r14 = r10.y(this.S);
        int r15 = r10.y(this.T);
        if (r11 == false) goto L11;
        i r16 = this.f1440e;
        if (r16 == null) goto L11;
        DependencyNode r17 = r16.f1548h;
        if (r17.f1538j == false) goto L11;
        DependencyNode r18 = r16.f1549i;
        if (r18.f1538j == false) goto L11;
        r12 = r17.f1535g;
        r14 = r18.f1535g;
    L11:
        if (r11 == false) goto L19;
        k r19 = this.f1442f;
        if (r19 == null) goto L19;
        DependencyNode r20 = r19.f1548h;
        if (r20.f1538j == false) goto L19;
        DependencyNode r21 = r19.f1549i;
        if (r21.f1538j == false) goto L19;
        r13 = r20.f1535g;
        r15 = r21.f1535g;
    L19:
        int r22 = r15 - r13;
        if ((r14 - r12) < 0) goto L32;
        if (r22 < 0) goto L32;
        if (r12 == Integer.MIN_VALUE) goto L32;
        if (r12 == Integer.MAX_VALUE) goto L32;
        if (r13 == Integer.MIN_VALUE) goto L32;
        if (r13 == Integer.MAX_VALUE) goto L32;
        if (r14 == Integer.MIN_VALUE) goto L32;
        if (r14 == Integer.MAX_VALUE) goto L32;
        if (r15 == Integer.MIN_VALUE) goto L32;
        if (r15 == Integer.MAX_VALUE) goto L32;
    L33:
        K0(r12, r13, r14, r15);
        return;
    L32:
        r12 = 0;
        r15 = 0;
        r13 = 0;
        r14 = 0;
        goto L33
    }

    public String s() {
        return this.f1477w0;
    }

    public void s0() {
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.f1437c0 = null;
        this.K = 0.0f;
        this.f1439d0 = 0;
        this.f1441e0 = 0;
        this.f1443f0 = 0.0f;
        this.f1445g0 = -1;
        this.f1447h0 = 0;
        this.f1449i0 = 0;
        this.f1455l0 = 0;
        this.f1457m0 = 0;
        this.f1459n0 = 0;
        this.f1461o0 = 0;
        this.f1463p0 = 0;
        float r10 = U0;
        this.f1465q0 = r10;
        this.f1467r0 = r10;
        DimensionBehaviour[] r11 = this.f1435b0;
        DimensionBehaviour r12 = DimensionBehaviour.FIXED;
        r11[0] = r12;
        r11[1] = r12;
        this.f1469s0 = null;
        this.f1471t0 = 0;
        this.f1473u0 = 0;
        this.f1479x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] r13 = this.N0;
        r13[0] = -1.0f;
        r13[1] = -1.0f;
        this.f1470t = -1;
        this.f1472u = -1;
        int[] r14 = this.f1431J;
        r14[0] = Integer.MAX_VALUE;
        r14[1] = Integer.MAX_VALUE;
        this.f1476w = 0;
        this.f1478x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Channel.UNLIMITED;
        this.D = Channel.UNLIMITED;
        this.f1482z = 0;
        this.C = 0;
        this.f1446h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] r15 = this.f1444g;
        r15[0] = true;
        r15[1] = true;
        this.N = false;
        boolean[] r16 = this.f1433a0;
        r16[0] = false;
        r16[1] = false;
        this.f1448i = true;
        int[] r17 = this.f1480y;
        r17[0] = 0;
        r17[1] = 0;
        this.f1454l = -1;
        this.f1456m = -1;
    }

    public DimensionBehaviour t(int r10) {
        if (r10 != 0) goto L6;
        return z();
    L6:
        if (r10 == 1) goto L8;
        return null;
    L8:
        return S();
    }

    public void t0() {
        u0();
        e1(U0);
        N0(U0);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        String r11 = "";
        if (this.f1479x0 == null) goto L5;
        String r12 = "type: " + this.f1479x0 + " ";
    L6:
        r10.append(r12);
        if (this.f1477w0 == null) goto L9;
        r11 = "id: " + this.f1477w0 + " ";
    L9:
        r10.append(r11);
        r10.append("(");
        r10.append(this.f1447h0);
        r10.append(", ");
        r10.append(this.f1449i0);
        r10.append(") - (");
        r10.append(this.f1439d0);
        r10.append(" x ");
        r10.append(this.f1441e0);
        r10.append(")");
        return r10.toString();
    L5:
        r12 = "";
        goto L6
    }

    public float u() {
        return this.f1443f0;
    }

    public void u0() {
        ConstraintWidget r10 = J();
        if (r10 != null) goto L5;
    L9:
        int r11 = this.Z.size();
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L12;
        ((ConstraintAnchor) this.Z.get(r12)).q();
        r12 = r12 + 1;
        goto L10
    L12:
        return;
    L5:
        if ((r10 instanceof ConstraintWidgetContainer) == false) goto L9;
        if (((ConstraintWidgetContainer) J()).N1() == false) goto L9;
    }

    public int v() {
        return this.f1445g0;
    }

    public void v0() {
        int r10 = 0;
        this.f1462p = false;
        this.f1464q = false;
        this.f1466r = false;
        this.f1468s = false;
        int r11 = this.Z.size();
    L3:
        if (r10 >= r11) goto L5;
        ((ConstraintAnchor) this.Z.get(r10)).r();
        r10 = r10 + 1;
        goto L3
    }

    public int w() {
        if (this.f1473u0 != 8) goto L7;
        return 0;
    L7:
        return this.f1441e0;
    }

    public void w0(androidx.constraintlayout.core.b r10) {
        this.Q.s(r10);
        this.R.s(r10);
        this.S.s(r10);
        this.T.s(r10);
        this.U.s(r10);
        this.X.s(r10);
        this.V.s(r10);
        this.W.s(r10);
    }

    public float x() {
        return this.f1465q0;
    }

    public final void x0(StringBuilder r10, String r11, float r12, float r13) {
        if (r12 != r13) goto L5;
        return;
    L5:
        r10.append(r11);
        r10.append(" :   ");
        r10.append(r12);
        r10.append(",\n");
    }

    public int y() {
        return this.J0;
    }

    public final void y0(StringBuilder r10, String r11, int r12, int r13) {
        if (r12 != r13) goto L4;
        return;
    L4:
        r10.append(r11);
        r10.append(" :   ");
        r10.append(r12);
        r10.append(",\n");
    }

    public DimensionBehaviour z() {
        return this.f1435b0[0];
    }

    public final void z0(StringBuilder r10, String r11, float r12, int r13) {
        if (r12 != 0.0f) goto L5;
        return;
    L5:
        r10.append(r11);
        r10.append(" :  [");
        r10.append(r12);
        r10.append(",");
        r10.append(r13);
        r10.append("");
        r10.append("],\n");
    }
}
