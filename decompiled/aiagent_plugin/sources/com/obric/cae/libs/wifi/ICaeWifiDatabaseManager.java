package com.obric.cae.libs.wifi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeWifiDatabaseManager extends IInterface {

    public static class Default implements ICaeWifiDatabaseManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getCountByBssidAndRssi(String r1, int r2) {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getThroughputByBssidAndRssi(String r1, int r2) {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getTriggerScanTput() {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
        public int getWifiQoeScore() {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeWifiDatabaseManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeWifiDatabaseManager";
        static final int TRANSACTION_getCountByBssidAndRssi = 2;
        static final int TRANSACTION_getThroughputByBssidAndRssi = 1;
        static final int TRANSACTION_getTriggerScanTput = 3;
        static final int TRANSACTION_getWifiQoeScore = 4;

        public static class Proxy implements ICaeWifiDatabaseManager {
            public static ICaeWifiDatabaseManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getCountByBssidAndRssi(String r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().getCountByBssidAndRssi(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getThroughputByBssidAndRssi(String r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r7 = Stub.getDefaultImpl().getThroughputByBssidAndRssi(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getTriggerScanTput() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getTriggerScanTput();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiDatabaseManager
            public int getWifiQoeScore() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getWifiQoeScore();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeWifiDatabaseManager asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICaeWifiDatabaseManager.class) == false) goto L13;
            return (ICaeWifiDatabaseManager) ZeusTransformUtils.preCheckCast(r0, ICaeWifiDatabaseManager.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICaeWifiDatabaseManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeWifiDatabaseManager r2) {
            ICaeWifiDatabaseManager r3 = (ICaeWifiDatabaseManager) ZeusTransformUtils.wrapperContextForParams(r2, ICaeWifiDatabaseManager.class, "com.obric.aiagent.plugin");
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
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L21;
            if (r4 != 1) goto L6;
            r5.enforceInterface(DESCRIPTOR);
            int r3 = getThroughputByBssidAndRssi(r5.readString(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r3);
            return true;
        L6:
            if (r4 != 2) goto L8;
            r5.enforceInterface(DESCRIPTOR);
            int r8 = getCountByBssidAndRssi(r5.readString(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r8);
            return true;
        L8:
            if (r4 != 3) goto L10;
            r5.enforceInterface(DESCRIPTOR);
            int r9 = getTriggerScanTput();
            r6.writeNoException();
            r6.writeInt(r9);
            return true;
        L10:
            if (r4 != 4) goto L12;
            r5.enforceInterface(DESCRIPTOR);
            int r10 = getWifiQoeScore();
            r6.writeNoException();
            r6.writeInt(r10);
            return true;
        L12:
            return super.onTransact(r4, r5, r6, r7);
        L21:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getCountByBssidAndRssi(String r1, int r2);

    int getThroughputByBssidAndRssi(String r1, int r2);

    int getTriggerScanTput();

    int getWifiQoeScore();
}
