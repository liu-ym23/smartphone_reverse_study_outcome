package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public final class R1 extends S1 {
    public R1(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.S1
    public final double a(Object obj, long j10) {
        return Double.longBitsToDouble(this.f20052a.getLong(obj, j10));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.S1
    public final float b(Object obj, long j10) {
        return Float.intBitsToFloat(this.f20052a.getInt(obj, j10));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.mlkit_vision_barcode_bundled.T1.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.mlkit_vision_barcode_bundled.T1.o(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z10' boolean)' in method call: com.google.android.gms.internal.mlkit_vision_barcode_bundled.T1.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z10' boolean)' in method call: com.google.android.gms.internal.mlkit_vision_barcode_bundled.T1.o(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.S1
    public final void c(Object obj, long j10, boolean z10) {
        if (T1.f20060h) {
            T1.n(obj, j10, z10);
        } else {
            T1.o(obj, j10, z10);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.S1
    public final void d(Object obj, long j10, byte b10) {
        if (T1.f20060h) {
            T1.d(obj, j10, b10);
        } else {
            T1.e(obj, j10, b10);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.S1
    public final void e(Object obj, long j10, double d10) {
        this.f20052a.putLong(obj, j10, Double.doubleToLongBits(d10));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.S1
    public final void f(Object obj, long j10, float f10) {
        this.f20052a.putInt(obj, j10, Float.floatToIntBits(f10));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.S1
    public final boolean g(Object obj, long j10) {
        return T1.f20060h ? T1.y(obj, j10) : T1.z(obj, j10);
    }
}
