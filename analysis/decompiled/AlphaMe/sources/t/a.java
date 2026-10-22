package t;

import androidx.room.AbstractC0351g;
import com.stepos.alphame.utils.Property;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: b, reason: collision with root package name */
    public final c f15258b;

    /* renamed from: c, reason: collision with root package name */
    public final d f15259c;

    /* renamed from: a, reason: collision with root package name */
    public int f15257a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f15260d = 8;

    /* renamed from: e, reason: collision with root package name */
    public int[] f15261e = new int[8];

    /* renamed from: f, reason: collision with root package name */
    public int[] f15262f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public float[] f15263g = new float[8];

    /* renamed from: h, reason: collision with root package name */
    public int f15264h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f15265i = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15266j = false;

    public a(c cVar, d dVar) {
        this.f15258b = cVar;
        this.f15259c = dVar;
    }

    @Override // t.b
    public final float a(int i4) {
        int i5 = this.f15264h;
        for (int i6 = 0; i5 != -1 && i6 < this.f15257a; i6++) {
            if (i6 == i4) {
                return this.f15263g[i5];
            }
            i5 = this.f15262f[i5];
        }
        return Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // t.b
    public final float b(c cVar, boolean z4) {
        float fE = e(cVar.f15267a);
        c(cVar.f15267a, z4);
        b bVar = cVar.f15270d;
        int iF = bVar.f();
        for (int i4 = 0; i4 < iF; i4++) {
            i iVarH = bVar.h(i4);
            j(iVarH, bVar.e(iVarH) * fE, z4);
        }
        return fE;
    }

    @Override // t.b
    public final float c(i iVar, boolean z4) {
        int i4 = this.f15264h;
        if (i4 == -1) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        int i5 = 0;
        int i6 = -1;
        while (i4 != -1 && i5 < this.f15257a) {
            if (this.f15261e[i4] == iVar.f15302b) {
                if (i4 == this.f15264h) {
                    this.f15264h = this.f15262f[i4];
                } else {
                    int[] iArr = this.f15262f;
                    iArr[i6] = iArr[i4];
                }
                if (z4) {
                    iVar.b(this.f15258b);
                }
                iVar.f15311k--;
                this.f15257a--;
                this.f15261e[i4] = -1;
                if (this.f15266j) {
                    this.f15265i = i4;
                }
                return this.f15263g[i4];
            }
            i5++;
            i6 = i4;
            i4 = this.f15262f[i4];
        }
        return Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // t.b
    public final void clear() {
        int i4 = this.f15264h;
        for (int i5 = 0; i4 != -1 && i5 < this.f15257a; i5++) {
            i iVar = ((i[]) this.f15259c.f15276d)[this.f15261e[i4]];
            if (iVar != null) {
                iVar.b(this.f15258b);
            }
            i4 = this.f15262f[i4];
        }
        this.f15264h = -1;
        this.f15265i = -1;
        this.f15266j = false;
        this.f15257a = 0;
    }

    @Override // t.b
    public final void d(i iVar, float f4) {
        if (f4 == Property.DEFAULT_FLOAT_VALUE) {
            c(iVar, true);
            return;
        }
        int i4 = this.f15264h;
        c cVar = this.f15258b;
        if (i4 == -1) {
            this.f15264h = 0;
            this.f15263g[0] = f4;
            this.f15261e[0] = iVar.f15302b;
            this.f15262f[0] = -1;
            iVar.f15311k++;
            iVar.a(cVar);
            this.f15257a++;
            if (this.f15266j) {
                return;
            }
            int i5 = this.f15265i + 1;
            this.f15265i = i5;
            int[] iArr = this.f15261e;
            if (i5 >= iArr.length) {
                this.f15266j = true;
                this.f15265i = iArr.length - 1;
                return;
            }
            return;
        }
        int i6 = -1;
        for (int i7 = 0; i4 != -1 && i7 < this.f15257a; i7++) {
            int i8 = this.f15261e[i4];
            int i9 = iVar.f15302b;
            if (i8 == i9) {
                this.f15263g[i4] = f4;
                return;
            }
            if (i8 < i9) {
                i6 = i4;
            }
            i4 = this.f15262f[i4];
        }
        int length = this.f15265i;
        int i10 = length + 1;
        if (this.f15266j) {
            int[] iArr2 = this.f15261e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i10;
        }
        int[] iArr3 = this.f15261e;
        if (length >= iArr3.length && this.f15257a < iArr3.length) {
            int i11 = 0;
            while (true) {
                int[] iArr4 = this.f15261e;
                if (i11 >= iArr4.length) {
                    break;
                }
                if (iArr4[i11] == -1) {
                    length = i11;
                    break;
                }
                i11++;
            }
        }
        int[] iArr5 = this.f15261e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i12 = this.f15260d * 2;
            this.f15260d = i12;
            this.f15266j = false;
            this.f15265i = length - 1;
            this.f15263g = Arrays.copyOf(this.f15263g, i12);
            this.f15261e = Arrays.copyOf(this.f15261e, this.f15260d);
            this.f15262f = Arrays.copyOf(this.f15262f, this.f15260d);
        }
        this.f15261e[length] = iVar.f15302b;
        this.f15263g[length] = f4;
        if (i6 != -1) {
            int[] iArr6 = this.f15262f;
            iArr6[length] = iArr6[i6];
            iArr6[i6] = length;
        } else {
            this.f15262f[length] = this.f15264h;
            this.f15264h = length;
        }
        iVar.f15311k++;
        iVar.a(cVar);
        int i13 = this.f15257a + 1;
        this.f15257a = i13;
        if (!this.f15266j) {
            this.f15265i++;
        }
        int[] iArr7 = this.f15261e;
        if (i13 >= iArr7.length) {
            this.f15266j = true;
        }
        if (this.f15265i >= iArr7.length) {
            this.f15266j = true;
            this.f15265i = iArr7.length - 1;
        }
    }

    @Override // t.b
    public final float e(i iVar) {
        int i4 = this.f15264h;
        for (int i5 = 0; i4 != -1 && i5 < this.f15257a; i5++) {
            if (this.f15261e[i4] == iVar.f15302b) {
                return this.f15263g[i4];
            }
            i4 = this.f15262f[i4];
        }
        return Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // t.b
    public final int f() {
        return this.f15257a;
    }

    @Override // t.b
    public final boolean g(i iVar) {
        int i4 = this.f15264h;
        if (i4 == -1) {
            return false;
        }
        for (int i5 = 0; i4 != -1 && i5 < this.f15257a; i5++) {
            if (this.f15261e[i4] == iVar.f15302b) {
                return true;
            }
            i4 = this.f15262f[i4];
        }
        return false;
    }

    @Override // t.b
    public final i h(int i4) {
        int i5 = this.f15264h;
        for (int i6 = 0; i5 != -1 && i6 < this.f15257a; i6++) {
            if (i6 == i4) {
                return ((i[]) this.f15259c.f15276d)[this.f15261e[i5]];
            }
            i5 = this.f15262f[i5];
        }
        return null;
    }

    @Override // t.b
    public final void i(float f4) {
        int i4 = this.f15264h;
        for (int i5 = 0; i4 != -1 && i5 < this.f15257a; i5++) {
            float[] fArr = this.f15263g;
            fArr[i4] = fArr[i4] / f4;
            i4 = this.f15262f[i4];
        }
    }

    @Override // t.b
    public final void j(i iVar, float f4, boolean z4) {
        if (f4 <= -0.001f || f4 >= 0.001f) {
            int i4 = this.f15264h;
            c cVar = this.f15258b;
            if (i4 == -1) {
                this.f15264h = 0;
                this.f15263g[0] = f4;
                this.f15261e[0] = iVar.f15302b;
                this.f15262f[0] = -1;
                iVar.f15311k++;
                iVar.a(cVar);
                this.f15257a++;
                if (this.f15266j) {
                    return;
                }
                int i5 = this.f15265i + 1;
                this.f15265i = i5;
                int[] iArr = this.f15261e;
                if (i5 >= iArr.length) {
                    this.f15266j = true;
                    this.f15265i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i6 = -1;
            for (int i7 = 0; i4 != -1 && i7 < this.f15257a; i7++) {
                int i8 = this.f15261e[i4];
                int i9 = iVar.f15302b;
                if (i8 == i9) {
                    float[] fArr = this.f15263g;
                    float f5 = fArr[i4] + f4;
                    if (f5 > -0.001f && f5 < 0.001f) {
                        f5 = 0.0f;
                    }
                    fArr[i4] = f5;
                    if (f5 == Property.DEFAULT_FLOAT_VALUE) {
                        if (i4 == this.f15264h) {
                            this.f15264h = this.f15262f[i4];
                        } else {
                            int[] iArr2 = this.f15262f;
                            iArr2[i6] = iArr2[i4];
                        }
                        if (z4) {
                            iVar.b(cVar);
                        }
                        if (this.f15266j) {
                            this.f15265i = i4;
                        }
                        iVar.f15311k--;
                        this.f15257a--;
                        return;
                    }
                    return;
                }
                if (i8 < i9) {
                    i6 = i4;
                }
                i4 = this.f15262f[i4];
            }
            int length = this.f15265i;
            int i10 = length + 1;
            if (this.f15266j) {
                int[] iArr3 = this.f15261e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i10;
            }
            int[] iArr4 = this.f15261e;
            if (length >= iArr4.length && this.f15257a < iArr4.length) {
                int i11 = 0;
                while (true) {
                    int[] iArr5 = this.f15261e;
                    if (i11 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i11] == -1) {
                        length = i11;
                        break;
                    }
                    i11++;
                }
            }
            int[] iArr6 = this.f15261e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i12 = this.f15260d * 2;
                this.f15260d = i12;
                this.f15266j = false;
                this.f15265i = length - 1;
                this.f15263g = Arrays.copyOf(this.f15263g, i12);
                this.f15261e = Arrays.copyOf(this.f15261e, this.f15260d);
                this.f15262f = Arrays.copyOf(this.f15262f, this.f15260d);
            }
            this.f15261e[length] = iVar.f15302b;
            this.f15263g[length] = f4;
            if (i6 != -1) {
                int[] iArr7 = this.f15262f;
                iArr7[length] = iArr7[i6];
                iArr7[i6] = length;
            } else {
                this.f15262f[length] = this.f15264h;
                this.f15264h = length;
            }
            iVar.f15311k++;
            iVar.a(cVar);
            this.f15257a++;
            if (!this.f15266j) {
                this.f15265i++;
            }
            int i13 = this.f15265i;
            int[] iArr8 = this.f15261e;
            if (i13 >= iArr8.length) {
                this.f15266j = true;
                this.f15265i = iArr8.length - 1;
            }
        }
    }

    @Override // t.b
    public final void k() {
        int i4 = this.f15264h;
        for (int i5 = 0; i4 != -1 && i5 < this.f15257a; i5++) {
            float[] fArr = this.f15263g;
            fArr[i4] = fArr[i4] * (-1.0f);
            i4 = this.f15262f[i4];
        }
    }

    public final String toString() {
        int i4 = this.f15264h;
        String string = "";
        for (int i5 = 0; i4 != -1 && i5 < this.f15257a; i5++) {
            StringBuilder sbS = B0.g.s(AbstractC0351g.p(string, " -> "));
            sbS.append(this.f15263g[i4]);
            sbS.append(" : ");
            StringBuilder sbS2 = B0.g.s(sbS.toString());
            sbS2.append(((i[]) this.f15259c.f15276d)[this.f15261e[i4]]);
            string = sbS2.toString();
            i4 = this.f15262f[i4];
        }
        return string;
    }
}
