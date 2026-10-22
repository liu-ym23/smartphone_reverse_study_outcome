package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zab;
import w2.C5717a;

/* loaded from: classes2.dex */
public abstract class zad extends zab implements zae {
    public zad() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 3:
                C5717a.b(parcel);
                break;
            case 4:
                C5717a.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                C5717a.b(parcel);
                break;
            case 7:
                C5717a.b(parcel);
                break;
            case 8:
                zak zakVar = (zak) C5717a.a(parcel, zak.CREATOR);
                C5717a.b(parcel);
                zab(zakVar);
                break;
            case 9:
                C5717a.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
