package com.obric.capabilitykit.entity.search;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IEntityChangeCallback extends IInterface {

    public static abstract class a extends Binder implements IEntityChangeCallback {
        public a() {
            attachInterface(this, "com.obric.capabilitykit.entity.search.IEntityChangeCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.obric.capabilitykit.entity.search.IEntityChangeCallback");
            if (r11.readInt() == 0) goto L18;
            EntityChangeResult r14 = EntityChangeResult.CREATOR.createFromParcel(r11);
        L19:
            onChange(r14);
        L13:
            r12.writeNoException();
            return true;
        L18:
            r14 = null;
            goto L19
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface("com.obric.capabilitykit.entity.search.IEntityChangeCallback");
            onError(r11.readInt(), r11.readString());
            goto L13
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString("com.obric.capabilitykit.entity.search.IEntityChangeCallback");
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void onChange(EntityChangeResult r10) throws RemoteException;

    void onError(int r10, String r11) throws RemoteException;
}
