package androidx.constraintlayout.core;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class LinearSystem {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f1259r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f1260s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f1261t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f1262u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f1263v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f1264w = 1000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static Metrics f1265x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f1266y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static long f1267z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f1270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Row f1271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayRow[] f1274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean[] f1277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f1281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SolverVariable[] f1282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Row f1284q;

    public interface Row {
        void addError(SolverVariable r10);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem r10, boolean[] r11);

        void initFromRow(Row r10);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem r10, SolverVariable r11, boolean r12);

        void updateFromRow(LinearSystem r10, ArrayRow r11, boolean r12);

        void updateFromSystem(LinearSystem r10);
    }

    public class a extends ArrayRow {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ LinearSystem f1285g;

        public a(LinearSystem r10, b r11) {
            this.f1285g = r10;
            this.f1257e = new e(this, r11);
        }
    }

    static {
    }

    public LinearSystem() {
        this.f1268a = false;
        this.f1269b = 0;
        this.f1270c = null;
        this.f1272e = 32;
        this.f1273f = 32;
        this.f1274g = null;
        this.f1275h = false;
        this.f1276i = false;
        this.f1277j = new boolean[32];
        this.f1278k = 1;
        this.f1279l = 0;
        this.f1280m = 32;
        this.f1282o = new SolverVariable[f1264w];
        this.f1283p = 0;
        this.f1274g = new ArrayRow[32];
        D();
        b r10 = new b();
        this.f1281n = r10;
        this.f1271d = new d(r10);
        if (f1263v == false) goto L5;
        this.f1284q = new a(this, r10);
        return;
    L5:
        this.f1284q = new ArrayRow(r10);
    }

    public static ArrayRow s(LinearSystem r10, SolverVariable r11, SolverVariable r12, float r13) {
        return r10.r().g(r11, r12, r13);
    }

    public static Metrics x() {
        return f1265x;
    }

    public void A() {
        Metrics r10 = f1265x;
        if (r10 == null) goto L6;
        r10.f1290e++;
    L6:
        if (this.f1271d.isEmpty() == false) goto L10;
        n();
        return;
    L10:
        if (this.f1275h == false) goto L12;
    L15:
        Metrics r11 = f1265x;
        if (r11 == null) goto L18;
        r11.f1302q++;
    L18:
        int r12 = 0;
    L20:
        if (r12 >= this.f1279l) goto L25;
        if (this.f1274g[r12].f1258f == false) goto L23;
        r12 = r12 + 1;
        goto L20
    L23:
        B(this.f1271d);
        return;
    L25:
        Metrics r13 = f1265x;
        if (r13 == null) goto L28;
        r13.f1301p++;
    L28:
        n();
        return;
    L12:
        if (this.f1276i == true) goto L15;
        B(this.f1271d);
    }

    public void B(Row r10) {
        Metrics r11 = f1265x;
        if (r11 == null) goto L5;
        r11.f1305t++;
        r11.f1306u = Math.max(r11.f1306u, this.f1278k);
        Metrics r12 = f1265x;
        r12.f1307v = Math.max(r12.f1307v, this.f1279l);
    L5:
        u(r10);
        C(r10, false);
        n();
    }

    public final int C(Row r13, boolean r14) {
        Metrics r15 = f1265x;
        if (r15 == null) goto L5;
        r15.f1293h++;
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.f1278k) goto L9;
        this.f1277j[r10] = false;
        r10 = r10 + 1;
        goto L7
    L9:
        boolean r11 = false;
        int r12 = 0;
    L10:
        if (r11 == true) goto L50;
        Metrics r16 = f1265x;
        if (r16 == null) goto L14;
        r16.f1294i++;
    L14:
        r12 = r12 + 1;
        if (r12 >= (this.f1278k * 2)) goto L16;
        if (r13.getKey() == null) goto L20;
        this.f1277j[r13.getKey().f1315c] = true;
    L20:
        SolverVariable r17 = r13.getPivotCandidate(this, this.f1277j);
        if (r17 == null) goto L26;
        boolean[] r18 = this.f1277j;
        int r19 = r17.f1315c;
        if (r18[r19] == true) goto L24;
        r18[r19] = true;
        goto L26
    L24:
        return r12;
    L26:
        if (r17 != null) goto L27;
        r11 = true;
        goto L10
    L27:
        float r20 = Float.MAX_VALUE;
        int r21 = 0;
        int r22 = -1;
    L29:
        if (r21 >= this.f1279l) goto L44;
        ArrayRow r23 = this.f1274g[r21];
        if (r23.f1253a.f1322j == SolverVariable.Type.UNRESTRICTED) goto L43;
        if (r23.f1258f == true) goto L43;
        if (r23.q(r17) == false) goto L43;
        float r110 = r23.f1257e.get(r17);
        if (r110 >= 0.0f) goto L43;
        float r24 = (-r23.f1254b) / r110;
        if (r24 >= r20) goto L43;
        r22 = r21;
        r20 = r24;
    L43:
        r21 = r21 + 1;
        goto L29
    L44:
        if (r22 <= (-1)) goto L10;
        ArrayRow r25 = this.f1274g[r22];
        r25.f1253a.f1316d = -1;
        Metrics r26 = f1265x;
        if (r26 == null) goto L48;
        r26.f1295j++;
    L48:
        r25.u(r17);
        SolverVariable r27 = r25.f1253a;
        r27.f1316d = r22;
        r27.h(this, r25);
        goto L10
    L16:
        return r12;
    L50:
        return r12;
    }

    public final void D() {
        int r10 = 0;
        if (f1263v == false) goto L11;
    L5:
        if (r10 >= this.f1279l) goto L16;
        ArrayRow r11 = this.f1274g[r10];
        if (r11 == null) goto L9;
        this.f1281n.f1342a.release(r11);
    L9:
        this.f1274g[r10] = null;
        r10 = r10 + 1;
        goto L5
    L16:
        return;
    L11:
        if (r10 >= this.f1279l) goto L23;
        ArrayRow r12 = this.f1274g[r10];
        if (r12 == null) goto L15;
        this.f1281n.f1343b.release(r12);
    L15:
        this.f1274g[r10] = null;
        r10 = r10 + 1;
        goto L11
    }

    public void E() {
        int r10 = 0;
    L3:
        b r11 = this.f1281n;
        SolverVariable[] r12 = r11.f1345d;
        if (r10 >= r12.length) goto L9;
        SolverVariable r13 = r12[r10];
        if (r13 == null) goto L8;
        r13.e();
    L8:
        r10 = r10 + 1;
        goto L3
    L9:
        r11.f1344c.releaseAll(this.f1282o, this.f1283p);
        this.f1283p = 0;
        Arrays.fill(this.f1281n.f1345d, null);
        HashMap r14 = this.f1270c;
        if (r14 == null) goto L12;
        r14.clear();
    L12:
        this.f1269b = 0;
        this.f1271d.clear();
        this.f1278k = 1;
        int r15 = 0;
    L14:
        if (r15 >= this.f1279l) goto L19;
        ArrayRow r16 = this.f1274g[r15];
        if (r16 == null) goto L18;
        r16.f1255c = false;
    L18:
        r15 = r15 + 1;
        goto L14
    L19:
        D();
        this.f1279l = 0;
        if (f1263v == false) goto L22;
        this.f1284q = new a(this, this.f1281n);
        return;
    L22:
        this.f1284q = new ArrayRow(this.f1281n);
    }

    public final SolverVariable a(SolverVariable.Type r10, String r11) {
        SolverVariable r12 = (SolverVariable) this.f1281n.f1344c.acquire();
        if (r12 != null) goto L5;
        r12 = new SolverVariable(r10, r11);
        r12.g(r10, r11);
    L6:
        int r13 = this.f1283p;
        int r14 = f1264w;
        if (r13 < r14) goto L9;
        int r15 = r14 * 2;
        f1264w = r15;
        this.f1282o = (SolverVariable[]) Arrays.copyOf(this.f1282o, r15);
    L9:
        SolverVariable[] r16 = this.f1282o;
        int r17 = this.f1283p;
        this.f1283p = r17 + 1;
        r16[r17] = r12;
        return r12;
    L5:
        r12.e();
        r12.g(r10, r11);
        goto L6
    }

    public void b(ConstraintWidget r17, ConstraintWidget r18, float r19, int r20) {
        ConstraintAnchor.Type r10 = ConstraintAnchor.Type.LEFT;
        SolverVariable r11 = q(r17.n(r10));
        ConstraintAnchor.Type r12 = ConstraintAnchor.Type.TOP;
        SolverVariable r13 = q(r17.n(r12));
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.RIGHT;
        SolverVariable r15 = q(r17.n(r14));
        ConstraintAnchor.Type r16 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable r21 = q(r17.n(r16));
        SolverVariable r22 = q(r18.n(r10));
        SolverVariable r110 = q(r18.n(r12));
        SolverVariable r23 = q(r18.n(r14));
        SolverVariable r111 = q(r18.n(r16));
        ArrayRow r24 = r();
        double r25 = r19;
        double r26 = r20;
        r24.n(r13, r21, r110, r111, (float) (Math.sin(r25) * r26));
        d(r24);
        ArrayRow r27 = r();
        r27.n(r11, r15, r22, r23, (float) (Math.cos(r25) * r26));
        d(r27);
    }

    public void c(SolverVariable r12, SolverVariable r13, int r14, float r15, SolverVariable r16, SolverVariable r17, int r18, int r19) {
        ArrayRow r10 = r();
        r10.e(r12, r13, r14, r15, r16, r17, r18);
        if (r19 == 8) goto L5;
        r10.a(this, r19);
    L5:
        d(r10);
    }

    public void d(ArrayRow r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Metrics r11 = f1265x;
        if (r11 == null) goto L9;
        r11.f1291f++;
        if (r10.f1258f == false) goto L9;
        r11.f1292g++;
    L9:
        boolean r12 = true;
        if ((this.f1279l + 1) < this.f1280m) goto L12;
    L13:
        z();
    L14:
        boolean r13 = false;
        if (r10.f1258f == true) goto L46;
        r10.updateFromSystem(this);
        if (r10.isEmpty() == false) goto L19;
        return;
    L19:
        r10.o();
        if (r10.c(this) == false) goto L41;
        SolverVariable r14 = p();
        r10.f1253a = r14;
        int r15 = this.f1279l;
        l(r10);
        if (this.f1279l != (r15 + 1)) goto L41;
        this.f1284q.initFromRow(r10);
        C(this.f1284q, true);
        if (r14.f1316d != (-1)) goto L43;
        if (r10.f1253a != r14) goto L34;
        SolverVariable r16 = r10.s(r14);
        if (r16 == null) goto L34;
        Metrics r17 = f1265x;
        if (r17 == null) goto L32;
        r17.f1295j++;
    L32:
        r10.u(r16);
    L34:
        if (r10.f1258f == true) goto L37;
        r10.f1253a.h(this, r10);
    L37:
        if (f1263v == false) goto L39;
        this.f1281n.f1342a.release(r10);
    L40:
        this.f1279l--;
        goto L43
    L39:
        this.f1281n.f1343b.release(r10);
    L43:
        if (r10.p() == true) goto L45;
        return;
    L45:
        r13 = r12;
    L41:
        r12 = false;
    L46:
        if (r13 == true) goto L49;
        l(r10);
        return;
    L49:
        return;
    L12:
        if ((this.f1278k + 1) < this.f1273f) goto L14;
        goto L13
    }

    public ArrayRow e(SolverVariable r10, SolverVariable r11, int r12, int r13) {
        if (f1260s == false) goto L11;
        if (r13 != 8) goto L11;
        if (r11.f1319g == false) goto L11;
        if (r10.f1316d != (-1)) goto L11;
        r10.f(this, r11.f1318f + r12);
        return null;
    L11:
        ArrayRow r14 = r();
        r14.k(r10, r11, r12);
        if (r13 == 8) goto L14;
        r14.a(this, r13);
    L14:
        d(r14);
        return r14;
    }

    public void f(SolverVariable r10, int r11) {
        if (f1260s == true) goto L5;
    L18:
        int r12 = r10.f1316d;
        if (r12 == (-1)) goto L27;
        ArrayRow r13 = this.f1274g[r12];
        if (r13.f1258f == false) goto L24;
        r13.f1254b = r11;
        return;
    L24:
        if (r13.f1257e.getCurrentSize() != 0) goto L26;
        r13.f1258f = true;
        r13.f1254b = r11;
        return;
    L26:
        ArrayRow r14 = r();
        r14.j(r10, r11);
        d(r14);
        return;
    L27:
        ArrayRow r15 = r();
        r15.f(r10, r11);
        d(r15);
        return;
    L5:
        if (r10.f1316d != (-1)) goto L18;
        float r16 = r11;
        r10.f(this, r16);
        int r17 = 0;
    L8:
        if (r17 >= (this.f1269b + 1)) goto L17;
        SolverVariable r18 = this.f1281n.f1345d[r17];
        if (r18 == null) goto L16;
        if (r18.f1326n == false) goto L16;
        if (r18.f1327o != r10.f1315c) goto L16;
        r18.f(this, r18.f1328p + r16);
    L16:
        r17 = r17 + 1;
        goto L8
    }

    public void g(SolverVariable r10, SolverVariable r11, int r12, boolean r13) {
        ArrayRow r14 = r();
        SolverVariable r15 = t();
        r15.f1317e = 0;
        r14.l(r10, r11, r15, r12);
        d(r14);
    }

    public void h(SolverVariable r10, SolverVariable r11, int r12, int r13) {
        ArrayRow r14 = r();
        SolverVariable r15 = t();
        r15.f1317e = 0;
        r14.l(r10, r11, r15, r12);
        if (r13 == 8) goto L5;
        m(r14, (int) (r14.f1257e.get(r15) * (-1.0f)), r13);
    L5:
        d(r14);
    }

    public void i(SolverVariable r10, SolverVariable r11, int r12, boolean r13) {
        ArrayRow r14 = r();
        SolverVariable r15 = t();
        r15.f1317e = 0;
        r14.m(r10, r11, r15, r12);
        d(r14);
    }

    public void j(SolverVariable r10, SolverVariable r11, int r12, int r13) {
        ArrayRow r14 = r();
        SolverVariable r15 = t();
        r15.f1317e = 0;
        r14.m(r10, r11, r15, r12);
        if (r13 == 8) goto L5;
        m(r14, (int) (r14.f1257e.get(r15) * (-1.0f)), r13);
    L5:
        d(r14);
    }

    public void k(SolverVariable r10, SolverVariable r11, SolverVariable r12, SolverVariable r13, float r14, int r15) {
        ArrayRow r16 = r();
        r16.h(r10, r11, r12, r13, r14);
        if (r15 == 8) goto L5;
        r16.a(this, r15);
    L5:
        d(r16);
    }

    public final void l(ArrayRow r10) {
        if (f1261t == true) goto L5;
    L7:
        ArrayRow[] r11 = this.f1274g;
        int r12 = this.f1279l;
        r11[r12] = r10;
        SolverVariable r13 = r10.f1253a;
        r13.f1316d = r12;
        this.f1279l = r12 + 1;
        r13.h(this, r10);
    L9:
        if (f1261t == true) goto L11;
        return;
    L11:
        if (this.f1268a == false) goto L47;
        int r14 = 0;
    L14:
        if (r14 >= this.f1279l) goto L37;
        if (this.f1274g[r14] != null) goto L18;
        System.out.println("WTF");
    L18:
        ArrayRow r15 = this.f1274g[r14];
        if (r15 == null) goto L36;
        if (r15.f1258f == false) goto L36;
        r15.f1253a.f(this, r15.f1254b);
        if (f1263v == false) goto L25;
        this.f1281n.f1342a.release(r15);
    L26:
        this.f1274g[r14] = null;
        int r16 = r14 + 1;
        int r17 = r16;
    L27:
        int r18 = this.f1279l;
        if (r16 >= r18) goto L33;
        ArrayRow[] r19 = this.f1274g;
        int r20 = r16 - 1;
        ArrayRow r21 = r19[r16];
        r19[r20] = r21;
        SolverVariable r22 = r21.f1253a;
        if (r22.f1316d != r16) goto L32;
        r22.f1316d = r20;
    L32:
        r17 = r16;
        r16 = r16 + 1;
        goto L27
    L33:
        if (r17 >= r18) goto L35;
        this.f1274g[r17] = null;
    L35:
        this.f1279l = r18 - 1;
        r14 = r14 - 1;
        goto L36
    L25:
        this.f1281n.f1343b.release(r15);
    L36:
        r14 = r14 + 1;
        goto L14
    L37:
        this.f1268a = false;
        return;
    L47:
        return;
    L5:
        if (r10.f1258f == false) goto L7;
        r10.f1253a.f(this, r10.f1254b);
        goto L9
    }

    public void m(ArrayRow r10, int r11, int r12) {
        r10.b(o(r12, null), r11);
    }

    public final void n() {
        int r10 = 0;
    L4:
        if (r10 >= this.f1279l) goto L6;
        ArrayRow r11 = this.f1274g[r10];
        SolverVariable r12 = r11.f1253a;
        r12.f1318f = r11.f1254b;
        r10 = r10 + 1;
        goto L4
    }

    public SolverVariable o(int r10, String r11) {
        Metrics r12 = f1265x;
        if (r12 == null) goto L6;
        r12.f1297l++;
    L6:
        if ((this.f1278k + 1) < this.f1273f) goto L8;
        z();
    L8:
        SolverVariable r13 = a(SolverVariable.Type.ERROR, r11);
        int r14 = this.f1269b + 1;
        this.f1269b = r14;
        this.f1278k++;
        r13.f1315c = r14;
        r13.f1317e = r10;
        this.f1281n.f1345d[r14] = r13;
        this.f1271d.addError(r13);
        return r13;
    }

    public SolverVariable p() {
        Metrics r10 = f1265x;
        if (r10 == null) goto L6;
        r10.f1299n++;
    L6:
        if ((this.f1278k + 1) < this.f1273f) goto L8;
        z();
    L8:
        SolverVariable r11 = a(SolverVariable.Type.SLACK, null);
        int r12 = this.f1269b + 1;
        this.f1269b = r12;
        this.f1278k++;
        r11.f1315c = r12;
        this.f1281n.f1345d[r12] = r11;
        return r11;
    }

    public SolverVariable q(Object r10) {
        SolverVariable r11 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((this.f1278k + 1) < this.f1273f) goto L9;
        z();
    L9:
        if ((r10 instanceof ConstraintAnchor) == false) goto L22;
        ConstraintAnchor r12 = (ConstraintAnchor) r10;
        r11 = r12.i();
        if (r11 != null) goto L13;
        r12.s(this.f1281n);
        r11 = r12.i();
    L13:
        int r13 = r11.f1315c;
        if (r13 != (-1)) goto L16;
    L19:
        if (r13 == (-1)) goto L21;
        r11.e();
    L21:
        int r14 = this.f1269b + 1;
        this.f1269b = r14;
        this.f1278k++;
        r11.f1315c = r14;
        r11.f1322j = SolverVariable.Type.UNRESTRICTED;
        this.f1281n.f1345d[r14] = r11;
        goto L22
    L16:
        if (r13 > this.f1269b) goto L19;
        if (this.f1281n.f1345d[r13] == null) goto L19;
    L22:
        return r11;
    }

    public ArrayRow r() {
        if (f1263v == false) goto L8;
        ArrayRow r10 = (ArrayRow) this.f1281n.f1342a.acquire();
        if (r10 != null) goto L7;
        r10 = new a(this, this.f1281n);
        f1267z++;
    L12:
        SolverVariable.c();
        return r10;
    L7:
        r10.v();
        goto L12
    L8:
        r10 = (ArrayRow) this.f1281n.f1343b.acquire();
        if (r10 != null) goto L11;
        r10 = new ArrayRow(this.f1281n);
        f1266y++;
        goto L12
    L11:
        r10.v();
        goto L12
    }

    public SolverVariable t() {
        Metrics r10 = f1265x;
        if (r10 == null) goto L6;
        r10.f1298m++;
    L6:
        if ((this.f1278k + 1) < this.f1273f) goto L8;
        z();
    L8:
        SolverVariable r11 = a(SolverVariable.Type.SLACK, null);
        int r12 = this.f1269b + 1;
        this.f1269b = r12;
        this.f1278k++;
        r11.f1315c = r12;
        this.f1281n.f1345d[r12] = r11;
        return r11;
    }

    public final int u(Row r20) {
        int r10 = 0;
    L4:
        if (r10 >= this.f1279l) goto L69;
        ArrayRow r11 = this.f1274g[r10];
        if (r11.f1253a.f1322j == SolverVariable.Type.UNRESTRICTED) goto L68;
        if (r11.f1254b >= 0.0f) goto L68;
        boolean r12 = false;
        int r13 = 0;
    L11:
        if (r12 == true) goto L94;
        Metrics r14 = f1265x;
        if (r14 == null) goto L15;
        r14.f1296k++;
    L15:
        r13 = r13 + 1;
        float r15 = Float.MAX_VALUE;
        int r16 = 0;
        int r17 = -1;
        int r18 = -1;
        int r19 = 0;
    L16:
        int r110 = 1;
        if (r16 >= this.f1279l) goto L58;
        ArrayRow r111 = this.f1274g[r16];
        if (r111.f1253a.f1322j == SolverVariable.Type.UNRESTRICTED) goto L56;
        if (r111.f1258f == true) goto L56;
        if (r111.f1254b >= 0.0f) goto L56;
        int r112 = 9;
        if (f1262u == false) goto L43;
        int r21 = r111.f1257e.getCurrentSize();
        int r113 = 0;
    L29:
        if (r113 >= r21) goto L56;
        SolverVariable r22 = r111.f1257e.getVariable(r113);
        float r23 = r111.f1257e.get(r22);
        if (r23 <= 0.0f) goto L41;
        int r24 = 0;
    L34:
        if (r24 >= r112) goto L41;
        float r114 = r22.f1320h[r24] / r23;
        if (r114 >= r15) goto L38;
        if (r24 != r19) goto L38;
    L39:
        r19 = r24;
        r18 = r22.f1315c;
        r17 = r16;
        r15 = r114;
    L40:
        r24 = r24 + 1;
        r112 = 9;
    L38:
        if (r24 <= r19) goto L40;
    L41:
        r113 = r113 + 1;
        r112 = 9;
    L43:
        if (r110 >= this.f1278k) goto L56;
        SolverVariable r25 = this.f1281n.f1345d[r110];
        float r26 = r111.f1257e.get(r25);
        if (r26 <= 0.0f) goto L55;
        int r27 = 0;
    L48:
        if (r27 >= 9) goto L55;
        float r115 = r25.f1320h[r27] / r26;
        if (r115 >= r15) goto L52;
        if (r27 != r19) goto L52;
    L53:
        r19 = r27;
        r17 = r16;
        r18 = r110;
        r15 = r115;
    L54:
        r27 = r27 + 1;
    L52:
        if (r27 <= r19) goto L54;
    L55:
        r110 = r110 + 1;
    L56:
        r16 = r16 + 1;
        goto L16
    L58:
        if (r17 == (-1)) goto L63;
        ArrayRow r28 = this.f1274g[r17];
        r28.f1253a.f1316d = -1;
        Metrics r29 = f1265x;
        if (r29 == null) goto L62;
        r29.f1295j++;
    L62:
        r28.u(this.f1281n.f1345d[r18]);
        SolverVariable r30 = r28.f1253a;
        r30.f1316d = r17;
        r30.h(this, r28);
    L65:
        if (r13 <= (this.f1278k / 2)) goto L11;
        r12 = true;
        goto L11
    L63:
        r12 = true;
        goto L65
    L94:
        return r13;
    L68:
        r10 = r10 + 1;
        goto L4
    L69:
        return 0;
    }

    public void v(Metrics r10) {
        f1265x = r10;
    }

    public b w() {
        return this.f1281n;
    }

    public int y(Object r10) {
        SolverVariable r11 = ((ConstraintAnchor) r10).i();
        if (r11 != null) goto L5;
        return 0;
    L5:
        return (int) (r11.f1318f + 0.5f);
    }

    public final void z() {
        int r10 = this.f1272e * 2;
        this.f1272e = r10;
        this.f1274g = (ArrayRow[]) Arrays.copyOf(this.f1274g, r10);
        b r11 = this.f1281n;
        r11.f1345d = (SolverVariable[]) Arrays.copyOf(r11.f1345d, this.f1272e);
        int r12 = this.f1272e;
        this.f1277j = new boolean[r12];
        this.f1273f = r12;
        this.f1280m = r12;
        Metrics r13 = f1265x;
        if (r13 == null) goto L6;
        r13.f1289d++;
        r13.f1300o = Math.max(r13.f1300o, r12);
        Metrics r14 = f1265x;
        r14.f1309x = r14.f1300o;
        return;
    }
}
