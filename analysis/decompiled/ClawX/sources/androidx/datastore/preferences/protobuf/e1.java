package androidx.datastore.preferences.protobuf;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e1 extends g1 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f467b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(Unsafe unsafe, int i8) {
        super(unsafe);
        this.f467b = i8;
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final boolean c(Object obj, long j4) {
        switch (this.f467b) {
            case 0:
                if (!h1.f491g) {
                    break;
                } else {
                    break;
                }
            default:
                if (!h1.f491g) {
                    break;
                } else {
                    break;
                }
        }
        return h1.c(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final double d(Object obj, long j4) {
        switch (this.f467b) {
        }
        return Double.longBitsToDouble(g(obj, j4));
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final float e(Object obj, long j4) {
        switch (this.f467b) {
        }
        return Float.intBitsToFloat(f(obj, j4));
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void j(Object obj, long j4, boolean z) {
        switch (this.f467b) {
            case 0:
                if (!h1.f491g) {
                    h1.l(obj, j4, z ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    h1.k(obj, j4, z ? (byte) 1 : (byte) 0);
                    break;
                }
            default:
                if (!h1.f491g) {
                    h1.l(obj, j4, z ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    h1.k(obj, j4, z ? (byte) 1 : (byte) 0);
                    break;
                }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void k(Object obj, long j4, byte b9) {
        switch (this.f467b) {
            case 0:
                if (!h1.f491g) {
                    h1.l(obj, j4, b9);
                    break;
                } else {
                    h1.k(obj, j4, b9);
                    break;
                }
            default:
                if (!h1.f491g) {
                    h1.l(obj, j4, b9);
                    break;
                } else {
                    h1.k(obj, j4, b9);
                    break;
                }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void l(Object obj, long j4, double d) {
        switch (this.f467b) {
            case 0:
                o(obj, j4, Double.doubleToLongBits(d));
                break;
            default:
                o(obj, j4, Double.doubleToLongBits(d));
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void m(Object obj, long j4, float f3) {
        switch (this.f467b) {
            case 0:
                n(Float.floatToIntBits(f3), j4, obj);
                break;
            default:
                n(Float.floatToIntBits(f3), j4, obj);
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final boolean r() {
        switch (this.f467b) {
        }
        return false;
    }
}
