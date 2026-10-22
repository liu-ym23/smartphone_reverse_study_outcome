package com.obric.cae.libs.nfc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeNfcAdapter extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcAdapter";

    public static class Default implements ICaeNfcAdapter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
        public ICaeNfcEventManager getEventManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
        public ICaeNfcOmapiExecutor getOmapiExecutor() throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcAdapter {
        static final int TRANSACTION_getEventManager = 2;
        static final int TRANSACTION_getOmapiExecutor = 1;

        public static class Proxy implements ICaeNfcAdapter {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
            public ICaeNfcEventManager getEventManager() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcAdapter.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ICaeNfcEventManager r2 = ICaeNfcEventManager.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return ICaeNfcAdapter.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcAdapter
            public ICaeNfcOmapiExecutor getOmapiExecutor() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNfcAdapter.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ICaeNfcOmapiExecutor r2 = ICaeNfcOmapiExecutor.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeNfcAdapter.DESCRIPTOR);
        }

        public static ICaeNfcAdapter asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeNfcAdapter.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNfcAdapter) == false) goto L12;
            return (ICaeNfcAdapter) r0;
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
            r5.enforceInterface(ICaeNfcAdapter.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            if (r4 != 1) goto L11;
            ICaeNfcOmapiExecutor r8 = getOmapiExecutor();
            r6.writeNoException();
            r6.writeStrongInterface(r8);
        L16:
            return true;
        L11:
            if (r4 != 2) goto L13;
            ICaeNfcEventManager r9 = getEventManager();
            r6.writeNoException();
            r6.writeStrongInterface(r9);
            goto L16
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(ICaeNfcAdapter.DESCRIPTOR);
            return true;
        }
    }

    ICaeNfcEventManager getEventManager() throws RemoteException;

    ICaeNfcOmapiExecutor getOmapiExecutor() throws RemoteException;
}
