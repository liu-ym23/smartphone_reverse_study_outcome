package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import t0.J;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
/* loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new k(2);

    /* renamed from: a, reason: collision with root package name */
    public final String f9957a;

    /* renamed from: b, reason: collision with root package name */
    public final zzk f9958b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9959c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9960d;

    public zzs(String str, IBinder iBinder, boolean z4, boolean z5) {
        this.f9957a = str;
        zzk zzkVar = null;
        if (iBinder != null) {
            try {
                IObjectWrapper iObjectWrapperZzd = zzy.zzg(iBinder).zzd();
                byte[] bArr = iObjectWrapperZzd == null ? null : (byte[]) ObjectWrapper.unwrap(iObjectWrapperZzd);
                if (bArr != null) {
                    zzkVar = new zzk(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e4) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e4);
            }
        }
        this.f9958b = zzkVar;
        this.f9959c = z4;
        this.f9960d = z5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.U(parcel, 1, this.f9957a);
        zzk zzkVar = this.f9958b;
        if (zzkVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zzkVar = null;
        }
        J.R(parcel, 2, zzkVar);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9959c ? 1 : 0);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f9960d ? 1 : 0);
        J.b0(parcel, iZ);
    }
}
