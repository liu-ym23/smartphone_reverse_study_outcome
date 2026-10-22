package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.C6125f;

/* loaded from: classes2.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new C6125f();
    public String zza;
    public String zzb;

    public zzs() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.x(parcel, 2, this.zza, false);
        C5047a.x(parcel, 3, this.zzb, false);
        C5047a.b(parcel, iA);
    }

    public zzs(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }
}
