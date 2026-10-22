package com.google.protobuf;

import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public final class T2 extends V2 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ T2(Unsafe unsafe, int i) {
        super(unsafe);
        this.b = i;
    }

    @Override // com.google.protobuf.V2
    public final void c(long j5, byte[] bArr, long j6) {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.protobuf.V2
    public final boolean d(Object obj, long j5) {
        switch (this.b) {
            case 0:
                if (W2.h) {
                    if (W2.h(obj, j5) == 0) {
                    }
                } else if (W2.i(obj, j5) == 0) {
                }
                break;
            default:
                if (W2.h) {
                    if (W2.h(obj, j5) == 0) {
                    }
                } else if (W2.i(obj, j5) == 0) {
                }
                break;
        }
        return false;
    }

    @Override // com.google.protobuf.V2
    public final byte e(long j5) {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.protobuf.V2
    public final byte f(Object obj, long j5) {
        switch (this.b) {
            case 0:
                if (!W2.h) {
                    break;
                } else {
                    break;
                }
            default:
                if (!W2.h) {
                    break;
                } else {
                    break;
                }
        }
        return W2.i(obj, j5);
    }

    @Override // com.google.protobuf.V2
    public final double g(Object obj, long j5) {
        switch (this.b) {
        }
        return Double.longBitsToDouble(j(obj, j5));
    }

    @Override // com.google.protobuf.V2
    public final float h(Object obj, long j5) {
        switch (this.b) {
        }
        return Float.intBitsToFloat(i(obj, j5));
    }

    @Override // com.google.protobuf.V2
    public final void m(Object obj, long j5, boolean z10) {
        switch (this.b) {
            case 0:
                if (!W2.h) {
                    W2.m(obj, j5, z10 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    W2.l(obj, j5, z10 ? (byte) 1 : (byte) 0);
                    break;
                }
            default:
                if (!W2.h) {
                    W2.m(obj, j5, z10 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    W2.l(obj, j5, z10 ? (byte) 1 : (byte) 0);
                    break;
                }
        }
    }

    @Override // com.google.protobuf.V2
    public final void n(Object obj, long j5, byte b) {
        switch (this.b) {
            case 0:
                if (!W2.h) {
                    W2.m(obj, j5, b);
                    break;
                } else {
                    W2.l(obj, j5, b);
                    break;
                }
            default:
                if (!W2.h) {
                    W2.m(obj, j5, b);
                    break;
                } else {
                    W2.l(obj, j5, b);
                    break;
                }
        }
    }

    @Override // com.google.protobuf.V2
    public final void o(Object obj, long j5, double d) {
        switch (this.b) {
            case 0:
                r(obj, j5, Double.doubleToLongBits(d));
                break;
            default:
                r(obj, j5, Double.doubleToLongBits(d));
                break;
        }
    }

    @Override // com.google.protobuf.V2
    public final void p(Object obj, long j5, float f) {
        switch (this.b) {
            case 0:
                q(obj, j5, Float.floatToIntBits(f));
                break;
            default:
                q(obj, j5, Float.floatToIntBits(f));
                break;
        }
    }

    @Override // com.google.protobuf.V2
    public final boolean u() {
        switch (this.b) {
        }
        return false;
    }
}
