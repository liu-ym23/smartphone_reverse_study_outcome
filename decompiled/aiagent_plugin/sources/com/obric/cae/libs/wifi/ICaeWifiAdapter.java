package com.obric.cae.libs.wifi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeWifiAdapter extends IInterface {

    public static class Default implements ICaeWifiAdapter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public int getRoamRssiThreshold(int r1) {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public boolean setLatencyLevel(int r1, int r2) {
            return false;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
        public boolean setRoamRssiThreshold(int r1, int r2) {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeWifiAdapter {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeWifiAdapter";
        static final int TRANSACTION_getRoamRssiThreshold = 3;
        static final int TRANSACTION_setLatencyLevel = 1;
        static final int TRANSACTION_setRoamRssiThreshold = 2;

        public static class Proxy implements ICaeWifiAdapter {
            public static ICaeWifiAdapter sDefaultImpl;
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

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public int getRoamRssiThreshold(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r6 = Stub.getDefaultImpl().getRoamRssiThreshold(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r6;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public boolean setLatencyLevel(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                boolean r2 = false;
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r2 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().setLatencyLevel(r5, r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeWifiAdapter
            public boolean setRoamRssiThreshold(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                r0.writeInt(r6);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r3 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r3;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r4 = Stub.getDefaultImpl().setRoamRssiThreshold(r5, r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeWifiAdapter asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICaeWifiAdapter.class) == false) goto L13;
            return (ICaeWifiAdapter) ZeusTransformUtils.preCheckCast(r0, ICaeWifiAdapter.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICaeWifiAdapter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeWifiAdapter r2) {
            ICaeWifiAdapter r3 = (ICaeWifiAdapter) ZeusTransformUtils.wrapperContextForParams(r2, ICaeWifiAdapter.class, "com.obric.aiagent.plugin");
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
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            boolean r3 = setLatencyLevel(r5.readInt(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r3 ? 1 : 0);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = setRoamRssiThreshold(r5.readInt(), r5.readInt());
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            int r9 = getRoamRssiThreshold(r5.readInt());
            r6.writeNoException();
            r6.writeInt(r9);
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    int getRoamRssiThreshold(int r1);

    boolean setLatencyLevel(int r1, int r2);

    boolean setRoamRssiThreshold(int r1, int r2);
}
