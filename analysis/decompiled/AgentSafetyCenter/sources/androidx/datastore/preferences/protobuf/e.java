package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends f {
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f1103j;

    @Override // androidx.datastore.preferences.protobuf.f
    public final byte a(int i) {
        int i3 = this.f1103j;
        if (((i3 - (i + 1)) | i) >= 0) {
            return this.f1108f[this.i + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(k0.a.j(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(androidx.activity.b.i("Index > length: ", i, ", ", i3));
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final void d(int i, byte[] bArr) {
        System.arraycopy(this.f1108f, this.i, bArr, 0, i);
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final int e() {
        return this.i;
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final byte f(int i) {
        return this.f1108f[this.i + i];
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final int size() {
        return this.f1103j;
    }
}
