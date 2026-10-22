package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import l0.C4855a;
import n0.C4934a;
import p0.C5035c;

/* loaded from: classes.dex */
public class ConstraintWidget {

    /* renamed from: U0, reason: collision with root package name */
    public static float f11931U0 = 0.5f;

    /* renamed from: A0, reason: collision with root package name */
    public int f11933A0;

    /* renamed from: B0, reason: collision with root package name */
    public int f11935B0;

    /* renamed from: C0, reason: collision with root package name */
    public boolean f11937C0;

    /* renamed from: D0, reason: collision with root package name */
    public boolean f11939D0;

    /* renamed from: E0, reason: collision with root package name */
    public boolean f11941E0;

    /* renamed from: F, reason: collision with root package name */
    public boolean f11942F;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f11943F0;

    /* renamed from: G, reason: collision with root package name */
    public boolean f11944G;

    /* renamed from: G0, reason: collision with root package name */
    public boolean f11945G0;

    /* renamed from: H0, reason: collision with root package name */
    public boolean f11947H0;

    /* renamed from: I0, reason: collision with root package name */
    public boolean f11949I0;

    /* renamed from: J0, reason: collision with root package name */
    public int f11951J0;

    /* renamed from: K0, reason: collision with root package name */
    public int f11953K0;

    /* renamed from: L0, reason: collision with root package name */
    public boolean f11955L0;

    /* renamed from: M, reason: collision with root package name */
    public boolean f11956M;

    /* renamed from: M0, reason: collision with root package name */
    public boolean f11957M0;

    /* renamed from: N0, reason: collision with root package name */
    public float[] f11959N0;

    /* renamed from: O0, reason: collision with root package name */
    public ConstraintWidget[] f11961O0;

    /* renamed from: P0, reason: collision with root package name */
    public ConstraintWidget[] f11963P0;

    /* renamed from: Q0, reason: collision with root package name */
    public ConstraintWidget f11965Q0;

    /* renamed from: R0, reason: collision with root package name */
    public ConstraintWidget f11967R0;

    /* renamed from: S0, reason: collision with root package name */
    public int f11969S0;

    /* renamed from: T0, reason: collision with root package name */
    public int f11971T0;

    /* renamed from: X, reason: collision with root package name */
    public ConstraintAnchor f11975X;

    /* renamed from: Y, reason: collision with root package name */
    public ConstraintAnchor[] f11976Y;

    /* renamed from: Z, reason: collision with root package name */
    public ArrayList<ConstraintAnchor> f11977Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean[] f11979a0;

    /* renamed from: b0, reason: collision with root package name */
    public DimensionBehaviour[] f11981b0;

    /* renamed from: c, reason: collision with root package name */
    public C5035c f11982c;

    /* renamed from: c0, reason: collision with root package name */
    public ConstraintWidget f11983c0;

    /* renamed from: d, reason: collision with root package name */
    public C5035c f11984d;

    /* renamed from: d0, reason: collision with root package name */
    public int f11985d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f11987e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f11989f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f11991g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f11993h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f11995i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f11997j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f11999k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f12001l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f12003m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f12005n0;

    /* renamed from: o, reason: collision with root package name */
    public String f12006o;

    /* renamed from: o0, reason: collision with root package name */
    public int f12007o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f12009p0;

    /* renamed from: q0, reason: collision with root package name */
    public float f12011q0;

    /* renamed from: r0, reason: collision with root package name */
    public float f12013r0;

    /* renamed from: s0, reason: collision with root package name */
    public Object f12015s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f12017t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f12019u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f12021v0;

    /* renamed from: w0, reason: collision with root package name */
    public String f12023w0;

    /* renamed from: x0, reason: collision with root package name */
    public String f12025x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f12027y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f12029z0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11978a = false;

    /* renamed from: b, reason: collision with root package name */
    public WidgetRun[] f11980b = new WidgetRun[2];

    /* renamed from: e, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.c f11986e = null;

    /* renamed from: f, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.d f11988f = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean[] f11990g = {true, true};

    /* renamed from: h, reason: collision with root package name */
    public boolean f11992h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11994i = true;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11996j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11998k = true;

    /* renamed from: l, reason: collision with root package name */
    public int f12000l = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f12002m = -1;

    /* renamed from: n, reason: collision with root package name */
    public C4934a f12004n = new C4934a(this);

    /* renamed from: p, reason: collision with root package name */
    public boolean f12008p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12010q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12012r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12014s = false;

    /* renamed from: t, reason: collision with root package name */
    public int f12016t = -1;

    /* renamed from: u, reason: collision with root package name */
    public int f12018u = -1;

    /* renamed from: v, reason: collision with root package name */
    public int f12020v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f12022w = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f12024x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int[] f12026y = new int[2];

    /* renamed from: z, reason: collision with root package name */
    public int f12028z = 0;

    /* renamed from: A, reason: collision with root package name */
    public int f11932A = 0;

    /* renamed from: B, reason: collision with root package name */
    public float f11934B = 1.0f;

    /* renamed from: C, reason: collision with root package name */
    public int f11936C = 0;

    /* renamed from: D, reason: collision with root package name */
    public int f11938D = 0;

    /* renamed from: E, reason: collision with root package name */
    public float f11940E = 1.0f;

    /* renamed from: H, reason: collision with root package name */
    public int f11946H = -1;

    /* renamed from: I, reason: collision with root package name */
    public float f11948I = 1.0f;

    /* renamed from: J, reason: collision with root package name */
    public int[] f11950J = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* renamed from: K, reason: collision with root package name */
    public float f11952K = Float.NaN;

    /* renamed from: L, reason: collision with root package name */
    public boolean f11954L = false;

    /* renamed from: N, reason: collision with root package name */
    public boolean f11958N = false;

    /* renamed from: O, reason: collision with root package name */
    public int f11960O = 0;

    /* renamed from: P, reason: collision with root package name */
    public int f11962P = 0;

    /* renamed from: Q, reason: collision with root package name */
    public ConstraintAnchor f11964Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);

    /* renamed from: R, reason: collision with root package name */
    public ConstraintAnchor f11966R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);

    /* renamed from: S, reason: collision with root package name */
    public ConstraintAnchor f11968S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);

    /* renamed from: T, reason: collision with root package name */
    public ConstraintAnchor f11970T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);

    /* renamed from: U, reason: collision with root package name */
    public ConstraintAnchor f11972U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);

    /* renamed from: V, reason: collision with root package name */
    public ConstraintAnchor f11973V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);

    /* renamed from: W, reason: collision with root package name */
    public ConstraintAnchor f11974W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12030a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f12030a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12030a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12030a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12030a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12030a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12030a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12030a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12030a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12030a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.f11975X = constraintAnchor;
        this.f11976Y = new ConstraintAnchor[]{this.f11964Q, this.f11968S, this.f11966R, this.f11970T, this.f11972U, constraintAnchor};
        this.f11977Z = new ArrayList<>();
        this.f11979a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.f11981b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f11983c0 = null;
        this.f11985d0 = 0;
        this.f11987e0 = 0;
        this.f11989f0 = 0.0f;
        this.f11991g0 = -1;
        this.f11993h0 = 0;
        this.f11995i0 = 0;
        this.f11997j0 = 0;
        this.f11999k0 = 0;
        this.f12001l0 = 0;
        this.f12003m0 = 0;
        this.f12005n0 = 0;
        float f10 = f11931U0;
        this.f12011q0 = f10;
        this.f12013r0 = f10;
        this.f12017t0 = 0;
        this.f12019u0 = 0;
        this.f12021v0 = false;
        this.f12023w0 = null;
        this.f12025x0 = null;
        this.f11949I0 = false;
        this.f11951J0 = 0;
        this.f11953K0 = 0;
        this.f11959N0 = new float[]{-1.0f, -1.0f};
        this.f11961O0 = new ConstraintWidget[]{null, null};
        this.f11963P0 = new ConstraintWidget[]{null, null};
        this.f11965Q0 = null;
        this.f11967R0 = null;
        this.f11969S0 = -1;
        this.f11971T0 = -1;
        d();
    }

    public float A() {
        return this.f12011q0;
    }

    public final void A0(StringBuilder sb2, String str, float f10, float f11) {
        if (f10 == f11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f10);
        sb2.append(",\n");
    }

    public int B() {
        return this.f11951J0;
    }

    public final void B0(StringBuilder sb2, String str, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(i10);
        sb2.append(",\n");
    }

    public DimensionBehaviour C() {
        return this.f11981b0[0];
    }

    public final void C0(StringBuilder sb2, String str, String str2, String str3) {
        if (str3.equals(str2)) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(str2);
        sb2.append(",\n");
    }

    public int D() {
        ConstraintAnchor constraintAnchor = this.f11964Q;
        int i10 = constraintAnchor != null ? constraintAnchor.f11928g : 0;
        ConstraintAnchor constraintAnchor2 = this.f11968S;
        return constraintAnchor2 != null ? i10 + constraintAnchor2.f11928g : i10;
    }

    public final void D0(StringBuilder sb2, String str, float f10, int i10) {
        if (f10 == 0.0f) {
            return;
        }
        sb2.append(str);
        sb2.append(" :  [");
        sb2.append(f10);
        sb2.append(Const.STR_MART_COMMA);
        sb2.append(i10);
        sb2.append("");
        sb2.append("],\n");
    }

    public int E() {
        return this.f11960O;
    }

    public void E0(boolean z10) {
        this.f12021v0 = z10;
    }

    public int F() {
        return this.f11962P;
    }

    public void F0(int i10) {
        this.f12005n0 = i10;
        this.f11954L = i10 > 0;
    }

    public int G(int i10) {
        if (i10 == 0) {
            return Y();
        }
        if (i10 == 1) {
            return z();
        }
        return 0;
    }

    public void G0(Object obj) {
        this.f12015s0 = obj;
    }

    public int H() {
        return this.f11950J[1];
    }

    public void H0(String str) {
        this.f12023w0 = str;
    }

    public int I() {
        return this.f11950J[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086 A[PHI: r0
      0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void I0(java.lang.String r9) throws java.lang.NumberFormatException {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L90
            int r1 = r9.length()
            if (r1 != 0) goto Lb
            goto L90
        Lb:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L39
            int r6 = r1 + (-1)
            if (r2 >= r6) goto L39
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L2b
            goto L36
        L2b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L35
            r3 = r4
            goto L36
        L35:
            r3 = r5
        L36:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L39:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L77
            int r1 = r1 - r4
            if (r2 >= r1) goto L77
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L86
            int r2 = r9.length()
            if (r2 <= 0) goto L86
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> L86
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L86
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L86
            if (r5 != r4) goto L71
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L71:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L77:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L86
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L86:
            r9 = r0
        L87:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L8f
            r8.f11989f0 = r9
            r8.f11991g0 = r5
        L8f:
            return
        L90:
            r8.f11989f0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.I0(java.lang.String):void");
    }

    public int J() {
        return this.f12009p0;
    }

    public void J0(int i10) {
        if (this.f11954L) {
            int i11 = i10 - this.f12005n0;
            int i12 = this.f11987e0 + i11;
            this.f11995i0 = i11;
            this.f11966R.t(i11);
            this.f11970T.t(i12);
            this.f11972U.t(i10);
            this.f12010q = true;
        }
    }

    public int K() {
        return this.f12007o0;
    }

    public void K0(int i10, int i11) {
        if (this.f12008p) {
            return;
        }
        this.f11964Q.t(i10);
        this.f11968S.t(i11);
        this.f11993h0 = i10;
        this.f11985d0 = i11 - i10;
        this.f12008p = true;
    }

    public ConstraintWidget L(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 != 0) {
            if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.f11970T).f11927f) != null && constraintAnchor2.f11927f == constraintAnchor) {
                return constraintAnchor2.f11925d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.f11968S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f11927f;
        if (constraintAnchor4 == null || constraintAnchor4.f11927f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f11925d;
    }

    public void L0(int i10) {
        this.f11964Q.t(i10);
        this.f11993h0 = i10;
    }

    public ConstraintWidget M() {
        return this.f11983c0;
    }

    public void M0(int i10) {
        this.f11966R.t(i10);
        this.f11995i0 = i10;
    }

    public ConstraintWidget N(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 != 0) {
            if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.f11966R).f11927f) != null && constraintAnchor2.f11927f == constraintAnchor) {
                return constraintAnchor2.f11925d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.f11964Q;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f11927f;
        if (constraintAnchor4 == null || constraintAnchor4.f11927f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f11925d;
    }

    public void N0(int i10, int i11) {
        if (this.f12010q) {
            return;
        }
        this.f11966R.t(i10);
        this.f11970T.t(i11);
        this.f11995i0 = i10;
        this.f11987e0 = i11 - i10;
        if (this.f11954L) {
            this.f11972U.t(i10 + this.f12005n0);
        }
        this.f12010q = true;
    }

    public int O() {
        return Z() + this.f11985d0;
    }

    public void O0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.f11993h0 = i10;
        this.f11995i0 = i11;
        if (this.f12019u0 == 8) {
            this.f11985d0 = 0;
            this.f11987e0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.f11981b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i16 < (i15 = this.f11985d0)) {
            i16 = i15;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i17 < (i14 = this.f11987e0)) {
            i17 = i14;
        }
        this.f11985d0 = i16;
        this.f11987e0 = i17;
        int i18 = this.f12009p0;
        if (i17 < i18) {
            this.f11987e0 = i18;
        }
        int i19 = this.f12007o0;
        if (i16 < i19) {
            this.f11985d0 = i19;
        }
        int i20 = this.f11932A;
        if (i20 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f11985d0 = Math.min(this.f11985d0, i20);
        }
        int i21 = this.f11938D;
        if (i21 > 0 && this.f11981b0[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f11987e0 = Math.min(this.f11987e0, i21);
        }
        int i22 = this.f11985d0;
        if (i16 != i22) {
            this.f12000l = i22;
        }
        int i23 = this.f11987e0;
        if (i17 != i23) {
            this.f12002m = i23;
        }
    }

    public WidgetRun P(int i10) {
        if (i10 == 0) {
            return this.f11986e;
        }
        if (i10 == 1) {
            return this.f11988f;
        }
        return null;
    }

    public void P0(boolean z10) {
        this.f11954L = z10;
    }

    public void Q(StringBuilder sb2) {
        sb2.append("  " + this.f12006o + ":{\n");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("    actualWidth:");
        sb3.append(this.f11985d0);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.f11987e0);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.f11993h0);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.f11995i0);
        sb2.append("\n");
        S(sb2, "left", this.f11964Q);
        S(sb2, "top", this.f11966R);
        S(sb2, "right", this.f11968S);
        S(sb2, "bottom", this.f11970T);
        S(sb2, "baseline", this.f11972U);
        S(sb2, "centerX", this.f11973V);
        S(sb2, "centerY", this.f11974W);
        R(sb2, "    width", this.f11985d0, this.f12007o0, this.f11950J[0], this.f12000l, this.f12028z, this.f12022w, this.f11934B, this.f11981b0[0], this.f11959N0[0]);
        R(sb2, "    height", this.f11987e0, this.f12009p0, this.f11950J[1], this.f12002m, this.f11936C, this.f12024x, this.f11940E, this.f11981b0[1], this.f11959N0[1]);
        D0(sb2, "    dimensionRatio", this.f11989f0, this.f11991g0);
        A0(sb2, "    horizontalBias", this.f12011q0, f11931U0);
        A0(sb2, "    verticalBias", this.f12013r0, f11931U0);
        B0(sb2, "    horizontalChainStyle", this.f11951J0, 0);
        B0(sb2, "    verticalChainStyle", this.f11953K0, 0);
        sb2.append("  }");
    }

    public void Q0(int i10) {
        this.f11987e0 = i10;
        int i11 = this.f12009p0;
        if (i10 < i11) {
            this.f11987e0 = i11;
        }
    }

    public final void R(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, int i15, float f10, DimensionBehaviour dimensionBehaviour, float f11) {
        sb2.append(str);
        sb2.append(" :  {\n");
        C0(sb2, "      behavior", dimensionBehaviour.toString(), DimensionBehaviour.FIXED.toString());
        B0(sb2, "      size", i10, 0);
        B0(sb2, "      min", i11, 0);
        B0(sb2, "      max", i12, Integer.MAX_VALUE);
        B0(sb2, "      matchMin", i14, 0);
        B0(sb2, "      matchDef", i15, 0);
        A0(sb2, "      matchPercent", f10, 1.0f);
        sb2.append("    },\n");
    }

    public void R0(float f10) {
        this.f12011q0 = f10;
    }

    public final void S(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f11927f == null) {
            return;
        }
        sb2.append("    ");
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(constraintAnchor.f11927f);
        sb2.append("'");
        if (constraintAnchor.f11929h != Integer.MIN_VALUE || constraintAnchor.f11928g != 0) {
            sb2.append(Const.STR_MART_COMMA);
            sb2.append(constraintAnchor.f11928g);
            if (constraintAnchor.f11929h != Integer.MIN_VALUE) {
                sb2.append(Const.STR_MART_COMMA);
                sb2.append(constraintAnchor.f11929h);
                sb2.append(Const.STR_MART_COMMA);
            }
        }
        sb2.append(" ] ,\n");
    }

    public void S0(int i10) {
        this.f11951J0 = i10;
    }

    public float T() {
        return this.f12013r0;
    }

    public void T0(int i10, int i11) {
        this.f11993h0 = i10;
        int i12 = i11 - i10;
        this.f11985d0 = i12;
        int i13 = this.f12007o0;
        if (i12 < i13) {
            this.f11985d0 = i13;
        }
    }

    public int U() {
        return this.f11953K0;
    }

    public void U0(DimensionBehaviour dimensionBehaviour) {
        this.f11981b0[0] = dimensionBehaviour;
    }

    public DimensionBehaviour V() {
        return this.f11981b0[1];
    }

    public void V0(int i10, int i11, int i12, float f10) {
        this.f12022w = i10;
        this.f12028z = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f11932A = i12;
        this.f11934B = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f12022w = 2;
    }

    public int W() {
        int i10 = this.f11964Q != null ? this.f11966R.f11928g : 0;
        return this.f11968S != null ? i10 + this.f11970T.f11928g : i10;
    }

    public void W0(float f10) {
        this.f11959N0[0] = f10;
    }

    public int X() {
        return this.f12019u0;
    }

    public void X0(int i10, boolean z10) {
        this.f11979a0[i10] = z10;
    }

    public int Y() {
        if (this.f12019u0 == 8) {
            return 0;
        }
        return this.f11985d0;
    }

    public void Y0(boolean z10) {
        this.f11956M = z10;
    }

    public int Z() {
        ConstraintWidget constraintWidget = this.f11983c0;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f11993h0 : ((d) constraintWidget).f12092c1 + this.f11993h0;
    }

    public void Z0(boolean z10) {
        this.f11958N = z10;
    }

    public int a0() {
        ConstraintWidget constraintWidget = this.f11983c0;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f11995i0 : ((d) constraintWidget).f12093d1 + this.f11995i0;
    }

    public void a1(int i10, int i11) {
        this.f11960O = i10;
        this.f11962P = i11;
        d1(false);
    }

    public boolean b0() {
        return this.f11954L;
    }

    public void b1(int i10) {
        this.f11950J[1] = i10;
    }

    public boolean c0(int i10) {
        if (i10 == 0) {
            return (this.f11964Q.f11927f != null ? 1 : 0) + (this.f11968S.f11927f != null ? 1 : 0) < 2;
        }
        return ((this.f11966R.f11927f != null ? 1 : 0) + (this.f11970T.f11927f != null ? 1 : 0)) + (this.f11972U.f11927f != null ? 1 : 0) < 2;
    }

    public void c1(int i10) {
        this.f11950J[0] = i10;
    }

    public final void d() {
        this.f11977Z.add(this.f11964Q);
        this.f11977Z.add(this.f11966R);
        this.f11977Z.add(this.f11968S);
        this.f11977Z.add(this.f11970T);
        this.f11977Z.add(this.f11973V);
        this.f11977Z.add(this.f11974W);
        this.f11977Z.add(this.f11975X);
        this.f11977Z.add(this.f11972U);
    }

    public boolean d0() {
        int size = this.f11977Z.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f11977Z.get(i10).m()) {
                return true;
            }
        }
        return false;
    }

    public void d1(boolean z10) {
        this.f11994i = z10;
    }

    public void e(d dVar, androidx.constraintlayout.core.c cVar, HashSet<ConstraintWidget> hashSet, int i10, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            g.a(dVar, cVar, this);
            hashSet.remove(this);
            g(cVar, dVar.Z1(64));
        }
        if (i10 == 0) {
            HashSet<ConstraintAnchor> hashSetD = this.f11964Q.d();
            if (hashSetD != null) {
                Iterator<ConstraintAnchor> it = hashSetD.iterator();
                while (it.hasNext()) {
                    it.next().f11925d.e(dVar, cVar, hashSet, i10, true);
                }
            }
            HashSet<ConstraintAnchor> hashSetD2 = this.f11968S.d();
            if (hashSetD2 != null) {
                Iterator<ConstraintAnchor> it2 = hashSetD2.iterator();
                while (it2.hasNext()) {
                    it2.next().f11925d.e(dVar, cVar, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> hashSetD3 = this.f11966R.d();
        if (hashSetD3 != null) {
            Iterator<ConstraintAnchor> it3 = hashSetD3.iterator();
            while (it3.hasNext()) {
                it3.next().f11925d.e(dVar, cVar, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> hashSetD4 = this.f11970T.d();
        if (hashSetD4 != null) {
            Iterator<ConstraintAnchor> it4 = hashSetD4.iterator();
            while (it4.hasNext()) {
                it4.next().f11925d.e(dVar, cVar, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> hashSetD5 = this.f11972U.d();
        if (hashSetD5 != null) {
            Iterator<ConstraintAnchor> it5 = hashSetD5.iterator();
            while (it5.hasNext()) {
                it5.next().f11925d.e(dVar, cVar, hashSet, i10, true);
            }
        }
    }

    public boolean e0() {
        return (this.f12000l == -1 && this.f12002m == -1) ? false : true;
    }

    public void e1(int i10) {
        if (i10 < 0) {
            this.f12009p0 = 0;
        } else {
            this.f12009p0 = i10;
        }
    }

    public boolean f() {
        return (this instanceof i) || (this instanceof f);
    }

    public boolean f0(int i10, int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor3 = this.f11964Q.f11927f;
            return constraintAnchor3 != null && constraintAnchor3.n() && (constraintAnchor2 = this.f11968S.f11927f) != null && constraintAnchor2.n() && (this.f11968S.f11927f.e() - this.f11968S.f()) - (this.f11964Q.f11927f.e() + this.f11964Q.f()) >= i11;
        }
        ConstraintAnchor constraintAnchor4 = this.f11966R.f11927f;
        if (constraintAnchor4 != null && constraintAnchor4.n() && (constraintAnchor = this.f11970T.f11927f) != null && constraintAnchor.n() && (this.f11970T.f11927f.e() - this.f11970T.f()) - (this.f11966R.f11927f.e() + this.f11966R.f()) >= i11) {
            return true;
        }
        return false;
    }

    public void f1(int i10) {
        if (i10 < 0) {
            this.f12007o0 = 0;
        } else {
            this.f12007o0 = i10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x056f  */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(androidx.constraintlayout.core.c r51, boolean r52) {
        /*
            Method dump skipped, instructions count: 1427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.c, boolean):void");
    }

    public void g0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10, int i11) {
        q(type).b(constraintWidget.q(type2), i10, i11, true);
    }

    public void g1(int i10, int i11) {
        this.f11993h0 = i10;
        this.f11995i0 = i11;
    }

    public boolean h() {
        return this.f12019u0 != 8;
    }

    public final boolean h0(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i11 = i10 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.f11976Y;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i11];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f11927f;
        return (constraintAnchor4 == null || constraintAnchor4.f11927f == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i11 + 1]).f11927f) == null || constraintAnchor2.f11927f != constraintAnchor) ? false : true;
    }

    public void h1(ConstraintWidget constraintWidget) {
        this.f11983c0 = constraintWidget;
    }

    /* JADX WARN: Removed duplicated region for block: B:362:0x0582  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(androidx.constraintlayout.core.c r31, boolean r32, boolean r33, boolean r34, boolean r35, androidx.constraintlayout.core.SolverVariable r36, androidx.constraintlayout.core.SolverVariable r37, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r38, boolean r39, androidx.constraintlayout.core.widgets.ConstraintAnchor r40, androidx.constraintlayout.core.widgets.ConstraintAnchor r41, int r42, int r43, int r44, int r45, float r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        /*
            Method dump skipped, instructions count: 1418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.i(androidx.constraintlayout.core.c, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public boolean i0() {
        return this.f12012r;
    }

    public void i1(float f10) {
        this.f12013r0 = f10;
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        k(type, constraintWidget, type2, 0);
    }

    public boolean j0(int i10) {
        return this.f11979a0[i10];
    }

    public void j1(int i10) {
        this.f11953K0 = i10;
    }

    public void k(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z10;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 != type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                if (type2 == type6 || type2 == ConstraintAnchor.Type.RIGHT) {
                    k(type6, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                    q(type5).a(constraintWidget.q(type2), 0);
                    return;
                }
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.TOP;
                if (type2 == type7 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    k(type7, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    q(type5).a(constraintWidget.q(type2), 0);
                    return;
                }
                return;
            }
            ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor constraintAnchorQ = q(type8);
            ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor constraintAnchorQ2 = q(type9);
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor constraintAnchorQ3 = q(type10);
            ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor constraintAnchorQ4 = q(type11);
            boolean z11 = true;
            if ((constraintAnchorQ == null || !constraintAnchorQ.o()) && (constraintAnchorQ2 == null || !constraintAnchorQ2.o())) {
                k(type8, constraintWidget, type8, 0);
                k(type9, constraintWidget, type9, 0);
                z10 = true;
            } else {
                z10 = false;
            }
            if ((constraintAnchorQ3 == null || !constraintAnchorQ3.o()) && (constraintAnchorQ4 == null || !constraintAnchorQ4.o())) {
                k(type10, constraintWidget, type10, 0);
                k(type11, constraintWidget, type11, 0);
            } else {
                z11 = false;
            }
            if (z10 && z11) {
                q(type5).a(constraintWidget.q(type5), 0);
                return;
            }
            if (z10) {
                ConstraintAnchor.Type type12 = ConstraintAnchor.Type.CENTER_X;
                q(type12).a(constraintWidget.q(type12), 0);
                return;
            } else {
                if (z11) {
                    ConstraintAnchor.Type type13 = ConstraintAnchor.Type.CENTER_Y;
                    q(type13).a(constraintWidget.q(type13), 0);
                    return;
                }
                return;
            }
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor constraintAnchorQ5 = q(type4);
            ConstraintAnchor constraintAnchorQ6 = constraintWidget.q(type2);
            ConstraintAnchor constraintAnchorQ7 = q(ConstraintAnchor.Type.RIGHT);
            constraintAnchorQ5.a(constraintAnchorQ6, 0);
            constraintAnchorQ7.a(constraintAnchorQ6, 0);
            q(type14).a(constraintAnchorQ6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor constraintAnchorQ8 = constraintWidget.q(type2);
            q(type3).a(constraintAnchorQ8, 0);
            q(ConstraintAnchor.Type.BOTTOM).a(constraintAnchorQ8, 0);
            q(type15).a(constraintAnchorQ8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            q(type16).a(constraintWidget.q(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            q(type17).a(constraintWidget.q(type17), 0);
            q(type14).a(constraintWidget.q(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            q(type18).a(constraintWidget.q(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            q(type19).a(constraintWidget.q(type19), 0);
            q(type15).a(constraintWidget.q(type2), 0);
            return;
        }
        ConstraintAnchor constraintAnchorQ9 = q(type);
        ConstraintAnchor constraintAnchorQ10 = constraintWidget.q(type2);
        if (constraintAnchorQ9.p(constraintAnchorQ10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor constraintAnchorQ11 = q(ConstraintAnchor.Type.TOP);
                ConstraintAnchor constraintAnchorQ12 = q(ConstraintAnchor.Type.BOTTOM);
                if (constraintAnchorQ11 != null) {
                    constraintAnchorQ11.q();
                }
                if (constraintAnchorQ12 != null) {
                    constraintAnchorQ12.q();
                }
            } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                ConstraintAnchor constraintAnchorQ13 = q(type20);
                if (constraintAnchorQ13 != null) {
                    constraintAnchorQ13.q();
                }
                ConstraintAnchor constraintAnchorQ14 = q(type5);
                if (constraintAnchorQ14.j() != constraintAnchorQ10) {
                    constraintAnchorQ14.q();
                }
                ConstraintAnchor constraintAnchorG = q(type).g();
                ConstraintAnchor constraintAnchorQ15 = q(type15);
                if (constraintAnchorQ15.o()) {
                    constraintAnchorG.q();
                    constraintAnchorQ15.q();
                }
            } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor constraintAnchorQ16 = q(type5);
                if (constraintAnchorQ16.j() != constraintAnchorQ10) {
                    constraintAnchorQ16.q();
                }
                ConstraintAnchor constraintAnchorG2 = q(type).g();
                ConstraintAnchor constraintAnchorQ17 = q(type14);
                if (constraintAnchorQ17.o()) {
                    constraintAnchorG2.q();
                    constraintAnchorQ17.q();
                }
            }
            constraintAnchorQ9.a(constraintAnchorQ10, i10);
        }
    }

    public boolean k0() {
        ConstraintAnchor constraintAnchor = this.f11964Q;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f11927f;
        if (constraintAnchor2 != null && constraintAnchor2.f11927f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.f11968S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f11927f;
        return constraintAnchor4 != null && constraintAnchor4.f11927f == constraintAnchor3;
    }

    public void k1(int i10, int i11) {
        this.f11995i0 = i10;
        int i12 = i11 - i10;
        this.f11987e0 = i12;
        int i13 = this.f12009p0;
        if (i12 < i13) {
            this.f11987e0 = i13;
        }
    }

    public void l(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        if (constraintAnchor.h() == this) {
            k(constraintAnchor.k(), constraintAnchor2.h(), constraintAnchor2.k(), i10);
        }
    }

    public boolean l0() {
        return this.f11956M;
    }

    public void l1(DimensionBehaviour dimensionBehaviour) {
        this.f11981b0[1] = dimensionBehaviour;
    }

    public void m(ConstraintWidget constraintWidget, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        g0(type, constraintWidget, type, i10, 0);
        this.f11952K = f10;
    }

    public boolean m0() {
        ConstraintAnchor constraintAnchor = this.f11966R;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f11927f;
        if (constraintAnchor2 != null && constraintAnchor2.f11927f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.f11970T;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f11927f;
        return constraintAnchor4 != null && constraintAnchor4.f11927f == constraintAnchor3;
    }

    public void m1(int i10, int i11, int i12, float f10) {
        this.f12024x = i10;
        this.f11936C = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f11938D = i12;
        this.f11940E = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f12024x = 2;
    }

    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        this.f12016t = constraintWidget.f12016t;
        this.f12018u = constraintWidget.f12018u;
        this.f12022w = constraintWidget.f12022w;
        this.f12024x = constraintWidget.f12024x;
        int[] iArr = this.f12026y;
        int[] iArr2 = constraintWidget.f12026y;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.f12028z = constraintWidget.f12028z;
        this.f11932A = constraintWidget.f11932A;
        this.f11936C = constraintWidget.f11936C;
        this.f11938D = constraintWidget.f11938D;
        this.f11940E = constraintWidget.f11940E;
        this.f11942F = constraintWidget.f11942F;
        this.f11944G = constraintWidget.f11944G;
        this.f11946H = constraintWidget.f11946H;
        this.f11948I = constraintWidget.f11948I;
        int[] iArr3 = constraintWidget.f11950J;
        this.f11950J = Arrays.copyOf(iArr3, iArr3.length);
        this.f11952K = constraintWidget.f11952K;
        this.f11954L = constraintWidget.f11954L;
        this.f11956M = constraintWidget.f11956M;
        this.f11964Q.q();
        this.f11966R.q();
        this.f11968S.q();
        this.f11970T.q();
        this.f11972U.q();
        this.f11973V.q();
        this.f11974W.q();
        this.f11975X.q();
        this.f11981b0 = (DimensionBehaviour[]) Arrays.copyOf(this.f11981b0, 2);
        this.f11983c0 = this.f11983c0 == null ? null : map.get(constraintWidget.f11983c0);
        this.f11985d0 = constraintWidget.f11985d0;
        this.f11987e0 = constraintWidget.f11987e0;
        this.f11989f0 = constraintWidget.f11989f0;
        this.f11991g0 = constraintWidget.f11991g0;
        this.f11993h0 = constraintWidget.f11993h0;
        this.f11995i0 = constraintWidget.f11995i0;
        this.f11997j0 = constraintWidget.f11997j0;
        this.f11999k0 = constraintWidget.f11999k0;
        this.f12001l0 = constraintWidget.f12001l0;
        this.f12003m0 = constraintWidget.f12003m0;
        this.f12005n0 = constraintWidget.f12005n0;
        this.f12007o0 = constraintWidget.f12007o0;
        this.f12009p0 = constraintWidget.f12009p0;
        this.f12011q0 = constraintWidget.f12011q0;
        this.f12013r0 = constraintWidget.f12013r0;
        this.f12015s0 = constraintWidget.f12015s0;
        this.f12017t0 = constraintWidget.f12017t0;
        this.f12019u0 = constraintWidget.f12019u0;
        this.f12021v0 = constraintWidget.f12021v0;
        this.f12023w0 = constraintWidget.f12023w0;
        this.f12025x0 = constraintWidget.f12025x0;
        this.f12027y0 = constraintWidget.f12027y0;
        this.f12029z0 = constraintWidget.f12029z0;
        this.f11933A0 = constraintWidget.f11933A0;
        this.f11935B0 = constraintWidget.f11935B0;
        this.f11937C0 = constraintWidget.f11937C0;
        this.f11939D0 = constraintWidget.f11939D0;
        this.f11941E0 = constraintWidget.f11941E0;
        this.f11943F0 = constraintWidget.f11943F0;
        this.f11945G0 = constraintWidget.f11945G0;
        this.f11947H0 = constraintWidget.f11947H0;
        this.f11951J0 = constraintWidget.f11951J0;
        this.f11953K0 = constraintWidget.f11953K0;
        this.f11955L0 = constraintWidget.f11955L0;
        this.f11957M0 = constraintWidget.f11957M0;
        float[] fArr = this.f11959N0;
        float[] fArr2 = constraintWidget.f11959N0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.f11961O0;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.f11961O0;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.f11963P0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.f11963P0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.f11965Q0;
        this.f11965Q0 = constraintWidget2 == null ? null : map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.f11967R0;
        this.f11967R0 = constraintWidget3 != null ? map.get(constraintWidget3) : null;
    }

    public boolean n0() {
        return this.f11958N;
    }

    public void n1(float f10) {
        this.f11959N0[1] = f10;
    }

    public void o(androidx.constraintlayout.core.c cVar) {
        cVar.q(this.f11964Q);
        cVar.q(this.f11966R);
        cVar.q(this.f11968S);
        cVar.q(this.f11970T);
        if (this.f12005n0 > 0) {
            cVar.q(this.f11972U);
        }
    }

    public boolean o0() {
        return this.f11994i && this.f12019u0 != 8;
    }

    public void o1(int i10) {
        this.f12019u0 = i10;
    }

    public void p() {
        if (this.f11986e == null) {
            this.f11986e = new androidx.constraintlayout.core.widgets.analyzer.c(this);
        }
        if (this.f11988f == null) {
            this.f11988f = new androidx.constraintlayout.core.widgets.analyzer.d(this);
        }
    }

    public boolean p0() {
        if (this.f12008p) {
            return true;
        }
        return this.f11964Q.n() && this.f11968S.n();
    }

    public void p1(int i10) {
        this.f11985d0 = i10;
        int i11 = this.f12007o0;
        if (i10 < i11) {
            this.f11985d0 = i11;
        }
    }

    public ConstraintAnchor q(ConstraintAnchor.Type type) {
        switch (a.f12030a[type.ordinal()]) {
            case 1:
                return this.f11964Q;
            case 2:
                return this.f11966R;
            case 3:
                return this.f11968S;
            case 4:
                return this.f11970T;
            case 5:
                return this.f11972U;
            case 6:
                return this.f11975X;
            case 7:
                return this.f11973V;
            case 8:
                return this.f11974W;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public boolean q0() {
        if (this.f12010q) {
            return true;
        }
        return this.f11966R.n() && this.f11970T.n();
    }

    public void q1(int i10) {
        if (i10 < 0 || i10 > 3) {
            return;
        }
        this.f12020v = i10;
    }

    public int r() {
        return this.f12005n0;
    }

    public boolean r0() {
        return this.f12014s;
    }

    public void r1(int i10) {
        this.f11993h0 = i10;
    }

    public float s(int i10) {
        if (i10 == 0) {
            return this.f12011q0;
        }
        if (i10 == 1) {
            return this.f12013r0;
        }
        return -1.0f;
    }

    public void s0() {
        this.f12012r = true;
    }

    public void s1(int i10) {
        this.f11995i0 = i10;
    }

    public int t() {
        return a0() + this.f11987e0;
    }

    public void t0() {
        this.f12014s = true;
    }

    public void t1(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.f11946H == -1) {
            if (z12 && !z13) {
                this.f11946H = 0;
            } else if (!z12 && z13) {
                this.f11946H = 1;
                if (this.f11991g0 == -1) {
                    this.f11948I = 1.0f / this.f11948I;
                }
            }
        }
        if (this.f11946H == 0 && (!this.f11966R.o() || !this.f11970T.o())) {
            this.f11946H = 1;
        } else if (this.f11946H == 1 && (!this.f11964Q.o() || !this.f11968S.o())) {
            this.f11946H = 0;
        }
        if (this.f11946H == -1 && (!this.f11966R.o() || !this.f11970T.o() || !this.f11964Q.o() || !this.f11968S.o())) {
            if (this.f11966R.o() && this.f11970T.o()) {
                this.f11946H = 0;
            } else if (this.f11964Q.o() && this.f11968S.o()) {
                this.f11948I = 1.0f / this.f11948I;
                this.f11946H = 1;
            }
        }
        if (this.f11946H == -1) {
            int i10 = this.f12028z;
            if (i10 > 0 && this.f11936C == 0) {
                this.f11946H = 0;
            } else {
                if (i10 != 0 || this.f11936C <= 0) {
                    return;
                }
                this.f11948I = 1.0f / this.f11948I;
                this.f11946H = 1;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.f12025x0 != null) {
            str = "type: " + this.f12025x0 + " ";
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.f12023w0 != null) {
            str2 = "id: " + this.f12023w0 + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.f11993h0);
        sb2.append(", ");
        sb2.append(this.f11995i0);
        sb2.append(") - (");
        sb2.append(this.f11985d0);
        sb2.append(" x ");
        sb2.append(this.f11987e0);
        sb2.append(")");
        return sb2.toString();
    }

    public Object u() {
        return this.f12015s0;
    }

    public boolean u0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.f11981b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void u1(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean zK = z10 & this.f11986e.k();
        boolean zK2 = z11 & this.f11988f.k();
        androidx.constraintlayout.core.widgets.analyzer.c cVar = this.f11986e;
        int i12 = cVar.f12054h.f12041g;
        androidx.constraintlayout.core.widgets.analyzer.d dVar = this.f11988f;
        int i13 = dVar.f12054h.f12041g;
        int i14 = cVar.f12055i.f12041g;
        int i15 = dVar.f12055i.f12041g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (zK) {
            this.f11993h0 = i12;
        }
        if (zK2) {
            this.f11995i0 = i13;
        }
        if (this.f12019u0 == 8) {
            this.f11985d0 = 0;
            this.f11987e0 = 0;
            return;
        }
        if (zK) {
            if (this.f11981b0[0] == DimensionBehaviour.FIXED && i17 < (i11 = this.f11985d0)) {
                i17 = i11;
            }
            this.f11985d0 = i17;
            int i19 = this.f12007o0;
            if (i17 < i19) {
                this.f11985d0 = i19;
            }
        }
        if (zK2) {
            if (this.f11981b0[1] == DimensionBehaviour.FIXED && i18 < (i10 = this.f11987e0)) {
                i18 = i10;
            }
            this.f11987e0 = i18;
            int i20 = this.f12009p0;
            if (i18 < i20) {
                this.f11987e0 = i20;
            }
        }
    }

    public String v() {
        return this.f12023w0;
    }

    public void v0() {
        this.f11964Q.q();
        this.f11966R.q();
        this.f11968S.q();
        this.f11970T.q();
        this.f11972U.q();
        this.f11973V.q();
        this.f11974W.q();
        this.f11975X.q();
        this.f11983c0 = null;
        this.f11952K = Float.NaN;
        this.f11985d0 = 0;
        this.f11987e0 = 0;
        this.f11989f0 = 0.0f;
        this.f11991g0 = -1;
        this.f11993h0 = 0;
        this.f11995i0 = 0;
        this.f12001l0 = 0;
        this.f12003m0 = 0;
        this.f12005n0 = 0;
        this.f12007o0 = 0;
        this.f12009p0 = 0;
        float f10 = f11931U0;
        this.f12011q0 = f10;
        this.f12013r0 = f10;
        DimensionBehaviour[] dimensionBehaviourArr = this.f11981b0;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f12015s0 = null;
        this.f12017t0 = 0;
        this.f12019u0 = 0;
        this.f12025x0 = null;
        this.f11945G0 = false;
        this.f11947H0 = false;
        this.f11951J0 = 0;
        this.f11953K0 = 0;
        this.f11955L0 = false;
        this.f11957M0 = false;
        float[] fArr = this.f11959N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f12016t = -1;
        this.f12018u = -1;
        int[] iArr = this.f11950J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f12022w = 0;
        this.f12024x = 0;
        this.f11934B = 1.0f;
        this.f11940E = 1.0f;
        this.f11932A = Integer.MAX_VALUE;
        this.f11938D = Integer.MAX_VALUE;
        this.f12028z = 0;
        this.f11936C = 0;
        this.f11992h = false;
        this.f11946H = -1;
        this.f11948I = 1.0f;
        this.f11949I0 = false;
        boolean[] zArr = this.f11990g;
        zArr[0] = true;
        zArr[1] = true;
        this.f11958N = false;
        boolean[] zArr2 = this.f11979a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f11994i = true;
        int[] iArr2 = this.f12026y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f12000l = -1;
        this.f12002m = -1;
    }

    public void v1(androidx.constraintlayout.core.c cVar, boolean z10) {
        androidx.constraintlayout.core.widgets.analyzer.d dVar;
        androidx.constraintlayout.core.widgets.analyzer.c cVar2;
        int iY = cVar.y(this.f11964Q);
        int iY2 = cVar.y(this.f11966R);
        int iY3 = cVar.y(this.f11968S);
        int iY4 = cVar.y(this.f11970T);
        if (z10 && (cVar2 = this.f11986e) != null) {
            DependencyNode dependencyNode = cVar2.f12054h;
            if (dependencyNode.f12044j) {
                DependencyNode dependencyNode2 = cVar2.f12055i;
                if (dependencyNode2.f12044j) {
                    iY = dependencyNode.f12041g;
                    iY3 = dependencyNode2.f12041g;
                }
            }
        }
        if (z10 && (dVar = this.f11988f) != null) {
            DependencyNode dependencyNode3 = dVar.f12054h;
            if (dependencyNode3.f12044j) {
                DependencyNode dependencyNode4 = dVar.f12055i;
                if (dependencyNode4.f12044j) {
                    iY2 = dependencyNode3.f12041g;
                    iY4 = dependencyNode4.f12041g;
                }
            }
        }
        int i10 = iY4 - iY2;
        if (iY3 - iY < 0 || i10 < 0 || iY == Integer.MIN_VALUE || iY == Integer.MAX_VALUE || iY2 == Integer.MIN_VALUE || iY2 == Integer.MAX_VALUE || iY3 == Integer.MIN_VALUE || iY3 == Integer.MAX_VALUE || iY4 == Integer.MIN_VALUE || iY4 == Integer.MAX_VALUE) {
            iY = 0;
            iY4 = 0;
            iY2 = 0;
            iY3 = 0;
        }
        O0(iY, iY2, iY3, iY4);
    }

    public DimensionBehaviour w(int i10) {
        if (i10 == 0) {
            return C();
        }
        if (i10 == 1) {
            return V();
        }
        return null;
    }

    public void w0() {
        x0();
        i1(f11931U0);
        R0(f11931U0);
    }

    public float x() {
        return this.f11989f0;
    }

    public void x0() {
        ConstraintWidget constraintWidgetM = M();
        if (constraintWidgetM != null && (constraintWidgetM instanceof d) && ((d) M()).R1()) {
            return;
        }
        int size = this.f11977Z.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11977Z.get(i10).q();
        }
    }

    public int y() {
        return this.f11991g0;
    }

    public void y0() {
        this.f12008p = false;
        this.f12010q = false;
        this.f12012r = false;
        this.f12014s = false;
        int size = this.f11977Z.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11977Z.get(i10).r();
        }
    }

    public int z() {
        if (this.f12019u0 == 8) {
            return 0;
        }
        return this.f11987e0;
    }

    public void z0(C4855a c4855a) {
        this.f11964Q.s(c4855a);
        this.f11966R.s(c4855a);
        this.f11968S.s(c4855a);
        this.f11970T.s(c4855a);
        this.f11972U.s(c4855a);
        this.f11975X.s(c4855a);
        this.f11973V.s(c4855a);
        this.f11974W.s(c4855a);
    }
}
