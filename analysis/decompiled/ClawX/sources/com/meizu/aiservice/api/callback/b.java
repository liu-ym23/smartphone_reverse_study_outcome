package com.meizu.aiservice.api.callback;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b extends Binder implements c {
    static final int TRANSACTION_onCall = 1;

    public static c asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.meizu.aiservice.api.callback.IBundleCallback");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof c)) {
            return (c) iInterfaceQueryLocalInterface;
        }
        a aVar = new a();
        aVar.f1545a = iBinder;
        return aVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 >= 1 && i8 <= 16777215) {
            parcel.enforceInterface("com.meizu.aiservice.api.callback.IBundleCallback");
        }
        if (i8 == 1598968902) {
            parcel2.writeString("com.meizu.aiservice.api.callback.IBundleCallback");
            return true;
        }
        if (i8 != 1) {
            return super.onTransact(i8, parcel, parcel2, i9);
        }
        onCall((Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
        parcel2.writeNoException();
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
