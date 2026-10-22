package com.obric.capabilitykit.entity.search;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IInAppSearchCallback extends IInterface {

    public static class Default implements IInAppSearchCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
        public void onCompleted() throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
        public void onError(int r1, String r2) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
        public void onSearchResult(InAppSearchResult r1) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
        public void onSearchResultWithoutEntity(InAppSearchResultWithoutEntity r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IInAppSearchCallback {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.entity.search.IInAppSearchCallback";
        public static final int TRANSACTION_onCompleted = 2;
        public static final int TRANSACTION_onError = 3;
        public static final int TRANSACTION_onSearchResult = 1;
        public static final int TRANSACTION_onSearchResultWithoutEntity = 4;

        public static class Proxy implements IInAppSearchCallback {
            public static IInAppSearchCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onCompleted() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onCompleted();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onError(int r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onError(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onSearchResult(InAppSearchResult r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSearchResult(r5);     // Catch: Throwable -> L16
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchCallback
            public void onSearchResultWithoutEntity(InAppSearchResultWithoutEntity r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSearchResultWithoutEntity(r5);     // Catch: Throwable -> L16
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInAppSearchCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IInAppSearchCallback) == false) goto L12;
            return (IInAppSearchCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static IInAppSearchCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IInAppSearchCallback r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            if (r5 == 1598968902) goto L26;
            InAppSearchResult r0 = null;
            InAppSearchResultWithoutEntity r1 = null;
            if (r5 != 1) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L25;
            r0 = InAppSearchResult.CREATOR.createFromParcel(r6);
        L25:
            onSearchResult(r0);
        L18:
            r7.writeNoException();
            return true;
        L7:
            if (r5 != 2) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            onCompleted();
            goto L18
        L9:
            if (r5 != 3) goto L11;
            r6.enforceInterface(DESCRIPTOR);
            onError(r6.readInt(), r6.readString());
            goto L18
        L11:
            if (r5 != 4) goto L13;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L17;
            r1 = InAppSearchResultWithoutEntity.CREATOR.createFromParcel(r6);
        L17:
            onSearchResultWithoutEntity(r1);
            goto L18
        L13:
            return super.onTransact(r5, r6, r7, r8);
        L26:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onCompleted() throws RemoteException;

    void onError(int r1, String r2) throws RemoteException;

    void onSearchResult(InAppSearchResult r1) throws RemoteException;

    void onSearchResultWithoutEntity(InAppSearchResultWithoutEntity r1) throws RemoteException;
}
