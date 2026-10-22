package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.C6075a;

/* loaded from: classes2.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new C6075a();
    public int zza;
    public String zzb;
    public String zzc;
    public String zzd;

    public zzn() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 2, this.zza);
        C5047a.x(parcel, 3, this.zzb, false);
        C5047a.x(parcel, 4, this.zzc, false);
        C5047a.x(parcel, 5, this.zzd, false);
        C5047a.b(parcel, iA);
    }

    public zzn(int i10, String str, String str2, String str3) {
        this.zza = i10;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }
}
