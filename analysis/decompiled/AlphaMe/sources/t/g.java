package t;

import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.Property;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class g extends c {

    /* renamed from: f, reason: collision with root package name */
    public i[] f15297f;

    /* renamed from: g, reason: collision with root package name */
    public int f15298g;

    /* renamed from: h, reason: collision with root package name */
    public android.support.v4.media.session.c f15299h;

    @Override // t.c
    public final i d(boolean[] zArr) {
        int i4 = -1;
        for (int i5 = 0; i5 < this.f15298g; i5++) {
            i[] iVarArr = this.f15297f;
            i iVar = iVarArr[i5];
            if (!zArr[iVar.f15302b]) {
                android.support.v4.media.session.c cVar = this.f15299h;
                cVar.f2364b = iVar;
                int i6 = 8;
                if (i4 == -1) {
                    while (i6 >= 0) {
                        float f4 = ((i) cVar.f2364b).f15308h[i6];
                        if (f4 <= Property.DEFAULT_FLOAT_VALUE) {
                            if (f4 < Property.DEFAULT_FLOAT_VALUE) {
                                i4 = i5;
                                break;
                            }
                            i6--;
                        }
                    }
                } else {
                    i iVar2 = iVarArr[i4];
                    while (true) {
                        if (i6 >= 0) {
                            float f5 = iVar2.f15308h[i6];
                            float f6 = ((i) cVar.f2364b).f15308h[i6];
                            if (f6 == f5) {
                                i6--;
                            } else if (f6 < f5) {
                            }
                        }
                    }
                }
            }
        }
        if (i4 == -1) {
            return null;
        }
        return this.f15297f[i4];
    }

    @Override // t.c
    public final boolean e() {
        return this.f15298g == 0;
    }

    @Override // t.c
    public final void i(e eVar, c cVar, boolean z4) {
        i iVar = cVar.f15267a;
        if (iVar == null) {
            return;
        }
        b bVar = cVar.f15270d;
        int iF = bVar.f();
        for (int i4 = 0; i4 < iF; i4++) {
            i iVarH = bVar.h(i4);
            float fA = bVar.a(i4);
            android.support.v4.media.session.c cVar2 = this.f15299h;
            cVar2.f2364b = iVarH;
            boolean z5 = iVarH.f15301a;
            float[] fArr = iVar.f15308h;
            if (z5) {
                boolean z6 = true;
                for (int i5 = 0; i5 < 9; i5++) {
                    float[] fArr2 = ((i) cVar2.f2364b).f15308h;
                    float f4 = (fArr[i5] * fA) + fArr2[i5];
                    fArr2[i5] = f4;
                    if (Math.abs(f4) < 1.0E-4f) {
                        ((i) cVar2.f2364b).f15308h[i5] = 0.0f;
                    } else {
                        z6 = false;
                    }
                }
                if (z6) {
                    ((g) cVar2.f2366d).k((i) cVar2.f2364b);
                }
            } else {
                for (int i6 = 0; i6 < 9; i6++) {
                    float f5 = fArr[i6];
                    if (f5 != Property.DEFAULT_FLOAT_VALUE) {
                        float f6 = f5 * fA;
                        if (Math.abs(f6) < 1.0E-4f) {
                            f6 = 0.0f;
                        }
                        ((i) cVar2.f2364b).f15308h[i6] = f6;
                    } else {
                        ((i) cVar2.f2364b).f15308h[i6] = 0.0f;
                    }
                }
                j(iVarH);
            }
            this.f15268b = (cVar.f15268b * fA) + this.f15268b;
        }
        k(iVar);
    }

    public final void j(i iVar) {
        int i4 = this.f15298g + 1;
        i[] iVarArr = this.f15297f;
        if (i4 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f15297f = iVarArr2;
        }
        i[] iVarArr3 = this.f15297f;
        int i5 = this.f15298g;
        iVarArr3[i5] = iVar;
        int i6 = i5 + 1;
        this.f15298g = i6;
        if (i6 > 1) {
            int i7 = iVar.f15302b;
        }
        iVar.f15301a = true;
        iVar.a(this);
    }

    public final void k(i iVar) {
        int i4 = 0;
        while (i4 < this.f15298g) {
            if (this.f15297f[i4] == iVar) {
                while (true) {
                    int i5 = this.f15298g;
                    if (i4 >= i5 - 1) {
                        this.f15298g = i5 - 1;
                        iVar.f15301a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f15297f;
                        int i6 = i4 + 1;
                        iVarArr[i4] = iVarArr[i6];
                        i4 = i6;
                    }
                }
            } else {
                i4++;
            }
        }
    }

    @Override // t.c
    public final String toString() {
        String str = " goal -> (" + this.f15268b + ") : ";
        for (int i4 = 0; i4 < this.f15298g; i4++) {
            i iVar = this.f15297f[i4];
            android.support.v4.media.session.c cVar = this.f15299h;
            cVar.f2364b = iVar;
            str = str + cVar + AwarenessDataItem.PERMISSION_SPLITTER;
        }
        return str;
    }
}
