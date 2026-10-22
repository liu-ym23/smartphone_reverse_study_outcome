package com.obric.capabilitykit.entity.search;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IInAppSearchCallback extends IInterface {

    public static abstract class a extends Binder implements IInAppSearchCallback {
        public a() {
            attachInterface(this, "com.obric.capabilitykit.entity.search.IInAppSearchCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L26;
            InAppSearchResult r14 = null;
            InAppSearchResultWithoutEntity r15 = null;
            if (r10 != 1) goto L7;
            r11.enforceInterface("com.obric.capabilitykit.entity.search.IInAppSearchCallback");
            if (r11.readInt() == 0) goto L25;
            r14 = InAppSearchResult.CREATOR.createFromParcel(r11);
        L25:
            onSearchResult(r14);
        L18:
            r12.writeNoException();
            return true;
        L7:
            if (r10 != 2) goto L9;
            r11.enforceInterface("com.obric.capabilitykit.entity.search.IInAppSearchCallback");
            onCompleted();
            goto L18
        L9:
            if (r10 != 3) goto L11;
            r11.enforceInterface("com.obric.capabilitykit.entity.search.IInAppSearchCallback");
            onError(r11.readInt(), r11.readString());
            goto L18
        L11:
            if (r10 != 4) goto L13;
            r11.enforceInterface("com.obric.capabilitykit.entity.search.IInAppSearchCallback");
            if (r11.readInt() == 0) goto L17;
            r15 = InAppSearchResultWithoutEntity.CREATOR.createFromParcel(r11);
        L17:
            onSearchResultWithoutEntity(r15);
            goto L18
        L13:
            return super.onTransact(r10, r11, r12, r13);
        L26:
            r12.writeString("com.obric.capabilitykit.entity.search.IInAppSearchCallback");
            return true;
        }
    }

    void onCompleted() throws RemoteException;

    void onError(int r10, String r11) throws RemoteException;

    void onSearchResult(InAppSearchResult r10) throws RemoteException;

    void onSearchResultWithoutEntity(InAppSearchResultWithoutEntity r10) throws RemoteException;
}
