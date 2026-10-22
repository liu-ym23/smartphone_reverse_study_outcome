package com.google.protobuf;

import java.util.Iterator;

/* loaded from: classes.dex */
public class k extends l {

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f2418i;

    public k(byte[] bArr) {
        this.f2426f = 0;
        bArr.getClass();
        this.f2418i = bArr;
    }

    @Override // com.google.protobuf.l
    public byte a(int i2) {
        return this.f2418i[i2];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l) || size() != ((l) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof k)) {
            return obj.equals(this);
        }
        k kVar = (k) obj;
        int i2 = this.f2426f;
        int i10 = kVar.f2426f;
        if (i2 != 0 && i10 != 0 && i2 != i10) {
            return false;
        }
        int size = size();
        if (size > kVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > kVar.size()) {
            StringBuilder sbN = a1.a.n(size, "Ran off end of other: 0, ", ", ");
            sbN.append(kVar.size());
            throw new IllegalArgumentException(sbN.toString());
        }
        byte[] bArr = kVar.f2418i;
        int iK = k() + size;
        int iK2 = k();
        int iK3 = kVar.k();
        while (iK2 < iK) {
            if (this.f2418i[iK2] != bArr[iK3]) {
                return false;
            }
            iK2++;
            iK3++;
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new androidx.datastore.preferences.protobuf.d(this);
    }

    @Override // com.google.protobuf.l
    public void j(int i2, byte[] bArr) {
        System.arraycopy(this.f2418i, 0, bArr, 0, i2);
    }

    public int k() {
        return 0;
    }

    public byte l(int i2) {
        return this.f2418i[i2];
    }

    @Override // com.google.protobuf.l
    public int size() {
        return this.f2418i.length;
    }
}
