package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new p();
    private final String zza;
    private final zzj zzb;
    private final boolean zzc;
    private final boolean zzd;

    public zzs(String str, zzj zzjVar, boolean z10, boolean z11) {
        this.zza = str;
        this.zzb = zzjVar;
        this.zzc = z10;
        this.zzd = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.x(parcel, 1, str, false);
        zzj zzjVar = this.zzb;
        if (zzjVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zzjVar = null;
        }
        C5047a.o(parcel, 2, zzjVar, false);
        C5047a.g(parcel, 3, this.zzc);
        C5047a.g(parcel, 4, this.zzd);
        C5047a.b(parcel, iA);
    }

    public zzs(String str, IBinder iBinder, boolean z10, boolean z11) {
        this.zza = str;
        zzk zzkVar = null;
        if (iBinder != null) {
            try {
                IObjectWrapper iObjectWrapperZzd = zzz.zzg(iBinder).zzd();
                byte[] bArr = iObjectWrapperZzd == null ? null : (byte[]) ObjectWrapper.unwrap(iObjectWrapperZzd);
                if (bArr != null) {
                    zzkVar = new zzk(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e10) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e10);
            }
        }
        this.zzb = zzkVar;
        this.zzc = z10;
        this.zzd = z11;
    }
}
