package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C1668i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.C6145h;

/* loaded from: classes2.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new C6145h();
    public int zza;
    public boolean zzb;

    public zzah() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzahVar = (zzah) obj;
        return this.zza == zzahVar.zza && C1668i.a(Boolean.valueOf(this.zzb), Boolean.valueOf(zzahVar.zzb));
    }

    public final int hashCode() {
        return C1668i.b(Integer.valueOf(this.zza), Boolean.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 2, this.zza);
        C5047a.g(parcel, 3, this.zzb);
        C5047a.b(parcel, iA);
    }

    public zzah(int i10, boolean z10) {
        this.zza = i10;
        this.zzb = z10;
    }
}
