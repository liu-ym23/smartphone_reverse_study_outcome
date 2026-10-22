package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class T implements Parcelable.Creator {
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, getServiceRequest.zzc);
        C5047a.p(parcel, 2, getServiceRequest.zzd);
        C5047a.p(parcel, 3, getServiceRequest.zze);
        C5047a.x(parcel, 4, getServiceRequest.zzf, false);
        C5047a.o(parcel, 5, getServiceRequest.zzg, false);
        C5047a.A(parcel, 6, getServiceRequest.zzh, i10, false);
        C5047a.i(parcel, 7, getServiceRequest.zzi, false);
        C5047a.w(parcel, 8, getServiceRequest.zzj, i10, false);
        C5047a.A(parcel, 10, getServiceRequest.zzk, i10, false);
        C5047a.A(parcel, 11, getServiceRequest.zzl, i10, false);
        C5047a.g(parcel, 12, getServiceRequest.zzm);
        C5047a.p(parcel, 13, getServiceRequest.zzn);
        C5047a.g(parcel, 14, getServiceRequest.zzo);
        C5047a.x(parcel, 15, getServiceRequest.zza(), false);
        C5047a.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.zzb;
        Feature[] featureArr2 = featureArr;
        String strO = null;
        IBinder iBinderZ = null;
        Account account = null;
        String strO2 = null;
        int iA = 0;
        int iA2 = 0;
        int iA3 = 0;
        boolean zV = false;
        int iA4 = 0;
        boolean zV2 = false;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    break;
                case 3:
                    iA3 = SafeParcelReader.A(parcel, iY);
                    break;
                case 4:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 5:
                    iBinderZ = SafeParcelReader.z(parcel, iY);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.r(parcel, iY, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, iY);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.n(parcel, iY, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.r(parcel, iY, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.r(parcel, iY, Feature.CREATOR);
                    break;
                case 12:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
                case 13:
                    iA4 = SafeParcelReader.A(parcel, iY);
                    break;
                case 14:
                    zV2 = SafeParcelReader.v(parcel, iY);
                    break;
                case 15:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new GetServiceRequest(iA, iA2, iA3, strO, iBinderZ, scopeArr, bundle, account, featureArr, featureArr2, zV, iA4, zV2, strO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GetServiceRequest[i10];
    }
}
