package androidx.constraintlayout.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: SolverVariable.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements Comparable<h> {
    private static int q = 1;
    private static int r = 1;
    private static int s = 1;
    private static int t = 1;
    private static int u = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f810e;
    public boolean f;
    float[] g;
    float[] h;
    a i;
    b[] j;
    int k;
    public int l;
    boolean m;
    int n;
    float o;
    HashSet<b> p;
    private String v;

    /* JADX INFO: compiled from: SolverVariable.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f811a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f812b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f813c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f814d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f815e = null;
        private static final /* synthetic */ a[] f = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("UNRESTRICTED", 0);
            f811a = r0;
            a r1 = new a("CONSTANT", 1);
            f812b = r1;
            a r3 = new a("SLACK", 2);
            f813c = r3;
            a r5 = new a("ERROR", 3);
            f814d = r5;
            a r7 = new a("UNKNOWN", 4);
            f815e = r7;
            f = new a[]{r0, r1, r3, r5, r7};
        }
    }

    static {
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(h r3) {
        return a((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"));
    }

    static void a() {
        r++;
    }

    public h(a r4, String r5) {
        this.f807b = -1;
        this.f808c = -1;
        this.f809d = 0;
        this.f = false;
        this.g = new float[9];
        this.h = new float[9];
        this.j = new b[16];
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = -1;
        this.o = 0.0f;
        this.p = null;
        this.i = r4;
    }

    public final void a(b r4) {
        int r0 = 0;
    L3:
        int r1 = this.k;
        if (r0 >= r1) goto L9;
        if (this.j[r0] == r4) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return;
    L9:
        b[] r2 = this.j;
        if (r1 < r2.length) goto L12;
        this.j = (b[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length * 2), b[].class, "com.obric.aiagent.plugin");
    L12:
        b[] r3 = this.j;
        int r5 = this.k;
        r3[r5] = r4;
        this.k = r5 + 1;
    }

    public final void b(b r5) {
        int r0 = this.k;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        if (this.j[r1] == r5) goto L7;
        r1 = r1 + 1;
    L7:
        if (r1 >= (r0 - 1)) goto L9;
        b[] r6 = this.j;
        int r2 = r1 + 1;
        r6[r1] = r6[r2];
        r1 = r2;
        goto L7
    L9:
        this.k--;
        return;
    }

    public final void a(d r5, b r6) {
        int r0 = this.k;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.j[r2].a(r5, r6, false);
        r2 = r2 + 1;
        goto L3
    L5:
        this.k = 0;
    }

    public void a(d r4, float r5) {
        this.f810e = r5;
        this.f = true;
        this.m = false;
        this.n = -1;
        this.o = 0.0f;
        int r1 = this.k;
        this.f808c = -1;
        int r0 = 0;
    L3:
        if (r0 >= r1) goto L5;
        this.j[r0].a(r4, this, false);
        r0 = r0 + 1;
        goto L3
    L5:
        this.k = 0;
    }

    public void b() {
        this.v = null;
        this.i = a.f815e;
        this.f809d = 0;
        this.f807b = -1;
        this.f808c = -1;
        this.f810e = 0.0f;
        this.f = false;
        this.m = false;
        this.n = -1;
        this.o = 0.0f;
        int r2 = this.k;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        this.j[r4] = null;
        r4 = r4 + 1;
        goto L3
    L5:
        this.k = 0;
        this.l = 0;
        this.f806a = false;
        Arrays.fill(this.h, 0.0f);
    }

    public void a(a r1, String r2) {
        this.i = r1;
    }

    public int a(h r1) {
        return this.f807b - r1.f807b;
    }

    public String toString() {
        if (this.v == null) goto L6;
        return "" + this.v;
    L6:
        return "" + this.f807b;
    }
}
