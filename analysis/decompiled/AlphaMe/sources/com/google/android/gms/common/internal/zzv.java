package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import h1.AbstractC0588a;

/* loaded from: classes.dex */
public final class zzv extends zza implements IAccountAccessor {
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() throws RemoteException {
        Parcel parcelZzB = zzB(2, zza());
        Account account = (Account) AbstractC0588a.a(parcelZzB, Account.CREATOR);
        parcelZzB.recycle();
        return account;
    }
}
