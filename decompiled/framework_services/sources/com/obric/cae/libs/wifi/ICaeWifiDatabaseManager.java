package com.obric.cae.libs.wifi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeWifiDatabaseManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeWifiDatabaseManager";

    public static class Default implements ICaeWifiDatabaseManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getCountByBssidAndRssi(String r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getThroughputByBssidAndRssi(String r1, int r2) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getTriggerScanTput() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getWifiQoeScore() throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeWifiDatabaseManager {
        static final int TRANSACTION_getCountByBssidAndRssi = 2;
        static final int TRANSACTION_getThroughputByBssidAndRssi = 1;
        static final int TRANSACTION_getTriggerScanTput = 3;
        static final int TRANSACTION_getWifiQoeScore = 4;

        public static class Proxy implements ICaeWifiDatabaseManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getCountByBssidAndRssi(String r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeWifiDatabaseManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
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

            public String getInterfaceDescriptor() {
                return ICaeWifiDatabaseManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getThroughputByBssidAndRssi(String r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeWifiDatabaseManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getTriggerScanTput() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeWifiDatabaseManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r2 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getWifiQoeScore() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeWifiDatabaseManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r2 = r1.readInt();     // Catch: Throwable -> L6
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
            attachInterface(this, ICaeWifiDatabaseManager.DESCRIPTOR);
        }

        public static ICaeWifiDatabaseManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeWifiDatabaseManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeWifiDatabaseManager) == false) goto L12;
            return (ICaeWifiDatabaseManager) r0;
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
            r5.enforceInterface(ICaeWifiDatabaseManager.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            switch(r4) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                default: goto L11;
            };
        L12:
            int r8 = getWifiQoeScore();
            r6.writeNoException();
            r6.writeInt(r8);
        L16:
            return true;
        L13:
            int r9 = getTriggerScanTput();
            r6.writeNoException();
            r6.writeInt(r9);
            goto L16
        L14:
            int r10 = getCountByBssidAndRssi(r5.readString(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r10);
            goto L16
        L15:
            int r11 = getThroughputByBssidAndRssi(r5.readString(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r11);
            goto L16
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(ICaeWifiDatabaseManager.DESCRIPTOR);
            return true;
        }
    }

    int getCountByBssidAndRssi(String r1, int r2) throws RemoteException;

    int getThroughputByBssidAndRssi(String r1, int r2) throws RemoteException;

    int getTriggerScanTput() throws RemoteException;

    int getWifiQoeScore() throws RemoteException;
}
