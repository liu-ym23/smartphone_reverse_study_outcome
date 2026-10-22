package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
final class zzda extends zzde {

    /* renamed from: d, reason: collision with root package name */
    public final int f20156d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20157e;

    public zzda(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzdf.x(i10, i10 + i11, bArr.length);
        this.f20156d = i10;
        this.f20157e = i11;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde
    public final int L() {
        return this.f20156d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte b(int i10) {
        zzdf.G(i10, this.f20157e);
        return this.f20158c[this.f20156d + i10];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte c(int i10) {
        return this.f20158c[this.f20156d + i10];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int f() {
        return this.f20157e;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzde, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void i(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f20158c, this.f20156d + i10, bArr, i11, i12);
    }
}
