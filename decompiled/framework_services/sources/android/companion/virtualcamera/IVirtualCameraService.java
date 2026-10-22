package android.companion.virtualcamera;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IVirtualCameraService extends IInterface {
    public static final String DESCRIPTOR = "android.companion.virtualcamera.IVirtualCameraService";

    public static class Default implements IVirtualCameraService {
        public Default() {
        }

        @Override // android.companion.virtualcamera.IVirtualCameraService
        public boolean registerCamera(IBinder token, VirtualCameraConfiguration configuration, int deviceId) throws RemoteException {
            return false;
        }

        @Override // android.companion.virtualcamera.IVirtualCameraService
        public void unregisterCamera(IBinder token) throws RemoteException {
        }

        @Override // android.companion.virtualcamera.IVirtualCameraService
        public String getCameraId(IBinder token) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVirtualCameraService {
        static final int TRANSACTION_getCameraId = 3;
        static final int TRANSACTION_registerCamera = 1;
        static final int TRANSACTION_unregisterCamera = 2;

        private static class Proxy implements IVirtualCameraService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVirtualCameraService.DESCRIPTOR;
            }

            @Override // android.companion.virtualcamera.IVirtualCameraService
            public boolean registerCamera(IBinder token, VirtualCameraConfiguration configuration, int deviceId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IVirtualCameraService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongBinder(token);     // Catch: Throwable -> L6
                _data.writeTypedObject(configuration, 0);     // Catch: Throwable -> L6
                _data.writeInt(deviceId);     // Catch: Throwable -> L6
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

            @Override // android.companion.virtualcamera.IVirtualCameraService
            public void unregisterCamera(IBinder token) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IVirtualCameraService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongBinder(token);     // Catch: Throwable -> L6
                this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L6
                _reply.readException();     // Catch: Throwable -> L6
                _reply.recycle();
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.companion.virtualcamera.IVirtualCameraService
            public String getCameraId(IBinder token) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IVirtualCameraService.DESCRIPTOR);     // Catch: Throwable -> L6
                _data.writeStrongBinder(token);     // Catch: Throwable -> L6
                this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L6
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
        }

        public Stub() {
            attachInterface(this, IVirtualCameraService.DESCRIPTOR);
        }

        public static IVirtualCameraService asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IVirtualCameraService.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IVirtualCameraService) == false) goto L12;
            return (IVirtualCameraService) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L9;
                case 2: goto L7;
                case 3: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "getCameraId";
        L7:
            return "unregisterCamera";
        L9:
            return "registerCamera";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(IVirtualCameraService.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IVirtualCameraService.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                default: goto L13;
            };
        L14:
            IBinder _arg0 = data.readStrongBinder();
            data.enforceNoDataAvail();
            String _result = getCameraId(_arg0);
            reply.writeNoException();
            reply.writeString(_result);
        L17:
            return true;
        L15:
            IBinder _arg1 = data.readStrongBinder();
            data.enforceNoDataAvail();
            unregisterCamera(_arg1);
            reply.writeNoException();
            goto L17
        L16:
            IBinder _arg2 = data.readStrongBinder();
            VirtualCameraConfiguration _arg3 = (VirtualCameraConfiguration) data.readTypedObject(VirtualCameraConfiguration.CREATOR);
            int _arg4 = data.readInt();
            data.enforceNoDataAvail();
            boolean _result2 = registerCamera(_arg2, _arg3, _arg4);
            reply.writeNoException();
            reply.writeBoolean(_result2);
            goto L17
        L13:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return 2;
        }
    }

    String getCameraId(IBinder r1) throws RemoteException;

    boolean registerCamera(IBinder r1, VirtualCameraConfiguration r2, int r3) throws RemoteException;

    void unregisterCamera(IBinder r1) throws RemoteException;
}
