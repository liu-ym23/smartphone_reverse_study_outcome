package com.obric.cae.libs.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeNetworkHandoverListener extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.network.ICaeNetworkHandoverListener";

    public static class Default implements ICaeNetworkHandoverListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverListener
        public void notifyNetworkExitingPolicyUpdate(int r1, boolean r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverListener
        public void notifyNetworkTestedResult(int r1, int r2, String r3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNetworkHandoverListener {
        static final int TRANSACTION_notifyNetworkExitingPolicyUpdate = 2;
        static final int TRANSACTION_notifyNetworkTestedResult = 1;

        public static class Proxy implements ICaeNetworkHandoverListener {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeNetworkHandoverListener.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.network.ICaeNetworkHandoverListener
            public void notifyNetworkExitingPolicyUpdate(int r4, boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNetworkHandoverListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.network.ICaeNetworkHandoverListener
            public void notifyNetworkTestedResult(int r4, int r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNetworkHandoverListener.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
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
            attachInterface(this, ICaeNetworkHandoverListener.DESCRIPTOR);
        }

        public static ICaeNetworkHandoverListener asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeNetworkHandoverListener.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNetworkHandoverListener) == false) goto L12;
            return (ICaeNetworkHandoverListener) r0;
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
            r5.enforceInterface(ICaeNetworkHandoverListener.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L21;
            if (r4 != 1) goto L11;
            notifyNetworkTestedResult(r5.readInt(), r5.readInt(), r5.readString());
            r6.writeNoException();
        L20:
            return true;
        L11:
            if (r4 != 2) goto L13;
            int r8 = r5.readInt();
            if (r5.readInt() == 0) goto L17;
            boolean r9 = true;
        L18:
            notifyNetworkExitingPolicyUpdate(r8, r9);
            r6.writeNoException();
            goto L20
        L17:
            r9 = false;
            goto L18
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L21:
            r6.writeString(ICaeNetworkHandoverListener.DESCRIPTOR);
            return true;
        }
    }

    void notifyNetworkExitingPolicyUpdate(int r1, boolean r2) throws RemoteException;

    void notifyNetworkTestedResult(int r1, int r2, String r3) throws RemoteException;
}
