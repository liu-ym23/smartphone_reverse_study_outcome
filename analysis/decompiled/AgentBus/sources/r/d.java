package r;

/* loaded from: classes.dex */
public final class d implements c, g {

    /* renamed from: a, reason: collision with root package name */
    public final float f8854a;

    /* renamed from: b, reason: collision with root package name */
    public final float f8855b;

    public d(float f10) {
        this.f8854a = f10;
        this.f8855b = f10;
    }

    @Override // r.c, r.g
    public final float a() {
        return this.f8855b;
    }

    @Override // r.c
    public final void b(i1.m0 m0Var, int i2, int[] iArr, d2.l lVar, int[] iArr2) {
        int i10;
        int iMin;
        if (iArr.length == 0) {
            return;
        }
        int iY = m0Var.y(this.f8854a);
        boolean z4 = lVar == d2.l.f2794g;
        e eVar = i.f8866a;
        if (z4) {
            i10 = 0;
            iMin = 0;
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i11 = iArr[length];
                int iMin2 = Math.min(i10, i2 - i11);
                iArr2[length] = iMin2;
                iMin = Math.min(iY, (i2 - iMin2) - i11);
                i10 = iArr2[length] + i11 + iMin;
            }
        } else {
            int length2 = iArr.length;
            int i12 = 0;
            i10 = 0;
            iMin = 0;
            int i13 = 0;
            while (i12 < length2) {
                int i14 = iArr[i12];
                int iMin3 = Math.min(i10, i2 - i14);
                iArr2[i13] = iMin3;
                int iMin4 = Math.min(iY, (i2 - iMin3) - i14);
                int i15 = iArr2[i13] + i14 + iMin4;
                i12++;
                iMin = iMin4;
                i10 = i15;
                i13++;
            }
        }
        if (i10 - iMin < i2) {
            int iRound = Math.round((1 + (lVar != d2.l.f2793f ? (-1.0f) * (-1) : -1.0f)) * ((i2 - r4) / 2.0f));
            int length3 = iArr2.length;
            for (int i16 = 0; i16 < length3; i16++) {
                iArr2[i16] = iArr2[i16] + iRound;
            }
        }
    }

    @Override // r.g
    public final void c(int i2, i1.m0 m0Var, int[] iArr, int[] iArr2) {
        b(m0Var, i2, iArr, d2.l.f2793f, iArr2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d) || !d2.f.a(this.f8854a, ((d) obj).f8854a)) {
            return false;
        }
        Object obj2 = h.f8861g;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        return h.f8861g.hashCode() + m.x.e(Float.hashCode(this.f8854a) * 31, 31, true);
    }

    public final String toString() {
        return "Arrangement#spacedAligned(" + ((Object) d2.f.b(this.f8854a)) + ", " + h.f8861g + ')';
    }
}
