package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzb;
import h1.AbstractC0588a;

/* loaded from: classes.dex */
public interface IAccountAccessor extends IInterface {

    public static abstract class Stub extends zzb implements IAccountAccessor {
        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        @NonNull
        public static IAccountAccessor asInterface(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new zzv(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int i4, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 2) {
                return false;
            }
            Account accountZzb = zzb();
            parcel2.writeNoException();
            int i6 = AbstractC0588a.f12690a;
            if (accountZzb == null) {
                parcel2.writeInt(0);
            } else {
                parcel2.writeInt(1);
                accountZzb.writeToParcel(parcel2, 1);
            }
            return true;
        }
    }

    @NonNull
    Account zzb() throws RemoteException;
}
