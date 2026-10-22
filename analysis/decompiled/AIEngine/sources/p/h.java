package p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public long[] f11372a;

    /* renamed from: b, reason: collision with root package name */
    public int f11373b;

    public h(int i10) {
        this.f11372a = i10 == 0 ? d.f11359a : new long[i10];
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            int i10 = hVar.f11373b;
            int i11 = this.f11373b;
            if (i10 == i11) {
                long[] jArr = this.f11372a;
                long[] jArr2 = hVar.f11372a;
                dc.e eVarE0 = dc.h.e0(0, i11);
                int i12 = eVarE0.f8451a;
                int i13 = eVarE0.f8452b;
                if (i12 > i13) {
                    return true;
                }
                while (jArr[i12] == jArr2[i12]) {
                    if (i12 == i13) {
                        return true;
                    }
                    i12++;
                }
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        long[] jArr = this.f11372a;
        int i10 = this.f11373b;
        int iHashCode = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode += Long.hashCode(jArr[i11]) * 31;
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "[");
        long[] jArr = this.f11372a;
        int i10 = this.f11373b;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                sb2.append((CharSequence) "]");
                break;
            }
            long j10 = jArr[i11];
            if (i11 == -1) {
                sb2.append((CharSequence) "...");
                break;
            }
            if (i11 != 0) {
                sb2.append((CharSequence) ", ");
            }
            sb2.append(j10);
            i11++;
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }
}
