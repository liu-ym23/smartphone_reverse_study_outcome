package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements f, h {

    /* renamed from: a, reason: collision with root package name */
    public final float f14973a;

    /* renamed from: b, reason: collision with root package name */
    public final yb.l f14974b;

    /* renamed from: c, reason: collision with root package name */
    public final float f14975c;

    /* JADX WARN: Multi-variable type inference failed */
    public g(float f5, xb.p pVar) {
        this.f14973a = f5;
        this.f14974b = (yb.l) pVar;
        this.f14975c = f5;
    }

    @Override // w.f, w.h
    public final float a() {
        return this.f14975c;
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [xb.p, yb.l] */
    @Override // w.f
    public final void b(o2.c cVar, int i, int[] iArr, o2.l lVar, int[] iArr2) {
        int i3;
        int iMin;
        if (iArr.length == 0) {
            return;
        }
        int iE0 = cVar.e0(this.f14973a);
        boolean z10 = lVar == o2.l.f9124f;
        e eVar = k.f14990a;
        if (z10) {
            i3 = 0;
            iMin = 0;
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i10 = iArr[length];
                int iMin2 = Math.min(i3, i - i10);
                iArr2[length] = iMin2;
                iMin = Math.min(iE0, (i - iMin2) - i10);
                i3 = iArr2[length] + i10 + iMin;
            }
        } else {
            int length2 = iArr.length;
            int i11 = 0;
            i3 = 0;
            iMin = 0;
            int i12 = 0;
            while (i11 < length2) {
                int i13 = iArr[i11];
                int iMin3 = Math.min(i3, i - i13);
                iArr2[i12] = iMin3;
                int iMin4 = Math.min(iE0, (i - iMin3) - i13);
                int i14 = iArr2[i12] + i13 + iMin4;
                i11++;
                iMin = iMin4;
                i3 = i14;
                i12++;
            }
        }
        int i15 = i3 - iMin;
        if (i15 < i) {
            int iIntValue = ((Number) this.f14974b.invoke(Integer.valueOf(i - i15), lVar)).intValue();
            int length3 = iArr2.length;
            for (int i16 = 0; i16 < length3; i16++) {
                iArr2[i16] = iArr2[i16] + iIntValue;
            }
        }
    }

    @Override // w.h
    public final void c(int i, s1.h0 h0Var, int[] iArr, int[] iArr2) {
        b(h0Var, i, iArr, o2.l.f9123c, iArr2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return o2.f.b(this.f14973a, gVar.f14973a) && this.f14974b.equals(gVar.f14974b);
    }

    public final int hashCode() {
        return this.f14974b.hashCode() + k0.a.h(Float.hashCode(this.f14973a) * 31, 31, true);
    }

    public final String toString() {
        StringBuilder sbV = k0.a.v("", "Arrangement#spacedAligned(");
        sbV.append((Object) o2.f.c(this.f14973a));
        sbV.append(", ");
        sbV.append(this.f14974b);
        sbV.append(')');
        return sbV.toString();
    }
}
