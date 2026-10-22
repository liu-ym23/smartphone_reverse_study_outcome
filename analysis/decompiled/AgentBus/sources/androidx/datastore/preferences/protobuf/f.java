package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: j, reason: collision with root package name */
    public final int f845j;

    /* renamed from: k, reason: collision with root package name */
    public final int f846k;

    public f(byte[] bArr, int i2, int i10) {
        super(bArr);
        g.f(i2, i2 + i10, bArr.length);
        this.f845j = i2;
        this.f846k = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final byte a(int i2) {
        int i10 = this.f846k;
        if (((i10 - (i2 + 1)) | i2) >= 0) {
            return this.f853g[this.f845j + i2];
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(n.f.c(i2, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(m.x.k("Index > length: ", i2, i10, ", "));
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final void i(int i2, byte[] bArr) {
        System.arraycopy(this.f853g, this.f845j, bArr, 0, i2);
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final int j() {
        return this.f845j;
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final byte k(int i2) {
        return this.f853g[this.f845j + i2];
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final int size() {
        return this.f846k;
    }
}
