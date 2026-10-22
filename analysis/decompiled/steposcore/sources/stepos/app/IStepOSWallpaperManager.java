package stepos.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSWallpaperManager extends IInterface {
    public static final String DESCRIPTOR = "stepos.app.IStepOSWallpaperManager";

    ParcelFileDescriptor getStepOSNightModeLauncherWallpaperFD() throws RemoteException;

    ParcelFileDescriptor getStepOSNightModeLockWallpaperFD() throws RemoteException;

    int getStepOSNightModeWallpaperStatus() throws RemoteException;

    void onStepOSLockWallpaperReady() throws RemoteException;

    public static class Default implements IStepOSWallpaperManager {
        @Override // stepos.app.IStepOSWallpaperManager
        public ParcelFileDescriptor getStepOSNightModeLauncherWallpaperFD() throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWallpaperManager
        public ParcelFileDescriptor getStepOSNightModeLockWallpaperFD() throws RemoteException {
            return null;
        }

        @Override // stepos.app.IStepOSWallpaperManager
        public int getStepOSNightModeWallpaperStatus() throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSWallpaperManager
        public void onStepOSLockWallpaperReady() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSWallpaperManager {
        static final int TRANSACTION_getStepOSNightModeLauncherWallpaperFD = 1;
        static final int TRANSACTION_getStepOSNightModeLockWallpaperFD = 2;
        static final int TRANSACTION_getStepOSNightModeWallpaperStatus = 3;
        static final int TRANSACTION_onStepOSLockWallpaperReady = 4;

        public Stub() {
            attachInterface(this, IStepOSWallpaperManager.DESCRIPTOR);
        }

        public static IStepOSWallpaperManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSWallpaperManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSWallpaperManager)) {
                return (IStepOSWallpaperManager) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "getStepOSNightModeLauncherWallpaperFD";
                case 2:
                    return "getStepOSNightModeLockWallpaperFD";
                case 3:
                    return "getStepOSNightModeWallpaperStatus";
                case 4:
                    return "onStepOSLockWallpaperReady";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IStepOSWallpaperManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSWallpaperManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    ParcelFileDescriptor _result = getStepOSNightModeLauncherWallpaperFD();
                    reply.writeNoException();
                    reply.writeTypedObject(_result, 1);
                    return true;
                case 2:
                    ParcelFileDescriptor _result2 = getStepOSNightModeLockWallpaperFD();
                    reply.writeNoException();
                    reply.writeTypedObject(_result2, 1);
                    return true;
                case 3:
                    int _result3 = getStepOSNightModeWallpaperStatus();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 4:
                    onStepOSLockWallpaperReady();
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSWallpaperManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSWallpaperManager.DESCRIPTOR;
            }

            @Override // stepos.app.IStepOSWallpaperManager
            public ParcelFileDescriptor getStepOSNightModeLauncherWallpaperFD() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWallpaperManager.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    ParcelFileDescriptor _result = (ParcelFileDescriptor) _reply.readTypedObject(ParcelFileDescriptor.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWallpaperManager
            public ParcelFileDescriptor getStepOSNightModeLockWallpaperFD() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWallpaperManager.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    ParcelFileDescriptor _result = (ParcelFileDescriptor) _reply.readTypedObject(ParcelFileDescriptor.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWallpaperManager
            public int getStepOSNightModeWallpaperStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWallpaperManager.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSWallpaperManager
            public void onStepOSLockWallpaperReady() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSWallpaperManager.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 3;
        }
    }
}
