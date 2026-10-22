package com.obric.cae.libs.multipath;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeMultipathCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.multipath.ICaeMultipathCallback";

    public static class Default implements ICaeMultipathCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathCallback
        public boolean changePathCtlAction(String r1, int r2) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeMultipathCallback {
        static final int TRANSACTION_changePathCtlAction = 1;

        public static class Proxy implements ICaeMultipathCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathCallback
            public boolean changePathCtlAction(String r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMultipathCallback.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeString(r4);     // Catch: Throwable -> L8
                r0.writeInt(r5);     // Catch: Throwable -> L8
                boolean r6 = false;
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r6 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r6;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return ICaeMultipathCallback.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, ICaeMultipathCallback.DESCRIPTOR);
        }

        public static ICaeMultipathCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeMultipathCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeMultipathCallback) == false) goto L12;
            return (ICaeMultipathCallback) r0;
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
            r5.enforceInterface(ICaeMultipathCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            boolean r8 = changePathCtlAction(r5.readString(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString(ICaeMultipathCallback.DESCRIPTOR);
            return true;
        }
    }

    boolean changePathCtlAction(String r1, int r2) throws RemoteException;
}
