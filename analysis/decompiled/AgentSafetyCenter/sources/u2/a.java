package u2;

import java.util.Arrays;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f13981a;

    /* renamed from: b, reason: collision with root package name */
    public b f13982b;

    /* renamed from: c, reason: collision with root package name */
    public m f13983c;

    /* renamed from: d, reason: collision with root package name */
    public int f13984d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f13985e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f13986f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f13987g;

    /* renamed from: h, reason: collision with root package name */
    public int f13988h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13989j;

    public final void a(e eVar, float f5, boolean z10) {
        b bVar = this.f13982b;
        if (f5 <= -0.001f || f5 >= 0.001f) {
            int i = this.f13988h;
            if (i == -1) {
                this.f13988h = 0;
                this.f13987g[0] = f5;
                this.f13985e[0] = eVar.f14015f;
                this.f13986f[0] = -1;
                eVar.f14023o++;
                eVar.a(bVar);
                this.f13981a++;
                if (this.f13989j) {
                    return;
                }
                int i3 = this.i + 1;
                this.i = i3;
                int[] iArr = this.f13985e;
                if (i3 >= iArr.length) {
                    this.f13989j = true;
                    this.i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i10 = -1;
            for (int i11 = 0; i != -1 && i11 < this.f13981a; i11++) {
                int i12 = this.f13985e[i];
                int i13 = eVar.f14015f;
                if (i12 == i13) {
                    float[] fArr = this.f13987g;
                    float f10 = fArr[i] + f5;
                    if (f10 > -0.001f && f10 < 0.001f) {
                        f10 = 0.0f;
                    }
                    fArr[i] = f10;
                    if (f10 == 0.0f) {
                        int i14 = this.f13988h;
                        int[] iArr2 = this.f13986f;
                        if (i == i14) {
                            this.f13988h = iArr2[i];
                        } else {
                            iArr2[i10] = iArr2[i];
                        }
                        if (z10) {
                            eVar.b(bVar);
                        }
                        if (this.f13989j) {
                            this.i = i;
                        }
                        eVar.f14023o--;
                        this.f13981a--;
                        return;
                    }
                    return;
                }
                if (i12 < i13) {
                    i10 = i;
                }
                i = this.f13986f[i];
            }
            int length = this.i;
            int i15 = length + 1;
            if (this.f13989j) {
                int[] iArr3 = this.f13985e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i15;
            }
            int[] iArr4 = this.f13985e;
            if (length >= iArr4.length && this.f13981a < iArr4.length) {
                int i16 = 0;
                while (true) {
                    int[] iArr5 = this.f13985e;
                    if (i16 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i16] == -1) {
                        length = i16;
                        break;
                    }
                    i16++;
                }
            }
            int[] iArr6 = this.f13985e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i17 = this.f13984d * 2;
                this.f13984d = i17;
                this.f13989j = false;
                this.i = length - 1;
                this.f13987g = Arrays.copyOf(this.f13987g, i17);
                this.f13985e = Arrays.copyOf(this.f13985e, this.f13984d);
                this.f13986f = Arrays.copyOf(this.f13986f, this.f13984d);
            }
            this.f13985e[length] = eVar.f14015f;
            this.f13987g[length] = f5;
            int[] iArr7 = this.f13986f;
            if (i10 != -1) {
                iArr7[length] = iArr7[i10];
                iArr7[i10] = length;
            } else {
                iArr7[length] = this.f13988h;
                this.f13988h = length;
            }
            eVar.f14023o++;
            eVar.a(bVar);
            this.f13981a++;
            if (!this.f13989j) {
                this.i++;
            }
            int i18 = this.i;
            int[] iArr8 = this.f13985e;
            if (i18 >= iArr8.length) {
                this.f13989j = true;
                this.i = iArr8.length - 1;
            }
        }
    }

    public final void b() {
        int i = this.f13988h;
        for (int i3 = 0; i != -1 && i3 < this.f13981a; i3++) {
            e eVar = ((e[]) this.f13983c.f9743h)[this.f13985e[i]];
            if (eVar != null) {
                eVar.b(this.f13982b);
            }
            i = this.f13986f[i];
        }
        this.f13988h = -1;
        this.i = -1;
        this.f13989j = false;
        this.f13981a = 0;
    }

    public final float c(e eVar) {
        int i = this.f13988h;
        for (int i3 = 0; i != -1 && i3 < this.f13981a; i3++) {
            if (this.f13985e[i] == eVar.f14015f) {
                return this.f13987g[i];
            }
            i = this.f13986f[i];
        }
        return 0.0f;
    }

    public final int d() {
        return this.f13981a;
    }

    public final e e(int i) {
        int i3 = this.f13988h;
        for (int i10 = 0; i3 != -1 && i10 < this.f13981a; i10++) {
            if (i10 == i) {
                return ((e[]) this.f13983c.f9743h)[this.f13985e[i3]];
            }
            i3 = this.f13986f[i3];
        }
        return null;
    }

    public final float f(int i) {
        int i3 = this.f13988h;
        for (int i10 = 0; i3 != -1 && i10 < this.f13981a; i10++) {
            if (i10 == i) {
                return this.f13987g[i3];
            }
            i3 = this.f13986f[i3];
        }
        return 0.0f;
    }

    public final void g(e eVar, float f5) {
        b bVar = this.f13982b;
        if (f5 == 0.0f) {
            h(eVar, true);
            return;
        }
        int i = this.f13988h;
        if (i == -1) {
            this.f13988h = 0;
            this.f13987g[0] = f5;
            this.f13985e[0] = eVar.f14015f;
            this.f13986f[0] = -1;
            eVar.f14023o++;
            eVar.a(bVar);
            this.f13981a++;
            if (this.f13989j) {
                return;
            }
            int i3 = this.i + 1;
            this.i = i3;
            int[] iArr = this.f13985e;
            if (i3 >= iArr.length) {
                this.f13989j = true;
                this.i = iArr.length - 1;
                return;
            }
            return;
        }
        int i10 = -1;
        for (int i11 = 0; i != -1 && i11 < this.f13981a; i11++) {
            int i12 = this.f13985e[i];
            int i13 = eVar.f14015f;
            if (i12 == i13) {
                this.f13987g[i] = f5;
                return;
            }
            if (i12 < i13) {
                i10 = i;
            }
            i = this.f13986f[i];
        }
        int length = this.i;
        int i14 = length + 1;
        if (this.f13989j) {
            int[] iArr2 = this.f13985e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i14;
        }
        int[] iArr3 = this.f13985e;
        if (length >= iArr3.length && this.f13981a < iArr3.length) {
            int i15 = 0;
            while (true) {
                int[] iArr4 = this.f13985e;
                if (i15 >= iArr4.length) {
                    break;
                }
                if (iArr4[i15] == -1) {
                    length = i15;
                    break;
                }
                i15++;
            }
        }
        int[] iArr5 = this.f13985e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i16 = this.f13984d * 2;
            this.f13984d = i16;
            this.f13989j = false;
            this.i = length - 1;
            this.f13987g = Arrays.copyOf(this.f13987g, i16);
            this.f13985e = Arrays.copyOf(this.f13985e, this.f13984d);
            this.f13986f = Arrays.copyOf(this.f13986f, this.f13984d);
        }
        this.f13985e[length] = eVar.f14015f;
        this.f13987g[length] = f5;
        int[] iArr6 = this.f13986f;
        if (i10 != -1) {
            iArr6[length] = iArr6[i10];
            iArr6[i10] = length;
        } else {
            iArr6[length] = this.f13988h;
            this.f13988h = length;
        }
        eVar.f14023o++;
        eVar.a(bVar);
        int i17 = this.f13981a + 1;
        this.f13981a = i17;
        if (!this.f13989j) {
            this.i++;
        }
        int[] iArr7 = this.f13985e;
        if (i17 >= iArr7.length) {
            this.f13989j = true;
        }
        if (this.i >= iArr7.length) {
            this.f13989j = true;
            this.i = iArr7.length - 1;
        }
    }

    public final float h(e eVar, boolean z10) {
        int i = this.f13988h;
        if (i == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i10 = -1;
        while (i != -1 && i3 < this.f13981a) {
            if (this.f13985e[i] == eVar.f14015f) {
                int i11 = this.f13988h;
                int[] iArr = this.f13986f;
                if (i == i11) {
                    this.f13988h = iArr[i];
                } else {
                    iArr[i10] = iArr[i];
                }
                if (z10) {
                    eVar.b(this.f13982b);
                }
                eVar.f14023o--;
                this.f13981a--;
                this.f13985e[i] = -1;
                if (this.f13989j) {
                    this.i = i;
                }
                return this.f13987g[i];
            }
            i3++;
            i10 = i;
            i = this.f13986f[i];
        }
        return 0.0f;
    }

    public final String toString() {
        int i = this.f13988h;
        String string = "";
        for (int i3 = 0; i != -1 && i3 < this.f13981a; i3++) {
            StringBuilder sbC = w2.c.c(string.concat(" -> "));
            sbC.append(this.f13987g[i]);
            sbC.append(" : ");
            StringBuilder sbC2 = w2.c.c(sbC.toString());
            sbC2.append(((e[]) this.f13983c.f9743h)[this.f13985e[i]]);
            string = sbC2.toString();
            i = this.f13986f[i];
        }
        return string;
    }
}
