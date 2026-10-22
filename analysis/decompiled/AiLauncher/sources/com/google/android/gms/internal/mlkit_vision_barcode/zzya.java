package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.g9;

/* loaded from: classes2.dex */
public final class zzya extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzya> CREATOR = new g9();
    private final String zza;
    private final String zzb;
    private final int zzc;

    public zzya(String str, String str2, int i10) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.x(parcel, 1, str, false);
        C5047a.x(parcel, 2, this.zzb, false);
        C5047a.p(parcel, 3, this.zzc);
        C5047a.b(parcel, iA);
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
