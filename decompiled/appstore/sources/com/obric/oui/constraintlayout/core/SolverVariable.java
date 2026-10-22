package com.obric.oui.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public class SolverVariable implements Comparable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f13126r = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f13132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f13134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f13135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Type f13136j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayRow[] f13137k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13138l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13139m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13140n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13141o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13142p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashSet f13143q;

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
        this.f13129c = -1;
        this.f13130d = -1;
        this.f13131e = 0;
        this.f13133g = false;
        this.f13134h = new float[9];
        this.f13135i = new float[9];
        this.f13137k = new ArrayRow[16];
        this.f13138l = 0;
        this.f13139m = 0;
        this.f13140n = false;
        this.f13141o = -1;
        this.f13142p = 0.0f;
        this.f13143q = null;
        this.f13136j = r10;
    }

    public static void c() {
        f13126r++;
    }

    public final void a(ArrayRow r10) {
        int r11 = 0;
    L3:
        int r12 = this.f13138l;
        if (r11 >= r12) goto L9;
        if (this.f13137k[r11] == r10) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return;
    L9:
        ArrayRow[] r13 = this.f13137k;
        if (r12 < r13.length) goto L12;
        this.f13137k = (ArrayRow[]) Arrays.copyOf(r13, r13.length * 2);
    L12:
        ArrayRow[] r14 = this.f13137k;
        int r15 = this.f13138l;
        r14[r15] = r10;
        this.f13138l = r15 + 1;
    }

    public int b(SolverVariable r10) {
        return this.f13129c - r10.f13129c;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return b((SolverVariable) r10);
    }

    public final void d(ArrayRow r10) {
        int r11 = this.f13138l;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        if (this.f13137k[r12] == r10) goto L7;
        r12 = r12 + 1;
    L7:
        if (r12 >= (r11 - 1)) goto L9;
        ArrayRow[] r13 = this.f13137k;
        int r14 = r12 + 1;
        r13[r12] = r13[r14];
        r12 = r14;
        goto L7
    L9:
        this.f13138l--;
        return;
    }

    public void e() {
        this.f13128b = null;
        this.f13136j = Type.UNKNOWN;
        this.f13131e = 0;
        this.f13129c = -1;
        this.f13130d = -1;
        this.f13132f = 0.0f;
        this.f13133g = false;
        this.f13140n = false;
        this.f13141o = -1;
        this.f13142p = 0.0f;
        int r10 = this.f13138l;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.f13137k[r11] = null;
        r11 = r11 + 1;
        goto L3
    L5:
        this.f13138l = 0;
        this.f13139m = 0;
        this.f13127a = false;
        Arrays.fill(this.f13135i, 0.0f);
    }

    public void f(LinearSystem r10, float r11) {
        this.f13132f = r11;
        this.f13133g = true;
        this.f13140n = false;
        this.f13141o = -1;
        this.f13142p = 0.0f;
        int r12 = this.f13138l;
        this.f13130d = -1;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.f13137k[r13].updateFromFinalVariable(r10, this, false);
        r13 = r13 + 1;
        goto L3
    L5:
        this.f13138l = 0;
    }

    public void g(Type r10, String r11) {
        this.f13136j = r10;
    }

    public final void h(LinearSystem r10, ArrayRow r11) {
        int r12 = this.f13138l;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.f13137k[r13].updateFromRow(r10, r11, false);
        r13 = r13 + 1;
        goto L3
    L5:
        this.f13138l = 0;
    }

    public String toString() {
        if (this.f13128b == null) goto L6;
        return "" + this.f13128b;
    L6:
        return "" + this.f13129c;
    }
}
