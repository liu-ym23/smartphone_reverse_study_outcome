package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new n();
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final Context zzd;
    private final boolean zze;
    private final boolean zzf;

    public zzo(String str, boolean z10, boolean z11, IBinder iBinder, boolean z12, boolean z13) {
        this.zza = str;
        this.zzb = z10;
        this.zzc = z11;
        this.zzd = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zze = z12;
        this.zzf = z13;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.x(parcel, 1, str, false);
        C5047a.g(parcel, 2, this.zzb);
        C5047a.g(parcel, 3, this.zzc);
        C5047a.o(parcel, 4, ObjectWrapper.wrap(this.zzd), false);
        C5047a.g(parcel, 5, this.zze);
        C5047a.g(parcel, 6, this.zzf);
        C5047a.b(parcel, iA);
    }
}
