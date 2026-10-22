package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new C1769u();
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public zzar(int i10, String str, String str2, String str3) {
        this.zza = i10;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, i11);
        C5047a.x(parcel, 2, this.zzb, false);
        C5047a.x(parcel, 3, this.zzc, false);
        C5047a.x(parcel, 4, this.zzd, false);
        C5047a.b(parcel, iA);
    }
}
