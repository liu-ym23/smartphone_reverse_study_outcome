package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.r1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1759r1 implements InterfaceC1707e1 {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1720h1 f20131a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20132b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f20133c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20134d;

    public C1759r1(InterfaceC1720h1 interfaceC1720h1, String str, Object[] objArr) {
        this.f20131a = interfaceC1720h1;
        this.f20132b = str;
        this.f20133c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f20134d = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 1;
        int i12 = 13;
        while (true) {
            int i13 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.f20134d = i10 | (cCharAt2 << i12);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i12;
                i12 += 13;
                i11 = i13;
            }
        }
    }

    public final String a() {
        return this.f20132b;
    }

    public final Object[] b() {
        return this.f20133c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1707e1
    public final InterfaceC1720h1 zza() {
        return this.f20131a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1707e1
    public final boolean zzb() {
        return (this.f20134d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1707e1
    public final int zzc() {
        int i10 = this.f20134d;
        if ((i10 & 1) != 0) {
            return 1;
        }
        return (i10 & 4) == 4 ? 3 : 2;
    }
}
