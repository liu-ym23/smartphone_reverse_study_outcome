package s;

import java.util.Arrays;
import org.libpag.BuildConfig;
import s.C1044b;

/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1043a implements C1044b.a {

    /* renamed from: l, reason: collision with root package name */
    private static float f20130l = 0.001f;

    /* renamed from: b, reason: collision with root package name */
    private final C1044b f20132b;

    /* renamed from: c, reason: collision with root package name */
    protected final C1045c f20133c;

    /* renamed from: a, reason: collision with root package name */
    int f20131a = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f20134d = 8;

    /* renamed from: e, reason: collision with root package name */
    private i f20135e = null;

    /* renamed from: f, reason: collision with root package name */
    private int[] f20136f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    private int[] f20137g = new int[8];

    /* renamed from: h, reason: collision with root package name */
    private float[] f20138h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    private int f20139i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f20140j = -1;

    /* renamed from: k, reason: collision with root package name */
    private boolean f20141k = false;

    C1043a(C1044b c1044b, C1045c c1045c) {
        this.f20132b = c1044b;
        this.f20133c = c1045c;
    }

    @Override // s.C1044b.a
    public final void a(i iVar, float f5) {
        if (f5 == 0.0f) {
            d(iVar, true);
            return;
        }
        int i5 = this.f20139i;
        if (i5 == -1) {
            this.f20139i = 0;
            this.f20138h[0] = f5;
            this.f20136f[0] = iVar.f20193c;
            this.f20137g[0] = -1;
            iVar.f20203m++;
            iVar.b(this.f20132b);
            this.f20131a++;
            if (this.f20141k) {
                return;
            }
            int i6 = this.f20140j + 1;
            this.f20140j = i6;
            int[] iArr = this.f20136f;
            if (i6 >= iArr.length) {
                this.f20141k = true;
                this.f20140j = iArr.length - 1;
                return;
            }
            return;
        }
        int i7 = -1;
        for (int i8 = 0; i5 != -1 && i8 < this.f20131a; i8++) {
            int i9 = this.f20136f[i5];
            int i10 = iVar.f20193c;
            if (i9 == i10) {
                this.f20138h[i5] = f5;
                return;
            }
            if (i9 < i10) {
                i7 = i5;
            }
            i5 = this.f20137g[i5];
        }
        int length = this.f20140j;
        int i11 = length + 1;
        if (this.f20141k) {
            int[] iArr2 = this.f20136f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i11;
        }
        int[] iArr3 = this.f20136f;
        if (length >= iArr3.length && this.f20131a < iArr3.length) {
            int i12 = 0;
            while (true) {
                int[] iArr4 = this.f20136f;
                if (i12 >= iArr4.length) {
                    break;
                }
                if (iArr4[i12] == -1) {
                    length = i12;
                    break;
                }
                i12++;
            }
        }
        int[] iArr5 = this.f20136f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i13 = this.f20134d * 2;
            this.f20134d = i13;
            this.f20141k = false;
            this.f20140j = length - 1;
            this.f20138h = Arrays.copyOf(this.f20138h, i13);
            this.f20136f = Arrays.copyOf(this.f20136f, this.f20134d);
            this.f20137g = Arrays.copyOf(this.f20137g, this.f20134d);
        }
        this.f20136f[length] = iVar.f20193c;
        this.f20138h[length] = f5;
        if (i7 != -1) {
            int[] iArr6 = this.f20137g;
            iArr6[length] = iArr6[i7];
            iArr6[i7] = length;
        } else {
            this.f20137g[length] = this.f20139i;
            this.f20139i = length;
        }
        iVar.f20203m++;
        iVar.b(this.f20132b);
        int i14 = this.f20131a + 1;
        this.f20131a = i14;
        if (!this.f20141k) {
            this.f20140j++;
        }
        int[] iArr7 = this.f20136f;
        if (i14 >= iArr7.length) {
            this.f20141k = true;
        }
        if (this.f20140j >= iArr7.length) {
            this.f20141k = true;
            this.f20140j = iArr7.length - 1;
        }
    }

    @Override // s.C1044b.a
    public int b() {
        return this.f20131a;
    }

    @Override // s.C1044b.a
    public float c(C1044b c1044b, boolean z5) {
        float f5 = f(c1044b.f20142a);
        d(c1044b.f20142a, z5);
        C1044b.a aVar = c1044b.f20146e;
        int iB = aVar.b();
        for (int i5 = 0; i5 < iB; i5++) {
            i iVarE = aVar.e(i5);
            k(iVarE, aVar.f(iVarE) * f5, z5);
        }
        return f5;
    }

    @Override // s.C1044b.a
    public final void clear() {
        int i5 = this.f20139i;
        for (int i6 = 0; i5 != -1 && i6 < this.f20131a; i6++) {
            i iVar = this.f20133c.f20151d[this.f20136f[i5]];
            if (iVar != null) {
                iVar.g(this.f20132b);
            }
            i5 = this.f20137g[i5];
        }
        this.f20139i = -1;
        this.f20140j = -1;
        this.f20141k = false;
        this.f20131a = 0;
    }

    @Override // s.C1044b.a
    public final float d(i iVar, boolean z5) {
        if (this.f20135e == iVar) {
            this.f20135e = null;
        }
        int i5 = this.f20139i;
        if (i5 == -1) {
            return 0.0f;
        }
        int i6 = 0;
        int i7 = -1;
        while (i5 != -1 && i6 < this.f20131a) {
            if (this.f20136f[i5] == iVar.f20193c) {
                if (i5 == this.f20139i) {
                    this.f20139i = this.f20137g[i5];
                } else {
                    int[] iArr = this.f20137g;
                    iArr[i7] = iArr[i5];
                }
                if (z5) {
                    iVar.g(this.f20132b);
                }
                iVar.f20203m--;
                this.f20131a--;
                this.f20136f[i5] = -1;
                if (this.f20141k) {
                    this.f20140j = i5;
                }
                return this.f20138h[i5];
            }
            i6++;
            i7 = i5;
            i5 = this.f20137g[i5];
        }
        return 0.0f;
    }

    @Override // s.C1044b.a
    public i e(int i5) {
        int i6 = this.f20139i;
        for (int i7 = 0; i6 != -1 && i7 < this.f20131a; i7++) {
            if (i7 == i5) {
                return this.f20133c.f20151d[this.f20136f[i6]];
            }
            i6 = this.f20137g[i6];
        }
        return null;
    }

    @Override // s.C1044b.a
    public final float f(i iVar) {
        int i5 = this.f20139i;
        for (int i6 = 0; i5 != -1 && i6 < this.f20131a; i6++) {
            if (this.f20136f[i5] == iVar.f20193c) {
                return this.f20138h[i5];
            }
            i5 = this.f20137g[i5];
        }
        return 0.0f;
    }

    @Override // s.C1044b.a
    public void g() {
        int i5 = this.f20139i;
        for (int i6 = 0; i5 != -1 && i6 < this.f20131a; i6++) {
            float[] fArr = this.f20138h;
            fArr[i5] = fArr[i5] * (-1.0f);
            i5 = this.f20137g[i5];
        }
    }

    @Override // s.C1044b.a
    public float h(int i5) {
        int i6 = this.f20139i;
        for (int i7 = 0; i6 != -1 && i7 < this.f20131a; i7++) {
            if (i7 == i5) {
                return this.f20138h[i6];
            }
            i6 = this.f20137g[i6];
        }
        return 0.0f;
    }

    @Override // s.C1044b.a
    public boolean i(i iVar) {
        int i5 = this.f20139i;
        if (i5 == -1) {
            return false;
        }
        for (int i6 = 0; i5 != -1 && i6 < this.f20131a; i6++) {
            if (this.f20136f[i5] == iVar.f20193c) {
                return true;
            }
            i5 = this.f20137g[i5];
        }
        return false;
    }

    @Override // s.C1044b.a
    public void j(float f5) {
        int i5 = this.f20139i;
        for (int i6 = 0; i5 != -1 && i6 < this.f20131a; i6++) {
            float[] fArr = this.f20138h;
            fArr[i5] = fArr[i5] / f5;
            i5 = this.f20137g[i5];
        }
    }

    @Override // s.C1044b.a
    public void k(i iVar, float f5, boolean z5) {
        float f6 = f20130l;
        if (f5 <= (-f6) || f5 >= f6) {
            int i5 = this.f20139i;
            if (i5 == -1) {
                this.f20139i = 0;
                this.f20138h[0] = f5;
                this.f20136f[0] = iVar.f20193c;
                this.f20137g[0] = -1;
                iVar.f20203m++;
                iVar.b(this.f20132b);
                this.f20131a++;
                if (this.f20141k) {
                    return;
                }
                int i6 = this.f20140j + 1;
                this.f20140j = i6;
                int[] iArr = this.f20136f;
                if (i6 >= iArr.length) {
                    this.f20141k = true;
                    this.f20140j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i7 = -1;
            for (int i8 = 0; i5 != -1 && i8 < this.f20131a; i8++) {
                int i9 = this.f20136f[i5];
                int i10 = iVar.f20193c;
                if (i9 == i10) {
                    float[] fArr = this.f20138h;
                    float f7 = fArr[i5] + f5;
                    float f8 = f20130l;
                    if (f7 > (-f8) && f7 < f8) {
                        f7 = 0.0f;
                    }
                    fArr[i5] = f7;
                    if (f7 == 0.0f) {
                        if (i5 == this.f20139i) {
                            this.f20139i = this.f20137g[i5];
                        } else {
                            int[] iArr2 = this.f20137g;
                            iArr2[i7] = iArr2[i5];
                        }
                        if (z5) {
                            iVar.g(this.f20132b);
                        }
                        if (this.f20141k) {
                            this.f20140j = i5;
                        }
                        iVar.f20203m--;
                        this.f20131a--;
                        return;
                    }
                    return;
                }
                if (i9 < i10) {
                    i7 = i5;
                }
                i5 = this.f20137g[i5];
            }
            int length = this.f20140j;
            int i11 = length + 1;
            if (this.f20141k) {
                int[] iArr3 = this.f20136f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i11;
            }
            int[] iArr4 = this.f20136f;
            if (length >= iArr4.length && this.f20131a < iArr4.length) {
                int i12 = 0;
                while (true) {
                    int[] iArr5 = this.f20136f;
                    if (i12 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i12] == -1) {
                        length = i12;
                        break;
                    }
                    i12++;
                }
            }
            int[] iArr6 = this.f20136f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i13 = this.f20134d * 2;
                this.f20134d = i13;
                this.f20141k = false;
                this.f20140j = length - 1;
                this.f20138h = Arrays.copyOf(this.f20138h, i13);
                this.f20136f = Arrays.copyOf(this.f20136f, this.f20134d);
                this.f20137g = Arrays.copyOf(this.f20137g, this.f20134d);
            }
            this.f20136f[length] = iVar.f20193c;
            this.f20138h[length] = f5;
            if (i7 != -1) {
                int[] iArr7 = this.f20137g;
                iArr7[length] = iArr7[i7];
                iArr7[i7] = length;
            } else {
                this.f20137g[length] = this.f20139i;
                this.f20139i = length;
            }
            iVar.f20203m++;
            iVar.b(this.f20132b);
            this.f20131a++;
            if (!this.f20141k) {
                this.f20140j++;
            }
            int i14 = this.f20140j;
            int[] iArr8 = this.f20136f;
            if (i14 >= iArr8.length) {
                this.f20141k = true;
                this.f20140j = iArr8.length - 1;
            }
        }
    }

    public String toString() {
        int i5 = this.f20139i;
        String str = BuildConfig.FLAVOR;
        for (int i6 = 0; i5 != -1 && i6 < this.f20131a; i6++) {
            str = ((str + " -> ") + this.f20138h[i5] + " : ") + this.f20133c.f20151d[this.f20136f[i5]];
            i5 = this.f20137g[i5];
        }
        return str;
    }
}
