package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariable implements Comparable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f1312r = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f1318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f1320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f1321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Type f1322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayRow[] f1323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1324l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1325m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1326n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1327o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f1328p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashSet f1329q;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CONSTANT = null;
        public static final Type ERROR = null;
        public static final Type SLACK = null;
        public static final Type UNKNOWN = null;
        public static final Type UNRESTRICTED = null;

        static {
            Type r10 = new Type("UNRESTRICTED", 0);
            UNRESTRICTED = r10;
            Type r11 = new Type("CONSTANT", 1);
            CONSTANT = r11;
            Type r12 = new Type("SLACK", 2);
            SLACK = r12;
            Type r13 = new Type("ERROR", 3);
            ERROR = r13;
            Type r14 = new Type("UNKNOWN", 4);
            UNKNOWN = r14;
            $VALUES = new Type[]{r10, r11, r12, r13, r14};
        }

        private Type(String r10, int r11) {
            super(r10, r11);
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    static {
    }

    public SolverVariable(Type r10, String r11) {
        this.f1315c = -1;
        this.f1316d = -1;
        this.f1317e = 0;
        this.f1319g = false;
        this.f1320h = new float[9];
        this.f1321i = new float[9];
        this.f1323k = new ArrayRow[16];
        this.f1324l = 0;
        this.f1325m = 0;
        this.f1326n = false;
        this.f1327o = -1;
        this.f1328p = 0.0f;
        this.f1329q = null;
        this.f1322j = r10;
    }

    public static void c() {
        f1312r++;
    }

    public final void a(ArrayRow r10) {
        int r11 = 0;
    L3:
        int r12 = this.f1324l;
        if (r11 >= r12) goto L9;
        if (this.f1323k[r11] == r10) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return;
    L9:
        ArrayRow[] r13 = this.f1323k;
        if (r12 < r13.length) goto L12;
        this.f1323k = (ArrayRow[]) Arrays.copyOf(r13, r13.length * 2);
    L12:
        ArrayRow[] r14 = this.f1323k;
        int r15 = this.f1324l;
        r14[r15] = r10;
        this.f1324l = r15 + 1;
    }

    public int b(SolverVariable r10) {
        return this.f1315c - r10.f1315c;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return b((SolverVariable) r10);
    }

    public final void d(ArrayRow r10) {
        int r11 = this.f1324l;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        if (this.f1323k[r12] == r10) goto L7;
        r12 = r12 + 1;
    L7:
        if (r12 >= (r11 - 1)) goto L9;
        ArrayRow[] r13 = this.f1323k;
        int r14 = r12 + 1;
        r13[r12] = r13[r14];
        r12 = r14;
        goto L7
    L9:
        this.f1324l--;
        return;
    }

    public void e() {
        this.f1314b = null;
        this.f1322j = Type.UNKNOWN;
        this.f1317e = 0;
        this.f1315c = -1;
        this.f1316d = -1;
        this.f1318f = 0.0f;
        this.f1319g = false;
        this.f1326n = false;
        this.f1327o = -1;
        this.f1328p = 0.0f;
        int r10 = this.f1324l;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.f1323k[r11] = null;
        r11 = r11 + 1;
        goto L3
    L5:
        this.f1324l = 0;
        this.f1325m = 0;
        this.f1313a = false;
        Arrays.fill(this.f1321i, 0.0f);
    }

    public void f(LinearSystem r10, float r11) {
        this.f1318f = r11;
        this.f1319g = true;
        this.f1326n = false;
        this.f1327o = -1;
        this.f1328p = 0.0f;
        int r12 = this.f1324l;
        this.f1316d = -1;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.f1323k[r13].updateFromFinalVariable(r10, this, false);
        r13 = r13 + 1;
        goto L3
    L5:
        this.f1324l = 0;
    }

    public void g(Type r10, String r11) {
        this.f1322j = r10;
    }

    public final void h(LinearSystem r10, ArrayRow r11) {
        int r12 = this.f1324l;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.f1323k[r13].updateFromRow(r10, r11, false);
        r13 = r13 + 1;
        goto L3
    L5:
        this.f1324l = 0;
    }

    public String toString() {
        if (this.f1314b == null) goto L6;
        return "" + this.f1314b;
    L6:
        return "" + this.f1315c;
    }
}
