package com.google.protobuf;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class f4 extends h4 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2353b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f4(Unsafe unsafe, int i2) {
        super(unsafe);
        this.f2353b = i2;
    }

    @Override // com.google.protobuf.h4
    public final boolean c(long j2, Object obj) {
        switch (this.f2353b) {
            case 0:
                if (i4.f2404g) {
                    if (i4.h(j2, obj) == 0) {
                    }
                } else if (i4.i(j2, obj) == 0) {
                }
                break;
            default:
                if (i4.f2404g) {
                    if (i4.h(j2, obj) == 0) {
                    }
                } else if (i4.i(j2, obj) == 0) {
                }
                break;
        }
        return false;
    }

    @Override // com.google.protobuf.h4
    public final byte d(long j2, Object obj) {
        switch (this.f2353b) {
            case 0:
                if (!i4.f2404g) {
                    break;
                } else {
                    break;
                }
            default:
                if (!i4.f2404g) {
                    break;
                } else {
                    break;
                }
        }
        return i4.i(j2, obj);
    }

    @Override // com.google.protobuf.h4
    public final double e(long j2, Object obj) {
        switch (this.f2353b) {
        }
        return Double.longBitsToDouble(h(j2, obj));
    }

    @Override // com.google.protobuf.h4
    public final float f(long j2, Object obj) {
        switch (this.f2353b) {
        }
        return Float.intBitsToFloat(g(j2, obj));
    }

    @Override // com.google.protobuf.h4
    public final void k(Object obj, long j2, boolean z4) {
        switch (this.f2353b) {
            case 0:
                if (!i4.f2404g) {
                    i4.m(obj, j2, z4 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    i4.l(obj, j2, z4 ? (byte) 1 : (byte) 0);
                    break;
                }
            default:
                if (!i4.f2404g) {
                    i4.m(obj, j2, z4 ? (byte) 1 : (byte) 0);
                    break;
                } else {
                    i4.l(obj, j2, z4 ? (byte) 1 : (byte) 0);
                    break;
                }
        }
    }

    @Override // com.google.protobuf.h4
    public final void l(Object obj, long j2, byte b10) {
        switch (this.f2353b) {
            case 0:
                if (!i4.f2404g) {
                    i4.m(obj, j2, b10);
                    break;
                } else {
                    i4.l(obj, j2, b10);
                    break;
                }
            default:
                if (!i4.f2404g) {
                    i4.m(obj, j2, b10);
                    break;
                } else {
                    i4.l(obj, j2, b10);
                    break;
                }
        }
    }

    @Override // com.google.protobuf.h4
    public final void m(Object obj, long j2, double d6) {
        switch (this.f2353b) {
            case 0:
                p(obj, j2, Double.doubleToLongBits(d6));
                break;
            default:
                p(obj, j2, Double.doubleToLongBits(d6));
                break;
        }
    }

    @Override // com.google.protobuf.h4
    public final void n(Object obj, long j2, float f10) {
        switch (this.f2353b) {
            case 0:
                o(Float.floatToIntBits(f10), j2, obj);
                break;
            default:
                o(Float.floatToIntBits(f10), j2, obj);
                break;
        }
    }

    @Override // com.google.protobuf.h4
    public final boolean s() {
        switch (this.f2353b) {
        }
        return false;
    }
}
