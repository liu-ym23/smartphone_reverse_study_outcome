package android.gsi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IGsiService extends IInterface {
    public static final String DESCRIPTOR = "android.gsi.IGsiService";
    public static final int INSTALL_ERROR_FILE_SYSTEM_CLUTTERED = 3;
    public static final int INSTALL_ERROR_GENERIC = 1;
    public static final int INSTALL_ERROR_NO_SPACE = 2;
    public static final int INSTALL_OK = 0;
    public static final int STATUS_COMPLETE = 2;
    public static final int STATUS_NO_OPERATION = 0;
    public static final int STATUS_WORKING = 1;

    public static class Default implements IGsiService {
        public Default() {
        }

        @Override // android.gsi.IGsiService
        public boolean commitGsiChunkFromStream(ParcelFileDescriptor stream, long bytes) throws RemoteException {
            return false;
        }

        @Override // android.gsi.IGsiService
        public GsiProgress getInstallProgress() throws RemoteException {
            return null;
        }

        @Override // android.gsi.IGsiService
        public boolean setGsiAshmem(ParcelFileDescriptor stream, long size) throws RemoteException {
            return false;
        }

        @Override // android.gsi.IGsiService
        public boolean commitGsiChunkFromAshmem(long bytes) throws RemoteException {
            return false;
        }

        @Override // android.gsi.IGsiService
        public int enableGsi(boolean oneShot, String dsuSlot) throws RemoteException {
            return 0;
        }

        @Override // android.gsi.IGsiService
        public void enableGsiAsync(boolean oneShot, String dsuSlot, IGsiServiceCallback result) throws RemoteException {
        }

        @Override // android.gsi.IGsiService
        public boolean isGsiEnabled() throws RemoteException {
            return false;
        }

        @Override // android.gsi.IGsiService
        public boolean cancelGsiInstall() throws RemoteException {
            return false;
        }

        @Override // android.gsi.IGsiService
        public boolean isGsiInstallInProgress() throws RemoteException {
            return false;
        }

        @Override // android.gsi.IGsiService
        public boolean removeGsi() throws RemoteException {
            return false;
        }

        @Override // android.gsi.IGsiService
        public void removeGsiAsync(IGsiServiceCallback result) throws RemoteException {
        }

        @Override // android.gsi.IGsiService
        public boolean disableGsi() throws RemoteException {
            return false;
        }

        @Override // android.gsi.IGsiService
        public boolean isGsiInstalled() throws RemoteException {
            return false;
        }

        @Override // android.gsi.IGsiService
        public boolean isGsiRunning() throws RemoteException {
            return false;
        }

        @Override // android.gsi.IGsiService
        public String getActiveDsuSlot() throws RemoteException {
            return null;
        }

        @Override // android.gsi.IGsiService
        public String getInstalledGsiImageDir() throws RemoteException {
            return null;
        }

        @Override // android.gsi.IGsiService
        public List<String> getInstalledDsuSlots() throws RemoteException {
            return null;
        }

        @Override // android.gsi.IGsiService
        public int openInstall(String installDir) throws RemoteException {
            return 0;
        }

        @Override // android.gsi.IGsiService
        public int closeInstall() throws RemoteException {
            return 0;
        }

        @Override // android.gsi.IGsiService
        public int createPartition(String name, long size, boolean readOnly) throws RemoteException {
            return 0;
        }

        @Override // android.gsi.IGsiService
        public int closePartition() throws RemoteException {
            return 0;
        }

        @Override // android.gsi.IGsiService
        public int zeroPartition(String name) throws RemoteException {
            return 0;
        }

        @Override // android.gsi.IGsiService
        public IImageService openImageService(String prefix) throws RemoteException {
            return null;
        }

        @Override // android.gsi.IGsiService
        public String dumpDeviceMapperDevices() throws RemoteException {
            return null;
        }

        @Override // android.gsi.IGsiService
        public int getAvbPublicKey(AvbPublicKey dst) throws RemoteException {
            return 0;
        }

        @Override // android.gsi.IGsiService
        public long suggestScratchSize() throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IGsiService {
        static final int TRANSACTION_cancelGsiInstall = 8;
        static final int TRANSACTION_closeInstall = 19;
        static final int TRANSACTION_closePartition = 21;
        static final int TRANSACTION_commitGsiChunkFromAshmem = 4;
        static final int TRANSACTION_commitGsiChunkFromStream = 1;
        static final int TRANSACTION_createPartition = 20;
        static final int TRANSACTION_disableGsi = 12;
        static final int TRANSACTION_dumpDeviceMapperDevices = 24;
        static final int TRANSACTION_enableGsi = 5;
        static final int TRANSACTION_enableGsiAsync = 6;
        static final int TRANSACTION_getActiveDsuSlot = 15;
        static final int TRANSACTION_getAvbPublicKey = 25;
        static final int TRANSACTION_getInstallProgress = 2;
        static final int TRANSACTION_getInstalledDsuSlots = 17;
        static final int TRANSACTION_getInstalledGsiImageDir = 16;
        static final int TRANSACTION_isGsiEnabled = 7;
        static final int TRANSACTION_isGsiInstallInProgress = 9;
        static final int TRANSACTION_isGsiInstalled = 13;
        static final int TRANSACTION_isGsiRunning = 14;
        static final int TRANSACTION_openImageService = 23;
        static final int TRANSACTION_openInstall = 18;
        static final int TRANSACTION_removeGsi = 10;
        static final int TRANSACTION_removeGsiAsync = 11;
        static final int TRANSACTION_setGsiAshmem = 3;
        static final int TRANSACTION_suggestScratchSize = 26;
        static final int TRANSACTION_zeroPartition = 22;

        private static class Proxy implements IGsiService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IGsiService.DESCRIPTOR;
            }

            @Override // android.gsi.IGsiService
            public boolean commitGsiChunkFromStream(ParcelFileDescriptor stream, long bytes) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeTypedObject(stream, 0);     // Catch: Throwable -> L6
                _data.writeLong(bytes);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public GsiProgress getInstallProgress() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                GsiProgress _result = (GsiProgress) _reply.readTypedObject(GsiProgress.CREATOR);     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public boolean setGsiAshmem(ParcelFileDescriptor stream, long size) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeTypedObject(stream, 0);     // Catch: Throwable -> L6
                _data.writeLong(size);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public boolean commitGsiChunkFromAshmem(long bytes) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeLong(bytes);     // Catch: Throwable -> L6
                this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public int enableGsi(boolean oneShot, String dsuSlot) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeBoolean(oneShot);     // Catch: Throwable -> L6
                _data.writeString(dsuSlot);     // Catch: Throwable -> L6
                this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public void enableGsiAsync(boolean oneShot, String dsuSlot, IGsiServiceCallback result) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeBoolean(oneShot);     // Catch: Throwable -> L6
                _data.writeString(dsuSlot);     // Catch: Throwable -> L6
                _data.writeStrongInterface(result);     // Catch: Throwable -> L6
                this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public boolean isGsiEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public boolean cancelGsiInstall() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public boolean isGsiInstallInProgress() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public boolean removeGsi() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public void removeGsiAsync(IGsiServiceCallback result) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongInterface(result);     // Catch: Throwable -> L6
                this.mRemote.transact(11, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public boolean disableGsi() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public boolean isGsiInstalled() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(13, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public boolean isGsiRunning() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(14, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public String getActiveDsuSlot() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(15, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                String _result = _reply.readString();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public String getInstalledGsiImageDir() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(16, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                String _result = _reply.readString();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public List<String> getInstalledDsuSlots() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(17, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                List<String> _result = _reply.createStringArrayList();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public int openInstall(String installDir) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(installDir);     // Catch: Throwable -> L6
                this.mRemote.transact(18, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public int closeInstall() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(19, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public int createPartition(String name, long size, boolean readOnly) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
                _data.writeLong(size);     // Catch: Throwable -> L6
                _data.writeBoolean(readOnly);     // Catch: Throwable -> L6
                this.mRemote.transact(20, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public int closePartition() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(21, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public int zeroPartition(String name) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(name);     // Catch: Throwable -> L6
                this.mRemote.transact(22, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                int _result = _reply.readInt();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public IImageService openImageService(String prefix) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeString(prefix);     // Catch: Throwable -> L6
                this.mRemote.transact(23, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                IImageService _result = IImageService.Stub.asInterface(_reply.readStrongBinder());     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public String dumpDeviceMapperDevices() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(24, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                String _result = _reply.readString();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public int getAvbPublicKey(AvbPublicKey dst) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(25, _data, _reply, 0);     // Catch: Throwable -> L7
                _reply.readException();     // Catch: Throwable -> L7
                int _result = _reply.readInt();     // Catch: Throwable -> L7
                if (_reply.readInt() == 0) goto L9;
                dst.readFromParcel(_reply);     // Catch: Throwable -> L7
            L9:
                _reply.recycle();
                _data.recycle();
                return _result;
            L7:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.gsi.IGsiService
            public long suggestScratchSize() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IGsiService.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(26, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                long _result = _reply.readLong();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return _result;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IGsiService.DESCRIPTOR);
        }

        public static IGsiService asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IGsiService.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IGsiService) == false) goto L12;
            return (IGsiService) iin;
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
            data.enforceInterface(IGsiService.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IGsiService.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L37;
                case 4: goto L36;
                case 5: goto L35;
                case 6: goto L34;
                case 7: goto L33;
                case 8: goto L32;
                case 9: goto L31;
                case 10: goto L30;
                case 11: goto L29;
                case 12: goto L28;
                case 13: goto L27;
                case 14: goto L26;
                case 15: goto L25;
                case 16: goto L24;
                case 17: goto L23;
                case 18: goto L22;
                case 19: goto L21;
                case 20: goto L20;
                case 21: goto L19;
                case 22: goto L18;
                case 23: goto L17;
                case 24: goto L16;
                case 25: goto L15;
                case 26: goto L14;
                default: goto L13;
            };
        L14:
            long _result = suggestScratchSize();
            reply.writeNoException();
            reply.writeLong(_result);
        L40:
            return true;
        L15:
            AvbPublicKey _arg0 = new AvbPublicKey();
            data.enforceNoDataAvail();
            int _result2 = getAvbPublicKey(_arg0);
            reply.writeNoException();
            reply.writeInt(_result2);
            reply.writeTypedObject(_arg0, 1);
            goto L40
        L16:
            String _result3 = dumpDeviceMapperDevices();
            reply.writeNoException();
            reply.writeString(_result3);
            goto L40
        L17:
            String _arg1 = data.readString();
            data.enforceNoDataAvail();
            IImageService _result4 = openImageService(_arg1);
            reply.writeNoException();
            reply.writeStrongInterface(_result4);
            goto L40
        L18:
            String _arg2 = data.readString();
            data.enforceNoDataAvail();
            int _result5 = zeroPartition(_arg2);
            reply.writeNoException();
            reply.writeInt(_result5);
            goto L40
        L19:
            int _result6 = closePartition();
            reply.writeNoException();
            reply.writeInt(_result6);
            goto L40
        L20:
            String _arg3 = data.readString();
            long _arg4 = data.readLong();
            boolean _arg5 = data.readBoolean();
            data.enforceNoDataAvail();
            int _result7 = createPartition(_arg3, _arg4, _arg5);
            reply.writeNoException();
            reply.writeInt(_result7);
            goto L40
        L21:
            int _result8 = closeInstall();
            reply.writeNoException();
            reply.writeInt(_result8);
            goto L40
        L22:
            String _arg6 = data.readString();
            data.enforceNoDataAvail();
            int _result9 = openInstall(_arg6);
            reply.writeNoException();
            reply.writeInt(_result9);
            goto L40
        L23:
            List<String> _result10 = getInstalledDsuSlots();
            reply.writeNoException();
            reply.writeStringList(_result10);
            goto L40
        L24:
            String _result11 = getInstalledGsiImageDir();
            reply.writeNoException();
            reply.writeString(_result11);
            goto L40
        L25:
            String _result12 = getActiveDsuSlot();
            reply.writeNoException();
            reply.writeString(_result12);
            goto L40
        L26:
            boolean _result13 = isGsiRunning();
            reply.writeNoException();
            reply.writeBoolean(_result13);
            goto L40
        L27:
            boolean _result14 = isGsiInstalled();
            reply.writeNoException();
            reply.writeBoolean(_result14);
            goto L40
        L28:
            boolean _result15 = disableGsi();
            reply.writeNoException();
            reply.writeBoolean(_result15);
            goto L40
        L29:
            IGsiServiceCallback _arg7 = IGsiServiceCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            removeGsiAsync(_arg7);
            goto L40
        L30:
            boolean _result16 = removeGsi();
            reply.writeNoException();
            reply.writeBoolean(_result16);
            goto L40
        L31:
            boolean _result17 = isGsiInstallInProgress();
            reply.writeNoException();
            reply.writeBoolean(_result17);
            goto L40
        L32:
            boolean _result18 = cancelGsiInstall();
            reply.writeNoException();
            reply.writeBoolean(_result18);
            goto L40
        L33:
            boolean _result19 = isGsiEnabled();
            reply.writeNoException();
            reply.writeBoolean(_result19);
            goto L40
        L34:
            boolean _arg8 = data.readBoolean();
            String _arg9 = data.readString();
            IGsiServiceCallback _arg10 = IGsiServiceCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            enableGsiAsync(_arg8, _arg9, _arg10);
            goto L40
        L35:
            boolean _arg11 = data.readBoolean();
            String _arg12 = data.readString();
            data.enforceNoDataAvail();
            int _result20 = enableGsi(_arg11, _arg12);
            reply.writeNoException();
            reply.writeInt(_result20);
            goto L40
        L36:
            long _arg13 = data.readLong();
            data.enforceNoDataAvail();
            boolean _result21 = commitGsiChunkFromAshmem(_arg13);
            reply.writeNoException();
            reply.writeBoolean(_result21);
            goto L40
        L37:
            ParcelFileDescriptor _arg14 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
            long _arg15 = data.readLong();
            data.enforceNoDataAvail();
            boolean _result22 = setGsiAshmem(_arg14, _arg15);
            reply.writeNoException();
            reply.writeBoolean(_result22);
            goto L40
        L38:
            GsiProgress _result23 = getInstallProgress();
            reply.writeNoException();
            reply.writeTypedObject(_result23, 1);
            goto L40
        L39:
            ParcelFileDescriptor _arg16 = (ParcelFileDescriptor) data.readTypedObject(ParcelFileDescriptor.CREATOR);
            long _arg17 = data.readLong();
            data.enforceNoDataAvail();
            boolean _result24 = commitGsiChunkFromStream(_arg16, _arg17);
            reply.writeNoException();
            reply.writeBoolean(_result24);
            goto L40
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    boolean cancelGsiInstall() throws RemoteException;

    int closeInstall() throws RemoteException;

    int closePartition() throws RemoteException;

    boolean commitGsiChunkFromAshmem(long r1) throws RemoteException;

    boolean commitGsiChunkFromStream(ParcelFileDescriptor r1, long r2) throws RemoteException;

    int createPartition(String r1, long r2, boolean r4) throws RemoteException;

    boolean disableGsi() throws RemoteException;

    String dumpDeviceMapperDevices() throws RemoteException;

    int enableGsi(boolean r1, String r2) throws RemoteException;

    void enableGsiAsync(boolean r1, String r2, IGsiServiceCallback r3) throws RemoteException;

    String getActiveDsuSlot() throws RemoteException;

    int getAvbPublicKey(AvbPublicKey r1) throws RemoteException;

    GsiProgress getInstallProgress() throws RemoteException;

    List<String> getInstalledDsuSlots() throws RemoteException;

    String getInstalledGsiImageDir() throws RemoteException;

    boolean isGsiEnabled() throws RemoteException;

    boolean isGsiInstallInProgress() throws RemoteException;

    boolean isGsiInstalled() throws RemoteException;

    boolean isGsiRunning() throws RemoteException;

    IImageService openImageService(String r1) throws RemoteException;

    int openInstall(String r1) throws RemoteException;

    boolean removeGsi() throws RemoteException;

    void removeGsiAsync(IGsiServiceCallback r1) throws RemoteException;

    boolean setGsiAshmem(ParcelFileDescriptor r1, long r2) throws RemoteException;

    long suggestScratchSize() throws RemoteException;

    int zeroPartition(String r1) throws RemoteException;
}
