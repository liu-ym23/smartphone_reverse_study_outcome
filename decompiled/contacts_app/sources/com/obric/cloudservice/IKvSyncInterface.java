package com.obric.cloudservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IKvSyncInterface extends IInterface {

    public static class Default implements IKvSyncInterface {
        @Override // com.obric.cloudservice.IKvSyncInterface
        public void addSyncStateListener(String pkgName, ISyncStateListener listener) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public boolean getSwitchStatus(String pkgName) throws RemoteException {
            return false;
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public boolean getSyncSettingsStatus(String pkgName) throws RemoteException {
            return false;
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public int getSyncStatus(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public Bundle getUsedSpaceDetail(String pkgName) throws RemoteException {
            return null;
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public int init(String pkgName) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public void removeSyncStateListener(String pkgName, ISyncStateListener listener) throws RemoteException {
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public int setDeleted(String pkgName, String tableName) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public int setInserted(String pkgName, long dataId, String tableName) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public boolean setSwitchStatus(String pkgName, boolean enabled) throws RemoteException {
            return false;
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public int setUpdated(String pkgName, long dataId, String tableName) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cloudservice.IKvSyncInterface
        public int triggerSync(String pkgName, String syncSceneDesc) throws RemoteException {
            return 0;
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements IKvSyncInterface {
        private static final String DESCRIPTOR = "com.obric.cloudservice.IKvSyncInterface";
        static final int TRANSACTION_addSyncStateListener = 2;
        static final int TRANSACTION_getSwitchStatus = 9;
        static final int TRANSACTION_getSyncSettingsStatus = 11;
        static final int TRANSACTION_getSyncStatus = 7;
        static final int TRANSACTION_getUsedSpaceDetail = 12;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_removeSyncStateListener = 3;
        static final int TRANSACTION_setDeleted = 5;
        static final int TRANSACTION_setInserted = 4;
        static final int TRANSACTION_setSwitchStatus = 10;
        static final int TRANSACTION_setUpdated = 6;
        static final int TRANSACTION_triggerSync = 8;

        private static class Proxy implements IKvSyncInterface {
            public static IKvSyncInterface sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cloudservice.IKvSyncInterface
            public int init(String pkgName) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(pkgName);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().init(pkgName);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cloudservice.IKvSyncInterface
            public void addSyncStateListener(String pkgName, ISyncStateListener listener) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(pkgName);     // Catch: Throwable -> L17
                if (listener == null) goto L6;
                IBinder r2 = listener.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addSyncStateListener(pkgName, listener);     // Catch: Throwable -> L17
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

            @Override // com.obric.cloudservice.IKvSyncInterface
            public void removeSyncStateListener(String pkgName, ISyncStateListener listener) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(pkgName);     // Catch: Throwable -> L17
                if (listener == null) goto L6;
                IBinder r2 = listener.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeSyncStateListener(pkgName, listener);     // Catch: Throwable -> L17
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

            @Override // com.obric.cloudservice.IKvSyncInterface
            public int setInserted(String pkgName, long dataId, String tableName) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(pkgName);     // Catch: Throwable -> L13
                r0.writeLong(dataId);     // Catch: Throwable -> L13
                r0.writeString(tableName);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().setInserted(pkgName, dataId, tableName);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cloudservice.IKvSyncInterface
            public int setDeleted(String pkgName, String tableName) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(pkgName);     // Catch: Throwable -> L13
                r0.writeString(tableName);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().setDeleted(pkgName, tableName);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cloudservice.IKvSyncInterface
            public int setUpdated(String pkgName, long dataId, String tableName) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(pkgName);     // Catch: Throwable -> L13
                r0.writeLong(dataId);     // Catch: Throwable -> L13
                r0.writeString(tableName);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().setUpdated(pkgName, dataId, tableName);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cloudservice.IKvSyncInterface
            public int getSyncStatus(String pkgName) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(pkgName);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().getSyncStatus(pkgName);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cloudservice.IKvSyncInterface
            public int triggerSync(String pkgName, String syncSceneDesc) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(pkgName);     // Catch: Throwable -> L13
                r0.writeString(syncSceneDesc);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r4 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r5 = Stub.getDefaultImpl().triggerSync(pkgName, syncSceneDesc);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r5;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cloudservice.IKvSyncInterface
            public boolean getSwitchStatus(String pkgName) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(pkgName);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().getSwitchStatus(pkgName);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cloudservice.IKvSyncInterface
            public boolean setSwitchStatus(String pkgName, boolean enabled) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeString(pkgName);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (enabled == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L20
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r5 = Stub.getDefaultImpl().setSwitchStatus(pkgName, enabled);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r4 = 0;
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cloudservice.IKvSyncInterface
            public boolean getSyncSettingsStatus(String pkgName) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(pkgName);     // Catch: Throwable -> L15
                boolean r3 = false;
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
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
                boolean r4 = Stub.getDefaultImpl().getSyncSettingsStatus(pkgName);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r4;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cloudservice.IKvSyncInterface
            public Bundle getUsedSpaceDetail(String pkgName) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(pkgName);     // Catch: Throwable -> L17
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Bundle r4 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r5 = Stub.getDefaultImpl().getUsedSpaceDetail(pkgName);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IKvSyncInterface asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IKvSyncInterface) == false) goto L12;
            return (IKvSyncInterface) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            if (r5 == 1598968902) goto L38;
            boolean r0 = false;
            switch(r5) {
                case 1: goto L36;
                case 2: goto L34;
                case 3: goto L32;
                case 4: goto L30;
                case 5: goto L28;
                case 6: goto L26;
                case 7: goto L24;
                case 8: goto L22;
                case 9: goto L20;
                case 10: goto L15;
                case 11: goto L13;
                case 12: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            Bundle r4 = getUsedSpaceDetail(r6.readString());
            r7.writeNoException();
            if (r4 == null) goto L11;
            r7.writeInt(1);
            r4.writeToParcel(r7, 1);
        L12:
            return true;
        L11:
            r7.writeInt(0);
            goto L12
        L13:
            r6.enforceInterface(DESCRIPTOR);
            boolean r9 = getSyncSettingsStatus(r6.readString());
            r7.writeNoException();
            r7.writeInt(r9 ? 1 : 0);
            return true;
        L15:
            r6.enforceInterface(DESCRIPTOR);
            String r10 = r6.readString();
            if (r6.readInt() == 0) goto L18;
            r0 = true;
        L18:
            boolean r11 = setSwitchStatus(r10, r0);
            r7.writeNoException();
            r7.writeInt(r11 ? 1 : 0);
            return true;
        L20:
            r6.enforceInterface(DESCRIPTOR);
            boolean r12 = getSwitchStatus(r6.readString());
            r7.writeNoException();
            r7.writeInt(r12 ? 1 : 0);
            return true;
        L22:
            r6.enforceInterface(DESCRIPTOR);
            int r13 = triggerSync(r6.readString(), r6.readString());
            r7.writeNoException();
            r7.writeInt(r13);
            return true;
        L24:
            r6.enforceInterface(DESCRIPTOR);
            int r14 = getSyncStatus(r6.readString());
            r7.writeNoException();
            r7.writeInt(r14);
            return true;
        L26:
            r6.enforceInterface(DESCRIPTOR);
            int r15 = setUpdated(r6.readString(), r6.readLong(), r6.readString());
            r7.writeNoException();
            r7.writeInt(r15);
            return true;
        L28:
            r6.enforceInterface(DESCRIPTOR);
            int r16 = setDeleted(r6.readString(), r6.readString());
            r7.writeNoException();
            r7.writeInt(r16);
            return true;
        L30:
            r6.enforceInterface(DESCRIPTOR);
            int r17 = setInserted(r6.readString(), r6.readLong(), r6.readString());
            r7.writeNoException();
            r7.writeInt(r17);
            return true;
        L32:
            r6.enforceInterface(DESCRIPTOR);
            removeSyncStateListener(r6.readString(), ISyncStateListener.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L34:
            r6.enforceInterface(DESCRIPTOR);
            addSyncStateListener(r6.readString(), ISyncStateListener.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L36:
            r6.enforceInterface(DESCRIPTOR);
            int r18 = init(r6.readString());
            r7.writeNoException();
            r7.writeInt(r18);
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L38:
            r7.writeString(DESCRIPTOR);
            return true;
        }

        public static boolean setDefaultImpl(IKvSyncInterface impl) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (impl == null) goto L7;
            Proxy.sDefaultImpl = impl;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IKvSyncInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void addSyncStateListener(String pkgName, ISyncStateListener listener) throws RemoteException;

    boolean getSwitchStatus(String pkgName) throws RemoteException;

    boolean getSyncSettingsStatus(String pkgName) throws RemoteException;

    int getSyncStatus(String pkgName) throws RemoteException;

    Bundle getUsedSpaceDetail(String pkgName) throws RemoteException;

    int init(String pkgName) throws RemoteException;

    void removeSyncStateListener(String pkgName, ISyncStateListener listener) throws RemoteException;

    int setDeleted(String pkgName, String tableName) throws RemoteException;

    int setInserted(String pkgName, long dataId, String tableName) throws RemoteException;

    boolean setSwitchStatus(String pkgName, boolean enabled) throws RemoteException;

    int setUpdated(String pkgName, long dataId, String tableName) throws RemoteException;

    int triggerSync(String pkgName, String syncSceneDesc) throws RemoteException;
}
