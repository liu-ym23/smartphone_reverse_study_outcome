package android.hardware.display;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSDeviceControlService extends IInterface {
    public static final String DESCRIPTOR = "android.hardware.display.IStepOSDeviceControlService";

    boolean isForceKeptAwake() throws RemoteException;

    void setPowerModeForCast(int i) throws RemoteException;

    public static class Default implements IStepOSDeviceControlService {
        @Override // android.hardware.display.IStepOSDeviceControlService
        public boolean isForceKeptAwake() throws RemoteException {
            return false;
        }

        @Override // android.hardware.display.IStepOSDeviceControlService
        public void setPowerModeForCast(int displayId) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSDeviceControlService {
        static final int TRANSACTION_isForceKeptAwake = 1;
        static final int TRANSACTION_setPowerModeForCast = 2;

        public Stub() {
            attachInterface(this, IStepOSDeviceControlService.DESCRIPTOR);
        }

        public static IStepOSDeviceControlService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSDeviceControlService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSDeviceControlService)) {
                return (IStepOSDeviceControlService) iin;
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
                    return "isForceKeptAwake";
                case 2:
                    return "setPowerModeForCast";
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
                data.enforceInterface(IStepOSDeviceControlService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSDeviceControlService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    boolean _result = isForceKeptAwake();
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 2:
                    int _arg0 = data.readInt();
                    setPowerModeForCast(_arg0);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSDeviceControlService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSDeviceControlService.DESCRIPTOR;
            }

            @Override // android.hardware.display.IStepOSDeviceControlService
            public boolean isForceKeptAwake() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDeviceControlService.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDeviceControlService
            public void setPowerModeForCast(int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDeviceControlService.DESCRIPTOR);
                    _data.writeInt(displayId);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 1;
        }
    }
}
