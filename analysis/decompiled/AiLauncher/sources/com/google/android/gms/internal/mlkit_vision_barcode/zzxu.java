package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.a9;

/* loaded from: classes2.dex */
public final class zzxu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxu> CREATOR = new a9();
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public zzxu(int i10, String str, String str2, String str3) {
        this.zza = i10;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, this.zza);
        C5047a.x(parcel, 2, this.zzb, false);
        C5047a.x(parcel, 3, this.zzc, false);
        C5047a.x(parcel, 4, this.zzd, false);
        C5047a.b(parcel, iA);
    }

    public final int zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zzc;
    }
}
