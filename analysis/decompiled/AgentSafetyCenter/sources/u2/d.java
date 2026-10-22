package u2;

import a9.n;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: f, reason: collision with root package name */
    public e[] f14011f;

    /* renamed from: g, reason: collision with root package name */
    public e[] f14012g;

    /* renamed from: h, reason: collision with root package name */
    public int f14013h;
    public p5.e i;

    @Override // u2.b
    public final e d(boolean[] zArr) {
        int i = -1;
        for (int i3 = 0; i3 < this.f14013h; i3++) {
            e[] eVarArr = this.f14011f;
            e eVar = eVarArr[i3];
            if (!zArr[eVar.f14015f]) {
                p5.e eVar2 = this.i;
                eVar2.f9722f = eVar;
                int i10 = 8;
                if (i == -1) {
                    while (i10 >= 0) {
                        float f5 = ((e) eVar2.f9722f).f14020l[i10];
                        if (f5 <= 0.0f) {
                            if (f5 < 0.0f) {
                                i = i3;
                                break;
                            }
                            i10--;
                        }
                    }
                } else {
                    e eVar3 = eVarArr[i];
                    while (true) {
                        if (i10 >= 0) {
                            float f10 = eVar3.f14020l[i10];
                            float f11 = ((e) eVar2.f9722f).f14020l[i10];
                            if (f11 == f10) {
                                i10--;
                            } else if (f11 < f10) {
                            }
                        }
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f14011f[i];
    }

    @Override // u2.b
    public final boolean e() {
        return this.f14013h == 0;
    }

    @Override // u2.b
    public final void i(c cVar, b bVar, boolean z10) {
        e eVar = bVar.f13990a;
        if (eVar == null) {
            return;
        }
        float[] fArr = eVar.f14020l;
        a aVar = bVar.f13993d;
        int iD = aVar.d();
        for (int i = 0; i < iD; i++) {
            e eVarE = aVar.e(i);
            float f5 = aVar.f(i);
            p5.e eVar2 = this.i;
            eVar2.f9722f = eVarE;
            if (eVarE.f14014c) {
                boolean z11 = true;
                for (int i3 = 0; i3 < 9; i3++) {
                    float[] fArr2 = ((e) eVar2.f9722f).f14020l;
                    float f10 = (fArr[i3] * f5) + fArr2[i3];
                    fArr2[i3] = f10;
                    if (Math.abs(f10) < 1.0E-4f) {
                        ((e) eVar2.f9722f).f14020l[i3] = 0.0f;
                    } else {
                        z11 = false;
                    }
                }
                if (z11) {
                    ((d) eVar2.f9723g).k((e) eVar2.f9722f);
                }
            } else {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f11 = fArr[i10];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f5;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        ((e) eVar2.f9722f).f14020l[i10] = f12;
                    } else {
                        ((e) eVar2.f9722f).f14020l[i10] = 0.0f;
                    }
                }
                j(eVarE);
            }
            this.f13991b = (bVar.f13991b * f5) + this.f13991b;
        }
        k(eVar);
    }

    public final void j(e eVar) {
        int i;
        e[] eVarArr;
        int i3 = this.f14013h + 1;
        e[] eVarArr2 = this.f14011f;
        if (i3 > eVarArr2.length) {
            e[] eVarArr3 = (e[]) Arrays.copyOf(eVarArr2, eVarArr2.length * 2);
            this.f14011f = eVarArr3;
            this.f14012g = (e[]) Arrays.copyOf(eVarArr3, eVarArr3.length * 2);
        }
        e[] eVarArr4 = this.f14011f;
        int i10 = this.f14013h;
        eVarArr4[i10] = eVar;
        int i11 = i10 + 1;
        this.f14013h = i11;
        if (i11 > 1 && eVarArr4[i10].f14015f > eVar.f14015f) {
            int i12 = 0;
            while (true) {
                i = this.f14013h;
                eVarArr = this.f14012g;
                if (i12 >= i) {
                    break;
                }
                eVarArr[i12] = this.f14011f[i12];
                i12++;
            }
            Arrays.sort(eVarArr, 0, i, new n(10));
            for (int i13 = 0; i13 < this.f14013h; i13++) {
                this.f14011f[i13] = this.f14012g[i13];
            }
        }
        eVar.f14014c = true;
        eVar.a(this);
    }

    public final void k(e eVar) {
        int i = 0;
        while (i < this.f14013h) {
            if (this.f14011f[i] == eVar) {
                while (true) {
                    int i3 = this.f14013h;
                    if (i >= i3 - 1) {
                        this.f14013h = i3 - 1;
                        eVar.f14014c = false;
                        return;
                    } else {
                        e[] eVarArr = this.f14011f;
                        int i10 = i + 1;
                        eVarArr[i] = eVarArr[i10];
                        i = i10;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // u2.b
    public final String toString() {
        p5.e eVar = this.i;
        String str = " goal -> (" + this.f13991b + ") : ";
        for (int i = 0; i < this.f14013h; i++) {
            eVar.f9722f = this.f14011f[i];
            str = str + eVar + " ";
        }
        return str;
    }
}
