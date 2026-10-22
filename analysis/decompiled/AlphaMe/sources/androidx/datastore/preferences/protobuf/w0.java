package androidx.datastore.preferences.protobuf;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class w0 extends y0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3549b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(Unsafe unsafe, int i4) {
        super(unsafe);
        this.f3549b = i4;
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final boolean c(long j4, Object obj) {
        switch (this.f3549b) {
            case 0:
                if (z0.f3562h) {
                    if (z0.g(j4, obj) == 0) {
                    }
                } else if (z0.h(j4, obj) == 0) {
                }
                break;
            default:
                if (z0.f3562h) {
                    if (z0.g(j4, obj) == 0) {
                    }
                } else if (z0.h(j4, obj) == 0) {
                }
                break;
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final byte d(long j4, Object obj) {
        switch (this.f3549b) {
            case 0:
                if (!z0.f3562h) {
                    break;
                } else {
                    break;
                }
            default:
                if (!z0.f3562h) {
                    break;
                } else {
                    break;
                }
        }
        return z0.h(j4, obj);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final double e(long j4, Object obj) {
        switch (this.f3549b) {
        }
        return Double.longBitsToDouble(h(j4, obj));
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final float f(long j4, Object obj) {
        switch (this.f3549b) {
        }
        return Float.intBitsToFloat(g(j4, obj));
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final void k(Object obj, long j4, boolean z4) {
        switch (this.f3549b) {
            case 0:
                if (!z0.f3562h) {
                    z0.o(obj, j4, z4 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    z0.n(obj, j4, z4 ? (byte) 1 : (byte) 0);
                    break;
                }
            default:
                if (!z0.f3562h) {
                    z0.o(obj, j4, z4 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    z0.n(obj, j4, z4 ? (byte) 1 : (byte) 0);
                    break;
                }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final void l(Object obj, long j4, byte b4) {
        switch (this.f3549b) {
            case 0:
                if (!z0.f3562h) {
                    z0.o(obj, j4, b4);
                    break;
                } else {
                    z0.n(obj, j4, b4);
                    break;
                }
            default:
                if (!z0.f3562h) {
                    z0.o(obj, j4, b4);
                    break;
                } else {
                    z0.n(obj, j4, b4);
                    break;
                }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final void m(Object obj, long j4, double d4) {
        switch (this.f3549b) {
            case 0:
                p(obj, j4, Double.doubleToLongBits(d4));
                break;
            default:
                p(obj, j4, Double.doubleToLongBits(d4));
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final void n(Object obj, long j4, float f4) {
        switch (this.f3549b) {
            case 0:
                o(Float.floatToIntBits(f4), j4, obj);
                break;
            default:
                o(Float.floatToIntBits(f4), j4, obj);
                break;
        }
    }
}
