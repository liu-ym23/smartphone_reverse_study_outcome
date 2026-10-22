package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: j, reason: collision with root package name */
    public final int f2203j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2204k;

    public f(byte[] bArr, int i2, int i10) {
        super(bArr);
        h.f(i2, i2 + i10, bArr.length);
        this.f2203j = i2;
        this.f2204k = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g, com.google.crypto.tink.shaded.protobuf.h
    public final byte a(int i2) {
        int i10 = this.f2204k;
        if (((i10 - (i2 + 1)) | i2) >= 0) {
            return this.f2207i[this.f2203j + i2];
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(n.f.c(i2, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(m.x.k("Index > length: ", i2, i10, ", "));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g, com.google.crypto.tink.shaded.protobuf.h
    public final void i(int i2, byte[] bArr) {
        System.arraycopy(this.f2207i, this.f2203j, bArr, 0, i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g
    public final int k() {
        return this.f2203j;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g
    public final byte l(int i2) {
        return this.f2207i[this.f2203j + i2];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.g, com.google.crypto.tink.shaded.protobuf.h
    public final int size() {
        return this.f2204k;
    }
}
