package android.hardware.fingerprint;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSFingerprintService extends IInterface {
    public static final String DESCRIPTOR = "android.hardware.fingerprint.IStepOSFingerprintService";

    long getLockoutTimestamp(int i, int i2) throws RemoteException;

    boolean hasClient() throws RemoteException;

    public static class Default implements IStepOSFingerprintService {
        @Override // android.hardware.fingerprint.IStepOSFingerprintService
        public long getLockoutTimestamp(int userId, int sensorId) throws RemoteException {
            return 0L;
        }

        @Override // android.hardware.fingerprint.IStepOSFingerprintService
        public boolean hasClient() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSFingerprintService {
        static final int TRANSACTION_getLockoutTimestamp = 1;
        static final int TRANSACTION_hasClient = 2;

        public Stub() {
            attachInterface(this, IStepOSFingerprintService.DESCRIPTOR);
        }

        public static IStepOSFingerprintService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSFingerprintService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSFingerprintService)) {
                return (IStepOSFingerprintService) iin;
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
                    return "getLockoutTimestamp";
                case 2:
                    return "hasClient";
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
                data.enforceInterface(IStepOSFingerprintService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSFingerprintService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    long _result = getLockoutTimestamp(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeLong(_result);
                    return true;
                case 2:
                    boolean _result2 = hasClient();
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSFingerprintService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSFingerprintService.DESCRIPTOR;
            }

            @Override // android.hardware.fingerprint.IStepOSFingerprintService
            public long getLockoutTimestamp(int userId, int sensorId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSFingerprintService.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeInt(sensorId);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.fingerprint.IStepOSFingerprintService
            public boolean hasClient() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSFingerprintService.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
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
