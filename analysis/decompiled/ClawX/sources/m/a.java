package m;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public final b f3843b;

    /* renamed from: c, reason: collision with root package name */
    public final a4.d f3844c;

    /* renamed from: a, reason: collision with root package name */
    public int f3842a = 0;
    public int d = 8;

    /* renamed from: e, reason: collision with root package name */
    public int[] f3845e = new int[8];

    /* renamed from: f, reason: collision with root package name */
    public int[] f3846f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public float[] f3847g = new float[8];

    /* renamed from: h, reason: collision with root package name */
    public int f3848h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f3849i = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3850j = false;

    public a(b bVar, a4.d dVar) {
        this.f3843b = bVar;
        this.f3844c = dVar;
    }

    public final void a(g gVar, float f3, boolean z) {
        if (f3 <= -0.001f || f3 >= 0.001f) {
            int i8 = this.f3848h;
            b bVar = this.f3843b;
            if (i8 == -1) {
                this.f3848h = 0;
                this.f3847g[0] = f3;
                this.f3845e[0] = gVar.f3878b;
                this.f3846f[0] = -1;
                gVar.f3886l++;
                gVar.a(bVar);
                this.f3842a++;
                if (this.f3850j) {
                    return;
                }
                int i9 = this.f3849i + 1;
                this.f3849i = i9;
                int[] iArr = this.f3845e;
                if (i9 >= iArr.length) {
                    this.f3850j = true;
                    this.f3849i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i10 = -1;
            for (int i11 = 0; i8 != -1 && i11 < this.f3842a; i11++) {
                int i12 = this.f3845e[i8];
                int i13 = gVar.f3878b;
                if (i12 == i13) {
                    float[] fArr = this.f3847g;
                    float f7 = fArr[i8] + f3;
                    if (f7 > -0.001f && f7 < 0.001f) {
                        f7 = 0.0f;
                    }
                    fArr[i8] = f7;
                    if (f7 == 0.0f) {
                        if (i8 == this.f3848h) {
                            this.f3848h = this.f3846f[i8];
                        } else {
                            int[] iArr2 = this.f3846f;
                            iArr2[i10] = iArr2[i8];
                        }
                        if (z) {
                            gVar.b(bVar);
                        }
                        if (this.f3850j) {
                            this.f3849i = i8;
                        }
                        gVar.f3886l--;
                        this.f3842a--;
                        return;
                    }
                    return;
                }
                if (i12 < i13) {
                    i10 = i8;
                }
                i8 = this.f3846f[i8];
            }
            int length = this.f3849i;
            int i14 = length + 1;
            if (this.f3850j) {
                int[] iArr3 = this.f3845e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i14;
            }
            int[] iArr4 = this.f3845e;
            if (length >= iArr4.length && this.f3842a < iArr4.length) {
                int i15 = 0;
                while (true) {
                    int[] iArr5 = this.f3845e;
                    if (i15 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i15] == -1) {
                        length = i15;
                        break;
                    }
                    i15++;
                }
            }
            int[] iArr6 = this.f3845e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i16 = this.d * 2;
                this.d = i16;
                this.f3850j = false;
                this.f3849i = length - 1;
                this.f3847g = Arrays.copyOf(this.f3847g, i16);
                this.f3845e = Arrays.copyOf(this.f3845e, this.d);
                this.f3846f = Arrays.copyOf(this.f3846f, this.d);
            }
            this.f3845e[length] = gVar.f3878b;
            this.f3847g[length] = f3;
            if (i10 != -1) {
                int[] iArr7 = this.f3846f;
                iArr7[length] = iArr7[i10];
                iArr7[i10] = length;
            } else {
                this.f3846f[length] = this.f3848h;
                this.f3848h = length;
            }
            gVar.f3886l++;
            gVar.a(bVar);
            this.f3842a++;
            if (!this.f3850j) {
                this.f3849i++;
            }
            int i17 = this.f3849i;
            int[] iArr8 = this.f3845e;
            if (i17 >= iArr8.length) {
                this.f3850j = true;
                this.f3849i = iArr8.length - 1;
            }
        }
    }

    public final void b() {
        int i8 = this.f3848h;
        for (int i9 = 0; i8 != -1 && i9 < this.f3842a; i9++) {
            g gVar = ((g[]) this.f3844c.d)[this.f3845e[i8]];
            if (gVar != null) {
                gVar.b(this.f3843b);
            }
            i8 = this.f3846f[i8];
        }
        this.f3848h = -1;
        this.f3849i = -1;
        this.f3850j = false;
        this.f3842a = 0;
    }

    public final float c(g gVar) {
        int i8 = this.f3848h;
        for (int i9 = 0; i8 != -1 && i9 < this.f3842a; i9++) {
            if (this.f3845e[i8] == gVar.f3878b) {
                return this.f3847g[i8];
            }
            i8 = this.f3846f[i8];
        }
        return 0.0f;
    }

    public final int d() {
        return this.f3842a;
    }

    public final g e(int i8) {
        int i9 = this.f3848h;
        for (int i10 = 0; i9 != -1 && i10 < this.f3842a; i10++) {
            if (i10 == i8) {
                return ((g[]) this.f3844c.d)[this.f3845e[i9]];
            }
            i9 = this.f3846f[i9];
        }
        return null;
    }

    public final float f(int i8) {
        int i9 = this.f3848h;
        for (int i10 = 0; i9 != -1 && i10 < this.f3842a; i10++) {
            if (i10 == i8) {
                return this.f3847g[i9];
            }
            i9 = this.f3846f[i9];
        }
        return 0.0f;
    }

    public final void g(g gVar, float f3) {
        if (f3 == 0.0f) {
            h(gVar, true);
            return;
        }
        int i8 = this.f3848h;
        b bVar = this.f3843b;
        if (i8 == -1) {
            this.f3848h = 0;
            this.f3847g[0] = f3;
            this.f3845e[0] = gVar.f3878b;
            this.f3846f[0] = -1;
            gVar.f3886l++;
            gVar.a(bVar);
            this.f3842a++;
            if (this.f3850j) {
                return;
            }
            int i9 = this.f3849i + 1;
            this.f3849i = i9;
            int[] iArr = this.f3845e;
            if (i9 >= iArr.length) {
                this.f3850j = true;
                this.f3849i = iArr.length - 1;
                return;
            }
            return;
        }
        int i10 = -1;
        for (int i11 = 0; i8 != -1 && i11 < this.f3842a; i11++) {
            int i12 = this.f3845e[i8];
            int i13 = gVar.f3878b;
            if (i12 == i13) {
                this.f3847g[i8] = f3;
                return;
            }
            if (i12 < i13) {
                i10 = i8;
            }
            i8 = this.f3846f[i8];
        }
        int length = this.f3849i;
        int i14 = length + 1;
        if (this.f3850j) {
            int[] iArr2 = this.f3845e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i14;
        }
        int[] iArr3 = this.f3845e;
        if (length >= iArr3.length && this.f3842a < iArr3.length) {
            int i15 = 0;
            while (true) {
                int[] iArr4 = this.f3845e;
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
        int[] iArr5 = this.f3845e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i16 = this.d * 2;
            this.d = i16;
            this.f3850j = false;
            this.f3849i = length - 1;
            this.f3847g = Arrays.copyOf(this.f3847g, i16);
            this.f3845e = Arrays.copyOf(this.f3845e, this.d);
            this.f3846f = Arrays.copyOf(this.f3846f, this.d);
        }
        this.f3845e[length] = gVar.f3878b;
        this.f3847g[length] = f3;
        if (i10 != -1) {
            int[] iArr6 = this.f3846f;
            iArr6[length] = iArr6[i10];
            iArr6[i10] = length;
        } else {
            this.f3846f[length] = this.f3848h;
            this.f3848h = length;
        }
        gVar.f3886l++;
        gVar.a(bVar);
        int i17 = this.f3842a + 1;
        this.f3842a = i17;
        if (!this.f3850j) {
            this.f3849i++;
        }
        int[] iArr7 = this.f3845e;
        if (i17 >= iArr7.length) {
            this.f3850j = true;
        }
        if (this.f3849i >= iArr7.length) {
            this.f3850j = true;
            this.f3849i = iArr7.length - 1;
        }
    }

    public final float h(g gVar, boolean z) {
        int i8 = this.f3848h;
        if (i8 == -1) {
            return 0.0f;
        }
        int i9 = 0;
        int i10 = -1;
        while (i8 != -1 && i9 < this.f3842a) {
            if (this.f3845e[i8] == gVar.f3878b) {
                if (i8 == this.f3848h) {
                    this.f3848h = this.f3846f[i8];
                } else {
                    int[] iArr = this.f3846f;
                    iArr[i10] = iArr[i8];
                }
                if (z) {
                    gVar.b(this.f3843b);
                }
                gVar.f3886l--;
                this.f3842a--;
                this.f3845e[i8] = -1;
                if (this.f3850j) {
                    this.f3849i = i8;
                }
                return this.f3847g[i8];
            }
            i9++;
            i10 = i8;
            i8 = this.f3846f[i8];
        }
        return 0.0f;
    }

    public final String toString() {
        int i8 = this.f3848h;
        String str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        for (int i9 = 0; i8 != -1 && i9 < this.f3842a; i9++) {
            str = (a8.b.n(str, " -> ") + this.f3847g[i8] + " : ") + ((g[]) this.f3844c.d)[this.f3845e[i8]];
            i8 = this.f3846f[i8];
        }
        return str;
    }
}
