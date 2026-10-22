package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends h {

    /* renamed from: e, reason: collision with root package name */
    public final int f1460e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1461f;

    public g(byte[] bArr, int i8, int i9) {
        super(bArr);
        i.g(i8, i8 + i9, bArr.length);
        this.f1460e = i8;
        this.f1461f = i9;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h, com.google.crypto.tink.shaded.protobuf.i
    public final byte f(int i8) {
        int i9 = this.f1461f;
        if (((i9 - (i8 + 1)) | i8) >= 0) {
            return this.d[this.f1460e + i8];
        }
        if (i8 < 0) {
            throw new ArrayIndexOutOfBoundsException(a8.b.j(i8, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(a8.b.i(i8, i9, "Index > length: ", ", "));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h, com.google.crypto.tink.shaded.protobuf.i
    public final void i(byte[] bArr, int i8) {
        System.arraycopy(this.d, this.f1460e, bArr, 0, i8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h
    public final int k() {
        return this.f1460e;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h
    public final byte l(int i8) {
        return this.d[this.f1460e + i8];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h, com.google.crypto.tink.shaded.protobuf.i
    public final int size() {
        return this.f1461f;
    }
}
