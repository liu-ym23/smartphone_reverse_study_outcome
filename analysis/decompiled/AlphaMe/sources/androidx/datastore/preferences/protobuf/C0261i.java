package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0261i extends AbstractC0259h {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f3483d;

    public C0261i(byte[] bArr) {
        this.f3482a = 0;
        bArr.getClass();
        this.f3483d = bArr;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0259h
    public byte a(int i4) {
        return this.f3483d[i4];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0259h) || size() != ((AbstractC0259h) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof C0261i)) {
            return obj.equals(this);
        }
        C0261i c0261i = (C0261i) obj;
        int i4 = this.f3482a;
        int i5 = c0261i.f3482a;
        if (i4 != 0 && i5 != 0 && i4 != i5) {
            return false;
        }
        int size = size();
        if (size > c0261i.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > c0261i.size()) {
            StringBuilder sbT = B0.g.t("Ran off end of other: 0, ", size, ", ");
            sbT.append(c0261i.size());
            throw new IllegalArgumentException(sbT.toString());
        }
        int iH = h() + size;
        int iH2 = h();
        int iH3 = c0261i.h();
        while (iH2 < iH) {
            if (this.f3483d[iH2] != c0261i.f3483d[iH3]) {
                return false;
            }
            iH2++;
            iH3++;
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0259h
    public byte f(int i4) {
        return this.f3483d[i4];
    }

    public int h() {
        return 0;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0259h
    public int size() {
        return this.f3483d.length;
    }
}
