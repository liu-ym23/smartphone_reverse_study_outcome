package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new C1773v();
    private final double zza;
    private final double zzb;

    public zzas(double d10, double d11) {
        this.zza = d10;
        this.zzb = d11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        double d10 = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.k(parcel, 1, d10);
        C5047a.k(parcel, 2, this.zzb);
        C5047a.b(parcel, iA);
    }
}
