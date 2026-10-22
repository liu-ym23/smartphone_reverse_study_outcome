package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class x0 extends y0 {
    @Override // androidx.datastore.preferences.protobuf.y0
    public final boolean c(long j4, Object obj) {
        return this.f3554a.getBoolean(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final byte d(long j4, Object obj) {
        return this.f3554a.getByte(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final double e(long j4, Object obj) {
        return this.f3554a.getDouble(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final float f(long j4, Object obj) {
        return this.f3554a.getFloat(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final void k(Object obj, long j4, boolean z4) {
        this.f3554a.putBoolean(obj, j4, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final void l(Object obj, long j4, byte b4) {
        this.f3554a.putByte(obj, j4, b4);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final void m(Object obj, long j4, double d4) {
        this.f3554a.putDouble(obj, j4, d4);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final void n(Object obj, long j4, float f4) {
        this.f3554a.putFloat(obj, j4, f4);
    }
}
