package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: e, reason: collision with root package name */
    public final int f468e;

    /* renamed from: f, reason: collision with root package name */
    public final int f469f;

    public f(byte[] bArr, int i8, int i9) {
        super(bArr);
        g.g(i8, i8 + i9, bArr.length);
        this.f468e = i8;
        this.f469f = i9;
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final byte f(int i8) {
        int i9 = this.f469f;
        if (((i9 - (i8 + 1)) | i8) >= 0) {
            return this.f475b[this.f468e + i8];
        }
        if (i8 < 0) {
            throw new ArrayIndexOutOfBoundsException(a8.b.j(i8, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(a8.b.i(i8, i9, "Index > length: ", ", "));
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final void i(byte[] bArr, int i8) {
        System.arraycopy(this.f475b, this.f468e, bArr, 0, i8);
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final int j() {
        return this.f468e;
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final byte k(int i8) {
        return this.f475b[this.f468e + i8];
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final int size() {
        return this.f469f;
    }
}
