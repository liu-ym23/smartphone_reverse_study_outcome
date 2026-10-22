package com.obric.cae.libs.wifi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeWifiAdapter extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeWifiAdapter";

    public static class Default implements ICaeWifiAdapter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public int getRoamRssiThreshold(int r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public boolean setLatencyLevel(int r1, int r2) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public boolean setRoamRssiThreshold(int r1, int r2) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeWifiAdapter {
        static final int TRANSACTION_getRoamRssiThreshold = 3;
        static final int TRANSACTION_setLatencyLevel = 1;
        static final int TRANSACTION_setRoamRssiThreshold = 2;

        public static class Proxy implements ICaeWifiAdapter {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeWifiAdapter.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public int getRoamRssiThreshold(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeWifiAdapter.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r6 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r6;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public boolean setLatencyLevel(int r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeWifiAdapter.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeInt(r4);     // Catch: Throwable -> L8
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

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public boolean setRoamRssiThreshold(int r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeWifiAdapter.DESCRIPTOR);     // Catch: Throwable -> L8
                r0.writeInt(r4);     // Catch: Throwable -> L8
                r0.writeInt(r5);     // Catch: Throwable -> L8
                boolean r2 = false;
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r2 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeWifiAdapter.DESCRIPTOR);
        }

        public static ICaeWifiAdapter asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeWifiAdapter.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeWifiAdapter) == false) goto L12;
            return (ICaeWifiAdapter) r0;
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
            r5.enforceInterface(ICaeWifiAdapter.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L20;
            if (r4 != 1) goto L11;
            boolean r8 = setLatencyLevel(r5.readInt(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
        L19:
            return true;
        L11:
            if (r4 != 2) goto L13;
            boolean r9 = setRoamRssiThreshold(r5.readInt(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            goto L19
        L13:
            if (r4 != 3) goto L15;
            int r10 = getRoamRssiThreshold(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r10);
            goto L19
        L15:
            return super.onTransact(r4, r5, r6, r7);
        L20:
            r6.writeString(ICaeWifiAdapter.DESCRIPTOR);
            return true;
        }
    }

    int getRoamRssiThreshold(int r1) throws RemoteException;

    boolean setLatencyLevel(int r1, int r2) throws RemoteException;

    boolean setRoamRssiThreshold(int r1, int r2) throws RemoteException;
}
