package com.google.protobuf;

/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: j, reason: collision with root package name */
    public final int f2405j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2406k;

    public j(byte[] bArr, int i2, int i10) {
        super(bArr);
        l.f(i2, i2 + i10, bArr.length);
        this.f2405j = i2;
        this.f2406k = i10;
    }

    @Override // com.google.protobuf.k, com.google.protobuf.l
    public final byte a(int i2) {
        int i10 = this.f2406k;
        if (((i10 - (i2 + 1)) | i2) >= 0) {
            return this.f2418i[this.f2405j + i2];
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(n.f.c(i2, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(m.x.k("Index > length: ", i2, i10, ", "));
    }

    @Override // com.google.protobuf.k, com.google.protobuf.l
    public final void j(int i2, byte[] bArr) {
        System.arraycopy(this.f2418i, this.f2405j, bArr, 0, i2);
    }

    @Override // com.google.protobuf.k
    public final int k() {
        return this.f2405j;
    }

    @Override // com.google.protobuf.k
    public final byte l(int i2) {
        return this.f2418i[this.f2405j + i2];
    }

    @Override // com.google.protobuf.k, com.google.protobuf.l
    public final int size() {
        return this.f2406k;
    }
}
