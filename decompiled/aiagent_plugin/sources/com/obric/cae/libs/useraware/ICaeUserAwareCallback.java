package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeUserAwareCallback extends IInterface {

    public static class Default implements ICaeUserAwareCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onCellInfoChange(CellAwareInfo r1) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onCellNeighbourInfoChange(List<CellAwareInfo> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onInSubWayChange(int r1, String r2) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onUserAwareReportData(String r1, String r2) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiConnectInfoChanged(WifiStandardData r1) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiNetworkAvailable(boolean r1) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiScanInfoChanged(List<WifiStandardData> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }
    }

    public static abstract class Stub extends Binder implements ICaeUserAwareCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.useraware.ICaeUserAwareCallback";
        static final int TRANSACTION_onCellInfoChange = 4;
        static final int TRANSACTION_onCellNeighbourInfoChange = 5;
        static final int TRANSACTION_onInSubWayChange = 7;
        static final int TRANSACTION_onUserAwareReportData = 6;
        static final int TRANSACTION_onWifiConnectInfoChanged = 2;
        static final int TRANSACTION_onWifiNetworkAvailable = 3;
        static final int TRANSACTION_onWifiScanInfoChanged = 1;

        public static class Proxy implements ICaeUserAwareCallback {
            public static ICaeUserAwareCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onCellInfoChange(CellAwareInfo r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(4, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onCellInfoChange(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onCellNeighbourInfoChange(List<CellAwareInfo> r5) {
                List<CellAwareInfo> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(5, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onCellNeighbourInfoChange(r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onInSubWayChange(int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onInSubWayChange(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onUserAwareReportData(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onUserAwareReportData(r5, r6);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiConnectInfoChanged(WifiStandardData r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onWifiConnectInfoChanged(r5);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiNetworkAvailable(boolean r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onWifiNetworkAvailable(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiScanInfoChanged(List<WifiStandardData> r4) {
                List<WifiStandardData> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onWifiScanInfoChanged(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeUserAwareCallback asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICaeUserAwareCallback.class) == false) goto L13;
            return (ICaeUserAwareCallback) ZeusTransformUtils.preCheckCast(r0, ICaeUserAwareCallback.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICaeUserAwareCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeUserAwareCallback r2) {
            ICaeUserAwareCallback r3 = (ICaeUserAwareCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICaeUserAwareCallback.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L32;
            WifiStandardData r3 = null;
            CellAwareInfo r4 = null;
            switch(r5) {
                case 1: goto L30;
                case 2: goto L25;
                case 3: goto L19;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            onInSubWayChange(r6.readInt(), r6.readString());
            return true;
        L10:
            r6.enforceInterface(DESCRIPTOR);
            onUserAwareReportData(r6.readString(), r6.readString());
            return true;
        L12:
            r6.enforceInterface(DESCRIPTOR);
            onCellNeighbourInfoChange(r6.createTypedArrayList(CellAwareInfo.CREATOR));
            return true;
        L14:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L17;
            r4 = (CellAwareInfo) ZeusTransformUtils.preCheckCast(CellAwareInfo.CREATOR.createFromParcel(r6), CellAwareInfo.class, "com.obric.aiagent.plugin");
        L17:
            onCellInfoChange(r4);
            return true;
        L19:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L22;
            boolean r9 = true;
        L23:
            onWifiNetworkAvailable(r9);
            return true;
        L22:
            r9 = false;
            goto L23
        L25:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L28;
            r3 = (WifiStandardData) ZeusTransformUtils.preCheckCast(WifiStandardData.CREATOR.createFromParcel(r6), WifiStandardData.class, "com.obric.aiagent.plugin");
        L28:
            onWifiConnectInfoChanged(r3);
            return true;
        L30:
            r6.enforceInterface(DESCRIPTOR);
            onWifiScanInfoChanged(r6.createTypedArrayList(WifiStandardData.CREATOR));
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L32:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onCellInfoChange(CellAwareInfo r1);

    void onCellNeighbourInfoChange(List<CellAwareInfo> r1);

    void onInSubWayChange(int r1, String r2);

    void onUserAwareReportData(String r1, String r2);

    void onWifiConnectInfoChanged(WifiStandardData r1);

    void onWifiNetworkAvailable(boolean r1);

    void onWifiScanInfoChanged(List<WifiStandardData> r1);
}
