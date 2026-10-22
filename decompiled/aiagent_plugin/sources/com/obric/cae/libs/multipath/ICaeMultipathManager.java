package com.obric.cae.libs.multipath;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeMultipathManager extends IInterface {

    public static class Default implements ICaeMultipathManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public String getLatestNetworkTruth() {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantFailure() {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantOperateApps(int[] r1) {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportMPAConnectionQuality(String r1, int r2, int r3, int r4, int r5, int r6) {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportPathCtlModeChanged(String r1, int r2) {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void setICaeMultipathCallback(ICaeMultipathCallback r2) {
            ICaeMultipathCallback r1 = (ICaeMultipathCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICaeMultipathCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void startMultipath() {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void stopMultipath() {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void unsetICaeMultipathCallback() {
        }
    }

    public static abstract class Stub extends Binder implements ICaeMultipathManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.multipath.ICaeMultipathManager";
        static final int TRANSACTION_getLatestNetworkTruth = 7;
        static final int TRANSACTION_reportAssistantFailure = 8;
        static final int TRANSACTION_reportAssistantOperateApps = 9;
        static final int TRANSACTION_reportMPAConnectionQuality = 3;
        static final int TRANSACTION_reportPathCtlModeChanged = 6;
        static final int TRANSACTION_setICaeMultipathCallback = 4;
        static final int TRANSACTION_startMultipath = 1;
        static final int TRANSACTION_stopMultipath = 2;
        static final int TRANSACTION_unsetICaeMultipathCallback = 5;

        public static class Proxy implements ICaeMultipathManager {
            public static ICaeMultipathManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public String getLatestNetworkTruth() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r4 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r5 = Stub.getDefaultImpl().getLatestNetworkTruth();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportAssistantFailure() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportAssistantFailure();     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportAssistantOperateApps(int[] r5) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeIntArray(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r0, null, 1) == false) goto L6;
            L10:
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportAssistantOperateApps(r5);     // Catch: Throwable -> L12
                r0.recycle();
                return;
            L12:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportMPAConnectionQuality(String r10, int r11, int r12, int r13, int r14, int r15) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeInt(r12);     // Catch: Throwable -> L13
                r0.writeInt(r13);     // Catch: Throwable -> L13
                r0.writeInt(r14);     // Catch: Throwable -> L13
                r0.writeInt(r15);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportMPAConnectionQuality(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportPathCtlModeChanged(String r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r5);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportPathCtlModeChanged(r5, r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void setICaeMultipathCallback(ICaeMultipathCallback r5) {
                ICaeMultipathCallback r6 = (ICaeMultipathCallback) ZeusTransformUtils.wrapperContextForParams(r5, ICaeMultipathCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setICaeMultipathCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void startMultipath() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().startMultipath();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void stopMultipath() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().stopMultipath();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void unsetICaeMultipathCallback() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unsetICaeMultipathCallback();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
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

        public static ICaeMultipathManager asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICaeMultipathManager.class) == false) goto L13;
            return (ICaeMultipathManager) ZeusTransformUtils.preCheckCast(r0, ICaeMultipathManager.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICaeMultipathManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeMultipathManager r2) {
            ICaeMultipathManager r3 = (ICaeMultipathManager) ZeusTransformUtils.wrapperContextForParams(r2, ICaeMultipathManager.class, "com.obric.aiagent.plugin");
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
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) {
            if (r9 == 1598968902) goto L25;
            switch(r9) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L15;
                case 6: goto L13;
                case 7: goto L11;
                case 8: goto L9;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r10.enforceInterface(DESCRIPTOR);
            reportAssistantOperateApps(r10.createIntArray());
            return true;
        L9:
            r10.enforceInterface(DESCRIPTOR);
            reportAssistantFailure();
            return true;
        L11:
            r10.enforceInterface(DESCRIPTOR);
            String r8 = getLatestNetworkTruth();
            r11.writeNoException();
            r11.writeString(r8);
            return true;
        L13:
            r10.enforceInterface(DESCRIPTOR);
            reportPathCtlModeChanged(r10.readString(), r10.readInt());
            r11.writeNoException();
            return true;
        L15:
            r10.enforceInterface(DESCRIPTOR);
            unsetICaeMultipathCallback();
            r11.writeNoException();
            return true;
        L17:
            r10.enforceInterface(DESCRIPTOR);
            setICaeMultipathCallback(ICaeMultipathCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L19:
            r10.enforceInterface(DESCRIPTOR);
            reportMPAConnectionQuality(r10.readString(), r10.readInt(), r10.readInt(), r10.readInt(), r10.readInt(), r10.readInt());
            r11.writeNoException();
            return true;
        L21:
            r10.enforceInterface(DESCRIPTOR);
            stopMultipath();
            r11.writeNoException();
            return true;
        L23:
            r10.enforceInterface(DESCRIPTOR);
            startMultipath();
            r11.writeNoException();
            return true;
        L6:
            return super.onTransact(r9, r10, r11, r12);
        L25:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getLatestNetworkTruth();

    void reportAssistantFailure();

    void reportAssistantOperateApps(int[] r1);

    void reportMPAConnectionQuality(String r1, int r2, int r3, int r4, int r5, int r6);

    void reportPathCtlModeChanged(String r1, int r2);

    void setICaeMultipathCallback(ICaeMultipathCallback r1);

    void startMultipath();

    void stopMultipath();

    void unsetICaeMultipathCallback();
}
