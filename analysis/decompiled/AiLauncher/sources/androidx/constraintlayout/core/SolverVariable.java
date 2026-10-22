package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {

    /* renamed from: r, reason: collision with root package name */
    public static int f11837r = 1;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11838a;

    /* renamed from: b, reason: collision with root package name */
    public String f11839b;

    /* renamed from: f, reason: collision with root package name */
    public float f11843f;

    /* renamed from: j, reason: collision with root package name */
    public Type f11847j;

    /* renamed from: c, reason: collision with root package name */
    public int f11840c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f11841d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f11842e = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11844g = false;

    /* renamed from: h, reason: collision with root package name */
    public float[] f11845h = new float[9];

    /* renamed from: i, reason: collision with root package name */
    public float[] f11846i = new float[9];

    /* renamed from: k, reason: collision with root package name */
    public b[] f11848k = new b[16];

    /* renamed from: l, reason: collision with root package name */
    public int f11849l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f11850m = 0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11851n = false;

    /* renamed from: o, reason: collision with root package name */
    public int f11852o = -1;

    /* renamed from: p, reason: collision with root package name */
    public float f11853p = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    public HashSet<b> f11854q = null;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f11847j = type;
    }

    public static void c() {
        f11837r++;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f11849l;
            if (i10 >= i11) {
                b[] bVarArr = this.f11848k;
                if (i11 >= bVarArr.length) {
                    this.f11848k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f11848k;
                int i12 = this.f11849l;
                bVarArr2[i12] = bVar;
                this.f11849l = i12 + 1;
                return;
            }
            if (this.f11848k[i10] == bVar) {
                return;
            } else {
                i10++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(SolverVariable solverVariable) {
        return this.f11840c - solverVariable.f11840c;
    }

    public final void e(b bVar) {
        int i10 = this.f11849l;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f11848k[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f11848k;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f11849l--;
                return;
            }
            i11++;
        }
    }

    public void i() {
        this.f11839b = null;
        this.f11847j = Type.UNKNOWN;
        this.f11842e = 0;
        this.f11840c = -1;
        this.f11841d = -1;
        this.f11843f = 0.0f;
        this.f11844g = false;
        this.f11851n = false;
        this.f11852o = -1;
        this.f11853p = 0.0f;
        int i10 = this.f11849l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f11848k[i11] = null;
        }
        this.f11849l = 0;
        this.f11850m = 0;
        this.f11838a = false;
        Arrays.fill(this.f11846i, 0.0f);
    }

    public void j(c cVar, float f10) {
        this.f11843f = f10;
        this.f11844g = true;
        this.f11851n = false;
        this.f11852o = -1;
        this.f11853p = 0.0f;
        int i10 = this.f11849l;
        this.f11841d = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f11848k[i11].A(cVar, this, false);
        }
        this.f11849l = 0;
    }

    public void k(Type type, String str) {
        this.f11847j = type;
    }

    public final void l(c cVar, b bVar) {
        int i10 = this.f11849l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f11848k[i11].B(cVar, bVar, false);
        }
        this.f11849l = 0;
    }

    public String toString() {
        if (this.f11839b != null) {
            return "" + this.f11839b;
        }
        return "" + this.f11840c;
    }
}
