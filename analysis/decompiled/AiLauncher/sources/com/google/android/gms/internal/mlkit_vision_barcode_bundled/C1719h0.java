package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.h0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1719h0 extends C1727j0 {

    /* renamed from: b, reason: collision with root package name */
    public int f20085b;

    /* renamed from: c, reason: collision with root package name */
    public int f20086c;

    /* renamed from: d, reason: collision with root package name */
    public int f20087d;

    public /* synthetic */ C1719h0(byte[] bArr, int i10, int i11, boolean z10, C1715g0 c1715g0) {
        super(null);
        this.f20087d = Integer.MAX_VALUE;
        this.f20085b = 0;
    }

    public final int c(int i10) throws zzer {
        int i11 = this.f20087d;
        this.f20087d = 0;
        int i12 = this.f20085b + this.f20086c;
        this.f20085b = i12;
        if (i12 <= 0) {
            this.f20086c = 0;
            return i11;
        }
        this.f20086c = i12;
        this.f20085b = 0;
        return i11;
    }
}
