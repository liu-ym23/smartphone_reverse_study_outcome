package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.h9;

/* loaded from: classes2.dex */
public final class zzyu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyu> CREATOR = new h9();
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;

    public zzyu(int i10, int i11, int i12, int i13, long j10) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = j10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, i11);
        C5047a.p(parcel, 2, this.zzb);
        C5047a.p(parcel, 3, this.zzc);
        C5047a.p(parcel, 4, this.zzd);
        C5047a.r(parcel, 5, this.zze);
        C5047a.b(parcel, iA);
    }
}
