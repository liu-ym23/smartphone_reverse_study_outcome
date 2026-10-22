package com.obric.cae.libs.multipath;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeMultipathManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.multipath.ICaeMultipathManager";

    public static class Default implements ICaeMultipathManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public String getLatestNetworkTruth() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantFailure() throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportAssistantOperateApps(int[] r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportMPAConnectionQuality(String r1, int r2, int r3, int r4, int r5, int r6) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void reportPathCtlModeChanged(String r1, int r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void setICaeMultipathCallback(ICaeMultipathCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void startMultipath() throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void stopMultipath() throws RemoteException {
        }

        @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
        public void unsetICaeMultipathCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeMultipathManager {
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
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeMultipathManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public String getLatestNetworkTruth() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMultipathManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r2 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportAssistantFailure() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMultipathManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportAssistantOperateApps(int[] r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMultipathManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeIntArray(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportMPAConnectionQuality(String r4, int r5, int r6, int r7, int r8, int r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMultipathManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                r0.writeInt(r8);     // Catch: Throwable -> L6
                r0.writeInt(r9);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void reportPathCtlModeChanged(String r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMultipathManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void setICaeMultipathCallback(ICaeMultipathCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMultipathManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void startMultipath() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMultipathManager.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void stopMultipath() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMultipathManager.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.multipath.ICaeMultipathManager
            public void unsetICaeMultipathCallback() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeMultipathManager.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, ICaeMultipathManager.DESCRIPTOR);
        }

        public static ICaeMultipathManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeMultipathManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeMultipathManager) == false) goto L12;
            return (ICaeMultipathManager) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(ICaeMultipathManager.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L22;
            switch(r10) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                default: goto L11;
            };
        L12:
            reportAssistantOperateApps(r11.createIntArray());
        L21:
            return true;
        L13:
            reportAssistantFailure();
            goto L21
        L14:
            String r14 = getLatestNetworkTruth();
            r12.writeNoException();
            r12.writeString(r14);
            goto L21
        L15:
            reportPathCtlModeChanged(r11.readString(), r11.readInt());
            r12.writeNoException();
            goto L21
        L16:
            unsetICaeMultipathCallback();
            r12.writeNoException();
            goto L21
        L17:
            setICaeMultipathCallback(ICaeMultipathCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            goto L21
        L18:
            reportMPAConnectionQuality(r11.readString(), r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt());
            r12.writeNoException();
            goto L21
        L19:
            stopMultipath();
            r12.writeNoException();
            goto L21
        L20:
            startMultipath();
            r12.writeNoException();
            goto L21
        L11:
            return super.onTransact(r10, r11, r12, r13);
        L22:
            r12.writeString(ICaeMultipathManager.DESCRIPTOR);
            return true;
        }
    }

    String getLatestNetworkTruth() throws RemoteException;

    void reportAssistantFailure() throws RemoteException;

    void reportAssistantOperateApps(int[] r1) throws RemoteException;

    void reportMPAConnectionQuality(String r1, int r2, int r3, int r4, int r5, int r6) throws RemoteException;

    void reportPathCtlModeChanged(String r1, int r2) throws RemoteException;

    void setICaeMultipathCallback(ICaeMultipathCallback r1) throws RemoteException;

    void startMultipath() throws RemoteException;

    void stopMultipath() throws RemoteException;

    void unsetICaeMultipathCallback() throws RemoteException;
}
