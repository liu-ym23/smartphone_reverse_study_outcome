package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class D0 implements InterfaceC1774v0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f20011a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhf f20012b;

    public D0(I0 i02, int i10, zzhf zzhfVar, boolean z10, boolean z11) {
        this.f20011a = i10;
        this.f20012b = zzhfVar;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.f20011a - ((D0) obj).f20011a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1774v0
    public final InterfaceC1716g1 g(InterfaceC1716g1 interfaceC1716g1, InterfaceC1720h1 interfaceC1720h1) {
        A0 a02 = (A0) interfaceC1716g1;
        a02.o((F0) interfaceC1720h1);
        return a02;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1774v0
    public final InterfaceC1740m1 h(InterfaceC1740m1 interfaceC1740m1, InterfaceC1740m1 interfaceC1740m12) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1774v0
    public final int zza() {
        return this.f20011a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1774v0
    public final zzhf zzd() {
        return this.f20012b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1774v0
    public final zzhg zze() {
        return this.f20012b.zza();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1774v0
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1774v0
    public final boolean zzg() {
        return false;
    }
}
