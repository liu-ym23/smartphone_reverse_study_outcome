package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new o();
    private final boolean zza;
    private final String zzb;
    private final int zzc;
    private final int zzd;

    public zzq(boolean z10, String str, int i10, int i11) {
        this.zza = z10;
        this.zzb = str;
        this.zzc = q.a(i10) - 1;
        this.zzd = k.a(i11) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.g(parcel, 1, this.zza);
        C5047a.x(parcel, 2, this.zzb, false);
        C5047a.p(parcel, 3, this.zzc);
        C5047a.p(parcel, 4, this.zzd);
        C5047a.b(parcel, iA);
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zza;
    }

    public final int zzc() {
        return k.a(this.zzd);
    }

    public final int zzd() {
        return q.a(this.zzc);
    }
}
