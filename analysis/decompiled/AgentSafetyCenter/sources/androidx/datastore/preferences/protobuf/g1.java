package androidx.datastore.preferences.protobuf;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g1 extends i1 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1120b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(Unsafe unsafe, int i) {
        super(unsafe);
        this.f1120b = i;
    }

    @Override // androidx.datastore.preferences.protobuf.i1
    public final boolean c(Object obj, long j10) {
        switch (this.f1120b) {
            case 0:
                if (!j1.f1144g) {
                    break;
                } else {
                    break;
                }
            default:
                if (!j1.f1144g) {
                    break;
                } else {
                    break;
                }
        }
        return j1.c(obj, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.i1
    public final double d(Object obj, long j10) {
        switch (this.f1120b) {
        }
        return Double.longBitsToDouble(g(obj, j10));
    }

    @Override // androidx.datastore.preferences.protobuf.i1
    public final float e(Object obj, long j10) {
        switch (this.f1120b) {
        }
        return Float.intBitsToFloat(f(obj, j10));
    }

    @Override // androidx.datastore.preferences.protobuf.i1
    public final void j(Object obj, long j10, boolean z10) {
        switch (this.f1120b) {
            case 0:
                if (!j1.f1144g) {
                    j1.l(obj, j10, z10 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    j1.k(obj, j10, z10 ? (byte) 1 : (byte) 0);
                    break;
                }
            default:
                if (!j1.f1144g) {
                    j1.l(obj, j10, z10 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    j1.k(obj, j10, z10 ? (byte) 1 : (byte) 0);
                    break;
                }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.i1
    public final void k(Object obj, long j10, byte b10) {
        switch (this.f1120b) {
            case 0:
                if (!j1.f1144g) {
                    j1.l(obj, j10, b10);
                    break;
                } else {
                    j1.k(obj, j10, b10);
                    break;
                }
            default:
                if (!j1.f1144g) {
                    j1.l(obj, j10, b10);
                    break;
                } else {
                    j1.k(obj, j10, b10);
                    break;
                }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.i1
    public final void l(Object obj, long j10, double d7) {
        switch (this.f1120b) {
            case 0:
                o(obj, j10, Double.doubleToLongBits(d7));
                break;
            default:
                o(obj, j10, Double.doubleToLongBits(d7));
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.i1
    public final void m(Object obj, long j10, float f5) {
        switch (this.f1120b) {
            case 0:
                n(obj, j10, Float.floatToIntBits(f5));
                break;
            default:
                n(obj, j10, Float.floatToIntBits(f5));
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.i1
    public final boolean r() {
        switch (this.f1120b) {
        }
        return false;
    }
}
