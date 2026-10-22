package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeUserAwareCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.useraware.ICaeUserAwareCallback";

    public static class Default implements ICaeUserAwareCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onCellInfoChange(CellAwareInfo r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onCellNeighbourInfoChange(List<CellAwareInfo> r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onInSubWayChange(int r1, String r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onUserAwareReportData(String r1, String r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiConnectInfoChanged(WifiStandardData r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiNetworkAvailable(boolean r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiScanInfoChanged(List<WifiStandardData> r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeUserAwareCallback {
        static final int TRANSACTION_onCellInfoChange = 4;
        static final int TRANSACTION_onCellNeighbourInfoChange = 5;
        static final int TRANSACTION_onInSubWayChange = 7;
        static final int TRANSACTION_onUserAwareReportData = 6;
        static final int TRANSACTION_onWifiConnectInfoChanged = 2;
        static final int TRANSACTION_onWifiNetworkAvailable = 3;
        static final int TRANSACTION_onWifiScanInfoChanged = 1;

        public static class Proxy implements ICaeUserAwareCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeUserAwareCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onCellInfoChange(CellAwareInfo r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAwareCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(4, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onCellNeighbourInfoChange(List<CellAwareInfo> r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAwareCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeTypedList(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onInSubWayChange(int r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAwareCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onUserAwareReportData(String r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAwareCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiConnectInfoChanged(WifiStandardData r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAwareCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiNetworkAvailable(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAwareCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiScanInfoChanged(List<WifiStandardData> r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAwareCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeTypedList(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeUserAwareCallback.DESCRIPTOR);
        }

        public static ICaeUserAwareCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeUserAwareCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeUserAwareCallback) == false) goto L12;
            return (ICaeUserAwareCallback) r0;
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
            r5.enforceInterface(ICaeUserAwareCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L24;
            switch(r4) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                default: goto L11;
            };
        L12:
            onInSubWayChange(r5.readInt(), r5.readString());
        L23:
            return true;
        L13:
            onUserAwareReportData(r5.readString(), r5.readString());
            goto L23
        L14:
            onCellNeighbourInfoChange(r5.createTypedArrayList(CellAwareInfo.CREATOR));
            goto L23
        L15:
            onCellInfoChange((CellAwareInfo) _Parcel.a(r5, CellAwareInfo.CREATOR));
            goto L23
        L21:
            onWifiConnectInfoChanged((WifiStandardData) _Parcel.a(r5, WifiStandardData.CREATOR));
            goto L23
        L22:
            onWifiScanInfoChanged(r5.createTypedArrayList(WifiStandardData.CREATOR));
            goto L23
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            if (r5.readInt() == 0) goto L19;
            boolean r8 = true;
        L20:
            onWifiNetworkAvailable(r8);
            goto L23
        L19:
            r8 = false;
            goto L20
        L24:
            r6.writeString(ICaeUserAwareCallback.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static Object a(Parcel r1, Parcelable.Creator r2) {
            if (r1.readInt() != 0) goto L7;
            return null;
        L7:
            return r2.createFromParcel(r1);
        }
    }

    void onCellInfoChange(CellAwareInfo r1) throws RemoteException;

    void onCellNeighbourInfoChange(List<CellAwareInfo> r1) throws RemoteException;

    void onInSubWayChange(int r1, String r2) throws RemoteException;

    void onUserAwareReportData(String r1, String r2) throws RemoteException;

    void onWifiConnectInfoChanged(WifiStandardData r1) throws RemoteException;

    void onWifiNetworkAvailable(boolean r1) throws RemoteException;

    void onWifiScanInfoChanged(List<WifiStandardData> r1) throws RemoteException;
}
