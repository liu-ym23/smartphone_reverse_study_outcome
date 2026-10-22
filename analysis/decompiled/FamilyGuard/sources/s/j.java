package s;

import java.util.Arrays;
import s.C1044b;

/* loaded from: classes.dex */
public class j implements C1044b.a {

    /* renamed from: n, reason: collision with root package name */
    private static float f20214n = 0.001f;

    /* renamed from: a, reason: collision with root package name */
    private final int f20215a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f20216b = 16;

    /* renamed from: c, reason: collision with root package name */
    private int f20217c = 16;

    /* renamed from: d, reason: collision with root package name */
    int[] f20218d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    int[] f20219e = new int[16];

    /* renamed from: f, reason: collision with root package name */
    int[] f20220f = new int[16];

    /* renamed from: g, reason: collision with root package name */
    float[] f20221g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    int[] f20222h = new int[16];

    /* renamed from: i, reason: collision with root package name */
    int[] f20223i = new int[16];

    /* renamed from: j, reason: collision with root package name */
    int f20224j = 0;

    /* renamed from: k, reason: collision with root package name */
    int f20225k = -1;

    /* renamed from: l, reason: collision with root package name */
    private final C1044b f20226l;

    /* renamed from: m, reason: collision with root package name */
    protected final C1045c f20227m;

    j(C1044b c1044b, C1045c c1045c) {
        this.f20226l = c1044b;
        this.f20227m = c1045c;
        clear();
    }

    private void l(i iVar, int i5) {
        int[] iArr;
        int i6 = iVar.f20193c % this.f20217c;
        int[] iArr2 = this.f20218d;
        int i7 = iArr2[i6];
        if (i7 == -1) {
            iArr2[i6] = i5;
        } else {
            while (true) {
                iArr = this.f20219e;
                int i8 = iArr[i7];
                if (i8 == -1) {
                    break;
                } else {
                    i7 = i8;
                }
            }
            iArr[i7] = i5;
        }
        this.f20219e[i5] = -1;
    }

    private void m(int i5, i iVar, float f5) {
        this.f20220f[i5] = iVar.f20193c;
        this.f20221g[i5] = f5;
        this.f20222h[i5] = -1;
        this.f20223i[i5] = -1;
        iVar.b(this.f20226l);
        iVar.f20203m++;
        this.f20224j++;
    }

    private int n() {
        for (int i5 = 0; i5 < this.f20216b; i5++) {
            if (this.f20220f[i5] == -1) {
                return i5;
            }
        }
        return -1;
    }

    private void o() {
        int i5 = this.f20216b * 2;
        this.f20220f = Arrays.copyOf(this.f20220f, i5);
        this.f20221g = Arrays.copyOf(this.f20221g, i5);
        this.f20222h = Arrays.copyOf(this.f20222h, i5);
        this.f20223i = Arrays.copyOf(this.f20223i, i5);
        this.f20219e = Arrays.copyOf(this.f20219e, i5);
        for (int i6 = this.f20216b; i6 < i5; i6++) {
            this.f20220f[i6] = -1;
            this.f20219e[i6] = -1;
        }
        this.f20216b = i5;
    }

    private void q(int i5, i iVar, float f5) {
        int iN = n();
        m(iN, iVar, f5);
        if (i5 != -1) {
            this.f20222h[iN] = i5;
            int[] iArr = this.f20223i;
            iArr[iN] = iArr[i5];
            iArr[i5] = iN;
        } else {
            this.f20222h[iN] = -1;
            if (this.f20224j > 0) {
                this.f20223i[iN] = this.f20225k;
                this.f20225k = iN;
            } else {
                this.f20223i[iN] = -1;
            }
        }
        int i6 = this.f20223i[iN];
        if (i6 != -1) {
            this.f20222h[i6] = iN;
        }
        l(iVar, iN);
    }

    private void r(i iVar) {
        int[] iArr;
        int i5;
        int i6 = iVar.f20193c;
        int i7 = i6 % this.f20217c;
        int[] iArr2 = this.f20218d;
        int i8 = iArr2[i7];
        if (i8 == -1) {
            return;
        }
        if (this.f20220f[i8] == i6) {
            int[] iArr3 = this.f20219e;
            iArr2[i7] = iArr3[i8];
            iArr3[i8] = -1;
            return;
        }
        while (true) {
            iArr = this.f20219e;
            i5 = iArr[i8];
            if (i5 == -1 || this.f20220f[i5] == i6) {
                break;
            } else {
                i8 = i5;
            }
        }
        if (i5 == -1 || this.f20220f[i5] != i6) {
            return;
        }
        iArr[i8] = iArr[i5];
        iArr[i5] = -1;
    }

    @Override // s.C1044b.a
    public void a(i iVar, float f5) {
        float f6 = f20214n;
        if (f5 > (-f6) && f5 < f6) {
            d(iVar, true);
            return;
        }
        if (this.f20224j == 0) {
            m(0, iVar, f5);
            l(iVar, 0);
            this.f20225k = 0;
            return;
        }
        int iP = p(iVar);
        if (iP != -1) {
            this.f20221g[iP] = f5;
            return;
        }
        if (this.f20224j + 1 >= this.f20216b) {
            o();
        }
        int i5 = this.f20224j;
        int i6 = this.f20225k;
        int i7 = -1;
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = this.f20220f[i6];
            int i10 = iVar.f20193c;
            if (i9 == i10) {
                this.f20221g[i6] = f5;
                return;
            }
            if (i9 < i10) {
                i7 = i6;
            }
            i6 = this.f20223i[i6];
            if (i6 == -1) {
                break;
            }
        }
        q(i7, iVar, f5);
    }

    @Override // s.C1044b.a
    public int b() {
        return this.f20224j;
    }

    @Override // s.C1044b.a
    public float c(C1044b c1044b, boolean z5) {
        float f5 = f(c1044b.f20142a);
        d(c1044b.f20142a, z5);
        j jVar = (j) c1044b.f20146e;
        int iB = jVar.b();
        int i5 = 0;
        int i6 = 0;
        while (i5 < iB) {
            int i7 = jVar.f20220f[i6];
            if (i7 != -1) {
                k(this.f20227m.f20151d[i7], jVar.f20221g[i6] * f5, z5);
                i5++;
            }
            i6++;
        }
        return f5;
    }

    @Override // s.C1044b.a
    public void clear() {
        int i5 = this.f20224j;
        for (int i6 = 0; i6 < i5; i6++) {
            i iVarE = e(i6);
            if (iVarE != null) {
                iVarE.g(this.f20226l);
            }
        }
        for (int i7 = 0; i7 < this.f20216b; i7++) {
            this.f20220f[i7] = -1;
            this.f20219e[i7] = -1;
        }
        for (int i8 = 0; i8 < this.f20217c; i8++) {
            this.f20218d[i8] = -1;
        }
        this.f20224j = 0;
        this.f20225k = -1;
    }

    @Override // s.C1044b.a
    public float d(i iVar, boolean z5) {
        int iP = p(iVar);
        if (iP == -1) {
            return 0.0f;
        }
        r(iVar);
        float f5 = this.f20221g[iP];
        if (this.f20225k == iP) {
            this.f20225k = this.f20223i[iP];
        }
        this.f20220f[iP] = -1;
        int[] iArr = this.f20222h;
        int i5 = iArr[iP];
        if (i5 != -1) {
            int[] iArr2 = this.f20223i;
            iArr2[i5] = iArr2[iP];
        }
        int i6 = this.f20223i[iP];
        if (i6 != -1) {
            iArr[i6] = iArr[iP];
        }
        this.f20224j--;
        iVar.f20203m--;
        if (z5) {
            iVar.g(this.f20226l);
        }
        return f5;
    }

    @Override // s.C1044b.a
    public i e(int i5) {
        int i6 = this.f20224j;
        if (i6 == 0) {
            return null;
        }
        int i7 = this.f20225k;
        for (int i8 = 0; i8 < i6; i8++) {
            if (i8 == i5 && i7 != -1) {
                return this.f20227m.f20151d[this.f20220f[i7]];
            }
            i7 = this.f20223i[i7];
            if (i7 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // s.C1044b.a
    public float f(i iVar) {
        int iP = p(iVar);
        if (iP != -1) {
            return this.f20221g[iP];
        }
        return 0.0f;
    }

    @Override // s.C1044b.a
    public void g() {
        int i5 = this.f20224j;
        int i6 = this.f20225k;
        for (int i7 = 0; i7 < i5; i7++) {
            float[] fArr = this.f20221g;
            fArr[i6] = fArr[i6] * (-1.0f);
            i6 = this.f20223i[i6];
            if (i6 == -1) {
                return;
            }
        }
    }

    @Override // s.C1044b.a
    public float h(int i5) {
        int i6 = this.f20224j;
        int i7 = this.f20225k;
        for (int i8 = 0; i8 < i6; i8++) {
            if (i8 == i5) {
                return this.f20221g[i7];
            }
            i7 = this.f20223i[i7];
            if (i7 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // s.C1044b.a
    public boolean i(i iVar) {
        return p(iVar) != -1;
    }

    @Override // s.C1044b.a
    public void j(float f5) {
        int i5 = this.f20224j;
        int i6 = this.f20225k;
        for (int i7 = 0; i7 < i5; i7++) {
            float[] fArr = this.f20221g;
            fArr[i6] = fArr[i6] / f5;
            i6 = this.f20223i[i6];
            if (i6 == -1) {
                return;
            }
        }
    }

    @Override // s.C1044b.a
    public void k(i iVar, float f5, boolean z5) {
        float f6 = f20214n;
        if (f5 <= (-f6) || f5 >= f6) {
            int iP = p(iVar);
            if (iP == -1) {
                a(iVar, f5);
                return;
            }
            float[] fArr = this.f20221g;
            float f7 = fArr[iP] + f5;
            fArr[iP] = f7;
            float f8 = f20214n;
            if (f7 <= (-f8) || f7 >= f8) {
                return;
            }
            fArr[iP] = 0.0f;
            d(iVar, z5);
        }
    }

    public int p(i iVar) {
        if (this.f20224j != 0 && iVar != null) {
            int i5 = iVar.f20193c;
            int i6 = this.f20218d[i5 % this.f20217c];
            if (i6 == -1) {
                return -1;
            }
            if (this.f20220f[i6] == i5) {
                return i6;
            }
            do {
                i6 = this.f20219e[i6];
                if (i6 == -1) {
                    break;
                }
            } while (this.f20220f[i6] != i5);
            if (i6 != -1 && this.f20220f[i6] == i5) {
                return i6;
            }
        }
        return -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i5 = this.f20224j;
        for (int i6 = 0; i6 < i5; i6++) {
            i iVarE = e(i6);
            if (iVarE != null) {
                String str2 = str + iVarE + " = " + h(i6) + " ";
                int iP = p(iVarE);
                String str3 = str2 + "[p: ";
                String str4 = (this.f20222h[iP] != -1 ? str3 + this.f20227m.f20151d[this.f20220f[this.f20222h[iP]]] : str3 + "none") + ", n: ";
                str = (this.f20223i[iP] != -1 ? str4 + this.f20227m.f20151d[this.f20220f[this.f20223i[iP]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
