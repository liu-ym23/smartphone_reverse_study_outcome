package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.C6085b;

/* loaded from: classes2.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new C6085b();
    public double zza;
    public double zzb;

    public zzo() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.k(parcel, 2, this.zza);
        C5047a.k(parcel, 3, this.zzb);
        C5047a.b(parcel, iA);
    }

    public zzo(double d10, double d11) {
        this.zza = d10;
        this.zzb = d11;
    }
}
