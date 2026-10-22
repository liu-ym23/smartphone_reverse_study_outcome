package android.os;

/* JADX INFO: loaded from: classes.dex */
public interface IVoldListener extends IInterface {

    public static class Default implements IVoldListener {
        public Default() {
        }

        @Override // android.os.IVoldListener
        public void onDiskCreated(String diskId, int flags) throws RemoteException {
        }

        @Override // android.os.IVoldListener
        public void onDiskScanned(String diskId) throws RemoteException {
        }

        @Override // android.os.IVoldListener
        public void onDiskMetadataChanged(String diskId, long sizeBytes, String label, String sysPath) throws RemoteException {
        }

        @Override // android.os.IVoldListener
        public void onDiskDestroyed(String diskId) throws RemoteException {
        }

        @Override // android.os.IVoldListener
        public void onVolumeCreated(String volId, int type, String diskId, String partGuid, int userId) throws RemoteException {
        }

        @Override // android.os.IVoldListener
        public void onVolumeStateChanged(String volId, int state, int userId) throws RemoteException {
        }

        @Override // android.os.IVoldListener
        public void onVolumeMetadataChanged(String volId, String fsType, String fsUuid, String fsLabel) throws RemoteException {
        }

        @Override // android.os.IVoldListener
        public void onVolumePathChanged(String volId, String path) throws RemoteException {
        }

        @Override // android.os.IVoldListener
        public void onVolumeInternalPathChanged(String volId, String internalPath) throws RemoteException {
        }

        @Override // android.os.IVoldListener
        public void onVolumeDestroyed(String volId) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoldListener {
        public static final String DESCRIPTOR = "android.os.IVoldListener";
        static final int TRANSACTION_onDiskCreated = 1;
        static final int TRANSACTION_onDiskDestroyed = 4;
        static final int TRANSACTION_onDiskMetadataChanged = 3;
        static final int TRANSACTION_onDiskScanned = 2;
        static final int TRANSACTION_onVolumeCreated = 5;
        static final int TRANSACTION_onVolumeDestroyed = 10;
        static final int TRANSACTION_onVolumeInternalPathChanged = 9;
        static final int TRANSACTION_onVolumeMetadataChanged = 7;
        static final int TRANSACTION_onVolumePathChanged = 8;
        static final int TRANSACTION_onVolumeStateChanged = 6;

        private static class Proxy implements IVoldListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IVoldListener
            public void onDiskCreated(String diskId, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(diskId);     // Catch: Throwable -> L6
                _data.writeInt(flags);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVoldListener
            public void onDiskScanned(String diskId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(diskId);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVoldListener
            public void onDiskMetadataChanged(String diskId, long sizeBytes, String label, String sysPath) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(diskId);     // Catch: Throwable -> L6
                _data.writeLong(sizeBytes);     // Catch: Throwable -> L6
                _data.writeString(label);     // Catch: Throwable -> L6
                _data.writeString(sysPath);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVoldListener
            public void onDiskDestroyed(String diskId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(diskId);     // Catch: Throwable -> L6
                this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVoldListener
            public void onVolumeCreated(String volId, int type, String diskId, String partGuid, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                _data.writeInt(type);     // Catch: Throwable -> L6
                _data.writeString(diskId);     // Catch: Throwable -> L6
                _data.writeString(partGuid);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVoldListener
            public void onVolumeStateChanged(String volId, int state, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                _data.writeInt(state);     // Catch: Throwable -> L6
                _data.writeInt(userId);     // Catch: Throwable -> L6
                this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVoldListener
            public void onVolumeMetadataChanged(String volId, String fsType, String fsUuid, String fsLabel) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                _data.writeString(fsType);     // Catch: Throwable -> L6
                _data.writeString(fsUuid);     // Catch: Throwable -> L6
                _data.writeString(fsLabel);     // Catch: Throwable -> L6
                this.mRemote.transact(7, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVoldListener
            public void onVolumePathChanged(String volId, String path) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                _data.writeString(path);     // Catch: Throwable -> L6
                this.mRemote.transact(8, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVoldListener
            public void onVolumeInternalPathChanged(String volId, String internalPath) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                _data.writeString(internalPath);     // Catch: Throwable -> L6
                this.mRemote.transact(9, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.os.IVoldListener
            public void onVolumeDestroyed(String volId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(volId);     // Catch: Throwable -> L6
                this.mRemote.transact(10, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVoldListener asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IVoldListener) == false) goto L12;
            return (IVoldListener) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                default: goto L13;
            };
        L14:
            String _arg0 = data.readString();
            data.enforceNoDataAvail();
            onVolumeDestroyed(_arg0);
        L24:
            return true;
        L15:
            String _arg1 = data.readString();
            String _arg2 = data.readString();
            data.enforceNoDataAvail();
            onVolumeInternalPathChanged(_arg1, _arg2);
            goto L24
        L16:
            String _arg3 = data.readString();
            String _arg4 = data.readString();
            data.enforceNoDataAvail();
            onVolumePathChanged(_arg3, _arg4);
            goto L24
        L17:
            String _arg5 = data.readString();
            String _arg6 = data.readString();
            String _arg7 = data.readString();
            String _arg8 = data.readString();
            data.enforceNoDataAvail();
            onVolumeMetadataChanged(_arg5, _arg6, _arg7, _arg8);
            goto L24
        L18:
            String _arg9 = data.readString();
            int _arg10 = data.readInt();
            int _arg11 = data.readInt();
            data.enforceNoDataAvail();
            onVolumeStateChanged(_arg9, _arg10, _arg11);
            goto L24
        L19:
            String _arg12 = data.readString();
            int _arg13 = data.readInt();
            String _arg14 = data.readString();
            String _arg15 = data.readString();
            int _arg16 = data.readInt();
            data.enforceNoDataAvail();
            onVolumeCreated(_arg12, _arg13, _arg14, _arg15, _arg16);
            goto L24
        L20:
            String _arg17 = data.readString();
            data.enforceNoDataAvail();
            onDiskDestroyed(_arg17);
            goto L24
        L21:
            String _arg18 = data.readString();
            long _arg19 = data.readLong();
            String _arg20 = data.readString();
            String _arg21 = data.readString();
            data.enforceNoDataAvail();
            onDiskMetadataChanged(_arg18, _arg19, _arg20, _arg21);
            goto L24
        L22:
            String _arg22 = data.readString();
            data.enforceNoDataAvail();
            onDiskScanned(_arg22);
            goto L24
        L23:
            String _arg23 = data.readString();
            int _arg24 = data.readInt();
            data.enforceNoDataAvail();
            onDiskCreated(_arg23, _arg24);
            goto L24
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void onDiskCreated(String r1, int r2) throws RemoteException;

    void onDiskDestroyed(String r1) throws RemoteException;

    void onDiskMetadataChanged(String r1, long r2, String r4, String r5) throws RemoteException;

    void onDiskScanned(String r1) throws RemoteException;

    void onVolumeCreated(String r1, int r2, String r3, String r4, int r5) throws RemoteException;

    void onVolumeDestroyed(String r1) throws RemoteException;

    void onVolumeInternalPathChanged(String r1, String r2) throws RemoteException;

    void onVolumeMetadataChanged(String r1, String r2, String r3, String r4) throws RemoteException;

    void onVolumePathChanged(String r1, String r2) throws RemoteException;

    void onVolumeStateChanged(String r1, int r2, int r3) throws RemoteException;
}
