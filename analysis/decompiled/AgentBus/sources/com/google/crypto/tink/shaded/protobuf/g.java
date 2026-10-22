package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;

/* loaded from: classes.dex */
public class g extends h {

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f2207i;

    public g(byte[] bArr) {
        this.f2211f = 0;
        bArr.getClass();
        this.f2207i = bArr;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h
    public byte a(int i2) {
        return this.f2207i[i2];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h) || size() != ((h) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof g)) {
            return obj.equals(this);
        }
        g gVar = (g) obj;
        int i2 = this.f2211f;
        int i10 = gVar.f2211f;
        if (i2 != 0 && i10 != 0 && i2 != i10) {
            return false;
        }
        int size = size();
        if (size > gVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > gVar.size()) {
            StringBuilder sbN = a1.a.n(size, "Ran off end of other: 0, ", ", ");
            sbN.append(gVar.size());
            throw new IllegalArgumentException(sbN.toString());
        }
        byte[] bArr = gVar.f2207i;
        int iK = k() + size;
        int iK2 = k();
        int iK3 = gVar.k();
        while (iK2 < iK) {
            if (this.f2207i[iK2] != bArr[iK3]) {
                return false;
            }
            iK2++;
            iK3++;
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h
    public void i(int i2, byte[] bArr) {
        System.arraycopy(this.f2207i, 0, bArr, 0, i2);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new androidx.datastore.preferences.protobuf.d(this);
    }

    public int k() {
        return 0;
    }

    public byte l(int i2) {
        return this.f2207i[i2];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h
    public int size() {
        return this.f2207i.length;
    }
}
