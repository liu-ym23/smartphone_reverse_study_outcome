package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        ArrayList arrayListS = null;
        Account account = null;
        String strO = null;
        String strO2 = null;
        ArrayList arrayListS2 = null;
        String strO3 = null;
        int iA = 0;
        boolean zV = false;
        boolean zV2 = false;
        boolean zV3 = false;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    arrayListS = SafeParcelReader.s(parcel, iY, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.n(parcel, iY, Account.CREATOR);
                    break;
                case 4:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
                case 5:
                    zV2 = SafeParcelReader.v(parcel, iY);
                    break;
                case 6:
                    zV3 = SafeParcelReader.v(parcel, iY);
                    break;
                case 7:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 8:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 9:
                    arrayListS2 = SafeParcelReader.s(parcel, iY, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    strO3 = SafeParcelReader.o(parcel, iY);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new GoogleSignInOptions(iA, arrayListS, account, zV, zV2, zV3, strO, strO2, arrayListS2, strO3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GoogleSignInOptions[i10];
    }
}
