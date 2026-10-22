package com.google.crypto.tink.shaded.protobuf;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k1 extends m1 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1485b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k1(Unsafe unsafe, int i8) {
        super(unsafe);
        this.f1485b = i8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final boolean c(Object obj, long j4) {
        switch (this.f1485b) {
            case 0:
                if (n1.f1502g) {
                    if (n1.h(obj, j4) == 0) {
                    }
                } else if (n1.i(obj, j4) == 0) {
                }
                break;
            default:
                if (n1.f1502g) {
                    if (n1.h(obj, j4) == 0) {
                    }
                } else if (n1.i(obj, j4) == 0) {
                }
                break;
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final byte d(Object obj, long j4) {
        switch (this.f1485b) {
            case 0:
                if (!n1.f1502g) {
                    break;
                } else {
                    break;
                }
            default:
                if (!n1.f1502g) {
                    break;
                } else {
                    break;
                }
        }
        return n1.i(obj, j4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final double e(Object obj, long j4) {
        switch (this.f1485b) {
        }
        return Double.longBitsToDouble(h(obj, j4));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final float f(Object obj, long j4) {
        switch (this.f1485b) {
        }
        return Float.intBitsToFloat(g(obj, j4));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final void k(Object obj, long j4, boolean z) {
        switch (this.f1485b) {
            case 0:
                if (!n1.f1502g) {
                    n1.m(obj, j4, z ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    n1.l(obj, j4, z ? (byte) 1 : (byte) 0);
                    break;
                }
            default:
                if (!n1.f1502g) {
                    n1.m(obj, j4, z ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    n1.l(obj, j4, z ? (byte) 1 : (byte) 0);
                    break;
                }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final void l(Object obj, long j4, byte b9) {
        switch (this.f1485b) {
            case 0:
                if (!n1.f1502g) {
                    n1.m(obj, j4, b9);
                    break;
                } else {
                    n1.l(obj, j4, b9);
                    break;
                }
            default:
                if (!n1.f1502g) {
                    n1.m(obj, j4, b9);
                    break;
                } else {
                    n1.l(obj, j4, b9);
                    break;
                }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final void m(Object obj, long j4, double d) {
        switch (this.f1485b) {
            case 0:
                p(obj, j4, Double.doubleToLongBits(d));
                break;
            default:
                p(obj, j4, Double.doubleToLongBits(d));
                break;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final void n(Object obj, long j4, float f3) {
        switch (this.f1485b) {
            case 0:
                o(Float.floatToIntBits(f3), j4, obj);
                break;
            default:
                o(Float.floatToIntBits(f3), j4, obj);
                break;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m1
    public final boolean s() {
        switch (this.f1485b) {
        }
        return false;
    }
}
