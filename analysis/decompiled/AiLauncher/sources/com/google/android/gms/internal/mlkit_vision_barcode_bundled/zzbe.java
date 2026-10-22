package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new C1750p();
    private final zzbr zza;

    public zzbe(zzbr zzbrVar) {
        this.zza = zzbrVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        zzbr zzbrVar = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.w(parcel, 1, zzbrVar, i10, false);
        C5047a.b(parcel, iA);
    }
}
