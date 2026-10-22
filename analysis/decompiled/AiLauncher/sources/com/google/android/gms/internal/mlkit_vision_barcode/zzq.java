package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.C6105d;

/* loaded from: classes2.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new C6105d();
    public int zza;
    public String zzb;

    public zzq() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 2, this.zza);
        C5047a.x(parcel, 3, this.zzb, false);
        C5047a.b(parcel, iA);
    }

    public zzq(int i10, String str) {
        this.zza = i10;
        this.zzb = str;
    }
}
