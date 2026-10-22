package androidx.datastore.preferences.protobuf;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class p1 extends r1 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f916b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p1(Unsafe unsafe, int i2) {
        super(unsafe);
        this.f916b = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final boolean c(long j2, Object obj) {
        switch (this.f916b) {
            case 0:
                if (s1.f953g) {
                    if (s1.h(j2, obj) == 0) {
                    }
                } else if (s1.i(j2, obj) == 0) {
                }
                break;
            default:
                if (s1.f953g) {
                    if (s1.h(j2, obj) == 0) {
                    }
                } else if (s1.i(j2, obj) == 0) {
                }
                break;
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final byte d(long j2, Object obj) {
        switch (this.f916b) {
            case 0:
                if (!s1.f953g) {
                    break;
                } else {
                    break;
                }
            default:
                if (!s1.f953g) {
                    break;
                } else {
                    break;
                }
        }
        return s1.i(j2, obj);
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final double e(long j2, Object obj) {
        switch (this.f916b) {
        }
        return Double.longBitsToDouble(h(j2, obj));
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final float f(long j2, Object obj) {
        switch (this.f916b) {
        }
        return Float.intBitsToFloat(g(j2, obj));
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void k(Object obj, long j2, boolean z4) {
        switch (this.f916b) {
            case 0:
                if (!s1.f953g) {
                    s1.m(obj, j2, z4 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    s1.l(obj, j2, z4 ? (byte) 1 : (byte) 0);
                    break;
                }
            default:
                if (!s1.f953g) {
                    s1.m(obj, j2, z4 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    s1.l(obj, j2, z4 ? (byte) 1 : (byte) 0);
                    break;
                }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void l(Object obj, long j2, byte b10) {
        switch (this.f916b) {
            case 0:
                if (!s1.f953g) {
                    s1.m(obj, j2, b10);
                    break;
                } else {
                    s1.l(obj, j2, b10);
                    break;
                }
            default:
                if (!s1.f953g) {
                    s1.m(obj, j2, b10);
                    break;
                } else {
                    s1.l(obj, j2, b10);
                    break;
                }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void m(Object obj, long j2, double d6) {
        switch (this.f916b) {
            case 0:
                p(obj, j2, Double.doubleToLongBits(d6));
                break;
            default:
                p(obj, j2, Double.doubleToLongBits(d6));
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void n(Object obj, long j2, float f10) {
        switch (this.f916b) {
            case 0:
                o(Float.floatToIntBits(f10), j2, obj);
                break;
            default:
                o(Float.floatToIntBits(f10), j2, obj);
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final boolean s() {
        switch (this.f916b) {
        }
        return false;
    }
}
