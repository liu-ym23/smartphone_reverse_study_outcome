package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zab;
import g1.AbstractC0573a;

/* loaded from: classes.dex */
public abstract class zad extends zab implements zae {
    public zad() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        switch (i4) {
            case 3:
                AbstractC0573a.b(parcel);
                break;
            case 4:
                AbstractC0573a.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                AbstractC0573a.b(parcel);
                break;
            case 7:
                AbstractC0573a.b(parcel);
                break;
            case 8:
                zak zakVar = (zak) AbstractC0573a.a(parcel, zak.CREATOR);
                AbstractC0573a.b(parcel);
                zab(zakVar);
                break;
            case 9:
                AbstractC0573a.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
