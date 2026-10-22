package v;

import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.libpag.BuildConfig;
import s.C1045c;
import u.C1150a;
import v.d;
import w.C1197c;
import w.n;
import w.p;

/* loaded from: classes.dex */
public class e {

    /* renamed from: K0, reason: collision with root package name */
    public static float f23019K0 = 0.5f;

    /* renamed from: A0, reason: collision with root package name */
    int f23021A0;

    /* renamed from: B0, reason: collision with root package name */
    boolean f23023B0;

    /* renamed from: C0, reason: collision with root package name */
    boolean f23025C0;

    /* renamed from: D0, reason: collision with root package name */
    public float[] f23027D0;

    /* renamed from: E0, reason: collision with root package name */
    protected e[] f23029E0;

    /* renamed from: F0, reason: collision with root package name */
    protected e[] f23031F0;

    /* renamed from: G0, reason: collision with root package name */
    e f23033G0;

    /* renamed from: H0, reason: collision with root package name */
    e f23035H0;

    /* renamed from: I0, reason: collision with root package name */
    public int f23037I0;

    /* renamed from: J0, reason: collision with root package name */
    public int f23039J0;

    /* renamed from: K, reason: collision with root package name */
    private boolean f23040K;

    /* renamed from: V, reason: collision with root package name */
    public d f23051V;

    /* renamed from: W, reason: collision with root package name */
    public d[] f23052W;

    /* renamed from: X, reason: collision with root package name */
    protected ArrayList<d> f23053X;

    /* renamed from: Y, reason: collision with root package name */
    private boolean[] f23054Y;

    /* renamed from: Z, reason: collision with root package name */
    public b[] f23055Z;

    /* renamed from: a0, reason: collision with root package name */
    public e f23057a0;

    /* renamed from: b0, reason: collision with root package name */
    int f23059b0;

    /* renamed from: c, reason: collision with root package name */
    public C1197c f23060c;

    /* renamed from: c0, reason: collision with root package name */
    int f23061c0;

    /* renamed from: d, reason: collision with root package name */
    public C1197c f23062d;

    /* renamed from: d0, reason: collision with root package name */
    public float f23063d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f23065e0;

    /* renamed from: f0, reason: collision with root package name */
    protected int f23067f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f23069g0;

    /* renamed from: h0, reason: collision with root package name */
    int f23071h0;

    /* renamed from: i0, reason: collision with root package name */
    int f23073i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f23075j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f23077k0;

    /* renamed from: l0, reason: collision with root package name */
    int f23079l0;

    /* renamed from: m0, reason: collision with root package name */
    protected int f23081m0;

    /* renamed from: n0, reason: collision with root package name */
    protected int f23083n0;

    /* renamed from: o, reason: collision with root package name */
    public String f23084o;

    /* renamed from: o0, reason: collision with root package name */
    float f23085o0;

    /* renamed from: p0, reason: collision with root package name */
    float f23087p0;

    /* renamed from: q0, reason: collision with root package name */
    private Object f23089q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f23091r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f23093s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f23095t0;

    /* renamed from: u0, reason: collision with root package name */
    private String f23097u0;

    /* renamed from: v0, reason: collision with root package name */
    private String f23099v0;

    /* renamed from: w0, reason: collision with root package name */
    boolean f23101w0;

    /* renamed from: x0, reason: collision with root package name */
    boolean f23103x0;

    /* renamed from: y0, reason: collision with root package name */
    boolean f23105y0;

    /* renamed from: z0, reason: collision with root package name */
    int f23107z0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f23056a = false;

    /* renamed from: b, reason: collision with root package name */
    public p[] f23058b = new p[2];

    /* renamed from: e, reason: collision with root package name */
    public w.l f23064e = null;

    /* renamed from: f, reason: collision with root package name */
    public n f23066f = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean[] f23068g = {true, true};

    /* renamed from: h, reason: collision with root package name */
    boolean f23070h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f23072i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f23074j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f23076k = true;

    /* renamed from: l, reason: collision with root package name */
    private int f23078l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f23080m = -1;

    /* renamed from: n, reason: collision with root package name */
    public C1150a f23082n = new C1150a(this);

    /* renamed from: p, reason: collision with root package name */
    private boolean f23086p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f23088q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f23090r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f23092s = false;

    /* renamed from: t, reason: collision with root package name */
    public int f23094t = -1;

    /* renamed from: u, reason: collision with root package name */
    public int f23096u = -1;

    /* renamed from: v, reason: collision with root package name */
    private int f23098v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f23100w = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f23102x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int[] f23104y = new int[2];

    /* renamed from: z, reason: collision with root package name */
    public int f23106z = 0;

    /* renamed from: A, reason: collision with root package name */
    public int f23020A = 0;

    /* renamed from: B, reason: collision with root package name */
    public float f23022B = 1.0f;

    /* renamed from: C, reason: collision with root package name */
    public int f23024C = 0;

    /* renamed from: D, reason: collision with root package name */
    public int f23026D = 0;

    /* renamed from: E, reason: collision with root package name */
    public float f23028E = 1.0f;

    /* renamed from: F, reason: collision with root package name */
    int f23030F = -1;

    /* renamed from: G, reason: collision with root package name */
    float f23032G = 1.0f;

    /* renamed from: H, reason: collision with root package name */
    private int[] f23034H = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* renamed from: I, reason: collision with root package name */
    private float f23036I = 0.0f;

    /* renamed from: J, reason: collision with root package name */
    private boolean f23038J = false;

    /* renamed from: L, reason: collision with root package name */
    private boolean f23041L = false;

    /* renamed from: M, reason: collision with root package name */
    private int f23042M = 0;

    /* renamed from: N, reason: collision with root package name */
    private int f23043N = 0;

    /* renamed from: O, reason: collision with root package name */
    public d f23044O = new d(this, d.b.LEFT);

    /* renamed from: P, reason: collision with root package name */
    public d f23045P = new d(this, d.b.TOP);

    /* renamed from: Q, reason: collision with root package name */
    public d f23046Q = new d(this, d.b.RIGHT);

    /* renamed from: R, reason: collision with root package name */
    public d f23047R = new d(this, d.b.BOTTOM);

    /* renamed from: S, reason: collision with root package name */
    public d f23048S = new d(this, d.b.BASELINE);

    /* renamed from: T, reason: collision with root package name */
    d f23049T = new d(this, d.b.CENTER_X);

    /* renamed from: U, reason: collision with root package name */
    d f23050U = new d(this, d.b.CENTER_Y);

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23108a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f23109b;

        static {
            int[] iArr = new int[b.values().length];
            f23109b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23109b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23109b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23109b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f23108a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23108a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23108a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23108a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23108a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23108a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23108a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f23108a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f23108a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.f23051V = dVar;
        this.f23052W = new d[]{this.f23044O, this.f23046Q, this.f23045P, this.f23047R, this.f23048S, dVar};
        this.f23053X = new ArrayList<>();
        this.f23054Y = new boolean[2];
        b bVar = b.FIXED;
        this.f23055Z = new b[]{bVar, bVar};
        this.f23057a0 = null;
        this.f23059b0 = 0;
        this.f23061c0 = 0;
        this.f23063d0 = 0.0f;
        this.f23065e0 = -1;
        this.f23067f0 = 0;
        this.f23069g0 = 0;
        this.f23071h0 = 0;
        this.f23073i0 = 0;
        this.f23075j0 = 0;
        this.f23077k0 = 0;
        this.f23079l0 = 0;
        float f5 = f23019K0;
        this.f23085o0 = f5;
        this.f23087p0 = f5;
        this.f23091r0 = 0;
        this.f23093s0 = 0;
        this.f23095t0 = false;
        this.f23097u0 = null;
        this.f23099v0 = null;
        this.f23105y0 = false;
        this.f23107z0 = 0;
        this.f23021A0 = 0;
        this.f23027D0 = new float[]{-1.0f, -1.0f};
        this.f23029E0 = new e[]{null, null};
        this.f23031F0 = new e[]{null, null};
        this.f23033G0 = null;
        this.f23035H0 = null;
        this.f23037I0 = -1;
        this.f23039J0 = -1;
        d();
    }

    private void P(StringBuilder sb, String str, int i5, int i6, int i7, int i8, int i9, int i10, float f5, float f6) {
        sb.append(str);
        sb.append(" :  {\n");
        y0(sb, "      size", i5, 0);
        y0(sb, "      min", i6, 0);
        y0(sb, "      max", i7, Integer.MAX_VALUE);
        y0(sb, "      matchMin", i9, 0);
        y0(sb, "      matchDef", i10, 0);
        x0(sb, "      matchPercent", f5, 1.0f);
        sb.append("    },\n");
    }

    private void Q(StringBuilder sb, String str, d dVar) {
        if (dVar.f23004f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(dVar.f23004f);
        sb.append("'");
        if (dVar.f23006h != Integer.MIN_VALUE || dVar.f23005g != 0) {
            sb.append(",");
            sb.append(dVar.f23005g);
            if (dVar.f23006h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(dVar.f23006h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    private void d() {
        this.f23053X.add(this.f23044O);
        this.f23053X.add(this.f23045P);
        this.f23053X.add(this.f23046Q);
        this.f23053X.add(this.f23047R);
        this.f23053X.add(this.f23049T);
        this.f23053X.add(this.f23050U);
        this.f23053X.add(this.f23051V);
        this.f23053X.add(this.f23048S);
    }

    private boolean f0(int i5) {
        d dVar;
        d dVar2;
        int i6 = i5 * 2;
        d[] dVarArr = this.f23052W;
        d dVar3 = dVarArr[i6];
        d dVar4 = dVar3.f23004f;
        return (dVar4 == null || dVar4.f23004f == dVar3 || (dVar2 = (dVar = dVarArr[i6 + 1]).f23004f) == null || dVar2.f23004f != dVar) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0557 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:376:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i(s.d r31, boolean r32, boolean r33, boolean r34, boolean r35, s.i r36, s.i r37, v.e.b r38, boolean r39, v.d r40, v.d r41, int r42, int r43, int r44, int r45, float r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        /*
            Method dump skipped, instructions count: 1430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.e.i(s.d, boolean, boolean, boolean, boolean, s.i, s.i, v.e$b, boolean, v.d, v.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    private void x0(StringBuilder sb, String str, float f5, float f6) {
        if (f5 == f6) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f5);
        sb.append(",\n");
    }

    private void y0(StringBuilder sb, String str, int i5, int i6) {
        if (i5 == i6) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i5);
        sb.append(",\n");
    }

    private void z0(StringBuilder sb, String str, float f5, int i5) {
        if (f5 == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f5);
        sb.append(",");
        sb.append(i5);
        sb.append(BuildConfig.FLAVOR);
        sb.append("],\n");
    }

    public b A() {
        return this.f23055Z[0];
    }

    public void A0(int i5) {
        this.f23079l0 = i5;
        this.f23038J = i5 > 0;
    }

    public int B() {
        d dVar = this.f23044O;
        int i5 = dVar != null ? dVar.f23005g : 0;
        d dVar2 = this.f23046Q;
        return dVar2 != null ? i5 + dVar2.f23005g : i5;
    }

    public void B0(Object obj) {
        this.f23089q0 = obj;
    }

    public int C() {
        return this.f23042M;
    }

    public void C0(String str) {
        this.f23097u0 = str;
    }

    public int D() {
        return this.f23043N;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086 A[PHI: r0
      0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void D0(java.lang.String r9) throws java.lang.NumberFormatException {
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
            r8.f23063d0 = r9
            r8.f23065e0 = r5
        L8f:
            return
        L90:
            r8.f23063d0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.e.D0(java.lang.String):void");
    }

    public int E(int i5) {
        if (i5 == 0) {
            return W();
        }
        if (i5 == 1) {
            return x();
        }
        return 0;
    }

    public void E0(int i5) {
        if (this.f23038J) {
            int i6 = i5 - this.f23079l0;
            int i7 = this.f23061c0 + i6;
            this.f23069g0 = i6;
            this.f23045P.t(i6);
            this.f23047R.t(i7);
            this.f23048S.t(i5);
            this.f23088q = true;
        }
    }

    public int F() {
        return this.f23034H[1];
    }

    public void F0(int i5, int i6) {
        if (this.f23086p) {
            return;
        }
        this.f23044O.t(i5);
        this.f23046Q.t(i6);
        this.f23067f0 = i5;
        this.f23059b0 = i6 - i5;
        this.f23086p = true;
    }

    public int G() {
        return this.f23034H[0];
    }

    public void G0(int i5) {
        this.f23044O.t(i5);
        this.f23067f0 = i5;
    }

    public int H() {
        return this.f23083n0;
    }

    public void H0(int i5) {
        this.f23045P.t(i5);
        this.f23069g0 = i5;
    }

    public int I() {
        return this.f23081m0;
    }

    public void I0(int i5, int i6) {
        if (this.f23088q) {
            return;
        }
        this.f23045P.t(i5);
        this.f23047R.t(i6);
        this.f23069g0 = i5;
        this.f23061c0 = i6 - i5;
        if (this.f23038J) {
            this.f23048S.t(i5 + this.f23079l0);
        }
        this.f23088q = true;
    }

    public e J(int i5) {
        d dVar;
        d dVar2;
        if (i5 != 0) {
            if (i5 == 1 && (dVar2 = (dVar = this.f23047R).f23004f) != null && dVar2.f23004f == dVar) {
                return dVar2.f23002d;
            }
            return null;
        }
        d dVar3 = this.f23046Q;
        d dVar4 = dVar3.f23004f;
        if (dVar4 == null || dVar4.f23004f != dVar3) {
            return null;
        }
        return dVar4.f23002d;
    }

    public void J0(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11 = i7 - i5;
        int i12 = i8 - i6;
        this.f23067f0 = i5;
        this.f23069g0 = i6;
        if (this.f23093s0 == 8) {
            this.f23059b0 = 0;
            this.f23061c0 = 0;
            return;
        }
        b[] bVarArr = this.f23055Z;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i11 < (i10 = this.f23059b0)) {
            i11 = i10;
        }
        if (bVarArr[1] == bVar2 && i12 < (i9 = this.f23061c0)) {
            i12 = i9;
        }
        this.f23059b0 = i11;
        this.f23061c0 = i12;
        int i13 = this.f23083n0;
        if (i12 < i13) {
            this.f23061c0 = i13;
        }
        int i14 = this.f23081m0;
        if (i11 < i14) {
            this.f23059b0 = i14;
        }
        int i15 = this.f23020A;
        if (i15 > 0 && bVar == b.MATCH_CONSTRAINT) {
            this.f23059b0 = Math.min(this.f23059b0, i15);
        }
        int i16 = this.f23026D;
        if (i16 > 0 && this.f23055Z[1] == b.MATCH_CONSTRAINT) {
            this.f23061c0 = Math.min(this.f23061c0, i16);
        }
        int i17 = this.f23059b0;
        if (i11 != i17) {
            this.f23078l = i17;
        }
        int i18 = this.f23061c0;
        if (i12 != i18) {
            this.f23080m = i18;
        }
    }

    public e K() {
        return this.f23057a0;
    }

    public void K0(boolean z5) {
        this.f23038J = z5;
    }

    public e L(int i5) {
        d dVar;
        d dVar2;
        if (i5 != 0) {
            if (i5 == 1 && (dVar2 = (dVar = this.f23045P).f23004f) != null && dVar2.f23004f == dVar) {
                return dVar2.f23002d;
            }
            return null;
        }
        d dVar3 = this.f23044O;
        d dVar4 = dVar3.f23004f;
        if (dVar4 == null || dVar4.f23004f != dVar3) {
            return null;
        }
        return dVar4.f23002d;
    }

    public void L0(int i5) {
        this.f23061c0 = i5;
        int i6 = this.f23083n0;
        if (i5 < i6) {
            this.f23061c0 = i6;
        }
    }

    public int M() {
        return X() + this.f23059b0;
    }

    public void M0(float f5) {
        this.f23085o0 = f5;
    }

    public p N(int i5) {
        if (i5 == 0) {
            return this.f23064e;
        }
        if (i5 == 1) {
            return this.f23066f;
        }
        return null;
    }

    public void N0(int i5) {
        this.f23107z0 = i5;
    }

    public void O(StringBuilder sb) {
        sb.append("  " + this.f23084o + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.f23059b0);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.f23061c0);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f23067f0);
        sb.append("\n");
        sb.append("    actualTop:" + this.f23069g0);
        sb.append("\n");
        Q(sb, "left", this.f23044O);
        Q(sb, "top", this.f23045P);
        Q(sb, "right", this.f23046Q);
        Q(sb, "bottom", this.f23047R);
        Q(sb, "baseline", this.f23048S);
        Q(sb, "centerX", this.f23049T);
        Q(sb, "centerY", this.f23050U);
        P(sb, "    width", this.f23059b0, this.f23081m0, this.f23034H[0], this.f23078l, this.f23106z, this.f23100w, this.f23022B, this.f23027D0[0]);
        P(sb, "    height", this.f23061c0, this.f23083n0, this.f23034H[1], this.f23080m, this.f23024C, this.f23102x, this.f23028E, this.f23027D0[1]);
        z0(sb, "    dimensionRatio", this.f23063d0, this.f23065e0);
        x0(sb, "    horizontalBias", this.f23085o0, f23019K0);
        x0(sb, "    verticalBias", this.f23087p0, f23019K0);
        y0(sb, "    horizontalChainStyle", this.f23107z0, 0);
        y0(sb, "    verticalChainStyle", this.f23021A0, 0);
        sb.append("  }");
    }

    public void O0(int i5, int i6) {
        this.f23067f0 = i5;
        int i7 = i6 - i5;
        this.f23059b0 = i7;
        int i8 = this.f23081m0;
        if (i7 < i8) {
            this.f23059b0 = i8;
        }
    }

    public void P0(b bVar) {
        this.f23055Z[0] = bVar;
    }

    public void Q0(int i5, int i6, int i7, float f5) {
        this.f23100w = i5;
        this.f23106z = i6;
        if (i7 == Integer.MAX_VALUE) {
            i7 = 0;
        }
        this.f23020A = i7;
        this.f23022B = f5;
        if (f5 <= 0.0f || f5 >= 1.0f || i5 != 0) {
            return;
        }
        this.f23100w = 2;
    }

    public float R() {
        return this.f23087p0;
    }

    public void R0(float f5) {
        this.f23027D0[0] = f5;
    }

    public int S() {
        return this.f23021A0;
    }

    protected void S0(int i5, boolean z5) {
        this.f23054Y[i5] = z5;
    }

    public b T() {
        return this.f23055Z[1];
    }

    public void T0(boolean z5) {
        this.f23040K = z5;
    }

    public int U() {
        int i5 = this.f23044O != null ? this.f23045P.f23005g : 0;
        return this.f23046Q != null ? i5 + this.f23047R.f23005g : i5;
    }

    public void U0(boolean z5) {
        this.f23041L = z5;
    }

    public int V() {
        return this.f23093s0;
    }

    public void V0(int i5, int i6) {
        this.f23042M = i5;
        this.f23043N = i6;
        Y0(false);
    }

    public int W() {
        if (this.f23093s0 == 8) {
            return 0;
        }
        return this.f23059b0;
    }

    public void W0(int i5) {
        this.f23034H[1] = i5;
    }

    public int X() {
        e eVar = this.f23057a0;
        return (eVar == null || !(eVar instanceof f)) ? this.f23067f0 : ((f) eVar).f23121S0 + this.f23067f0;
    }

    public void X0(int i5) {
        this.f23034H[0] = i5;
    }

    public int Y() {
        e eVar = this.f23057a0;
        return (eVar == null || !(eVar instanceof f)) ? this.f23069g0 : ((f) eVar).f23122T0 + this.f23069g0;
    }

    public void Y0(boolean z5) {
        this.f23072i = z5;
    }

    public boolean Z() {
        return this.f23038J;
    }

    public void Z0(int i5) {
        if (i5 < 0) {
            this.f23083n0 = 0;
        } else {
            this.f23083n0 = i5;
        }
    }

    public boolean a0(int i5) {
        if (i5 == 0) {
            return (this.f23044O.f23004f != null ? 1 : 0) + (this.f23046Q.f23004f != null ? 1 : 0) < 2;
        }
        return ((this.f23045P.f23004f != null ? 1 : 0) + (this.f23047R.f23004f != null ? 1 : 0)) + (this.f23048S.f23004f != null ? 1 : 0) < 2;
    }

    public void a1(int i5) {
        if (i5 < 0) {
            this.f23081m0 = 0;
        } else {
            this.f23081m0 = i5;
        }
    }

    public boolean b0() {
        int size = this.f23053X.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f23053X.get(i5).m()) {
                return true;
            }
        }
        return false;
    }

    public void b1(int i5, int i6) {
        this.f23067f0 = i5;
        this.f23069g0 = i6;
    }

    public boolean c0() {
        return (this.f23078l == -1 && this.f23080m == -1) ? false : true;
    }

    public void c1(e eVar) {
        this.f23057a0 = eVar;
    }

    public boolean d0(int i5, int i6) {
        d dVar;
        d dVar2;
        if (i5 == 0) {
            d dVar3 = this.f23044O.f23004f;
            return dVar3 != null && dVar3.n() && (dVar2 = this.f23046Q.f23004f) != null && dVar2.n() && (this.f23046Q.f23004f.e() - this.f23046Q.f()) - (this.f23044O.f23004f.e() + this.f23044O.f()) >= i6;
        }
        d dVar4 = this.f23045P.f23004f;
        if (dVar4 != null && dVar4.n() && (dVar = this.f23047R.f23004f) != null && dVar.n() && (this.f23047R.f23004f.e() - this.f23047R.f()) - (this.f23045P.f23004f.e() + this.f23045P.f()) >= i6) {
            return true;
        }
        return false;
    }

    public void d1(float f5) {
        this.f23087p0 = f5;
    }

    public void e(f fVar, s.d dVar, HashSet<e> hashSet, int i5, boolean z5) {
        if (z5) {
            if (!hashSet.contains(this)) {
                return;
            }
            k.a(fVar, dVar, this);
            hashSet.remove(this);
            g(dVar, fVar.T1(64));
        }
        if (i5 == 0) {
            HashSet<d> hashSetD = this.f23044O.d();
            if (hashSetD != null) {
                Iterator<d> it = hashSetD.iterator();
                while (it.hasNext()) {
                    it.next().f23002d.e(fVar, dVar, hashSet, i5, true);
                }
            }
            HashSet<d> hashSetD2 = this.f23046Q.d();
            if (hashSetD2 != null) {
                Iterator<d> it2 = hashSetD2.iterator();
                while (it2.hasNext()) {
                    it2.next().f23002d.e(fVar, dVar, hashSet, i5, true);
                }
                return;
            }
            return;
        }
        HashSet<d> hashSetD3 = this.f23045P.d();
        if (hashSetD3 != null) {
            Iterator<d> it3 = hashSetD3.iterator();
            while (it3.hasNext()) {
                it3.next().f23002d.e(fVar, dVar, hashSet, i5, true);
            }
        }
        HashSet<d> hashSetD4 = this.f23047R.d();
        if (hashSetD4 != null) {
            Iterator<d> it4 = hashSetD4.iterator();
            while (it4.hasNext()) {
                it4.next().f23002d.e(fVar, dVar, hashSet, i5, true);
            }
        }
        HashSet<d> hashSetD5 = this.f23048S.d();
        if (hashSetD5 != null) {
            Iterator<d> it5 = hashSetD5.iterator();
            while (it5.hasNext()) {
                it5.next().f23002d.e(fVar, dVar, hashSet, i5, true);
            }
        }
    }

    public void e0(d.b bVar, e eVar, d.b bVar2, int i5, int i6) {
        o(bVar).b(eVar.o(bVar2), i5, i6, true);
    }

    public void e1(int i5) {
        this.f23021A0 = i5;
    }

    boolean f() {
        return (this instanceof l) || (this instanceof h);
    }

    public void f1(int i5, int i6) {
        this.f23069g0 = i5;
        int i7 = i6 - i5;
        this.f23061c0 = i7;
        int i8 = this.f23083n0;
        if (i7 < i8) {
            this.f23061c0 = i8;
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
    public void g(s.d r51, boolean r52) {
        /*
            Method dump skipped, instructions count: 1427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.e.g(s.d, boolean):void");
    }

    public boolean g0() {
        return this.f23090r;
    }

    public void g1(b bVar) {
        this.f23055Z[1] = bVar;
    }

    public boolean h() {
        return this.f23093s0 != 8;
    }

    public boolean h0(int i5) {
        return this.f23054Y[i5];
    }

    public void h1(int i5, int i6, int i7, float f5) {
        this.f23102x = i5;
        this.f23024C = i6;
        if (i7 == Integer.MAX_VALUE) {
            i7 = 0;
        }
        this.f23026D = i7;
        this.f23028E = f5;
        if (f5 <= 0.0f || f5 >= 1.0f || i5 != 0) {
            return;
        }
        this.f23102x = 2;
    }

    public boolean i0() {
        d dVar = this.f23044O;
        d dVar2 = dVar.f23004f;
        if (dVar2 != null && dVar2.f23004f == dVar) {
            return true;
        }
        d dVar3 = this.f23046Q;
        d dVar4 = dVar3.f23004f;
        return dVar4 != null && dVar4.f23004f == dVar3;
    }

    public void i1(float f5) {
        this.f23027D0[1] = f5;
    }

    public void j(d.b bVar, e eVar, d.b bVar2, int i5) {
        d.b bVar3;
        d.b bVar4;
        boolean z5;
        d.b bVar5 = d.b.CENTER;
        if (bVar == bVar5) {
            if (bVar2 != bVar5) {
                d.b bVar6 = d.b.LEFT;
                if (bVar2 == bVar6 || bVar2 == d.b.RIGHT) {
                    j(bVar6, eVar, bVar2, 0);
                    j(d.b.RIGHT, eVar, bVar2, 0);
                    o(bVar5).a(eVar.o(bVar2), 0);
                    return;
                }
                d.b bVar7 = d.b.TOP;
                if (bVar2 == bVar7 || bVar2 == d.b.BOTTOM) {
                    j(bVar7, eVar, bVar2, 0);
                    j(d.b.BOTTOM, eVar, bVar2, 0);
                    o(bVar5).a(eVar.o(bVar2), 0);
                    return;
                }
                return;
            }
            d.b bVar8 = d.b.LEFT;
            d dVarO = o(bVar8);
            d.b bVar9 = d.b.RIGHT;
            d dVarO2 = o(bVar9);
            d.b bVar10 = d.b.TOP;
            d dVarO3 = o(bVar10);
            d.b bVar11 = d.b.BOTTOM;
            d dVarO4 = o(bVar11);
            boolean z6 = true;
            if ((dVarO == null || !dVarO.o()) && (dVarO2 == null || !dVarO2.o())) {
                j(bVar8, eVar, bVar8, 0);
                j(bVar9, eVar, bVar9, 0);
                z5 = true;
            } else {
                z5 = false;
            }
            if ((dVarO3 == null || !dVarO3.o()) && (dVarO4 == null || !dVarO4.o())) {
                j(bVar10, eVar, bVar10, 0);
                j(bVar11, eVar, bVar11, 0);
            } else {
                z6 = false;
            }
            if (z5 && z6) {
                o(bVar5).a(eVar.o(bVar5), 0);
                return;
            }
            if (z5) {
                d.b bVar12 = d.b.CENTER_X;
                o(bVar12).a(eVar.o(bVar12), 0);
                return;
            } else {
                if (z6) {
                    d.b bVar13 = d.b.CENTER_Y;
                    o(bVar13).a(eVar.o(bVar13), 0);
                    return;
                }
                return;
            }
        }
        d.b bVar14 = d.b.CENTER_X;
        if (bVar == bVar14 && (bVar2 == (bVar4 = d.b.LEFT) || bVar2 == d.b.RIGHT)) {
            d dVarO5 = o(bVar4);
            d dVarO6 = eVar.o(bVar2);
            d dVarO7 = o(d.b.RIGHT);
            dVarO5.a(dVarO6, 0);
            dVarO7.a(dVarO6, 0);
            o(bVar14).a(dVarO6, 0);
            return;
        }
        d.b bVar15 = d.b.CENTER_Y;
        if (bVar == bVar15 && (bVar2 == (bVar3 = d.b.TOP) || bVar2 == d.b.BOTTOM)) {
            d dVarO8 = eVar.o(bVar2);
            o(bVar3).a(dVarO8, 0);
            o(d.b.BOTTOM).a(dVarO8, 0);
            o(bVar15).a(dVarO8, 0);
            return;
        }
        if (bVar == bVar14 && bVar2 == bVar14) {
            d.b bVar16 = d.b.LEFT;
            o(bVar16).a(eVar.o(bVar16), 0);
            d.b bVar17 = d.b.RIGHT;
            o(bVar17).a(eVar.o(bVar17), 0);
            o(bVar14).a(eVar.o(bVar2), 0);
            return;
        }
        if (bVar == bVar15 && bVar2 == bVar15) {
            d.b bVar18 = d.b.TOP;
            o(bVar18).a(eVar.o(bVar18), 0);
            d.b bVar19 = d.b.BOTTOM;
            o(bVar19).a(eVar.o(bVar19), 0);
            o(bVar15).a(eVar.o(bVar2), 0);
            return;
        }
        d dVarO9 = o(bVar);
        d dVarO10 = eVar.o(bVar2);
        if (dVarO9.p(dVarO10)) {
            d.b bVar20 = d.b.BASELINE;
            if (bVar == bVar20) {
                d dVarO11 = o(d.b.TOP);
                d dVarO12 = o(d.b.BOTTOM);
                if (dVarO11 != null) {
                    dVarO11.q();
                }
                if (dVarO12 != null) {
                    dVarO12.q();
                }
            } else if (bVar == d.b.TOP || bVar == d.b.BOTTOM) {
                d dVarO13 = o(bVar20);
                if (dVarO13 != null) {
                    dVarO13.q();
                }
                d dVarO14 = o(bVar5);
                if (dVarO14.j() != dVarO10) {
                    dVarO14.q();
                }
                d dVarG = o(bVar).g();
                d dVarO15 = o(bVar15);
                if (dVarO15.o()) {
                    dVarG.q();
                    dVarO15.q();
                }
            } else if (bVar == d.b.LEFT || bVar == d.b.RIGHT) {
                d dVarO16 = o(bVar5);
                if (dVarO16.j() != dVarO10) {
                    dVarO16.q();
                }
                d dVarG2 = o(bVar).g();
                d dVarO17 = o(bVar14);
                if (dVarO17.o()) {
                    dVarG2.q();
                    dVarO17.q();
                }
            }
            dVarO9.a(dVarO10, i5);
        }
    }

    public boolean j0() {
        return this.f23040K;
    }

    public void j1(int i5) {
        this.f23093s0 = i5;
    }

    public void k(d dVar, d dVar2, int i5) {
        if (dVar.h() == this) {
            j(dVar.k(), dVar2.h(), dVar2.k(), i5);
        }
    }

    public boolean k0() {
        d dVar = this.f23045P;
        d dVar2 = dVar.f23004f;
        if (dVar2 != null && dVar2.f23004f == dVar) {
            return true;
        }
        d dVar3 = this.f23047R;
        d dVar4 = dVar3.f23004f;
        return dVar4 != null && dVar4.f23004f == dVar3;
    }

    public void k1(int i5) {
        this.f23059b0 = i5;
        int i6 = this.f23081m0;
        if (i5 < i6) {
            this.f23059b0 = i6;
        }
    }

    public void l(e eVar, float f5, int i5) {
        d.b bVar = d.b.CENTER;
        e0(bVar, eVar, bVar, i5, 0);
        this.f23036I = f5;
    }

    public boolean l0() {
        return this.f23041L;
    }

    public void l1(int i5) {
        if (i5 < 0 || i5 > 3) {
            return;
        }
        this.f23098v = i5;
    }

    public void m(s.d dVar) {
        dVar.q(this.f23044O);
        dVar.q(this.f23045P);
        dVar.q(this.f23046Q);
        dVar.q(this.f23047R);
        if (this.f23079l0 > 0) {
            dVar.q(this.f23048S);
        }
    }

    public boolean m0() {
        return this.f23072i && this.f23093s0 != 8;
    }

    public void m1(int i5) {
        this.f23067f0 = i5;
    }

    public void n() {
        if (this.f23064e == null) {
            this.f23064e = new w.l(this);
        }
        if (this.f23066f == null) {
            this.f23066f = new n(this);
        }
    }

    public boolean n0() {
        if (this.f23086p) {
            return true;
        }
        return this.f23044O.n() && this.f23046Q.n();
    }

    public void n1(int i5) {
        this.f23069g0 = i5;
    }

    public d o(d.b bVar) {
        switch (a.f23108a[bVar.ordinal()]) {
            case 1:
                return this.f23044O;
            case 2:
                return this.f23045P;
            case 3:
                return this.f23046Q;
            case 4:
                return this.f23047R;
            case 5:
                return this.f23048S;
            case 6:
                return this.f23051V;
            case 7:
                return this.f23049T;
            case 8:
                return this.f23050U;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public boolean o0() {
        if (this.f23088q) {
            return true;
        }
        return this.f23045P.n() && this.f23047R.n();
    }

    public void o1(boolean z5, boolean z6, boolean z7, boolean z8) {
        if (this.f23030F == -1) {
            if (z7 && !z8) {
                this.f23030F = 0;
            } else if (!z7 && z8) {
                this.f23030F = 1;
                if (this.f23065e0 == -1) {
                    this.f23032G = 1.0f / this.f23032G;
                }
            }
        }
        if (this.f23030F == 0 && (!this.f23045P.o() || !this.f23047R.o())) {
            this.f23030F = 1;
        } else if (this.f23030F == 1 && (!this.f23044O.o() || !this.f23046Q.o())) {
            this.f23030F = 0;
        }
        if (this.f23030F == -1 && (!this.f23045P.o() || !this.f23047R.o() || !this.f23044O.o() || !this.f23046Q.o())) {
            if (this.f23045P.o() && this.f23047R.o()) {
                this.f23030F = 0;
            } else if (this.f23044O.o() && this.f23046Q.o()) {
                this.f23032G = 1.0f / this.f23032G;
                this.f23030F = 1;
            }
        }
        if (this.f23030F == -1) {
            int i5 = this.f23106z;
            if (i5 > 0 && this.f23024C == 0) {
                this.f23030F = 0;
            } else {
                if (i5 != 0 || this.f23024C <= 0) {
                    return;
                }
                this.f23032G = 1.0f / this.f23032G;
                this.f23030F = 1;
            }
        }
    }

    public int p() {
        return this.f23079l0;
    }

    public boolean p0() {
        return this.f23092s;
    }

    public void p1(boolean z5, boolean z6) {
        int i5;
        int i6;
        boolean zK = z5 & this.f23064e.k();
        boolean zK2 = z6 & this.f23066f.k();
        w.l lVar = this.f23064e;
        int i7 = lVar.f23476h.f23422g;
        n nVar = this.f23066f;
        int i8 = nVar.f23476h.f23422g;
        int i9 = lVar.f23477i.f23422g;
        int i10 = nVar.f23477i.f23422g;
        int i11 = i10 - i8;
        if (i9 - i7 < 0 || i11 < 0 || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE || i9 == Integer.MIN_VALUE || i9 == Integer.MAX_VALUE || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE) {
            i9 = 0;
            i7 = 0;
            i10 = 0;
            i8 = 0;
        }
        int i12 = i9 - i7;
        int i13 = i10 - i8;
        if (zK) {
            this.f23067f0 = i7;
        }
        if (zK2) {
            this.f23069g0 = i8;
        }
        if (this.f23093s0 == 8) {
            this.f23059b0 = 0;
            this.f23061c0 = 0;
            return;
        }
        if (zK) {
            if (this.f23055Z[0] == b.FIXED && i12 < (i6 = this.f23059b0)) {
                i12 = i6;
            }
            this.f23059b0 = i12;
            int i14 = this.f23081m0;
            if (i12 < i14) {
                this.f23059b0 = i14;
            }
        }
        if (zK2) {
            if (this.f23055Z[1] == b.FIXED && i13 < (i5 = this.f23061c0)) {
                i13 = i5;
            }
            this.f23061c0 = i13;
            int i15 = this.f23083n0;
            if (i13 < i15) {
                this.f23061c0 = i15;
            }
        }
    }

    public float q(int i5) {
        if (i5 == 0) {
            return this.f23085o0;
        }
        if (i5 == 1) {
            return this.f23087p0;
        }
        return -1.0f;
    }

    public void q0() {
        this.f23090r = true;
    }

    public void q1(s.d dVar, boolean z5) {
        n nVar;
        w.l lVar;
        int iX = dVar.x(this.f23044O);
        int iX2 = dVar.x(this.f23045P);
        int iX3 = dVar.x(this.f23046Q);
        int iX4 = dVar.x(this.f23047R);
        if (z5 && (lVar = this.f23064e) != null) {
            w.f fVar = lVar.f23476h;
            if (fVar.f23425j) {
                w.f fVar2 = lVar.f23477i;
                if (fVar2.f23425j) {
                    iX = fVar.f23422g;
                    iX3 = fVar2.f23422g;
                }
            }
        }
        if (z5 && (nVar = this.f23066f) != null) {
            w.f fVar3 = nVar.f23476h;
            if (fVar3.f23425j) {
                w.f fVar4 = nVar.f23477i;
                if (fVar4.f23425j) {
                    iX2 = fVar3.f23422g;
                    iX4 = fVar4.f23422g;
                }
            }
        }
        int i5 = iX4 - iX2;
        if (iX3 - iX < 0 || i5 < 0 || iX == Integer.MIN_VALUE || iX == Integer.MAX_VALUE || iX2 == Integer.MIN_VALUE || iX2 == Integer.MAX_VALUE || iX3 == Integer.MIN_VALUE || iX3 == Integer.MAX_VALUE || iX4 == Integer.MIN_VALUE || iX4 == Integer.MAX_VALUE) {
            iX = 0;
            iX4 = 0;
            iX2 = 0;
            iX3 = 0;
        }
        J0(iX, iX2, iX3, iX4);
    }

    public int r() {
        return Y() + this.f23061c0;
    }

    public void r0() {
        this.f23092s = true;
    }

    public Object s() {
        return this.f23089q0;
    }

    public boolean s0() {
        b[] bVarArr = this.f23055Z;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public String t() {
        return this.f23097u0;
    }

    public void t0() {
        this.f23044O.q();
        this.f23045P.q();
        this.f23046Q.q();
        this.f23047R.q();
        this.f23048S.q();
        this.f23049T.q();
        this.f23050U.q();
        this.f23051V.q();
        this.f23057a0 = null;
        this.f23036I = 0.0f;
        this.f23059b0 = 0;
        this.f23061c0 = 0;
        this.f23063d0 = 0.0f;
        this.f23065e0 = -1;
        this.f23067f0 = 0;
        this.f23069g0 = 0;
        this.f23075j0 = 0;
        this.f23077k0 = 0;
        this.f23079l0 = 0;
        this.f23081m0 = 0;
        this.f23083n0 = 0;
        float f5 = f23019K0;
        this.f23085o0 = f5;
        this.f23087p0 = f5;
        b[] bVarArr = this.f23055Z;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f23089q0 = null;
        this.f23091r0 = 0;
        this.f23093s0 = 0;
        this.f23099v0 = null;
        this.f23101w0 = false;
        this.f23103x0 = false;
        this.f23107z0 = 0;
        this.f23021A0 = 0;
        this.f23023B0 = false;
        this.f23025C0 = false;
        float[] fArr = this.f23027D0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f23094t = -1;
        this.f23096u = -1;
        int[] iArr = this.f23034H;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f23100w = 0;
        this.f23102x = 0;
        this.f23022B = 1.0f;
        this.f23028E = 1.0f;
        this.f23020A = Integer.MAX_VALUE;
        this.f23026D = Integer.MAX_VALUE;
        this.f23106z = 0;
        this.f23024C = 0;
        this.f23070h = false;
        this.f23030F = -1;
        this.f23032G = 1.0f;
        this.f23105y0 = false;
        boolean[] zArr = this.f23068g;
        zArr[0] = true;
        zArr[1] = true;
        this.f23041L = false;
        boolean[] zArr2 = this.f23054Y;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f23072i = true;
        int[] iArr2 = this.f23104y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f23078l = -1;
        this.f23080m = -1;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = this.f23099v0;
        String str3 = BuildConfig.FLAVOR;
        if (str2 != null) {
            str = "type: " + this.f23099v0 + " ";
        } else {
            str = BuildConfig.FLAVOR;
        }
        sb.append(str);
        if (this.f23097u0 != null) {
            str3 = "id: " + this.f23097u0 + " ";
        }
        sb.append(str3);
        sb.append("(");
        sb.append(this.f23067f0);
        sb.append(", ");
        sb.append(this.f23069g0);
        sb.append(") - (");
        sb.append(this.f23059b0);
        sb.append(" x ");
        sb.append(this.f23061c0);
        sb.append(")");
        return sb.toString();
    }

    public b u(int i5) {
        if (i5 == 0) {
            return A();
        }
        if (i5 == 1) {
            return T();
        }
        return null;
    }

    public void u0() {
        e eVarK = K();
        if (eVarK != null && (eVarK instanceof f) && ((f) K()).L1()) {
            return;
        }
        int size = this.f23053X.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f23053X.get(i5).q();
        }
    }

    public float v() {
        return this.f23063d0;
    }

    public void v0() {
        this.f23086p = false;
        this.f23088q = false;
        this.f23090r = false;
        this.f23092s = false;
        int size = this.f23053X.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f23053X.get(i5).r();
        }
    }

    public int w() {
        return this.f23065e0;
    }

    public void w0(C1045c c1045c) {
        this.f23044O.s(c1045c);
        this.f23045P.s(c1045c);
        this.f23046Q.s(c1045c);
        this.f23047R.s(c1045c);
        this.f23048S.s(c1045c);
        this.f23051V.s(c1045c);
        this.f23049T.s(c1045c);
        this.f23050U.s(c1045c);
    }

    public int x() {
        if (this.f23093s0 == 8) {
            return 0;
        }
        return this.f23061c0;
    }

    public float y() {
        return this.f23085o0;
    }

    public int z() {
        return this.f23107z0;
    }
}
