package com.google.android.gms.internal.mlkit_vision_barcode;

import z2.X;

/* loaded from: classes2.dex */
public enum zzra implements X {
    TYPE_UNKNOWN(0),
    TYPE_THIN(1),
    TYPE_THICK(2),
    TYPE_GMV(3);

    private final int zzf;

    zzra(int i10) {
        this.zzf = i10;
    }

    @Override // z2.X
    public final int zza() {
        return this.zzf;
    }
}
