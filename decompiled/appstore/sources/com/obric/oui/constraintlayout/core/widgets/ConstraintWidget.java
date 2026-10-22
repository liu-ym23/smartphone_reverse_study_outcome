package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.ArrayRow;
import com.obric.oui.constraintlayout.core.LinearSystem;
import com.obric.oui.constraintlayout.core.SolverVariable;
import com.obric.oui.constraintlayout.core.widgets.analyzer.DependencyNode;
import com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.obric.oui.constraintlayout.core.widgets.analyzer.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
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
    public int[] f13250J;
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
    public boolean f13251a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean[] f13252a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WidgetRun[] f13253b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public DimensionBehaviour[] f13254b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.analyzer.b f13255c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ConstraintWidget f13256c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.analyzer.b f13257d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f13258d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.analyzer.i f13259e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f13260e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f13261f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f13262f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean[] f13263g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f13264g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13265h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f13266h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13267i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f13268i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13269j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f13270j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13271k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f13272k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13273l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f13274l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13275m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f13276m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.state.a f13277n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f13278n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f13279o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f13280o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f13281p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f13282p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13283q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f13284q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13285r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f13286r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f13287s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public Object f13288s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13289t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f13290t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13291u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f13292u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13293v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f13294v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13295w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public String f13296w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13297x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f13298x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f13299y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f13300y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13301z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f13302z0;

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
        public static final /* synthetic */ int[] f13303a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13304b = null;

        static {
            int[] r10 = new int[DimensionBehaviour.values().length];
            f13304b = r10;
            r10[DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            f13304b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L46:
            f13304b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L58:
            f13304b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            int[] r11 = new int[ConstraintAnchor.Type.values().length];
            f13303a = r11;
            r11[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L38:
            f13303a[ConstraintAnchor.Type.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L44:
            f13303a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L52:
            f13303a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L34:
            f13303a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L42:
            f13303a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L56:
            f13303a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L40:
            f13303a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            f13303a[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    static {
    }

    public ConstraintWidget() {
        this.f13251a = false;
        this.f13253b = new WidgetRun[2];
        this.f13259e = null;
        this.f13261f = null;
        this.f13263g = new boolean[]{true, true};
        this.f13265h = false;
        this.f13267i = true;
        this.f13269j = false;
        this.f13271k = true;
        this.f13273l = -1;
        this.f13275m = -1;
        this.f13277n = new com.obric.oui.constraintlayout.core.state.a(this);
        this.f13281p = false;
        this.f13283q = false;
        this.f13285r = false;
        this.f13287s = false;
        this.f13289t = -1;
        this.f13291u = -1;
        this.f13293v = 0;
        this.f13295w = 0;
        this.f13297x = 0;
        this.f13299y = new int[2];
        this.f13301z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.f13250J = new int[]{Channel.UNLIMITED, Channel.UNLIMITED};
        this.K = Float.NaN;
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
        ConstraintAnchor r11 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = r11;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, r11};
        this.Z = new ArrayList();
        this.f13252a0 = new boolean[2];
        DimensionBehaviour r10 = DimensionBehaviour.FIXED;
        this.f13254b0 = new DimensionBehaviour[]{r10, r10};
        this.f13256c0 = null;
        this.f13258d0 = 0;
        this.f13260e0 = 0;
        this.f13262f0 = 0.0f;
        this.f13264g0 = -1;
        this.f13266h0 = 0;
        this.f13268i0 = 0;
        this.f13270j0 = 0;
        this.f13272k0 = 0;
        this.f13274l0 = 0;
        this.f13276m0 = 0;
        this.f13278n0 = 0;
        float r12 = U0;
        this.f13284q0 = r12;
        this.f13286r0 = r12;
        this.f13290t0 = 0;
        this.f13292u0 = 0;
        this.f13294v0 = false;
        this.f13296w0 = null;
        this.f13298x0 = null;
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
        int r11 = r10.f13246g;
    L6:
        ConstraintAnchor r12 = this.S;
        if (r12 != null) goto L9;
        return r11;
    L9:
        return r11 + r12.f13246g;
    L5:
        r11 = 0;
        goto L6
    }

    public final void A0(StringBuilder r10, String r11, float r12, int r13) {
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

    public int B() {
        return this.O;
    }

    public void B0(boolean r10) {
        this.f13294v0 = r10;
    }

    public int C() {
        return this.P;
    }

    public void C0(int r10) {
        this.f13278n0 = r10;
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        this.L = r11;
        return;
    L5:
        r11 = false;
        goto L6
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

    public void D0(Object r10) {
        this.f13288s0 = r10;
    }

    public int E() {
        return this.f13250J[1];
    }

    public void E0(String r10) {
        this.f13296w0 = r10;
    }

    public int F() {
        return this.f13250J[0];
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    public void F0(String r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
    L44:
        this.f13262f0 = 0.0f;
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
        this.f13262f0 = r18;
        this.f13264g0 = r15;
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

    public int G() {
        return this.f13282p0;
    }

    public void G0(int r10) {
        if (this.L == true) goto L5;
        return;
    L5:
        int r11 = r10 - this.f13278n0;
        int r12 = this.f13260e0 + r11;
        this.f13268i0 = r11;
        this.R.t(r11);
        this.T.t(r12);
        this.U.t(r10);
        this.f13283q = true;
    }

    public int H() {
        return this.f13280o0;
    }

    public void H0(int r10, int r11) {
        if (this.f13281p == false) goto L5;
        return;
    L5:
        this.Q.t(r10);
        this.S.t(r11);
        this.f13266h0 = r10;
        this.f13258d0 = r11 - r10;
        this.f13281p = true;
    }

    public ConstraintWidget I(int r10) {
        if (r10 != 0) goto L10;
        ConstraintAnchor r11 = this.S;
        ConstraintAnchor r12 = r11.f13245f;
        if (r12 != null) goto L6;
        return null;
    L6:
        if (r12.f13245f == r11) goto L8;
        return null;
    L8:
        return r12.f13243d;
    L10:
        if (r10 != 1) goto L20;
        ConstraintAnchor r13 = this.T;
        ConstraintAnchor r14 = r13.f13245f;
        if (r14 != null) goto L14;
        return null;
    L14:
        if (r14.f13245f == r13) goto L16;
        return null;
    L16:
        return r14.f13243d;
    L20:
        return null;
    }

    public void I0(int r10) {
        this.Q.t(r10);
        this.f13266h0 = r10;
    }

    public ConstraintWidget J() {
        return this.f13256c0;
    }

    public void J0(int r10) {
        this.R.t(r10);
        this.f13268i0 = r10;
    }

    public ConstraintWidget K(int r10) {
        if (r10 != 0) goto L10;
        ConstraintAnchor r11 = this.Q;
        ConstraintAnchor r12 = r11.f13245f;
        if (r12 != null) goto L6;
        return null;
    L6:
        if (r12.f13245f == r11) goto L8;
        return null;
    L8:
        return r12.f13243d;
    L10:
        if (r10 != 1) goto L20;
        ConstraintAnchor r13 = this.R;
        ConstraintAnchor r14 = r13.f13245f;
        if (r14 != null) goto L14;
        return null;
    L14:
        if (r14.f13245f == r13) goto L16;
        return null;
    L16:
        return r14.f13243d;
    L20:
        return null;
    }

    public void K0(int r10, int r11) {
        if (this.f13283q == false) goto L5;
        return;
    L5:
        this.R.t(r10);
        this.T.t(r11);
        this.f13268i0 = r10;
        this.f13260e0 = r11 - r10;
        if (this.L == false) goto L8;
        this.U.t(r10 + this.f13278n0);
    L8:
        this.f13283q = true;
    }

    public int L() {
        return W() + this.f13258d0;
    }

    public void L0(int r10, int r11, int r12, int r13) {
        int r14 = r12 - r10;
        int r15 = r13 - r11;
        this.f13266h0 = r10;
        this.f13268i0 = r11;
        if (this.f13292u0 != 8) goto L6;
        this.f13258d0 = 0;
        this.f13260e0 = 0;
        return;
    L6:
        DimensionBehaviour[] r16 = this.f13254b0;
        DimensionBehaviour r17 = r16[0];
        DimensionBehaviour r18 = DimensionBehaviour.FIXED;
        if (r17 != r18) goto L12;
        int r19 = this.f13258d0;
        if (r14 >= r19) goto L12;
        r14 = r19;
    L12:
        if (r16[1] != r18) goto L16;
        int r20 = this.f13260e0;
        if (r15 >= r20) goto L16;
        r15 = r20;
    L16:
        this.f13258d0 = r14;
        this.f13260e0 = r15;
        int r21 = this.f13282p0;
        if (r15 >= r21) goto L19;
        this.f13260e0 = r21;
    L19:
        int r22 = this.f13280o0;
        if (r14 >= r22) goto L22;
        this.f13258d0 = r22;
    L22:
        int r23 = this.A;
        if (r23 > 0) goto L25;
    L27:
        int r24 = this.D;
        if (r24 > 0) goto L30;
    L32:
        int r25 = this.f13258d0;
        if (r14 == r25) goto L35;
        this.f13273l = r25;
    L35:
        int r26 = this.f13260e0;
        if (r15 == r26) goto L39;
        this.f13275m = r26;
        return;
    L39:
        return;
    L30:
        if (this.f13254b0[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        this.f13260e0 = Math.min(this.f13260e0, r24);
        goto L32
    L25:
        if (r17 != DimensionBehaviour.MATCH_CONSTRAINT) goto L27;
        this.f13258d0 = Math.min(this.f13258d0, r23);
        goto L27
    }

    public WidgetRun M(int r10) {
        if (r10 != 0) goto L6;
        return this.f13259e;
    L6:
        if (r10 == 1) goto L8;
        return null;
    L8:
        return this.f13261f;
    }

    public void M0(boolean r10) {
        this.L = r10;
    }

    public void N(StringBuilder r16) {
        r16.append("  " + this.f13279o + ":{\n");
        StringBuilder r10 = new StringBuilder();
        r10.append("    actualWidth:");
        r10.append(this.f13258d0);
        r16.append(r10.toString());
        r16.append("\n");
        r16.append("    actualHeight:" + this.f13260e0);
        r16.append("\n");
        r16.append("    actualLeft:" + this.f13266h0);
        r16.append("\n");
        r16.append("    actualTop:" + this.f13268i0);
        r16.append("\n");
        P(r16, "left", this.Q);
        P(r16, "top", this.R);
        P(r16, "right", this.S);
        P(r16, "bottom", this.T);
        P(r16, "baseline", this.U);
        P(r16, "centerX", this.V);
        P(r16, "centerY", this.W);
        O(r16, "    width", this.f13258d0, this.f13280o0, this.f13250J[0], this.f13273l, this.f13301z, this.f13295w, this.B, this.f13254b0[0], this.N0[0]);
        O(r16, "    height", this.f13260e0, this.f13282p0, this.f13250J[1], this.f13275m, this.C, this.f13297x, this.E, this.f13254b0[1], this.N0[1]);
        A0(r16, "    dimensionRatio", this.f13262f0, this.f13264g0);
        x0(r16, "    horizontalBias", this.f13284q0, U0);
        x0(r16, "    verticalBias", this.f13286r0, U0);
        y0(r16, "    horizontalChainStyle", this.J0, 0);
        y0(r16, "    verticalChainStyle", this.K0, 0);
        r16.append("  }");
    }

    public void N0(int r10) {
        this.f13260e0 = r10;
        int r11 = this.f13282p0;
        if (r10 >= r11) goto L6;
        this.f13260e0 = r11;
        return;
    }

    public final void O(StringBuilder r10, String r11, int r12, int r13, int r14, int r15, int r16, int r17, float r18, DimensionBehaviour r19, float r110) {
        r10.append(r11);
        r10.append(" :  {\n");
        z0(r10, "      behavior", r19.toString(), DimensionBehaviour.FIXED.toString());
        y0(r10, "      size", r12, 0);
        y0(r10, "      min", r13, 0);
        y0(r10, "      max", r14, Channel.UNLIMITED);
        y0(r10, "      matchMin", r16, 0);
        y0(r10, "      matchDef", r17, 0);
        x0(r10, "      matchPercent", r18, 1.0f);
        r10.append("    },\n");
    }

    public void O0(float r10) {
        this.f13284q0 = r10;
    }

    public final void P(StringBuilder r10, String r11, ConstraintAnchor r12) {
        if (r12.f13245f != null) goto L5;
        return;
    L5:
        r10.append("    ");
        r10.append(r11);
        r10.append(" : [ '");
        r10.append(r12.f13245f);
        r10.append("'");
        if (r12.f13247h == Integer.MIN_VALUE) goto L8;
    L9:
        r10.append(",");
        r10.append(r12.f13246g);
        if (r12.f13247h == Integer.MIN_VALUE) goto L12;
        r10.append(",");
        r10.append(r12.f13247h);
        r10.append(",");
    L12:
        r10.append(" ] ,\n");
        return;
    L8:
        if (r12.f13246g == 0) goto L12;
        goto L9
    }

    public void P0(int r10) {
        this.J0 = r10;
    }

    public float Q() {
        return this.f13286r0;
    }

    public void Q0(int r10, int r11) {
        this.f13266h0 = r10;
        int r12 = r11 - r10;
        this.f13258d0 = r12;
        int r13 = this.f13280o0;
        if (r12 >= r13) goto L6;
        this.f13258d0 = r13;
        return;
    }

    public int R() {
        return this.K0;
    }

    public void R0(DimensionBehaviour r10) {
        this.f13254b0[0] = r10;
    }

    public DimensionBehaviour S() {
        return this.f13254b0[1];
    }

    public void S0(int r10, int r11, int r12, float r13) {
        this.f13295w = r10;
        this.f13301z = r11;
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
        this.f13295w = 2;
        return;
    L14:
        return;
    }

    public int T() {
        if (this.Q == null) goto L5;
        int r10 = this.R.f13246g;
    L7:
        if (this.S != null) goto L9;
        return r10;
    L9:
        return r10 + this.T.f13246g;
    L5:
        r10 = 0;
        goto L7
    }

    public void T0(float r10) {
        this.N0[0] = r10;
    }

    public int U() {
        return this.f13292u0;
    }

    public void U0(int r10, boolean r11) {
        this.f13252a0[r10] = r11;
    }

    public int V() {
        if (this.f13292u0 != 8) goto L7;
        return 0;
    L7:
        return this.f13258d0;
    }

    public void V0(boolean r10) {
        this.M = r10;
    }

    public int W() {
        ConstraintWidget r10 = this.f13256c0;
        if (r10 == null) goto L9;
        if ((r10 instanceof d) == false) goto L9;
        return ((d) r10).f13411c1 + this.f13266h0;
    L9:
        return this.f13266h0;
    }

    public void W0(boolean r10) {
        this.N = r10;
    }

    public int X() {
        ConstraintWidget r10 = this.f13256c0;
        if (r10 == null) goto L9;
        if ((r10 instanceof d) == false) goto L9;
        return ((d) r10).f13412d1 + this.f13268i0;
    L9:
        return this.f13268i0;
    }

    public void X0(int r10, int r11) {
        this.O = r10;
        this.P = r11;
        a1(false);
    }

    public boolean Y() {
        return this.L;
    }

    public void Y0(int r10) {
        this.f13250J[1] = r10;
    }

    public boolean Z(int r10) {
        if (r10 != 0) goto L17;
        if (this.Q.f13245f == null) goto L7;
        int r11 = 1;
    L9:
        if (this.S.f13245f == null) goto L11;
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
        if (this.R.f13245f == null) goto L19;
        int r13 = 1;
    L21:
        if (this.T.f13245f == null) goto L23;
        int r14 = 1;
    L24:
        int r15 = r13 + r14;
        if (this.U.f13245f == null) goto L27;
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

    public void Z0(int r10) {
        this.f13250J[0] = r10;
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

    public void a1(boolean r10) {
        this.f13267i = r10;
    }

    public void b(d r10, LinearSystem r11, HashSet r12, int r13, boolean r14) {
        if (r14 == true) goto L4;
    L7:
        if (r13 != 0) goto L20;
        HashSet r15 = this.Q.d();
        if (r15 == null) goto L14;
        Iterator r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        ((ConstraintAnchor) r16.next()).f13243d.b(r10, r11, r12, r13, true);
    L14:
        HashSet r17 = this.S.d();
        if (r17 == null) goto L38;
        Iterator r18 = r17.iterator();
    L18:
        if (r18.hasNext() == false) goto L45;
        ((ConstraintAnchor) r18.next()).f13243d.b(r10, r11, r12, r13, true);
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
        ((ConstraintAnchor) r110.next()).f13243d.b(r10, r11, r12, r13, true);
    L26:
        HashSet r111 = this.T.d();
        if (r111 == null) goto L32;
        Iterator r112 = r111.iterator();
    L30:
        if (r112.hasNext() == false) goto L32;
        ((ConstraintAnchor) r112.next()).f13243d.b(r10, r11, r12, r13, true);
    L32:
        HashSet r20 = this.U.d();
        if (r20 == null) goto L44;
        Iterator r21 = r20.iterator();
    L36:
        if (r21.hasNext() == false) goto L46;
        ((ConstraintAnchor) r21.next()).f13243d.b(r10, r11, r12, r13, true);
        goto L36
    L46:
        return;
    L44:
        return;
    L4:
        if (r12.contains(this) == true) goto L6;
        return;
    L6:
        g.a(r10, r11, this);
        r12.remove(this);
        d(r11, r10.W1(64));
        goto L7
    }

    public boolean b0() {
        if (this.f13273l == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (this.f13275m != (-1)) goto L8;
        return false;
    }

    public void b1(int r10) {
        if (r10 >= 0) goto L4;
        this.f13282p0 = 0;
        return;
    L4:
        this.f13282p0 = r10;
    }

    public boolean c() {
        if ((this instanceof i) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof f) == true) goto L8;
        return false;
    }

    public boolean c0(int r10, int r11) {
        if (r10 != 0) goto L17;
        ConstraintAnchor r12 = this.Q.f13245f;
        if (r12 != null) goto L7;
    L30:
        return false;
    L7:
        if (r12.n() == false) goto L30;
        ConstraintAnchor r13 = this.S.f13245f;
        if (r13 == null) goto L30;
        if (r13.n() == false) goto L30;
        if (((this.S.f13245f.e() - this.S.f()) - (this.Q.f13245f.e() + this.Q.f())) < r11) goto L16;
        return true;
    L16:
        return false;
    L17:
        ConstraintAnchor r14 = this.R.f13245f;
        if (r14 == null) goto L30;
        if (r14.n() == false) goto L30;
        ConstraintAnchor r15 = this.T.f13245f;
        if (r15 == null) goto L30;
        if (r15.n() == false) goto L30;
        if (((this.T.f13245f.e() - this.T.f()) - (this.R.f13245f.e() + this.R.f())) < r11) goto L29;
        return true;
    L29:
        return false;
    }

    public void c1(int r10) {
        if (r10 >= 0) goto L4;
        this.f13280o0 = 0;
        return;
    L4:
        this.f13280o0 = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [com.obric.oui.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r15v5, types: [com.obric.oui.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r53v0, types: [com.obric.oui.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v6 */
    public void d(LinearSystem r54, boolean r55) {
        SolverVariable r13 = r54.q(this.Q);
        SolverVariable r12 = r54.q(this.S);
        SolverVariable r11 = r54.q(this.R);
        SolverVariable r10 = r54.q(this.T);
        SolverVariable r14 = r54.q(this.U);
        ConstraintWidget r15 = this.f13256c0;
        if (r15 == null) goto L19;
        if (r15 != null) goto L6;
    L8:
        boolean r16 = false;
    L9:
        if (r15 != null) goto L11;
    L13:
        boolean r17 = false;
    L14:
        int r18 = this.f13293v;
        if (r18 == 1) goto L21;
        if (r18 == 2) goto L20;
        if (r18 == 3) goto L19;
        boolean r19 = r17;
        boolean r20 = r16;
    L23:
        if (this.f13292u0 == 8) goto L25;
    L33:
        boolean r21 = this.f13281p;
        if (r21 == false) goto L36;
    L37:
        if (r21 == false) goto L47;
        r54.f(r13, this.f13266h0);
        r54.f(r12, this.f13266h0 + this.f13258d0);
        if (r20 == false) goto L47;
        ConstraintWidget r22 = this.f13256c0;
        if (r22 == null) goto L47;
        if (this.f13271k == false) goto L45;
        d r23 = (d) r22;
        r23.B1(this.Q);
        r23.A1(this.S);
        goto L47
    L45:
        r54.h(r54.q(r22.S), r12, 0, 5);
    L47:
        if (this.f13283q == false) goto L59;
        r54.f(r11, this.f13268i0);
        r54.f(r10, this.f13268i0 + this.f13260e0);
        if (this.U.m() == false) goto L51;
        r54.f(r14, this.f13268i0 + this.f13278n0);
    L51:
        if (r19 == false) goto L59;
        ConstraintWidget r24 = this.f13256c0;
        if (r24 == null) goto L59;
        if (this.f13271k == false) goto L57;
        d r25 = (d) r24;
        r25.G1(this.R);
        r25.F1(this.T);
        goto L59
    L57:
        r54.h(r54.q(r24.T), r10, 0, 5);
    L59:
        if (this.f13281p == true) goto L61;
    L64:
        boolean r26 = LinearSystem.f13101s;
        if (r55 == false) goto L95;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i r27 = this.f13259e;
        if (r27 == null) goto L95;
        k r28 = this.f13261f;
        if (r28 == null) goto L95;
        DependencyNode r29 = r27.f13341h;
        if (r29.f13331j == false) goto L95;
        if (r27.f13342i.f13331j == false) goto L95;
        if (r28.f13341h.f13331j == false) goto L95;
        if (r28.f13342i.f13331j == false) goto L95;
        r54.f(r13, r29.f13328g);
        r54.f(r12, this.f13259e.f13342i.f13328g);
        r54.f(r11, this.f13261f.f13341h.f13328g);
        r54.f(r10, this.f13261f.f13342i.f13328g);
        r54.f(r14, this.f13261f.f13370k.f13328g);
        if (this.f13256c0 == null) goto L92;
        if (r20 == true) goto L82;
    L86:
        if (r19 == false) goto L92;
        if (this.f13263g[1] == false) goto L92;
        if (j0() == true) goto L92;
        r54.h(r54.q(this.f13256c0.T), r10, 0, 8);
        goto L92
    L82:
        if (this.f13263g[0] == false) goto L86;
        if (h0() == true) goto L86;
        r54.h(r54.q(this.f13256c0.S), r12, 0, 8);
    L92:
        this.f13281p = false;
        this.f13283q = false;
        return;
    L95:
        if (this.f13256c0 != null) goto L97;
        boolean r210 = false;
        boolean r211 = false;
    L126:
        int r30 = this.f13258d0;
        int r31 = this.f13280o0;
        if (r30 < r31) goto L130;
        r31 = r30;
    L130:
        int r32 = this.f13260e0;
        int r33 = this.f13282p0;
        if (r32 < r33) goto L134;
        r33 = r32;
    L134:
        DimensionBehaviour[] r34 = this.f13254b0;
        DimensionBehaviour r35 = r34[0];
        DimensionBehaviour r36 = DimensionBehaviour.MATCH_CONSTRAINT;
        int r212 = r31;
        if (r35 == r36) goto L138;
        boolean r37 = true;
    L139:
        DimensionBehaviour r38 = r34[1];
        int r213 = r33;
        SolverVariable r214 = r14;
        if (r38 == r36) goto L142;
        boolean r39 = true;
    L143:
        int r40 = this.f13264g0;
        this.H = r40;
        SolverVariable r310 = r10;
        float r110 = this.f13262f0;
        this.I = r110;
        SolverVariable r311 = r11;
        int r111 = this.f13295w;
        int r112 = this.f13297x;
        if (r110 > 0.0f) goto L146;
    L180:
        r111 = r111;
        r112 = r112;
        int r312 = r213;
    L177:
        boolean r113 = false;
    L181:
        int[] r41 = this.f13299y;
        r41[0] = r111;
        r41[1] = r112;
        this.f13265h = r113;
        if (r113 == false) goto L187;
        int r42 = this.H;
        int r43 = -1;
        if (r42 == 0) goto L186;
        if (r42 == (-1)) goto L186;
    L188:
        boolean r114 = false;
    L189:
        if (r113 == false) goto L194;
        int r44 = this.H;
        if (r44 == 1) goto L193;
        if (r44 != r43) goto L194;
    L193:
        boolean r313 = true;
    L195:
        DimensionBehaviour r45 = this.f13254b0[0];
        DimensionBehaviour r115 = DimensionBehaviour.WRAP_CONTENT;
        if (r45 == r115) goto L198;
    L200:
        boolean r46 = false;
    L201:
        if (r46 == false) goto L203;
        int r215 = 0;
    L204:
        boolean r314 = !this.X.o();
        boolean[] r47 = this.f13252a0;
        boolean r216 = r47[0];
        boolean r315 = r47[1];
        if (this.f13289t != 2) goto L207;
    L227:
        SolverVariable r316 = r12;
        SolverVariable r317 = r13;
    L241:
        if (r55 == false) goto L259;
        ?? r116 = this;
        k r48 = r116.f13261f;
        if (r48 == null) goto L258;
        DependencyNode r49 = r48.f13341h;
        if (r49.f13331j == false) goto L258;
        if (r48.f13342i.f13331j == false) goto L258;
        r54 = r54;
        r311 = r311;
        r54.f(r311, r49.f13328g);
        r310 = r310;
        r54.f(r310, r116.f13261f.f13342i.f13328g);
        r214 = r214;
        r54.f(r214, r116.f13261f.f13370k.f13328g);
        ConstraintWidget r50 = r116.f13256c0;
        if (r50 == null) goto L256;
        if (r210 == true) goto L256;
        if (r19 == false) goto L256;
        int r117 = 1;
        if (r116.f13263g[1] == false) goto L255;
        int r51 = 8;
        int r118 = 0;
        r54.h(r54.q(r50.T), r310, 0, 8);
    L257:
        int r52 = r118;
        ?? r119 = r116;
    L262:
        if (r119.f13291u != 2) goto L264;
        int r53 = r118;
    L265:
        if (r53 == 0) goto L306;
        if (r119.f13283q == true) goto L306;
        if (r119.f13254b0[r117] == r115) goto L271;
    L273:
        ?? r56 = r118;
    L274:
        if (r56 == 0) goto L276;
        r312 = r118;
    L276:
        ConstraintWidget r57 = r119.f13256c0;
        if (r57 == null) goto L279;
        SolverVariable r58 = r54.q(r57.T);
    L280:
        ConstraintWidget r59 = r119.f13256c0;
        if (r59 == null) goto L283;
        SolverVariable r60 = r54.q(r59.R);
    L285:
        if (r119.f13278n0 <= 0) goto L287;
    L288:
        ConstraintAnchor r61 = r119.U;
        if (r61.f13245f == null) goto L295;
        r54.e(r214, r311, o(), r51);
        r54.e(r214, r54.q(r119.U.f13245f), r119.U.f(), r51);
        if (r19 == 0) goto L293;
        r54.h(r58, r54.q(r119.T), r118, 5);
    L293:
        ?? r217 = r118;
    L299:
        boolean r62 = r119.f13263g[r117];
        DimensionBehaviour[] r63 = r119.f13254b0;
        DimensionBehaviour r64 = r63[r117];
        ConstraintAnchor r65 = r119.R;
        ConstraintAnchor r66 = r119.T;
        int r67 = r119.f13268i0;
        int r68 = r119.f13282p0;
        int r120 = r119.f13250J[r117];
        float r121 = r119.f13286r0;
        if (r63[0] != r36) goto L302;
        boolean r122 = true;
    L303:
        f(r54, false, r19, r20, r62, r60, r58, r64, r56, r65, r66, r67, r312, r68, r120, r121, r313, r122, r210, r211, r315, r112, r111, r119.C, r119.D, r119.E, r217);
        goto L306
    L302:
        r122 = false;
        goto L303
    L295:
        if (r119.f13292u0 != r51) goto L297;
        r54.e(r214, r311, r61.f(), r51);
    L298:
        r217 = r314;
        goto L299
    L297:
        r54.e(r214, r311, o(), r51);
        goto L298
    L287:
        if (r119.f13292u0 != r51) goto L298;
    L283:
        r60 = null;
        goto L285
    L279:
        r58 = null;
        goto L280
    L271:
        if ((r119 instanceof d) == false) goto L273;
        r56 = r117;
    L306:
        if (r113 == false) goto L312;
        if (this.H != 1) goto L310;
        r54.k(r310, r311, r316, r317, this.I, 8);
        goto L312
    L310:
        r54.k(r316, r317, r310, r311, this.I, 8);
    L312:
        if (this.X.o() == false) goto L314;
        r54.b(this, this.X.j().h(), (float) Math.toRadians(this.K + 90.0f), this.X.f());
    L314:
        this.f13281p = false;
        this.f13283q = false;
        return;
    L264:
        r53 = r52;
        goto L265
    L255:
        r51 = 8;
        r118 = 0;
    L256:
        r51 = 8;
        r118 = 0;
        r117 = 1;
    L258:
        r51 = 8;
        r118 = 0;
        r117 = 1;
        ?? r123 = r116;
    L260:
        r52 = r117;
        r119 = r123;
        goto L262
    L259:
        r51 = 8;
        r118 = 0;
        r117 = 1;
        r123 = this;
        goto L260
    L207:
        if (this.f13281p == true) goto L227;
        if (r55 == false) goto L228;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i r69 = this.f13259e;
        if (r69 == null) goto L228;
        DependencyNode r70 = r69.f13341h;
        if (r70.f13331j == false) goto L228;
        if (r69.f13342i.f13331j == false) goto L228;
        if (r55 == false) goto L227;
        r54.f(r13, r70.f13328g);
        r54.f(r12, this.f13259e.f13342i.f13328g);
        if (this.f13256c0 == null) goto L225;
        if (r20 == false) goto L225;
        if (this.f13263g[0] == false) goto L225;
        if (h0() == true) goto L225;
        r54.h(r54.q(this.f13256c0.S), r12, 0, 8);
    L225:
        r316 = r12;
        r317 = r13;
    L228:
        ConstraintWidget r71 = this.f13256c0;
        if (r71 == null) goto L231;
        SolverVariable r72 = r54.q(r71.S);
    L232:
        ConstraintWidget r73 = this.f13256c0;
        if (r73 == null) goto L235;
        SolverVariable r124 = r54.q(r73.Q);
    L236:
        boolean r218 = this.f13263g[0];
        DimensionBehaviour[] r74 = this.f13254b0;
        DimensionBehaviour r318 = r74[0];
        ConstraintAnchor r75 = this.Q;
        ConstraintAnchor r76 = this.S;
        int r77 = this.f13266h0;
        int r78 = this.f13280o0;
        int r410 = this.f13250J[0];
        float r79 = this.f13284q0;
        if (r74[1] != r36) goto L239;
        boolean r411 = true;
    L240:
        r316 = r12;
        r317 = r13;
        f(r54, true, r20, r19, r218, r124, r72, r318, r46, r75, r76, r77, r215, r78, r410, r79, r114, r411, r211, r210, r216, r111, r112, this.f13301z, this.A, this.B, r314);
        goto L241
    L239:
        r411 = false;
        goto L240
    L235:
        r124 = null;
        goto L236
    L231:
        r72 = null;
        goto L232
    L203:
        r215 = r212;
        goto L204
    L198:
        if ((this instanceof d) == false) goto L200;
        r46 = true;
    L194:
        r313 = false;
    L186:
        r114 = true;
        goto L189
    L187:
        r43 = -1;
        goto L188
    L146:
        if (this.f13292u0 == 8) goto L180;
        if (r35 != r36) goto L150;
        if (r111 != 0) goto L150;
        r111 = 3;
    L150:
        if (r38 != r36) goto L153;
        if (r112 != 0) goto L153;
        r112 = 3;
    L153:
        if (r35 != r36) goto L159;
        if (r38 != r36) goto L159;
        int r125 = 3;
        if (r111 != 3) goto L161;
        if (r112 != 3) goto L161;
        q1(r20, r19, r37, r39);
    L179:
        r212 = r212;
    L167:
        r312 = r213;
    L168:
        r113 = true;
    L161:
        if (r35 != r36) goto L169;
        if (r111 != r125) goto L169;
        this.H = 0;
        int r80 = (int) (r110 * r32);
        if (r38 == r36) goto L166;
        r111 = 4;
        r112 = r112;
        r312 = r213;
        r113 = false;
        r212 = r80;
        goto L181
    L166:
        r212 = r80;
    L169:
        if (r38 != r36) goto L179;
        if (r112 != r125) goto L179;
        this.H = 1;
        if (r40 != (-1)) goto L174;
        this.I = 1.0f / r110;
    L174:
        int r81 = (int) (this.I * r30);
        if (r35 == r36) goto L178;
        r112 = 4;
        r312 = r81;
        r111 = r111;
        goto L177
    L178:
        r312 = r81;
        r111 = r111;
        r112 = r112;
        r212 = r212;
    L159:
        r125 = 3;
        goto L161
    L142:
        r39 = false;
        goto L143
    L138:
        r37 = false;
        goto L139
    L97:
        if (e0(0) == false) goto L99;
        ((d) this.f13256c0).x1(this, 0);
        boolean r82 = true;
    L101:
        if (e0(1) == false) goto L103;
        ((d) this.f13256c0).x1(this, 1);
        boolean r83 = true;
    L104:
        if (r82 == true) goto L113;
        if (r20 == false) goto L113;
        if (this.f13292u0 == 8) goto L113;
        if (this.Q.f13245f != null) goto L113;
        if (this.S.f13245f != null) goto L113;
        r54.h(r54.q(this.f13256c0.S), r12, 0, 1);
    L113:
        if (r83 == true) goto L124;
        if (r19 == false) goto L124;
        if (this.f13292u0 == 8) goto L124;
        if (this.R.f13245f != null) goto L124;
        if (this.T.f13245f != null) goto L124;
        if (this.U != null) goto L124;
        r54.h(r54.q(this.f13256c0.T), r10, 0, 1);
    L124:
        r211 = r82;
        r210 = r83;
        goto L126
    L103:
        r83 = j0();
        goto L104
    L99:
        r82 = h0();
        goto L101
    L61:
        if (this.f13283q == false) goto L64;
        this.f13281p = false;
        this.f13283q = false;
        return;
    L36:
        if (this.f13283q == false) goto L64;
    L25:
        if (this.f13294v0 == true) goto L33;
        if (a0() == true) goto L33;
        boolean[] r84 = this.f13252a0;
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
        if (r15.f13254b0[1] != DimensionBehaviour.WRAP_CONTENT) goto L13;
        r17 = true;
        goto L14
    L6:
        if (r15.f13254b0[0] != DimensionBehaviour.WRAP_CONTENT) goto L8;
        r16 = true;
    L19:
        r20 = false;
        r19 = false;
        goto L23
    }

    public void d0(ConstraintAnchor.Type r10, ConstraintWidget r11, ConstraintAnchor.Type r12, int r13, int r14) {
        n(r10).b(r11.n(r12), r13, r14, true);
    }

    public void d1(int r10, int r11) {
        this.f13266h0 = r10;
        this.f13268i0 = r11;
    }

    public boolean e() {
        if (this.f13292u0 == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e0(int r10) {
        int r11 = r10 * 2;
        ConstraintAnchor[] r12 = this.Y;
        ConstraintAnchor r13 = r12[r11];
        ConstraintAnchor r14 = r13.f13245f;
        if (r14 != null) goto L5;
    L11:
        return false;
    L5:
        if (r14.f13245f == r13) goto L11;
        ConstraintAnchor r15 = r12[r11 + 1];
        ConstraintAnchor r16 = r15.f13245f;
        if (r16 == null) goto L11;
        if (r16.f13245f != r15) goto L11;
        return true;
    }

    public void e1(ConstraintWidget r10) {
        this.f13256c0 = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(LinearSystem r38, boolean r39, boolean r40, boolean r41, boolean r42, SolverVariable r43, SolverVariable r44, DimensionBehaviour r45, boolean r46, ConstraintAnchor r47, ConstraintAnchor r48, int r49, int r50, int r51, int r52, float r53, boolean r54, boolean r55, boolean r56, boolean r57, boolean r58, int r59, int r60, int r61, int r62, float r63, boolean r64) {
        int r10 = r62;
        SolverVariable r11 = r38.q(r47);
        SolverVariable r12 = r38.q(r48);
        SolverVariable r13 = r38.q(r47.j());
        SolverVariable r14 = r38.q(r48.j());
        LinearSystem.x();
        boolean r16 = r47.o();
        boolean r17 = r48.o();
        boolean r18 = this.X.o();
        if (r17 == false) goto L5;
        int r15 = (r16 ? 1 : 0) + 1;
    L6:
        if (r18 == false) goto L8;
        r15 = r15 + 1;
    L8:
        if (r54 == false) goto L10;
        int r19 = 3;
    L11:
        int r110 = a.f13304b[r45.ordinal()];
        if (r110 != 1) goto L14;
    L19:
        int r111 = r19;
    L20:
        boolean r112 = false;
    L24:
        int r20 = this.f13273l;
        if (r20 == (-1)) goto L28;
        if (r39 == false) goto L28;
        this.f13273l = -1;
        r50 = r20;
        r112 = false;
    L28:
        int r21 = this.f13275m;
        if (r21 == (-1)) goto L32;
        if (r39 == true) goto L32;
        this.f13275m = -1;
        r112 = false;
    L33:
        int r510 = r21;
        if (this.f13292u0 != 8) goto L36;
        int r113 = 0;
        r112 = false;
    L37:
        if (r64 == false) goto L46;
        if (r16 == true) goto L43;
        if (r17 == true) goto L43;
        if (r18 == true) goto L43;
        r38.f(r11, r49);
    L42:
        int r22 = 8;
    L47:
        if (r112 == true) goto L59;
        if (r46 == false) goto L55;
        r38.e(r12, r11, 0, 3);
        if (r51 <= 0) goto L53;
        r38.h(r12, r11, r51, 8);
    L53:
        if (r52 >= Integer.MAX_VALUE) goto L56;
        r38.j(r12, r11, r52, 8);
    L56:
        boolean r25 = r112;
    L57:
        int r24 = r61;
    L111:
        if (r64 == false) goto L352;
        if (r56 == true) goto L352;
        if (r16 == true) goto L118;
        if (r17 == true) goto L118;
        if (r18 == true) goto L118;
    L117:
        int r23 = 5;
        int r26 = 0;
    L331:
        boolean r114 = r40;
    L332:
        if (r114 == false) goto L380;
        if (r42 == true) goto L335;
        return;
    L335:
        if (r48.f13245f == null) goto L338;
        r26 = r48.f();
    L338:
        if (r14 != r44) goto L340;
        return;
    L340:
        if (this.f13269j == true) goto L342;
    L350:
        r38.h(r44, r12, r26, r23);
        return;
    L342:
        if (r12.f13133g == false) goto L350;
        ConstraintWidget r27 = this.f13256c0;
        if (r27 == null) goto L350;
        d r28 = (d) r27;
        if (r39 == false) goto L348;
        r28.A1(r48);
        return;
    L348:
        r28.F1(r48);
        return;
    L380:
        return;
    L118:
        if (r16 == false) goto L129;
        if (r17 == true) goto L129;
        ConstraintWidget r29 = r47.f13245f.f13243d;
        if (r40 == true) goto L123;
    L125:
        int r30 = 5;
    L126:
        r114 = r40;
        r23 = r30;
    L127:
        r14 = r14;
    L128:
        r26 = 0;
        goto L332
    L123:
        if ((r29 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L125;
        r30 = 8;
    L129:
        if (r16 == true) goto L145;
        if (r17 == false) goto L145;
        r38.e(r12, r14, -r48.f(), 8);
        if (r40 == false) goto L117;
        if (this.f13269j == true) goto L136;
    L143:
        r38.h(r11, r43, 0, 5);
        r26 = 0;
        r23 = 5;
        goto L331
    L136:
        if (r11.f13133g == false) goto L143;
        ConstraintWidget r31 = this.f13256c0;
        if (r31 == null) goto L143;
        d r32 = (d) r31;
        if (r39 == false) goto L142;
        r32.B1(r47);
        goto L117
    L142:
        r32.G1(r47);
    L145:
        if (r16 == false) goto L330;
        if (r17 == false) goto L330;
        ConstraintWidget r33 = r47.f13245f.f13243d;
        boolean r34 = false;
        ConstraintWidget r35 = r48.f13245f.f13243d;
        ConstraintWidget r36 = J();
        int r115 = 6;
        if (r25 == false) goto L219;
        if (r111 != 0) goto L169;
        if (r10 != 0) goto L159;
        if (r24 != 0) goto L159;
        if (r13.f13133g == true) goto L155;
    L158:
        int r37 = 8;
        int r116 = 8;
        boolean r117 = false;
        boolean r210 = false;
        boolean r211 = true;
    L161:
        if ((r33 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L163;
    L166:
        int r212 = r37;
        boolean r213 = r117;
        r34 = r211;
        char r65 = 5;
        boolean r66 = true;
        int r118 = 4;
    L167:
        r44 = r44;
    L234:
        if (r210 == false) goto L238;
        if (r13 != r14) goto L238;
        if (r33 == r36) goto L238;
        r210 = false;
        boolean r214 = false;
    L239:
        if (r213 == false) goto L249;
        if (r25 == true) goto L246;
        if (r55 == true) goto L246;
        if (r57 == true) goto L246;
        if (r13 != r43) goto L246;
        if (r14 != r44) goto L246;
        r114 = false;
        r212 = 8;
        int r215 = 8;
        r214 = false;
    L247:
        SolverVariable r410 = r13;
        int r119 = 8;
        int r310 = 4;
        r38.c(r11, r410, r47.f(), r53, r14, r12, r48.f(), r215);
    L248:
        boolean r67 = r214;
        if (this.f13292u0 == r119) goto L253;
    L255:
        SolverVariable r68 = r410;
        if (r210 == false) goto L270;
        if (r114 == false) goto L267;
        if (r68 == r14) goto L267;
        if (r25 == true) goto L267;
        ConstraintWidget r69 = r33;
        if ((r69 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L265;
        ConstraintWidget r70 = r35;
        if ((r70 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L266;
    L268:
        int r71 = r212;
    L269:
        SolverVariable r72 = r11;
        r38.h(r72, r68, r47.f(), r71);
        r38.j(r12, r14, -r48.f(), r71);
        r212 = r71;
    L271:
        if (r114 == false) goto L280;
        if (r58 == false) goto L280;
        if ((r69 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L280;
        if ((r70 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L280;
        ConstraintWidget r73 = r36;
        if (r70 == r73) goto L281;
        int r74 = 6;
        int r75 = 6;
        r67 = r66;
    L282:
        if (r67 == false) goto L313;
        if (r34 == false) goto L304;
        if (r57 == false) goto L286;
        if (r41 == false) goto L304;
    L286:
        if (r69 == r73) goto L290;
        if (r70 == r73) goto L290;
        int r76 = r74;
    L292:
        if ((r69 instanceof f) == false) goto L294;
    L295:
        r76 = 5;
    L297:
        if ((r69 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L299;
    L300:
        r76 = 5;
    L301:
        if (r57 == false) goto L303;
        r76 = 5;
    L303:
        int r77 = Math.max(r76, r74);
    L305:
        if (r114 == false) goto L312;
        r77 = Math.min(r75, r77);
        if (r54 == false) goto L312;
        if (r57 == true) goto L312;
        if (r69 == r73) goto L311;
        if (r70 != r73) goto L312;
    L311:
        r77 = r310;
    L312:
        r38.e(r72, r68, r47.f(), r77);
        r38.e(r12, r14, -r48.f(), r77);
        goto L313
    L299:
        if ((r70 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L301;
    L294:
        if ((r70 instanceof f) == false) goto L297;
    L290:
        r76 = 6;
    L304:
        r77 = r74;
    L313:
        if (r114 == false) goto L319;
        if (r43 != r68) goto L316;
        int r78 = r47.f();
    L317:
        if (r68 == r43) goto L319;
        r23 = 5;
        r38.h(r72, r43, r78, 5);
    L320:
        if (r114 == false) goto L127;
        if (r25 == false) goto L127;
        r14 = r14;
        if (r51 != 0) goto L128;
        if (r24 != 0) goto L128;
        if (r25 == true) goto L327;
    L329:
        r26 = 0;
        r38.h(r12, r72, 0, r23);
        goto L332
    L327:
        if (r111 != 3) goto L329;
        r26 = 0;
        r38.h(r12, r72, 0, r119);
        goto L332
    L316:
        r78 = 0;
    L319:
        r23 = 5;
    L281:
        r74 = r118;
        r75 = r212;
    L280:
        r73 = r36;
    L266:
        r71 = 6;
        goto L269
    L265:
        r70 = r35;
    L267:
        r70 = r35;
        r69 = r33;
        goto L268
    L270:
        r70 = r35;
        r69 = r33;
        r72 = r11;
        goto L271
    L253:
        if (r48.m() == true) goto L255;
        return;
    L246:
        r215 = r115;
        r114 = r40;
        goto L247
    L249:
        r410 = r13;
        r119 = 8;
        r310 = 4;
        r114 = r40;
    L238:
        r214 = r66;
        goto L239
    L163:
        if ((r35 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L166;
        r212 = r37;
        r213 = r117;
        r34 = r211;
        r65 = 5;
        r66 = true;
        r44 = r44;
        r118 = r116;
        r115 = 6;
        goto L234
    L155:
        if (r14.f13133g == false) goto L158;
        r38.e(r11, r13, r47.f(), 8);
        r38.e(r12, r14, -r48.f(), 8);
        return;
    L159:
        r211 = false;
        r37 = 5;
        r116 = 5;
        r117 = true;
        r210 = true;
        goto L161
    L169:
        if (r111 != 2) goto L180;
        if ((r33 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L173;
    L178:
        r65 = 5;
        r66 = true;
        r118 = 4;
    L176:
        r212 = 5;
    L177:
        r213 = true;
        r210 = true;
        goto L234
    L173:
        if ((r35 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L178;
        r65 = 5;
        r66 = true;
        r118 = 5;
        goto L176
    L180:
        if (r111 != 1) goto L183;
        r44 = r44;
        r34 = false;
        r115 = 6;
        r65 = 5;
        r66 = true;
        r118 = 4;
        r212 = 8;
        goto L177
    L183:
        if (r111 == 3) goto L185;
        r66 = true;
        r65 = 5;
        r118 = 4;
        r212 = 5;
        r213 = false;
        r210 = false;
    L218:
        r34 = false;
        goto L234
    L185:
        if (this.H != (-1)) goto L193;
        if (r57 == false) goto L192;
        r44 = r44;
        r65 = 5;
        r66 = true;
        if (r40 == false) goto L191;
        r115 = 5;
    L190:
        r118 = 5;
        r212 = 8;
        r213 = true;
        r210 = true;
        r34 = true;
        goto L234
    L191:
        r115 = 4;
        goto L190
    L192:
        r44 = r44;
        r65 = 5;
        r66 = true;
        r115 = 8;
        goto L190
    L193:
        if (r54 == true) goto L195;
        r66 = true;
        if (r10 <= 0) goto L207;
        r213 = true;
        r210 = true;
        r34 = true;
        r65 = 5;
        r118 = 5;
    L206:
        r212 = 5;
        goto L234
    L207:
        if (r10 != 0) goto L216;
        if (r24 != 0) goto L216;
        if (r57 == true) goto L211;
        r213 = true;
        r210 = true;
        r34 = true;
        r65 = 5;
        r118 = 8;
        goto L206
    L211:
        if (r33 == r36) goto L214;
        if (r35 == r36) goto L214;
        int r79 = 4;
    L215:
        r44 = r44;
        r212 = r79;
        r213 = true;
        r210 = true;
        r34 = true;
        r115 = 6;
        r65 = 5;
        r118 = 4;
    L214:
        r79 = 5;
    L216:
        r213 = true;
        r210 = true;
        r34 = true;
        r65 = 5;
        r118 = 4;
        goto L206
    L195:
        if (r60 == 2) goto L200;
        r66 = true;
        if (r60 == 1) goto L201;
        int r80 = 8;
        int r81 = 5;
    L202:
        r212 = r80;
        r118 = r81;
        r213 = r66;
        r210 = r213;
        r34 = r210;
        r65 = 5;
    L201:
        r80 = 5;
        r81 = 4;
        goto L202
    L200:
        r66 = true;
        goto L201
    L219:
        r66 = true;
        if (r13.f13133g == true) goto L222;
    L233:
        r65 = 5;
        r212 = 5;
        r213 = true;
        r210 = true;
        r118 = 4;
        goto L218
    L222:
        if (r14.f13133g == false) goto L233;
        r38.c(r11, r13, r47.f(), r53, r14, r12, r48.f(), 8);
        if (r40 == false) goto L376;
        if (r42 == true) goto L227;
        return;
    L227:
        if (r48.f13245f == null) goto L229;
        int r82 = r48.f();
    L230:
        if (r14 == r44) goto L378;
        r38.h(r44, r12, r82, 5);
        return;
    L378:
        return;
    L229:
        r82 = 0;
        goto L230
    L376:
        return;
    L330:
        r26 = 0;
        r23 = 5;
    L352:
        if (r15 >= 2) goto L383;
        if (r40 == false) goto L384;
        if (r42 == false) goto L385;
        r38.h(r11, r43, 0, 8);
        if (r39 == false) goto L358;
    L361:
        Object[] r83 = true;
    L362:
        if (r39 == true) goto L373;
        ConstraintAnchor r84 = this.U.f13245f;
        if (r84 == null) goto L373;
        ConstraintWidget r85 = r84.f13243d;
        if (r85.f13262f0 == 0.0f) goto L372;
        DimensionBehaviour[] r86 = r85.f13254b0;
        DimensionBehaviour r87 = r86[0];
        DimensionBehaviour r88 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r87 != r88) goto L372;
        if (r86[1] != r88) goto L372;
        r83 = true;
    L372:
        r83 = false;
    L373:
        if (r83 == false) goto L386;
        r38.h(r44, r12, 0, 8);
        return;
    L386:
        return;
    L358:
        if (this.U.f13245f == null) goto L361;
        r83 = false;
        goto L362
    L385:
        return;
    L384:
        return;
    L383:
        return;
    L55:
        r38.e(r12, r11, r113, r22);
        goto L56
    L59:
        if (r15 == 2) goto L69;
        if (r54 == true) goto L69;
        if (r111 == 1) goto L64;
        if (r111 != 0) goto L69;
    L64:
        int r89 = Math.max(r61, r113);
        if (r10 <= 0) goto L67;
        r89 = Math.min(r10, r89);
    L67:
        r38.e(r12, r11, r89, 8);
        r25 = false;
    L69:
        if (r61 != (-2)) goto L71;
        int r90 = r113;
    L72:
        if (r10 != (-2)) goto L74;
        int r91 = r113;
    L75:
        if (r113 <= 0) goto L80;
        if (r111 == 1) goto L80;
        r113 = 0;
    L80:
        if (r90 <= 0) goto L83;
        r38.h(r12, r11, r90, 8);
        r113 = Math.max(r113, r90);
    L83:
        if (r91 <= 0) goto L89;
        if (r40 == false) goto L87;
        if (r111 != 1) goto L87;
    L88:
        r113 = Math.min(r113, r91);
    L87:
        r38.j(r12, r11, r91, 8);
    L89:
        if (r111 != 1) goto L97;
        if (r40 == false) goto L92;
        r38.e(r12, r11, r113, 8);
    L95:
        r10 = r91;
        r15 = r15 == true ? 1 : 0;
        r12 = r12;
        r25 = r112;
        r14 = r14;
        r42 = r42;
        r24 = r90;
        r13 = r13;
        goto L111
    L92:
        if (r56 == false) goto L94;
        r38.e(r12, r11, r113, 5);
        r38.j(r12, r11, r113, 8);
        goto L95
    L94:
        r38.e(r12, r11, r113, 5);
        r38.j(r12, r11, r113, 8);
        goto L95
    L97:
        if (r111 != 2) goto L110;
        ConstraintAnchor.Type r92 = r47.k();
        ConstraintAnchor.Type r93 = ConstraintAnchor.Type.TOP;
        if (r92 != r93) goto L101;
    L105:
        SolverVariable r94 = r38.q(this.f13256c0.n(r93));
        SolverVariable r95 = r38.q(this.f13256c0.n(ConstraintAnchor.Type.BOTTOM));
    L104:
        SolverVariable r120 = r94;
        SolverVariable r96 = r95;
        ArrayRow r97 = r38.r();
        int r411 = r91;
        r15 = r15 == true ? 1 : 0;
        r14 = r14;
        int r511 = r90;
        r13 = r13;
        r12 = r12;
        r38.d(r97.h(r12, r11, r96, r120, r63));
        if (r40 == false) goto L109;
        r112 = false;
    L109:
        r10 = r411;
        r24 = r511;
        r25 = r112;
        r42 = r42;
        goto L111
    L101:
        if (r47.k() == ConstraintAnchor.Type.BOTTOM) goto L105;
        r94 = r38.q(this.f13256c0.n(ConstraintAnchor.Type.LEFT));
        r95 = r38.q(this.f13256c0.n(ConstraintAnchor.Type.RIGHT));
        goto L104
    L110:
        int r412 = r91;
        int r512 = r90;
        r15 = r15 == true ? 1 : 0;
        r13 = r13;
        r12 = r12;
        r14 = r14;
        r10 = r412;
        r24 = r512;
        r25 = r112;
        r42 = true;
        goto L111
    L74:
        r91 = r10;
        goto L75
    L71:
        r90 = r61;
    L43:
        if (r16 == false) goto L42;
        if (r17 == true) goto L42;
        r22 = 8;
        r38.e(r11, r13, r47.f(), 8);
        goto L47
    L46:
        r22 = 8;
        goto L47
    L36:
        r113 = r510;
    L32:
        r21 = r50;
        goto L33
    L14:
        if (r110 == 2) goto L19;
        if (r110 == 3) goto L19;
        if (r110 != 4) goto L19;
        r111 = r19;
        if (r111 == 4) goto L20;
        r112 = true;
        goto L24
    L10:
        r19 = r59;
        goto L11
    L5:
        r15 = r16 ? 1 : 0;
        goto L6
    }

    public boolean f0() {
        return this.f13285r;
    }

    public void f1(float r10) {
        this.f13286r0 = r10;
    }

    public void g(ConstraintAnchor.Type r10, ConstraintWidget r11, ConstraintAnchor.Type r12) {
        h(r10, r11, r12, 0);
    }

    public boolean g0(int r10) {
        return this.f13252a0[r10];
    }

    public void g1(int r10) {
        this.K0 = r10;
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
        ConstraintAnchor r11 = r10.f13245f;
        if (r11 != null) goto L5;
    L6:
        ConstraintAnchor r12 = this.S;
        ConstraintAnchor r13 = r12.f13245f;
        if (r13 != null) goto L9;
        return false;
    L9:
        if (r13.f13245f != r12) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r11.f13245f != r10) goto L6;
        return true;
    }

    public void h1(int r10, int r11) {
        this.f13268i0 = r10;
        int r12 = r11 - r10;
        this.f13260e0 = r12;
        int r13 = this.f13282p0;
        if (r12 >= r13) goto L6;
        this.f13260e0 = r13;
        return;
    }

    public void i(ConstraintAnchor r10, ConstraintAnchor r11, int r12) {
        if (r10.h() != this) goto L6;
        h(r10.k(), r11.h(), r11.k(), r12);
        return;
    }

    public boolean i0() {
        return this.M;
    }

    public void i1(DimensionBehaviour r10) {
        this.f13254b0[1] = r10;
    }

    public void j(ConstraintWidget r10, float r11, int r12) {
        ConstraintAnchor.Type r13 = ConstraintAnchor.Type.CENTER;
        d0(r13, r10, r13, r12, 0);
        this.K = r11;
    }

    public boolean j0() {
        ConstraintAnchor r10 = this.R;
        ConstraintAnchor r11 = r10.f13245f;
        if (r11 != null) goto L5;
    L6:
        ConstraintAnchor r12 = this.T;
        ConstraintAnchor r13 = r12.f13245f;
        if (r13 != null) goto L9;
        return false;
    L9:
        if (r13.f13245f != r12) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r11.f13245f != r10) goto L6;
        return true;
    }

    public void j1(int r10, int r11, int r12, float r13) {
        this.f13297x = r10;
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
        this.f13297x = 2;
        return;
    L14:
        return;
    }

    public void k(ConstraintWidget r10, HashMap r11) {
        this.f13289t = r10.f13289t;
        this.f13291u = r10.f13291u;
        this.f13295w = r10.f13295w;
        this.f13297x = r10.f13297x;
        int[] r12 = this.f13299y;
        int[] r13 = r10.f13299y;
        r12[0] = r13[0];
        r12[1] = r13[1];
        this.f13301z = r10.f13301z;
        this.A = r10.A;
        this.C = r10.C;
        this.D = r10.D;
        this.E = r10.E;
        this.F = r10.F;
        this.G = r10.G;
        this.H = r10.H;
        this.I = r10.I;
        int[] r14 = r10.f13250J;
        this.f13250J = Arrays.copyOf(r14, r14.length);
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
        this.f13254b0 = (DimensionBehaviour[]) Arrays.copyOf(this.f13254b0, 2);
        ConstraintWidget r15 = null;
        if (this.f13256c0 != null) goto L5;
        ConstraintWidget r16 = null;
    L6:
        this.f13256c0 = r16;
        this.f13258d0 = r10.f13258d0;
        this.f13260e0 = r10.f13260e0;
        this.f13262f0 = r10.f13262f0;
        this.f13264g0 = r10.f13264g0;
        this.f13266h0 = r10.f13266h0;
        this.f13268i0 = r10.f13268i0;
        this.f13270j0 = r10.f13270j0;
        this.f13272k0 = r10.f13272k0;
        this.f13274l0 = r10.f13274l0;
        this.f13276m0 = r10.f13276m0;
        this.f13278n0 = r10.f13278n0;
        this.f13280o0 = r10.f13280o0;
        this.f13282p0 = r10.f13282p0;
        this.f13284q0 = r10.f13284q0;
        this.f13286r0 = r10.f13286r0;
        this.f13288s0 = r10.f13288s0;
        this.f13290t0 = r10.f13290t0;
        this.f13292u0 = r10.f13292u0;
        this.f13294v0 = r10.f13294v0;
        this.f13296w0 = r10.f13296w0;
        this.f13298x0 = r10.f13298x0;
        this.f13300y0 = r10.f13300y0;
        this.f13302z0 = r10.f13302z0;
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
        r16 = (ConstraintWidget) r11.get(r10.f13256c0);
        goto L6
    }

    public boolean k0() {
        return this.N;
    }

    public void k1(float r10) {
        this.N0[1] = r10;
    }

    public void l(LinearSystem r10) {
        r10.q(this.Q);
        r10.q(this.R);
        r10.q(this.S);
        r10.q(this.T);
        if (this.f13278n0 <= 0) goto L6;
        r10.q(this.U);
        return;
    }

    public boolean l0() {
        if (this.f13267i == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f13292u0 == 8) goto L7;
        return true;
    }

    public void l1(int r10) {
        this.f13292u0 = r10;
    }

    public void m() {
        if (this.f13259e != null) goto L6;
        this.f13259e = new com.obric.oui.constraintlayout.core.widgets.analyzer.i(this);
    L6:
        if (this.f13261f != null) goto L9;
        this.f13261f = new k(this);
        return;
    }

    public boolean m0() {
        if (this.f13281p == false) goto L5;
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
        this.f13258d0 = r10;
        int r11 = this.f13280o0;
        if (r10 >= r11) goto L6;
        this.f13258d0 = r11;
        return;
    }

    public ConstraintAnchor n(ConstraintAnchor.Type r10) {
        switch(a.f13303a[r10.ordinal()]) {
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
        if (this.f13283q == false) goto L5;
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
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 > 3) goto L8;
        this.f13293v = r10;
        return;
    }

    public int o() {
        return this.f13278n0;
    }

    public boolean o0() {
        return this.f13287s;
    }

    public void o1(int r10) {
        this.f13266h0 = r10;
    }

    public float p(int r10) {
        if (r10 != 0) goto L6;
        return this.f13284q0;
    L6:
        if (r10 == 1) goto L8;
        return -1.0f;
    L8:
        return this.f13286r0;
    }

    public void p0() {
        this.f13285r = true;
    }

    public void p1(int r10) {
        this.f13268i0 = r10;
    }

    public int q() {
        return X() + this.f13260e0;
    }

    public void q0() {
        this.f13287s = true;
    }

    public void q1(boolean r10, boolean r11, boolean r12, boolean r13) {
        if (this.H != (-1)) goto L13;
        if (r12 == false) goto L7;
        if (r13 == true) goto L7;
        this.H = 0;
    L7:
        if (r12 == true) goto L13;
        if (r13 == false) goto L13;
        this.H = 1;
        if (this.f13264g0 != (-1)) goto L13;
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
        int r14 = this.f13301z;
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

    public Object r() {
        return this.f13288s0;
    }

    public boolean r0() {
        DimensionBehaviour[] r10 = this.f13254b0;
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

    public void r1(boolean r10, boolean r11) {
        boolean r12 = r10 & this.f13259e.j();
        boolean r13 = r11 & this.f13261f.j();
        com.obric.oui.constraintlayout.core.widgets.analyzer.i r14 = this.f13259e;
        int r15 = r14.f13341h.f13328g;
        k r16 = this.f13261f;
        int r17 = r16.f13341h.f13328g;
        int r18 = r14.f13342i.f13328g;
        int r19 = r16.f13342i.f13328g;
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
        this.f13266h0 = r15;
    L19:
        if (r13 == false) goto L22;
        this.f13268i0 = r17;
    L22:
        if (this.f13292u0 != 8) goto L25;
        this.f13258d0 = 0;
        this.f13260e0 = 0;
        return;
    L25:
        if (r12 == true) goto L27;
    L34:
        if (r13 == true) goto L36;
        return;
    L36:
        if (this.f13254b0[1] != DimensionBehaviour.FIXED) goto L40;
        int r23 = this.f13260e0;
        if (r22 >= r23) goto L40;
        r22 = r23;
    L40:
        this.f13260e0 = r22;
        int r24 = this.f13282p0;
        if (r22 >= r24) goto L45;
        this.f13260e0 = r24;
        return;
    L45:
        return;
    L27:
        if (this.f13254b0[0] != DimensionBehaviour.FIXED) goto L31;
        int r25 = this.f13258d0;
        if (r21 >= r25) goto L31;
        r21 = r25;
    L31:
        this.f13258d0 = r21;
        int r26 = this.f13280o0;
        if (r21 >= r26) goto L34;
        this.f13258d0 = r26;
    L15:
        r18 = 0;
        r15 = 0;
        r19 = 0;
        r17 = 0;
        goto L16
    }

    public String s() {
        return this.f13296w0;
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
        this.f13256c0 = null;
        this.K = Float.NaN;
        this.f13258d0 = 0;
        this.f13260e0 = 0;
        this.f13262f0 = 0.0f;
        this.f13264g0 = -1;
        this.f13266h0 = 0;
        this.f13268i0 = 0;
        this.f13274l0 = 0;
        this.f13276m0 = 0;
        this.f13278n0 = 0;
        this.f13280o0 = 0;
        this.f13282p0 = 0;
        float r10 = U0;
        this.f13284q0 = r10;
        this.f13286r0 = r10;
        DimensionBehaviour[] r11 = this.f13254b0;
        DimensionBehaviour r12 = DimensionBehaviour.FIXED;
        r11[0] = r12;
        r11[1] = r12;
        this.f13288s0 = null;
        this.f13290t0 = 0;
        this.f13292u0 = 0;
        this.f13298x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] r13 = this.N0;
        r13[0] = -1.0f;
        r13[1] = -1.0f;
        this.f13289t = -1;
        this.f13291u = -1;
        int[] r14 = this.f13250J;
        r14[0] = Integer.MAX_VALUE;
        r14[1] = Integer.MAX_VALUE;
        this.f13295w = 0;
        this.f13297x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Channel.UNLIMITED;
        this.D = Channel.UNLIMITED;
        this.f13301z = 0;
        this.C = 0;
        this.f13265h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] r15 = this.f13263g;
        r15[0] = true;
        r15[1] = true;
        this.N = false;
        boolean[] r16 = this.f13252a0;
        r16[0] = false;
        r16[1] = false;
        this.f13267i = true;
        int[] r17 = this.f13299y;
        r17[0] = 0;
        r17[1] = 0;
        this.f13273l = -1;
        this.f13275m = -1;
    }

    public void s1(LinearSystem r10, boolean r11) {
        int r12 = r10.y(this.Q);
        int r13 = r10.y(this.R);
        int r14 = r10.y(this.S);
        int r15 = r10.y(this.T);
        if (r11 == false) goto L11;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i r16 = this.f13259e;
        if (r16 == null) goto L11;
        DependencyNode r17 = r16.f13341h;
        if (r17.f13331j == false) goto L11;
        DependencyNode r18 = r16.f13342i;
        if (r18.f13331j == false) goto L11;
        r12 = r17.f13328g;
        r14 = r18.f13328g;
    L11:
        if (r11 == false) goto L19;
        k r19 = this.f13261f;
        if (r19 == null) goto L19;
        DependencyNode r20 = r19.f13341h;
        if (r20.f13331j == false) goto L19;
        DependencyNode r21 = r19.f13342i;
        if (r21.f13331j == false) goto L19;
        r13 = r20.f13328g;
        r15 = r21.f13328g;
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
        L0(r12, r13, r14, r15);
        return;
    L32:
        r12 = 0;
        r15 = 0;
        r13 = 0;
        r14 = 0;
        goto L33
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
        f1(U0);
        O0(U0);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        String r11 = "";
        if (this.f13298x0 == null) goto L5;
        String r12 = "type: " + this.f13298x0 + " ";
    L6:
        r10.append(r12);
        if (this.f13296w0 == null) goto L9;
        r11 = "id: " + this.f13296w0 + " ";
    L9:
        r10.append(r11);
        r10.append("(");
        r10.append(this.f13266h0);
        r10.append(", ");
        r10.append(this.f13268i0);
        r10.append(") - (");
        r10.append(this.f13258d0);
        r10.append(" x ");
        r10.append(this.f13260e0);
        r10.append(")");
        return r10.toString();
    L5:
        r12 = "";
        goto L6
    }

    public float u() {
        return this.f13262f0;
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
        if ((r10 instanceof d) == false) goto L9;
        if (((d) J()).O1() == false) goto L9;
    }

    public int v() {
        return this.f13264g0;
    }

    public void v0() {
        int r10 = 0;
        this.f13281p = false;
        this.f13283q = false;
        this.f13285r = false;
        this.f13287s = false;
        int r11 = this.Z.size();
    L3:
        if (r10 >= r11) goto L5;
        ((ConstraintAnchor) this.Z.get(r10)).r();
        r10 = r10 + 1;
        goto L3
    }

    public int w() {
        if (this.f13292u0 != 8) goto L7;
        return 0;
    L7:
        return this.f13260e0;
    }

    public void w0(com.obric.oui.constraintlayout.core.b r10) {
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
        return this.f13284q0;
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
        return this.f13254b0[0];
    }

    public final void z0(StringBuilder r10, String r11, String r12, String r13) {
        if (r13.equals(r12) == false) goto L5;
        return;
    L5:
        r10.append(r11);
        r10.append(" :   ");
        r10.append(r12);
        r10.append(",\n");
    }
}
