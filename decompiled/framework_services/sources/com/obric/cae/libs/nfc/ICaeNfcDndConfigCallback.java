package com.obric.cae.libs.nfc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeNfcDndConfigCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcDndConfigCallback";

    public static class Default implements ICaeNfcDndConfigCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcDndConfigCallback
        public void onDndConfigChanged(boolean r1, int r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcDndConfigCallback {
        static final int TRANSACTION_onDndConfigChanged = 1;

        public static class Proxy implements ICaeNfcDndConfigCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeNfcDndConfigCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcDndConfigCallback
            public void onDndConfigChanged(boolean r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcDndConfigCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeNfcDndConfigCallback.DESCRIPTOR);
        }

        public static ICaeNfcDndConfigCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeNfcDndConfigCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNfcDndConfigCallback) == false) goto L12;
            return (ICaeNfcDndConfigCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(ICaeNfcDndConfigCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L18;
            if (r4 == 1) goto L13;
            return super.onTransact(r4, r5, r6, r7);
        L13:
            if (r5.readInt() == 0) goto L15;
            boolean r8 = true;
        L16:
            onDndConfigChanged(r8, r5.readInt());
            r6.writeNoException();
            return true;
        L15:
            r8 = false;
            goto L16
        L18:
            r6.writeString(ICaeNfcDndConfigCallback.DESCRIPTOR);
            return true;
        }
    }

    void onDndConfigChanged(boolean r1, int r2) throws RemoteException;
}
