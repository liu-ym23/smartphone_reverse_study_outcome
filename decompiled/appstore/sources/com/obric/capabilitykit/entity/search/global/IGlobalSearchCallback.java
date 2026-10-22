package com.obric.capabilitykit.entity.search.global;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IGlobalSearchCallback extends IInterface {

    public static abstract class a extends Binder implements IGlobalSearchCallback {
        public a() {
            attachInterface(this, "com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L23;
            if (r10 != 1) goto L6;
            r11.enforceInterface("com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback");
            if (r11.readInt() == 0) goto L21;
            GlobalSearchResult r14 = GlobalSearchResult.CREATOR.a(r11);
        L22:
            onSearchResult(r14);
        L14:
            r12.writeNoException();
            return true;
        L21:
            r14 = null;
            goto L22
        L6:
            if (r10 != 2) goto L8;
            r11.enforceInterface("com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback");
            onCompleted(r11.readInt());
            goto L14
        L8:
            if (r10 != 3) goto L10;
            r11.enforceInterface("com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback");
            onAllCompleted();
            goto L14
        L10:
            if (r10 != 4) goto L12;
            r11.enforceInterface("com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback");
            onError(r11.readInt(), r11.readInt(), r11.readString());
            goto L14
        L12:
            return super.onTransact(r10, r11, r12, r13);
        L23:
            r12.writeString("com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback");
            return true;
        }
    }

    void onAllCompleted() throws RemoteException;

    void onCompleted(int r10) throws RemoteException;

    void onError(int r10, int r11, String r12) throws RemoteException;

    void onSearchResult(GlobalSearchResult r10) throws RemoteException;
}
