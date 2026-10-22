package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import g1.AbstractC0573a;

/* loaded from: classes.dex */
public interface IStatusCallback extends IInterface {

    public static abstract class Stub extends zab implements IStatusCallback {
        public Stub() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @NonNull
        public static IStatusCallback asInterface(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return iInterfaceQueryLocalInterface instanceof IStatusCallback ? (IStatusCallback) iInterfaceQueryLocalInterface : new zaby(iBinder);
        }

        @Override // com.google.android.gms.internal.base.zab
        public final boolean zaa(int i4, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1) {
                return false;
            }
            Status status = (Status) AbstractC0573a.a(parcel, Status.CREATOR);
            AbstractC0573a.b(parcel);
            onResult(status);
            return true;
        }
    }

    void onResult(@NonNull Status status) throws RemoteException;
}
