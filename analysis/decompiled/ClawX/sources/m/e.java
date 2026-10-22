package m;

import androidx.emoji2.text.p;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: f, reason: collision with root package name */
    public g[] f3872f;

    /* renamed from: g, reason: collision with root package name */
    public g[] f3873g;

    /* renamed from: h, reason: collision with root package name */
    public int f3874h;

    /* renamed from: i, reason: collision with root package name */
    public p f3875i;

    @Override // m.b
    public final g d(boolean[] zArr) {
        int i8 = -1;
        for (int i9 = 0; i9 < this.f3874h; i9++) {
            g[] gVarArr = this.f3872f;
            g gVar = gVarArr[i9];
            if (!zArr[gVar.f3878b]) {
                p pVar = this.f3875i;
                pVar.f623b = gVar;
                int i10 = 8;
                if (i8 == -1) {
                    while (i10 >= 0) {
                        float f3 = ((g) pVar.f623b).f3883h[i10];
                        if (f3 <= 0.0f) {
                            if (f3 < 0.0f) {
                                i8 = i9;
                                break;
                            }
                            i10--;
                        }
                    }
                } else {
                    g gVar2 = gVarArr[i8];
                    while (true) {
                        if (i10 >= 0) {
                            float f7 = gVar2.f3883h[i10];
                            float f9 = ((g) pVar.f623b).f3883h[i10];
                            if (f9 == f7) {
                                i10--;
                            } else if (f9 < f7) {
                            }
                        }
                    }
                }
            }
        }
        if (i8 == -1) {
            return null;
        }
        return this.f3872f[i8];
    }

    @Override // m.b
    public final boolean e() {
        return this.f3874h == 0;
    }

    @Override // m.b
    public final void i(c cVar, b bVar, boolean z) {
        g gVar = bVar.f3851a;
        if (gVar == null) {
            return;
        }
        float[] fArr = gVar.f3883h;
        a aVar = bVar.d;
        int iD = aVar.d();
        for (int i8 = 0; i8 < iD; i8++) {
            g gVarE = aVar.e(i8);
            float f3 = aVar.f(i8);
            p pVar = this.f3875i;
            pVar.f623b = gVarE;
            if (gVarE.f3877a) {
                boolean z2 = true;
                for (int i9 = 0; i9 < 9; i9++) {
                    float[] fArr2 = ((g) pVar.f623b).f3883h;
                    float f7 = (fArr[i9] * f3) + fArr2[i9];
                    fArr2[i9] = f7;
                    if (Math.abs(f7) < 1.0E-4f) {
                        ((g) pVar.f623b).f3883h[i9] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    ((e) pVar.f624c).k((g) pVar.f623b);
                }
            } else {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f9 = fArr[i10];
                    if (f9 != 0.0f) {
                        float f10 = f9 * f3;
                        if (Math.abs(f10) < 1.0E-4f) {
                            f10 = 0.0f;
                        }
                        ((g) pVar.f623b).f3883h[i10] = f10;
                    } else {
                        ((g) pVar.f623b).f3883h[i10] = 0.0f;
                    }
                }
                j(gVarE);
            }
            this.f3852b = (bVar.f3852b * f3) + this.f3852b;
        }
        k(gVar);
    }

    public final void j(g gVar) {
        int i8;
        int i9 = this.f3874h + 1;
        g[] gVarArr = this.f3872f;
        if (i9 > gVarArr.length) {
            g[] gVarArr2 = (g[]) Arrays.copyOf(gVarArr, gVarArr.length * 2);
            this.f3872f = gVarArr2;
            this.f3873g = (g[]) Arrays.copyOf(gVarArr2, gVarArr2.length * 2);
        }
        g[] gVarArr3 = this.f3872f;
        int i10 = this.f3874h;
        gVarArr3[i10] = gVar;
        int i11 = i10 + 1;
        this.f3874h = i11;
        if (i11 > 1 && gVarArr3[i10].f3878b > gVar.f3878b) {
            int i12 = 0;
            while (true) {
                i8 = this.f3874h;
                if (i12 >= i8) {
                    break;
                }
                this.f3873g[i12] = this.f3872f[i12];
                i12++;
            }
            Arrays.sort(this.f3873g, 0, i8, new d(0));
            for (int i13 = 0; i13 < this.f3874h; i13++) {
                this.f3872f[i13] = this.f3873g[i13];
            }
        }
        gVar.f3877a = true;
        gVar.a(this);
    }

    public final void k(g gVar) {
        int i8 = 0;
        while (i8 < this.f3874h) {
            if (this.f3872f[i8] == gVar) {
                while (true) {
                    int i9 = this.f3874h;
                    if (i8 >= i9 - 1) {
                        this.f3874h = i9 - 1;
                        gVar.f3877a = false;
                        return;
                    } else {
                        g[] gVarArr = this.f3872f;
                        int i10 = i8 + 1;
                        gVarArr[i8] = gVarArr[i10];
                        i8 = i10;
                    }
                }
            } else {
                i8++;
            }
        }
    }

    @Override // m.b
    public final String toString() {
        p pVar = this.f3875i;
        String str = " goal -> (" + this.f3852b + ") : ";
        for (int i8 = 0; i8 < this.f3874h; i8++) {
            pVar.f623b = this.f3872f[i8];
            str = str + pVar + " ";
        }
        return str;
    }
}
