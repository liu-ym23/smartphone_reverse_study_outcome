package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.b9;

/* loaded from: classes2.dex */
public final class zzxv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxv> CREATOR = new b9();
    private final double zza;
    private final double zzb;

    public zzxv(double d10, double d11) {
        this.zza = d10;
        this.zzb = d11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.k(parcel, 1, this.zza);
        C5047a.k(parcel, 2, this.zzb);
        C5047a.b(parcel, iA);
    }

    public final double zza() {
        return this.zza;
    }

    public final double zzb() {
        return this.zzb;
    }
}
