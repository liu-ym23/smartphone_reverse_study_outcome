package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class h extends i {
    public final byte[] d;

    public h(byte[] bArr) {
        this.f1467a = 0;
        bArr.getClass();
        this.d = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i) || size() != ((i) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof h)) {
            return obj.equals(this);
        }
        h hVar = (h) obj;
        int i8 = this.f1467a;
        int i9 = hVar.f1467a;
        if (i8 != 0 && i9 != 0 && i8 != i9) {
            return false;
        }
        int size = size();
        if (size > hVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > hVar.size()) {
            StringBuilder sbS = a8.b.s(size, "Ran off end of other: 0, ", ", ");
            sbS.append(hVar.size());
            throw new IllegalArgumentException(sbS.toString());
        }
        byte[] bArr = hVar.d;
        int iK = k() + size;
        int iK2 = k();
        int iK3 = hVar.k();
        while (iK2 < iK) {
            if (this.d[iK2] != bArr[iK3]) {
                return false;
            }
            iK2++;
            iK3++;
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i
    public byte f(int i8) {
        return this.d[i8];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i
    public void i(byte[] bArr, int i8) {
        System.arraycopy(this.d, 0, bArr, 0, i8);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new androidx.datastore.preferences.protobuf.d(this);
    }

    public int k() {
        return 0;
    }

    public byte l(int i8) {
        return this.d[i8];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i
    public int size() {
        return this.d.length;
    }
}
